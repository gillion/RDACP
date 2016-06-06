/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfPoiSetting;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfPoiSetting.request.*;
import com.cartan.center.ebs.ipfPoiSetting.response.*;
import com.cartan.core.ipfPoiSetting.domain.IpfPoiSetting;
import com.cartan.core.ipfPoiSetting.service.IpfPoiSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfPoiSettingServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfPoiSettingServiceEbs.class.getName());
	private IpfPoiSettingService  ipfPoiSettingService;
	
    public IpfPoiSettingService getIpfPoiSettingService() {
        return ipfPoiSettingService;
    }

    @Autowired
    public void setIpfPoiSettingService(IpfPoiSettingService ipfPoiSettingService) {
        this.ipfPoiSettingService = ipfPoiSettingService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfPoiSettingGetSessionRequest request) {      
    	IpfPoiSettingGetSessionResponse ipfPoiSettingGetSessionResponse = new IpfPoiSettingGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfPoiSettingGetSessionResponse.setResultString("0");
        } else {
        	ipfPoiSettingGetSessionResponse.setResultString("1");
            ipfPoiSettingGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfPoiSettingGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfPoiSettingGetSessionRequest request) {
    	IpfPoiSettingGetSessionResponse ipfPoiSettingGetSessionResponse = new IpfPoiSettingGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfPoiSettingGetSessionResponse.setResultString("1");
        } else {
        	ipfPoiSettingGetSessionResponse.setResultString("0");
        }
        ipfPoiSettingGetSessionResponse.setSessionId(request.getSessionId());
        return ipfPoiSettingGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfPoiSettingGetSessionRequest request) {
    	IpfPoiSettingGetSessionResponse ipfPoiSettingGetSessionResponse = new IpfPoiSettingGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfPoiSettingGetSessionResponse.setResultString("0");
        	ipfPoiSettingGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfPoiSettingGetSessionResponse.setResultString("1");
        }
        return ipfPoiSettingGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.createIpfPoiSetting", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfPoiSetting(IpfPoiSettingCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfPoiSetting_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfPoiSetting ipfPoiSetting=new IpfPoiSetting();
        ipfPoiSetting.setId(request.getId());    		
        ipfPoiSetting.setBoName(request.getBoName());
        ipfPoiSetting.setPoiType(request.getPoiType());
        ipfPoiSetting.setTemplateFileName(request.getTemplateFileName());
        ipfPoiSetting.setTemplateUrl(request.getTemplateUrl());
        ipfPoiSetting.setFileName(request.getFileName());
        ipfPoiSetting.setSourceService(request.getSourceService());
        ipfPoiSetting.setClassName(request.getClassName());
        ipfPoiSetting.setTemplateExtName(request.getTemplateExtName());
        ipfPoiSetting.setRuleNo(request.getRuleNo());
        ipfPoiSetting.setDictName(request.getDictName());
        ipfPoiSetting.setDealService(request.getDealService());
        ipfPoiSetting.setMethodeName(request.getMethodeName());
        ipfPoiSetting.setIsAsync(request.getIsAsync());
        ipfPoiSetting.setAsyncPageSize(request.getAsyncPageSize());
        ipfPoiSetting.setTemplate(request.getTemplate());
        ipfPoiSetting.setTemplateFileKey(request.getTemplateFileKey());
        ipfPoiSetting.setPrimaryColumns(request.getPrimaryColumns());
        ipfPoiSetting.setChildrenTable(request.getChildrenTable());
        ipfPoiSetting.setSortExpress(request.getSortExpress());
        ipfPoiSetting.setAllowParameter(request.getAllowParameter());
        ipfPoiSetting.setIpfDefineColumn(request.getIpfDefineColumn());
    	ipfPoiSettingService.createIpfPoiSetting(ipfPoiSetting);
        //返回响应
        IpfPoiSettingCreateResponse ipfPoiSettingCreateResponse = new IpfPoiSettingCreateResponse();
        ipfPoiSettingCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfPoiSettingCreateResponse.setResultJson(ipfPoiSetting);
        return ipfPoiSettingCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.deleteIpfPoiSetting", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfPoiSetting(IpfPoiSettingDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfPoiSetting_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfPoiSettingService.deleteIpfPoiSetting(idstr);
        //返回响应
        IpfPoiSettingDeleteResponse ipfPoiSettingDeleteResponse = new IpfPoiSettingDeleteResponse();
        ipfPoiSettingDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfPoiSettingDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.updateIpfPoiSetting", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfPoiSetting(IpfPoiSettingUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfPoiSetting_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfPoiSetting ipfPoiSetting=new IpfPoiSetting();
        ipfPoiSetting=ipfPoiSettingService.getIpfPoiSetting(request.getId());
        if (request.getId()!=null){
	        ipfPoiSetting.setId(request.getId());
        }
        if (request.getBoName()!=null){
	        ipfPoiSetting.setBoName(request.getBoName());
        }
        if (request.getPoiType()!=null){
	        ipfPoiSetting.setPoiType(request.getPoiType());
        }
        if (request.getTemplateFileName()!=null){
	        ipfPoiSetting.setTemplateFileName(request.getTemplateFileName());
        }
        if (request.getTemplateUrl()!=null){
	        ipfPoiSetting.setTemplateUrl(request.getTemplateUrl());
        }
        if (request.getFileName()!=null){
	        ipfPoiSetting.setFileName(request.getFileName());
        }
        if (request.getSourceService()!=null){
	        ipfPoiSetting.setSourceService(request.getSourceService());
        }
        if (request.getClassName()!=null){
	        ipfPoiSetting.setClassName(request.getClassName());
        }
        if (request.getTemplateExtName()!=null){
	        ipfPoiSetting.setTemplateExtName(request.getTemplateExtName());
        }
        if (request.getRuleNo()!=null){
	        ipfPoiSetting.setRuleNo(request.getRuleNo());
        }
        if (request.getDictName()!=null){
	        ipfPoiSetting.setDictName(request.getDictName());
        }
        if (request.getDealService()!=null){
	        ipfPoiSetting.setDealService(request.getDealService());
        }
        if (request.getMethodeName()!=null){
	        ipfPoiSetting.setMethodeName(request.getMethodeName());
        }
        if (request.getIsAsync()!=null){
	        ipfPoiSetting.setIsAsync(request.getIsAsync());
        }
        if (request.getAsyncPageSize()!=null){
	        ipfPoiSetting.setAsyncPageSize(request.getAsyncPageSize());
        }
        if (request.getTemplate()!=null){
	        ipfPoiSetting.setTemplate(request.getTemplate());
        }
        if (request.getTemplateFileKey()!=null){
	        ipfPoiSetting.setTemplateFileKey(request.getTemplateFileKey());
        }
        if (request.getPrimaryColumns()!=null){
	        ipfPoiSetting.setPrimaryColumns(request.getPrimaryColumns());
        }
        if (request.getChildrenTable()!=null){
	        ipfPoiSetting.setChildrenTable(request.getChildrenTable());
        }
        if (request.getSortExpress()!=null){
	        ipfPoiSetting.setSortExpress(request.getSortExpress());
        }
        if (request.getAllowParameter()!=null){
	        ipfPoiSetting.setAllowParameter(request.getAllowParameter());
        }
        if (request.getIpfDefineColumn()!=null){
	        ipfPoiSetting.setIpfDefineColumn(request.getIpfDefineColumn());
        }
    	ipfPoiSettingService.updateIpfPoiSetting(ipfPoiSetting);
        //返回响应
        IpfPoiSettingUpdateResponse ipfPoiSettingUpdateResponse = new IpfPoiSettingUpdateResponse();
        ipfPoiSettingUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfPoiSettingUpdateResponse.setResultJson(ipfPoiSetting);
        return ipfPoiSettingUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.getIpfPoiSetting", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfPoiSetting(IpfPoiSettingGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfPoiSetting ipfPoiSetting=new IpfPoiSetting();
        ipfPoiSetting=ipfPoiSettingService.getIpfPoiSetting(id);
        //返回响应
        IpfPoiSettingGetResponse ipfPoiSettingGetResponse = new IpfPoiSettingGetResponse();
        ipfPoiSettingGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfPoiSettingGetResponse.setResultJson(ipfPoiSetting);
        return ipfPoiSettingGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfPoiSettingSelectAllRequest request) {
        IpfPoiSettingSelectAllResponse ipfPoiSettingSelectAllResponse = new IpfPoiSettingSelectAllResponse();
        ipfPoiSettingSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfPoiSettingSelectAllResponse.setResultJson(ipfPoiSettingService.selectAll());
        return ipfPoiSettingSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfPoiSettingCountAllRequest request) {
        IpfPoiSettingCountAllResponse ipfPoiSettingCountAllResponse = new IpfPoiSettingCountAllResponse();
        ipfPoiSettingCountAllResponse.setResultString(String.valueOf(ipfPoiSettingService.countAll()));
        ipfPoiSettingCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfPoiSettingCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfPoiSettingSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfPoiSettingSelectAllResponse ipfPoiSettingSelectAllResponse = new IpfPoiSettingSelectAllResponse();
        ipfPoiSettingSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfPoiSettingSelectAllResponse.setResultJson(ipfPoiSettingService.selectBySql(sqlstr));
        return ipfPoiSettingSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.selectIpfPoiSetting", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfPoiSettingSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfPoiSetting_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfPoiSetting ipfPoiSetting=new IpfPoiSetting();
        ipfPoiSetting.setId(request.getId());
        ipfPoiSetting.setBoName(request.getBoName());
        ipfPoiSetting.setPoiType(request.getPoiType());
        ipfPoiSetting.setTemplateFileName(request.getTemplateFileName());
        ipfPoiSetting.setTemplateUrl(request.getTemplateUrl());
        ipfPoiSetting.setFileName(request.getFileName());
        ipfPoiSetting.setSourceService(request.getSourceService());
        ipfPoiSetting.setClassName(request.getClassName());
        ipfPoiSetting.setTemplateExtName(request.getTemplateExtName());
        ipfPoiSetting.setRuleNo(request.getRuleNo());
        ipfPoiSetting.setDictName(request.getDictName());
        ipfPoiSetting.setDealService(request.getDealService());
        ipfPoiSetting.setMethodeName(request.getMethodeName());
        ipfPoiSetting.setIsAsync(request.getIsAsync());
        ipfPoiSetting.setAsyncPageSize(request.getAsyncPageSize());
        ipfPoiSetting.setTemplate(request.getTemplate());
        ipfPoiSetting.setTemplateFileKey(request.getTemplateFileKey());
        ipfPoiSetting.setPrimaryColumns(request.getPrimaryColumns());
        ipfPoiSetting.setChildrenTable(request.getChildrenTable());
        ipfPoiSetting.setSortExpress(request.getSortExpress());
        ipfPoiSetting.setAllowParameter(request.getAllowParameter());
        ipfPoiSetting.setIpfDefineColumn(request.getIpfDefineColumn());
    	IpfPoiSettingSelectResponse ipfPoiSettingSelectResponse = new IpfPoiSettingSelectResponse();
        ipfPoiSettingSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfPoiSetting> ipfPoiSettings= ipfPoiSettingService.selectWithCondition(ipfPoiSetting);
        ipfPoiSettingSelectResponse.setResultJson(ipfPoiSettings);
        return ipfPoiSettingSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfPoiSetting.isExistIpfPoiSetting", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfPoiSetting(IpfPoiSettingSelectRequest request) {
        IpfPoiSetting ipfPoiSetting=new IpfPoiSetting();
        ipfPoiSetting.setId(request.getId());
        ipfPoiSetting.setBoName(request.getBoName());
        ipfPoiSetting.setPoiType(request.getPoiType());
        ipfPoiSetting.setTemplateFileName(request.getTemplateFileName());
        ipfPoiSetting.setTemplateUrl(request.getTemplateUrl());
        ipfPoiSetting.setFileName(request.getFileName());
        ipfPoiSetting.setSourceService(request.getSourceService());
        ipfPoiSetting.setClassName(request.getClassName());
        ipfPoiSetting.setTemplateExtName(request.getTemplateExtName());
        ipfPoiSetting.setRuleNo(request.getRuleNo());
        ipfPoiSetting.setDictName(request.getDictName());
        ipfPoiSetting.setDealService(request.getDealService());
        ipfPoiSetting.setMethodeName(request.getMethodeName());
        ipfPoiSetting.setIsAsync(request.getIsAsync());
        ipfPoiSetting.setAsyncPageSize(request.getAsyncPageSize());
        ipfPoiSetting.setTemplate(request.getTemplate());
        ipfPoiSetting.setTemplateFileKey(request.getTemplateFileKey());
        ipfPoiSetting.setPrimaryColumns(request.getPrimaryColumns());
        ipfPoiSetting.setChildrenTable(request.getChildrenTable());
        ipfPoiSetting.setSortExpress(request.getSortExpress());
        ipfPoiSetting.setAllowParameter(request.getAllowParameter());
        ipfPoiSetting.setIpfDefineColumn(request.getIpfDefineColumn());
        ArrayList<IpfPoiSetting> ipfPoiSettings= ipfPoiSettingService.selectWithCondition(ipfPoiSetting);
    	IpfPoiSettingCountAllResponse ipfPoiSettingCountAllResponse = new IpfPoiSettingCountAllResponse();
        if (ipfPoiSettings.size()>0){
        	ipfPoiSettingCountAllResponse.setResultString("1");
        } else {
        	ipfPoiSettingCountAllResponse.setResultString("0");
        }        
        return ipfPoiSettingCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfPoiSettingCreateRequest request){
    	IpfPoiSetting ipfPoiSetting=new IpfPoiSetting();
    	ipfPoiSetting.setId(request.getId());
        ArrayList<IpfPoiSetting> ipfPoiSettings= ipfPoiSettingService.selectWithCondition(ipfPoiSetting);
        if (ipfPoiSettings!=null&&ipfPoiSettings.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfPoiSettingUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfPoiSettingDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfPoiSettingSelectRequest request){
        return  true;
     }    
}
