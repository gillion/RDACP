/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTreeOutput;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ruleTreeOutput.request.*;
import com.cartan.center.ebs.ruleTreeOutput.response.*;
import com.cartan.core.ruleTreeOutput.domain.RuleTreeOutput;
import com.cartan.core.ruleTreeOutput.service.RuleTreeOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class RuleTreeOutputServiceEbsBase {
    static Logger logger = Logger.getLogger(RuleTreeOutputServiceEbs.class.getName());
	private RuleTreeOutputService  ruleTreeOutputService;
	
    public RuleTreeOutputService getRuleTreeOutputService() {
        return ruleTreeOutputService;
    }

    @Autowired
    public void setRuleTreeOutputService(RuleTreeOutputService ruleTreeOutputService) {
        this.ruleTreeOutputService = ruleTreeOutputService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(RuleTreeOutputGetSessionRequest request) {      
    	RuleTreeOutputGetSessionResponse ruleTreeOutputGetSessionResponse = new RuleTreeOutputGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleTreeOutputGetSessionResponse.setResultString("0");
        } else {
        	ruleTreeOutputGetSessionResponse.setResultString("1");
            ruleTreeOutputGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ruleTreeOutputGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(RuleTreeOutputGetSessionRequest request) {
    	RuleTreeOutputGetSessionResponse ruleTreeOutputGetSessionResponse = new RuleTreeOutputGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ruleTreeOutputGetSessionResponse.setResultString("1");
        } else {
        	ruleTreeOutputGetSessionResponse.setResultString("0");
        }
        ruleTreeOutputGetSessionResponse.setSessionId(request.getSessionId());
        return ruleTreeOutputGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(RuleTreeOutputGetSessionRequest request) {
    	RuleTreeOutputGetSessionResponse ruleTreeOutputGetSessionResponse = new RuleTreeOutputGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleTreeOutputGetSessionResponse.setResultString("0");
        	ruleTreeOutputGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ruleTreeOutputGetSessionResponse.setResultString("1");
        }
        return ruleTreeOutputGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.createRuleTreeOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createRuleTreeOutput(RuleTreeOutputCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_RuleTreeOutput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTreeOutput ruleTreeOutput=new RuleTreeOutput();
        ruleTreeOutput.setId(request.getId());    		
        ruleTreeOutput.setRuleTreeId(request.getRuleTreeId());
        ruleTreeOutput.setTreeNodeCode(request.getTreeNodeCode());
        ruleTreeOutput.setTreeNodeName(request.getTreeNodeName());
        ruleTreeOutput.setOutputVer(request.getOutputVer());
        ruleTreeOutput.setOutputValue(request.getOutputValue());
    	ruleTreeOutputService.createRuleTreeOutput(ruleTreeOutput);
        //返回响应
        RuleTreeOutputCreateResponse ruleTreeOutputCreateResponse = new RuleTreeOutputCreateResponse();
        ruleTreeOutputCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTreeOutputCreateResponse.setResultJson(ruleTreeOutput);
        return ruleTreeOutputCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.deleteRuleTreeOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteRuleTreeOutput(RuleTreeOutputDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_RuleTreeOutput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ruleTreeOutputService.deleteRuleTreeOutput(idstr);
        //返回响应
        RuleTreeOutputDeleteResponse ruleTreeOutputDeleteResponse = new RuleTreeOutputDeleteResponse();
        ruleTreeOutputDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleTreeOutputDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.updateRuleTreeOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateRuleTreeOutput(RuleTreeOutputUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_RuleTreeOutput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTreeOutput ruleTreeOutput=new RuleTreeOutput();
        ruleTreeOutput=ruleTreeOutputService.getRuleTreeOutput(request.getId());
        if (request.getId()!=null){
	        ruleTreeOutput.setId(request.getId());
        }
        if (request.getRuleTreeId()!=null){
	        ruleTreeOutput.setRuleTreeId(request.getRuleTreeId());
        }
        if (request.getTreeNodeCode()!=null){
	        ruleTreeOutput.setTreeNodeCode(request.getTreeNodeCode());
        }
        if (request.getTreeNodeName()!=null){
	        ruleTreeOutput.setTreeNodeName(request.getTreeNodeName());
        }
        if (request.getOutputVer()!=null){
	        ruleTreeOutput.setOutputVer(request.getOutputVer());
        }
        if (request.getOutputValue()!=null){
	        ruleTreeOutput.setOutputValue(request.getOutputValue());
        }
    	ruleTreeOutputService.updateRuleTreeOutput(ruleTreeOutput);
        //返回响应
        RuleTreeOutputUpdateResponse ruleTreeOutputUpdateResponse = new RuleTreeOutputUpdateResponse();
        ruleTreeOutputUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTreeOutputUpdateResponse.setResultJson(ruleTreeOutput);
        return ruleTreeOutputUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.getRuleTreeOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getRuleTreeOutput(RuleTreeOutputGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        RuleTreeOutput ruleTreeOutput=new RuleTreeOutput();
        ruleTreeOutput=ruleTreeOutputService.getRuleTreeOutput(id);
        //返回响应
        RuleTreeOutputGetResponse ruleTreeOutputGetResponse = new RuleTreeOutputGetResponse();
        ruleTreeOutputGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTreeOutputGetResponse.setResultJson(ruleTreeOutput);
        return ruleTreeOutputGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(RuleTreeOutputSelectAllRequest request) {
        RuleTreeOutputSelectAllResponse ruleTreeOutputSelectAllResponse = new RuleTreeOutputSelectAllResponse();
        ruleTreeOutputSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTreeOutputSelectAllResponse.setResultJson(ruleTreeOutputService.selectAll());
        return ruleTreeOutputSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(RuleTreeOutputCountAllRequest request) {
        RuleTreeOutputCountAllResponse ruleTreeOutputCountAllResponse = new RuleTreeOutputCountAllResponse();
        ruleTreeOutputCountAllResponse.setResultString(String.valueOf(ruleTreeOutputService.countAll()));
        ruleTreeOutputCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleTreeOutputCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(RuleTreeOutputSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        RuleTreeOutputSelectAllResponse ruleTreeOutputSelectAllResponse = new RuleTreeOutputSelectAllResponse();
        ruleTreeOutputSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTreeOutputSelectAllResponse.setResultJson(ruleTreeOutputService.selectBySql(sqlstr));
        return ruleTreeOutputSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.selectRuleTreeOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(RuleTreeOutputSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_RuleTreeOutput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTreeOutput ruleTreeOutput=new RuleTreeOutput();
        ruleTreeOutput.setId(request.getId());
        ruleTreeOutput.setRuleTreeId(request.getRuleTreeId());
        ruleTreeOutput.setTreeNodeCode(request.getTreeNodeCode());
        ruleTreeOutput.setTreeNodeName(request.getTreeNodeName());
        ruleTreeOutput.setOutputVer(request.getOutputVer());
        ruleTreeOutput.setOutputValue(request.getOutputValue());
    	RuleTreeOutputSelectResponse ruleTreeOutputSelectResponse = new RuleTreeOutputSelectResponse();
        ruleTreeOutputSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<RuleTreeOutput> ruleTreeOutputs= ruleTreeOutputService.selectWithCondition(ruleTreeOutput);
        ruleTreeOutputSelectResponse.setResultJson(ruleTreeOutputs);
        return ruleTreeOutputSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTreeOutput.isExistRuleTreeOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistRuleTreeOutput(RuleTreeOutputSelectRequest request) {
        RuleTreeOutput ruleTreeOutput=new RuleTreeOutput();
        ruleTreeOutput.setId(request.getId());
        ruleTreeOutput.setRuleTreeId(request.getRuleTreeId());
        ruleTreeOutput.setTreeNodeCode(request.getTreeNodeCode());
        ruleTreeOutput.setTreeNodeName(request.getTreeNodeName());
        ruleTreeOutput.setOutputVer(request.getOutputVer());
        ruleTreeOutput.setOutputValue(request.getOutputValue());
        ArrayList<RuleTreeOutput> ruleTreeOutputs= ruleTreeOutputService.selectWithCondition(ruleTreeOutput);
    	RuleTreeOutputCountAllResponse ruleTreeOutputCountAllResponse = new RuleTreeOutputCountAllResponse();
        if (ruleTreeOutputs.size()>0){
        	ruleTreeOutputCountAllResponse.setResultString("1");
        } else {
        	ruleTreeOutputCountAllResponse.setResultString("0");
        }        
        return ruleTreeOutputCountAllResponse;
    }

    public Boolean validateCreateRequest(RuleTreeOutputCreateRequest request){
    	RuleTreeOutput ruleTreeOutput=new RuleTreeOutput();
    	ruleTreeOutput.setId(request.getId());
        ArrayList<RuleTreeOutput> ruleTreeOutputs= ruleTreeOutputService.selectWithCondition(ruleTreeOutput);
        if (ruleTreeOutputs!=null&&ruleTreeOutputs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(RuleTreeOutputUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(RuleTreeOutputDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(RuleTreeOutputSelectRequest request){
        return  true;
     }    
}
