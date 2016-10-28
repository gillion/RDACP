/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.codegener;

import com.cartan.center.ebs.ruleset.FileProperties;
import com.cartan.core.codegenerCheckbox.domain.CodegenerCheckbox;
import com.cartan.core.codegenerCheckbox.service.CodegenerCheckboxService;
import com.cartan.core.codegenerCombobox.domain.CodegenerCombobox;
import com.cartan.core.codegenerCombobox.service.CodegenerComboboxService;
import com.cartan.core.codegenerRadio.domain.CodegenerRadio;
import com.cartan.core.codegenerRadio.service.CodegenerRadioService;
import com.cartan.core.codegenerSelect.domain.CodegenerSelect;
import com.cartan.core.codegenerSelect.service.CodegenerSelectService;
import com.cartan.core.codegenerTable.domain.CodegenerTable;
import com.cartan.core.codegenerTable.service.CodegenerTableService;
import com.cartan.core.loginSession.domain.LoginSession;
import com.cartan.core.loginSession.service.LoginSessionService;
import com.cartan.core.loginUser.domain.LoginUser;
import com.cartan.core.loginUser.service.LoginUserService;
import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.codegener.request.*;
import com.cartan.center.ebs.codegener.response.*;
import com.cartan.core.codegener.domain.Codegener;
import com.cartan.core.codegener.service.CodegenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class CodegenerServiceEbsBase {
    static Logger logger = Logger.getLogger(CodegenerServiceEbs.class.getName());
	private CodegenerService  codegenerService;
	
    public CodegenerService getCodegenerService() {
        return codegenerService;
    }

    @Autowired
    public void setCodegenerService(CodegenerService codegenerService) {
        this.codegenerService = codegenerService;
    }
    private CodegenerTableService codegenerTableService;

    public CodegenerTableService getCodegenerTableService() {
        return codegenerTableService;
    }

    @Autowired
    public void setCodegenerTableService(CodegenerTableService codegenerTableService) {
        this.codegenerTableService = codegenerTableService;
    }
    private CodegenerSelectService codegenerSelectService;

    public CodegenerSelectService getCodegenerSelectService() {
        return codegenerSelectService;
    }

    @Autowired
    public void setCodegenerSelectService(CodegenerSelectService codegenerSelectService) {
        this.codegenerSelectService = codegenerSelectService;
    }

    private CodegenerComboboxService codegenerComboboxService;

    public CodegenerComboboxService getCodegenerComboboxService() {
        return codegenerComboboxService;
    }

    @Autowired
    public void setCodegenerComboboxService(CodegenerComboboxService codegenerComboboxService) {
        this.codegenerComboboxService = codegenerComboboxService;
    }
    private CodegenerCheckboxService codegenerCheckboxService;

    public CodegenerCheckboxService getCodegenerCheckboxService() {
        return codegenerCheckboxService;
    }

    @Autowired
    public void setCodegenerCheckboxService(CodegenerCheckboxService codegenerCheckboxService) {
        this.codegenerCheckboxService = codegenerCheckboxService;
    }
    private CodegenerRadioService codegenerRadioService;

    public CodegenerRadioService getCodegenerRadioService() {
        return codegenerRadioService;
    }

    @Autowired
    public void setCodegenerRadioService(CodegenerRadioService codegenerRadioService) {
        this.codegenerRadioService = codegenerRadioService;
    }


    private LoginSessionService loginSessionService;

    public LoginSessionService getLoginSessionService() {
        return loginSessionService;
    }

    @Autowired
    public void setLoginSessionService(LoginSessionService loginSessionService) {
        this.loginSessionService = loginSessionService;
    }

    private LoginUserService loginUserService;

    public LoginUserService getLoginUserService() {
        return loginUserService;
    }

    @Autowired
    public void setLoginUserService(LoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(CodegenerGetSessionRequest request) {      
    	CodegenerGetSessionResponse codegenerGetSessionResponse = new CodegenerGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerGetSessionResponse.setResultString("0");
        } else {
        	codegenerGetSessionResponse.setResultString("1");
            codegenerGetSessionResponse.setSessionId(request.getSessionId());
        }
        return codegenerGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(CodegenerGetSessionRequest request) {
    	CodegenerGetSessionResponse codegenerGetSessionResponse = new CodegenerGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            codegenerGetSessionResponse.setResultString("1");
        } else {
        	codegenerGetSessionResponse.setResultString("0");
        }
        codegenerGetSessionResponse.setSessionId(request.getSessionId());
        return codegenerGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(CodegenerGetSessionRequest request) {
    	CodegenerGetSessionResponse codegenerGetSessionResponse = new CodegenerGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerGetSessionResponse.setResultString("0");
        	codegenerGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            codegenerGetSessionResponse.setResultString("1");
        }
        return codegenerGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.createCodegener", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createCodegener(CodegenerCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_Codegener_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Codegener codegener=new Codegener();
        codegener.setId(request.getId());    		
        codegener.setSetupName(request.getSetupName());
        codegener.setBasePackage(request.getBasePackage());
        codegener.setModuleName(request.getModuleName());
        codegener.setRoot(request.getRoot());
        codegener.setOutput(request.getOutput());
        codegener.setSysname(request.getSysname());
        codegener.setStatus("101");
        LoginSession loginSession=new LoginSession();
        loginSession.setSessionid(request.getSessionId());
        ArrayList<LoginSession> loginSessions= loginSessionService.selectWithCondition(loginSession);
        if (loginSessions.size()>0) {
            codegener.setProjectName(loginSessions.get(0).getProjectName());
        }
    	codegenerService.createCodegener(codegener);
        //返回响应
        CodegenerCreateResponse codegenerCreateResponse = new CodegenerCreateResponse();
        codegenerCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerCreateResponse.setResultJson(codegener);
        return codegenerCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.deleteCodegener", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteCodegener(CodegenerDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_Codegener_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        codegenerService.deleteCodegener(idstr);
        //返回响应
        CodegenerDeleteResponse codegenerDeleteResponse = new CodegenerDeleteResponse();
        codegenerDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerDeleteResponse;
        }
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


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.runCodeGener", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object runCodeGener(CodegenerCreateRequest request) {
        LoginSession loginSession=new LoginSession();
        loginSession.setSessionid(request.getSessionId());
        ArrayList<LoginSession> loginSessions= loginSessionService.selectWithCondition(loginSession);
        String userId="panbc";
        if (loginSessions.size()>0) {
            userId=loginSessions.get(0).getLoginUser();
        }
        try {
            Runtime.getRuntime().exec("cmd /c start cmd /c start d:/deploy/"+userId+"/CstGener.bat");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        CodegenerGetSessionResponse codegenerGetSessionResponse = new CodegenerGetSessionResponse();
        codegenerGetSessionResponse.setResultString("1");
        codegenerGetSessionResponse.setSessionId(request.getSessionId());
        return codegenerGetSessionResponse;
    }

    @ServiceMethod(method = "codegener.getUserId", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getUserId(CodegenerCreateRequest request) {
        CodegenerGetSessionResponse codegenerGetSessionResponse = new CodegenerGetSessionResponse();

        LoginSession loginSession=new LoginSession();
        loginSession.setSessionid(request.getSessionId());
        ArrayList<LoginSession> loginSessions= loginSessionService.selectWithCondition(loginSession);
        String userId="panbc";
        if (loginSessions.size()>0) {
            userId=loginSessions.get(0).getLoginUser();
        }
        codegenerGetSessionResponse.setResultString(userId);
        codegenerGetSessionResponse.setSessionId(request.getSessionId());
        return codegenerGetSessionResponse;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.makeProperty", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object makeProperty(CodegenerCreateRequest request) {
        CodegenerGetSessionResponse codegenerGetSessionResponse = new CodegenerGetSessionResponse();
        LoginSession loginSession=new LoginSession();
        loginSession.setSessionid(request.getSessionId());
        ArrayList<LoginSession> loginSessions= loginSessionService.selectWithCondition(loginSession);
        String userId="panbc";
        String projectName="jfgl";
        String templateType="1";
        if (loginSessions.size()>0) {
            userId=loginSessions.get(0).getLoginUser();
            LoginUser loginUser=new LoginUser();
            loginUser.setId(userId);
            ArrayList<LoginUser> loginUsers=  loginUserService.selectWithCondition(loginUser);
            if (loginUsers.size()>0) {
                templateType=loginUsers.get(0).getTemplateType();
            }
            projectName = loginSessions.get(0).getProjectName();
        }
        Codegener codegener=new Codegener();
        codegener=codegenerService.getCodegener(request.getId());
        String tablelist="";
        CodegenerTable querycodegener=new CodegenerTable();
        querycodegener.setSetupId(request.getId());
        ArrayList<CodegenerTable> codegenerTables= codegenerTableService.selectWithCondition(querycodegener);
        if (codegenerTables!=null&&codegenerTables.size()>0)   {
            for(int i=0;i<codegenerTables.size();i++){
                tablelist+= codegenerTables.get(i).getTableName()+":"+codegenerTables.get(i).getTableDes()+":"+codegenerTables.get(i).getPageSize()+":"+codegenerTables.get(i).getParentTableName()+":"+codegenerTables.get(i).getNoParent()+":"+codegenerTables.get(i).getIsNewBsclass()+";";
            }
        }

        String selectfields="";
        CodegenerSelect querycodegenerSelects=new CodegenerSelect();
        querycodegenerSelects.setSetupId(request.getId());
        ArrayList<CodegenerSelect> codegenerSelects= codegenerSelectService.selectWithCondition(querycodegenerSelects);
        if (codegenerSelects!=null&&codegenerSelects.size()>0)   {
            for(int i=0;i<codegenerSelects.size();i++){
                selectfields+= codegenerSelects.get(i).getSelectField()+":"+codegenerSelects.get(i).getSelectTable()+":"+codegenerSelects.get(i).getSelectDes()+";";
            }
        }

        String Comboboxfields="";
        CodegenerCombobox querycodegenerComboboxs=new CodegenerCombobox();
        querycodegenerComboboxs.setSetupId(request.getId());
        ArrayList<CodegenerCombobox> codegenerComboboxs= codegenerComboboxService.selectWithCondition(querycodegenerComboboxs);
        if (codegenerComboboxs!=null&&codegenerComboboxs.size()>0)   {
            for(int i=0;i<codegenerComboboxs.size();i++){
                Comboboxfields+= codegenerComboboxs.get(i).getComboboxField()+":"+codegenerComboboxs.get(i).getCodeType()+";";
            }
        }
        String Checkboxfields="";
        CodegenerCheckbox querycodegenerCheckboxs=new CodegenerCheckbox();
        querycodegenerCheckboxs.setSetupId(request.getId());
        ArrayList<CodegenerCheckbox> codegenerCheckboxs= codegenerCheckboxService.selectWithCondition(querycodegenerCheckboxs);
        if (codegenerCheckboxs!=null&&codegenerCheckboxs.size()>0)   {
            for(int i=0;i<codegenerCheckboxs.size();i++){
                Checkboxfields+= codegenerCheckboxs.get(i).getCheckboxField()+":"+codegenerCheckboxs.get(i).getCodeType()+";";
            }
        }

        String Radiofields="";
        CodegenerRadio querycodegenerRadios=new CodegenerRadio();
        querycodegenerRadios.setSetupId(request.getId());
        ArrayList<CodegenerRadio> codegenerRadios= codegenerRadioService.selectWithCondition(querycodegenerRadios);
        if (codegenerRadios!=null&&codegenerRadios.size()>0)   {
            for(int i=0;i<codegenerRadios.size();i++){
                Radiofields+= codegenerRadios.get(i).getRadioField()+":"+codegenerRadios.get(i).getCodeType()+";";
            }
        }
        FileProperties props_CorpTotal = new FileProperties("D:/deploy/"+userId+"/config.properties");
        if (codegener.getBasePackage()!=null){
            props_CorpTotal.setProperty("basepackage",codegener.getBasePackage());
        }
        if (codegener.getModuleName()!=null){
            props_CorpTotal.setProperty("moduleName",codegener.getModuleName());
        }
        if (codegener.getRoot()!=null){
            props_CorpTotal.setProperty("root",codegener.getRoot());
        }
        if (codegener.getOutput()!=null){
            props_CorpTotal.setProperty("output",codegener.getOutput());
        }
        if (codegener.getSysname()!=null){
            props_CorpTotal.setProperty("sysname",codegener.getSysname());
        }
        if (codegener.getProjectName()!=null){
            props_CorpTotal.setProperty("projectName",codegener.getProjectName());
        }
        props_CorpTotal.setProperty("templateType", templateType);
        props_CorpTotal.setProperty("tablelist", tablelist);

        // props_CorpTotal.setProperty("tablelist","t_ipf_req_rule:基本配置:1;t_ipf_ccm_environment:基本配置:1;t_ipf_ccm_template:基本配置:1;");
        props_CorpTotal.setProperty("timefields","");
        props_CorpTotal.setProperty("selectfields",selectfields);
        props_CorpTotal.setProperty("comboxfields",Comboboxfields);
        props_CorpTotal.setProperty("checkboxfields",Checkboxfields);
        props_CorpTotal.setProperty("radiofields",Radiofields);
        props_CorpTotal.setProperty("radiofields",Radiofields);
        if (templateType.equals("3")){
            props_CorpTotal.setProperty("commonfields","createtime;creater;edittime;editer;deletestate;deleter;recordVersion");
        } else
        if (templateType.equals("2")){
            props_CorpTotal.setProperty("commonfields","createTime;creater;editTime;editer;deleteState;deleter;recordVersion");
        } else {
            props_CorpTotal.setProperty("commonfields","creator;createOffice;createTime;lastModifyor;lastModifyOffice;lastModifyTime;recordVersion");
        }
        String fileName="D:/deploy/"+userId+"/config.properties";
        FileOutputStream outputFile = null;
        try {
            outputFile = new FileOutputStream(fileName);
            try {
                props_CorpTotal.store(outputFile, "");
                outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        StringBuffer content=new StringBuffer();
        content.append("D:\r\n");
        content.append("cd D:\\deploy\\"+userId+"\r\n");
        content.append("set classpath=.;"+codegener.getRoot()+"\\lib\\rapid.jar;"+codegener.getRoot()+"\\lib\\ojdbc14.jar;"+codegener.getRoot()+"\\lib\\freemarker.jar;"+codegener.getRoot()+"\\lib\\xwork-core-2.2.3.jar;"+codegener.getRoot()+"\\lib\\mysql-connector-java-5.1.25.jar;"+codegener.getRoot()+"\\lib\\db2jcc.jar;"+codegener.getRoot()+"\\lib\\db2jcc_license_cisuz.jar;"+codegener.getRoot()+"\\lib\\db2jcc_license_cu.jar;"+codegener.getRoot()+"\\lib\\tools.jar;"+codegener.getRoot()+"\\lib\\dt.jar;"+codegener.getRoot()+"\\lib\\rt.jar;"+codegener.getRoot()+"\r\n");
        content.append("D:\\Java\\jdk1.6.0_29\\bin\\java heip.generator.main.CstCodeGenerator "+userId+"\r\n");
        content.append("exit");
        try {
            Writefile("D:\\deploy\\"+userId+"\\CstGener.bat",content.toString());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        codegenerGetSessionResponse.setResultString(tablelist);
        codegenerGetSessionResponse.setSessionId("");
        return codegenerGetSessionResponse;
    }

    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.updateCodegener", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateCodegener(CodegenerUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_Codegener_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Codegener codegener=new Codegener();
        codegener=codegenerService.getCodegener(request.getId());
        if (request.getId()!=null){
	        codegener.setId(request.getId());
        }
        if (request.getSetupName()!=null){
	        codegener.setSetupName(request.getSetupName());
        }
        if (request.getBasePackage()!=null){
	        codegener.setBasePackage(request.getBasePackage());
        }
        if (request.getModuleName()!=null){
	        codegener.setModuleName(request.getModuleName());
        }
        if (request.getRoot()!=null){
	        codegener.setRoot(request.getRoot());
        }
        if (request.getOutput()!=null){
	        codegener.setOutput(request.getOutput());
        }
        if (request.getSysname()!=null){
	        codegener.setSysname(request.getSysname());
        }
        if (request.getStatus()!=null){
            LoginSession loginSession=new LoginSession();
            loginSession.setSessionid(request.getSessionId());
            ArrayList<LoginSession> loginSessions= loginSessionService.selectWithCondition(loginSession);
            String userId="panbc";
            if (loginSessions.size()>0) {
                userId=loginSessions.get(0).getLoginUser();
            }
            codegener.setStatus(request.getStatus());
            if (request.getStatus().equals("101")){
                codegener.setLockMan("");
                codegener.setLockTime("");
            } else {
                codegener.setLockMan(userId);
                Calendar c1 = Calendar.getInstance();
                c1.setTime(new Date());
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
                codegener.setLockTime(format.format(c1.getTime()));
            }
        }

        codegenerService.updateCodegener(codegener);
            //返回响应
        CodegenerUpdateResponse codegenerUpdateResponse = new CodegenerUpdateResponse();
        codegenerUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerUpdateResponse.setResultJson(codegener);
        return codegenerUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.getCodegener", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getCodegener(CodegenerGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        Codegener codegener=new Codegener();
        codegener=codegenerService.getCodegener(id);
        //返回响应
        CodegenerGetResponse codegenerGetResponse = new CodegenerGetResponse();
        codegenerGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerGetResponse.setResultJson(codegener);
        return codegenerGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(CodegenerSelectAllRequest request) {
        CodegenerSelectAllResponse codegenerSelectAllResponse = new CodegenerSelectAllResponse();
        codegenerSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerSelectAllResponse.setResultJson(codegenerService.selectAll());
        return codegenerSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(CodegenerCountAllRequest request) {
        CodegenerCountAllResponse codegenerCountAllResponse = new CodegenerCountAllResponse();
        codegenerCountAllResponse.setResultString(String.valueOf(codegenerService.countAll()));
        codegenerCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(CodegenerSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        CodegenerSelectAllResponse codegenerSelectAllResponse = new CodegenerSelectAllResponse();
        codegenerSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerSelectAllResponse.setResultJson(codegenerService.selectBySql(sqlstr));
        return codegenerSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.selectCodegener", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(CodegenerSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_Codegener_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        LoginSession loginSession=new LoginSession();
        loginSession.setSessionid(request.getSid());
        ArrayList<LoginSession> loginSessions= loginSessionService.selectWithCondition(loginSession);

        Codegener codegener=new Codegener();
        codegener.setId(request.getId());
        codegener.setSetupName(request.getSetupName());
        codegener.setBasePackage(request.getBasePackage());
        codegener.setModuleName(request.getModuleName());
        codegener.setRoot(request.getRoot());
        codegener.setOutput(request.getOutput());
        codegener.setSysname(request.getSysname());
        if (loginSessions.size()>0)
          codegener.setProjectName(loginSessions.get(0).getProjectName());
    	CodegenerSelectResponse codegenerSelectResponse = new CodegenerSelectResponse();
        codegenerSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<Codegener> codegeners= codegenerService.selectWithCondition(codegener);
        codegenerSelectResponse.setResultJson(codegeners);
        return codegenerSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegener.isExistCodegener", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistCodegener(CodegenerSelectRequest request) {
        Codegener codegener=new Codegener();
        codegener.setId(request.getId());
        codegener.setSetupName(request.getSetupName());
        codegener.setBasePackage(request.getBasePackage());
        codegener.setModuleName(request.getModuleName());
        codegener.setRoot(request.getRoot());
        codegener.setOutput(request.getOutput());
        codegener.setSysname(request.getSysname());
        ArrayList<Codegener> codegeners= codegenerService.selectWithCondition(codegener);
    	CodegenerCountAllResponse codegenerCountAllResponse = new CodegenerCountAllResponse();
        if (codegeners.size()>0){
        	codegenerCountAllResponse.setResultString("1");
        } else {
        	codegenerCountAllResponse.setResultString("0");
        }        
        return codegenerCountAllResponse;
    }

    public Boolean validateCreateRequest(CodegenerCreateRequest request){
    	Codegener codegener=new Codegener();
    	codegener.setId(request.getId());
        ArrayList<Codegener> codegeners= codegenerService.selectWithCondition(codegener);
        if (codegeners!=null&&codegeners.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(CodegenerUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(CodegenerDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(CodegenerSelectRequest request){
        return  true;
     }    
}
