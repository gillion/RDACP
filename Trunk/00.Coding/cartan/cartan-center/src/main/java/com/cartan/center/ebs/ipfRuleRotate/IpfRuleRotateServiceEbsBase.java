/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRuleRotate;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfRuleRotate.request.*;
import com.cartan.center.ebs.ipfRuleRotate.response.*;
import com.cartan.core.ipfRuleRotate.domain.IpfRuleRotate;
import com.cartan.core.ipfRuleRotate.service.IpfRuleRotateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfRuleRotateServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfRuleRotateServiceEbs.class.getName());
	private IpfRuleRotateService  ipfRuleRotateService;
	
    public IpfRuleRotateService getIpfRuleRotateService() {
        return ipfRuleRotateService;
    }

    @Autowired
    public void setIpfRuleRotateService(IpfRuleRotateService ipfRuleRotateService) {
        this.ipfRuleRotateService = ipfRuleRotateService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfRuleRotateGetSessionRequest request) {      
    	IpfRuleRotateGetSessionResponse ipfRuleRotateGetSessionResponse = new IpfRuleRotateGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRuleRotateGetSessionResponse.setResultString("0");
        } else {
        	ipfRuleRotateGetSessionResponse.setResultString("1");
            ipfRuleRotateGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfRuleRotateGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfRuleRotateGetSessionRequest request) {
    	IpfRuleRotateGetSessionResponse ipfRuleRotateGetSessionResponse = new IpfRuleRotateGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfRuleRotateGetSessionResponse.setResultString("1");
        } else {
        	ipfRuleRotateGetSessionResponse.setResultString("0");
        }
        ipfRuleRotateGetSessionResponse.setSessionId(request.getSessionId());
        return ipfRuleRotateGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfRuleRotateGetSessionRequest request) {
    	IpfRuleRotateGetSessionResponse ipfRuleRotateGetSessionResponse = new IpfRuleRotateGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRuleRotateGetSessionResponse.setResultString("0");
        	ipfRuleRotateGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfRuleRotateGetSessionResponse.setResultString("1");
        }
        return ipfRuleRotateGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.createIpfRuleRotate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfRuleRotate(IpfRuleRotateCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfRuleRotate_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleRotate ipfRuleRotate=new IpfRuleRotate();
        ipfRuleRotate.setId(request.getId());    		
        ipfRuleRotate.setWarehouseOfficeId(request.getWarehouseOfficeId());
        ipfRuleRotate.setRuleCode(request.getRuleCode());
        ipfRuleRotate.setRuleDesc(request.getRuleDesc());
        ipfRuleRotate.setIsActive(request.getIsActive());
        ipfRuleRotate.setIsSystemCreate(request.getIsSystemCreate());
        ipfRuleRotate.setRotateExpress(request.getRotateExpress());
    	ipfRuleRotateService.createIpfRuleRotate(ipfRuleRotate);
        //返回响应
        IpfRuleRotateCreateResponse ipfRuleRotateCreateResponse = new IpfRuleRotateCreateResponse();
        ipfRuleRotateCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleRotateCreateResponse.setResultJson(ipfRuleRotate);
        return ipfRuleRotateCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.deleteIpfRuleRotate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfRuleRotate(IpfRuleRotateDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfRuleRotate_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfRuleRotateService.deleteIpfRuleRotate(idstr);
        //返回响应
        IpfRuleRotateDeleteResponse ipfRuleRotateDeleteResponse = new IpfRuleRotateDeleteResponse();
        ipfRuleRotateDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRuleRotateDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.updateIpfRuleRotate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfRuleRotate(IpfRuleRotateUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfRuleRotate_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleRotate ipfRuleRotate=new IpfRuleRotate();
        ipfRuleRotate=ipfRuleRotateService.getIpfRuleRotate(request.getId());
        if (request.getId()!=null){
	        ipfRuleRotate.setId(request.getId());
        }
        if (request.getWarehouseOfficeId()!=null){
	        ipfRuleRotate.setWarehouseOfficeId(request.getWarehouseOfficeId());
        }
        if (request.getRuleCode()!=null){
	        ipfRuleRotate.setRuleCode(request.getRuleCode());
        }
        if (request.getRuleDesc()!=null){
	        ipfRuleRotate.setRuleDesc(request.getRuleDesc());
        }
        if (request.getIsActive()!=null){
	        ipfRuleRotate.setIsActive(request.getIsActive());
        }
        if (request.getIsSystemCreate()!=null){
	        ipfRuleRotate.setIsSystemCreate(request.getIsSystemCreate());
        }
        if (request.getRotateExpress()!=null){
	        ipfRuleRotate.setRotateExpress(request.getRotateExpress());
        }
    	ipfRuleRotateService.updateIpfRuleRotate(ipfRuleRotate);
        //返回响应
        IpfRuleRotateUpdateResponse ipfRuleRotateUpdateResponse = new IpfRuleRotateUpdateResponse();
        ipfRuleRotateUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleRotateUpdateResponse.setResultJson(ipfRuleRotate);
        return ipfRuleRotateUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.getIpfRuleRotate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfRuleRotate(IpfRuleRotateGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfRuleRotate ipfRuleRotate=new IpfRuleRotate();
        ipfRuleRotate=ipfRuleRotateService.getIpfRuleRotate(id);
        //返回响应
        IpfRuleRotateGetResponse ipfRuleRotateGetResponse = new IpfRuleRotateGetResponse();
        ipfRuleRotateGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleRotateGetResponse.setResultJson(ipfRuleRotate);
        return ipfRuleRotateGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfRuleRotateSelectAllRequest request) {
        IpfRuleRotateSelectAllResponse ipfRuleRotateSelectAllResponse = new IpfRuleRotateSelectAllResponse();
        ipfRuleRotateSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleRotateSelectAllResponse.setResultJson(ipfRuleRotateService.selectAll());
        return ipfRuleRotateSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfRuleRotateCountAllRequest request) {
        IpfRuleRotateCountAllResponse ipfRuleRotateCountAllResponse = new IpfRuleRotateCountAllResponse();
        ipfRuleRotateCountAllResponse.setResultString(String.valueOf(ipfRuleRotateService.countAll()));
        ipfRuleRotateCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRuleRotateCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfRuleRotateSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfRuleRotateSelectAllResponse ipfRuleRotateSelectAllResponse = new IpfRuleRotateSelectAllResponse();
        ipfRuleRotateSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleRotateSelectAllResponse.setResultJson(ipfRuleRotateService.selectBySql(sqlstr));
        return ipfRuleRotateSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.selectIpfRuleRotate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfRuleRotateSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfRuleRotate_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleRotate ipfRuleRotate=new IpfRuleRotate();
        ipfRuleRotate.setId(request.getId());
        ipfRuleRotate.setWarehouseOfficeId(request.getWarehouseOfficeId());
        ipfRuleRotate.setRuleCode(request.getRuleCode());
        ipfRuleRotate.setRuleDesc(request.getRuleDesc());
        ipfRuleRotate.setIsActive(request.getIsActive());
        ipfRuleRotate.setIsSystemCreate(request.getIsSystemCreate());
        ipfRuleRotate.setRotateExpress(request.getRotateExpress());
    	IpfRuleRotateSelectResponse ipfRuleRotateSelectResponse = new IpfRuleRotateSelectResponse();
        ipfRuleRotateSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfRuleRotate> ipfRuleRotates= ipfRuleRotateService.selectWithCondition(ipfRuleRotate);
        ipfRuleRotateSelectResponse.setResultJson(ipfRuleRotates);
        return ipfRuleRotateSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotate.isExistIpfRuleRotate", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfRuleRotate(IpfRuleRotateSelectRequest request) {
        IpfRuleRotate ipfRuleRotate=new IpfRuleRotate();
        ipfRuleRotate.setId(request.getId());
        ipfRuleRotate.setWarehouseOfficeId(request.getWarehouseOfficeId());
        ipfRuleRotate.setRuleCode(request.getRuleCode());
        ipfRuleRotate.setRuleDesc(request.getRuleDesc());
        ipfRuleRotate.setIsActive(request.getIsActive());
        ipfRuleRotate.setIsSystemCreate(request.getIsSystemCreate());
        ipfRuleRotate.setRotateExpress(request.getRotateExpress());
        ArrayList<IpfRuleRotate> ipfRuleRotates= ipfRuleRotateService.selectWithCondition(ipfRuleRotate);
    	IpfRuleRotateCountAllResponse ipfRuleRotateCountAllResponse = new IpfRuleRotateCountAllResponse();
        if (ipfRuleRotates.size()>0){
        	ipfRuleRotateCountAllResponse.setResultString("1");
        } else {
        	ipfRuleRotateCountAllResponse.setResultString("0");
        }        
        return ipfRuleRotateCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfRuleRotateCreateRequest request){
    	IpfRuleRotate ipfRuleRotate=new IpfRuleRotate();
    	ipfRuleRotate.setId(request.getId());
        ArrayList<IpfRuleRotate> ipfRuleRotates= ipfRuleRotateService.selectWithCondition(ipfRuleRotate);
        if (ipfRuleRotates!=null&&ipfRuleRotates.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfRuleRotateUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfRuleRotateDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfRuleRotateSelectRequest request){
        return  true;
     }    
}
