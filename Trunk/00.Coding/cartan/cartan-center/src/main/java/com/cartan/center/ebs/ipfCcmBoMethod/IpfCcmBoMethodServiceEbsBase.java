/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoMethod;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoMethod.request.*;
import com.cartan.center.ebs.ipfCcmBoMethod.response.*;
import com.cartan.core.ipfCcmBoMethod.domain.IpfCcmBoMethod;
import com.cartan.core.ipfCcmBoMethod.service.IpfCcmBoMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoMethodServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoMethodServiceEbs.class.getName());
	private IpfCcmBoMethodService  ipfCcmBoMethodService;
	
    public IpfCcmBoMethodService getIpfCcmBoMethodService() {
        return ipfCcmBoMethodService;
    }

    @Autowired
    public void setIpfCcmBoMethodService(IpfCcmBoMethodService ipfCcmBoMethodService) {
        this.ipfCcmBoMethodService = ipfCcmBoMethodService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoMethodGetSessionRequest request) {      
    	IpfCcmBoMethodGetSessionResponse ipfCcmBoMethodGetSessionResponse = new IpfCcmBoMethodGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoMethodGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoMethodGetSessionResponse.setResultString("1");
            ipfCcmBoMethodGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoMethodGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoMethodGetSessionRequest request) {
    	IpfCcmBoMethodGetSessionResponse ipfCcmBoMethodGetSessionResponse = new IpfCcmBoMethodGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoMethodGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoMethodGetSessionResponse.setResultString("0");
        }
        ipfCcmBoMethodGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoMethodGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoMethodGetSessionRequest request) {
    	IpfCcmBoMethodGetSessionResponse ipfCcmBoMethodGetSessionResponse = new IpfCcmBoMethodGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoMethodGetSessionResponse.setResultString("0");
        	ipfCcmBoMethodGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoMethodGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoMethodGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.createIpfCcmBoMethod", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoMethod(IpfCcmBoMethodCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoMethod_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoMethod ipfCcmBoMethod=new IpfCcmBoMethod();
        ipfCcmBoMethod.setId(request.getId());    		
        ipfCcmBoMethod.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoMethod.setBoType(request.getBoType());
        ipfCcmBoMethod.setBoRefId(request.getBoRefId());
        ipfCcmBoMethod.setIcon(request.getIcon());
        ipfCcmBoMethod.setRemark(request.getRemark());
        ipfCcmBoMethod.setMethodDesc(request.getMethodDesc());
        ipfCcmBoMethod.setMethodName(request.getMethodName());
        ipfCcmBoMethod.setMethodType(request.getMethodType());
        ipfCcmBoMethod.setUrl(request.getUrl());
        ipfCcmBoMethod.setIsDefault(request.getIsDefault());
        ipfCcmBoMethod.setIsVisible(request.getIsVisible());
        ipfCcmBoMethod.setRefShlpName(request.getRefShlpName());
        ipfCcmBoMethod.setRuleNo(request.getRuleNo());
        ipfCcmBoMethod.setJumpMethodId(request.getJumpMethodId());
        ipfCcmBoMethod.setJumpMethodName(request.getJumpMethodName());
        ipfCcmBoMethod.setJumpBoName(request.getJumpBoName());
        ipfCcmBoMethod.setWidth(request.getWidth());
        ipfCcmBoMethod.setHeight(request.getHeight());
        ipfCcmBoMethod.setGroupName(request.getGroupName());
        ipfCcmBoMethod.setGroupDesc(request.getGroupDesc());
        ipfCcmBoMethod.setIsCache(request.getIsCache());
        ipfCcmBoMethod.setCacheType(request.getCacheType());
        ipfCcmBoMethod.setRequestType(request.getRequestType());
        ipfCcmBoMethod.setJumpWindowTitle(request.getJumpWindowTitle());
        ipfCcmBoMethod.setIsRefreshParentBo(request.getIsRefreshParentBo());
    	ipfCcmBoMethodService.createIpfCcmBoMethod(ipfCcmBoMethod);
        //返回响应
        IpfCcmBoMethodCreateResponse ipfCcmBoMethodCreateResponse = new IpfCcmBoMethodCreateResponse();
        ipfCcmBoMethodCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodCreateResponse.setResultJson(ipfCcmBoMethod);
        return ipfCcmBoMethodCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.deleteIpfCcmBoMethod", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoMethod(IpfCcmBoMethodDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoMethod_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoMethodService.deleteIpfCcmBoMethod(idstr);
        //返回响应
        IpfCcmBoMethodDeleteResponse ipfCcmBoMethodDeleteResponse = new IpfCcmBoMethodDeleteResponse();
        ipfCcmBoMethodDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoMethodDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.updateIpfCcmBoMethod", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoMethod(IpfCcmBoMethodUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoMethod_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoMethod ipfCcmBoMethod=new IpfCcmBoMethod();
        ipfCcmBoMethod=ipfCcmBoMethodService.getIpfCcmBoMethod(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoMethod.setId(request.getId());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfCcmBoMethod.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getBoType()!=null){
	        ipfCcmBoMethod.setBoType(request.getBoType());
        }
        if (request.getBoRefId()!=null){
	        ipfCcmBoMethod.setBoRefId(request.getBoRefId());
        }
        if (request.getIcon()!=null){
	        ipfCcmBoMethod.setIcon(request.getIcon());
        }
        if (request.getRemark()!=null){
	        ipfCcmBoMethod.setRemark(request.getRemark());
        }
        if (request.getMethodDesc()!=null){
	        ipfCcmBoMethod.setMethodDesc(request.getMethodDesc());
        }
        if (request.getMethodName()!=null){
	        ipfCcmBoMethod.setMethodName(request.getMethodName());
        }
        if (request.getMethodType()!=null){
	        ipfCcmBoMethod.setMethodType(request.getMethodType());
        }
        if (request.getUrl()!=null){
	        ipfCcmBoMethod.setUrl(request.getUrl());
        }
        if (request.getIsDefault()!=null){
	        ipfCcmBoMethod.setIsDefault(request.getIsDefault());
        }
        if (request.getIsVisible()!=null){
	        ipfCcmBoMethod.setIsVisible(request.getIsVisible());
        }
        if (request.getRefShlpName()!=null){
	        ipfCcmBoMethod.setRefShlpName(request.getRefShlpName());
        }
        if (request.getRuleNo()!=null){
	        ipfCcmBoMethod.setRuleNo(request.getRuleNo());
        }
        if (request.getJumpMethodId()!=null){
	        ipfCcmBoMethod.setJumpMethodId(request.getJumpMethodId());
        }
        if (request.getJumpMethodName()!=null){
	        ipfCcmBoMethod.setJumpMethodName(request.getJumpMethodName());
        }
        if (request.getJumpBoName()!=null){
	        ipfCcmBoMethod.setJumpBoName(request.getJumpBoName());
        }
        if (request.getWidth()!=null){
	        ipfCcmBoMethod.setWidth(request.getWidth());
        }
        if (request.getHeight()!=null){
	        ipfCcmBoMethod.setHeight(request.getHeight());
        }
        if (request.getGroupName()!=null){
	        ipfCcmBoMethod.setGroupName(request.getGroupName());
        }
        if (request.getGroupDesc()!=null){
	        ipfCcmBoMethod.setGroupDesc(request.getGroupDesc());
        }
        if (request.getIsCache()!=null){
	        ipfCcmBoMethod.setIsCache(request.getIsCache());
        }
        if (request.getCacheType()!=null){
	        ipfCcmBoMethod.setCacheType(request.getCacheType());
        }
        if (request.getRequestType()!=null){
	        ipfCcmBoMethod.setRequestType(request.getRequestType());
        }
        if (request.getJumpWindowTitle()!=null){
	        ipfCcmBoMethod.setJumpWindowTitle(request.getJumpWindowTitle());
        }
        if (request.getIsRefreshParentBo()!=null){
	        ipfCcmBoMethod.setIsRefreshParentBo(request.getIsRefreshParentBo());
        }
    	ipfCcmBoMethodService.updateIpfCcmBoMethod(ipfCcmBoMethod);
        //返回响应
        IpfCcmBoMethodUpdateResponse ipfCcmBoMethodUpdateResponse = new IpfCcmBoMethodUpdateResponse();
        ipfCcmBoMethodUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodUpdateResponse.setResultJson(ipfCcmBoMethod);
        return ipfCcmBoMethodUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.getIpfCcmBoMethod", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoMethod(IpfCcmBoMethodGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoMethod ipfCcmBoMethod=new IpfCcmBoMethod();
        ipfCcmBoMethod=ipfCcmBoMethodService.getIpfCcmBoMethod(id);
        //返回响应
        IpfCcmBoMethodGetResponse ipfCcmBoMethodGetResponse = new IpfCcmBoMethodGetResponse();
        ipfCcmBoMethodGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodGetResponse.setResultJson(ipfCcmBoMethod);
        return ipfCcmBoMethodGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoMethodSelectAllRequest request) {
        IpfCcmBoMethodSelectAllResponse ipfCcmBoMethodSelectAllResponse = new IpfCcmBoMethodSelectAllResponse();
        ipfCcmBoMethodSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodSelectAllResponse.setResultJson(ipfCcmBoMethodService.selectAll());
        return ipfCcmBoMethodSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoMethodCountAllRequest request) {
        IpfCcmBoMethodCountAllResponse ipfCcmBoMethodCountAllResponse = new IpfCcmBoMethodCountAllResponse();
        ipfCcmBoMethodCountAllResponse.setResultString(String.valueOf(ipfCcmBoMethodService.countAll()));
        ipfCcmBoMethodCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoMethodCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoMethodSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoMethodSelectAllResponse ipfCcmBoMethodSelectAllResponse = new IpfCcmBoMethodSelectAllResponse();
        ipfCcmBoMethodSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodSelectAllResponse.setResultJson(ipfCcmBoMethodService.selectBySql(sqlstr));
        return ipfCcmBoMethodSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.selectIpfCcmBoMethod", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoMethodSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoMethod_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoMethod ipfCcmBoMethod=new IpfCcmBoMethod();
        ipfCcmBoMethod.setId(request.getId());
        ipfCcmBoMethod.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoMethod.setBoType(request.getBoType());
        ipfCcmBoMethod.setBoRefId(request.getBoRefId());
        ipfCcmBoMethod.setIcon(request.getIcon());
        ipfCcmBoMethod.setRemark(request.getRemark());
        ipfCcmBoMethod.setMethodDesc(request.getMethodDesc());
        ipfCcmBoMethod.setMethodName(request.getMethodName());
        ipfCcmBoMethod.setMethodType(request.getMethodType());
        ipfCcmBoMethod.setUrl(request.getUrl());
        ipfCcmBoMethod.setIsDefault(request.getIsDefault());
        ipfCcmBoMethod.setIsVisible(request.getIsVisible());
        ipfCcmBoMethod.setRefShlpName(request.getRefShlpName());
        ipfCcmBoMethod.setRuleNo(request.getRuleNo());
        ipfCcmBoMethod.setJumpMethodId(request.getJumpMethodId());
        ipfCcmBoMethod.setJumpMethodName(request.getJumpMethodName());
        ipfCcmBoMethod.setJumpBoName(request.getJumpBoName());
        ipfCcmBoMethod.setWidth(request.getWidth());
        ipfCcmBoMethod.setHeight(request.getHeight());
        ipfCcmBoMethod.setGroupName(request.getGroupName());
        ipfCcmBoMethod.setGroupDesc(request.getGroupDesc());
        ipfCcmBoMethod.setIsCache(request.getIsCache());
        ipfCcmBoMethod.setCacheType(request.getCacheType());
        ipfCcmBoMethod.setRequestType(request.getRequestType());
        ipfCcmBoMethod.setJumpWindowTitle(request.getJumpWindowTitle());
        ipfCcmBoMethod.setIsRefreshParentBo(request.getIsRefreshParentBo());
    	IpfCcmBoMethodSelectResponse ipfCcmBoMethodSelectResponse = new IpfCcmBoMethodSelectResponse();
        ipfCcmBoMethodSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoMethod> ipfCcmBoMethods= ipfCcmBoMethodService.selectWithCondition(ipfCcmBoMethod);
        ipfCcmBoMethodSelectResponse.setResultJson(ipfCcmBoMethods);
        return ipfCcmBoMethodSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethod.isExistIpfCcmBoMethod", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoMethod(IpfCcmBoMethodSelectRequest request) {
        IpfCcmBoMethod ipfCcmBoMethod=new IpfCcmBoMethod();
        ipfCcmBoMethod.setId(request.getId());
        ipfCcmBoMethod.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoMethod.setBoType(request.getBoType());
        ipfCcmBoMethod.setBoRefId(request.getBoRefId());
        ipfCcmBoMethod.setIcon(request.getIcon());
        ipfCcmBoMethod.setRemark(request.getRemark());
        ipfCcmBoMethod.setMethodDesc(request.getMethodDesc());
        ipfCcmBoMethod.setMethodName(request.getMethodName());
        ipfCcmBoMethod.setMethodType(request.getMethodType());
        ipfCcmBoMethod.setUrl(request.getUrl());
        ipfCcmBoMethod.setIsDefault(request.getIsDefault());
        ipfCcmBoMethod.setIsVisible(request.getIsVisible());
        ipfCcmBoMethod.setRefShlpName(request.getRefShlpName());
        ipfCcmBoMethod.setRuleNo(request.getRuleNo());
        ipfCcmBoMethod.setJumpMethodId(request.getJumpMethodId());
        ipfCcmBoMethod.setJumpMethodName(request.getJumpMethodName());
        ipfCcmBoMethod.setJumpBoName(request.getJumpBoName());
        ipfCcmBoMethod.setWidth(request.getWidth());
        ipfCcmBoMethod.setHeight(request.getHeight());
        ipfCcmBoMethod.setGroupName(request.getGroupName());
        ipfCcmBoMethod.setGroupDesc(request.getGroupDesc());
        ipfCcmBoMethod.setIsCache(request.getIsCache());
        ipfCcmBoMethod.setCacheType(request.getCacheType());
        ipfCcmBoMethod.setRequestType(request.getRequestType());
        ipfCcmBoMethod.setJumpWindowTitle(request.getJumpWindowTitle());
        ipfCcmBoMethod.setIsRefreshParentBo(request.getIsRefreshParentBo());
        ArrayList<IpfCcmBoMethod> ipfCcmBoMethods= ipfCcmBoMethodService.selectWithCondition(ipfCcmBoMethod);
    	IpfCcmBoMethodCountAllResponse ipfCcmBoMethodCountAllResponse = new IpfCcmBoMethodCountAllResponse();
        if (ipfCcmBoMethods.size()>0){
        	ipfCcmBoMethodCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoMethodCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoMethodCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoMethodCreateRequest request){
    	IpfCcmBoMethod ipfCcmBoMethod=new IpfCcmBoMethod();
    	ipfCcmBoMethod.setId(request.getId());
        ArrayList<IpfCcmBoMethod> ipfCcmBoMethods= ipfCcmBoMethodService.selectWithCondition(ipfCcmBoMethod);
        if (ipfCcmBoMethods!=null&&ipfCcmBoMethods.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoMethodUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoMethodDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoMethodSelectRequest request){
        return  true;
     }    
}
