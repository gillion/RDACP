package heip.generator.main;

import heip.generator.entity.EntityTable;
import heip.generator.generer.EntityGenerator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.org.rapid_framework.generator.GeneratorProperties;



/**
 * 请使用具体的单表，多表生成器来生成实体
 * 实体代码生成器
 * 
 * @author HSWHM
 * 
 */
@Deprecated
public class EntityCodeGenerator extends BaseAbstractCodeGenerator {

	private static String moduleName = "App";//模块
	private static String isNew = "0";//是否覆盖业务类
	private static String maketype = "2";//生成内容 1:po;2:vo
	
	public static void main(String[] args)throws Exception{
		/**
		 * 注意：如果VO继承临时表需要指定外键字段
		 * 一张表一张表生成，不用设置父子关系
		 */
		

		clearDir("E:/heip-generator-output/");

		turntable("WrInst_Pcs_Opin_Tbl");   
		turntable("WrInst_TrmOfVld_Inf");   
		turntable("WrInst_Admt_Reply_Bl");  
		turntable("WrInstAdmtAplyBsn_Tbl"); 
		turntable("WrInst_Admt_Inf");       
		turntable("EC_Cst_Aply_Inf");       
		turntable("ECmrc_Splt_Jrnl");       
		turntable("ECmrc_Cst_Pcs_Inf");     
		turntable("TrdFnc_RltInf");         
		turntable("CpCtRsk_Ivst_Cst_List"); 
		turntable("Empe_Prmpt_Inf");        
		turntable("To_Alct_Cst_List");      
		turntable("Cst_And_Empe_Rel");      
		turntable("Cst_And_Empe_Rel_Hist"); 
		turntable("Cst_And_CCBIns_Rel");    
		turntable("CstAndCCBIns_Rel_Hist"); 
		turntable("CstMGrpAnd_CCBIns_Rel"); 
		turntable("CstMGrpACCBInsRelHist"); 
		turntable("Cst_MGrp_And_Empe_Rel"); 
		turntable("CstMGrpAndEmpeRelHist"); 
		turntable("Cst_Mgt_Team_MdHis");    
		turntable("Cst_HdOv_Rslt");         
		turntable("Cst_HdOv_Rcrd");         
		turntable("InstMrgBtchPcsParmTbl"); 
		turntable("CpCt_Ls_Rsk_Inf");       
		turntable("Ls_Warn_Rsn_Inf");       
		turntable("Ls_Warn_RDsc_Inf");      
		turntable("PD_Invt_Ases_Inf");      
		turntable("PD_Prcg_Ases_Inf");      
		turntable("Ls_Warn_TrVal");         
		turntable("FnRpt_Cd_Tbl");          
		turntable("Org_FnRpt_InfItm");      
		turntable("Fnc_Idx_Cd_Tbl");        
		turntable("Fnc_InData");            
		turntable("FnRpt");                 
		turntable("Csttpandfnrptctlg_Rel"); 
		turntable("Org_FnRpt_Inf");         
		turntable("Cst_Fnc_Data");          
		turntable("Vw_Rl_Cfg");             
		turntable("Vw_Cfg");                
		turntable("SmBsn_Cst_Plcy");        
		turntable("IdfcyHsCstc_Cntnt_Inf"); 
		turntable("Idfcy_Hs_Cgy_LnPj_Inf"); 
		turntable("RlEstDvlpCgy_LnPj_Inf"); 
		turntable("FixAst_Ln_Cgy_Prj_Inf"); 
		turntable("LdRsrv_Ln_Cgy_Prj_Inf"); 
		turntable("ApvlItmBrSpclzOpt_Inf"); 
		turntable("ApvlItmBrSzOptInfHist"); 
		turntable("Apvl_Itm_Apl_Hier_Inf"); 
		turntable("ApvlItmAplHierInfHist"); 
		turntable("Apvl_Itm_Apl_Inst_Inf"); 
		turntable("ApvlItmAplInstInfHist"); 
		turntable("Apvl_Itm_Cmnt_Inf");     
		turntable("ApvlItm_Cmnt_Inf_Hist"); 
		turntable("Apvl_Itm_Inf");          
		turntable("Apvl_Itm_Inf_Hist");     
		turntable("CstBscInfDpltTmPntInf"); 
		turntable("CstOprtSttnDtTmPntInf"); 
		turntable("CstMGrpMbrDptTmPntInf"); 
		turntable("CstMGrpDplt_TmPnt_Inf"); 
		turntable("Cst_Main_Fnc_Idx");      
		turntable("TrdFncBsnAlBrSpclzInf"); 
		turntable("TrdFncBsnApvlAply_Inf"); 
		turntable("CmrclHsCstc_Cntnt_Inf"); 
		turntable("IvsrListDpltTmPnt_Inf"); 
		turntable("Prj_Fnds_Prep_Scm");     
		turntable("CrLnApvl_Pcs_Opin_Tbl"); 
		turntable("CrLn_Apvl_Reply_Bl");    
		turntable("CrLn_Apvl_Aply_Inf");    
		turntable("CrLn_Apvl_Qstn_Ansr");   
		turntable("UCnstrct_Prj_Inf");      
		turntable("Cst_Prj_Apvl_Rule");     
		turntable("PD_CL_Rule");            
		turntable("PD_CL_Rule_Hist");       
		turntable("PD_CrLn_Plcy_Def_Rule"); 
		turntable("PDCrLnPlcyDefRuleHist"); 
		turntable("PD_Plcy");               
		turntable("PD_Plcy_Hist");          
		turntable("CpCt_Plcy");             
		turntable("CpCt_Plcy_RltInf");      
		turntable("CpCt_Plcy_Hist");        
		turntable("Idy_CrLn_Plcy");         
		turntable("Idy_CrLn_Plcy_Hist");    
		turntable("Plcy_Atch_Inf");         
		turntable("INST_INF_DPLT");         
		turntable("Cst_Bsc_Inf_Dplt");      
		turntable("EntpGrpAndCrG_Grp_Rel"); 
		turntable("MGrpCstMbrUnitInfDplt"); 
		turntable("MGrp_Cst_Mbr_Inf_Dplt"); 
		turntable("MGrp_CsInf_Dplt");       
		turntable("MGrpCstAdMUnitRelDplt"); 
		turntable("Ivsr_List");             
		turntable("CstIplNMgt_List");       
		turntable("CstIplNMgt_List_Hist");  

		
		
		//turntable("PDA_SYS_PARAM");
		/*
		turntable("PDA_DNLIST");
		turntable("PDA_FETCH_TABLE");
		turntable("PDA_FETCH_FIELD");
		turntable("PDA_CKLIST");
		turntable("PDA_MODULE");
		turntable("PDA_SYS_PARAM");
		turntable("PDA_SELFORM");
		turntable("PDA_VERCTL");
*/
//		turntable("t_log_activity");
//		turntable("t_log_notification");
//		turntable("t_log_sms");
		/*
		turntable("t_app");
		turntable("t_app_issue");
		turntable("t_channel_device");
		turntable("t_channel_user");
		turntable("t_code_item");
		turntable("t_code_table");
		turntable("t_device");
		turntable("t_device_app");
		turntable("t_msg_channel");
		turntable("t_msg_mediator");
		turntable("t_rpt_activity");
		turntable("t_rpt_activity30");
		turntable("t_rpt_notification");
		turntable("t_rpt_notification30");
		turntable("t_rpt_sms");
		turntable("t_rpt_sms30");
		turntable("t_service");
		turntable("t_service_acl");
		turntable("t_service_issue");
		turntable("t_sys_parameter");
		turntable("t_sys_user");
		*/
		/*
		EntityTable table1 = new EntityTable("t_app_issue");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table2 = new EntityTable("t_channel_device");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table3 = new EntityTable("t_channel_user");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table4 = new EntityTable("t_code_item");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table5 = new EntityTable("t_code_table");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table6 = new EntityTable("t_device");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table7 = new EntityTable("t_device_app");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table8 = new EntityTable("t_log_activity");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table9 = new EntityTable("t_log_notification");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table10 = new EntityTable("t_log_sms");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table11 = new EntityTable("t_msg_channel");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table12 = new EntityTable("t_msg_mediator");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table13 = new EntityTable("t_rpt_activity");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table14 = new EntityTable("t_rpt_activity30");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table15 = new EntityTable("t_rpt_notification");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table16 = new EntityTable("t_rpt_notification30");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table17 = new EntityTable("t_rpt_sms");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table18 = new EntityTable("t_rpt_sms30");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table19 = new EntityTable("t_service");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table20 = new EntityTable("t_service_acl");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table21 = new EntityTable("t_service_issue");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table22 = new EntityTable("t_sys_parameter");	//参数为 表名：tc_pick_after,子表对象：sub
		EntityTable table23 = new EntityTable("t_sys_user");	//参数为 表名：tc_pick_after,子表对象：sub
		*/
		//EntityTable table2 = new EntityTable("ST_COMAREA","SAREAID");	//参数为 表名：tc_pick_after,子表对象：sub
		//EntityTable table3 = new EntityTable("ST_COMSTORE","SSTOREID");	//参数为 表名：tc_pick_after,子表对象：sub

		//EntityTable sub = new EntityTable("tc_end_shipment_out", "result_group_id");//参数为 表名：tc_pick_after,外键:before_id（如果不是继承临时表实体，不需要指定）
		
		
		//生成表对应的PO，VO代码
		
		//gt(table2,true,false);
		//gt(table3,true,false);
		//生成表对应的PO，VO代码
		//gt(sub,true,true);
		
		open();
	}
	
