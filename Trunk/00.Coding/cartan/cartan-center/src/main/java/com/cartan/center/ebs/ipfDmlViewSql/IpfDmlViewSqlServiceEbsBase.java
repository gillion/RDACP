/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlViewSql;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlViewSql.request.*;
import com.cartan.center.ebs.ipfDmlViewSql.response.*;
import com.cartan.core.ipfDmlViewSql.domain.IpfDmlViewSql;
import com.cartan.core.ipfDmlViewSql.service.IpfDmlViewSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlViewSqlServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlViewSqlServiceEbs.class.getName());
	private IpfDmlViewSqlService  ipfDmlViewSqlService;
	
    public IpfDmlViewSqlService getIpfDmlViewSqlService() {
        return ipfDmlViewSqlService;
    }

    @Autowired
    public void setIpfDmlViewSqlService(IpfDmlViewSqlService ipfDmlViewSqlService) {
        this.ipfDmlViewSqlService = ipfDmlViewSqlService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlViewSqlGetSessionRequest request) {      
    	IpfDmlViewSqlGetSessionResponse ipfDmlViewSqlGetSessionResponse = new IpfDmlViewSqlGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlViewSqlGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlViewSqlGetSessionResponse.setResultString("1");
            ipfDmlViewSqlGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlViewSqlGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlViewSqlGetSessionRequest request) {
    	IpfDmlViewSqlGetSessionResponse ipfDmlViewSqlGetSessionResponse = new IpfDmlViewSqlGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlViewSqlGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlViewSqlGetSessionResponse.setResultString("0");
        }
        ipfDmlViewSqlGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlViewSqlGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlViewSqlGetSessionRequest request) {
    	IpfDmlViewSqlGetSessionResponse ipfDmlViewSqlGetSessionResponse = new IpfDmlViewSqlGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlViewSqlGetSessionResponse.setResultString("0");
        	ipfDmlViewSqlGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlViewSqlGetSessionResponse.setResultString("1");
        }
        return ipfDmlViewSqlGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.createIpfDmlViewSql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlViewSql(IpfDmlViewSqlCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlViewSql_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlViewSql ipfDmlViewSql=new IpfDmlViewSql();
        ipfDmlViewSql.setId(request.getId());    		
        ipfDmlViewSql.setIpfDmlViewId(request.getIpfDmlViewId());
        ipfDmlViewSql.setDbmsType(request.getDbmsType());
        ipfDmlViewSql.setSqlStatement(request.getSqlStatement());
    	ipfDmlViewSqlService.createIpfDmlViewSql(ipfDmlViewSql);
        //返回响应
        IpfDmlViewSqlCreateResponse ipfDmlViewSqlCreateResponse = new IpfDmlViewSqlCreateResponse();
        ipfDmlViewSqlCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewSqlCreateResponse.setResultJson(ipfDmlViewSql);
        return ipfDmlViewSqlCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.deleteIpfDmlViewSql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlViewSql(IpfDmlViewSqlDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlViewSql_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlViewSqlService.deleteIpfDmlViewSql(idstr);
        //返回响应
        IpfDmlViewSqlDeleteResponse ipfDmlViewSqlDeleteResponse = new IpfDmlViewSqlDeleteResponse();
        ipfDmlViewSqlDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlViewSqlDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.updateIpfDmlViewSql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlViewSql(IpfDmlViewSqlUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlViewSql_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlViewSql ipfDmlViewSql=new IpfDmlViewSql();
        ipfDmlViewSql=ipfDmlViewSqlService.getIpfDmlViewSql(request.getId());
        if (request.getId()!=null){
	        ipfDmlViewSql.setId(request.getId());
        }
        if (request.getIpfDmlViewId()!=null){
	        ipfDmlViewSql.setIpfDmlViewId(request.getIpfDmlViewId());
        }
        if (request.getDbmsType()!=null){
	        ipfDmlViewSql.setDbmsType(request.getDbmsType());
        }
        if (request.getSqlStatement()!=null){
	        ipfDmlViewSql.setSqlStatement(request.getSqlStatement());
        }
    	ipfDmlViewSqlService.updateIpfDmlViewSql(ipfDmlViewSql);
        //返回响应
        IpfDmlViewSqlUpdateResponse ipfDmlViewSqlUpdateResponse = new IpfDmlViewSqlUpdateResponse();
        ipfDmlViewSqlUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewSqlUpdateResponse.setResultJson(ipfDmlViewSql);
        return ipfDmlViewSqlUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.getIpfDmlViewSql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlViewSql(IpfDmlViewSqlGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlViewSql ipfDmlViewSql=new IpfDmlViewSql();
        ipfDmlViewSql=ipfDmlViewSqlService.getIpfDmlViewSql(id);
        //返回响应
        IpfDmlViewSqlGetResponse ipfDmlViewSqlGetResponse = new IpfDmlViewSqlGetResponse();
        ipfDmlViewSqlGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewSqlGetResponse.setResultJson(ipfDmlViewSql);
        return ipfDmlViewSqlGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlViewSqlSelectAllRequest request) {
        IpfDmlViewSqlSelectAllResponse ipfDmlViewSqlSelectAllResponse = new IpfDmlViewSqlSelectAllResponse();
        ipfDmlViewSqlSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewSqlSelectAllResponse.setResultJson(ipfDmlViewSqlService.selectAll());
        return ipfDmlViewSqlSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlViewSqlCountAllRequest request) {
        IpfDmlViewSqlCountAllResponse ipfDmlViewSqlCountAllResponse = new IpfDmlViewSqlCountAllResponse();
        ipfDmlViewSqlCountAllResponse.setResultString(String.valueOf(ipfDmlViewSqlService.countAll()));
        ipfDmlViewSqlCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlViewSqlCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlViewSqlSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlViewSqlSelectAllResponse ipfDmlViewSqlSelectAllResponse = new IpfDmlViewSqlSelectAllResponse();
        ipfDmlViewSqlSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewSqlSelectAllResponse.setResultJson(ipfDmlViewSqlService.selectBySql(sqlstr));
        return ipfDmlViewSqlSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.selectIpfDmlViewSql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlViewSqlSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlViewSql_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlViewSql ipfDmlViewSql=new IpfDmlViewSql();
        ipfDmlViewSql.setId(request.getId());
        ipfDmlViewSql.setIpfDmlViewId(request.getIpfDmlViewId());
        ipfDmlViewSql.setDbmsType(request.getDbmsType());
        ipfDmlViewSql.setSqlStatement(request.getSqlStatement());
    	IpfDmlViewSqlSelectResponse ipfDmlViewSqlSelectResponse = new IpfDmlViewSqlSelectResponse();
        ipfDmlViewSqlSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlViewSql> ipfDmlViewSqls= ipfDmlViewSqlService.selectWithCondition(ipfDmlViewSql);
        ipfDmlViewSqlSelectResponse.setResultJson(ipfDmlViewSqls);
        return ipfDmlViewSqlSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlViewSql.isExistIpfDmlViewSql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlViewSql(IpfDmlViewSqlSelectRequest request) {
        IpfDmlViewSql ipfDmlViewSql=new IpfDmlViewSql();
        ipfDmlViewSql.setId(request.getId());
        ipfDmlViewSql.setIpfDmlViewId(request.getIpfDmlViewId());
        ipfDmlViewSql.setDbmsType(request.getDbmsType());
        ipfDmlViewSql.setSqlStatement(request.getSqlStatement());
        ArrayList<IpfDmlViewSql> ipfDmlViewSqls= ipfDmlViewSqlService.selectWithCondition(ipfDmlViewSql);
    	IpfDmlViewSqlCountAllResponse ipfDmlViewSqlCountAllResponse = new IpfDmlViewSqlCountAllResponse();
        if (ipfDmlViewSqls.size()>0){
        	ipfDmlViewSqlCountAllResponse.setResultString("1");
        } else {
        	ipfDmlViewSqlCountAllResponse.setResultString("0");
        }        
        return ipfDmlViewSqlCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlViewSqlCreateRequest request){
    	IpfDmlViewSql ipfDmlViewSql=new IpfDmlViewSql();
    	ipfDmlViewSql.setId(request.getId());
        ArrayList<IpfDmlViewSql> ipfDmlViewSqls= ipfDmlViewSqlService.selectWithCondition(ipfDmlViewSql);
        if (ipfDmlViewSqls!=null&&ipfDmlViewSqls.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlViewSqlUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlViewSqlDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlViewSqlSelectRequest request){
        return  true;
     }    
}
