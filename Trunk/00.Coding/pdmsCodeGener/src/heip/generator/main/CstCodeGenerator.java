package heip.generator.main;

import heip.generator.entity.EntityTable;
import heip.generator.generer.CstGenerator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.org.rapid_framework.generator.GeneratorProperties;



/**
 * 请使用具体的单表，多表生成器来生成实体
 * 实体代码生成器
 * 
 * @author HSWHM
 * 
 */
@Deprecated
public class CstCodeGenerator extends BaseAbstractCodeGenerator {
 
	private static String sysname = "gxy";//子系统名称
	private static String moduleName = "train";//模块
	private static String username = "gxy";//生成内容 1:po;2:vo
	private static String templateType = "8";//模板类型 1:仓库管理;2:主数据管理
	private static String projectName = "gxy";//项目名称 jfgl:积分管理;pdqc:成品外观检查

	public static void main(String[] args)throws Exception{
		/**
		 * 注意：如果VO继承临时表需要指定外键字段
		 * 一张表一张表生成，不用设置父子关系
		 */
		if ((null!=args)&(args.length>0)) {
			username=args[0].trim();
		} 		
		if ((null!=args)&(args.length>1)) {
			moduleName=args[1].trim();
		} 		
		System.out.print(username);
		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		String deployPath = props_CorpTotal.getProperty("deployPath"); 
		String root = props_CorpTotal.getProperty("root"); 
		clearDir(deployPath+username+"/code/");
		delDir(deployPath+username+"/output/");
		String tablelist = props_CorpTotal.getProperty("tablelist"); 
		String sysname = props_CorpTotal.getProperty("sysname"); 
		templateType=props_CorpTotal.getProperty("templateType"); 
		projectName=props_CorpTotal.getProperty("projectName"); 
		String tables[] = tablelist.split(";");
		String tablename="";
		String tabledes="";
		String pageSize="";
		String parentTableName="";
		String noParent="";
		String IsNewBsclass="";
		String templatePath=deployPath+username+"/template";	
		if ((!username.equals("liuxb"))){
			templatePath=deployPath+"common/"+projectName;	
		}
		GeneratorProperties.setProperty("outRoot", deployPath+username+"/code/");
		for(String splittable:tables){	
			String[] field = splittable.split(":");
			if (field.length>0)
			 tablename=field[0];
			if (field.length>1)
				tabledes=field[1];		
			if (field.length>2)
				pageSize=field[2];	
			if (field.length>3)
				parentTableName=field[3];		
			if (field.length>4)
				noParent=field[4];	
			if (field.length>5)
				IsNewBsclass=field[5];		
			turntable(tablename,IsNewBsclass,parentTableName,templatePath);
			
		}		
		/*
	
        StringBuffer content=new StringBuffer();


        content.append("<%@ page language='java' contentType='text/html; charset=UTF-8'\r\n");
        content.append("    pageEncoding='UTF-8'%>\r\n");
		content.append("<%@include file='/common/taglibs.jsp' %>\r\n");
		content.append("<html>\r\n");
		content.append("<head>\r\n");
		content.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\r\n");
		content.append("<script src='${ctx}/resources/js/jquery-easyui-1.4.4/jquery.min.js'></script>\r\n");
		content.append("<script src='${ctx}/resources/js/jquery-easyui-1.4.4/json2.js'></script>\r\n");
		content.append("<title>测试页</title>\r\n");
		content.append("</head>\r\n");
		content.append("<body>\r\n");
		for(String splittable:tables){	
			String[] field = splittable.split(":");
			if (field.length>0)
			 tablename=field[0];
			if (field.length>1)
				tabledes=field[1];		
			if (field.length>2)
				pageSize=field[2];	
			if (field.length>3)
				parentTableName=field[3];		
			if (field.length>4)
				noParent=field[4];	
			if (field.length>5)
				IsNewBsclass=field[5];		
			turntable(tablename,IsNewBsclass,parentTableName,templatePath);
			content.append("<br>");
			content.append("<a href='http://localhost:8092/"+sysname+"/content/test/"+moduleName+"/"+getboclassbytable(tablename.substring(3))+".jsp' target='_blank'>"+tabledes+"</a>\r\n");

		}		
		content.append("</body>");
		content.append("</html>");

		if (templateType.equals("1")||templateType.equals("2")){	
	        try {
	        	
	            Writefile("C:\\deploy\\"+username+"\\output\\"+sysname+"\\src\\main\\webapp\\content\\test\\"+moduleName+".jsp",content.toString());
	        } catch (IOException e) {
	            e.printStackTrace();  
	        }
		}
		
		*/
		List<File> files=ZipUtils.getFileList(deployPath+username+"/code/");
		(new File(root+"cartan-center/src/main/web/code")).mkdirs();
		clearDir(root+"cartan-center/src/main/web/code/");
		for (int i=0;i<files.size();i++){
			File srcfile,desfile;
			srcfile = new File(deployPath+username+"/code/"+files.get(i).getName());
	        desfile = new File(root+"cartan-center/src/main/web/code/"+files.get(i).getName());
			copyFile(srcfile, desfile);
		}
		clearDir(deployPath+username+"/zip/");
		SimpleDateFormat df = new SimpleDateFormat("(yyyy年MM月dd日HH点mm分ss秒)");//设置日期格式
		FileOutputStream fos1 = new FileOutputStream(new File(deployPath+username+"/zip/"+df.format(new Date())+moduleName+".zip"));
		ZipUtils.toZip(deployPath+username+"/output/", fos1,true);
		List<File> files1=ZipUtils.getFileList(deployPath+username+"/zip/");
		(new File(root+"cartan-center/src/main/web/zip")).mkdirs();
		for (int i=0;i<files1.size();i++){
			File srcfile,desfile;
			srcfile = new File(deployPath+username+"/zip/"+files1.get(i).getName());
	        desfile = new File(root+"cartan-center/src/main/web/zip/"+files1.get(i).getName());
			copyFile(srcfile, desfile);
		}
		//open();
		System.exit(0);
	}