	public static void turntable(String tablename)throws Exception{

		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		String root = props_CorpTotal.getProperty("root"); 
		String output = props_CorpTotal.getProperty("output"); 
		//String boname=getboclassbytable(tablename.substring(2));
		String boname=getboclassbytable(tablename);
		moduleName=boname.substring(0, 1).toLowerCase()+ boname.substring(1);
		EntityTable table = new EntityTable(tablename);	//参数为 表名：tc_pick_after,子表对象：sub
		
		gt(table,true,false);
		File srcfile,desfile;
        //srcfile = new File(output+"/error_zn_CN.properties");
        //desfile = new File(root+"/error_zh_CN.properties");
        srcfile = new File(output+"/CompareDataStru.txt");
        desfile = new File(root+"/CompareDataStru.txt");
		copyFile(srcfile, desfile);
		if(maketype.equals("1")){
			//deploypo(tablename);	
		} else if(maketype.equals("2")){
			//deployrop(tablename);	
		}		
	}
	
	/*
	public static void turntable(String tablename)throws Exception{

		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		String root = props_CorpTotal.getProperty("root"); 
		String output = props_CorpTotal.getProperty("output"); 
		//String boname=getboclassbytable(tablename.substring(2));
		String boname=getboclassbytable(tablename);
		moduleName=boname.substring(0, 1).toLowerCase()+ boname.substring(1);
		EntityTable table = new EntityTable(tablename);	//参数为 表名：tc_pick_after,子表对象：sub
		
		gt(table,true,false);
	
		File srcfile,desfile;
        //srcfile = new File(output+"/error_zn_CN.properties");
        //desfile = new File(root+"/error_zh_CN.properties");
        //srcfile = new File(output+"/CompareDataStru.txt");
        //desfile = new File(root+"/CompareDataStru.txt");
		//copyFile(srcfile, desfile);
		if(maketype.equals("1")){
			//deploypo(tablename);	
		} else if(maketype.equals("2")){
			//deployrop(tablename);	
		}		
	}
*/

