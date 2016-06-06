/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlIndex;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlIndex.request.*;
import com.cartan.center.ebs.ipfDmlIndex.response.*;
import com.cartan.core.ipfDmlIndex.domain.IpfDmlIndex;
import com.cartan.core.ipfDmlIndex.service.IpfDmlIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlIndexServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlIndexServiceEbs.class.getName());
	private IpfDmlIndexService  ipfDmlIndexService;
	
    public IpfDmlIndexService getIpfDmlIndexService() {
        return ipfDmlIndexService;
    }

    @Autowired
    public void setIpfDmlIndexService(IpfDmlIndexService ipfDmlIndexService) {
        this.ipfDmlIndexService = ipfDmlIndexService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlIndexGetSessionRequest request) {      
    	IpfDmlIndexGetSessionResponse ipfDmlIndexGetSessionResponse = new IpfDmlIndexGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlIndexGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlIndexGetSessionResponse.setResultString("1");
            ipfDmlIndexGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlIndexGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlIndexGetSessionRequest request) {
    	IpfDmlIndexGetSessionResponse ipfDmlIndexGetSessionResponse = new IpfDmlIndexGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlIndexGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlIndexGetSessionResponse.setResultString("0");
        }
        ipfDmlIndexGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlIndexGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlIndexGetSessionRequest request) {
    	IpfDmlIndexGetSessionResponse ipfDmlIndexGetSessionResponse = new IpfDmlIndexGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlIndexGetSessionResponse.setResultString("0");
        	ipfDmlIndexGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlIndexGetSessionResponse.setResultString("1");
        }
        return ipfDmlIndexGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.createIpfDmlIndex", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlIndex(IpfDmlIndexCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlIndex_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlIndex ipfDmlIndex=new IpfDmlIndex();
        ipfDmlIndex.setId(request.getId());    		
        ipfDmlIndex.setIpfDmlTableId(request.getIpfDmlTableId());
        ipfDmlIndex.setIndexName(request.getIndexName());
        ipfDmlIndex.setIndexType(request.getIndexType());
    	ipfDmlIndexService.createIpfDmlIndex(ipfDmlIndex);
        //返回响应
        IpfDmlIndexCreateResponse ipfDmlIndexCreateResponse = new IpfDmlIndexCreateResponse();
        ipfDmlIndexCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlIndexCreateResponse.setResultJson(ipfDmlIndex);
        return ipfDmlIndexCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.deleteIpfDmlIndex", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlIndex(IpfDmlIndexDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlIndex_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlIndexService.deleteIpfDmlIndex(idstr);
        //返回响应
        IpfDmlIndexDeleteResponse ipfDmlIndexDeleteResponse = new IpfDmlIndexDeleteResponse();
        ipfDmlIndexDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlIndexDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.updateIpfDmlIndex", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlIndex(IpfDmlIndexUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlIndex_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlIndex ipfDmlIndex=new IpfDmlIndex();
        ipfDmlIndex=ipfDmlIndexService.getIpfDmlIndex(request.getId());
        if (request.getId()!=null){
	        ipfDmlIndex.setId(request.getId());
        }
        if (request.getIpfDmlTableId()!=null){
	        ipfDmlIndex.setIpfDmlTableId(request.getIpfDmlTableId());
        }
        if (request.getIndexName()!=null){
	        ipfDmlIndex.setIndexName(request.getIndexName());
        }
        if (request.getIndexType()!=null){
	        ipfDmlIndex.setIndexType(request.getIndexType());
        }
    	ipfDmlIndexService.updateIpfDmlIndex(ipfDmlIndex);
        //返回响应
        IpfDmlIndexUpdateResponse ipfDmlIndexUpdateResponse = new IpfDmlIndexUpdateResponse();
        ipfDmlIndexUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlIndexUpdateResponse.setResultJson(ipfDmlIndex);
        return ipfDmlIndexUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.getIpfDmlIndex", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlIndex(IpfDmlIndexGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlIndex ipfDmlIndex=new IpfDmlIndex();
        ipfDmlIndex=ipfDmlIndexService.getIpfDmlIndex(id);
        //返回响应
        IpfDmlIndexGetResponse ipfDmlIndexGetResponse = new IpfDmlIndexGetResponse();
        ipfDmlIndexGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlIndexGetResponse.setResultJson(ipfDmlIndex);
        return ipfDmlIndexGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlIndexSelectAllRequest request) {
        IpfDmlIndexSelectAllResponse ipfDmlIndexSelectAllResponse = new IpfDmlIndexSelectAllResponse();
        ipfDmlIndexSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlIndexSelectAllResponse.setResultJson(ipfDmlIndexService.selectAll());
        return ipfDmlIndexSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlIndexCountAllRequest request) {
        IpfDmlIndexCountAllResponse ipfDmlIndexCountAllResponse = new IpfDmlIndexCountAllResponse();
        ipfDmlIndexCountAllResponse.setResultString(String.valueOf(ipfDmlIndexService.countAll()));
        ipfDmlIndexCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlIndexCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlIndexSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlIndexSelectAllResponse ipfDmlIndexSelectAllResponse = new IpfDmlIndexSelectAllResponse();
        ipfDmlIndexSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlIndexSelectAllResponse.setResultJson(ipfDmlIndexService.selectBySql(sqlstr));
        return ipfDmlIndexSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.selectIpfDmlIndex", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlIndexSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlIndex_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlIndex ipfDmlIndex=new IpfDmlIndex();
        ipfDmlIndex.setId(request.getId());
        ipfDmlIndex.setIpfDmlTableId(request.getIpfDmlTableId());
        ipfDmlIndex.setIndexName(request.getIndexName());
        ipfDmlIndex.setIndexType(request.getIndexType());
    	IpfDmlIndexSelectResponse ipfDmlIndexSelectResponse = new IpfDmlIndexSelectResponse();
        ipfDmlIndexSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlIndex> ipfDmlIndexs= ipfDmlIndexService.selectWithCondition(ipfDmlIndex);
        ipfDmlIndexSelectResponse.setResultJson(ipfDmlIndexs);
        return ipfDmlIndexSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlIndex.isExistIpfDmlIndex", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlIndex(IpfDmlIndexSelectRequest request) {
        IpfDmlIndex ipfDmlIndex=new IpfDmlIndex();
        ipfDmlIndex.setId(request.getId());
        ipfDmlIndex.setIpfDmlTableId(request.getIpfDmlTableId());
        ipfDmlIndex.setIndexName(request.getIndexName());
        ipfDmlIndex.setIndexType(request.getIndexType());
        ArrayList<IpfDmlIndex> ipfDmlIndexs= ipfDmlIndexService.selectWithCondition(ipfDmlIndex);
    	IpfDmlIndexCountAllResponse ipfDmlIndexCountAllResponse = new IpfDmlIndexCountAllResponse();
        if (ipfDmlIndexs.size()>0){
        	ipfDmlIndexCountAllResponse.setResultString("1");
        } else {
        	ipfDmlIndexCountAllResponse.setResultString("0");
        }        
        return ipfDmlIndexCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlIndexCreateRequest request){
    	IpfDmlIndex ipfDmlIndex=new IpfDmlIndex();
    	ipfDmlIndex.setId(request.getId());
        ArrayList<IpfDmlIndex> ipfDmlIndexs= ipfDmlIndexService.selectWithCondition(ipfDmlIndex);
        if (ipfDmlIndexs!=null&&ipfDmlIndexs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlIndexUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlIndexDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlIndexSelectRequest request){
        return  true;
     }    
}
