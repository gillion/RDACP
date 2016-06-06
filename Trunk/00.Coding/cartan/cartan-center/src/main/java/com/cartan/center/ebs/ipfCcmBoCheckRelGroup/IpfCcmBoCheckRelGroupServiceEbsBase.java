/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoCheckRelGroup;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoCheckRelGroup.request.*;
import com.cartan.center.ebs.ipfCcmBoCheckRelGroup.response.*;
import com.cartan.core.ipfCcmBoCheckRelGroup.domain.IpfCcmBoCheckRelGroup;
import com.cartan.core.ipfCcmBoCheckRelGroup.service.IpfCcmBoCheckRelGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoCheckRelGroupServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoCheckRelGroupServiceEbs.class.getName());
	private IpfCcmBoCheckRelGroupService  ipfCcmBoCheckRelGroupService;
	
    public IpfCcmBoCheckRelGroupService getIpfCcmBoCheckRelGroupService() {
        return ipfCcmBoCheckRelGroupService;
    }

    @Autowired
    public void setIpfCcmBoCheckRelGroupService(IpfCcmBoCheckRelGroupService ipfCcmBoCheckRelGroupService) {
        this.ipfCcmBoCheckRelGroupService = ipfCcmBoCheckRelGroupService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoCheckRelGroupGetSessionRequest request) {      
    	IpfCcmBoCheckRelGroupGetSessionResponse ipfCcmBoCheckRelGroupGetSessionResponse = new IpfCcmBoCheckRelGroupGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoCheckRelGroupGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoCheckRelGroupGetSessionResponse.setResultString("1");
            ipfCcmBoCheckRelGroupGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoCheckRelGroupGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoCheckRelGroupGetSessionRequest request) {
    	IpfCcmBoCheckRelGroupGetSessionResponse ipfCcmBoCheckRelGroupGetSessionResponse = new IpfCcmBoCheckRelGroupGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoCheckRelGroupGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoCheckRelGroupGetSessionResponse.setResultString("0");
        }
        ipfCcmBoCheckRelGroupGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoCheckRelGroupGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoCheckRelGroupGetSessionRequest request) {
    	IpfCcmBoCheckRelGroupGetSessionResponse ipfCcmBoCheckRelGroupGetSessionResponse = new IpfCcmBoCheckRelGroupGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoCheckRelGroupGetSessionResponse.setResultString("0");
        	ipfCcmBoCheckRelGroupGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoCheckRelGroupGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoCheckRelGroupGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.createIpfCcmBoCheckRelGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoCheckRelGroup(IpfCcmBoCheckRelGroupCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoCheckRelGroup_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup=new IpfCcmBoCheckRelGroup();
        ipfCcmBoCheckRelGroup.setId(request.getId());    		
        ipfCcmBoCheckRelGroup.setIpfCcmBoCheckId(request.getIpfCcmBoCheckId());
        ipfCcmBoCheckRelGroup.setGroupName(request.getGroupName());
        ipfCcmBoCheckRelGroup.setGroupDesc(request.getGroupDesc());
    	ipfCcmBoCheckRelGroupService.createIpfCcmBoCheckRelGroup(ipfCcmBoCheckRelGroup);
        //返回响应
        IpfCcmBoCheckRelGroupCreateResponse ipfCcmBoCheckRelGroupCreateResponse = new IpfCcmBoCheckRelGroupCreateResponse();
        ipfCcmBoCheckRelGroupCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckRelGroupCreateResponse.setResultJson(ipfCcmBoCheckRelGroup);
        return ipfCcmBoCheckRelGroupCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.deleteIpfCcmBoCheckRelGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoCheckRelGroup(IpfCcmBoCheckRelGroupDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoCheckRelGroup_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoCheckRelGroupService.deleteIpfCcmBoCheckRelGroup(idstr);
        //返回响应
        IpfCcmBoCheckRelGroupDeleteResponse ipfCcmBoCheckRelGroupDeleteResponse = new IpfCcmBoCheckRelGroupDeleteResponse();
        ipfCcmBoCheckRelGroupDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoCheckRelGroupDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.updateIpfCcmBoCheckRelGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoCheckRelGroup(IpfCcmBoCheckRelGroupUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoCheckRelGroup_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup=new IpfCcmBoCheckRelGroup();
        ipfCcmBoCheckRelGroup=ipfCcmBoCheckRelGroupService.getIpfCcmBoCheckRelGroup(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoCheckRelGroup.setId(request.getId());
        }
        if (request.getIpfCcmBoCheckId()!=null){
	        ipfCcmBoCheckRelGroup.setIpfCcmBoCheckId(request.getIpfCcmBoCheckId());
        }
        if (request.getGroupName()!=null){
	        ipfCcmBoCheckRelGroup.setGroupName(request.getGroupName());
        }
        if (request.getGroupDesc()!=null){
	        ipfCcmBoCheckRelGroup.setGroupDesc(request.getGroupDesc());
        }
    	ipfCcmBoCheckRelGroupService.updateIpfCcmBoCheckRelGroup(ipfCcmBoCheckRelGroup);
        //返回响应
        IpfCcmBoCheckRelGroupUpdateResponse ipfCcmBoCheckRelGroupUpdateResponse = new IpfCcmBoCheckRelGroupUpdateResponse();
        ipfCcmBoCheckRelGroupUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckRelGroupUpdateResponse.setResultJson(ipfCcmBoCheckRelGroup);
        return ipfCcmBoCheckRelGroupUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.getIpfCcmBoCheckRelGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoCheckRelGroup(IpfCcmBoCheckRelGroupGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup=new IpfCcmBoCheckRelGroup();
        ipfCcmBoCheckRelGroup=ipfCcmBoCheckRelGroupService.getIpfCcmBoCheckRelGroup(id);
        //返回响应
        IpfCcmBoCheckRelGroupGetResponse ipfCcmBoCheckRelGroupGetResponse = new IpfCcmBoCheckRelGroupGetResponse();
        ipfCcmBoCheckRelGroupGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckRelGroupGetResponse.setResultJson(ipfCcmBoCheckRelGroup);
        return ipfCcmBoCheckRelGroupGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoCheckRelGroupSelectAllRequest request) {
        IpfCcmBoCheckRelGroupSelectAllResponse ipfCcmBoCheckRelGroupSelectAllResponse = new IpfCcmBoCheckRelGroupSelectAllResponse();
        ipfCcmBoCheckRelGroupSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckRelGroupSelectAllResponse.setResultJson(ipfCcmBoCheckRelGroupService.selectAll());
        return ipfCcmBoCheckRelGroupSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoCheckRelGroupCountAllRequest request) {
        IpfCcmBoCheckRelGroupCountAllResponse ipfCcmBoCheckRelGroupCountAllResponse = new IpfCcmBoCheckRelGroupCountAllResponse();
        ipfCcmBoCheckRelGroupCountAllResponse.setResultString(String.valueOf(ipfCcmBoCheckRelGroupService.countAll()));
        ipfCcmBoCheckRelGroupCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoCheckRelGroupCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoCheckRelGroupSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoCheckRelGroupSelectAllResponse ipfCcmBoCheckRelGroupSelectAllResponse = new IpfCcmBoCheckRelGroupSelectAllResponse();
        ipfCcmBoCheckRelGroupSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckRelGroupSelectAllResponse.setResultJson(ipfCcmBoCheckRelGroupService.selectBySql(sqlstr));
        return ipfCcmBoCheckRelGroupSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.selectIpfCcmBoCheckRelGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoCheckRelGroupSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoCheckRelGroup_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup=new IpfCcmBoCheckRelGroup();
        ipfCcmBoCheckRelGroup.setId(request.getId());
        ipfCcmBoCheckRelGroup.setIpfCcmBoCheckId(request.getIpfCcmBoCheckId());
        ipfCcmBoCheckRelGroup.setGroupName(request.getGroupName());
        ipfCcmBoCheckRelGroup.setGroupDesc(request.getGroupDesc());
    	IpfCcmBoCheckRelGroupSelectResponse ipfCcmBoCheckRelGroupSelectResponse = new IpfCcmBoCheckRelGroupSelectResponse();
        ipfCcmBoCheckRelGroupSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoCheckRelGroup> ipfCcmBoCheckRelGroups= ipfCcmBoCheckRelGroupService.selectWithCondition(ipfCcmBoCheckRelGroup);
        ipfCcmBoCheckRelGroupSelectResponse.setResultJson(ipfCcmBoCheckRelGroups);
        return ipfCcmBoCheckRelGroupSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckRelGroup.isExistIpfCcmBoCheckRelGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoCheckRelGroup(IpfCcmBoCheckRelGroupSelectRequest request) {
        IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup=new IpfCcmBoCheckRelGroup();
        ipfCcmBoCheckRelGroup.setId(request.getId());
        ipfCcmBoCheckRelGroup.setIpfCcmBoCheckId(request.getIpfCcmBoCheckId());
        ipfCcmBoCheckRelGroup.setGroupName(request.getGroupName());
        ipfCcmBoCheckRelGroup.setGroupDesc(request.getGroupDesc());
        ArrayList<IpfCcmBoCheckRelGroup> ipfCcmBoCheckRelGroups= ipfCcmBoCheckRelGroupService.selectWithCondition(ipfCcmBoCheckRelGroup);
    	IpfCcmBoCheckRelGroupCountAllResponse ipfCcmBoCheckRelGroupCountAllResponse = new IpfCcmBoCheckRelGroupCountAllResponse();
        if (ipfCcmBoCheckRelGroups.size()>0){
        	ipfCcmBoCheckRelGroupCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoCheckRelGroupCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoCheckRelGroupCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoCheckRelGroupCreateRequest request){
    	IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup=new IpfCcmBoCheckRelGroup();
    	ipfCcmBoCheckRelGroup.setId(request.getId());
        ArrayList<IpfCcmBoCheckRelGroup> ipfCcmBoCheckRelGroups= ipfCcmBoCheckRelGroupService.selectWithCondition(ipfCcmBoCheckRelGroup);
        if (ipfCcmBoCheckRelGroups!=null&&ipfCcmBoCheckRelGroups.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoCheckRelGroupUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoCheckRelGroupDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoCheckRelGroupSelectRequest request){
        return  true;
     }    
}
