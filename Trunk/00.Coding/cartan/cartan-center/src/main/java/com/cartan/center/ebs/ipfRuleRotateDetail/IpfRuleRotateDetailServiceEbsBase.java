/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRuleRotateDetail;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfRuleRotateDetail.request.*;
import com.cartan.center.ebs.ipfRuleRotateDetail.response.*;
import com.cartan.core.ipfRuleRotateDetail.domain.IpfRuleRotateDetail;
import com.cartan.core.ipfRuleRotateDetail.service.IpfRuleRotateDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfRuleRotateDetailServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfRuleRotateDetailServiceEbs.class.getName());
	private IpfRuleRotateDetailService  ipfRuleRotateDetailService;
	
    public IpfRuleRotateDetailService getIpfRuleRotateDetailService() {
        return ipfRuleRotateDetailService;
    }

    @Autowired
    public void setIpfRuleRotateDetailService(IpfRuleRotateDetailService ipfRuleRotateDetailService) {
        this.ipfRuleRotateDetailService = ipfRuleRotateDetailService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfRuleRotateDetailGetSessionRequest request) {      
    	IpfRuleRotateDetailGetSessionResponse ipfRuleRotateDetailGetSessionResponse = new IpfRuleRotateDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRuleRotateDetailGetSessionResponse.setResultString("0");
        } else {
        	ipfRuleRotateDetailGetSessionResponse.setResultString("1");
            ipfRuleRotateDetailGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfRuleRotateDetailGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfRuleRotateDetailGetSessionRequest request) {
    	IpfRuleRotateDetailGetSessionResponse ipfRuleRotateDetailGetSessionResponse = new IpfRuleRotateDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfRuleRotateDetailGetSessionResponse.setResultString("1");
        } else {
        	ipfRuleRotateDetailGetSessionResponse.setResultString("0");
        }
        ipfRuleRotateDetailGetSessionResponse.setSessionId(request.getSessionId());
        return ipfRuleRotateDetailGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfRuleRotateDetailGetSessionRequest request) {
    	IpfRuleRotateDetailGetSessionResponse ipfRuleRotateDetailGetSessionResponse = new IpfRuleRotateDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRuleRotateDetailGetSessionResponse.setResultString("0");
        	ipfRuleRotateDetailGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfRuleRotateDetailGetSessionResponse.setResultString("1");
        }
        return ipfRuleRotateDetailGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.createIpfRuleRotateDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfRuleRotateDetail(IpfRuleRotateDetailCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfRuleRotateDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleRotateDetail ipfRuleRotateDetail=new IpfRuleRotateDetail();
        ipfRuleRotateDetail.setId(request.getId());    		
        ipfRuleRotateDetail.setIpfRuleRotateId(request.getIpfRuleRotateId());
        ipfRuleRotateDetail.setLineId(request.getLineId());
        ipfRuleRotateDetail.setLotAttributes(request.getLotAttributes());
        ipfRuleRotateDetail.setSortType(request.getSortType());
        ipfRuleRotateDetail.setDetailDesc(request.getDetailDesc());
        ipfRuleRotateDetail.setIsActive(request.getIsActive());
    	ipfRuleRotateDetailService.createIpfRuleRotateDetail(ipfRuleRotateDetail);
        //返回响应
        IpfRuleRotateDetailCreateResponse ipfRuleRotateDetailCreateResponse = new IpfRuleRotateDetailCreateResponse();
        ipfRuleRotateDetailCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleRotateDetailCreateResponse.setResultJson(ipfRuleRotateDetail);
        return ipfRuleRotateDetailCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.deleteIpfRuleRotateDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfRuleRotateDetail(IpfRuleRotateDetailDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfRuleRotateDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfRuleRotateDetailService.deleteIpfRuleRotateDetail(idstr);
        //返回响应
        IpfRuleRotateDetailDeleteResponse ipfRuleRotateDetailDeleteResponse = new IpfRuleRotateDetailDeleteResponse();
        ipfRuleRotateDetailDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRuleRotateDetailDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.updateIpfRuleRotateDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfRuleRotateDetail(IpfRuleRotateDetailUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfRuleRotateDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleRotateDetail ipfRuleRotateDetail=new IpfRuleRotateDetail();
        ipfRuleRotateDetail=ipfRuleRotateDetailService.getIpfRuleRotateDetail(request.getId());
        if (request.getId()!=null){
	        ipfRuleRotateDetail.setId(request.getId());
        }
        if (request.getIpfRuleRotateId()!=null){
	        ipfRuleRotateDetail.setIpfRuleRotateId(request.getIpfRuleRotateId());
        }
        if (request.getLineId()!=null){
	        ipfRuleRotateDetail.setLineId(request.getLineId());
        }
        if (request.getLotAttributes()!=null){
	        ipfRuleRotateDetail.setLotAttributes(request.getLotAttributes());
        }
        if (request.getSortType()!=null){
	        ipfRuleRotateDetail.setSortType(request.getSortType());
        }
        if (request.getDetailDesc()!=null){
	        ipfRuleRotateDetail.setDetailDesc(request.getDetailDesc());
        }
        if (request.getIsActive()!=null){
	        ipfRuleRotateDetail.setIsActive(request.getIsActive());
        }
    	ipfRuleRotateDetailService.updateIpfRuleRotateDetail(ipfRuleRotateDetail);
        //返回响应
        IpfRuleRotateDetailUpdateResponse ipfRuleRotateDetailUpdateResponse = new IpfRuleRotateDetailUpdateResponse();
        ipfRuleRotateDetailUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleRotateDetailUpdateResponse.setResultJson(ipfRuleRotateDetail);
        return ipfRuleRotateDetailUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.getIpfRuleRotateDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfRuleRotateDetail(IpfRuleRotateDetailGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfRuleRotateDetail ipfRuleRotateDetail=new IpfRuleRotateDetail();
        ipfRuleRotateDetail=ipfRuleRotateDetailService.getIpfRuleRotateDetail(id);
        //返回响应
        IpfRuleRotateDetailGetResponse ipfRuleRotateDetailGetResponse = new IpfRuleRotateDetailGetResponse();
        ipfRuleRotateDetailGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleRotateDetailGetResponse.setResultJson(ipfRuleRotateDetail);
        return ipfRuleRotateDetailGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfRuleRotateDetailSelectAllRequest request) {
        IpfRuleRotateDetailSelectAllResponse ipfRuleRotateDetailSelectAllResponse = new IpfRuleRotateDetailSelectAllResponse();
        ipfRuleRotateDetailSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleRotateDetailSelectAllResponse.setResultJson(ipfRuleRotateDetailService.selectAll());
        return ipfRuleRotateDetailSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfRuleRotateDetailCountAllRequest request) {
        IpfRuleRotateDetailCountAllResponse ipfRuleRotateDetailCountAllResponse = new IpfRuleRotateDetailCountAllResponse();
        ipfRuleRotateDetailCountAllResponse.setResultString(String.valueOf(ipfRuleRotateDetailService.countAll()));
        ipfRuleRotateDetailCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRuleRotateDetailCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfRuleRotateDetailSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfRuleRotateDetailSelectAllResponse ipfRuleRotateDetailSelectAllResponse = new IpfRuleRotateDetailSelectAllResponse();
        ipfRuleRotateDetailSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRuleRotateDetailSelectAllResponse.setResultJson(ipfRuleRotateDetailService.selectBySql(sqlstr));
        return ipfRuleRotateDetailSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.selectIpfRuleRotateDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfRuleRotateDetailSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfRuleRotateDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRuleRotateDetail ipfRuleRotateDetail=new IpfRuleRotateDetail();
        ipfRuleRotateDetail.setId(request.getId());
        ipfRuleRotateDetail.setIpfRuleRotateId(request.getIpfRuleRotateId());
        ipfRuleRotateDetail.setLineId(request.getLineId());
        ipfRuleRotateDetail.setLotAttributes(request.getLotAttributes());
        ipfRuleRotateDetail.setSortType(request.getSortType());
        ipfRuleRotateDetail.setDetailDesc(request.getDetailDesc());
        ipfRuleRotateDetail.setIsActive(request.getIsActive());
    	IpfRuleRotateDetailSelectResponse ipfRuleRotateDetailSelectResponse = new IpfRuleRotateDetailSelectResponse();
        ipfRuleRotateDetailSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfRuleRotateDetail> ipfRuleRotateDetails= ipfRuleRotateDetailService.selectWithCondition(ipfRuleRotateDetail);
        ipfRuleRotateDetailSelectResponse.setResultJson(ipfRuleRotateDetails);
        return ipfRuleRotateDetailSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRuleRotateDetail.isExistIpfRuleRotateDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfRuleRotateDetail(IpfRuleRotateDetailSelectRequest request) {
        IpfRuleRotateDetail ipfRuleRotateDetail=new IpfRuleRotateDetail();
        ipfRuleRotateDetail.setId(request.getId());
        ipfRuleRotateDetail.setIpfRuleRotateId(request.getIpfRuleRotateId());
        ipfRuleRotateDetail.setLineId(request.getLineId());
        ipfRuleRotateDetail.setLotAttributes(request.getLotAttributes());
        ipfRuleRotateDetail.setSortType(request.getSortType());
        ipfRuleRotateDetail.setDetailDesc(request.getDetailDesc());
        ipfRuleRotateDetail.setIsActive(request.getIsActive());
        ArrayList<IpfRuleRotateDetail> ipfRuleRotateDetails= ipfRuleRotateDetailService.selectWithCondition(ipfRuleRotateDetail);
    	IpfRuleRotateDetailCountAllResponse ipfRuleRotateDetailCountAllResponse = new IpfRuleRotateDetailCountAllResponse();
        if (ipfRuleRotateDetails.size()>0){
        	ipfRuleRotateDetailCountAllResponse.setResultString("1");
        } else {
        	ipfRuleRotateDetailCountAllResponse.setResultString("0");
        }        
        return ipfRuleRotateDetailCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfRuleRotateDetailCreateRequest request){
    	IpfRuleRotateDetail ipfRuleRotateDetail=new IpfRuleRotateDetail();
    	ipfRuleRotateDetail.setId(request.getId());
        ArrayList<IpfRuleRotateDetail> ipfRuleRotateDetails= ipfRuleRotateDetailService.selectWithCondition(ipfRuleRotateDetail);
        if (ipfRuleRotateDetails!=null&&ipfRuleRotateDetails.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfRuleRotateDetailUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfRuleRotateDetailDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfRuleRotateDetailSelectRequest request){
        return  true;
     }    
}