    public static void Writefile(String fileName, String content) throws IOException{
        File file=new File(fileName);
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,false);
        StringBuffer sb=new StringBuffer();
        sb.append(content);
        out.write(sb.toString().getBytes("utf-8"));
        out.close();
    }

	public static void delDir(String filepath) throws IOException{
		File f = new File(filepath);//定义文件路径
		if(f.exists() && f.isDirectory()){//判断是文件还是目录
		   if(f.listFiles().length==0){//若目录下没有文件则直接删除
		        f.delete();
		    }else{//若有则把文件放进数组，并判断是否有下级目录
		        File delFile[]=f.listFiles();
		        int i =f.listFiles().length;
		        for(int j=0;j<i;j++){
		           if(delFile[j].isDirectory()){
		        	   delDir(delFile[j].getAbsolutePath());
		           }
		           delFile[j].delete();
		        }
		        }
		   }
		}
	
	public static void turntable(String tablename,String IsNewBsclass,String parentTableName,String templatePath)throws Exception{

		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		String root = props_CorpTotal.getProperty("root"); 
		String output = props_CorpTotal.getProperty("output"); 
		String boname=getboclassbytable(tablename.substring(3));
		moduleName=props_CorpTotal.getProperty("moduleName"); 
			//boname.substring(0, 1).toLowerCase()+ boname.substring(1);
		EntityTable table = new EntityTable(tablename);	//参数为 表名：tc_pick_after,子表对象：sub
		
		gt(table,templatePath);
		deploy(tablename,IsNewBsclass,parentTableName);	
	/*
		File srcfile,desfile;
		if(maketype.equals("1")){
			deploypo(tablename);	
		} else if(maketype.equals("2")){
			deployrop(tablename);
		}else if(maketype.equals("3")){		
			deployJSP(tablename);				
		}
		*/
	}

	public static void deploy(String tablename,String IsNewBsclass,String parentTableName)throws Exception{
		FileProperties props_CorpTotal = new FileProperties("/config.properties");	
		String deployPath = props_CorpTotal.getProperty("deployPath"); 
		moduleName = props_CorpTotal.getProperty("moduleName");  
		projectName=props_CorpTotal.getProperty("projectName");
		templateType=props_CorpTotal.getProperty("templateType");
		String sysname = props_CorpTotal.getProperty("sysname");  
		String templatelist = props_CorpTotal.getProperty("templatelist");  
		String basepackage = props_CorpTotal.getProperty("basepackage");  

		String dirstr= basepackage.replace(".", "/");
		
		String outpath = deployPath+username+"/output/"; 
		//String boname=getboclassbytable(tablename.substring(3));
		String boname=getboclassbytable(tablename);
		String frontchar="";
		if (frontchar.equals("diyou")){
			frontchar=tablename.substring(0, 5);
		}
		if (templateType.equals("9")){	
			boname=getboclassbytable(tablename.substring(6));
			String tlist[] = templatelist.split(";");
			for(String splitfield:tlist){
				String[] field = splitfield.split(":");
				String templatename=field[0];
				String templatedir=field[1];
				(new File(outpath+templatedir)).mkdirs();
				File srcfile,desfile;
				srcfile = new File(deployPath+username+"/code/"+templatename.replace("${className}", boname));
		        desfile = new File(outpath+templatedir+templatename.replace("${className}", boname));
				copyFile(srcfile, desfile);
			}
			
//			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/controller/")).mkdirs();
//			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/controller/base/")).mkdirs();
//			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/dao/" + moduleName+"/")).mkdirs();
//			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/pojo/" + moduleName+"/")).mkdirs();
//			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/")).mkdirs();
//			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/base/")).mkdirs();
//			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/impl/")).mkdirs();
//			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/impl/base/")).mkdirs();
//			(new File(outpath+sysname+"/src/main/resources/mybatis/"+dirstr+"/dao/")).mkdirs();
//			File srcfile,desfile;
//
//
//			srcfile = new File(deployPath+username+"/code/"+boname+".java");
//	        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/pojo/" + moduleName+"/"+boname+".java");
//			copyFile(srcfile, desfile);
//			srcfile = new File(deployPath+username+"/code/"+boname+"Dao.java");
//	        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/dao/" + moduleName+"/"+boname+"Dao.java");
//			copyFile(srcfile, desfile);
//			srcfile = new File(deployPath+username+"/code/"+boname+"Dao.xml");
//	        desfile = new File(outpath+sysname+"/src/main/resources/mybatis/"+dirstr+"/dao/"+boname+"Dao.xml");
//			copyFile(srcfile, desfile);
			

		} else if (templateType.equals("8")){	
			(new File(outpath+boname+"/")).mkdirs();

			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/controller/")).mkdirs();
			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/controller/base/")).mkdirs();
			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/dao/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/pojo/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/")).mkdirs();
			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/base/")).mkdirs();
			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/impl/")).mkdirs();
			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/impl/base/")).mkdirs();
			(new File(outpath+sysname+"/src/main/resources/mybatis/"+dirstr+"/dao/")).mkdirs();
			File srcfile,desfile;

			srcfile = new File(deployPath+username+"/code/"+boname+"navigate.js");
	        desfile = new File(outpath+boname+"/"+boname+"navigate.js");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+"navigate.json");
	        desfile = new File(outpath+boname+"/"+boname+"navigate.json");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+"navigate.wxml");
	        desfile = new File(outpath+boname+"/"+boname+"navigate.wxml");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+"navigate.wxss");
	        desfile = new File(outpath+boname+"/"+boname+"navigate.wxss");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+".js");
	        desfile = new File(outpath+boname+"/"+boname+".js");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+".json");
	        desfile = new File(outpath+boname+"/"+boname+".json");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+".wxml");
	        desfile = new File(outpath+boname+"/"+boname+".wxml");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+".wxss");
	        desfile = new File(outpath+boname+"/"+boname+".wxss");
			copyFile(srcfile, desfile);
			
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerBase.java");
	        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/controller/base/"+boname+"ControllerBase.java");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceBase.java");
	        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/base/"+boname+"ServiceBase.java");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplBase.java");
	        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/impl/base/"+boname+"ServiceImplBase.java");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+".java");
	        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/pojo/" + moduleName+"/"+boname+".java");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+"Dao.java");
	        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/dao/" + moduleName+"/"+boname+"Dao.java");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/"+boname+"Dao.xml");
	        desfile = new File(outpath+sysname+"/src/main/resources/mybatis/"+dirstr+"/dao/"+boname+"Dao.xml");
			copyFile(srcfile, desfile);
			
			if (IsNewBsclass.equals("1")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Controller.java");
		        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/controller/"+boname+"Controller.java");
				copyFile(srcfile, desfile);
				srcfile = new File(deployPath+username+"/code/"+boname+"Service.java");
		        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/"+boname+"Service.java");
				copyFile(srcfile, desfile);
				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImpl.java");
		        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/service/impl/"+boname+"ServiceImpl.java");
				copyFile(srcfile, desfile);
			}

		} else if (templateType.equals("1")){
			(new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/")).mkdirs();
			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/web/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+"kcgl-common/src/main/resources/mybatis/oracle")).mkdirs();
			(new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/pojo/")).mkdirs();
			(new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/")).mkdirs();
			(new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/")).mkdirs();
			(new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/")).mkdirs();
			(new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/")).mkdirs();
			(new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/")).mkdirs();
			File srcfile,desfile;

			srcfile = new File(deployPath+username+"/code/common.js");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/common.js");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/Utils.js");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/Utils.js");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+".jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+".jsp");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"Add.jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+"Add.jsp");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"IB.jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+"IB.jsp");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"AddIB.jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+"AddIB.jsp");
			copyFile(srcfile, desfile);
			
			if (IsNewBsclass.equals("1")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Controller.java");
		        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"Controller.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"ControllerIB.java");
		        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"ControllerIB.java");
				copyFile(srcfile, desfile);			

				srcfile = new File(deployPath+username+"/code/"+boname+"ControllerTest.java");
		        desfile = new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"ControllerTest.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+".java");
		        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/pojo/"+boname+".java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"Dao.java");
		        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/"+boname+"Dao.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"DaoIB.java");
		        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/"+boname+"DaoIB.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"DaoImpl.java");
		        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/"+boname+"DaoImpl.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplIB.java");
		        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/"+boname+"DaoImplIB.java");
				copyFile(srcfile, desfile);
				

				srcfile = new File(deployPath+username+"/code/"+boname+"Service.java");
		        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"Service.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceIB.java");
		        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"ServiceIB.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImpl.java");
		        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/"+boname+"ServiceImpl.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplIB.java");
		        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/"+boname+"ServiceImplIB.java");
				copyFile(srcfile, desfile);
				
			}

			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerBase.java");
	        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/"+boname+"ControllerBase.java");
			copyFile(srcfile, desfile);		

			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerIBBase.java");
	        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/"+boname+"ControllerIBBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerBaseTest.java");
	        desfile = new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"ControllerBaseTest.java");
			copyFile(srcfile, desfile);		

			srcfile = new File(deployPath+username+"/code/"+boname+"Mapper.xml");
	        desfile = new File(outpath+"kcgl-common/src/main/resources/mybatis/oracle/"+boname+"Mapper.xml");
			copyFile(srcfile, desfile);
			if (parentTableName.equals("")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Base.java");
		        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/pojo/"+boname+"Base.java");
				copyFile(srcfile, desfile);			
			}
					
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoBase.java");
	        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/"+boname+"DaoBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoIBBase.java");
	        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/"+boname+"DaoIBBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplBase.java");
	        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/"+boname+"DaoImplBase.java");
			copyFile(srcfile, desfile);		
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplIBBase.java");
	        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/"+boname+"DaoImplIBBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceBase.java");
	        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"ServiceBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceIBBase.java");
	        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"ServiceIBBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplBase.java");
	        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/"+boname+"ServiceImplBase.java");
			copyFile(srcfile, desfile);		
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplIBBase.java");
	        desfile = new File(outpath+"kcgl-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/"+boname+"ServiceImplIBBase.java");
			copyFile(srcfile, desfile);	
			
		} else if (templateType.equals("2")){

			(new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/")).mkdirs();
			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/web/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/resources/mybatis/oracle")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/resources/mybatis/oracle/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/resources/mybatis/oracle/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/base/")).mkdirs();
			File srcfile,desfile;

			srcfile = new File(deployPath+username+"/code/common.js");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/common.js");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/Utils.js");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/Utils.js");
			copyFile(srcfile, desfile);
