<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package ${basepackage}.ebs.${classNameLower};

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import ${basepackage}.ebs.${classNameLower}.request.*;
import ${basepackage}.ebs.${classNameLower}.response.*;
import com.cartan.core.loginSession.domain.LoginSession;
import com.cartan.core.loginSession.service.LoginSessionService;
import com.cartan.core.${classNameLower}.domain.${className};
import com.cartan.core.${classNameLower}.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class ${className}ServiceEbsBase {
    <#assign porpNo = 0>
	<#list table.columns as column>
       <#assign porpNo=porpNo+1>
       <#if porpNo==1>
  			<#assign columnlowkey = column.columnNameLower> 
       		<#assign columnkey = column.columnName>     
       		<#assign columnsqlkey = column.sqlName>   		
		</#if>
        <#if column.pk>
			<#assign columnlowkey = column.columnNameLower>  
			<#assign columnkey = column.columnName>   	   
       		<#assign columnsqlkey = column.sqlName>   			   		
		</#if>
	</#list>
    static Logger logger = Logger.getLogger(${className}ServiceEbs.class.getName());
	private ${className}Service  ${classNameLower}Service;
	
    public ${className}Service get${className}Service() {
        return ${classNameLower}Service;
    }

    @Autowired
    public void set${className}Service(${className}Service ${classNameLower}Service) {
        this.${classNameLower}Service = ${classNameLower}Service;
    }
    private LoginSessionService loginSessionService;

    public LoginSessionService getLoginSessionService() {
        return loginSessionService;
    }

    @Autowired
    public void setLoginSessionService(LoginSessionService loginSessionService) {
        this.loginSessionService = loginSessionService;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(${className}GetSessionRequest request) {      
    	${className}GetSessionResponse ${classNameLower}GetSessionResponse = new ${className}GetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	${classNameLower}GetSessionResponse.setResultString("0");
        } else {
        	${classNameLower}GetSessionResponse.setResultString("1");
            ${classNameLower}GetSessionResponse.setSessionId(request.getSessionId());
        }
        return ${classNameLower}GetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(${className}GetSessionRequest request) {
    	${className}GetSessionResponse ${classNameLower}GetSessionResponse = new ${className}GetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ${classNameLower}GetSessionResponse.setResultString("1");
        } else {
        	${classNameLower}GetSessionResponse.setResultString("0");
        }
        ${classNameLower}GetSessionResponse.setSessionId(request.getSessionId());
        return ${classNameLower}GetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(${className}GetSessionRequest request) {
    	${className}GetSessionResponse ${classNameLower}GetSessionResponse = new ${className}GetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	${classNameLower}GetSessionResponse.setResultString("0");
        	${classNameLower}GetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ${classNameLower}GetSessionResponse.setResultString("1");
        }
        return ${classNameLower}GetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.create${className}", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object create${className}(${className}CreateRequest request) {
        if (request.get${columnkey}().equals("")){
            request.set${columnkey}(CodeUtils.uuid());
        }
    	<#assign UUIDKey = "0">
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_${className}_RESERVED",
                    request.getRopRequestContext().getLocale(), request.get${columnkey}());
        } else{
        LoginSession loginSession=new LoginSession();
        loginSession.setSessionid(request.getSessionId());
        ArrayList<LoginSession> loginSessions= loginSessionService.selectWithCondition(loginSession);
        ${className} ${classNameLower}=new ${className}();
        <#list table.columns as column>
        <#if column.pk>
    	<#if column.javaType == "String">
    	<#if (column.size==36)>
    	<#assign UUIDKey = "1">
        ${classNameLower}.set${column.columnName}(CodeUtils.uuid());
    	<#else> 
        ${classNameLower}.set${column.columnName}(request.get${column.columnName}());    		
	   	</#if>
	   	<#elseif column.javaType == "Long" >
    	<#assign UUIDKey = "2">
        ${classNameLower}.set${column.columnName}(1L);
	   	</#if>
        <#else>
        if (request.get${column.columnName}()!=null){            
    	<#if column.javaType == "String">
        ${classNameLower}.set${column.columnName}(request.get${column.columnName}());
    	<#elseif column.javaType == "BigDecimal" >
        ${classNameLower}.set${column.columnName}(Double.valueOf(request.get${column.columnName}()));
	   	<#elseif column.javaType == "Long" >
        ${classNameLower}.set${column.columnName}(Long.valueOf(request.get${column.columnName}()));
	   	<#elseif column.javaType == "Date" >
        ${classNameLower}.set${column.columnName}(Date.valueOf(request.get${column.columnName}()));
	   	<#elseif column.javaType == "Boolean" >
        ${classNameLower}.set${column.columnName}(Boolean.valueOf(request.get${column.columnName}()));
        </#if>
        } else {
        	<#if column.javaType == "String">
            ${classNameLower}.set${column.columnName}("");
        	<#elseif column.javaType == "BigDecimal" >
    	   	${classNameLower}.set${column.columnName}(0
    	   	<#elseif column.javaType == "Long" >
    	   	${classNameLower}.set${column.columnName}(0L);
    	   	<#elseif column.javaType == "Date" >
            ${classNameLower}.set${column.columnName}(new Date());
    	   	<#elseif column.javaType == "Boolean" >
            ${classNameLower}.set${column.columnName}(false);
            </#if>        	
        }
        </#if>
    	</#list>
        if (loginSessions.size()>0)
        	${classNameLower}.setProjectName(loginSessions.get(0).getProjectName());
    	${classNameLower}Service.create${className}(${classNameLower});
        //返回响应
        ${className}CreateResponse ${classNameLower}CreateResponse = new ${className}CreateResponse();
        ${classNameLower}CreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ${classNameLower}CreateResponse.setResultJson(${classNameLower});
        return ${classNameLower}CreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.delete${className}", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object delete${className}(${className}DeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_${className}_RESERVED",
                    request.getRopRequestContext().getLocale(), request.get${columnkey}());
        } else{
        String ${columnlowkey}str=request.getRopRequestContext().getParamValue("${columnlowkey}");
        ${classNameLower}Service.delete${className}(${columnlowkey}str);
        //返回响应
        ${className}DeleteResponse ${classNameLower}DeleteResponse = new ${className}DeleteResponse();
        ${classNameLower}DeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ${classNameLower}DeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.update${className}", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object update${className}(${className}UpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_${className}_RESERVED",
                    request.getRopRequestContext().getLocale(), request.get${columnkey}());
        } else{
        ${className} ${classNameLower}=new ${className}();
        ${classNameLower}=${classNameLower}Service.get${className}(request.get${columnkey}());
        <#list table.columns as column>
        if (request.get${column.columnName}()!=null){
	        <#if column.javaType == "String">
	        ${classNameLower}.set${column.columnName}(request.get${column.columnName}());
	    	<#elseif column.javaType == "BigDecimal" >
	        ${classNameLower}.set${column.columnName}(Double.valueOf(request.get${column.columnName}()));
		   	<#elseif column.javaType == "Long" >
	        ${classNameLower}.set${column.columnName}(Long.valueOf(request.get${column.columnName}()));
		   	<#elseif column.javaType == "Date" >
	        ${classNameLower}.set${column.columnName}(Date.valueOf(request.get${column.columnName}()));
		   	<#elseif column.javaType == "Boolean" >
	        ${classNameLower}.set${column.columnName}(Boolean.valueOf(request.get${column.columnName}()));
	        </#if>
        }
        </#list>
    	${classNameLower}Service.update${className}(${classNameLower});
        //返回响应
        ${className}UpdateResponse ${classNameLower}UpdateResponse = new ${className}UpdateResponse();
        ${classNameLower}UpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ${classNameLower}UpdateResponse.setResultJson(${classNameLower});
        return ${classNameLower}UpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.get${className}", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object get${className}(${className}GetRequest request) {  	
        String ${columnlowkey}=request.getRopRequestContext().getParamValue("${columnlowkey}");
        ${className} ${classNameLower}=new ${className}();
        ${classNameLower}=${classNameLower}Service.get${className}(${columnlowkey});
        //返回响应
        ${className}GetResponse ${classNameLower}GetResponse = new ${className}GetResponse();
        ${classNameLower}GetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ${classNameLower}GetResponse.setResultJson(${classNameLower});
        return ${classNameLower}GetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(${className}SelectAllRequest request) {
        ${className}SelectAllResponse ${classNameLower}SelectAllResponse = new ${className}SelectAllResponse();
        ${classNameLower}SelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ${classNameLower}SelectAllResponse.setResultJson(${classNameLower}Service.selectAll());
        return ${classNameLower}SelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(${className}CountAllRequest request) {
        ${className}CountAllResponse ${classNameLower}CountAllResponse = new ${className}CountAllResponse();
        ${classNameLower}CountAllResponse.setResultString(String.valueOf(${classNameLower}Service.countAll()));
        ${classNameLower}CountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ${classNameLower}CountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(${className}SelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        ${className}SelectAllResponse ${classNameLower}SelectAllResponse = new ${className}SelectAllResponse();
        ${classNameLower}SelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ${classNameLower}SelectAllResponse.setResultJson(${classNameLower}Service.selectBySql(sqlstr));
        return ${classNameLower}SelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.select${className}", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(${className}SelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_${className}_RESERVED",
                    request.getRopRequestContext().getLocale(), request.get${columnkey}());
        } else{
        ${className} ${classNameLower}=new ${className}();
        <#list table.columns as column>
        if (request.get${column.columnName}()!=null){   
        <#if column.javaType == "String">
        ${classNameLower}.set${column.columnName}(request.get${column.columnName}());
    	<#elseif column.javaType == "BigDecimal" >
        ${classNameLower}.set${column.columnName}(Double.valueOf(request.get${column.columnName}()));
	   	<#elseif column.javaType == "Long" >
        ${classNameLower}.set${column.columnName}(Long.valueOf(request.get${column.columnName}()));
	   	<#elseif column.javaType == "Date" >
        ${classNameLower}.set${column.columnName}(Date.valueOf(request.get${column.columnName}()));
	   	<#elseif column.javaType == "Boolean" >
        ${classNameLower}.set${column.columnName}(Boolean.valueOf(request.get${column.columnName}()));
        </#if>
        }
        </#list>
        LoginSession loginSession=new LoginSession();
        loginSession.setSessionid(request.getSid());
        ArrayList<LoginSession> loginSessions= loginSessionService.selectWithCondition(loginSession);
        if (loginSessions.size()>0)
        	${classNameLower}.setProjectName(loginSessions.get(0).getProjectName());
    	${className}SelectResponse ${classNameLower}SelectResponse = new ${className}SelectResponse();
        ${classNameLower}SelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<${className}> ${classNameLower}s= ${classNameLower}Service.selectWithCondition(${classNameLower});
        ${classNameLower}SelectResponse.setResultJson(${classNameLower}s);
        return ${classNameLower}SelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "${classNameLower}.isExist${className}", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExist${className}(${className}SelectRequest request) {
        ${className} ${classNameLower}=new ${className}();
        <#list table.columns as column>
        if (request.get${column.columnName}()!=null){   
        <#if column.javaType == "String">
        ${classNameLower}.set${column.columnName}(request.get${column.columnName}());
    	<#elseif column.javaType == "BigDecimal" >
        ${classNameLower}.set${column.columnName}(Double.valueOf(request.get${column.columnName}()));
	   	<#elseif column.javaType == "Long" >
        ${classNameLower}.set${column.columnName}(Long.valueOf(request.get${column.columnName}()));
	   	<#elseif column.javaType == "Date" >
        ${classNameLower}.set${column.columnName}(Date.valueOf(request.get${column.columnName}()));
	   	<#elseif column.javaType == "Boolean" >
        ${classNameLower}.set${column.columnName}(Boolean.valueOf(request.get${column.columnName}()));
        </#if>
        }
        </#list>
        ArrayList<${className}> ${classNameLower}s= ${classNameLower}Service.selectWithCondition(${classNameLower});
    	${className}CountAllResponse ${classNameLower}CountAllResponse = new ${className}CountAllResponse();
        if (${classNameLower}s.size()>0){
        	${classNameLower}CountAllResponse.setResultString("1");
        } else {
        	${classNameLower}CountAllResponse.setResultString("0");
        }        
        return ${classNameLower}CountAllResponse;
    }

    public Boolean validateCreateRequest(${className}CreateRequest request){
    	<#if (UUIDKey=="0")>
    	${className} ${classNameLower}=new ${className}();
    	${classNameLower}.set${columnkey}(request.get${columnkey}());
        ArrayList<${className}> ${classNameLower}s= ${classNameLower}Service.selectWithCondition(${classNameLower});
        if (${classNameLower}s!=null&&${classNameLower}s.size()>0)   {
        	request.set${columnkey}("主键"+request.get${columnkey}()+"已存在,"); 
        	return false;             
        }else
            return  true;
        <#else>
        return  true;
        </#if>
     }
    public Boolean validateUpdateRequest(${className}UpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(${className}DeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(${className}SelectRequest request){
        return  true;
     }    
}
