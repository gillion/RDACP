/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlElement;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlElement.request.*;
import com.cartan.center.ebs.ipfDmlElement.response.*;
import com.cartan.core.ipfDmlElement.domain.IpfDmlElement;
import com.cartan.core.ipfDmlElement.service.IpfDmlElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlElementServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlElementServiceEbs.class.getName());
	private IpfDmlElementService  ipfDmlElementService;
	
    public IpfDmlElementService getIpfDmlElementService() {
        return ipfDmlElementService;
    }

    @Autowired
    public void setIpfDmlElementService(IpfDmlElementService ipfDmlElementService) {
        this.ipfDmlElementService = ipfDmlElementService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlElementGetSessionRequest request) {      
    	IpfDmlElementGetSessionResponse ipfDmlElementGetSessionResponse = new IpfDmlElementGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlElementGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlElementGetSessionResponse.setResultString("1");
            ipfDmlElementGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlElementGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlElementGetSessionRequest request) {
    	IpfDmlElementGetSessionResponse ipfDmlElementGetSessionResponse = new IpfDmlElementGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlElementGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlElementGetSessionResponse.setResultString("0");
        }
        ipfDmlElementGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlElementGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlElementGetSessionRequest request) {
    	IpfDmlElementGetSessionResponse ipfDmlElementGetSessionResponse = new IpfDmlElementGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlElementGetSessionResponse.setResultString("0");
        	ipfDmlElementGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlElementGetSessionResponse.setResultString("1");
        }
        return ipfDmlElementGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.createIpfDmlElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlElement(IpfDmlElementCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlElement_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlElement ipfDmlElement=new IpfDmlElement();
        ipfDmlElement.setId(request.getId());    		
        ipfDmlElement.setElementCode(request.getElementCode());
        ipfDmlElement.setFieldText(request.getFieldText());
        ipfDmlElement.setDataType(request.getDataType());
        ipfDmlElement.setFieldLength(request.getFieldLength());
        ipfDmlElement.setDecimals(request.getDecimals());
    	ipfDmlElementService.createIpfDmlElement(ipfDmlElement);
        //返回响应
        IpfDmlElementCreateResponse ipfDmlElementCreateResponse = new IpfDmlElementCreateResponse();
        ipfDmlElementCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlElementCreateResponse.setResultJson(ipfDmlElement);
        return ipfDmlElementCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.deleteIpfDmlElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlElement(IpfDmlElementDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlElement_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlElementService.deleteIpfDmlElement(idstr);
        //返回响应
        IpfDmlElementDeleteResponse ipfDmlElementDeleteResponse = new IpfDmlElementDeleteResponse();
        ipfDmlElementDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlElementDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.updateIpfDmlElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlElement(IpfDmlElementUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlElement_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlElement ipfDmlElement=new IpfDmlElement();
        ipfDmlElement=ipfDmlElementService.getIpfDmlElement(request.getId());
        if (request.getId()!=null){
	        ipfDmlElement.setId(request.getId());
        }
        if (request.getElementCode()!=null){
	        ipfDmlElement.setElementCode(request.getElementCode());
        }
        if (request.getFieldText()!=null){
	        ipfDmlElement.setFieldText(request.getFieldText());
        }
        if (request.getDataType()!=null){
	        ipfDmlElement.setDataType(request.getDataType());
        }
        if (request.getFieldLength()!=null){
	        ipfDmlElement.setFieldLength(request.getFieldLength());
        }
        if (request.getDecimals()!=null){
	        ipfDmlElement.setDecimals(request.getDecimals());
        }
    	ipfDmlElementService.updateIpfDmlElement(ipfDmlElement);
        //返回响应
        IpfDmlElementUpdateResponse ipfDmlElementUpdateResponse = new IpfDmlElementUpdateResponse();
        ipfDmlElementUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlElementUpdateResponse.setResultJson(ipfDmlElement);
        return ipfDmlElementUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.getIpfDmlElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlElement(IpfDmlElementGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlElement ipfDmlElement=new IpfDmlElement();
        ipfDmlElement=ipfDmlElementService.getIpfDmlElement(id);
        //返回响应
        IpfDmlElementGetResponse ipfDmlElementGetResponse = new IpfDmlElementGetResponse();
        ipfDmlElementGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlElementGetResponse.setResultJson(ipfDmlElement);
        return ipfDmlElementGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlElementSelectAllRequest request) {
        IpfDmlElementSelectAllResponse ipfDmlElementSelectAllResponse = new IpfDmlElementSelectAllResponse();
        ipfDmlElementSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlElementSelectAllResponse.setResultJson(ipfDmlElementService.selectAll());
        return ipfDmlElementSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlElementCountAllRequest request) {
        IpfDmlElementCountAllResponse ipfDmlElementCountAllResponse = new IpfDmlElementCountAllResponse();
        ipfDmlElementCountAllResponse.setResultString(String.valueOf(ipfDmlElementService.countAll()));
        ipfDmlElementCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlElementCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlElementSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlElementSelectAllResponse ipfDmlElementSelectAllResponse = new IpfDmlElementSelectAllResponse();
        ipfDmlElementSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlElementSelectAllResponse.setResultJson(ipfDmlElementService.selectBySql(sqlstr));
        return ipfDmlElementSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.selectIpfDmlElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlElementSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlElement_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlElement ipfDmlElement=new IpfDmlElement();
        ipfDmlElement.setId(request.getId());
        ipfDmlElement.setElementCode(request.getElementCode());
        ipfDmlElement.setFieldText(request.getFieldText());
        ipfDmlElement.setDataType(request.getDataType());
        ipfDmlElement.setFieldLength(request.getFieldLength());
        ipfDmlElement.setDecimals(request.getDecimals());
    	IpfDmlElementSelectResponse ipfDmlElementSelectResponse = new IpfDmlElementSelectResponse();
        ipfDmlElementSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlElement> ipfDmlElements= ipfDmlElementService.selectWithCondition(ipfDmlElement);
        ipfDmlElementSelectResponse.setResultJson(ipfDmlElements);
        return ipfDmlElementSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElement.isExistIpfDmlElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlElement(IpfDmlElementSelectRequest request) {
        IpfDmlElement ipfDmlElement=new IpfDmlElement();
        ipfDmlElement.setId(request.getId());
        ipfDmlElement.setElementCode(request.getElementCode());
        ipfDmlElement.setFieldText(request.getFieldText());
        ipfDmlElement.setDataType(request.getDataType());
        ipfDmlElement.setFieldLength(request.getFieldLength());
        ipfDmlElement.setDecimals(request.getDecimals());
        ArrayList<IpfDmlElement> ipfDmlElements= ipfDmlElementService.selectWithCondition(ipfDmlElement);
    	IpfDmlElementCountAllResponse ipfDmlElementCountAllResponse = new IpfDmlElementCountAllResponse();
        if (ipfDmlElements.size()>0){
        	ipfDmlElementCountAllResponse.setResultString("1");
        } else {
        	ipfDmlElementCountAllResponse.setResultString("0");
        }        
        return ipfDmlElementCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlElementCreateRequest request){
    	IpfDmlElement ipfDmlElement=new IpfDmlElement();
    	ipfDmlElement.setId(request.getId());
        ArrayList<IpfDmlElement> ipfDmlElements= ipfDmlElementService.selectWithCondition(ipfDmlElement);
        if (ipfDmlElements!=null&&ipfDmlElements.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlElementUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlElementDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlElementSelectRequest request){
        return  true;
     }    
}
