/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmConfigAttrBo;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfRtmConfigAttrBo.request.*;
import com.cartan.center.ebs.ipfRtmConfigAttrBo.response.*;
import com.cartan.core.ipfRtmConfigAttrBo.domain.IpfRtmConfigAttrBo;
import com.cartan.core.ipfRtmConfigAttrBo.service.IpfRtmConfigAttrBoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfRtmConfigAttrBoServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfRtmConfigAttrBoServiceEbs.class.getName());
	private IpfRtmConfigAttrBoService  ipfRtmConfigAttrBoService;
	
    public IpfRtmConfigAttrBoService getIpfRtmConfigAttrBoService() {
        return ipfRtmConfigAttrBoService;
    }

    @Autowired
    public void setIpfRtmConfigAttrBoService(IpfRtmConfigAttrBoService ipfRtmConfigAttrBoService) {
        this.ipfRtmConfigAttrBoService = ipfRtmConfigAttrBoService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfRtmConfigAttrBoGetSessionRequest request) {      
    	IpfRtmConfigAttrBoGetSessionResponse ipfRtmConfigAttrBoGetSessionResponse = new IpfRtmConfigAttrBoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmConfigAttrBoGetSessionResponse.setResultString("0");
        } else {
        	ipfRtmConfigAttrBoGetSessionResponse.setResultString("1");
            ipfRtmConfigAttrBoGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfRtmConfigAttrBoGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfRtmConfigAttrBoGetSessionRequest request) {
    	IpfRtmConfigAttrBoGetSessionResponse ipfRtmConfigAttrBoGetSessionResponse = new IpfRtmConfigAttrBoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfRtmConfigAttrBoGetSessionResponse.setResultString("1");
        } else {
        	ipfRtmConfigAttrBoGetSessionResponse.setResultString("0");
        }
        ipfRtmConfigAttrBoGetSessionResponse.setSessionId(request.getSessionId());
        return ipfRtmConfigAttrBoGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfRtmConfigAttrBoGetSessionRequest request) {
    	IpfRtmConfigAttrBoGetSessionResponse ipfRtmConfigAttrBoGetSessionResponse = new IpfRtmConfigAttrBoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmConfigAttrBoGetSessionResponse.setResultString("0");
        	ipfRtmConfigAttrBoGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfRtmConfigAttrBoGetSessionResponse.setResultString("1");
        }
        return ipfRtmConfigAttrBoGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.createIpfRtmConfigAttrBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfRtmConfigAttrBo(IpfRtmConfigAttrBoCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfRtmConfigAttrBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmConfigAttrBo ipfRtmConfigAttrBo=new IpfRtmConfigAttrBo();
        ipfRtmConfigAttrBo.setId(request.getId());    		
        ipfRtmConfigAttrBo.setIpfRtmConfigAttrId(request.getIpfRtmConfigAttrId());
        ipfRtmConfigAttrBo.setIpfRtmConfigId(request.getIpfRtmConfigId());
        ipfRtmConfigAttrBo.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfRtmConfigAttrBo.setBoName(request.getBoName());
        ipfRtmConfigAttrBo.setBoDesc(request.getBoDesc());
        ipfRtmConfigAttrBo.setBoAttributeName(request.getBoAttributeName());
        ipfRtmConfigAttrBo.setIsVisible(request.getIsVisible());
        ipfRtmConfigAttrBo.setIsRequired(request.getIsRequired());
        ipfRtmConfigAttrBo.setDefaultValue(request.getDefaultValue());
        ipfRtmConfigAttrBo.setShlpValueFiled(request.getShlpValueFiled());
    	ipfRtmConfigAttrBoService.createIpfRtmConfigAttrBo(ipfRtmConfigAttrBo);
        //返回响应
        IpfRtmConfigAttrBoCreateResponse ipfRtmConfigAttrBoCreateResponse = new IpfRtmConfigAttrBoCreateResponse();
        ipfRtmConfigAttrBoCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigAttrBoCreateResponse.setResultJson(ipfRtmConfigAttrBo);
        return ipfRtmConfigAttrBoCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.deleteIpfRtmConfigAttrBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfRtmConfigAttrBo(IpfRtmConfigAttrBoDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfRtmConfigAttrBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfRtmConfigAttrBoService.deleteIpfRtmConfigAttrBo(idstr);
        //返回响应
        IpfRtmConfigAttrBoDeleteResponse ipfRtmConfigAttrBoDeleteResponse = new IpfRtmConfigAttrBoDeleteResponse();
        ipfRtmConfigAttrBoDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmConfigAttrBoDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.updateIpfRtmConfigAttrBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfRtmConfigAttrBo(IpfRtmConfigAttrBoUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfRtmConfigAttrBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmConfigAttrBo ipfRtmConfigAttrBo=new IpfRtmConfigAttrBo();
        ipfRtmConfigAttrBo=ipfRtmConfigAttrBoService.getIpfRtmConfigAttrBo(request.getId());
        if (request.getId()!=null){
	        ipfRtmConfigAttrBo.setId(request.getId());
        }
        if (request.getIpfRtmConfigAttrId()!=null){
	        ipfRtmConfigAttrBo.setIpfRtmConfigAttrId(request.getIpfRtmConfigAttrId());
        }
        if (request.getIpfRtmConfigId()!=null){
	        ipfRtmConfigAttrBo.setIpfRtmConfigId(request.getIpfRtmConfigId());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfRtmConfigAttrBo.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getBoName()!=null){
	        ipfRtmConfigAttrBo.setBoName(request.getBoName());
        }
        if (request.getBoDesc()!=null){
	        ipfRtmConfigAttrBo.setBoDesc(request.getBoDesc());
        }
        if (request.getBoAttributeName()!=null){
	        ipfRtmConfigAttrBo.setBoAttributeName(request.getBoAttributeName());
        }
        if (request.getIsVisible()!=null){
	        ipfRtmConfigAttrBo.setIsVisible(request.getIsVisible());
        }
        if (request.getIsRequired()!=null){
	        ipfRtmConfigAttrBo.setIsRequired(request.getIsRequired());
        }
        if (request.getDefaultValue()!=null){
	        ipfRtmConfigAttrBo.setDefaultValue(request.getDefaultValue());
        }
        if (request.getShlpValueFiled()!=null){
	        ipfRtmConfigAttrBo.setShlpValueFiled(request.getShlpValueFiled());
        }
    	ipfRtmConfigAttrBoService.updateIpfRtmConfigAttrBo(ipfRtmConfigAttrBo);
        //返回响应
        IpfRtmConfigAttrBoUpdateResponse ipfRtmConfigAttrBoUpdateResponse = new IpfRtmConfigAttrBoUpdateResponse();
        ipfRtmConfigAttrBoUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigAttrBoUpdateResponse.setResultJson(ipfRtmConfigAttrBo);
        return ipfRtmConfigAttrBoUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.getIpfRtmConfigAttrBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfRtmConfigAttrBo(IpfRtmConfigAttrBoGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfRtmConfigAttrBo ipfRtmConfigAttrBo=new IpfRtmConfigAttrBo();
        ipfRtmConfigAttrBo=ipfRtmConfigAttrBoService.getIpfRtmConfigAttrBo(id);
        //返回响应
        IpfRtmConfigAttrBoGetResponse ipfRtmConfigAttrBoGetResponse = new IpfRtmConfigAttrBoGetResponse();
        ipfRtmConfigAttrBoGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigAttrBoGetResponse.setResultJson(ipfRtmConfigAttrBo);
        return ipfRtmConfigAttrBoGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfRtmConfigAttrBoSelectAllRequest request) {
        IpfRtmConfigAttrBoSelectAllResponse ipfRtmConfigAttrBoSelectAllResponse = new IpfRtmConfigAttrBoSelectAllResponse();
        ipfRtmConfigAttrBoSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigAttrBoSelectAllResponse.setResultJson(ipfRtmConfigAttrBoService.selectAll());
        return ipfRtmConfigAttrBoSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfRtmConfigAttrBoCountAllRequest request) {
        IpfRtmConfigAttrBoCountAllResponse ipfRtmConfigAttrBoCountAllResponse = new IpfRtmConfigAttrBoCountAllResponse();
        ipfRtmConfigAttrBoCountAllResponse.setResultString(String.valueOf(ipfRtmConfigAttrBoService.countAll()));
        ipfRtmConfigAttrBoCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmConfigAttrBoCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfRtmConfigAttrBoSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfRtmConfigAttrBoSelectAllResponse ipfRtmConfigAttrBoSelectAllResponse = new IpfRtmConfigAttrBoSelectAllResponse();
        ipfRtmConfigAttrBoSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigAttrBoSelectAllResponse.setResultJson(ipfRtmConfigAttrBoService.selectBySql(sqlstr));
        return ipfRtmConfigAttrBoSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.selectIpfRtmConfigAttrBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfRtmConfigAttrBoSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfRtmConfigAttrBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmConfigAttrBo ipfRtmConfigAttrBo=new IpfRtmConfigAttrBo();
        ipfRtmConfigAttrBo.setId(request.getId());
        ipfRtmConfigAttrBo.setIpfRtmConfigAttrId(request.getIpfRtmConfigAttrId());
        ipfRtmConfigAttrBo.setIpfRtmConfigId(request.getIpfRtmConfigId());
        ipfRtmConfigAttrBo.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfRtmConfigAttrBo.setBoName(request.getBoName());
        ipfRtmConfigAttrBo.setBoDesc(request.getBoDesc());
        ipfRtmConfigAttrBo.setBoAttributeName(request.getBoAttributeName());
        ipfRtmConfigAttrBo.setIsVisible(request.getIsVisible());
        ipfRtmConfigAttrBo.setIsRequired(request.getIsRequired());
        ipfRtmConfigAttrBo.setDefaultValue(request.getDefaultValue());
        ipfRtmConfigAttrBo.setShlpValueFiled(request.getShlpValueFiled());
    	IpfRtmConfigAttrBoSelectResponse ipfRtmConfigAttrBoSelectResponse = new IpfRtmConfigAttrBoSelectResponse();
        ipfRtmConfigAttrBoSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfRtmConfigAttrBo> ipfRtmConfigAttrBos= ipfRtmConfigAttrBoService.selectWithCondition(ipfRtmConfigAttrBo);
        ipfRtmConfigAttrBoSelectResponse.setResultJson(ipfRtmConfigAttrBos);
        return ipfRtmConfigAttrBoSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttrBo.isExistIpfRtmConfigAttrBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfRtmConfigAttrBo(IpfRtmConfigAttrBoSelectRequest request) {
        IpfRtmConfigAttrBo ipfRtmConfigAttrBo=new IpfRtmConfigAttrBo();
        ipfRtmConfigAttrBo.setId(request.getId());
        ipfRtmConfigAttrBo.setIpfRtmConfigAttrId(request.getIpfRtmConfigAttrId());
        ipfRtmConfigAttrBo.setIpfRtmConfigId(request.getIpfRtmConfigId());
        ipfRtmConfigAttrBo.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfRtmConfigAttrBo.setBoName(request.getBoName());
        ipfRtmConfigAttrBo.setBoDesc(request.getBoDesc());
        ipfRtmConfigAttrBo.setBoAttributeName(request.getBoAttributeName());
        ipfRtmConfigAttrBo.setIsVisible(request.getIsVisible());
        ipfRtmConfigAttrBo.setIsRequired(request.getIsRequired());
        ipfRtmConfigAttrBo.setDefaultValue(request.getDefaultValue());
        ipfRtmConfigAttrBo.setShlpValueFiled(request.getShlpValueFiled());
        ArrayList<IpfRtmConfigAttrBo> ipfRtmConfigAttrBos= ipfRtmConfigAttrBoService.selectWithCondition(ipfRtmConfigAttrBo);
    	IpfRtmConfigAttrBoCountAllResponse ipfRtmConfigAttrBoCountAllResponse = new IpfRtmConfigAttrBoCountAllResponse();
        if (ipfRtmConfigAttrBos.size()>0){
        	ipfRtmConfigAttrBoCountAllResponse.setResultString("1");
        } else {
        	ipfRtmConfigAttrBoCountAllResponse.setResultString("0");
        }        
        return ipfRtmConfigAttrBoCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfRtmConfigAttrBoCreateRequest request){
    	IpfRtmConfigAttrBo ipfRtmConfigAttrBo=new IpfRtmConfigAttrBo();
    	ipfRtmConfigAttrBo.setId(request.getId());
        ArrayList<IpfRtmConfigAttrBo> ipfRtmConfigAttrBos= ipfRtmConfigAttrBoService.selectWithCondition(ipfRtmConfigAttrBo);
        if (ipfRtmConfigAttrBos!=null&&ipfRtmConfigAttrBos.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfRtmConfigAttrBoUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfRtmConfigAttrBoDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfRtmConfigAttrBoSelectRequest request){
        return  true;
     }    
}
