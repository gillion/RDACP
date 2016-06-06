/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayoutDetail;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmUiLayoutDetail.request.*;
import com.cartan.center.ebs.ipfCcmUiLayoutDetail.response.*;
import com.cartan.core.ipfCcmUiLayoutDetail.domain.IpfCcmUiLayoutDetail;
import com.cartan.core.ipfCcmUiLayoutDetail.service.IpfCcmUiLayoutDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmUiLayoutDetailServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmUiLayoutDetailServiceEbs.class.getName());
	private IpfCcmUiLayoutDetailService  ipfCcmUiLayoutDetailService;
	
    public IpfCcmUiLayoutDetailService getIpfCcmUiLayoutDetailService() {
        return ipfCcmUiLayoutDetailService;
    }

    @Autowired
    public void setIpfCcmUiLayoutDetailService(IpfCcmUiLayoutDetailService ipfCcmUiLayoutDetailService) {
        this.ipfCcmUiLayoutDetailService = ipfCcmUiLayoutDetailService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmUiLayoutDetailGetSessionRequest request) {      
    	IpfCcmUiLayoutDetailGetSessionResponse ipfCcmUiLayoutDetailGetSessionResponse = new IpfCcmUiLayoutDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmUiLayoutDetailGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmUiLayoutDetailGetSessionResponse.setResultString("1");
            ipfCcmUiLayoutDetailGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmUiLayoutDetailGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmUiLayoutDetailGetSessionRequest request) {
    	IpfCcmUiLayoutDetailGetSessionResponse ipfCcmUiLayoutDetailGetSessionResponse = new IpfCcmUiLayoutDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmUiLayoutDetailGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmUiLayoutDetailGetSessionResponse.setResultString("0");
        }
        ipfCcmUiLayoutDetailGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmUiLayoutDetailGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmUiLayoutDetailGetSessionRequest request) {
    	IpfCcmUiLayoutDetailGetSessionResponse ipfCcmUiLayoutDetailGetSessionResponse = new IpfCcmUiLayoutDetailGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmUiLayoutDetailGetSessionResponse.setResultString("0");
        	ipfCcmUiLayoutDetailGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmUiLayoutDetailGetSessionResponse.setResultString("1");
        }
        return ipfCcmUiLayoutDetailGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.createIpfCcmUiLayoutDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmUiLayoutDetail(IpfCcmUiLayoutDetailCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmUiLayoutDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail=new IpfCcmUiLayoutDetail();
        ipfCcmUiLayoutDetail.setId(request.getId());    		
        ipfCcmUiLayoutDetail.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        ipfCcmUiLayoutDetail.setIpfCcmUiLayoutListId(request.getIpfCcmUiLayoutListId());
        ipfCcmUiLayoutDetail.setLayoutElementName(request.getLayoutElementName());
        ipfCcmUiLayoutDetail.setDescription(request.getDescription());
    	ipfCcmUiLayoutDetailService.createIpfCcmUiLayoutDetail(ipfCcmUiLayoutDetail);
        //返回响应
        IpfCcmUiLayoutDetailCreateResponse ipfCcmUiLayoutDetailCreateResponse = new IpfCcmUiLayoutDetailCreateResponse();
        ipfCcmUiLayoutDetailCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutDetailCreateResponse.setResultJson(ipfCcmUiLayoutDetail);
        return ipfCcmUiLayoutDetailCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.deleteIpfCcmUiLayoutDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmUiLayoutDetail(IpfCcmUiLayoutDetailDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmUiLayoutDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmUiLayoutDetailService.deleteIpfCcmUiLayoutDetail(idstr);
        //返回响应
        IpfCcmUiLayoutDetailDeleteResponse ipfCcmUiLayoutDetailDeleteResponse = new IpfCcmUiLayoutDetailDeleteResponse();
        ipfCcmUiLayoutDetailDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmUiLayoutDetailDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.updateIpfCcmUiLayoutDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmUiLayoutDetail(IpfCcmUiLayoutDetailUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmUiLayoutDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail=new IpfCcmUiLayoutDetail();
        ipfCcmUiLayoutDetail=ipfCcmUiLayoutDetailService.getIpfCcmUiLayoutDetail(request.getId());
        if (request.getId()!=null){
	        ipfCcmUiLayoutDetail.setId(request.getId());
        }
        if (request.getIpfCcmUiLayoutId()!=null){
	        ipfCcmUiLayoutDetail.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        }
        if (request.getIpfCcmUiLayoutListId()!=null){
	        ipfCcmUiLayoutDetail.setIpfCcmUiLayoutListId(request.getIpfCcmUiLayoutListId());
        }
        if (request.getLayoutElementName()!=null){
	        ipfCcmUiLayoutDetail.setLayoutElementName(request.getLayoutElementName());
        }
        if (request.getDescription()!=null){
	        ipfCcmUiLayoutDetail.setDescription(request.getDescription());
        }
    	ipfCcmUiLayoutDetailService.updateIpfCcmUiLayoutDetail(ipfCcmUiLayoutDetail);
        //返回响应
        IpfCcmUiLayoutDetailUpdateResponse ipfCcmUiLayoutDetailUpdateResponse = new IpfCcmUiLayoutDetailUpdateResponse();
        ipfCcmUiLayoutDetailUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutDetailUpdateResponse.setResultJson(ipfCcmUiLayoutDetail);
        return ipfCcmUiLayoutDetailUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.getIpfCcmUiLayoutDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmUiLayoutDetail(IpfCcmUiLayoutDetailGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail=new IpfCcmUiLayoutDetail();
        ipfCcmUiLayoutDetail=ipfCcmUiLayoutDetailService.getIpfCcmUiLayoutDetail(id);
        //返回响应
        IpfCcmUiLayoutDetailGetResponse ipfCcmUiLayoutDetailGetResponse = new IpfCcmUiLayoutDetailGetResponse();
        ipfCcmUiLayoutDetailGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutDetailGetResponse.setResultJson(ipfCcmUiLayoutDetail);
        return ipfCcmUiLayoutDetailGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmUiLayoutDetailSelectAllRequest request) {
        IpfCcmUiLayoutDetailSelectAllResponse ipfCcmUiLayoutDetailSelectAllResponse = new IpfCcmUiLayoutDetailSelectAllResponse();
        ipfCcmUiLayoutDetailSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutDetailSelectAllResponse.setResultJson(ipfCcmUiLayoutDetailService.selectAll());
        return ipfCcmUiLayoutDetailSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmUiLayoutDetailCountAllRequest request) {
        IpfCcmUiLayoutDetailCountAllResponse ipfCcmUiLayoutDetailCountAllResponse = new IpfCcmUiLayoutDetailCountAllResponse();
        ipfCcmUiLayoutDetailCountAllResponse.setResultString(String.valueOf(ipfCcmUiLayoutDetailService.countAll()));
        ipfCcmUiLayoutDetailCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmUiLayoutDetailCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmUiLayoutDetailSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmUiLayoutDetailSelectAllResponse ipfCcmUiLayoutDetailSelectAllResponse = new IpfCcmUiLayoutDetailSelectAllResponse();
        ipfCcmUiLayoutDetailSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmUiLayoutDetailSelectAllResponse.setResultJson(ipfCcmUiLayoutDetailService.selectBySql(sqlstr));
        return ipfCcmUiLayoutDetailSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.selectIpfCcmUiLayoutDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmUiLayoutDetailSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmUiLayoutDetail_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail=new IpfCcmUiLayoutDetail();
        ipfCcmUiLayoutDetail.setId(request.getId());
        ipfCcmUiLayoutDetail.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        ipfCcmUiLayoutDetail.setIpfCcmUiLayoutListId(request.getIpfCcmUiLayoutListId());
        ipfCcmUiLayoutDetail.setLayoutElementName(request.getLayoutElementName());
        ipfCcmUiLayoutDetail.setDescription(request.getDescription());
    	IpfCcmUiLayoutDetailSelectResponse ipfCcmUiLayoutDetailSelectResponse = new IpfCcmUiLayoutDetailSelectResponse();
        ipfCcmUiLayoutDetailSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmUiLayoutDetail> ipfCcmUiLayoutDetails= ipfCcmUiLayoutDetailService.selectWithCondition(ipfCcmUiLayoutDetail);
        ipfCcmUiLayoutDetailSelectResponse.setResultJson(ipfCcmUiLayoutDetails);
        return ipfCcmUiLayoutDetailSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmUiLayoutDetail.isExistIpfCcmUiLayoutDetail", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmUiLayoutDetail(IpfCcmUiLayoutDetailSelectRequest request) {
        IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail=new IpfCcmUiLayoutDetail();
        ipfCcmUiLayoutDetail.setId(request.getId());
        ipfCcmUiLayoutDetail.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        ipfCcmUiLayoutDetail.setIpfCcmUiLayoutListId(request.getIpfCcmUiLayoutListId());
        ipfCcmUiLayoutDetail.setLayoutElementName(request.getLayoutElementName());
        ipfCcmUiLayoutDetail.setDescription(request.getDescription());
        ArrayList<IpfCcmUiLayoutDetail> ipfCcmUiLayoutDetails= ipfCcmUiLayoutDetailService.selectWithCondition(ipfCcmUiLayoutDetail);
    	IpfCcmUiLayoutDetailCountAllResponse ipfCcmUiLayoutDetailCountAllResponse = new IpfCcmUiLayoutDetailCountAllResponse();
        if (ipfCcmUiLayoutDetails.size()>0){
        	ipfCcmUiLayoutDetailCountAllResponse.setResultString("1");
        } else {
        	ipfCcmUiLayoutDetailCountAllResponse.setResultString("0");
        }        
        return ipfCcmUiLayoutDetailCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmUiLayoutDetailCreateRequest request){
    	IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail=new IpfCcmUiLayoutDetail();
    	ipfCcmUiLayoutDetail.setId(request.getId());
        ArrayList<IpfCcmUiLayoutDetail> ipfCcmUiLayoutDetails= ipfCcmUiLayoutDetailService.selectWithCondition(ipfCcmUiLayoutDetail);
        if (ipfCcmUiLayoutDetails!=null&&ipfCcmUiLayoutDetails.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmUiLayoutDetailUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmUiLayoutDetailDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmUiLayoutDetailSelectRequest request){
        return  true;
     }    
}
