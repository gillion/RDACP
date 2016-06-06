/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmTypeBo;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfRtmTypeBo.request.*;
import com.cartan.center.ebs.ipfRtmTypeBo.response.*;
import com.cartan.core.ipfRtmTypeBo.domain.IpfRtmTypeBo;
import com.cartan.core.ipfRtmTypeBo.service.IpfRtmTypeBoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfRtmTypeBoServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfRtmTypeBoServiceEbs.class.getName());
	private IpfRtmTypeBoService  ipfRtmTypeBoService;
	
    public IpfRtmTypeBoService getIpfRtmTypeBoService() {
        return ipfRtmTypeBoService;
    }

    @Autowired
    public void setIpfRtmTypeBoService(IpfRtmTypeBoService ipfRtmTypeBoService) {
        this.ipfRtmTypeBoService = ipfRtmTypeBoService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfRtmTypeBoGetSessionRequest request) {      
    	IpfRtmTypeBoGetSessionResponse ipfRtmTypeBoGetSessionResponse = new IpfRtmTypeBoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmTypeBoGetSessionResponse.setResultString("0");
        } else {
        	ipfRtmTypeBoGetSessionResponse.setResultString("1");
            ipfRtmTypeBoGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfRtmTypeBoGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfRtmTypeBoGetSessionRequest request) {
    	IpfRtmTypeBoGetSessionResponse ipfRtmTypeBoGetSessionResponse = new IpfRtmTypeBoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfRtmTypeBoGetSessionResponse.setResultString("1");
        } else {
        	ipfRtmTypeBoGetSessionResponse.setResultString("0");
        }
        ipfRtmTypeBoGetSessionResponse.setSessionId(request.getSessionId());
        return ipfRtmTypeBoGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfRtmTypeBoGetSessionRequest request) {
    	IpfRtmTypeBoGetSessionResponse ipfRtmTypeBoGetSessionResponse = new IpfRtmTypeBoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmTypeBoGetSessionResponse.setResultString("0");
        	ipfRtmTypeBoGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfRtmTypeBoGetSessionResponse.setResultString("1");
        }
        return ipfRtmTypeBoGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.createIpfRtmTypeBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfRtmTypeBo(IpfRtmTypeBoCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfRtmTypeBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmTypeBo ipfRtmTypeBo=new IpfRtmTypeBo();
        ipfRtmTypeBo.setId(request.getId());    		
        ipfRtmTypeBo.setIpfRtmTypeId(request.getIpfRtmTypeId());
        ipfRtmTypeBo.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfRtmTypeBo.setBoName(request.getBoName());
        ipfRtmTypeBo.setBoDesc(request.getBoDesc());
        ipfRtmTypeBo.setPropertyName(request.getPropertyName());
        ipfRtmTypeBo.setPropertyUtility(request.getPropertyUtility());
        ipfRtmTypeBo.setExternalBoName(request.getExternalBoName());
        ipfRtmTypeBo.setExternalMatchProperty(request.getExternalMatchProperty());
        ipfRtmTypeBo.setExternalResultProperty(request.getExternalResultProperty());
        ipfRtmTypeBo.setExternalBoId(request.getExternalBoId());
        ipfRtmTypeBo.setTriggerPropertyName(request.getTriggerPropertyName());
    	ipfRtmTypeBoService.createIpfRtmTypeBo(ipfRtmTypeBo);
        //返回响应
        IpfRtmTypeBoCreateResponse ipfRtmTypeBoCreateResponse = new IpfRtmTypeBoCreateResponse();
        ipfRtmTypeBoCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoCreateResponse.setResultJson(ipfRtmTypeBo);
        return ipfRtmTypeBoCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.deleteIpfRtmTypeBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfRtmTypeBo(IpfRtmTypeBoDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfRtmTypeBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfRtmTypeBoService.deleteIpfRtmTypeBo(idstr);
        //返回响应
        IpfRtmTypeBoDeleteResponse ipfRtmTypeBoDeleteResponse = new IpfRtmTypeBoDeleteResponse();
        ipfRtmTypeBoDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmTypeBoDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.updateIpfRtmTypeBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfRtmTypeBo(IpfRtmTypeBoUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfRtmTypeBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmTypeBo ipfRtmTypeBo=new IpfRtmTypeBo();
        ipfRtmTypeBo=ipfRtmTypeBoService.getIpfRtmTypeBo(request.getId());
        if (request.getId()!=null){
	        ipfRtmTypeBo.setId(request.getId());
        }
        if (request.getIpfRtmTypeId()!=null){
	        ipfRtmTypeBo.setIpfRtmTypeId(request.getIpfRtmTypeId());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfRtmTypeBo.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getBoName()!=null){
	        ipfRtmTypeBo.setBoName(request.getBoName());
        }
        if (request.getBoDesc()!=null){
	        ipfRtmTypeBo.setBoDesc(request.getBoDesc());
        }
        if (request.getPropertyName()!=null){
	        ipfRtmTypeBo.setPropertyName(request.getPropertyName());
        }
        if (request.getPropertyUtility()!=null){
	        ipfRtmTypeBo.setPropertyUtility(request.getPropertyUtility());
        }
        if (request.getExternalBoName()!=null){
	        ipfRtmTypeBo.setExternalBoName(request.getExternalBoName());
        }
        if (request.getExternalMatchProperty()!=null){
	        ipfRtmTypeBo.setExternalMatchProperty(request.getExternalMatchProperty());
        }
        if (request.getExternalResultProperty()!=null){
	        ipfRtmTypeBo.setExternalResultProperty(request.getExternalResultProperty());
        }
        if (request.getExternalBoId()!=null){
	        ipfRtmTypeBo.setExternalBoId(request.getExternalBoId());
        }
        if (request.getTriggerPropertyName()!=null){
	        ipfRtmTypeBo.setTriggerPropertyName(request.getTriggerPropertyName());
        }
    	ipfRtmTypeBoService.updateIpfRtmTypeBo(ipfRtmTypeBo);
        //返回响应
        IpfRtmTypeBoUpdateResponse ipfRtmTypeBoUpdateResponse = new IpfRtmTypeBoUpdateResponse();
        ipfRtmTypeBoUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoUpdateResponse.setResultJson(ipfRtmTypeBo);
        return ipfRtmTypeBoUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.getIpfRtmTypeBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfRtmTypeBo(IpfRtmTypeBoGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfRtmTypeBo ipfRtmTypeBo=new IpfRtmTypeBo();
        ipfRtmTypeBo=ipfRtmTypeBoService.getIpfRtmTypeBo(id);
        //返回响应
        IpfRtmTypeBoGetResponse ipfRtmTypeBoGetResponse = new IpfRtmTypeBoGetResponse();
        ipfRtmTypeBoGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoGetResponse.setResultJson(ipfRtmTypeBo);
        return ipfRtmTypeBoGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfRtmTypeBoSelectAllRequest request) {
        IpfRtmTypeBoSelectAllResponse ipfRtmTypeBoSelectAllResponse = new IpfRtmTypeBoSelectAllResponse();
        ipfRtmTypeBoSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoSelectAllResponse.setResultJson(ipfRtmTypeBoService.selectAll());
        return ipfRtmTypeBoSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfRtmTypeBoCountAllRequest request) {
        IpfRtmTypeBoCountAllResponse ipfRtmTypeBoCountAllResponse = new IpfRtmTypeBoCountAllResponse();
        ipfRtmTypeBoCountAllResponse.setResultString(String.valueOf(ipfRtmTypeBoService.countAll()));
        ipfRtmTypeBoCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmTypeBoCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfRtmTypeBoSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfRtmTypeBoSelectAllResponse ipfRtmTypeBoSelectAllResponse = new IpfRtmTypeBoSelectAllResponse();
        ipfRtmTypeBoSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoSelectAllResponse.setResultJson(ipfRtmTypeBoService.selectBySql(sqlstr));
        return ipfRtmTypeBoSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.selectIpfRtmTypeBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfRtmTypeBoSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfRtmTypeBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmTypeBo ipfRtmTypeBo=new IpfRtmTypeBo();
        ipfRtmTypeBo.setId(request.getId());
        ipfRtmTypeBo.setIpfRtmTypeId(request.getIpfRtmTypeId());
        ipfRtmTypeBo.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfRtmTypeBo.setBoName(request.getBoName());
        ipfRtmTypeBo.setBoDesc(request.getBoDesc());
        ipfRtmTypeBo.setPropertyName(request.getPropertyName());
        ipfRtmTypeBo.setPropertyUtility(request.getPropertyUtility());
        ipfRtmTypeBo.setExternalBoName(request.getExternalBoName());
        ipfRtmTypeBo.setExternalMatchProperty(request.getExternalMatchProperty());
        ipfRtmTypeBo.setExternalResultProperty(request.getExternalResultProperty());
        ipfRtmTypeBo.setExternalBoId(request.getExternalBoId());
        ipfRtmTypeBo.setTriggerPropertyName(request.getTriggerPropertyName());
    	IpfRtmTypeBoSelectResponse ipfRtmTypeBoSelectResponse = new IpfRtmTypeBoSelectResponse();
        ipfRtmTypeBoSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfRtmTypeBo> ipfRtmTypeBos= ipfRtmTypeBoService.selectWithCondition(ipfRtmTypeBo);
        ipfRtmTypeBoSelectResponse.setResultJson(ipfRtmTypeBos);
        return ipfRtmTypeBoSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBo.isExistIpfRtmTypeBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfRtmTypeBo(IpfRtmTypeBoSelectRequest request) {
        IpfRtmTypeBo ipfRtmTypeBo=new IpfRtmTypeBo();
        ipfRtmTypeBo.setId(request.getId());
        ipfRtmTypeBo.setIpfRtmTypeId(request.getIpfRtmTypeId());
        ipfRtmTypeBo.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfRtmTypeBo.setBoName(request.getBoName());
        ipfRtmTypeBo.setBoDesc(request.getBoDesc());
        ipfRtmTypeBo.setPropertyName(request.getPropertyName());
        ipfRtmTypeBo.setPropertyUtility(request.getPropertyUtility());
        ipfRtmTypeBo.setExternalBoName(request.getExternalBoName());
        ipfRtmTypeBo.setExternalMatchProperty(request.getExternalMatchProperty());
        ipfRtmTypeBo.setExternalResultProperty(request.getExternalResultProperty());
        ipfRtmTypeBo.setExternalBoId(request.getExternalBoId());
        ipfRtmTypeBo.setTriggerPropertyName(request.getTriggerPropertyName());
        ArrayList<IpfRtmTypeBo> ipfRtmTypeBos= ipfRtmTypeBoService.selectWithCondition(ipfRtmTypeBo);
    	IpfRtmTypeBoCountAllResponse ipfRtmTypeBoCountAllResponse = new IpfRtmTypeBoCountAllResponse();
        if (ipfRtmTypeBos.size()>0){
        	ipfRtmTypeBoCountAllResponse.setResultString("1");
        } else {
        	ipfRtmTypeBoCountAllResponse.setResultString("0");
        }        
        return ipfRtmTypeBoCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfRtmTypeBoCreateRequest request){
    	IpfRtmTypeBo ipfRtmTypeBo=new IpfRtmTypeBo();
    	ipfRtmTypeBo.setId(request.getId());
        ArrayList<IpfRtmTypeBo> ipfRtmTypeBos= ipfRtmTypeBoService.selectWithCondition(ipfRtmTypeBo);
        if (ipfRtmTypeBos!=null&&ipfRtmTypeBos.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfRtmTypeBoUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfRtmTypeBoDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfRtmTypeBoSelectRequest request){
        return  true;
     }    
}
