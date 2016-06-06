/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayoutConfig;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmUiLayoutConfig.request.*;
import com.cartan.center.ebs.ipfCcmUiLayoutConfig.response.*;
import com.cartan.core.ipfCcmUiLayoutConfig.domain.IpfCcmUiLayoutConfig;
import com.cartan.core.ipfCcmUiLayoutConfig.service.IpfCcmUiLayoutConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmUiLayoutConfigServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmUiLayoutConfigServiceEbs.class.getName());
	private IpfCcmUiLayoutConfigService  ipfCcmUiLayoutConfigService;
	
    public IpfCcmUiLayoutConfigService getIpfCcmUiLayoutConfigService() {
        return ipfCcmUiLayoutConfigService;
    }

    @Autowired
    public void setIpfCcmUiLayoutConfigService(IpfCcmUiLayoutConfigService ipfCcmUiLayoutConfigService) {
        this.ipfCcmUiLayoutConfigService = ipfCcmUiLayoutConfigService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmUiLayoutConfigGetSessionRequest request) {      
    	IpfCcmUiLayoutConfigGetSessionResponse ipfCcmUiLayoutConfigGetSessionResponse = new IpfCcmUiLayoutConfigGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmUiLayoutConfigGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmUiLayoutConfigGetSessionResponse.setResultString("1");
            ipfCcmUiLayoutConfigGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmUiLayoutConfigGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmUiLayoutConfigGetSessionRequest request) {
    	IpfCcmUiLayoutConfigGetSessionResponse ipfCcmUiLayoutConfigGetSessionResponse = new IpfCcmUiLayoutConfigGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmUiLayoutConfigGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmUiLayoutConfigGetSessionResponse.setResultString("0");
        }
        ipfCcmUiLayoutConfigGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmUiLayoutConfigGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmUiLayoutConfigGetSessionRequest request) {
    	IpfCcmUiLayoutConfigGetSessionResponse ipfCcmUiLayoutConfigGetSessionResponse = new IpfCcmUiLayoutConfigGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmUiLayoutConfigGetSessionResponse.setResultString("0");
        	ipfCcmUiLayoutConfigGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmUiLayoutConfigGetSessionResponse.setResultString("1");
        }
        return ipfCcmUiLayoutConfigGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.createIpfCcmUiLayoutConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmUiLayoutConfig(IpfCcmUiLayoutConfigCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmUiLayoutConfig_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig=new IpfCcmUiLayoutConfig();
        ipfCcmUiLayoutConfig.setId(request.getId());    		
        ipfCcmUiLayoutConfig.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmUiLayoutConfig.setBoId(request.getBoId());
        ipfCcmUiLayoutConfig.setPageName(request.getPageName());
        ipfCcmUiLayoutConfig.setLayoutElementName(request.getLayoutElementName());
        ipfCcmUiLayoutConfig.setLayoutElementDescription(request.getLayoutElementDescription());
        ipfCcmUiLayoutConfig.setBoName(request.getBoName());
        ipfCcmUiLayoutConfig.setBoElementName(request.getBoElementName());
    	ipfCcmUiLayoutConfigService.createIpfCcmUiLayoutConfig(ipfCcmUiLayoutConfig);
        //返回响应
        IpfCcmUiLayoutConfigCreateResponse ipfCcmUiLayoutConfigCreateResponse = new IpfCcmUiLayoutConfigCreateResponse();
        ipfCcmUiLayoutConfigCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutConfigCreateResponse.setResultJson(ipfCcmUiLayoutConfig);
        return ipfCcmUiLayoutConfigCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.deleteIpfCcmUiLayoutConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmUiLayoutConfig(IpfCcmUiLayoutConfigDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmUiLayoutConfig_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmUiLayoutConfigService.deleteIpfCcmUiLayoutConfig(idstr);
        //返回响应
        IpfCcmUiLayoutConfigDeleteResponse ipfCcmUiLayoutConfigDeleteResponse = new IpfCcmUiLayoutConfigDeleteResponse();
        ipfCcmUiLayoutConfigDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmUiLayoutConfigDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.updateIpfCcmUiLayoutConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmUiLayoutConfig(IpfCcmUiLayoutConfigUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmUiLayoutConfig_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig=new IpfCcmUiLayoutConfig();
        ipfCcmUiLayoutConfig=ipfCcmUiLayoutConfigService.getIpfCcmUiLayoutConfig(request.getId());
        if (request.getId()!=null){
	        ipfCcmUiLayoutConfig.setId(request.getId());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfCcmUiLayoutConfig.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getBoId()!=null){
	        ipfCcmUiLayoutConfig.setBoId(request.getBoId());
        }
        if (request.getPageName()!=null){
	        ipfCcmUiLayoutConfig.setPageName(request.getPageName());
        }
        if (request.getLayoutElementName()!=null){
	        ipfCcmUiLayoutConfig.setLayoutElementName(request.getLayoutElementName());
        }
        if (request.getLayoutElementDescription()!=null){
	        ipfCcmUiLayoutConfig.setLayoutElementDescription(request.getLayoutElementDescription());
        }
        if (request.getBoName()!=null){
	        ipfCcmUiLayoutConfig.setBoName(request.getBoName());
        }
        if (request.getBoElementName()!=null){
	        ipfCcmUiLayoutConfig.setBoElementName(request.getBoElementName());
        }
    	ipfCcmUiLayoutConfigService.updateIpfCcmUiLayoutConfig(ipfCcmUiLayoutConfig);
        //返回响应
        IpfCcmUiLayoutConfigUpdateResponse ipfCcmUiLayoutConfigUpdateResponse = new IpfCcmUiLayoutConfigUpdateResponse();
        ipfCcmUiLayoutConfigUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutConfigUpdateResponse.setResultJson(ipfCcmUiLayoutConfig);
        return ipfCcmUiLayoutConfigUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.getIpfCcmUiLayoutConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmUiLayoutConfig(IpfCcmUiLayoutConfigGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig=new IpfCcmUiLayoutConfig();
        ipfCcmUiLayoutConfig=ipfCcmUiLayoutConfigService.getIpfCcmUiLayoutConfig(id);
        //返回响应
        IpfCcmUiLayoutConfigGetResponse ipfCcmUiLayoutConfigGetResponse = new IpfCcmUiLayoutConfigGetResponse();
        ipfCcmUiLayoutConfigGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutConfigGetResponse.setResultJson(ipfCcmUiLayoutConfig);
        return ipfCcmUiLayoutConfigGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmUiLayoutConfigSelectAllRequest request) {
        IpfCcmUiLayoutConfigSelectAllResponse ipfCcmUiLayoutConfigSelectAllResponse = new IpfCcmUiLayoutConfigSelectAllResponse();
        ipfCcmUiLayoutConfigSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutConfigSelectAllResponse.setResultJson(ipfCcmUiLayoutConfigService.selectAll());
        return ipfCcmUiLayoutConfigSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmUiLayoutConfigCountAllRequest request) {
        IpfCcmUiLayoutConfigCountAllResponse ipfCcmUiLayoutConfigCountAllResponse = new IpfCcmUiLayoutConfigCountAllResponse();
        ipfCcmUiLayoutConfigCountAllResponse.setResultString(String.valueOf(ipfCcmUiLayoutConfigService.countAll()));
        ipfCcmUiLayoutConfigCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmUiLayoutConfigCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmUiLayoutConfigSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmUiLayoutConfigSelectAllResponse ipfCcmUiLayoutConfigSelectAllResponse = new IpfCcmUiLayoutConfigSelectAllResponse();
        ipfCcmUiLayoutConfigSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutConfigSelectAllResponse.setResultJson(ipfCcmUiLayoutConfigService.selectBySql(sqlstr));
        return ipfCcmUiLayoutConfigSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.selectIpfCcmUiLayoutConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmUiLayoutConfigSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmUiLayoutConfig_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig=new IpfCcmUiLayoutConfig();
        ipfCcmUiLayoutConfig.setId(request.getId());
        ipfCcmUiLayoutConfig.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmUiLayoutConfig.setBoId(request.getBoId());
        ipfCcmUiLayoutConfig.setPageName(request.getPageName());
        ipfCcmUiLayoutConfig.setLayoutElementName(request.getLayoutElementName());
        ipfCcmUiLayoutConfig.setLayoutElementDescription(request.getLayoutElementDescription());
        ipfCcmUiLayoutConfig.setBoName(request.getBoName());
        ipfCcmUiLayoutConfig.setBoElementName(request.getBoElementName());
    	IpfCcmUiLayoutConfigSelectResponse ipfCcmUiLayoutConfigSelectResponse = new IpfCcmUiLayoutConfigSelectResponse();
        ipfCcmUiLayoutConfigSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmUiLayoutConfig> ipfCcmUiLayoutConfigs= ipfCcmUiLayoutConfigService.selectWithCondition(ipfCcmUiLayoutConfig);
        ipfCcmUiLayoutConfigSelectResponse.setResultJson(ipfCcmUiLayoutConfigs);
        return ipfCcmUiLayoutConfigSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutConfig.isExistIpfCcmUiLayoutConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmUiLayoutConfig(IpfCcmUiLayoutConfigSelectRequest request) {
        IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig=new IpfCcmUiLayoutConfig();
        ipfCcmUiLayoutConfig.setId(request.getId());
        ipfCcmUiLayoutConfig.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmUiLayoutConfig.setBoId(request.getBoId());
        ipfCcmUiLayoutConfig.setPageName(request.getPageName());
        ipfCcmUiLayoutConfig.setLayoutElementName(request.getLayoutElementName());
        ipfCcmUiLayoutConfig.setLayoutElementDescription(request.getLayoutElementDescription());
        ipfCcmUiLayoutConfig.setBoName(request.getBoName());
        ipfCcmUiLayoutConfig.setBoElementName(request.getBoElementName());
        ArrayList<IpfCcmUiLayoutConfig> ipfCcmUiLayoutConfigs= ipfCcmUiLayoutConfigService.selectWithCondition(ipfCcmUiLayoutConfig);
    	IpfCcmUiLayoutConfigCountAllResponse ipfCcmUiLayoutConfigCountAllResponse = new IpfCcmUiLayoutConfigCountAllResponse();
        if (ipfCcmUiLayoutConfigs.size()>0){
        	ipfCcmUiLayoutConfigCountAllResponse.setResultString("1");
        } else {
        	ipfCcmUiLayoutConfigCountAllResponse.setResultString("0");
        }        
        return ipfCcmUiLayoutConfigCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmUiLayoutConfigCreateRequest request){
    	IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig=new IpfCcmUiLayoutConfig();
    	ipfCcmUiLayoutConfig.setId(request.getId());
        ArrayList<IpfCcmUiLayoutConfig> ipfCcmUiLayoutConfigs= ipfCcmUiLayoutConfigService.selectWithCondition(ipfCcmUiLayoutConfig);
        if (ipfCcmUiLayoutConfigs!=null&&ipfCcmUiLayoutConfigs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmUiLayoutConfigUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmUiLayoutConfigDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmUiLayoutConfigSelectRequest request){
        return  true;
     }    
}
