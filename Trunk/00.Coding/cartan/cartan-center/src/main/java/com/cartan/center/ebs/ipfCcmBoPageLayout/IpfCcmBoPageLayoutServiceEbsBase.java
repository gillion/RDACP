/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoPageLayout;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoPageLayout.request.*;
import com.cartan.center.ebs.ipfCcmBoPageLayout.response.*;
import com.cartan.core.ipfCcmBoPageLayout.domain.IpfCcmBoPageLayout;
import com.cartan.core.ipfCcmBoPageLayout.service.IpfCcmBoPageLayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoPageLayoutServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoPageLayoutServiceEbs.class.getName());
	private IpfCcmBoPageLayoutService  ipfCcmBoPageLayoutService;
	
    public IpfCcmBoPageLayoutService getIpfCcmBoPageLayoutService() {
        return ipfCcmBoPageLayoutService;
    }

    @Autowired
    public void setIpfCcmBoPageLayoutService(IpfCcmBoPageLayoutService ipfCcmBoPageLayoutService) {
        this.ipfCcmBoPageLayoutService = ipfCcmBoPageLayoutService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoPageLayoutGetSessionRequest request) {      
    	IpfCcmBoPageLayoutGetSessionResponse ipfCcmBoPageLayoutGetSessionResponse = new IpfCcmBoPageLayoutGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoPageLayoutGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoPageLayoutGetSessionResponse.setResultString("1");
            ipfCcmBoPageLayoutGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoPageLayoutGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoPageLayoutGetSessionRequest request) {
    	IpfCcmBoPageLayoutGetSessionResponse ipfCcmBoPageLayoutGetSessionResponse = new IpfCcmBoPageLayoutGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoPageLayoutGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoPageLayoutGetSessionResponse.setResultString("0");
        }
        ipfCcmBoPageLayoutGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoPageLayoutGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoPageLayoutGetSessionRequest request) {
    	IpfCcmBoPageLayoutGetSessionResponse ipfCcmBoPageLayoutGetSessionResponse = new IpfCcmBoPageLayoutGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoPageLayoutGetSessionResponse.setResultString("0");
        	ipfCcmBoPageLayoutGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoPageLayoutGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoPageLayoutGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.createIpfCcmBoPageLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoPageLayout(IpfCcmBoPageLayoutCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoPageLayout_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPageLayout ipfCcmBoPageLayout=new IpfCcmBoPageLayout();
        ipfCcmBoPageLayout.setId(request.getId());    		
        ipfCcmBoPageLayout.setIpfCcmBoPageId(request.getIpfCcmBoPageId());
        ipfCcmBoPageLayout.setLayoutType(request.getLayoutType());
        ipfCcmBoPageLayout.setLayoutContainerType(request.getLayoutContainerType());
        ipfCcmBoPageLayout.setLayoutBoName(request.getLayoutBoName());
        ipfCcmBoPageLayout.setStyleClass(request.getStyleClass());
        ipfCcmBoPageLayout.setStyle(request.getStyle());
        ipfCcmBoPageLayout.setFormType(request.getFormType());
        ipfCcmBoPageLayout.setElementName(request.getElementName());
        ipfCcmBoPageLayout.setHeight(request.getHeight());
        ipfCcmBoPageLayout.setIsShowGroup(request.getIsShowGroup());
        ipfCcmBoPageLayout.setGroupWidget(request.getGroupWidget());
        ipfCcmBoPageLayout.setGroupMsgCode(request.getGroupMsgCode());
        ipfCcmBoPageLayout.setGroupTitle(request.getGroupTitle());
        ipfCcmBoPageLayout.setUnitCount(request.getUnitCount());
        ipfCcmBoPageLayout.setIsParent(request.getIsParent());
        ipfCcmBoPageLayout.setChildrenLineCount(request.getChildrenLineCount());
        ipfCcmBoPageLayout.setCellName(request.getCellName());
        ipfCcmBoPageLayout.setRowNo(request.getRowNo());
        ipfCcmBoPageLayout.setColumnNo(request.getColumnNo());
        ipfCcmBoPageLayout.setLabelUnitCount(request.getLabelUnitCount());
        ipfCcmBoPageLayout.setSeqNo(request.getSeqNo());
        ipfCcmBoPageLayout.setControlConnector(request.getControlConnector());
        ipfCcmBoPageLayout.setParentCellName(request.getParentCellName());
    	ipfCcmBoPageLayoutService.createIpfCcmBoPageLayout(ipfCcmBoPageLayout);
        //返回响应
        IpfCcmBoPageLayoutCreateResponse ipfCcmBoPageLayoutCreateResponse = new IpfCcmBoPageLayoutCreateResponse();
        ipfCcmBoPageLayoutCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPageLayoutCreateResponse.setResultJson(ipfCcmBoPageLayout);
        return ipfCcmBoPageLayoutCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.deleteIpfCcmBoPageLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoPageLayout(IpfCcmBoPageLayoutDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoPageLayout_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoPageLayoutService.deleteIpfCcmBoPageLayout(idstr);
        //返回响应
        IpfCcmBoPageLayoutDeleteResponse ipfCcmBoPageLayoutDeleteResponse = new IpfCcmBoPageLayoutDeleteResponse();
        ipfCcmBoPageLayoutDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoPageLayoutDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.updateIpfCcmBoPageLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoPageLayout(IpfCcmBoPageLayoutUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoPageLayout_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPageLayout ipfCcmBoPageLayout=new IpfCcmBoPageLayout();
        ipfCcmBoPageLayout=ipfCcmBoPageLayoutService.getIpfCcmBoPageLayout(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoPageLayout.setId(request.getId());
        }
        if (request.getIpfCcmBoPageId()!=null){
	        ipfCcmBoPageLayout.setIpfCcmBoPageId(request.getIpfCcmBoPageId());
        }
        if (request.getLayoutType()!=null){
	        ipfCcmBoPageLayout.setLayoutType(request.getLayoutType());
        }
        if (request.getLayoutContainerType()!=null){
	        ipfCcmBoPageLayout.setLayoutContainerType(request.getLayoutContainerType());
        }
        if (request.getLayoutBoName()!=null){
	        ipfCcmBoPageLayout.setLayoutBoName(request.getLayoutBoName());
        }
        if (request.getStyleClass()!=null){
	        ipfCcmBoPageLayout.setStyleClass(request.getStyleClass());
        }
        if (request.getStyle()!=null){
	        ipfCcmBoPageLayout.setStyle(request.getStyle());
        }
        if (request.getFormType()!=null){
	        ipfCcmBoPageLayout.setFormType(request.getFormType());
        }
        if (request.getElementName()!=null){
	        ipfCcmBoPageLayout.setElementName(request.getElementName());
        }
        if (request.getHeight()!=null){
	        ipfCcmBoPageLayout.setHeight(request.getHeight());
        }
        if (request.getIsShowGroup()!=null){
	        ipfCcmBoPageLayout.setIsShowGroup(request.getIsShowGroup());
        }
        if (request.getGroupWidget()!=null){
	        ipfCcmBoPageLayout.setGroupWidget(request.getGroupWidget());
        }
        if (request.getGroupMsgCode()!=null){
	        ipfCcmBoPageLayout.setGroupMsgCode(request.getGroupMsgCode());
        }
        if (request.getGroupTitle()!=null){
	        ipfCcmBoPageLayout.setGroupTitle(request.getGroupTitle());
        }
        if (request.getUnitCount()!=null){
	        ipfCcmBoPageLayout.setUnitCount(request.getUnitCount());
        }
        if (request.getIsParent()!=null){
	        ipfCcmBoPageLayout.setIsParent(request.getIsParent());
        }
        if (request.getChildrenLineCount()!=null){
	        ipfCcmBoPageLayout.setChildrenLineCount(request.getChildrenLineCount());
        }
        if (request.getCellName()!=null){
	        ipfCcmBoPageLayout.setCellName(request.getCellName());
        }
        if (request.getRowNo()!=null){
	        ipfCcmBoPageLayout.setRowNo(request.getRowNo());
        }
        if (request.getColumnNo()!=null){
	        ipfCcmBoPageLayout.setColumnNo(request.getColumnNo());
        }
        if (request.getLabelUnitCount()!=null){
	        ipfCcmBoPageLayout.setLabelUnitCount(request.getLabelUnitCount());
        }
        if (request.getSeqNo()!=null){
	        ipfCcmBoPageLayout.setSeqNo(request.getSeqNo());
        }
        if (request.getControlConnector()!=null){
	        ipfCcmBoPageLayout.setControlConnector(request.getControlConnector());
        }
        if (request.getParentCellName()!=null){
	        ipfCcmBoPageLayout.setParentCellName(request.getParentCellName());
        }
    	ipfCcmBoPageLayoutService.updateIpfCcmBoPageLayout(ipfCcmBoPageLayout);
        //返回响应
        IpfCcmBoPageLayoutUpdateResponse ipfCcmBoPageLayoutUpdateResponse = new IpfCcmBoPageLayoutUpdateResponse();
        ipfCcmBoPageLayoutUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPageLayoutUpdateResponse.setResultJson(ipfCcmBoPageLayout);
        return ipfCcmBoPageLayoutUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.getIpfCcmBoPageLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoPageLayout(IpfCcmBoPageLayoutGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoPageLayout ipfCcmBoPageLayout=new IpfCcmBoPageLayout();
        ipfCcmBoPageLayout=ipfCcmBoPageLayoutService.getIpfCcmBoPageLayout(id);
        //返回响应
        IpfCcmBoPageLayoutGetResponse ipfCcmBoPageLayoutGetResponse = new IpfCcmBoPageLayoutGetResponse();
        ipfCcmBoPageLayoutGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPageLayoutGetResponse.setResultJson(ipfCcmBoPageLayout);
        return ipfCcmBoPageLayoutGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoPageLayoutSelectAllRequest request) {
        IpfCcmBoPageLayoutSelectAllResponse ipfCcmBoPageLayoutSelectAllResponse = new IpfCcmBoPageLayoutSelectAllResponse();
        ipfCcmBoPageLayoutSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPageLayoutSelectAllResponse.setResultJson(ipfCcmBoPageLayoutService.selectAll());
        return ipfCcmBoPageLayoutSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoPageLayoutCountAllRequest request) {
        IpfCcmBoPageLayoutCountAllResponse ipfCcmBoPageLayoutCountAllResponse = new IpfCcmBoPageLayoutCountAllResponse();
        ipfCcmBoPageLayoutCountAllResponse.setResultString(String.valueOf(ipfCcmBoPageLayoutService.countAll()));
        ipfCcmBoPageLayoutCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoPageLayoutCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoPageLayoutSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoPageLayoutSelectAllResponse ipfCcmBoPageLayoutSelectAllResponse = new IpfCcmBoPageLayoutSelectAllResponse();
        ipfCcmBoPageLayoutSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPageLayoutSelectAllResponse.setResultJson(ipfCcmBoPageLayoutService.selectBySql(sqlstr));
        return ipfCcmBoPageLayoutSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.selectIpfCcmBoPageLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoPageLayoutSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoPageLayout_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPageLayout ipfCcmBoPageLayout=new IpfCcmBoPageLayout();
        ipfCcmBoPageLayout.setId(request.getId());
        ipfCcmBoPageLayout.setIpfCcmBoPageId(request.getIpfCcmBoPageId());
        ipfCcmBoPageLayout.setLayoutType(request.getLayoutType());
        ipfCcmBoPageLayout.setLayoutContainerType(request.getLayoutContainerType());
        ipfCcmBoPageLayout.setLayoutBoName(request.getLayoutBoName());
        ipfCcmBoPageLayout.setStyleClass(request.getStyleClass());
        ipfCcmBoPageLayout.setStyle(request.getStyle());
        ipfCcmBoPageLayout.setFormType(request.getFormType());
        ipfCcmBoPageLayout.setElementName(request.getElementName());
        ipfCcmBoPageLayout.setHeight(request.getHeight());
        ipfCcmBoPageLayout.setIsShowGroup(request.getIsShowGroup());
        ipfCcmBoPageLayout.setGroupWidget(request.getGroupWidget());
        ipfCcmBoPageLayout.setGroupMsgCode(request.getGroupMsgCode());
        ipfCcmBoPageLayout.setGroupTitle(request.getGroupTitle());
        ipfCcmBoPageLayout.setUnitCount(request.getUnitCount());
        ipfCcmBoPageLayout.setIsParent(request.getIsParent());
        ipfCcmBoPageLayout.setChildrenLineCount(request.getChildrenLineCount());
        ipfCcmBoPageLayout.setCellName(request.getCellName());
        ipfCcmBoPageLayout.setRowNo(request.getRowNo());
        ipfCcmBoPageLayout.setColumnNo(request.getColumnNo());
        ipfCcmBoPageLayout.setLabelUnitCount(request.getLabelUnitCount());
        ipfCcmBoPageLayout.setSeqNo(request.getSeqNo());
        ipfCcmBoPageLayout.setControlConnector(request.getControlConnector());
        ipfCcmBoPageLayout.setParentCellName(request.getParentCellName());
    	IpfCcmBoPageLayoutSelectResponse ipfCcmBoPageLayoutSelectResponse = new IpfCcmBoPageLayoutSelectResponse();
        ipfCcmBoPageLayoutSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoPageLayout> ipfCcmBoPageLayouts= ipfCcmBoPageLayoutService.selectWithCondition(ipfCcmBoPageLayout);
        ipfCcmBoPageLayoutSelectResponse.setResultJson(ipfCcmBoPageLayouts);
        return ipfCcmBoPageLayoutSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPageLayout.isExistIpfCcmBoPageLayout", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoPageLayout(IpfCcmBoPageLayoutSelectRequest request) {
        IpfCcmBoPageLayout ipfCcmBoPageLayout=new IpfCcmBoPageLayout();
        ipfCcmBoPageLayout.setId(request.getId());
        ipfCcmBoPageLayout.setIpfCcmBoPageId(request.getIpfCcmBoPageId());
        ipfCcmBoPageLayout.setLayoutType(request.getLayoutType());
        ipfCcmBoPageLayout.setLayoutContainerType(request.getLayoutContainerType());
        ipfCcmBoPageLayout.setLayoutBoName(request.getLayoutBoName());
        ipfCcmBoPageLayout.setStyleClass(request.getStyleClass());
        ipfCcmBoPageLayout.setStyle(request.getStyle());
        ipfCcmBoPageLayout.setFormType(request.getFormType());
        ipfCcmBoPageLayout.setElementName(request.getElementName());
        ipfCcmBoPageLayout.setHeight(request.getHeight());
        ipfCcmBoPageLayout.setIsShowGroup(request.getIsShowGroup());
        ipfCcmBoPageLayout.setGroupWidget(request.getGroupWidget());
        ipfCcmBoPageLayout.setGroupMsgCode(request.getGroupMsgCode());
        ipfCcmBoPageLayout.setGroupTitle(request.getGroupTitle());
        ipfCcmBoPageLayout.setUnitCount(request.getUnitCount());
        ipfCcmBoPageLayout.setIsParent(request.getIsParent());
        ipfCcmBoPageLayout.setChildrenLineCount(request.getChildrenLineCount());
        ipfCcmBoPageLayout.setCellName(request.getCellName());
        ipfCcmBoPageLayout.setRowNo(request.getRowNo());
        ipfCcmBoPageLayout.setColumnNo(request.getColumnNo());
        ipfCcmBoPageLayout.setLabelUnitCount(request.getLabelUnitCount());
        ipfCcmBoPageLayout.setSeqNo(request.getSeqNo());
        ipfCcmBoPageLayout.setControlConnector(request.getControlConnector());
        ipfCcmBoPageLayout.setParentCellName(request.getParentCellName());
        ArrayList<IpfCcmBoPageLayout> ipfCcmBoPageLayouts= ipfCcmBoPageLayoutService.selectWithCondition(ipfCcmBoPageLayout);
    	IpfCcmBoPageLayoutCountAllResponse ipfCcmBoPageLayoutCountAllResponse = new IpfCcmBoPageLayoutCountAllResponse();
        if (ipfCcmBoPageLayouts.size()>0){
        	ipfCcmBoPageLayoutCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoPageLayoutCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoPageLayoutCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoPageLayoutCreateRequest request){
    	IpfCcmBoPageLayout ipfCcmBoPageLayout=new IpfCcmBoPageLayout();
    	ipfCcmBoPageLayout.setId(request.getId());
        ArrayList<IpfCcmBoPageLayout> ipfCcmBoPageLayouts= ipfCcmBoPageLayoutService.selectWithCondition(ipfCcmBoPageLayout);
        if (ipfCcmBoPageLayouts!=null&&ipfCcmBoPageLayouts.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoPageLayoutUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoPageLayoutDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoPageLayoutSelectRequest request){
        return  true;
     }    
}
