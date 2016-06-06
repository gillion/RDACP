/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmNumruleList;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmNumruleList.request.*;
import com.cartan.center.ebs.ipfCcmNumruleList.response.*;
import com.cartan.core.ipfCcmNumruleList.domain.IpfCcmNumruleList;
import com.cartan.core.ipfCcmNumruleList.service.IpfCcmNumruleListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmNumruleListServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmNumruleListServiceEbs.class.getName());
	private IpfCcmNumruleListService  ipfCcmNumruleListService;
	
    public IpfCcmNumruleListService getIpfCcmNumruleListService() {
        return ipfCcmNumruleListService;
    }

    @Autowired
    public void setIpfCcmNumruleListService(IpfCcmNumruleListService ipfCcmNumruleListService) {
        this.ipfCcmNumruleListService = ipfCcmNumruleListService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmNumruleListGetSessionRequest request) {      
    	IpfCcmNumruleListGetSessionResponse ipfCcmNumruleListGetSessionResponse = new IpfCcmNumruleListGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmNumruleListGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmNumruleListGetSessionResponse.setResultString("1");
            ipfCcmNumruleListGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmNumruleListGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmNumruleListGetSessionRequest request) {
    	IpfCcmNumruleListGetSessionResponse ipfCcmNumruleListGetSessionResponse = new IpfCcmNumruleListGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmNumruleListGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmNumruleListGetSessionResponse.setResultString("0");
        }
        ipfCcmNumruleListGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmNumruleListGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmNumruleListGetSessionRequest request) {
    	IpfCcmNumruleListGetSessionResponse ipfCcmNumruleListGetSessionResponse = new IpfCcmNumruleListGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmNumruleListGetSessionResponse.setResultString("0");
        	ipfCcmNumruleListGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmNumruleListGetSessionResponse.setResultString("1");
        }
        return ipfCcmNumruleListGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.createIpfCcmNumruleList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmNumruleList(IpfCcmNumruleListCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmNumruleList_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmNumruleList ipfCcmNumruleList=new IpfCcmNumruleList();
        ipfCcmNumruleList.setId(request.getId());    		
        ipfCcmNumruleList.setIpfCcmNumruleId(request.getIpfCcmNumruleId());
        ipfCcmNumruleList.setConstExpression(request.getConstExpression());
        ipfCcmNumruleList.setCurrentValue(request.getCurrentValue());
        ipfCcmNumruleList.setInitialValue(request.getInitialValue());
        ipfCcmNumruleList.setMaxValue(request.getMaxValue());
        ipfCcmNumruleList.setGrowth(request.getGrowth());
        ipfCcmNumruleList.setRemark(request.getRemark());
        ipfCcmNumruleList.setIsActive(request.getIsActive());
    	ipfCcmNumruleListService.createIpfCcmNumruleList(ipfCcmNumruleList);
        //返回响应
        IpfCcmNumruleListCreateResponse ipfCcmNumruleListCreateResponse = new IpfCcmNumruleListCreateResponse();
        ipfCcmNumruleListCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmNumruleListCreateResponse.setResultJson(ipfCcmNumruleList);
        return ipfCcmNumruleListCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.deleteIpfCcmNumruleList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmNumruleList(IpfCcmNumruleListDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmNumruleList_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmNumruleListService.deleteIpfCcmNumruleList(idstr);
        //返回响应
        IpfCcmNumruleListDeleteResponse ipfCcmNumruleListDeleteResponse = new IpfCcmNumruleListDeleteResponse();
        ipfCcmNumruleListDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmNumruleListDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.updateIpfCcmNumruleList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmNumruleList(IpfCcmNumruleListUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmNumruleList_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmNumruleList ipfCcmNumruleList=new IpfCcmNumruleList();
        ipfCcmNumruleList=ipfCcmNumruleListService.getIpfCcmNumruleList(request.getId());
        if (request.getId()!=null){
	        ipfCcmNumruleList.setId(request.getId());
        }
        if (request.getIpfCcmNumruleId()!=null){
	        ipfCcmNumruleList.setIpfCcmNumruleId(request.getIpfCcmNumruleId());
        }
        if (request.getConstExpression()!=null){
	        ipfCcmNumruleList.setConstExpression(request.getConstExpression());
        }
        if (request.getCurrentValue()!=null){
	        ipfCcmNumruleList.setCurrentValue(request.getCurrentValue());
        }
        if (request.getInitialValue()!=null){
	        ipfCcmNumruleList.setInitialValue(request.getInitialValue());
        }
        if (request.getMaxValue()!=null){
	        ipfCcmNumruleList.setMaxValue(request.getMaxValue());
        }
        if (request.getGrowth()!=null){
	        ipfCcmNumruleList.setGrowth(request.getGrowth());
        }
        if (request.getRemark()!=null){
	        ipfCcmNumruleList.setRemark(request.getRemark());
        }
        if (request.getIsActive()!=null){
	        ipfCcmNumruleList.setIsActive(request.getIsActive());
        }
    	ipfCcmNumruleListService.updateIpfCcmNumruleList(ipfCcmNumruleList);
        //返回响应
        IpfCcmNumruleListUpdateResponse ipfCcmNumruleListUpdateResponse = new IpfCcmNumruleListUpdateResponse();
        ipfCcmNumruleListUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmNumruleListUpdateResponse.setResultJson(ipfCcmNumruleList);
        return ipfCcmNumruleListUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.getIpfCcmNumruleList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmNumruleList(IpfCcmNumruleListGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmNumruleList ipfCcmNumruleList=new IpfCcmNumruleList();
        ipfCcmNumruleList=ipfCcmNumruleListService.getIpfCcmNumruleList(id);
        //返回响应
        IpfCcmNumruleListGetResponse ipfCcmNumruleListGetResponse = new IpfCcmNumruleListGetResponse();
        ipfCcmNumruleListGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmNumruleListGetResponse.setResultJson(ipfCcmNumruleList);
        return ipfCcmNumruleListGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmNumruleListSelectAllRequest request) {
        IpfCcmNumruleListSelectAllResponse ipfCcmNumruleListSelectAllResponse = new IpfCcmNumruleListSelectAllResponse();
        ipfCcmNumruleListSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmNumruleListSelectAllResponse.setResultJson(ipfCcmNumruleListService.selectAll());
        return ipfCcmNumruleListSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmNumruleListCountAllRequest request) {
        IpfCcmNumruleListCountAllResponse ipfCcmNumruleListCountAllResponse = new IpfCcmNumruleListCountAllResponse();
        ipfCcmNumruleListCountAllResponse.setResultString(String.valueOf(ipfCcmNumruleListService.countAll()));
        ipfCcmNumruleListCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmNumruleListCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmNumruleListSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmNumruleListSelectAllResponse ipfCcmNumruleListSelectAllResponse = new IpfCcmNumruleListSelectAllResponse();
        ipfCcmNumruleListSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmNumruleListSelectAllResponse.setResultJson(ipfCcmNumruleListService.selectBySql(sqlstr));
        return ipfCcmNumruleListSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.selectIpfCcmNumruleList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmNumruleListSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmNumruleList_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmNumruleList ipfCcmNumruleList=new IpfCcmNumruleList();
        ipfCcmNumruleList.setId(request.getId());
        ipfCcmNumruleList.setIpfCcmNumruleId(request.getIpfCcmNumruleId());
        ipfCcmNumruleList.setConstExpression(request.getConstExpression());
        ipfCcmNumruleList.setCurrentValue(request.getCurrentValue());
        ipfCcmNumruleList.setInitialValue(request.getInitialValue());
        ipfCcmNumruleList.setMaxValue(request.getMaxValue());
        ipfCcmNumruleList.setGrowth(request.getGrowth());
        ipfCcmNumruleList.setRemark(request.getRemark());
        ipfCcmNumruleList.setIsActive(request.getIsActive());
    	IpfCcmNumruleListSelectResponse ipfCcmNumruleListSelectResponse = new IpfCcmNumruleListSelectResponse();
        ipfCcmNumruleListSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmNumruleList> ipfCcmNumruleLists= ipfCcmNumruleListService.selectWithCondition(ipfCcmNumruleList);
        ipfCcmNumruleListSelectResponse.setResultJson(ipfCcmNumruleLists);
        return ipfCcmNumruleListSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmNumruleList.isExistIpfCcmNumruleList", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmNumruleList(IpfCcmNumruleListSelectRequest request) {
        IpfCcmNumruleList ipfCcmNumruleList=new IpfCcmNumruleList();
        ipfCcmNumruleList.setId(request.getId());
        ipfCcmNumruleList.setIpfCcmNumruleId(request.getIpfCcmNumruleId());
        ipfCcmNumruleList.setConstExpression(request.getConstExpression());
        ipfCcmNumruleList.setCurrentValue(request.getCurrentValue());
        ipfCcmNumruleList.setInitialValue(request.getInitialValue());
        ipfCcmNumruleList.setMaxValue(request.getMaxValue());
        ipfCcmNumruleList.setGrowth(request.getGrowth());
        ipfCcmNumruleList.setRemark(request.getRemark());
        ipfCcmNumruleList.setIsActive(request.getIsActive());
        ArrayList<IpfCcmNumruleList> ipfCcmNumruleLists= ipfCcmNumruleListService.selectWithCondition(ipfCcmNumruleList);
    	IpfCcmNumruleListCountAllResponse ipfCcmNumruleListCountAllResponse = new IpfCcmNumruleListCountAllResponse();
        if (ipfCcmNumruleLists.size()>0){
        	ipfCcmNumruleListCountAllResponse.setResultString("1");
        } else {
        	ipfCcmNumruleListCountAllResponse.setResultString("0");
        }        
        return ipfCcmNumruleListCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmNumruleListCreateRequest request){
    	IpfCcmNumruleList ipfCcmNumruleList=new IpfCcmNumruleList();
    	ipfCcmNumruleList.setId(request.getId());
        ArrayList<IpfCcmNumruleList> ipfCcmNumruleLists= ipfCcmNumruleListService.selectWithCondition(ipfCcmNumruleList);
        if (ipfCcmNumruleLists!=null&&ipfCcmNumruleLists.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmNumruleListUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmNumruleListDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmNumruleListSelectRequest request){
        return  true;
     }    
}
