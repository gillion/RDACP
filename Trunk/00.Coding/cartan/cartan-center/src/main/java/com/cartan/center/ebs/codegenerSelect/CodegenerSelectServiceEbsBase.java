/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.codegenerSelect;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.codegenerSelect.request.*;
import com.cartan.center.ebs.codegenerSelect.response.*;
import com.cartan.core.codegenerSelect.domain.CodegenerSelect;
import com.cartan.core.codegenerSelect.service.CodegenerSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class CodegenerSelectServiceEbsBase {
    static Logger logger = Logger.getLogger(CodegenerSelectServiceEbs.class.getName());
	private CodegenerSelectService  codegenerSelectService;
	
    public CodegenerSelectService getCodegenerSelectService() {
        return codegenerSelectService;
    }

    @Autowired
    public void setCodegenerSelectService(CodegenerSelectService codegenerSelectService) {
        this.codegenerSelectService = codegenerSelectService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(CodegenerSelectGetSessionRequest request) {      
    	CodegenerSelectGetSessionResponse codegenerSelectGetSessionResponse = new CodegenerSelectGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerSelectGetSessionResponse.setResultString("0");
        } else {
        	codegenerSelectGetSessionResponse.setResultString("1");
            codegenerSelectGetSessionResponse.setSessionId(request.getSessionId());
        }
        return codegenerSelectGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(CodegenerSelectGetSessionRequest request) {
    	CodegenerSelectGetSessionResponse codegenerSelectGetSessionResponse = new CodegenerSelectGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            codegenerSelectGetSessionResponse.setResultString("1");
        } else {
        	codegenerSelectGetSessionResponse.setResultString("0");
        }
        codegenerSelectGetSessionResponse.setSessionId(request.getSessionId());
        return codegenerSelectGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(CodegenerSelectGetSessionRequest request) {
    	CodegenerSelectGetSessionResponse codegenerSelectGetSessionResponse = new CodegenerSelectGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerSelectGetSessionResponse.setResultString("0");
        	codegenerSelectGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            codegenerSelectGetSessionResponse.setResultString("1");
        }
        return codegenerSelectGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.createCodegenerSelect", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createCodegenerSelect(CodegenerSelectCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_CodegenerSelect_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerSelect codegenerSelect=new CodegenerSelect();
        codegenerSelect.setId(request.getId());    		
        codegenerSelect.setSetupId(request.getSetupId());
        codegenerSelect.setTableId(request.getTableId());
        codegenerSelect.setSelectField(request.getSelectField());
        codegenerSelect.setSelectTable(request.getSelectTable());
        codegenerSelect.setSelectDes(request.getSelectDes());
    	codegenerSelectService.createCodegenerSelect(codegenerSelect);
        //返回响应
        CodegenerSelectCreateResponse codegenerSelectCreateResponse = new CodegenerSelectCreateResponse();
        codegenerSelectCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerSelectCreateResponse.setResultJson(codegenerSelect);
        return codegenerSelectCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.deleteCodegenerSelect", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteCodegenerSelect(CodegenerSelectDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_CodegenerSelect_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        codegenerSelectService.deleteCodegenerSelect(idstr);
        //返回响应
        CodegenerSelectDeleteResponse codegenerSelectDeleteResponse = new CodegenerSelectDeleteResponse();
        codegenerSelectDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerSelectDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.updateCodegenerSelect", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateCodegenerSelect(CodegenerSelectUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_CodegenerSelect_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerSelect codegenerSelect=new CodegenerSelect();
        codegenerSelect=codegenerSelectService.getCodegenerSelect(request.getId());
        if (request.getId()!=null){
	        codegenerSelect.setId(request.getId());
        }
        if (request.getSetupId()!=null){
	        codegenerSelect.setSetupId(request.getSetupId());
        }
        if (request.getTableId()!=null){
	        codegenerSelect.setTableId(request.getTableId());
        }
        if (request.getSelectField()!=null){
	        codegenerSelect.setSelectField(request.getSelectField());
        }
        if (request.getSelectTable()!=null){
	        codegenerSelect.setSelectTable(request.getSelectTable());
        }
        if (request.getSelectDes()!=null){
	        codegenerSelect.setSelectDes(request.getSelectDes());
        }
    	codegenerSelectService.updateCodegenerSelect(codegenerSelect);
        //返回响应
        CodegenerSelectUpdateResponse codegenerSelectUpdateResponse = new CodegenerSelectUpdateResponse();
        codegenerSelectUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerSelectUpdateResponse.setResultJson(codegenerSelect);
        return codegenerSelectUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.getCodegenerSelect", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getCodegenerSelect(CodegenerSelectGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        CodegenerSelect codegenerSelect=new CodegenerSelect();
        codegenerSelect=codegenerSelectService.getCodegenerSelect(id);
        //返回响应
        CodegenerSelectGetResponse codegenerSelectGetResponse = new CodegenerSelectGetResponse();
        codegenerSelectGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerSelectGetResponse.setResultJson(codegenerSelect);
        return codegenerSelectGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(CodegenerSelectSelectAllRequest request) {
        CodegenerSelectSelectAllResponse codegenerSelectSelectAllResponse = new CodegenerSelectSelectAllResponse();
        codegenerSelectSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerSelectSelectAllResponse.setResultJson(codegenerSelectService.selectAll());
        return codegenerSelectSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(CodegenerSelectCountAllRequest request) {
        CodegenerSelectCountAllResponse codegenerSelectCountAllResponse = new CodegenerSelectCountAllResponse();
        codegenerSelectCountAllResponse.setResultString(String.valueOf(codegenerSelectService.countAll()));
        codegenerSelectCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerSelectCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(CodegenerSelectSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        CodegenerSelectSelectAllResponse codegenerSelectSelectAllResponse = new CodegenerSelectSelectAllResponse();
        codegenerSelectSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerSelectSelectAllResponse.setResultJson(codegenerSelectService.selectBySql(sqlstr));
        return codegenerSelectSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.selectCodegenerSelect", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(CodegenerSelectSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_CodegenerSelect_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerSelect codegenerSelect=new CodegenerSelect();
        codegenerSelect.setId(request.getId());
        codegenerSelect.setSetupId(request.getSetupId());
        codegenerSelect.setTableId(request.getTableId());
        codegenerSelect.setSelectField(request.getSelectField());
        codegenerSelect.setSelectTable(request.getSelectTable());
        codegenerSelect.setSelectDes(request.getSelectDes());
    	CodegenerSelectSelectResponse codegenerSelectSelectResponse = new CodegenerSelectSelectResponse();
        codegenerSelectSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<CodegenerSelect> codegenerSelects= codegenerSelectService.selectWithCondition(codegenerSelect);
        codegenerSelectSelectResponse.setResultJson(codegenerSelects);
        return codegenerSelectSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerSelect.isExistCodegenerSelect", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistCodegenerSelect(CodegenerSelectSelectRequest request) {
        CodegenerSelect codegenerSelect=new CodegenerSelect();
        codegenerSelect.setId(request.getId());
        codegenerSelect.setSetupId(request.getSetupId());
        codegenerSelect.setTableId(request.getTableId());
        codegenerSelect.setSelectField(request.getSelectField());
        codegenerSelect.setSelectTable(request.getSelectTable());
        codegenerSelect.setSelectDes(request.getSelectDes());
        ArrayList<CodegenerSelect> codegenerSelects= codegenerSelectService.selectWithCondition(codegenerSelect);
    	CodegenerSelectCountAllResponse codegenerSelectCountAllResponse = new CodegenerSelectCountAllResponse();
        if (codegenerSelects.size()>0){
        	codegenerSelectCountAllResponse.setResultString("1");
        } else {
        	codegenerSelectCountAllResponse.setResultString("0");
        }        
        return codegenerSelectCountAllResponse;
    }

    public Boolean validateCreateRequest(CodegenerSelectCreateRequest request){
    	CodegenerSelect codegenerSelect=new CodegenerSelect();
    	codegenerSelect.setId(request.getId());
        ArrayList<CodegenerSelect> codegenerSelects= codegenerSelectService.selectWithCondition(codegenerSelect);
        if (codegenerSelects!=null&&codegenerSelects.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(CodegenerSelectUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(CodegenerSelectDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(CodegenerSelectSelectRequest request){
        return  true;
     }    
}
