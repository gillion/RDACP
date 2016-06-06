/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfReqRule;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfReqRule.request.*;
import com.cartan.center.ebs.ipfReqRule.response.*;
import com.cartan.core.ipfReqRule.domain.IpfReqRule;
import com.cartan.core.ipfReqRule.service.IpfReqRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfReqRuleServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfReqRuleServiceEbs.class.getName());
	private IpfReqRuleService  ipfReqRuleService;
	
    public IpfReqRuleService getIpfReqRuleService() {
        return ipfReqRuleService;
    }

    @Autowired
    public void setIpfReqRuleService(IpfReqRuleService ipfReqRuleService) {
        this.ipfReqRuleService = ipfReqRuleService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfReqRuleGetSessionRequest request) {      
    	IpfReqRuleGetSessionResponse ipfReqRuleGetSessionResponse = new IpfReqRuleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfReqRuleGetSessionResponse.setResultString("0");
        } else {
        	ipfReqRuleGetSessionResponse.setResultString("1");
            ipfReqRuleGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfReqRuleGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfReqRuleGetSessionRequest request) {
    	IpfReqRuleGetSessionResponse ipfReqRuleGetSessionResponse = new IpfReqRuleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfReqRuleGetSessionResponse.setResultString("1");
        } else {
        	ipfReqRuleGetSessionResponse.setResultString("0");
        }
        ipfReqRuleGetSessionResponse.setSessionId(request.getSessionId());
        return ipfReqRuleGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfReqRuleGetSessionRequest request) {
    	IpfReqRuleGetSessionResponse ipfReqRuleGetSessionResponse = new IpfReqRuleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfReqRuleGetSessionResponse.setResultString("0");
        	ipfReqRuleGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfReqRuleGetSessionResponse.setResultString("1");
        }
        return ipfReqRuleGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.createIpfReqRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfReqRule(IpfReqRuleCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfReqRule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfReqRule ipfReqRule=new IpfReqRule();
        ipfReqRule.setId(request.getId());    		
        ipfReqRule.setRuleName(request.getRuleName());
        ipfReqRule.setRuleNo(request.getRuleNo());
        ipfReqRule.setRuleType(request.getRuleType());
        ipfReqRule.setRuleStatus(request.getRuleStatus());
        ipfReqRule.setTriggerType(request.getTriggerType());
        ipfReqRule.setPhysicalLocation(request.getPhysicalLocation());
        ipfReqRule.setActionType(request.getActionType());
        ipfReqRule.setBusinessLocation(request.getBusinessLocation());
        ipfReqRule.setBusinessModule(request.getBusinessModule());
        ipfReqRule.setDroolsAttribute(request.getDroolsAttribute());
        ipfReqRule.setRuleDesc(request.getRuleDesc());
        ipfReqRule.setIsDecisionTable(request.getIsDecisionTable());
        ipfReqRule.setPublicType(request.getPublicType());
        ipfReqRule.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfReqRule.setImportDesc(request.getImportDesc());
        ipfReqRule.setDroolsWhen(request.getDroolsWhen());
        ipfReqRule.setDroolsThen(request.getDroolsThen());
        ipfReqRule.setRemark(request.getRemark());
    	ipfReqRuleService.createIpfReqRule(ipfReqRule);
        //返回响应
        IpfReqRuleCreateResponse ipfReqRuleCreateResponse = new IpfReqRuleCreateResponse();
        ipfReqRuleCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfReqRuleCreateResponse.setResultJson(ipfReqRule);
        return ipfReqRuleCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.deleteIpfReqRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfReqRule(IpfReqRuleDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfReqRule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfReqRuleService.deleteIpfReqRule(idstr);
        //返回响应
        IpfReqRuleDeleteResponse ipfReqRuleDeleteResponse = new IpfReqRuleDeleteResponse();
        ipfReqRuleDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfReqRuleDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.updateIpfReqRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfReqRule(IpfReqRuleUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfReqRule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfReqRule ipfReqRule=new IpfReqRule();
        ipfReqRule=ipfReqRuleService.getIpfReqRule(request.getId());
        if (request.getId()!=null){
	        ipfReqRule.setId(request.getId());
        }
        if (request.getRuleName()!=null){
	        ipfReqRule.setRuleName(request.getRuleName());
        }
        if (request.getRuleNo()!=null){
	        ipfReqRule.setRuleNo(request.getRuleNo());
        }
        if (request.getRuleType()!=null){
	        ipfReqRule.setRuleType(request.getRuleType());
        }
        if (request.getRuleStatus()!=null){
	        ipfReqRule.setRuleStatus(request.getRuleStatus());
        }
        if (request.getTriggerType()!=null){
	        ipfReqRule.setTriggerType(request.getTriggerType());
        }
        if (request.getPhysicalLocation()!=null){
	        ipfReqRule.setPhysicalLocation(request.getPhysicalLocation());
        }
        if (request.getActionType()!=null){
	        ipfReqRule.setActionType(request.getActionType());
        }
        if (request.getBusinessLocation()!=null){
	        ipfReqRule.setBusinessLocation(request.getBusinessLocation());
        }
        if (request.getBusinessModule()!=null){
	        ipfReqRule.setBusinessModule(request.getBusinessModule());
        }
        if (request.getDroolsAttribute()!=null){
	        ipfReqRule.setDroolsAttribute(request.getDroolsAttribute());
        }
        if (request.getRuleDesc()!=null){
	        ipfReqRule.setRuleDesc(request.getRuleDesc());
        }
        if (request.getIsDecisionTable()!=null){
	        ipfReqRule.setIsDecisionTable(request.getIsDecisionTable());
        }
        if (request.getPublicType()!=null){
	        ipfReqRule.setPublicType(request.getPublicType());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfReqRule.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getImportDesc()!=null){
	        ipfReqRule.setImportDesc(request.getImportDesc());
        }
        if (request.getDroolsWhen()!=null){
	        ipfReqRule.setDroolsWhen(request.getDroolsWhen());
        }
        if (request.getDroolsThen()!=null){
	        ipfReqRule.setDroolsThen(request.getDroolsThen());
        }
        if (request.getRemark()!=null){
	        ipfReqRule.setRemark(request.getRemark());
        }
    	ipfReqRuleService.updateIpfReqRule(ipfReqRule);
        //返回响应
        IpfReqRuleUpdateResponse ipfReqRuleUpdateResponse = new IpfReqRuleUpdateResponse();
        ipfReqRuleUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfReqRuleUpdateResponse.setResultJson(ipfReqRule);
        return ipfReqRuleUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.getIpfReqRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfReqRule(IpfReqRuleGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfReqRule ipfReqRule=new IpfReqRule();
        ipfReqRule=ipfReqRuleService.getIpfReqRule(id);
        //返回响应
        IpfReqRuleGetResponse ipfReqRuleGetResponse = new IpfReqRuleGetResponse();
        ipfReqRuleGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfReqRuleGetResponse.setResultJson(ipfReqRule);
        return ipfReqRuleGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfReqRuleSelectAllRequest request) {
        IpfReqRuleSelectAllResponse ipfReqRuleSelectAllResponse = new IpfReqRuleSelectAllResponse();
        ipfReqRuleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfReqRuleSelectAllResponse.setResultJson(ipfReqRuleService.selectAll());
        return ipfReqRuleSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfReqRuleCountAllRequest request) {
        IpfReqRuleCountAllResponse ipfReqRuleCountAllResponse = new IpfReqRuleCountAllResponse();
        ipfReqRuleCountAllResponse.setResultString(String.valueOf(ipfReqRuleService.countAll()));
        ipfReqRuleCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfReqRuleCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfReqRuleSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfReqRuleSelectAllResponse ipfReqRuleSelectAllResponse = new IpfReqRuleSelectAllResponse();
        ipfReqRuleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfReqRuleSelectAllResponse.setResultJson(ipfReqRuleService.selectBySql(sqlstr));
        return ipfReqRuleSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.selectIpfReqRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfReqRuleSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfReqRule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfReqRule ipfReqRule=new IpfReqRule();
        ipfReqRule.setId(request.getId());
        ipfReqRule.setRuleName(request.getRuleName());
        ipfReqRule.setRuleNo(request.getRuleNo());
        ipfReqRule.setRuleType(request.getRuleType());
        ipfReqRule.setRuleStatus(request.getRuleStatus());
        ipfReqRule.setTriggerType(request.getTriggerType());
        ipfReqRule.setPhysicalLocation(request.getPhysicalLocation());
        ipfReqRule.setActionType(request.getActionType());
        ipfReqRule.setBusinessLocation(request.getBusinessLocation());
        ipfReqRule.setBusinessModule(request.getBusinessModule());
        ipfReqRule.setDroolsAttribute(request.getDroolsAttribute());
        ipfReqRule.setRuleDesc(request.getRuleDesc());
        ipfReqRule.setIsDecisionTable(request.getIsDecisionTable());
        ipfReqRule.setPublicType(request.getPublicType());
        ipfReqRule.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfReqRule.setImportDesc(request.getImportDesc());
        ipfReqRule.setDroolsWhen(request.getDroolsWhen());
        ipfReqRule.setDroolsThen(request.getDroolsThen());
        ipfReqRule.setRemark(request.getRemark());
    	IpfReqRuleSelectResponse ipfReqRuleSelectResponse = new IpfReqRuleSelectResponse();
        ipfReqRuleSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfReqRule> ipfReqRules= ipfReqRuleService.selectWithCondition(ipfReqRule);
        ipfReqRuleSelectResponse.setResultJson(ipfReqRules);
        return ipfReqRuleSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfReqRule.isExistIpfReqRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfReqRule(IpfReqRuleSelectRequest request) {
        IpfReqRule ipfReqRule=new IpfReqRule();
        ipfReqRule.setId(request.getId());
        ipfReqRule.setRuleName(request.getRuleName());
        ipfReqRule.setRuleNo(request.getRuleNo());
        ipfReqRule.setRuleType(request.getRuleType());
        ipfReqRule.setRuleStatus(request.getRuleStatus());
        ipfReqRule.setTriggerType(request.getTriggerType());
        ipfReqRule.setPhysicalLocation(request.getPhysicalLocation());
        ipfReqRule.setActionType(request.getActionType());
        ipfReqRule.setBusinessLocation(request.getBusinessLocation());
        ipfReqRule.setBusinessModule(request.getBusinessModule());
        ipfReqRule.setDroolsAttribute(request.getDroolsAttribute());
        ipfReqRule.setRuleDesc(request.getRuleDesc());
        ipfReqRule.setIsDecisionTable(request.getIsDecisionTable());
        ipfReqRule.setPublicType(request.getPublicType());
        ipfReqRule.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfReqRule.setImportDesc(request.getImportDesc());
        ipfReqRule.setDroolsWhen(request.getDroolsWhen());
        ipfReqRule.setDroolsThen(request.getDroolsThen());
        ipfReqRule.setRemark(request.getRemark());
        ArrayList<IpfReqRule> ipfReqRules= ipfReqRuleService.selectWithCondition(ipfReqRule);
    	IpfReqRuleCountAllResponse ipfReqRuleCountAllResponse = new IpfReqRuleCountAllResponse();
        if (ipfReqRules.size()>0){
        	ipfReqRuleCountAllResponse.setResultString("1");
        } else {
        	ipfReqRuleCountAllResponse.setResultString("0");
        }        
        return ipfReqRuleCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfReqRuleCreateRequest request){
    	IpfReqRule ipfReqRule=new IpfReqRule();
    	ipfReqRule.setId(request.getId());
        ArrayList<IpfReqRule> ipfReqRules= ipfReqRuleService.selectWithCondition(ipfReqRule);
        if (ipfReqRules!=null&&ipfReqRules.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfReqRuleUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfReqRuleDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfReqRuleSelectRequest request){
        return  true;
     }    
}
