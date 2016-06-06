/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.groupAction;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.groupAction.request.*;
import com.cartan.center.ebs.groupAction.response.*;
import com.cartan.core.groupAction.domain.GroupAction;
import com.cartan.core.groupAction.service.GroupActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class GroupActionServiceEbsBase {
    static Logger logger = Logger.getLogger(GroupActionServiceEbs.class.getName());
	private GroupActionService  groupActionService;
	
    public GroupActionService getGroupActionService() {
        return groupActionService;
    }

    @Autowired
    public void setGroupActionService(GroupActionService groupActionService) {
        this.groupActionService = groupActionService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(GroupActionGetSessionRequest request) {      
    	GroupActionGetSessionResponse groupActionGetSessionResponse = new GroupActionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	groupActionGetSessionResponse.setResultString("0");
        } else {
        	groupActionGetSessionResponse.setResultString("1");
            groupActionGetSessionResponse.setSessionId(request.getSessionId());
        }
        return groupActionGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(GroupActionGetSessionRequest request) {
    	GroupActionGetSessionResponse groupActionGetSessionResponse = new GroupActionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            groupActionGetSessionResponse.setResultString("1");
        } else {
        	groupActionGetSessionResponse.setResultString("0");
        }
        groupActionGetSessionResponse.setSessionId(request.getSessionId());
        return groupActionGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(GroupActionGetSessionRequest request) {
    	GroupActionGetSessionResponse groupActionGetSessionResponse = new GroupActionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	groupActionGetSessionResponse.setResultString("0");
        	groupActionGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            groupActionGetSessionResponse.setResultString("1");
        }
        return groupActionGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.createGroupAction", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createGroupAction(GroupActionCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_GroupAction_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        GroupAction groupAction=new GroupAction();
        groupAction.setId(request.getId());    		
        groupAction.setName(request.getName());
        groupAction.setBegintime(request.getBegintime());
        groupAction.setEndtime(request.getEndtime());
        groupAction.setAddr(request.getAddr());
        groupAction.setLeadings(request.getLeadings());
        groupAction.setMemoinfo(request.getMemoinfo());
        groupAction.setMincount(request.getMincount());
        groupAction.setBudget(request.getBudget());
        groupAction.setSpending(request.getSpending());
    	groupActionService.createGroupAction(groupAction);
        //返回响应
        GroupActionCreateResponse groupActionCreateResponse = new GroupActionCreateResponse();
        groupActionCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupActionCreateResponse.setResultJson(groupAction);
        return groupActionCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.deleteGroupAction", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteGroupAction(GroupActionDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_GroupAction_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        groupActionService.deleteGroupAction(idstr);
        //返回响应
        GroupActionDeleteResponse groupActionDeleteResponse = new GroupActionDeleteResponse();
        groupActionDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return groupActionDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.updateGroupAction", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateGroupAction(GroupActionUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_GroupAction_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        GroupAction groupAction=new GroupAction();
        groupAction=groupActionService.getGroupAction(request.getId());
        if (request.getId()!=null){
	        groupAction.setId(request.getId());
        }
        if (request.getName()!=null){
	        groupAction.setName(request.getName());
        }
        if (request.getBegintime()!=null){
	        groupAction.setBegintime(request.getBegintime());
        }
        if (request.getEndtime()!=null){
	        groupAction.setEndtime(request.getEndtime());
        }
        if (request.getAddr()!=null){
	        groupAction.setAddr(request.getAddr());
        }
        if (request.getLeadings()!=null){
	        groupAction.setLeadings(request.getLeadings());
        }
        if (request.getMemoinfo()!=null){
	        groupAction.setMemoinfo(request.getMemoinfo());
        }
        if (request.getMincount()!=null){
	        groupAction.setMincount(request.getMincount());
        }
        if (request.getBudget()!=null){
	        groupAction.setBudget(request.getBudget());
        }
        if (request.getSpending()!=null){
	        groupAction.setSpending(request.getSpending());
        }
    	groupActionService.updateGroupAction(groupAction);
        //返回响应
        GroupActionUpdateResponse groupActionUpdateResponse = new GroupActionUpdateResponse();
        groupActionUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupActionUpdateResponse.setResultJson(groupAction);
        return groupActionUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.getGroupAction", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getGroupAction(GroupActionGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        GroupAction groupAction=new GroupAction();
        groupAction=groupActionService.getGroupAction(id);
        //返回响应
        GroupActionGetResponse groupActionGetResponse = new GroupActionGetResponse();
        groupActionGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupActionGetResponse.setResultJson(groupAction);
        return groupActionGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(GroupActionSelectAllRequest request) {
        GroupActionSelectAllResponse groupActionSelectAllResponse = new GroupActionSelectAllResponse();
        groupActionSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupActionSelectAllResponse.setResultJson(groupActionService.selectAll());
        return groupActionSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(GroupActionCountAllRequest request) {
        GroupActionCountAllResponse groupActionCountAllResponse = new GroupActionCountAllResponse();
        groupActionCountAllResponse.setResultString(String.valueOf(groupActionService.countAll()));
        groupActionCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return groupActionCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(GroupActionSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        GroupActionSelectAllResponse groupActionSelectAllResponse = new GroupActionSelectAllResponse();
        groupActionSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupActionSelectAllResponse.setResultJson(groupActionService.selectBySql(sqlstr));
        return groupActionSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.selectGroupAction", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(GroupActionSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_GroupAction_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        GroupAction groupAction=new GroupAction();
        groupAction.setId(request.getId());
        groupAction.setName(request.getName());
        groupAction.setBegintime(request.getBegintime());
        groupAction.setEndtime(request.getEndtime());
        groupAction.setAddr(request.getAddr());
        groupAction.setLeadings(request.getLeadings());
        groupAction.setMemoinfo(request.getMemoinfo());
        groupAction.setMincount(request.getMincount());
        groupAction.setBudget(request.getBudget());
        groupAction.setSpending(request.getSpending());
    	GroupActionSelectResponse groupActionSelectResponse = new GroupActionSelectResponse();
        groupActionSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<GroupAction> groupActions= groupActionService.selectWithCondition(groupAction);
        groupActionSelectResponse.setResultJson(groupActions);
        return groupActionSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupAction.isExistGroupAction", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistGroupAction(GroupActionSelectRequest request) {
        GroupAction groupAction=new GroupAction();
        groupAction.setId(request.getId());
        groupAction.setName(request.getName());
        groupAction.setBegintime(request.getBegintime());
        groupAction.setEndtime(request.getEndtime());
        groupAction.setAddr(request.getAddr());
        groupAction.setLeadings(request.getLeadings());
        groupAction.setMemoinfo(request.getMemoinfo());
        groupAction.setMincount(request.getMincount());
        groupAction.setBudget(request.getBudget());
        groupAction.setSpending(request.getSpending());
        ArrayList<GroupAction> groupActions= groupActionService.selectWithCondition(groupAction);
    	GroupActionCountAllResponse groupActionCountAllResponse = new GroupActionCountAllResponse();
        if (groupActions.size()>0){
        	groupActionCountAllResponse.setResultString("1");
        } else {
        	groupActionCountAllResponse.setResultString("0");
        }        
        return groupActionCountAllResponse;
    }

    public Boolean validateCreateRequest(GroupActionCreateRequest request){
    	GroupAction groupAction=new GroupAction();
    	groupAction.setId(request.getId());
        ArrayList<GroupAction> groupActions= groupActionService.selectWithCondition(groupAction);
        if (groupActions!=null&&groupActions.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(GroupActionUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(GroupActionDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(GroupActionSelectRequest request){
        return  true;
     }    
}
