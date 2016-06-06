/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlConstraintColumn;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlConstraintColumn.request.*;
import com.cartan.center.ebs.ipfDmlConstraintColumn.response.*;
import com.cartan.core.ipfDmlConstraintColumn.domain.IpfDmlConstraintColumn;
import com.cartan.core.ipfDmlConstraintColumn.service.IpfDmlConstraintColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlConstraintColumnServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlConstraintColumnServiceEbs.class.getName());
	private IpfDmlConstraintColumnService  ipfDmlConstraintColumnService;
	
    public IpfDmlConstraintColumnService getIpfDmlConstraintColumnService() {
        return ipfDmlConstraintColumnService;
    }

    @Autowired
    public void setIpfDmlConstraintColumnService(IpfDmlConstraintColumnService ipfDmlConstraintColumnService) {
        this.ipfDmlConstraintColumnService = ipfDmlConstraintColumnService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlConstraintColumnGetSessionRequest request) {      
    	IpfDmlConstraintColumnGetSessionResponse ipfDmlConstraintColumnGetSessionResponse = new IpfDmlConstraintColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlConstraintColumnGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlConstraintColumnGetSessionResponse.setResultString("1");
            ipfDmlConstraintColumnGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlConstraintColumnGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlConstraintColumnGetSessionRequest request) {
    	IpfDmlConstraintColumnGetSessionResponse ipfDmlConstraintColumnGetSessionResponse = new IpfDmlConstraintColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlConstraintColumnGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlConstraintColumnGetSessionResponse.setResultString("0");
        }
        ipfDmlConstraintColumnGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlConstraintColumnGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlConstraintColumnGetSessionRequest request) {
    	IpfDmlConstraintColumnGetSessionResponse ipfDmlConstraintColumnGetSessionResponse = new IpfDmlConstraintColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlConstraintColumnGetSessionResponse.setResultString("0");
        	ipfDmlConstraintColumnGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlConstraintColumnGetSessionResponse.setResultString("1");
        }
        return ipfDmlConstraintColumnGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.createIpfDmlConstraintColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlConstraintColumn(IpfDmlConstraintColumnCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlConstraintColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlConstraintColumn ipfDmlConstraintColumn=new IpfDmlConstraintColumn();
        ipfDmlConstraintColumn.setId(request.getId());    		
        ipfDmlConstraintColumn.setIpfDmlConstraintId(request.getIpfDmlConstraintId());
        ipfDmlConstraintColumn.setColumnName(request.getColumnName());
    	ipfDmlConstraintColumnService.createIpfDmlConstraintColumn(ipfDmlConstraintColumn);
        //返回响应
        IpfDmlConstraintColumnCreateResponse ipfDmlConstraintColumnCreateResponse = new IpfDmlConstraintColumnCreateResponse();
        ipfDmlConstraintColumnCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlConstraintColumnCreateResponse.setResultJson(ipfDmlConstraintColumn);
        return ipfDmlConstraintColumnCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.deleteIpfDmlConstraintColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlConstraintColumn(IpfDmlConstraintColumnDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlConstraintColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlConstraintColumnService.deleteIpfDmlConstraintColumn(idstr);
        //返回响应
        IpfDmlConstraintColumnDeleteResponse ipfDmlConstraintColumnDeleteResponse = new IpfDmlConstraintColumnDeleteResponse();
        ipfDmlConstraintColumnDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlConstraintColumnDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.updateIpfDmlConstraintColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlConstraintColumn(IpfDmlConstraintColumnUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlConstraintColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlConstraintColumn ipfDmlConstraintColumn=new IpfDmlConstraintColumn();
        ipfDmlConstraintColumn=ipfDmlConstraintColumnService.getIpfDmlConstraintColumn(request.getId());
        if (request.getId()!=null){
	        ipfDmlConstraintColumn.setId(request.getId());
        }
        if (request.getIpfDmlConstraintId()!=null){
	        ipfDmlConstraintColumn.setIpfDmlConstraintId(request.getIpfDmlConstraintId());
        }
        if (request.getColumnName()!=null){
	        ipfDmlConstraintColumn.setColumnName(request.getColumnName());
        }
    	ipfDmlConstraintColumnService.updateIpfDmlConstraintColumn(ipfDmlConstraintColumn);
        //返回响应
        IpfDmlConstraintColumnUpdateResponse ipfDmlConstraintColumnUpdateResponse = new IpfDmlConstraintColumnUpdateResponse();
        ipfDmlConstraintColumnUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlConstraintColumnUpdateResponse.setResultJson(ipfDmlConstraintColumn);
        return ipfDmlConstraintColumnUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.getIpfDmlConstraintColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlConstraintColumn(IpfDmlConstraintColumnGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlConstraintColumn ipfDmlConstraintColumn=new IpfDmlConstraintColumn();
        ipfDmlConstraintColumn=ipfDmlConstraintColumnService.getIpfDmlConstraintColumn(id);
        //返回响应
        IpfDmlConstraintColumnGetResponse ipfDmlConstraintColumnGetResponse = new IpfDmlConstraintColumnGetResponse();
        ipfDmlConstraintColumnGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlConstraintColumnGetResponse.setResultJson(ipfDmlConstraintColumn);
        return ipfDmlConstraintColumnGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlConstraintColumnSelectAllRequest request) {
        IpfDmlConstraintColumnSelectAllResponse ipfDmlConstraintColumnSelectAllResponse = new IpfDmlConstraintColumnSelectAllResponse();
        ipfDmlConstraintColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlConstraintColumnSelectAllResponse.setResultJson(ipfDmlConstraintColumnService.selectAll());
        return ipfDmlConstraintColumnSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlConstraintColumnCountAllRequest request) {
        IpfDmlConstraintColumnCountAllResponse ipfDmlConstraintColumnCountAllResponse = new IpfDmlConstraintColumnCountAllResponse();
        ipfDmlConstraintColumnCountAllResponse.setResultString(String.valueOf(ipfDmlConstraintColumnService.countAll()));
        ipfDmlConstraintColumnCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlConstraintColumnCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlConstraintColumnSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlConstraintColumnSelectAllResponse ipfDmlConstraintColumnSelectAllResponse = new IpfDmlConstraintColumnSelectAllResponse();
        ipfDmlConstraintColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlConstraintColumnSelectAllResponse.setResultJson(ipfDmlConstraintColumnService.selectBySql(sqlstr));
        return ipfDmlConstraintColumnSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.selectIpfDmlConstraintColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlConstraintColumnSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlConstraintColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlConstraintColumn ipfDmlConstraintColumn=new IpfDmlConstraintColumn();
        ipfDmlConstraintColumn.setId(request.getId());
        ipfDmlConstraintColumn.setIpfDmlConstraintId(request.getIpfDmlConstraintId());
        ipfDmlConstraintColumn.setColumnName(request.getColumnName());
    	IpfDmlConstraintColumnSelectResponse ipfDmlConstraintColumnSelectResponse = new IpfDmlConstraintColumnSelectResponse();
        ipfDmlConstraintColumnSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlConstraintColumn> ipfDmlConstraintColumns= ipfDmlConstraintColumnService.selectWithCondition(ipfDmlConstraintColumn);
        ipfDmlConstraintColumnSelectResponse.setResultJson(ipfDmlConstraintColumns);
        return ipfDmlConstraintColumnSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraintColumn.isExistIpfDmlConstraintColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlConstraintColumn(IpfDmlConstraintColumnSelectRequest request) {
        IpfDmlConstraintColumn ipfDmlConstraintColumn=new IpfDmlConstraintColumn();
        ipfDmlConstraintColumn.setId(request.getId());
        ipfDmlConstraintColumn.setIpfDmlConstraintId(request.getIpfDmlConstraintId());
        ipfDmlConstraintColumn.setColumnName(request.getColumnName());
        ArrayList<IpfDmlConstraintColumn> ipfDmlConstraintColumns= ipfDmlConstraintColumnService.selectWithCondition(ipfDmlConstraintColumn);
    	IpfDmlConstraintColumnCountAllResponse ipfDmlConstraintColumnCountAllResponse = new IpfDmlConstraintColumnCountAllResponse();
        if (ipfDmlConstraintColumns.size()>0){
        	ipfDmlConstraintColumnCountAllResponse.setResultString("1");
        } else {
        	ipfDmlConstraintColumnCountAllResponse.setResultString("0");
        }        
        return ipfDmlConstraintColumnCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlConstraintColumnCreateRequest request){
    	IpfDmlConstraintColumn ipfDmlConstraintColumn=new IpfDmlConstraintColumn();
    	ipfDmlConstraintColumn.setId(request.getId());
        ArrayList<IpfDmlConstraintColumn> ipfDmlConstraintColumns= ipfDmlConstraintColumnService.selectWithCondition(ipfDmlConstraintColumn);
        if (ipfDmlConstraintColumns!=null&&ipfDmlConstraintColumns.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlConstraintColumnUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlConstraintColumnDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlConstraintColumnSelectRequest request){
        return  true;
     }    
}
