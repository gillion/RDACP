/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoGridToolbar;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoGridToolbar.request.*;
import com.cartan.center.ebs.ipfCcmBoGridToolbar.response.*;
import com.cartan.core.ipfCcmBoGridToolbar.domain.IpfCcmBoGridToolbar;
import com.cartan.core.ipfCcmBoGridToolbar.service.IpfCcmBoGridToolbarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoGridToolbarServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoGridToolbarServiceEbs.class.getName());
	private IpfCcmBoGridToolbarService  ipfCcmBoGridToolbarService;
	
    public IpfCcmBoGridToolbarService getIpfCcmBoGridToolbarService() {
        return ipfCcmBoGridToolbarService;
    }

    @Autowired
    public void setIpfCcmBoGridToolbarService(IpfCcmBoGridToolbarService ipfCcmBoGridToolbarService) {
        this.ipfCcmBoGridToolbarService = ipfCcmBoGridToolbarService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoGridToolbarGetSessionRequest request) {      
    	IpfCcmBoGridToolbarGetSessionResponse ipfCcmBoGridToolbarGetSessionResponse = new IpfCcmBoGridToolbarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoGridToolbarGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoGridToolbarGetSessionResponse.setResultString("1");
            ipfCcmBoGridToolbarGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoGridToolbarGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoGridToolbarGetSessionRequest request) {
    	IpfCcmBoGridToolbarGetSessionResponse ipfCcmBoGridToolbarGetSessionResponse = new IpfCcmBoGridToolbarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoGridToolbarGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoGridToolbarGetSessionResponse.setResultString("0");
        }
        ipfCcmBoGridToolbarGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoGridToolbarGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoGridToolbarGetSessionRequest request) {
    	IpfCcmBoGridToolbarGetSessionResponse ipfCcmBoGridToolbarGetSessionResponse = new IpfCcmBoGridToolbarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoGridToolbarGetSessionResponse.setResultString("0");
        	ipfCcmBoGridToolbarGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoGridToolbarGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoGridToolbarGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.createIpfCcmBoGridToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoGridToolbar(IpfCcmBoGridToolbarCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoGridToolbar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoGridToolbar ipfCcmBoGridToolbar=new IpfCcmBoGridToolbar();
        ipfCcmBoGridToolbar.setId(request.getId());    		
        ipfCcmBoGridToolbar.setIpfCcbBoId(request.getIpfCcbBoId());
        ipfCcmBoGridToolbar.setMethodName(request.getMethodName());
        ipfCcmBoGridToolbar.setMethodDesc(request.getMethodDesc());
        ipfCcmBoGridToolbar.setSeqNo(request.getSeqNo());
        ipfCcmBoGridToolbar.setMethodId(request.getMethodId());
        ipfCcmBoGridToolbar.setButtonStyle(request.getButtonStyle());
        ipfCcmBoGridToolbar.setDisabledExpree(request.getDisabledExpree());
        ipfCcmBoGridToolbar.setIsRefreshParentBo(request.getIsRefreshParentBo());
        ipfCcmBoGridToolbar.setHotkeyType(request.getHotkeyType());
        ipfCcmBoGridToolbar.setHotkeyValue(request.getHotkeyValue());
        ipfCcmBoGridToolbar.setIsHide(request.getIsHide());
    	ipfCcmBoGridToolbarService.createIpfCcmBoGridToolbar(ipfCcmBoGridToolbar);
        //返回响应
        IpfCcmBoGridToolbarCreateResponse ipfCcmBoGridToolbarCreateResponse = new IpfCcmBoGridToolbarCreateResponse();
        ipfCcmBoGridToolbarCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoGridToolbarCreateResponse.setResultJson(ipfCcmBoGridToolbar);
        return ipfCcmBoGridToolbarCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.deleteIpfCcmBoGridToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoGridToolbar(IpfCcmBoGridToolbarDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoGridToolbar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoGridToolbarService.deleteIpfCcmBoGridToolbar(idstr);
        //返回响应
        IpfCcmBoGridToolbarDeleteResponse ipfCcmBoGridToolbarDeleteResponse = new IpfCcmBoGridToolbarDeleteResponse();
        ipfCcmBoGridToolbarDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoGridToolbarDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.updateIpfCcmBoGridToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoGridToolbar(IpfCcmBoGridToolbarUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoGridToolbar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoGridToolbar ipfCcmBoGridToolbar=new IpfCcmBoGridToolbar();
        ipfCcmBoGridToolbar=ipfCcmBoGridToolbarService.getIpfCcmBoGridToolbar(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoGridToolbar.setId(request.getId());
        }
        if (request.getIpfCcbBoId()!=null){
	        ipfCcmBoGridToolbar.setIpfCcbBoId(request.getIpfCcbBoId());
        }
        if (request.getMethodName()!=null){
	        ipfCcmBoGridToolbar.setMethodName(request.getMethodName());
        }
        if (request.getMethodDesc()!=null){
	        ipfCcmBoGridToolbar.setMethodDesc(request.getMethodDesc());
        }
        if (request.getSeqNo()!=null){
	        ipfCcmBoGridToolbar.setSeqNo(request.getSeqNo());
        }
        if (request.getMethodId()!=null){
	        ipfCcmBoGridToolbar.setMethodId(request.getMethodId());
        }
        if (request.getButtonStyle()!=null){
	        ipfCcmBoGridToolbar.setButtonStyle(request.getButtonStyle());
        }
        if (request.getDisabledExpree()!=null){
	        ipfCcmBoGridToolbar.setDisabledExpree(request.getDisabledExpree());
        }
        if (request.getIsRefreshParentBo()!=null){
	        ipfCcmBoGridToolbar.setIsRefreshParentBo(request.getIsRefreshParentBo());
        }
        if (request.getHotkeyType()!=null){
	        ipfCcmBoGridToolbar.setHotkeyType(request.getHotkeyType());
        }
        if (request.getHotkeyValue()!=null){
	        ipfCcmBoGridToolbar.setHotkeyValue(request.getHotkeyValue());
        }
        if (request.getIsHide()!=null){
	        ipfCcmBoGridToolbar.setIsHide(request.getIsHide());
        }
    	ipfCcmBoGridToolbarService.updateIpfCcmBoGridToolbar(ipfCcmBoGridToolbar);
        //返回响应
        IpfCcmBoGridToolbarUpdateResponse ipfCcmBoGridToolbarUpdateResponse = new IpfCcmBoGridToolbarUpdateResponse();
        ipfCcmBoGridToolbarUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoGridToolbarUpdateResponse.setResultJson(ipfCcmBoGridToolbar);
        return ipfCcmBoGridToolbarUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.getIpfCcmBoGridToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoGridToolbar(IpfCcmBoGridToolbarGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoGridToolbar ipfCcmBoGridToolbar=new IpfCcmBoGridToolbar();
        ipfCcmBoGridToolbar=ipfCcmBoGridToolbarService.getIpfCcmBoGridToolbar(id);
        //返回响应
        IpfCcmBoGridToolbarGetResponse ipfCcmBoGridToolbarGetResponse = new IpfCcmBoGridToolbarGetResponse();
        ipfCcmBoGridToolbarGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoGridToolbarGetResponse.setResultJson(ipfCcmBoGridToolbar);
        return ipfCcmBoGridToolbarGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoGridToolbarSelectAllRequest request) {
        IpfCcmBoGridToolbarSelectAllResponse ipfCcmBoGridToolbarSelectAllResponse = new IpfCcmBoGridToolbarSelectAllResponse();
        ipfCcmBoGridToolbarSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoGridToolbarSelectAllResponse.setResultJson(ipfCcmBoGridToolbarService.selectAll());
        return ipfCcmBoGridToolbarSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoGridToolbarCountAllRequest request) {
        IpfCcmBoGridToolbarCountAllResponse ipfCcmBoGridToolbarCountAllResponse = new IpfCcmBoGridToolbarCountAllResponse();
        ipfCcmBoGridToolbarCountAllResponse.setResultString(String.valueOf(ipfCcmBoGridToolbarService.countAll()));
        ipfCcmBoGridToolbarCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoGridToolbarCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoGridToolbarSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoGridToolbarSelectAllResponse ipfCcmBoGridToolbarSelectAllResponse = new IpfCcmBoGridToolbarSelectAllResponse();
        ipfCcmBoGridToolbarSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoGridToolbarSelectAllResponse.setResultJson(ipfCcmBoGridToolbarService.selectBySql(sqlstr));
        return ipfCcmBoGridToolbarSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.selectIpfCcmBoGridToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoGridToolbarSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoGridToolbar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoGridToolbar ipfCcmBoGridToolbar=new IpfCcmBoGridToolbar();
        ipfCcmBoGridToolbar.setId(request.getId());
        ipfCcmBoGridToolbar.setIpfCcbBoId(request.getIpfCcbBoId());
        ipfCcmBoGridToolbar.setMethodName(request.getMethodName());
        ipfCcmBoGridToolbar.setMethodDesc(request.getMethodDesc());
        ipfCcmBoGridToolbar.setSeqNo(request.getSeqNo());
        ipfCcmBoGridToolbar.setMethodId(request.getMethodId());
        ipfCcmBoGridToolbar.setButtonStyle(request.getButtonStyle());
        ipfCcmBoGridToolbar.setDisabledExpree(request.getDisabledExpree());
        ipfCcmBoGridToolbar.setIsRefreshParentBo(request.getIsRefreshParentBo());
        ipfCcmBoGridToolbar.setHotkeyType(request.getHotkeyType());
        ipfCcmBoGridToolbar.setHotkeyValue(request.getHotkeyValue());
        ipfCcmBoGridToolbar.setIsHide(request.getIsHide());
    	IpfCcmBoGridToolbarSelectResponse ipfCcmBoGridToolbarSelectResponse = new IpfCcmBoGridToolbarSelectResponse();
        ipfCcmBoGridToolbarSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoGridToolbar> ipfCcmBoGridToolbars= ipfCcmBoGridToolbarService.selectWithCondition(ipfCcmBoGridToolbar);
        ipfCcmBoGridToolbarSelectResponse.setResultJson(ipfCcmBoGridToolbars);
        return ipfCcmBoGridToolbarSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridToolbar.isExistIpfCcmBoGridToolbar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoGridToolbar(IpfCcmBoGridToolbarSelectRequest request) {
        IpfCcmBoGridToolbar ipfCcmBoGridToolbar=new IpfCcmBoGridToolbar();
        ipfCcmBoGridToolbar.setId(request.getId());
        ipfCcmBoGridToolbar.setIpfCcbBoId(request.getIpfCcbBoId());
        ipfCcmBoGridToolbar.setMethodName(request.getMethodName());
        ipfCcmBoGridToolbar.setMethodDesc(request.getMethodDesc());
        ipfCcmBoGridToolbar.setSeqNo(request.getSeqNo());
        ipfCcmBoGridToolbar.setMethodId(request.getMethodId());
        ipfCcmBoGridToolbar.setButtonStyle(request.getButtonStyle());
        ipfCcmBoGridToolbar.setDisabledExpree(request.getDisabledExpree());
        ipfCcmBoGridToolbar.setIsRefreshParentBo(request.getIsRefreshParentBo());
        ipfCcmBoGridToolbar.setHotkeyType(request.getHotkeyType());
        ipfCcmBoGridToolbar.setHotkeyValue(request.getHotkeyValue());
        ipfCcmBoGridToolbar.setIsHide(request.getIsHide());
        ArrayList<IpfCcmBoGridToolbar> ipfCcmBoGridToolbars= ipfCcmBoGridToolbarService.selectWithCondition(ipfCcmBoGridToolbar);
    	IpfCcmBoGridToolbarCountAllResponse ipfCcmBoGridToolbarCountAllResponse = new IpfCcmBoGridToolbarCountAllResponse();
        if (ipfCcmBoGridToolbars.size()>0){
        	ipfCcmBoGridToolbarCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoGridToolbarCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoGridToolbarCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoGridToolbarCreateRequest request){
    	IpfCcmBoGridToolbar ipfCcmBoGridToolbar=new IpfCcmBoGridToolbar();
    	ipfCcmBoGridToolbar.setId(request.getId());
        ArrayList<IpfCcmBoGridToolbar> ipfCcmBoGridToolbars= ipfCcmBoGridToolbarService.selectWithCondition(ipfCcmBoGridToolbar);
        if (ipfCcmBoGridToolbars!=null&&ipfCcmBoGridToolbars.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoGridToolbarUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoGridToolbarDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoGridToolbarSelectRequest request){
        return  true;
     }    
}
