/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlView;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlView.request.*;
import com.cartan.center.ebs.ipfDmlView.response.*;
import com.cartan.core.ipfDmlView.domain.IpfDmlView;
import com.cartan.core.ipfDmlView.service.IpfDmlViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlViewServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlViewServiceEbs.class.getName());
	private IpfDmlViewService  ipfDmlViewService;
	
    public IpfDmlViewService getIpfDmlViewService() {
        return ipfDmlViewService;
    }

    @Autowired
    public void setIpfDmlViewService(IpfDmlViewService ipfDmlViewService) {
        this.ipfDmlViewService = ipfDmlViewService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlViewGetSessionRequest request) {      
    	IpfDmlViewGetSessionResponse ipfDmlViewGetSessionResponse = new IpfDmlViewGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlViewGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlViewGetSessionResponse.setResultString("1");
            ipfDmlViewGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlViewGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlViewGetSessionRequest request) {
    	IpfDmlViewGetSessionResponse ipfDmlViewGetSessionResponse = new IpfDmlViewGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlViewGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlViewGetSessionResponse.setResultString("0");
        }
        ipfDmlViewGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlViewGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlViewGetSessionRequest request) {
    	IpfDmlViewGetSessionResponse ipfDmlViewGetSessionResponse = new IpfDmlViewGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlViewGetSessionResponse.setResultString("0");
        	ipfDmlViewGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlViewGetSessionResponse.setResultString("1");
        }
        return ipfDmlViewGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.createIpfDmlView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlView(IpfDmlViewCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlView_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlView ipfDmlView=new IpfDmlView();
        ipfDmlView.setId(request.getId());    		
        ipfDmlView.setViewName(request.getViewName());
        ipfDmlView.setViewDes(request.getViewDes());
        ipfDmlView.setViewType(request.getViewType());
    	ipfDmlViewService.createIpfDmlView(ipfDmlView);
        //返回响应
        IpfDmlViewCreateResponse ipfDmlViewCreateResponse = new IpfDmlViewCreateResponse();
        ipfDmlViewCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewCreateResponse.setResultJson(ipfDmlView);
        return ipfDmlViewCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.deleteIpfDmlView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlView(IpfDmlViewDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlView_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlViewService.deleteIpfDmlView(idstr);
        //返回响应
        IpfDmlViewDeleteResponse ipfDmlViewDeleteResponse = new IpfDmlViewDeleteResponse();
        ipfDmlViewDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlViewDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.updateIpfDmlView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlView(IpfDmlViewUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlView_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlView ipfDmlView=new IpfDmlView();
        ipfDmlView=ipfDmlViewService.getIpfDmlView(request.getId());
        if (request.getId()!=null){
	        ipfDmlView.setId(request.getId());
        }
        if (request.getViewName()!=null){
	        ipfDmlView.setViewName(request.getViewName());
        }
        if (request.getViewDes()!=null){
	        ipfDmlView.setViewDes(request.getViewDes());
        }
        if (request.getViewType()!=null){
	        ipfDmlView.setViewType(request.getViewType());
        }
    	ipfDmlViewService.updateIpfDmlView(ipfDmlView);
        //返回响应
        IpfDmlViewUpdateResponse ipfDmlViewUpdateResponse = new IpfDmlViewUpdateResponse();
        ipfDmlViewUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewUpdateResponse.setResultJson(ipfDmlView);
        return ipfDmlViewUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.getIpfDmlView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlView(IpfDmlViewGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlView ipfDmlView=new IpfDmlView();
        ipfDmlView=ipfDmlViewService.getIpfDmlView(id);
        //返回响应
        IpfDmlViewGetResponse ipfDmlViewGetResponse = new IpfDmlViewGetResponse();
        ipfDmlViewGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewGetResponse.setResultJson(ipfDmlView);
        return ipfDmlViewGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlViewSelectAllRequest request) {
        IpfDmlViewSelectAllResponse ipfDmlViewSelectAllResponse = new IpfDmlViewSelectAllResponse();
        ipfDmlViewSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewSelectAllResponse.setResultJson(ipfDmlViewService.selectAll());
        return ipfDmlViewSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlViewCountAllRequest request) {
        IpfDmlViewCountAllResponse ipfDmlViewCountAllResponse = new IpfDmlViewCountAllResponse();
        ipfDmlViewCountAllResponse.setResultString(String.valueOf(ipfDmlViewService.countAll()));
        ipfDmlViewCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlViewCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlViewSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlViewSelectAllResponse ipfDmlViewSelectAllResponse = new IpfDmlViewSelectAllResponse();
        ipfDmlViewSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlViewSelectAllResponse.setResultJson(ipfDmlViewService.selectBySql(sqlstr));
        return ipfDmlViewSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.selectIpfDmlView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlViewSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlView_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlView ipfDmlView=new IpfDmlView();
        ipfDmlView.setId(request.getId());
        ipfDmlView.setViewName(request.getViewName());
        ipfDmlView.setViewDes(request.getViewDes());
        ipfDmlView.setViewType(request.getViewType());
    	IpfDmlViewSelectResponse ipfDmlViewSelectResponse = new IpfDmlViewSelectResponse();
        ipfDmlViewSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlView> ipfDmlViews= ipfDmlViewService.selectWithCondition(ipfDmlView);
        ipfDmlViewSelectResponse.setResultJson(ipfDmlViews);
        return ipfDmlViewSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlView.isExistIpfDmlView", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlView(IpfDmlViewSelectRequest request) {
        IpfDmlView ipfDmlView=new IpfDmlView();
        ipfDmlView.setId(request.getId());
        ipfDmlView.setViewName(request.getViewName());
        ipfDmlView.setViewDes(request.getViewDes());
        ipfDmlView.setViewType(request.getViewType());
        ArrayList<IpfDmlView> ipfDmlViews= ipfDmlViewService.selectWithCondition(ipfDmlView);
    	IpfDmlViewCountAllResponse ipfDmlViewCountAllResponse = new IpfDmlViewCountAllResponse();
        if (ipfDmlViews.size()>0){
        	ipfDmlViewCountAllResponse.setResultString("1");
        } else {
        	ipfDmlViewCountAllResponse.setResultString("0");
        }        
        return ipfDmlViewCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlViewCreateRequest request){
    	IpfDmlView ipfDmlView=new IpfDmlView();
    	ipfDmlView.setId(request.getId());
        ArrayList<IpfDmlView> ipfDmlViews= ipfDmlViewService.selectWithCondition(ipfDmlView);
        if (ipfDmlViews!=null&&ipfDmlViews.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlViewUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlViewDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlViewSelectRequest request){
        return  true;
     }    
}
