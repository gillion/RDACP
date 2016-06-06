/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmTypeBoAttr;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfRtmTypeBoAttr.request.*;
import com.cartan.center.ebs.ipfRtmTypeBoAttr.response.*;
import com.cartan.core.ipfRtmTypeBoAttr.domain.IpfRtmTypeBoAttr;
import com.cartan.core.ipfRtmTypeBoAttr.service.IpfRtmTypeBoAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfRtmTypeBoAttrServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfRtmTypeBoAttrServiceEbs.class.getName());
	private IpfRtmTypeBoAttrService  ipfRtmTypeBoAttrService;
	
    public IpfRtmTypeBoAttrService getIpfRtmTypeBoAttrService() {
        return ipfRtmTypeBoAttrService;
    }

    @Autowired
    public void setIpfRtmTypeBoAttrService(IpfRtmTypeBoAttrService ipfRtmTypeBoAttrService) {
        this.ipfRtmTypeBoAttrService = ipfRtmTypeBoAttrService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfRtmTypeBoAttrGetSessionRequest request) {      
    	IpfRtmTypeBoAttrGetSessionResponse ipfRtmTypeBoAttrGetSessionResponse = new IpfRtmTypeBoAttrGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmTypeBoAttrGetSessionResponse.setResultString("0");
        } else {
        	ipfRtmTypeBoAttrGetSessionResponse.setResultString("1");
            ipfRtmTypeBoAttrGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfRtmTypeBoAttrGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfRtmTypeBoAttrGetSessionRequest request) {
    	IpfRtmTypeBoAttrGetSessionResponse ipfRtmTypeBoAttrGetSessionResponse = new IpfRtmTypeBoAttrGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfRtmTypeBoAttrGetSessionResponse.setResultString("1");
        } else {
        	ipfRtmTypeBoAttrGetSessionResponse.setResultString("0");
        }
        ipfRtmTypeBoAttrGetSessionResponse.setSessionId(request.getSessionId());
        return ipfRtmTypeBoAttrGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfRtmTypeBoAttrGetSessionRequest request) {
    	IpfRtmTypeBoAttrGetSessionResponse ipfRtmTypeBoAttrGetSessionResponse = new IpfRtmTypeBoAttrGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmTypeBoAttrGetSessionResponse.setResultString("0");
        	ipfRtmTypeBoAttrGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfRtmTypeBoAttrGetSessionResponse.setResultString("1");
        }
        return ipfRtmTypeBoAttrGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.createIpfRtmTypeBoAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfRtmTypeBoAttr(IpfRtmTypeBoAttrCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfRtmTypeBoAttr_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmTypeBoAttr ipfRtmTypeBoAttr=new IpfRtmTypeBoAttr();
        ipfRtmTypeBoAttr.setId(request.getId());    		
        ipfRtmTypeBoAttr.setIpfRtmTypeBoId(request.getIpfRtmTypeBoId());
        ipfRtmTypeBoAttr.setPropertyName(request.getPropertyName());
        ipfRtmTypeBoAttr.setFieldText(request.getFieldText());
    	ipfRtmTypeBoAttrService.createIpfRtmTypeBoAttr(ipfRtmTypeBoAttr);
        //返回响应
        IpfRtmTypeBoAttrCreateResponse ipfRtmTypeBoAttrCreateResponse = new IpfRtmTypeBoAttrCreateResponse();
        ipfRtmTypeBoAttrCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoAttrCreateResponse.setResultJson(ipfRtmTypeBoAttr);
        return ipfRtmTypeBoAttrCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.deleteIpfRtmTypeBoAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfRtmTypeBoAttr(IpfRtmTypeBoAttrDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfRtmTypeBoAttr_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfRtmTypeBoAttrService.deleteIpfRtmTypeBoAttr(idstr);
        //返回响应
        IpfRtmTypeBoAttrDeleteResponse ipfRtmTypeBoAttrDeleteResponse = new IpfRtmTypeBoAttrDeleteResponse();
        ipfRtmTypeBoAttrDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmTypeBoAttrDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.updateIpfRtmTypeBoAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfRtmTypeBoAttr(IpfRtmTypeBoAttrUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfRtmTypeBoAttr_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmTypeBoAttr ipfRtmTypeBoAttr=new IpfRtmTypeBoAttr();
        ipfRtmTypeBoAttr=ipfRtmTypeBoAttrService.getIpfRtmTypeBoAttr(request.getId());
        if (request.getId()!=null){
	        ipfRtmTypeBoAttr.setId(request.getId());
        }
        if (request.getIpfRtmTypeBoId()!=null){
	        ipfRtmTypeBoAttr.setIpfRtmTypeBoId(request.getIpfRtmTypeBoId());
        }
        if (request.getPropertyName()!=null){
	        ipfRtmTypeBoAttr.setPropertyName(request.getPropertyName());
        }
        if (request.getFieldText()!=null){
	        ipfRtmTypeBoAttr.setFieldText(request.getFieldText());
        }
    	ipfRtmTypeBoAttrService.updateIpfRtmTypeBoAttr(ipfRtmTypeBoAttr);
        //返回响应
        IpfRtmTypeBoAttrUpdateResponse ipfRtmTypeBoAttrUpdateResponse = new IpfRtmTypeBoAttrUpdateResponse();
        ipfRtmTypeBoAttrUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoAttrUpdateResponse.setResultJson(ipfRtmTypeBoAttr);
        return ipfRtmTypeBoAttrUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.getIpfRtmTypeBoAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfRtmTypeBoAttr(IpfRtmTypeBoAttrGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfRtmTypeBoAttr ipfRtmTypeBoAttr=new IpfRtmTypeBoAttr();
        ipfRtmTypeBoAttr=ipfRtmTypeBoAttrService.getIpfRtmTypeBoAttr(id);
        //返回响应
        IpfRtmTypeBoAttrGetResponse ipfRtmTypeBoAttrGetResponse = new IpfRtmTypeBoAttrGetResponse();
        ipfRtmTypeBoAttrGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoAttrGetResponse.setResultJson(ipfRtmTypeBoAttr);
        return ipfRtmTypeBoAttrGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfRtmTypeBoAttrSelectAllRequest request) {
        IpfRtmTypeBoAttrSelectAllResponse ipfRtmTypeBoAttrSelectAllResponse = new IpfRtmTypeBoAttrSelectAllResponse();
        ipfRtmTypeBoAttrSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoAttrSelectAllResponse.setResultJson(ipfRtmTypeBoAttrService.selectAll());
        return ipfRtmTypeBoAttrSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfRtmTypeBoAttrCountAllRequest request) {
        IpfRtmTypeBoAttrCountAllResponse ipfRtmTypeBoAttrCountAllResponse = new IpfRtmTypeBoAttrCountAllResponse();
        ipfRtmTypeBoAttrCountAllResponse.setResultString(String.valueOf(ipfRtmTypeBoAttrService.countAll()));
        ipfRtmTypeBoAttrCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmTypeBoAttrCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfRtmTypeBoAttrSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfRtmTypeBoAttrSelectAllResponse ipfRtmTypeBoAttrSelectAllResponse = new IpfRtmTypeBoAttrSelectAllResponse();
        ipfRtmTypeBoAttrSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoAttrSelectAllResponse.setResultJson(ipfRtmTypeBoAttrService.selectBySql(sqlstr));
        return ipfRtmTypeBoAttrSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.selectIpfRtmTypeBoAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfRtmTypeBoAttrSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfRtmTypeBoAttr_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmTypeBoAttr ipfRtmTypeBoAttr=new IpfRtmTypeBoAttr();
        ipfRtmTypeBoAttr.setId(request.getId());
        ipfRtmTypeBoAttr.setIpfRtmTypeBoId(request.getIpfRtmTypeBoId());
        ipfRtmTypeBoAttr.setPropertyName(request.getPropertyName());
        ipfRtmTypeBoAttr.setFieldText(request.getFieldText());
    	IpfRtmTypeBoAttrSelectResponse ipfRtmTypeBoAttrSelectResponse = new IpfRtmTypeBoAttrSelectResponse();
        ipfRtmTypeBoAttrSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfRtmTypeBoAttr> ipfRtmTypeBoAttrs= ipfRtmTypeBoAttrService.selectWithCondition(ipfRtmTypeBoAttr);
        ipfRtmTypeBoAttrSelectResponse.setResultJson(ipfRtmTypeBoAttrs);
        return ipfRtmTypeBoAttrSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoAttr.isExistIpfRtmTypeBoAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfRtmTypeBoAttr(IpfRtmTypeBoAttrSelectRequest request) {
        IpfRtmTypeBoAttr ipfRtmTypeBoAttr=new IpfRtmTypeBoAttr();
        ipfRtmTypeBoAttr.setId(request.getId());
        ipfRtmTypeBoAttr.setIpfRtmTypeBoId(request.getIpfRtmTypeBoId());
        ipfRtmTypeBoAttr.setPropertyName(request.getPropertyName());
        ipfRtmTypeBoAttr.setFieldText(request.getFieldText());
        ArrayList<IpfRtmTypeBoAttr> ipfRtmTypeBoAttrs= ipfRtmTypeBoAttrService.selectWithCondition(ipfRtmTypeBoAttr);
    	IpfRtmTypeBoAttrCountAllResponse ipfRtmTypeBoAttrCountAllResponse = new IpfRtmTypeBoAttrCountAllResponse();
        if (ipfRtmTypeBoAttrs.size()>0){
        	ipfRtmTypeBoAttrCountAllResponse.setResultString("1");
        } else {
        	ipfRtmTypeBoAttrCountAllResponse.setResultString("0");
        }        
        return ipfRtmTypeBoAttrCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfRtmTypeBoAttrCreateRequest request){
    	IpfRtmTypeBoAttr ipfRtmTypeBoAttr=new IpfRtmTypeBoAttr();
    	ipfRtmTypeBoAttr.setId(request.getId());
        ArrayList<IpfRtmTypeBoAttr> ipfRtmTypeBoAttrs= ipfRtmTypeBoAttrService.selectWithCondition(ipfRtmTypeBoAttr);
        if (ipfRtmTypeBoAttrs!=null&&ipfRtmTypeBoAttrs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfRtmTypeBoAttrUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfRtmTypeBoAttrDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfRtmTypeBoAttrSelectRequest request){
        return  true;
     }    
}
