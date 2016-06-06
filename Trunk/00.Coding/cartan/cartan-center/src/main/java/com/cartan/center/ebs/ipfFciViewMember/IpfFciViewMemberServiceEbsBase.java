/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciViewMember;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfFciViewMember.request.*;
import com.cartan.center.ebs.ipfFciViewMember.response.*;
import com.cartan.core.ipfFciViewMember.domain.IpfFciViewMember;
import com.cartan.core.ipfFciViewMember.service.IpfFciViewMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfFciViewMemberServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfFciViewMemberServiceEbs.class.getName());
	private IpfFciViewMemberService  ipfFciViewMemberService;
	
    public IpfFciViewMemberService getIpfFciViewMemberService() {
        return ipfFciViewMemberService;
    }

    @Autowired
    public void setIpfFciViewMemberService(IpfFciViewMemberService ipfFciViewMemberService) {
        this.ipfFciViewMemberService = ipfFciViewMemberService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfFciViewMemberGetSessionRequest request) {      
    	IpfFciViewMemberGetSessionResponse ipfFciViewMemberGetSessionResponse = new IpfFciViewMemberGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciViewMemberGetSessionResponse.setResultString("0");
        } else {
        	ipfFciViewMemberGetSessionResponse.setResultString("1");
            ipfFciViewMemberGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfFciViewMemberGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfFciViewMemberGetSessionRequest request) {
    	IpfFciViewMemberGetSessionResponse ipfFciViewMemberGetSessionResponse = new IpfFciViewMemberGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfFciViewMemberGetSessionResponse.setResultString("1");
        } else {
        	ipfFciViewMemberGetSessionResponse.setResultString("0");
        }
        ipfFciViewMemberGetSessionResponse.setSessionId(request.getSessionId());
        return ipfFciViewMemberGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfFciViewMemberGetSessionRequest request) {
    	IpfFciViewMemberGetSessionResponse ipfFciViewMemberGetSessionResponse = new IpfFciViewMemberGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciViewMemberGetSessionResponse.setResultString("0");
        	ipfFciViewMemberGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfFciViewMemberGetSessionResponse.setResultString("1");
        }
        return ipfFciViewMemberGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.createIpfFciViewMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfFciViewMember(IpfFciViewMemberCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfFciViewMember_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciViewMember ipfFciViewMember=new IpfFciViewMember();
        ipfFciViewMember.setId(request.getId());    		
        ipfFciViewMember.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciViewMember.setConfigItemType(request.getConfigItemType());
        ipfFciViewMember.setConfigItemCode(request.getConfigItemCode());
        ipfFciViewMember.setConfigItemId(request.getConfigItemId());
        ipfFciViewMember.setRevisionNumber(request.getRevisionNumber());
        ipfFciViewMember.setSourceType(request.getSourceType());
        ipfFciViewMember.setSourceItemId(request.getSourceItemId());
        ipfFciViewMember.setRelationMemberId(request.getRelationMemberId());
        ipfFciViewMember.setIsLock(request.getIsLock());
        ipfFciViewMember.setLockUser(request.getLockUser());
        ipfFciViewMember.setLockTime(request.getLockTime());
        ipfFciViewMember.setIsActive(request.getIsActive());
    	ipfFciViewMemberService.createIpfFciViewMember(ipfFciViewMember);
        //返回响应
        IpfFciViewMemberCreateResponse ipfFciViewMemberCreateResponse = new IpfFciViewMemberCreateResponse();
        ipfFciViewMemberCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciViewMemberCreateResponse.setResultJson(ipfFciViewMember);
        return ipfFciViewMemberCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.deleteIpfFciViewMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfFciViewMember(IpfFciViewMemberDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfFciViewMember_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfFciViewMemberService.deleteIpfFciViewMember(idstr);
        //返回响应
        IpfFciViewMemberDeleteResponse ipfFciViewMemberDeleteResponse = new IpfFciViewMemberDeleteResponse();
        ipfFciViewMemberDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciViewMemberDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.updateIpfFciViewMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfFciViewMember(IpfFciViewMemberUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfFciViewMember_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciViewMember ipfFciViewMember=new IpfFciViewMember();
        ipfFciViewMember=ipfFciViewMemberService.getIpfFciViewMember(request.getId());
        if (request.getId()!=null){
	        ipfFciViewMember.setId(request.getId());
        }
        if (request.getIpfFciViewId()!=null){
	        ipfFciViewMember.setIpfFciViewId(request.getIpfFciViewId());
        }
        if (request.getConfigItemType()!=null){
	        ipfFciViewMember.setConfigItemType(request.getConfigItemType());
        }
        if (request.getConfigItemCode()!=null){
	        ipfFciViewMember.setConfigItemCode(request.getConfigItemCode());
        }
        if (request.getConfigItemId()!=null){
	        ipfFciViewMember.setConfigItemId(request.getConfigItemId());
        }
        if (request.getRevisionNumber()!=null){
	        ipfFciViewMember.setRevisionNumber(request.getRevisionNumber());
        }
        if (request.getSourceType()!=null){
	        ipfFciViewMember.setSourceType(request.getSourceType());
        }
        if (request.getSourceItemId()!=null){
	        ipfFciViewMember.setSourceItemId(request.getSourceItemId());
        }
        if (request.getRelationMemberId()!=null){
	        ipfFciViewMember.setRelationMemberId(request.getRelationMemberId());
        }
        if (request.getIsLock()!=null){
	        ipfFciViewMember.setIsLock(request.getIsLock());
        }
        if (request.getLockUser()!=null){
	        ipfFciViewMember.setLockUser(request.getLockUser());
        }
        if (request.getLockTime()!=null){
	        ipfFciViewMember.setLockTime(request.getLockTime());
        }
        if (request.getIsActive()!=null){
	        ipfFciViewMember.setIsActive(request.getIsActive());
        }
    	ipfFciViewMemberService.updateIpfFciViewMember(ipfFciViewMember);
        //返回响应
        IpfFciViewMemberUpdateResponse ipfFciViewMemberUpdateResponse = new IpfFciViewMemberUpdateResponse();
        ipfFciViewMemberUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciViewMemberUpdateResponse.setResultJson(ipfFciViewMember);
        return ipfFciViewMemberUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.getIpfFciViewMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfFciViewMember(IpfFciViewMemberGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfFciViewMember ipfFciViewMember=new IpfFciViewMember();
        ipfFciViewMember=ipfFciViewMemberService.getIpfFciViewMember(id);
        //返回响应
        IpfFciViewMemberGetResponse ipfFciViewMemberGetResponse = new IpfFciViewMemberGetResponse();
        ipfFciViewMemberGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciViewMemberGetResponse.setResultJson(ipfFciViewMember);
        return ipfFciViewMemberGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfFciViewMemberSelectAllRequest request) {
        IpfFciViewMemberSelectAllResponse ipfFciViewMemberSelectAllResponse = new IpfFciViewMemberSelectAllResponse();
        ipfFciViewMemberSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciViewMemberSelectAllResponse.setResultJson(ipfFciViewMemberService.selectAll());
        return ipfFciViewMemberSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfFciViewMemberCountAllRequest request) {
        IpfFciViewMemberCountAllResponse ipfFciViewMemberCountAllResponse = new IpfFciViewMemberCountAllResponse();
        ipfFciViewMemberCountAllResponse.setResultString(String.valueOf(ipfFciViewMemberService.countAll()));
        ipfFciViewMemberCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciViewMemberCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfFciViewMemberSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfFciViewMemberSelectAllResponse ipfFciViewMemberSelectAllResponse = new IpfFciViewMemberSelectAllResponse();
        ipfFciViewMemberSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciViewMemberSelectAllResponse.setResultJson(ipfFciViewMemberService.selectBySql(sqlstr));
        return ipfFciViewMemberSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.selectIpfFciViewMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfFciViewMemberSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfFciViewMember_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciViewMember ipfFciViewMember=new IpfFciViewMember();
        ipfFciViewMember.setId(request.getId());
        ipfFciViewMember.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciViewMember.setConfigItemType(request.getConfigItemType());
        ipfFciViewMember.setConfigItemCode(request.getConfigItemCode());
        ipfFciViewMember.setConfigItemId(request.getConfigItemId());
        ipfFciViewMember.setRevisionNumber(request.getRevisionNumber());
        ipfFciViewMember.setSourceType(request.getSourceType());
        ipfFciViewMember.setSourceItemId(request.getSourceItemId());
        ipfFciViewMember.setRelationMemberId(request.getRelationMemberId());
        ipfFciViewMember.setIsLock(request.getIsLock());
        ipfFciViewMember.setLockUser(request.getLockUser());
        ipfFciViewMember.setLockTime(request.getLockTime());
        ipfFciViewMember.setIsActive(request.getIsActive());
    	IpfFciViewMemberSelectResponse ipfFciViewMemberSelectResponse = new IpfFciViewMemberSelectResponse();
        ipfFciViewMemberSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfFciViewMember> ipfFciViewMembers= ipfFciViewMemberService.selectWithCondition(ipfFciViewMember);
        ipfFciViewMemberSelectResponse.setResultJson(ipfFciViewMembers);
        return ipfFciViewMemberSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciViewMember.isExistIpfFciViewMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfFciViewMember(IpfFciViewMemberSelectRequest request) {
        IpfFciViewMember ipfFciViewMember=new IpfFciViewMember();
        ipfFciViewMember.setId(request.getId());
        ipfFciViewMember.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciViewMember.setConfigItemType(request.getConfigItemType());
        ipfFciViewMember.setConfigItemCode(request.getConfigItemCode());
        ipfFciViewMember.setConfigItemId(request.getConfigItemId());
        ipfFciViewMember.setRevisionNumber(request.getRevisionNumber());
        ipfFciViewMember.setSourceType(request.getSourceType());
        ipfFciViewMember.setSourceItemId(request.getSourceItemId());
        ipfFciViewMember.setRelationMemberId(request.getRelationMemberId());
        ipfFciViewMember.setIsLock(request.getIsLock());
        ipfFciViewMember.setLockUser(request.getLockUser());
        ipfFciViewMember.setLockTime(request.getLockTime());
        ipfFciViewMember.setIsActive(request.getIsActive());
        ArrayList<IpfFciViewMember> ipfFciViewMembers= ipfFciViewMemberService.selectWithCondition(ipfFciViewMember);
    	IpfFciViewMemberCountAllResponse ipfFciViewMemberCountAllResponse = new IpfFciViewMemberCountAllResponse();
        if (ipfFciViewMembers.size()>0){
        	ipfFciViewMemberCountAllResponse.setResultString("1");
        } else {
        	ipfFciViewMemberCountAllResponse.setResultString("0");
        }        
        return ipfFciViewMemberCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfFciViewMemberCreateRequest request){
    	IpfFciViewMember ipfFciViewMember=new IpfFciViewMember();
    	ipfFciViewMember.setId(request.getId());
        ArrayList<IpfFciViewMember> ipfFciViewMembers= ipfFciViewMemberService.selectWithCondition(ipfFciViewMember);
        if (ipfFciViewMembers!=null&&ipfFciViewMembers.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfFciViewMemberUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfFciViewMemberDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfFciViewMemberSelectRequest request){
        return  true;
     }    
}
