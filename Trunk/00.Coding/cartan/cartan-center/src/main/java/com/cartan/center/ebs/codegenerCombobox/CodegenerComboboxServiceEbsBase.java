/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.codegenerCombobox;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.codegenerCombobox.request.*;
import com.cartan.center.ebs.codegenerCombobox.response.*;
import com.cartan.core.codegenerCombobox.domain.CodegenerCombobox;
import com.cartan.core.codegenerCombobox.service.CodegenerComboboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class CodegenerComboboxServiceEbsBase {
    static Logger logger = Logger.getLogger(CodegenerComboboxServiceEbs.class.getName());
	private CodegenerComboboxService  codegenerComboboxService;
	
    public CodegenerComboboxService getCodegenerComboboxService() {
        return codegenerComboboxService;
    }

    @Autowired
    public void setCodegenerComboboxService(CodegenerComboboxService codegenerComboboxService) {
        this.codegenerComboboxService = codegenerComboboxService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(CodegenerComboboxGetSessionRequest request) {      
    	CodegenerComboboxGetSessionResponse codegenerComboboxGetSessionResponse = new CodegenerComboboxGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerComboboxGetSessionResponse.setResultString("0");
        } else {
        	codegenerComboboxGetSessionResponse.setResultString("1");
            codegenerComboboxGetSessionResponse.setSessionId(request.getSessionId());
        }
        return codegenerComboboxGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(CodegenerComboboxGetSessionRequest request) {
    	CodegenerComboboxGetSessionResponse codegenerComboboxGetSessionResponse = new CodegenerComboboxGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            codegenerComboboxGetSessionResponse.setResultString("1");
        } else {
        	codegenerComboboxGetSessionResponse.setResultString("0");
        }
        codegenerComboboxGetSessionResponse.setSessionId(request.getSessionId());
        return codegenerComboboxGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(CodegenerComboboxGetSessionRequest request) {
    	CodegenerComboboxGetSessionResponse codegenerComboboxGetSessionResponse = new CodegenerComboboxGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerComboboxGetSessionResponse.setResultString("0");
        	codegenerComboboxGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            codegenerComboboxGetSessionResponse.setResultString("1");
        }
        return codegenerComboboxGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.createCodegenerCombobox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createCodegenerCombobox(CodegenerComboboxCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_CodegenerCombobox_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerCombobox codegenerCombobox=new CodegenerCombobox();
        codegenerCombobox.setId(request.getId());    		
        codegenerCombobox.setSetupId(request.getSetupId());
        codegenerCombobox.setTableId(request.getTableId());
        codegenerCombobox.setComboboxField(request.getComboboxField());
        codegenerCombobox.setCodeType(request.getCodeType());
    	codegenerComboboxService.createCodegenerCombobox(codegenerCombobox);
        //返回响应
        CodegenerComboboxCreateResponse codegenerComboboxCreateResponse = new CodegenerComboboxCreateResponse();
        codegenerComboboxCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerComboboxCreateResponse.setResultJson(codegenerCombobox);
        return codegenerComboboxCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.deleteCodegenerCombobox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteCodegenerCombobox(CodegenerComboboxDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_CodegenerCombobox_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        codegenerComboboxService.deleteCodegenerCombobox(idstr);
        //返回响应
        CodegenerComboboxDeleteResponse codegenerComboboxDeleteResponse = new CodegenerComboboxDeleteResponse();
        codegenerComboboxDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerComboboxDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.updateCodegenerCombobox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateCodegenerCombobox(CodegenerComboboxUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_CodegenerCombobox_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerCombobox codegenerCombobox=new CodegenerCombobox();
        codegenerCombobox=codegenerComboboxService.getCodegenerCombobox(request.getId());
        if (request.getId()!=null){
	        codegenerCombobox.setId(request.getId());
        }
        if (request.getSetupId()!=null){
	        codegenerCombobox.setSetupId(request.getSetupId());
        }
        if (request.getTableId()!=null){
	        codegenerCombobox.setTableId(request.getTableId());
        }
        if (request.getComboboxField()!=null){
	        codegenerCombobox.setComboboxField(request.getComboboxField());
        }
        if (request.getCodeType()!=null){
	        codegenerCombobox.setCodeType(request.getCodeType());
        }
    	codegenerComboboxService.updateCodegenerCombobox(codegenerCombobox);
        //返回响应
        CodegenerComboboxUpdateResponse codegenerComboboxUpdateResponse = new CodegenerComboboxUpdateResponse();
        codegenerComboboxUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerComboboxUpdateResponse.setResultJson(codegenerCombobox);
        return codegenerComboboxUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.getCodegenerCombobox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getCodegenerCombobox(CodegenerComboboxGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        CodegenerCombobox codegenerCombobox=new CodegenerCombobox();
        codegenerCombobox=codegenerComboboxService.getCodegenerCombobox(id);
        //返回响应
        CodegenerComboboxGetResponse codegenerComboboxGetResponse = new CodegenerComboboxGetResponse();
        codegenerComboboxGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerComboboxGetResponse.setResultJson(codegenerCombobox);
        return codegenerComboboxGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(CodegenerComboboxSelectAllRequest request) {
        CodegenerComboboxSelectAllResponse codegenerComboboxSelectAllResponse = new CodegenerComboboxSelectAllResponse();
        codegenerComboboxSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerComboboxSelectAllResponse.setResultJson(codegenerComboboxService.selectAll());
        return codegenerComboboxSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(CodegenerComboboxCountAllRequest request) {
        CodegenerComboboxCountAllResponse codegenerComboboxCountAllResponse = new CodegenerComboboxCountAllResponse();
        codegenerComboboxCountAllResponse.setResultString(String.valueOf(codegenerComboboxService.countAll()));
        codegenerComboboxCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerComboboxCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(CodegenerComboboxSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        CodegenerComboboxSelectAllResponse codegenerComboboxSelectAllResponse = new CodegenerComboboxSelectAllResponse();
        codegenerComboboxSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerComboboxSelectAllResponse.setResultJson(codegenerComboboxService.selectBySql(sqlstr));
        return codegenerComboboxSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.selectCodegenerCombobox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(CodegenerComboboxSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_CodegenerCombobox_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerCombobox codegenerCombobox=new CodegenerCombobox();
        codegenerCombobox.setId(request.getId());
        codegenerCombobox.setSetupId(request.getSetupId());
        codegenerCombobox.setTableId(request.getTableId());
        codegenerCombobox.setComboboxField(request.getComboboxField());
        codegenerCombobox.setCodeType(request.getCodeType());
    	CodegenerComboboxSelectResponse codegenerComboboxSelectResponse = new CodegenerComboboxSelectResponse();
        codegenerComboboxSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<CodegenerCombobox> codegenerComboboxs= codegenerComboboxService.selectWithCondition(codegenerCombobox);
        codegenerComboboxSelectResponse.setResultJson(codegenerComboboxs);
        return codegenerComboboxSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerCombobox.isExistCodegenerCombobox", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistCodegenerCombobox(CodegenerComboboxSelectRequest request) {
        CodegenerCombobox codegenerCombobox=new CodegenerCombobox();
        codegenerCombobox.setId(request.getId());
        codegenerCombobox.setSetupId(request.getSetupId());
        codegenerCombobox.setTableId(request.getTableId());
        codegenerCombobox.setComboboxField(request.getComboboxField());
        codegenerCombobox.setCodeType(request.getCodeType());
        ArrayList<CodegenerCombobox> codegenerComboboxs= codegenerComboboxService.selectWithCondition(codegenerCombobox);
    	CodegenerComboboxCountAllResponse codegenerComboboxCountAllResponse = new CodegenerComboboxCountAllResponse();
        if (codegenerComboboxs.size()>0){
        	codegenerComboboxCountAllResponse.setResultString("1");
        } else {
        	codegenerComboboxCountAllResponse.setResultString("0");
        }        
        return codegenerComboboxCountAllResponse;
    }

    public Boolean validateCreateRequest(CodegenerComboboxCreateRequest request){
    	CodegenerCombobox codegenerCombobox=new CodegenerCombobox();
    	codegenerCombobox.setId(request.getId());
        ArrayList<CodegenerCombobox> codegenerComboboxs= codegenerComboboxService.selectWithCondition(codegenerCombobox);
        if (codegenerComboboxs!=null&&codegenerComboboxs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(CodegenerComboboxUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(CodegenerComboboxDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(CodegenerComboboxSelectRequest request){
        return  true;
     }    
}
