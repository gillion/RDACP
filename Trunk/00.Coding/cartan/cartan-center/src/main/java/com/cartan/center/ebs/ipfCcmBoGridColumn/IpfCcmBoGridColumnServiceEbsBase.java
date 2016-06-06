/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoGridColumn;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoGridColumn.request.*;
import com.cartan.center.ebs.ipfCcmBoGridColumn.response.*;
import com.cartan.core.ipfCcmBoGridColumn.domain.IpfCcmBoGridColumn;
import com.cartan.core.ipfCcmBoGridColumn.service.IpfCcmBoGridColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoGridColumnServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoGridColumnServiceEbs.class.getName());
	private IpfCcmBoGridColumnService  ipfCcmBoGridColumnService;
	
    public IpfCcmBoGridColumnService getIpfCcmBoGridColumnService() {
        return ipfCcmBoGridColumnService;
    }

    @Autowired
    public void setIpfCcmBoGridColumnService(IpfCcmBoGridColumnService ipfCcmBoGridColumnService) {
        this.ipfCcmBoGridColumnService = ipfCcmBoGridColumnService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoGridColumnGetSessionRequest request) {      
    	IpfCcmBoGridColumnGetSessionResponse ipfCcmBoGridColumnGetSessionResponse = new IpfCcmBoGridColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoGridColumnGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoGridColumnGetSessionResponse.setResultString("1");
            ipfCcmBoGridColumnGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoGridColumnGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoGridColumnGetSessionRequest request) {
    	IpfCcmBoGridColumnGetSessionResponse ipfCcmBoGridColumnGetSessionResponse = new IpfCcmBoGridColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoGridColumnGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoGridColumnGetSessionResponse.setResultString("0");
        }
        ipfCcmBoGridColumnGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoGridColumnGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoGridColumnGetSessionRequest request) {
    	IpfCcmBoGridColumnGetSessionResponse ipfCcmBoGridColumnGetSessionResponse = new IpfCcmBoGridColumnGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoGridColumnGetSessionResponse.setResultString("0");
        	ipfCcmBoGridColumnGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoGridColumnGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoGridColumnGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.createIpfCcmBoGridColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoGridColumn(IpfCcmBoGridColumnCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoGridColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoGridColumn ipfCcmBoGridColumn=new IpfCcmBoGridColumn();
        ipfCcmBoGridColumn.setId(request.getId());    		
        ipfCcmBoGridColumn.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoGridColumn.setDefaultValue(request.getDefaultValue());
        ipfCcmBoGridColumn.setIsCondition(request.getIsCondition());
        ipfCcmBoGridColumn.setIsRange(request.getIsRange());
        ipfCcmBoGridColumn.setCorrectType(request.getCorrectType());
        ipfCcmBoGridColumn.setIsSum(request.getIsSum());
        ipfCcmBoGridColumn.setIsNotNull(request.getIsNotNull());
        ipfCcmBoGridColumn.setIsOrderBy(request.getIsOrderBy());
        ipfCcmBoGridColumn.setPropertyName(request.getPropertyName());
        ipfCcmBoGridColumn.setPropertyType(request.getPropertyType());
        ipfCcmBoGridColumn.setUiType(request.getUiType());
        ipfCcmBoGridColumn.setColumnNo(request.getColumnNo());
        ipfCcmBoGridColumn.setIsReadOnly(request.getIsReadOnly());
        ipfCcmBoGridColumn.setIsVisible(request.getIsVisible());
        ipfCcmBoGridColumn.setWidth(request.getWidth());
        ipfCcmBoGridColumn.setPropertyId(request.getPropertyId());
        ipfCcmBoGridColumn.setCellRuleNo(request.getCellRuleNo());
        ipfCcmBoGridColumn.setMethodId(request.getMethodId());
        ipfCcmBoGridColumn.setMethodName(request.getMethodName());
        ipfCcmBoGridColumn.setSearchColumnNo(request.getSearchColumnNo());
        ipfCcmBoGridColumn.setSearchRowNo(request.getSearchRowNo());
        ipfCcmBoGridColumn.setOperation(request.getOperation());
        ipfCcmBoGridColumn.setConditionVisible(request.getConditionVisible());
        ipfCcmBoGridColumn.setShlpValueType(request.getShlpValueType());
        ipfCcmBoGridColumn.setIsQuickSearch(request.getIsQuickSearch());
        ipfCcmBoGridColumn.setQuickCellName(request.getQuickCellName());
        ipfCcmBoGridColumn.setQuickTextFormHeight(request.getQuickTextFormHeight());
        ipfCcmBoGridColumn.setQuickTextLineNum(request.getQuickTextLineNum());
        ipfCcmBoGridColumn.setQuickInlineWidth(request.getQuickInlineWidth());
        ipfCcmBoGridColumn.setQuickInlineOrderNo(request.getQuickInlineOrderNo());
        ipfCcmBoGridColumn.setQuickInlineConnector(request.getQuickInlineConnector());
        ipfCcmBoGridColumn.setIsQuickShowLabel(request.getIsQuickShowLabel());
        ipfCcmBoGridColumn.setIsQuickRadioInline(request.getIsQuickRadioInline());
        ipfCcmBoGridColumn.setIsAdvSearch(request.getIsAdvSearch());
        ipfCcmBoGridColumn.setAdvCellName(request.getAdvCellName());
        ipfCcmBoGridColumn.setAdvTextFormHeight(request.getAdvTextFormHeight());
        ipfCcmBoGridColumn.setAdvTextLineNum(request.getAdvTextLineNum());
        ipfCcmBoGridColumn.setAdvInlineWidth(request.getAdvInlineWidth());
        ipfCcmBoGridColumn.setAdvInlineOrderNo(request.getAdvInlineOrderNo());
        ipfCcmBoGridColumn.setAdvInlineConnector(request.getAdvInlineConnector());
        ipfCcmBoGridColumn.setIsAdvShowLabel(request.getIsAdvShowLabel());
        ipfCcmBoGridColumn.setIsAdvRadioInline(request.getIsAdvRadioInline());
        ipfCcmBoGridColumn.setTabIndex(request.getTabIndex());
        ipfCcmBoGridColumn.setIsCellEditable(request.getIsCellEditable());
        ipfCcmBoGridColumn.setInitValueType(request.getInitValueType());
        ipfCcmBoGridColumn.setInitValueType2(request.getInitValueType2());
        ipfCcmBoGridColumn.setDefaultValue2(request.getDefaultValue2());
        ipfCcmBoGridColumn.setFieldSort(request.getFieldSort());
        ipfCcmBoGridColumn.setActiveExpress(request.getActiveExpress());
        ipfCcmBoGridColumn.setLockColumnExpress(request.getLockColumnExpress());
        ipfCcmBoGridColumn.setUnlockColumnExpress(request.getUnlockColumnExpress());
        ipfCcmBoGridColumn.setIsShowSort(request.getIsShowSort());
    	ipfCcmBoGridColumnService.createIpfCcmBoGridColumn(ipfCcmBoGridColumn);
        //返回响应
        IpfCcmBoGridColumnCreateResponse ipfCcmBoGridColumnCreateResponse = new IpfCcmBoGridColumnCreateResponse();
        ipfCcmBoGridColumnCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoGridColumnCreateResponse.setResultJson(ipfCcmBoGridColumn);
        return ipfCcmBoGridColumnCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.deleteIpfCcmBoGridColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoGridColumn(IpfCcmBoGridColumnDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoGridColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoGridColumnService.deleteIpfCcmBoGridColumn(idstr);
        //返回响应
        IpfCcmBoGridColumnDeleteResponse ipfCcmBoGridColumnDeleteResponse = new IpfCcmBoGridColumnDeleteResponse();
        ipfCcmBoGridColumnDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoGridColumnDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.updateIpfCcmBoGridColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoGridColumn(IpfCcmBoGridColumnUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoGridColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoGridColumn ipfCcmBoGridColumn=new IpfCcmBoGridColumn();
        ipfCcmBoGridColumn=ipfCcmBoGridColumnService.getIpfCcmBoGridColumn(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoGridColumn.setId(request.getId());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfCcmBoGridColumn.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getDefaultValue()!=null){
	        ipfCcmBoGridColumn.setDefaultValue(request.getDefaultValue());
        }
        if (request.getIsCondition()!=null){
	        ipfCcmBoGridColumn.setIsCondition(request.getIsCondition());
        }
        if (request.getIsRange()!=null){
	        ipfCcmBoGridColumn.setIsRange(request.getIsRange());
        }
        if (request.getCorrectType()!=null){
	        ipfCcmBoGridColumn.setCorrectType(request.getCorrectType());
        }
        if (request.getIsSum()!=null){
	        ipfCcmBoGridColumn.setIsSum(request.getIsSum());
        }
        if (request.getIsNotNull()!=null){
	        ipfCcmBoGridColumn.setIsNotNull(request.getIsNotNull());
        }
        if (request.getIsOrderBy()!=null){
	        ipfCcmBoGridColumn.setIsOrderBy(request.getIsOrderBy());
        }
        if (request.getPropertyName()!=null){
	        ipfCcmBoGridColumn.setPropertyName(request.getPropertyName());
        }
        if (request.getPropertyType()!=null){
	        ipfCcmBoGridColumn.setPropertyType(request.getPropertyType());
        }
        if (request.getUiType()!=null){
	        ipfCcmBoGridColumn.setUiType(request.getUiType());
        }
        if (request.getColumnNo()!=null){
	        ipfCcmBoGridColumn.setColumnNo(request.getColumnNo());
        }
        if (request.getIsReadOnly()!=null){
	        ipfCcmBoGridColumn.setIsReadOnly(request.getIsReadOnly());
        }
        if (request.getIsVisible()!=null){
	        ipfCcmBoGridColumn.setIsVisible(request.getIsVisible());
        }
        if (request.getWidth()!=null){
	        ipfCcmBoGridColumn.setWidth(request.getWidth());
        }
        if (request.getPropertyId()!=null){
	        ipfCcmBoGridColumn.setPropertyId(request.getPropertyId());
        }
        if (request.getCellRuleNo()!=null){
	        ipfCcmBoGridColumn.setCellRuleNo(request.getCellRuleNo());
        }
        if (request.getMethodId()!=null){
	        ipfCcmBoGridColumn.setMethodId(request.getMethodId());
        }
        if (request.getMethodName()!=null){
	        ipfCcmBoGridColumn.setMethodName(request.getMethodName());
        }
        if (request.getSearchColumnNo()!=null){
	        ipfCcmBoGridColumn.setSearchColumnNo(request.getSearchColumnNo());
        }
        if (request.getSearchRowNo()!=null){
	        ipfCcmBoGridColumn.setSearchRowNo(request.getSearchRowNo());
        }
        if (request.getOperation()!=null){
	        ipfCcmBoGridColumn.setOperation(request.getOperation());
        }
        if (request.getConditionVisible()!=null){
	        ipfCcmBoGridColumn.setConditionVisible(request.getConditionVisible());
        }
        if (request.getShlpValueType()!=null){
	        ipfCcmBoGridColumn.setShlpValueType(request.getShlpValueType());
        }
        if (request.getIsQuickSearch()!=null){
	        ipfCcmBoGridColumn.setIsQuickSearch(request.getIsQuickSearch());
        }
        if (request.getQuickCellName()!=null){
	        ipfCcmBoGridColumn.setQuickCellName(request.getQuickCellName());
        }
        if (request.getQuickTextFormHeight()!=null){
	        ipfCcmBoGridColumn.setQuickTextFormHeight(request.getQuickTextFormHeight());
        }
        if (request.getQuickTextLineNum()!=null){
	        ipfCcmBoGridColumn.setQuickTextLineNum(request.getQuickTextLineNum());
        }
        if (request.getQuickInlineWidth()!=null){
	        ipfCcmBoGridColumn.setQuickInlineWidth(request.getQuickInlineWidth());
        }
        if (request.getQuickInlineOrderNo()!=null){
	        ipfCcmBoGridColumn.setQuickInlineOrderNo(request.getQuickInlineOrderNo());
        }
        if (request.getQuickInlineConnector()!=null){
	        ipfCcmBoGridColumn.setQuickInlineConnector(request.getQuickInlineConnector());
        }
        if (request.getIsQuickShowLabel()!=null){
	        ipfCcmBoGridColumn.setIsQuickShowLabel(request.getIsQuickShowLabel());
        }
        if (request.getIsQuickRadioInline()!=null){
	        ipfCcmBoGridColumn.setIsQuickRadioInline(request.getIsQuickRadioInline());
        }
        if (request.getIsAdvSearch()!=null){
	        ipfCcmBoGridColumn.setIsAdvSearch(request.getIsAdvSearch());
        }
        if (request.getAdvCellName()!=null){
	        ipfCcmBoGridColumn.setAdvCellName(request.getAdvCellName());
        }
        if (request.getAdvTextFormHeight()!=null){
	        ipfCcmBoGridColumn.setAdvTextFormHeight(request.getAdvTextFormHeight());
        }
        if (request.getAdvTextLineNum()!=null){
	        ipfCcmBoGridColumn.setAdvTextLineNum(request.getAdvTextLineNum());
        }
        if (request.getAdvInlineWidth()!=null){
	        ipfCcmBoGridColumn.setAdvInlineWidth(request.getAdvInlineWidth());
        }
        if (request.getAdvInlineOrderNo()!=null){
	        ipfCcmBoGridColumn.setAdvInlineOrderNo(request.getAdvInlineOrderNo());
        }
        if (request.getAdvInlineConnector()!=null){
	        ipfCcmBoGridColumn.setAdvInlineConnector(request.getAdvInlineConnector());
        }
        if (request.getIsAdvShowLabel()!=null){
	        ipfCcmBoGridColumn.setIsAdvShowLabel(request.getIsAdvShowLabel());
        }
        if (request.getIsAdvRadioInline()!=null){
	        ipfCcmBoGridColumn.setIsAdvRadioInline(request.getIsAdvRadioInline());
        }
        if (request.getTabIndex()!=null){
	        ipfCcmBoGridColumn.setTabIndex(request.getTabIndex());
        }
        if (request.getIsCellEditable()!=null){
	        ipfCcmBoGridColumn.setIsCellEditable(request.getIsCellEditable());
        }
        if (request.getInitValueType()!=null){
	        ipfCcmBoGridColumn.setInitValueType(request.getInitValueType());
        }
        if (request.getInitValueType2()!=null){
	        ipfCcmBoGridColumn.setInitValueType2(request.getInitValueType2());
        }
        if (request.getDefaultValue2()!=null){
	        ipfCcmBoGridColumn.setDefaultValue2(request.getDefaultValue2());
        }
        if (request.getFieldSort()!=null){
	        ipfCcmBoGridColumn.setFieldSort(request.getFieldSort());
        }
        if (request.getActiveExpress()!=null){
	        ipfCcmBoGridColumn.setActiveExpress(request.getActiveExpress());
        }
        if (request.getLockColumnExpress()!=null){
	        ipfCcmBoGridColumn.setLockColumnExpress(request.getLockColumnExpress());
        }
        if (request.getUnlockColumnExpress()!=null){
	        ipfCcmBoGridColumn.setUnlockColumnExpress(request.getUnlockColumnExpress());
        }
        if (request.getIsShowSort()!=null){
	        ipfCcmBoGridColumn.setIsShowSort(request.getIsShowSort());
        }
    	ipfCcmBoGridColumnService.updateIpfCcmBoGridColumn(ipfCcmBoGridColumn);
        //返回响应
        IpfCcmBoGridColumnUpdateResponse ipfCcmBoGridColumnUpdateResponse = new IpfCcmBoGridColumnUpdateResponse();
        ipfCcmBoGridColumnUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoGridColumnUpdateResponse.setResultJson(ipfCcmBoGridColumn);
        return ipfCcmBoGridColumnUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.getIpfCcmBoGridColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoGridColumn(IpfCcmBoGridColumnGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoGridColumn ipfCcmBoGridColumn=new IpfCcmBoGridColumn();
        ipfCcmBoGridColumn=ipfCcmBoGridColumnService.getIpfCcmBoGridColumn(id);
        //返回响应
        IpfCcmBoGridColumnGetResponse ipfCcmBoGridColumnGetResponse = new IpfCcmBoGridColumnGetResponse();
        ipfCcmBoGridColumnGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoGridColumnGetResponse.setResultJson(ipfCcmBoGridColumn);
        return ipfCcmBoGridColumnGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoGridColumnSelectAllRequest request) {
        IpfCcmBoGridColumnSelectAllResponse ipfCcmBoGridColumnSelectAllResponse = new IpfCcmBoGridColumnSelectAllResponse();
        ipfCcmBoGridColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoGridColumnSelectAllResponse.setResultJson(ipfCcmBoGridColumnService.selectAll());
        return ipfCcmBoGridColumnSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoGridColumnCountAllRequest request) {
        IpfCcmBoGridColumnCountAllResponse ipfCcmBoGridColumnCountAllResponse = new IpfCcmBoGridColumnCountAllResponse();
        ipfCcmBoGridColumnCountAllResponse.setResultString(String.valueOf(ipfCcmBoGridColumnService.countAll()));
        ipfCcmBoGridColumnCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoGridColumnCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoGridColumnSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoGridColumnSelectAllResponse ipfCcmBoGridColumnSelectAllResponse = new IpfCcmBoGridColumnSelectAllResponse();
        ipfCcmBoGridColumnSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoGridColumnSelectAllResponse.setResultJson(ipfCcmBoGridColumnService.selectBySql(sqlstr));
        return ipfCcmBoGridColumnSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.selectIpfCcmBoGridColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoGridColumnSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoGridColumn_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoGridColumn ipfCcmBoGridColumn=new IpfCcmBoGridColumn();
        ipfCcmBoGridColumn.setId(request.getId());
        ipfCcmBoGridColumn.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoGridColumn.setDefaultValue(request.getDefaultValue());
        ipfCcmBoGridColumn.setIsCondition(request.getIsCondition());
        ipfCcmBoGridColumn.setIsRange(request.getIsRange());
        ipfCcmBoGridColumn.setCorrectType(request.getCorrectType());
        ipfCcmBoGridColumn.setIsSum(request.getIsSum());
        ipfCcmBoGridColumn.setIsNotNull(request.getIsNotNull());
        ipfCcmBoGridColumn.setIsOrderBy(request.getIsOrderBy());
        ipfCcmBoGridColumn.setPropertyName(request.getPropertyName());
        ipfCcmBoGridColumn.setPropertyType(request.getPropertyType());
        ipfCcmBoGridColumn.setUiType(request.getUiType());
        ipfCcmBoGridColumn.setColumnNo(request.getColumnNo());
        ipfCcmBoGridColumn.setIsReadOnly(request.getIsReadOnly());
        ipfCcmBoGridColumn.setIsVisible(request.getIsVisible());
        ipfCcmBoGridColumn.setWidth(request.getWidth());
        ipfCcmBoGridColumn.setPropertyId(request.getPropertyId());
        ipfCcmBoGridColumn.setCellRuleNo(request.getCellRuleNo());
        ipfCcmBoGridColumn.setMethodId(request.getMethodId());
        ipfCcmBoGridColumn.setMethodName(request.getMethodName());
        ipfCcmBoGridColumn.setSearchColumnNo(request.getSearchColumnNo());
        ipfCcmBoGridColumn.setSearchRowNo(request.getSearchRowNo());
        ipfCcmBoGridColumn.setOperation(request.getOperation());
        ipfCcmBoGridColumn.setConditionVisible(request.getConditionVisible());
        ipfCcmBoGridColumn.setShlpValueType(request.getShlpValueType());
        ipfCcmBoGridColumn.setIsQuickSearch(request.getIsQuickSearch());
        ipfCcmBoGridColumn.setQuickCellName(request.getQuickCellName());
        ipfCcmBoGridColumn.setQuickTextFormHeight(request.getQuickTextFormHeight());
        ipfCcmBoGridColumn.setQuickTextLineNum(request.getQuickTextLineNum());
        ipfCcmBoGridColumn.setQuickInlineWidth(request.getQuickInlineWidth());
        ipfCcmBoGridColumn.setQuickInlineOrderNo(request.getQuickInlineOrderNo());
        ipfCcmBoGridColumn.setQuickInlineConnector(request.getQuickInlineConnector());
        ipfCcmBoGridColumn.setIsQuickShowLabel(request.getIsQuickShowLabel());
        ipfCcmBoGridColumn.setIsQuickRadioInline(request.getIsQuickRadioInline());
        ipfCcmBoGridColumn.setIsAdvSearch(request.getIsAdvSearch());
        ipfCcmBoGridColumn.setAdvCellName(request.getAdvCellName());
        ipfCcmBoGridColumn.setAdvTextFormHeight(request.getAdvTextFormHeight());
        ipfCcmBoGridColumn.setAdvTextLineNum(request.getAdvTextLineNum());
        ipfCcmBoGridColumn.setAdvInlineWidth(request.getAdvInlineWidth());
        ipfCcmBoGridColumn.setAdvInlineOrderNo(request.getAdvInlineOrderNo());
        ipfCcmBoGridColumn.setAdvInlineConnector(request.getAdvInlineConnector());
        ipfCcmBoGridColumn.setIsAdvShowLabel(request.getIsAdvShowLabel());
        ipfCcmBoGridColumn.setIsAdvRadioInline(request.getIsAdvRadioInline());
        ipfCcmBoGridColumn.setTabIndex(request.getTabIndex());
        ipfCcmBoGridColumn.setIsCellEditable(request.getIsCellEditable());
        ipfCcmBoGridColumn.setInitValueType(request.getInitValueType());
        ipfCcmBoGridColumn.setInitValueType2(request.getInitValueType2());
        ipfCcmBoGridColumn.setDefaultValue2(request.getDefaultValue2());
        ipfCcmBoGridColumn.setFieldSort(request.getFieldSort());
        ipfCcmBoGridColumn.setActiveExpress(request.getActiveExpress());
        ipfCcmBoGridColumn.setLockColumnExpress(request.getLockColumnExpress());
        ipfCcmBoGridColumn.setUnlockColumnExpress(request.getUnlockColumnExpress());
        ipfCcmBoGridColumn.setIsShowSort(request.getIsShowSort());
    	IpfCcmBoGridColumnSelectResponse ipfCcmBoGridColumnSelectResponse = new IpfCcmBoGridColumnSelectResponse();
        ipfCcmBoGridColumnSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoGridColumn> ipfCcmBoGridColumns= ipfCcmBoGridColumnService.selectWithCondition(ipfCcmBoGridColumn);
        ipfCcmBoGridColumnSelectResponse.setResultJson(ipfCcmBoGridColumns);
        return ipfCcmBoGridColumnSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoGridColumn.isExistIpfCcmBoGridColumn", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoGridColumn(IpfCcmBoGridColumnSelectRequest request) {
        IpfCcmBoGridColumn ipfCcmBoGridColumn=new IpfCcmBoGridColumn();
        ipfCcmBoGridColumn.setId(request.getId());
        ipfCcmBoGridColumn.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoGridColumn.setDefaultValue(request.getDefaultValue());
        ipfCcmBoGridColumn.setIsCondition(request.getIsCondition());
        ipfCcmBoGridColumn.setIsRange(request.getIsRange());
        ipfCcmBoGridColumn.setCorrectType(request.getCorrectType());
        ipfCcmBoGridColumn.setIsSum(request.getIsSum());
        ipfCcmBoGridColumn.setIsNotNull(request.getIsNotNull());
        ipfCcmBoGridColumn.setIsOrderBy(request.getIsOrderBy());
        ipfCcmBoGridColumn.setPropertyName(request.getPropertyName());
        ipfCcmBoGridColumn.setPropertyType(request.getPropertyType());
        ipfCcmBoGridColumn.setUiType(request.getUiType());
        ipfCcmBoGridColumn.setColumnNo(request.getColumnNo());
        ipfCcmBoGridColumn.setIsReadOnly(request.getIsReadOnly());
        ipfCcmBoGridColumn.setIsVisible(request.getIsVisible());
        ipfCcmBoGridColumn.setWidth(request.getWidth());
        ipfCcmBoGridColumn.setPropertyId(request.getPropertyId());
        ipfCcmBoGridColumn.setCellRuleNo(request.getCellRuleNo());
        ipfCcmBoGridColumn.setMethodId(request.getMethodId());
        ipfCcmBoGridColumn.setMethodName(request.getMethodName());
        ipfCcmBoGridColumn.setSearchColumnNo(request.getSearchColumnNo());
        ipfCcmBoGridColumn.setSearchRowNo(request.getSearchRowNo());
        ipfCcmBoGridColumn.setOperation(request.getOperation());
        ipfCcmBoGridColumn.setConditionVisible(request.getConditionVisible());
        ipfCcmBoGridColumn.setShlpValueType(request.getShlpValueType());
        ipfCcmBoGridColumn.setIsQuickSearch(request.getIsQuickSearch());
        ipfCcmBoGridColumn.setQuickCellName(request.getQuickCellName());
        ipfCcmBoGridColumn.setQuickTextFormHeight(request.getQuickTextFormHeight());
        ipfCcmBoGridColumn.setQuickTextLineNum(request.getQuickTextLineNum());
        ipfCcmBoGridColumn.setQuickInlineWidth(request.getQuickInlineWidth());
        ipfCcmBoGridColumn.setQuickInlineOrderNo(request.getQuickInlineOrderNo());
        ipfCcmBoGridColumn.setQuickInlineConnector(request.getQuickInlineConnector());
        ipfCcmBoGridColumn.setIsQuickShowLabel(request.getIsQuickShowLabel());
        ipfCcmBoGridColumn.setIsQuickRadioInline(request.getIsQuickRadioInline());
        ipfCcmBoGridColumn.setIsAdvSearch(request.getIsAdvSearch());
        ipfCcmBoGridColumn.setAdvCellName(request.getAdvCellName());
        ipfCcmBoGridColumn.setAdvTextFormHeight(request.getAdvTextFormHeight());
        ipfCcmBoGridColumn.setAdvTextLineNum(request.getAdvTextLineNum());
        ipfCcmBoGridColumn.setAdvInlineWidth(request.getAdvInlineWidth());
        ipfCcmBoGridColumn.setAdvInlineOrderNo(request.getAdvInlineOrderNo());
        ipfCcmBoGridColumn.setAdvInlineConnector(request.getAdvInlineConnector());
        ipfCcmBoGridColumn.setIsAdvShowLabel(request.getIsAdvShowLabel());
        ipfCcmBoGridColumn.setIsAdvRadioInline(request.getIsAdvRadioInline());
        ipfCcmBoGridColumn.setTabIndex(request.getTabIndex());
        ipfCcmBoGridColumn.setIsCellEditable(request.getIsCellEditable());
        ipfCcmBoGridColumn.setInitValueType(request.getInitValueType());
        ipfCcmBoGridColumn.setInitValueType2(request.getInitValueType2());
        ipfCcmBoGridColumn.setDefaultValue2(request.getDefaultValue2());
        ipfCcmBoGridColumn.setFieldSort(request.getFieldSort());
        ipfCcmBoGridColumn.setActiveExpress(request.getActiveExpress());
        ipfCcmBoGridColumn.setLockColumnExpress(request.getLockColumnExpress());
        ipfCcmBoGridColumn.setUnlockColumnExpress(request.getUnlockColumnExpress());
        ipfCcmBoGridColumn.setIsShowSort(request.getIsShowSort());
        ArrayList<IpfCcmBoGridColumn> ipfCcmBoGridColumns= ipfCcmBoGridColumnService.selectWithCondition(ipfCcmBoGridColumn);
    	IpfCcmBoGridColumnCountAllResponse ipfCcmBoGridColumnCountAllResponse = new IpfCcmBoGridColumnCountAllResponse();
        if (ipfCcmBoGridColumns.size()>0){
        	ipfCcmBoGridColumnCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoGridColumnCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoGridColumnCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoGridColumnCreateRequest request){
    	IpfCcmBoGridColumn ipfCcmBoGridColumn=new IpfCcmBoGridColumn();
    	ipfCcmBoGridColumn.setId(request.getId());
        ArrayList<IpfCcmBoGridColumn> ipfCcmBoGridColumns= ipfCcmBoGridColumnService.selectWithCondition(ipfCcmBoGridColumn);
        if (ipfCcmBoGridColumns!=null&&ipfCcmBoGridColumns.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoGridColumnUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoGridColumnDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoGridColumnSelectRequest request){
        return  true;
     }    
}
