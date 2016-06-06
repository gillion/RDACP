/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.dataset;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.dataset.request.*;
import com.cartan.center.ebs.dataset.response.*;
import com.cartan.core.dataset.domain.Dataset;
import com.cartan.core.dataset.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class DatasetServiceEbsBase {
    static Logger logger = Logger.getLogger(DatasetServiceEbs.class.getName());
	private DatasetService  datasetService;
	
    public DatasetService getDatasetService() {
        return datasetService;
    }

    @Autowired
    public void setDatasetService(DatasetService datasetService) {
        this.datasetService = datasetService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(DatasetGetSessionRequest request) {      
    	DatasetGetSessionResponse datasetGetSessionResponse = new DatasetGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	datasetGetSessionResponse.setResultString("0");
        } else {
        	datasetGetSessionResponse.setResultString("1");
            datasetGetSessionResponse.setSessionId(request.getSessionId());
        }
        return datasetGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(DatasetGetSessionRequest request) {
    	DatasetGetSessionResponse datasetGetSessionResponse = new DatasetGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            datasetGetSessionResponse.setResultString("1");
        } else {
        	datasetGetSessionResponse.setResultString("0");
        }
        datasetGetSessionResponse.setSessionId(request.getSessionId());
        return datasetGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(DatasetGetSessionRequest request) {
    	DatasetGetSessionResponse datasetGetSessionResponse = new DatasetGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	datasetGetSessionResponse.setResultString("0");
        	datasetGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            datasetGetSessionResponse.setResultString("1");
        }
        return datasetGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.createDataset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createDataset(DatasetCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_Dataset_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Dataset dataset=new Dataset();
        dataset.setId(request.getId());    		
        dataset.setDatasetName(request.getDatasetName());
        dataset.setDatasetDes(request.getDatasetDes());
        dataset.setDatasetType(request.getDatasetType());
        dataset.setRemark(request.getRemark());
    	datasetService.createDataset(dataset);
        //返回响应
        DatasetCreateResponse datasetCreateResponse = new DatasetCreateResponse();
        datasetCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        datasetCreateResponse.setResultJson(dataset);
        return datasetCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.deleteDataset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteDataset(DatasetDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_Dataset_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        datasetService.deleteDataset(idstr);
        //返回响应
        DatasetDeleteResponse datasetDeleteResponse = new DatasetDeleteResponse();
        datasetDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return datasetDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.updateDataset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateDataset(DatasetUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_Dataset_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Dataset dataset=new Dataset();
        dataset=datasetService.getDataset(request.getId());
        if (request.getId()!=null){
	        dataset.setId(request.getId());
        }
        if (request.getDatasetName()!=null){
	        dataset.setDatasetName(request.getDatasetName());
        }
        if (request.getDatasetDes()!=null){
	        dataset.setDatasetDes(request.getDatasetDes());
        }
        if (request.getDatasetType()!=null){
	        dataset.setDatasetType(request.getDatasetType());
        }
        if (request.getRemark()!=null){
	        dataset.setRemark(request.getRemark());
        }
    	datasetService.updateDataset(dataset);
        //返回响应
        DatasetUpdateResponse datasetUpdateResponse = new DatasetUpdateResponse();
        datasetUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        datasetUpdateResponse.setResultJson(dataset);
        return datasetUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.getDataset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getDataset(DatasetGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        Dataset dataset=new Dataset();
        dataset=datasetService.getDataset(id);
        //返回响应
        DatasetGetResponse datasetGetResponse = new DatasetGetResponse();
        datasetGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        datasetGetResponse.setResultJson(dataset);
        return datasetGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(DatasetSelectAllRequest request) {
        DatasetSelectAllResponse datasetSelectAllResponse = new DatasetSelectAllResponse();
        datasetSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        datasetSelectAllResponse.setResultJson(datasetService.selectAll());
        return datasetSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(DatasetCountAllRequest request) {
        DatasetCountAllResponse datasetCountAllResponse = new DatasetCountAllResponse();
        datasetCountAllResponse.setResultString(String.valueOf(datasetService.countAll()));
        datasetCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return datasetCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(DatasetSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        DatasetSelectAllResponse datasetSelectAllResponse = new DatasetSelectAllResponse();
        datasetSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        datasetSelectAllResponse.setResultJson(datasetService.selectBySql(sqlstr));
        return datasetSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.selectDataset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(DatasetSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_Dataset_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Dataset dataset=new Dataset();
        dataset.setId(request.getId());
        dataset.setDatasetName(request.getDatasetName());
        dataset.setDatasetDes(request.getDatasetDes());
        dataset.setDatasetType(request.getDatasetType());
        dataset.setRemark(request.getRemark());
    	DatasetSelectResponse datasetSelectResponse = new DatasetSelectResponse();
        datasetSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<Dataset> datasets= datasetService.selectWithCondition(dataset);
        datasetSelectResponse.setResultJson(datasets);
        return datasetSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "dataset.isExistDataset", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistDataset(DatasetSelectRequest request) {
        Dataset dataset=new Dataset();
        dataset.setId(request.getId());
        dataset.setDatasetName(request.getDatasetName());
        dataset.setDatasetDes(request.getDatasetDes());
        dataset.setDatasetType(request.getDatasetType());
        dataset.setRemark(request.getRemark());
        ArrayList<Dataset> datasets= datasetService.selectWithCondition(dataset);
    	DatasetCountAllResponse datasetCountAllResponse = new DatasetCountAllResponse();
        if (datasets.size()>0){
        	datasetCountAllResponse.setResultString("1");
        } else {
        	datasetCountAllResponse.setResultString("0");
        }        
        return datasetCountAllResponse;
    }

    public Boolean validateCreateRequest(DatasetCreateRequest request){
    	Dataset dataset=new Dataset();
    	dataset.setId(request.getId());
        ArrayList<Dataset> datasets= datasetService.selectWithCondition(dataset);
        if (datasets!=null&&datasets.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(DatasetUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(DatasetDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(DatasetSelectRequest request){
        return  true;
     }    
}
