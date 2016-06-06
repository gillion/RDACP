/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoCheckGroup;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoCheckGroup.request.*;
import com.cartan.center.ebs.ipfCcmBoCheckGroup.response.*;
import com.cartan.core.ipfCcmBoCheckGroup.domain.IpfCcmBoCheckGroup;
import com.cartan.core.ipfCcmBoCheckGroup.service.IpfCcmBoCheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoCheckGroupServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoCheckGroupServiceEbs.class.getName());
	private IpfCcmBoCheckGroupService  ipfCcmBoCheckGroupService;
	
    public IpfCcmBoCheckGroupService getIpfCcmBoCheckGroupService() {
        return ipfCcmBoCheckGroupService;
    }

    @Autowired
    public void setIpfCcmBoCheckGroupService(IpfCcmBoCheckGroupService ipfCcmBoCheckGroupService) {
        this.ipfCcmBoCheckGroupService = ipfCcmBoCheckGroupService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoCheckGroupGetSessionRequest request) {      
    	IpfCcmBoCheckGroupGetSessionResponse ipfCcmBoCheckGroupGetSessionResponse = new IpfCcmBoCheckGroupGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoCheckGroupGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoCheckGroupGetSessionResponse.setResultString("1");
            ipfCcmBoCheckGroupGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoCheckGroupGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoCheckGroupGetSessionRequest request) {
    	IpfCcmBoCheckGroupGetSessionResponse ipfCcmBoCheckGroupGetSessionResponse = new IpfCcmBoCheckGroupGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoCheckGroupGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoCheckGroupGetSessionResponse.setResultString("0");
        }
        ipfCcmBoCheckGroupGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoCheckGroupGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoCheckGroupGetSessionRequest request) {
    	IpfCcmBoCheckGroupGetSessionResponse ipfCcmBoCheckGroupGetSessionResponse = new IpfCcmBoCheckGroupGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoCheckGroupGetSessionResponse.setResultString("0");
        	ipfCcmBoCheckGroupGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoCheckGroupGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoCheckGroupGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.createIpfCcmBoCheckGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoCheckGroup(IpfCcmBoCheckGroupCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoCheckGroup_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheckGroup ipfCcmBoCheckGroup=new IpfCcmBoCheckGroup();
        ipfCcmBoCheckGroup.setId(request.getId());    		
        ipfCcmBoCheckGroup.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoCheckGroup.setGroupName(request.getGroupName());
        ipfCcmBoCheckGroup.setGroupDesc(request.getGroupDesc());
    	ipfCcmBoCheckGroupService.createIpfCcmBoCheckGroup(ipfCcmBoCheckGroup);
        //返回响应
        IpfCcmBoCheckGroupCreateResponse ipfCcmBoCheckGroupCreateResponse = new IpfCcmBoCheckGroupCreateResponse();
        ipfCcmBoCheckGroupCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckGroupCreateResponse.setResultJson(ipfCcmBoCheckGroup);
        return ipfCcmBoCheckGroupCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.deleteIpfCcmBoCheckGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoCheckGroup(IpfCcmBoCheckGroupDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoCheckGroup_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoCheckGroupService.deleteIpfCcmBoCheckGroup(idstr);
        //返回响应
        IpfCcmBoCheckGroupDeleteResponse ipfCcmBoCheckGroupDeleteResponse = new IpfCcmBoCheckGroupDeleteResponse();
        ipfCcmBoCheckGroupDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoCheckGroupDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.updateIpfCcmBoCheckGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoCheckGroup(IpfCcmBoCheckGroupUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoCheckGroup_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheckGroup ipfCcmBoCheckGroup=new IpfCcmBoCheckGroup();
        ipfCcmBoCheckGroup=ipfCcmBoCheckGroupService.getIpfCcmBoCheckGroup(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoCheckGroup.setId(request.getId());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfCcmBoCheckGroup.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getGroupName()!=null){
	        ipfCcmBoCheckGroup.setGroupName(request.getGroupName());
        }
        if (request.getGroupDesc()!=null){
	        ipfCcmBoCheckGroup.setGroupDesc(request.getGroupDesc());
        }
    	ipfCcmBoCheckGroupService.updateIpfCcmBoCheckGroup(ipfCcmBoCheckGroup);
        //返回响应
        IpfCcmBoCheckGroupUpdateResponse ipfCcmBoCheckGroupUpdateResponse = new IpfCcmBoCheckGroupUpdateResponse();
        ipfCcmBoCheckGroupUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckGroupUpdateResponse.setResultJson(ipfCcmBoCheckGroup);
        return ipfCcmBoCheckGroupUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.getIpfCcmBoCheckGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoCheckGroup(IpfCcmBoCheckGroupGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoCheckGroup ipfCcmBoCheckGroup=new IpfCcmBoCheckGroup();
        ipfCcmBoCheckGroup=ipfCcmBoCheckGroupService.getIpfCcmBoCheckGroup(id);
        //返回响应
        IpfCcmBoCheckGroupGetResponse ipfCcmBoCheckGroupGetResponse = new IpfCcmBoCheckGroupGetResponse();
        ipfCcmBoCheckGroupGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckGroupGetResponse.setResultJson(ipfCcmBoCheckGroup);
        return ipfCcmBoCheckGroupGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoCheckGroupSelectAllRequest request) {
        IpfCcmBoCheckGroupSelectAllResponse ipfCcmBoCheckGroupSelectAllResponse = new IpfCcmBoCheckGroupSelectAllResponse();
        ipfCcmBoCheckGroupSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckGroupSelectAllResponse.setResultJson(ipfCcmBoCheckGroupService.selectAll());
        return ipfCcmBoCheckGroupSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoCheckGroupCountAllRequest request) {
        IpfCcmBoCheckGroupCountAllResponse ipfCcmBoCheckGroupCountAllResponse = new IpfCcmBoCheckGroupCountAllResponse();
        ipfCcmBoCheckGroupCountAllResponse.setResultString(String.valueOf(ipfCcmBoCheckGroupService.countAll()));
        ipfCcmBoCheckGroupCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoCheckGroupCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoCheckGroupSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoCheckGroupSelectAllResponse ipfCcmBoCheckGroupSelectAllResponse = new IpfCcmBoCheckGroupSelectAllResponse();
        ipfCcmBoCheckGroupSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCheckGroupSelectAllResponse.setResultJson(ipfCcmBoCheckGroupService.selectBySql(sqlstr));
        return ipfCcmBoCheckGroupSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.selectIpfCcmBoCheckGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoCheckGroupSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoCheckGroup_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoCheckGroup ipfCcmBoCheckGroup=new IpfCcmBoCheckGroup();
        ipfCcmBoCheckGroup.setId(request.getId());
        ipfCcmBoCheckGroup.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoCheckGroup.setGroupName(request.getGroupName());
        ipfCcmBoCheckGroup.setGroupDesc(request.getGroupDesc());
    	IpfCcmBoCheckGroupSelectResponse ipfCcmBoCheckGroupSelectResponse = new IpfCcmBoCheckGroupSelectResponse();
        ipfCcmBoCheckGroupSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoCheckGroup> ipfCcmBoCheckGroups= ipfCcmBoCheckGroupService.selectWithCondition(ipfCcmBoCheckGroup);
        ipfCcmBoCheckGroupSelectResponse.setResultJson(ipfCcmBoCheckGroups);
        return ipfCcmBoCheckGroupSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoCheckGroup.isExistIpfCcmBoCheckGroup", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoCheckGroup(IpfCcmBoCheckGroupSelectRequest request) {
        IpfCcmBoCheckGroup ipfCcmBoCheckGroup=new IpfCcmBoCheckGroup();
        ipfCcmBoCheckGroup.setId(request.getId());
        ipfCcmBoCheckGroup.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoCheckGroup.setGroupName(request.getGroupName());
        ipfCcmBoCheckGroup.setGroupDesc(request.getGroupDesc());
        ArrayList<IpfCcmBoCheckGroup> ipfCcmBoCheckGroups= ipfCcmBoCheckGroupService.selectWithCondition(ipfCcmBoCheckGroup);
    	IpfCcmBoCheckGroupCountAllResponse ipfCcmBoCheckGroupCountAllResponse = new IpfCcmBoCheckGroupCountAllResponse();
        if (ipfCcmBoCheckGroups.size()>0){
        	ipfCcmBoCheckGroupCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoCheckGroupCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoCheckGroupCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoCheckGroupCreateRequest request){
    	IpfCcmBoCheckGroup ipfCcmBoCheckGroup=new IpfCcmBoCheckGroup();
    	ipfCcmBoCheckGroup.setId(request.getId());
        ArrayList<IpfCcmBoCheckGroup> ipfCcmBoCheckGroups= ipfCcmBoCheckGroupService.selectWithCondition(ipfCcmBoCheckGroup);
        if (ipfCcmBoCheckGroups!=null&&ipfCcmBoCheckGroups.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoCheckGroupUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoCheckGroupDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoCheckGroupSelectRequest request){
        return  true;
     }    
}
