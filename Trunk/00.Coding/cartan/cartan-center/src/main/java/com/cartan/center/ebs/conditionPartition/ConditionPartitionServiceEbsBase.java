/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.conditionPartition;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.conditionPartition.request.*;
import com.cartan.center.ebs.conditionPartition.response.*;
import com.cartan.core.conditionPartition.domain.ConditionPartition;
import com.cartan.core.conditionPartition.service.ConditionPartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class ConditionPartitionServiceEbsBase {
    static Logger logger = Logger.getLogger(ConditionPartitionServiceEbs.class.getName());
	private ConditionPartitionService  conditionPartitionService;
	
    public ConditionPartitionService getConditionPartitionService() {
        return conditionPartitionService;
    }

    @Autowired
    public void setConditionPartitionService(ConditionPartitionService conditionPartitionService) {
        this.conditionPartitionService = conditionPartitionService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(ConditionPartitionGetSessionRequest request) {      
    	ConditionPartitionGetSessionResponse conditionPartitionGetSessionResponse = new ConditionPartitionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	conditionPartitionGetSessionResponse.setResultString("0");
        } else {
        	conditionPartitionGetSessionResponse.setResultString("1");
            conditionPartitionGetSessionResponse.setSessionId(request.getSessionId());
        }
        return conditionPartitionGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(ConditionPartitionGetSessionRequest request) {
    	ConditionPartitionGetSessionResponse conditionPartitionGetSessionResponse = new ConditionPartitionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            conditionPartitionGetSessionResponse.setResultString("1");
        } else {
        	conditionPartitionGetSessionResponse.setResultString("0");
        }
        conditionPartitionGetSessionResponse.setSessionId(request.getSessionId());
        return conditionPartitionGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(ConditionPartitionGetSessionRequest request) {
    	ConditionPartitionGetSessionResponse conditionPartitionGetSessionResponse = new ConditionPartitionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	conditionPartitionGetSessionResponse.setResultString("0");
        	conditionPartitionGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            conditionPartitionGetSessionResponse.setResultString("1");
        }
        return conditionPartitionGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.createConditionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createConditionPartition(ConditionPartitionCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_ConditionPartition_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        ConditionPartition conditionPartition=new ConditionPartition();
        conditionPartition.setId(request.getId());    		
        conditionPartition.setConditionName(request.getConditionName());
        conditionPartition.setStatus(request.getStatus());
        conditionPartition.setModifyDate(request.getModifyDate());
        conditionPartition.setModifyed(request.getModifyed());
        conditionPartition.setOwner(request.getOwner());
        conditionPartition.setLocked(request.getLocked());
    	conditionPartitionService.createConditionPartition(conditionPartition);
        //返回响应
        ConditionPartitionCreateResponse conditionPartitionCreateResponse = new ConditionPartitionCreateResponse();
        conditionPartitionCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        conditionPartitionCreateResponse.setResultJson(conditionPartition);
        return conditionPartitionCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.deleteConditionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteConditionPartition(ConditionPartitionDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_ConditionPartition_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        conditionPartitionService.deleteConditionPartition(idstr);
        //返回响应
        ConditionPartitionDeleteResponse conditionPartitionDeleteResponse = new ConditionPartitionDeleteResponse();
        conditionPartitionDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return conditionPartitionDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.updateConditionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateConditionPartition(ConditionPartitionUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_ConditionPartition_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        ConditionPartition conditionPartition=new ConditionPartition();
        conditionPartition=conditionPartitionService.getConditionPartition(request.getId());
        if (request.getId()!=null){
	        conditionPartition.setId(request.getId());
        }
        if (request.getConditionName()!=null){
	        conditionPartition.setConditionName(request.getConditionName());
        }
        if (request.getStatus()!=null){
	        conditionPartition.setStatus(request.getStatus());
        }
        if (request.getModifyDate()!=null){
	        conditionPartition.setModifyDate(request.getModifyDate());
        }
        if (request.getModifyed()!=null){
	        conditionPartition.setModifyed(request.getModifyed());
        }
        if (request.getOwner()!=null){
	        conditionPartition.setOwner(request.getOwner());
        }
        if (request.getLocked()!=null){
	        conditionPartition.setLocked(request.getLocked());
        }
    	conditionPartitionService.updateConditionPartition(conditionPartition);
        //返回响应
        ConditionPartitionUpdateResponse conditionPartitionUpdateResponse = new ConditionPartitionUpdateResponse();
        conditionPartitionUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        conditionPartitionUpdateResponse.setResultJson(conditionPartition);
        return conditionPartitionUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.getConditionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getConditionPartition(ConditionPartitionGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        ConditionPartition conditionPartition=new ConditionPartition();
        conditionPartition=conditionPartitionService.getConditionPartition(id);
        //返回响应
        ConditionPartitionGetResponse conditionPartitionGetResponse = new ConditionPartitionGetResponse();
        conditionPartitionGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        conditionPartitionGetResponse.setResultJson(conditionPartition);
        return conditionPartitionGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(ConditionPartitionSelectAllRequest request) {
        ConditionPartitionSelectAllResponse conditionPartitionSelectAllResponse = new ConditionPartitionSelectAllResponse();
        conditionPartitionSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        conditionPartitionSelectAllResponse.setResultJson(conditionPartitionService.selectAll());
        return conditionPartitionSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(ConditionPartitionCountAllRequest request) {
        ConditionPartitionCountAllResponse conditionPartitionCountAllResponse = new ConditionPartitionCountAllResponse();
        conditionPartitionCountAllResponse.setResultString(String.valueOf(conditionPartitionService.countAll()));
        conditionPartitionCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return conditionPartitionCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(ConditionPartitionSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        ConditionPartitionSelectAllResponse conditionPartitionSelectAllResponse = new ConditionPartitionSelectAllResponse();
        conditionPartitionSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        conditionPartitionSelectAllResponse.setResultJson(conditionPartitionService.selectBySql(sqlstr));
        return conditionPartitionSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.selectConditionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(ConditionPartitionSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_ConditionPartition_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        ConditionPartition conditionPartition=new ConditionPartition();
        conditionPartition.setId(request.getId());
        conditionPartition.setConditionName(request.getConditionName());
        conditionPartition.setStatus(request.getStatus());
        conditionPartition.setModifyDate(request.getModifyDate());
        conditionPartition.setModifyed(request.getModifyed());
        conditionPartition.setOwner(request.getOwner());
        conditionPartition.setLocked(request.getLocked());
    	ConditionPartitionSelectResponse conditionPartitionSelectResponse = new ConditionPartitionSelectResponse();
        conditionPartitionSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<ConditionPartition> conditionPartitions= conditionPartitionService.selectWithCondition(conditionPartition);
        conditionPartitionSelectResponse.setResultJson(conditionPartitions);
        return conditionPartitionSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "conditionPartition.isExistConditionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistConditionPartition(ConditionPartitionSelectRequest request) {
        ConditionPartition conditionPartition=new ConditionPartition();
        conditionPartition.setId(request.getId());
        conditionPartition.setConditionName(request.getConditionName());
        conditionPartition.setStatus(request.getStatus());
        conditionPartition.setModifyDate(request.getModifyDate());
        conditionPartition.setModifyed(request.getModifyed());
        conditionPartition.setOwner(request.getOwner());
        conditionPartition.setLocked(request.getLocked());
        ArrayList<ConditionPartition> conditionPartitions= conditionPartitionService.selectWithCondition(conditionPartition);
    	ConditionPartitionCountAllResponse conditionPartitionCountAllResponse = new ConditionPartitionCountAllResponse();
        if (conditionPartitions.size()>0){
        	conditionPartitionCountAllResponse.setResultString("1");
        } else {
        	conditionPartitionCountAllResponse.setResultString("0");
        }        
        return conditionPartitionCountAllResponse;
    }

    public Boolean validateCreateRequest(ConditionPartitionCreateRequest request){
    	ConditionPartition conditionPartition=new ConditionPartition();
    	conditionPartition.setId(request.getId());
        ArrayList<ConditionPartition> conditionPartitions= conditionPartitionService.selectWithCondition(conditionPartition);
        if (conditionPartitions!=null&&conditionPartitions.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(ConditionPartitionUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(ConditionPartitionDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(ConditionPartitionSelectRequest request){
        return  true;
     }    
}
