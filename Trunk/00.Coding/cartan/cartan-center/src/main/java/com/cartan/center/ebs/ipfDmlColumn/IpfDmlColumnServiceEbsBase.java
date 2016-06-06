/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlColumn;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlColumn.request.*;
import com.cartan.center.ebs.ipfDmlColumn.response.*;
import com.cartan.core.ipfDmlColumn.domain.IpfDmlColumn;
import com.cartan.core.ipfDmlColumn.service.IpfDmlColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlColumnServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlColumnServiceEbs.class.getName());
	private IpfDmlColumnService  ipfDmlColumnService;
	
    public IpfDmlColumnService getIpfDmlColumnService() {
        return ipfDmlColumnService;
    }

    @Autowired
    public void setIpfDmlColumnService(IpfDmlColumnService ipfDmlColumnService) {
        this.ipfDmlColumnService = ipfDmlColumnService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlColumnGetSessionRequest request) {      
    	IpfDmlColumnGetSessionResponse ipfDmlColumnGetSessionResponse = new IpfDmlColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlColumnGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlColumnGetSessionResponse.setResultString("1");
            ipfDmlColumnGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlColumnGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlColumnGetSessionRequest request) {
    	IpfDmlColumnGetSessionResponse ipfDmlColumnGetSessionResponse = new IpfDmlColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlColumnGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlColumnGetSessionResponse.setResultString("0");
        }
        ipfDmlColumnGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlColumnGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlColumnGetSessionRequest request) {
    	IpfDmlColumnGetSessionResponse ipfDmlColumnGetSessionResponse = new IpfDmlColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlColumnGetSessionResponse.setResultString("0");
        	ipfDmlColumnGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlColumnGetSessionResponse.setResultString("1");
        }
        return ipfDmlColumnGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.createIpfDmlColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlColumn(IpfDmlColumnCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlColumn ipfDmlColumn=new IpfDmlColumn();
        ipfDmlColumn.setId(request.getId());    		
        ipfDmlColumn.setIpfDmlTableId(request.getIpfDmlTableId());
        ipfDmlColumn.setColumnName(request.getColumnName());
        ipfDmlColumn.setIpfDmlElementId(request.getIpfDmlElementId());
        ipfDmlColumn.setElementCode(request.getElementCode());
        ipfDmlColumn.setFieldText(request.getFieldText());
        ipfDmlColumn.setDataType(request.getDataType());
        ipfDmlColumn.setFieldLength(request.getFieldLength());
        ipfDmlColumn.setDecimals(request.getDecimals());
        ipfDmlColumn.setIsNotNull(request.getIsNotNull());
        ipfDmlColumn.setIsPrimaryKey(request.getIsPrimaryKey());
        ipfDmlColumn.setDefaultValue(request.getDefaultValue());
        ipfDmlColumn.setInitValue(request.getInitValue());
    	ipfDmlColumnService.createIpfDmlColumn(ipfDmlColumn);
        //返回响应
        IpfDmlColumnCreateResponse ipfDmlColumnCreateResponse = new IpfDmlColumnCreateResponse();
        ipfDmlColumnCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlColumnCreateResponse.setResultJson(ipfDmlColumn);
        return ipfDmlColumnCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.deleteIpfDmlColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlColumn(IpfDmlColumnDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlColumnService.deleteIpfDmlColumn(idstr);
        //返回响应
        IpfDmlColumnDeleteResponse ipfDmlColumnDeleteResponse = new IpfDmlColumnDeleteResponse();
        ipfDmlColumnDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlColumnDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.updateIpfDmlColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlColumn(IpfDmlColumnUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlColumn ipfDmlColumn=new IpfDmlColumn();
        ipfDmlColumn=ipfDmlColumnService.getIpfDmlColumn(request.getId());
        if (request.getId()!=null){
	        ipfDmlColumn.setId(request.getId());
        }
        if (request.getIpfDmlTableId()!=null){
	        ipfDmlColumn.setIpfDmlTableId(request.getIpfDmlTableId());
        }
        if (request.getColumnName()!=null){
	        ipfDmlColumn.setColumnName(request.getColumnName());
        }
        if (request.getIpfDmlElementId()!=null){
	        ipfDmlColumn.setIpfDmlElementId(request.getIpfDmlElementId());
        }
        if (request.getElementCode()!=null){
	        ipfDmlColumn.setElementCode(request.getElementCode());
        }
        if (request.getFieldText()!=null){
	        ipfDmlColumn.setFieldText(request.getFieldText());
        }
        if (request.getDataType()!=null){
	        ipfDmlColumn.setDataType(request.getDataType());
        }
        if (request.getFieldLength()!=null){
	        ipfDmlColumn.setFieldLength(request.getFieldLength());
        }
        if (request.getDecimals()!=null){
	        ipfDmlColumn.setDecimals(request.getDecimals());
        }
        if (request.getIsNotNull()!=null){
	        ipfDmlColumn.setIsNotNull(request.getIsNotNull());
        }
        if (request.getIsPrimaryKey()!=null){
	        ipfDmlColumn.setIsPrimaryKey(request.getIsPrimaryKey());
        }
        if (request.getDefaultValue()!=null){
	        ipfDmlColumn.setDefaultValue(request.getDefaultValue());
        }
        if (request.getInitValue()!=null){
	        ipfDmlColumn.setInitValue(request.getInitValue());
        }
    	ipfDmlColumnService.updateIpfDmlColumn(ipfDmlColumn);
        //返回响应
        IpfDmlColumnUpdateResponse ipfDmlColumnUpdateResponse = new IpfDmlColumnUpdateResponse();
        ipfDmlColumnUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlColumnUpdateResponse.setResultJson(ipfDmlColumn);
        return ipfDmlColumnUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.getIpfDmlColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlColumn(IpfDmlColumnGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlColumn ipfDmlColumn=new IpfDmlColumn();
        ipfDmlColumn=ipfDmlColumnService.getIpfDmlColumn(id);
        //返回响应
        IpfDmlColumnGetResponse ipfDmlColumnGetResponse = new IpfDmlColumnGetResponse();
        ipfDmlColumnGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlColumnGetResponse.setResultJson(ipfDmlColumn);
        return ipfDmlColumnGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlColumnSelectAllRequest request) {
        IpfDmlColumnSelectAllResponse ipfDmlColumnSelectAllResponse = new IpfDmlColumnSelectAllResponse();
        ipfDmlColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlColumnSelectAllResponse.setResultJson(ipfDmlColumnService.selectAll());
        return ipfDmlColumnSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlColumnCountAllRequest request) {
        IpfDmlColumnCountAllResponse ipfDmlColumnCountAllResponse = new IpfDmlColumnCountAllResponse();
        ipfDmlColumnCountAllResponse.setResultString(String.valueOf(ipfDmlColumnService.countAll()));
        ipfDmlColumnCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlColumnCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlColumnSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlColumnSelectAllResponse ipfDmlColumnSelectAllResponse = new IpfDmlColumnSelectAllResponse();
        ipfDmlColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlColumnSelectAllResponse.setResultJson(ipfDmlColumnService.selectBySql(sqlstr));
        return ipfDmlColumnSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.selectIpfDmlColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlColumnSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlColumn ipfDmlColumn=new IpfDmlColumn();
        ipfDmlColumn.setId(request.getId());
        ipfDmlColumn.setIpfDmlTableId(request.getIpfDmlTableId());
        ipfDmlColumn.setColumnName(request.getColumnName());
        ipfDmlColumn.setIpfDmlElementId(request.getIpfDmlElementId());
        ipfDmlColumn.setElementCode(request.getElementCode());
        ipfDmlColumn.setFieldText(request.getFieldText());
        ipfDmlColumn.setDataType(request.getDataType());
        ipfDmlColumn.setFieldLength(request.getFieldLength());
        ipfDmlColumn.setDecimals(request.getDecimals());
        ipfDmlColumn.setIsNotNull(request.getIsNotNull());
        ipfDmlColumn.setIsPrimaryKey(request.getIsPrimaryKey());
        ipfDmlColumn.setDefaultValue(request.getDefaultValue());
        ipfDmlColumn.setInitValue(request.getInitValue());
    	IpfDmlColumnSelectResponse ipfDmlColumnSelectResponse = new IpfDmlColumnSelectResponse();
        ipfDmlColumnSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlColumn> ipfDmlColumns= ipfDmlColumnService.selectWithCondition(ipfDmlColumn);
        ipfDmlColumnSelectResponse.setResultJson(ipfDmlColumns);
        return ipfDmlColumnSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlColumn.isExistIpfDmlColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlColumn(IpfDmlColumnSelectRequest request) {
        IpfDmlColumn ipfDmlColumn=new IpfDmlColumn();
        ipfDmlColumn.setId(request.getId());
        ipfDmlColumn.setIpfDmlTableId(request.getIpfDmlTableId());
        ipfDmlColumn.setColumnName(request.getColumnName());
        ipfDmlColumn.setIpfDmlElementId(request.getIpfDmlElementId());
        ipfDmlColumn.setElementCode(request.getElementCode());
        ipfDmlColumn.setFieldText(request.getFieldText());
        ipfDmlColumn.setDataType(request.getDataType());
        ipfDmlColumn.setFieldLength(request.getFieldLength());
        ipfDmlColumn.setDecimals(request.getDecimals());
        ipfDmlColumn.setIsNotNull(request.getIsNotNull());
        ipfDmlColumn.setIsPrimaryKey(request.getIsPrimaryKey());
        ipfDmlColumn.setDefaultValue(request.getDefaultValue());
        ipfDmlColumn.setInitValue(request.getInitValue());
        ArrayList<IpfDmlColumn> ipfDmlColumns= ipfDmlColumnService.selectWithCondition(ipfDmlColumn);
    	IpfDmlColumnCountAllResponse ipfDmlColumnCountAllResponse = new IpfDmlColumnCountAllResponse();
        if (ipfDmlColumns.size()>0){
        	ipfDmlColumnCountAllResponse.setResultString("1");
        } else {
        	ipfDmlColumnCountAllResponse.setResultString("0");
        }        
        return ipfDmlColumnCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlColumnCreateRequest request){
    	IpfDmlColumn ipfDmlColumn=new IpfDmlColumn();
    	ipfDmlColumn.setId(request.getId());
        ArrayList<IpfDmlColumn> ipfDmlColumns= ipfDmlColumnService.selectWithCondition(ipfDmlColumn);
        if (ipfDmlColumns!=null&&ipfDmlColumns.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlColumnUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlColumnDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlColumnSelectRequest request){
        return  true;
     }    
}
