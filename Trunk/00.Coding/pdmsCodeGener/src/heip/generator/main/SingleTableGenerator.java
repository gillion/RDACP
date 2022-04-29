package heip.generator.main;

import heip.generator.entity.EntityClazz;
import heip.generator.entity.EntityColumn;
import heip.generator.entity.EntityTable;
import heip.generator.generer.ActionGenerator;
import heip.generator.generer.EntityGenerator;
import heip.generator.generer.JSPGenerator;
import heip.generator.generer.ServiceGenerator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import cn.org.rapid_framework.generator.provider.java.model.JavaClass;

/**
 * 单表 代码生成器
 *1)修改模块moduleName
 *2）
 *a)生成表的实体对象
 * 注释main方法里里的gg.generatorClazzAndJSP(),启用gg.generatorTable()
 * 修改generatorTable 里的变量，参考方法说明
 *b)生成 service,action,jsp(必须先执行生成实体，并已经拷贝到依赖的开发工程里)
 * 注释main方法里里的gg.generatorTable(),启用gg.generatorClazzAndJSP()
 * 修改 generatorClazzAndJSP 里的变量，参考方法说明
 * 
 * @author HSWHM
 * Modify By:<br/>
 * Modify Date:2012-7-20<br/>
 * Remark:修改说明<br/>
 */
public class SingleTableGenerator extends BaseAbstractCodeGenerator{
	
	static String moduleName;//模块名称
	static String basepackage;//基础包
	static String root; //工程根目录
	static String output; //临时输出目录
	static String javapath; //java文件目录
	
