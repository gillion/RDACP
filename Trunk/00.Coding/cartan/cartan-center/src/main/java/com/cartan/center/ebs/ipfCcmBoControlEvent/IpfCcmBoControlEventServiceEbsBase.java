/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoControlEvent;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoControlEvent.request.*;
import com.cartan.center.ebs.ipfCcmBoControlEvent.response.*;
import com.cartan.core.ipfCcmBoControlEvent.domain.IpfCcmBoControlEvent;
import com.cartan.core.ipfCcmBoControlEvent.service.IpfCcmBoControlEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoControlEventServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoControlEventServiceEbs.class.getName());
	private IpfCcmBoControlEventService  ipfCcmBoControlEventService;
	
    public IpfCcmBoControlEventService getIpfCcmBoControlEventService() {
        return ipfCcmBoControlEventService;
    }

    @Autowired
    public void setIpfCcmBoControlEventService(IpfCcmBoControlEventService ipfCcmBoControlEventService) {
        this.ipfCcmBoControlEventService = ipfCcmBoControlEventService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoControlEventGetSessionRequest request) {      
    	IpfCcmBoControlEventGetSessionResponse ipfCcmBoControlEventGetSessionResponse = new IpfCcmBoControlEventGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoControlEventGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoControlEventGetSessionResponse.setResultString("1");
            ipfCcmBoControlEventGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoControlEventGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoControlEventGetSessionRequest request) {
    	IpfCcmBoControlEventGetSessionResponse ipfCcmBoControlEventGetSessionResponse = new IpfCcmBoControlEventGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoControlEventGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoControlEventGetSessionResponse.setResultString("0");
        }
        ipfCcmBoControlEventGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoControlEventGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoControlEventGetSessionRequest request) {
    	IpfCcmBoControlEventGetSessionResponse ipfCcmBoControlEventGetSessionResponse = new IpfCcmBoControlEventGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoControlEventGetSessionResponse.setResultString("0");
        	ipfCcmBoControlEventGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoControlEventGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoControlEventGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.createIpfCcmBoControlEvent", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoControlEvent(IpfCcmBoControlEventCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoControlEvent_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoControlEvent ipfCcmBoControlEvent=new IpfCcmBoControlEvent();
        ipfCcmBoControlEvent.setId(request.getId());    		
        ipfCcmBoControlEvent.setIpfCcbBoFormColumnId(request.getIpfCcbBoFormColumnId());
        ipfCcmBoControlEvent.setEventType(request.getEventType());
        ipfCcmBoControlEvent.setExecType(request.getExecType());
        ipfCcmBoControlEvent.setExecContent(request.getExecContent());
        ipfCcmBoControlEvent.setCallBack(request.getCallBack());
    	ipfCcmBoControlEventService.createIpfCcmBoControlEvent(ipfCcmBoControlEvent);
        //返回响应
        IpfCcmBoControlEventCreateResponse ipfCcmBoControlEventCreateResponse = new IpfCcmBoControlEventCreateResponse();
        ipfCcmBoControlEventCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoControlEventCreateResponse.setResultJson(ipfCcmBoControlEvent);
        return ipfCcmBoControlEventCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.deleteIpfCcmBoControlEvent", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoControlEvent(IpfCcmBoControlEventDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoControlEvent_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoControlEventService.deleteIpfCcmBoControlEvent(idstr);
        //返回响应
        IpfCcmBoControlEventDeleteResponse ipfCcmBoControlEventDeleteResponse = new IpfCcmBoControlEventDeleteResponse();
        ipfCcmBoControlEventDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoControlEventDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.updateIpfCcmBoControlEvent", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoControlEvent(IpfCcmBoControlEventUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoControlEvent_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoControlEvent ipfCcmBoControlEvent=new IpfCcmBoControlEvent();
        ipfCcmBoControlEvent=ipfCcmBoControlEventService.getIpfCcmBoControlEvent(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoControlEvent.setId(request.getId());
        }
        if (request.getIpfCcbBoFormColumnId()!=null){
	        ipfCcmBoControlEvent.setIpfCcbBoFormColumnId(request.getIpfCcbBoFormColumnId());
        }
        if (request.getEventType()!=null){
	        ipfCcmBoControlEvent.setEventType(request.getEventType());
        }
        if (request.getExecType()!=null){
	        ipfCcmBoControlEvent.setExecType(request.getExecType());
        }
        if (request.getExecContent()!=null){
	        ipfCcmBoControlEvent.setExecContent(request.getExecContent());
        }
        if (request.getCallBack()!=null){
	        ipfCcmBoControlEvent.setCallBack(request.getCallBack());
        }
    	ipfCcmBoControlEventService.updateIpfCcmBoControlEvent(ipfCcmBoControlEvent);
        //返回响应
        IpfCcmBoControlEventUpdateResponse ipfCcmBoControlEventUpdateResponse = new IpfCcmBoControlEventUpdateResponse();
        ipfCcmBoControlEventUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoControlEventUpdateResponse.setResultJson(ipfCcmBoControlEvent);
        return ipfCcmBoControlEventUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.getIpfCcmBoControlEvent", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoControlEvent(IpfCcmBoControlEventGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoControlEvent ipfCcmBoControlEvent=new IpfCcmBoControlEvent();
        ipfCcmBoControlEvent=ipfCcmBoControlEventService.getIpfCcmBoControlEvent(id);
        //返回响应
        IpfCcmBoControlEventGetResponse ipfCcmBoControlEventGetResponse = new IpfCcmBoControlEventGetResponse();
        ipfCcmBoControlEventGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoControlEventGetResponse.setResultJson(ipfCcmBoControlEvent);
        return ipfCcmBoControlEventGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoControlEventSelectAllRequest request) {
        IpfCcmBoControlEventSelectAllResponse ipfCcmBoControlEventSelectAllResponse = new IpfCcmBoControlEventSelectAllResponse();
        ipfCcmBoControlEventSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoControlEventSelectAllResponse.setResultJson(ipfCcmBoControlEventService.selectAll());
        return ipfCcmBoControlEventSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoControlEventCountAllRequest request) {
        IpfCcmBoControlEventCountAllResponse ipfCcmBoControlEventCountAllResponse = new IpfCcmBoControlEventCountAllResponse();
        ipfCcmBoControlEventCountAllResponse.setResultString(String.valueOf(ipfCcmBoControlEventService.countAll()));
        ipfCcmBoControlEventCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoControlEventCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoControlEventSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoControlEventSelectAllResponse ipfCcmBoControlEventSelectAllResponse = new IpfCcmBoControlEventSelectAllResponse();
        ipfCcmBoControlEventSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoControlEventSelectAllResponse.setResultJson(ipfCcmBoControlEventService.selectBySql(sqlstr));
        return ipfCcmBoControlEventSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.selectIpfCcmBoControlEvent", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoControlEventSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoControlEvent_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoControlEvent ipfCcmBoControlEvent=new IpfCcmBoControlEvent();
        ipfCcmBoControlEvent.setId(request.getId());
        ipfCcmBoControlEvent.setIpfCcbBoFormColumnId(request.getIpfCcbBoFormColumnId());
        ipfCcmBoControlEvent.setEventType(request.getEventType());
        ipfCcmBoControlEvent.setExecType(request.getExecType());
        ipfCcmBoControlEvent.setExecContent(request.getExecContent());
        ipfCcmBoControlEvent.setCallBack(request.getCallBack());
    	IpfCcmBoControlEventSelectResponse ipfCcmBoControlEventSelectResponse = new IpfCcmBoControlEventSelectResponse();
        ipfCcmBoControlEventSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoControlEvent> ipfCcmBoControlEvents= ipfCcmBoControlEventService.selectWithCondition(ipfCcmBoControlEvent);
        ipfCcmBoControlEventSelectResponse.setResultJson(ipfCcmBoControlEvents);
        return ipfCcmBoControlEventSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoControlEvent.isExistIpfCcmBoControlEvent", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoControlEvent(IpfCcmBoControlEventSelectRequest request) {
        IpfCcmBoControlEvent ipfCcmBoControlEvent=new IpfCcmBoControlEvent();
        ipfCcmBoControlEvent.setId(request.getId());
        ipfCcmBoControlEvent.setIpfCcbBoFormColumnId(request.getIpfCcbBoFormColumnId());
        ipfCcmBoControlEvent.setEventType(request.getEventType());
        ipfCcmBoControlEvent.setExecType(request.getExecType());
        ipfCcmBoControlEvent.setExecContent(request.getExecContent());
        ipfCcmBoControlEvent.setCallBack(request.getCallBack());
        ArrayList<IpfCcmBoControlEvent> ipfCcmBoControlEvents= ipfCcmBoControlEventService.selectWithCondition(ipfCcmBoControlEvent);
    	IpfCcmBoControlEventCountAllResponse ipfCcmBoControlEventCountAllResponse = new IpfCcmBoControlEventCountAllResponse();
        if (ipfCcmBoControlEvents.size()>0){
        	ipfCcmBoControlEventCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoControlEventCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoControlEventCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoControlEventCreateRequest request){
    	IpfCcmBoControlEvent ipfCcmBoControlEvent=new IpfCcmBoControlEvent();
    	ipfCcmBoControlEvent.setId(request.getId());
        ArrayList<IpfCcmBoControlEvent> ipfCcmBoControlEvents= ipfCcmBoControlEventService.selectWithCondition(ipfCcmBoControlEvent);
        if (ipfCcmBoControlEvents!=null&&ipfCcmBoControlEvents.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoControlEventUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoControlEventDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoControlEventSelectRequest request){
        return  true;
     }    
}
