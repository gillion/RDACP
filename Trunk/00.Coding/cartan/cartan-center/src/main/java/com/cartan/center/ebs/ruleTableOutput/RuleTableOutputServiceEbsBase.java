/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTableOutput;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ruleTableOutput.request.*;
import com.cartan.center.ebs.ruleTableOutput.response.*;
import com.cartan.core.ruleTableOutput.domain.RuleTableOutput;
import com.cartan.core.ruleTableOutput.service.RuleTableOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class RuleTableOutputServiceEbsBase {
    static Logger logger = Logger.getLogger(RuleTableOutputServiceEbs.class.getName());
	private RuleTableOutputService  ruleTableOutputService;
	
    public RuleTableOutputService getRuleTableOutputService() {
        return ruleTableOutputService;
    }

    @Autowired
    public void setRuleTableOutputService(RuleTableOutputService ruleTableOutputService) {
        this.ruleTableOutputService = ruleTableOutputService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(RuleTableOutputGetSessionRequest request) {      
    	RuleTableOutputGetSessionResponse ruleTableOutputGetSessionResponse = new RuleTableOutputGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleTableOutputGetSessionResponse.setResultString("0");
        } else {
        	ruleTableOutputGetSessionResponse.setResultString("1");
            ruleTableOutputGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ruleTableOutputGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(RuleTableOutputGetSessionRequest request) {
    	RuleTableOutputGetSessionResponse ruleTableOutputGetSessionResponse = new RuleTableOutputGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ruleTableOutputGetSessionResponse.setResultString("1");
        } else {
        	ruleTableOutputGetSessionResponse.setResultString("0");
        }
        ruleTableOutputGetSessionResponse.setSessionId(request.getSessionId());
        return ruleTableOutputGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(RuleTableOutputGetSessionRequest request) {
    	RuleTableOutputGetSessionResponse ruleTableOutputGetSessionResponse = new RuleTableOutputGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleTableOutputGetSessionResponse.setResultString("0");
        	ruleTableOutputGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ruleTableOutputGetSessionResponse.setResultString("1");
        }
        return ruleTableOutputGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.createRuleTableOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createRuleTableOutput(RuleTableOutputCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_RuleTableOutput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTableOutput ruleTableOutput=new RuleTableOutput();
        ruleTableOutput.setId(request.getId());    		
        ruleTableOutput.setRuleTableId(request.getRuleTableId());
        ruleTableOutput.setOutputLocation(request.getOutputLocation());
        ruleTableOutput.setOutputVar(request.getOutputVar());
        ruleTableOutput.setOutputValue(request.getOutputValue());
    	ruleTableOutputService.createRuleTableOutput(ruleTableOutput);
        //返回响应
        RuleTableOutputCreateResponse ruleTableOutputCreateResponse = new RuleTableOutputCreateResponse();
        ruleTableOutputCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableOutputCreateResponse.setResultJson(ruleTableOutput);
        return ruleTableOutputCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.deleteRuleTableOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteRuleTableOutput(RuleTableOutputDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_RuleTableOutput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ruleTableOutputService.deleteRuleTableOutput(idstr);
        //返回响应
        RuleTableOutputDeleteResponse ruleTableOutputDeleteResponse = new RuleTableOutputDeleteResponse();
        ruleTableOutputDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleTableOutputDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.updateRuleTableOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateRuleTableOutput(RuleTableOutputUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_RuleTableOutput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTableOutput ruleTableOutput=new RuleTableOutput();
        ruleTableOutput=ruleTableOutputService.getRuleTableOutput(request.getId());
        if (request.getId()!=null){
	        ruleTableOutput.setId(request.getId());
        }
        if (request.getRuleTableId()!=null){
	        ruleTableOutput.setRuleTableId(request.getRuleTableId());
        }
        if (request.getOutputLocation()!=null){
	        ruleTableOutput.setOutputLocation(request.getOutputLocation());
        }
        if (request.getOutputVar()!=null){
	        ruleTableOutput.setOutputVar(request.getOutputVar());
        }
        if (request.getOutputValue()!=null){
	        ruleTableOutput.setOutputValue(request.getOutputValue());
        }
    	ruleTableOutputService.updateRuleTableOutput(ruleTableOutput);
        //返回响应
        RuleTableOutputUpdateResponse ruleTableOutputUpdateResponse = new RuleTableOutputUpdateResponse();
        ruleTableOutputUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableOutputUpdateResponse.setResultJson(ruleTableOutput);
        return ruleTableOutputUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.getRuleTableOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getRuleTableOutput(RuleTableOutputGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        RuleTableOutput ruleTableOutput=new RuleTableOutput();
        ruleTableOutput=ruleTableOutputService.getRuleTableOutput(id);
        //返回响应
        RuleTableOutputGetResponse ruleTableOutputGetResponse = new RuleTableOutputGetResponse();
        ruleTableOutputGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableOutputGetResponse.setResultJson(ruleTableOutput);
        return ruleTableOutputGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(RuleTableOutputSelectAllRequest request) {
        RuleTableOutputSelectAllResponse ruleTableOutputSelectAllResponse = new RuleTableOutputSelectAllResponse();
        ruleTableOutputSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableOutputSelectAllResponse.setResultJson(ruleTableOutputService.selectAll());
        return ruleTableOutputSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(RuleTableOutputCountAllRequest request) {
        RuleTableOutputCountAllResponse ruleTableOutputCountAllResponse = new RuleTableOutputCountAllResponse();
        ruleTableOutputCountAllResponse.setResultString(String.valueOf(ruleTableOutputService.countAll()));
        ruleTableOutputCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleTableOutputCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(RuleTableOutputSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        RuleTableOutputSelectAllResponse ruleTableOutputSelectAllResponse = new RuleTableOutputSelectAllResponse();
        ruleTableOutputSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableOutputSelectAllResponse.setResultJson(ruleTableOutputService.selectBySql(sqlstr));
        return ruleTableOutputSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.selectRuleTableOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(RuleTableOutputSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_RuleTableOutput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTableOutput ruleTableOutput=new RuleTableOutput();
        ruleTableOutput.setId(request.getId());
        ruleTableOutput.setRuleTableId(request.getRuleTableId());
        ruleTableOutput.setOutputLocation(request.getOutputLocation());
        ruleTableOutput.setOutputVar(request.getOutputVar());
        ruleTableOutput.setOutputValue(request.getOutputValue());
    	RuleTableOutputSelectResponse ruleTableOutputSelectResponse = new RuleTableOutputSelectResponse();
        ruleTableOutputSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<RuleTableOutput> ruleTableOutputs= ruleTableOutputService.selectWithCondition(ruleTableOutput);
        ruleTableOutputSelectResponse.setResultJson(ruleTableOutputs);
        return ruleTableOutputSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableOutput.isExistRuleTableOutput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistRuleTableOutput(RuleTableOutputSelectRequest request) {
        RuleTableOutput ruleTableOutput=new RuleTableOutput();
        ruleTableOutput.setId(request.getId());
        ruleTableOutput.setRuleTableId(request.getRuleTableId());
        ruleTableOutput.setOutputLocation(request.getOutputLocation());
        ruleTableOutput.setOutputVar(request.getOutputVar());
        ruleTableOutput.setOutputValue(request.getOutputValue());
        ArrayList<RuleTableOutput> ruleTableOutputs= ruleTableOutputService.selectWithCondition(ruleTableOutput);
    	RuleTableOutputCountAllResponse ruleTableOutputCountAllResponse = new RuleTableOutputCountAllResponse();
        if (ruleTableOutputs.size()>0){
        	ruleTableOutputCountAllResponse.setResultString("1");
        } else {
        	ruleTableOutputCountAllResponse.setResultString("0");
        }        
        return ruleTableOutputCountAllResponse;
    }

    public Boolean validateCreateRequest(RuleTableOutputCreateRequest request){
    	RuleTableOutput ruleTableOutput=new RuleTableOutput();
    	ruleTableOutput.setId(request.getId());
        ArrayList<RuleTableOutput> ruleTableOutputs= ruleTableOutputService.selectWithCondition(ruleTableOutput);
        if (ruleTableOutputs!=null&&ruleTableOutputs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(RuleTableOutputUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(RuleTableOutputDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(RuleTableOutputSelectRequest request){
        return  true;
     }    
}
