/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoRelation;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoRelation.request.*;
import com.cartan.center.ebs.ipfCcmBoRelation.response.*;
import com.cartan.core.ipfCcmBoRelation.domain.IpfCcmBoRelation;
import com.cartan.core.ipfCcmBoRelation.service.IpfCcmBoRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoRelationServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoRelationServiceEbs.class.getName());
	private IpfCcmBoRelationService  ipfCcmBoRelationService;
	
    public IpfCcmBoRelationService getIpfCcmBoRelationService() {
        return ipfCcmBoRelationService;
    }

    @Autowired
    public void setIpfCcmBoRelationService(IpfCcmBoRelationService ipfCcmBoRelationService) {
        this.ipfCcmBoRelationService = ipfCcmBoRelationService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoRelationGetSessionRequest request) {      
    	IpfCcmBoRelationGetSessionResponse ipfCcmBoRelationGetSessionResponse = new IpfCcmBoRelationGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoRelationGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoRelationGetSessionResponse.setResultString("1");
            ipfCcmBoRelationGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoRelationGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoRelationGetSessionRequest request) {
    	IpfCcmBoRelationGetSessionResponse ipfCcmBoRelationGetSessionResponse = new IpfCcmBoRelationGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoRelationGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoRelationGetSessionResponse.setResultString("0");
        }
        ipfCcmBoRelationGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoRelationGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoRelationGetSessionRequest request) {
    	IpfCcmBoRelationGetSessionResponse ipfCcmBoRelationGetSessionResponse = new IpfCcmBoRelationGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoRelationGetSessionResponse.setResultString("0");
        	ipfCcmBoRelationGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoRelationGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoRelationGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.createIpfCcmBoRelation", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoRelation(IpfCcmBoRelationCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoRelation_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoRelation ipfCcmBoRelation=new IpfCcmBoRelation();
        ipfCcmBoRelation.setId(request.getId());    		
        ipfCcmBoRelation.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoRelation.setPropertyName(request.getPropertyName());
        ipfCcmBoRelation.setSubBoName(request.getSubBoName());
        ipfCcmBoRelation.setSubBoRelType(request.getSubBoRelType());
        ipfCcmBoRelation.setObjectType(request.getObjectType());
        ipfCcmBoRelation.setDescription(request.getDescription());
        ipfCcmBoRelation.setSubBoOrderNo(request.getSubBoOrderNo());
        ipfCcmBoRelation.setPersistentSaveType(request.getPersistentSaveType());
        ipfCcmBoRelation.setGridEditType(request.getGridEditType());
        ipfCcmBoRelation.setLinkBoName(request.getLinkBoName());
    	ipfCcmBoRelationService.createIpfCcmBoRelation(ipfCcmBoRelation);
        //返回响应
        IpfCcmBoRelationCreateResponse ipfCcmBoRelationCreateResponse = new IpfCcmBoRelationCreateResponse();
        ipfCcmBoRelationCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoRelationCreateResponse.setResultJson(ipfCcmBoRelation);
        return ipfCcmBoRelationCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.deleteIpfCcmBoRelation", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoRelation(IpfCcmBoRelationDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoRelation_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoRelationService.deleteIpfCcmBoRelation(idstr);
        //返回响应
        IpfCcmBoRelationDeleteResponse ipfCcmBoRelationDeleteResponse = new IpfCcmBoRelationDeleteResponse();
        ipfCcmBoRelationDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoRelationDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.updateIpfCcmBoRelation", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoRelation(IpfCcmBoRelationUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoRelation_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoRelation ipfCcmBoRelation=new IpfCcmBoRelation();
        ipfCcmBoRelation=ipfCcmBoRelationService.getIpfCcmBoRelation(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoRelation.setId(request.getId());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfCcmBoRelation.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getPropertyName()!=null){
	        ipfCcmBoRelation.setPropertyName(request.getPropertyName());
        }
        if (request.getSubBoName()!=null){
	        ipfCcmBoRelation.setSubBoName(request.getSubBoName());
        }
        if (request.getSubBoRelType()!=null){
	        ipfCcmBoRelation.setSubBoRelType(request.getSubBoRelType());
        }
        if (request.getObjectType()!=null){
	        ipfCcmBoRelation.setObjectType(request.getObjectType());
        }
        if (request.getDescription()!=null){
	        ipfCcmBoRelation.setDescription(request.getDescription());
        }
        if (request.getSubBoOrderNo()!=null){
	        ipfCcmBoRelation.setSubBoOrderNo(request.getSubBoOrderNo());
        }
        if (request.getPersistentSaveType()!=null){
	        ipfCcmBoRelation.setPersistentSaveType(request.getPersistentSaveType());
        }
        if (request.getGridEditType()!=null){
	        ipfCcmBoRelation.setGridEditType(request.getGridEditType());
        }
        if (request.getLinkBoName()!=null){
	        ipfCcmBoRelation.setLinkBoName(request.getLinkBoName());
        }
    	ipfCcmBoRelationService.updateIpfCcmBoRelation(ipfCcmBoRelation);
        //返回响应
        IpfCcmBoRelationUpdateResponse ipfCcmBoRelationUpdateResponse = new IpfCcmBoRelationUpdateResponse();
        ipfCcmBoRelationUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoRelationUpdateResponse.setResultJson(ipfCcmBoRelation);
        return ipfCcmBoRelationUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.getIpfCcmBoRelation", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoRelation(IpfCcmBoRelationGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoRelation ipfCcmBoRelation=new IpfCcmBoRelation();
        ipfCcmBoRelation=ipfCcmBoRelationService.getIpfCcmBoRelation(id);
        //返回响应
        IpfCcmBoRelationGetResponse ipfCcmBoRelationGetResponse = new IpfCcmBoRelationGetResponse();
        ipfCcmBoRelationGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoRelationGetResponse.setResultJson(ipfCcmBoRelation);
        return ipfCcmBoRelationGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoRelationSelectAllRequest request) {
        IpfCcmBoRelationSelectAllResponse ipfCcmBoRelationSelectAllResponse = new IpfCcmBoRelationSelectAllResponse();
        ipfCcmBoRelationSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoRelationSelectAllResponse.setResultJson(ipfCcmBoRelationService.selectAll());
        return ipfCcmBoRelationSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoRelationCountAllRequest request) {
        IpfCcmBoRelationCountAllResponse ipfCcmBoRelationCountAllResponse = new IpfCcmBoRelationCountAllResponse();
        ipfCcmBoRelationCountAllResponse.setResultString(String.valueOf(ipfCcmBoRelationService.countAll()));
        ipfCcmBoRelationCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoRelationCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoRelationSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoRelationSelectAllResponse ipfCcmBoRelationSelectAllResponse = new IpfCcmBoRelationSelectAllResponse();
        ipfCcmBoRelationSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoRelationSelectAllResponse.setResultJson(ipfCcmBoRelationService.selectBySql(sqlstr));
        return ipfCcmBoRelationSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.selectIpfCcmBoRelation", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoRelationSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoRelation_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoRelation ipfCcmBoRelation=new IpfCcmBoRelation();
        ipfCcmBoRelation.setId(request.getId());
        ipfCcmBoRelation.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoRelation.setPropertyName(request.getPropertyName());
        ipfCcmBoRelation.setSubBoName(request.getSubBoName());
        ipfCcmBoRelation.setSubBoRelType(request.getSubBoRelType());
        ipfCcmBoRelation.setObjectType(request.getObjectType());
        ipfCcmBoRelation.setDescription(request.getDescription());
        ipfCcmBoRelation.setSubBoOrderNo(request.getSubBoOrderNo());
        ipfCcmBoRelation.setPersistentSaveType(request.getPersistentSaveType());
        ipfCcmBoRelation.setGridEditType(request.getGridEditType());
        ipfCcmBoRelation.setLinkBoName(request.getLinkBoName());
    	IpfCcmBoRelationSelectResponse ipfCcmBoRelationSelectResponse = new IpfCcmBoRelationSelectResponse();
        ipfCcmBoRelationSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoRelation> ipfCcmBoRelations= ipfCcmBoRelationService.selectWithCondition(ipfCcmBoRelation);
        ipfCcmBoRelationSelectResponse.setResultJson(ipfCcmBoRelations);
        return ipfCcmBoRelationSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoRelation.isExistIpfCcmBoRelation", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoRelation(IpfCcmBoRelationSelectRequest request) {
        IpfCcmBoRelation ipfCcmBoRelation=new IpfCcmBoRelation();
        ipfCcmBoRelation.setId(request.getId());
        ipfCcmBoRelation.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoRelation.setPropertyName(request.getPropertyName());
        ipfCcmBoRelation.setSubBoName(request.getSubBoName());
        ipfCcmBoRelation.setSubBoRelType(request.getSubBoRelType());
        ipfCcmBoRelation.setObjectType(request.getObjectType());
        ipfCcmBoRelation.setDescription(request.getDescription());
        ipfCcmBoRelation.setSubBoOrderNo(request.getSubBoOrderNo());
        ipfCcmBoRelation.setPersistentSaveType(request.getPersistentSaveType());
        ipfCcmBoRelation.setGridEditType(request.getGridEditType());
        ipfCcmBoRelation.setLinkBoName(request.getLinkBoName());
        ArrayList<IpfCcmBoRelation> ipfCcmBoRelations= ipfCcmBoRelationService.selectWithCondition(ipfCcmBoRelation);
    	IpfCcmBoRelationCountAllResponse ipfCcmBoRelationCountAllResponse = new IpfCcmBoRelationCountAllResponse();
        if (ipfCcmBoRelations.size()>0){
        	ipfCcmBoRelationCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoRelationCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoRelationCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoRelationCreateRequest request){
    	IpfCcmBoRelation ipfCcmBoRelation=new IpfCcmBoRelation();
    	ipfCcmBoRelation.setId(request.getId());
        ArrayList<IpfCcmBoRelation> ipfCcmBoRelations= ipfCcmBoRelationService.selectWithCondition(ipfCcmBoRelation);
        if (ipfCcmBoRelations!=null&&ipfCcmBoRelations.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoRelationUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoRelationDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoRelationSelectRequest request){
        return  true;
     }    
}
