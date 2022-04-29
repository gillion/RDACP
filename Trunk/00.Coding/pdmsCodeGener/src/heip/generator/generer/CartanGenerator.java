package heip.generator.generer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.org.rapid_framework.generator.provider.java.model.JavaClass;

import heip.generator.entity.EntityColumn;
import heip.generator.entity.EntityTable;
import heip.generator.main.FileProperties;
/**
 * 实体生成
 * @author HSWHM
 *
 *
 */
public class CartanGenerator extends AbstractGenerator{
	/**
	 *需要手动修改的变量 --------------------------------
	 */
	private String moduleName = "portal";//模块
	
	public void execute() throws Exception{
		//EntityTable ss = new EntityTable("tc_pick_notice_place_dtl", "notice_detail_id");
		//EntityTable sub1 = new EntityTable("tc_pick_notice_dtl", "notice_id",ss);
		EntityTable mainTable = new EntityTable("RO_ACT_CODE");
		
		//generatorPO(new EntityTable[]{mainTable},true);
		generatorVO(new EntityTable[]{mainTable},true);
		
		//generatorPO(new EntityTable[]{sub1,ss},false);
		//generatorVO(new EntityTable[]{sub1,ss},true);
	
	}
	
	
	/**                                                    **/
	/**-------------------------------------END 一下不用管------------ **/
	 /**                                                    */
	private static final String poTem = "TEMPLATE_NEW/ENTITY_TEMPLATE/po";
	private static final String voTem = "TEMPLATE_NEW/ENTITY_TEMPLATE/vo";
	private static final String JspTem = "TEMPLATE_NEW/ENTITY_TEMPLATE/Jsp";
	private static final String TaskTem = "TEMPLATE_NEW/ENTITY_TEMPLATE/Task";
	private static final String subPoTem = "TEMPLATE_NEW/ENTITY_TEMPLATE/subPO";
	private static final String subVoTem = "TEMPLATE_NEW/ENTITY_TEMPLATE/subVO";
	
