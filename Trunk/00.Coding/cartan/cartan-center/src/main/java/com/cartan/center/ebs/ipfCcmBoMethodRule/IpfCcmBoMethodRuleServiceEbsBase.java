/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoMethodRule;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoMethodRule.request.*;
import com.cartan.center.ebs.ipfCcmBoMethodRule.response.*;
import com.cartan.core.ipfCcmBoMethodRule.domain.IpfCcmBoMethodRule;
import com.cartan.core.ipfCcmBoMethodRule.service.IpfCcmBoMethodRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoMethodRuleServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoMethodRuleServiceEbs.class.getName());
	private IpfCcmBoMethodRuleService  ipfCcmBoMethodRuleService;
	
    public IpfCcmBoMethodRuleService getIpfCcmBoMethodRuleService() {
        return ipfCcmBoMethodRuleService;
    }

    @Autowired
    public void setIpfCcmBoMethodRuleService(IpfCcmBoMethodRuleService ipfCcmBoMethodRuleService) {
        this.ipfCcmBoMethodRuleService = ipfCcmBoMethodRuleService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoMethodRuleGetSessionRequest request) {      
    	IpfCcmBoMethodRuleGetSessionResponse ipfCcmBoMethodRuleGetSessionResponse = new IpfCcmBoMethodRuleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoMethodRuleGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoMethodRuleGetSessionResponse.setResultString("1");
            ipfCcmBoMethodRuleGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoMethodRuleGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoMethodRuleGetSessionRequest request) {
    	IpfCcmBoMethodRuleGetSessionResponse ipfCcmBoMethodRuleGetSessionResponse = new IpfCcmBoMethodRuleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoMethodRuleGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoMethodRuleGetSessionResponse.setResultString("0");
        }
        ipfCcmBoMethodRuleGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoMethodRuleGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoMethodRuleGetSessionRequest request) {
    	IpfCcmBoMethodRuleGetSessionResponse ipfCcmBoMethodRuleGetSessionResponse = new IpfCcmBoMethodRuleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoMethodRuleGetSessionResponse.setResultString("0");
        	ipfCcmBoMethodRuleGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoMethodRuleGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoMethodRuleGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.createIpfCcmBoMethodRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoMethodRule(IpfCcmBoMethodRuleCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoMethodRule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoMethodRule ipfCcmBoMethodRule=new IpfCcmBoMethodRule();
        ipfCcmBoMethodRule.setId(request.getId());    		
        ipfCcmBoMethodRule.setIpfCcbBoMethodId(request.getIpfCcbBoMethodId());
        ipfCcmBoMethodRule.setRuleNo(request.getRuleNo());
        ipfCcmBoMethodRule.setRuleName(request.getRuleName());
        ipfCcmBoMethodRule.setInvokePoint(request.getInvokePoint());
        ipfCcmBoMethodRule.setInvokeOrder(request.getInvokeOrder());
        ipfCcmBoMethodRule.setRuleId(request.getRuleId());
    	ipfCcmBoMethodRuleService.createIpfCcmBoMethodRule(ipfCcmBoMethodRule);
        //返回响应
        IpfCcmBoMethodRuleCreateResponse ipfCcmBoMethodRuleCreateResponse = new IpfCcmBoMethodRuleCreateResponse();
        ipfCcmBoMethodRuleCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodRuleCreateResponse.setResultJson(ipfCcmBoMethodRule);
        return ipfCcmBoMethodRuleCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.deleteIpfCcmBoMethodRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoMethodRule(IpfCcmBoMethodRuleDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoMethodRule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoMethodRuleService.deleteIpfCcmBoMethodRule(idstr);
        //返回响应
        IpfCcmBoMethodRuleDeleteResponse ipfCcmBoMethodRuleDeleteResponse = new IpfCcmBoMethodRuleDeleteResponse();
        ipfCcmBoMethodRuleDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoMethodRuleDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.updateIpfCcmBoMethodRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoMethodRule(IpfCcmBoMethodRuleUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoMethodRule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoMethodRule ipfCcmBoMethodRule=new IpfCcmBoMethodRule();
        ipfCcmBoMethodRule=ipfCcmBoMethodRuleService.getIpfCcmBoMethodRule(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoMethodRule.setId(request.getId());
        }
        if (request.getIpfCcbBoMethodId()!=null){
	        ipfCcmBoMethodRule.setIpfCcbBoMethodId(request.getIpfCcbBoMethodId());
        }
        if (request.getRuleNo()!=null){
	        ipfCcmBoMethodRule.setRuleNo(request.getRuleNo());
        }
        if (request.getRuleName()!=null){
	        ipfCcmBoMethodRule.setRuleName(request.getRuleName());
        }
        if (request.getInvokePoint()!=null){
	        ipfCcmBoMethodRule.setInvokePoint(request.getInvokePoint());
        }
        if (request.getInvokeOrder()!=null){
	        ipfCcmBoMethodRule.setInvokeOrder(request.getInvokeOrder());
        }
        if (request.getRuleId()!=null){
	        ipfCcmBoMethodRule.setRuleId(request.getRuleId());
        }
    	ipfCcmBoMethodRuleService.updateIpfCcmBoMethodRule(ipfCcmBoMethodRule);
        //返回响应
        IpfCcmBoMethodRuleUpdateResponse ipfCcmBoMethodRuleUpdateResponse = new IpfCcmBoMethodRuleUpdateResponse();
        ipfCcmBoMethodRuleUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodRuleUpdateResponse.setResultJson(ipfCcmBoMethodRule);
        return ipfCcmBoMethodRuleUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.getIpfCcmBoMethodRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoMethodRule(IpfCcmBoMethodRuleGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoMethodRule ipfCcmBoMethodRule=new IpfCcmBoMethodRule();
        ipfCcmBoMethodRule=ipfCcmBoMethodRuleService.getIpfCcmBoMethodRule(id);
        //返回响应
        IpfCcmBoMethodRuleGetResponse ipfCcmBoMethodRuleGetResponse = new IpfCcmBoMethodRuleGetResponse();
        ipfCcmBoMethodRuleGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodRuleGetResponse.setResultJson(ipfCcmBoMethodRule);
        return ipfCcmBoMethodRuleGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoMethodRuleSelectAllRequest request) {
        IpfCcmBoMethodRuleSelectAllResponse ipfCcmBoMethodRuleSelectAllResponse = new IpfCcmBoMethodRuleSelectAllResponse();
        ipfCcmBoMethodRuleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodRuleSelectAllResponse.setResultJson(ipfCcmBoMethodRuleService.selectAll());
        return ipfCcmBoMethodRuleSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoMethodRuleCountAllRequest request) {
        IpfCcmBoMethodRuleCountAllResponse ipfCcmBoMethodRuleCountAllResponse = new IpfCcmBoMethodRuleCountAllResponse();
        ipfCcmBoMethodRuleCountAllResponse.setResultString(String.valueOf(ipfCcmBoMethodRuleService.countAll()));
        ipfCcmBoMethodRuleCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoMethodRuleCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoMethodRuleSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoMethodRuleSelectAllResponse ipfCcmBoMethodRuleSelectAllResponse = new IpfCcmBoMethodRuleSelectAllResponse();
        ipfCcmBoMethodRuleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodRuleSelectAllResponse.setResultJson(ipfCcmBoMethodRuleService.selectBySql(sqlstr));
        return ipfCcmBoMethodRuleSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.selectIpfCcmBoMethodRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoMethodRuleSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoMethodRule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoMethodRule ipfCcmBoMethodRule=new IpfCcmBoMethodRule();
        ipfCcmBoMethodRule.setId(request.getId());
        ipfCcmBoMethodRule.setIpfCcbBoMethodId(request.getIpfCcbBoMethodId());
        ipfCcmBoMethodRule.setRuleNo(request.getRuleNo());
        ipfCcmBoMethodRule.setRuleName(request.getRuleName());
        ipfCcmBoMethodRule.setInvokePoint(request.getInvokePoint());
        ipfCcmBoMethodRule.setInvokeOrder(request.getInvokeOrder());
        ipfCcmBoMethodRule.setRuleId(request.getRuleId());
    	IpfCcmBoMethodRuleSelectResponse ipfCcmBoMethodRuleSelectResponse = new IpfCcmBoMethodRuleSelectResponse();
        ipfCcmBoMethodRuleSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoMethodRule> ipfCcmBoMethodRules= ipfCcmBoMethodRuleService.selectWithCondition(ipfCcmBoMethodRule);
        ipfCcmBoMethodRuleSelectResponse.setResultJson(ipfCcmBoMethodRules);
        return ipfCcmBoMethodRuleSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodRule.isExistIpfCcmBoMethodRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoMethodRule(IpfCcmBoMethodRuleSelectRequest request) {
        IpfCcmBoMethodRule ipfCcmBoMethodRule=new IpfCcmBoMethodRule();
        ipfCcmBoMethodRule.setId(request.getId());
        ipfCcmBoMethodRule.setIpfCcbBoMethodId(request.getIpfCcbBoMethodId());
        ipfCcmBoMethodRule.setRuleNo(request.getRuleNo());
        ipfCcmBoMethodRule.setRuleName(request.getRuleName());
        ipfCcmBoMethodRule.setInvokePoint(request.getInvokePoint());
        ipfCcmBoMethodRule.setInvokeOrder(request.getInvokeOrder());
        ipfCcmBoMethodRule.setRuleId(request.getRuleId());
        ArrayList<IpfCcmBoMethodRule> ipfCcmBoMethodRules= ipfCcmBoMethodRuleService.selectWithCondition(ipfCcmBoMethodRule);
    	IpfCcmBoMethodRuleCountAllResponse ipfCcmBoMethodRuleCountAllResponse = new IpfCcmBoMethodRuleCountAllResponse();
        if (ipfCcmBoMethodRules.size()>0){
        	ipfCcmBoMethodRuleCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoMethodRuleCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoMethodRuleCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoMethodRuleCreateRequest request){
    	IpfCcmBoMethodRule ipfCcmBoMethodRule=new IpfCcmBoMethodRule();
    	ipfCcmBoMethodRule.setId(request.getId());
        ArrayList<IpfCcmBoMethodRule> ipfCcmBoMethodRules= ipfCcmBoMethodRuleService.selectWithCondition(ipfCcmBoMethodRule);
        if (ipfCcmBoMethodRules!=null&&ipfCcmBoMethodRules.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoMethodRuleUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoMethodRuleDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoMethodRuleSelectRequest request){
        return  true;
     }    
}
