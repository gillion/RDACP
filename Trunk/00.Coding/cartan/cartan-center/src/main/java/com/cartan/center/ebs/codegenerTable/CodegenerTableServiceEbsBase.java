/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.codegenerTable;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.codegenerTable.request.*;
import com.cartan.center.ebs.codegenerTable.response.*;
import com.cartan.core.codegenerTable.domain.CodegenerTable;
import com.cartan.core.codegenerTable.service.CodegenerTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class CodegenerTableServiceEbsBase {
    static Logger logger = Logger.getLogger(CodegenerTableServiceEbs.class.getName());
	private CodegenerTableService  codegenerTableService;
	
    public CodegenerTableService getCodegenerTableService() {
        return codegenerTableService;
    }

    @Autowired
    public void setCodegenerTableService(CodegenerTableService codegenerTableService) {
        this.codegenerTableService = codegenerTableService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(CodegenerTableGetSessionRequest request) {      
    	CodegenerTableGetSessionResponse codegenerTableGetSessionResponse = new CodegenerTableGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerTableGetSessionResponse.setResultString("0");
        } else {
        	codegenerTableGetSessionResponse.setResultString("1");
            codegenerTableGetSessionResponse.setSessionId(request.getSessionId());
        }
        return codegenerTableGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(CodegenerTableGetSessionRequest request) {
    	CodegenerTableGetSessionResponse codegenerTableGetSessionResponse = new CodegenerTableGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            codegenerTableGetSessionResponse.setResultString("1");
        } else {
        	codegenerTableGetSessionResponse.setResultString("0");
        }
        codegenerTableGetSessionResponse.setSessionId(request.getSessionId());
        return codegenerTableGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(CodegenerTableGetSessionRequest request) {
    	CodegenerTableGetSessionResponse codegenerTableGetSessionResponse = new CodegenerTableGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	codegenerTableGetSessionResponse.setResultString("0");
        	codegenerTableGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            codegenerTableGetSessionResponse.setResultString("1");
        }
        return codegenerTableGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.createCodegenerTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createCodegenerTable(CodegenerTableCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_CodegenerTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerTable codegenerTable=new CodegenerTable();
        codegenerTable.setId(request.getId());    		
        if (request.getSetupId()!=null){            
        codegenerTable.setSetupId(request.getSetupId());
        } else {
            codegenerTable.setSetupId("");
        }
        if (request.getTableName()!=null){            
        codegenerTable.setTableName(request.getTableName());
        } else {
            codegenerTable.setTableName("");
        }
        if (request.getTableDes()!=null){            
        codegenerTable.setTableDes(request.getTableDes());
        } else {
            codegenerTable.setTableDes("");
        }
        if (request.getParentTableName()!=null){            
        codegenerTable.setParentTableName(request.getParentTableName());
        } else {
            codegenerTable.setParentTableName("");
        }
        if (request.getNoParent()!=null){            
        codegenerTable.setNoParent(request.getNoParent());
        } else {
            codegenerTable.setNoParent("");
        }
        if (request.getIsNewBsclass()!=null){            
        codegenerTable.setIsNewBsclass(request.getIsNewBsclass());
        } else {
            codegenerTable.setIsNewBsclass("");
        }
        if (request.getPageSize()!=null){            
        codegenerTable.setPageSize(request.getPageSize());
        } else {
            codegenerTable.setPageSize("");
        }
    	codegenerTableService.createCodegenerTable(codegenerTable);
        //返回响应
        CodegenerTableCreateResponse codegenerTableCreateResponse = new CodegenerTableCreateResponse();
        codegenerTableCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerTableCreateResponse.setResultJson(codegenerTable);
        return codegenerTableCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.deleteCodegenerTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteCodegenerTable(CodegenerTableDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_CodegenerTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        codegenerTableService.deleteCodegenerTable(idstr);
        //返回响应
        CodegenerTableDeleteResponse codegenerTableDeleteResponse = new CodegenerTableDeleteResponse();
        codegenerTableDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerTableDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.updateCodegenerTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateCodegenerTable(CodegenerTableUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_CodegenerTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerTable codegenerTable=new CodegenerTable();
        codegenerTable=codegenerTableService.getCodegenerTable(request.getId());
        if (request.getId()!=null){
	        codegenerTable.setId(request.getId());
        }
        if (request.getSetupId()!=null){
	        codegenerTable.setSetupId(request.getSetupId());
        }
        if (request.getTableName()!=null){
	        codegenerTable.setTableName(request.getTableName());
        }
        if (request.getTableDes()!=null){
	        codegenerTable.setTableDes(request.getTableDes());
        }
        if (request.getParentTableName()!=null){
	        codegenerTable.setParentTableName(request.getParentTableName());
        }
        if (request.getNoParent()!=null){
	        codegenerTable.setNoParent(request.getNoParent());
        }
        if (request.getIsNewBsclass()!=null){
	        codegenerTable.setIsNewBsclass(request.getIsNewBsclass());
        }
        if (request.getPageSize()!=null){
	        codegenerTable.setPageSize(request.getPageSize());
        }
    	codegenerTableService.updateCodegenerTable(codegenerTable);
        //返回响应
        CodegenerTableUpdateResponse codegenerTableUpdateResponse = new CodegenerTableUpdateResponse();
        codegenerTableUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerTableUpdateResponse.setResultJson(codegenerTable);
        return codegenerTableUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.getCodegenerTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getCodegenerTable(CodegenerTableGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        CodegenerTable codegenerTable=new CodegenerTable();
        codegenerTable=codegenerTableService.getCodegenerTable(id);
        //返回响应
        CodegenerTableGetResponse codegenerTableGetResponse = new CodegenerTableGetResponse();
        codegenerTableGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerTableGetResponse.setResultJson(codegenerTable);
        return codegenerTableGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(CodegenerTableSelectAllRequest request) {
        CodegenerTableSelectAllResponse codegenerTableSelectAllResponse = new CodegenerTableSelectAllResponse();
        codegenerTableSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerTableSelectAllResponse.setResultJson(codegenerTableService.selectAll());
        return codegenerTableSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(CodegenerTableCountAllRequest request) {
        CodegenerTableCountAllResponse codegenerTableCountAllResponse = new CodegenerTableCountAllResponse();
        codegenerTableCountAllResponse.setResultString(String.valueOf(codegenerTableService.countAll()));
        codegenerTableCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return codegenerTableCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(CodegenerTableSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        CodegenerTableSelectAllResponse codegenerTableSelectAllResponse = new CodegenerTableSelectAllResponse();
        codegenerTableSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        codegenerTableSelectAllResponse.setResultJson(codegenerTableService.selectBySql(sqlstr));
        return codegenerTableSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.selectCodegenerTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(CodegenerTableSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_CodegenerTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        CodegenerTable codegenerTable=new CodegenerTable();
        if (request.getId()!=null){   
        codegenerTable.setId(request.getId());
        }
        if (request.getSetupId()!=null){   
        codegenerTable.setSetupId(request.getSetupId());
        }
        if (request.getTableName()!=null){   
        codegenerTable.setTableName(request.getTableName());
        }
        if (request.getTableDes()!=null){   
        codegenerTable.setTableDes(request.getTableDes());
        }
        if (request.getParentTableName()!=null){   
        codegenerTable.setParentTableName(request.getParentTableName());
        }
        if (request.getNoParent()!=null){   
        codegenerTable.setNoParent(request.getNoParent());
        }
        if (request.getIsNewBsclass()!=null){   
        codegenerTable.setIsNewBsclass(request.getIsNewBsclass());
        }
        if (request.getPageSize()!=null){   
        codegenerTable.setPageSize(request.getPageSize());
        }
    	CodegenerTableSelectResponse codegenerTableSelectResponse = new CodegenerTableSelectResponse();
        codegenerTableSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<CodegenerTable> codegenerTables= codegenerTableService.selectWithCondition(codegenerTable);
        codegenerTableSelectResponse.setResultJson(codegenerTables);
        return codegenerTableSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "codegenerTable.isExistCodegenerTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistCodegenerTable(CodegenerTableSelectRequest request) {
        CodegenerTable codegenerTable=new CodegenerTable();
        if (request.getId()!=null){   
        codegenerTable.setId(request.getId());
        }
        if (request.getSetupId()!=null){   
        codegenerTable.setSetupId(request.getSetupId());
        }
        if (request.getTableName()!=null){   
        codegenerTable.setTableName(request.getTableName());
        }
        if (request.getTableDes()!=null){   
        codegenerTable.setTableDes(request.getTableDes());
        }
        if (request.getParentTableName()!=null){   
        codegenerTable.setParentTableName(request.getParentTableName());
        }
        if (request.getNoParent()!=null){   
        codegenerTable.setNoParent(request.getNoParent());
        }
        if (request.getIsNewBsclass()!=null){   
        codegenerTable.setIsNewBsclass(request.getIsNewBsclass());
        }
        if (request.getPageSize()!=null){   
        codegenerTable.setPageSize(request.getPageSize());
        }
        ArrayList<CodegenerTable> codegenerTables= codegenerTableService.selectWithCondition(codegenerTable);
    	CodegenerTableCountAllResponse codegenerTableCountAllResponse = new CodegenerTableCountAllResponse();
        if (codegenerTables.size()>0){
        	codegenerTableCountAllResponse.setResultString("1");
        } else {
        	codegenerTableCountAllResponse.setResultString("0");
        }        
        return codegenerTableCountAllResponse;
    }

    public Boolean validateCreateRequest(CodegenerTableCreateRequest request){
    	CodegenerTable codegenerTable=new CodegenerTable();
    	codegenerTable.setId(request.getId());
        ArrayList<CodegenerTable> codegenerTables= codegenerTableService.selectWithCondition(codegenerTable);
        if (codegenerTables!=null&&codegenerTables.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(CodegenerTableUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(CodegenerTableDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(CodegenerTableSelectRequest request){
        return  true;
     }    
}
