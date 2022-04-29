package heip.generator.generer;

import heip.generator.entity.EntityClazz;
import heip.generator.main.FileProperties;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.org.rapid_framework.generator.provider.java.model.JavaClass;

/**
 * 生成service类
 * @author HSWHM
 *
 */
public class ActionGenerator extends AbstractGenerator{
	/**
	 *需要手动修改的变量 
	 */
	String moduleName = "";
	String root = "";//工程根目录
	String output = "";//临时输出目录
	
	public void execute()throws Exception{
		
	}
	
	/******************************************************/
	
	public ActionGenerator(){
		gg.put("moduleName",moduleName);
		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		moduleName = props_CorpTotal.getProperty("moduleName"); 
		root = props_CorpTotal.getProperty("root"); 
		output = props_CorpTotal.getProperty("output"); 
	}
	public ActionGenerator(String moduleName){
		this.moduleName = moduleName;
		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		root = props_CorpTotal.getProperty("root"); 
		output = props_CorpTotal.getProperty("output"); 
		gg.put("moduleName",moduleName);
	}
	
	public static void main(String[] args) throws Exception{
		ActionGenerator ge = new ActionGenerator();
		ge.execute();
		open();
	}
	

	private static final String initstrutsTem = "TEMPLATE_NEW/INIT_TEMPLATE/struts";
	private static final String sigleTem = "TEMPLATE_NEW/ACTION_TEMPLATE/single";
	private static final String twoGrid = "TEMPLATE_NEW/ACTION_TEMPLATE/twoTable/grid/main";
	private static final String twoTemMain = "TEMPLATE_NEW/ACTION_TEMPLATE/twoTable/temTable/main";
	private static final String twoTemSub = "TEMPLATE_NEW/ACTION_TEMPLATE/twoTable/temTable/sub";
	private static final String threeMain = twoTemMain;
	private static final String threeSubMain = "TEMPLATE_NEW/ACTION_TEMPLATE/threeTable/sub";
	
	
	public void generatorGrid(EntityClazz entityClazz) throws Exception{
		Class mainClazz = entityClazz.clazz;
		String entityCnName=entityClazz.entityCnName;
		String tableid=entityClazz.tableid;
		
        //判断配置是否存在,如果存在则拷贝到临时输出目录追加配置,如果不存在则拷贝一份初始化配置文件进行追加配置.
        File file = new File(root +"src/" +"struts-"+moduleName+".xml");
        if (file.exists()){
            copyFile(file, new File(output +"struts-"+moduleName+".xml"));
        } else {
			generator.generateByClass(mainClazz,initstrutsTem);        	
        }
		//1 单表
		if(!entityClazz.hasSub()){
			gg.put("entityCnName", entityCnName);
			gg.put("tableid", tableid);
			gg.put("inputfieldList",entityClazz.inputfieldList);
			generator.generateByClass(mainClazz,sigleTem);
			return;
		}
		
		//2grid 
		JavaClass[] subClazzes = new JavaClass[entityClazz.subClazzes.size()];
		int i=0;
		for(EntityClazz subClass: entityClazz.subClazzes){
			subClazzes[i] = new JavaClass(subClass.clazz);
			subClazzes[i].setFkProperty(subClass.fkProperty);
			i++;
		}
		
		Map map = new HashMap();
		map.put("subClazzes", subClazzes);
		map.put("clazz",new JavaClass(mainClazz));
		map.put("entityCnName", entityCnName);
		
		generator.generateByMap(map, twoGrid);
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
	public void generateTem4Two(EntityClazz entityClazz) throws Exception{
		Class mainClazz = entityClazz.clazz;
		String entityCnName=entityClazz.entityCnName;
		Map map = new HashMap();
        //判断配置是否存在,如果存在则拷贝到临时输出目录追加配置,如果不存在则拷贝一份初始化配置文件进行追加配置.
        File file = new File(root +"src/" +"struts-"+moduleName+".xml");
        if (file.exists()){
            copyFile(file, new File(output +"struts-"+moduleName+".xml"));
        } else {
			generator.generateByClass(mainClazz,initstrutsTem);        	
        }
		/**
		 * 生成主表的bs
		 */
		
		JavaClass[] subClazzes = new JavaClass[entityClazz.subClazzes.size()];
		int i=0;
		for(EntityClazz subClass: entityClazz.subClazzes){
			subClazzes[i] = new JavaClass(subClass.clazz);
			subClazzes[i].setFkProperty(subClass.fkProperty);
			i++;
		}
		map.put("subClazzes", subClazzes);
		map.put("clazz",new JavaClass(mainClazz));
		map.put("entityCnName", entityCnName);
		/**
		 * 生成主表的Action
		 */
		generator.generateByMap(map,twoTemMain);
		for(EntityClazz subClass: entityClazz.subClazzes){
			map = new HashMap();
			map.put("clazz",new JavaClass(subClass.clazz));
			map.put("mainClazzId", subClass.fkProperty);
			map.put("fatherClazz",new JavaClass(subClass.fatherClazz.clazz));
			map.put("entityCnName", subClass.entityCnName);
			generator.generateByMap(map,twoTemSub);
		}
	}
	
	public void generateThree(EntityClazz entityClazz) throws Exception{
		Class mainClazz = entityClazz.clazz;
		String entityCnName=entityClazz.entityCnName;
		Map map = new HashMap();
		/**
		 * 生成主表的bs
		 */
		
		JavaClass[] subClazzes = new JavaClass[entityClazz.subClazzes.size()];
		int i=0;
		for(EntityClazz subClass: entityClazz.subClazzes){
			subClazzes[i] = new JavaClass(subClass.clazz);
			subClazzes[i].setFkProperty(subClass.fkProperty);
			i++;
		}
		map.put("subClazzes", subClazzes);
		map.put("clazz",new JavaClass(mainClazz));
		map.put("entityCnName", entityCnName);
		/**
		 * 生成主表的Action
		 */
		generator.generateByMap(map,threeMain);
		for(EntityClazz subMain: entityClazz.subClazzes){
			map = new HashMap();
			map.put("clazz",new JavaClass(subMain.clazz));
			map.put("mainClazzId", subMain.fkProperty);
			map.put("fatherClazz",new JavaClass(subMain.fatherClazz.clazz));
			map.put("entityCnName", subMain.entityCnName);
			
			subClazzes = new JavaClass[subMain.subClazzes.size()];
			i=0;
			for(EntityClazz subClass: subMain.subClazzes){
				subClazzes[i] = new JavaClass(subClass.clazz);
				subClazzes[i].setFkProperty(subClass.fkProperty);
				i++;
			}
			map.put("subClazzes", subClazzes);
			generator.generateByMap(map,threeSubMain);
		}
	}
}