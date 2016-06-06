/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmShlp;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmShlp.request.*;
import com.cartan.center.ebs.ipfCcmShlp.response.*;
import com.cartan.core.ipfCcmShlp.domain.IpfCcmShlp;
import com.cartan.core.ipfCcmShlp.service.IpfCcmShlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmShlpServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmShlpServiceEbs.class.getName());
	private IpfCcmShlpService  ipfCcmShlpService;
	
    public IpfCcmShlpService getIpfCcmShlpService() {
        return ipfCcmShlpService;
    }

    @Autowired
    public void setIpfCcmShlpService(IpfCcmShlpService ipfCcmShlpService) {
        this.ipfCcmShlpService = ipfCcmShlpService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmShlpGetSessionRequest request) {      
    	IpfCcmShlpGetSessionResponse ipfCcmShlpGetSessionResponse = new IpfCcmShlpGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmShlpGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmShlpGetSessionResponse.setResultString("1");
            ipfCcmShlpGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmShlpGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmShlpGetSessionRequest request) {
    	IpfCcmShlpGetSessionResponse ipfCcmShlpGetSessionResponse = new IpfCcmShlpGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmShlpGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmShlpGetSessionResponse.setResultString("0");
        }
        ipfCcmShlpGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmShlpGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmShlpGetSessionRequest request) {
    	IpfCcmShlpGetSessionResponse ipfCcmShlpGetSessionResponse = new IpfCcmShlpGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmShlpGetSessionResponse.setResultString("0");
        	ipfCcmShlpGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmShlpGetSessionResponse.setResultString("1");
        }
        return ipfCcmShlpGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.createIpfCcmShlp", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmShlp(IpfCcmShlpCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmShlp_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmShlp ipfCcmShlp=new IpfCcmShlp();
        ipfCcmShlp.setId(request.getId());    		
        ipfCcmShlp.setShlpName(request.getShlpName());
        ipfCcmShlp.setShlpStatus(request.getShlpStatus());
        ipfCcmShlp.setDataSource(request.getDataSource());
        ipfCcmShlp.setDataSourceType(request.getDataSourceType());
        ipfCcmShlp.setValueColumn(request.getValueColumn());
        ipfCcmShlp.setDisplayColumn(request.getDisplayColumn());
        ipfCcmShlp.setRuleNo(request.getRuleNo());
    	ipfCcmShlpService.createIpfCcmShlp(ipfCcmShlp);
        //返回响应
        IpfCcmShlpCreateResponse ipfCcmShlpCreateResponse = new IpfCcmShlpCreateResponse();
        ipfCcmShlpCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpCreateResponse.setResultJson(ipfCcmShlp);
        return ipfCcmShlpCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.deleteIpfCcmShlp", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmShlp(IpfCcmShlpDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmShlp_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmShlpService.deleteIpfCcmShlp(idstr);
        //返回响应
        IpfCcmShlpDeleteResponse ipfCcmShlpDeleteResponse = new IpfCcmShlpDeleteResponse();
        ipfCcmShlpDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmShlpDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.updateIpfCcmShlp", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmShlp(IpfCcmShlpUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmShlp_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmShlp ipfCcmShlp=new IpfCcmShlp();
        ipfCcmShlp=ipfCcmShlpService.getIpfCcmShlp(request.getId());
        if (request.getId()!=null){
	        ipfCcmShlp.setId(request.getId());
        }
        if (request.getShlpName()!=null){
	        ipfCcmShlp.setShlpName(request.getShlpName());
        }
        if (request.getShlpStatus()!=null){
	        ipfCcmShlp.setShlpStatus(request.getShlpStatus());
        }
        if (request.getDataSource()!=null){
	        ipfCcmShlp.setDataSource(request.getDataSource());
        }
        if (request.getDataSourceType()!=null){
	        ipfCcmShlp.setDataSourceType(request.getDataSourceType());
        }
        if (request.getValueColumn()!=null){
	        ipfCcmShlp.setValueColumn(request.getValueColumn());
        }
        if (request.getDisplayColumn()!=null){
	        ipfCcmShlp.setDisplayColumn(request.getDisplayColumn());
        }
        if (request.getRuleNo()!=null){
	        ipfCcmShlp.setRuleNo(request.getRuleNo());
        }
    	ipfCcmShlpService.updateIpfCcmShlp(ipfCcmShlp);
        //返回响应
        IpfCcmShlpUpdateResponse ipfCcmShlpUpdateResponse = new IpfCcmShlpUpdateResponse();
        ipfCcmShlpUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpUpdateResponse.setResultJson(ipfCcmShlp);
        return ipfCcmShlpUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.getIpfCcmShlp", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmShlp(IpfCcmShlpGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmShlp ipfCcmShlp=new IpfCcmShlp();
        ipfCcmShlp=ipfCcmShlpService.getIpfCcmShlp(id);
        //返回响应
        IpfCcmShlpGetResponse ipfCcmShlpGetResponse = new IpfCcmShlpGetResponse();
        ipfCcmShlpGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpGetResponse.setResultJson(ipfCcmShlp);
        return ipfCcmShlpGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmShlpSelectAllRequest request) {
        IpfCcmShlpSelectAllResponse ipfCcmShlpSelectAllResponse = new IpfCcmShlpSelectAllResponse();
        ipfCcmShlpSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpSelectAllResponse.setResultJson(ipfCcmShlpService.selectAll());
        return ipfCcmShlpSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmShlpCountAllRequest request) {
        IpfCcmShlpCountAllResponse ipfCcmShlpCountAllResponse = new IpfCcmShlpCountAllResponse();
        ipfCcmShlpCountAllResponse.setResultString(String.valueOf(ipfCcmShlpService.countAll()));
        ipfCcmShlpCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmShlpCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmShlpSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmShlpSelectAllResponse ipfCcmShlpSelectAllResponse = new IpfCcmShlpSelectAllResponse();
        ipfCcmShlpSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpSelectAllResponse.setResultJson(ipfCcmShlpService.selectBySql(sqlstr));
        return ipfCcmShlpSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.selectIpfCcmShlp", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmShlpSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmShlp_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmShlp ipfCcmShlp=new IpfCcmShlp();
        ipfCcmShlp.setId(request.getId());
        ipfCcmShlp.setShlpName(request.getShlpName());
        ipfCcmShlp.setShlpStatus(request.getShlpStatus());
        ipfCcmShlp.setDataSource(request.getDataSource());
        ipfCcmShlp.setDataSourceType(request.getDataSourceType());
        ipfCcmShlp.setValueColumn(request.getValueColumn());
        ipfCcmShlp.setDisplayColumn(request.getDisplayColumn());
        ipfCcmShlp.setRuleNo(request.getRuleNo());
    	IpfCcmShlpSelectResponse ipfCcmShlpSelectResponse = new IpfCcmShlpSelectResponse();
        ipfCcmShlpSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmShlp> ipfCcmShlps= ipfCcmShlpService.selectWithCondition(ipfCcmShlp);
        ipfCcmShlpSelectResponse.setResultJson(ipfCcmShlps);
        return ipfCcmShlpSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlp.isExistIpfCcmShlp", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmShlp(IpfCcmShlpSelectRequest request) {
        IpfCcmShlp ipfCcmShlp=new IpfCcmShlp();
        ipfCcmShlp.setId(request.getId());
        ipfCcmShlp.setShlpName(request.getShlpName());
        ipfCcmShlp.setShlpStatus(request.getShlpStatus());
        ipfCcmShlp.setDataSource(request.getDataSource());
        ipfCcmShlp.setDataSourceType(request.getDataSourceType());
        ipfCcmShlp.setValueColumn(request.getValueColumn());
        ipfCcmShlp.setDisplayColumn(request.getDisplayColumn());
        ipfCcmShlp.setRuleNo(request.getRuleNo());
        ArrayList<IpfCcmShlp> ipfCcmShlps= ipfCcmShlpService.selectWithCondition(ipfCcmShlp);
    	IpfCcmShlpCountAllResponse ipfCcmShlpCountAllResponse = new IpfCcmShlpCountAllResponse();
        if (ipfCcmShlps.size()>0){
        	ipfCcmShlpCountAllResponse.setResultString("1");
        } else {
        	ipfCcmShlpCountAllResponse.setResultString("0");
        }        
        return ipfCcmShlpCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmShlpCreateRequest request){
    	IpfCcmShlp ipfCcmShlp=new IpfCcmShlp();
    	ipfCcmShlp.setId(request.getId());
        ArrayList<IpfCcmShlp> ipfCcmShlps= ipfCcmShlpService.selectWithCondition(ipfCcmShlp);
        if (ipfCcmShlps!=null&&ipfCcmShlps.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmShlpUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmShlpDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmShlpSelectRequest request){
        return  true;
     }    
}
