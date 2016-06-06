/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmNumrule;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmNumrule.request.*;
import com.cartan.center.ebs.ipfCcmNumrule.response.*;
import com.cartan.core.ipfCcmNumrule.domain.IpfCcmNumrule;
import com.cartan.core.ipfCcmNumrule.service.IpfCcmNumruleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmNumruleServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmNumruleServiceEbs.class.getName());
	private IpfCcmNumruleService  ipfCcmNumruleService;
	
    public IpfCcmNumruleService getIpfCcmNumruleService() {
        return ipfCcmNumruleService;
    }

    @Autowired
    public void setIpfCcmNumruleService(IpfCcmNumruleService ipfCcmNumruleService) {
        this.ipfCcmNumruleService = ipfCcmNumruleService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmNumruleGetSessionRequest request) {      
    	IpfCcmNumruleGetSessionResponse ipfCcmNumruleGetSessionResponse = new IpfCcmNumruleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmNumruleGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmNumruleGetSessionResponse.setResultString("1");
            ipfCcmNumruleGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmNumruleGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmNumruleGetSessionRequest request) {
    	IpfCcmNumruleGetSessionResponse ipfCcmNumruleGetSessionResponse = new IpfCcmNumruleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmNumruleGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmNumruleGetSessionResponse.setResultString("0");
        }
        ipfCcmNumruleGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmNumruleGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmNumruleGetSessionRequest request) {
    	IpfCcmNumruleGetSessionResponse ipfCcmNumruleGetSessionResponse = new IpfCcmNumruleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmNumruleGetSessionResponse.setResultString("0");
        	ipfCcmNumruleGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmNumruleGetSessionResponse.setResultString("1");
        }
        return ipfCcmNumruleGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.createIpfCcmNumrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmNumrule(IpfCcmNumruleCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmNumrule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmNumrule ipfCcmNumrule=new IpfCcmNumrule();
        ipfCcmNumrule.setId(request.getId());    		
        ipfCcmNumrule.setRuleCode(request.getRuleCode());
        ipfCcmNumrule.setRuleName(request.getRuleName());
        ipfCcmNumrule.setRuleExpression(request.getRuleExpression());
        ipfCcmNumrule.setRuleStatus(request.getRuleStatus());
        ipfCcmNumrule.setInitialValue(request.getInitialValue());
        ipfCcmNumrule.setMaxValue(request.getMaxValue());
        ipfCcmNumrule.setGrowth(request.getGrowth());
        ipfCcmNumrule.setRemark(request.getRemark());
        ipfCcmNumrule.setIsActive(request.getIsActive());
        ipfCcmNumrule.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmNumrule.setBoName(request.getBoName());
        ipfCcmNumrule.setIpfCcmBoPropertyId(request.getIpfCcmBoPropertyId());
        ipfCcmNumrule.setPropertyName(request.getPropertyName());
    	ipfCcmNumruleService.createIpfCcmNumrule(ipfCcmNumrule);
        //返回响应
        IpfCcmNumruleCreateResponse ipfCcmNumruleCreateResponse = new IpfCcmNumruleCreateResponse();
        ipfCcmNumruleCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmNumruleCreateResponse.setResultJson(ipfCcmNumrule);
        return ipfCcmNumruleCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.deleteIpfCcmNumrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmNumrule(IpfCcmNumruleDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmNumrule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmNumruleService.deleteIpfCcmNumrule(idstr);
        //返回响应
        IpfCcmNumruleDeleteResponse ipfCcmNumruleDeleteResponse = new IpfCcmNumruleDeleteResponse();
        ipfCcmNumruleDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmNumruleDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.updateIpfCcmNumrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmNumrule(IpfCcmNumruleUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmNumrule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmNumrule ipfCcmNumrule=new IpfCcmNumrule();
        ipfCcmNumrule=ipfCcmNumruleService.getIpfCcmNumrule(request.getId());
        if (request.getId()!=null){
	        ipfCcmNumrule.setId(request.getId());
        }
        if (request.getRuleCode()!=null){
	        ipfCcmNumrule.setRuleCode(request.getRuleCode());
        }
        if (request.getRuleName()!=null){
	        ipfCcmNumrule.setRuleName(request.getRuleName());
        }
        if (request.getRuleExpression()!=null){
	        ipfCcmNumrule.setRuleExpression(request.getRuleExpression());
        }
        if (request.getRuleStatus()!=null){
	        ipfCcmNumrule.setRuleStatus(request.getRuleStatus());
        }
        if (request.getInitialValue()!=null){
	        ipfCcmNumrule.setInitialValue(request.getInitialValue());
        }
        if (request.getMaxValue()!=null){
	        ipfCcmNumrule.setMaxValue(request.getMaxValue());
        }
        if (request.getGrowth()!=null){
	        ipfCcmNumrule.setGrowth(request.getGrowth());
        }
        if (request.getRemark()!=null){
	        ipfCcmNumrule.setRemark(request.getRemark());
        }
        if (request.getIsActive()!=null){
	        ipfCcmNumrule.setIsActive(request.getIsActive());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfCcmNumrule.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getBoName()!=null){
	        ipfCcmNumrule.setBoName(request.getBoName());
        }
        if (request.getIpfCcmBoPropertyId()!=null){
	        ipfCcmNumrule.setIpfCcmBoPropertyId(request.getIpfCcmBoPropertyId());
        }
        if (request.getPropertyName()!=null){
	        ipfCcmNumrule.setPropertyName(request.getPropertyName());
        }
    	ipfCcmNumruleService.updateIpfCcmNumrule(ipfCcmNumrule);
        //返回响应
        IpfCcmNumruleUpdateResponse ipfCcmNumruleUpdateResponse = new IpfCcmNumruleUpdateResponse();
        ipfCcmNumruleUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmNumruleUpdateResponse.setResultJson(ipfCcmNumrule);
        return ipfCcmNumruleUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.getIpfCcmNumrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmNumrule(IpfCcmNumruleGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmNumrule ipfCcmNumrule=new IpfCcmNumrule();
        ipfCcmNumrule=ipfCcmNumruleService.getIpfCcmNumrule(id);
        //返回响应
        IpfCcmNumruleGetResponse ipfCcmNumruleGetResponse = new IpfCcmNumruleGetResponse();
        ipfCcmNumruleGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmNumruleGetResponse.setResultJson(ipfCcmNumrule);
        return ipfCcmNumruleGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmNumruleSelectAllRequest request) {
        IpfCcmNumruleSelectAllResponse ipfCcmNumruleSelectAllResponse = new IpfCcmNumruleSelectAllResponse();
        ipfCcmNumruleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmNumruleSelectAllResponse.setResultJson(ipfCcmNumruleService.selectAll());
        return ipfCcmNumruleSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmNumruleCountAllRequest request) {
        IpfCcmNumruleCountAllResponse ipfCcmNumruleCountAllResponse = new IpfCcmNumruleCountAllResponse();
        ipfCcmNumruleCountAllResponse.setResultString(String.valueOf(ipfCcmNumruleService.countAll()));
        ipfCcmNumruleCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmNumruleCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmNumruleSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmNumruleSelectAllResponse ipfCcmNumruleSelectAllResponse = new IpfCcmNumruleSelectAllResponse();
        ipfCcmNumruleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmNumruleSelectAllResponse.setResultJson(ipfCcmNumruleService.selectBySql(sqlstr));
        return ipfCcmNumruleSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.selectIpfCcmNumrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmNumruleSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmNumrule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmNumrule ipfCcmNumrule=new IpfCcmNumrule();
        ipfCcmNumrule.setId(request.getId());
        ipfCcmNumrule.setRuleCode(request.getRuleCode());
        ipfCcmNumrule.setRuleName(request.getRuleName());
        ipfCcmNumrule.setRuleExpression(request.getRuleExpression());
        ipfCcmNumrule.setRuleStatus(request.getRuleStatus());
        ipfCcmNumrule.setInitialValue(request.getInitialValue());
        ipfCcmNumrule.setMaxValue(request.getMaxValue());
        ipfCcmNumrule.setGrowth(request.getGrowth());
        ipfCcmNumrule.setRemark(request.getRemark());
        ipfCcmNumrule.setIsActive(request.getIsActive());
        ipfCcmNumrule.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmNumrule.setBoName(request.getBoName());
        ipfCcmNumrule.setIpfCcmBoPropertyId(request.getIpfCcmBoPropertyId());
        ipfCcmNumrule.setPropertyName(request.getPropertyName());
    	IpfCcmNumruleSelectResponse ipfCcmNumruleSelectResponse = new IpfCcmNumruleSelectResponse();
        ipfCcmNumruleSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmNumrule> ipfCcmNumrules= ipfCcmNumruleService.selectWithCondition(ipfCcmNumrule);
        ipfCcmNumruleSelectResponse.setResultJson(ipfCcmNumrules);
        return ipfCcmNumruleSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumrule.isExistIpfCcmNumrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmNumrule(IpfCcmNumruleSelectRequest request) {
        IpfCcmNumrule ipfCcmNumrule=new IpfCcmNumrule();
        ipfCcmNumrule.setId(request.getId());
        ipfCcmNumrule.setRuleCode(request.getRuleCode());
        ipfCcmNumrule.setRuleName(request.getRuleName());
        ipfCcmNumrule.setRuleExpression(request.getRuleExpression());
        ipfCcmNumrule.setRuleStatus(request.getRuleStatus());
        ipfCcmNumrule.setInitialValue(request.getInitialValue());
        ipfCcmNumrule.setMaxValue(request.getMaxValue());
        ipfCcmNumrule.setGrowth(request.getGrowth());
        ipfCcmNumrule.setRemark(request.getRemark());
        ipfCcmNumrule.setIsActive(request.getIsActive());
        ipfCcmNumrule.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmNumrule.setBoName(request.getBoName());
        ipfCcmNumrule.setIpfCcmBoPropertyId(request.getIpfCcmBoPropertyId());
        ipfCcmNumrule.setPropertyName(request.getPropertyName());
        ArrayList<IpfCcmNumrule> ipfCcmNumrules= ipfCcmNumruleService.selectWithCondition(ipfCcmNumrule);
    	IpfCcmNumruleCountAllResponse ipfCcmNumruleCountAllResponse = new IpfCcmNumruleCountAllResponse();
        if (ipfCcmNumrules.size()>0){
        	ipfCcmNumruleCountAllResponse.setResultString("1");
        } else {
        	ipfCcmNumruleCountAllResponse.setResultString("0");
        }        
        return ipfCcmNumruleCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmNumruleCreateRequest request){
    	IpfCcmNumrule ipfCcmNumrule=new IpfCcmNumrule();
    	ipfCcmNumrule.setId(request.getId());
        ArrayList<IpfCcmNumrule> ipfCcmNumrules= ipfCcmNumruleService.selectWithCondition(ipfCcmNumrule);
        if (ipfCcmNumrules!=null&&ipfCcmNumrules.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmNumruleUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmNumruleDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmNumruleSelectRequest request){
        return  true;
     }    
}
