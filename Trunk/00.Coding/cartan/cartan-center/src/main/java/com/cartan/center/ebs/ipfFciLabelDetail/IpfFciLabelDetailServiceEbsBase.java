/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciLabelDetail;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfFciLabelDetail.request.*;
import com.cartan.center.ebs.ipfFciLabelDetail.response.*;
import com.cartan.core.ipfFciLabelDetail.domain.IpfFciLabelDetail;
import com.cartan.core.ipfFciLabelDetail.service.IpfFciLabelDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfFciLabelDetailServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfFciLabelDetailServiceEbs.class.getName());
	private IpfFciLabelDetailService  ipfFciLabelDetailService;
	
    public IpfFciLabelDetailService getIpfFciLabelDetailService() {
        return ipfFciLabelDetailService;
    }

    @Autowired
    public void setIpfFciLabelDetailService(IpfFciLabelDetailService ipfFciLabelDetailService) {
        this.ipfFciLabelDetailService = ipfFciLabelDetailService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfFciLabelDetailGetSessionRequest request) {      
    	IpfFciLabelDetailGetSessionResponse ipfFciLabelDetailGetSessionResponse = new IpfFciLabelDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciLabelDetailGetSessionResponse.setResultString("0");
        } else {
        	ipfFciLabelDetailGetSessionResponse.setResultString("1");
            ipfFciLabelDetailGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfFciLabelDetailGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfFciLabelDetailGetSessionRequest request) {
    	IpfFciLabelDetailGetSessionResponse ipfFciLabelDetailGetSessionResponse = new IpfFciLabelDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfFciLabelDetailGetSessionResponse.setResultString("1");
        } else {
        	ipfFciLabelDetailGetSessionResponse.setResultString("0");
        }
        ipfFciLabelDetailGetSessionResponse.setSessionId(request.getSessionId());
        return ipfFciLabelDetailGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfFciLabelDetailGetSessionRequest request) {
    	IpfFciLabelDetailGetSessionResponse ipfFciLabelDetailGetSessionResponse = new IpfFciLabelDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfFciLabelDetailGetSessionResponse.setResultString("0");
        	ipfFciLabelDetailGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfFciLabelDetailGetSessionResponse.setResultString("1");
        }
        return ipfFciLabelDetailGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.createIpfFciLabelDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfFciLabelDetail(IpfFciLabelDetailCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfFciLabelDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciLabelDetail ipfFciLabelDetail=new IpfFciLabelDetail();
        ipfFciLabelDetail.setId(request.getId());    		
        ipfFciLabelDetail.setIpfFciLabelId(request.getIpfFciLabelId());
        ipfFciLabelDetail.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciLabelDetail.setConfigItemType(request.getConfigItemType());
        ipfFciLabelDetail.setConfigItemCode(request.getConfigItemCode());
        ipfFciLabelDetail.setConfigItemId(request.getConfigItemId());
        ipfFciLabelDetail.setRevisionNumber(request.getRevisionNumber());
        ipfFciLabelDetail.setRelationMemberId(request.getRelationMemberId());
        ipfFciLabelDetail.setIsActive(request.getIsActive());
    	ipfFciLabelDetailService.createIpfFciLabelDetail(ipfFciLabelDetail);
        //返回响应
        IpfFciLabelDetailCreateResponse ipfFciLabelDetailCreateResponse = new IpfFciLabelDetailCreateResponse();
        ipfFciLabelDetailCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciLabelDetailCreateResponse.setResultJson(ipfFciLabelDetail);
        return ipfFciLabelDetailCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.deleteIpfFciLabelDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfFciLabelDetail(IpfFciLabelDetailDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfFciLabelDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfFciLabelDetailService.deleteIpfFciLabelDetail(idstr);
        //返回响应
        IpfFciLabelDetailDeleteResponse ipfFciLabelDetailDeleteResponse = new IpfFciLabelDetailDeleteResponse();
        ipfFciLabelDetailDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciLabelDetailDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.updateIpfFciLabelDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfFciLabelDetail(IpfFciLabelDetailUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfFciLabelDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciLabelDetail ipfFciLabelDetail=new IpfFciLabelDetail();
        ipfFciLabelDetail=ipfFciLabelDetailService.getIpfFciLabelDetail(request.getId());
        if (request.getId()!=null){
	        ipfFciLabelDetail.setId(request.getId());
        }
        if (request.getIpfFciLabelId()!=null){
	        ipfFciLabelDetail.setIpfFciLabelId(request.getIpfFciLabelId());
        }
        if (request.getIpfFciViewId()!=null){
	        ipfFciLabelDetail.setIpfFciViewId(request.getIpfFciViewId());
        }
        if (request.getConfigItemType()!=null){
	        ipfFciLabelDetail.setConfigItemType(request.getConfigItemType());
        }
        if (request.getConfigItemCode()!=null){
	        ipfFciLabelDetail.setConfigItemCode(request.getConfigItemCode());
        }
        if (request.getConfigItemId()!=null){
	        ipfFciLabelDetail.setConfigItemId(request.getConfigItemId());
        }
        if (request.getRevisionNumber()!=null){
	        ipfFciLabelDetail.setRevisionNumber(request.getRevisionNumber());
        }
        if (request.getRelationMemberId()!=null){
	        ipfFciLabelDetail.setRelationMemberId(request.getRelationMemberId());
        }
        if (request.getIsActive()!=null){
	        ipfFciLabelDetail.setIsActive(request.getIsActive());
        }
    	ipfFciLabelDetailService.updateIpfFciLabelDetail(ipfFciLabelDetail);
        //返回响应
        IpfFciLabelDetailUpdateResponse ipfFciLabelDetailUpdateResponse = new IpfFciLabelDetailUpdateResponse();
        ipfFciLabelDetailUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciLabelDetailUpdateResponse.setResultJson(ipfFciLabelDetail);
        return ipfFciLabelDetailUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.getIpfFciLabelDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfFciLabelDetail(IpfFciLabelDetailGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfFciLabelDetail ipfFciLabelDetail=new IpfFciLabelDetail();
        ipfFciLabelDetail=ipfFciLabelDetailService.getIpfFciLabelDetail(id);
        //返回响应
        IpfFciLabelDetailGetResponse ipfFciLabelDetailGetResponse = new IpfFciLabelDetailGetResponse();
        ipfFciLabelDetailGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciLabelDetailGetResponse.setResultJson(ipfFciLabelDetail);
        return ipfFciLabelDetailGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfFciLabelDetailSelectAllRequest request) {
        IpfFciLabelDetailSelectAllResponse ipfFciLabelDetailSelectAllResponse = new IpfFciLabelDetailSelectAllResponse();
        ipfFciLabelDetailSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciLabelDetailSelectAllResponse.setResultJson(ipfFciLabelDetailService.selectAll());
        return ipfFciLabelDetailSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfFciLabelDetailCountAllRequest request) {
        IpfFciLabelDetailCountAllResponse ipfFciLabelDetailCountAllResponse = new IpfFciLabelDetailCountAllResponse();
        ipfFciLabelDetailCountAllResponse.setResultString(String.valueOf(ipfFciLabelDetailService.countAll()));
        ipfFciLabelDetailCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfFciLabelDetailCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfFciLabelDetailSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfFciLabelDetailSelectAllResponse ipfFciLabelDetailSelectAllResponse = new IpfFciLabelDetailSelectAllResponse();
        ipfFciLabelDetailSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfFciLabelDetailSelectAllResponse.setResultJson(ipfFciLabelDetailService.selectBySql(sqlstr));
        return ipfFciLabelDetailSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.selectIpfFciLabelDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfFciLabelDetailSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfFciLabelDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfFciLabelDetail ipfFciLabelDetail=new IpfFciLabelDetail();
        ipfFciLabelDetail.setId(request.getId());
        ipfFciLabelDetail.setIpfFciLabelId(request.getIpfFciLabelId());
        ipfFciLabelDetail.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciLabelDetail.setConfigItemType(request.getConfigItemType());
        ipfFciLabelDetail.setConfigItemCode(request.getConfigItemCode());
        ipfFciLabelDetail.setConfigItemId(request.getConfigItemId());
        ipfFciLabelDetail.setRevisionNumber(request.getRevisionNumber());
        ipfFciLabelDetail.setRelationMemberId(request.getRelationMemberId());
        ipfFciLabelDetail.setIsActive(request.getIsActive());
    	IpfFciLabelDetailSelectResponse ipfFciLabelDetailSelectResponse = new IpfFciLabelDetailSelectResponse();
        ipfFciLabelDetailSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfFciLabelDetail> ipfFciLabelDetails= ipfFciLabelDetailService.selectWithCondition(ipfFciLabelDetail);
        ipfFciLabelDetailSelectResponse.setResultJson(ipfFciLabelDetails);
        return ipfFciLabelDetailSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfFciLabelDetail.isExistIpfFciLabelDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfFciLabelDetail(IpfFciLabelDetailSelectRequest request) {
        IpfFciLabelDetail ipfFciLabelDetail=new IpfFciLabelDetail();
        ipfFciLabelDetail.setId(request.getId());
        ipfFciLabelDetail.setIpfFciLabelId(request.getIpfFciLabelId());
        ipfFciLabelDetail.setIpfFciViewId(request.getIpfFciViewId());
        ipfFciLabelDetail.setConfigItemType(request.getConfigItemType());
        ipfFciLabelDetail.setConfigItemCode(request.getConfigItemCode());
        ipfFciLabelDetail.setConfigItemId(request.getConfigItemId());
        ipfFciLabelDetail.setRevisionNumber(request.getRevisionNumber());
        ipfFciLabelDetail.setRelationMemberId(request.getRelationMemberId());
        ipfFciLabelDetail.setIsActive(request.getIsActive());
        ArrayList<IpfFciLabelDetail> ipfFciLabelDetails= ipfFciLabelDetailService.selectWithCondition(ipfFciLabelDetail);
    	IpfFciLabelDetailCountAllResponse ipfFciLabelDetailCountAllResponse = new IpfFciLabelDetailCountAllResponse();
        if (ipfFciLabelDetails.size()>0){
        	ipfFciLabelDetailCountAllResponse.setResultString("1");
        } else {
        	ipfFciLabelDetailCountAllResponse.setResultString("0");
        }        
        return ipfFciLabelDetailCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfFciLabelDetailCreateRequest request){
    	IpfFciLabelDetail ipfFciLabelDetail=new IpfFciLabelDetail();
    	ipfFciLabelDetail.setId(request.getId());
        ArrayList<IpfFciLabelDetail> ipfFciLabelDetails= ipfFciLabelDetailService.selectWithCondition(ipfFciLabelDetail);
        if (ipfFciLabelDetails!=null&&ipfFciLabelDetails.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfFciLabelDetailUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfFciLabelDetailDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfFciLabelDetailSelectRequest request){
        return  true;
     }    
}
