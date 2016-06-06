/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBizruleDtl;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBizruleDtl.request.*;
import com.cartan.center.ebs.ipfCcmBizruleDtl.response.*;
import com.cartan.core.ipfCcmBizruleDtl.domain.IpfCcmBizruleDtl;
import com.cartan.core.ipfCcmBizruleDtl.service.IpfCcmBizruleDtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBizruleDtlServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBizruleDtlServiceEbs.class.getName());
	private IpfCcmBizruleDtlService  ipfCcmBizruleDtlService;
	
    public IpfCcmBizruleDtlService getIpfCcmBizruleDtlService() {
        return ipfCcmBizruleDtlService;
    }

    @Autowired
    public void setIpfCcmBizruleDtlService(IpfCcmBizruleDtlService ipfCcmBizruleDtlService) {
        this.ipfCcmBizruleDtlService = ipfCcmBizruleDtlService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBizruleDtlGetSessionRequest request) {      
    	IpfCcmBizruleDtlGetSessionResponse ipfCcmBizruleDtlGetSessionResponse = new IpfCcmBizruleDtlGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBizruleDtlGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBizruleDtlGetSessionResponse.setResultString("1");
            ipfCcmBizruleDtlGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBizruleDtlGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBizruleDtlGetSessionRequest request) {
    	IpfCcmBizruleDtlGetSessionResponse ipfCcmBizruleDtlGetSessionResponse = new IpfCcmBizruleDtlGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBizruleDtlGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBizruleDtlGetSessionResponse.setResultString("0");
        }
        ipfCcmBizruleDtlGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBizruleDtlGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBizruleDtlGetSessionRequest request) {
    	IpfCcmBizruleDtlGetSessionResponse ipfCcmBizruleDtlGetSessionResponse = new IpfCcmBizruleDtlGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBizruleDtlGetSessionResponse.setResultString("0");
        	ipfCcmBizruleDtlGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBizruleDtlGetSessionResponse.setResultString("1");
        }
        return ipfCcmBizruleDtlGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.createIpfCcmBizruleDtl", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBizruleDtl(IpfCcmBizruleDtlCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBizruleDtl_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBizruleDtl ipfCcmBizruleDtl=new IpfCcmBizruleDtl();
        ipfCcmBizruleDtl.setId(request.getId());    		
        ipfCcmBizruleDtl.setIpfCcmBizruleId(request.getIpfCcmBizruleId());
        ipfCcmBizruleDtl.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        ipfCcmBizruleDtl.setStrategyCode(request.getStrategyCode());
        ipfCcmBizruleDtl.setStrategyName(request.getStrategyName());
        ipfCcmBizruleDtl.setRemark(request.getRemark());
        ipfCcmBizruleDtl.setRuleDetailIndex(request.getRuleDetailIndex());
    	ipfCcmBizruleDtlService.createIpfCcmBizruleDtl(ipfCcmBizruleDtl);
        //返回响应
        IpfCcmBizruleDtlCreateResponse ipfCcmBizruleDtlCreateResponse = new IpfCcmBizruleDtlCreateResponse();
        ipfCcmBizruleDtlCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleDtlCreateResponse.setResultJson(ipfCcmBizruleDtl);
        return ipfCcmBizruleDtlCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.deleteIpfCcmBizruleDtl", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBizruleDtl(IpfCcmBizruleDtlDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBizruleDtl_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBizruleDtlService.deleteIpfCcmBizruleDtl(idstr);
        //返回响应
        IpfCcmBizruleDtlDeleteResponse ipfCcmBizruleDtlDeleteResponse = new IpfCcmBizruleDtlDeleteResponse();
        ipfCcmBizruleDtlDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBizruleDtlDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.updateIpfCcmBizruleDtl", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBizruleDtl(IpfCcmBizruleDtlUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBizruleDtl_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBizruleDtl ipfCcmBizruleDtl=new IpfCcmBizruleDtl();
        ipfCcmBizruleDtl=ipfCcmBizruleDtlService.getIpfCcmBizruleDtl(request.getId());
        if (request.getId()!=null){
	        ipfCcmBizruleDtl.setId(request.getId());
        }
        if (request.getIpfCcmBizruleId()!=null){
	        ipfCcmBizruleDtl.setIpfCcmBizruleId(request.getIpfCcmBizruleId());
        }
        if (request.getIpfCcmStrategyId()!=null){
	        ipfCcmBizruleDtl.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        }
        if (request.getStrategyCode()!=null){
	        ipfCcmBizruleDtl.setStrategyCode(request.getStrategyCode());
        }
        if (request.getStrategyName()!=null){
	        ipfCcmBizruleDtl.setStrategyName(request.getStrategyName());
        }
        if (request.getRemark()!=null){
	        ipfCcmBizruleDtl.setRemark(request.getRemark());
        }
        if (request.getRuleDetailIndex()!=null){
	        ipfCcmBizruleDtl.setRuleDetailIndex(request.getRuleDetailIndex());
        }
    	ipfCcmBizruleDtlService.updateIpfCcmBizruleDtl(ipfCcmBizruleDtl);
        //返回响应
        IpfCcmBizruleDtlUpdateResponse ipfCcmBizruleDtlUpdateResponse = new IpfCcmBizruleDtlUpdateResponse();
        ipfCcmBizruleDtlUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleDtlUpdateResponse.setResultJson(ipfCcmBizruleDtl);
        return ipfCcmBizruleDtlUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.getIpfCcmBizruleDtl", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBizruleDtl(IpfCcmBizruleDtlGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBizruleDtl ipfCcmBizruleDtl=new IpfCcmBizruleDtl();
        ipfCcmBizruleDtl=ipfCcmBizruleDtlService.getIpfCcmBizruleDtl(id);
        //返回响应
        IpfCcmBizruleDtlGetResponse ipfCcmBizruleDtlGetResponse = new IpfCcmBizruleDtlGetResponse();
        ipfCcmBizruleDtlGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleDtlGetResponse.setResultJson(ipfCcmBizruleDtl);
        return ipfCcmBizruleDtlGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBizruleDtlSelectAllRequest request) {
        IpfCcmBizruleDtlSelectAllResponse ipfCcmBizruleDtlSelectAllResponse = new IpfCcmBizruleDtlSelectAllResponse();
        ipfCcmBizruleDtlSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleDtlSelectAllResponse.setResultJson(ipfCcmBizruleDtlService.selectAll());
        return ipfCcmBizruleDtlSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBizruleDtlCountAllRequest request) {
        IpfCcmBizruleDtlCountAllResponse ipfCcmBizruleDtlCountAllResponse = new IpfCcmBizruleDtlCountAllResponse();
        ipfCcmBizruleDtlCountAllResponse.setResultString(String.valueOf(ipfCcmBizruleDtlService.countAll()));
        ipfCcmBizruleDtlCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBizruleDtlCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBizruleDtlSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBizruleDtlSelectAllResponse ipfCcmBizruleDtlSelectAllResponse = new IpfCcmBizruleDtlSelectAllResponse();
        ipfCcmBizruleDtlSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBizruleDtlSelectAllResponse.setResultJson(ipfCcmBizruleDtlService.selectBySql(sqlstr));
        return ipfCcmBizruleDtlSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.selectIpfCcmBizruleDtl", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBizruleDtlSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBizruleDtl_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBizruleDtl ipfCcmBizruleDtl=new IpfCcmBizruleDtl();
        ipfCcmBizruleDtl.setId(request.getId());
        ipfCcmBizruleDtl.setIpfCcmBizruleId(request.getIpfCcmBizruleId());
        ipfCcmBizruleDtl.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        ipfCcmBizruleDtl.setStrategyCode(request.getStrategyCode());
        ipfCcmBizruleDtl.setStrategyName(request.getStrategyName());
        ipfCcmBizruleDtl.setRemark(request.getRemark());
        ipfCcmBizruleDtl.setRuleDetailIndex(request.getRuleDetailIndex());
    	IpfCcmBizruleDtlSelectResponse ipfCcmBizruleDtlSelectResponse = new IpfCcmBizruleDtlSelectResponse();
        ipfCcmBizruleDtlSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBizruleDtl> ipfCcmBizruleDtls= ipfCcmBizruleDtlService.selectWithCondition(ipfCcmBizruleDtl);
        ipfCcmBizruleDtlSelectResponse.setResultJson(ipfCcmBizruleDtls);
        return ipfCcmBizruleDtlSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBizruleDtl.isExistIpfCcmBizruleDtl", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBizruleDtl(IpfCcmBizruleDtlSelectRequest request) {
        IpfCcmBizruleDtl ipfCcmBizruleDtl=new IpfCcmBizruleDtl();
        ipfCcmBizruleDtl.setId(request.getId());
        ipfCcmBizruleDtl.setIpfCcmBizruleId(request.getIpfCcmBizruleId());
        ipfCcmBizruleDtl.setIpfCcmStrategyId(request.getIpfCcmStrategyId());
        ipfCcmBizruleDtl.setStrategyCode(request.getStrategyCode());
        ipfCcmBizruleDtl.setStrategyName(request.getStrategyName());
        ipfCcmBizruleDtl.setRemark(request.getRemark());
        ipfCcmBizruleDtl.setRuleDetailIndex(request.getRuleDetailIndex());
        ArrayList<IpfCcmBizruleDtl> ipfCcmBizruleDtls= ipfCcmBizruleDtlService.selectWithCondition(ipfCcmBizruleDtl);
    	IpfCcmBizruleDtlCountAllResponse ipfCcmBizruleDtlCountAllResponse = new IpfCcmBizruleDtlCountAllResponse();
        if (ipfCcmBizruleDtls.size()>0){
        	ipfCcmBizruleDtlCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBizruleDtlCountAllResponse.setResultString("0");
        }        
        return ipfCcmBizruleDtlCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBizruleDtlCreateRequest request){
    	IpfCcmBizruleDtl ipfCcmBizruleDtl=new IpfCcmBizruleDtl();
    	ipfCcmBizruleDtl.setId(request.getId());
        ArrayList<IpfCcmBizruleDtl> ipfCcmBizruleDtls= ipfCcmBizruleDtlService.selectWithCondition(ipfCcmBizruleDtl);
        if (ipfCcmBizruleDtls!=null&&ipfCcmBizruleDtls.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBizruleDtlUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBizruleDtlDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBizruleDtlSelectRequest request){
        return  true;
     }    
}
