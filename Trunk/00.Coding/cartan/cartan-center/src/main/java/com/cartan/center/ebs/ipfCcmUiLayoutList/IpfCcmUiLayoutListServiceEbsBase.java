/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayoutList;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmUiLayoutList.request.*;
import com.cartan.center.ebs.ipfCcmUiLayoutList.response.*;
import com.cartan.core.ipfCcmUiLayoutList.domain.IpfCcmUiLayoutList;
import com.cartan.core.ipfCcmUiLayoutList.service.IpfCcmUiLayoutListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmUiLayoutListServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmUiLayoutListServiceEbs.class.getName());
	private IpfCcmUiLayoutListService  ipfCcmUiLayoutListService;
	
    public IpfCcmUiLayoutListService getIpfCcmUiLayoutListService() {
        return ipfCcmUiLayoutListService;
    }

    @Autowired
    public void setIpfCcmUiLayoutListService(IpfCcmUiLayoutListService ipfCcmUiLayoutListService) {
        this.ipfCcmUiLayoutListService = ipfCcmUiLayoutListService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmUiLayoutListGetSessionRequest request) {      
    	IpfCcmUiLayoutListGetSessionResponse ipfCcmUiLayoutListGetSessionResponse = new IpfCcmUiLayoutListGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmUiLayoutListGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmUiLayoutListGetSessionResponse.setResultString("1");
            ipfCcmUiLayoutListGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmUiLayoutListGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmUiLayoutListGetSessionRequest request) {
    	IpfCcmUiLayoutListGetSessionResponse ipfCcmUiLayoutListGetSessionResponse = new IpfCcmUiLayoutListGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmUiLayoutListGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmUiLayoutListGetSessionResponse.setResultString("0");
        }
        ipfCcmUiLayoutListGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmUiLayoutListGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmUiLayoutListGetSessionRequest request) {
    	IpfCcmUiLayoutListGetSessionResponse ipfCcmUiLayoutListGetSessionResponse = new IpfCcmUiLayoutListGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmUiLayoutListGetSessionResponse.setResultString("0");
        	ipfCcmUiLayoutListGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmUiLayoutListGetSessionResponse.setResultString("1");
        }
        return ipfCcmUiLayoutListGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.createIpfCcmUiLayoutList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmUiLayoutList(IpfCcmUiLayoutListCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmUiLayoutList_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayoutList ipfCcmUiLayoutList=new IpfCcmUiLayoutList();
        ipfCcmUiLayoutList.setId(request.getId());    		
        ipfCcmUiLayoutList.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        ipfCcmUiLayoutList.setPageName(request.getPageName());
        ipfCcmUiLayoutList.setDescription(request.getDescription());
        ipfCcmUiLayoutList.setImagePath(request.getImagePath());
    	ipfCcmUiLayoutListService.createIpfCcmUiLayoutList(ipfCcmUiLayoutList);
        //返回响应
        IpfCcmUiLayoutListCreateResponse ipfCcmUiLayoutListCreateResponse = new IpfCcmUiLayoutListCreateResponse();
        ipfCcmUiLayoutListCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutListCreateResponse.setResultJson(ipfCcmUiLayoutList);
        return ipfCcmUiLayoutListCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.deleteIpfCcmUiLayoutList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmUiLayoutList(IpfCcmUiLayoutListDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmUiLayoutList_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmUiLayoutListService.deleteIpfCcmUiLayoutList(idstr);
        //返回响应
        IpfCcmUiLayoutListDeleteResponse ipfCcmUiLayoutListDeleteResponse = new IpfCcmUiLayoutListDeleteResponse();
        ipfCcmUiLayoutListDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmUiLayoutListDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.updateIpfCcmUiLayoutList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmUiLayoutList(IpfCcmUiLayoutListUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmUiLayoutList_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayoutList ipfCcmUiLayoutList=new IpfCcmUiLayoutList();
        ipfCcmUiLayoutList=ipfCcmUiLayoutListService.getIpfCcmUiLayoutList(request.getId());
        if (request.getId()!=null){
	        ipfCcmUiLayoutList.setId(request.getId());
        }
        if (request.getIpfCcmUiLayoutId()!=null){
	        ipfCcmUiLayoutList.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        }
        if (request.getPageName()!=null){
	        ipfCcmUiLayoutList.setPageName(request.getPageName());
        }
        if (request.getDescription()!=null){
	        ipfCcmUiLayoutList.setDescription(request.getDescription());
        }
        if (request.getImagePath()!=null){
	        ipfCcmUiLayoutList.setImagePath(request.getImagePath());
        }
    	ipfCcmUiLayoutListService.updateIpfCcmUiLayoutList(ipfCcmUiLayoutList);
        //返回响应
        IpfCcmUiLayoutListUpdateResponse ipfCcmUiLayoutListUpdateResponse = new IpfCcmUiLayoutListUpdateResponse();
        ipfCcmUiLayoutListUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutListUpdateResponse.setResultJson(ipfCcmUiLayoutList);
        return ipfCcmUiLayoutListUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.getIpfCcmUiLayoutList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmUiLayoutList(IpfCcmUiLayoutListGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmUiLayoutList ipfCcmUiLayoutList=new IpfCcmUiLayoutList();
        ipfCcmUiLayoutList=ipfCcmUiLayoutListService.getIpfCcmUiLayoutList(id);
        //返回响应
        IpfCcmUiLayoutListGetResponse ipfCcmUiLayoutListGetResponse = new IpfCcmUiLayoutListGetResponse();
        ipfCcmUiLayoutListGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutListGetResponse.setResultJson(ipfCcmUiLayoutList);
        return ipfCcmUiLayoutListGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmUiLayoutListSelectAllRequest request) {
        IpfCcmUiLayoutListSelectAllResponse ipfCcmUiLayoutListSelectAllResponse = new IpfCcmUiLayoutListSelectAllResponse();
        ipfCcmUiLayoutListSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutListSelectAllResponse.setResultJson(ipfCcmUiLayoutListService.selectAll());
        return ipfCcmUiLayoutListSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmUiLayoutListCountAllRequest request) {
        IpfCcmUiLayoutListCountAllResponse ipfCcmUiLayoutListCountAllResponse = new IpfCcmUiLayoutListCountAllResponse();
        ipfCcmUiLayoutListCountAllResponse.setResultString(String.valueOf(ipfCcmUiLayoutListService.countAll()));
        ipfCcmUiLayoutListCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmUiLayoutListCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmUiLayoutListSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmUiLayoutListSelectAllResponse ipfCcmUiLayoutListSelectAllResponse = new IpfCcmUiLayoutListSelectAllResponse();
        ipfCcmUiLayoutListSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutListSelectAllResponse.setResultJson(ipfCcmUiLayoutListService.selectBySql(sqlstr));
        return ipfCcmUiLayoutListSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.selectIpfCcmUiLayoutList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmUiLayoutListSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmUiLayoutList_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayoutList ipfCcmUiLayoutList=new IpfCcmUiLayoutList();
        ipfCcmUiLayoutList.setId(request.getId());
        ipfCcmUiLayoutList.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        ipfCcmUiLayoutList.setPageName(request.getPageName());
        ipfCcmUiLayoutList.setDescription(request.getDescription());
        ipfCcmUiLayoutList.setImagePath(request.getImagePath());
    	IpfCcmUiLayoutListSelectResponse ipfCcmUiLayoutListSelectResponse = new IpfCcmUiLayoutListSelectResponse();
        ipfCcmUiLayoutListSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmUiLayoutList> ipfCcmUiLayoutLists= ipfCcmUiLayoutListService.selectWithCondition(ipfCcmUiLayoutList);
        ipfCcmUiLayoutListSelectResponse.setResultJson(ipfCcmUiLayoutLists);
        return ipfCcmUiLayoutListSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutList.isExistIpfCcmUiLayoutList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmUiLayoutList(IpfCcmUiLayoutListSelectRequest request) {
        IpfCcmUiLayoutList ipfCcmUiLayoutList=new IpfCcmUiLayoutList();
        ipfCcmUiLayoutList.setId(request.getId());
        ipfCcmUiLayoutList.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        ipfCcmUiLayoutList.setPageName(request.getPageName());
        ipfCcmUiLayoutList.setDescription(request.getDescription());
        ipfCcmUiLayoutList.setImagePath(request.getImagePath());
        ArrayList<IpfCcmUiLayoutList> ipfCcmUiLayoutLists= ipfCcmUiLayoutListService.selectWithCondition(ipfCcmUiLayoutList);
    	IpfCcmUiLayoutListCountAllResponse ipfCcmUiLayoutListCountAllResponse = new IpfCcmUiLayoutListCountAllResponse();
        if (ipfCcmUiLayoutLists.size()>0){
        	ipfCcmUiLayoutListCountAllResponse.setResultString("1");
        } else {
        	ipfCcmUiLayoutListCountAllResponse.setResultString("0");
        }        
        return ipfCcmUiLayoutListCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmUiLayoutListCreateRequest request){
    	IpfCcmUiLayoutList ipfCcmUiLayoutList=new IpfCcmUiLayoutList();
    	ipfCcmUiLayoutList.setId(request.getId());
        ArrayList<IpfCcmUiLayoutList> ipfCcmUiLayoutLists= ipfCcmUiLayoutListService.selectWithCondition(ipfCcmUiLayoutList);
        if (ipfCcmUiLayoutLists!=null&&ipfCcmUiLayoutLists.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmUiLayoutListUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmUiLayoutListDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmUiLayoutListSelectRequest request){
        return  true;
     }    
}
