/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoFormColumn;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoFormColumn.request.*;
import com.cartan.center.ebs.ipfCcmBoFormColumn.response.*;
import com.cartan.core.ipfCcmBoFormColumn.domain.IpfCcmBoFormColumn;
import com.cartan.core.ipfCcmBoFormColumn.service.IpfCcmBoFormColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoFormColumnServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoFormColumnServiceEbs.class.getName());
	private IpfCcmBoFormColumnService  ipfCcmBoFormColumnService;
	
    public IpfCcmBoFormColumnService getIpfCcmBoFormColumnService() {
        return ipfCcmBoFormColumnService;
    }

    @Autowired
    public void setIpfCcmBoFormColumnService(IpfCcmBoFormColumnService ipfCcmBoFormColumnService) {
        this.ipfCcmBoFormColumnService = ipfCcmBoFormColumnService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoFormColumnGetSessionRequest request) {      
    	IpfCcmBoFormColumnGetSessionResponse ipfCcmBoFormColumnGetSessionResponse = new IpfCcmBoFormColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoFormColumnGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoFormColumnGetSessionResponse.setResultString("1");
            ipfCcmBoFormColumnGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoFormColumnGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoFormColumnGetSessionRequest request) {
    	IpfCcmBoFormColumnGetSessionResponse ipfCcmBoFormColumnGetSessionResponse = new IpfCcmBoFormColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoFormColumnGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoFormColumnGetSessionResponse.setResultString("0");
        }
        ipfCcmBoFormColumnGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoFormColumnGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoFormColumnGetSessionRequest request) {
    	IpfCcmBoFormColumnGetSessionResponse ipfCcmBoFormColumnGetSessionResponse = new IpfCcmBoFormColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoFormColumnGetSessionResponse.setResultString("0");
        	ipfCcmBoFormColumnGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoFormColumnGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoFormColumnGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.createIpfCcmBoFormColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoFormColumn(IpfCcmBoFormColumnCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoFormColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoFormColumn ipfCcmBoFormColumn=new IpfCcmBoFormColumn();
        ipfCcmBoFormColumn.setId(request.getId());    		
        ipfCcmBoFormColumn.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoFormColumn.setDefaultValue(request.getDefaultValue());
        ipfCcmBoFormColumn.setIsGroup(request.getIsGroup());
        ipfCcmBoFormColumn.setGroupName(request.getGroupName());
        ipfCcmBoFormColumn.setIsCaNote(request.getIsCaNote());
        ipfCcmBoFormColumn.setIsHeader(request.getIsHeader());
        ipfCcmBoFormColumn.setIsNotNull(request.getIsNotNull());
        ipfCcmBoFormColumn.setIsReadOnly(request.getIsReadOnly());
        ipfCcmBoFormColumn.setPropertyName(request.getPropertyName());
        ipfCcmBoFormColumn.setPropertyType(request.getPropertyType());
        ipfCcmBoFormColumn.setColumnNo(request.getColumnNo());
        ipfCcmBoFormColumn.setRowNo(request.getRowNo());
        ipfCcmBoFormColumn.setUiType(request.getUiType());
        ipfCcmBoFormColumn.setIsVisible(request.getIsVisible());
        ipfCcmBoFormColumn.setPropertyId(request.getPropertyId());
        ipfCcmBoFormColumn.setRuleNo(request.getRuleNo());
        ipfCcmBoFormColumn.setColumnStyle(request.getColumnStyle());
        ipfCcmBoFormColumn.setDisplayLable(request.getDisplayLable());
        ipfCcmBoFormColumn.setLableStyle(request.getLableStyle());
        ipfCcmBoFormColumn.setCellName(request.getCellName());
        ipfCcmBoFormColumn.setTextFormHeight(request.getTextFormHeight());
        ipfCcmBoFormColumn.setTextLineNum(request.getTextLineNum());
        ipfCcmBoFormColumn.setInlineWidth(request.getInlineWidth());
        ipfCcmBoFormColumn.setInlineOrderNo(request.getInlineOrderNo());
        ipfCcmBoFormColumn.setInlineConnector(request.getInlineConnector());
        ipfCcmBoFormColumn.setIsShowLabel(request.getIsShowLabel());
        ipfCcmBoFormColumn.setIsRadioInline(request.getIsRadioInline());
        ipfCcmBoFormColumn.setTabIndex(request.getTabIndex());
        ipfCcmBoFormColumn.setInitValueType(request.getInitValueType());
        ipfCcmBoFormColumn.setCorrectType(request.getCorrectType());
        ipfCcmBoFormColumn.setActiveExpress(request.getActiveExpress());
    	ipfCcmBoFormColumnService.createIpfCcmBoFormColumn(ipfCcmBoFormColumn);
        //返回响应
        IpfCcmBoFormColumnCreateResponse ipfCcmBoFormColumnCreateResponse = new IpfCcmBoFormColumnCreateResponse();
        ipfCcmBoFormColumnCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormColumnCreateResponse.setResultJson(ipfCcmBoFormColumn);
        return ipfCcmBoFormColumnCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.deleteIpfCcmBoFormColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoFormColumn(IpfCcmBoFormColumnDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoFormColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoFormColumnService.deleteIpfCcmBoFormColumn(idstr);
        //返回响应
        IpfCcmBoFormColumnDeleteResponse ipfCcmBoFormColumnDeleteResponse = new IpfCcmBoFormColumnDeleteResponse();
        ipfCcmBoFormColumnDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoFormColumnDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.updateIpfCcmBoFormColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoFormColumn(IpfCcmBoFormColumnUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoFormColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoFormColumn ipfCcmBoFormColumn=new IpfCcmBoFormColumn();
        ipfCcmBoFormColumn=ipfCcmBoFormColumnService.getIpfCcmBoFormColumn(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoFormColumn.setId(request.getId());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfCcmBoFormColumn.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getDefaultValue()!=null){
	        ipfCcmBoFormColumn.setDefaultValue(request.getDefaultValue());
        }
        if (request.getIsGroup()!=null){
	        ipfCcmBoFormColumn.setIsGroup(request.getIsGroup());
        }
        if (request.getGroupName()!=null){
	        ipfCcmBoFormColumn.setGroupName(request.getGroupName());
        }
        if (request.getIsCaNote()!=null){
	        ipfCcmBoFormColumn.setIsCaNote(request.getIsCaNote());
        }
        if (request.getIsHeader()!=null){
	        ipfCcmBoFormColumn.setIsHeader(request.getIsHeader());
        }
        if (request.getIsNotNull()!=null){
	        ipfCcmBoFormColumn.setIsNotNull(request.getIsNotNull());
        }
        if (request.getIsReadOnly()!=null){
	        ipfCcmBoFormColumn.setIsReadOnly(request.getIsReadOnly());
        }
        if (request.getPropertyName()!=null){
	        ipfCcmBoFormColumn.setPropertyName(request.getPropertyName());
        }
        if (request.getPropertyType()!=null){
	        ipfCcmBoFormColumn.setPropertyType(request.getPropertyType());
        }
        if (request.getColumnNo()!=null){
	        ipfCcmBoFormColumn.setColumnNo(request.getColumnNo());
        }
        if (request.getRowNo()!=null){
	        ipfCcmBoFormColumn.setRowNo(request.getRowNo());
        }
        if (request.getUiType()!=null){
	        ipfCcmBoFormColumn.setUiType(request.getUiType());
        }
        if (request.getIsVisible()!=null){
	        ipfCcmBoFormColumn.setIsVisible(request.getIsVisible());
        }
        if (request.getPropertyId()!=null){
	        ipfCcmBoFormColumn.setPropertyId(request.getPropertyId());
        }
        if (request.getRuleNo()!=null){
	        ipfCcmBoFormColumn.setRuleNo(request.getRuleNo());
        }
        if (request.getColumnStyle()!=null){
	        ipfCcmBoFormColumn.setColumnStyle(request.getColumnStyle());
        }
        if (request.getDisplayLable()!=null){
	        ipfCcmBoFormColumn.setDisplayLable(request.getDisplayLable());
        }
        if (request.getLableStyle()!=null){
	        ipfCcmBoFormColumn.setLableStyle(request.getLableStyle());
        }
        if (request.getCellName()!=null){
	        ipfCcmBoFormColumn.setCellName(request.getCellName());
        }
        if (request.getTextFormHeight()!=null){
	        ipfCcmBoFormColumn.setTextFormHeight(request.getTextFormHeight());
        }
        if (request.getTextLineNum()!=null){
	        ipfCcmBoFormColumn.setTextLineNum(request.getTextLineNum());
        }
        if (request.getInlineWidth()!=null){
	        ipfCcmBoFormColumn.setInlineWidth(request.getInlineWidth());
        }
        if (request.getInlineOrderNo()!=null){
	        ipfCcmBoFormColumn.setInlineOrderNo(request.getInlineOrderNo());
        }
        if (request.getInlineConnector()!=null){
	        ipfCcmBoFormColumn.setInlineConnector(request.getInlineConnector());
        }
        if (request.getIsShowLabel()!=null){
	        ipfCcmBoFormColumn.setIsShowLabel(request.getIsShowLabel());
        }
        if (request.getIsRadioInline()!=null){
	        ipfCcmBoFormColumn.setIsRadioInline(request.getIsRadioInline());
        }
        if (request.getTabIndex()!=null){
	        ipfCcmBoFormColumn.setTabIndex(request.getTabIndex());
        }
        if (request.getInitValueType()!=null){
	        ipfCcmBoFormColumn.setInitValueType(request.getInitValueType());
        }
        if (request.getCorrectType()!=null){
	        ipfCcmBoFormColumn.setCorrectType(request.getCorrectType());
        }
        if (request.getActiveExpress()!=null){
	        ipfCcmBoFormColumn.setActiveExpress(request.getActiveExpress());
        }
    	ipfCcmBoFormColumnService.updateIpfCcmBoFormColumn(ipfCcmBoFormColumn);
        //返回响应
        IpfCcmBoFormColumnUpdateResponse ipfCcmBoFormColumnUpdateResponse = new IpfCcmBoFormColumnUpdateResponse();
        ipfCcmBoFormColumnUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormColumnUpdateResponse.setResultJson(ipfCcmBoFormColumn);
        return ipfCcmBoFormColumnUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.getIpfCcmBoFormColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoFormColumn(IpfCcmBoFormColumnGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoFormColumn ipfCcmBoFormColumn=new IpfCcmBoFormColumn();
        ipfCcmBoFormColumn=ipfCcmBoFormColumnService.getIpfCcmBoFormColumn(id);
        //返回响应
        IpfCcmBoFormColumnGetResponse ipfCcmBoFormColumnGetResponse = new IpfCcmBoFormColumnGetResponse();
        ipfCcmBoFormColumnGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormColumnGetResponse.setResultJson(ipfCcmBoFormColumn);
        return ipfCcmBoFormColumnGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoFormColumnSelectAllRequest request) {
        IpfCcmBoFormColumnSelectAllResponse ipfCcmBoFormColumnSelectAllResponse = new IpfCcmBoFormColumnSelectAllResponse();
        ipfCcmBoFormColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormColumnSelectAllResponse.setResultJson(ipfCcmBoFormColumnService.selectAll());
        return ipfCcmBoFormColumnSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoFormColumnCountAllRequest request) {
        IpfCcmBoFormColumnCountAllResponse ipfCcmBoFormColumnCountAllResponse = new IpfCcmBoFormColumnCountAllResponse();
        ipfCcmBoFormColumnCountAllResponse.setResultString(String.valueOf(ipfCcmBoFormColumnService.countAll()));
        ipfCcmBoFormColumnCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoFormColumnCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoFormColumnSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoFormColumnSelectAllResponse ipfCcmBoFormColumnSelectAllResponse = new IpfCcmBoFormColumnSelectAllResponse();
        ipfCcmBoFormColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormColumnSelectAllResponse.setResultJson(ipfCcmBoFormColumnService.selectBySql(sqlstr));
        return ipfCcmBoFormColumnSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.selectIpfCcmBoFormColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoFormColumnSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoFormColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoFormColumn ipfCcmBoFormColumn=new IpfCcmBoFormColumn();
        ipfCcmBoFormColumn.setId(request.getId());
        ipfCcmBoFormColumn.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoFormColumn.setDefaultValue(request.getDefaultValue());
        ipfCcmBoFormColumn.setIsGroup(request.getIsGroup());
        ipfCcmBoFormColumn.setGroupName(request.getGroupName());
        ipfCcmBoFormColumn.setIsCaNote(request.getIsCaNote());
        ipfCcmBoFormColumn.setIsHeader(request.getIsHeader());
        ipfCcmBoFormColumn.setIsNotNull(request.getIsNotNull());
        ipfCcmBoFormColumn.setIsReadOnly(request.getIsReadOnly());
        ipfCcmBoFormColumn.setPropertyName(request.getPropertyName());
        ipfCcmBoFormColumn.setPropertyType(request.getPropertyType());
        ipfCcmBoFormColumn.setColumnNo(request.getColumnNo());
        ipfCcmBoFormColumn.setRowNo(request.getRowNo());
        ipfCcmBoFormColumn.setUiType(request.getUiType());
        ipfCcmBoFormColumn.setIsVisible(request.getIsVisible());
        ipfCcmBoFormColumn.setPropertyId(request.getPropertyId());
        ipfCcmBoFormColumn.setRuleNo(request.getRuleNo());
        ipfCcmBoFormColumn.setColumnStyle(request.getColumnStyle());
        ipfCcmBoFormColumn.setDisplayLable(request.getDisplayLable());
        ipfCcmBoFormColumn.setLableStyle(request.getLableStyle());
        ipfCcmBoFormColumn.setCellName(request.getCellName());
        ipfCcmBoFormColumn.setTextFormHeight(request.getTextFormHeight());
        ipfCcmBoFormColumn.setTextLineNum(request.getTextLineNum());
        ipfCcmBoFormColumn.setInlineWidth(request.getInlineWidth());
        ipfCcmBoFormColumn.setInlineOrderNo(request.getInlineOrderNo());
        ipfCcmBoFormColumn.setInlineConnector(request.getInlineConnector());
        ipfCcmBoFormColumn.setIsShowLabel(request.getIsShowLabel());
        ipfCcmBoFormColumn.setIsRadioInline(request.getIsRadioInline());
        ipfCcmBoFormColumn.setTabIndex(request.getTabIndex());
        ipfCcmBoFormColumn.setInitValueType(request.getInitValueType());
        ipfCcmBoFormColumn.setCorrectType(request.getCorrectType());
        ipfCcmBoFormColumn.setActiveExpress(request.getActiveExpress());
    	IpfCcmBoFormColumnSelectResponse ipfCcmBoFormColumnSelectResponse = new IpfCcmBoFormColumnSelectResponse();
        ipfCcmBoFormColumnSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoFormColumn> ipfCcmBoFormColumns= ipfCcmBoFormColumnService.selectWithCondition(ipfCcmBoFormColumn);
        ipfCcmBoFormColumnSelectResponse.setResultJson(ipfCcmBoFormColumns);
        return ipfCcmBoFormColumnSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormColumn.isExistIpfCcmBoFormColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoFormColumn(IpfCcmBoFormColumnSelectRequest request) {
        IpfCcmBoFormColumn ipfCcmBoFormColumn=new IpfCcmBoFormColumn();
        ipfCcmBoFormColumn.setId(request.getId());
        ipfCcmBoFormColumn.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoFormColumn.setDefaultValue(request.getDefaultValue());
        ipfCcmBoFormColumn.setIsGroup(request.getIsGroup());
        ipfCcmBoFormColumn.setGroupName(request.getGroupName());
        ipfCcmBoFormColumn.setIsCaNote(request.getIsCaNote());
        ipfCcmBoFormColumn.setIsHeader(request.getIsHeader());
        ipfCcmBoFormColumn.setIsNotNull(request.getIsNotNull());
        ipfCcmBoFormColumn.setIsReadOnly(request.getIsReadOnly());
        ipfCcmBoFormColumn.setPropertyName(request.getPropertyName());
        ipfCcmBoFormColumn.setPropertyType(request.getPropertyType());
        ipfCcmBoFormColumn.setColumnNo(request.getColumnNo());
        ipfCcmBoFormColumn.setRowNo(request.getRowNo());
        ipfCcmBoFormColumn.setUiType(request.getUiType());
        ipfCcmBoFormColumn.setIsVisible(request.getIsVisible());
        ipfCcmBoFormColumn.setPropertyId(request.getPropertyId());
        ipfCcmBoFormColumn.setRuleNo(request.getRuleNo());
        ipfCcmBoFormColumn.setColumnStyle(request.getColumnStyle());
        ipfCcmBoFormColumn.setDisplayLable(request.getDisplayLable());
        ipfCcmBoFormColumn.setLableStyle(request.getLableStyle());
        ipfCcmBoFormColumn.setCellName(request.getCellName());
        ipfCcmBoFormColumn.setTextFormHeight(request.getTextFormHeight());
        ipfCcmBoFormColumn.setTextLineNum(request.getTextLineNum());
        ipfCcmBoFormColumn.setInlineWidth(request.getInlineWidth());
        ipfCcmBoFormColumn.setInlineOrderNo(request.getInlineOrderNo());
        ipfCcmBoFormColumn.setInlineConnector(request.getInlineConnector());
        ipfCcmBoFormColumn.setIsShowLabel(request.getIsShowLabel());
        ipfCcmBoFormColumn.setIsRadioInline(request.getIsRadioInline());
        ipfCcmBoFormColumn.setTabIndex(request.getTabIndex());
        ipfCcmBoFormColumn.setInitValueType(request.getInitValueType());
        ipfCcmBoFormColumn.setCorrectType(request.getCorrectType());
        ipfCcmBoFormColumn.setActiveExpress(request.getActiveExpress());
        ArrayList<IpfCcmBoFormColumn> ipfCcmBoFormColumns= ipfCcmBoFormColumnService.selectWithCondition(ipfCcmBoFormColumn);
    	IpfCcmBoFormColumnCountAllResponse ipfCcmBoFormColumnCountAllResponse = new IpfCcmBoFormColumnCountAllResponse();
        if (ipfCcmBoFormColumns.size()>0){
        	ipfCcmBoFormColumnCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoFormColumnCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoFormColumnCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoFormColumnCreateRequest request){
    	IpfCcmBoFormColumn ipfCcmBoFormColumn=new IpfCcmBoFormColumn();
    	ipfCcmBoFormColumn.setId(request.getId());
        ArrayList<IpfCcmBoFormColumn> ipfCcmBoFormColumns= ipfCcmBoFormColumnService.selectWithCondition(ipfCcmBoFormColumn);
        if (ipfCcmBoFormColumns!=null&&ipfCcmBoFormColumns.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoFormColumnUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoFormColumnDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoFormColumnSelectRequest request){
        return  true;
     }    
}
