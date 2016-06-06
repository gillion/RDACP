/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.datasetVar;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.datasetVar.request.*;
import com.cartan.center.ebs.datasetVar.response.*;
import com.cartan.core.datasetVar.domain.DatasetVar;
import com.cartan.core.datasetVar.service.DatasetVarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class DatasetVarServiceEbsBase {
    static Logger logger = Logger.getLogger(DatasetVarServiceEbs.class.getName());
	private DatasetVarService  datasetVarService;
	
    public DatasetVarService getDatasetVarService() {
        return datasetVarService;
    }

    @Autowired
    public void setDatasetVarService(DatasetVarService datasetVarService) {
        this.datasetVarService = datasetVarService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(DatasetVarGetSessionRequest request) {      
    	DatasetVarGetSessionResponse datasetVarGetSessionResponse = new DatasetVarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	datasetVarGetSessionResponse.setResultString("0");
        } else {
        	datasetVarGetSessionResponse.setResultString("1");
            datasetVarGetSessionResponse.setSessionId(request.getSessionId());
        }
        return datasetVarGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(DatasetVarGetSessionRequest request) {
    	DatasetVarGetSessionResponse datasetVarGetSessionResponse = new DatasetVarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            datasetVarGetSessionResponse.setResultString("1");
        } else {
        	datasetVarGetSessionResponse.setResultString("0");
        }
        datasetVarGetSessionResponse.setSessionId(request.getSessionId());
        return datasetVarGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(DatasetVarGetSessionRequest request) {
    	DatasetVarGetSessionResponse datasetVarGetSessionResponse = new DatasetVarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	datasetVarGetSessionResponse.setResultString("0");
        	datasetVarGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            datasetVarGetSessionResponse.setResultString("1");
        }
        return datasetVarGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.createDatasetVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createDatasetVar(DatasetVarCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_DatasetVar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        DatasetVar datasetVar=new DatasetVar();
        datasetVar.setId(request.getId());    		
        datasetVar.setDatasetId(request.getDatasetId());
        datasetVar.setVarName(request.getVarName());
        datasetVar.setVarDes(request.getVarDes());
        datasetVar.setIsDerived(request.getIsDerived());
        datasetVar.setIsSet(request.getIsSet());
        datasetVar.setVarType(request.getVarType());
        datasetVar.setSpanBegin(request.getSpanBegin());
        datasetVar.setSpanEnd(request.getSpanEnd());
        datasetVar.setIsOutput(request.getIsOutput());
        datasetVar.setDefValue(request.getDefValue());
        datasetVar.setRemark(request.getRemark());
    	datasetVarService.createDatasetVar(datasetVar);
        //返回响应
        DatasetVarCreateResponse datasetVarCreateResponse = new DatasetVarCreateResponse();
        datasetVarCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        datasetVarCreateResponse.setResultJson(datasetVar);
        return datasetVarCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.deleteDatasetVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteDatasetVar(DatasetVarDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_DatasetVar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        datasetVarService.deleteDatasetVar(idstr);
        //返回响应
        DatasetVarDeleteResponse datasetVarDeleteResponse = new DatasetVarDeleteResponse();
        datasetVarDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return datasetVarDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.updateDatasetVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateDatasetVar(DatasetVarUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_DatasetVar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        DatasetVar datasetVar=new DatasetVar();
        datasetVar=datasetVarService.getDatasetVar(request.getId());
        if (request.getId()!=null){
	        datasetVar.setId(request.getId());
        }
        if (request.getDatasetId()!=null){
	        datasetVar.setDatasetId(request.getDatasetId());
        }
        if (request.getVarName()!=null){
	        datasetVar.setVarName(request.getVarName());
        }
        if (request.getVarDes()!=null){
	        datasetVar.setVarDes(request.getVarDes());
        }
        if (request.getIsDerived()!=null){
	        datasetVar.setIsDerived(request.getIsDerived());
        }
        if (request.getIsSet()!=null){
	        datasetVar.setIsSet(request.getIsSet());
        }
        if (request.getVarType()!=null){
	        datasetVar.setVarType(request.getVarType());
        }
        if (request.getSpanBegin()!=null){
	        datasetVar.setSpanBegin(request.getSpanBegin());
        }
        if (request.getSpanEnd()!=null){
	        datasetVar.setSpanEnd(request.getSpanEnd());
        }
        if (request.getIsOutput()!=null){
	        datasetVar.setIsOutput(request.getIsOutput());
        }
        if (request.getDefValue()!=null){
	        datasetVar.setDefValue(request.getDefValue());
        }
        if (request.getRemark()!=null){
	        datasetVar.setRemark(request.getRemark());
        }
    	datasetVarService.updateDatasetVar(datasetVar);
        //返回响应
        DatasetVarUpdateResponse datasetVarUpdateResponse = new DatasetVarUpdateResponse();
        datasetVarUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        datasetVarUpdateResponse.setResultJson(datasetVar);
        return datasetVarUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.getDatasetVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getDatasetVar(DatasetVarGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        DatasetVar datasetVar=new DatasetVar();
        datasetVar=datasetVarService.getDatasetVar(id);
        //返回响应
        DatasetVarGetResponse datasetVarGetResponse = new DatasetVarGetResponse();
        datasetVarGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        datasetVarGetResponse.setResultJson(datasetVar);
        return datasetVarGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(DatasetVarSelectAllRequest request) {
        DatasetVarSelectAllResponse datasetVarSelectAllResponse = new DatasetVarSelectAllResponse();
        datasetVarSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        datasetVarSelectAllResponse.setResultJson(datasetVarService.selectAll());
        return datasetVarSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(DatasetVarCountAllRequest request) {
        DatasetVarCountAllResponse datasetVarCountAllResponse = new DatasetVarCountAllResponse();
        datasetVarCountAllResponse.setResultString(String.valueOf(datasetVarService.countAll()));
        datasetVarCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return datasetVarCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(DatasetVarSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        DatasetVarSelectAllResponse datasetVarSelectAllResponse = new DatasetVarSelectAllResponse();
        datasetVarSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        datasetVarSelectAllResponse.setResultJson(datasetVarService.selectBySql(sqlstr));
        return datasetVarSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.selectDatasetVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(DatasetVarSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_DatasetVar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        DatasetVar datasetVar=new DatasetVar();
        datasetVar.setId(request.getId());
        datasetVar.setDatasetId(request.getDatasetId());
        datasetVar.setVarName(request.getVarName());
        datasetVar.setVarDes(request.getVarDes());
        datasetVar.setIsDerived(request.getIsDerived());
        datasetVar.setIsSet(request.getIsSet());
        datasetVar.setVarType(request.getVarType());
        datasetVar.setSpanBegin(request.getSpanBegin());
        datasetVar.setSpanEnd(request.getSpanEnd());
        datasetVar.setIsOutput(request.getIsOutput());
        datasetVar.setDefValue(request.getDefValue());
        datasetVar.setRemark(request.getRemark());
    	DatasetVarSelectResponse datasetVarSelectResponse = new DatasetVarSelectResponse();
        datasetVarSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<DatasetVar> datasetVars= datasetVarService.selectWithCondition(datasetVar);
        datasetVarSelectResponse.setResultJson(datasetVars);
        return datasetVarSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "datasetVar.isExistDatasetVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistDatasetVar(DatasetVarSelectRequest request) {
        DatasetVar datasetVar=new DatasetVar();
        datasetVar.setId(request.getId());
        datasetVar.setDatasetId(request.getDatasetId());
        datasetVar.setVarName(request.getVarName());
        datasetVar.setVarDes(request.getVarDes());
        datasetVar.setIsDerived(request.getIsDerived());
        datasetVar.setIsSet(request.getIsSet());
        datasetVar.setVarType(request.getVarType());
        datasetVar.setSpanBegin(request.getSpanBegin());
        datasetVar.setSpanEnd(request.getSpanEnd());
        datasetVar.setIsOutput(request.getIsOutput());
        datasetVar.setDefValue(request.getDefValue());
        datasetVar.setRemark(request.getRemark());
        ArrayList<DatasetVar> datasetVars= datasetVarService.selectWithCondition(datasetVar);
    	DatasetVarCountAllResponse datasetVarCountAllResponse = new DatasetVarCountAllResponse();
        if (datasetVars.size()>0){
        	datasetVarCountAllResponse.setResultString("1");
        } else {
        	datasetVarCountAllResponse.setResultString("0");
        }        
        return datasetVarCountAllResponse;
    }

    public Boolean validateCreateRequest(DatasetVarCreateRequest request){
    	DatasetVar datasetVar=new DatasetVar();
    	datasetVar.setId(request.getId());
        ArrayList<DatasetVar> datasetVars= datasetVarService.selectWithCondition(datasetVar);
        if (datasetVars!=null&&datasetVars.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(DatasetVarUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(DatasetVarDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(DatasetVarSelectRequest request){
        return  true;
     }    
}
