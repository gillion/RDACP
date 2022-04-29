package heip.generator.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import heip.generator.entity.EntityClazz;
import heip.generator.entity.EntityTable;
import heip.generator.generer.ActionGenerator;
import heip.generator.generer.EntityGenerator;
import heip.generator.generer.JSPGenerator;
import heip.generator.generer.ServiceGenerator;



/**
 * 已不推荐使用，因为2层表都使用gird方式实现
 * 两层表的临时表方式 代码生成器
 * @author HSWHM
 */
@Deprecated
public class TwoTableGenerator  extends BaseAbstractCodeGenerator{

	static String moduleName;//模块名称
	static String basepackage;//基础包
	static String root; //工程根目录
	static String output; //临时输出目录
	static String javapath; //java文件目录
	
	public static void main(String[] args)throws Exception{
		//runMakeCode(1);
		runMakeCode(2);
		open();
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
	 * @time 2012-11-23上午09:50:10
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

		String tname1 = props_CorpTotal.getProperty("tablename1"); 
		String title1 = props_CorpTotal.getProperty("tabletitle1"); 	
		String tname2 = props_CorpTotal.getProperty("tablename2"); 
		String title2 = props_CorpTotal.getProperty("tabletitle2"); 
		String tid2 = props_CorpTotal.getProperty("tableid2"); 
		String isDepoly=props_CorpTotal.getProperty("isDeploy"); 	
		
		// 创建集成目录
		createDir();	
		
        //循环逻辑开始
		String tb1[] = tname1.split(";");
		String tbtitle1[] = title1.split(";");
		String tb2[] = tname2.split(";");
		String tbtitle2[] = title2.split(";");
		String tbid2[] = tid2.split(";");
		for(int k=0;k<tb1.length;k++){
			String tablename1 = tb1[k];
			String tabletitle1 = tbtitle1[k];
			String tablename2 = tb2[k];
			String tabletitle2 = tbtitle2[k];
			String tableid2 = tbid2[k];
			clearDir(output);
			if (step==1){
				// 生成持久化类
				createPoVo(tablename1,tablename2,tableid2);
			} else if (step==2){
				// 生成java代码及配置文件
				createJava(tablename1,tabletitle1,tablename2,tabletitle2,tableid2);
				// 集成代码
				if (isDepoly.equals("1"))
					Deploy(tablename1,tablename2);
			}
			
		}
        //循环逻辑结束
	}
	//
	
	/**
	 * TODO 创建集成目录
	 * 
	 * heip.generator.main
	 * SingleTableGenerator
	 * 
	 * @throws Exception
	 * @since
	 * @author 中软海晟程序员.
	 * @time 2012-11-23上午09:50:38
	 * @version 1.0
	 * <pre>
	 * 
	 * </pre>
	 */
	public static void createDir() throws Exception {			
		// 新建目标目录
        (new File(javapath+"data/bo/"+moduleName)).mkdirs();
        (new File(javapath+"data/vo/"+moduleName)).mkdirs();
        (new File(javapath+"action/"+moduleName)).mkdirs();
        (new File(javapath+"service/"+moduleName)).mkdirs();
        (new File(javapath+"service/impl/"+moduleName)).mkdirs();
        (new File(root +"WebRoot/"+moduleName)).mkdirs();
	}
	//
	
	/**
	 * TODO 生成持久化类
	 * 
	 * heip.generator.main
	 * TwoTable4GridGenerator
	 * 
	 * @param tablename1主表
	 * @param tablename2从表
	 * @param tableid2从表关联主表字段
	 * @throws Exception
	 * @since
	 * @author 中软海晟程序员.
	 * @time 2012-11-23上午09:50:54
	 * @version 1.0
	 * <pre>
	 * 
	 * </pre>
	 */
	public static void createPoVo(String tablename1,String tablename2,String tableid2) throws Exception {

		TwoTableGenerator gg = new TwoTableGenerator();
		
		gg.generatorTable(tablename1,tablename2,tableid2);
		
		String boname1=getboclassbytable(tablename1);
		String boname2=getboclassbytable(tablename2);
        //表一
        File file = new File(output+boname1+".java");
        copyFile(file, new File(javapath +"data/bo/"+moduleName+"/" + file.getName()));

        file = new File(output+boname1+"VO"+".java");
        copyFile(file, new File(javapath +"data/vo/"+moduleName+"/" + file.getName()));
        //表二
        file = new File(output+boname2+".java");
        copyFile(file, new File(javapath +"data/bo/"+moduleName+"/" + file.getName()));
        
        file = new File(output+boname2+"VO"+".java");
        copyFile(file, new File(javapath +"data/vo/"+moduleName+"/" + file.getName()));

	}
	//
	
	/**
	 * TODO 生成java代码及配置文件
	 * 
	 * heip.generator.main
	 * TwoTable4GridGenerator
	 * 
	 * @param tablename1主表英文名
	 * @param tabletitle1主表中文名
	 * @param tablename2从表英文名
	 * @param tabletitle2从表中文名
	 * @param tableid2从表关联主表字段
	 * @throws Exception
	 * @since
	 * @author 中软海晟程序员.
	 * @time 2012-11-23上午09:51:15
	 * @version 1.0
	 * <pre>
	 * 
	 * </pre>
	 */
	public static void createJava(String tablename1,String tabletitle1,String tablename2,String tabletitle2,String tableid2) throws Exception {

		TwoTableGenerator gg = new TwoTableGenerator();
		String boclass1=basepackage+".data.bo."+moduleName+"."+getboclassbytable(tablename1);	        
		String boclass2=basepackage+".data.bo."+moduleName+"."+getboclassbytable(tablename2);	
        //配置
        File file = new File(root +"src/" +"struts.xml");
        copyFile(file, new File(output +"struts.xml"));    
		//生成bs,action,jsp请保证实体已先生成并以导入工程
		gg.generatorClazzAndJSP(boclass1,tabletitle1,boclass2,tabletitle2,tableid2);

	}
	//
	
