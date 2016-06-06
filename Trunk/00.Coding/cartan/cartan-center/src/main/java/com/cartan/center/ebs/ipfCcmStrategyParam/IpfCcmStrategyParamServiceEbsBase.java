/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmStrategyParam;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmStrategyParam.request.*;
import com.cartan.center.ebs.ipfCcmStrategyParam.response.*;
import com.cartan.core.ipfCcmStrategyParam.domain.IpfCcmStrategyParam;
import com.cartan.core.ipfCcmStrategyParam.service.IpfCcmStrategyParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmStrategyParamServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmStrategyParamServiceEbs.class.getName());
	private IpfCcmStrategyParamService  ipfCcmStrategyParamService;
	
    public IpfCcmStrategyParamService getIpfCcmStrategyParamService() {
        return ipfCcmStrategyParamService;
    }

    @Autowired
    public void setIpfCcmStrategyParamService(IpfCcmStrategyParamService ipfCcmStrategyParamService) {
        this.ipfCcmStrategyParamService = ipfCcmStrategyParamService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmStrategyParamGetSessionRequest request) {      
    	IpfCcmStrategyParamGetSessionResponse ipfCcmStrategyParamGetSessionResponse = new IpfCcmStrategyParamGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmStrategyParamGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmStrategyParamGetSessionResponse.setResultString("1");
            ipfCcmStrategyParamGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmStrategyParamGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmStrategyParamGetSessionRequest request) {
    	IpfCcmStrategyParamGetSessionResponse ipfCcmStrategyParamGetSessionResponse = new IpfCcmStrategyParamGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmStrategyParamGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmStrategyParamGetSessionResponse.setResultString("0");
        }
        ipfCcmStrategyParamGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmStrategyParamGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmStrategyParamGetSessionRequest request) {
    	IpfCcmStrategyParamGetSessionResponse ipfCcmStrategyParamGetSessionResponse = new IpfCcmStrategyParamGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmStrategyParamGetSessionResponse.setResultString("0");
        	ipfCcmStrategyParamGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmStrategyParamGetSessionResponse.setResultString("1");
        }
        return ipfCcmStrategyParamGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.createIpfCcmStrategyParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmStrategyParam(IpfCcmStrategyParamCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmStrategyParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmStrategyParam ipfCcmStrategyParam=new IpfCcmStrategyParam();
        ipfCcmStrategyParam.setId(request.getId());    		
        ipfCcmStrategyParam.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        ipfCcmStrategyParam.setParamType(request.getParamType());
        ipfCcmStrategyParam.setParamName(request.getParamName());
        ipfCcmStrategyParam.setParamDes(request.getParamDes());
        ipfCcmStrategyParam.setRtmConfigCode(request.getRtmConfigCode());
    	ipfCcmStrategyParamService.createIpfCcmStrategyParam(ipfCcmStrategyParam);
        //返回响应
        IpfCcmStrategyParamCreateResponse ipfCcmStrategyParamCreateResponse = new IpfCcmStrategyParamCreateResponse();
        ipfCcmStrategyParamCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmStrategyParamCreateResponse.setResultJson(ipfCcmStrategyParam);
        return ipfCcmStrategyParamCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.deleteIpfCcmStrategyParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmStrategyParam(IpfCcmStrategyParamDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmStrategyParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmStrategyParamService.deleteIpfCcmStrategyParam(idstr);
        //返回响应
        IpfCcmStrategyParamDeleteResponse ipfCcmStrategyParamDeleteResponse = new IpfCcmStrategyParamDeleteResponse();
        ipfCcmStrategyParamDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmStrategyParamDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.updateIpfCcmStrategyParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmStrategyParam(IpfCcmStrategyParamUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmStrategyParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmStrategyParam ipfCcmStrategyParam=new IpfCcmStrategyParam();
        ipfCcmStrategyParam=ipfCcmStrategyParamService.getIpfCcmStrategyParam(request.getId());
        if (request.getId()!=null){
	        ipfCcmStrategyParam.setId(request.getId());
        }
        if (request.getIpfCcmStrategyId()!=null){
	        ipfCcmStrategyParam.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        }
        if (request.getParamType()!=null){
	        ipfCcmStrategyParam.setParamType(request.getParamType());
        }
        if (request.getParamName()!=null){
	        ipfCcmStrategyParam.setParamName(request.getParamName());
        }
        if (request.getParamDes()!=null){
	        ipfCcmStrategyParam.setParamDes(request.getParamDes());
        }
        if (request.getRtmConfigCode()!=null){
	        ipfCcmStrategyParam.setRtmConfigCode(request.getRtmConfigCode());
        }
    	ipfCcmStrategyParamService.updateIpfCcmStrategyParam(ipfCcmStrategyParam);
        //返回响应
        IpfCcmStrategyParamUpdateResponse ipfCcmStrategyParamUpdateResponse = new IpfCcmStrategyParamUpdateResponse();
        ipfCcmStrategyParamUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmStrategyParamUpdateResponse.setResultJson(ipfCcmStrategyParam);
        return ipfCcmStrategyParamUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.getIpfCcmStrategyParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmStrategyParam(IpfCcmStrategyParamGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmStrategyParam ipfCcmStrategyParam=new IpfCcmStrategyParam();
        ipfCcmStrategyParam=ipfCcmStrategyParamService.getIpfCcmStrategyParam(id);
        //返回响应
        IpfCcmStrategyParamGetResponse ipfCcmStrategyParamGetResponse = new IpfCcmStrategyParamGetResponse();
        ipfCcmStrategyParamGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmStrategyParamGetResponse.setResultJson(ipfCcmStrategyParam);
        return ipfCcmStrategyParamGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmStrategyParamSelectAllRequest request) {
        IpfCcmStrategyParamSelectAllResponse ipfCcmStrategyParamSelectAllResponse = new IpfCcmStrategyParamSelectAllResponse();
        ipfCcmStrategyParamSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmStrategyParamSelectAllResponse.setResultJson(ipfCcmStrategyParamService.selectAll());
        return ipfCcmStrategyParamSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmStrategyParamCountAllRequest request) {
        IpfCcmStrategyParamCountAllResponse ipfCcmStrategyParamCountAllResponse = new IpfCcmStrategyParamCountAllResponse();
        ipfCcmStrategyParamCountAllResponse.setResultString(String.valueOf(ipfCcmStrategyParamService.countAll()));
        ipfCcmStrategyParamCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmStrategyParamCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmStrategyParamSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmStrategyParamSelectAllResponse ipfCcmStrategyParamSelectAllResponse = new IpfCcmStrategyParamSelectAllResponse();
        ipfCcmStrategyParamSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmStrategyParamSelectAllResponse.setResultJson(ipfCcmStrategyParamService.selectBySql(sqlstr));
        return ipfCcmStrategyParamSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.selectIpfCcmStrategyParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmStrategyParamSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmStrategyParam_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmStrategyParam ipfCcmStrategyParam=new IpfCcmStrategyParam();
        ipfCcmStrategyParam.setId(request.getId());
        ipfCcmStrategyParam.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        ipfCcmStrategyParam.setParamType(request.getParamType());
        ipfCcmStrategyParam.setParamName(request.getParamName());
        ipfCcmStrategyParam.setParamDes(request.getParamDes());
        ipfCcmStrategyParam.setRtmConfigCode(request.getRtmConfigCode());
    	IpfCcmStrategyParamSelectResponse ipfCcmStrategyParamSelectResponse = new IpfCcmStrategyParamSelectResponse();
        ipfCcmStrategyParamSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmStrategyParam> ipfCcmStrategyParams= ipfCcmStrategyParamService.selectWithCondition(ipfCcmStrategyParam);
        ipfCcmStrategyParamSelectResponse.setResultJson(ipfCcmStrategyParams);
        return ipfCcmStrategyParamSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategyParam.isExistIpfCcmStrategyParam", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmStrategyParam(IpfCcmStrategyParamSelectRequest request) {
        IpfCcmStrategyParam ipfCcmStrategyParam=new IpfCcmStrategyParam();
        ipfCcmStrategyParam.setId(request.getId());
        ipfCcmStrategyParam.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        ipfCcmStrategyParam.setParamType(request.getParamType());
        ipfCcmStrategyParam.setParamName(request.getParamName());
        ipfCcmStrategyParam.setParamDes(request.getParamDes());
        ipfCcmStrategyParam.setRtmConfigCode(request.getRtmConfigCode());
        ArrayList<IpfCcmStrategyParam> ipfCcmStrategyParams= ipfCcmStrategyParamService.selectWithCondition(ipfCcmStrategyParam);
    	IpfCcmStrategyParamCountAllResponse ipfCcmStrategyParamCountAllResponse = new IpfCcmStrategyParamCountAllResponse();
        if (ipfCcmStrategyParams.size()>0){
        	ipfCcmStrategyParamCountAllResponse.setResultString("1");
        } else {
        	ipfCcmStrategyParamCountAllResponse.setResultString("0");
        }        
        return ipfCcmStrategyParamCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmStrategyParamCreateRequest request){
    	IpfCcmStrategyParam ipfCcmStrategyParam=new IpfCcmStrategyParam();
    	ipfCcmStrategyParam.setId(request.getId());
        ArrayList<IpfCcmStrategyParam> ipfCcmStrategyParams= ipfCcmStrategyParamService.selectWithCondition(ipfCcmStrategyParam);
        if (ipfCcmStrategyParams!=null&&ipfCcmStrategyParams.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmStrategyParamUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmStrategyParamDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmStrategyParamSelectRequest request){
        return  true;
     }    
}
