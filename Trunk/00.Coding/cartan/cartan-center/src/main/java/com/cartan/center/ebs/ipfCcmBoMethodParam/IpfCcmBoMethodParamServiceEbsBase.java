/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoMethodParam;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoMethodParam.request.*;
import com.cartan.center.ebs.ipfCcmBoMethodParam.response.*;
import com.cartan.core.ipfCcmBoMethodParam.domain.IpfCcmBoMethodParam;
import com.cartan.core.ipfCcmBoMethodParam.service.IpfCcmBoMethodParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoMethodParamServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoMethodParamServiceEbs.class.getName());
	private IpfCcmBoMethodParamService  ipfCcmBoMethodParamService;
	
    public IpfCcmBoMethodParamService getIpfCcmBoMethodParamService() {
        return ipfCcmBoMethodParamService;
    }

    @Autowired
    public void setIpfCcmBoMethodParamService(IpfCcmBoMethodParamService ipfCcmBoMethodParamService) {
        this.ipfCcmBoMethodParamService = ipfCcmBoMethodParamService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoMethodParamGetSessionRequest request) {      
    	IpfCcmBoMethodParamGetSessionResponse ipfCcmBoMethodParamGetSessionResponse = new IpfCcmBoMethodParamGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoMethodParamGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoMethodParamGetSessionResponse.setResultString("1");
            ipfCcmBoMethodParamGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoMethodParamGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoMethodParamGetSessionRequest request) {
    	IpfCcmBoMethodParamGetSessionResponse ipfCcmBoMethodParamGetSessionResponse = new IpfCcmBoMethodParamGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoMethodParamGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoMethodParamGetSessionResponse.setResultString("0");
        }
        ipfCcmBoMethodParamGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoMethodParamGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoMethodParamGetSessionRequest request) {
    	IpfCcmBoMethodParamGetSessionResponse ipfCcmBoMethodParamGetSessionResponse = new IpfCcmBoMethodParamGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoMethodParamGetSessionResponse.setResultString("0");
        	ipfCcmBoMethodParamGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoMethodParamGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoMethodParamGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.createIpfCcmBoMethodParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoMethodParam(IpfCcmBoMethodParamCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoMethodParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoMethodParam ipfCcmBoMethodParam=new IpfCcmBoMethodParam();
        ipfCcmBoMethodParam.setId(request.getId());    		
        ipfCcmBoMethodParam.setIpfCcmBoMethodId(request.getIpfCcmBoMethodId());
        ipfCcmBoMethodParam.setConstantValue(request.getConstantValue());
        ipfCcmBoMethodParam.setIsCondition(request.getIsCondition());
        ipfCcmBoMethodParam.setMethodName(request.getMethodName());
        ipfCcmBoMethodParam.setParamName(request.getParamName());
        ipfCcmBoMethodParam.setParamRef(request.getParamRef());
        ipfCcmBoMethodParam.setParamType(request.getParamType());
        ipfCcmBoMethodParam.setBoNameRef(request.getBoNameRef());
    	ipfCcmBoMethodParamService.createIpfCcmBoMethodParam(ipfCcmBoMethodParam);
        //返回响应
        IpfCcmBoMethodParamCreateResponse ipfCcmBoMethodParamCreateResponse = new IpfCcmBoMethodParamCreateResponse();
        ipfCcmBoMethodParamCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodParamCreateResponse.setResultJson(ipfCcmBoMethodParam);
        return ipfCcmBoMethodParamCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.deleteIpfCcmBoMethodParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoMethodParam(IpfCcmBoMethodParamDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoMethodParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoMethodParamService.deleteIpfCcmBoMethodParam(idstr);
        //返回响应
        IpfCcmBoMethodParamDeleteResponse ipfCcmBoMethodParamDeleteResponse = new IpfCcmBoMethodParamDeleteResponse();
        ipfCcmBoMethodParamDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoMethodParamDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.updateIpfCcmBoMethodParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoMethodParam(IpfCcmBoMethodParamUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoMethodParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoMethodParam ipfCcmBoMethodParam=new IpfCcmBoMethodParam();
        ipfCcmBoMethodParam=ipfCcmBoMethodParamService.getIpfCcmBoMethodParam(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoMethodParam.setId(request.getId());
        }
        if (request.getIpfCcmBoMethodId()!=null){
	        ipfCcmBoMethodParam.setIpfCcmBoMethodId(request.getIpfCcmBoMethodId());
        }
        if (request.getConstantValue()!=null){
	        ipfCcmBoMethodParam.setConstantValue(request.getConstantValue());
        }
        if (request.getIsCondition()!=null){
	        ipfCcmBoMethodParam.setIsCondition(request.getIsCondition());
        }
        if (request.getMethodName()!=null){
	        ipfCcmBoMethodParam.setMethodName(request.getMethodName());
        }
        if (request.getParamName()!=null){
	        ipfCcmBoMethodParam.setParamName(request.getParamName());
        }
        if (request.getParamRef()!=null){
	        ipfCcmBoMethodParam.setParamRef(request.getParamRef());
        }
        if (request.getParamType()!=null){
	        ipfCcmBoMethodParam.setParamType(request.getParamType());
        }
        if (request.getBoNameRef()!=null){
	        ipfCcmBoMethodParam.setBoNameRef(request.getBoNameRef());
        }
    	ipfCcmBoMethodParamService.updateIpfCcmBoMethodParam(ipfCcmBoMethodParam);
        //返回响应
        IpfCcmBoMethodParamUpdateResponse ipfCcmBoMethodParamUpdateResponse = new IpfCcmBoMethodParamUpdateResponse();
        ipfCcmBoMethodParamUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodParamUpdateResponse.setResultJson(ipfCcmBoMethodParam);
        return ipfCcmBoMethodParamUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.getIpfCcmBoMethodParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoMethodParam(IpfCcmBoMethodParamGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoMethodParam ipfCcmBoMethodParam=new IpfCcmBoMethodParam();
        ipfCcmBoMethodParam=ipfCcmBoMethodParamService.getIpfCcmBoMethodParam(id);
        //返回响应
        IpfCcmBoMethodParamGetResponse ipfCcmBoMethodParamGetResponse = new IpfCcmBoMethodParamGetResponse();
        ipfCcmBoMethodParamGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodParamGetResponse.setResultJson(ipfCcmBoMethodParam);
        return ipfCcmBoMethodParamGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoMethodParamSelectAllRequest request) {
        IpfCcmBoMethodParamSelectAllResponse ipfCcmBoMethodParamSelectAllResponse = new IpfCcmBoMethodParamSelectAllResponse();
        ipfCcmBoMethodParamSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodParamSelectAllResponse.setResultJson(ipfCcmBoMethodParamService.selectAll());
        return ipfCcmBoMethodParamSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoMethodParamCountAllRequest request) {
        IpfCcmBoMethodParamCountAllResponse ipfCcmBoMethodParamCountAllResponse = new IpfCcmBoMethodParamCountAllResponse();
        ipfCcmBoMethodParamCountAllResponse.setResultString(String.valueOf(ipfCcmBoMethodParamService.countAll()));
        ipfCcmBoMethodParamCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoMethodParamCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoMethodParamSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoMethodParamSelectAllResponse ipfCcmBoMethodParamSelectAllResponse = new IpfCcmBoMethodParamSelectAllResponse();
        ipfCcmBoMethodParamSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoMethodParamSelectAllResponse.setResultJson(ipfCcmBoMethodParamService.selectBySql(sqlstr));
        return ipfCcmBoMethodParamSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.selectIpfCcmBoMethodParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoMethodParamSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoMethodParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoMethodParam ipfCcmBoMethodParam=new IpfCcmBoMethodParam();
        ipfCcmBoMethodParam.setId(request.getId());
        ipfCcmBoMethodParam.setIpfCcmBoMethodId(request.getIpfCcmBoMethodId());
        ipfCcmBoMethodParam.setConstantValue(request.getConstantValue());
        ipfCcmBoMethodParam.setIsCondition(request.getIsCondition());
        ipfCcmBoMethodParam.setMethodName(request.getMethodName());
        ipfCcmBoMethodParam.setParamName(request.getParamName());
        ipfCcmBoMethodParam.setParamRef(request.getParamRef());
        ipfCcmBoMethodParam.setParamType(request.getParamType());
        ipfCcmBoMethodParam.setBoNameRef(request.getBoNameRef());
    	IpfCcmBoMethodParamSelectResponse ipfCcmBoMethodParamSelectResponse = new IpfCcmBoMethodParamSelectResponse();
        ipfCcmBoMethodParamSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoMethodParam> ipfCcmBoMethodParams= ipfCcmBoMethodParamService.selectWithCondition(ipfCcmBoMethodParam);
        ipfCcmBoMethodParamSelectResponse.setResultJson(ipfCcmBoMethodParams);
        return ipfCcmBoMethodParamSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoMethodParam.isExistIpfCcmBoMethodParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoMethodParam(IpfCcmBoMethodParamSelectRequest request) {
        IpfCcmBoMethodParam ipfCcmBoMethodParam=new IpfCcmBoMethodParam();
        ipfCcmBoMethodParam.setId(request.getId());
        ipfCcmBoMethodParam.setIpfCcmBoMethodId(request.getIpfCcmBoMethodId());
        ipfCcmBoMethodParam.setConstantValue(request.getConstantValue());
        ipfCcmBoMethodParam.setIsCondition(request.getIsCondition());
        ipfCcmBoMethodParam.setMethodName(request.getMethodName());
        ipfCcmBoMethodParam.setParamName(request.getParamName());
        ipfCcmBoMethodParam.setParamRef(request.getParamRef());
        ipfCcmBoMethodParam.setParamType(request.getParamType());
        ipfCcmBoMethodParam.setBoNameRef(request.getBoNameRef());
        ArrayList<IpfCcmBoMethodParam> ipfCcmBoMethodParams= ipfCcmBoMethodParamService.selectWithCondition(ipfCcmBoMethodParam);
    	IpfCcmBoMethodParamCountAllResponse ipfCcmBoMethodParamCountAllResponse = new IpfCcmBoMethodParamCountAllResponse();
        if (ipfCcmBoMethodParams.size()>0){
        	ipfCcmBoMethodParamCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoMethodParamCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoMethodParamCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoMethodParamCreateRequest request){
    	IpfCcmBoMethodParam ipfCcmBoMethodParam=new IpfCcmBoMethodParam();
    	ipfCcmBoMethodParam.setId(request.getId());
        ArrayList<IpfCcmBoMethodParam> ipfCcmBoMethodParams= ipfCcmBoMethodParamService.selectWithCondition(ipfCcmBoMethodParam);
        if (ipfCcmBoMethodParams!=null&&ipfCcmBoMethodParams.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoMethodParamUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoMethodParamDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoMethodParamSelectRequest request){
        return  true;
     }    
}