	public static void main(String[] args) throws Exception{
		CartanGenerator eg = new CartanGenerator();
		eg.execute();
		open();
	}
	public CartanGenerator(){
		gg.put("moduleName",moduleName);
	}
	public CartanGenerator(String moduleName){
		gg.put("moduleName",moduleName);
		gg.put("databaseName","cartan_common");		
	}
	
	
	/**
	 * 生成PO
	 * @param sequence  是否添加Hibernatne Id递增
	 * @param tables
	 * @throws Exception
	 */
	public void generatorPO(EntityTable[] tables,boolean sequence) throws Exception{
		for(EntityTable table: tables){
			String mainTableName= table.getTableName();
			if(sequence){
				generator.generateByTable(mainTableName,poTem);
			}else{
				generator.generateByTable(mainTableName,subPoTem);
			}
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

	/*
	public void generatorVO(EntityTable[] tables,boolean isTem) throws Exception{
		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		String root = props_CorpTotal.getProperty("root"); 
		String output = props_CorpTotal.getProperty("output"); 
		String isTask = props_CorpTotal.getProperty("isTask"); 
		for(EntityTable table: tables){
			String mainTableName= table.getTableName();
			//String boname=getboclassbytable(mainTableName.substring(2));
			String boname=getboclassbytable(mainTableName);
	        //File srcfile = new File("C:/deploy/cartan/output/cartan/cartan-center/src/main/resources/rop/i18n/error_zh_CN.properties");
//			File srcfile = new File(root+"/error_zh_CN.properties");
//		    File desfile = new File(output+"/error_zn_CN.properties");
			File srcfile = new File(root+"/CompareDataStru.txt");
		    File desfile = new File(output+"/CompareDataStru.txt");
			copyFile(srcfile, desfile);
			//srcfile = new File("C:/deploy/cartan/output/cartan/cartan-center/src/main/resources/rop/i18n/error_zh_CN.properties");
		   // desfile = new File(output+"/error_zh_CN.properties");
			//copyFile(srcfile, desfile);
			if (isTask.equals("1")){
				generator.generateByTable(mainTableName,TaskTem);				
			} else
			if(isTem){
				String foreignKey = table.getFkColumn();
				gg.put("foreignKey", foreignKey);
				generator.generateByTable(mainTableName,subVoTem);
			}else{
				generator.generateByTable(mainTableName,voTem);
			}
		}
	}
	
*/

    public void generatorJSP(EntityTable[] tables) throws Exception{
		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		for(EntityTable table: tables){
			String mainTableName= table.getTableName();			
			String timefields = props_CorpTotal.getProperty("timefields"); 
			String selectfields = props_CorpTotal.getProperty("selectfields"); 
			String comboxfields = props_CorpTotal.getProperty("comboxfields");  
			String radiofields = props_CorpTotal.getProperty("radiofields");    
			String checkboxfields = props_CorpTotal.getProperty("checkboxfields");
			String tablelist = props_CorpTotal.getProperty("tablelist");  
			String sysname = props_CorpTotal.getProperty("sysname");  		
			String commonfields = props_CorpTotal.getProperty("commonfields");  	
			addfieldlist("commonfieldList",commonfields); 	 
			Integer psize =0;
			//Integer.parseInt(props_CorpTotal.getProperty("psize"));
			addfieldlist("timefieldList",timefields);
			addfieldlist("selectfieldList",selectfields);
			addtablelist("tablelist",tablelist);
			addfieldlist("comboxList",comboxfields);
			addfieldlist("radioList",radiofields);
			addfieldlist("checkboxList",checkboxfields);
			gg.put("sysname", sysname);		
			String tabledes = mainTableName;
			String fieldlist[] = tablelist.split(";");
			for(String splitfield:fieldlist){
				String[] field = splitfield.split(":");
				String tablename=field[0];
				if (tablename.equals(mainTableName)){
					if (field.length>1)
					tabledes=field[1];
					if (field.length>2)
					psize=Integer.parseInt(field[2]);
				}
			}
			gg.put("tabledes", tabledes);
			gg.put("psize", psize);					
			generator.generateByTable(mainTableName,JspTem);
		}
	}

    public void generatorVO(EntityTable[] tables,boolean isTem) throws Exception{
		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		String output = props_CorpTotal.getProperty("output"); 
		String isTask = "0";
		for(EntityTable table: tables){
			String mainTableName= table.getTableName();
			String boname=getboclassbytable(mainTableName.substring(2));
//	        File srcfile = new File("C:/deploy/cartan/output/cartan/cartan-center/src/main/resources/rop/i18n/error_zh_CN.properties");
//		    File desfile = new File(output+"/error_zn_CN.properties");
//			copyFile(srcfile, desfile);
			if (isTask.equals("1")){
				generator.generateByTable(mainTableName,TaskTem);				
			} else
			if(isTem){
				String foreignKey = table.getFkColumn();
				gg.put("foreignKey", foreignKey);
				generator.generateByTable(mainTableName,subVoTem);
			}else{
				generator.generateByTable(mainTableName,voTem);
				String basepackage = props_CorpTotal.getProperty("basepackage"); 
				String timefields = props_CorpTotal.getProperty("timefields"); 
				String selectfields = props_CorpTotal.getProperty("selectfields"); 
				String comboxfields = props_CorpTotal.getProperty("comboxfields");  
				String radiofields = props_CorpTotal.getProperty("radiofields");  
				String checkboxfields = props_CorpTotal.getProperty("checkboxfields");
				String tablelist = props_CorpTotal.getProperty("tablelist"); 
				String sysname = props_CorpTotal.getProperty("sysname");  	
				String commonfields = props_CorpTotal.getProperty("commonfields");  	
				addfieldlist("commonfieldList",commonfields); 	 	
				Integer psize =0;
				//Integer.parseInt(props_CorpTotal.getProperty("psize")); 			
				moduleName=boname.substring(0, 1).toLowerCase()+ boname.substring(1);
				addfieldlist("timefieldList",timefields);
				addfieldlist("selectfieldList",selectfields);
				addtablelist("tablelist",tablelist);
				addfieldlist("comboxList",comboxfields);
				addfieldlist("radioList",radiofields);
				addfieldlist("checkboxList",checkboxfields);
				gg.put("sysname", sysname);				

				String tabledes = mainTableName;
				String fieldlist[] = tablelist.split(";");
				for(String splitfield:fieldlist){
					String[] field = splitfield.split(":");
					String tablename=field[0];
					if (tablename.equals(mainTableName)){
						if (field.length>1)
						tabledes=field[1];
						if (field.length>2)
						psize=Integer.parseInt(field[2]);
					}
				}
				gg.put("tabledes", tabledes);
				gg.put("psize", psize);			
				generator.generateByTable(mainTableName,JspTem);
			}
		}
	}

	public void addtablelist(String listname,String splitfields){			

		List<EntityColumn> columnfieldList = new ArrayList<EntityColumn>();
		String fieldlist[] = splitfields.split(";");
		for(String splitfield:fieldlist){
			String[] field = splitfield.split(":");
			String fieldname=field[0];
			fieldname=getboclassbytable(fieldname.substring(2));
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
			columnfieldList.add(new EntityColumn(fieldname,fieldname,"String",fielduitype,fieldchecknull,fieldchecktype));
		}
		gg.put(listname,columnfieldList);
	}
	public void addfieldlist(String listname,String splitfields){			

		List<EntityColumn> columnfieldList = new ArrayList<EntityColumn>();
		String fieldlist[] = splitfields.split(";");
		for(String splitfield:fieldlist){
			String[] field = splitfield.split(":");
			String fieldname=field[0];
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
			columnfieldList.add(new EntityColumn(fieldname,fieldchecknull,"String",fielduitype,fieldchecknull,fieldchecktype));
		}
		gg.put(listname,columnfieldList);
	}
	
	
	public void generator(EntityTable mainTable) throws Exception{
		String mainTableName= mainTable.getTableName();
		
		generator.generateByTable(mainTableName,poTem);
		generator.generateByTable(mainTableName,voTem);	
		
		generatorSubTable(mainTable);
	}
	
	public void generatorSubTable(EntityTable mainTable) throws Exception{
		if(mainTable.hasSubTable()){
			for(EntityTable sub : mainTable.getSubEntitys()){
				String detailTableName = sub.getTableName();
				String foreignKey = sub.getFkColumn();
				super.gg.put("foreignKey", foreignKey);
				
				generator.generateByTable(detailTableName,subPoTem);
				generator.generateByTable(detailTableName,subVoTem);	
				
				if(sub.hasSubTable()){generatorSubTable(sub);}
			}
		}
	}
}
