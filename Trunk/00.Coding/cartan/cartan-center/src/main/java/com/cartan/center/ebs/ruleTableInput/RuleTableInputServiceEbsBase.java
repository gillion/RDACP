/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTableInput;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ruleTableInput.request.*;
import com.cartan.center.ebs.ruleTableInput.response.*;
import com.cartan.core.ruleTableInput.domain.RuleTableInput;
import com.cartan.core.ruleTableInput.service.RuleTableInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class RuleTableInputServiceEbsBase {
    static Logger logger = Logger.getLogger(RuleTableInputServiceEbs.class.getName());
	private RuleTableInputService  ruleTableInputService;
	
    public RuleTableInputService getRuleTableInputService() {
        return ruleTableInputService;
    }

    @Autowired
    public void setRuleTableInputService(RuleTableInputService ruleTableInputService) {
        this.ruleTableInputService = ruleTableInputService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(RuleTableInputGetSessionRequest request) {      
    	RuleTableInputGetSessionResponse ruleTableInputGetSessionResponse = new RuleTableInputGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleTableInputGetSessionResponse.setResultString("0");
        } else {
        	ruleTableInputGetSessionResponse.setResultString("1");
            ruleTableInputGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ruleTableInputGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(RuleTableInputGetSessionRequest request) {
    	RuleTableInputGetSessionResponse ruleTableInputGetSessionResponse = new RuleTableInputGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ruleTableInputGetSessionResponse.setResultString("1");
        } else {
        	ruleTableInputGetSessionResponse.setResultString("0");
        }
        ruleTableInputGetSessionResponse.setSessionId(request.getSessionId());
        return ruleTableInputGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(RuleTableInputGetSessionRequest request) {
    	RuleTableInputGetSessionResponse ruleTableInputGetSessionResponse = new RuleTableInputGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ruleTableInputGetSessionResponse.setResultString("0");
        	ruleTableInputGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ruleTableInputGetSessionResponse.setResultString("1");
        }
        return ruleTableInputGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.createRuleTableInput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createRuleTableInput(RuleTableInputCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_RuleTableInput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTableInput ruleTableInput=new RuleTableInput();
        ruleTableInput.setId(request.getId());    		
        ruleTableInput.setRuleTableId(request.getRuleTableId());
        ruleTableInput.setOutputLocation(request.getOutputLocation());
        ruleTableInput.setInputVar(request.getInputVar());
        ruleTableInput.setInputValue(request.getInputValue());
    	ruleTableInputService.createRuleTableInput(ruleTableInput);
        //返回响应
        RuleTableInputCreateResponse ruleTableInputCreateResponse = new RuleTableInputCreateResponse();
        ruleTableInputCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableInputCreateResponse.setResultJson(ruleTableInput);
        return ruleTableInputCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.deleteRuleTableInput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteRuleTableInput(RuleTableInputDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_RuleTableInput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ruleTableInputService.deleteRuleTableInput(idstr);
        //返回响应
        RuleTableInputDeleteResponse ruleTableInputDeleteResponse = new RuleTableInputDeleteResponse();
        ruleTableInputDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleTableInputDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.updateRuleTableInput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateRuleTableInput(RuleTableInputUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_RuleTableInput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTableInput ruleTableInput=new RuleTableInput();
        ruleTableInput=ruleTableInputService.getRuleTableInput(request.getId());
        if (request.getId()!=null){
	        ruleTableInput.setId(request.getId());
        }
        if (request.getRuleTableId()!=null){
	        ruleTableInput.setRuleTableId(request.getRuleTableId());
        }
        if (request.getOutputLocation()!=null){
	        ruleTableInput.setOutputLocation(request.getOutputLocation());
        }
        if (request.getInputVar()!=null){
	        ruleTableInput.setInputVar(request.getInputVar());
        }
        if (request.getInputValue()!=null){
	        ruleTableInput.setInputValue(request.getInputValue());
        }
    	ruleTableInputService.updateRuleTableInput(ruleTableInput);
        //返回响应
        RuleTableInputUpdateResponse ruleTableInputUpdateResponse = new RuleTableInputUpdateResponse();
        ruleTableInputUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableInputUpdateResponse.setResultJson(ruleTableInput);
        return ruleTableInputUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.getRuleTableInput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getRuleTableInput(RuleTableInputGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        RuleTableInput ruleTableInput=new RuleTableInput();
        ruleTableInput=ruleTableInputService.getRuleTableInput(id);
        //返回响应
        RuleTableInputGetResponse ruleTableInputGetResponse = new RuleTableInputGetResponse();
        ruleTableInputGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableInputGetResponse.setResultJson(ruleTableInput);
        return ruleTableInputGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(RuleTableInputSelectAllRequest request) {
        RuleTableInputSelectAllResponse ruleTableInputSelectAllResponse = new RuleTableInputSelectAllResponse();
        ruleTableInputSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableInputSelectAllResponse.setResultJson(ruleTableInputService.selectAll());
        return ruleTableInputSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(RuleTableInputCountAllRequest request) {
        RuleTableInputCountAllResponse ruleTableInputCountAllResponse = new RuleTableInputCountAllResponse();
        ruleTableInputCountAllResponse.setResultString(String.valueOf(ruleTableInputService.countAll()));
        ruleTableInputCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ruleTableInputCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(RuleTableInputSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        RuleTableInputSelectAllResponse ruleTableInputSelectAllResponse = new RuleTableInputSelectAllResponse();
        ruleTableInputSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ruleTableInputSelectAllResponse.setResultJson(ruleTableInputService.selectBySql(sqlstr));
        return ruleTableInputSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.selectRuleTableInput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(RuleTableInputSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_RuleTableInput_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        RuleTableInput ruleTableInput=new RuleTableInput();
        ruleTableInput.setId(request.getId());
        ruleTableInput.setRuleTableId(request.getRuleTableId());
        ruleTableInput.setOutputLocation(request.getOutputLocation());
        ruleTableInput.setInputVar(request.getInputVar());
        ruleTableInput.setInputValue(request.getInputValue());
    	RuleTableInputSelectResponse ruleTableInputSelectResponse = new RuleTableInputSelectResponse();
        ruleTableInputSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<RuleTableInput> ruleTableInputs= ruleTableInputService.selectWithCondition(ruleTableInput);
        ruleTableInputSelectResponse.setResultJson(ruleTableInputs);
        return ruleTableInputSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ruleTableInput.isExistRuleTableInput", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistRuleTableInput(RuleTableInputSelectRequest request) {
        RuleTableInput ruleTableInput=new RuleTableInput();
        ruleTableInput.setId(request.getId());
        ruleTableInput.setRuleTableId(request.getRuleTableId());
        ruleTableInput.setOutputLocation(request.getOutputLocation());
        ruleTableInput.setInputVar(request.getInputVar());
        ruleTableInput.setInputValue(request.getInputValue());
        ArrayList<RuleTableInput> ruleTableInputs= ruleTableInputService.selectWithCondition(ruleTableInput);
    	RuleTableInputCountAllResponse ruleTableInputCountAllResponse = new RuleTableInputCountAllResponse();
        if (ruleTableInputs.size()>0){
        	ruleTableInputCountAllResponse.setResultString("1");
        } else {
        	ruleTableInputCountAllResponse.setResultString("0");
        }        
        return ruleTableInputCountAllResponse;
    }

    public Boolean validateCreateRequest(RuleTableInputCreateRequest request){
    	RuleTableInput ruleTableInput=new RuleTableInput();
    	ruleTableInput.setId(request.getId());
        ArrayList<RuleTableInput> ruleTableInputs= ruleTableInputService.selectWithCondition(ruleTableInput);
        if (ruleTableInputs!=null&&ruleTableInputs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(RuleTableInputUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(RuleTableInputDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(RuleTableInputSelectRequest request){
        return  true;
     }    
}
