/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoFormToolbar;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoFormToolbar.request.*;
import com.cartan.center.ebs.ipfCcmBoFormToolbar.response.*;
import com.cartan.core.ipfCcmBoFormToolbar.domain.IpfCcmBoFormToolbar;
import com.cartan.core.ipfCcmBoFormToolbar.service.IpfCcmBoFormToolbarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoFormToolbarServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoFormToolbarServiceEbs.class.getName());
	private IpfCcmBoFormToolbarService  ipfCcmBoFormToolbarService;
	
    public IpfCcmBoFormToolbarService getIpfCcmBoFormToolbarService() {
        return ipfCcmBoFormToolbarService;
    }

    @Autowired
    public void setIpfCcmBoFormToolbarService(IpfCcmBoFormToolbarService ipfCcmBoFormToolbarService) {
        this.ipfCcmBoFormToolbarService = ipfCcmBoFormToolbarService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoFormToolbarGetSessionRequest request) {      
    	IpfCcmBoFormToolbarGetSessionResponse ipfCcmBoFormToolbarGetSessionResponse = new IpfCcmBoFormToolbarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoFormToolbarGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoFormToolbarGetSessionResponse.setResultString("1");
            ipfCcmBoFormToolbarGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoFormToolbarGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoFormToolbarGetSessionRequest request) {
    	IpfCcmBoFormToolbarGetSessionResponse ipfCcmBoFormToolbarGetSessionResponse = new IpfCcmBoFormToolbarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoFormToolbarGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoFormToolbarGetSessionResponse.setResultString("0");
        }
        ipfCcmBoFormToolbarGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoFormToolbarGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoFormToolbarGetSessionRequest request) {
    	IpfCcmBoFormToolbarGetSessionResponse ipfCcmBoFormToolbarGetSessionResponse = new IpfCcmBoFormToolbarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoFormToolbarGetSessionResponse.setResultString("0");
        	ipfCcmBoFormToolbarGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoFormToolbarGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoFormToolbarGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.createIpfCcmBoFormToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoFormToolbar(IpfCcmBoFormToolbarCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoFormToolbar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoFormToolbar ipfCcmBoFormToolbar=new IpfCcmBoFormToolbar();
        ipfCcmBoFormToolbar.setId(request.getId());    		
        ipfCcmBoFormToolbar.setIpfCcbBoId(request.getIpfCcbBoId());
        ipfCcmBoFormToolbar.setMethodName(request.getMethodName());
        ipfCcmBoFormToolbar.setMethodDesc(request.getMethodDesc());
        ipfCcmBoFormToolbar.setSeqNo(request.getSeqNo());
        ipfCcmBoFormToolbar.setMethodId(request.getMethodId());
        ipfCcmBoFormToolbar.setButtonStyle(request.getButtonStyle());
        ipfCcmBoFormToolbar.setDisabledExpree(request.getDisabledExpree());
        ipfCcmBoFormToolbar.setIsRefreshParentBo(request.getIsRefreshParentBo());
        ipfCcmBoFormToolbar.setHotkeyType(request.getHotkeyType());
        ipfCcmBoFormToolbar.setHotkeyValue(request.getHotkeyValue());
        ipfCcmBoFormToolbar.setIsHide(request.getIsHide());
    	ipfCcmBoFormToolbarService.createIpfCcmBoFormToolbar(ipfCcmBoFormToolbar);
        //返回响应
        IpfCcmBoFormToolbarCreateResponse ipfCcmBoFormToolbarCreateResponse = new IpfCcmBoFormToolbarCreateResponse();
        ipfCcmBoFormToolbarCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormToolbarCreateResponse.setResultJson(ipfCcmBoFormToolbar);
        return ipfCcmBoFormToolbarCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.deleteIpfCcmBoFormToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoFormToolbar(IpfCcmBoFormToolbarDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoFormToolbar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoFormToolbarService.deleteIpfCcmBoFormToolbar(idstr);
        //返回响应
        IpfCcmBoFormToolbarDeleteResponse ipfCcmBoFormToolbarDeleteResponse = new IpfCcmBoFormToolbarDeleteResponse();
        ipfCcmBoFormToolbarDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoFormToolbarDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.updateIpfCcmBoFormToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoFormToolbar(IpfCcmBoFormToolbarUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoFormToolbar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoFormToolbar ipfCcmBoFormToolbar=new IpfCcmBoFormToolbar();
        ipfCcmBoFormToolbar=ipfCcmBoFormToolbarService.getIpfCcmBoFormToolbar(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoFormToolbar.setId(request.getId());
        }
        if (request.getIpfCcbBoId()!=null){
	        ipfCcmBoFormToolbar.setIpfCcbBoId(request.getIpfCcbBoId());
        }
        if (request.getMethodName()!=null){
	        ipfCcmBoFormToolbar.setMethodName(request.getMethodName());
        }
        if (request.getMethodDesc()!=null){
	        ipfCcmBoFormToolbar.setMethodDesc(request.getMethodDesc());
        }
        if (request.getSeqNo()!=null){
	        ipfCcmBoFormToolbar.setSeqNo(request.getSeqNo());
        }
        if (request.getMethodId()!=null){
	        ipfCcmBoFormToolbar.setMethodId(request.getMethodId());
        }
        if (request.getButtonStyle()!=null){
	        ipfCcmBoFormToolbar.setButtonStyle(request.getButtonStyle());
        }
        if (request.getDisabledExpree()!=null){
	        ipfCcmBoFormToolbar.setDisabledExpree(request.getDisabledExpree());
        }
        if (request.getIsRefreshParentBo()!=null){
	        ipfCcmBoFormToolbar.setIsRefreshParentBo(request.getIsRefreshParentBo());
        }
        if (request.getHotkeyType()!=null){
	        ipfCcmBoFormToolbar.setHotkeyType(request.getHotkeyType());
        }
        if (request.getHotkeyValue()!=null){
	        ipfCcmBoFormToolbar.setHotkeyValue(request.getHotkeyValue());
        }
        if (request.getIsHide()!=null){
	        ipfCcmBoFormToolbar.setIsHide(request.getIsHide());
        }
    	ipfCcmBoFormToolbarService.updateIpfCcmBoFormToolbar(ipfCcmBoFormToolbar);
        //返回响应
        IpfCcmBoFormToolbarUpdateResponse ipfCcmBoFormToolbarUpdateResponse = new IpfCcmBoFormToolbarUpdateResponse();
        ipfCcmBoFormToolbarUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormToolbarUpdateResponse.setResultJson(ipfCcmBoFormToolbar);
        return ipfCcmBoFormToolbarUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.getIpfCcmBoFormToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoFormToolbar(IpfCcmBoFormToolbarGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoFormToolbar ipfCcmBoFormToolbar=new IpfCcmBoFormToolbar();
        ipfCcmBoFormToolbar=ipfCcmBoFormToolbarService.getIpfCcmBoFormToolbar(id);
        //返回响应
        IpfCcmBoFormToolbarGetResponse ipfCcmBoFormToolbarGetResponse = new IpfCcmBoFormToolbarGetResponse();
        ipfCcmBoFormToolbarGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormToolbarGetResponse.setResultJson(ipfCcmBoFormToolbar);
        return ipfCcmBoFormToolbarGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoFormToolbarSelectAllRequest request) {
        IpfCcmBoFormToolbarSelectAllResponse ipfCcmBoFormToolbarSelectAllResponse = new IpfCcmBoFormToolbarSelectAllResponse();
        ipfCcmBoFormToolbarSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormToolbarSelectAllResponse.setResultJson(ipfCcmBoFormToolbarService.selectAll());
        return ipfCcmBoFormToolbarSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoFormToolbarCountAllRequest request) {
        IpfCcmBoFormToolbarCountAllResponse ipfCcmBoFormToolbarCountAllResponse = new IpfCcmBoFormToolbarCountAllResponse();
        ipfCcmBoFormToolbarCountAllResponse.setResultString(String.valueOf(ipfCcmBoFormToolbarService.countAll()));
        ipfCcmBoFormToolbarCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoFormToolbarCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoFormToolbarSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoFormToolbarSelectAllResponse ipfCcmBoFormToolbarSelectAllResponse = new IpfCcmBoFormToolbarSelectAllResponse();
        ipfCcmBoFormToolbarSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormToolbarSelectAllResponse.setResultJson(ipfCcmBoFormToolbarService.selectBySql(sqlstr));
        return ipfCcmBoFormToolbarSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.selectIpfCcmBoFormToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoFormToolbarSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoFormToolbar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoFormToolbar ipfCcmBoFormToolbar=new IpfCcmBoFormToolbar();
        ipfCcmBoFormToolbar.setId(request.getId());
        ipfCcmBoFormToolbar.setIpfCcbBoId(request.getIpfCcbBoId());
        ipfCcmBoFormToolbar.setMethodName(request.getMethodName());
        ipfCcmBoFormToolbar.setMethodDesc(request.getMethodDesc());
        ipfCcmBoFormToolbar.setSeqNo(request.getSeqNo());
        ipfCcmBoFormToolbar.setMethodId(request.getMethodId());
        ipfCcmBoFormToolbar.setButtonStyle(request.getButtonStyle());
        ipfCcmBoFormToolbar.setDisabledExpree(request.getDisabledExpree());
        ipfCcmBoFormToolbar.setIsRefreshParentBo(request.getIsRefreshParentBo());
        ipfCcmBoFormToolbar.setHotkeyType(request.getHotkeyType());
        ipfCcmBoFormToolbar.setHotkeyValue(request.getHotkeyValue());
        ipfCcmBoFormToolbar.setIsHide(request.getIsHide());
    	IpfCcmBoFormToolbarSelectResponse ipfCcmBoFormToolbarSelectResponse = new IpfCcmBoFormToolbarSelectResponse();
        ipfCcmBoFormToolbarSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoFormToolbar> ipfCcmBoFormToolbars= ipfCcmBoFormToolbarService.selectWithCondition(ipfCcmBoFormToolbar);
        ipfCcmBoFormToolbarSelectResponse.setResultJson(ipfCcmBoFormToolbars);
        return ipfCcmBoFormToolbarSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormToolbar.isExistIpfCcmBoFormToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoFormToolbar(IpfCcmBoFormToolbarSelectRequest request) {
        IpfCcmBoFormToolbar ipfCcmBoFormToolbar=new IpfCcmBoFormToolbar();
        ipfCcmBoFormToolbar.setId(request.getId());
        ipfCcmBoFormToolbar.setIpfCcbBoId(request.getIpfCcbBoId());
        ipfCcmBoFormToolbar.setMethodName(request.getMethodName());
        ipfCcmBoFormToolbar.setMethodDesc(request.getMethodDesc());
        ipfCcmBoFormToolbar.setSeqNo(request.getSeqNo());
        ipfCcmBoFormToolbar.setMethodId(request.getMethodId());
        ipfCcmBoFormToolbar.setButtonStyle(request.getButtonStyle());
        ipfCcmBoFormToolbar.setDisabledExpree(request.getDisabledExpree());
        ipfCcmBoFormToolbar.setIsRefreshParentBo(request.getIsRefreshParentBo());
        ipfCcmBoFormToolbar.setHotkeyType(request.getHotkeyType());
        ipfCcmBoFormToolbar.setHotkeyValue(request.getHotkeyValue());
        ipfCcmBoFormToolbar.setIsHide(request.getIsHide());
        ArrayList<IpfCcmBoFormToolbar> ipfCcmBoFormToolbars= ipfCcmBoFormToolbarService.selectWithCondition(ipfCcmBoFormToolbar);
    	IpfCcmBoFormToolbarCountAllResponse ipfCcmBoFormToolbarCountAllResponse = new IpfCcmBoFormToolbarCountAllResponse();
        if (ipfCcmBoFormToolbars.size()>0){
        	ipfCcmBoFormToolbarCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoFormToolbarCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoFormToolbarCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoFormToolbarCreateRequest request){
    	IpfCcmBoFormToolbar ipfCcmBoFormToolbar=new IpfCcmBoFormToolbar();
    	ipfCcmBoFormToolbar.setId(request.getId());
        ArrayList<IpfCcmBoFormToolbar> ipfCcmBoFormToolbars= ipfCcmBoFormToolbarService.selectWithCondition(ipfCcmBoFormToolbar);
        if (ipfCcmBoFormToolbars!=null&&ipfCcmBoFormToolbars.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoFormToolbarUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoFormToolbarDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoFormToolbarSelectRequest request){
        return  true;
     }    
}
