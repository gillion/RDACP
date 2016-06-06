/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoPropertyCas;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoPropertyCas.request.*;
import com.cartan.center.ebs.ipfCcmBoPropertyCas.response.*;
import com.cartan.core.ipfCcmBoPropertyCas.domain.IpfCcmBoPropertyCas;
import com.cartan.core.ipfCcmBoPropertyCas.service.IpfCcmBoPropertyCasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoPropertyCasServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoPropertyCasServiceEbs.class.getName());
	private IpfCcmBoPropertyCasService  ipfCcmBoPropertyCasService;
	
    public IpfCcmBoPropertyCasService getIpfCcmBoPropertyCasService() {
        return ipfCcmBoPropertyCasService;
    }

    @Autowired
    public void setIpfCcmBoPropertyCasService(IpfCcmBoPropertyCasService ipfCcmBoPropertyCasService) {
        this.ipfCcmBoPropertyCasService = ipfCcmBoPropertyCasService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoPropertyCasGetSessionRequest request) {      
    	IpfCcmBoPropertyCasGetSessionResponse ipfCcmBoPropertyCasGetSessionResponse = new IpfCcmBoPropertyCasGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoPropertyCasGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoPropertyCasGetSessionResponse.setResultString("1");
            ipfCcmBoPropertyCasGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoPropertyCasGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoPropertyCasGetSessionRequest request) {
    	IpfCcmBoPropertyCasGetSessionResponse ipfCcmBoPropertyCasGetSessionResponse = new IpfCcmBoPropertyCasGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoPropertyCasGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoPropertyCasGetSessionResponse.setResultString("0");
        }
        ipfCcmBoPropertyCasGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoPropertyCasGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoPropertyCasGetSessionRequest request) {
    	IpfCcmBoPropertyCasGetSessionResponse ipfCcmBoPropertyCasGetSessionResponse = new IpfCcmBoPropertyCasGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoPropertyCasGetSessionResponse.setResultString("0");
        	ipfCcmBoPropertyCasGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoPropertyCasGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoPropertyCasGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.createIpfCcmBoPropertyCas", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoPropertyCas(IpfCcmBoPropertyCasCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoPropertyCas_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPropertyCas ipfCcmBoPropertyCas=new IpfCcmBoPropertyCas();
        ipfCcmBoPropertyCas.setId(request.getId());    		
        ipfCcmBoPropertyCas.setIpfCcmBoPropertyId(request.getIpfCcmBoPropertyId());
        ipfCcmBoPropertyCas.setCascadePropertyId(request.getCascadePropertyId());
        ipfCcmBoPropertyCas.setOperation(request.getOperation());
        ipfCcmBoPropertyCas.setTargetPropertyName(request.getTargetPropertyName());
        ipfCcmBoPropertyCas.setType(request.getType());
    	ipfCcmBoPropertyCasService.createIpfCcmBoPropertyCas(ipfCcmBoPropertyCas);
        //返回响应
        IpfCcmBoPropertyCasCreateResponse ipfCcmBoPropertyCasCreateResponse = new IpfCcmBoPropertyCasCreateResponse();
        ipfCcmBoPropertyCasCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPropertyCasCreateResponse.setResultJson(ipfCcmBoPropertyCas);
        return ipfCcmBoPropertyCasCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.deleteIpfCcmBoPropertyCas", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoPropertyCas(IpfCcmBoPropertyCasDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoPropertyCas_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoPropertyCasService.deleteIpfCcmBoPropertyCas(idstr);
        //返回响应
        IpfCcmBoPropertyCasDeleteResponse ipfCcmBoPropertyCasDeleteResponse = new IpfCcmBoPropertyCasDeleteResponse();
        ipfCcmBoPropertyCasDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoPropertyCasDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.updateIpfCcmBoPropertyCas", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoPropertyCas(IpfCcmBoPropertyCasUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoPropertyCas_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPropertyCas ipfCcmBoPropertyCas=new IpfCcmBoPropertyCas();
        ipfCcmBoPropertyCas=ipfCcmBoPropertyCasService.getIpfCcmBoPropertyCas(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoPropertyCas.setId(request.getId());
        }
        if (request.getIpfCcmBoPropertyId()!=null){
	        ipfCcmBoPropertyCas.setIpfCcmBoPropertyId(request.getIpfCcmBoPropertyId());
        }
        if (request.getCascadePropertyId()!=null){
	        ipfCcmBoPropertyCas.setCascadePropertyId(request.getCascadePropertyId());
        }
        if (request.getOperation()!=null){
	        ipfCcmBoPropertyCas.setOperation(request.getOperation());
        }
        if (request.getTargetPropertyName()!=null){
	        ipfCcmBoPropertyCas.setTargetPropertyName(request.getTargetPropertyName());
        }
        if (request.getType()!=null){
	        ipfCcmBoPropertyCas.setType(request.getType());
        }
    	ipfCcmBoPropertyCasService.updateIpfCcmBoPropertyCas(ipfCcmBoPropertyCas);
        //返回响应
        IpfCcmBoPropertyCasUpdateResponse ipfCcmBoPropertyCasUpdateResponse = new IpfCcmBoPropertyCasUpdateResponse();
        ipfCcmBoPropertyCasUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPropertyCasUpdateResponse.setResultJson(ipfCcmBoPropertyCas);
        return ipfCcmBoPropertyCasUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.getIpfCcmBoPropertyCas", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoPropertyCas(IpfCcmBoPropertyCasGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoPropertyCas ipfCcmBoPropertyCas=new IpfCcmBoPropertyCas();
        ipfCcmBoPropertyCas=ipfCcmBoPropertyCasService.getIpfCcmBoPropertyCas(id);
        //返回响应
        IpfCcmBoPropertyCasGetResponse ipfCcmBoPropertyCasGetResponse = new IpfCcmBoPropertyCasGetResponse();
        ipfCcmBoPropertyCasGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPropertyCasGetResponse.setResultJson(ipfCcmBoPropertyCas);
        return ipfCcmBoPropertyCasGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoPropertyCasSelectAllRequest request) {
        IpfCcmBoPropertyCasSelectAllResponse ipfCcmBoPropertyCasSelectAllResponse = new IpfCcmBoPropertyCasSelectAllResponse();
        ipfCcmBoPropertyCasSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPropertyCasSelectAllResponse.setResultJson(ipfCcmBoPropertyCasService.selectAll());
        return ipfCcmBoPropertyCasSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoPropertyCasCountAllRequest request) {
        IpfCcmBoPropertyCasCountAllResponse ipfCcmBoPropertyCasCountAllResponse = new IpfCcmBoPropertyCasCountAllResponse();
        ipfCcmBoPropertyCasCountAllResponse.setResultString(String.valueOf(ipfCcmBoPropertyCasService.countAll()));
        ipfCcmBoPropertyCasCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoPropertyCasCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoPropertyCasSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoPropertyCasSelectAllResponse ipfCcmBoPropertyCasSelectAllResponse = new IpfCcmBoPropertyCasSelectAllResponse();
        ipfCcmBoPropertyCasSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoPropertyCasSelectAllResponse.setResultJson(ipfCcmBoPropertyCasService.selectBySql(sqlstr));
        return ipfCcmBoPropertyCasSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.selectIpfCcmBoPropertyCas", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoPropertyCasSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoPropertyCas_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoPropertyCas ipfCcmBoPropertyCas=new IpfCcmBoPropertyCas();
        ipfCcmBoPropertyCas.setId(request.getId());
        ipfCcmBoPropertyCas.setIpfCcmBoPropertyId(request.getIpfCcmBoPropertyId());
        ipfCcmBoPropertyCas.setCascadePropertyId(request.getCascadePropertyId());
        ipfCcmBoPropertyCas.setOperation(request.getOperation());
        ipfCcmBoPropertyCas.setTargetPropertyName(request.getTargetPropertyName());
        ipfCcmBoPropertyCas.setType(request.getType());
    	IpfCcmBoPropertyCasSelectResponse ipfCcmBoPropertyCasSelectResponse = new IpfCcmBoPropertyCasSelectResponse();
        ipfCcmBoPropertyCasSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoPropertyCas> ipfCcmBoPropertyCass= ipfCcmBoPropertyCasService.selectWithCondition(ipfCcmBoPropertyCas);
        ipfCcmBoPropertyCasSelectResponse.setResultJson(ipfCcmBoPropertyCass);
        return ipfCcmBoPropertyCasSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoPropertyCas.isExistIpfCcmBoPropertyCas", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoPropertyCas(IpfCcmBoPropertyCasSelectRequest request) {
        IpfCcmBoPropertyCas ipfCcmBoPropertyCas=new IpfCcmBoPropertyCas();
        ipfCcmBoPropertyCas.setId(request.getId());
        ipfCcmBoPropertyCas.setIpfCcmBoPropertyId(request.getIpfCcmBoPropertyId());
        ipfCcmBoPropertyCas.setCascadePropertyId(request.getCascadePropertyId());
        ipfCcmBoPropertyCas.setOperation(request.getOperation());
        ipfCcmBoPropertyCas.setTargetPropertyName(request.getTargetPropertyName());
        ipfCcmBoPropertyCas.setType(request.getType());
        ArrayList<IpfCcmBoPropertyCas> ipfCcmBoPropertyCass= ipfCcmBoPropertyCasService.selectWithCondition(ipfCcmBoPropertyCas);
    	IpfCcmBoPropertyCasCountAllResponse ipfCcmBoPropertyCasCountAllResponse = new IpfCcmBoPropertyCasCountAllResponse();
        if (ipfCcmBoPropertyCass.size()>0){
        	ipfCcmBoPropertyCasCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoPropertyCasCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoPropertyCasCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoPropertyCasCreateRequest request){
    	IpfCcmBoPropertyCas ipfCcmBoPropertyCas=new IpfCcmBoPropertyCas();
    	ipfCcmBoPropertyCas.setId(request.getId());
        ArrayList<IpfCcmBoPropertyCas> ipfCcmBoPropertyCass= ipfCcmBoPropertyCasService.selectWithCondition(ipfCcmBoPropertyCas);
        if (ipfCcmBoPropertyCass!=null&&ipfCcmBoPropertyCass.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoPropertyCasUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoPropertyCasDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoPropertyCasSelectRequest request){
        return  true;
     }    
}
