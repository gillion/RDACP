/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleset;

import com.cartan.center.ebs.ruleset.request.*;
import com.cartan.center.ebs.ruleset.response.*;
import com.cartan.core.ruleset.domain.Ruleset;
import com.cartan.core.ruleset.service.RulesetService;
import com.ridge.util.CodeUtils;
import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;

@ServiceMethodBean
public class RulesetServiceEbsBase {
    static Logger logger = Logger.getLogger(RulesetServiceEbs.class.getName());
	private RulesetService  rulesetService;
	
    public RulesetService getRulesetService() {
        return rulesetService;
    }

    @Autowired
    public void setRulesetService(RulesetService rulesetService) {
        this.rulesetService = rulesetService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(RulesetGetSessionRequest request) {      
    	RulesetGetSessionResponse rulesetGetSessionResponse = new RulesetGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	rulesetGetSessionResponse.setResultString("0");
        } else {
        	rulesetGetSessionResponse.setResultString("1");
            rulesetGetSessionResponse.setSessionId(request.getSessionId());
        }
        return rulesetGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(RulesetGetSessionRequest request) {
    	RulesetGetSessionResponse rulesetGetSessionResponse = new RulesetGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            rulesetGetSessionResponse.setResultString("1");
        } else {
        	rulesetGetSessionResponse.setResultString("0");
        }
        rulesetGetSessionResponse.setSessionId(request.getSessionId());
        return rulesetGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(RulesetGetSessionRequest request) {
    	RulesetGetSessionResponse rulesetGetSessionResponse = new RulesetGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	rulesetGetSessionResponse.setResultString("0");
        	rulesetGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            rulesetGetSessionResponse.setResultString("1");
        }
        return rulesetGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.createRuleset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createRuleset(RulesetCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_Ruleset_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Ruleset ruleset=new Ruleset();
        ruleset.setId(request.getId());    		
        ruleset.setRulesetName(request.getRulesetName());
        ruleset.setVersion(request.getVersion());
        ruleset.setStatus(request.getStatus());
        ruleset.setModifyDate(request.getModifyDate());
        ruleset.setModifyed(request.getModifyed());
        ruleset.setOwner(request.getOwner());
        ruleset.setLocked(request.getLocked());
    	rulesetService.createRuleset(ruleset);
        //返回响应
        RulesetCreateResponse rulesetCreateResponse = new RulesetCreateResponse();
        rulesetCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        rulesetCreateResponse.setResultJson(ruleset);
        return rulesetCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.deleteRuleset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteRuleset(RulesetDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_Ruleset_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        rulesetService.deleteRuleset(idstr);
        //返回响应
        RulesetDeleteResponse rulesetDeleteResponse = new RulesetDeleteResponse();
        rulesetDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return rulesetDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.updateRuleset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateRuleset(RulesetUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_Ruleset_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Ruleset ruleset=new Ruleset();
        ruleset=rulesetService.getRuleset(request.getId());
        if (request.getId()!=null){
	        ruleset.setId(request.getId());
        }
        if (request.getRulesetName()!=null){
	        ruleset.setRulesetName(request.getRulesetName());
        }
        if (request.getVersion()!=null){
	        ruleset.setVersion(request.getVersion());
        }
        if (request.getStatus()!=null){
	        ruleset.setStatus(request.getStatus());
        }
        if (request.getModifyDate()!=null){
	        ruleset.setModifyDate(request.getModifyDate());
        }
        if (request.getModifyed()!=null){
	        ruleset.setModifyed(request.getModifyed());
        }
        if (request.getOwner()!=null){
	        ruleset.setOwner(request.getOwner());
        }
        if (request.getLocked()!=null){
	        ruleset.setLocked(request.getLocked());
        }
    	rulesetService.updateRuleset(ruleset);
        //返回响应
        RulesetUpdateResponse rulesetUpdateResponse = new RulesetUpdateResponse();
        rulesetUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        rulesetUpdateResponse.setResultJson(ruleset);
        return rulesetUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.getRuleset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getRuleset(RulesetGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        Ruleset ruleset=new Ruleset();
        ruleset=rulesetService.getRuleset(id);
        //返回响应
        RulesetGetResponse rulesetGetResponse = new RulesetGetResponse();
        rulesetGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        rulesetGetResponse.setResultJson(ruleset);
        return rulesetGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(RulesetSelectAllRequest request) {
        RulesetSelectAllResponse rulesetSelectAllResponse = new RulesetSelectAllResponse();
        rulesetSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        rulesetSelectAllResponse.setResultJson(rulesetService.selectAll());
        return rulesetSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(RulesetCountAllRequest request) {
        RulesetCountAllResponse rulesetCountAllResponse = new RulesetCountAllResponse();
        rulesetCountAllResponse.setResultString(String.valueOf(rulesetService.countAll()));
        rulesetCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return rulesetCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(RulesetSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        RulesetSelectAllResponse rulesetSelectAllResponse = new RulesetSelectAllResponse();
        rulesetSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        rulesetSelectAllResponse.setResultJson(rulesetService.selectBySql(sqlstr));
        return rulesetSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.selectRuleset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(RulesetSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_Ruleset_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
                 /*
            try {
                Runtime.getRuntime().exec("cmd /c start c:/CodeGener/Gener.bat");
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            */
            Ruleset ruleset=new Ruleset();
        ruleset.setId(request.getId());
        ruleset.setRulesetName(request.getRulesetName());
        ruleset.setVersion(request.getVersion());
        ruleset.setStatus(request.getStatus());
        ruleset.setModifyDate(request.getModifyDate());
        ruleset.setModifyed(request.getModifyed());
        ruleset.setOwner(request.getOwner());
        ruleset.setLocked(request.getLocked());
    	RulesetSelectResponse rulesetSelectResponse = new RulesetSelectResponse();
        rulesetSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<Ruleset> rulesets= rulesetService.selectWithCondition(ruleset);
        rulesetSelectResponse.setResultJson(rulesets);
        return rulesetSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleset.isExistRuleset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistRuleset(RulesetSelectRequest request) {
        Ruleset ruleset=new Ruleset();
        ruleset.setId(request.getId());
        ruleset.setRulesetName(request.getRulesetName());
        ruleset.setVersion(request.getVersion());
        ruleset.setStatus(request.getStatus());
        ruleset.setModifyDate(request.getModifyDate());
        ruleset.setModifyed(request.getModifyed());
        ruleset.setOwner(request.getOwner());
        ruleset.setLocked(request.getLocked());
        ArrayList<Ruleset> rulesets= rulesetService.selectWithCondition(ruleset);
    	RulesetCountAllResponse rulesetCountAllResponse = new RulesetCountAllResponse();
        if (rulesets.size()>0){
        	rulesetCountAllResponse.setResultString("1");
        } else {
        	rulesetCountAllResponse.setResultString("0");
        }        
        return rulesetCountAllResponse;
    }

    public Boolean validateCreateRequest(RulesetCreateRequest request){
    	Ruleset ruleset=new Ruleset();
    	ruleset.setId(request.getId());
        ArrayList<Ruleset> rulesets= rulesetService.selectWithCondition(ruleset);
        if (rulesets!=null&&rulesets.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(RulesetUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(RulesetDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(RulesetSelectRequest request){
        return  true;
     }    
}
