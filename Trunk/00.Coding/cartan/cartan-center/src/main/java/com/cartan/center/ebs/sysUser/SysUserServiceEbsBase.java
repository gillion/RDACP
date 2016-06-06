/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.center.ebs.sysUser;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.cartan.center.ebs.sysUser.request.*;
import com.cartan.center.ebs.sysUser.response.*;
import com.cartan.core.sysUser.domain.SysUser;
import com.cartan.core.sysUser.service.SysUserService;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.conf.EventProcessingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author : liuxb(13720880048@163.com)
 * @date: 2013-09-05
 */
@ServiceMethodBean
public class SysUserServiceEbsBase {

    public static class Message {

        public static final int REQUIRE = 0;
        public static final int SUPPLY = 1;
        public static final int FINISH = 2;

        private String message;

        private double price;

        private double require;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public double getPrice() {
            return this.price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getRequire() {
            return this.require;
        }

        public void setRequire(double require) {
            this.require = require;
        }

    }
    static Logger logger = Logger.getLogger(SysUserServiceEbs.class.getName());
	private SysUserService  sysUserService;
	
    public SysUserService getSysUserService() {
        return sysUserService;
    }

    @Autowired
    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(SysUserGetSessionRequest request) {       
        SysUserGetSessionResponse sysUserGetSessionResponse = new SysUserGetSessionResponse();
        sysUserGetSessionResponse.setSessionId(CodeUtils.uuid());
        return sysUserGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.createSysUser", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createSysUser(SysUserCreateRequest request) {
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_SysUser_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getUserId());
        } else{
            SysUser sysUser=new SysUser();
                /*   KieServices ks = KieServices.Factory.get();
                KieContainer kContainer = ks.getKieClasspathContainer();
                KieSession kSession = kContainer.newKieSession("ksession-rules");
                Message message = new Message();
                message.setMessage("Hello World");
                message.setStatus(Message.HELLO);
                kSession.insert(message);
                kSession.fireAllRules();       */
                //this.getContext().setRequestAttribute("savebtn", message.getMessage());
                sysUser.setUserId(CodeUtils.uuid());
                sysUser.setUserName(request.getUserName());
                sysUser.setPassword(request.getPassword());
                sysUser.setUserType(request.getUserType());
                sysUser.setLastLogonTime(request.getLastLogonTime());
                sysUser.setLastLogonIp(request.getLastLogonIp());
                sysUser.setStatus(request.getStatus());
                sysUser.setCreateTime(request.getCreateTime());
                sysUserService.createSysUser(sysUser);
            //返回响应
            SysUserCreateResponse sysUserCreateResponse = new SysUserCreateResponse();
            sysUserCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
            sysUserCreateResponse.setResultJson(sysUser);
            return sysUserCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.deleteSysUser", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteSysUser(SysUserDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_SysUser_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getUserId());
        } else{
        String userIdstr=request.getRopRequestContext().getParamValue("userId");
        sysUserService.deleteSysUser(userIdstr);
        //返回响应
        SysUserDeleteResponse sysUserDeleteResponse = new SysUserDeleteResponse();
        sysUserDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return sysUserDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.updateSysUser", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateSysUser(SysUserUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_SysUser_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getUserId());
        } else{

        SysUser sysUser=new SysUser();

        sysUser = sysUserService.getSysUser(request.getUserId());

        if (request.getUserId()!=null){
	        sysUser.setUserId(request.getUserId());
        }
        if (request.getUserName()!=null){
	        sysUser.setUserName(request.getUserName());
        }
        if (request.getPassword()!=null){
	        sysUser.setPassword(request.getPassword());
        }
        if (request.getUserType()!=null){
	        sysUser.setUserType(request.getUserType());
        }
        if (request.getLastLogonTime()!=null){
	        sysUser.setLastLogonTime(request.getLastLogonTime());
        }
        if (request.getLastLogonIp()!=null){
	        sysUser.setLastLogonIp(request.getLastLogonIp());
        }
        if (request.getStatus()!=null){
	        sysUser.setStatus(request.getStatus());
        }
        if (request.getCreateTime()!=null){
	        sysUser.setCreateTime(request.getCreateTime());
        }
    	sysUserService.updateSysUser(sysUser);
        //返回响应
        SysUserUpdateResponse sysUserUpdateResponse = new SysUserUpdateResponse();
        sysUserUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sysUserUpdateResponse.setResultJson(sysUser);
        return sysUserUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.getSysUser", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getSysUser(SysUserGetRequest request) {
        String userId=request.getRopRequestContext().getParamValue("userId");
        SysUser sysUser=new SysUser();
        sysUser=sysUserService.getSysUser(userId);
        //返回响应
        SysUserGetResponse sysUserGetResponse = new SysUserGetResponse();
        sysUserGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sysUserGetResponse.setResultJson(sysUser);
        return sysUserGetResponse;
    }

