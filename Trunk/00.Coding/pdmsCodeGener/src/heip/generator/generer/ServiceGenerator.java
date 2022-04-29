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
public class ServiceGenerator extends AbstractGenerator{
	/**
	 *需要手动修改的变量 
	 */
	//模块名
	private String moduleName;
	String root = "";//工程根目录
	String output = "";//临时输出目录
	
	public  ServiceGenerator(String moduleName){
		this.moduleName = moduleName;
		gg.put("moduleName",this.moduleName);
	}
	
	public void generatorCacheBS(EntityClazz entityClazz) throws Exception{
		Class mainClazz = entityClazz.clazz;
		String entityCnName=entityClazz.entityCnName;
		String tableid=entityClazz.tableid;

		FileProperties props_CorpTotal = new FileProperties("/config.properties");
		String root = props_CorpTotal.getProperty("root"); 
		String output = props_CorpTotal.getProperty("output"); 
        //判断配置是否存在,如果存在则拷贝到临时输出目录追加配置,如果不存在则拷贝一份初始化配置文件进行追加配置.
        File file = new File(root +"WebRoot/WEB-INF/" +"applicationContext-"+moduleName+".xml");
        if (file.exists()){
            copyFile(file, new File(output +"application-"+moduleName+".xml"));
        } else {
			generator.generateByClass(mainClazz,initapplicationTem);	        	
        }
		//1 单表
		if(!entityClazz.hasSub()){
			gg.put("entityCnName", entityCnName);
			gg.put("tableid", tableid);
			generator.generateByClass(mainClazz,sigleTem);
			return;
		}

		//2 多表
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
		
		Map map = new HashMap();
		map.put("subClazzes", subClazzes);
		map.put("clazz",new JavaClass(mainClazz));
		map.put("entityCnName", entityCnName);
		generator.generateByMap(map,cacheMainTem);
		
		for(EntityClazz subClass: entityClazz.subClazzes){
			generatorSubCacheBS(subClass);
		}	
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

	//生成子表service
	private void generatorSubCacheBS(EntityClazz entityClazz) throws Exception{
		Class mainClazz = entityClazz.clazz;
		String entityCnName=entityClazz.entityCnName;
		Map map = new HashMap();
		map = new HashMap();
		map.put("clazz",new JavaClass(entityClazz.clazz));
		map.put("entityCnName", entityClazz.entityCnName);
		
		map.put("mainClazzId", entityClazz.fkProperty);
		map.put("fatherClazz",new JavaClass(entityClazz.fatherClazz.clazz));
		
		JavaClass[] sces = new JavaClass[entityClazz.subClazzes.size()];
		int j=0;
		for(EntityClazz sc: entityClazz.subClazzes){
			sces[j] = new JavaClass(sc.clazz);
			j++;
		}
		map.put("subClazzes", sces);
		generator.generateByMap(map,cacheSubTem);
		if(sces.length>0){
			for(EntityClazz subClass: entityClazz.subClazzes){
				generatorSubCacheBS(subClass);
			}		
		}
	}
	
	
	public void generatorGrid(EntityClazz entityClazz) throws Exception{
		if(!entityClazz.hasSub()){
			generatorCacheBS(entityClazz);
		}
		
		Class mainClazz = entityClazz.clazz;
		String entityCnName=entityClazz.entityCnName;
		
		//1 单表
		//TODO
		
		//2 多表
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
		FileProperties props_CorpTotal = new FileProperties("/config.properties");
		String root = props_CorpTotal.getProperty("root"); 
		String output = props_CorpTotal.getProperty("output"); 
        //判断配置是否存在,如果存在则拷贝到临时输出目录追加配置,如果不存在则拷贝一份初始化配置文件进行追加配置.
        File file = new File(root +"WebRoot/WEB-INF/" +"applicationContext-"+moduleName+".xml");
        if (file.exists()){
            copyFile(file, new File(output +"application-"+moduleName+".xml"));
        } else {
			generator.generateByClass(mainClazz,initapplicationTem);	        	
        }
		generator.generateByMap(map,gridMainTem);
		
		for(EntityClazz subClass: entityClazz.subClazzes){
			generatorSubGrid(subClass);
		}
	}
	public void generatorSubGrid(EntityClazz subClass) throws Exception{
		Map map = new HashMap();
		map.put("clazz",new JavaClass(subClass.clazz));
		map.put("mainClazzId", subClass.fkProperty);
		map.put("fatherClazz",new JavaClass(subClass.fatherClazz.clazz));
		map.put("entityCnName", subClass.entityCnName);
		generator.generateByMap(map,gridSubTem);
	}
	
	/**
	 * 生成3
	 * @param entityClazz
	 * @throws Exception
	 */
	public void generatorThree(EntityClazz entityClazz) throws Exception{
		Class mainClazz = entityClazz.clazz;
		String entityCnName=entityClazz.entityCnName;
		
		
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
		//判断配置是否存在,如果存在则拷贝到临时输出目录追加配置,如果不存在则拷贝一份初始化配置文件进行追加配置.
		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		moduleName = props_CorpTotal.getProperty("moduleName"); 
		root = props_CorpTotal.getProperty("root"); 
		output = props_CorpTotal.getProperty("output"); 
        File file = new File(root +"src/" +"struts-"+moduleName+".xml");
        if (file.exists()){
            copyFile(file, new File(output +"struts-"+moduleName+".xml"));
        } else {
			generator.generateByClass(mainClazz,initstrutsTem);        	
        }
        //判断配置是否存在,如果存在则拷贝到临时输出目录追加配置,如果不存在则拷贝一份初始化配置文件进行追加配置.
        file = new File(root +"WebRoot/WEB-INF/" +"applicationContext-"+moduleName+".xml");
        if (file.exists()){
            copyFile(file, new File(output +"application-"+moduleName+".xml"));
        } else {
			generator.generateByClass(mainClazz,initapplicationTem);	        	
        }
		generator.generateByMap(map,threeMain);
		
		for(EntityClazz subMain: entityClazz.subClazzes){
			if(!subMain.hasSub()){
				generatorSubGrid(subMain);
				continue;
			}
			map = new HashMap();
			map.put("clazz",new JavaClass(subMain.clazz));
			map.put("mainClazzId", subMain.fkProperty);
			map.put("fatherClazz",new JavaClass(entityClazz.clazz));
			map.put("entityCnName", subMain.entityCnName);
			
			subClazzes  = new JavaClass[subMain.subClazzes.size()];
			i=0;
			for(EntityClazz subClass: subMain.subClazzes){
				subClazzes[i] = new JavaClass(subClass.clazz);
				subClazzes[i].setFkProperty(subClass.fkProperty);
				i++;
			}
			map.put("subClazzes", subClazzes);
			
			generator.generateByMap(map,threeSubMain);
			if(subMain.hasSub()){
				for(EntityClazz subClass: subMain.subClazzes){
					map = new HashMap();
					map.put("clazz",new JavaClass(subClass.clazz));
					map.put("mainClazzId", subClass.fkProperty);
					map.put("fatherClazz",new JavaClass(subClass.fatherClazz.clazz));
					map.put("entityCnName", subClass.entityCnName);
					generator.generateByMap(map,threeSub);
				}
			}
		}
	}
	

	private static final String initstrutsTem = "TEMPLATE_NEW/INIT_TEMPLATE/struts";
	private static final String initapplicationTem = "TEMPLATE_NEW/INIT_TEMPLATE/application";
	private static final String sigleTem = "TEMPLATE_NEW/SERVICE_TEMPLATE/single";
	private static final String gridMainTem= "TEMPLATE_NEW/SERVICE_TEMPLATE/twoTable/grid/main";
	private static final String gridSubTem= "TEMPLATE_NEW/SERVICE_TEMPLATE/twoTable/grid/sub";
	private static final String cacheMainTem= "TEMPLATE_NEW/SERVICE_TEMPLATE/twoTable/temTable/main";
	private static final String cacheSubTem= "TEMPLATE_NEW/SERVICE_TEMPLATE/twoTable/temTable/sub";
	private static final String threeMain= cacheMainTem;
	private static final String threeSubMain= "TEMPLATE_NEW/SERVICE_TEMPLATE/threeTable/submain";
	private static final String threeSub= "TEMPLATE_NEW/SERVICE_TEMPLATE/threeTable/sub";
}