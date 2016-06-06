/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoPgLoElement;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoPgLoElement.request.*;
import com.cartan.center.ebs.ipfCcmBoPgLoElement.response.*;
import com.cartan.core.ipfCcmBoPgLoElement.domain.IpfCcmBoPgLoElement;
import com.cartan.core.ipfCcmBoPgLoElement.service.IpfCcmBoPgLoElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoPgLoElementServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoPgLoElementServiceEbs.class.getName());
	private IpfCcmBoPgLoElementService  ipfCcmBoPgLoElementService;
	
    public IpfCcmBoPgLoElementService getIpfCcmBoPgLoElementService() {
        return ipfCcmBoPgLoElementService;
    }

    @Autowired
    public void setIpfCcmBoPgLoElementService(IpfCcmBoPgLoElementService ipfCcmBoPgLoElementService) {
        this.ipfCcmBoPgLoElementService = ipfCcmBoPgLoElementService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoPgLoElementGetSessionRequest request) {      
    	IpfCcmBoPgLoElementGetSessionResponse ipfCcmBoPgLoElementGetSessionResponse = new IpfCcmBoPgLoElementGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoPgLoElementGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoPgLoElementGetSessionResponse.setResultString("1");
            ipfCcmBoPgLoElementGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoPgLoElementGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoPgLoElementGetSessionRequest request) {
    	IpfCcmBoPgLoElementGetSessionResponse ipfCcmBoPgLoElementGetSessionResponse = new IpfCcmBoPgLoElementGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoPgLoElementGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoPgLoElementGetSessionResponse.setResultString("0");
        }
        ipfCcmBoPgLoElementGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoPgLoElementGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoPgLoElementGetSessionRequest request) {
    	IpfCcmBoPgLoElementGetSessionResponse ipfCcmBoPgLoElementGetSessionResponse = new IpfCcmBoPgLoElementGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoPgLoElementGetSessionResponse.setResultString("0");
        	ipfCcmBoPgLoElementGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoPgLoElementGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoPgLoElementGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.createIpfCcmBoPgLoElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoPgLoElement(IpfCcmBoPgLoElementCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoPgLoElement_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPgLoElement ipfCcmBoPgLoElement=new IpfCcmBoPgLoElement();
        ipfCcmBoPgLoElement.setId(request.getId());    		
        ipfCcmBoPgLoElement.setIpfCcmBoPageLayoutId(request.getIpfCcmBoPageLayoutId());
        ipfCcmBoPgLoElement.setSeqNo(request.getSeqNo());
        ipfCcmBoPgLoElement.setLayoutElementType(request.getLayoutElementType());
        ipfCcmBoPgLoElement.setLayoutBoName(request.getLayoutBoName());
        ipfCcmBoPgLoElement.setControlHeight(request.getControlHeight());
        ipfCcmBoPgLoElement.setControlWidth(request.getControlWidth());
        ipfCcmBoPgLoElement.setTextLineNum(request.getTextLineNum());
        ipfCcmBoPgLoElement.setControlConnector(request.getControlConnector());
        ipfCcmBoPgLoElement.setIsNotNull(request.getIsNotNull());
        ipfCcmBoPgLoElement.setIsReadOnly(request.getIsReadOnly());
        ipfCcmBoPgLoElement.setUiType(request.getUiType());
        ipfCcmBoPgLoElement.setIsVisible(request.getIsVisible());
        ipfCcmBoPgLoElement.setColumnStyle(request.getColumnStyle());
        ipfCcmBoPgLoElement.setLableStyle(request.getLableStyle());
        ipfCcmBoPgLoElement.setIsShowLable(request.getIsShowLable());
        ipfCcmBoPgLoElement.setIsInline(request.getIsInline());
        ipfCcmBoPgLoElement.setTabIndex(request.getTabIndex());
        ipfCcmBoPgLoElement.setDefaultValue(request.getDefaultValue());
        ipfCcmBoPgLoElement.setInitValueType(request.getInitValueType());
        ipfCcmBoPgLoElement.setCorrectType(request.getCorrectType());
        ipfCcmBoPgLoElement.setConditionType(request.getConditionType());
        ipfCcmBoPgLoElement.setOperation(request.getOperation());
        ipfCcmBoPgLoElement.setQueryType(request.getQueryType());
        ipfCcmBoPgLoElement.setRangeType(request.getRangeType());
        ipfCcmBoPgLoElement.setMethodName(request.getMethodName());
        ipfCcmBoPgLoElement.setPropertyName(request.getPropertyName());
    	ipfCcmBoPgLoElementService.createIpfCcmBoPgLoElement(ipfCcmBoPgLoElement);
        //返回响应
        IpfCcmBoPgLoElementCreateResponse ipfCcmBoPgLoElementCreateResponse = new IpfCcmBoPgLoElementCreateResponse();
        ipfCcmBoPgLoElementCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPgLoElementCreateResponse.setResultJson(ipfCcmBoPgLoElement);
        return ipfCcmBoPgLoElementCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.deleteIpfCcmBoPgLoElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoPgLoElement(IpfCcmBoPgLoElementDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoPgLoElement_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoPgLoElementService.deleteIpfCcmBoPgLoElement(idstr);
        //返回响应
        IpfCcmBoPgLoElementDeleteResponse ipfCcmBoPgLoElementDeleteResponse = new IpfCcmBoPgLoElementDeleteResponse();
        ipfCcmBoPgLoElementDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoPgLoElementDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.updateIpfCcmBoPgLoElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoPgLoElement(IpfCcmBoPgLoElementUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoPgLoElement_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPgLoElement ipfCcmBoPgLoElement=new IpfCcmBoPgLoElement();
        ipfCcmBoPgLoElement=ipfCcmBoPgLoElementService.getIpfCcmBoPgLoElement(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoPgLoElement.setId(request.getId());
        }
        if (request.getIpfCcmBoPageLayoutId()!=null){
	        ipfCcmBoPgLoElement.setIpfCcmBoPageLayoutId(request.getIpfCcmBoPageLayoutId());
        }
        if (request.getSeqNo()!=null){
	        ipfCcmBoPgLoElement.setSeqNo(request.getSeqNo());
        }
        if (request.getLayoutElementType()!=null){
	        ipfCcmBoPgLoElement.setLayoutElementType(request.getLayoutElementType());
        }
        if (request.getLayoutBoName()!=null){
	        ipfCcmBoPgLoElement.setLayoutBoName(request.getLayoutBoName());
        }
        if (request.getControlHeight()!=null){
	        ipfCcmBoPgLoElement.setControlHeight(request.getControlHeight());
        }
        if (request.getControlWidth()!=null){
	        ipfCcmBoPgLoElement.setControlWidth(request.getControlWidth());
        }
        if (request.getTextLineNum()!=null){
	        ipfCcmBoPgLoElement.setTextLineNum(request.getTextLineNum());
        }
        if (request.getControlConnector()!=null){
	        ipfCcmBoPgLoElement.setControlConnector(request.getControlConnector());
        }
        if (request.getIsNotNull()!=null){
	        ipfCcmBoPgLoElement.setIsNotNull(request.getIsNotNull());
        }
        if (request.getIsReadOnly()!=null){
	        ipfCcmBoPgLoElement.setIsReadOnly(request.getIsReadOnly());
        }
        if (request.getUiType()!=null){
	        ipfCcmBoPgLoElement.setUiType(request.getUiType());
        }
        if (request.getIsVisible()!=null){
	        ipfCcmBoPgLoElement.setIsVisible(request.getIsVisible());
        }
        if (request.getColumnStyle()!=null){
	        ipfCcmBoPgLoElement.setColumnStyle(request.getColumnStyle());
        }
        if (request.getLableStyle()!=null){
	        ipfCcmBoPgLoElement.setLableStyle(request.getLableStyle());
        }
        if (request.getIsShowLable()!=null){
	        ipfCcmBoPgLoElement.setIsShowLable(request.getIsShowLable());
        }
        if (request.getIsInline()!=null){
	        ipfCcmBoPgLoElement.setIsInline(request.getIsInline());
        }
        if (request.getTabIndex()!=null){
	        ipfCcmBoPgLoElement.setTabIndex(request.getTabIndex());
        }
        if (request.getDefaultValue()!=null){
	        ipfCcmBoPgLoElement.setDefaultValue(request.getDefaultValue());
        }
        if (request.getInitValueType()!=null){
	        ipfCcmBoPgLoElement.setInitValueType(request.getInitValueType());
        }
        if (request.getCorrectType()!=null){
	        ipfCcmBoPgLoElement.setCorrectType(request.getCorrectType());
        }
        if (request.getConditionType()!=null){
	        ipfCcmBoPgLoElement.setConditionType(request.getConditionType());
        }
        if (request.getOperation()!=null){
	        ipfCcmBoPgLoElement.setOperation(request.getOperation());
        }
        if (request.getQueryType()!=null){
	        ipfCcmBoPgLoElement.setQueryType(request.getQueryType());
        }
        if (request.getRangeType()!=null){
	        ipfCcmBoPgLoElement.setRangeType(request.getRangeType());
        }
        if (request.getMethodName()!=null){
	        ipfCcmBoPgLoElement.setMethodName(request.getMethodName());
        }
        if (request.getPropertyName()!=null){
	        ipfCcmBoPgLoElement.setPropertyName(request.getPropertyName());
        }
    	ipfCcmBoPgLoElementService.updateIpfCcmBoPgLoElement(ipfCcmBoPgLoElement);
        //返回响应
        IpfCcmBoPgLoElementUpdateResponse ipfCcmBoPgLoElementUpdateResponse = new IpfCcmBoPgLoElementUpdateResponse();
        ipfCcmBoPgLoElementUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPgLoElementUpdateResponse.setResultJson(ipfCcmBoPgLoElement);
        return ipfCcmBoPgLoElementUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.getIpfCcmBoPgLoElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoPgLoElement(IpfCcmBoPgLoElementGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoPgLoElement ipfCcmBoPgLoElement=new IpfCcmBoPgLoElement();
        ipfCcmBoPgLoElement=ipfCcmBoPgLoElementService.getIpfCcmBoPgLoElement(id);
        //返回响应
        IpfCcmBoPgLoElementGetResponse ipfCcmBoPgLoElementGetResponse = new IpfCcmBoPgLoElementGetResponse();
        ipfCcmBoPgLoElementGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPgLoElementGetResponse.setResultJson(ipfCcmBoPgLoElement);
        return ipfCcmBoPgLoElementGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoPgLoElementSelectAllRequest request) {
        IpfCcmBoPgLoElementSelectAllResponse ipfCcmBoPgLoElementSelectAllResponse = new IpfCcmBoPgLoElementSelectAllResponse();
        ipfCcmBoPgLoElementSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPgLoElementSelectAllResponse.setResultJson(ipfCcmBoPgLoElementService.selectAll());
        return ipfCcmBoPgLoElementSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoPgLoElementCountAllRequest request) {
        IpfCcmBoPgLoElementCountAllResponse ipfCcmBoPgLoElementCountAllResponse = new IpfCcmBoPgLoElementCountAllResponse();
        ipfCcmBoPgLoElementCountAllResponse.setResultString(String.valueOf(ipfCcmBoPgLoElementService.countAll()));
        ipfCcmBoPgLoElementCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoPgLoElementCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoPgLoElementSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoPgLoElementSelectAllResponse ipfCcmBoPgLoElementSelectAllResponse = new IpfCcmBoPgLoElementSelectAllResponse();
        ipfCcmBoPgLoElementSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPgLoElementSelectAllResponse.setResultJson(ipfCcmBoPgLoElementService.selectBySql(sqlstr));
        return ipfCcmBoPgLoElementSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.selectIpfCcmBoPgLoElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoPgLoElementSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoPgLoElement_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPgLoElement ipfCcmBoPgLoElement=new IpfCcmBoPgLoElement();
        ipfCcmBoPgLoElement.setId(request.getId());
        ipfCcmBoPgLoElement.setIpfCcmBoPageLayoutId(request.getIpfCcmBoPageLayoutId());
        ipfCcmBoPgLoElement.setSeqNo(request.getSeqNo());
        ipfCcmBoPgLoElement.setLayoutElementType(request.getLayoutElementType());
        ipfCcmBoPgLoElement.setLayoutBoName(request.getLayoutBoName());
        ipfCcmBoPgLoElement.setControlHeight(request.getControlHeight());
        ipfCcmBoPgLoElement.setControlWidth(request.getControlWidth());
        ipfCcmBoPgLoElement.setTextLineNum(request.getTextLineNum());
        ipfCcmBoPgLoElement.setControlConnector(request.getControlConnector());
        ipfCcmBoPgLoElement.setIsNotNull(request.getIsNotNull());
        ipfCcmBoPgLoElement.setIsReadOnly(request.getIsReadOnly());
        ipfCcmBoPgLoElement.setUiType(request.getUiType());
        ipfCcmBoPgLoElement.setIsVisible(request.getIsVisible());
        ipfCcmBoPgLoElement.setColumnStyle(request.getColumnStyle());
        ipfCcmBoPgLoElement.setLableStyle(request.getLableStyle());
        ipfCcmBoPgLoElement.setIsShowLable(request.getIsShowLable());
        ipfCcmBoPgLoElement.setIsInline(request.getIsInline());
        ipfCcmBoPgLoElement.setTabIndex(request.getTabIndex());
        ipfCcmBoPgLoElement.setDefaultValue(request.getDefaultValue());
        ipfCcmBoPgLoElement.setInitValueType(request.getInitValueType());
        ipfCcmBoPgLoElement.setCorrectType(request.getCorrectType());
        ipfCcmBoPgLoElement.setConditionType(request.getConditionType());
        ipfCcmBoPgLoElement.setOperation(request.getOperation());
        ipfCcmBoPgLoElement.setQueryType(request.getQueryType());
        ipfCcmBoPgLoElement.setRangeType(request.getRangeType());
        ipfCcmBoPgLoElement.setMethodName(request.getMethodName());
        ipfCcmBoPgLoElement.setPropertyName(request.getPropertyName());
    	IpfCcmBoPgLoElementSelectResponse ipfCcmBoPgLoElementSelectResponse = new IpfCcmBoPgLoElementSelectResponse();
        ipfCcmBoPgLoElementSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoPgLoElement> ipfCcmBoPgLoElements= ipfCcmBoPgLoElementService.selectWithCondition(ipfCcmBoPgLoElement);
        ipfCcmBoPgLoElementSelectResponse.setResultJson(ipfCcmBoPgLoElements);
        return ipfCcmBoPgLoElementSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPgLoElement.isExistIpfCcmBoPgLoElement", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoPgLoElement(IpfCcmBoPgLoElementSelectRequest request) {
        IpfCcmBoPgLoElement ipfCcmBoPgLoElement=new IpfCcmBoPgLoElement();
        ipfCcmBoPgLoElement.setId(request.getId());
        ipfCcmBoPgLoElement.setIpfCcmBoPageLayoutId(request.getIpfCcmBoPageLayoutId());
        ipfCcmBoPgLoElement.setSeqNo(request.getSeqNo());
        ipfCcmBoPgLoElement.setLayoutElementType(request.getLayoutElementType());
        ipfCcmBoPgLoElement.setLayoutBoName(request.getLayoutBoName());
        ipfCcmBoPgLoElement.setControlHeight(request.getControlHeight());
        ipfCcmBoPgLoElement.setControlWidth(request.getControlWidth());
        ipfCcmBoPgLoElement.setTextLineNum(request.getTextLineNum());
        ipfCcmBoPgLoElement.setControlConnector(request.getControlConnector());
        ipfCcmBoPgLoElement.setIsNotNull(request.getIsNotNull());
        ipfCcmBoPgLoElement.setIsReadOnly(request.getIsReadOnly());
        ipfCcmBoPgLoElement.setUiType(request.getUiType());
        ipfCcmBoPgLoElement.setIsVisible(request.getIsVisible());
        ipfCcmBoPgLoElement.setColumnStyle(request.getColumnStyle());
        ipfCcmBoPgLoElement.setLableStyle(request.getLableStyle());
        ipfCcmBoPgLoElement.setIsShowLable(request.getIsShowLable());
        ipfCcmBoPgLoElement.setIsInline(request.getIsInline());
        ipfCcmBoPgLoElement.setTabIndex(request.getTabIndex());
        ipfCcmBoPgLoElement.setDefaultValue(request.getDefaultValue());
        ipfCcmBoPgLoElement.setInitValueType(request.getInitValueType());
        ipfCcmBoPgLoElement.setCorrectType(request.getCorrectType());
        ipfCcmBoPgLoElement.setConditionType(request.getConditionType());
        ipfCcmBoPgLoElement.setOperation(request.getOperation());
        ipfCcmBoPgLoElement.setQueryType(request.getQueryType());
        ipfCcmBoPgLoElement.setRangeType(request.getRangeType());
        ipfCcmBoPgLoElement.setMethodName(request.getMethodName());
        ipfCcmBoPgLoElement.setPropertyName(request.getPropertyName());
        ArrayList<IpfCcmBoPgLoElement> ipfCcmBoPgLoElements= ipfCcmBoPgLoElementService.selectWithCondition(ipfCcmBoPgLoElement);
    	IpfCcmBoPgLoElementCountAllResponse ipfCcmBoPgLoElementCountAllResponse = new IpfCcmBoPgLoElementCountAllResponse();
        if (ipfCcmBoPgLoElements.size()>0){
        	ipfCcmBoPgLoElementCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoPgLoElementCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoPgLoElementCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoPgLoElementCreateRequest request){
    	IpfCcmBoPgLoElement ipfCcmBoPgLoElement=new IpfCcmBoPgLoElement();
    	ipfCcmBoPgLoElement.setId(request.getId());
        ArrayList<IpfCcmBoPgLoElement> ipfCcmBoPgLoElements= ipfCcmBoPgLoElementService.selectWithCondition(ipfCcmBoPgLoElement);
        if (ipfCcmBoPgLoElements!=null&&ipfCcmBoPgLoElements.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoPgLoElementUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoPgLoElementDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoPgLoElementSelectRequest request){
        return  true;
     }    
}
