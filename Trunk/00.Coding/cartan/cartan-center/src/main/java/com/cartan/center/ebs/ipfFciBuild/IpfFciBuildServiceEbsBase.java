/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciBuild;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfFciBuild.request.*;
import com.cartan.center.ebs.ipfFciBuild.response.*;
import com.cartan.core.ipfFciBuild.domain.IpfFciBuild;
import com.cartan.core.ipfFciBuild.service.IpfFciBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfFciBuildServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfFciBuildServiceEbs.class.getName());
	private IpfFciBuildService  ipfFciBuildService;
	
    public IpfFciBuildService getIpfFciBuildService() {
        return ipfFciBuildService;
    }

    @Autowired
    public void setIpfFciBuildService(IpfFciBuildService ipfFciBuildService) {
        this.ipfFciBuildService = ipfFciBuildService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfFciBuildGetSessionRequest request) {      
    	IpfFciBuildGetSessionResponse ipfFciBuildGetSessionResponse = new IpfFciBuildGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciBuildGetSessionResponse.setResultString("0");
        } else {
        	ipfFciBuildGetSessionResponse.setResultString("1");
            ipfFciBuildGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfFciBuildGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfFciBuildGetSessionRequest request) {
    	IpfFciBuildGetSessionResponse ipfFciBuildGetSessionResponse = new IpfFciBuildGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfFciBuildGetSessionResponse.setResultString("1");
        } else {
        	ipfFciBuildGetSessionResponse.setResultString("0");
        }
        ipfFciBuildGetSessionResponse.setSessionId(request.getSessionId());
        return ipfFciBuildGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfFciBuildGetSessionRequest request) {
    	IpfFciBuildGetSessionResponse ipfFciBuildGetSessionResponse = new IpfFciBuildGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciBuildGetSessionResponse.setResultString("0");
        	ipfFciBuildGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfFciBuildGetSessionResponse.setResultString("1");
        }
        return ipfFciBuildGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.createIpfFciBuild", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfFciBuild(IpfFciBuildCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfFciBuild_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciBuild ipfFciBuild=new IpfFciBuild();
        ipfFciBuild.setId(request.getId());    		
        ipfFciBuild.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciBuild.setIpfFciProjectId(request.getIpfFciProjectId());
        ipfFciBuild.setMajorVersion(request.getMajorVersion());
        ipfFciBuild.setMinorVersion(request.getMinorVersion());
        ipfFciBuild.setMaxVersionBuildNumber(request.getMaxVersionBuildNumber());
        ipfFciBuild.setIsDefault(request.getIsDefault());
    	ipfFciBuildService.createIpfFciBuild(ipfFciBuild);
        //返回响应
        IpfFciBuildCreateResponse ipfFciBuildCreateResponse = new IpfFciBuildCreateResponse();
        ipfFciBuildCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciBuildCreateResponse.setResultJson(ipfFciBuild);
        return ipfFciBuildCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.deleteIpfFciBuild", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfFciBuild(IpfFciBuildDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfFciBuild_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfFciBuildService.deleteIpfFciBuild(idstr);
        //返回响应
        IpfFciBuildDeleteResponse ipfFciBuildDeleteResponse = new IpfFciBuildDeleteResponse();
        ipfFciBuildDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciBuildDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.updateIpfFciBuild", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfFciBuild(IpfFciBuildUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfFciBuild_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciBuild ipfFciBuild=new IpfFciBuild();
        ipfFciBuild=ipfFciBuildService.getIpfFciBuild(request.getId());
        if (request.getId()!=null){
	        ipfFciBuild.setId(request.getId());
        }
        if (request.getIpfFciViewId()!=null){
	        ipfFciBuild.setIpfFciViewId(request.getIpfFciViewId());
        }
        if (request.getIpfFciProjectId()!=null){
	        ipfFciBuild.setIpfFciProjectId(request.getIpfFciProjectId());
        }
        if (request.getMajorVersion()!=null){
	        ipfFciBuild.setMajorVersion(request.getMajorVersion());
        }
        if (request.getMinorVersion()!=null){
	        ipfFciBuild.setMinorVersion(request.getMinorVersion());
        }
        if (request.getMaxVersionBuildNumber()!=null){
	        ipfFciBuild.setMaxVersionBuildNumber(request.getMaxVersionBuildNumber());
        }
        if (request.getIsDefault()!=null){
	        ipfFciBuild.setIsDefault(request.getIsDefault());
        }
    	ipfFciBuildService.updateIpfFciBuild(ipfFciBuild);
        //返回响应
        IpfFciBuildUpdateResponse ipfFciBuildUpdateResponse = new IpfFciBuildUpdateResponse();
        ipfFciBuildUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciBuildUpdateResponse.setResultJson(ipfFciBuild);
        return ipfFciBuildUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.getIpfFciBuild", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfFciBuild(IpfFciBuildGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfFciBuild ipfFciBuild=new IpfFciBuild();
        ipfFciBuild=ipfFciBuildService.getIpfFciBuild(id);
        //返回响应
        IpfFciBuildGetResponse ipfFciBuildGetResponse = new IpfFciBuildGetResponse();
        ipfFciBuildGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciBuildGetResponse.setResultJson(ipfFciBuild);
        return ipfFciBuildGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfFciBuildSelectAllRequest request) {
        IpfFciBuildSelectAllResponse ipfFciBuildSelectAllResponse = new IpfFciBuildSelectAllResponse();
        ipfFciBuildSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciBuildSelectAllResponse.setResultJson(ipfFciBuildService.selectAll());
        return ipfFciBuildSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfFciBuildCountAllRequest request) {
        IpfFciBuildCountAllResponse ipfFciBuildCountAllResponse = new IpfFciBuildCountAllResponse();
        ipfFciBuildCountAllResponse.setResultString(String.valueOf(ipfFciBuildService.countAll()));
        ipfFciBuildCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciBuildCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfFciBuildSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfFciBuildSelectAllResponse ipfFciBuildSelectAllResponse = new IpfFciBuildSelectAllResponse();
        ipfFciBuildSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciBuildSelectAllResponse.setResultJson(ipfFciBuildService.selectBySql(sqlstr));
        return ipfFciBuildSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.selectIpfFciBuild", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfFciBuildSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfFciBuild_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciBuild ipfFciBuild=new IpfFciBuild();
        ipfFciBuild.setId(request.getId());
        ipfFciBuild.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciBuild.setIpfFciProjectId(request.getIpfFciProjectId());
        ipfFciBuild.setMajorVersion(request.getMajorVersion());
        ipfFciBuild.setMinorVersion(request.getMinorVersion());
        ipfFciBuild.setMaxVersionBuildNumber(request.getMaxVersionBuildNumber());
        ipfFciBuild.setIsDefault(request.getIsDefault());
    	IpfFciBuildSelectResponse ipfFciBuildSelectResponse = new IpfFciBuildSelectResponse();
        ipfFciBuildSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfFciBuild> ipfFciBuilds= ipfFciBuildService.selectWithCondition(ipfFciBuild);
        ipfFciBuildSelectResponse.setResultJson(ipfFciBuilds);
        return ipfFciBuildSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciBuild.isExistIpfFciBuild", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfFciBuild(IpfFciBuildSelectRequest request) {
        IpfFciBuild ipfFciBuild=new IpfFciBuild();
        ipfFciBuild.setId(request.getId());
        ipfFciBuild.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciBuild.setIpfFciProjectId(request.getIpfFciProjectId());
        ipfFciBuild.setMajorVersion(request.getMajorVersion());
        ipfFciBuild.setMinorVersion(request.getMinorVersion());
        ipfFciBuild.setMaxVersionBuildNumber(request.getMaxVersionBuildNumber());
        ipfFciBuild.setIsDefault(request.getIsDefault());
        ArrayList<IpfFciBuild> ipfFciBuilds= ipfFciBuildService.selectWithCondition(ipfFciBuild);
    	IpfFciBuildCountAllResponse ipfFciBuildCountAllResponse = new IpfFciBuildCountAllResponse();
        if (ipfFciBuilds.size()>0){
        	ipfFciBuildCountAllResponse.setResultString("1");
        } else {
        	ipfFciBuildCountAllResponse.setResultString("0");
        }        
        return ipfFciBuildCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfFciBuildCreateRequest request){
    	IpfFciBuild ipfFciBuild=new IpfFciBuild();
    	ipfFciBuild.setId(request.getId());
        ArrayList<IpfFciBuild> ipfFciBuilds= ipfFciBuildService.selectWithCondition(ipfFciBuild);
        if (ipfFciBuilds!=null&&ipfFciBuilds.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfFciBuildUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfFciBuildDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfFciBuildSelectRequest request){
        return  true;
     }    
}
