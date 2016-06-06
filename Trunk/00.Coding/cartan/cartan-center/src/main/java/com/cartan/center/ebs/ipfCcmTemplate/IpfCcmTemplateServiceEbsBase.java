/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmTemplate;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmTemplate.request.*;
import com.cartan.center.ebs.ipfCcmTemplate.response.*;
import com.cartan.core.ipfCcmTemplate.domain.IpfCcmTemplate;
import com.cartan.core.ipfCcmTemplate.service.IpfCcmTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmTemplateServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmTemplateServiceEbs.class.getName());
	private IpfCcmTemplateService  ipfCcmTemplateService;
	
    public IpfCcmTemplateService getIpfCcmTemplateService() {
        return ipfCcmTemplateService;
    }

    @Autowired
    public void setIpfCcmTemplateService(IpfCcmTemplateService ipfCcmTemplateService) {
        this.ipfCcmTemplateService = ipfCcmTemplateService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmTemplateGetSessionRequest request) {      
    	IpfCcmTemplateGetSessionResponse ipfCcmTemplateGetSessionResponse = new IpfCcmTemplateGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmTemplateGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmTemplateGetSessionResponse.setResultString("1");
            ipfCcmTemplateGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmTemplateGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmTemplateGetSessionRequest request) {
    	IpfCcmTemplateGetSessionResponse ipfCcmTemplateGetSessionResponse = new IpfCcmTemplateGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmTemplateGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmTemplateGetSessionResponse.setResultString("0");
        }
        ipfCcmTemplateGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmTemplateGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmTemplateGetSessionRequest request) {
    	IpfCcmTemplateGetSessionResponse ipfCcmTemplateGetSessionResponse = new IpfCcmTemplateGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmTemplateGetSessionResponse.setResultString("0");
        	ipfCcmTemplateGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmTemplateGetSessionResponse.setResultString("1");
        }
        return ipfCcmTemplateGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.createIpfCcmTemplate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmTemplate(IpfCcmTemplateCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmTemplate_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmTemplate ipfCcmTemplate=new IpfCcmTemplate();
        ipfCcmTemplate.setId(request.getId());    		
        ipfCcmTemplate.setTemplateFile(request.getTemplateFile());
        ipfCcmTemplate.setTemplateDesc(request.getTemplateDesc());
        ipfCcmTemplate.setTemplateType(request.getTemplateType());
    	ipfCcmTemplateService.createIpfCcmTemplate(ipfCcmTemplate);
        //返回响应
        IpfCcmTemplateCreateResponse ipfCcmTemplateCreateResponse = new IpfCcmTemplateCreateResponse();
        ipfCcmTemplateCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmTemplateCreateResponse.setResultJson(ipfCcmTemplate);
        return ipfCcmTemplateCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.deleteIpfCcmTemplate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmTemplate(IpfCcmTemplateDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmTemplate_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmTemplateService.deleteIpfCcmTemplate(idstr);
        //返回响应
        IpfCcmTemplateDeleteResponse ipfCcmTemplateDeleteResponse = new IpfCcmTemplateDeleteResponse();
        ipfCcmTemplateDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmTemplateDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.updateIpfCcmTemplate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmTemplate(IpfCcmTemplateUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmTemplate_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmTemplate ipfCcmTemplate=new IpfCcmTemplate();
        ipfCcmTemplate=ipfCcmTemplateService.getIpfCcmTemplate(request.getId());
        if (request.getId()!=null){
	        ipfCcmTemplate.setId(request.getId());
        }
        if (request.getTemplateFile()!=null){
	        ipfCcmTemplate.setTemplateFile(request.getTemplateFile());
        }
        if (request.getTemplateDesc()!=null){
	        ipfCcmTemplate.setTemplateDesc(request.getTemplateDesc());
        }
        if (request.getTemplateType()!=null){
	        ipfCcmTemplate.setTemplateType(request.getTemplateType());
        }
    	ipfCcmTemplateService.updateIpfCcmTemplate(ipfCcmTemplate);
        //返回响应
        IpfCcmTemplateUpdateResponse ipfCcmTemplateUpdateResponse = new IpfCcmTemplateUpdateResponse();
        ipfCcmTemplateUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmTemplateUpdateResponse.setResultJson(ipfCcmTemplate);
        return ipfCcmTemplateUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.getIpfCcmTemplate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmTemplate(IpfCcmTemplateGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmTemplate ipfCcmTemplate=new IpfCcmTemplate();
        ipfCcmTemplate=ipfCcmTemplateService.getIpfCcmTemplate(id);
        //返回响应
        IpfCcmTemplateGetResponse ipfCcmTemplateGetResponse = new IpfCcmTemplateGetResponse();
        ipfCcmTemplateGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmTemplateGetResponse.setResultJson(ipfCcmTemplate);
        return ipfCcmTemplateGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmTemplateSelectAllRequest request) {
        IpfCcmTemplateSelectAllResponse ipfCcmTemplateSelectAllResponse = new IpfCcmTemplateSelectAllResponse();
        ipfCcmTemplateSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmTemplateSelectAllResponse.setResultJson(ipfCcmTemplateService.selectAll());
        return ipfCcmTemplateSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmTemplateCountAllRequest request) {
        IpfCcmTemplateCountAllResponse ipfCcmTemplateCountAllResponse = new IpfCcmTemplateCountAllResponse();
        ipfCcmTemplateCountAllResponse.setResultString(String.valueOf(ipfCcmTemplateService.countAll()));
        ipfCcmTemplateCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmTemplateCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmTemplateSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmTemplateSelectAllResponse ipfCcmTemplateSelectAllResponse = new IpfCcmTemplateSelectAllResponse();
        ipfCcmTemplateSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmTemplateSelectAllResponse.setResultJson(ipfCcmTemplateService.selectBySql(sqlstr));
        return ipfCcmTemplateSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.selectIpfCcmTemplate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmTemplateSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmTemplate_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmTemplate ipfCcmTemplate=new IpfCcmTemplate();
        ipfCcmTemplate.setId(request.getId());
        ipfCcmTemplate.setTemplateFile(request.getTemplateFile());
        ipfCcmTemplate.setTemplateDesc(request.getTemplateDesc());
        ipfCcmTemplate.setTemplateType(request.getTemplateType());
    	IpfCcmTemplateSelectResponse ipfCcmTemplateSelectResponse = new IpfCcmTemplateSelectResponse();
        ipfCcmTemplateSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmTemplate> ipfCcmTemplates= ipfCcmTemplateService.selectWithCondition(ipfCcmTemplate);
        ipfCcmTemplateSelectResponse.setResultJson(ipfCcmTemplates);
        return ipfCcmTemplateSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmTemplate.isExistIpfCcmTemplate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmTemplate(IpfCcmTemplateSelectRequest request) {
        IpfCcmTemplate ipfCcmTemplate=new IpfCcmTemplate();
        ipfCcmTemplate.setId(request.getId());
        ipfCcmTemplate.setTemplateFile(request.getTemplateFile());
        ipfCcmTemplate.setTemplateDesc(request.getTemplateDesc());
        ipfCcmTemplate.setTemplateType(request.getTemplateType());
        ArrayList<IpfCcmTemplate> ipfCcmTemplates= ipfCcmTemplateService.selectWithCondition(ipfCcmTemplate);
    	IpfCcmTemplateCountAllResponse ipfCcmTemplateCountAllResponse = new IpfCcmTemplateCountAllResponse();
        if (ipfCcmTemplates.size()>0){
        	ipfCcmTemplateCountAllResponse.setResultString("1");
        } else {
        	ipfCcmTemplateCountAllResponse.setResultString("0");
        }        
        return ipfCcmTemplateCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmTemplateCreateRequest request){
    	IpfCcmTemplate ipfCcmTemplate=new IpfCcmTemplate();
    	ipfCcmTemplate.setId(request.getId());
        ArrayList<IpfCcmTemplate> ipfCcmTemplates= ipfCcmTemplateService.selectWithCondition(ipfCcmTemplate);
        if (ipfCcmTemplates!=null&&ipfCcmTemplates.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmTemplateUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmTemplateDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmTemplateSelectRequest request){
        return  true;
     }    
}
