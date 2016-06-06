/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTree;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ruleTree.request.*;
import com.cartan.center.ebs.ruleTree.response.*;
import com.cartan.core.ruleTree.domain.RuleTree;
import com.cartan.core.ruleTree.service.RuleTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class RuleTreeServiceEbsBase {
    static Logger logger = Logger.getLogger(RuleTreeServiceEbs.class.getName());
	private RuleTreeService  ruleTreeService;
	
    public RuleTreeService getRuleTreeService() {
        return ruleTreeService;
    }

    @Autowired
    public void setRuleTreeService(RuleTreeService ruleTreeService) {
        this.ruleTreeService = ruleTreeService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(RuleTreeGetSessionRequest request) {      
    	RuleTreeGetSessionResponse ruleTreeGetSessionResponse = new RuleTreeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleTreeGetSessionResponse.setResultString("0");
        } else {
        	ruleTreeGetSessionResponse.setResultString("1");
            ruleTreeGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ruleTreeGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(RuleTreeGetSessionRequest request) {
    	RuleTreeGetSessionResponse ruleTreeGetSessionResponse = new RuleTreeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ruleTreeGetSessionResponse.setResultString("1");
        } else {
        	ruleTreeGetSessionResponse.setResultString("0");
        }
        ruleTreeGetSessionResponse.setSessionId(request.getSessionId());
        return ruleTreeGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(RuleTreeGetSessionRequest request) {
    	RuleTreeGetSessionResponse ruleTreeGetSessionResponse = new RuleTreeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleTreeGetSessionResponse.setResultString("0");
        	ruleTreeGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ruleTreeGetSessionResponse.setResultString("1");
        }
        return ruleTreeGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.createRuleTree", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createRuleTree(RuleTreeCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_RuleTree_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTree ruleTree=new RuleTree();
        ruleTree.setId(request.getId());    		
        ruleTree.setRuleTreeName(request.getRuleTreeName());
        ruleTree.setVersion(request.getVersion());
        ruleTree.setStatus(request.getStatus());
        ruleTree.setOutputWay(request.getOutputWay());
        ruleTree.setModifyDate(request.getModifyDate());
        ruleTree.setModifyed(request.getModifyed());
        ruleTree.setOwner(request.getOwner());
        ruleTree.setLocked(request.getLocked());
    	ruleTreeService.createRuleTree(ruleTree);
        //返回响应
        RuleTreeCreateResponse ruleTreeCreateResponse = new RuleTreeCreateResponse();
        ruleTreeCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTreeCreateResponse.setResultJson(ruleTree);
        return ruleTreeCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.deleteRuleTree", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteRuleTree(RuleTreeDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_RuleTree_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ruleTreeService.deleteRuleTree(idstr);
        //返回响应
        RuleTreeDeleteResponse ruleTreeDeleteResponse = new RuleTreeDeleteResponse();
        ruleTreeDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleTreeDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.updateRuleTree", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateRuleTree(RuleTreeUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_RuleTree_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTree ruleTree=new RuleTree();
        ruleTree=ruleTreeService.getRuleTree(request.getId());
        if (request.getId()!=null){
	        ruleTree.setId(request.getId());
        }
        if (request.getRuleTreeName()!=null){
	        ruleTree.setRuleTreeName(request.getRuleTreeName());
        }
        if (request.getVersion()!=null){
	        ruleTree.setVersion(request.getVersion());
        }
        if (request.getStatus()!=null){
	        ruleTree.setStatus(request.getStatus());
        }
        if (request.getOutputWay()!=null){
	        ruleTree.setOutputWay(request.getOutputWay());
        }
        if (request.getModifyDate()!=null){
	        ruleTree.setModifyDate(request.getModifyDate());
        }
        if (request.getModifyed()!=null){
	        ruleTree.setModifyed(request.getModifyed());
        }
        if (request.getOwner()!=null){
	        ruleTree.setOwner(request.getOwner());
        }
        if (request.getLocked()!=null){
	        ruleTree.setLocked(request.getLocked());
        }
    	ruleTreeService.updateRuleTree(ruleTree);
        //返回响应
        RuleTreeUpdateResponse ruleTreeUpdateResponse = new RuleTreeUpdateResponse();
        ruleTreeUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTreeUpdateResponse.setResultJson(ruleTree);
        return ruleTreeUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.getRuleTree", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getRuleTree(RuleTreeGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        RuleTree ruleTree=new RuleTree();
        ruleTree=ruleTreeService.getRuleTree(id);
        //返回响应
        RuleTreeGetResponse ruleTreeGetResponse = new RuleTreeGetResponse();
        ruleTreeGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTreeGetResponse.setResultJson(ruleTree);
        return ruleTreeGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(RuleTreeSelectAllRequest request) {
        RuleTreeSelectAllResponse ruleTreeSelectAllResponse = new RuleTreeSelectAllResponse();
        ruleTreeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTreeSelectAllResponse.setResultJson(ruleTreeService.selectAll());
        return ruleTreeSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(RuleTreeCountAllRequest request) {
        RuleTreeCountAllResponse ruleTreeCountAllResponse = new RuleTreeCountAllResponse();
        ruleTreeCountAllResponse.setResultString(String.valueOf(ruleTreeService.countAll()));
        ruleTreeCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleTreeCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(RuleTreeSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        RuleTreeSelectAllResponse ruleTreeSelectAllResponse = new RuleTreeSelectAllResponse();
        ruleTreeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTreeSelectAllResponse.setResultJson(ruleTreeService.selectBySql(sqlstr));
        return ruleTreeSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.selectRuleTree", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(RuleTreeSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_RuleTree_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTree ruleTree=new RuleTree();
        ruleTree.setId(request.getId());
        ruleTree.setRuleTreeName(request.getRuleTreeName());
        ruleTree.setVersion(request.getVersion());
        ruleTree.setStatus(request.getStatus());
        ruleTree.setOutputWay(request.getOutputWay());
        ruleTree.setModifyDate(request.getModifyDate());
        ruleTree.setModifyed(request.getModifyed());
        ruleTree.setOwner(request.getOwner());
        ruleTree.setLocked(request.getLocked());
    	RuleTreeSelectResponse ruleTreeSelectResponse = new RuleTreeSelectResponse();
        ruleTreeSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<RuleTree> ruleTrees= ruleTreeService.selectWithCondition(ruleTree);
        ruleTreeSelectResponse.setResultJson(ruleTrees);
        return ruleTreeSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTree.isExistRuleTree", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistRuleTree(RuleTreeSelectRequest request) {
        RuleTree ruleTree=new RuleTree();
        ruleTree.setId(request.getId());
        ruleTree.setRuleTreeName(request.getRuleTreeName());
        ruleTree.setVersion(request.getVersion());
        ruleTree.setStatus(request.getStatus());
        ruleTree.setOutputWay(request.getOutputWay());
        ruleTree.setModifyDate(request.getModifyDate());
        ruleTree.setModifyed(request.getModifyed());
        ruleTree.setOwner(request.getOwner());
        ruleTree.setLocked(request.getLocked());
        ArrayList<RuleTree> ruleTrees= ruleTreeService.selectWithCondition(ruleTree);
    	RuleTreeCountAllResponse ruleTreeCountAllResponse = new RuleTreeCountAllResponse();
        if (ruleTrees.size()>0){
        	ruleTreeCountAllResponse.setResultString("1");
        } else {
        	ruleTreeCountAllResponse.setResultString("0");
        }        
        return ruleTreeCountAllResponse;
    }

    public Boolean validateCreateRequest(RuleTreeCreateRequest request){
    	RuleTree ruleTree=new RuleTree();
    	ruleTree.setId(request.getId());
        ArrayList<RuleTree> ruleTrees= ruleTreeService.selectWithCondition(ruleTree);
        if (ruleTrees!=null&&ruleTrees.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(RuleTreeUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(RuleTreeDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(RuleTreeSelectRequest request){
        return  true;
     }    
}
