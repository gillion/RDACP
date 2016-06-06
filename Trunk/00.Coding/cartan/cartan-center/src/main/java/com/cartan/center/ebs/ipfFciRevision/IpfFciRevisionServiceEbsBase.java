/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciRevision;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfFciRevision.request.*;
import com.cartan.center.ebs.ipfFciRevision.response.*;
import com.cartan.core.ipfFciRevision.domain.IpfFciRevision;
import com.cartan.core.ipfFciRevision.service.IpfFciRevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfFciRevisionServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfFciRevisionServiceEbs.class.getName());
	private IpfFciRevisionService  ipfFciRevisionService;
	
    public IpfFciRevisionService getIpfFciRevisionService() {
        return ipfFciRevisionService;
    }

    @Autowired
    public void setIpfFciRevisionService(IpfFciRevisionService ipfFciRevisionService) {
        this.ipfFciRevisionService = ipfFciRevisionService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfFciRevisionGetSessionRequest request) {      
    	IpfFciRevisionGetSessionResponse ipfFciRevisionGetSessionResponse = new IpfFciRevisionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciRevisionGetSessionResponse.setResultString("0");
        } else {
        	ipfFciRevisionGetSessionResponse.setResultString("1");
            ipfFciRevisionGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfFciRevisionGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfFciRevisionGetSessionRequest request) {
    	IpfFciRevisionGetSessionResponse ipfFciRevisionGetSessionResponse = new IpfFciRevisionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfFciRevisionGetSessionResponse.setResultString("1");
        } else {
        	ipfFciRevisionGetSessionResponse.setResultString("0");
        }
        ipfFciRevisionGetSessionResponse.setSessionId(request.getSessionId());
        return ipfFciRevisionGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfFciRevisionGetSessionRequest request) {
    	IpfFciRevisionGetSessionResponse ipfFciRevisionGetSessionResponse = new IpfFciRevisionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciRevisionGetSessionResponse.setResultString("0");
        	ipfFciRevisionGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfFciRevisionGetSessionResponse.setResultString("1");
        }
        return ipfFciRevisionGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.createIpfFciRevision", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfFciRevision(IpfFciRevisionCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfFciRevision_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciRevision ipfFciRevision=new IpfFciRevision();
        ipfFciRevision.setId(request.getId());    		
        ipfFciRevision.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciRevision.setIpfFciProjectId(request.getIpfFciProjectId());
        ipfFciRevision.setRevisionNumber(request.getRevisionNumber());
        ipfFciRevision.setRemark(request.getRemark());
    	ipfFciRevisionService.createIpfFciRevision(ipfFciRevision);
        //返回响应
        IpfFciRevisionCreateResponse ipfFciRevisionCreateResponse = new IpfFciRevisionCreateResponse();
        ipfFciRevisionCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciRevisionCreateResponse.setResultJson(ipfFciRevision);
        return ipfFciRevisionCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.deleteIpfFciRevision", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfFciRevision(IpfFciRevisionDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfFciRevision_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfFciRevisionService.deleteIpfFciRevision(idstr);
        //返回响应
        IpfFciRevisionDeleteResponse ipfFciRevisionDeleteResponse = new IpfFciRevisionDeleteResponse();
        ipfFciRevisionDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciRevisionDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.updateIpfFciRevision", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfFciRevision(IpfFciRevisionUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfFciRevision_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciRevision ipfFciRevision=new IpfFciRevision();
        ipfFciRevision=ipfFciRevisionService.getIpfFciRevision(request.getId());
        if (request.getId()!=null){
	        ipfFciRevision.setId(request.getId());
        }
        if (request.getIpfFciViewId()!=null){
	        ipfFciRevision.setIpfFciViewId(request.getIpfFciViewId());
        }
        if (request.getIpfFciProjectId()!=null){
	        ipfFciRevision.setIpfFciProjectId(request.getIpfFciProjectId());
        }
        if (request.getRevisionNumber()!=null){
	        ipfFciRevision.setRevisionNumber(request.getRevisionNumber());
        }
        if (request.getRemark()!=null){
	        ipfFciRevision.setRemark(request.getRemark());
        }
    	ipfFciRevisionService.updateIpfFciRevision(ipfFciRevision);
        //返回响应
        IpfFciRevisionUpdateResponse ipfFciRevisionUpdateResponse = new IpfFciRevisionUpdateResponse();
        ipfFciRevisionUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciRevisionUpdateResponse.setResultJson(ipfFciRevision);
        return ipfFciRevisionUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.getIpfFciRevision", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfFciRevision(IpfFciRevisionGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfFciRevision ipfFciRevision=new IpfFciRevision();
        ipfFciRevision=ipfFciRevisionService.getIpfFciRevision(id);
        //返回响应
        IpfFciRevisionGetResponse ipfFciRevisionGetResponse = new IpfFciRevisionGetResponse();
        ipfFciRevisionGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciRevisionGetResponse.setResultJson(ipfFciRevision);
        return ipfFciRevisionGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfFciRevisionSelectAllRequest request) {
        IpfFciRevisionSelectAllResponse ipfFciRevisionSelectAllResponse = new IpfFciRevisionSelectAllResponse();
        ipfFciRevisionSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciRevisionSelectAllResponse.setResultJson(ipfFciRevisionService.selectAll());
        return ipfFciRevisionSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfFciRevisionCountAllRequest request) {
        IpfFciRevisionCountAllResponse ipfFciRevisionCountAllResponse = new IpfFciRevisionCountAllResponse();
        ipfFciRevisionCountAllResponse.setResultString(String.valueOf(ipfFciRevisionService.countAll()));
        ipfFciRevisionCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciRevisionCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfFciRevisionSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfFciRevisionSelectAllResponse ipfFciRevisionSelectAllResponse = new IpfFciRevisionSelectAllResponse();
        ipfFciRevisionSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciRevisionSelectAllResponse.setResultJson(ipfFciRevisionService.selectBySql(sqlstr));
        return ipfFciRevisionSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.selectIpfFciRevision", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfFciRevisionSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfFciRevision_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciRevision ipfFciRevision=new IpfFciRevision();
        ipfFciRevision.setId(request.getId());
        ipfFciRevision.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciRevision.setIpfFciProjectId(request.getIpfFciProjectId());
        ipfFciRevision.setRevisionNumber(request.getRevisionNumber());
        ipfFciRevision.setRemark(request.getRemark());
    	IpfFciRevisionSelectResponse ipfFciRevisionSelectResponse = new IpfFciRevisionSelectResponse();
        ipfFciRevisionSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfFciRevision> ipfFciRevisions= ipfFciRevisionService.selectWithCondition(ipfFciRevision);
        ipfFciRevisionSelectResponse.setResultJson(ipfFciRevisions);
        return ipfFciRevisionSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciRevision.isExistIpfFciRevision", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfFciRevision(IpfFciRevisionSelectRequest request) {
        IpfFciRevision ipfFciRevision=new IpfFciRevision();
        ipfFciRevision.setId(request.getId());
        ipfFciRevision.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciRevision.setIpfFciProjectId(request.getIpfFciProjectId());
        ipfFciRevision.setRevisionNumber(request.getRevisionNumber());
        ipfFciRevision.setRemark(request.getRemark());
        ArrayList<IpfFciRevision> ipfFciRevisions= ipfFciRevisionService.selectWithCondition(ipfFciRevision);
    	IpfFciRevisionCountAllResponse ipfFciRevisionCountAllResponse = new IpfFciRevisionCountAllResponse();
        if (ipfFciRevisions.size()>0){
        	ipfFciRevisionCountAllResponse.setResultString("1");
        } else {
        	ipfFciRevisionCountAllResponse.setResultString("0");
        }        
        return ipfFciRevisionCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfFciRevisionCreateRequest request){
    	IpfFciRevision ipfFciRevision=new IpfFciRevision();
    	ipfFciRevision.setId(request.getId());
        ArrayList<IpfFciRevision> ipfFciRevisions= ipfFciRevisionService.selectWithCondition(ipfFciRevision);
        if (ipfFciRevisions!=null&&ipfFciRevisions.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfFciRevisionUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfFciRevisionDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfFciRevisionSelectRequest request){
        return  true;
     }    
}
