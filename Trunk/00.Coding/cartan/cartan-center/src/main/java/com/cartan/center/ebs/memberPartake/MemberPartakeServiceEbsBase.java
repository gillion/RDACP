/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.memberPartake;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.memberPartake.request.*;
import com.cartan.center.ebs.memberPartake.response.*;
import com.cartan.core.memberPartake.domain.MemberPartake;
import com.cartan.core.memberPartake.service.MemberPartakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class MemberPartakeServiceEbsBase {
    static Logger logger = Logger.getLogger(MemberPartakeServiceEbs.class.getName());
	private MemberPartakeService  memberPartakeService;
	
    public MemberPartakeService getMemberPartakeService() {
        return memberPartakeService;
    }

    @Autowired
    public void setMemberPartakeService(MemberPartakeService memberPartakeService) {
        this.memberPartakeService = memberPartakeService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(MemberPartakeGetSessionRequest request) {      
    	MemberPartakeGetSessionResponse memberPartakeGetSessionResponse = new MemberPartakeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	memberPartakeGetSessionResponse.setResultString("0");
        } else {
        	memberPartakeGetSessionResponse.setResultString("1");
            memberPartakeGetSessionResponse.setSessionId(request.getSessionId());
        }
        return memberPartakeGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(MemberPartakeGetSessionRequest request) {
    	MemberPartakeGetSessionResponse memberPartakeGetSessionResponse = new MemberPartakeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            memberPartakeGetSessionResponse.setResultString("1");
        } else {
        	memberPartakeGetSessionResponse.setResultString("0");
        }
        memberPartakeGetSessionResponse.setSessionId(request.getSessionId());
        return memberPartakeGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(MemberPartakeGetSessionRequest request) {
    	MemberPartakeGetSessionResponse memberPartakeGetSessionResponse = new MemberPartakeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	memberPartakeGetSessionResponse.setResultString("0");
        	memberPartakeGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            memberPartakeGetSessionResponse.setResultString("1");
        }
        return memberPartakeGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.createMemberPartake", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createMemberPartake(MemberPartakeCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_MemberPartake_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        MemberPartake memberPartake=new MemberPartake();
        memberPartake.setId(request.getId());    		
        memberPartake.setGroupActId(request.getGroupActId());
        memberPartake.setGroupMemberId(request.getGroupMemberId());
        memberPartake.setPartaketime(request.getPartaketime());
        memberPartake.setSpending(request.getSpending());
    	memberPartakeService.createMemberPartake(memberPartake);
        //返回响应
        MemberPartakeCreateResponse memberPartakeCreateResponse = new MemberPartakeCreateResponse();
        memberPartakeCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberPartakeCreateResponse.setResultJson(memberPartake);
        return memberPartakeCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.deleteMemberPartake", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteMemberPartake(MemberPartakeDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_MemberPartake_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        memberPartakeService.deleteMemberPartake(idstr);
        //返回响应
        MemberPartakeDeleteResponse memberPartakeDeleteResponse = new MemberPartakeDeleteResponse();
        memberPartakeDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return memberPartakeDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.updateMemberPartake", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateMemberPartake(MemberPartakeUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_MemberPartake_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        MemberPartake memberPartake=new MemberPartake();
        memberPartake=memberPartakeService.getMemberPartake(request.getId());
        if (request.getId()!=null){
	        memberPartake.setId(request.getId());
        }
        if (request.getGroupActId()!=null){
	        memberPartake.setGroupActId(request.getGroupActId());
        }
        if (request.getGroupMemberId()!=null){
	        memberPartake.setGroupMemberId(request.getGroupMemberId());
        }
        if (request.getPartaketime()!=null){
	        memberPartake.setPartaketime(request.getPartaketime());
        }
        if (request.getSpending()!=null){
	        memberPartake.setSpending(request.getSpending());
        }
    	memberPartakeService.updateMemberPartake(memberPartake);
        //返回响应
        MemberPartakeUpdateResponse memberPartakeUpdateResponse = new MemberPartakeUpdateResponse();
        memberPartakeUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberPartakeUpdateResponse.setResultJson(memberPartake);
        return memberPartakeUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.getMemberPartake", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getMemberPartake(MemberPartakeGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        MemberPartake memberPartake=new MemberPartake();
        memberPartake=memberPartakeService.getMemberPartake(id);
        //返回响应
        MemberPartakeGetResponse memberPartakeGetResponse = new MemberPartakeGetResponse();
        memberPartakeGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberPartakeGetResponse.setResultJson(memberPartake);
        return memberPartakeGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(MemberPartakeSelectAllRequest request) {
        MemberPartakeSelectAllResponse memberPartakeSelectAllResponse = new MemberPartakeSelectAllResponse();
        memberPartakeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberPartakeSelectAllResponse.setResultJson(memberPartakeService.selectAll());
        return memberPartakeSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(MemberPartakeCountAllRequest request) {
        MemberPartakeCountAllResponse memberPartakeCountAllResponse = new MemberPartakeCountAllResponse();
        memberPartakeCountAllResponse.setResultString(String.valueOf(memberPartakeService.countAll()));
        memberPartakeCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return memberPartakeCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(MemberPartakeSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        MemberPartakeSelectAllResponse memberPartakeSelectAllResponse = new MemberPartakeSelectAllResponse();
        memberPartakeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberPartakeSelectAllResponse.setResultJson(memberPartakeService.selectBySql(sqlstr));
        return memberPartakeSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.selectMemberPartake", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(MemberPartakeSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_MemberPartake_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        MemberPartake memberPartake=new MemberPartake();
        memberPartake.setId(request.getId());
        memberPartake.setGroupActId(request.getGroupActId());
        memberPartake.setGroupMemberId(request.getGroupMemberId());
        memberPartake.setPartaketime(request.getPartaketime());
        memberPartake.setSpending(request.getSpending());
    	MemberPartakeSelectResponse memberPartakeSelectResponse = new MemberPartakeSelectResponse();
        memberPartakeSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<MemberPartake> memberPartakes= memberPartakeService.selectWithCondition(memberPartake);
        memberPartakeSelectResponse.setResultJson(memberPartakes);
        return memberPartakeSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberPartake.isExistMemberPartake", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistMemberPartake(MemberPartakeSelectRequest request) {
        MemberPartake memberPartake=new MemberPartake();
        memberPartake.setId(request.getId());
        memberPartake.setGroupActId(request.getGroupActId());
        memberPartake.setGroupMemberId(request.getGroupMemberId());
        memberPartake.setPartaketime(request.getPartaketime());
        memberPartake.setSpending(request.getSpending());
        ArrayList<MemberPartake> memberPartakes= memberPartakeService.selectWithCondition(memberPartake);
    	MemberPartakeCountAllResponse memberPartakeCountAllResponse = new MemberPartakeCountAllResponse();
        if (memberPartakes.size()>0){
        	memberPartakeCountAllResponse.setResultString("1");
        } else {
        	memberPartakeCountAllResponse.setResultString("0");
        }        
        return memberPartakeCountAllResponse;
    }

    public Boolean validateCreateRequest(MemberPartakeCreateRequest request){
    	MemberPartake memberPartake=new MemberPartake();
    	memberPartake.setId(request.getId());
        ArrayList<MemberPartake> memberPartakes= memberPartakeService.selectWithCondition(memberPartake);
        if (memberPartakes!=null&&memberPartakes.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(MemberPartakeUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(MemberPartakeDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(MemberPartakeSelectRequest request){
        return  true;
     }    
}
