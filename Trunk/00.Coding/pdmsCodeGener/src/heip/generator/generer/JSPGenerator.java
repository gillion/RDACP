package heip.generator.generer;

import heip.generator.entity.EntityClazz;
import heip.generator.entity.EntityColumn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.org.rapid_framework.generator.provider.java.model.JavaClass;
import cn.org.rapid_framework.generator.provider.java.model.JavaProperty;

/**
 * 生成service类
 * @author HSWHM
 *
 */
public class JSPGenerator extends AbstractGenerator{
	/**
	 *需要手动修改的变量 
	 */
	String moduleName = "";
	
	
	
	public void execute() throws Exception{
		
		
	}
	
	/**                                                    **/
	/**-------------------------------------END 一下不用管------------ **/
	public JSPGenerator(){
		gg.put("moduleName",moduleName);
	}
	public JSPGenerator(String moduleName){
		gg.put("moduleName",moduleName);
	}
	
	
	public static void main(String[] args) throws Exception{
		JSPGenerator ge = new JSPGenerator();
		ge.execute();
		open();
	}
	
	private static final String singleMain = "TEMPLATE_NEW/JSP_TEMPLATE/singleTable/main";
	private static final String twoGrid = "TEMPLATE_NEW/JSP_TEMPLATE/twoTable/grid";
	private static final String temMain = "TEMPLATE_NEW/JSP_TEMPLATE/twoTable/temTable/main";
	private static final String temSub = "TEMPLATE_NEW/JSP_TEMPLATE/twoTable/temTable/sub";
	
	private static final String threeMain = temMain;//list跟twoGrid的一模一样复制拷贝而已
	private static final String threeSubMain = "TEMPLATE_NEW/JSP_TEMPLATE/threeTable/subMain";
	//private static final String threeSub = "TEMPLATE_NEW/JSP_TEMPLATE/twoTable/temTable/sub";
	
	public void generatorSingle(EntityClazz entityClazz) throws Exception{
		Class mainClazz = entityClazz.clazz;
		String entityCnName=entityClazz.entityCnName;
		String tableid=entityClazz.tableid;		
		JavaClass clazz =new JavaClass(mainClazz);
		/*JavaClass[] subClazzes = new JavaClass[entityClazz.subClazzes.size()];
		int i=0;
		for(EntityClazz subClass: entityClazz.subClazzes){
			subClazzes[i] = new JavaClass(subClass.clazz);
			subClazzes[i].setFkProperty(subClass.fkProperty);
			i++;
		}
		Map map = new HashMap();
		map.put("subClazzes", subClazzes);*/
		Map map = new HashMap();
		map.put("clazz",clazz);
		map.put("entityCnName", entityCnName);				
		map.put("tableid", tableid);		
		map.put("inputfieldList",entityClazz.inputfieldList);
		map.put("gridfieldList",entityClazz.gridfieldList);
		
		generator.generateByMap(map,singleMain);
	}
	
	public void generatorGrid(EntityClazz entityClazz) throws Exception{
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
		generator.generateByMap(map,twoGrid);
	}
	

	public void generateJsp4Two(EntityClazz entityClazz) throws Exception{
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
		generator.generateByMap(map,temMain);
		
		for(EntityClazz subClass: entityClazz.subClazzes){
			map = new HashMap();
			map.put("clazz",new JavaClass(subClass.clazz));
			map.put("mainClazzId", subClass.fkProperty);
			map.put("fatherClazz",new JavaClass(subClass.fatherClazz.clazz));
			map.put("entityCnName", subClass.entityCnName);
			generator.generateByMap(map, temSub);
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