	/**
	 * TODO 集成代码
	 * 
	 * heip.generator.main
	 * TwoTable4GridGenerator
	 * 
	 * @param tablename1主表名
	 * @param tablename2从表名
	 * @throws Exception
	 * @since
	 * @author 中软海晟程序员.
	 * @time 2012-11-23上午09:51:33
	 * @version 1.0
	 * <pre>
	 * 
	 * </pre>
	 */
	public static void Deploy(String tablename1,String tablename2) throws Exception {
		
		String boname1=getboclassbytable(tablename1);
		String boname2=getboclassbytable(tablename2);
        //表一
		File file = new File(output+boname1+"Action"+".java");
        copyFile(file, new File(javapath +"action/"+moduleName+"/" + file.getName()));

        file = new File(output+boname1+"BS"+".java");
        copyFile(file, new File(javapath +"service/"+moduleName+"/" + file.getName()));

        file = new File(output+boname1+"BSImpl"+".java");
        copyFile(file, new File(javapath +"service/impl/"+moduleName+"/" + file.getName()));

        file = new File(output+tablename1+"_edit"+".jsp");
        copyFile(file, new File(root +"WebRoot/"+moduleName+"/"+ file.getName()));

        file = new File(output+tablename1+"_list"+".jsp");
        copyFile(file, new File(root +"WebRoot/"+moduleName+"/"+ file.getName()));

        file = new File(output+"struts.xml");
        copyFile(file, new File(root +"src/struts.xml"));
        
        file = new File(output+"struts-"+moduleName+".xml");
        copyFile(file, new File(root +"src/struts-" + moduleName +".xml"));

        file = new File(output+"application-"+moduleName+".xml");
        copyFile(file, new File(root +"WebRoot/WEB-INF/applicationContext-" + moduleName + ".xml"));


        //表二
        file = new File(output+boname2+"Action"+".java");
        copyFile(file, new File(javapath +"action/"+moduleName+"/" + file.getName()));

        file = new File(output+boname2+"BS"+".java");
        copyFile(file, new File(javapath +"service/"+moduleName+"/" + file.getName()));

        file = new File(output+boname2+"BSImpl"+".java");
        copyFile(file, new File(javapath +"service/impl/"+moduleName+"/" + file.getName()));

        file = new File(output+tablename2+"_edit"+".jsp");
        copyFile(file, new File(root +"WebRoot/"+moduleName+"/"+ file.getName()));

        file = new File(output+tablename2+"_list"+".jsp");
        copyFile(file, new File(root +"WebRoot/"+moduleName+"/"+ file.getName()));

        file = new File(output+"struts-"+moduleName+".xml");
        copyFile(file, new File(root +"src/struts-" + moduleName + ".xml"));

        file = new File(output+"application-"+moduleName+".xml");
        copyFile(file, new File(root +"WebRoot/WEB-INF/applicationContext-" + moduleName + ".xml"));

	}
	

	//////////////////////////下面内容请勿修改/////////////////////////////////
	//////////////////////////下面内容请勿修改/////////////////////////////////
	//////////////////////////下面内容请勿修改/////////////////////////////////
	
	public void generatorTable(String tablename1,String tablename2,String id2) throws Exception {
		EntityTable sub = new EntityTable(tablename2, id2);//参数为 表名：tc_pick_after,外键:before_id
		EntityTable mainTable = new EntityTable(tablename1,sub);	//参数为 表名：tc_pick_after,子表对象：sub		
		//生成代码
		gt(mainTable);//只需要传入主表对象就可以了
	}
	
	public void generatorClazzAndJSP(String boclass1,String botitle1,String boclass2,String botitle2,String id2)throws Exception{
		Object stcom1 = Class.forName(boclass1).newInstance();
		Object stcom2 = Class.forName(boclass2).newInstance();
		EntityClazz subClazz = new EntityClazz(stcom2.getClass(), botitle2,id2);//参数：子表类Class,中文名称，外键属性名
		EntityClazz mainClazz = new EntityClazz(stcom1.getClass(),botitle1,subClazz);//参数为：类class，中文名称，子表EntityClazz对象
		
		//生成代码
		gc(mainClazz);//只需要传入主表对象就可以了
	}
	
	
	private void gt(EntityTable table) throws Exception{
		EntityGenerator eg = new EntityGenerator(moduleName);
		eg.generatorPO(new EntityTable[]{table}, true);
		eg.generatorVO(new EntityTable[]{table}, false);
		
		for(EntityTable et : table.getSubEntitys()){
			eg.generatorPO(new EntityTable[]{et}, true);
			eg.generatorVO(new EntityTable[]{et}, true);
			if(et.hasSubTable()){
				for(EntityTable ett :et.getSubEntitys()){
					eg.generatorPO(new EntityTable[]{ett}, true);
					eg.generatorVO(new EntityTable[]{ett}, true);
				}
			}
		}
	}
	
	private void gc(EntityClazz clazz)throws Exception{
		ServiceGenerator sg = new ServiceGenerator(moduleName);
		ActionGenerator ag = new ActionGenerator(moduleName);
		JSPGenerator jg = new JSPGenerator(moduleName);
	
		sg.generatorCacheBS(clazz);
		ag.generateTem4Two(clazz);
		jg.generateJsp4Two(clazz);
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
