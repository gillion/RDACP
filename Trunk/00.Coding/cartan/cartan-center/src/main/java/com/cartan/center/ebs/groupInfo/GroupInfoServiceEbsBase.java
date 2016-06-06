/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.groupInfo;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.groupInfo.request.*;
import com.cartan.center.ebs.groupInfo.response.*;
import com.cartan.core.groupInfo.domain.GroupInfo;
import com.cartan.core.groupInfo.service.GroupInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class GroupInfoServiceEbsBase {
    static Logger logger = Logger.getLogger(GroupInfoServiceEbs.class.getName());
	private GroupInfoService  groupInfoService;
	
    public GroupInfoService getGroupInfoService() {
        return groupInfoService;
    }

    @Autowired
    public void setGroupInfoService(GroupInfoService groupInfoService) {
        this.groupInfoService = groupInfoService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(GroupInfoGetSessionRequest request) {      
    	GroupInfoGetSessionResponse groupInfoGetSessionResponse = new GroupInfoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	groupInfoGetSessionResponse.setResultString("0");
        } else {
        	groupInfoGetSessionResponse.setResultString("1");
            groupInfoGetSessionResponse.setSessionId(request.getSessionId());
        }
        return groupInfoGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(GroupInfoGetSessionRequest request) {
    	GroupInfoGetSessionResponse groupInfoGetSessionResponse = new GroupInfoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            groupInfoGetSessionResponse.setResultString("1");
        } else {
        	groupInfoGetSessionResponse.setResultString("0");
        }
        groupInfoGetSessionResponse.setSessionId(request.getSessionId());
        return groupInfoGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(GroupInfoGetSessionRequest request) {
    	GroupInfoGetSessionResponse groupInfoGetSessionResponse = new GroupInfoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	groupInfoGetSessionResponse.setResultString("0");
        	groupInfoGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            groupInfoGetSessionResponse.setResultString("1");
        }
        return groupInfoGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.createGroupInfo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createGroupInfo(GroupInfoCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_GroupInfo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        GroupInfo groupInfo=new GroupInfo();
        groupInfo.setId(request.getId());    		
        groupInfo.setType(request.getType());
        groupInfo.setName(request.getName());
        groupInfo.setCreatetime(request.getCreatetime());
        groupInfo.setCreator(request.getCreator());
        groupInfo.setMemoinfo(request.getMemoinfo());
    	groupInfoService.createGroupInfo(groupInfo);
        //返回响应
        GroupInfoCreateResponse groupInfoCreateResponse = new GroupInfoCreateResponse();
        groupInfoCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupInfoCreateResponse.setResultJson(groupInfo);
        return groupInfoCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.deleteGroupInfo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteGroupInfo(GroupInfoDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_GroupInfo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        groupInfoService.deleteGroupInfo(idstr);
        //返回响应
        GroupInfoDeleteResponse groupInfoDeleteResponse = new GroupInfoDeleteResponse();
        groupInfoDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return groupInfoDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.updateGroupInfo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateGroupInfo(GroupInfoUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_GroupInfo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        GroupInfo groupInfo=new GroupInfo();
        groupInfo=groupInfoService.getGroupInfo(request.getId());
        if (request.getId()!=null){
	        groupInfo.setId(request.getId());
        }
        if (request.getType()!=null){
	        groupInfo.setType(request.getType());
        }
        if (request.getName()!=null){
	        groupInfo.setName(request.getName());
        }
        if (request.getCreatetime()!=null){
	        groupInfo.setCreatetime(request.getCreatetime());
        }
        if (request.getCreator()!=null){
	        groupInfo.setCreator(request.getCreator());
        }
        if (request.getMemoinfo()!=null){
	        groupInfo.setMemoinfo(request.getMemoinfo());
        }
    	groupInfoService.updateGroupInfo(groupInfo);
        //返回响应
        GroupInfoUpdateResponse groupInfoUpdateResponse = new GroupInfoUpdateResponse();
        groupInfoUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupInfoUpdateResponse.setResultJson(groupInfo);
        return groupInfoUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.getGroupInfo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getGroupInfo(GroupInfoGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        GroupInfo groupInfo=new GroupInfo();
        groupInfo=groupInfoService.getGroupInfo(id);
        //返回响应
        GroupInfoGetResponse groupInfoGetResponse = new GroupInfoGetResponse();
        groupInfoGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupInfoGetResponse.setResultJson(groupInfo);
        return groupInfoGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(GroupInfoSelectAllRequest request) {
        GroupInfoSelectAllResponse groupInfoSelectAllResponse = new GroupInfoSelectAllResponse();
        groupInfoSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupInfoSelectAllResponse.setResultJson(groupInfoService.selectAll());
        return groupInfoSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(GroupInfoCountAllRequest request) {
        GroupInfoCountAllResponse groupInfoCountAllResponse = new GroupInfoCountAllResponse();
        groupInfoCountAllResponse.setResultString(String.valueOf(groupInfoService.countAll()));
        groupInfoCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return groupInfoCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(GroupInfoSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        GroupInfoSelectAllResponse groupInfoSelectAllResponse = new GroupInfoSelectAllResponse();
        groupInfoSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        groupInfoSelectAllResponse.setResultJson(groupInfoService.selectBySql(sqlstr));
        return groupInfoSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.selectGroupInfo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(GroupInfoSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_GroupInfo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        GroupInfo groupInfo=new GroupInfo();
        groupInfo.setId(request.getId());
        groupInfo.setType(request.getType());
        groupInfo.setName(request.getName());
        groupInfo.setCreatetime(request.getCreatetime());
        groupInfo.setCreator(request.getCreator());
        groupInfo.setMemoinfo(request.getMemoinfo());
    	GroupInfoSelectResponse groupInfoSelectResponse = new GroupInfoSelectResponse();
        groupInfoSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<GroupInfo> groupInfos= groupInfoService.selectWithCondition(groupInfo);
        groupInfoSelectResponse.setResultJson(groupInfos);
        return groupInfoSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "groupInfo.isExistGroupInfo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistGroupInfo(GroupInfoSelectRequest request) {
        GroupInfo groupInfo=new GroupInfo();
        groupInfo.setId(request.getId());
        groupInfo.setType(request.getType());
        groupInfo.setName(request.getName());
        groupInfo.setCreatetime(request.getCreatetime());
        groupInfo.setCreator(request.getCreator());
        groupInfo.setMemoinfo(request.getMemoinfo());
        ArrayList<GroupInfo> groupInfos= groupInfoService.selectWithCondition(groupInfo);
    	GroupInfoCountAllResponse groupInfoCountAllResponse = new GroupInfoCountAllResponse();
        if (groupInfos.size()>0){
        	groupInfoCountAllResponse.setResultString("1");
        } else {
        	groupInfoCountAllResponse.setResultString("0");
        }        
        return groupInfoCountAllResponse;
    }

    public Boolean validateCreateRequest(GroupInfoCreateRequest request){
    	GroupInfo groupInfo=new GroupInfo();
    	groupInfo.setId(request.getId());
        ArrayList<GroupInfo> groupInfos= groupInfoService.selectWithCondition(groupInfo);
        if (groupInfos!=null&&groupInfos.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(GroupInfoUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(GroupInfoDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(GroupInfoSelectRequest request){
        return  true;
     }    
}
