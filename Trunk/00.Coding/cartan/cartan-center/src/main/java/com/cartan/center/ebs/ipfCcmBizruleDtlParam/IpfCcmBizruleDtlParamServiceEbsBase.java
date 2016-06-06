/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBizruleDtlParam;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBizruleDtlParam.request.*;
import com.cartan.center.ebs.ipfCcmBizruleDtlParam.response.*;
import com.cartan.core.ipfCcmBizruleDtlParam.domain.IpfCcmBizruleDtlParam;
import com.cartan.core.ipfCcmBizruleDtlParam.service.IpfCcmBizruleDtlParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBizruleDtlParamServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBizruleDtlParamServiceEbs.class.getName());
	private IpfCcmBizruleDtlParamService  ipfCcmBizruleDtlParamService;
	
    public IpfCcmBizruleDtlParamService getIpfCcmBizruleDtlParamService() {
        return ipfCcmBizruleDtlParamService;
    }

    @Autowired
    public void setIpfCcmBizruleDtlParamService(IpfCcmBizruleDtlParamService ipfCcmBizruleDtlParamService) {
        this.ipfCcmBizruleDtlParamService = ipfCcmBizruleDtlParamService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBizruleDtlParamGetSessionRequest request) {      
    	IpfCcmBizruleDtlParamGetSessionResponse ipfCcmBizruleDtlParamGetSessionResponse = new IpfCcmBizruleDtlParamGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBizruleDtlParamGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBizruleDtlParamGetSessionResponse.setResultString("1");
            ipfCcmBizruleDtlParamGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBizruleDtlParamGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBizruleDtlParamGetSessionRequest request) {
    	IpfCcmBizruleDtlParamGetSessionResponse ipfCcmBizruleDtlParamGetSessionResponse = new IpfCcmBizruleDtlParamGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBizruleDtlParamGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBizruleDtlParamGetSessionResponse.setResultString("0");
        }
        ipfCcmBizruleDtlParamGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBizruleDtlParamGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBizruleDtlParamGetSessionRequest request) {
    	IpfCcmBizruleDtlParamGetSessionResponse ipfCcmBizruleDtlParamGetSessionResponse = new IpfCcmBizruleDtlParamGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBizruleDtlParamGetSessionResponse.setResultString("0");
        	ipfCcmBizruleDtlParamGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBizruleDtlParamGetSessionResponse.setResultString("1");
        }
        return ipfCcmBizruleDtlParamGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.createIpfCcmBizruleDtlParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBizruleDtlParam(IpfCcmBizruleDtlParamCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBizruleDtlParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam=new IpfCcmBizruleDtlParam();
        ipfCcmBizruleDtlParam.setId(request.getId());    		
        ipfCcmBizruleDtlParam.setIpfCcmBizruleId(request.getIpfCcmBizruleId());
        ipfCcmBizruleDtlParam.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        ipfCcmBizruleDtlParam.setIpfCcmStrategyParamId(request.getIpfCcmStrategyParamId());
        ipfCcmBizruleDtlParam.setParamName(request.getParamName());
        ipfCcmBizruleDtlParam.setParamDes(request.getParamDes());
        ipfCcmBizruleDtlParam.setParamValue(request.getParamValue());
        ipfCcmBizruleDtlParam.setParamValueDes(request.getParamValueDes());
    	ipfCcmBizruleDtlParamService.createIpfCcmBizruleDtlParam(ipfCcmBizruleDtlParam);
        //返回响应
        IpfCcmBizruleDtlParamCreateResponse ipfCcmBizruleDtlParamCreateResponse = new IpfCcmBizruleDtlParamCreateResponse();
        ipfCcmBizruleDtlParamCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleDtlParamCreateResponse.setResultJson(ipfCcmBizruleDtlParam);
        return ipfCcmBizruleDtlParamCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.deleteIpfCcmBizruleDtlParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBizruleDtlParam(IpfCcmBizruleDtlParamDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBizruleDtlParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBizruleDtlParamService.deleteIpfCcmBizruleDtlParam(idstr);
        //返回响应
        IpfCcmBizruleDtlParamDeleteResponse ipfCcmBizruleDtlParamDeleteResponse = new IpfCcmBizruleDtlParamDeleteResponse();
        ipfCcmBizruleDtlParamDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBizruleDtlParamDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.updateIpfCcmBizruleDtlParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBizruleDtlParam(IpfCcmBizruleDtlParamUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBizruleDtlParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam=new IpfCcmBizruleDtlParam();
        ipfCcmBizruleDtlParam=ipfCcmBizruleDtlParamService.getIpfCcmBizruleDtlParam(request.getId());
        if (request.getId()!=null){
	        ipfCcmBizruleDtlParam.setId(request.getId());
        }
        if (request.getIpfCcmBizruleId()!=null){
	        ipfCcmBizruleDtlParam.setIpfCcmBizruleId(request.getIpfCcmBizruleId());
        }
        if (request.getIpfCcmStrategyId()!=null){
	        ipfCcmBizruleDtlParam.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        }
        if (request.getIpfCcmStrategyParamId()!=null){
	        ipfCcmBizruleDtlParam.setIpfCcmStrategyParamId(request.getIpfCcmStrategyParamId());
        }
        if (request.getParamName()!=null){
	        ipfCcmBizruleDtlParam.setParamName(request.getParamName());
        }
        if (request.getParamDes()!=null){
	        ipfCcmBizruleDtlParam.setParamDes(request.getParamDes());
        }
        if (request.getParamValue()!=null){
	        ipfCcmBizruleDtlParam.setParamValue(request.getParamValue());
        }
        if (request.getParamValueDes()!=null){
	        ipfCcmBizruleDtlParam.setParamValueDes(request.getParamValueDes());
        }
    	ipfCcmBizruleDtlParamService.updateIpfCcmBizruleDtlParam(ipfCcmBizruleDtlParam);
        //返回响应
        IpfCcmBizruleDtlParamUpdateResponse ipfCcmBizruleDtlParamUpdateResponse = new IpfCcmBizruleDtlParamUpdateResponse();
        ipfCcmBizruleDtlParamUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleDtlParamUpdateResponse.setResultJson(ipfCcmBizruleDtlParam);
        return ipfCcmBizruleDtlParamUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.getIpfCcmBizruleDtlParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBizruleDtlParam(IpfCcmBizruleDtlParamGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam=new IpfCcmBizruleDtlParam();
        ipfCcmBizruleDtlParam=ipfCcmBizruleDtlParamService.getIpfCcmBizruleDtlParam(id);
        //返回响应
        IpfCcmBizruleDtlParamGetResponse ipfCcmBizruleDtlParamGetResponse = new IpfCcmBizruleDtlParamGetResponse();
        ipfCcmBizruleDtlParamGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleDtlParamGetResponse.setResultJson(ipfCcmBizruleDtlParam);
        return ipfCcmBizruleDtlParamGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBizruleDtlParamSelectAllRequest request) {
        IpfCcmBizruleDtlParamSelectAllResponse ipfCcmBizruleDtlParamSelectAllResponse = new IpfCcmBizruleDtlParamSelectAllResponse();
        ipfCcmBizruleDtlParamSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleDtlParamSelectAllResponse.setResultJson(ipfCcmBizruleDtlParamService.selectAll());
        return ipfCcmBizruleDtlParamSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBizruleDtlParamCountAllRequest request) {
        IpfCcmBizruleDtlParamCountAllResponse ipfCcmBizruleDtlParamCountAllResponse = new IpfCcmBizruleDtlParamCountAllResponse();
        ipfCcmBizruleDtlParamCountAllResponse.setResultString(String.valueOf(ipfCcmBizruleDtlParamService.countAll()));
        ipfCcmBizruleDtlParamCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBizruleDtlParamCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBizruleDtlParamSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBizruleDtlParamSelectAllResponse ipfCcmBizruleDtlParamSelectAllResponse = new IpfCcmBizruleDtlParamSelectAllResponse();
        ipfCcmBizruleDtlParamSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleDtlParamSelectAllResponse.setResultJson(ipfCcmBizruleDtlParamService.selectBySql(sqlstr));
        return ipfCcmBizruleDtlParamSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.selectIpfCcmBizruleDtlParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBizruleDtlParamSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBizruleDtlParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam=new IpfCcmBizruleDtlParam();
        ipfCcmBizruleDtlParam.setId(request.getId());
        ipfCcmBizruleDtlParam.setIpfCcmBizruleId(request.getIpfCcmBizruleId());
        ipfCcmBizruleDtlParam.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        ipfCcmBizruleDtlParam.setIpfCcmStrategyParamId(request.getIpfCcmStrategyParamId());
        ipfCcmBizruleDtlParam.setParamName(request.getParamName());
        ipfCcmBizruleDtlParam.setParamDes(request.getParamDes());
        ipfCcmBizruleDtlParam.setParamValue(request.getParamValue());
        ipfCcmBizruleDtlParam.setParamValueDes(request.getParamValueDes());
    	IpfCcmBizruleDtlParamSelectResponse ipfCcmBizruleDtlParamSelectResponse = new IpfCcmBizruleDtlParamSelectResponse();
        ipfCcmBizruleDtlParamSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBizruleDtlParam> ipfCcmBizruleDtlParams= ipfCcmBizruleDtlParamService.selectWithCondition(ipfCcmBizruleDtlParam);
        ipfCcmBizruleDtlParamSelectResponse.setResultJson(ipfCcmBizruleDtlParams);
        return ipfCcmBizruleDtlParamSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtlParam.isExistIpfCcmBizruleDtlParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBizruleDtlParam(IpfCcmBizruleDtlParamSelectRequest request) {
        IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam=new IpfCcmBizruleDtlParam();
        ipfCcmBizruleDtlParam.setId(request.getId());
        ipfCcmBizruleDtlParam.setIpfCcmBizruleId(request.getIpfCcmBizruleId());
        ipfCcmBizruleDtlParam.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        ipfCcmBizruleDtlParam.setIpfCcmStrategyParamId(request.getIpfCcmStrategyParamId());
        ipfCcmBizruleDtlParam.setParamName(request.getParamName());
        ipfCcmBizruleDtlParam.setParamDes(request.getParamDes());
        ipfCcmBizruleDtlParam.setParamValue(request.getParamValue());
        ipfCcmBizruleDtlParam.setParamValueDes(request.getParamValueDes());
        ArrayList<IpfCcmBizruleDtlParam> ipfCcmBizruleDtlParams= ipfCcmBizruleDtlParamService.selectWithCondition(ipfCcmBizruleDtlParam);
    	IpfCcmBizruleDtlParamCountAllResponse ipfCcmBizruleDtlParamCountAllResponse = new IpfCcmBizruleDtlParamCountAllResponse();
        if (ipfCcmBizruleDtlParams.size()>0){
        	ipfCcmBizruleDtlParamCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBizruleDtlParamCountAllResponse.setResultString("0");
        }        
        return ipfCcmBizruleDtlParamCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBizruleDtlParamCreateRequest request){
    	IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam=new IpfCcmBizruleDtlParam();
    	ipfCcmBizruleDtlParam.setId(request.getId());
        ArrayList<IpfCcmBizruleDtlParam> ipfCcmBizruleDtlParams= ipfCcmBizruleDtlParamService.selectWithCondition(ipfCcmBizruleDtlParam);
        if (ipfCcmBizruleDtlParams!=null&&ipfCcmBizruleDtlParams.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBizruleDtlParamUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBizruleDtlParamDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBizruleDtlParamSelectRequest request){
        return  true;
     }    
}
