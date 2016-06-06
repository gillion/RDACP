/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmConfigAttr;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfRtmConfigAttr.request.*;
import com.cartan.center.ebs.ipfRtmConfigAttr.response.*;
import com.cartan.core.ipfRtmConfigAttr.domain.IpfRtmConfigAttr;
import com.cartan.core.ipfRtmConfigAttr.service.IpfRtmConfigAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfRtmConfigAttrServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfRtmConfigAttrServiceEbs.class.getName());
	private IpfRtmConfigAttrService  ipfRtmConfigAttrService;
	
    public IpfRtmConfigAttrService getIpfRtmConfigAttrService() {
        return ipfRtmConfigAttrService;
    }

    @Autowired
    public void setIpfRtmConfigAttrService(IpfRtmConfigAttrService ipfRtmConfigAttrService) {
        this.ipfRtmConfigAttrService = ipfRtmConfigAttrService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfRtmConfigAttrGetSessionRequest request) {      
    	IpfRtmConfigAttrGetSessionResponse ipfRtmConfigAttrGetSessionResponse = new IpfRtmConfigAttrGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmConfigAttrGetSessionResponse.setResultString("0");
        } else {
        	ipfRtmConfigAttrGetSessionResponse.setResultString("1");
            ipfRtmConfigAttrGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfRtmConfigAttrGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfRtmConfigAttrGetSessionRequest request) {
    	IpfRtmConfigAttrGetSessionResponse ipfRtmConfigAttrGetSessionResponse = new IpfRtmConfigAttrGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfRtmConfigAttrGetSessionResponse.setResultString("1");
        } else {
        	ipfRtmConfigAttrGetSessionResponse.setResultString("0");
        }
        ipfRtmConfigAttrGetSessionResponse.setSessionId(request.getSessionId());
        return ipfRtmConfigAttrGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfRtmConfigAttrGetSessionRequest request) {
    	IpfRtmConfigAttrGetSessionResponse ipfRtmConfigAttrGetSessionResponse = new IpfRtmConfigAttrGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfRtmConfigAttrGetSessionResponse.setResultString("0");
        	ipfRtmConfigAttrGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfRtmConfigAttrGetSessionResponse.setResultString("1");
        }
        return ipfRtmConfigAttrGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.createIpfRtmConfigAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfRtmConfigAttr(IpfRtmConfigAttrCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfRtmConfigAttr_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmConfigAttr ipfRtmConfigAttr=new IpfRtmConfigAttr();
        ipfRtmConfigAttr.setId(request.getId());    		
        ipfRtmConfigAttr.setIpfRtmConfigId(request.getIpfRtmConfigId());
        ipfRtmConfigAttr.setSeqNo(request.getSeqNo());
        ipfRtmConfigAttr.setDisplayLabel(request.getDisplayLabel());
        ipfRtmConfigAttr.setDataType(request.getDataType());
        ipfRtmConfigAttr.setUiType(request.getUiType());
        ipfRtmConfigAttr.setDictTableName(request.getDictTableName());
        ipfRtmConfigAttr.setDictGroupValue(request.getDictGroupValue());
        ipfRtmConfigAttr.setSearchHelp(request.getSearchHelp());
        ipfRtmConfigAttr.setShValueColumn(request.getShValueColumn());
        ipfRtmConfigAttr.setShDisplayColumn(request.getShDisplayColumn());
    	ipfRtmConfigAttrService.createIpfRtmConfigAttr(ipfRtmConfigAttr);
        //返回响应
        IpfRtmConfigAttrCreateResponse ipfRtmConfigAttrCreateResponse = new IpfRtmConfigAttrCreateResponse();
        ipfRtmConfigAttrCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigAttrCreateResponse.setResultJson(ipfRtmConfigAttr);
        return ipfRtmConfigAttrCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.deleteIpfRtmConfigAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfRtmConfigAttr(IpfRtmConfigAttrDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfRtmConfigAttr_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfRtmConfigAttrService.deleteIpfRtmConfigAttr(idstr);
        //返回响应
        IpfRtmConfigAttrDeleteResponse ipfRtmConfigAttrDeleteResponse = new IpfRtmConfigAttrDeleteResponse();
        ipfRtmConfigAttrDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmConfigAttrDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.updateIpfRtmConfigAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfRtmConfigAttr(IpfRtmConfigAttrUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfRtmConfigAttr_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmConfigAttr ipfRtmConfigAttr=new IpfRtmConfigAttr();
        ipfRtmConfigAttr=ipfRtmConfigAttrService.getIpfRtmConfigAttr(request.getId());
        if (request.getId()!=null){
	        ipfRtmConfigAttr.setId(request.getId());
        }
        if (request.getIpfRtmConfigId()!=null){
	        ipfRtmConfigAttr.setIpfRtmConfigId(request.getIpfRtmConfigId());
        }
        if (request.getSeqNo()!=null){
	        ipfRtmConfigAttr.setSeqNo(request.getSeqNo());
        }
        if (request.getDisplayLabel()!=null){
	        ipfRtmConfigAttr.setDisplayLabel(request.getDisplayLabel());
        }
        if (request.getDataType()!=null){
	        ipfRtmConfigAttr.setDataType(request.getDataType());
        }
        if (request.getUiType()!=null){
	        ipfRtmConfigAttr.setUiType(request.getUiType());
        }
        if (request.getDictTableName()!=null){
	        ipfRtmConfigAttr.setDictTableName(request.getDictTableName());
        }
        if (request.getDictGroupValue()!=null){
	        ipfRtmConfigAttr.setDictGroupValue(request.getDictGroupValue());
        }
        if (request.getSearchHelp()!=null){
	        ipfRtmConfigAttr.setSearchHelp(request.getSearchHelp());
        }
        if (request.getShValueColumn()!=null){
	        ipfRtmConfigAttr.setShValueColumn(request.getShValueColumn());
        }
        if (request.getShDisplayColumn()!=null){
	        ipfRtmConfigAttr.setShDisplayColumn(request.getShDisplayColumn());
        }
    	ipfRtmConfigAttrService.updateIpfRtmConfigAttr(ipfRtmConfigAttr);
        //返回响应
        IpfRtmConfigAttrUpdateResponse ipfRtmConfigAttrUpdateResponse = new IpfRtmConfigAttrUpdateResponse();
        ipfRtmConfigAttrUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigAttrUpdateResponse.setResultJson(ipfRtmConfigAttr);
        return ipfRtmConfigAttrUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.getIpfRtmConfigAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfRtmConfigAttr(IpfRtmConfigAttrGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfRtmConfigAttr ipfRtmConfigAttr=new IpfRtmConfigAttr();
        ipfRtmConfigAttr=ipfRtmConfigAttrService.getIpfRtmConfigAttr(id);
        //返回响应
        IpfRtmConfigAttrGetResponse ipfRtmConfigAttrGetResponse = new IpfRtmConfigAttrGetResponse();
        ipfRtmConfigAttrGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigAttrGetResponse.setResultJson(ipfRtmConfigAttr);
        return ipfRtmConfigAttrGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfRtmConfigAttrSelectAllRequest request) {
        IpfRtmConfigAttrSelectAllResponse ipfRtmConfigAttrSelectAllResponse = new IpfRtmConfigAttrSelectAllResponse();
        ipfRtmConfigAttrSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigAttrSelectAllResponse.setResultJson(ipfRtmConfigAttrService.selectAll());
        return ipfRtmConfigAttrSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfRtmConfigAttrCountAllRequest request) {
        IpfRtmConfigAttrCountAllResponse ipfRtmConfigAttrCountAllResponse = new IpfRtmConfigAttrCountAllResponse();
        ipfRtmConfigAttrCountAllResponse.setResultString(String.valueOf(ipfRtmConfigAttrService.countAll()));
        ipfRtmConfigAttrCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfRtmConfigAttrCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfRtmConfigAttrSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfRtmConfigAttrSelectAllResponse ipfRtmConfigAttrSelectAllResponse = new IpfRtmConfigAttrSelectAllResponse();
        ipfRtmConfigAttrSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfRtmConfigAttrSelectAllResponse.setResultJson(ipfRtmConfigAttrService.selectBySql(sqlstr));
        return ipfRtmConfigAttrSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.selectIpfRtmConfigAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfRtmConfigAttrSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfRtmConfigAttr_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfRtmConfigAttr ipfRtmConfigAttr=new IpfRtmConfigAttr();
        ipfRtmConfigAttr.setId(request.getId());
        ipfRtmConfigAttr.setIpfRtmConfigId(request.getIpfRtmConfigId());
        ipfRtmConfigAttr.setSeqNo(request.getSeqNo());
        ipfRtmConfigAttr.setDisplayLabel(request.getDisplayLabel());
        ipfRtmConfigAttr.setDataType(request.getDataType());
        ipfRtmConfigAttr.setUiType(request.getUiType());
        ipfRtmConfigAttr.setDictTableName(request.getDictTableName());
        ipfRtmConfigAttr.setDictGroupValue(request.getDictGroupValue());
        ipfRtmConfigAttr.setSearchHelp(request.getSearchHelp());
        ipfRtmConfigAttr.setShValueColumn(request.getShValueColumn());
        ipfRtmConfigAttr.setShDisplayColumn(request.getShDisplayColumn());
    	IpfRtmConfigAttrSelectResponse ipfRtmConfigAttrSelectResponse = new IpfRtmConfigAttrSelectResponse();
        ipfRtmConfigAttrSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfRtmConfigAttr> ipfRtmConfigAttrs= ipfRtmConfigAttrService.selectWithCondition(ipfRtmConfigAttr);
        ipfRtmConfigAttrSelectResponse.setResultJson(ipfRtmConfigAttrs);
        return ipfRtmConfigAttrSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfRtmConfigAttr.isExistIpfRtmConfigAttr", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfRtmConfigAttr(IpfRtmConfigAttrSelectRequest request) {
        IpfRtmConfigAttr ipfRtmConfigAttr=new IpfRtmConfigAttr();
        ipfRtmConfigAttr.setId(request.getId());
        ipfRtmConfigAttr.setIpfRtmConfigId(request.getIpfRtmConfigId());
        ipfRtmConfigAttr.setSeqNo(request.getSeqNo());
        ipfRtmConfigAttr.setDisplayLabel(request.getDisplayLabel());
        ipfRtmConfigAttr.setDataType(request.getDataType());
        ipfRtmConfigAttr.setUiType(request.getUiType());
        ipfRtmConfigAttr.setDictTableName(request.getDictTableName());
        ipfRtmConfigAttr.setDictGroupValue(request.getDictGroupValue());
        ipfRtmConfigAttr.setSearchHelp(request.getSearchHelp());
        ipfRtmConfigAttr.setShValueColumn(request.getShValueColumn());
        ipfRtmConfigAttr.setShDisplayColumn(request.getShDisplayColumn());
        ArrayList<IpfRtmConfigAttr> ipfRtmConfigAttrs= ipfRtmConfigAttrService.selectWithCondition(ipfRtmConfigAttr);
    	IpfRtmConfigAttrCountAllResponse ipfRtmConfigAttrCountAllResponse = new IpfRtmConfigAttrCountAllResponse();
        if (ipfRtmConfigAttrs.size()>0){
        	ipfRtmConfigAttrCountAllResponse.setResultString("1");
        } else {
        	ipfRtmConfigAttrCountAllResponse.setResultString("0");
        }        
        return ipfRtmConfigAttrCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfRtmConfigAttrCreateRequest request){
    	IpfRtmConfigAttr ipfRtmConfigAttr=new IpfRtmConfigAttr();
    	ipfRtmConfigAttr.setId(request.getId());
        ArrayList<IpfRtmConfigAttr> ipfRtmConfigAttrs= ipfRtmConfigAttrService.selectWithCondition(ipfRtmConfigAttr);
        if (ipfRtmConfigAttrs!=null&&ipfRtmConfigAttrs.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfRtmConfigAttrUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfRtmConfigAttrDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfRtmConfigAttrSelectRequest request){
        return  true;
     }    
}
