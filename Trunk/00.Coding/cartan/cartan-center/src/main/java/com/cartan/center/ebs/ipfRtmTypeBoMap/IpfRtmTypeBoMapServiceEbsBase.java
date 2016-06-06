/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmTypeBoMap;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfRtmTypeBoMap.request.*;
import com.cartan.center.ebs.ipfRtmTypeBoMap.response.*;
import com.cartan.core.ipfRtmTypeBoMap.domain.IpfRtmTypeBoMap;
import com.cartan.core.ipfRtmTypeBoMap.service.IpfRtmTypeBoMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfRtmTypeBoMapServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfRtmTypeBoMapServiceEbs.class.getName());
	private IpfRtmTypeBoMapService  ipfRtmTypeBoMapService;
	
    public IpfRtmTypeBoMapService getIpfRtmTypeBoMapService() {
        return ipfRtmTypeBoMapService;
    }

    @Autowired
    public void setIpfRtmTypeBoMapService(IpfRtmTypeBoMapService ipfRtmTypeBoMapService) {
        this.ipfRtmTypeBoMapService = ipfRtmTypeBoMapService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfRtmTypeBoMapGetSessionRequest request) {      
    	IpfRtmTypeBoMapGetSessionResponse ipfRtmTypeBoMapGetSessionResponse = new IpfRtmTypeBoMapGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmTypeBoMapGetSessionResponse.setResultString("0");
        } else {
        	ipfRtmTypeBoMapGetSessionResponse.setResultString("1");
            ipfRtmTypeBoMapGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfRtmTypeBoMapGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfRtmTypeBoMapGetSessionRequest request) {
    	IpfRtmTypeBoMapGetSessionResponse ipfRtmTypeBoMapGetSessionResponse = new IpfRtmTypeBoMapGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfRtmTypeBoMapGetSessionResponse.setResultString("1");
        } else {
        	ipfRtmTypeBoMapGetSessionResponse.setResultString("0");
        }
        ipfRtmTypeBoMapGetSessionResponse.setSessionId(request.getSessionId());
        return ipfRtmTypeBoMapGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfRtmTypeBoMapGetSessionRequest request) {
    	IpfRtmTypeBoMapGetSessionResponse ipfRtmTypeBoMapGetSessionResponse = new IpfRtmTypeBoMapGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmTypeBoMapGetSessionResponse.setResultString("0");
        	ipfRtmTypeBoMapGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfRtmTypeBoMapGetSessionResponse.setResultString("1");
        }
        return ipfRtmTypeBoMapGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.createIpfRtmTypeBoMap", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfRtmTypeBoMap(IpfRtmTypeBoMapCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfRtmTypeBoMap_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmTypeBoMap ipfRtmTypeBoMap=new IpfRtmTypeBoMap();
        ipfRtmTypeBoMap.setId(request.getId());    		
        ipfRtmTypeBoMap.setIpfRtmTypeBoId(request.getIpfRtmTypeBoId());
        ipfRtmTypeBoMap.setSourceValue(request.getSourceValue());
        ipfRtmTypeBoMap.setDestValue(request.getDestValue());
    	ipfRtmTypeBoMapService.createIpfRtmTypeBoMap(ipfRtmTypeBoMap);
        //返回响应
        IpfRtmTypeBoMapCreateResponse ipfRtmTypeBoMapCreateResponse = new IpfRtmTypeBoMapCreateResponse();
        ipfRtmTypeBoMapCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoMapCreateResponse.setResultJson(ipfRtmTypeBoMap);
        return ipfRtmTypeBoMapCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.deleteIpfRtmTypeBoMap", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfRtmTypeBoMap(IpfRtmTypeBoMapDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfRtmTypeBoMap_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfRtmTypeBoMapService.deleteIpfRtmTypeBoMap(idstr);
        //返回响应
        IpfRtmTypeBoMapDeleteResponse ipfRtmTypeBoMapDeleteResponse = new IpfRtmTypeBoMapDeleteResponse();
        ipfRtmTypeBoMapDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmTypeBoMapDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.updateIpfRtmTypeBoMap", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfRtmTypeBoMap(IpfRtmTypeBoMapUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfRtmTypeBoMap_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmTypeBoMap ipfRtmTypeBoMap=new IpfRtmTypeBoMap();
        ipfRtmTypeBoMap=ipfRtmTypeBoMapService.getIpfRtmTypeBoMap(request.getId());
        if (request.getId()!=null){
	        ipfRtmTypeBoMap.setId(request.getId());
        }
        if (request.getIpfRtmTypeBoId()!=null){
	        ipfRtmTypeBoMap.setIpfRtmTypeBoId(request.getIpfRtmTypeBoId());
        }
        if (request.getSourceValue()!=null){
	        ipfRtmTypeBoMap.setSourceValue(request.getSourceValue());
        }
        if (request.getDestValue()!=null){
	        ipfRtmTypeBoMap.setDestValue(request.getDestValue());
        }
    	ipfRtmTypeBoMapService.updateIpfRtmTypeBoMap(ipfRtmTypeBoMap);
        //返回响应
        IpfRtmTypeBoMapUpdateResponse ipfRtmTypeBoMapUpdateResponse = new IpfRtmTypeBoMapUpdateResponse();
        ipfRtmTypeBoMapUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoMapUpdateResponse.setResultJson(ipfRtmTypeBoMap);
        return ipfRtmTypeBoMapUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.getIpfRtmTypeBoMap", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfRtmTypeBoMap(IpfRtmTypeBoMapGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfRtmTypeBoMap ipfRtmTypeBoMap=new IpfRtmTypeBoMap();
        ipfRtmTypeBoMap=ipfRtmTypeBoMapService.getIpfRtmTypeBoMap(id);
        //返回响应
        IpfRtmTypeBoMapGetResponse ipfRtmTypeBoMapGetResponse = new IpfRtmTypeBoMapGetResponse();
        ipfRtmTypeBoMapGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoMapGetResponse.setResultJson(ipfRtmTypeBoMap);
        return ipfRtmTypeBoMapGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfRtmTypeBoMapSelectAllRequest request) {
        IpfRtmTypeBoMapSelectAllResponse ipfRtmTypeBoMapSelectAllResponse = new IpfRtmTypeBoMapSelectAllResponse();
        ipfRtmTypeBoMapSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoMapSelectAllResponse.setResultJson(ipfRtmTypeBoMapService.selectAll());
        return ipfRtmTypeBoMapSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfRtmTypeBoMapCountAllRequest request) {
        IpfRtmTypeBoMapCountAllResponse ipfRtmTypeBoMapCountAllResponse = new IpfRtmTypeBoMapCountAllResponse();
        ipfRtmTypeBoMapCountAllResponse.setResultString(String.valueOf(ipfRtmTypeBoMapService.countAll()));
        ipfRtmTypeBoMapCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmTypeBoMapCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfRtmTypeBoMapSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfRtmTypeBoMapSelectAllResponse ipfRtmTypeBoMapSelectAllResponse = new IpfRtmTypeBoMapSelectAllResponse();
        ipfRtmTypeBoMapSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmTypeBoMapSelectAllResponse.setResultJson(ipfRtmTypeBoMapService.selectBySql(sqlstr));
        return ipfRtmTypeBoMapSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.selectIpfRtmTypeBoMap", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfRtmTypeBoMapSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfRtmTypeBoMap_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmTypeBoMap ipfRtmTypeBoMap=new IpfRtmTypeBoMap();
        ipfRtmTypeBoMap.setId(request.getId());
        ipfRtmTypeBoMap.setIpfRtmTypeBoId(request.getIpfRtmTypeBoId());
        ipfRtmTypeBoMap.setSourceValue(request.getSourceValue());
        ipfRtmTypeBoMap.setDestValue(request.getDestValue());
    	IpfRtmTypeBoMapSelectResponse ipfRtmTypeBoMapSelectResponse = new IpfRtmTypeBoMapSelectResponse();
        ipfRtmTypeBoMapSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfRtmTypeBoMap> ipfRtmTypeBoMaps= ipfRtmTypeBoMapService.selectWithCondition(ipfRtmTypeBoMap);
        ipfRtmTypeBoMapSelectResponse.setResultJson(ipfRtmTypeBoMaps);
        return ipfRtmTypeBoMapSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmTypeBoMap.isExistIpfRtmTypeBoMap", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfRtmTypeBoMap(IpfRtmTypeBoMapSelectRequest request) {
        IpfRtmTypeBoMap ipfRtmTypeBoMap=new IpfRtmTypeBoMap();
        ipfRtmTypeBoMap.setId(request.getId());
        ipfRtmTypeBoMap.setIpfRtmTypeBoId(request.getIpfRtmTypeBoId());
        ipfRtmTypeBoMap.setSourceValue(request.getSourceValue());
        ipfRtmTypeBoMap.setDestValue(request.getDestValue());
        ArrayList<IpfRtmTypeBoMap> ipfRtmTypeBoMaps= ipfRtmTypeBoMapService.selectWithCondition(ipfRtmTypeBoMap);
    	IpfRtmTypeBoMapCountAllResponse ipfRtmTypeBoMapCountAllResponse = new IpfRtmTypeBoMapCountAllResponse();
        if (ipfRtmTypeBoMaps.size()>0){
        	ipfRtmTypeBoMapCountAllResponse.setResultString("1");
        } else {
        	ipfRtmTypeBoMapCountAllResponse.setResultString("0");
        }        
        return ipfRtmTypeBoMapCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfRtmTypeBoMapCreateRequest request){
    	IpfRtmTypeBoMap ipfRtmTypeBoMap=new IpfRtmTypeBoMap();
    	ipfRtmTypeBoMap.setId(request.getId());
        ArrayList<IpfRtmTypeBoMap> ipfRtmTypeBoMaps= ipfRtmTypeBoMapService.selectWithCondition(ipfRtmTypeBoMap);
        if (ipfRtmTypeBoMaps!=null&&ipfRtmTypeBoMaps.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfRtmTypeBoMapUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfRtmTypeBoMapDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfRtmTypeBoMapSelectRequest request){
        return  true;
     }    
}
