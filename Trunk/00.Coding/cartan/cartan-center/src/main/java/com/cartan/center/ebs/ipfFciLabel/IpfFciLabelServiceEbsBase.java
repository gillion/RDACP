/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciLabel;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfFciLabel.request.*;
import com.cartan.center.ebs.ipfFciLabel.response.*;
import com.cartan.core.ipfFciLabel.domain.IpfFciLabel;
import com.cartan.core.ipfFciLabel.service.IpfFciLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfFciLabelServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfFciLabelServiceEbs.class.getName());
	private IpfFciLabelService  ipfFciLabelService;
	
    public IpfFciLabelService getIpfFciLabelService() {
        return ipfFciLabelService;
    }

    @Autowired
    public void setIpfFciLabelService(IpfFciLabelService ipfFciLabelService) {
        this.ipfFciLabelService = ipfFciLabelService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfFciLabelGetSessionRequest request) {      
    	IpfFciLabelGetSessionResponse ipfFciLabelGetSessionResponse = new IpfFciLabelGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciLabelGetSessionResponse.setResultString("0");
        } else {
        	ipfFciLabelGetSessionResponse.setResultString("1");
            ipfFciLabelGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfFciLabelGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfFciLabelGetSessionRequest request) {
    	IpfFciLabelGetSessionResponse ipfFciLabelGetSessionResponse = new IpfFciLabelGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfFciLabelGetSessionResponse.setResultString("1");
        } else {
        	ipfFciLabelGetSessionResponse.setResultString("0");
        }
        ipfFciLabelGetSessionResponse.setSessionId(request.getSessionId());
        return ipfFciLabelGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfFciLabelGetSessionRequest request) {
    	IpfFciLabelGetSessionResponse ipfFciLabelGetSessionResponse = new IpfFciLabelGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciLabelGetSessionResponse.setResultString("0");
        	ipfFciLabelGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfFciLabelGetSessionResponse.setResultString("1");
        }
        return ipfFciLabelGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.createIpfFciLabel", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfFciLabel(IpfFciLabelCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfFciLabel_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciLabel ipfFciLabel=new IpfFciLabel();
        ipfFciLabel.setId(request.getId());    		
        ipfFciLabel.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciLabel.setLabelName(request.getLabelName());
        ipfFciLabel.setLabelDesc(request.getLabelDesc());
        ipfFciLabel.setIpfFciBuildId(request.getIpfFciBuildId());
        ipfFciLabel.setMajorVersion(request.getMajorVersion());
        ipfFciLabel.setMinorVersion(request.getMinorVersion());
        ipfFciLabel.setVersionBuildNumber(request.getVersionBuildNumber());
        ipfFciLabel.setRevisionNumber(request.getRevisionNumber());
        ipfFciLabel.setSvnRevision(request.getSvnRevision());
        ipfFciLabel.setSvnTagsPath(request.getSvnTagsPath());
        ipfFciLabel.setIsActive(request.getIsActive());
        ipfFciLabel.setViewName(request.getViewName());
    	ipfFciLabelService.createIpfFciLabel(ipfFciLabel);
        //返回响应
        IpfFciLabelCreateResponse ipfFciLabelCreateResponse = new IpfFciLabelCreateResponse();
        ipfFciLabelCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciLabelCreateResponse.setResultJson(ipfFciLabel);
        return ipfFciLabelCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.deleteIpfFciLabel", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfFciLabel(IpfFciLabelDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfFciLabel_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfFciLabelService.deleteIpfFciLabel(idstr);
        //返回响应
        IpfFciLabelDeleteResponse ipfFciLabelDeleteResponse = new IpfFciLabelDeleteResponse();
        ipfFciLabelDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciLabelDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.updateIpfFciLabel", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfFciLabel(IpfFciLabelUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfFciLabel_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciLabel ipfFciLabel=new IpfFciLabel();
        ipfFciLabel=ipfFciLabelService.getIpfFciLabel(request.getId());
        if (request.getId()!=null){
	        ipfFciLabel.setId(request.getId());
        }
        if (request.getIpfFciViewId()!=null){
	        ipfFciLabel.setIpfFciViewId(request.getIpfFciViewId());
        }
        if (request.getLabelName()!=null){
	        ipfFciLabel.setLabelName(request.getLabelName());
        }
        if (request.getLabelDesc()!=null){
	        ipfFciLabel.setLabelDesc(request.getLabelDesc());
        }
        if (request.getIpfFciBuildId()!=null){
	        ipfFciLabel.setIpfFciBuildId(request.getIpfFciBuildId());
        }
        if (request.getMajorVersion()!=null){
	        ipfFciLabel.setMajorVersion(request.getMajorVersion());
        }
        if (request.getMinorVersion()!=null){
	        ipfFciLabel.setMinorVersion(request.getMinorVersion());
        }
        if (request.getVersionBuildNumber()!=null){
	        ipfFciLabel.setVersionBuildNumber(request.getVersionBuildNumber());
        }
        if (request.getRevisionNumber()!=null){
	        ipfFciLabel.setRevisionNumber(request.getRevisionNumber());
        }
        if (request.getSvnRevision()!=null){
	        ipfFciLabel.setSvnRevision(request.getSvnRevision());
        }
        if (request.getSvnTagsPath()!=null){
	        ipfFciLabel.setSvnTagsPath(request.getSvnTagsPath());
        }
        if (request.getIsActive()!=null){
	        ipfFciLabel.setIsActive(request.getIsActive());
        }
        if (request.getViewName()!=null){
	        ipfFciLabel.setViewName(request.getViewName());
        }
    	ipfFciLabelService.updateIpfFciLabel(ipfFciLabel);
        //返回响应
        IpfFciLabelUpdateResponse ipfFciLabelUpdateResponse = new IpfFciLabelUpdateResponse();
        ipfFciLabelUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciLabelUpdateResponse.setResultJson(ipfFciLabel);
        return ipfFciLabelUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.getIpfFciLabel", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfFciLabel(IpfFciLabelGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfFciLabel ipfFciLabel=new IpfFciLabel();
        ipfFciLabel=ipfFciLabelService.getIpfFciLabel(id);
        //返回响应
        IpfFciLabelGetResponse ipfFciLabelGetResponse = new IpfFciLabelGetResponse();
        ipfFciLabelGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciLabelGetResponse.setResultJson(ipfFciLabel);
        return ipfFciLabelGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfFciLabelSelectAllRequest request) {
        IpfFciLabelSelectAllResponse ipfFciLabelSelectAllResponse = new IpfFciLabelSelectAllResponse();
        ipfFciLabelSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciLabelSelectAllResponse.setResultJson(ipfFciLabelService.selectAll());
        return ipfFciLabelSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfFciLabelCountAllRequest request) {
        IpfFciLabelCountAllResponse ipfFciLabelCountAllResponse = new IpfFciLabelCountAllResponse();
        ipfFciLabelCountAllResponse.setResultString(String.valueOf(ipfFciLabelService.countAll()));
        ipfFciLabelCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciLabelCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfFciLabelSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfFciLabelSelectAllResponse ipfFciLabelSelectAllResponse = new IpfFciLabelSelectAllResponse();
        ipfFciLabelSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciLabelSelectAllResponse.setResultJson(ipfFciLabelService.selectBySql(sqlstr));
        return ipfFciLabelSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.selectIpfFciLabel", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfFciLabelSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfFciLabel_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciLabel ipfFciLabel=new IpfFciLabel();
        ipfFciLabel.setId(request.getId());
        ipfFciLabel.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciLabel.setLabelName(request.getLabelName());
        ipfFciLabel.setLabelDesc(request.getLabelDesc());
        ipfFciLabel.setIpfFciBuildId(request.getIpfFciBuildId());
        ipfFciLabel.setMajorVersion(request.getMajorVersion());
        ipfFciLabel.setMinorVersion(request.getMinorVersion());
        ipfFciLabel.setVersionBuildNumber(request.getVersionBuildNumber());
        ipfFciLabel.setRevisionNumber(request.getRevisionNumber());
        ipfFciLabel.setSvnRevision(request.getSvnRevision());
        ipfFciLabel.setSvnTagsPath(request.getSvnTagsPath());
        ipfFciLabel.setIsActive(request.getIsActive());
        ipfFciLabel.setViewName(request.getViewName());
    	IpfFciLabelSelectResponse ipfFciLabelSelectResponse = new IpfFciLabelSelectResponse();
        ipfFciLabelSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfFciLabel> ipfFciLabels= ipfFciLabelService.selectWithCondition(ipfFciLabel);
        ipfFciLabelSelectResponse.setResultJson(ipfFciLabels);
        return ipfFciLabelSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabel.isExistIpfFciLabel", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfFciLabel(IpfFciLabelSelectRequest request) {
        IpfFciLabel ipfFciLabel=new IpfFciLabel();
        ipfFciLabel.setId(request.getId());
        ipfFciLabel.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciLabel.setLabelName(request.getLabelName());
        ipfFciLabel.setLabelDesc(request.getLabelDesc());
        ipfFciLabel.setIpfFciBuildId(request.getIpfFciBuildId());
        ipfFciLabel.setMajorVersion(request.getMajorVersion());
        ipfFciLabel.setMinorVersion(request.getMinorVersion());
        ipfFciLabel.setVersionBuildNumber(request.getVersionBuildNumber());
        ipfFciLabel.setRevisionNumber(request.getRevisionNumber());
        ipfFciLabel.setSvnRevision(request.getSvnRevision());
        ipfFciLabel.setSvnTagsPath(request.getSvnTagsPath());
        ipfFciLabel.setIsActive(request.getIsActive());
        ipfFciLabel.setViewName(request.getViewName());
        ArrayList<IpfFciLabel> ipfFciLabels= ipfFciLabelService.selectWithCondition(ipfFciLabel);
    	IpfFciLabelCountAllResponse ipfFciLabelCountAllResponse = new IpfFciLabelCountAllResponse();
        if (ipfFciLabels.size()>0){
        	ipfFciLabelCountAllResponse.setResultString("1");
        } else {
        	ipfFciLabelCountAllResponse.setResultString("0");
        }        
        return ipfFciLabelCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfFciLabelCreateRequest request){
    	IpfFciLabel ipfFciLabel=new IpfFciLabel();
    	ipfFciLabel.setId(request.getId());
        ArrayList<IpfFciLabel> ipfFciLabels= ipfFciLabelService.selectWithCondition(ipfFciLabel);
        if (ipfFciLabels!=null&&ipfFciLabels.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfFciLabelUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfFciLabelDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfFciLabelSelectRequest request){
        return  true;
     }    
}
