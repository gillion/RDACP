/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.rule;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.rule.request.*;
import com.cartan.center.ebs.rule.response.*;
import com.cartan.core.rule.domain.Rule;
import com.cartan.core.rule.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class RuleServiceEbsBase {
    static Logger logger = Logger.getLogger(RuleServiceEbs.class.getName());
	private RuleService  ruleService;
	
    public RuleService getRuleService() {
        return ruleService;
    }

    @Autowired
    public void setRuleService(RuleService ruleService) {
        this.ruleService = ruleService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(RuleGetSessionRequest request) {

    	RuleGetSessionResponse ruleGetSessionResponse = new RuleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleGetSessionResponse.setResultString("0");
        } else {
        	ruleGetSessionResponse.setResultString("1");
            ruleGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ruleGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(RuleGetSessionRequest request) {
    	RuleGetSessionResponse ruleGetSessionResponse = new RuleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ruleGetSessionResponse.setResultString("1");
        } else {
        	ruleGetSessionResponse.setResultString("0");
        }
        ruleGetSessionResponse.setSessionId(request.getSessionId());
        return ruleGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(RuleGetSessionRequest request) {
    	RuleGetSessionResponse ruleGetSessionResponse = new RuleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleGetSessionResponse.setResultString("0");
        	ruleGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ruleGetSessionResponse.setResultString("1");
        }
        return ruleGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.createRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createRule(RuleCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_Rule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Rule rule=new Rule();
        rule.setId(request.getId());    		
        rule.setRuleName(request.getRuleName());
        rule.setRulesetId(request.getRulesetId());
        rule.setIsUsed(request.getIsUsed());
        rule.setPriLevel(request.getPriLevel());
        rule.setContentType(request.getContentType());
        rule.setEffectDate(request.getEffectDate());
        rule.setInvalidDate(request.getInvalidDate());
        rule.setCreator(request.getCreator());
        rule.setCreateDate(request.getCreateDate());
        rule.setModifyDate(request.getModifyDate());
        rule.setModifyed(request.getModifyed());
        rule.setOwner(request.getOwner());
        rule.setLocked(request.getLocked());
    	ruleService.createRule(rule);
        //返回响应
        RuleCreateResponse ruleCreateResponse = new RuleCreateResponse();
        ruleCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleCreateResponse.setResultJson(rule);
        return ruleCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.deleteRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteRule(RuleDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_Rule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ruleService.deleteRule(idstr);
        //返回响应
        RuleDeleteResponse ruleDeleteResponse = new RuleDeleteResponse();
        ruleDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.updateRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateRule(RuleUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_Rule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Rule rule=new Rule();
        rule=ruleService.getRule(request.getId());
        if (request.getId()!=null){
	        rule.setId(request.getId());
        }
        if (request.getRuleName()!=null){
	        rule.setRuleName(request.getRuleName());
        }
        if (request.getRulesetId()!=null){
	        rule.setRulesetId(request.getRulesetId());
        }
        if (request.getIsUsed()!=null){
	        rule.setIsUsed(request.getIsUsed());
        }
        if (request.getPriLevel()!=null){
	        rule.setPriLevel(request.getPriLevel());
        }
        if (request.getContentType()!=null){
	        rule.setContentType(request.getContentType());
        }
        if (request.getEffectDate()!=null){
	        rule.setEffectDate(request.getEffectDate());
        }
        if (request.getInvalidDate()!=null){
	        rule.setInvalidDate(request.getInvalidDate());
        }
        if (request.getCreator()!=null){
	        rule.setCreator(request.getCreator());
        }
        if (request.getCreateDate()!=null){
	        rule.setCreateDate(request.getCreateDate());
        }
        if (request.getModifyDate()!=null){
	        rule.setModifyDate(request.getModifyDate());
        }
        if (request.getModifyed()!=null){
	        rule.setModifyed(request.getModifyed());
        }
        if (request.getOwner()!=null){
	        rule.setOwner(request.getOwner());
        }
        if (request.getLocked()!=null){
	        rule.setLocked(request.getLocked());
        }
    	ruleService.updateRule(rule);
        //返回响应
        RuleUpdateResponse ruleUpdateResponse = new RuleUpdateResponse();
        ruleUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleUpdateResponse.setResultJson(rule);
        return ruleUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.getRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getRule(RuleGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        Rule rule=new Rule();
        rule=ruleService.getRule(id);
        //返回响应
        RuleGetResponse ruleGetResponse = new RuleGetResponse();
        ruleGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleGetResponse.setResultJson(rule);
        return ruleGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(RuleSelectAllRequest request) {
        RuleSelectAllResponse ruleSelectAllResponse = new RuleSelectAllResponse();
        ruleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleSelectAllResponse.setResultJson(ruleService.selectAll());
        return ruleSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(RuleCountAllRequest request) {
        RuleCountAllResponse ruleCountAllResponse = new RuleCountAllResponse();
        ruleCountAllResponse.setResultString(String.valueOf(ruleService.countAll()));
        ruleCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(RuleSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        RuleSelectAllResponse ruleSelectAllResponse = new RuleSelectAllResponse();
        ruleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleSelectAllResponse.setResultJson(ruleService.selectBySql(sqlstr));
        return ruleSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.selectRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(RuleSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_Rule_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Rule rule=new Rule();
        rule.setId(request.getId());
        rule.setRuleName(request.getRuleName());
        rule.setRulesetId(request.getRulesetId());
        rule.setIsUsed(request.getIsUsed());
        rule.setPriLevel(request.getPriLevel());
        rule.setContentType(request.getContentType());
        rule.setEffectDate(request.getEffectDate());
        rule.setInvalidDate(request.getInvalidDate());
        rule.setCreator(request.getCreator());
        rule.setCreateDate(request.getCreateDate());
        rule.setModifyDate(request.getModifyDate());
        rule.setModifyed(request.getModifyed());
        rule.setOwner(request.getOwner());
        rule.setLocked(request.getLocked());
    	RuleSelectResponse ruleSelectResponse = new RuleSelectResponse();
        ruleSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<Rule> rules= ruleService.selectWithCondition(rule);
        ruleSelectResponse.setResultJson(rules);
        return ruleSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "rule.isExistRule", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistRule(RuleSelectRequest request) {
        Rule rule=new Rule();
        rule.setId(request.getId());
        rule.setRuleName(request.getRuleName());
        rule.setRulesetId(request.getRulesetId());
        rule.setIsUsed(request.getIsUsed());
        rule.setPriLevel(request.getPriLevel());
        rule.setContentType(request.getContentType());
        rule.setEffectDate(request.getEffectDate());
        rule.setInvalidDate(request.getInvalidDate());
        rule.setCreator(request.getCreator());
        rule.setCreateDate(request.getCreateDate());
        rule.setModifyDate(request.getModifyDate());
        rule.setModifyed(request.getModifyed());
        rule.setOwner(request.getOwner());
        rule.setLocked(request.getLocked());
        ArrayList<Rule> rules= ruleService.selectWithCondition(rule);
    	RuleCountAllResponse ruleCountAllResponse = new RuleCountAllResponse();
        if (rules.size()>0){
        	ruleCountAllResponse.setResultString("1");
        } else {
        	ruleCountAllResponse.setResultString("0");
        }        
        return ruleCountAllResponse;
    }

    public Boolean validateCreateRequest(RuleCreateRequest request){
    	Rule rule=new Rule();
    	rule.setId(request.getId());
        ArrayList<Rule> rules= ruleService.selectWithCondition(rule);
        if (rules!=null&&rules.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(RuleUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(RuleDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(RuleSelectRequest request){
        return  true;
     }    
}
