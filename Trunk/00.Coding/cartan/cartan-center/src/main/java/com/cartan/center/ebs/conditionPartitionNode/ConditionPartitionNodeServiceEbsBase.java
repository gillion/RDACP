/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.conditionPartitionNode;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.conditionPartitionNode.request.*;
import com.cartan.center.ebs.conditionPartitionNode.response.*;
import com.cartan.core.conditionPartitionNode.domain.ConditionPartitionNode;
import com.cartan.core.conditionPartitionNode.service.ConditionPartitionNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class ConditionPartitionNodeServiceEbsBase {
    static Logger logger = Logger.getLogger(ConditionPartitionNodeServiceEbs.class.getName());
	private ConditionPartitionNodeService  conditionPartitionNodeService;
	
    public ConditionPartitionNodeService getConditionPartitionNodeService() {
        return conditionPartitionNodeService;
    }

    @Autowired
    public void setConditionPartitionNodeService(ConditionPartitionNodeService conditionPartitionNodeService) {
        this.conditionPartitionNodeService = conditionPartitionNodeService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(ConditionPartitionNodeGetSessionRequest request) {      
    	ConditionPartitionNodeGetSessionResponse conditionPartitionNodeGetSessionResponse = new ConditionPartitionNodeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	conditionPartitionNodeGetSessionResponse.setResultString("0");
        } else {
        	conditionPartitionNodeGetSessionResponse.setResultString("1");
            conditionPartitionNodeGetSessionResponse.setSessionId(request.getSessionId());
        }
        return conditionPartitionNodeGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(ConditionPartitionNodeGetSessionRequest request) {
    	ConditionPartitionNodeGetSessionResponse conditionPartitionNodeGetSessionResponse = new ConditionPartitionNodeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            conditionPartitionNodeGetSessionResponse.setResultString("1");
        } else {
        	conditionPartitionNodeGetSessionResponse.setResultString("0");
        }
        conditionPartitionNodeGetSessionResponse.setSessionId(request.getSessionId());
        return conditionPartitionNodeGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(ConditionPartitionNodeGetSessionRequest request) {
    	ConditionPartitionNodeGetSessionResponse conditionPartitionNodeGetSessionResponse = new ConditionPartitionNodeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	conditionPartitionNodeGetSessionResponse.setResultString("0");
        	conditionPartitionNodeGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            conditionPartitionNodeGetSessionResponse.setResultString("1");
        }
        return conditionPartitionNodeGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.createConditionPartitionNode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createConditionPartitionNode(ConditionPartitionNodeCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_ConditionPartitionNode_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        ConditionPartitionNode conditionPartitionNode=new ConditionPartitionNode();
        conditionPartitionNode.setId(request.getId());    		
        conditionPartitionNode.setConPartitionId(request.getConPartitionId());
        conditionPartitionNode.setConNodeName(request.getConNodeName());
        conditionPartitionNode.setRelationMark(request.getRelationMark());
        conditionPartitionNode.setVarName(request.getVarName());
        conditionPartitionNode.setOptChar(request.getOptChar());
        conditionPartitionNode.setCompareValue(request.getCompareValue());
    	conditionPartitionNodeService.createConditionPartitionNode(conditionPartitionNode);
        //返回响应
        ConditionPartitionNodeCreateResponse conditionPartitionNodeCreateResponse = new ConditionPartitionNodeCreateResponse();
        conditionPartitionNodeCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        conditionPartitionNodeCreateResponse.setResultJson(conditionPartitionNode);
        return conditionPartitionNodeCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.deleteConditionPartitionNode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteConditionPartitionNode(ConditionPartitionNodeDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_ConditionPartitionNode_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        conditionPartitionNodeService.deleteConditionPartitionNode(idstr);
        //返回响应
        ConditionPartitionNodeDeleteResponse conditionPartitionNodeDeleteResponse = new ConditionPartitionNodeDeleteResponse();
        conditionPartitionNodeDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return conditionPartitionNodeDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.updateConditionPartitionNode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateConditionPartitionNode(ConditionPartitionNodeUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_ConditionPartitionNode_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        ConditionPartitionNode conditionPartitionNode=new ConditionPartitionNode();
        conditionPartitionNode=conditionPartitionNodeService.getConditionPartitionNode(request.getId());
        if (request.getId()!=null){
	        conditionPartitionNode.setId(request.getId());
        }
        if (request.getConPartitionId()!=null){
	        conditionPartitionNode.setConPartitionId(request.getConPartitionId());
        }
        if (request.getConNodeName()!=null){
	        conditionPartitionNode.setConNodeName(request.getConNodeName());
        }
        if (request.getRelationMark()!=null){
	        conditionPartitionNode.setRelationMark(request.getRelationMark());
        }
        if (request.getVarName()!=null){
	        conditionPartitionNode.setVarName(request.getVarName());
        }
        if (request.getOptChar()!=null){
	        conditionPartitionNode.setOptChar(request.getOptChar());
        }
        if (request.getCompareValue()!=null){
	        conditionPartitionNode.setCompareValue(request.getCompareValue());
        }
    	conditionPartitionNodeService.updateConditionPartitionNode(conditionPartitionNode);
        //返回响应
        ConditionPartitionNodeUpdateResponse conditionPartitionNodeUpdateResponse = new ConditionPartitionNodeUpdateResponse();
        conditionPartitionNodeUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        conditionPartitionNodeUpdateResponse.setResultJson(conditionPartitionNode);
        return conditionPartitionNodeUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.getConditionPartitionNode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getConditionPartitionNode(ConditionPartitionNodeGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        ConditionPartitionNode conditionPartitionNode=new ConditionPartitionNode();
        conditionPartitionNode=conditionPartitionNodeService.getConditionPartitionNode(id);
        //返回响应
        ConditionPartitionNodeGetResponse conditionPartitionNodeGetResponse = new ConditionPartitionNodeGetResponse();
        conditionPartitionNodeGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        conditionPartitionNodeGetResponse.setResultJson(conditionPartitionNode);
        return conditionPartitionNodeGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(ConditionPartitionNodeSelectAllRequest request) {
        ConditionPartitionNodeSelectAllResponse conditionPartitionNodeSelectAllResponse = new ConditionPartitionNodeSelectAllResponse();
        conditionPartitionNodeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        conditionPartitionNodeSelectAllResponse.setResultJson(conditionPartitionNodeService.selectAll());
        return conditionPartitionNodeSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(ConditionPartitionNodeCountAllRequest request) {
        ConditionPartitionNodeCountAllResponse conditionPartitionNodeCountAllResponse = new ConditionPartitionNodeCountAllResponse();
        conditionPartitionNodeCountAllResponse.setResultString(String.valueOf(conditionPartitionNodeService.countAll()));
        conditionPartitionNodeCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return conditionPartitionNodeCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(ConditionPartitionNodeSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        ConditionPartitionNodeSelectAllResponse conditionPartitionNodeSelectAllResponse = new ConditionPartitionNodeSelectAllResponse();
        conditionPartitionNodeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        conditionPartitionNodeSelectAllResponse.setResultJson(conditionPartitionNodeService.selectBySql(sqlstr));
        return conditionPartitionNodeSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.selectConditionPartitionNode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(ConditionPartitionNodeSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_ConditionPartitionNode_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        ConditionPartitionNode conditionPartitionNode=new ConditionPartitionNode();
        conditionPartitionNode.setId(request.getId());
        conditionPartitionNode.setConPartitionId(request.getConPartitionId());
        conditionPartitionNode.setConNodeName(request.getConNodeName());
        conditionPartitionNode.setRelationMark(request.getRelationMark());
        conditionPartitionNode.setVarName(request.getVarName());
        conditionPartitionNode.setOptChar(request.getOptChar());
        conditionPartitionNode.setCompareValue(request.getCompareValue());
    	ConditionPartitionNodeSelectResponse conditionPartitionNodeSelectResponse = new ConditionPartitionNodeSelectResponse();
        conditionPartitionNodeSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<ConditionPartitionNode> conditionPartitionNodes= conditionPartitionNodeService.selectWithCondition(conditionPartitionNode);
        conditionPartitionNodeSelectResponse.setResultJson(conditionPartitionNodes);
        return conditionPartitionNodeSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartitionNode.isExistConditionPartitionNode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistConditionPartitionNode(ConditionPartitionNodeSelectRequest request) {
        ConditionPartitionNode conditionPartitionNode=new ConditionPartitionNode();
        conditionPartitionNode.setId(request.getId());
        conditionPartitionNode.setConPartitionId(request.getConPartitionId());
        conditionPartitionNode.setConNodeName(request.getConNodeName());
        conditionPartitionNode.setRelationMark(request.getRelationMark());
        conditionPartitionNode.setVarName(request.getVarName());
        conditionPartitionNode.setOptChar(request.getOptChar());
        conditionPartitionNode.setCompareValue(request.getCompareValue());
        ArrayList<ConditionPartitionNode> conditionPartitionNodes= conditionPartitionNodeService.selectWithCondition(conditionPartitionNode);
    	ConditionPartitionNodeCountAllResponse conditionPartitionNodeCountAllResponse = new ConditionPartitionNodeCountAllResponse();
        if (conditionPartitionNodes.size()>0){
        	conditionPartitionNodeCountAllResponse.setResultString("1");
        } else {
        	conditionPartitionNodeCountAllResponse.setResultString("0");
        }        
        return conditionPartitionNodeCountAllResponse;
    }

    public Boolean validateCreateRequest(ConditionPartitionNodeCreateRequest request){
    	ConditionPartitionNode conditionPartitionNode=new ConditionPartitionNode();
    	conditionPartitionNode.setId(request.getId());
        ArrayList<ConditionPartitionNode> conditionPartitionNodes= conditionPartitionNodeService.selectWithCondition(conditionPartitionNode);
        if (conditionPartitionNodes!=null&&conditionPartitionNodes.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(ConditionPartitionNodeUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(ConditionPartitionNodeDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(ConditionPartitionNodeSelectRequest request){
        return  true;
     }    
}
