/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciView;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfFciView.request.*;
import com.cartan.center.ebs.ipfFciView.response.*;
import com.cartan.core.ipfFciView.domain.IpfFciView;
import com.cartan.core.ipfFciView.service.IpfFciViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfFciViewServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfFciViewServiceEbs.class.getName());
	private IpfFciViewService  ipfFciViewService;
	
    public IpfFciViewService getIpfFciViewService() {
        return ipfFciViewService;
    }

    @Autowired
    public void setIpfFciViewService(IpfFciViewService ipfFciViewService) {
        this.ipfFciViewService = ipfFciViewService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfFciViewGetSessionRequest request) {      
    	IpfFciViewGetSessionResponse ipfFciViewGetSessionResponse = new IpfFciViewGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciViewGetSessionResponse.setResultString("0");
        } else {
        	ipfFciViewGetSessionResponse.setResultString("1");
            ipfFciViewGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfFciViewGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfFciViewGetSessionRequest request) {
    	IpfFciViewGetSessionResponse ipfFciViewGetSessionResponse = new IpfFciViewGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfFciViewGetSessionResponse.setResultString("1");
        } else {
        	ipfFciViewGetSessionResponse.setResultString("0");
        }
        ipfFciViewGetSessionResponse.setSessionId(request.getSessionId());
        return ipfFciViewGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfFciViewGetSessionRequest request) {
    	IpfFciViewGetSessionResponse ipfFciViewGetSessionResponse = new IpfFciViewGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciViewGetSessionResponse.setResultString("0");
        	ipfFciViewGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfFciViewGetSessionResponse.setResultString("1");
        }
        return ipfFciViewGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.createIpfFciView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfFciView(IpfFciViewCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfFciView_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciView ipfFciView=new IpfFciView();
        ipfFciView.setId(request.getId());    		
        ipfFciView.setViewName(request.getViewName());
        ipfFciView.setProjectName(request.getProjectName());
        ipfFciView.setViewDesc(request.getViewDesc());
        ipfFciView.setSvnBranchesPath(request.getSvnBranchesPath());
        ipfFciView.setIsActive(request.getIsActive());
        ipfFciView.setConnectionString(request.getConnectionString());
        ipfFciView.setIpfFciProjectId(request.getIpfFciProjectId());
        ipfFciView.setSourceLabelId(request.getSourceLabelId());
        ipfFciView.setIsPermissionPageOnly(request.getIsPermissionPageOnly());
    	ipfFciViewService.createIpfFciView(ipfFciView);
        //返回响应
        IpfFciViewCreateResponse ipfFciViewCreateResponse = new IpfFciViewCreateResponse();
        ipfFciViewCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciViewCreateResponse.setResultJson(ipfFciView);
        return ipfFciViewCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.deleteIpfFciView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfFciView(IpfFciViewDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfFciView_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfFciViewService.deleteIpfFciView(idstr);
        //返回响应
        IpfFciViewDeleteResponse ipfFciViewDeleteResponse = new IpfFciViewDeleteResponse();
        ipfFciViewDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciViewDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.updateIpfFciView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfFciView(IpfFciViewUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfFciView_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciView ipfFciView=new IpfFciView();
        ipfFciView=ipfFciViewService.getIpfFciView(request.getId());
        if (request.getId()!=null){
	        ipfFciView.setId(request.getId());
        }
        if (request.getViewName()!=null){
	        ipfFciView.setViewName(request.getViewName());
        }
        if (request.getProjectName()!=null){
	        ipfFciView.setProjectName(request.getProjectName());
        }
        if (request.getViewDesc()!=null){
	        ipfFciView.setViewDesc(request.getViewDesc());
        }
        if (request.getSvnBranchesPath()!=null){
	        ipfFciView.setSvnBranchesPath(request.getSvnBranchesPath());
        }
        if (request.getIsActive()!=null){
	        ipfFciView.setIsActive(request.getIsActive());
        }
        if (request.getConnectionString()!=null){
	        ipfFciView.setConnectionString(request.getConnectionString());
        }
        if (request.getIpfFciProjectId()!=null){
	        ipfFciView.setIpfFciProjectId(request.getIpfFciProjectId());
        }
        if (request.getSourceLabelId()!=null){
	        ipfFciView.setSourceLabelId(request.getSourceLabelId());
        }
        if (request.getIsPermissionPageOnly()!=null){
	        ipfFciView.setIsPermissionPageOnly(request.getIsPermissionPageOnly());
        }
    	ipfFciViewService.updateIpfFciView(ipfFciView);
        //返回响应
        IpfFciViewUpdateResponse ipfFciViewUpdateResponse = new IpfFciViewUpdateResponse();
        ipfFciViewUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciViewUpdateResponse.setResultJson(ipfFciView);
        return ipfFciViewUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.getIpfFciView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfFciView(IpfFciViewGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfFciView ipfFciView=new IpfFciView();
        ipfFciView=ipfFciViewService.getIpfFciView(id);
        //返回响应
        IpfFciViewGetResponse ipfFciViewGetResponse = new IpfFciViewGetResponse();
        ipfFciViewGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciViewGetResponse.setResultJson(ipfFciView);
        return ipfFciViewGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfFciViewSelectAllRequest request) {
        IpfFciViewSelectAllResponse ipfFciViewSelectAllResponse = new IpfFciViewSelectAllResponse();
        ipfFciViewSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciViewSelectAllResponse.setResultJson(ipfFciViewService.selectAll());
        return ipfFciViewSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfFciViewCountAllRequest request) {
        IpfFciViewCountAllResponse ipfFciViewCountAllResponse = new IpfFciViewCountAllResponse();
        ipfFciViewCountAllResponse.setResultString(String.valueOf(ipfFciViewService.countAll()));
        ipfFciViewCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciViewCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfFciViewSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfFciViewSelectAllResponse ipfFciViewSelectAllResponse = new IpfFciViewSelectAllResponse();
        ipfFciViewSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciViewSelectAllResponse.setResultJson(ipfFciViewService.selectBySql(sqlstr));
        return ipfFciViewSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.selectIpfFciView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfFciViewSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfFciView_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciView ipfFciView=new IpfFciView();
        ipfFciView.setId(request.getId());
        ipfFciView.setViewName(request.getViewName());
        ipfFciView.setProjectName(request.getProjectName());
        ipfFciView.setViewDesc(request.getViewDesc());
        ipfFciView.setSvnBranchesPath(request.getSvnBranchesPath());
        ipfFciView.setIsActive(request.getIsActive());
        ipfFciView.setConnectionString(request.getConnectionString());
        ipfFciView.setIpfFciProjectId(request.getIpfFciProjectId());
        ipfFciView.setSourceLabelId(request.getSourceLabelId());
        ipfFciView.setIsPermissionPageOnly(request.getIsPermissionPageOnly());
    	IpfFciViewSelectResponse ipfFciViewSelectResponse = new IpfFciViewSelectResponse();
        ipfFciViewSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfFciView> ipfFciViews= ipfFciViewService.selectWithCondition(ipfFciView);
        ipfFciViewSelectResponse.setResultJson(ipfFciViews);
        return ipfFciViewSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciView.isExistIpfFciView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfFciView(IpfFciViewSelectRequest request) {
        IpfFciView ipfFciView=new IpfFciView();
        ipfFciView.setId(request.getId());
        ipfFciView.setViewName(request.getViewName());
        ipfFciView.setProjectName(request.getProjectName());
        ipfFciView.setViewDesc(request.getViewDesc());
        ipfFciView.setSvnBranchesPath(request.getSvnBranchesPath());
        ipfFciView.setIsActive(request.getIsActive());
        ipfFciView.setConnectionString(request.getConnectionString());
        ipfFciView.setIpfFciProjectId(request.getIpfFciProjectId());
        ipfFciView.setSourceLabelId(request.getSourceLabelId());
        ipfFciView.setIsPermissionPageOnly(request.getIsPermissionPageOnly());
        ArrayList<IpfFciView> ipfFciViews= ipfFciViewService.selectWithCondition(ipfFciView);
    	IpfFciViewCountAllResponse ipfFciViewCountAllResponse = new IpfFciViewCountAllResponse();
        if (ipfFciViews.size()>0){
        	ipfFciViewCountAllResponse.setResultString("1");
        } else {
        	ipfFciViewCountAllResponse.setResultString("0");
        }        
        return ipfFciViewCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfFciViewCreateRequest request){
    	IpfFciView ipfFciView=new IpfFciView();
    	ipfFciView.setId(request.getId());
        ArrayList<IpfFciView> ipfFciViews= ipfFciViewService.selectWithCondition(ipfFciView);
        if (ipfFciViews!=null&&ipfFciViews.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfFciViewUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfFciViewDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfFciViewSelectRequest request){
        return  true;
     }    
}
