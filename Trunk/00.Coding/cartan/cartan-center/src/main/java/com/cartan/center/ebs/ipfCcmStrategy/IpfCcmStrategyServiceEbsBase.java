/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmStrategy;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmStrategy.request.*;
import com.cartan.center.ebs.ipfCcmStrategy.response.*;
import com.cartan.core.ipfCcmStrategy.domain.IpfCcmStrategy;
import com.cartan.core.ipfCcmStrategy.service.IpfCcmStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmStrategyServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmStrategyServiceEbs.class.getName());
	private IpfCcmStrategyService  ipfCcmStrategyService;
	
    public IpfCcmStrategyService getIpfCcmStrategyService() {
        return ipfCcmStrategyService;
    }

    @Autowired
    public void setIpfCcmStrategyService(IpfCcmStrategyService ipfCcmStrategyService) {
        this.ipfCcmStrategyService = ipfCcmStrategyService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmStrategyGetSessionRequest request) {      
    	IpfCcmStrategyGetSessionResponse ipfCcmStrategyGetSessionResponse = new IpfCcmStrategyGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmStrategyGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmStrategyGetSessionResponse.setResultString("1");
            ipfCcmStrategyGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmStrategyGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmStrategyGetSessionRequest request) {
    	IpfCcmStrategyGetSessionResponse ipfCcmStrategyGetSessionResponse = new IpfCcmStrategyGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmStrategyGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmStrategyGetSessionResponse.setResultString("0");
        }
        ipfCcmStrategyGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmStrategyGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmStrategyGetSessionRequest request) {
    	IpfCcmStrategyGetSessionResponse ipfCcmStrategyGetSessionResponse = new IpfCcmStrategyGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmStrategyGetSessionResponse.setResultString("0");
        	ipfCcmStrategyGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmStrategyGetSessionResponse.setResultString("1");
        }
        return ipfCcmStrategyGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.createIpfCcmStrategy", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmStrategy(IpfCcmStrategyCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmStrategy_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmStrategy ipfCcmStrategy=new IpfCcmStrategy();
        ipfCcmStrategy.setId(request.getId());    		
        ipfCcmStrategy.setStrategyType(request.getStrategyType());
        ipfCcmStrategy.setStrategyCode(request.getStrategyCode());
        ipfCcmStrategy.setStrategyName(request.getStrategyName());
        ipfCcmStrategy.setStrategyDes(request.getStrategyDes());
        ipfCcmStrategy.setDrlFile(request.getDrlFile());
        ipfCcmStrategy.setDrlRoute(request.getDrlRoute());
        ipfCcmStrategy.setPackageName(request.getPackageName());
        ipfCcmStrategy.setRuleNo(request.getRuleNo());
        ipfCcmStrategy.setRuleType(request.getRuleType());
        ipfCcmStrategy.setSourceCode(request.getSourceCode());
        ipfCcmStrategy.setSvnRevision(request.getSvnRevision());
    	ipfCcmStrategyService.createIpfCcmStrategy(ipfCcmStrategy);
        //返回响应
        IpfCcmStrategyCreateResponse ipfCcmStrategyCreateResponse = new IpfCcmStrategyCreateResponse();
        ipfCcmStrategyCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmStrategyCreateResponse.setResultJson(ipfCcmStrategy);
        return ipfCcmStrategyCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.deleteIpfCcmStrategy", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmStrategy(IpfCcmStrategyDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmStrategy_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmStrategyService.deleteIpfCcmStrategy(idstr);
        //返回响应
        IpfCcmStrategyDeleteResponse ipfCcmStrategyDeleteResponse = new IpfCcmStrategyDeleteResponse();
        ipfCcmStrategyDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmStrategyDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.updateIpfCcmStrategy", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmStrategy(IpfCcmStrategyUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmStrategy_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmStrategy ipfCcmStrategy=new IpfCcmStrategy();
        ipfCcmStrategy=ipfCcmStrategyService.getIpfCcmStrategy(request.getId());
        if (request.getId()!=null){
	        ipfCcmStrategy.setId(request.getId());
        }
        if (request.getStrategyType()!=null){
	        ipfCcmStrategy.setStrategyType(request.getStrategyType());
        }
        if (request.getStrategyCode()!=null){
	        ipfCcmStrategy.setStrategyCode(request.getStrategyCode());
        }
        if (request.getStrategyName()!=null){
	        ipfCcmStrategy.setStrategyName(request.getStrategyName());
        }
        if (request.getStrategyDes()!=null){
	        ipfCcmStrategy.setStrategyDes(request.getStrategyDes());
        }
        if (request.getDrlFile()!=null){
	        ipfCcmStrategy.setDrlFile(request.getDrlFile());
        }
        if (request.getDrlRoute()!=null){
	        ipfCcmStrategy.setDrlRoute(request.getDrlRoute());
        }
        if (request.getPackageName()!=null){
	        ipfCcmStrategy.setPackageName(request.getPackageName());
        }
        if (request.getRuleNo()!=null){
	        ipfCcmStrategy.setRuleNo(request.getRuleNo());
        }
        if (request.getRuleType()!=null){
	        ipfCcmStrategy.setRuleType(request.getRuleType());
        }
        if (request.getSourceCode()!=null){
	        ipfCcmStrategy.setSourceCode(request.getSourceCode());
        }
        if (request.getSvnRevision()!=null){
	        ipfCcmStrategy.setSvnRevision(request.getSvnRevision());
        }
    	ipfCcmStrategyService.updateIpfCcmStrategy(ipfCcmStrategy);
        //返回响应
        IpfCcmStrategyUpdateResponse ipfCcmStrategyUpdateResponse = new IpfCcmStrategyUpdateResponse();
        ipfCcmStrategyUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmStrategyUpdateResponse.setResultJson(ipfCcmStrategy);
        return ipfCcmStrategyUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.getIpfCcmStrategy", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmStrategy(IpfCcmStrategyGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmStrategy ipfCcmStrategy=new IpfCcmStrategy();
        ipfCcmStrategy=ipfCcmStrategyService.getIpfCcmStrategy(id);
        //返回响应
        IpfCcmStrategyGetResponse ipfCcmStrategyGetResponse = new IpfCcmStrategyGetResponse();
        ipfCcmStrategyGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmStrategyGetResponse.setResultJson(ipfCcmStrategy);
        return ipfCcmStrategyGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmStrategySelectAllRequest request) {
        IpfCcmStrategySelectAllResponse ipfCcmStrategySelectAllResponse = new IpfCcmStrategySelectAllResponse();
        ipfCcmStrategySelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmStrategySelectAllResponse.setResultJson(ipfCcmStrategyService.selectAll());
        return ipfCcmStrategySelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmStrategyCountAllRequest request) {
        IpfCcmStrategyCountAllResponse ipfCcmStrategyCountAllResponse = new IpfCcmStrategyCountAllResponse();
        ipfCcmStrategyCountAllResponse.setResultString(String.valueOf(ipfCcmStrategyService.countAll()));
        ipfCcmStrategyCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmStrategyCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmStrategySelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmStrategySelectAllResponse ipfCcmStrategySelectAllResponse = new IpfCcmStrategySelectAllResponse();
        ipfCcmStrategySelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmStrategySelectAllResponse.setResultJson(ipfCcmStrategyService.selectBySql(sqlstr));
        return ipfCcmStrategySelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.selectIpfCcmStrategy", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmStrategySelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmStrategy_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmStrategy ipfCcmStrategy=new IpfCcmStrategy();
        ipfCcmStrategy.setId(request.getId());
        ipfCcmStrategy.setStrategyType(request.getStrategyType());
        ipfCcmStrategy.setStrategyCode(request.getStrategyCode());
        ipfCcmStrategy.setStrategyName(request.getStrategyName());
        ipfCcmStrategy.setStrategyDes(request.getStrategyDes());
        ipfCcmStrategy.setDrlFile(request.getDrlFile());
        ipfCcmStrategy.setDrlRoute(request.getDrlRoute());
        ipfCcmStrategy.setPackageName(request.getPackageName());
        ipfCcmStrategy.setRuleNo(request.getRuleNo());
        ipfCcmStrategy.setRuleType(request.getRuleType());
        ipfCcmStrategy.setSourceCode(request.getSourceCode());
        ipfCcmStrategy.setSvnRevision(request.getSvnRevision());
    	IpfCcmStrategySelectResponse ipfCcmStrategySelectResponse = new IpfCcmStrategySelectResponse();
        ipfCcmStrategySelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmStrategy> ipfCcmStrategys= ipfCcmStrategyService.selectWithCondition(ipfCcmStrategy);
        ipfCcmStrategySelectResponse.setResultJson(ipfCcmStrategys);
        return ipfCcmStrategySelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmStrategy.isExistIpfCcmStrategy", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmStrategy(IpfCcmStrategySelectRequest request) {
        IpfCcmStrategy ipfCcmStrategy=new IpfCcmStrategy();
        ipfCcmStrategy.setId(request.getId());
        ipfCcmStrategy.setStrategyType(request.getStrategyType());
        ipfCcmStrategy.setStrategyCode(request.getStrategyCode());
        ipfCcmStrategy.setStrategyName(request.getStrategyName());
        ipfCcmStrategy.setStrategyDes(request.getStrategyDes());
        ipfCcmStrategy.setDrlFile(request.getDrlFile());
        ipfCcmStrategy.setDrlRoute(request.getDrlRoute());
        ipfCcmStrategy.setPackageName(request.getPackageName());
        ipfCcmStrategy.setRuleNo(request.getRuleNo());
        ipfCcmStrategy.setRuleType(request.getRuleType());
        ipfCcmStrategy.setSourceCode(request.getSourceCode());
        ipfCcmStrategy.setSvnRevision(request.getSvnRevision());
        ArrayList<IpfCcmStrategy> ipfCcmStrategys= ipfCcmStrategyService.selectWithCondition(ipfCcmStrategy);
    	IpfCcmStrategyCountAllResponse ipfCcmStrategyCountAllResponse = new IpfCcmStrategyCountAllResponse();
        if (ipfCcmStrategys.size()>0){
        	ipfCcmStrategyCountAllResponse.setResultString("1");
        } else {
        	ipfCcmStrategyCountAllResponse.setResultString("0");
        }        
        return ipfCcmStrategyCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmStrategyCreateRequest request){
    	IpfCcmStrategy ipfCcmStrategy=new IpfCcmStrategy();
    	ipfCcmStrategy.setId(request.getId());
        ArrayList<IpfCcmStrategy> ipfCcmStrategys= ipfCcmStrategyService.selectWithCondition(ipfCcmStrategy);
        if (ipfCcmStrategys!=null&&ipfCcmStrategys.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmStrategyUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmStrategyDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmStrategySelectRequest request){
        return  true;
     }    
}