	public static void deploypo(String tablename)throws Exception{
		String boname=getboclassbytable(tablename.substring(2));
		//String boname=getboclassbytable(tablename);
		moduleName=boname.substring(0, 1).toLowerCase()+ boname.substring(1);
        (new File("E:/mywork/cartan/cartan-core/src/main/java/com/cartan/core/" +moduleName+"/domain")).mkdirs();
        (new File("E:/mywork/cartan/cartan-core/src/main/java/com/cartan/core/" +moduleName+"/dao")).mkdirs();
        (new File("E:/mywork/cartan/cartan-core/src/main/java/com/cartan/core/" +moduleName+"/service")).mkdirs();
        (new File("E:/mywork/cartan/cartan-core/src/test/java/com/cartan/core")).mkdirs();
        (new File("E:/mywork/cartan/cartan-core/src/test/resources/com/cartan/core")).mkdirs();
        (new File("E:/mywork/cartan/cartan-core/src/test/resources/spring")).mkdirs();
		
        File srcfile = new File("E:/heip-generator-output/"+boname+".java");
        File desfile = new File("E:/mywork/cartan/cartan-core/src/main/java/com/cartan/core/" +moduleName+"/domain/" + boname+".java");
		copyFile(srcfile, desfile);
        //srcfile = new File("E:/heip-generator-output/"+boname+".mbt.xml");
        //desfile = new File("E:/MYDOC/PHONEGAP/program/SVN/Trunk/00.Coding/cartan/cartan-core/src/main/java/com/cartan/core/" +moduleName+"/dao/" + boname+".mbt.xml");
		//copyFile(srcfile, desfile);
		if (isNew.equals("1")){
			srcfile = new File("E:/heip-generator-output/"+boname+"VO.java");
	        desfile = new File("E:/mywork/cartan/cartan-core/src/main/java/com/cartan/core/" +moduleName+"/domain/" + boname+"VO.java");
			copyFile(srcfile, desfile);
	        srcfile = new File("E:/heip-generator-output/"+boname+"Mapper.java");
	        desfile = new File("E:/mywork/cartan/cartan-core/src/main/java/com/cartan/core/" +moduleName+"/dao/" + boname+"Mapper.java");
			copyFile(srcfile, desfile);	
	        srcfile = new File("E:/heip-generator-output/"+boname+"Service.java");
	        desfile = new File("E:/mywork/cartan/cartan-core/src/main/java/com/cartan/core/" +moduleName+"/service/" + boname+"Service.java");
			copyFile(srcfile, desfile);
	        srcfile = new File("E:/heip-generator-output/"+boname+"DaoTest.java");
	        desfile = new File("E:/mywork/cartan/cartan-core/src/test/java/com/cartan/core/" + boname+"DaoTest.java");
			copyFile(srcfile, desfile);
	        srcfile = new File("E:/heip-generator-output/"+boname+"DaoTest.xml");
	        desfile = new File("E:/mywork/cartan/cartan-core/src/test/resources/com/cartan/core/" + boname+"DaoTest.xml");
			copyFile(srcfile, desfile);
	        srcfile = new File("E:/heip-generator-output/"+boname+"Context.xml");
	        desfile = new File("E:/mywork/cartan/cartan-core/src/test/resources/spring/" + boname+"Context.xml");
			copyFile(srcfile, desfile);
		}
        srcfile = new File("E:/heip-generator-output/"+boname+"MapperBase.java");
        desfile = new File("E:/mywork/cartan/cartan-core/src/main/java/com/cartan/core/" +moduleName+"/dao/" + boname+"MapperBase.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"SqlProvider.java");
        desfile = new File("E:/mywork/cartan/cartan-core/src/main/java/com/cartan/core/" +moduleName+"/dao/" + boname+"SqlProvider.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"ServiceBase.java");
        desfile = new File("E:/mywork/cartan/cartan-core/src/main/java/com/cartan/core/" +moduleName+"/service/" + boname+"ServiceBase.java");
		copyFile(srcfile, desfile);
	}
	public static void deployrop(String tablename)throws Exception{
		//String boname=getboclassbytable(tablename);
		String boname=getboclassbytable(tablename.substring(2));
		moduleName=boname.substring(0, 1).toLowerCase()+ boname.substring(1);
		(new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName)).mkdirs();
		(new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/request")).mkdirs();
		(new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/response")).mkdirs();
		(new File("E:/mywork/cartan/cartan-center/src/test/java/com/cartan/center/ebs/" +moduleName)).mkdirs();
		(new File("E:/mywork/cartan/cartan-center/src/main/resources/rop/i18n")).mkdirs();
		File srcfile,desfile;
		if (isNew.equals("1")){
		srcfile = new File("E:/heip-generator-output/"+boname+"CreateRequest.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/request/" + boname+"CreateRequest.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"UpdateRequest.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/request/" + boname+"UpdateRequest.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"DeleteRequest.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/request/" + boname+"DeleteRequest.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"SelectRequest.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/request/" + boname+"SelectRequest.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"GetSessionRequest.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/request/" + boname+"GetSessionRequest.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"GetRequest.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/request/" + boname+"GetRequest.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"SelectAllRequest.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/request/" + boname+"SelectAllRequest.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"CountAllRequest.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/request/" + boname+"CountAllRequest.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"GetSessionResponse.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/response/" + boname+"GetSessionResponse.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"CreateResponse.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/response/" + boname+"CreateResponse.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"DeleteResponse.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/response/" + boname+"DeleteResponse.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"UpdateResponse.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/response/" + boname+"UpdateResponse.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"GetResponse.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/response/" + boname+"GetResponse.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"SelectAllResponse.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/response/" + boname+"SelectAllResponse.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"CountAllResponse.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/response/" + boname+"CountAllResponse.java");
		copyFile(srcfile, desfile);
        srcfile = new File("E:/heip-generator-output/"+boname+"SelectResponse.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/response/" + boname+"SelectResponse.java");
		copyFile(srcfile, desfile);
		srcfile = new File("E:/heip-generator-output/"+boname+"ServiceEbs.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/" + boname+"ServiceEbs.java");
		copyFile(srcfile, desfile);
		srcfile = new File("E:/heip-generator-output/"+boname+"ServiceEbsIT.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/test/java/com/cartan/center/ebs/" +moduleName+"/" + boname+"ServiceEbsIT.java");
		copyFile(srcfile, desfile);
		srcfile = new File("E:/heip-generator-output/"+boname+"ServiceEbsBase.java");
        desfile = new File("E:/mywork/cartan/cartan-center/src/main/java/com/cartan/center/ebs/" +moduleName+"/" + boname+"ServiceEbsBase.java");
		copyFile(srcfile, desfile);
		}
//
//        srcfile = new File("E:/heip-generator-output/error_zn_CN.properties");
//        desfile = new File("E:/MYDOC/PHONEGAP/program/SVN/Trunk/00.Coding/cartan/cartan-center/src/main/resources/rop/i18n/error_zh_CN.properties");
//		copyFile(srcfile, desfile);
	}
	
    public static void clearDir(String sourceDirPath) throws IOException {
        File[] file = (new File(sourceDirPath)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
            	file[i].delete();
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
	///////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////
	
	public EntityCodeGenerator(){}
	
	/**
	 * 
	 * @param table
	 * @param seqFlg  PO是否使用Hibernate自动生成sequece
	 * @param temFlag VO实体是否继承临时表
	 * @throws Exception
	 */
	public static void gt(EntityTable table,boolean seqFlg,boolean temFlag) throws Exception{
		EntityGenerator eg = new EntityGenerator(moduleName);

		if(maketype.equals("1")){
			eg.generatorPO(new EntityTable[]{table}, seqFlg);
		} else if(maketype.equals("2")){
			eg.generatorVO(new EntityTable[]{table}, temFlag);
		}
	}
	
}
