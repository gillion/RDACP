/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlIndexColumn;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlIndexColumn.request.*;
import com.cartan.center.ebs.ipfDmlIndexColumn.response.*;
import com.cartan.core.ipfDmlIndexColumn.domain.IpfDmlIndexColumn;
import com.cartan.core.ipfDmlIndexColumn.service.IpfDmlIndexColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlIndexColumnServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlIndexColumnServiceEbs.class.getName());
	private IpfDmlIndexColumnService  ipfDmlIndexColumnService;
	
    public IpfDmlIndexColumnService getIpfDmlIndexColumnService() {
        return ipfDmlIndexColumnService;
    }

    @Autowired
    public void setIpfDmlIndexColumnService(IpfDmlIndexColumnService ipfDmlIndexColumnService) {
        this.ipfDmlIndexColumnService = ipfDmlIndexColumnService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlIndexColumnGetSessionRequest request) {      
    	IpfDmlIndexColumnGetSessionResponse ipfDmlIndexColumnGetSessionResponse = new IpfDmlIndexColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlIndexColumnGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlIndexColumnGetSessionResponse.setResultString("1");
            ipfDmlIndexColumnGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlIndexColumnGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlIndexColumnGetSessionRequest request) {
    	IpfDmlIndexColumnGetSessionResponse ipfDmlIndexColumnGetSessionResponse = new IpfDmlIndexColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlIndexColumnGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlIndexColumnGetSessionResponse.setResultString("0");
        }
        ipfDmlIndexColumnGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlIndexColumnGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlIndexColumnGetSessionRequest request) {
    	IpfDmlIndexColumnGetSessionResponse ipfDmlIndexColumnGetSessionResponse = new IpfDmlIndexColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlIndexColumnGetSessionResponse.setResultString("0");
        	ipfDmlIndexColumnGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlIndexColumnGetSessionResponse.setResultString("1");
        }
        return ipfDmlIndexColumnGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.createIpfDmlIndexColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlIndexColumn(IpfDmlIndexColumnCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlIndexColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlIndexColumn ipfDmlIndexColumn=new IpfDmlIndexColumn();
        ipfDmlIndexColumn.setId(request.getId());    		
        ipfDmlIndexColumn.setIpfDmlIndexId(request.getIpfDmlIndexId());
        ipfDmlIndexColumn.setColumnName(request.getColumnName());
        ipfDmlIndexColumn.setIndexOption(request.getIndexOption());
    	ipfDmlIndexColumnService.createIpfDmlIndexColumn(ipfDmlIndexColumn);
        //返回响应
        IpfDmlIndexColumnCreateResponse ipfDmlIndexColumnCreateResponse = new IpfDmlIndexColumnCreateResponse();
        ipfDmlIndexColumnCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlIndexColumnCreateResponse.setResultJson(ipfDmlIndexColumn);
        return ipfDmlIndexColumnCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.deleteIpfDmlIndexColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlIndexColumn(IpfDmlIndexColumnDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlIndexColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlIndexColumnService.deleteIpfDmlIndexColumn(idstr);
        //返回响应
        IpfDmlIndexColumnDeleteResponse ipfDmlIndexColumnDeleteResponse = new IpfDmlIndexColumnDeleteResponse();
        ipfDmlIndexColumnDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlIndexColumnDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.updateIpfDmlIndexColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlIndexColumn(IpfDmlIndexColumnUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlIndexColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlIndexColumn ipfDmlIndexColumn=new IpfDmlIndexColumn();
        ipfDmlIndexColumn=ipfDmlIndexColumnService.getIpfDmlIndexColumn(request.getId());
        if (request.getId()!=null){
	        ipfDmlIndexColumn.setId(request.getId());
        }
        if (request.getIpfDmlIndexId()!=null){
	        ipfDmlIndexColumn.setIpfDmlIndexId(request.getIpfDmlIndexId());
        }
        if (request.getColumnName()!=null){
	        ipfDmlIndexColumn.setColumnName(request.getColumnName());
        }
        if (request.getIndexOption()!=null){
	        ipfDmlIndexColumn.setIndexOption(request.getIndexOption());
        }
    	ipfDmlIndexColumnService.updateIpfDmlIndexColumn(ipfDmlIndexColumn);
        //返回响应
        IpfDmlIndexColumnUpdateResponse ipfDmlIndexColumnUpdateResponse = new IpfDmlIndexColumnUpdateResponse();
        ipfDmlIndexColumnUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlIndexColumnUpdateResponse.setResultJson(ipfDmlIndexColumn);
        return ipfDmlIndexColumnUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.getIpfDmlIndexColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlIndexColumn(IpfDmlIndexColumnGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlIndexColumn ipfDmlIndexColumn=new IpfDmlIndexColumn();
        ipfDmlIndexColumn=ipfDmlIndexColumnService.getIpfDmlIndexColumn(id);
        //返回响应
        IpfDmlIndexColumnGetResponse ipfDmlIndexColumnGetResponse = new IpfDmlIndexColumnGetResponse();
        ipfDmlIndexColumnGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlIndexColumnGetResponse.setResultJson(ipfDmlIndexColumn);
        return ipfDmlIndexColumnGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlIndexColumnSelectAllRequest request) {
        IpfDmlIndexColumnSelectAllResponse ipfDmlIndexColumnSelectAllResponse = new IpfDmlIndexColumnSelectAllResponse();
        ipfDmlIndexColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlIndexColumnSelectAllResponse.setResultJson(ipfDmlIndexColumnService.selectAll());
        return ipfDmlIndexColumnSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlIndexColumnCountAllRequest request) {
        IpfDmlIndexColumnCountAllResponse ipfDmlIndexColumnCountAllResponse = new IpfDmlIndexColumnCountAllResponse();
        ipfDmlIndexColumnCountAllResponse.setResultString(String.valueOf(ipfDmlIndexColumnService.countAll()));
        ipfDmlIndexColumnCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlIndexColumnCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlIndexColumnSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlIndexColumnSelectAllResponse ipfDmlIndexColumnSelectAllResponse = new IpfDmlIndexColumnSelectAllResponse();
        ipfDmlIndexColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlIndexColumnSelectAllResponse.setResultJson(ipfDmlIndexColumnService.selectBySql(sqlstr));
        return ipfDmlIndexColumnSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.selectIpfDmlIndexColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlIndexColumnSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlIndexColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlIndexColumn ipfDmlIndexColumn=new IpfDmlIndexColumn();
        ipfDmlIndexColumn.setId(request.getId());
        ipfDmlIndexColumn.setIpfDmlIndexId(request.getIpfDmlIndexId());
        ipfDmlIndexColumn.setColumnName(request.getColumnName());
        ipfDmlIndexColumn.setIndexOption(request.getIndexOption());
    	IpfDmlIndexColumnSelectResponse ipfDmlIndexColumnSelectResponse = new IpfDmlIndexColumnSelectResponse();
        ipfDmlIndexColumnSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlIndexColumn> ipfDmlIndexColumns= ipfDmlIndexColumnService.selectWithCondition(ipfDmlIndexColumn);
        ipfDmlIndexColumnSelectResponse.setResultJson(ipfDmlIndexColumns);
        return ipfDmlIndexColumnSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndexColumn.isExistIpfDmlIndexColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlIndexColumn(IpfDmlIndexColumnSelectRequest request) {
        IpfDmlIndexColumn ipfDmlIndexColumn=new IpfDmlIndexColumn();
        ipfDmlIndexColumn.setId(request.getId());
        ipfDmlIndexColumn.setIpfDmlIndexId(request.getIpfDmlIndexId());
        ipfDmlIndexColumn.setColumnName(request.getColumnName());
        ipfDmlIndexColumn.setIndexOption(request.getIndexOption());
        ArrayList<IpfDmlIndexColumn> ipfDmlIndexColumns= ipfDmlIndexColumnService.selectWithCondition(ipfDmlIndexColumn);
    	IpfDmlIndexColumnCountAllResponse ipfDmlIndexColumnCountAllResponse = new IpfDmlIndexColumnCountAllResponse();
        if (ipfDmlIndexColumns.size()>0){
        	ipfDmlIndexColumnCountAllResponse.setResultString("1");
        } else {
        	ipfDmlIndexColumnCountAllResponse.setResultString("0");
        }        
        return ipfDmlIndexColumnCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlIndexColumnCreateRequest request){
    	IpfDmlIndexColumn ipfDmlIndexColumn=new IpfDmlIndexColumn();
    	ipfDmlIndexColumn.setId(request.getId());
        ArrayList<IpfDmlIndexColumn> ipfDmlIndexColumns= ipfDmlIndexColumnService.selectWithCondition(ipfDmlIndexColumn);
        if (ipfDmlIndexColumns!=null&&ipfDmlIndexColumns.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlIndexColumnUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlIndexColumnDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlIndexColumnSelectRequest request){
        return  true;
     }    
}
