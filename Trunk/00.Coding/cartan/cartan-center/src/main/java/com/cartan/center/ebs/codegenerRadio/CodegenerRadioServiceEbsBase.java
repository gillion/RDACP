/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.codegenerRadio;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.codegenerRadio.request.*;
import com.cartan.center.ebs.codegenerRadio.response.*;
import com.cartan.core.codegenerRadio.domain.CodegenerRadio;
import com.cartan.core.codegenerRadio.service.CodegenerRadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class CodegenerRadioServiceEbsBase {
    static Logger logger = Logger.getLogger(CodegenerRadioServiceEbs.class.getName());
	private CodegenerRadioService  codegenerRadioService;
	
    public CodegenerRadioService getCodegenerRadioService() {
        return codegenerRadioService;
    }

    @Autowired
    public void setCodegenerRadioService(CodegenerRadioService codegenerRadioService) {
        this.codegenerRadioService = codegenerRadioService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(CodegenerRadioGetSessionRequest request) {      
    	CodegenerRadioGetSessionResponse codegenerRadioGetSessionResponse = new CodegenerRadioGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerRadioGetSessionResponse.setResultString("0");
        } else {
        	codegenerRadioGetSessionResponse.setResultString("1");
            codegenerRadioGetSessionResponse.setSessionId(request.getSessionId());
        }
        return codegenerRadioGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(CodegenerRadioGetSessionRequest request) {
    	CodegenerRadioGetSessionResponse codegenerRadioGetSessionResponse = new CodegenerRadioGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            codegenerRadioGetSessionResponse.setResultString("1");
        } else {
        	codegenerRadioGetSessionResponse.setResultString("0");
        }
        codegenerRadioGetSessionResponse.setSessionId(request.getSessionId());
        return codegenerRadioGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(CodegenerRadioGetSessionRequest request) {
    	CodegenerRadioGetSessionResponse codegenerRadioGetSessionResponse = new CodegenerRadioGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerRadioGetSessionResponse.setResultString("0");
        	codegenerRadioGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            codegenerRadioGetSessionResponse.setResultString("1");
        }
        return codegenerRadioGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.createCodegenerRadio", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createCodegenerRadio(CodegenerRadioCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_CodegenerRadio_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerRadio codegenerRadio=new CodegenerRadio();
        codegenerRadio.setId(request.getId());    		
        codegenerRadio.setSetupId(request.getSetupId());
        codegenerRadio.setTableId(request.getTableId());
        codegenerRadio.setRadioField(request.getRadioField());
        codegenerRadio.setCodeType(request.getCodeType());
    	codegenerRadioService.createCodegenerRadio(codegenerRadio);
        //返回响应
        CodegenerRadioCreateResponse codegenerRadioCreateResponse = new CodegenerRadioCreateResponse();
        codegenerRadioCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerRadioCreateResponse.setResultJson(codegenerRadio);
        return codegenerRadioCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.deleteCodegenerRadio", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteCodegenerRadio(CodegenerRadioDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_CodegenerRadio_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        codegenerRadioService.deleteCodegenerRadio(idstr);
        //返回响应
        CodegenerRadioDeleteResponse codegenerRadioDeleteResponse = new CodegenerRadioDeleteResponse();
        codegenerRadioDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerRadioDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.updateCodegenerRadio", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateCodegenerRadio(CodegenerRadioUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_CodegenerRadio_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerRadio codegenerRadio=new CodegenerRadio();
        codegenerRadio=codegenerRadioService.getCodegenerRadio(request.getId());
        if (request.getId()!=null){
	        codegenerRadio.setId(request.getId());
        }
        if (request.getSetupId()!=null){
	        codegenerRadio.setSetupId(request.getSetupId());
        }
        if (request.getTableId()!=null){
	        codegenerRadio.setTableId(request.getTableId());
        }
        if (request.getRadioField()!=null){
	        codegenerRadio.setRadioField(request.getRadioField());
        }
        if (request.getCodeType()!=null){
	        codegenerRadio.setCodeType(request.getCodeType());
        }
    	codegenerRadioService.updateCodegenerRadio(codegenerRadio);
        //返回响应
        CodegenerRadioUpdateResponse codegenerRadioUpdateResponse = new CodegenerRadioUpdateResponse();
        codegenerRadioUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerRadioUpdateResponse.setResultJson(codegenerRadio);
        return codegenerRadioUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.getCodegenerRadio", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getCodegenerRadio(CodegenerRadioGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        CodegenerRadio codegenerRadio=new CodegenerRadio();
        codegenerRadio=codegenerRadioService.getCodegenerRadio(id);
        //返回响应
        CodegenerRadioGetResponse codegenerRadioGetResponse = new CodegenerRadioGetResponse();
        codegenerRadioGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerRadioGetResponse.setResultJson(codegenerRadio);
        return codegenerRadioGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(CodegenerRadioSelectAllRequest request) {
        CodegenerRadioSelectAllResponse codegenerRadioSelectAllResponse = new CodegenerRadioSelectAllResponse();
        codegenerRadioSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerRadioSelectAllResponse.setResultJson(codegenerRadioService.selectAll());
        return codegenerRadioSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(CodegenerRadioCountAllRequest request) {
        CodegenerRadioCountAllResponse codegenerRadioCountAllResponse = new CodegenerRadioCountAllResponse();
        codegenerRadioCountAllResponse.setResultString(String.valueOf(codegenerRadioService.countAll()));
        codegenerRadioCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerRadioCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(CodegenerRadioSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        CodegenerRadioSelectAllResponse codegenerRadioSelectAllResponse = new CodegenerRadioSelectAllResponse();
        codegenerRadioSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerRadioSelectAllResponse.setResultJson(codegenerRadioService.selectBySql(sqlstr));
        return codegenerRadioSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.selectCodegenerRadio", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(CodegenerRadioSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_CodegenerRadio_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerRadio codegenerRadio=new CodegenerRadio();
        codegenerRadio.setId(request.getId());
        codegenerRadio.setSetupId(request.getSetupId());
        codegenerRadio.setTableId(request.getTableId());
        codegenerRadio.setRadioField(request.getRadioField());
        codegenerRadio.setCodeType(request.getCodeType());
    	CodegenerRadioSelectResponse codegenerRadioSelectResponse = new CodegenerRadioSelectResponse();
        codegenerRadioSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<CodegenerRadio> codegenerRadios= codegenerRadioService.selectWithCondition(codegenerRadio);
        codegenerRadioSelectResponse.setResultJson(codegenerRadios);
        return codegenerRadioSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerRadio.isExistCodegenerRadio", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistCodegenerRadio(CodegenerRadioSelectRequest request) {
        CodegenerRadio codegenerRadio=new CodegenerRadio();
        codegenerRadio.setId(request.getId());
        codegenerRadio.setSetupId(request.getSetupId());
        codegenerRadio.setTableId(request.getTableId());
        codegenerRadio.setRadioField(request.getRadioField());
        codegenerRadio.setCodeType(request.getCodeType());
        ArrayList<CodegenerRadio> codegenerRadios= codegenerRadioService.selectWithCondition(codegenerRadio);
    	CodegenerRadioCountAllResponse codegenerRadioCountAllResponse = new CodegenerRadioCountAllResponse();
        if (codegenerRadios.size()>0){
        	codegenerRadioCountAllResponse.setResultString("1");
        } else {
        	codegenerRadioCountAllResponse.setResultString("0");
        }        
        return codegenerRadioCountAllResponse;
    }

    public Boolean validateCreateRequest(CodegenerRadioCreateRequest request){
    	CodegenerRadio codegenerRadio=new CodegenerRadio();
    	codegenerRadio.setId(request.getId());
        ArrayList<CodegenerRadio> codegenerRadios= codegenerRadioService.selectWithCondition(codegenerRadio);
        if (codegenerRadios!=null&&codegenerRadios.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(CodegenerRadioUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(CodegenerRadioDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(CodegenerRadioSelectRequest request){
        return  true;
     }    
}
