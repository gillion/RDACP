/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBizrule;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBizrule.request.*;
import com.cartan.center.ebs.ipfCcmBizrule.response.*;
import com.cartan.core.ipfCcmBizrule.domain.IpfCcmBizrule;
import com.cartan.core.ipfCcmBizrule.service.IpfCcmBizruleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBizruleServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBizruleServiceEbs.class.getName());
	private IpfCcmBizruleService  ipfCcmBizruleService;
	
    public IpfCcmBizruleService getIpfCcmBizruleService() {
        return ipfCcmBizruleService;
    }

    @Autowired
    public void setIpfCcmBizruleService(IpfCcmBizruleService ipfCcmBizruleService) {
        this.ipfCcmBizruleService = ipfCcmBizruleService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBizruleGetSessionRequest request) {      
    	IpfCcmBizruleGetSessionResponse ipfCcmBizruleGetSessionResponse = new IpfCcmBizruleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBizruleGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBizruleGetSessionResponse.setResultString("1");
            ipfCcmBizruleGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBizruleGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBizruleGetSessionRequest request) {
    	IpfCcmBizruleGetSessionResponse ipfCcmBizruleGetSessionResponse = new IpfCcmBizruleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBizruleGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBizruleGetSessionResponse.setResultString("0");
        }
        ipfCcmBizruleGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBizruleGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBizruleGetSessionRequest request) {
    	IpfCcmBizruleGetSessionResponse ipfCcmBizruleGetSessionResponse = new IpfCcmBizruleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBizruleGetSessionResponse.setResultString("0");
        	ipfCcmBizruleGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBizruleGetSessionResponse.setResultString("1");
        }
        return ipfCcmBizruleGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.createIpfCcmBizrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBizrule(IpfCcmBizruleCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBizrule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBizrule ipfCcmBizrule=new IpfCcmBizrule();
        ipfCcmBizrule.setId(request.getId());    		
        ipfCcmBizrule.setRuleType(request.getRuleType());
        ipfCcmBizrule.setRuleClass(request.getRuleClass());
        ipfCcmBizrule.setRuleCode(request.getRuleCode());
        ipfCcmBizrule.setRuleName(request.getRuleName());
        ipfCcmBizrule.setRuleDes(request.getRuleDes());
        ipfCcmBizrule.setIsSystemCreate(request.getIsSystemCreate());
    	ipfCcmBizruleService.createIpfCcmBizrule(ipfCcmBizrule);
        //返回响应
        IpfCcmBizruleCreateResponse ipfCcmBizruleCreateResponse = new IpfCcmBizruleCreateResponse();
        ipfCcmBizruleCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleCreateResponse.setResultJson(ipfCcmBizrule);
        return ipfCcmBizruleCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.deleteIpfCcmBizrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBizrule(IpfCcmBizruleDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBizrule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBizruleService.deleteIpfCcmBizrule(idstr);
        //返回响应
        IpfCcmBizruleDeleteResponse ipfCcmBizruleDeleteResponse = new IpfCcmBizruleDeleteResponse();
        ipfCcmBizruleDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBizruleDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.updateIpfCcmBizrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBizrule(IpfCcmBizruleUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBizrule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBizrule ipfCcmBizrule=new IpfCcmBizrule();
        ipfCcmBizrule=ipfCcmBizruleService.getIpfCcmBizrule(request.getId());
        if (request.getId()!=null){
	        ipfCcmBizrule.setId(request.getId());
        }
        if (request.getRuleType()!=null){
	        ipfCcmBizrule.setRuleType(request.getRuleType());
        }
        if (request.getRuleClass()!=null){
	        ipfCcmBizrule.setRuleClass(request.getRuleClass());
        }
        if (request.getRuleCode()!=null){
	        ipfCcmBizrule.setRuleCode(request.getRuleCode());
        }
        if (request.getRuleName()!=null){
	        ipfCcmBizrule.setRuleName(request.getRuleName());
        }
        if (request.getRuleDes()!=null){
	        ipfCcmBizrule.setRuleDes(request.getRuleDes());
        }
        if (request.getIsSystemCreate()!=null){
	        ipfCcmBizrule.setIsSystemCreate(request.getIsSystemCreate());
        }
    	ipfCcmBizruleService.updateIpfCcmBizrule(ipfCcmBizrule);
        //返回响应
        IpfCcmBizruleUpdateResponse ipfCcmBizruleUpdateResponse = new IpfCcmBizruleUpdateResponse();
        ipfCcmBizruleUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleUpdateResponse.setResultJson(ipfCcmBizrule);
        return ipfCcmBizruleUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.getIpfCcmBizrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBizrule(IpfCcmBizruleGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBizrule ipfCcmBizrule=new IpfCcmBizrule();
        ipfCcmBizrule=ipfCcmBizruleService.getIpfCcmBizrule(id);
        //返回响应
        IpfCcmBizruleGetResponse ipfCcmBizruleGetResponse = new IpfCcmBizruleGetResponse();
        ipfCcmBizruleGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleGetResponse.setResultJson(ipfCcmBizrule);
        return ipfCcmBizruleGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBizruleSelectAllRequest request) {
        IpfCcmBizruleSelectAllResponse ipfCcmBizruleSelectAllResponse = new IpfCcmBizruleSelectAllResponse();
        ipfCcmBizruleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleSelectAllResponse.setResultJson(ipfCcmBizruleService.selectAll());
        return ipfCcmBizruleSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBizruleCountAllRequest request) {
        IpfCcmBizruleCountAllResponse ipfCcmBizruleCountAllResponse = new IpfCcmBizruleCountAllResponse();
        ipfCcmBizruleCountAllResponse.setResultString(String.valueOf(ipfCcmBizruleService.countAll()));
        ipfCcmBizruleCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBizruleCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBizruleSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBizruleSelectAllResponse ipfCcmBizruleSelectAllResponse = new IpfCcmBizruleSelectAllResponse();
        ipfCcmBizruleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleSelectAllResponse.setResultJson(ipfCcmBizruleService.selectBySql(sqlstr));
        return ipfCcmBizruleSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.selectIpfCcmBizrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBizruleSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBizrule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBizrule ipfCcmBizrule=new IpfCcmBizrule();
        ipfCcmBizrule.setId(request.getId());
        ipfCcmBizrule.setRuleType(request.getRuleType());
        ipfCcmBizrule.setRuleClass(request.getRuleClass());
        ipfCcmBizrule.setRuleCode(request.getRuleCode());
        ipfCcmBizrule.setRuleName(request.getRuleName());
        ipfCcmBizrule.setRuleDes(request.getRuleDes());
        ipfCcmBizrule.setIsSystemCreate(request.getIsSystemCreate());
    	IpfCcmBizruleSelectResponse ipfCcmBizruleSelectResponse = new IpfCcmBizruleSelectResponse();
        ipfCcmBizruleSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBizrule> ipfCcmBizrules= ipfCcmBizruleService.selectWithCondition(ipfCcmBizrule);
        ipfCcmBizruleSelectResponse.setResultJson(ipfCcmBizrules);
        return ipfCcmBizruleSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizrule.isExistIpfCcmBizrule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBizrule(IpfCcmBizruleSelectRequest request) {
        IpfCcmBizrule ipfCcmBizrule=new IpfCcmBizrule();
        ipfCcmBizrule.setId(request.getId());
        ipfCcmBizrule.setRuleType(request.getRuleType());
        ipfCcmBizrule.setRuleClass(request.getRuleClass());
        ipfCcmBizrule.setRuleCode(request.getRuleCode());
        ipfCcmBizrule.setRuleName(request.getRuleName());
        ipfCcmBizrule.setRuleDes(request.getRuleDes());
        ipfCcmBizrule.setIsSystemCreate(request.getIsSystemCreate());
        ArrayList<IpfCcmBizrule> ipfCcmBizrules= ipfCcmBizruleService.selectWithCondition(ipfCcmBizrule);
    	IpfCcmBizruleCountAllResponse ipfCcmBizruleCountAllResponse = new IpfCcmBizruleCountAllResponse();
        if (ipfCcmBizrules.size()>0){
        	ipfCcmBizruleCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBizruleCountAllResponse.setResultString("0");
        }        
        return ipfCcmBizruleCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBizruleCreateRequest request){
    	IpfCcmBizrule ipfCcmBizrule=new IpfCcmBizrule();
    	ipfCcmBizrule.setId(request.getId());
        ArrayList<IpfCcmBizrule> ipfCcmBizrules= ipfCcmBizruleService.selectWithCondition(ipfCcmBizrule);
        if (ipfCcmBizrules!=null&&ipfCcmBizrules.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBizruleUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBizruleDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBizruleSelectRequest request){
        return  true;
     }    
}
