/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRuleFilterDetail;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfRuleFilterDetail.request.*;
import com.cartan.center.ebs.ipfRuleFilterDetail.response.*;
import com.cartan.core.ipfRuleFilterDetail.domain.IpfRuleFilterDetail;
import com.cartan.core.ipfRuleFilterDetail.service.IpfRuleFilterDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfRuleFilterDetailServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfRuleFilterDetailServiceEbs.class.getName());
	private IpfRuleFilterDetailService  ipfRuleFilterDetailService;
	
    public IpfRuleFilterDetailService getIpfRuleFilterDetailService() {
        return ipfRuleFilterDetailService;
    }

    @Autowired
    public void setIpfRuleFilterDetailService(IpfRuleFilterDetailService ipfRuleFilterDetailService) {
        this.ipfRuleFilterDetailService = ipfRuleFilterDetailService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfRuleFilterDetailGetSessionRequest request) {      
    	IpfRuleFilterDetailGetSessionResponse ipfRuleFilterDetailGetSessionResponse = new IpfRuleFilterDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRuleFilterDetailGetSessionResponse.setResultString("0");
        } else {
        	ipfRuleFilterDetailGetSessionResponse.setResultString("1");
            ipfRuleFilterDetailGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfRuleFilterDetailGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfRuleFilterDetailGetSessionRequest request) {
    	IpfRuleFilterDetailGetSessionResponse ipfRuleFilterDetailGetSessionResponse = new IpfRuleFilterDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfRuleFilterDetailGetSessionResponse.setResultString("1");
        } else {
        	ipfRuleFilterDetailGetSessionResponse.setResultString("0");
        }
        ipfRuleFilterDetailGetSessionResponse.setSessionId(request.getSessionId());
        return ipfRuleFilterDetailGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfRuleFilterDetailGetSessionRequest request) {
    	IpfRuleFilterDetailGetSessionResponse ipfRuleFilterDetailGetSessionResponse = new IpfRuleFilterDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRuleFilterDetailGetSessionResponse.setResultString("0");
        	ipfRuleFilterDetailGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfRuleFilterDetailGetSessionResponse.setResultString("1");
        }
        return ipfRuleFilterDetailGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.createIpfRuleFilterDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfRuleFilterDetail(IpfRuleFilterDetailCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfRuleFilterDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleFilterDetail ipfRuleFilterDetail=new IpfRuleFilterDetail();
        ipfRuleFilterDetail.setId(request.getId());    		
        ipfRuleFilterDetail.setIpfRuleFilterId(request.getIpfRuleFilterId());
        ipfRuleFilterDetail.setLineId(request.getLineId());
        ipfRuleFilterDetail.setAttribute(request.getAttribute());
        ipfRuleFilterDetail.setOperand(request.getOperand());
        ipfRuleFilterDetail.setLiteralValue(request.getLiteralValue());
        ipfRuleFilterDetail.setAndOr(request.getAndOr());
        ipfRuleFilterDetail.setLeftParen(request.getLeftParen());
        ipfRuleFilterDetail.setRightParen(request.getRightParen());
    	ipfRuleFilterDetailService.createIpfRuleFilterDetail(ipfRuleFilterDetail);
        //返回响应
        IpfRuleFilterDetailCreateResponse ipfRuleFilterDetailCreateResponse = new IpfRuleFilterDetailCreateResponse();
        ipfRuleFilterDetailCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleFilterDetailCreateResponse.setResultJson(ipfRuleFilterDetail);
        return ipfRuleFilterDetailCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.deleteIpfRuleFilterDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfRuleFilterDetail(IpfRuleFilterDetailDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfRuleFilterDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfRuleFilterDetailService.deleteIpfRuleFilterDetail(idstr);
        //返回响应
        IpfRuleFilterDetailDeleteResponse ipfRuleFilterDetailDeleteResponse = new IpfRuleFilterDetailDeleteResponse();
        ipfRuleFilterDetailDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRuleFilterDetailDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.updateIpfRuleFilterDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfRuleFilterDetail(IpfRuleFilterDetailUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfRuleFilterDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleFilterDetail ipfRuleFilterDetail=new IpfRuleFilterDetail();
        ipfRuleFilterDetail=ipfRuleFilterDetailService.getIpfRuleFilterDetail(request.getId());
        if (request.getId()!=null){
	        ipfRuleFilterDetail.setId(request.getId());
        }
        if (request.getIpfRuleFilterId()!=null){
	        ipfRuleFilterDetail.setIpfRuleFilterId(request.getIpfRuleFilterId());
        }
        if (request.getLineId()!=null){
	        ipfRuleFilterDetail.setLineId(request.getLineId());
        }
        if (request.getAttribute()!=null){
	        ipfRuleFilterDetail.setAttribute(request.getAttribute());
        }
        if (request.getOperand()!=null){
	        ipfRuleFilterDetail.setOperand(request.getOperand());
        }
        if (request.getLiteralValue()!=null){
	        ipfRuleFilterDetail.setLiteralValue(request.getLiteralValue());
        }
        if (request.getAndOr()!=null){
	        ipfRuleFilterDetail.setAndOr(request.getAndOr());
        }
        if (request.getLeftParen()!=null){
	        ipfRuleFilterDetail.setLeftParen(request.getLeftParen());
        }
        if (request.getRightParen()!=null){
	        ipfRuleFilterDetail.setRightParen(request.getRightParen());
        }
    	ipfRuleFilterDetailService.updateIpfRuleFilterDetail(ipfRuleFilterDetail);
        //返回响应
        IpfRuleFilterDetailUpdateResponse ipfRuleFilterDetailUpdateResponse = new IpfRuleFilterDetailUpdateResponse();
        ipfRuleFilterDetailUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleFilterDetailUpdateResponse.setResultJson(ipfRuleFilterDetail);
        return ipfRuleFilterDetailUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.getIpfRuleFilterDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfRuleFilterDetail(IpfRuleFilterDetailGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfRuleFilterDetail ipfRuleFilterDetail=new IpfRuleFilterDetail();
        ipfRuleFilterDetail=ipfRuleFilterDetailService.getIpfRuleFilterDetail(id);
        //返回响应
        IpfRuleFilterDetailGetResponse ipfRuleFilterDetailGetResponse = new IpfRuleFilterDetailGetResponse();
        ipfRuleFilterDetailGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleFilterDetailGetResponse.setResultJson(ipfRuleFilterDetail);
        return ipfRuleFilterDetailGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfRuleFilterDetailSelectAllRequest request) {
        IpfRuleFilterDetailSelectAllResponse ipfRuleFilterDetailSelectAllResponse = new IpfRuleFilterDetailSelectAllResponse();
        ipfRuleFilterDetailSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleFilterDetailSelectAllResponse.setResultJson(ipfRuleFilterDetailService.selectAll());
        return ipfRuleFilterDetailSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfRuleFilterDetailCountAllRequest request) {
        IpfRuleFilterDetailCountAllResponse ipfRuleFilterDetailCountAllResponse = new IpfRuleFilterDetailCountAllResponse();
        ipfRuleFilterDetailCountAllResponse.setResultString(String.valueOf(ipfRuleFilterDetailService.countAll()));
        ipfRuleFilterDetailCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRuleFilterDetailCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfRuleFilterDetailSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfRuleFilterDetailSelectAllResponse ipfRuleFilterDetailSelectAllResponse = new IpfRuleFilterDetailSelectAllResponse();
        ipfRuleFilterDetailSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleFilterDetailSelectAllResponse.setResultJson(ipfRuleFilterDetailService.selectBySql(sqlstr));
        return ipfRuleFilterDetailSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.selectIpfRuleFilterDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfRuleFilterDetailSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfRuleFilterDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleFilterDetail ipfRuleFilterDetail=new IpfRuleFilterDetail();
        ipfRuleFilterDetail.setId(request.getId());
        ipfRuleFilterDetail.setIpfRuleFilterId(request.getIpfRuleFilterId());
        ipfRuleFilterDetail.setLineId(request.getLineId());
        ipfRuleFilterDetail.setAttribute(request.getAttribute());
        ipfRuleFilterDetail.setOperand(request.getOperand());
        ipfRuleFilterDetail.setLiteralValue(request.getLiteralValue());
        ipfRuleFilterDetail.setAndOr(request.getAndOr());
        ipfRuleFilterDetail.setLeftParen(request.getLeftParen());
        ipfRuleFilterDetail.setRightParen(request.getRightParen());
    	IpfRuleFilterDetailSelectResponse ipfRuleFilterDetailSelectResponse = new IpfRuleFilterDetailSelectResponse();
        ipfRuleFilterDetailSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfRuleFilterDetail> ipfRuleFilterDetails= ipfRuleFilterDetailService.selectWithCondition(ipfRuleFilterDetail);
        ipfRuleFilterDetailSelectResponse.setResultJson(ipfRuleFilterDetails);
        return ipfRuleFilterDetailSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleFilterDetail.isExistIpfRuleFilterDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfRuleFilterDetail(IpfRuleFilterDetailSelectRequest request) {
        IpfRuleFilterDetail ipfRuleFilterDetail=new IpfRuleFilterDetail();
        ipfRuleFilterDetail.setId(request.getId());
        ipfRuleFilterDetail.setIpfRuleFilterId(request.getIpfRuleFilterId());
        ipfRuleFilterDetail.setLineId(request.getLineId());
        ipfRuleFilterDetail.setAttribute(request.getAttribute());
        ipfRuleFilterDetail.setOperand(request.getOperand());
        ipfRuleFilterDetail.setLiteralValue(request.getLiteralValue());
        ipfRuleFilterDetail.setAndOr(request.getAndOr());
        ipfRuleFilterDetail.setLeftParen(request.getLeftParen());
        ipfRuleFilterDetail.setRightParen(request.getRightParen());
        ArrayList<IpfRuleFilterDetail> ipfRuleFilterDetails= ipfRuleFilterDetailService.selectWithCondition(ipfRuleFilterDetail);
    	IpfRuleFilterDetailCountAllResponse ipfRuleFilterDetailCountAllResponse = new IpfRuleFilterDetailCountAllResponse();
        if (ipfRuleFilterDetails.size()>0){
        	ipfRuleFilterDetailCountAllResponse.setResultString("1");
        } else {
        	ipfRuleFilterDetailCountAllResponse.setResultString("0");
        }        
        return ipfRuleFilterDetailCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfRuleFilterDetailCreateRequest request){
    	IpfRuleFilterDetail ipfRuleFilterDetail=new IpfRuleFilterDetail();
    	ipfRuleFilterDetail.setId(request.getId());
        ArrayList<IpfRuleFilterDetail> ipfRuleFilterDetails= ipfRuleFilterDetailService.selectWithCondition(ipfRuleFilterDetail);
        if (ipfRuleFilterDetails!=null&&ipfRuleFilterDetails.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfRuleFilterDetailUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfRuleFilterDetailDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfRuleFilterDetailSelectRequest request){
        return  true;
     }    
}
