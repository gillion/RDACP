/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.memberVote;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.memberVote.request.*;
import com.cartan.center.ebs.memberVote.response.*;
import com.cartan.core.memberVote.domain.MemberVote;
import com.cartan.core.memberVote.service.MemberVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class MemberVoteServiceEbsBase {
    static Logger logger = Logger.getLogger(MemberVoteServiceEbs.class.getName());
	private MemberVoteService  memberVoteService;
	
    public MemberVoteService getMemberVoteService() {
        return memberVoteService;
    }

    @Autowired
    public void setMemberVoteService(MemberVoteService memberVoteService) {
        this.memberVoteService = memberVoteService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(MemberVoteGetSessionRequest request) {      
    	MemberVoteGetSessionResponse memberVoteGetSessionResponse = new MemberVoteGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	memberVoteGetSessionResponse.setResultString("0");
        } else {
        	memberVoteGetSessionResponse.setResultString("1");
            memberVoteGetSessionResponse.setSessionId(request.getSessionId());
        }
        return memberVoteGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(MemberVoteGetSessionRequest request) {
    	MemberVoteGetSessionResponse memberVoteGetSessionResponse = new MemberVoteGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            memberVoteGetSessionResponse.setResultString("1");
        } else {
        	memberVoteGetSessionResponse.setResultString("0");
        }
        memberVoteGetSessionResponse.setSessionId(request.getSessionId());
        return memberVoteGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(MemberVoteGetSessionRequest request) {
    	MemberVoteGetSessionResponse memberVoteGetSessionResponse = new MemberVoteGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	memberVoteGetSessionResponse.setResultString("0");
        	memberVoteGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            memberVoteGetSessionResponse.setResultString("1");
        }
        return memberVoteGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.createMemberVote", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createMemberVote(MemberVoteCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_MemberVote_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        MemberVote memberVote=new MemberVote();
        memberVote.setId(request.getId());    		
        memberVote.setGroupActId(request.getGroupActId());
        memberVote.setGroupMemberId(request.getGroupMemberId());
        memberVote.setVotetime(request.getVotetime());
        memberVote.setVotestate(request.getVotestate());
    	memberVoteService.createMemberVote(memberVote);
        //返回响应
        MemberVoteCreateResponse memberVoteCreateResponse = new MemberVoteCreateResponse();
        memberVoteCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberVoteCreateResponse.setResultJson(memberVote);
        return memberVoteCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.deleteMemberVote", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteMemberVote(MemberVoteDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_MemberVote_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        memberVoteService.deleteMemberVote(idstr);
        //返回响应
        MemberVoteDeleteResponse memberVoteDeleteResponse = new MemberVoteDeleteResponse();
        memberVoteDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return memberVoteDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.updateMemberVote", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateMemberVote(MemberVoteUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_MemberVote_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        MemberVote memberVote=new MemberVote();
        memberVote=memberVoteService.getMemberVote(request.getId());
        if (request.getId()!=null){
	        memberVote.setId(request.getId());
        }
        if (request.getGroupActId()!=null){
	        memberVote.setGroupActId(request.getGroupActId());
        }
        if (request.getGroupMemberId()!=null){
	        memberVote.setGroupMemberId(request.getGroupMemberId());
        }
        if (request.getVotetime()!=null){
	        memberVote.setVotetime(request.getVotetime());
        }
        if (request.getVotestate()!=null){
	        memberVote.setVotestate(request.getVotestate());
        }
    	memberVoteService.updateMemberVote(memberVote);
        //返回响应
        MemberVoteUpdateResponse memberVoteUpdateResponse = new MemberVoteUpdateResponse();
        memberVoteUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberVoteUpdateResponse.setResultJson(memberVote);
        return memberVoteUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.getMemberVote", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getMemberVote(MemberVoteGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        MemberVote memberVote=new MemberVote();
        memberVote=memberVoteService.getMemberVote(id);
        //返回响应
        MemberVoteGetResponse memberVoteGetResponse = new MemberVoteGetResponse();
        memberVoteGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberVoteGetResponse.setResultJson(memberVote);
        return memberVoteGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(MemberVoteSelectAllRequest request) {
        MemberVoteSelectAllResponse memberVoteSelectAllResponse = new MemberVoteSelectAllResponse();
        memberVoteSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberVoteSelectAllResponse.setResultJson(memberVoteService.selectAll());
        return memberVoteSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(MemberVoteCountAllRequest request) {
        MemberVoteCountAllResponse memberVoteCountAllResponse = new MemberVoteCountAllResponse();
        memberVoteCountAllResponse.setResultString(String.valueOf(memberVoteService.countAll()));
        memberVoteCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return memberVoteCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(MemberVoteSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        MemberVoteSelectAllResponse memberVoteSelectAllResponse = new MemberVoteSelectAllResponse();
        memberVoteSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberVoteSelectAllResponse.setResultJson(memberVoteService.selectBySql(sqlstr));
        return memberVoteSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.selectMemberVote", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(MemberVoteSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_MemberVote_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        MemberVote memberVote=new MemberVote();
        memberVote.setId(request.getId());
        memberVote.setGroupActId(request.getGroupActId());
        memberVote.setGroupMemberId(request.getGroupMemberId());
        memberVote.setVotetime(request.getVotetime());
        memberVote.setVotestate(request.getVotestate());
    	MemberVoteSelectResponse memberVoteSelectResponse = new MemberVoteSelectResponse();
        memberVoteSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<MemberVote> memberVotes= memberVoteService.selectWithCondition(memberVote);
        memberVoteSelectResponse.setResultJson(memberVotes);
        return memberVoteSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberVote.isExistMemberVote", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistMemberVote(MemberVoteSelectRequest request) {
        MemberVote memberVote=new MemberVote();
        memberVote.setId(request.getId());
        memberVote.setGroupActId(request.getGroupActId());
        memberVote.setGroupMemberId(request.getGroupMemberId());
        memberVote.setVotetime(request.getVotetime());
        memberVote.setVotestate(request.getVotestate());
        ArrayList<MemberVote> memberVotes= memberVoteService.selectWithCondition(memberVote);
    	MemberVoteCountAllResponse memberVoteCountAllResponse = new MemberVoteCountAllResponse();
        if (memberVotes.size()>0){
        	memberVoteCountAllResponse.setResultString("1");
        } else {
        	memberVoteCountAllResponse.setResultString("0");
        }        
        return memberVoteCountAllResponse;
    }

    public Boolean validateCreateRequest(MemberVoteCreateRequest request){
    	MemberVote memberVote=new MemberVote();
    	memberVote.setId(request.getId());
        ArrayList<MemberVote> memberVotes= memberVoteService.selectWithCondition(memberVote);
        if (memberVotes!=null&&memberVotes.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(MemberVoteUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(MemberVoteDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(MemberVoteSelectRequest request){
        return  true;
     }    
}
