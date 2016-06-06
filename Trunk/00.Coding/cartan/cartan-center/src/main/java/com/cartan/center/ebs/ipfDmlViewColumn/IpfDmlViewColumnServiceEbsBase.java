/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlViewColumn;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlViewColumn.request.*;
import com.cartan.center.ebs.ipfDmlViewColumn.response.*;
import com.cartan.core.ipfDmlViewColumn.domain.IpfDmlViewColumn;
import com.cartan.core.ipfDmlViewColumn.service.IpfDmlViewColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlViewColumnServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlViewColumnServiceEbs.class.getName());
	private IpfDmlViewColumnService  ipfDmlViewColumnService;
	
    public IpfDmlViewColumnService getIpfDmlViewColumnService() {
        return ipfDmlViewColumnService;
    }

    @Autowired
    public void setIpfDmlViewColumnService(IpfDmlViewColumnService ipfDmlViewColumnService) {
        this.ipfDmlViewColumnService = ipfDmlViewColumnService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlViewColumnGetSessionRequest request) {      
    	IpfDmlViewColumnGetSessionResponse ipfDmlViewColumnGetSessionResponse = new IpfDmlViewColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlViewColumnGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlViewColumnGetSessionResponse.setResultString("1");
            ipfDmlViewColumnGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlViewColumnGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlViewColumnGetSessionRequest request) {
    	IpfDmlViewColumnGetSessionResponse ipfDmlViewColumnGetSessionResponse = new IpfDmlViewColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlViewColumnGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlViewColumnGetSessionResponse.setResultString("0");
        }
        ipfDmlViewColumnGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlViewColumnGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlViewColumnGetSessionRequest request) {
    	IpfDmlViewColumnGetSessionResponse ipfDmlViewColumnGetSessionResponse = new IpfDmlViewColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlViewColumnGetSessionResponse.setResultString("0");
        	ipfDmlViewColumnGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlViewColumnGetSessionResponse.setResultString("1");
        }
        return ipfDmlViewColumnGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.createIpfDmlViewColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlViewColumn(IpfDmlViewColumnCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlViewColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlViewColumn ipfDmlViewColumn=new IpfDmlViewColumn();
        ipfDmlViewColumn.setId(request.getId());    		
        ipfDmlViewColumn.setIpfDmlViewId(request.getIpfDmlViewId());
        ipfDmlViewColumn.setColumnName(request.getColumnName());
        ipfDmlViewColumn.setFieldText(request.getFieldText());
        ipfDmlViewColumn.setDataType(request.getDataType());
        ipfDmlViewColumn.setFieldLength(request.getFieldLength());
        ipfDmlViewColumn.setDecimals(request.getDecimals());
        ipfDmlViewColumn.setIsNotNull(request.getIsNotNull());
        ipfDmlViewColumn.setIsPrimaryKey(request.getIsPrimaryKey());
    	ipfDmlViewColumnService.createIpfDmlViewColumn(ipfDmlViewColumn);
        //返回响应
        IpfDmlViewColumnCreateResponse ipfDmlViewColumnCreateResponse = new IpfDmlViewColumnCreateResponse();
        ipfDmlViewColumnCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewColumnCreateResponse.setResultJson(ipfDmlViewColumn);
        return ipfDmlViewColumnCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.deleteIpfDmlViewColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlViewColumn(IpfDmlViewColumnDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlViewColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlViewColumnService.deleteIpfDmlViewColumn(idstr);
        //返回响应
        IpfDmlViewColumnDeleteResponse ipfDmlViewColumnDeleteResponse = new IpfDmlViewColumnDeleteResponse();
        ipfDmlViewColumnDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlViewColumnDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.updateIpfDmlViewColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlViewColumn(IpfDmlViewColumnUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlViewColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlViewColumn ipfDmlViewColumn=new IpfDmlViewColumn();
        ipfDmlViewColumn=ipfDmlViewColumnService.getIpfDmlViewColumn(request.getId());
        if (request.getId()!=null){
	        ipfDmlViewColumn.setId(request.getId());
        }
        if (request.getIpfDmlViewId()!=null){
	        ipfDmlViewColumn.setIpfDmlViewId(request.getIpfDmlViewId());
        }
        if (request.getColumnName()!=null){
	        ipfDmlViewColumn.setColumnName(request.getColumnName());
        }
        if (request.getFieldText()!=null){
	        ipfDmlViewColumn.setFieldText(request.getFieldText());
        }
        if (request.getDataType()!=null){
	        ipfDmlViewColumn.setDataType(request.getDataType());
        }
        if (request.getFieldLength()!=null){
	        ipfDmlViewColumn.setFieldLength(request.getFieldLength());
        }
        if (request.getDecimals()!=null){
	        ipfDmlViewColumn.setDecimals(request.getDecimals());
        }
        if (request.getIsNotNull()!=null){
	        ipfDmlViewColumn.setIsNotNull(request.getIsNotNull());
        }
        if (request.getIsPrimaryKey()!=null){
	        ipfDmlViewColumn.setIsPrimaryKey(request.getIsPrimaryKey());
        }
    	ipfDmlViewColumnService.updateIpfDmlViewColumn(ipfDmlViewColumn);
        //返回响应
        IpfDmlViewColumnUpdateResponse ipfDmlViewColumnUpdateResponse = new IpfDmlViewColumnUpdateResponse();
        ipfDmlViewColumnUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewColumnUpdateResponse.setResultJson(ipfDmlViewColumn);
        return ipfDmlViewColumnUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.getIpfDmlViewColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlViewColumn(IpfDmlViewColumnGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlViewColumn ipfDmlViewColumn=new IpfDmlViewColumn();
        ipfDmlViewColumn=ipfDmlViewColumnService.getIpfDmlViewColumn(id);
        //返回响应
        IpfDmlViewColumnGetResponse ipfDmlViewColumnGetResponse = new IpfDmlViewColumnGetResponse();
        ipfDmlViewColumnGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewColumnGetResponse.setResultJson(ipfDmlViewColumn);
        return ipfDmlViewColumnGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlViewColumnSelectAllRequest request) {
        IpfDmlViewColumnSelectAllResponse ipfDmlViewColumnSelectAllResponse = new IpfDmlViewColumnSelectAllResponse();
        ipfDmlViewColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewColumnSelectAllResponse.setResultJson(ipfDmlViewColumnService.selectAll());
        return ipfDmlViewColumnSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlViewColumnCountAllRequest request) {
        IpfDmlViewColumnCountAllResponse ipfDmlViewColumnCountAllResponse = new IpfDmlViewColumnCountAllResponse();
        ipfDmlViewColumnCountAllResponse.setResultString(String.valueOf(ipfDmlViewColumnService.countAll()));
        ipfDmlViewColumnCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlViewColumnCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlViewColumnSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlViewColumnSelectAllResponse ipfDmlViewColumnSelectAllResponse = new IpfDmlViewColumnSelectAllResponse();
        ipfDmlViewColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewColumnSelectAllResponse.setResultJson(ipfDmlViewColumnService.selectBySql(sqlstr));
        return ipfDmlViewColumnSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.selectIpfDmlViewColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlViewColumnSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlViewColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlViewColumn ipfDmlViewColumn=new IpfDmlViewColumn();
        ipfDmlViewColumn.setId(request.getId());
        ipfDmlViewColumn.setIpfDmlViewId(request.getIpfDmlViewId());
        ipfDmlViewColumn.setColumnName(request.getColumnName());
        ipfDmlViewColumn.setFieldText(request.getFieldText());
        ipfDmlViewColumn.setDataType(request.getDataType());
        ipfDmlViewColumn.setFieldLength(request.getFieldLength());
        ipfDmlViewColumn.setDecimals(request.getDecimals());
        ipfDmlViewColumn.setIsNotNull(request.getIsNotNull());
        ipfDmlViewColumn.setIsPrimaryKey(request.getIsPrimaryKey());
    	IpfDmlViewColumnSelectResponse ipfDmlViewColumnSelectResponse = new IpfDmlViewColumnSelectResponse();
        ipfDmlViewColumnSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlViewColumn> ipfDmlViewColumns= ipfDmlViewColumnService.selectWithCondition(ipfDmlViewColumn);
        ipfDmlViewColumnSelectResponse.setResultJson(ipfDmlViewColumns);
        return ipfDmlViewColumnSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewColumn.isExistIpfDmlViewColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlViewColumn(IpfDmlViewColumnSelectRequest request) {
        IpfDmlViewColumn ipfDmlViewColumn=new IpfDmlViewColumn();
        ipfDmlViewColumn.setId(request.getId());
        ipfDmlViewColumn.setIpfDmlViewId(request.getIpfDmlViewId());
        ipfDmlViewColumn.setColumnName(request.getColumnName());
        ipfDmlViewColumn.setFieldText(request.getFieldText());
        ipfDmlViewColumn.setDataType(request.getDataType());
        ipfDmlViewColumn.setFieldLength(request.getFieldLength());
        ipfDmlViewColumn.setDecimals(request.getDecimals());
        ipfDmlViewColumn.setIsNotNull(request.getIsNotNull());
        ipfDmlViewColumn.setIsPrimaryKey(request.getIsPrimaryKey());
        ArrayList<IpfDmlViewColumn> ipfDmlViewColumns= ipfDmlViewColumnService.selectWithCondition(ipfDmlViewColumn);
    	IpfDmlViewColumnCountAllResponse ipfDmlViewColumnCountAllResponse = new IpfDmlViewColumnCountAllResponse();
        if (ipfDmlViewColumns.size()>0){
        	ipfDmlViewColumnCountAllResponse.setResultString("1");
        } else {
        	ipfDmlViewColumnCountAllResponse.setResultString("0");
        }        
        return ipfDmlViewColumnCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlViewColumnCreateRequest request){
    	IpfDmlViewColumn ipfDmlViewColumn=new IpfDmlViewColumn();
    	ipfDmlViewColumn.setId(request.getId());
        ArrayList<IpfDmlViewColumn> ipfDmlViewColumns= ipfDmlViewColumnService.selectWithCondition(ipfDmlViewColumn);
        if (ipfDmlViewColumns!=null&&ipfDmlViewColumns.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlViewColumnUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlViewColumnDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlViewColumnSelectRequest request){
        return  true;
     }    
}
