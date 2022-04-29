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
public class CstGenerator extends AbstractGenerator{
	/**
	 *需要手动修改的变量 --------------------------------
	 */
	private String moduleName = "portal";//模块
	
	public void execute() throws Exception{
		//EntityTable ss = new EntityTable("tc_pick_notice_place_dtl", "notice_detail_id");
		//EntityTable sub1 = new EntityTable("tc_pick_notice_dtl", "notice_id",ss);
		EntityTable mainTable = new EntityTable("RO_ACT_CODE");
		
		//generatorPO(new EntityTable[]{mainTable},true);
		//generatorVO(new EntityTable[]{mainTable},true);
		
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
		CstGenerator eg = new CstGenerator();
		eg.execute();
		open();
	}
	public CstGenerator(){
		gg.put("moduleName",moduleName);
	}
	public CstGenerator(String moduleName){
		gg.put("moduleName",moduleName);
		gg.put("databaseName","cartan_common");		
	}
	
	
	/**
	 * 生成PO
	 * @param sequence  是否添加Hibernatne Id递增
	 * @param tables
	 * @throws Exception
	 */
	public void generatorPO(EntityTable[] tables,String templatePath) throws Exception{
		for(EntityTable table: tables){
			String mainTableName= table.getTableName();
			generator.generateByTable(mainTableName,templatePath);
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

    public void generatorJSP(EntityTable[] tables,String templatePath) throws Exception{
		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		for(EntityTable table: tables){
			String mainTableName= table.getTableName();			
			String timefields = props_CorpTotal.getProperty("timefields"); 
			String selectfields = props_CorpTotal.getProperty("selectfields"); 
			String comboxfields = props_CorpTotal.getProperty("comboxfields");  
			String radiofields = props_CorpTotal.getProperty("radiofields");  
			String checkboxfields = props_CorpTotal.getProperty("checkboxfields");
			String tablelist = props_CorpTotal.getProperty("tablelist");  
			String commonfields = props_CorpTotal.getProperty("commonfields"); 
			String sysname = props_CorpTotal.getProperty("sysname");  	
			String basepackage = props_CorpTotal.getProperty("basepackage");  	
			Integer psize =0;	
			addfieldlist("timefieldList",timefields);
			addfieldlist("selectfieldList",selectfields);
			addtablelist("tablelist",tablelist);
			addfieldlist("comboxList",comboxfields);
			addfieldlist("radioList",radiofields);
			addfieldlist("checkboxList",checkboxfields);
			addfieldlist("commonfieldList",commonfields);
			gg.put("sysname", sysname);		
			gg.put("basepackage", basepackage);		
			String tabledes = mainTableName;
			String inherittable = "";
			String noparent = "";  	
			String modeltype="0";
			String psql="";
			String fieldlist[] = tablelist.split(";");
			for(String splitfield:fieldlist){
				String[] field = splitfield.split(":");
				String tablename=field[0];
				if (tablename.equals(mainTableName)){
					if (field.length>1)
					tabledes=field[1];
					if (field.length>2)
						psize=Integer.parseInt(field[2]);
					if (field.length>3){
						if (field[3].length()>2){
							inherittable=getboclassbytable(field[3].substring(2));							
						}else{
							inherittable="";
						}						
					}
					if (field.length>4)
						noparent=field[4];	
					if (field.length>6)
						modeltype=field[6];
					if (field.length>7)
						psql=field[7];
					//
				}
			}
			gg.put("tabledes", tabledes);
			gg.put("noparent", noparent);
			gg.put("inherittable", inherittable);
			gg.put("psize", psize);					
			gg.put("modeltype", modeltype);		
			gg.put("psql", psql);				
			generator.generateByTable(mainTableName,templatePath);
		}
	}

    public void generatorVO(EntityTable[] tables,String templatePath) throws Exception{
		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		String output = props_CorpTotal.getProperty("output"); 
		for(EntityTable table: tables){
			String mainTableName= table.getTableName();
			String boname=getboclassbytable(mainTableName.substring(3));
			String seqname=mainTableName.substring(1, mainTableName.length()-2)+"_S";
			
			//generator.generateByTable(mainTableName,templatePath);
			String basepackage = props_CorpTotal.getProperty("basepackage"); 
			String timefields = props_CorpTotal.getProperty("timefields"); 
			String selectfields = props_CorpTotal.getProperty("selectfields"); 
			String comboxfields = props_CorpTotal.getProperty("comboxfields");  
			String radiofields = props_CorpTotal.getProperty("radiofields");  
			String checkboxfields = props_CorpTotal.getProperty("checkboxfields");
			String tablelist = props_CorpTotal.getProperty("tablelist"); 
			String commonfields = props_CorpTotal.getProperty("commonfields"); 
			String sysname = props_CorpTotal.getProperty("sysname");  			
			Integer psize =0;		
			String modeltype="0";
			moduleName=boname.substring(0, 1).toLowerCase()+ boname.substring(1);
			addfieldlist("timefieldList",timefields);
			addfieldlist("selectfieldList",selectfields);
			addtablelist("tablelist",tablelist);
			addfieldlist("comboxList",comboxfields);
			addfieldlist("radioList",radiofields);
			addfieldlist("checkboxList",checkboxfields);
			addfieldlist("commonfieldList",commonfields);
			gg.put("seqname", seqname);		
			gg.put("sysname", sysname);		
			gg.put("basepackage", basepackage);		
			String tabledes = mainTableName;
			String inherittable = "";
			String noparent = "";  	
			String psql="";
			String fieldlist[] = tablelist.split(";");
			for(String splitfield:fieldlist){
				String[] field = splitfield.split(":");
				String tablename=field[0];
				if (tablename.equals(mainTableName)){
					if (field.length>1)
					tabledes=field[1];
					if (field.length>2)
						psize=Integer.parseInt(field[2]);
					if (field.length>3){
						if (field[3].length()>2){
							inherittable=getboclassbytable(field[3].substring(3));							
						}else{
							inherittable="";							
						}						
					}	
					if (field.length>4)
						noparent=field[4];	
					if (field.length>6)
						modeltype=field[6];
					if (field.length>7)
						psql=field[7];
						
					//psize=Integer.parseInt(field[2]);
				}
			}
			gg.put("inherittable", inherittable);
			gg.put("noparent", noparent);
			gg.put("tabledes", tabledes);
			gg.put("psize", psize);					
			gg.put("modeltype", modeltype);		
			gg.put("psql", psql);				
			generator.generateByTable(mainTableName,templatePath);
		}
	}

	public void addtablelist(String listname,String splitfields){			

		List<EntityColumn> columnfieldList = new ArrayList<EntityColumn>();
		String fieldlist[] = splitfields.split(";");
		for(String splitfield:fieldlist){
			String[] field = splitfield.split(":");
			String fieldname=field[0];
			fieldname=getboclassbytable(fieldname.substring(3));
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
