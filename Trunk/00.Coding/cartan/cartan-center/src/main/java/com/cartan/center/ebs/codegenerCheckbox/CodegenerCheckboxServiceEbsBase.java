/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.codegenerCheckbox;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.codegenerCheckbox.request.*;
import com.cartan.center.ebs.codegenerCheckbox.response.*;
import com.cartan.core.codegenerCheckbox.domain.CodegenerCheckbox;
import com.cartan.core.codegenerCheckbox.service.CodegenerCheckboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class CodegenerCheckboxServiceEbsBase {
    static Logger logger = Logger.getLogger(CodegenerCheckboxServiceEbs.class.getName());
	private CodegenerCheckboxService  codegenerCheckboxService;

    public CodegenerCheckboxService getCodegenerCheckboxService() {
        return codegenerCheckboxService;
    }

    @Autowired
    public void setCodegenerCheckboxService(CodegenerCheckboxService codegenerCheckboxService) {
        this.codegenerCheckboxService = codegenerCheckboxService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(CodegenerCheckboxGetSessionRequest request) {      
    	CodegenerCheckboxGetSessionResponse codegenerCheckboxGetSessionResponse = new CodegenerCheckboxGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerCheckboxGetSessionResponse.setResultString("0");
        } else {
        	codegenerCheckboxGetSessionResponse.setResultString("1");
            codegenerCheckboxGetSessionResponse.setSessionId(request.getSessionId());
        }
        return codegenerCheckboxGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(CodegenerCheckboxGetSessionRequest request) {
    	CodegenerCheckboxGetSessionResponse codegenerCheckboxGetSessionResponse = new CodegenerCheckboxGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            codegenerCheckboxGetSessionResponse.setResultString("1");
        } else {
        	codegenerCheckboxGetSessionResponse.setResultString("0");
        }
        codegenerCheckboxGetSessionResponse.setSessionId(request.getSessionId());
        return codegenerCheckboxGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(CodegenerCheckboxGetSessionRequest request) {
    	CodegenerCheckboxGetSessionResponse codegenerCheckboxGetSessionResponse = new CodegenerCheckboxGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerCheckboxGetSessionResponse.setResultString("0");
        	codegenerCheckboxGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            codegenerCheckboxGetSessionResponse.setResultString("1");
        }
        return codegenerCheckboxGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.createCodegenerCheckbox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createCodegenerCheckbox(CodegenerCheckboxCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_CodegenerCheckbox_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerCheckbox codegenerCheckbox=new CodegenerCheckbox();
        codegenerCheckbox.setId(request.getId());    		
        codegenerCheckbox.setSetupId(request.getSetupId());
        codegenerCheckbox.setTableId(request.getTableId());
        codegenerCheckbox.setCheckboxField(request.getCheckboxField());
        codegenerCheckbox.setCodeType(request.getCodeType());
    	codegenerCheckboxService.createCodegenerCheckbox(codegenerCheckbox);
        //返回响应
        CodegenerCheckboxCreateResponse codegenerCheckboxCreateResponse = new CodegenerCheckboxCreateResponse();
        codegenerCheckboxCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerCheckboxCreateResponse.setResultJson(codegenerCheckbox);
        return codegenerCheckboxCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.deleteCodegenerCheckbox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteCodegenerCheckbox(CodegenerCheckboxDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_CodegenerCheckbox_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        codegenerCheckboxService.deleteCodegenerCheckbox(idstr);
        //返回响应
        CodegenerCheckboxDeleteResponse codegenerCheckboxDeleteResponse = new CodegenerCheckboxDeleteResponse();
        codegenerCheckboxDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerCheckboxDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.updateCodegenerCheckbox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateCodegenerCheckbox(CodegenerCheckboxUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_CodegenerCheckbox_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerCheckbox codegenerCheckbox=new CodegenerCheckbox();
        codegenerCheckbox=codegenerCheckboxService.getCodegenerCheckbox(request.getId());
        if (request.getId()!=null){
	        codegenerCheckbox.setId(request.getId());
        }
        if (request.getSetupId()!=null){
	        codegenerCheckbox.setSetupId(request.getSetupId());
        }
        if (request.getTableId()!=null){
	        codegenerCheckbox.setTableId(request.getTableId());
        }
        if (request.getCheckboxField()!=null){
	        codegenerCheckbox.setCheckboxField(request.getCheckboxField());
        }
        if (request.getCodeType()!=null){
	        codegenerCheckbox.setCodeType(request.getCodeType());
        }
    	codegenerCheckboxService.updateCodegenerCheckbox(codegenerCheckbox);
        //返回响应
        CodegenerCheckboxUpdateResponse codegenerCheckboxUpdateResponse = new CodegenerCheckboxUpdateResponse();
        codegenerCheckboxUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerCheckboxUpdateResponse.setResultJson(codegenerCheckbox);
        return codegenerCheckboxUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.getCodegenerCheckbox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getCodegenerCheckbox(CodegenerCheckboxGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        CodegenerCheckbox codegenerCheckbox=new CodegenerCheckbox();
        codegenerCheckbox=codegenerCheckboxService.getCodegenerCheckbox(id);
        //返回响应
        CodegenerCheckboxGetResponse codegenerCheckboxGetResponse = new CodegenerCheckboxGetResponse();
        codegenerCheckboxGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerCheckboxGetResponse.setResultJson(codegenerCheckbox);
        return codegenerCheckboxGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(CodegenerCheckboxSelectAllRequest request) {
        CodegenerCheckboxSelectAllResponse codegenerCheckboxSelectAllResponse = new CodegenerCheckboxSelectAllResponse();
        codegenerCheckboxSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerCheckboxSelectAllResponse.setResultJson(codegenerCheckboxService.selectAll());
        return codegenerCheckboxSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(CodegenerCheckboxCountAllRequest request) {
        CodegenerCheckboxCountAllResponse codegenerCheckboxCountAllResponse = new CodegenerCheckboxCountAllResponse();
        codegenerCheckboxCountAllResponse.setResultString(String.valueOf(codegenerCheckboxService.countAll()));
        codegenerCheckboxCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerCheckboxCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(CodegenerCheckboxSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        CodegenerCheckboxSelectAllResponse codegenerCheckboxSelectAllResponse = new CodegenerCheckboxSelectAllResponse();
        codegenerCheckboxSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerCheckboxSelectAllResponse.setResultJson(codegenerCheckboxService.selectBySql(sqlstr));
        return codegenerCheckboxSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.selectCodegenerCheckbox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(CodegenerCheckboxSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_CodegenerCheckbox_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerCheckbox codegenerCheckbox=new CodegenerCheckbox();
        codegenerCheckbox.setId(request.getId());
        codegenerCheckbox.setSetupId(request.getSetupId());
        codegenerCheckbox.setTableId(request.getTableId());
        codegenerCheckbox.setCheckboxField(request.getCheckboxField());
        codegenerCheckbox.setCodeType(request.getCodeType());
    	CodegenerCheckboxSelectResponse codegenerCheckboxSelectResponse = new CodegenerCheckboxSelectResponse();
        codegenerCheckboxSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<CodegenerCheckbox> codegenerCheckboxs= codegenerCheckboxService.selectWithCondition(codegenerCheckbox);
        codegenerCheckboxSelectResponse.setResultJson(codegenerCheckboxs);
        return codegenerCheckboxSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCheckbox.isExistCodegenerCheckbox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistCodegenerCheckbox(CodegenerCheckboxSelectRequest request) {
        CodegenerCheckbox codegenerCheckbox=new CodegenerCheckbox();
        codegenerCheckbox.setId(request.getId());
        codegenerCheckbox.setSetupId(request.getSetupId());
        codegenerCheckbox.setTableId(request.getTableId());
        codegenerCheckbox.setCheckboxField(request.getCheckboxField());
        codegenerCheckbox.setCodeType(request.getCodeType());
        ArrayList<CodegenerCheckbox> codegenerCheckboxs= codegenerCheckboxService.selectWithCondition(codegenerCheckbox);
    	CodegenerCheckboxCountAllResponse codegenerCheckboxCountAllResponse = new CodegenerCheckboxCountAllResponse();
        if (codegenerCheckboxs.size()>0){
        	codegenerCheckboxCountAllResponse.setResultString("1");
        } else {
        	codegenerCheckboxCountAllResponse.setResultString("0");
        }        
        return codegenerCheckboxCountAllResponse;
    }

    public Boolean validateCreateRequest(CodegenerCheckboxCreateRequest request){
    	CodegenerCheckbox codegenerCheckbox=new CodegenerCheckbox();
    	codegenerCheckbox.setId(request.getId());
        ArrayList<CodegenerCheckbox> codegenerCheckboxs= codegenerCheckboxService.selectWithCondition(codegenerCheckbox);
        if (codegenerCheckboxs!=null&&codegenerCheckboxs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(CodegenerCheckboxUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(CodegenerCheckboxDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(CodegenerCheckboxSelectRequest request){
        return  true;
     }    
}
