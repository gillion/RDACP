/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.groupMember;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.groupMember.request.*;
import com.cartan.center.ebs.groupMember.response.*;
import com.cartan.core.groupMember.domain.GroupMember;
import com.cartan.core.groupMember.service.GroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class GroupMemberServiceEbsBase {
    static Logger logger = Logger.getLogger(GroupMemberServiceEbs.class.getName());
	private GroupMemberService  groupMemberService;
	
    public GroupMemberService getGroupMemberService() {
        return groupMemberService;
    }

    @Autowired
    public void setGroupMemberService(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(GroupMemberGetSessionRequest request) {      
    	GroupMemberGetSessionResponse groupMemberGetSessionResponse = new GroupMemberGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	groupMemberGetSessionResponse.setResultString("0");
        } else {
        	groupMemberGetSessionResponse.setResultString("1");
            groupMemberGetSessionResponse.setSessionId(request.getSessionId());
        }
        return groupMemberGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(GroupMemberGetSessionRequest request) {
    	GroupMemberGetSessionResponse groupMemberGetSessionResponse = new GroupMemberGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            groupMemberGetSessionResponse.setResultString("1");
        } else {
        	groupMemberGetSessionResponse.setResultString("0");
        }
        groupMemberGetSessionResponse.setSessionId(request.getSessionId());
        return groupMemberGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(GroupMemberGetSessionRequest request) {
    	GroupMemberGetSessionResponse groupMemberGetSessionResponse = new GroupMemberGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	groupMemberGetSessionResponse.setResultString("0");
        	groupMemberGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            groupMemberGetSessionResponse.setResultString("1");
        }
        return groupMemberGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.createGroupMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createGroupMember(GroupMemberCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_GroupMember_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        GroupMember groupMember=new GroupMember();
        groupMember.setId(request.getId());    		
        groupMember.setUser(request.getUser());
        groupMember.setGroupInfoId(request.getGroupInfoId());
        groupMember.setArea(request.getArea());
        groupMember.setName(request.getName());
        groupMember.setTel(request.getTel());
        groupMember.setUnit(request.getUnit());
        groupMember.setAddr(request.getAddr());
    	groupMemberService.createGroupMember(groupMember);
        //返回响应
        GroupMemberCreateResponse groupMemberCreateResponse = new GroupMemberCreateResponse();
        groupMemberCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupMemberCreateResponse.setResultJson(groupMember);
        return groupMemberCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.deleteGroupMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteGroupMember(GroupMemberDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_GroupMember_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        groupMemberService.deleteGroupMember(idstr);
        //返回响应
        GroupMemberDeleteResponse groupMemberDeleteResponse = new GroupMemberDeleteResponse();
        groupMemberDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return groupMemberDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.updateGroupMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateGroupMember(GroupMemberUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_GroupMember_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        GroupMember groupMember=new GroupMember();
        groupMember=groupMemberService.getGroupMember(request.getId());
        if (request.getId()!=null){
	        groupMember.setId(request.getId());
        }
        if (request.getUser()!=null){
	        groupMember.setUser(request.getUser());
        }
        if (request.getGroupInfoId()!=null){
	        groupMember.setGroupInfoId(request.getGroupInfoId());
        }
        if (request.getArea()!=null){
	        groupMember.setArea(request.getArea());
        }
        if (request.getName()!=null){
	        groupMember.setName(request.getName());
        }
        if (request.getTel()!=null){
	        groupMember.setTel(request.getTel());
        }
        if (request.getUnit()!=null){
	        groupMember.setUnit(request.getUnit());
        }
        if (request.getAddr()!=null){
	        groupMember.setAddr(request.getAddr());
        }
    	groupMemberService.updateGroupMember(groupMember);
        //返回响应
        GroupMemberUpdateResponse groupMemberUpdateResponse = new GroupMemberUpdateResponse();
        groupMemberUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupMemberUpdateResponse.setResultJson(groupMember);
        return groupMemberUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.getGroupMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getGroupMember(GroupMemberGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        GroupMember groupMember=new GroupMember();
        groupMember=groupMemberService.getGroupMember(id);
        //返回响应
        GroupMemberGetResponse groupMemberGetResponse = new GroupMemberGetResponse();
        groupMemberGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupMemberGetResponse.setResultJson(groupMember);
        return groupMemberGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(GroupMemberSelectAllRequest request) {
        GroupMemberSelectAllResponse groupMemberSelectAllResponse = new GroupMemberSelectAllResponse();
        groupMemberSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupMemberSelectAllResponse.setResultJson(groupMemberService.selectAll());
        return groupMemberSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(GroupMemberCountAllRequest request) {
        GroupMemberCountAllResponse groupMemberCountAllResponse = new GroupMemberCountAllResponse();
        groupMemberCountAllResponse.setResultString(String.valueOf(groupMemberService.countAll()));
        groupMemberCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return groupMemberCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(GroupMemberSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        GroupMemberSelectAllResponse groupMemberSelectAllResponse = new GroupMemberSelectAllResponse();
        groupMemberSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupMemberSelectAllResponse.setResultJson(groupMemberService.selectBySql(sqlstr));
        return groupMemberSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.selectGroupMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(GroupMemberSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_GroupMember_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        GroupMember groupMember=new GroupMember();
        groupMember.setId(request.getId());
        groupMember.setUser(request.getUser());
        groupMember.setGroupInfoId(request.getGroupInfoId());
        groupMember.setArea(request.getArea());
        groupMember.setName(request.getName());
        groupMember.setTel(request.getTel());
        groupMember.setUnit(request.getUnit());
        groupMember.setAddr(request.getAddr());
    	GroupMemberSelectResponse groupMemberSelectResponse = new GroupMemberSelectResponse();
        groupMemberSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<GroupMember> groupMembers= groupMemberService.selectWithCondition(groupMember);
        groupMemberSelectResponse.setResultJson(groupMembers);
        return groupMemberSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupMember.isExistGroupMember", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistGroupMember(GroupMemberSelectRequest request) {
        GroupMember groupMember=new GroupMember();
        groupMember.setId(request.getId());
        groupMember.setUser(request.getUser());
        groupMember.setGroupInfoId(request.getGroupInfoId());
        groupMember.setArea(request.getArea());
        groupMember.setName(request.getName());
        groupMember.setTel(request.getTel());
        groupMember.setUnit(request.getUnit());
        groupMember.setAddr(request.getAddr());
        ArrayList<GroupMember> groupMembers= groupMemberService.selectWithCondition(groupMember);
    	GroupMemberCountAllResponse groupMemberCountAllResponse = new GroupMemberCountAllResponse();
        if (groupMembers.size()>0){
        	groupMemberCountAllResponse.setResultString("1");
        } else {
        	groupMemberCountAllResponse.setResultString("0");
        }        
        return groupMemberCountAllResponse;
    }

    public Boolean validateCreateRequest(GroupMemberCreateRequest request){
    	GroupMember groupMember=new GroupMember();
    	groupMember.setId(request.getId());
        ArrayList<GroupMember> groupMembers= groupMemberService.selectWithCondition(groupMember);
        if (groupMembers!=null&&groupMembers.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(GroupMemberUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(GroupMemberDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(GroupMemberSelectRequest request){
        return  true;
     }    
}
