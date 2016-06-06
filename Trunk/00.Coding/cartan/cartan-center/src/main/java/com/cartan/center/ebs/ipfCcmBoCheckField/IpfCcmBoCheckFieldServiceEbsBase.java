/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoCheckField;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoCheckField.request.*;
import com.cartan.center.ebs.ipfCcmBoCheckField.response.*;
import com.cartan.core.ipfCcmBoCheckField.domain.IpfCcmBoCheckField;
import com.cartan.core.ipfCcmBoCheckField.service.IpfCcmBoCheckFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoCheckFieldServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoCheckFieldServiceEbs.class.getName());
	private IpfCcmBoCheckFieldService  ipfCcmBoCheckFieldService;
	
    public IpfCcmBoCheckFieldService getIpfCcmBoCheckFieldService() {
        return ipfCcmBoCheckFieldService;
    }

    @Autowired
    public void setIpfCcmBoCheckFieldService(IpfCcmBoCheckFieldService ipfCcmBoCheckFieldService) {
        this.ipfCcmBoCheckFieldService = ipfCcmBoCheckFieldService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoCheckFieldGetSessionRequest request) {      
    	IpfCcmBoCheckFieldGetSessionResponse ipfCcmBoCheckFieldGetSessionResponse = new IpfCcmBoCheckFieldGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoCheckFieldGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoCheckFieldGetSessionResponse.setResultString("1");
            ipfCcmBoCheckFieldGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoCheckFieldGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoCheckFieldGetSessionRequest request) {
    	IpfCcmBoCheckFieldGetSessionResponse ipfCcmBoCheckFieldGetSessionResponse = new IpfCcmBoCheckFieldGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoCheckFieldGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoCheckFieldGetSessionResponse.setResultString("0");
        }
        ipfCcmBoCheckFieldGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoCheckFieldGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoCheckFieldGetSessionRequest request) {
    	IpfCcmBoCheckFieldGetSessionResponse ipfCcmBoCheckFieldGetSessionResponse = new IpfCcmBoCheckFieldGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoCheckFieldGetSessionResponse.setResultString("0");
        	ipfCcmBoCheckFieldGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoCheckFieldGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoCheckFieldGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.createIpfCcmBoCheckField", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoCheckField(IpfCcmBoCheckFieldCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoCheckField_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheckField ipfCcmBoCheckField=new IpfCcmBoCheckField();
        ipfCcmBoCheckField.setId(request.getId());    		
        ipfCcmBoCheckField.setIpfCcmBoCheckId(request.getIpfCcmBoCheckId());
        ipfCcmBoCheckField.setPropertyId(request.getPropertyId());
        ipfCcmBoCheckField.setPropertyName(request.getPropertyName());
        ipfCcmBoCheckField.setPropertyDesc(request.getPropertyDesc());
        ipfCcmBoCheckField.setBoName(request.getBoName());
        ipfCcmBoCheckField.setSeqNo(request.getSeqNo());
    	ipfCcmBoCheckFieldService.createIpfCcmBoCheckField(ipfCcmBoCheckField);
        //返回响应
        IpfCcmBoCheckFieldCreateResponse ipfCcmBoCheckFieldCreateResponse = new IpfCcmBoCheckFieldCreateResponse();
        ipfCcmBoCheckFieldCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckFieldCreateResponse.setResultJson(ipfCcmBoCheckField);
        return ipfCcmBoCheckFieldCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.deleteIpfCcmBoCheckField", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoCheckField(IpfCcmBoCheckFieldDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoCheckField_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoCheckFieldService.deleteIpfCcmBoCheckField(idstr);
        //返回响应
        IpfCcmBoCheckFieldDeleteResponse ipfCcmBoCheckFieldDeleteResponse = new IpfCcmBoCheckFieldDeleteResponse();
        ipfCcmBoCheckFieldDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoCheckFieldDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.updateIpfCcmBoCheckField", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoCheckField(IpfCcmBoCheckFieldUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoCheckField_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheckField ipfCcmBoCheckField=new IpfCcmBoCheckField();
        ipfCcmBoCheckField=ipfCcmBoCheckFieldService.getIpfCcmBoCheckField(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoCheckField.setId(request.getId());
        }
        if (request.getIpfCcmBoCheckId()!=null){
	        ipfCcmBoCheckField.setIpfCcmBoCheckId(request.getIpfCcmBoCheckId());
        }
        if (request.getPropertyId()!=null){
	        ipfCcmBoCheckField.setPropertyId(request.getPropertyId());
        }
        if (request.getPropertyName()!=null){
	        ipfCcmBoCheckField.setPropertyName(request.getPropertyName());
        }
        if (request.getPropertyDesc()!=null){
	        ipfCcmBoCheckField.setPropertyDesc(request.getPropertyDesc());
        }
        if (request.getBoName()!=null){
	        ipfCcmBoCheckField.setBoName(request.getBoName());
        }
        if (request.getSeqNo()!=null){
	        ipfCcmBoCheckField.setSeqNo(request.getSeqNo());
        }
    	ipfCcmBoCheckFieldService.updateIpfCcmBoCheckField(ipfCcmBoCheckField);
        //返回响应
        IpfCcmBoCheckFieldUpdateResponse ipfCcmBoCheckFieldUpdateResponse = new IpfCcmBoCheckFieldUpdateResponse();
        ipfCcmBoCheckFieldUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckFieldUpdateResponse.setResultJson(ipfCcmBoCheckField);
        return ipfCcmBoCheckFieldUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.getIpfCcmBoCheckField", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoCheckField(IpfCcmBoCheckFieldGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoCheckField ipfCcmBoCheckField=new IpfCcmBoCheckField();
        ipfCcmBoCheckField=ipfCcmBoCheckFieldService.getIpfCcmBoCheckField(id);
        //返回响应
        IpfCcmBoCheckFieldGetResponse ipfCcmBoCheckFieldGetResponse = new IpfCcmBoCheckFieldGetResponse();
        ipfCcmBoCheckFieldGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckFieldGetResponse.setResultJson(ipfCcmBoCheckField);
        return ipfCcmBoCheckFieldGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoCheckFieldSelectAllRequest request) {
        IpfCcmBoCheckFieldSelectAllResponse ipfCcmBoCheckFieldSelectAllResponse = new IpfCcmBoCheckFieldSelectAllResponse();
        ipfCcmBoCheckFieldSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckFieldSelectAllResponse.setResultJson(ipfCcmBoCheckFieldService.selectAll());
        return ipfCcmBoCheckFieldSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoCheckFieldCountAllRequest request) {
        IpfCcmBoCheckFieldCountAllResponse ipfCcmBoCheckFieldCountAllResponse = new IpfCcmBoCheckFieldCountAllResponse();
        ipfCcmBoCheckFieldCountAllResponse.setResultString(String.valueOf(ipfCcmBoCheckFieldService.countAll()));
        ipfCcmBoCheckFieldCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoCheckFieldCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoCheckFieldSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoCheckFieldSelectAllResponse ipfCcmBoCheckFieldSelectAllResponse = new IpfCcmBoCheckFieldSelectAllResponse();
        ipfCcmBoCheckFieldSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckFieldSelectAllResponse.setResultJson(ipfCcmBoCheckFieldService.selectBySql(sqlstr));
        return ipfCcmBoCheckFieldSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.selectIpfCcmBoCheckField", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoCheckFieldSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoCheckField_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheckField ipfCcmBoCheckField=new IpfCcmBoCheckField();
        ipfCcmBoCheckField.setId(request.getId());
        ipfCcmBoCheckField.setIpfCcmBoCheckId(request.getIpfCcmBoCheckId());
        ipfCcmBoCheckField.setPropertyId(request.getPropertyId());
        ipfCcmBoCheckField.setPropertyName(request.getPropertyName());
        ipfCcmBoCheckField.setPropertyDesc(request.getPropertyDesc());
        ipfCcmBoCheckField.setBoName(request.getBoName());
        ipfCcmBoCheckField.setSeqNo(request.getSeqNo());
    	IpfCcmBoCheckFieldSelectResponse ipfCcmBoCheckFieldSelectResponse = new IpfCcmBoCheckFieldSelectResponse();
        ipfCcmBoCheckFieldSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoCheckField> ipfCcmBoCheckFields= ipfCcmBoCheckFieldService.selectWithCondition(ipfCcmBoCheckField);
        ipfCcmBoCheckFieldSelectResponse.setResultJson(ipfCcmBoCheckFields);
        return ipfCcmBoCheckFieldSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckField.isExistIpfCcmBoCheckField", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoCheckField(IpfCcmBoCheckFieldSelectRequest request) {
        IpfCcmBoCheckField ipfCcmBoCheckField=new IpfCcmBoCheckField();
        ipfCcmBoCheckField.setId(request.getId());
        ipfCcmBoCheckField.setIpfCcmBoCheckId(request.getIpfCcmBoCheckId());
        ipfCcmBoCheckField.setPropertyId(request.getPropertyId());
        ipfCcmBoCheckField.setPropertyName(request.getPropertyName());
        ipfCcmBoCheckField.setPropertyDesc(request.getPropertyDesc());
        ipfCcmBoCheckField.setBoName(request.getBoName());
        ipfCcmBoCheckField.setSeqNo(request.getSeqNo());
        ArrayList<IpfCcmBoCheckField> ipfCcmBoCheckFields= ipfCcmBoCheckFieldService.selectWithCondition(ipfCcmBoCheckField);
    	IpfCcmBoCheckFieldCountAllResponse ipfCcmBoCheckFieldCountAllResponse = new IpfCcmBoCheckFieldCountAllResponse();
        if (ipfCcmBoCheckFields.size()>0){
        	ipfCcmBoCheckFieldCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoCheckFieldCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoCheckFieldCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoCheckFieldCreateRequest request){
    	IpfCcmBoCheckField ipfCcmBoCheckField=new IpfCcmBoCheckField();
    	ipfCcmBoCheckField.setId(request.getId());
        ArrayList<IpfCcmBoCheckField> ipfCcmBoCheckFields= ipfCcmBoCheckFieldService.selectWithCondition(ipfCcmBoCheckField);
        if (ipfCcmBoCheckFields!=null&&ipfCcmBoCheckFields.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoCheckFieldUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoCheckFieldDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoCheckFieldSelectRequest request){
        return  true;
     }    
}
