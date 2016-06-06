/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmConfig;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfRtmConfig.request.*;
import com.cartan.center.ebs.ipfRtmConfig.response.*;
import com.cartan.core.ipfRtmConfig.domain.IpfRtmConfig;
import com.cartan.core.ipfRtmConfig.service.IpfRtmConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfRtmConfigServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfRtmConfigServiceEbs.class.getName());
	private IpfRtmConfigService  ipfRtmConfigService;
	
    public IpfRtmConfigService getIpfRtmConfigService() {
        return ipfRtmConfigService;
    }

    @Autowired
    public void setIpfRtmConfigService(IpfRtmConfigService ipfRtmConfigService) {
        this.ipfRtmConfigService = ipfRtmConfigService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfRtmConfigGetSessionRequest request) {      
    	IpfRtmConfigGetSessionResponse ipfRtmConfigGetSessionResponse = new IpfRtmConfigGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmConfigGetSessionResponse.setResultString("0");
        } else {
        	ipfRtmConfigGetSessionResponse.setResultString("1");
            ipfRtmConfigGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfRtmConfigGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfRtmConfigGetSessionRequest request) {
    	IpfRtmConfigGetSessionResponse ipfRtmConfigGetSessionResponse = new IpfRtmConfigGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfRtmConfigGetSessionResponse.setResultString("1");
        } else {
        	ipfRtmConfigGetSessionResponse.setResultString("0");
        }
        ipfRtmConfigGetSessionResponse.setSessionId(request.getSessionId());
        return ipfRtmConfigGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfRtmConfigGetSessionRequest request) {
    	IpfRtmConfigGetSessionResponse ipfRtmConfigGetSessionResponse = new IpfRtmConfigGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmConfigGetSessionResponse.setResultString("0");
        	ipfRtmConfigGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfRtmConfigGetSessionResponse.setResultString("1");
        }
        return ipfRtmConfigGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.createIpfRtmConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfRtmConfig(IpfRtmConfigCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfRtmConfig_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmConfig ipfRtmConfig=new IpfRtmConfig();
        ipfRtmConfig.setId(request.getId());    		
        ipfRtmConfig.setConfigCode(request.getConfigCode());
        ipfRtmConfig.setConfigName(request.getConfigName());
        ipfRtmConfig.setTypeCode(request.getTypeCode());
    	ipfRtmConfigService.createIpfRtmConfig(ipfRtmConfig);
        //返回响应
        IpfRtmConfigCreateResponse ipfRtmConfigCreateResponse = new IpfRtmConfigCreateResponse();
        ipfRtmConfigCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigCreateResponse.setResultJson(ipfRtmConfig);
        return ipfRtmConfigCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.deleteIpfRtmConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfRtmConfig(IpfRtmConfigDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfRtmConfig_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfRtmConfigService.deleteIpfRtmConfig(idstr);
        //返回响应
        IpfRtmConfigDeleteResponse ipfRtmConfigDeleteResponse = new IpfRtmConfigDeleteResponse();
        ipfRtmConfigDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmConfigDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.updateIpfRtmConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfRtmConfig(IpfRtmConfigUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfRtmConfig_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmConfig ipfRtmConfig=new IpfRtmConfig();
        ipfRtmConfig=ipfRtmConfigService.getIpfRtmConfig(request.getId());
        if (request.getId()!=null){
	        ipfRtmConfig.setId(request.getId());
        }
        if (request.getConfigCode()!=null){
	        ipfRtmConfig.setConfigCode(request.getConfigCode());
        }
        if (request.getConfigName()!=null){
	        ipfRtmConfig.setConfigName(request.getConfigName());
        }
        if (request.getTypeCode()!=null){
	        ipfRtmConfig.setTypeCode(request.getTypeCode());
        }
    	ipfRtmConfigService.updateIpfRtmConfig(ipfRtmConfig);
        //返回响应
        IpfRtmConfigUpdateResponse ipfRtmConfigUpdateResponse = new IpfRtmConfigUpdateResponse();
        ipfRtmConfigUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigUpdateResponse.setResultJson(ipfRtmConfig);
        return ipfRtmConfigUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.getIpfRtmConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfRtmConfig(IpfRtmConfigGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfRtmConfig ipfRtmConfig=new IpfRtmConfig();
        ipfRtmConfig=ipfRtmConfigService.getIpfRtmConfig(id);
        //返回响应
        IpfRtmConfigGetResponse ipfRtmConfigGetResponse = new IpfRtmConfigGetResponse();
        ipfRtmConfigGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigGetResponse.setResultJson(ipfRtmConfig);
        return ipfRtmConfigGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfRtmConfigSelectAllRequest request) {
        IpfRtmConfigSelectAllResponse ipfRtmConfigSelectAllResponse = new IpfRtmConfigSelectAllResponse();
        ipfRtmConfigSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigSelectAllResponse.setResultJson(ipfRtmConfigService.selectAll());
        return ipfRtmConfigSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfRtmConfigCountAllRequest request) {
        IpfRtmConfigCountAllResponse ipfRtmConfigCountAllResponse = new IpfRtmConfigCountAllResponse();
        ipfRtmConfigCountAllResponse.setResultString(String.valueOf(ipfRtmConfigService.countAll()));
        ipfRtmConfigCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmConfigCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfRtmConfigSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfRtmConfigSelectAllResponse ipfRtmConfigSelectAllResponse = new IpfRtmConfigSelectAllResponse();
        ipfRtmConfigSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigSelectAllResponse.setResultJson(ipfRtmConfigService.selectBySql(sqlstr));
        return ipfRtmConfigSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.selectIpfRtmConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfRtmConfigSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfRtmConfig_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmConfig ipfRtmConfig=new IpfRtmConfig();
        ipfRtmConfig.setId(request.getId());
        ipfRtmConfig.setConfigCode(request.getConfigCode());
        ipfRtmConfig.setConfigName(request.getConfigName());
        ipfRtmConfig.setTypeCode(request.getTypeCode());
    	IpfRtmConfigSelectResponse ipfRtmConfigSelectResponse = new IpfRtmConfigSelectResponse();
        ipfRtmConfigSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfRtmConfig> ipfRtmConfigs= ipfRtmConfigService.selectWithCondition(ipfRtmConfig);
        ipfRtmConfigSelectResponse.setResultJson(ipfRtmConfigs);
        return ipfRtmConfigSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfig.isExistIpfRtmConfig", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfRtmConfig(IpfRtmConfigSelectRequest request) {
        IpfRtmConfig ipfRtmConfig=new IpfRtmConfig();
        ipfRtmConfig.setId(request.getId());
        ipfRtmConfig.setConfigCode(request.getConfigCode());
        ipfRtmConfig.setConfigName(request.getConfigName());
        ipfRtmConfig.setTypeCode(request.getTypeCode());
        ArrayList<IpfRtmConfig> ipfRtmConfigs= ipfRtmConfigService.selectWithCondition(ipfRtmConfig);
    	IpfRtmConfigCountAllResponse ipfRtmConfigCountAllResponse = new IpfRtmConfigCountAllResponse();
        if (ipfRtmConfigs.size()>0){
        	ipfRtmConfigCountAllResponse.setResultString("1");
        } else {
        	ipfRtmConfigCountAllResponse.setResultString("0");
        }        
        return ipfRtmConfigCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfRtmConfigCreateRequest request){
    	IpfRtmConfig ipfRtmConfig=new IpfRtmConfig();
    	ipfRtmConfig.setId(request.getId());
        ArrayList<IpfRtmConfig> ipfRtmConfigs= ipfRtmConfigService.selectWithCondition(ipfRtmConfig);
        if (ipfRtmConfigs!=null&&ipfRtmConfigs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfRtmConfigUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfRtmConfigDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfRtmConfigSelectRequest request){
        return  true;
     }    
}
