/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayout;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmUiLayout.request.*;
import com.cartan.center.ebs.ipfCcmUiLayout.response.*;
import com.cartan.core.ipfCcmUiLayout.domain.IpfCcmUiLayout;
import com.cartan.core.ipfCcmUiLayout.service.IpfCcmUiLayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmUiLayoutServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmUiLayoutServiceEbs.class.getName());
	private IpfCcmUiLayoutService  ipfCcmUiLayoutService;
	
    public IpfCcmUiLayoutService getIpfCcmUiLayoutService() {
        return ipfCcmUiLayoutService;
    }

    @Autowired
    public void setIpfCcmUiLayoutService(IpfCcmUiLayoutService ipfCcmUiLayoutService) {
        this.ipfCcmUiLayoutService = ipfCcmUiLayoutService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmUiLayoutGetSessionRequest request) {      
    	IpfCcmUiLayoutGetSessionResponse ipfCcmUiLayoutGetSessionResponse = new IpfCcmUiLayoutGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmUiLayoutGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmUiLayoutGetSessionResponse.setResultString("1");
            ipfCcmUiLayoutGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmUiLayoutGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmUiLayoutGetSessionRequest request) {
    	IpfCcmUiLayoutGetSessionResponse ipfCcmUiLayoutGetSessionResponse = new IpfCcmUiLayoutGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmUiLayoutGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmUiLayoutGetSessionResponse.setResultString("0");
        }
        ipfCcmUiLayoutGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmUiLayoutGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmUiLayoutGetSessionRequest request) {
    	IpfCcmUiLayoutGetSessionResponse ipfCcmUiLayoutGetSessionResponse = new IpfCcmUiLayoutGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmUiLayoutGetSessionResponse.setResultString("0");
        	ipfCcmUiLayoutGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmUiLayoutGetSessionResponse.setResultString("1");
        }
        return ipfCcmUiLayoutGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.createIpfCcmUiLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmUiLayout(IpfCcmUiLayoutCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmUiLayout_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayout ipfCcmUiLayout=new IpfCcmUiLayout();
        ipfCcmUiLayout.setId(request.getId());    		
        ipfCcmUiLayout.setUiLayoutName(request.getUiLayoutName());
        ipfCcmUiLayout.setDescription(request.getDescription());
    	ipfCcmUiLayoutService.createIpfCcmUiLayout(ipfCcmUiLayout);
        //返回响应
        IpfCcmUiLayoutCreateResponse ipfCcmUiLayoutCreateResponse = new IpfCcmUiLayoutCreateResponse();
        ipfCcmUiLayoutCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutCreateResponse.setResultJson(ipfCcmUiLayout);
        return ipfCcmUiLayoutCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.deleteIpfCcmUiLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmUiLayout(IpfCcmUiLayoutDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmUiLayout_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmUiLayoutService.deleteIpfCcmUiLayout(idstr);
        //返回响应
        IpfCcmUiLayoutDeleteResponse ipfCcmUiLayoutDeleteResponse = new IpfCcmUiLayoutDeleteResponse();
        ipfCcmUiLayoutDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmUiLayoutDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.updateIpfCcmUiLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmUiLayout(IpfCcmUiLayoutUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmUiLayout_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayout ipfCcmUiLayout=new IpfCcmUiLayout();
        ipfCcmUiLayout=ipfCcmUiLayoutService.getIpfCcmUiLayout(request.getId());
        if (request.getId()!=null){
	        ipfCcmUiLayout.setId(request.getId());
        }
        if (request.getUiLayoutName()!=null){
	        ipfCcmUiLayout.setUiLayoutName(request.getUiLayoutName());
        }
        if (request.getDescription()!=null){
	        ipfCcmUiLayout.setDescription(request.getDescription());
        }
    	ipfCcmUiLayoutService.updateIpfCcmUiLayout(ipfCcmUiLayout);
        //返回响应
        IpfCcmUiLayoutUpdateResponse ipfCcmUiLayoutUpdateResponse = new IpfCcmUiLayoutUpdateResponse();
        ipfCcmUiLayoutUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutUpdateResponse.setResultJson(ipfCcmUiLayout);
        return ipfCcmUiLayoutUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.getIpfCcmUiLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmUiLayout(IpfCcmUiLayoutGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmUiLayout ipfCcmUiLayout=new IpfCcmUiLayout();
        ipfCcmUiLayout=ipfCcmUiLayoutService.getIpfCcmUiLayout(id);
        //返回响应
        IpfCcmUiLayoutGetResponse ipfCcmUiLayoutGetResponse = new IpfCcmUiLayoutGetResponse();
        ipfCcmUiLayoutGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutGetResponse.setResultJson(ipfCcmUiLayout);
        return ipfCcmUiLayoutGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmUiLayoutSelectAllRequest request) {
        IpfCcmUiLayoutSelectAllResponse ipfCcmUiLayoutSelectAllResponse = new IpfCcmUiLayoutSelectAllResponse();
        ipfCcmUiLayoutSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutSelectAllResponse.setResultJson(ipfCcmUiLayoutService.selectAll());
        return ipfCcmUiLayoutSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmUiLayoutCountAllRequest request) {
        IpfCcmUiLayoutCountAllResponse ipfCcmUiLayoutCountAllResponse = new IpfCcmUiLayoutCountAllResponse();
        ipfCcmUiLayoutCountAllResponse.setResultString(String.valueOf(ipfCcmUiLayoutService.countAll()));
        ipfCcmUiLayoutCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmUiLayoutCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmUiLayoutSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmUiLayoutSelectAllResponse ipfCcmUiLayoutSelectAllResponse = new IpfCcmUiLayoutSelectAllResponse();
        ipfCcmUiLayoutSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutSelectAllResponse.setResultJson(ipfCcmUiLayoutService.selectBySql(sqlstr));
        return ipfCcmUiLayoutSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.selectIpfCcmUiLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmUiLayoutSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmUiLayout_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayout ipfCcmUiLayout=new IpfCcmUiLayout();
        ipfCcmUiLayout.setId(request.getId());
        ipfCcmUiLayout.setUiLayoutName(request.getUiLayoutName());
        ipfCcmUiLayout.setDescription(request.getDescription());
    	IpfCcmUiLayoutSelectResponse ipfCcmUiLayoutSelectResponse = new IpfCcmUiLayoutSelectResponse();
        ipfCcmUiLayoutSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmUiLayout> ipfCcmUiLayouts= ipfCcmUiLayoutService.selectWithCondition(ipfCcmUiLayout);
        ipfCcmUiLayoutSelectResponse.setResultJson(ipfCcmUiLayouts);
        return ipfCcmUiLayoutSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayout.isExistIpfCcmUiLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmUiLayout(IpfCcmUiLayoutSelectRequest request) {
        IpfCcmUiLayout ipfCcmUiLayout=new IpfCcmUiLayout();
        ipfCcmUiLayout.setId(request.getId());
        ipfCcmUiLayout.setUiLayoutName(request.getUiLayoutName());
        ipfCcmUiLayout.setDescription(request.getDescription());
        ArrayList<IpfCcmUiLayout> ipfCcmUiLayouts= ipfCcmUiLayoutService.selectWithCondition(ipfCcmUiLayout);
    	IpfCcmUiLayoutCountAllResponse ipfCcmUiLayoutCountAllResponse = new IpfCcmUiLayoutCountAllResponse();
        if (ipfCcmUiLayouts.size()>0){
        	ipfCcmUiLayoutCountAllResponse.setResultString("1");
        } else {
        	ipfCcmUiLayoutCountAllResponse.setResultString("0");
        }        
        return ipfCcmUiLayoutCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmUiLayoutCreateRequest request){
    	IpfCcmUiLayout ipfCcmUiLayout=new IpfCcmUiLayout();
    	ipfCcmUiLayout.setId(request.getId());
        ArrayList<IpfCcmUiLayout> ipfCcmUiLayouts= ipfCcmUiLayoutService.selectWithCondition(ipfCcmUiLayout);
        if (ipfCcmUiLayouts!=null&&ipfCcmUiLayouts.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmUiLayoutUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmUiLayoutDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmUiLayoutSelectRequest request){
        return  true;
     }    
}
