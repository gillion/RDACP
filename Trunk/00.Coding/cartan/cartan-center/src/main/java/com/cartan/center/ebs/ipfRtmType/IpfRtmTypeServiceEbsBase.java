/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmType;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfRtmType.request.*;
import com.cartan.center.ebs.ipfRtmType.response.*;
import com.cartan.core.ipfRtmType.domain.IpfRtmType;
import com.cartan.core.ipfRtmType.service.IpfRtmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfRtmTypeServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfRtmTypeServiceEbs.class.getName());
	private IpfRtmTypeService  ipfRtmTypeService;
	
    public IpfRtmTypeService getIpfRtmTypeService() {
        return ipfRtmTypeService;
    }

    @Autowired
    public void setIpfRtmTypeService(IpfRtmTypeService ipfRtmTypeService) {
        this.ipfRtmTypeService = ipfRtmTypeService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfRtmTypeGetSessionRequest request) {      
    	IpfRtmTypeGetSessionResponse ipfRtmTypeGetSessionResponse = new IpfRtmTypeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmTypeGetSessionResponse.setResultString("0");
        } else {
        	ipfRtmTypeGetSessionResponse.setResultString("1");
            ipfRtmTypeGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfRtmTypeGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfRtmTypeGetSessionRequest request) {
    	IpfRtmTypeGetSessionResponse ipfRtmTypeGetSessionResponse = new IpfRtmTypeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfRtmTypeGetSessionResponse.setResultString("1");
        } else {
        	ipfRtmTypeGetSessionResponse.setResultString("0");
        }
        ipfRtmTypeGetSessionResponse.setSessionId(request.getSessionId());
        return ipfRtmTypeGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfRtmTypeGetSessionRequest request) {
    	IpfRtmTypeGetSessionResponse ipfRtmTypeGetSessionResponse = new IpfRtmTypeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmTypeGetSessionResponse.setResultString("0");
        	ipfRtmTypeGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfRtmTypeGetSessionResponse.setResultString("1");
        }
        return ipfRtmTypeGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.createIpfRtmType", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfRtmType(IpfRtmTypeCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfRtmType_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmType ipfRtmType=new IpfRtmType();
        ipfRtmType.setId(request.getId());    		
        ipfRtmType.setTypeCode(request.getTypeCode());
        ipfRtmType.setTypeName(request.getTypeName());
    	ipfRtmTypeService.createIpfRtmType(ipfRtmType);
        //返回响应
        IpfRtmTypeCreateResponse ipfRtmTypeCreateResponse = new IpfRtmTypeCreateResponse();
        ipfRtmTypeCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeCreateResponse.setResultJson(ipfRtmType);
        return ipfRtmTypeCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.deleteIpfRtmType", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfRtmType(IpfRtmTypeDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfRtmType_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfRtmTypeService.deleteIpfRtmType(idstr);
        //返回响应
        IpfRtmTypeDeleteResponse ipfRtmTypeDeleteResponse = new IpfRtmTypeDeleteResponse();
        ipfRtmTypeDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmTypeDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.updateIpfRtmType", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfRtmType(IpfRtmTypeUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfRtmType_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmType ipfRtmType=new IpfRtmType();
        ipfRtmType=ipfRtmTypeService.getIpfRtmType(request.getId());
        if (request.getId()!=null){
	        ipfRtmType.setId(request.getId());
        }
        if (request.getTypeCode()!=null){
	        ipfRtmType.setTypeCode(request.getTypeCode());
        }
        if (request.getTypeName()!=null){
	        ipfRtmType.setTypeName(request.getTypeName());
        }
    	ipfRtmTypeService.updateIpfRtmType(ipfRtmType);
        //返回响应
        IpfRtmTypeUpdateResponse ipfRtmTypeUpdateResponse = new IpfRtmTypeUpdateResponse();
        ipfRtmTypeUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeUpdateResponse.setResultJson(ipfRtmType);
        return ipfRtmTypeUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.getIpfRtmType", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfRtmType(IpfRtmTypeGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfRtmType ipfRtmType=new IpfRtmType();
        ipfRtmType=ipfRtmTypeService.getIpfRtmType(id);
        //返回响应
        IpfRtmTypeGetResponse ipfRtmTypeGetResponse = new IpfRtmTypeGetResponse();
        ipfRtmTypeGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeGetResponse.setResultJson(ipfRtmType);
        return ipfRtmTypeGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfRtmTypeSelectAllRequest request) {
        IpfRtmTypeSelectAllResponse ipfRtmTypeSelectAllResponse = new IpfRtmTypeSelectAllResponse();
        ipfRtmTypeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeSelectAllResponse.setResultJson(ipfRtmTypeService.selectAll());
        return ipfRtmTypeSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfRtmTypeCountAllRequest request) {
        IpfRtmTypeCountAllResponse ipfRtmTypeCountAllResponse = new IpfRtmTypeCountAllResponse();
        ipfRtmTypeCountAllResponse.setResultString(String.valueOf(ipfRtmTypeService.countAll()));
        ipfRtmTypeCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmTypeCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfRtmTypeSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfRtmTypeSelectAllResponse ipfRtmTypeSelectAllResponse = new IpfRtmTypeSelectAllResponse();
        ipfRtmTypeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeSelectAllResponse.setResultJson(ipfRtmTypeService.selectBySql(sqlstr));
        return ipfRtmTypeSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.selectIpfRtmType", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfRtmTypeSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfRtmType_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmType ipfRtmType=new IpfRtmType();
        ipfRtmType.setId(request.getId());
        ipfRtmType.setTypeCode(request.getTypeCode());
        ipfRtmType.setTypeName(request.getTypeName());
    	IpfRtmTypeSelectResponse ipfRtmTypeSelectResponse = new IpfRtmTypeSelectResponse();
        ipfRtmTypeSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfRtmType> ipfRtmTypes= ipfRtmTypeService.selectWithCondition(ipfRtmType);
        ipfRtmTypeSelectResponse.setResultJson(ipfRtmTypes);
        return ipfRtmTypeSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmType.isExistIpfRtmType", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfRtmType(IpfRtmTypeSelectRequest request) {
        IpfRtmType ipfRtmType=new IpfRtmType();
        ipfRtmType.setId(request.getId());
        ipfRtmType.setTypeCode(request.getTypeCode());
        ipfRtmType.setTypeName(request.getTypeName());
        ArrayList<IpfRtmType> ipfRtmTypes= ipfRtmTypeService.selectWithCondition(ipfRtmType);
    	IpfRtmTypeCountAllResponse ipfRtmTypeCountAllResponse = new IpfRtmTypeCountAllResponse();
        if (ipfRtmTypes.size()>0){
        	ipfRtmTypeCountAllResponse.setResultString("1");
        } else {
        	ipfRtmTypeCountAllResponse.setResultString("0");
        }        
        return ipfRtmTypeCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfRtmTypeCreateRequest request){
    	IpfRtmType ipfRtmType=new IpfRtmType();
    	ipfRtmType.setId(request.getId());
        ArrayList<IpfRtmType> ipfRtmTypes= ipfRtmTypeService.selectWithCondition(ipfRtmType);
        if (ipfRtmTypes!=null&&ipfRtmTypes.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfRtmTypeUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfRtmTypeDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfRtmTypeSelectRequest request){
        return  true;
     }    
}