	public static void main(String[] args){	
		try {
			runMakeCode(1);
			//runMakeCode(2);
			open();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//
	
	/**
	 * TODO 生成代码
	 * 
	 * heip.generator.main
	 * SingleTableGenerator
	 * 
	 * @param step 1:生成持久化类;2:生成程序代码并集成
	 * @throws Exception
	 * @since
	 * @author 中软海晟程序员.
	 * @time 2012-11-14下午09:06:06
	 * @version 1.0
	 * <pre>
	 * 
	 * </pre>
	 */
	public static void runMakeCode(int step) throws Exception {		
		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		basepackage = props_CorpTotal.getProperty("basepackage"); 
		moduleName = props_CorpTotal.getProperty("moduleName"); 
		root = props_CorpTotal.getProperty("root"); 
		output = props_CorpTotal.getProperty("output"); 
		javapath = props_CorpTotal.getProperty("javapath"); 
		String tablename1=props_CorpTotal.getProperty("tablename1"); 
		String tabletitle1=props_CorpTotal.getProperty("tabletitle1");
		String tableid1=props_CorpTotal.getProperty("tableid1"); 	 	
		String isDepoly=props_CorpTotal.getProperty("isDeploy"); 	
		String inputfields1=props_CorpTotal.getProperty("inputfields1"); 	
		String gridfields1=props_CorpTotal.getProperty("gridfields1"); 	
		
		// 创建集成目录
		createDir();	
        // 循环逻辑开始		
		String tb[] = tablename1.split(";");
		String tbtitle[] = tabletitle1.split(";");
		for(int k=0;k<tb.length;k++){
			String tablename = tb[k];
			String tabletitle= tbtitle[k];
			//清空临时输出目录
	        clearDir(output);
			tablename = tablename.toLowerCase();
			if (step==1){
				// 生成持久化类
				createPoVo(tablename);
				compilePoVo(tablename);
				Thread.sleep(2000);//等待5秒 
			//} else if (step==2){
				// 生成java代码及配置文件
			//	createJava(tablename,tabletitle,tableid1,inputfields1,gridfields1);
				// 集成代码
				if (isDepoly.equals("1"))
				  Deploy(tablename);
			}
		}
		// 循环逻辑结束
	}
	/**
	 * TODO 创建集成目录
	 * 
	 * heip.generator.main
	 * SingleTableGenerator
	 * 
	 * @throws Exception
	 * @since
	 * @author 中软海晟程序员.
	 * @time 2012-11-14下午03:22:00
	 * @version 1.0
	 * <pre>
	 * 
	 * </pre>
	 */
	public static void createDir() throws Exception {		
        (new File(javapath+"data/bo/"+moduleName)).mkdirs();
        (new File(javapath+"data/vo/"+moduleName)).mkdirs();
        (new File(javapath+"action/"+moduleName)).mkdirs();
        (new File(javapath+"service/"+moduleName)).mkdirs();
        (new File(javapath+"service/impl/"+moduleName)).mkdirs();
        (new File(root +"WebRoot/"+moduleName)).mkdirs();
	}
	
	/**
	 * TODO 生成持久化类
	 * 
	 * heip.generator.main
	 * SingleTableGenerator
	 * 
	 * @param tablename 表名
	 * @throws Exception
	 * @since
	 * @author 中软海晟程序员.
	 * @time 2012-11-14下午03:25:34
	 * @version 1.0
	 * <pre>
	 * 
	 * </pre>
	 */
	public static void createPoVo(String tablename) throws Exception {
		String boname=getboclassbytable(tablename);
        SingleTableGenerator gg = new SingleTableGenerator();    
		gg.generatorTable(tablename);
        File file = new File(output+boname+".java");
        copyFile(file, new File(javapath +"data/bo/"+moduleName+"/" + file.getName()));
                
        file = new File(output+boname+"VO"+".java");
        copyFile(file, new File(javapath +"data/vo/"+moduleName+"/" + file.getName()));
	}
	
	public static void compilePoVo(String tablename) throws Exception{
		String boname=getboclassbytable(tablename);
		File propFile = new File(output+"compile.list");
		if (!propFile.exists())
		{
			propFile.createNewFile();
			BufferedWriter writer;
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output+"compile.list", true)));
			writer.write(root +"src/com/fkframe/persist/RecordUserAndTimeAble.java" + "\r\n");
			writer.write(javapath +"data/bo/"+moduleName+"/"+boname+".java" + "\r\n");
			writer.write(javapath +"data/vo/"+moduleName+"/"+boname+"VO"+".java" + "\r\n");
			writer.close();
		}
       Runtime.getRuntime().exec("javac -d "+root+"WebRoot/WEB-INF/classes -extdirs "+root+"WebRoot/WEB-INF/lib -encoding UTF-8 @"+output+"compile.list");
	}
	/**
	 * TODO 生成java代码及配置文件
	 * 
	 * heip.generator.main
	 * SingleTableGenerator
	 * 
	 * @param boclass 类路径
	 * @param botitle 类名称
	 * @throws Exception
	 * @since
	 * @author 中软海晟程序员.
	 * @time 2012-11-14下午03:06:10
	 * @version 1.0
	 * <pre>
	 * 
	 * </pre>
	 */
	public static void createJava(String tablename,String tabletitle,String tableid,String inputfields1,String gridfields1) throws Exception {
		String boclass=basepackage+".data.bo."+moduleName+"."+getboclassbytable(tablename);
        SingleTableGenerator gg = new SingleTableGenerator();
        //配置
        File file = new File(root +"src/" +"struts.xml");
        copyFile(file, new File(output +"struts.xml"));        
        
		gg.generatorClazzAndJSP(boclass,tabletitle,tableid,inputfields1,gridfields1);		
	}
	
	/**
	 * TODO 集成代码
	 * 
	 * heip.generator.main
	 * SingleTableGenerator
	 * 
	 * @param tablename 数据表名
	 * @param boname 持久化类名
	 * @throws Exception
	 * @since
	 * @author 中软海晟程序员.
	 * @time 2012-11-14下午02:00:03
	 * @version 1.0
	 * <pre>
	 * 
	 * </pre>
	 */
	public static void Deploy(String tablename) throws Exception {
		String boname=getboclassbytable(tablename);

		File file = new File(output+boname+"Action"+".java");
        copyFile(file, new File(javapath +"action/"+moduleName+"/" + file.getName()));

        file = new File(output+boname+"BS"+".java");
        copyFile(file, new File(javapath +"service/"+moduleName+"/" + file.getName()));

        file = new File(output+boname+"BSImpl"+".java");
        copyFile(file, new File(javapath +"service/impl/"+moduleName+"/" + file.getName()));

        file = new File(output+tablename+"_edit"+".jsp");
        copyFile(file, new File(root +"WebRoot/"+moduleName+"/"+ file.getName()));

        file = new File(output+tablename+"_list"+".jsp");
        copyFile(file, new File(root +"WebRoot/"+moduleName+"/"+ file.getName()));

        file = new File(output+"struts-"+moduleName+".xml");
        copyFile(file, new File(root +"src/struts-" + moduleName +".xml"));

        file = new File(output+"struts.xml");
        copyFile(file, new File(root +"src/struts.xml"));
        
        file = new File(output+"application-"+moduleName+".xml");
        copyFile(file, new File(root +"WebRoot/WEB-INF/" +"applicationContext-"+moduleName+".xml"));

	}

	