    public static String Readfile(String path) throws IOException {
        File file=new File(path);
        if(!file.exists()||file.isDirectory())
                throw new FileNotFoundException();
        FileInputStream fis= null;
        StringBuffer sb=new StringBuffer();
            fis = new FileInputStream(file);
        byte[] buf = new byte[1024];
        while((fis.read(buf))!=-1){
            sb.append(new String(buf));
            buf=new byte[1024];//重新生成，避免和上次读取的数据重复
        }
        return sb.toString();
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

    /** 执行规则 */
    private static void executeRule(Message p) throws Exception {
        KieBase kbase = readKieBase();
        KieSession kSession = kbase.newKieSession();
        kSession.insert(p);
        kSession.fireAllRules();
    }

    /** 加载规则包 */
    private static KieBase readKieBase() throws Exception {
        // 加载规则文件
        KieServices ks = KieServices.Factory.get();

        FileInputStream fis = new FileInputStream("src/main/resources/rules/Sample.drl");
        FileInputStream fis1 = new FileInputStream("src/main/resources/rules/Sample1.drl");
        KieFileSystem kfs = ks.newKieFileSystem();
        kfs.write("src/main/resources/rules/Sample.drl", ks.getResources().newInputStreamResource(fis));
        kfs.write("src/main/resources/rules/Sample1.drl", ks.getResources().newInputStreamResource(fis1));
        //String content = Readfile("src/main/resources/rules/Sample1.drl");
        //Writefile("src/main/resources/rules/Sample2.drl",content);
        KieBuilder kieBuilder = ks.newKieBuilder(kfs);
        kieBuilder.buildAll();

        KieContainer kieContainer = ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
        KieBaseConfiguration config = ks.newKieBaseConfiguration();
        config.setOption( EventProcessingOption.STREAM );
        KieBase kieBase = kieContainer.newKieBase(config);
        return kieBase;
    }

    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.readDrl", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object readDrl(SysUserUpdateRequest request) {
        String userId=request.getRopRequestContext().getParamValue("userId");
        String userType=request.getRopRequestContext().getParamValue("userType");
        Message message = new Message();
        try {
            String content="";
            if (userType.equals("1")){
                content = Readfile("src/main/resources/rules/Sample.drl");
            } else if (userType.equals("2")){
                content = Readfile("src/main/resources/rules/Sample1.drl");
            }
            message.setMessage(content);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        //返回响应
        return message;
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.writeDrl", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object writeDrl(SysUserUpdateRequest request) {
        String userId=request.getRopRequestContext().getParamValue("userId");
        String userName=request.getRopRequestContext().getParamValue("userName");
        String userType=request.getRopRequestContext().getParamValue("userType");
        Message message = new Message();
        try {
            StringBuffer content=new StringBuffer();



            if (userType.equals("1")){
                content.append("package com.cartan.center.ebs.sysUser;\n\n");
                content.append("import com.cartan.center.ebs.sysUser.SysUserServiceEbsBase.Message;\n\n");
                content.append("rule \"require formula\"\n");
                content.append("    when\n");
                content.append("        m : Message( status == Message.REQUIRE)\n");
                content.append("    then \n");
                content.append("        m.setMessage( \"require finish\" );\n");
                content.append("        m.setPrice("+userId+"-m.getRequire()*"+userName+");\n");
                content.append("        m.setStatus(Message.FINISH); \n");
                content.append("        update(m); \n");
                content.append("end \n");
                Writefile("src/main/resources/rules/Sample.drl",content.toString());
            } else if (userType.equals("2")){
                content.append("package com.cartan.center.ebs.sysUser;\n\n");
                content.append("import com.cartan.center.ebs.sysUser.SysUserServiceEbsBase.Message;\n\n");
                content.append("rule \"supply formula\"\n");
                content.append("    when\n");
                content.append("        m : Message( status == Message.SUPPLY)\n");
                content.append("    then \n");
                content.append("        m.setMessage( \"supply finish\" );\n");
                content.append("        m.setPrice("+userId+"+m.getRequire()*"+userName+");\n");
                content.append("        m.setStatus(Message.FINISH); \n");
                content.append("        update(m); \n");
                content.append("end \n");
                Writefile("src/main/resources/rules/Sample1.drl",content.toString());
            }

            message.setMessage(content.toString());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        //返回响应
        return message;
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.getMultiCacuteRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getMultiCacuteRule(SysUserUpdateRequest request) {
        String userName=request.getRopRequestContext().getParamValue("userName");
        String[] require=request.getPassword().split(",");
        String sprice="";
        SysUser sysUser=new SysUser();
        for (int i=0;i<require.length;i++){
            try {
                Message message;
                if (userName.equals("1")){
                    message= new Message();
                    message.setMessage("require");
                    message.setRequire(Double.parseDouble(require[i]));
                    message.setStatus(Message.REQUIRE);
                    executeRule(message);
                    if (i<require.length-1){
                        sprice=sprice+message.getPrice()+",";
                    } else {
                        sprice=sprice+message.getPrice();
                    }
                } else {
                    message = new Message();
                    message.setMessage("supply");
                    message.setRequire(Double.parseDouble(require[i]));
                    message.setStatus(Message.SUPPLY);
                    executeRule(message);
                    if (i<require.length-1){
                        sprice=sprice+message.getPrice()+",";
                    } else {
                        sprice=sprice+message.getPrice();
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
        if (userName.equals("1")){
            sysUser.setLastLogonIp(sprice);
        } else {
            sysUser.setUserId(sprice);
        }
        //返回响应
        SysUserUpdateResponse sysUserUpdateResponse = new SysUserUpdateResponse();
        sysUserUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sysUserUpdateResponse.setResultJson(sysUser);
        return sysUserUpdateResponse;
    }

    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.getCacuteRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getCacuteRule(SysUserUpdateRequest request) {
        String userName=request.getRopRequestContext().getParamValue("userName");
        SysUser sysUser=new SysUser();
        try {
            Message message;
            if (userName.equals("1")){
                message= new Message();
                message.setMessage("require");
                message.setRequire(Double.parseDouble(request.getPassword()));
                message.setStatus(Message.REQUIRE);
                executeRule(message);
                sysUser.setLastLogonIp(String.valueOf(message.getPrice()));
            } else {
                message = new Message();
                message.setMessage("supply");
                message.setRequire(Double.parseDouble(request.getPassword()));
                message.setStatus(Message.SUPPLY);
                executeRule(message);
                sysUser.setUserId(String.valueOf(message.getPrice()));
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        //返回响应
        SysUserUpdateResponse sysUserUpdateResponse = new SysUserUpdateResponse();
        sysUserUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sysUserUpdateResponse.setResultJson(sysUser);
        return sysUserUpdateResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(SysUserSelectAllRequest request) {
        SysUserSelectAllResponse sysUserSelectAllResponse = new SysUserSelectAllResponse();
        sysUserSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sysUserSelectAllResponse.setResultJson(sysUserService.selectAll());
        return sysUserSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(SysUserCountAllRequest request) {
        SysUserCountAllResponse sysUserCountAllResponse = new SysUserCountAllResponse();
        sysUserCountAllResponse.setResultString(String.valueOf(sysUserService.countAll()));
        sysUserCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return sysUserCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(SysUserSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        SysUserSelectAllResponse sysUserSelectAllResponse = new SysUserSelectAllResponse();
        sysUserSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sysUserSelectAllResponse.setResultJson(sysUserService.selectBySql(sqlstr));
        return sysUserSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sysUser.selectSysUser", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(SysUserSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_SysUser_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getUserId());
        } else{
        SysUser sysUser=new SysUser();
        sysUser.setUserId(request.getUserId());
        sysUser.setUserName(request.getUserName());
        sysUser.setPassword(request.getPassword());
        sysUser.setUserType(request.getUserType());
        sysUser.setLastLogonTime(request.getLastLogonTime());
        sysUser.setLastLogonIp(request.getLastLogonIp());
        sysUser.setStatus(request.getStatus());
        sysUser.setCreateTime(request.getCreateTime());
    	SysUserSelectResponse sysUserSelectResponse = new SysUserSelectResponse();
        sysUserSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<SysUser> sysUsers= sysUserService.selectWithCondition(sysUser);
        sysUserSelectResponse.setResultJson(sysUsers);
        return sysUserSelectResponse;
        }
    }
    
    public Boolean validateCreateRequest(SysUserCreateRequest request){
        return  true;
     }
    public Boolean validateUpdateRequest(SysUserUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(SysUserDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(SysUserSelectRequest request){
        return  true;
     }    
}
