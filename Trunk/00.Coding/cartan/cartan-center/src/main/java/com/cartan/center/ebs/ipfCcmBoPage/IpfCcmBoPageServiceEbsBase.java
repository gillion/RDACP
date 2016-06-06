/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoPage;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoPage.request.*;
import com.cartan.center.ebs.ipfCcmBoPage.response.*;
import com.cartan.core.ipfCcmBoPage.domain.IpfCcmBoPage;
import com.cartan.core.ipfCcmBoPage.service.IpfCcmBoPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoPageServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoPageServiceEbs.class.getName());
	private IpfCcmBoPageService  ipfCcmBoPageService;
	
    public IpfCcmBoPageService getIpfCcmBoPageService() {
        return ipfCcmBoPageService;
    }

    @Autowired
    public void setIpfCcmBoPageService(IpfCcmBoPageService ipfCcmBoPageService) {
        this.ipfCcmBoPageService = ipfCcmBoPageService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoPageGetSessionRequest request) {      
    	IpfCcmBoPageGetSessionResponse ipfCcmBoPageGetSessionResponse = new IpfCcmBoPageGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoPageGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoPageGetSessionResponse.setResultString("1");
            ipfCcmBoPageGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoPageGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoPageGetSessionRequest request) {
    	IpfCcmBoPageGetSessionResponse ipfCcmBoPageGetSessionResponse = new IpfCcmBoPageGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoPageGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoPageGetSessionResponse.setResultString("0");
        }
        ipfCcmBoPageGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoPageGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoPageGetSessionRequest request) {
    	IpfCcmBoPageGetSessionResponse ipfCcmBoPageGetSessionResponse = new IpfCcmBoPageGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoPageGetSessionResponse.setResultString("0");
        	ipfCcmBoPageGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoPageGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoPageGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.createIpfCcmBoPage", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoPage(IpfCcmBoPageCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoPage_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPage ipfCcmBoPage=new IpfCcmBoPage();
        ipfCcmBoPage.setId(request.getId());    		
        ipfCcmBoPage.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoPage.setPageType(request.getPageType());
        ipfCcmBoPage.setDescription(request.getDescription());
        ipfCcmBoPage.setPageName(request.getPageName());
    	ipfCcmBoPageService.createIpfCcmBoPage(ipfCcmBoPage);
        //返回响应
        IpfCcmBoPageCreateResponse ipfCcmBoPageCreateResponse = new IpfCcmBoPageCreateResponse();
        ipfCcmBoPageCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPageCreateResponse.setResultJson(ipfCcmBoPage);
        return ipfCcmBoPageCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.deleteIpfCcmBoPage", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoPage(IpfCcmBoPageDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoPage_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoPageService.deleteIpfCcmBoPage(idstr);
        //返回响应
        IpfCcmBoPageDeleteResponse ipfCcmBoPageDeleteResponse = new IpfCcmBoPageDeleteResponse();
        ipfCcmBoPageDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoPageDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.updateIpfCcmBoPage", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoPage(IpfCcmBoPageUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoPage_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPage ipfCcmBoPage=new IpfCcmBoPage();
        ipfCcmBoPage=ipfCcmBoPageService.getIpfCcmBoPage(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoPage.setId(request.getId());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfCcmBoPage.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getPageType()!=null){
	        ipfCcmBoPage.setPageType(request.getPageType());
        }
        if (request.getDescription()!=null){
	        ipfCcmBoPage.setDescription(request.getDescription());
        }
        if (request.getPageName()!=null){
	        ipfCcmBoPage.setPageName(request.getPageName());
        }
    	ipfCcmBoPageService.updateIpfCcmBoPage(ipfCcmBoPage);
        //返回响应
        IpfCcmBoPageUpdateResponse ipfCcmBoPageUpdateResponse = new IpfCcmBoPageUpdateResponse();
        ipfCcmBoPageUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPageUpdateResponse.setResultJson(ipfCcmBoPage);
        return ipfCcmBoPageUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.getIpfCcmBoPage", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoPage(IpfCcmBoPageGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoPage ipfCcmBoPage=new IpfCcmBoPage();
        ipfCcmBoPage=ipfCcmBoPageService.getIpfCcmBoPage(id);
        //返回响应
        IpfCcmBoPageGetResponse ipfCcmBoPageGetResponse = new IpfCcmBoPageGetResponse();
        ipfCcmBoPageGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPageGetResponse.setResultJson(ipfCcmBoPage);
        return ipfCcmBoPageGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoPageSelectAllRequest request) {
        IpfCcmBoPageSelectAllResponse ipfCcmBoPageSelectAllResponse = new IpfCcmBoPageSelectAllResponse();
        ipfCcmBoPageSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPageSelectAllResponse.setResultJson(ipfCcmBoPageService.selectAll());
        return ipfCcmBoPageSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoPageCountAllRequest request) {
        IpfCcmBoPageCountAllResponse ipfCcmBoPageCountAllResponse = new IpfCcmBoPageCountAllResponse();
        ipfCcmBoPageCountAllResponse.setResultString(String.valueOf(ipfCcmBoPageService.countAll()));
        ipfCcmBoPageCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoPageCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoPageSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoPageSelectAllResponse ipfCcmBoPageSelectAllResponse = new IpfCcmBoPageSelectAllResponse();
        ipfCcmBoPageSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPageSelectAllResponse.setResultJson(ipfCcmBoPageService.selectBySql(sqlstr));
        return ipfCcmBoPageSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.selectIpfCcmBoPage", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoPageSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoPage_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPage ipfCcmBoPage=new IpfCcmBoPage();
        ipfCcmBoPage.setId(request.getId());
        ipfCcmBoPage.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoPage.setPageType(request.getPageType());
        ipfCcmBoPage.setDescription(request.getDescription());
        ipfCcmBoPage.setPageName(request.getPageName());
    	IpfCcmBoPageSelectResponse ipfCcmBoPageSelectResponse = new IpfCcmBoPageSelectResponse();
        ipfCcmBoPageSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoPage> ipfCcmBoPages= ipfCcmBoPageService.selectWithCondition(ipfCcmBoPage);
        ipfCcmBoPageSelectResponse.setResultJson(ipfCcmBoPages);
        return ipfCcmBoPageSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPage.isExistIpfCcmBoPage", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoPage(IpfCcmBoPageSelectRequest request) {
        IpfCcmBoPage ipfCcmBoPage=new IpfCcmBoPage();
        ipfCcmBoPage.setId(request.getId());
        ipfCcmBoPage.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoPage.setPageType(request.getPageType());
        ipfCcmBoPage.setDescription(request.getDescription());
        ipfCcmBoPage.setPageName(request.getPageName());
        ArrayList<IpfCcmBoPage> ipfCcmBoPages= ipfCcmBoPageService.selectWithCondition(ipfCcmBoPage);
    	IpfCcmBoPageCountAllResponse ipfCcmBoPageCountAllResponse = new IpfCcmBoPageCountAllResponse();
        if (ipfCcmBoPages.size()>0){
        	ipfCcmBoPageCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoPageCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoPageCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoPageCreateRequest request){
    	IpfCcmBoPage ipfCcmBoPage=new IpfCcmBoPage();
    	ipfCcmBoPage.setId(request.getId());
        ArrayList<IpfCcmBoPage> ipfCcmBoPages= ipfCcmBoPageService.selectWithCondition(ipfCcmBoPage);
        if (ipfCcmBoPages!=null&&ipfCcmBoPages.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoPageUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoPageDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoPageSelectRequest request){
        return  true;
     }    
}
