/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmEnvironment;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmEnvironment.request.*;
import com.cartan.center.ebs.ipfCcmEnvironment.response.*;
import com.cartan.core.ipfCcmEnvironment.domain.IpfCcmEnvironment;
import com.cartan.core.ipfCcmEnvironment.service.IpfCcmEnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmEnvironmentServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmEnvironmentServiceEbs.class.getName());
	private IpfCcmEnvironmentService  ipfCcmEnvironmentService;
	
    public IpfCcmEnvironmentService getIpfCcmEnvironmentService() {
        return ipfCcmEnvironmentService;
    }

    @Autowired
    public void setIpfCcmEnvironmentService(IpfCcmEnvironmentService ipfCcmEnvironmentService) {
        this.ipfCcmEnvironmentService = ipfCcmEnvironmentService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmEnvironmentGetSessionRequest request) {      
    	IpfCcmEnvironmentGetSessionResponse ipfCcmEnvironmentGetSessionResponse = new IpfCcmEnvironmentGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmEnvironmentGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmEnvironmentGetSessionResponse.setResultString("1");
            ipfCcmEnvironmentGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmEnvironmentGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmEnvironmentGetSessionRequest request) {
    	IpfCcmEnvironmentGetSessionResponse ipfCcmEnvironmentGetSessionResponse = new IpfCcmEnvironmentGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmEnvironmentGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmEnvironmentGetSessionResponse.setResultString("0");
        }
        ipfCcmEnvironmentGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmEnvironmentGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmEnvironmentGetSessionRequest request) {
    	IpfCcmEnvironmentGetSessionResponse ipfCcmEnvironmentGetSessionResponse = new IpfCcmEnvironmentGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmEnvironmentGetSessionResponse.setResultString("0");
        	ipfCcmEnvironmentGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmEnvironmentGetSessionResponse.setResultString("1");
        }
        return ipfCcmEnvironmentGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.createIpfCcmEnvironment", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmEnvironment(IpfCcmEnvironmentCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmEnvironment_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmEnvironment ipfCcmEnvironment=new IpfCcmEnvironment();
        ipfCcmEnvironment.setId(request.getId());    		
        ipfCcmEnvironment.setUserCode(request.getUserCode());
        ipfCcmEnvironment.setProjectName(request.getProjectName());
        ipfCcmEnvironment.setProjectPath(request.getProjectPath());
        ipfCcmEnvironment.setSrcPath(request.getSrcPath());
        ipfCcmEnvironment.setTemplatePath(request.getTemplatePath());
        ipfCcmEnvironment.setWebContentName(request.getWebContentName());
        ipfCcmEnvironment.setTargetProjectName(request.getTargetProjectName());
        ipfCcmEnvironment.setTargetProjectPath(request.getTargetProjectPath());
    	ipfCcmEnvironmentService.createIpfCcmEnvironment(ipfCcmEnvironment);
        //返回响应
        IpfCcmEnvironmentCreateResponse ipfCcmEnvironmentCreateResponse = new IpfCcmEnvironmentCreateResponse();
        ipfCcmEnvironmentCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmEnvironmentCreateResponse.setResultJson(ipfCcmEnvironment);
        return ipfCcmEnvironmentCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.deleteIpfCcmEnvironment", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmEnvironment(IpfCcmEnvironmentDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmEnvironment_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmEnvironmentService.deleteIpfCcmEnvironment(idstr);
        //返回响应
        IpfCcmEnvironmentDeleteResponse ipfCcmEnvironmentDeleteResponse = new IpfCcmEnvironmentDeleteResponse();
        ipfCcmEnvironmentDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmEnvironmentDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.updateIpfCcmEnvironment", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmEnvironment(IpfCcmEnvironmentUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmEnvironment_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmEnvironment ipfCcmEnvironment=new IpfCcmEnvironment();
        ipfCcmEnvironment=ipfCcmEnvironmentService.getIpfCcmEnvironment(request.getId());
        if (request.getId()!=null){
	        ipfCcmEnvironment.setId(request.getId());
        }
        if (request.getUserCode()!=null){
	        ipfCcmEnvironment.setUserCode(request.getUserCode());
        }
        if (request.getProjectName()!=null){
	        ipfCcmEnvironment.setProjectName(request.getProjectName());
        }
        if (request.getProjectPath()!=null){
	        ipfCcmEnvironment.setProjectPath(request.getProjectPath());
        }
        if (request.getSrcPath()!=null){
	        ipfCcmEnvironment.setSrcPath(request.getSrcPath());
        }
        if (request.getTemplatePath()!=null){
	        ipfCcmEnvironment.setTemplatePath(request.getTemplatePath());
        }
        if (request.getWebContentName()!=null){
	        ipfCcmEnvironment.setWebContentName(request.getWebContentName());
        }
        if (request.getTargetProjectName()!=null){
	        ipfCcmEnvironment.setTargetProjectName(request.getTargetProjectName());
        }
        if (request.getTargetProjectPath()!=null){
	        ipfCcmEnvironment.setTargetProjectPath(request.getTargetProjectPath());
        }
    	ipfCcmEnvironmentService.updateIpfCcmEnvironment(ipfCcmEnvironment);
        //返回响应
        IpfCcmEnvironmentUpdateResponse ipfCcmEnvironmentUpdateResponse = new IpfCcmEnvironmentUpdateResponse();
        ipfCcmEnvironmentUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmEnvironmentUpdateResponse.setResultJson(ipfCcmEnvironment);
        return ipfCcmEnvironmentUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.getIpfCcmEnvironment", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmEnvironment(IpfCcmEnvironmentGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmEnvironment ipfCcmEnvironment=new IpfCcmEnvironment();
        ipfCcmEnvironment=ipfCcmEnvironmentService.getIpfCcmEnvironment(id);
        //返回响应
        IpfCcmEnvironmentGetResponse ipfCcmEnvironmentGetResponse = new IpfCcmEnvironmentGetResponse();
        ipfCcmEnvironmentGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmEnvironmentGetResponse.setResultJson(ipfCcmEnvironment);
        return ipfCcmEnvironmentGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmEnvironmentSelectAllRequest request) {
        IpfCcmEnvironmentSelectAllResponse ipfCcmEnvironmentSelectAllResponse = new IpfCcmEnvironmentSelectAllResponse();
        ipfCcmEnvironmentSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmEnvironmentSelectAllResponse.setResultJson(ipfCcmEnvironmentService.selectAll());
        return ipfCcmEnvironmentSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmEnvironmentCountAllRequest request) {
        IpfCcmEnvironmentCountAllResponse ipfCcmEnvironmentCountAllResponse = new IpfCcmEnvironmentCountAllResponse();
        ipfCcmEnvironmentCountAllResponse.setResultString(String.valueOf(ipfCcmEnvironmentService.countAll()));
        ipfCcmEnvironmentCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmEnvironmentCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmEnvironmentSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmEnvironmentSelectAllResponse ipfCcmEnvironmentSelectAllResponse = new IpfCcmEnvironmentSelectAllResponse();
        ipfCcmEnvironmentSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmEnvironmentSelectAllResponse.setResultJson(ipfCcmEnvironmentService.selectBySql(sqlstr));
        return ipfCcmEnvironmentSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.selectIpfCcmEnvironment", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmEnvironmentSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmEnvironment_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmEnvironment ipfCcmEnvironment=new IpfCcmEnvironment();
        ipfCcmEnvironment.setId(request.getId());
        ipfCcmEnvironment.setUserCode(request.getUserCode());
        ipfCcmEnvironment.setProjectName(request.getProjectName());
        ipfCcmEnvironment.setProjectPath(request.getProjectPath());
        ipfCcmEnvironment.setSrcPath(request.getSrcPath());
        ipfCcmEnvironment.setTemplatePath(request.getTemplatePath());
        ipfCcmEnvironment.setWebContentName(request.getWebContentName());
        ipfCcmEnvironment.setTargetProjectName(request.getTargetProjectName());
        ipfCcmEnvironment.setTargetProjectPath(request.getTargetProjectPath());
    	IpfCcmEnvironmentSelectResponse ipfCcmEnvironmentSelectResponse = new IpfCcmEnvironmentSelectResponse();
        ipfCcmEnvironmentSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmEnvironment> ipfCcmEnvironments= ipfCcmEnvironmentService.selectWithCondition(ipfCcmEnvironment);
        ipfCcmEnvironmentSelectResponse.setResultJson(ipfCcmEnvironments);
        return ipfCcmEnvironmentSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmEnvironment.isExistIpfCcmEnvironment", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmEnvironment(IpfCcmEnvironmentSelectRequest request) {
        IpfCcmEnvironment ipfCcmEnvironment=new IpfCcmEnvironment();
        ipfCcmEnvironment.setId(request.getId());
        ipfCcmEnvironment.setUserCode(request.getUserCode());
        ipfCcmEnvironment.setProjectName(request.getProjectName());
        ipfCcmEnvironment.setProjectPath(request.getProjectPath());
        ipfCcmEnvironment.setSrcPath(request.getSrcPath());
        ipfCcmEnvironment.setTemplatePath(request.getTemplatePath());
        ipfCcmEnvironment.setWebContentName(request.getWebContentName());
        ipfCcmEnvironment.setTargetProjectName(request.getTargetProjectName());
        ipfCcmEnvironment.setTargetProjectPath(request.getTargetProjectPath());
        ArrayList<IpfCcmEnvironment> ipfCcmEnvironments= ipfCcmEnvironmentService.selectWithCondition(ipfCcmEnvironment);
    	IpfCcmEnvironmentCountAllResponse ipfCcmEnvironmentCountAllResponse = new IpfCcmEnvironmentCountAllResponse();
        if (ipfCcmEnvironments.size()>0){
        	ipfCcmEnvironmentCountAllResponse.setResultString("1");
        } else {
        	ipfCcmEnvironmentCountAllResponse.setResultString("0");
        }        
        return ipfCcmEnvironmentCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmEnvironmentCreateRequest request){
    	IpfCcmEnvironment ipfCcmEnvironment=new IpfCcmEnvironment();
    	ipfCcmEnvironment.setId(request.getId());
        ArrayList<IpfCcmEnvironment> ipfCcmEnvironments= ipfCcmEnvironmentService.selectWithCondition(ipfCcmEnvironment);
        if (ipfCcmEnvironments!=null&&ipfCcmEnvironments.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmEnvironmentUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmEnvironmentDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmEnvironmentSelectRequest request){
        return  true;
     }    
}
