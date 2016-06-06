/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmShlpDetail;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmShlpDetail.request.*;
import com.cartan.center.ebs.ipfCcmShlpDetail.response.*;
import com.cartan.core.ipfCcmShlpDetail.domain.IpfCcmShlpDetail;
import com.cartan.core.ipfCcmShlpDetail.service.IpfCcmShlpDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmShlpDetailServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmShlpDetailServiceEbs.class.getName());
	private IpfCcmShlpDetailService  ipfCcmShlpDetailService;
	
    public IpfCcmShlpDetailService getIpfCcmShlpDetailService() {
        return ipfCcmShlpDetailService;
    }

    @Autowired
    public void setIpfCcmShlpDetailService(IpfCcmShlpDetailService ipfCcmShlpDetailService) {
        this.ipfCcmShlpDetailService = ipfCcmShlpDetailService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmShlpDetailGetSessionRequest request) {      
    	IpfCcmShlpDetailGetSessionResponse ipfCcmShlpDetailGetSessionResponse = new IpfCcmShlpDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmShlpDetailGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmShlpDetailGetSessionResponse.setResultString("1");
            ipfCcmShlpDetailGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmShlpDetailGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmShlpDetailGetSessionRequest request) {
    	IpfCcmShlpDetailGetSessionResponse ipfCcmShlpDetailGetSessionResponse = new IpfCcmShlpDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmShlpDetailGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmShlpDetailGetSessionResponse.setResultString("0");
        }
        ipfCcmShlpDetailGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmShlpDetailGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmShlpDetailGetSessionRequest request) {
    	IpfCcmShlpDetailGetSessionResponse ipfCcmShlpDetailGetSessionResponse = new IpfCcmShlpDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmShlpDetailGetSessionResponse.setResultString("0");
        	ipfCcmShlpDetailGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmShlpDetailGetSessionResponse.setResultString("1");
        }
        return ipfCcmShlpDetailGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.createIpfCcmShlpDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmShlpDetail(IpfCcmShlpDetailCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmShlpDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmShlpDetail ipfCcmShlpDetail=new IpfCcmShlpDetail();
        ipfCcmShlpDetail.setId(request.getId());    		
        ipfCcmShlpDetail.setIpfCcmShlpId(request.getIpfCcmShlpId());
        ipfCcmShlpDetail.setShlpName(request.getShlpName());
        ipfCcmShlpDetail.setFieldName(request.getFieldName());
        ipfCcmShlpDetail.setFieldText(request.getFieldText());
        ipfCcmShlpDetail.setListPosition(request.getListPosition());
        ipfCcmShlpDetail.setIsVisible(request.getIsVisible());
        ipfCcmShlpDetail.setIsInput(request.getIsInput());
        ipfCcmShlpDetail.setIsOutput(request.getIsOutput());
        ipfCcmShlpDetail.setDetailStatus(request.getDetailStatus());
        ipfCcmShlpDetail.setDataType(request.getDataType());
        ipfCcmShlpDetail.setDecimals(request.getDecimals());
        ipfCcmShlpDetail.setDefaultValue(request.getDefaultValue());
        ipfCcmShlpDetail.setColumnLength(request.getColumnLength());
        ipfCcmShlpDetail.setConditionPosition(request.getConditionPosition());
        ipfCcmShlpDetail.setOperation(request.getOperation());
        ipfCcmShlpDetail.setIsRollChange(request.getIsRollChange());
        ipfCcmShlpDetail.setIsEditable(request.getIsEditable());
        ipfCcmShlpDetail.setDdtext(request.getDdtext());
        ipfCcmShlpDetail.setIsSort(request.getIsSort());
        ipfCcmShlpDetail.setSortOrder(request.getSortOrder());
        ipfCcmShlpDetail.setSortType(request.getSortType());
    	ipfCcmShlpDetailService.createIpfCcmShlpDetail(ipfCcmShlpDetail);
        //返回响应
        IpfCcmShlpDetailCreateResponse ipfCcmShlpDetailCreateResponse = new IpfCcmShlpDetailCreateResponse();
        ipfCcmShlpDetailCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpDetailCreateResponse.setResultJson(ipfCcmShlpDetail);
        return ipfCcmShlpDetailCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.deleteIpfCcmShlpDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmShlpDetail(IpfCcmShlpDetailDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmShlpDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmShlpDetailService.deleteIpfCcmShlpDetail(idstr);
        //返回响应
        IpfCcmShlpDetailDeleteResponse ipfCcmShlpDetailDeleteResponse = new IpfCcmShlpDetailDeleteResponse();
        ipfCcmShlpDetailDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmShlpDetailDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.updateIpfCcmShlpDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmShlpDetail(IpfCcmShlpDetailUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmShlpDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmShlpDetail ipfCcmShlpDetail=new IpfCcmShlpDetail();
        ipfCcmShlpDetail=ipfCcmShlpDetailService.getIpfCcmShlpDetail(request.getId());
        if (request.getId()!=null){
	        ipfCcmShlpDetail.setId(request.getId());
        }
        if (request.getIpfCcmShlpId()!=null){
	        ipfCcmShlpDetail.setIpfCcmShlpId(request.getIpfCcmShlpId());
        }
        if (request.getShlpName()!=null){
	        ipfCcmShlpDetail.setShlpName(request.getShlpName());
        }
        if (request.getFieldName()!=null){
	        ipfCcmShlpDetail.setFieldName(request.getFieldName());
        }
        if (request.getFieldText()!=null){
	        ipfCcmShlpDetail.setFieldText(request.getFieldText());
        }
        if (request.getListPosition()!=null){
	        ipfCcmShlpDetail.setListPosition(request.getListPosition());
        }
        if (request.getIsVisible()!=null){
	        ipfCcmShlpDetail.setIsVisible(request.getIsVisible());
        }
        if (request.getIsInput()!=null){
	        ipfCcmShlpDetail.setIsInput(request.getIsInput());
        }
        if (request.getIsOutput()!=null){
	        ipfCcmShlpDetail.setIsOutput(request.getIsOutput());
        }
        if (request.getDetailStatus()!=null){
	        ipfCcmShlpDetail.setDetailStatus(request.getDetailStatus());
        }
        if (request.getDataType()!=null){
	        ipfCcmShlpDetail.setDataType(request.getDataType());
        }
        if (request.getDecimals()!=null){
	        ipfCcmShlpDetail.setDecimals(request.getDecimals());
        }
        if (request.getDefaultValue()!=null){
	        ipfCcmShlpDetail.setDefaultValue(request.getDefaultValue());
        }
        if (request.getColumnLength()!=null){
	        ipfCcmShlpDetail.setColumnLength(request.getColumnLength());
        }
        if (request.getConditionPosition()!=null){
	        ipfCcmShlpDetail.setConditionPosition(request.getConditionPosition());
        }
        if (request.getOperation()!=null){
	        ipfCcmShlpDetail.setOperation(request.getOperation());
        }
        if (request.getIsRollChange()!=null){
	        ipfCcmShlpDetail.setIsRollChange(request.getIsRollChange());
        }
        if (request.getIsEditable()!=null){
	        ipfCcmShlpDetail.setIsEditable(request.getIsEditable());
        }
        if (request.getDdtext()!=null){
	        ipfCcmShlpDetail.setDdtext(request.getDdtext());
        }
        if (request.getIsSort()!=null){
	        ipfCcmShlpDetail.setIsSort(request.getIsSort());
        }
        if (request.getSortOrder()!=null){
	        ipfCcmShlpDetail.setSortOrder(request.getSortOrder());
        }
        if (request.getSortType()!=null){
	        ipfCcmShlpDetail.setSortType(request.getSortType());
        }
    	ipfCcmShlpDetailService.updateIpfCcmShlpDetail(ipfCcmShlpDetail);
        //返回响应
        IpfCcmShlpDetailUpdateResponse ipfCcmShlpDetailUpdateResponse = new IpfCcmShlpDetailUpdateResponse();
        ipfCcmShlpDetailUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpDetailUpdateResponse.setResultJson(ipfCcmShlpDetail);
        return ipfCcmShlpDetailUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.getIpfCcmShlpDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmShlpDetail(IpfCcmShlpDetailGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmShlpDetail ipfCcmShlpDetail=new IpfCcmShlpDetail();
        ipfCcmShlpDetail=ipfCcmShlpDetailService.getIpfCcmShlpDetail(id);
        //返回响应
        IpfCcmShlpDetailGetResponse ipfCcmShlpDetailGetResponse = new IpfCcmShlpDetailGetResponse();
        ipfCcmShlpDetailGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpDetailGetResponse.setResultJson(ipfCcmShlpDetail);
        return ipfCcmShlpDetailGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmShlpDetailSelectAllRequest request) {
        IpfCcmShlpDetailSelectAllResponse ipfCcmShlpDetailSelectAllResponse = new IpfCcmShlpDetailSelectAllResponse();
        ipfCcmShlpDetailSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpDetailSelectAllResponse.setResultJson(ipfCcmShlpDetailService.selectAll());
        return ipfCcmShlpDetailSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmShlpDetailCountAllRequest request) {
        IpfCcmShlpDetailCountAllResponse ipfCcmShlpDetailCountAllResponse = new IpfCcmShlpDetailCountAllResponse();
        ipfCcmShlpDetailCountAllResponse.setResultString(String.valueOf(ipfCcmShlpDetailService.countAll()));
        ipfCcmShlpDetailCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmShlpDetailCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmShlpDetailSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmShlpDetailSelectAllResponse ipfCcmShlpDetailSelectAllResponse = new IpfCcmShlpDetailSelectAllResponse();
        ipfCcmShlpDetailSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpDetailSelectAllResponse.setResultJson(ipfCcmShlpDetailService.selectBySql(sqlstr));
        return ipfCcmShlpDetailSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.selectIpfCcmShlpDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmShlpDetailSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmShlpDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmShlpDetail ipfCcmShlpDetail=new IpfCcmShlpDetail();
        ipfCcmShlpDetail.setId(request.getId());
        ipfCcmShlpDetail.setIpfCcmShlpId(request.getIpfCcmShlpId());
        ipfCcmShlpDetail.setShlpName(request.getShlpName());
        ipfCcmShlpDetail.setFieldName(request.getFieldName());
        ipfCcmShlpDetail.setFieldText(request.getFieldText());
        ipfCcmShlpDetail.setListPosition(request.getListPosition());
        ipfCcmShlpDetail.setIsVisible(request.getIsVisible());
        ipfCcmShlpDetail.setIsInput(request.getIsInput());
        ipfCcmShlpDetail.setIsOutput(request.getIsOutput());
        ipfCcmShlpDetail.setDetailStatus(request.getDetailStatus());
        ipfCcmShlpDetail.setDataType(request.getDataType());
        ipfCcmShlpDetail.setDecimals(request.getDecimals());
        ipfCcmShlpDetail.setDefaultValue(request.getDefaultValue());
        ipfCcmShlpDetail.setColumnLength(request.getColumnLength());
        ipfCcmShlpDetail.setConditionPosition(request.getConditionPosition());
        ipfCcmShlpDetail.setOperation(request.getOperation());
        ipfCcmShlpDetail.setIsRollChange(request.getIsRollChange());
        ipfCcmShlpDetail.setIsEditable(request.getIsEditable());
        ipfCcmShlpDetail.setDdtext(request.getDdtext());
        ipfCcmShlpDetail.setIsSort(request.getIsSort());
        ipfCcmShlpDetail.setSortOrder(request.getSortOrder());
        ipfCcmShlpDetail.setSortType(request.getSortType());
    	IpfCcmShlpDetailSelectResponse ipfCcmShlpDetailSelectResponse = new IpfCcmShlpDetailSelectResponse();
        ipfCcmShlpDetailSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmShlpDetail> ipfCcmShlpDetails= ipfCcmShlpDetailService.selectWithCondition(ipfCcmShlpDetail);
        ipfCcmShlpDetailSelectResponse.setResultJson(ipfCcmShlpDetails);
        return ipfCcmShlpDetailSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpDetail.isExistIpfCcmShlpDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmShlpDetail(IpfCcmShlpDetailSelectRequest request) {
        IpfCcmShlpDetail ipfCcmShlpDetail=new IpfCcmShlpDetail();
        ipfCcmShlpDetail.setId(request.getId());
        ipfCcmShlpDetail.setIpfCcmShlpId(request.getIpfCcmShlpId());
        ipfCcmShlpDetail.setShlpName(request.getShlpName());
        ipfCcmShlpDetail.setFieldName(request.getFieldName());
        ipfCcmShlpDetail.setFieldText(request.getFieldText());
        ipfCcmShlpDetail.setListPosition(request.getListPosition());
        ipfCcmShlpDetail.setIsVisible(request.getIsVisible());
        ipfCcmShlpDetail.setIsInput(request.getIsInput());
        ipfCcmShlpDetail.setIsOutput(request.getIsOutput());
        ipfCcmShlpDetail.setDetailStatus(request.getDetailStatus());
        ipfCcmShlpDetail.setDataType(request.getDataType());
        ipfCcmShlpDetail.setDecimals(request.getDecimals());
        ipfCcmShlpDetail.setDefaultValue(request.getDefaultValue());
        ipfCcmShlpDetail.setColumnLength(request.getColumnLength());
        ipfCcmShlpDetail.setConditionPosition(request.getConditionPosition());
        ipfCcmShlpDetail.setOperation(request.getOperation());
        ipfCcmShlpDetail.setIsRollChange(request.getIsRollChange());
        ipfCcmShlpDetail.setIsEditable(request.getIsEditable());
        ipfCcmShlpDetail.setDdtext(request.getDdtext());
        ipfCcmShlpDetail.setIsSort(request.getIsSort());
        ipfCcmShlpDetail.setSortOrder(request.getSortOrder());
        ipfCcmShlpDetail.setSortType(request.getSortType());
        ArrayList<IpfCcmShlpDetail> ipfCcmShlpDetails= ipfCcmShlpDetailService.selectWithCondition(ipfCcmShlpDetail);
    	IpfCcmShlpDetailCountAllResponse ipfCcmShlpDetailCountAllResponse = new IpfCcmShlpDetailCountAllResponse();
        if (ipfCcmShlpDetails.size()>0){
        	ipfCcmShlpDetailCountAllResponse.setResultString("1");
        } else {
        	ipfCcmShlpDetailCountAllResponse.setResultString("0");
        }        
        return ipfCcmShlpDetailCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmShlpDetailCreateRequest request){
    	IpfCcmShlpDetail ipfCcmShlpDetail=new IpfCcmShlpDetail();
    	ipfCcmShlpDetail.setId(request.getId());
        ArrayList<IpfCcmShlpDetail> ipfCcmShlpDetails= ipfCcmShlpDetailService.selectWithCondition(ipfCcmShlpDetail);
        if (ipfCcmShlpDetails!=null&&ipfCcmShlpDetails.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmShlpDetailUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmShlpDetailDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmShlpDetailSelectRequest request){
        return  true;
     }    
}