/*
			srcfile = new File("D:/deploy/"+username+"/code/HandlerAdapter.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/HandlerAdapter.java");
			copyFile(srcfile, desfile);
*/
			srcfile = new File(deployPath+username+"/code/"+boname+".jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+".jsp");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"Add.jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+"Add.jsp");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"IB.jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+"IB.jsp");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"AddIB.jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+"AddIB.jsp");
			copyFile(srcfile, desfile);
			
			if (IsNewBsclass.equals("1")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Controller.java");
		        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"Controller.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"ControllerIB.java");
		        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"ControllerIB.java");
				copyFile(srcfile, desfile);			

				srcfile = new File(deployPath+username+"/code/"+boname+"ControllerTest.java");
		        desfile = new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"ControllerTest.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+".java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/"+ moduleName+"/"+boname+".java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"View.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/"+ moduleName+"/"+boname+"View.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ViewMapper.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/"+ moduleName+"/"+boname+"ViewMapper.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"Dao.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/"+boname+"Dao.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"DaoIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/"+boname+"DaoIB.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"DaoImpl.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/"+boname+"DaoImpl.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/"+boname+"DaoImplIB.java");
				copyFile(srcfile, desfile);
				

				//if (parentTableName.equals("")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Service.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"Service.java");
				copyFile(srcfile, desfile);
				//}

				if (!parentTableName.equals("")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Handler.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"Handler.java");
				copyFile(srcfile, desfile);
				}
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"ServiceIB.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImpl.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/"+boname+"ServiceImpl.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/"+boname+"ServiceImplIB.java");
				copyFile(srcfile, desfile);
				
			}

			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/base/"+boname+"ControllerBase.java");
			copyFile(srcfile, desfile);		

			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/base/"+boname+"ControllerIBBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerBaseTest.java");
	        desfile = new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/base/"+boname+"ControllerBaseTest.java");
			copyFile(srcfile, desfile);		

			srcfile = new File(deployPath+username+"/code/"+boname+"Mapper.xml");
	        desfile = new File(outpath+projectName+"-common/src/main/resources/mybatis/oracle/"+ moduleName+"/base/"+boname+"Mapper.xml");
			copyFile(srcfile, desfile);
			//if (parentTableName.equals("")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Base.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/"+ moduleName+"/base/"+boname+"Base.java");
				copyFile(srcfile, desfile);			
			//}
			srcfile = new File(deployPath+username+"/code/"+boname+"ViewBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/"+ moduleName+"/base/"+boname+"ViewBase.java");
			copyFile(srcfile, desfile);			
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ViewBaseMapper.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/"+ moduleName+"/base/"+boname+"ViewBaseMapper.java");
			copyFile(srcfile, desfile);			
					
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/base/"+boname+"DaoBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/base/"+boname+"DaoIBBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/base/"+boname+"DaoImplBase.java");
			copyFile(srcfile, desfile);		
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/base/"+boname+"DaoImplIBBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/base/"+boname+"ServiceBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/base/"+boname+"ServiceIBBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/base/"+boname+"ServiceImplBase.java");
			copyFile(srcfile, desfile);		
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/base/"+boname+"ServiceImplIBBase.java");
			copyFile(srcfile, desfile);	
			

			

		} else if (templateType.equals("3")){			
			(new File(outpath+sysname+"/web/content/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/web/content/" + moduleName+"/js/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/web/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/web/controller/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/web/mapper/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/web/mapper/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/web/view/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/web/view/" + moduleName+"/base/")).mkdirs();			
			(new File(outpath+sysname+"/src/"+dirstr+"/pojo/" + moduleName)).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/pojo/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/service/" + moduleName)).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/service/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/service/" + moduleName+"/impl/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/service/" + moduleName+"/impl/base/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/dao/" + moduleName)).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/dao/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/dao/" + moduleName+"/impl/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/dao/" + moduleName+"/impl/base/")).mkdirs();
			(new File(outpath+sysname+"/src/"+dirstr+"/util/")).mkdirs();				
			(new File(outpath+sysname+"/test/"+dirstr+"/web/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/test/"+dirstr+"/web/controller/" + moduleName+"/base/")).mkdirs();			
			File srcfile,desfile;

			srcfile = new File(deployPath+username+"/code/"+boname+".jsp");
	        desfile = new File(outpath+sysname+"/web/content/" + moduleName+"/"+boname+".jsp");
			copyFile(srcfile, desfile);
						
			srcfile = new File(deployPath+username+"/code/"+boname+"center.jsp");
	        desfile = new File(outpath+sysname+"/web/content/" + moduleName+"/"+boname+"center.jsp");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/js"+boname+".jsp");
	        desfile = new File(outpath+sysname+"/web/content/" + moduleName+"/js/js"+boname+".jsp");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/Constants.java");
	        desfile = new File(outpath+sysname+"/src/"+dirstr+"/util/Constants.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/ContextUtils.java");
	        desfile = new File(outpath+sysname+"/src/"+dirstr+"/util/ContextUtils.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/ResultInfo.java");
	        desfile = new File(outpath+sysname+"/src/"+dirstr+"/util/ResultInfo.java");
			copyFile(srcfile, desfile);			
			
			if (IsNewBsclass.equals("1")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Controller.java");
		        desfile = new File(outpath+sysname+"/src/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"Controller.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"ControllerTest.java");
		        desfile = new File(outpath+sysname+"/test/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"ControllerTest.java");
				copyFile(srcfile, desfile);				

				srcfile = new File(deployPath+username+"/code/"+boname+"View.java");
		        desfile = new File(outpath+sysname+"/src/"+dirstr+"/web/view/" + moduleName+"/"+boname+"View.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ViewMapper.java");
		        desfile = new File(outpath+sysname+"/src/"+dirstr+"/web/mapper/" + moduleName+"/"+boname+"ViewMapper.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"Service.java");
		        desfile = new File(outpath+sysname+"/src/"+dirstr+"/service/" + moduleName+"/"+boname+"Service.java");
				copyFile(srcfile, desfile);				

				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImpl.java");
		        desfile = new File(outpath+sysname+"/src/"+dirstr+"/service/" + moduleName+"/impl/"+boname+"ServiceImpl.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"Dao.java");
		        desfile = new File(outpath+sysname+"/src/"+dirstr+"/dao/" + moduleName+"/"+boname+"Dao.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"DaoImpl.java");
		        desfile = new File(outpath+sysname+"/src/"+dirstr+"/dao/" + moduleName+"/impl/"+boname+"DaoImpl.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+".java");
		        desfile = new File(outpath+sysname+"/src/"+dirstr+"/pojo/" + moduleName+"/"+boname+".java");
				copyFile(srcfile, desfile);

			}
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerBase.java");
	        desfile = new File(outpath+sysname+"/src/"+dirstr+"/web/controller/" + moduleName+"/base/"+boname+"ControllerBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerBaseTest.java");
	        desfile = new File(outpath+sysname+"/test/"+dirstr+"/web/controller/" + moduleName+"/base/"+boname+"ControllerBaseTest.java");
			copyFile(srcfile, desfile);				

			srcfile = new File(deployPath+username+"/code/"+boname+"ViewBase.java");
	        desfile = new File(outpath+sysname+"/src/"+dirstr+"/web/view/" + moduleName+"/base/"+boname+"ViewBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ViewMapperBase.java");
	        desfile = new File(outpath+sysname+"/src/"+dirstr+"/web/mapper/" + moduleName+"/base/"+boname+"ViewMapperBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceBase.java");
	        desfile = new File(outpath+sysname+"/src/"+dirstr+"/service/" + moduleName+"/base/"+boname+"ServiceBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplBase.java");
	        desfile = new File(outpath+sysname+"/src/"+dirstr+"/service/" + moduleName+"/impl/base/"+boname+"ServiceImplBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoBase.java");
	        desfile = new File(outpath+sysname+"/src/"+dirstr+"/dao/" + moduleName+"/base/"+boname+"DaoBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplBase.java");
	        desfile = new File(outpath+sysname+"/src/"+dirstr+"/dao/" + moduleName+"/impl/base/"+boname+"DaoImplBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"Base.java");
	        desfile = new File(outpath+sysname+"/src/"+dirstr+"/pojo/" + moduleName+"/base/"+boname+"Base.java");
			copyFile(srcfile, desfile);
		} else if(templateType.equals("5")){

			/*
			(new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/")).mkdirs();
			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/web/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/base/")).mkdirs();
			*/
			(new File(outpath+projectName+"-common/src/main/resources/oracle")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/resources/oracle/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/resources/oracle/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/resources/templates")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/resources/templates/content/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/resources/templates/content/"+ moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/" + moduleName+"/base/")).mkdirs();
			/*
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/" + moduleName+"/base/")).mkdirs();
			*/
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/base/")).mkdirs();
			/*
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/base/")).mkdirs();
			*/
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/base/")).mkdirs();
			
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/base/")).mkdirs();
			File srcfile,desfile;
			/*
			srcfile = new File(deployPath+username+"/code/common.js");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/common.js");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/Utils.js");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/Utils.js");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"IB.jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+"IB.jsp");
			copyFile(srcfile, desfile);
			
			*/

			srcfile = new File(deployPath+username+"/code/"+boname+".jsp");
	        desfile = new File(outpath+projectName+"-common/src/main/resources/templates/content/" + moduleName+"/"+boname+".ftl");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"Add.jsp");
	        desfile = new File(outpath+projectName+"-common/src/main/resources/templates/content/" + moduleName+"/"+boname+"Add.ftl");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"AddIB.jsp");
	        desfile = new File(outpath+projectName+"-common/src/main/resources/templates/content/" + moduleName+"/"+boname+"AddIB.ftl");
			copyFile(srcfile, desfile);
			
			if (IsNewBsclass.equals("1")){
				/*
				srcfile = new File(deployPath+username+"/code/"+boname+"Controller.java");
		        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"Controller.java");
				copyFile(srcfile, desfile);


				srcfile = new File(deployPath+username+"/code/"+boname+"ControllerTest.java");
		        desfile = new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"ControllerTest.java");
				copyFile(srcfile, desfile);
				*/
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ControllerIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/"+boname+"ControllerIB.java");
				copyFile(srcfile, desfile);			
				
				srcfile = new File(deployPath+username+"/code/"+boname+".java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/"+ moduleName+"/"+boname+".java");
				copyFile(srcfile, desfile);
				/*
				srcfile = new File(deployPath+username+"/code/"+boname+"View.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/"+ moduleName+"/"+boname+"View.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ViewMapper.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/"+ moduleName+"/"+boname+"ViewMapper.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"Dao.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/"+boname+"Dao.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"DaoIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/"+boname+"DaoIB.java");
				copyFile(srcfile, desfile);
				*/
				srcfile = new File(deployPath+username+"/code/"+boname+"Mapper.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/" + moduleName+"/"+boname+"Mapper.java");
				copyFile(srcfile, desfile);
				/*
				srcfile = new File(deployPath+username+"/code/"+boname+"DaoImpl.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/"+boname+"DaoImpl.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/"+boname+"DaoImplIB.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"Service.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"Service.java");
				copyFile(srcfile, desfile);

				if (!parentTableName.equals("")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Handler.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"Handler.java");
				copyFile(srcfile, desfile);
				}
				

				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImpl.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/"+boname+"ServiceImpl.java");
				copyFile(srcfile, desfile);
				
				*/
				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"ServiceIB.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/"+boname+"ServiceImplIB.java");
				copyFile(srcfile, desfile);
			}
			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/base/"+boname+"ControllerIBBase.java");
			copyFile(srcfile, desfile);
			
			/*
			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/base/"+boname+"ControllerBase.java");
			copyFile(srcfile, desfile);		


			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerBaseTest.java");
	        desfile = new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/base/"+boname+"ControllerBaseTest.java");
			copyFile(srcfile, desfile);		
			*/
			srcfile = new File(deployPath+username+"/code/"+boname+"Mapper.xml");
	        desfile = new File(outpath+projectName+"-common/src/main/resources/oracle/"+ moduleName+"/base/"+boname+"Mapper.xml");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"Base.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/"+ moduleName+"/base/"+boname+"Base.java");
			copyFile(srcfile, desfile);
			/*
			srcfile = new File(deployPath+username+"/code/"+boname+"ViewBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/"+ moduleName+"/base/"+boname+"ViewBase.java");
			copyFile(srcfile, desfile);			
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ViewBaseMapper.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/"+ moduleName+"/base/"+boname+"ViewBaseMapper.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/base/"+boname+"DaoBase.java");
			copyFile(srcfile, desfile);
			*/
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/base/"+boname+"DaoIBBase.java");
			copyFile(srcfile, desfile);

			/*
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/base/"+boname+"DaoImplBase.java");
			copyFile(srcfile, desfile);		
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/base/"+boname+"DaoImplIBBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/base/"+boname+"ServiceBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/base/"+boname+"ServiceImplBase.java");
			copyFile(srcfile, desfile);		
			
			*/
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/base/"+boname+"ServiceIBBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/base/"+boname+"ServiceImplIBBase.java");
			copyFile(srcfile, desfile);	
		} else if (templateType.equals("6")){
			if (frontchar.equals("diyou")){
				boname=getboclassbytable(tablename.substring(6));
			}
			
			(new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/")).mkdirs();
			//(new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/")).mkdirs();
			(new File(outpath+sysname+"/src/main/java/"+dirstr+"/web/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/resources/mybatis/oracle")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/resources/mybatis/oracle/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/resources/mybatis/oracle/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/base/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/")).mkdirs();
			(new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/base/")).mkdirs();
			(new File(outpath+projectName+"-mobile/src/main/java/"+dirstr+"/rest/controller/" + moduleName+"/")).mkdirs();
			File srcfile,desfile;
/*
			srcfile = new File(deployPath+username+"/code/common.js");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/common.js");
			copyFile(srcfile, desfile);
			srcfile = new File(deployPath+username+"/code/Utils.js");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/js/Utils.js");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+".jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+".jsp");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"Add.jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+"Add.jsp");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"View.jsp");
	        desfile = new File(outpath+sysname+"/src/main/webapp/content/test/" + moduleName+"/"+boname+"View.jsp");
			copyFile(srcfile, desfile);
			*/
			if (IsNewBsclass.equals("1")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Controller.java");
		        desfile = new File(outpath+sysname+"/src/main/java/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"Controller.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"ControllerIB.java");
		        desfile = new File(outpath+projectName+"-mobile/src/main/java/"+dirstr+"/rest/controller/" + moduleName+"/"+boname+"ControllerIB.java");
				copyFile(srcfile, desfile);			

				srcfile = new File(deployPath+username+"/code/"+boname+"ControllerTest.java");
		        desfile = new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/"+boname+"ControllerTest.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+".java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/"+ moduleName+"/"+boname+".java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"View.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/"+ moduleName+"/"+boname+"View.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ViewMapper.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/"+ moduleName+"/"+boname+"ViewMapper.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"Dao.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/"+boname+"Dao.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"DaoIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/"+boname+"DaoIB.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"DaoImpl.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/"+boname+"DaoImpl.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/"+boname+"DaoImplIB.java");
				copyFile(srcfile, desfile);
				

				//if (parentTableName.equals("")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Service.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"Service.java");
				copyFile(srcfile, desfile);
				//}

				if (!parentTableName.equals("")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Handler.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"Handler.java");
				copyFile(srcfile, desfile);
				}
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/"+boname+"ServiceIB.java");
				copyFile(srcfile, desfile);

				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImpl.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/"+boname+"ServiceImpl.java");
				copyFile(srcfile, desfile);
				
				srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplIB.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/"+boname+"ServiceImplIB.java");
				copyFile(srcfile, desfile);
				
			}

			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/base/"+boname+"ControllerBase.java");
			copyFile(srcfile, desfile);		

			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/controller/" + moduleName+"/base/"+boname+"ControllerIBBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"ControllerBaseTest.java");
	        desfile = new File(outpath+sysname+"/src/test/java/"+dirstr+"/web/controller/" + moduleName+"/base/"+boname+"ControllerBaseTest.java");
			copyFile(srcfile, desfile);		
			
			srcfile = new File(deployPath+username+"/code/"+boname+"Mapper.xml");
	        desfile = new File(outpath+projectName+"-common/src/main/resources/mybatis/oracle/"+ moduleName+"/base/"+boname+"Mapper.xml");
			copyFile(srcfile, desfile);
			
			//if (parentTableName.equals("")){
				srcfile = new File(deployPath+username+"/code/"+boname+"Base.java");
		        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/pojo/"+ moduleName+"/base/"+boname+"Base.java");
				copyFile(srcfile, desfile);			
			//}
			srcfile = new File(deployPath+username+"/code/"+boname+"ViewBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/view/"+ moduleName+"/base/"+boname+"ViewBase.java");
			copyFile(srcfile, desfile);			
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ViewBaseMapper.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/mapper/"+ moduleName+"/base/"+boname+"ViewBaseMapper.java");
			copyFile(srcfile, desfile);			
					
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/base/"+boname+"DaoBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/base/"+boname+"DaoIBBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/base/"+boname+"DaoImplBase.java");
			copyFile(srcfile, desfile);		
			
			srcfile = new File(deployPath+username+"/code/"+boname+"DaoImplIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/dao/" + moduleName+"/impl/base/"+boname+"DaoImplIBBase.java");
			copyFile(srcfile, desfile);

			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/base/"+boname+"ServiceBase.java");
			copyFile(srcfile, desfile);
		
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/base/"+boname+"ServiceIBBase.java");
			copyFile(srcfile, desfile);
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/base/"+boname+"ServiceImplBase.java");
			copyFile(srcfile, desfile);		
			
			srcfile = new File(deployPath+username+"/code/"+boname+"ServiceImplIBBase.java");
	        desfile = new File(outpath+projectName+"-common/src/main/java/"+dirstr+"/common/service/" + moduleName+"/impl/base/"+boname+"ServiceImplIBBase.java");
			copyFile(srcfile, desfile);	

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
		//tablename = tablename.toLowerCase();
		String a[] = tablename.split("_");
		for(int k=0;k<a.length;k++){
			 a[k] = a[k].substring(0, 1).toUpperCase()+ a[k].substring(1);
			 boclassname = boclassname+a[k];
		}
    	return boclassname;
    }
	///////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////
	
	public CstCodeGenerator(){}
	
	/**
	 * 
	 * @param table
	 * @param seqFlg  PO是否使用Hibernate自动生成sequece
	 * @param temFlag VO实体是否继承临时表
	 * @throws Exception
	 */
	public static void gt(EntityTable table,String templatePath) throws Exception{
		CstGenerator eg = new CstGenerator(moduleName);
		eg.generatorVO(new EntityTable[]{table}, templatePath);
	}
	
}
