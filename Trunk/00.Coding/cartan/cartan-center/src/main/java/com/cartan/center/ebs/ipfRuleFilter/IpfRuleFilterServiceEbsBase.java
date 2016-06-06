/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRuleFilter;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfRuleFilter.request.*;
import com.cartan.center.ebs.ipfRuleFilter.response.*;
import com.cartan.core.ipfRuleFilter.domain.IpfRuleFilter;
import com.cartan.core.ipfRuleFilter.service.IpfRuleFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfRuleFilterServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfRuleFilterServiceEbs.class.getName());
	private IpfRuleFilterService  ipfRuleFilterService;
	
    public IpfRuleFilterService getIpfRuleFilterService() {
        return ipfRuleFilterService;
    }

    @Autowired
    public void setIpfRuleFilterService(IpfRuleFilterService ipfRuleFilterService) {
        this.ipfRuleFilterService = ipfRuleFilterService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfRuleFilterGetSessionRequest request) {      
    	IpfRuleFilterGetSessionResponse ipfRuleFilterGetSessionResponse = new IpfRuleFilterGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRuleFilterGetSessionResponse.setResultString("0");
        } else {
        	ipfRuleFilterGetSessionResponse.setResultString("1");
            ipfRuleFilterGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfRuleFilterGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfRuleFilterGetSessionRequest request) {
    	IpfRuleFilterGetSessionResponse ipfRuleFilterGetSessionResponse = new IpfRuleFilterGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfRuleFilterGetSessionResponse.setResultString("1");
        } else {
        	ipfRuleFilterGetSessionResponse.setResultString("0");
        }
        ipfRuleFilterGetSessionResponse.setSessionId(request.getSessionId());
        return ipfRuleFilterGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfRuleFilterGetSessionRequest request) {
    	IpfRuleFilterGetSessionResponse ipfRuleFilterGetSessionResponse = new IpfRuleFilterGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRuleFilterGetSessionResponse.setResultString("0");
        	ipfRuleFilterGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfRuleFilterGetSessionResponse.setResultString("1");
        }
        return ipfRuleFilterGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.createIpfRuleFilter", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfRuleFilter(IpfRuleFilterCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfRuleFilter_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleFilter ipfRuleFilter=new IpfRuleFilter();
        ipfRuleFilter.setId(request.getId());    		
        ipfRuleFilter.setFilterCode(request.getFilterCode());
        ipfRuleFilter.setFilterName(request.getFilterName());
        ipfRuleFilter.setFilterDesc(request.getFilterDesc());
        ipfRuleFilter.setFilterExpress(request.getFilterExpress());
        ipfRuleFilter.setIsActive(request.getIsActive());
        ipfRuleFilter.setIsSystemCreate(request.getIsSystemCreate());
        ipfRuleFilter.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfRuleFilter.setBoName(request.getBoName());
    	ipfRuleFilterService.createIpfRuleFilter(ipfRuleFilter);
        //返回响应
        IpfRuleFilterCreateResponse ipfRuleFilterCreateResponse = new IpfRuleFilterCreateResponse();
        ipfRuleFilterCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleFilterCreateResponse.setResultJson(ipfRuleFilter);
        return ipfRuleFilterCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.deleteIpfRuleFilter", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfRuleFilter(IpfRuleFilterDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfRuleFilter_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfRuleFilterService.deleteIpfRuleFilter(idstr);
        //返回响应
        IpfRuleFilterDeleteResponse ipfRuleFilterDeleteResponse = new IpfRuleFilterDeleteResponse();
        ipfRuleFilterDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRuleFilterDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.updateIpfRuleFilter", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfRuleFilter(IpfRuleFilterUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfRuleFilter_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleFilter ipfRuleFilter=new IpfRuleFilter();
        ipfRuleFilter=ipfRuleFilterService.getIpfRuleFilter(request.getId());
        if (request.getId()!=null){
	        ipfRuleFilter.setId(request.getId());
        }
        if (request.getFilterCode()!=null){
	        ipfRuleFilter.setFilterCode(request.getFilterCode());
        }
        if (request.getFilterName()!=null){
	        ipfRuleFilter.setFilterName(request.getFilterName());
        }
        if (request.getFilterDesc()!=null){
	        ipfRuleFilter.setFilterDesc(request.getFilterDesc());
        }
        if (request.getFilterExpress()!=null){
	        ipfRuleFilter.setFilterExpress(request.getFilterExpress());
        }
        if (request.getIsActive()!=null){
	        ipfRuleFilter.setIsActive(request.getIsActive());
        }
        if (request.getIsSystemCreate()!=null){
	        ipfRuleFilter.setIsSystemCreate(request.getIsSystemCreate());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfRuleFilter.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getBoName()!=null){
	        ipfRuleFilter.setBoName(request.getBoName());
        }
    	ipfRuleFilterService.updateIpfRuleFilter(ipfRuleFilter);
        //返回响应
        IpfRuleFilterUpdateResponse ipfRuleFilterUpdateResponse = new IpfRuleFilterUpdateResponse();
        ipfRuleFilterUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleFilterUpdateResponse.setResultJson(ipfRuleFilter);
        return ipfRuleFilterUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.getIpfRuleFilter", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfRuleFilter(IpfRuleFilterGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfRuleFilter ipfRuleFilter=new IpfRuleFilter();
        ipfRuleFilter=ipfRuleFilterService.getIpfRuleFilter(id);
        //返回响应
        IpfRuleFilterGetResponse ipfRuleFilterGetResponse = new IpfRuleFilterGetResponse();
        ipfRuleFilterGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleFilterGetResponse.setResultJson(ipfRuleFilter);
        return ipfRuleFilterGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfRuleFilterSelectAllRequest request) {
        IpfRuleFilterSelectAllResponse ipfRuleFilterSelectAllResponse = new IpfRuleFilterSelectAllResponse();
        ipfRuleFilterSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleFilterSelectAllResponse.setResultJson(ipfRuleFilterService.selectAll());
        return ipfRuleFilterSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfRuleFilterCountAllRequest request) {
        IpfRuleFilterCountAllResponse ipfRuleFilterCountAllResponse = new IpfRuleFilterCountAllResponse();
        ipfRuleFilterCountAllResponse.setResultString(String.valueOf(ipfRuleFilterService.countAll()));
        ipfRuleFilterCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRuleFilterCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfRuleFilterSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfRuleFilterSelectAllResponse ipfRuleFilterSelectAllResponse = new IpfRuleFilterSelectAllResponse();
        ipfRuleFilterSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleFilterSelectAllResponse.setResultJson(ipfRuleFilterService.selectBySql(sqlstr));
        return ipfRuleFilterSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.selectIpfRuleFilter", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfRuleFilterSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfRuleFilter_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleFilter ipfRuleFilter=new IpfRuleFilter();
        ipfRuleFilter.setId(request.getId());
        ipfRuleFilter.setFilterCode(request.getFilterCode());
        ipfRuleFilter.setFilterName(request.getFilterName());
        ipfRuleFilter.setFilterDesc(request.getFilterDesc());
        ipfRuleFilter.setFilterExpress(request.getFilterExpress());
        ipfRuleFilter.setIsActive(request.getIsActive());
        ipfRuleFilter.setIsSystemCreate(request.getIsSystemCreate());
        ipfRuleFilter.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfRuleFilter.setBoName(request.getBoName());
    	IpfRuleFilterSelectResponse ipfRuleFilterSelectResponse = new IpfRuleFilterSelectResponse();
        ipfRuleFilterSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfRuleFilter> ipfRuleFilters= ipfRuleFilterService.selectWithCondition(ipfRuleFilter);
        ipfRuleFilterSelectResponse.setResultJson(ipfRuleFilters);
        return ipfRuleFilterSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilter.isExistIpfRuleFilter", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfRuleFilter(IpfRuleFilterSelectRequest request) {
        IpfRuleFilter ipfRuleFilter=new IpfRuleFilter();
        ipfRuleFilter.setId(request.getId());
        ipfRuleFilter.setFilterCode(request.getFilterCode());
        ipfRuleFilter.setFilterName(request.getFilterName());
        ipfRuleFilter.setFilterDesc(request.getFilterDesc());
        ipfRuleFilter.setFilterExpress(request.getFilterExpress());
        ipfRuleFilter.setIsActive(request.getIsActive());
        ipfRuleFilter.setIsSystemCreate(request.getIsSystemCreate());
        ipfRuleFilter.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfRuleFilter.setBoName(request.getBoName());
        ArrayList<IpfRuleFilter> ipfRuleFilters= ipfRuleFilterService.selectWithCondition(ipfRuleFilter);
    	IpfRuleFilterCountAllResponse ipfRuleFilterCountAllResponse = new IpfRuleFilterCountAllResponse();
        if (ipfRuleFilters.size()>0){
        	ipfRuleFilterCountAllResponse.setResultString("1");
        } else {
        	ipfRuleFilterCountAllResponse.setResultString("0");
        }        
        return ipfRuleFilterCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfRuleFilterCreateRequest request){
    	IpfRuleFilter ipfRuleFilter=new IpfRuleFilter();
    	ipfRuleFilter.setId(request.getId());
        ArrayList<IpfRuleFilter> ipfRuleFilters= ipfRuleFilterService.selectWithCondition(ipfRuleFilter);
        if (ipfRuleFilters!=null&&ipfRuleFilters.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfRuleFilterUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfRuleFilterDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfRuleFilterSelectRequest request){
        return  true;
     }    
}
