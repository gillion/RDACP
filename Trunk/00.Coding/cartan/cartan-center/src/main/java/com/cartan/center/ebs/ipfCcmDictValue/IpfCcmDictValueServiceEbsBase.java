/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmDictValue;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmDictValue.request.*;
import com.cartan.center.ebs.ipfCcmDictValue.response.*;
import com.cartan.core.ipfCcmDictValue.domain.IpfCcmDictValue;
import com.cartan.core.ipfCcmDictValue.service.IpfCcmDictValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmDictValueServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmDictValueServiceEbs.class.getName());
	private IpfCcmDictValueService  ipfCcmDictValueService;
	
    public IpfCcmDictValueService getIpfCcmDictValueService() {
        return ipfCcmDictValueService;
    }

    @Autowired
    public void setIpfCcmDictValueService(IpfCcmDictValueService ipfCcmDictValueService) {
        this.ipfCcmDictValueService = ipfCcmDictValueService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmDictValueGetSessionRequest request) {      
    	IpfCcmDictValueGetSessionResponse ipfCcmDictValueGetSessionResponse = new IpfCcmDictValueGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmDictValueGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmDictValueGetSessionResponse.setResultString("1");
            ipfCcmDictValueGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmDictValueGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmDictValueGetSessionRequest request) {
    	IpfCcmDictValueGetSessionResponse ipfCcmDictValueGetSessionResponse = new IpfCcmDictValueGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmDictValueGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmDictValueGetSessionResponse.setResultString("0");
        }
        ipfCcmDictValueGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmDictValueGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmDictValueGetSessionRequest request) {
    	IpfCcmDictValueGetSessionResponse ipfCcmDictValueGetSessionResponse = new IpfCcmDictValueGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmDictValueGetSessionResponse.setResultString("0");
        	ipfCcmDictValueGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmDictValueGetSessionResponse.setResultString("1");
        }
        return ipfCcmDictValueGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.createIpfCcmDictValue", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmDictValue(IpfCcmDictValueCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmDictValue_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmDictValue ipfCcmDictValue=new IpfCcmDictValue();
        ipfCcmDictValue.setId(request.getId());    		
        ipfCcmDictValue.setIpfCcmDictId(request.getIpfCcmDictId());
        ipfCcmDictValue.setCodeValue(request.getCodeValue());
        ipfCcmDictValue.setDisplayValue(request.getDisplayValue());
        ipfCcmDictValue.setSeqNo(request.getSeqNo());
        ipfCcmDictValue.setGroupValue(request.getGroupValue());
        ipfCcmDictValue.setRemark(request.getRemark());
    	ipfCcmDictValueService.createIpfCcmDictValue(ipfCcmDictValue);
        //返回响应
        IpfCcmDictValueCreateResponse ipfCcmDictValueCreateResponse = new IpfCcmDictValueCreateResponse();
        ipfCcmDictValueCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmDictValueCreateResponse.setResultJson(ipfCcmDictValue);
        return ipfCcmDictValueCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.deleteIpfCcmDictValue", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmDictValue(IpfCcmDictValueDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmDictValue_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmDictValueService.deleteIpfCcmDictValue(idstr);
        //返回响应
        IpfCcmDictValueDeleteResponse ipfCcmDictValueDeleteResponse = new IpfCcmDictValueDeleteResponse();
        ipfCcmDictValueDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmDictValueDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.updateIpfCcmDictValue", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmDictValue(IpfCcmDictValueUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmDictValue_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmDictValue ipfCcmDictValue=new IpfCcmDictValue();
        ipfCcmDictValue=ipfCcmDictValueService.getIpfCcmDictValue(request.getId());
        if (request.getId()!=null){
	        ipfCcmDictValue.setId(request.getId());
        }
        if (request.getIpfCcmDictId()!=null){
	        ipfCcmDictValue.setIpfCcmDictId(request.getIpfCcmDictId());
        }
        if (request.getCodeValue()!=null){
	        ipfCcmDictValue.setCodeValue(request.getCodeValue());
        }
        if (request.getDisplayValue()!=null){
	        ipfCcmDictValue.setDisplayValue(request.getDisplayValue());
        }
        if (request.getSeqNo()!=null){
	        ipfCcmDictValue.setSeqNo(request.getSeqNo());
        }
        if (request.getGroupValue()!=null){
	        ipfCcmDictValue.setGroupValue(request.getGroupValue());
        }
        if (request.getRemark()!=null){
	        ipfCcmDictValue.setRemark(request.getRemark());
        }
    	ipfCcmDictValueService.updateIpfCcmDictValue(ipfCcmDictValue);
        //返回响应
        IpfCcmDictValueUpdateResponse ipfCcmDictValueUpdateResponse = new IpfCcmDictValueUpdateResponse();
        ipfCcmDictValueUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmDictValueUpdateResponse.setResultJson(ipfCcmDictValue);
        return ipfCcmDictValueUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.getIpfCcmDictValue", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmDictValue(IpfCcmDictValueGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmDictValue ipfCcmDictValue=new IpfCcmDictValue();
        ipfCcmDictValue=ipfCcmDictValueService.getIpfCcmDictValue(id);
        //返回响应
        IpfCcmDictValueGetResponse ipfCcmDictValueGetResponse = new IpfCcmDictValueGetResponse();
        ipfCcmDictValueGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmDictValueGetResponse.setResultJson(ipfCcmDictValue);
        return ipfCcmDictValueGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmDictValueSelectAllRequest request) {
        IpfCcmDictValueSelectAllResponse ipfCcmDictValueSelectAllResponse = new IpfCcmDictValueSelectAllResponse();
        ipfCcmDictValueSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmDictValueSelectAllResponse.setResultJson(ipfCcmDictValueService.selectAll());
        return ipfCcmDictValueSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmDictValueCountAllRequest request) {
        IpfCcmDictValueCountAllResponse ipfCcmDictValueCountAllResponse = new IpfCcmDictValueCountAllResponse();
        ipfCcmDictValueCountAllResponse.setResultString(String.valueOf(ipfCcmDictValueService.countAll()));
        ipfCcmDictValueCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmDictValueCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmDictValueSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmDictValueSelectAllResponse ipfCcmDictValueSelectAllResponse = new IpfCcmDictValueSelectAllResponse();
        ipfCcmDictValueSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmDictValueSelectAllResponse.setResultJson(ipfCcmDictValueService.selectBySql(sqlstr));
        return ipfCcmDictValueSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.selectIpfCcmDictValue", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmDictValueSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmDictValue_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmDictValue ipfCcmDictValue=new IpfCcmDictValue();
        ipfCcmDictValue.setId(request.getId());
        ipfCcmDictValue.setIpfCcmDictId(request.getIpfCcmDictId());
        ipfCcmDictValue.setCodeValue(request.getCodeValue());
        ipfCcmDictValue.setDisplayValue(request.getDisplayValue());
        ipfCcmDictValue.setSeqNo(request.getSeqNo());
        ipfCcmDictValue.setGroupValue(request.getGroupValue());
        ipfCcmDictValue.setRemark(request.getRemark());
    	IpfCcmDictValueSelectResponse ipfCcmDictValueSelectResponse = new IpfCcmDictValueSelectResponse();
        ipfCcmDictValueSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmDictValue> ipfCcmDictValues= ipfCcmDictValueService.selectWithCondition(ipfCcmDictValue);
        ipfCcmDictValueSelectResponse.setResultJson(ipfCcmDictValues);
        return ipfCcmDictValueSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDictValue.isExistIpfCcmDictValue", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmDictValue(IpfCcmDictValueSelectRequest request) {
        IpfCcmDictValue ipfCcmDictValue=new IpfCcmDictValue();
        ipfCcmDictValue.setId(request.getId());
        ipfCcmDictValue.setIpfCcmDictId(request.getIpfCcmDictId());
        ipfCcmDictValue.setCodeValue(request.getCodeValue());
        ipfCcmDictValue.setDisplayValue(request.getDisplayValue());
        ipfCcmDictValue.setSeqNo(request.getSeqNo());
        ipfCcmDictValue.setGroupValue(request.getGroupValue());
        ipfCcmDictValue.setRemark(request.getRemark());
        ArrayList<IpfCcmDictValue> ipfCcmDictValues= ipfCcmDictValueService.selectWithCondition(ipfCcmDictValue);
    	IpfCcmDictValueCountAllResponse ipfCcmDictValueCountAllResponse = new IpfCcmDictValueCountAllResponse();
        if (ipfCcmDictValues.size()>0){
        	ipfCcmDictValueCountAllResponse.setResultString("1");
        } else {
        	ipfCcmDictValueCountAllResponse.setResultString("0");
        }        
        return ipfCcmDictValueCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmDictValueCreateRequest request){
    	IpfCcmDictValue ipfCcmDictValue=new IpfCcmDictValue();
    	ipfCcmDictValue.setId(request.getId());
        ArrayList<IpfCcmDictValue> ipfCcmDictValues= ipfCcmDictValueService.selectWithCondition(ipfCcmDictValue);
        if (ipfCcmDictValues!=null&&ipfCcmDictValues.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmDictValueUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmDictValueDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmDictValueSelectRequest request){
        return  true;
     }    
}
