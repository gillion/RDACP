/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoProperty;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoProperty.request.*;
import com.cartan.center.ebs.ipfCcmBoProperty.response.*;
import com.cartan.core.ipfCcmBoProperty.domain.IpfCcmBoProperty;
import com.cartan.core.ipfCcmBoProperty.service.IpfCcmBoPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoPropertyServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoPropertyServiceEbs.class.getName());
	private IpfCcmBoPropertyService  ipfCcmBoPropertyService;
	
    public IpfCcmBoPropertyService getIpfCcmBoPropertyService() {
        return ipfCcmBoPropertyService;
    }

    @Autowired
    public void setIpfCcmBoPropertyService(IpfCcmBoPropertyService ipfCcmBoPropertyService) {
        this.ipfCcmBoPropertyService = ipfCcmBoPropertyService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoPropertyGetSessionRequest request) {      
    	IpfCcmBoPropertyGetSessionResponse ipfCcmBoPropertyGetSessionResponse = new IpfCcmBoPropertyGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoPropertyGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoPropertyGetSessionResponse.setResultString("1");
            ipfCcmBoPropertyGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoPropertyGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoPropertyGetSessionRequest request) {
    	IpfCcmBoPropertyGetSessionResponse ipfCcmBoPropertyGetSessionResponse = new IpfCcmBoPropertyGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoPropertyGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoPropertyGetSessionResponse.setResultString("0");
        }
        ipfCcmBoPropertyGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoPropertyGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoPropertyGetSessionRequest request) {
    	IpfCcmBoPropertyGetSessionResponse ipfCcmBoPropertyGetSessionResponse = new IpfCcmBoPropertyGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoPropertyGetSessionResponse.setResultString("0");
        	ipfCcmBoPropertyGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoPropertyGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoPropertyGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.createIpfCcmBoProperty", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoProperty(IpfCcmBoPropertyCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoProperty_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoProperty ipfCcmBoProperty=new IpfCcmBoProperty();
        ipfCcmBoProperty.setId(request.getId());    		
        ipfCcmBoProperty.setPropertyName(request.getPropertyName());
        ipfCcmBoProperty.setColumnName(request.getColumnName());
        ipfCcmBoProperty.setPropertyType(request.getPropertyType());
        ipfCcmBoProperty.setSubBoLayoutType(request.getSubBoLayoutType());
        ipfCcmBoProperty.setTableName(request.getTableName());
        ipfCcmBoProperty.setMaxValue(request.getMaxValue());
        ipfCcmBoProperty.setMinValue(request.getMinValue());
        ipfCcmBoProperty.setElementCode(request.getElementCode());
        ipfCcmBoProperty.setFieldText(request.getFieldText());
        ipfCcmBoProperty.setDataType(request.getDataType());
        ipfCcmBoProperty.setFieldLength(request.getFieldLength());
        ipfCcmBoProperty.setDecimals(request.getDecimals());
        ipfCcmBoProperty.setIsNotNull(request.getIsNotNull());
        ipfCcmBoProperty.setIsKey(request.getIsKey());
        ipfCcmBoProperty.setSubBoName(request.getSubBoName());
        ipfCcmBoProperty.setSubBoRelType(request.getSubBoRelType());
        ipfCcmBoProperty.setSubBoRelPro(request.getSubBoRelPro());
        ipfCcmBoProperty.setSubBoOrderNo(request.getSubBoOrderNo());
        ipfCcmBoProperty.setPersistentSaveType(request.getPersistentSaveType());
        ipfCcmBoProperty.setRelSubBoProName(request.getRelSubBoProName());
        ipfCcmBoProperty.setSearchHelp(request.getSearchHelp());
        ipfCcmBoProperty.setRefProName(request.getRefProName());
        ipfCcmBoProperty.setDictTableName(request.getDictTableName());
        ipfCcmBoProperty.setDictGroupValue(request.getDictGroupValue());
        ipfCcmBoProperty.setFetchWay(request.getFetchWay());
        ipfCcmBoProperty.setFixValue(request.getFixValue());
        ipfCcmBoProperty.setValueExpression(request.getValueExpression());
        ipfCcmBoProperty.setVlaueRuleNo(request.getVlaueRuleNo());
        ipfCcmBoProperty.setPreCondition(request.getPreCondition());
        ipfCcmBoProperty.setOptCondition(request.getOptCondition());
        ipfCcmBoProperty.setIsSurcharge(request.getIsSurcharge());
        ipfCcmBoProperty.setIsRealtimeCalculate(request.getIsRealtimeCalculate());
        ipfCcmBoProperty.setRpType(request.getRpType());
        ipfCcmBoProperty.setCustIdPropertyName(request.getCustIdPropertyName());
        ipfCcmBoProperty.setBusinessDatePropertyName(request.getBusinessDatePropertyName());
        ipfCcmBoProperty.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoProperty.setAuthField(request.getAuthField());
        ipfCcmBoProperty.setHelpIndex(request.getHelpIndex());
        ipfCcmBoProperty.setNumberObjectId(request.getNumberObjectId());
        ipfCcmBoProperty.setRelBoMethod(request.getRelBoMethod());
        ipfCcmBoProperty.setRelBoName(request.getRelBoName());
        ipfCcmBoProperty.setShTable(request.getShTable());
        ipfCcmBoProperty.setShValueColumn(request.getShValueColumn());
        ipfCcmBoProperty.setValidactionType(request.getValidactionType());
        ipfCcmBoProperty.setValidactionRegex(request.getValidactionRegex());
    	ipfCcmBoPropertyService.createIpfCcmBoProperty(ipfCcmBoProperty);
        //返回响应
        IpfCcmBoPropertyCreateResponse ipfCcmBoPropertyCreateResponse = new IpfCcmBoPropertyCreateResponse();
        ipfCcmBoPropertyCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPropertyCreateResponse.setResultJson(ipfCcmBoProperty);
        return ipfCcmBoPropertyCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.deleteIpfCcmBoProperty", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoProperty(IpfCcmBoPropertyDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoProperty_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoPropertyService.deleteIpfCcmBoProperty(idstr);
        //返回响应
        IpfCcmBoPropertyDeleteResponse ipfCcmBoPropertyDeleteResponse = new IpfCcmBoPropertyDeleteResponse();
        ipfCcmBoPropertyDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoPropertyDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.updateIpfCcmBoProperty", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoProperty(IpfCcmBoPropertyUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoProperty_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoProperty ipfCcmBoProperty=new IpfCcmBoProperty();
        ipfCcmBoProperty=ipfCcmBoPropertyService.getIpfCcmBoProperty(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoProperty.setId(request.getId());
        }
        if (request.getPropertyName()!=null){
	        ipfCcmBoProperty.setPropertyName(request.getPropertyName());
        }
        if (request.getColumnName()!=null){
	        ipfCcmBoProperty.setColumnName(request.getColumnName());
        }
        if (request.getPropertyType()!=null){
	        ipfCcmBoProperty.setPropertyType(request.getPropertyType());
        }
        if (request.getSubBoLayoutType()!=null){
	        ipfCcmBoProperty.setSubBoLayoutType(request.getSubBoLayoutType());
        }
        if (request.getTableName()!=null){
	        ipfCcmBoProperty.setTableName(request.getTableName());
        }
        if (request.getMaxValue()!=null){
	        ipfCcmBoProperty.setMaxValue(request.getMaxValue());
        }
        if (request.getMinValue()!=null){
	        ipfCcmBoProperty.setMinValue(request.getMinValue());
        }
        if (request.getElementCode()!=null){
	        ipfCcmBoProperty.setElementCode(request.getElementCode());
        }
        if (request.getFieldText()!=null){
	        ipfCcmBoProperty.setFieldText(request.getFieldText());
        }
        if (request.getDataType()!=null){
	        ipfCcmBoProperty.setDataType(request.getDataType());
        }
        if (request.getFieldLength()!=null){
	        ipfCcmBoProperty.setFieldLength(request.getFieldLength());
        }
        if (request.getDecimals()!=null){
	        ipfCcmBoProperty.setDecimals(request.getDecimals());
        }
        if (request.getIsNotNull()!=null){
	        ipfCcmBoProperty.setIsNotNull(request.getIsNotNull());
        }
        if (request.getIsKey()!=null){
	        ipfCcmBoProperty.setIsKey(request.getIsKey());
        }
        if (request.getSubBoName()!=null){
	        ipfCcmBoProperty.setSubBoName(request.getSubBoName());
        }
        if (request.getSubBoRelType()!=null){
	        ipfCcmBoProperty.setSubBoRelType(request.getSubBoRelType());
        }
        if (request.getSubBoRelPro()!=null){
	        ipfCcmBoProperty.setSubBoRelPro(request.getSubBoRelPro());
        }
        if (request.getSubBoOrderNo()!=null){
	        ipfCcmBoProperty.setSubBoOrderNo(request.getSubBoOrderNo());
        }
        if (request.getPersistentSaveType()!=null){
	        ipfCcmBoProperty.setPersistentSaveType(request.getPersistentSaveType());
        }
        if (request.getRelSubBoProName()!=null){
	        ipfCcmBoProperty.setRelSubBoProName(request.getRelSubBoProName());
        }
        if (request.getSearchHelp()!=null){
	        ipfCcmBoProperty.setSearchHelp(request.getSearchHelp());
        }
        if (request.getRefProName()!=null){
	        ipfCcmBoProperty.setRefProName(request.getRefProName());
        }
        if (request.getDictTableName()!=null){
	        ipfCcmBoProperty.setDictTableName(request.getDictTableName());
        }
        if (request.getDictGroupValue()!=null){
	        ipfCcmBoProperty.setDictGroupValue(request.getDictGroupValue());
        }
        if (request.getFetchWay()!=null){
	        ipfCcmBoProperty.setFetchWay(request.getFetchWay());
        }
        if (request.getFixValue()!=null){
	        ipfCcmBoProperty.setFixValue(request.getFixValue());
        }
        if (request.getValueExpression()!=null){
	        ipfCcmBoProperty.setValueExpression(request.getValueExpression());
        }
        if (request.getVlaueRuleNo()!=null){
	        ipfCcmBoProperty.setVlaueRuleNo(request.getVlaueRuleNo());
        }
        if (request.getPreCondition()!=null){
	        ipfCcmBoProperty.setPreCondition(request.getPreCondition());
        }
        if (request.getOptCondition()!=null){
	        ipfCcmBoProperty.setOptCondition(request.getOptCondition());
        }
        if (request.getIsSurcharge()!=null){
	        ipfCcmBoProperty.setIsSurcharge(request.getIsSurcharge());
        }
        if (request.getIsRealtimeCalculate()!=null){
	        ipfCcmBoProperty.setIsRealtimeCalculate(request.getIsRealtimeCalculate());
        }
        if (request.getRpType()!=null){
	        ipfCcmBoProperty.setRpType(request.getRpType());
        }
        if (request.getCustIdPropertyName()!=null){
	        ipfCcmBoProperty.setCustIdPropertyName(request.getCustIdPropertyName());
        }
        if (request.getBusinessDatePropertyName()!=null){
	        ipfCcmBoProperty.setBusinessDatePropertyName(request.getBusinessDatePropertyName());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfCcmBoProperty.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getAuthField()!=null){
	        ipfCcmBoProperty.setAuthField(request.getAuthField());
        }
        if (request.getHelpIndex()!=null){
	        ipfCcmBoProperty.setHelpIndex(request.getHelpIndex());
        }
        if (request.getNumberObjectId()!=null){
	        ipfCcmBoProperty.setNumberObjectId(request.getNumberObjectId());
        }
        if (request.getRelBoMethod()!=null){
	        ipfCcmBoProperty.setRelBoMethod(request.getRelBoMethod());
        }
        if (request.getRelBoName()!=null){
	        ipfCcmBoProperty.setRelBoName(request.getRelBoName());
        }
        if (request.getShTable()!=null){
	        ipfCcmBoProperty.setShTable(request.getShTable());
        }
        if (request.getShValueColumn()!=null){
	        ipfCcmBoProperty.setShValueColumn(request.getShValueColumn());
        }
        if (request.getValidactionType()!=null){
	        ipfCcmBoProperty.setValidactionType(request.getValidactionType());
        }
        if (request.getValidactionRegex()!=null){
	        ipfCcmBoProperty.setValidactionRegex(request.getValidactionRegex());
        }
    	ipfCcmBoPropertyService.updateIpfCcmBoProperty(ipfCcmBoProperty);
        //返回响应
        IpfCcmBoPropertyUpdateResponse ipfCcmBoPropertyUpdateResponse = new IpfCcmBoPropertyUpdateResponse();
        ipfCcmBoPropertyUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPropertyUpdateResponse.setResultJson(ipfCcmBoProperty);
        return ipfCcmBoPropertyUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.getIpfCcmBoProperty", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoProperty(IpfCcmBoPropertyGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoProperty ipfCcmBoProperty=new IpfCcmBoProperty();
        ipfCcmBoProperty=ipfCcmBoPropertyService.getIpfCcmBoProperty(id);
        //返回响应
        IpfCcmBoPropertyGetResponse ipfCcmBoPropertyGetResponse = new IpfCcmBoPropertyGetResponse();
        ipfCcmBoPropertyGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPropertyGetResponse.setResultJson(ipfCcmBoProperty);
        return ipfCcmBoPropertyGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoPropertySelectAllRequest request) {
        IpfCcmBoPropertySelectAllResponse ipfCcmBoPropertySelectAllResponse = new IpfCcmBoPropertySelectAllResponse();
        ipfCcmBoPropertySelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPropertySelectAllResponse.setResultJson(ipfCcmBoPropertyService.selectAll());
        return ipfCcmBoPropertySelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoPropertyCountAllRequest request) {
        IpfCcmBoPropertyCountAllResponse ipfCcmBoPropertyCountAllResponse = new IpfCcmBoPropertyCountAllResponse();
        ipfCcmBoPropertyCountAllResponse.setResultString(String.valueOf(ipfCcmBoPropertyService.countAll()));
        ipfCcmBoPropertyCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoPropertyCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoPropertySelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoPropertySelectAllResponse ipfCcmBoPropertySelectAllResponse = new IpfCcmBoPropertySelectAllResponse();
        ipfCcmBoPropertySelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPropertySelectAllResponse.setResultJson(ipfCcmBoPropertyService.selectBySql(sqlstr));
        return ipfCcmBoPropertySelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.selectIpfCcmBoProperty", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoPropertySelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoProperty_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoProperty ipfCcmBoProperty=new IpfCcmBoProperty();
        ipfCcmBoProperty.setId(request.getId());
        ipfCcmBoProperty.setPropertyName(request.getPropertyName());
        ipfCcmBoProperty.setColumnName(request.getColumnName());
        ipfCcmBoProperty.setPropertyType(request.getPropertyType());
        ipfCcmBoProperty.setSubBoLayoutType(request.getSubBoLayoutType());
        ipfCcmBoProperty.setTableName(request.getTableName());
        ipfCcmBoProperty.setMaxValue(request.getMaxValue());
        ipfCcmBoProperty.setMinValue(request.getMinValue());
        ipfCcmBoProperty.setElementCode(request.getElementCode());
        ipfCcmBoProperty.setFieldText(request.getFieldText());
        ipfCcmBoProperty.setDataType(request.getDataType());
        ipfCcmBoProperty.setFieldLength(request.getFieldLength());
        ipfCcmBoProperty.setDecimals(request.getDecimals());
        ipfCcmBoProperty.setIsNotNull(request.getIsNotNull());
        ipfCcmBoProperty.setIsKey(request.getIsKey());
        ipfCcmBoProperty.setSubBoName(request.getSubBoName());
        ipfCcmBoProperty.setSubBoRelType(request.getSubBoRelType());
        ipfCcmBoProperty.setSubBoRelPro(request.getSubBoRelPro());
        ipfCcmBoProperty.setSubBoOrderNo(request.getSubBoOrderNo());
        ipfCcmBoProperty.setPersistentSaveType(request.getPersistentSaveType());
        ipfCcmBoProperty.setRelSubBoProName(request.getRelSubBoProName());
        ipfCcmBoProperty.setSearchHelp(request.getSearchHelp());
        ipfCcmBoProperty.setRefProName(request.getRefProName());
        ipfCcmBoProperty.setDictTableName(request.getDictTableName());
        ipfCcmBoProperty.setDictGroupValue(request.getDictGroupValue());
        ipfCcmBoProperty.setFetchWay(request.getFetchWay());
        ipfCcmBoProperty.setFixValue(request.getFixValue());
        ipfCcmBoProperty.setValueExpression(request.getValueExpression());
        ipfCcmBoProperty.setVlaueRuleNo(request.getVlaueRuleNo());
        ipfCcmBoProperty.setPreCondition(request.getPreCondition());
        ipfCcmBoProperty.setOptCondition(request.getOptCondition());
        ipfCcmBoProperty.setIsSurcharge(request.getIsSurcharge());
        ipfCcmBoProperty.setIsRealtimeCalculate(request.getIsRealtimeCalculate());
        ipfCcmBoProperty.setRpType(request.getRpType());
        ipfCcmBoProperty.setCustIdPropertyName(request.getCustIdPropertyName());
        ipfCcmBoProperty.setBusinessDatePropertyName(request.getBusinessDatePropertyName());
        ipfCcmBoProperty.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoProperty.setAuthField(request.getAuthField());
        ipfCcmBoProperty.setHelpIndex(request.getHelpIndex());
        ipfCcmBoProperty.setNumberObjectId(request.getNumberObjectId());
        ipfCcmBoProperty.setRelBoMethod(request.getRelBoMethod());
        ipfCcmBoProperty.setRelBoName(request.getRelBoName());
        ipfCcmBoProperty.setShTable(request.getShTable());
        ipfCcmBoProperty.setShValueColumn(request.getShValueColumn());
        ipfCcmBoProperty.setValidactionType(request.getValidactionType());
        ipfCcmBoProperty.setValidactionRegex(request.getValidactionRegex());
    	IpfCcmBoPropertySelectResponse ipfCcmBoPropertySelectResponse = new IpfCcmBoPropertySelectResponse();
        ipfCcmBoPropertySelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoProperty> ipfCcmBoPropertys= ipfCcmBoPropertyService.selectWithCondition(ipfCcmBoProperty);
        ipfCcmBoPropertySelectResponse.setResultJson(ipfCcmBoPropertys);
        return ipfCcmBoPropertySelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoProperty.isExistIpfCcmBoProperty", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoProperty(IpfCcmBoPropertySelectRequest request) {
        IpfCcmBoProperty ipfCcmBoProperty=new IpfCcmBoProperty();
        ipfCcmBoProperty.setId(request.getId());
        ipfCcmBoProperty.setPropertyName(request.getPropertyName());
        ipfCcmBoProperty.setColumnName(request.getColumnName());
        ipfCcmBoProperty.setPropertyType(request.getPropertyType());
        ipfCcmBoProperty.setSubBoLayoutType(request.getSubBoLayoutType());
        ipfCcmBoProperty.setTableName(request.getTableName());
        ipfCcmBoProperty.setMaxValue(request.getMaxValue());
        ipfCcmBoProperty.setMinValue(request.getMinValue());
        ipfCcmBoProperty.setElementCode(request.getElementCode());
        ipfCcmBoProperty.setFieldText(request.getFieldText());
        ipfCcmBoProperty.setDataType(request.getDataType());
        ipfCcmBoProperty.setFieldLength(request.getFieldLength());
        ipfCcmBoProperty.setDecimals(request.getDecimals());
        ipfCcmBoProperty.setIsNotNull(request.getIsNotNull());
        ipfCcmBoProperty.setIsKey(request.getIsKey());
        ipfCcmBoProperty.setSubBoName(request.getSubBoName());
        ipfCcmBoProperty.setSubBoRelType(request.getSubBoRelType());
        ipfCcmBoProperty.setSubBoRelPro(request.getSubBoRelPro());
        ipfCcmBoProperty.setSubBoOrderNo(request.getSubBoOrderNo());
        ipfCcmBoProperty.setPersistentSaveType(request.getPersistentSaveType());
        ipfCcmBoProperty.setRelSubBoProName(request.getRelSubBoProName());
        ipfCcmBoProperty.setSearchHelp(request.getSearchHelp());
        ipfCcmBoProperty.setRefProName(request.getRefProName());
        ipfCcmBoProperty.setDictTableName(request.getDictTableName());
        ipfCcmBoProperty.setDictGroupValue(request.getDictGroupValue());
        ipfCcmBoProperty.setFetchWay(request.getFetchWay());
        ipfCcmBoProperty.setFixValue(request.getFixValue());
        ipfCcmBoProperty.setValueExpression(request.getValueExpression());
        ipfCcmBoProperty.setVlaueRuleNo(request.getVlaueRuleNo());
        ipfCcmBoProperty.setPreCondition(request.getPreCondition());
        ipfCcmBoProperty.setOptCondition(request.getOptCondition());
        ipfCcmBoProperty.setIsSurcharge(request.getIsSurcharge());
        ipfCcmBoProperty.setIsRealtimeCalculate(request.getIsRealtimeCalculate());
        ipfCcmBoProperty.setRpType(request.getRpType());
        ipfCcmBoProperty.setCustIdPropertyName(request.getCustIdPropertyName());
        ipfCcmBoProperty.setBusinessDatePropertyName(request.getBusinessDatePropertyName());
        ipfCcmBoProperty.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoProperty.setAuthField(request.getAuthField());
        ipfCcmBoProperty.setHelpIndex(request.getHelpIndex());
        ipfCcmBoProperty.setNumberObjectId(request.getNumberObjectId());
        ipfCcmBoProperty.setRelBoMethod(request.getRelBoMethod());
        ipfCcmBoProperty.setRelBoName(request.getRelBoName());
        ipfCcmBoProperty.setShTable(request.getShTable());
        ipfCcmBoProperty.setShValueColumn(request.getShValueColumn());
        ipfCcmBoProperty.setValidactionType(request.getValidactionType());
        ipfCcmBoProperty.setValidactionRegex(request.getValidactionRegex());
        ArrayList<IpfCcmBoProperty> ipfCcmBoPropertys= ipfCcmBoPropertyService.selectWithCondition(ipfCcmBoProperty);
    	IpfCcmBoPropertyCountAllResponse ipfCcmBoPropertyCountAllResponse = new IpfCcmBoPropertyCountAllResponse();
        if (ipfCcmBoPropertys.size()>0){
        	ipfCcmBoPropertyCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoPropertyCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoPropertyCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoPropertyCreateRequest request){
    	IpfCcmBoProperty ipfCcmBoProperty=new IpfCcmBoProperty();
    	ipfCcmBoProperty.setId(request.getId());
        ArrayList<IpfCcmBoProperty> ipfCcmBoPropertys= ipfCcmBoPropertyService.selectWithCondition(ipfCcmBoProperty);
        if (ipfCcmBoPropertys!=null&&ipfCcmBoPropertys.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoPropertyUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoPropertyDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoPropertySelectRequest request){
        return  true;
     }    
}
