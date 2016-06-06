/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTable;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ruleTable.request.*;
import com.cartan.center.ebs.ruleTable.response.*;
import com.cartan.core.ruleTable.domain.RuleTable;
import com.cartan.core.ruleTable.service.RuleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class RuleTableServiceEbsBase {
    static Logger logger = Logger.getLogger(RuleTableServiceEbs.class.getName());
	private RuleTableService  ruleTableService;
	
    public RuleTableService getRuleTableService() {
        return ruleTableService;
    }

    @Autowired
    public void setRuleTableService(RuleTableService ruleTableService) {
        this.ruleTableService = ruleTableService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(RuleTableGetSessionRequest request) {      
    	RuleTableGetSessionResponse ruleTableGetSessionResponse = new RuleTableGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleTableGetSessionResponse.setResultString("0");
        } else {
        	ruleTableGetSessionResponse.setResultString("1");
            ruleTableGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ruleTableGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(RuleTableGetSessionRequest request) {
    	RuleTableGetSessionResponse ruleTableGetSessionResponse = new RuleTableGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ruleTableGetSessionResponse.setResultString("1");
        } else {
        	ruleTableGetSessionResponse.setResultString("0");
        }
        ruleTableGetSessionResponse.setSessionId(request.getSessionId());
        return ruleTableGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(RuleTableGetSessionRequest request) {
    	RuleTableGetSessionResponse ruleTableGetSessionResponse = new RuleTableGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleTableGetSessionResponse.setResultString("0");
        	ruleTableGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ruleTableGetSessionResponse.setResultString("1");
        }
        return ruleTableGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.createRuleTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createRuleTable(RuleTableCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_RuleTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTable ruleTable=new RuleTable();
        ruleTable.setId(request.getId());    		
        ruleTable.setRuleTableName(request.getRuleTableName());
        ruleTable.setVersion(request.getVersion());
        ruleTable.setStatus(request.getStatus());
        ruleTable.setModifyDate(request.getModifyDate());
        ruleTable.setModifyed(request.getModifyed());
        ruleTable.setOwner(request.getOwner());
        ruleTable.setLocked(request.getLocked());
    	ruleTableService.createRuleTable(ruleTable);
        //返回响应
        RuleTableCreateResponse ruleTableCreateResponse = new RuleTableCreateResponse();
        ruleTableCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableCreateResponse.setResultJson(ruleTable);
        return ruleTableCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.deleteRuleTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteRuleTable(RuleTableDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_RuleTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ruleTableService.deleteRuleTable(idstr);
        //返回响应
        RuleTableDeleteResponse ruleTableDeleteResponse = new RuleTableDeleteResponse();
        ruleTableDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleTableDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.updateRuleTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateRuleTable(RuleTableUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_RuleTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTable ruleTable=new RuleTable();
        ruleTable=ruleTableService.getRuleTable(request.getId());
        if (request.getId()!=null){
	        ruleTable.setId(request.getId());
        }
        if (request.getRuleTableName()!=null){
	        ruleTable.setRuleTableName(request.getRuleTableName());
        }
        if (request.getVersion()!=null){
	        ruleTable.setVersion(request.getVersion());
        }
        if (request.getStatus()!=null){
	        ruleTable.setStatus(request.getStatus());
        }
        if (request.getModifyDate()!=null){
	        ruleTable.setModifyDate(request.getModifyDate());
        }
        if (request.getModifyed()!=null){
	        ruleTable.setModifyed(request.getModifyed());
        }
        if (request.getOwner()!=null){
	        ruleTable.setOwner(request.getOwner());
        }
        if (request.getLocked()!=null){
	        ruleTable.setLocked(request.getLocked());
        }
    	ruleTableService.updateRuleTable(ruleTable);
        //返回响应
        RuleTableUpdateResponse ruleTableUpdateResponse = new RuleTableUpdateResponse();
        ruleTableUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableUpdateResponse.setResultJson(ruleTable);
        return ruleTableUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.getRuleTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getRuleTable(RuleTableGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        RuleTable ruleTable=new RuleTable();
        ruleTable=ruleTableService.getRuleTable(id);
        //返回响应
        RuleTableGetResponse ruleTableGetResponse = new RuleTableGetResponse();
        ruleTableGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableGetResponse.setResultJson(ruleTable);
        return ruleTableGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(RuleTableSelectAllRequest request) {
        RuleTableSelectAllResponse ruleTableSelectAllResponse = new RuleTableSelectAllResponse();
        ruleTableSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableSelectAllResponse.setResultJson(ruleTableService.selectAll());
        return ruleTableSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(RuleTableCountAllRequest request) {
        RuleTableCountAllResponse ruleTableCountAllResponse = new RuleTableCountAllResponse();
        ruleTableCountAllResponse.setResultString(String.valueOf(ruleTableService.countAll()));
        ruleTableCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleTableCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(RuleTableSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        RuleTableSelectAllResponse ruleTableSelectAllResponse = new RuleTableSelectAllResponse();
        ruleTableSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableSelectAllResponse.setResultJson(ruleTableService.selectBySql(sqlstr));
        return ruleTableSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.selectRuleTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(RuleTableSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_RuleTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTable ruleTable=new RuleTable();
        ruleTable.setId(request.getId());
        ruleTable.setRuleTableName(request.getRuleTableName());
        ruleTable.setVersion(request.getVersion());
        ruleTable.setStatus(request.getStatus());
        ruleTable.setModifyDate(request.getModifyDate());
        ruleTable.setModifyed(request.getModifyed());
        ruleTable.setOwner(request.getOwner());
        ruleTable.setLocked(request.getLocked());
    	RuleTableSelectResponse ruleTableSelectResponse = new RuleTableSelectResponse();
        ruleTableSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<RuleTable> ruleTables= ruleTableService.selectWithCondition(ruleTable);
        ruleTableSelectResponse.setResultJson(ruleTables);
        return ruleTableSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTable.isExistRuleTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistRuleTable(RuleTableSelectRequest request) {
        RuleTable ruleTable=new RuleTable();
        ruleTable.setId(request.getId());
        ruleTable.setRuleTableName(request.getRuleTableName());
        ruleTable.setVersion(request.getVersion());
        ruleTable.setStatus(request.getStatus());
        ruleTable.setModifyDate(request.getModifyDate());
        ruleTable.setModifyed(request.getModifyed());
        ruleTable.setOwner(request.getOwner());
        ruleTable.setLocked(request.getLocked());
        ArrayList<RuleTable> ruleTables= ruleTableService.selectWithCondition(ruleTable);
    	RuleTableCountAllResponse ruleTableCountAllResponse = new RuleTableCountAllResponse();
        if (ruleTables.size()>0){
        	ruleTableCountAllResponse.setResultString("1");
        } else {
        	ruleTableCountAllResponse.setResultString("0");
        }        
        return ruleTableCountAllResponse;
    }

    public Boolean validateCreateRequest(RuleTableCreateRequest request){
    	RuleTable ruleTable=new RuleTable();
    	ruleTable.setId(request.getId());
        ArrayList<RuleTable> ruleTables= ruleTableService.selectWithCondition(ruleTable);
        if (ruleTables!=null&&ruleTables.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(RuleTableUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(RuleTableDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(RuleTableSelectRequest request){
        return  true;
     }    
}
