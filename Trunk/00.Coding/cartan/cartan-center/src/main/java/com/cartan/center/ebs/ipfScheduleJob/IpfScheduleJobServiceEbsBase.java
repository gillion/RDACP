/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfScheduleJob;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfScheduleJob.request.*;
import com.cartan.center.ebs.ipfScheduleJob.response.*;
import com.cartan.core.ipfScheduleJob.domain.IpfScheduleJob;
import com.cartan.core.ipfScheduleJob.service.IpfScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfScheduleJobServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfScheduleJobServiceEbs.class.getName());
	private IpfScheduleJobService  ipfScheduleJobService;
	
    public IpfScheduleJobService getIpfScheduleJobService() {
        return ipfScheduleJobService;
    }

    @Autowired
    public void setIpfScheduleJobService(IpfScheduleJobService ipfScheduleJobService) {
        this.ipfScheduleJobService = ipfScheduleJobService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfScheduleJobGetSessionRequest request) {      
    	IpfScheduleJobGetSessionResponse ipfScheduleJobGetSessionResponse = new IpfScheduleJobGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfScheduleJobGetSessionResponse.setResultString("0");
        } else {
        	ipfScheduleJobGetSessionResponse.setResultString("1");
            ipfScheduleJobGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfScheduleJobGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfScheduleJobGetSessionRequest request) {
    	IpfScheduleJobGetSessionResponse ipfScheduleJobGetSessionResponse = new IpfScheduleJobGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfScheduleJobGetSessionResponse.setResultString("1");
        } else {
        	ipfScheduleJobGetSessionResponse.setResultString("0");
        }
        ipfScheduleJobGetSessionResponse.setSessionId(request.getSessionId());
        return ipfScheduleJobGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfScheduleJobGetSessionRequest request) {
    	IpfScheduleJobGetSessionResponse ipfScheduleJobGetSessionResponse = new IpfScheduleJobGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfScheduleJobGetSessionResponse.setResultString("0");
        	ipfScheduleJobGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfScheduleJobGetSessionResponse.setResultString("1");
        }
        return ipfScheduleJobGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.createIpfScheduleJob", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfScheduleJob(IpfScheduleJobCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfScheduleJob_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfScheduleJob ipfScheduleJob=new IpfScheduleJob();
        ipfScheduleJob.setId(request.getId());    		
        ipfScheduleJob.setJobName(request.getJobName());
        ipfScheduleJob.setJobGroup(request.getJobGroup());
        ipfScheduleJob.setJobStatus(request.getJobStatus());
        ipfScheduleJob.setCronExpression(request.getCronExpression());
        ipfScheduleJob.setJobDesc(request.getJobDesc());
        ipfScheduleJob.setRuleNo(request.getRuleNo());
        ipfScheduleJob.setJobService(request.getJobService());
        ipfScheduleJob.setJobMethod(request.getJobMethod());
    	ipfScheduleJobService.createIpfScheduleJob(ipfScheduleJob);
        //返回响应
        IpfScheduleJobCreateResponse ipfScheduleJobCreateResponse = new IpfScheduleJobCreateResponse();
        ipfScheduleJobCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfScheduleJobCreateResponse.setResultJson(ipfScheduleJob);
        return ipfScheduleJobCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.deleteIpfScheduleJob", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfScheduleJob(IpfScheduleJobDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfScheduleJob_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfScheduleJobService.deleteIpfScheduleJob(idstr);
        //返回响应
        IpfScheduleJobDeleteResponse ipfScheduleJobDeleteResponse = new IpfScheduleJobDeleteResponse();
        ipfScheduleJobDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfScheduleJobDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.updateIpfScheduleJob", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfScheduleJob(IpfScheduleJobUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfScheduleJob_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfScheduleJob ipfScheduleJob=new IpfScheduleJob();
        ipfScheduleJob=ipfScheduleJobService.getIpfScheduleJob(request.getId());
        if (request.getId()!=null){
	        ipfScheduleJob.setId(request.getId());
        }
        if (request.getJobName()!=null){
	        ipfScheduleJob.setJobName(request.getJobName());
        }
        if (request.getJobGroup()!=null){
	        ipfScheduleJob.setJobGroup(request.getJobGroup());
        }
        if (request.getJobStatus()!=null){
	        ipfScheduleJob.setJobStatus(request.getJobStatus());
        }
        if (request.getCronExpression()!=null){
	        ipfScheduleJob.setCronExpression(request.getCronExpression());
        }
        if (request.getJobDesc()!=null){
	        ipfScheduleJob.setJobDesc(request.getJobDesc());
        }
        if (request.getRuleNo()!=null){
	        ipfScheduleJob.setRuleNo(request.getRuleNo());
        }
        if (request.getJobService()!=null){
	        ipfScheduleJob.setJobService(request.getJobService());
        }
        if (request.getJobMethod()!=null){
	        ipfScheduleJob.setJobMethod(request.getJobMethod());
        }
    	ipfScheduleJobService.updateIpfScheduleJob(ipfScheduleJob);
        //返回响应
        IpfScheduleJobUpdateResponse ipfScheduleJobUpdateResponse = new IpfScheduleJobUpdateResponse();
        ipfScheduleJobUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfScheduleJobUpdateResponse.setResultJson(ipfScheduleJob);
        return ipfScheduleJobUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.getIpfScheduleJob", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfScheduleJob(IpfScheduleJobGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfScheduleJob ipfScheduleJob=new IpfScheduleJob();
        ipfScheduleJob=ipfScheduleJobService.getIpfScheduleJob(id);
        //返回响应
        IpfScheduleJobGetResponse ipfScheduleJobGetResponse = new IpfScheduleJobGetResponse();
        ipfScheduleJobGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfScheduleJobGetResponse.setResultJson(ipfScheduleJob);
        return ipfScheduleJobGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfScheduleJobSelectAllRequest request) {
        IpfScheduleJobSelectAllResponse ipfScheduleJobSelectAllResponse = new IpfScheduleJobSelectAllResponse();
        ipfScheduleJobSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfScheduleJobSelectAllResponse.setResultJson(ipfScheduleJobService.selectAll());
        return ipfScheduleJobSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfScheduleJobCountAllRequest request) {
        IpfScheduleJobCountAllResponse ipfScheduleJobCountAllResponse = new IpfScheduleJobCountAllResponse();
        ipfScheduleJobCountAllResponse.setResultString(String.valueOf(ipfScheduleJobService.countAll()));
        ipfScheduleJobCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfScheduleJobCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfScheduleJobSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfScheduleJobSelectAllResponse ipfScheduleJobSelectAllResponse = new IpfScheduleJobSelectAllResponse();
        ipfScheduleJobSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfScheduleJobSelectAllResponse.setResultJson(ipfScheduleJobService.selectBySql(sqlstr));
        return ipfScheduleJobSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.selectIpfScheduleJob", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfScheduleJobSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfScheduleJob_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfScheduleJob ipfScheduleJob=new IpfScheduleJob();
        ipfScheduleJob.setId(request.getId());
        ipfScheduleJob.setJobName(request.getJobName());
        ipfScheduleJob.setJobGroup(request.getJobGroup());
        ipfScheduleJob.setJobStatus(request.getJobStatus());
        ipfScheduleJob.setCronExpression(request.getCronExpression());
        ipfScheduleJob.setJobDesc(request.getJobDesc());
        ipfScheduleJob.setRuleNo(request.getRuleNo());
        ipfScheduleJob.setJobService(request.getJobService());
        ipfScheduleJob.setJobMethod(request.getJobMethod());
    	IpfScheduleJobSelectResponse ipfScheduleJobSelectResponse = new IpfScheduleJobSelectResponse();
        ipfScheduleJobSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfScheduleJob> ipfScheduleJobs= ipfScheduleJobService.selectWithCondition(ipfScheduleJob);
        ipfScheduleJobSelectResponse.setResultJson(ipfScheduleJobs);
        return ipfScheduleJobSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfScheduleJob.isExistIpfScheduleJob", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfScheduleJob(IpfScheduleJobSelectRequest request) {
        IpfScheduleJob ipfScheduleJob=new IpfScheduleJob();
        ipfScheduleJob.setId(request.getId());
        ipfScheduleJob.setJobName(request.getJobName());
        ipfScheduleJob.setJobGroup(request.getJobGroup());
        ipfScheduleJob.setJobStatus(request.getJobStatus());
        ipfScheduleJob.setCronExpression(request.getCronExpression());
        ipfScheduleJob.setJobDesc(request.getJobDesc());
        ipfScheduleJob.setRuleNo(request.getRuleNo());
        ipfScheduleJob.setJobService(request.getJobService());
        ipfScheduleJob.setJobMethod(request.getJobMethod());
        ArrayList<IpfScheduleJob> ipfScheduleJobs= ipfScheduleJobService.selectWithCondition(ipfScheduleJob);
    	IpfScheduleJobCountAllResponse ipfScheduleJobCountAllResponse = new IpfScheduleJobCountAllResponse();
        if (ipfScheduleJobs.size()>0){
        	ipfScheduleJobCountAllResponse.setResultString("1");
        } else {
        	ipfScheduleJobCountAllResponse.setResultString("0");
        }        
        return ipfScheduleJobCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfScheduleJobCreateRequest request){
    	IpfScheduleJob ipfScheduleJob=new IpfScheduleJob();
    	ipfScheduleJob.setId(request.getId());
        ArrayList<IpfScheduleJob> ipfScheduleJobs= ipfScheduleJobService.selectWithCondition(ipfScheduleJob);
        if (ipfScheduleJobs!=null&&ipfScheduleJobs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfScheduleJobUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfScheduleJobDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfScheduleJobSelectRequest request){
        return  true;
     }    
}
