/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoCheck;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoCheck.request.*;
import com.cartan.center.ebs.ipfCcmBoCheck.response.*;
import com.cartan.core.ipfCcmBoCheck.domain.IpfCcmBoCheck;
import com.cartan.core.ipfCcmBoCheck.service.IpfCcmBoCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoCheckServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoCheckServiceEbs.class.getName());
	private IpfCcmBoCheckService  ipfCcmBoCheckService;
	
    public IpfCcmBoCheckService getIpfCcmBoCheckService() {
        return ipfCcmBoCheckService;
    }

    @Autowired
    public void setIpfCcmBoCheckService(IpfCcmBoCheckService ipfCcmBoCheckService) {
        this.ipfCcmBoCheckService = ipfCcmBoCheckService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoCheckGetSessionRequest request) {      
    	IpfCcmBoCheckGetSessionResponse ipfCcmBoCheckGetSessionResponse = new IpfCcmBoCheckGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoCheckGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoCheckGetSessionResponse.setResultString("1");
            ipfCcmBoCheckGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoCheckGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoCheckGetSessionRequest request) {
    	IpfCcmBoCheckGetSessionResponse ipfCcmBoCheckGetSessionResponse = new IpfCcmBoCheckGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoCheckGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoCheckGetSessionResponse.setResultString("0");
        }
        ipfCcmBoCheckGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoCheckGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoCheckGetSessionRequest request) {
    	IpfCcmBoCheckGetSessionResponse ipfCcmBoCheckGetSessionResponse = new IpfCcmBoCheckGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoCheckGetSessionResponse.setResultString("0");
        	ipfCcmBoCheckGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoCheckGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoCheckGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.createIpfCcmBoCheck", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoCheck(IpfCcmBoCheckCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoCheck_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheck ipfCcmBoCheck=new IpfCcmBoCheck();
        ipfCcmBoCheck.setId(request.getId());    		
        ipfCcmBoCheck.setCheckType(request.getCheckType());
        ipfCcmBoCheck.setCheckName(request.getCheckName());
        ipfCcmBoCheck.setBoName(request.getBoName());
        ipfCcmBoCheck.setPropertyName(request.getPropertyName());
        ipfCcmBoCheck.setPropertyDesc(request.getPropertyDesc());
    	ipfCcmBoCheckService.createIpfCcmBoCheck(ipfCcmBoCheck);
        //返回响应
        IpfCcmBoCheckCreateResponse ipfCcmBoCheckCreateResponse = new IpfCcmBoCheckCreateResponse();
        ipfCcmBoCheckCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckCreateResponse.setResultJson(ipfCcmBoCheck);
        return ipfCcmBoCheckCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.deleteIpfCcmBoCheck", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoCheck(IpfCcmBoCheckDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoCheck_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoCheckService.deleteIpfCcmBoCheck(idstr);
        //返回响应
        IpfCcmBoCheckDeleteResponse ipfCcmBoCheckDeleteResponse = new IpfCcmBoCheckDeleteResponse();
        ipfCcmBoCheckDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoCheckDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.updateIpfCcmBoCheck", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoCheck(IpfCcmBoCheckUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoCheck_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheck ipfCcmBoCheck=new IpfCcmBoCheck();
        ipfCcmBoCheck=ipfCcmBoCheckService.getIpfCcmBoCheck(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoCheck.setId(request.getId());
        }
        if (request.getCheckType()!=null){
	        ipfCcmBoCheck.setCheckType(request.getCheckType());
        }
        if (request.getCheckName()!=null){
	        ipfCcmBoCheck.setCheckName(request.getCheckName());
        }
        if (request.getBoName()!=null){
	        ipfCcmBoCheck.setBoName(request.getBoName());
        }
        if (request.getPropertyName()!=null){
	        ipfCcmBoCheck.setPropertyName(request.getPropertyName());
        }
        if (request.getPropertyDesc()!=null){
	        ipfCcmBoCheck.setPropertyDesc(request.getPropertyDesc());
        }
    	ipfCcmBoCheckService.updateIpfCcmBoCheck(ipfCcmBoCheck);
        //返回响应
        IpfCcmBoCheckUpdateResponse ipfCcmBoCheckUpdateResponse = new IpfCcmBoCheckUpdateResponse();
        ipfCcmBoCheckUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckUpdateResponse.setResultJson(ipfCcmBoCheck);
        return ipfCcmBoCheckUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.getIpfCcmBoCheck", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoCheck(IpfCcmBoCheckGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoCheck ipfCcmBoCheck=new IpfCcmBoCheck();
        ipfCcmBoCheck=ipfCcmBoCheckService.getIpfCcmBoCheck(id);
        //返回响应
        IpfCcmBoCheckGetResponse ipfCcmBoCheckGetResponse = new IpfCcmBoCheckGetResponse();
        ipfCcmBoCheckGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckGetResponse.setResultJson(ipfCcmBoCheck);
        return ipfCcmBoCheckGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoCheckSelectAllRequest request) {
        IpfCcmBoCheckSelectAllResponse ipfCcmBoCheckSelectAllResponse = new IpfCcmBoCheckSelectAllResponse();
        ipfCcmBoCheckSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckSelectAllResponse.setResultJson(ipfCcmBoCheckService.selectAll());
        return ipfCcmBoCheckSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoCheckCountAllRequest request) {
        IpfCcmBoCheckCountAllResponse ipfCcmBoCheckCountAllResponse = new IpfCcmBoCheckCountAllResponse();
        ipfCcmBoCheckCountAllResponse.setResultString(String.valueOf(ipfCcmBoCheckService.countAll()));
        ipfCcmBoCheckCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoCheckCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoCheckSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoCheckSelectAllResponse ipfCcmBoCheckSelectAllResponse = new IpfCcmBoCheckSelectAllResponse();
        ipfCcmBoCheckSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckSelectAllResponse.setResultJson(ipfCcmBoCheckService.selectBySql(sqlstr));
        return ipfCcmBoCheckSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.selectIpfCcmBoCheck", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoCheckSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoCheck_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheck ipfCcmBoCheck=new IpfCcmBoCheck();
        ipfCcmBoCheck.setId(request.getId());
        ipfCcmBoCheck.setCheckType(request.getCheckType());
        ipfCcmBoCheck.setCheckName(request.getCheckName());
        ipfCcmBoCheck.setBoName(request.getBoName());
        ipfCcmBoCheck.setPropertyName(request.getPropertyName());
        ipfCcmBoCheck.setPropertyDesc(request.getPropertyDesc());
    	IpfCcmBoCheckSelectResponse ipfCcmBoCheckSelectResponse = new IpfCcmBoCheckSelectResponse();
        ipfCcmBoCheckSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoCheck> ipfCcmBoChecks= ipfCcmBoCheckService.selectWithCondition(ipfCcmBoCheck);
        ipfCcmBoCheckSelectResponse.setResultJson(ipfCcmBoChecks);
        return ipfCcmBoCheckSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheck.isExistIpfCcmBoCheck", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoCheck(IpfCcmBoCheckSelectRequest request) {
        IpfCcmBoCheck ipfCcmBoCheck=new IpfCcmBoCheck();
        ipfCcmBoCheck.setId(request.getId());
        ipfCcmBoCheck.setCheckType(request.getCheckType());
        ipfCcmBoCheck.setCheckName(request.getCheckName());
        ipfCcmBoCheck.setBoName(request.getBoName());
        ipfCcmBoCheck.setPropertyName(request.getPropertyName());
        ipfCcmBoCheck.setPropertyDesc(request.getPropertyDesc());
        ArrayList<IpfCcmBoCheck> ipfCcmBoChecks= ipfCcmBoCheckService.selectWithCondition(ipfCcmBoCheck);
    	IpfCcmBoCheckCountAllResponse ipfCcmBoCheckCountAllResponse = new IpfCcmBoCheckCountAllResponse();
        if (ipfCcmBoChecks.size()>0){
        	ipfCcmBoCheckCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoCheckCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoCheckCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoCheckCreateRequest request){
    	IpfCcmBoCheck ipfCcmBoCheck=new IpfCcmBoCheck();
    	ipfCcmBoCheck.setId(request.getId());
        ArrayList<IpfCcmBoCheck> ipfCcmBoChecks= ipfCcmBoCheckService.selectWithCondition(ipfCcmBoCheck);
        if (ipfCcmBoChecks!=null&&ipfCcmBoChecks.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoCheckUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoCheckDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoCheckSelectRequest request){
        return  true;
     }    
}