//////////////////////////下面内容请勿修改/////////////////////////////////
//////////////////////////下面内容请勿修改/////////////////////////////////
//////////////////////////下面内容请勿修改/////////////////////////////////
	/**
	 * 使用说明
	 * 1)定义表Entity
	 * 例如 ：EntityTable mainTable = new EntityTable("BM_SYS_PARAM（表名称）");
	 * 
	 * 2)调用gt(主表EntityTable)生成文件
	 */
	public void generatorTable(String tablename) throws Exception {
		EntityTable mainTable = new EntityTable(tablename);	
		gt(mainTable);
	}
	/**
	 * 使用说明
	 * 1)定义主表Entity（只有一个）
	 * 例如 ：
	 * EntityClazz mainClazz = new EntityClazz(BmCodeType.class, "代码类型");//参数为：类class，中文名称
	 * 
	 * 2)调用gt(表EntityClazz)生成文件
	 */
	public void generatorClazzAndJSP(String boclass,String tabletitle,String tableid,String inputfields1,String gridfields1)throws Exception{	
		
		Object stcom = Class.forName(boclass).newInstance();

		JavaClass clazz =new JavaClass(stcom.getClass());
		List<EntityColumn> inputfieldList = new ArrayList<EntityColumn>();
		if (inputfields1.equals("")){
			for(int i=0;i<clazz.getProperties().length;i++){
				inputfieldList.add(new EntityColumn(clazz.getProperties()[i].getColumnName().toLowerCase(),clazz.getProperties()[i].getCnName(),clazz.getProperties()[i].getAsType(),"","0","-1"));
			}
		} else {
			String inputfieldlist[] = inputfields1.split(";");
			for(String inputfield1:inputfieldlist){
				String[] field = inputfield1.split(":");
				String fieldname=field[0].toLowerCase();
				String fielduitype="";
				String fieldchecknull="0";
				String fieldchecktype="-1";
				if (field.length>1){
					fielduitype=field[1];
				}
				if (field.length>2){
					fieldchecknull=field[2];
				}
				if (field.length>3){
					fieldchecktype=field[3];
				}
				for(int i=0;i<clazz.getProperties().length;i++){
					if (clazz.getProperties()[i].getColumnName().toLowerCase().equals(fieldname)){
						inputfieldList.add(new EntityColumn(clazz.getProperties()[i].getColumnName().toLowerCase(),clazz.getProperties()[i].getCnName(),clazz.getProperties()[i].getAsType(),fielduitype,fieldchecknull,fieldchecktype));
					}
				}
			}
		}
		List<EntityColumn> gridfieldList = new ArrayList<EntityColumn>();
		if (gridfields1.equals("")){
			for(int i=0;i<clazz.getProperties().length;i++){
				gridfieldList.add(new EntityColumn(clazz.getProperties()[i].getColumnName().toLowerCase(),clazz.getProperties()[i].getCnName(),clazz.getProperties()[i].getAsType(),"","0","-1"));
			}
		} else {
			String gridfieldlist[] = gridfields1.split(";");
			for(String gridfield1:gridfieldlist){
				String[] field = gridfield1.split(":");
				String fieldname=field[0].toLowerCase();
				String fielduitype="";
				String fieldchecknull="0";
				String fieldchecktype="-1";
				if (field.length>1){
					fielduitype=field[1];
				}
				if (field.length>2){
					fieldchecknull=field[2];
				}
				if (field.length>3){
					fieldchecktype=field[3];
				}
				for(int i=0;i<clazz.getProperties().length;i++){
					if (clazz.getProperties()[i].getColumnName().toLowerCase().equals(fieldname)){
						gridfieldList.add(new EntityColumn(clazz.getProperties()[i].getColumnName().toLowerCase(),clazz.getProperties()[i].getCnName(),clazz.getProperties()[i].getAsType(),fielduitype,fieldchecknull,fieldchecktype));
					}
				}
			}
		}
		EntityClazz mainClazz = new EntityClazz(stcom.getClass(),tabletitle,tableid,inputfieldList,gridfieldList);

		
		gc(mainClazz);
	}
	
	private void gt(EntityTable table) throws Exception{
		EntityGenerator eg = new EntityGenerator(moduleName);
		eg.generatorPO(new EntityTable[]{table}, true);
		eg.generatorVO(new EntityTable[]{table}, false);
	}
	
	private void gc(EntityClazz clazz)throws Exception{
		ServiceGenerator sg = new ServiceGenerator(moduleName);
		sg.generatorCacheBS(clazz);
		ActionGenerator ag = new ActionGenerator(moduleName);
		ag.generatorGrid(clazz);
		JSPGenerator jg = new JSPGenerator(moduleName);
		jg.generatorSingle(clazz);
	}
	
    // 复制文件
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }
    public static void clearDir(String sourceDirPath) throws IOException {
        File[] file = (new File(sourceDirPath)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                file[i].delete();
            }
        }
    }
    public static String getboclassbytable(String tablename){
		String boclassname="";
		tablename = tablename.toLowerCase();
		String a[] = tablename.split("_");
		for(int k=0;k<a.length;k++){
			 a[k] = a[k].substring(0, 1).toUpperCase()+ a[k].substring(1);
			 boclassname = boclassname+a[k];
		}
    	return boclassname;
    }
}