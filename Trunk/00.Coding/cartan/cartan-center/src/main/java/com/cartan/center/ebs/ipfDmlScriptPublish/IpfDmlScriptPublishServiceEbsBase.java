/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlScriptPublish;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlScriptPublish.request.*;
import com.cartan.center.ebs.ipfDmlScriptPublish.response.*;
import com.cartan.core.ipfDmlScriptPublish.domain.IpfDmlScriptPublish;
import com.cartan.core.ipfDmlScriptPublish.service.IpfDmlScriptPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlScriptPublishServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlScriptPublishServiceEbs.class.getName());
	private IpfDmlScriptPublishService  ipfDmlScriptPublishService;
	
    public IpfDmlScriptPublishService getIpfDmlScriptPublishService() {
        return ipfDmlScriptPublishService;
    }

    @Autowired
    public void setIpfDmlScriptPublishService(IpfDmlScriptPublishService ipfDmlScriptPublishService) {
        this.ipfDmlScriptPublishService = ipfDmlScriptPublishService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlScriptPublishGetSessionRequest request) {      
    	IpfDmlScriptPublishGetSessionResponse ipfDmlScriptPublishGetSessionResponse = new IpfDmlScriptPublishGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlScriptPublishGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlScriptPublishGetSessionResponse.setResultString("1");
            ipfDmlScriptPublishGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlScriptPublishGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlScriptPublishGetSessionRequest request) {
    	IpfDmlScriptPublishGetSessionResponse ipfDmlScriptPublishGetSessionResponse = new IpfDmlScriptPublishGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlScriptPublishGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlScriptPublishGetSessionResponse.setResultString("0");
        }
        ipfDmlScriptPublishGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlScriptPublishGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlScriptPublishGetSessionRequest request) {
    	IpfDmlScriptPublishGetSessionResponse ipfDmlScriptPublishGetSessionResponse = new IpfDmlScriptPublishGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlScriptPublishGetSessionResponse.setResultString("0");
        	ipfDmlScriptPublishGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlScriptPublishGetSessionResponse.setResultString("1");
        }
        return ipfDmlScriptPublishGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.createIpfDmlScriptPublish", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlScriptPublish(IpfDmlScriptPublishCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlScriptPublish_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlScriptPublish ipfDmlScriptPublish=new IpfDmlScriptPublish();
        ipfDmlScriptPublish.setId(request.getId());    		
        ipfDmlScriptPublish.setFileName(request.getFileName());
        ipfDmlScriptPublish.setFileDes(request.getFileDes());
        ipfDmlScriptPublish.setFileContent(request.getFileContent());
        ipfDmlScriptPublish.setIsPublished(request.getIsPublished());
    	ipfDmlScriptPublishService.createIpfDmlScriptPublish(ipfDmlScriptPublish);
        //返回响应
        IpfDmlScriptPublishCreateResponse ipfDmlScriptPublishCreateResponse = new IpfDmlScriptPublishCreateResponse();
        ipfDmlScriptPublishCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlScriptPublishCreateResponse.setResultJson(ipfDmlScriptPublish);
        return ipfDmlScriptPublishCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.deleteIpfDmlScriptPublish", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlScriptPublish(IpfDmlScriptPublishDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlScriptPublish_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlScriptPublishService.deleteIpfDmlScriptPublish(idstr);
        //返回响应
        IpfDmlScriptPublishDeleteResponse ipfDmlScriptPublishDeleteResponse = new IpfDmlScriptPublishDeleteResponse();
        ipfDmlScriptPublishDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlScriptPublishDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.updateIpfDmlScriptPublish", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlScriptPublish(IpfDmlScriptPublishUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlScriptPublish_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlScriptPublish ipfDmlScriptPublish=new IpfDmlScriptPublish();
        ipfDmlScriptPublish=ipfDmlScriptPublishService.getIpfDmlScriptPublish(request.getId());
        if (request.getId()!=null){
	        ipfDmlScriptPublish.setId(request.getId());
        }
        if (request.getFileName()!=null){
	        ipfDmlScriptPublish.setFileName(request.getFileName());
        }
        if (request.getFileDes()!=null){
	        ipfDmlScriptPublish.setFileDes(request.getFileDes());
        }
        if (request.getFileContent()!=null){
	        ipfDmlScriptPublish.setFileContent(request.getFileContent());
        }
        if (request.getIsPublished()!=null){
	        ipfDmlScriptPublish.setIsPublished(request.getIsPublished());
        }
    	ipfDmlScriptPublishService.updateIpfDmlScriptPublish(ipfDmlScriptPublish);
        //返回响应
        IpfDmlScriptPublishUpdateResponse ipfDmlScriptPublishUpdateResponse = new IpfDmlScriptPublishUpdateResponse();
        ipfDmlScriptPublishUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlScriptPublishUpdateResponse.setResultJson(ipfDmlScriptPublish);
        return ipfDmlScriptPublishUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.getIpfDmlScriptPublish", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlScriptPublish(IpfDmlScriptPublishGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlScriptPublish ipfDmlScriptPublish=new IpfDmlScriptPublish();
        ipfDmlScriptPublish=ipfDmlScriptPublishService.getIpfDmlScriptPublish(id);
        //返回响应
        IpfDmlScriptPublishGetResponse ipfDmlScriptPublishGetResponse = new IpfDmlScriptPublishGetResponse();
        ipfDmlScriptPublishGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlScriptPublishGetResponse.setResultJson(ipfDmlScriptPublish);
        return ipfDmlScriptPublishGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlScriptPublishSelectAllRequest request) {
        IpfDmlScriptPublishSelectAllResponse ipfDmlScriptPublishSelectAllResponse = new IpfDmlScriptPublishSelectAllResponse();
        ipfDmlScriptPublishSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlScriptPublishSelectAllResponse.setResultJson(ipfDmlScriptPublishService.selectAll());
        return ipfDmlScriptPublishSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlScriptPublishCountAllRequest request) {
        IpfDmlScriptPublishCountAllResponse ipfDmlScriptPublishCountAllResponse = new IpfDmlScriptPublishCountAllResponse();
        ipfDmlScriptPublishCountAllResponse.setResultString(String.valueOf(ipfDmlScriptPublishService.countAll()));
        ipfDmlScriptPublishCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlScriptPublishCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlScriptPublishSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlScriptPublishSelectAllResponse ipfDmlScriptPublishSelectAllResponse = new IpfDmlScriptPublishSelectAllResponse();
        ipfDmlScriptPublishSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlScriptPublishSelectAllResponse.setResultJson(ipfDmlScriptPublishService.selectBySql(sqlstr));
        return ipfDmlScriptPublishSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.selectIpfDmlScriptPublish", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlScriptPublishSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlScriptPublish_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlScriptPublish ipfDmlScriptPublish=new IpfDmlScriptPublish();
        ipfDmlScriptPublish.setId(request.getId());
        ipfDmlScriptPublish.setFileName(request.getFileName());
        ipfDmlScriptPublish.setFileDes(request.getFileDes());
        ipfDmlScriptPublish.setFileContent(request.getFileContent());
        ipfDmlScriptPublish.setIsPublished(request.getIsPublished());
    	IpfDmlScriptPublishSelectResponse ipfDmlScriptPublishSelectResponse = new IpfDmlScriptPublishSelectResponse();
        ipfDmlScriptPublishSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlScriptPublish> ipfDmlScriptPublishs= ipfDmlScriptPublishService.selectWithCondition(ipfDmlScriptPublish);
        ipfDmlScriptPublishSelectResponse.setResultJson(ipfDmlScriptPublishs);
        return ipfDmlScriptPublishSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlScriptPublish.isExistIpfDmlScriptPublish", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlScriptPublish(IpfDmlScriptPublishSelectRequest request) {
        IpfDmlScriptPublish ipfDmlScriptPublish=new IpfDmlScriptPublish();
        ipfDmlScriptPublish.setId(request.getId());
        ipfDmlScriptPublish.setFileName(request.getFileName());
        ipfDmlScriptPublish.setFileDes(request.getFileDes());
        ipfDmlScriptPublish.setFileContent(request.getFileContent());
        ipfDmlScriptPublish.setIsPublished(request.getIsPublished());
        ArrayList<IpfDmlScriptPublish> ipfDmlScriptPublishs= ipfDmlScriptPublishService.selectWithCondition(ipfDmlScriptPublish);
    	IpfDmlScriptPublishCountAllResponse ipfDmlScriptPublishCountAllResponse = new IpfDmlScriptPublishCountAllResponse();
        if (ipfDmlScriptPublishs.size()>0){
        	ipfDmlScriptPublishCountAllResponse.setResultString("1");
        } else {
        	ipfDmlScriptPublishCountAllResponse.setResultString("0");
        }        
        return ipfDmlScriptPublishCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlScriptPublishCreateRequest request){
    	IpfDmlScriptPublish ipfDmlScriptPublish=new IpfDmlScriptPublish();
    	ipfDmlScriptPublish.setId(request.getId());
        ArrayList<IpfDmlScriptPublish> ipfDmlScriptPublishs= ipfDmlScriptPublishService.selectWithCondition(ipfDmlScriptPublish);
        if (ipfDmlScriptPublishs!=null&&ipfDmlScriptPublishs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlScriptPublishUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlScriptPublishDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlScriptPublishSelectRequest request){
        return  true;
     }    
}
