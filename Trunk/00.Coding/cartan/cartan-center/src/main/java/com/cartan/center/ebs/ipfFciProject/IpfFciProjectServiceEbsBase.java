/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciProject;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfFciProject.request.*;
import com.cartan.center.ebs.ipfFciProject.response.*;
import com.cartan.core.ipfFciProject.domain.IpfFciProject;
import com.cartan.core.ipfFciProject.service.IpfFciProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfFciProjectServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfFciProjectServiceEbs.class.getName());
	private IpfFciProjectService  ipfFciProjectService;
	
    public IpfFciProjectService getIpfFciProjectService() {
        return ipfFciProjectService;
    }

    @Autowired
    public void setIpfFciProjectService(IpfFciProjectService ipfFciProjectService) {
        this.ipfFciProjectService = ipfFciProjectService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfFciProjectGetSessionRequest request) {      
    	IpfFciProjectGetSessionResponse ipfFciProjectGetSessionResponse = new IpfFciProjectGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciProjectGetSessionResponse.setResultString("0");
        } else {
        	ipfFciProjectGetSessionResponse.setResultString("1");
            ipfFciProjectGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfFciProjectGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfFciProjectGetSessionRequest request) {
    	IpfFciProjectGetSessionResponse ipfFciProjectGetSessionResponse = new IpfFciProjectGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfFciProjectGetSessionResponse.setResultString("1");
        } else {
        	ipfFciProjectGetSessionResponse.setResultString("0");
        }
        ipfFciProjectGetSessionResponse.setSessionId(request.getSessionId());
        return ipfFciProjectGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfFciProjectGetSessionRequest request) {
    	IpfFciProjectGetSessionResponse ipfFciProjectGetSessionResponse = new IpfFciProjectGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciProjectGetSessionResponse.setResultString("0");
        	ipfFciProjectGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfFciProjectGetSessionResponse.setResultString("1");
        }
        return ipfFciProjectGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.createIpfFciProject", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfFciProject(IpfFciProjectCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfFciProject_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciProject ipfFciProject=new IpfFciProject();
        ipfFciProject.setId(request.getId());    		
        ipfFciProject.setProjectName(request.getProjectName());
        ipfFciProject.setProjectType(request.getProjectType());
        ipfFciProject.setProjectDes(request.getProjectDes());
        ipfFciProject.setDefaultViewId(request.getDefaultViewId());
        ipfFciProject.setSvnRepositoryPath(request.getSvnRepositoryPath());
        ipfFciProject.setSvnUser(request.getSvnUser());
        ipfFciProject.setSvnPassword(request.getSvnPassword());
        ipfFciProject.setMaxRevisonNumber(request.getMaxRevisonNumber());
        ipfFciProject.setDdLanguage(request.getDdLanguage());
        ipfFciProject.setDbType(request.getDbType());
        ipfFciProject.setDbVersion(request.getDbVersion());
        ipfFciProject.setIsActive(request.getIsActive());
    	ipfFciProjectService.createIpfFciProject(ipfFciProject);
        //返回响应
        IpfFciProjectCreateResponse ipfFciProjectCreateResponse = new IpfFciProjectCreateResponse();
        ipfFciProjectCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciProjectCreateResponse.setResultJson(ipfFciProject);
        return ipfFciProjectCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.deleteIpfFciProject", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfFciProject(IpfFciProjectDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfFciProject_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfFciProjectService.deleteIpfFciProject(idstr);
        //返回响应
        IpfFciProjectDeleteResponse ipfFciProjectDeleteResponse = new IpfFciProjectDeleteResponse();
        ipfFciProjectDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciProjectDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.updateIpfFciProject", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfFciProject(IpfFciProjectUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfFciProject_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciProject ipfFciProject=new IpfFciProject();
        ipfFciProject=ipfFciProjectService.getIpfFciProject(request.getId());
        if (request.getId()!=null){
	        ipfFciProject.setId(request.getId());
        }
        if (request.getProjectName()!=null){
	        ipfFciProject.setProjectName(request.getProjectName());
        }
        if (request.getProjectType()!=null){
	        ipfFciProject.setProjectType(request.getProjectType());
        }
        if (request.getProjectDes()!=null){
	        ipfFciProject.setProjectDes(request.getProjectDes());
        }
        if (request.getDefaultViewId()!=null){
	        ipfFciProject.setDefaultViewId(request.getDefaultViewId());
        }
        if (request.getSvnRepositoryPath()!=null){
	        ipfFciProject.setSvnRepositoryPath(request.getSvnRepositoryPath());
        }
        if (request.getSvnUser()!=null){
	        ipfFciProject.setSvnUser(request.getSvnUser());
        }
        if (request.getSvnPassword()!=null){
	        ipfFciProject.setSvnPassword(request.getSvnPassword());
        }
        if (request.getMaxRevisonNumber()!=null){
	        ipfFciProject.setMaxRevisonNumber(request.getMaxRevisonNumber());
        }
        if (request.getDdLanguage()!=null){
	        ipfFciProject.setDdLanguage(request.getDdLanguage());
        }
        if (request.getDbType()!=null){
	        ipfFciProject.setDbType(request.getDbType());
        }
        if (request.getDbVersion()!=null){
	        ipfFciProject.setDbVersion(request.getDbVersion());
        }
        if (request.getIsActive()!=null){
	        ipfFciProject.setIsActive(request.getIsActive());
        }
    	ipfFciProjectService.updateIpfFciProject(ipfFciProject);
        //返回响应
        IpfFciProjectUpdateResponse ipfFciProjectUpdateResponse = new IpfFciProjectUpdateResponse();
        ipfFciProjectUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciProjectUpdateResponse.setResultJson(ipfFciProject);
        return ipfFciProjectUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.getIpfFciProject", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfFciProject(IpfFciProjectGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfFciProject ipfFciProject=new IpfFciProject();
        ipfFciProject=ipfFciProjectService.getIpfFciProject(id);
        //返回响应
        IpfFciProjectGetResponse ipfFciProjectGetResponse = new IpfFciProjectGetResponse();
        ipfFciProjectGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciProjectGetResponse.setResultJson(ipfFciProject);
        return ipfFciProjectGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfFciProjectSelectAllRequest request) {
        IpfFciProjectSelectAllResponse ipfFciProjectSelectAllResponse = new IpfFciProjectSelectAllResponse();
        ipfFciProjectSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciProjectSelectAllResponse.setResultJson(ipfFciProjectService.selectAll());
        return ipfFciProjectSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfFciProjectCountAllRequest request) {
        IpfFciProjectCountAllResponse ipfFciProjectCountAllResponse = new IpfFciProjectCountAllResponse();
        ipfFciProjectCountAllResponse.setResultString(String.valueOf(ipfFciProjectService.countAll()));
        ipfFciProjectCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciProjectCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfFciProjectSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfFciProjectSelectAllResponse ipfFciProjectSelectAllResponse = new IpfFciProjectSelectAllResponse();
        ipfFciProjectSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciProjectSelectAllResponse.setResultJson(ipfFciProjectService.selectBySql(sqlstr));
        return ipfFciProjectSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.selectIpfFciProject", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfFciProjectSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfFciProject_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciProject ipfFciProject=new IpfFciProject();
        ipfFciProject.setId(request.getId());
        ipfFciProject.setProjectName(request.getProjectName());
        ipfFciProject.setProjectType(request.getProjectType());
        ipfFciProject.setProjectDes(request.getProjectDes());
        ipfFciProject.setDefaultViewId(request.getDefaultViewId());
        ipfFciProject.setSvnRepositoryPath(request.getSvnRepositoryPath());
        ipfFciProject.setSvnUser(request.getSvnUser());
        ipfFciProject.setSvnPassword(request.getSvnPassword());
        ipfFciProject.setMaxRevisonNumber(request.getMaxRevisonNumber());
        ipfFciProject.setDdLanguage(request.getDdLanguage());
        ipfFciProject.setDbType(request.getDbType());
        ipfFciProject.setDbVersion(request.getDbVersion());
        ipfFciProject.setIsActive(request.getIsActive());
    	IpfFciProjectSelectResponse ipfFciProjectSelectResponse = new IpfFciProjectSelectResponse();
        ipfFciProjectSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfFciProject> ipfFciProjects= ipfFciProjectService.selectWithCondition(ipfFciProject);
        ipfFciProjectSelectResponse.setResultJson(ipfFciProjects);
        return ipfFciProjectSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciProject.isExistIpfFciProject", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfFciProject(IpfFciProjectSelectRequest request) {
        IpfFciProject ipfFciProject=new IpfFciProject();
        ipfFciProject.setId(request.getId());
        ipfFciProject.setProjectName(request.getProjectName());
        ipfFciProject.setProjectType(request.getProjectType());
        ipfFciProject.setProjectDes(request.getProjectDes());
        ipfFciProject.setDefaultViewId(request.getDefaultViewId());
        ipfFciProject.setSvnRepositoryPath(request.getSvnRepositoryPath());
        ipfFciProject.setSvnUser(request.getSvnUser());
        ipfFciProject.setSvnPassword(request.getSvnPassword());
        ipfFciProject.setMaxRevisonNumber(request.getMaxRevisonNumber());
        ipfFciProject.setDdLanguage(request.getDdLanguage());
        ipfFciProject.setDbType(request.getDbType());
        ipfFciProject.setDbVersion(request.getDbVersion());
        ipfFciProject.setIsActive(request.getIsActive());
        ArrayList<IpfFciProject> ipfFciProjects= ipfFciProjectService.selectWithCondition(ipfFciProject);
    	IpfFciProjectCountAllResponse ipfFciProjectCountAllResponse = new IpfFciProjectCountAllResponse();
        if (ipfFciProjects.size()>0){
        	ipfFciProjectCountAllResponse.setResultString("1");
        } else {
        	ipfFciProjectCountAllResponse.setResultString("0");
        }        
        return ipfFciProjectCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfFciProjectCreateRequest request){
    	IpfFciProject ipfFciProject=new IpfFciProject();
    	ipfFciProject.setId(request.getId());
        ArrayList<IpfFciProject> ipfFciProjects= ipfFciProjectService.selectWithCondition(ipfFciProject);
        if (ipfFciProjects!=null&&ipfFciProjects.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfFciProjectUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfFciProjectDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfFciProjectSelectRequest request){
        return  true;
     }    
}
