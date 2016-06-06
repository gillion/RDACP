/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBo;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBo.request.*;
import com.cartan.center.ebs.ipfCcmBo.response.*;
import com.cartan.core.ipfCcmBo.domain.IpfCcmBo;
import com.cartan.core.ipfCcmBo.service.IpfCcmBoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoServiceEbs.class.getName());
	private IpfCcmBoService  ipfCcmBoService;
	
    public IpfCcmBoService getIpfCcmBoService() {
        return ipfCcmBoService;
    }

    @Autowired
    public void setIpfCcmBoService(IpfCcmBoService ipfCcmBoService) {
        this.ipfCcmBoService = ipfCcmBoService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoGetSessionRequest request) {      
    	IpfCcmBoGetSessionResponse ipfCcmBoGetSessionResponse = new IpfCcmBoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoGetSessionResponse.setResultString("1");
            ipfCcmBoGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoGetSessionRequest request) {
    	IpfCcmBoGetSessionResponse ipfCcmBoGetSessionResponse = new IpfCcmBoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoGetSessionResponse.setResultString("0");
        }
        ipfCcmBoGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoGetSessionRequest request) {
    	IpfCcmBoGetSessionResponse ipfCcmBoGetSessionResponse = new IpfCcmBoGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoGetSessionResponse.setResultString("0");
        	ipfCcmBoGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.createIpfCcmBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBo(IpfCcmBoCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBo ipfCcmBo=new IpfCcmBo();
        ipfCcmBo.setId(request.getId());    		
        ipfCcmBo.setBoName(request.getBoName());
        ipfCcmBo.setBoType(request.getBoType());
        ipfCcmBo.setAppModule(request.getAppModule());
        ipfCcmBo.setServiceType(request.getServiceType());
        ipfCcmBo.setJavaPath(request.getJavaPath());
        ipfCcmBo.setServiceCategory(request.getServiceCategory());
        ipfCcmBo.setTableName(request.getTableName());
        ipfCcmBo.setTableType(request.getTableType());
        ipfCcmBo.setDescription(request.getDescription());
        ipfCcmBo.setSearchColumns(request.getSearchColumns());
        ipfCcmBo.setSearchMode(request.getSearchMode());
        ipfCcmBo.setPageSize(request.getPageSize());
        ipfCcmBo.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        ipfCcmBo.setUiLayoutName(request.getUiLayoutName());
        ipfCcmBo.setFormCellMode(request.getFormCellMode());
        ipfCcmBo.setUiTemplate(request.getUiTemplate());
        ipfCcmBo.setFormColumns(request.getFormColumns());
        ipfCcmBo.setGridStyle(request.getGridStyle());
        ipfCcmBo.setGridAlign(request.getGridAlign());
        ipfCcmBo.setGridEditType(request.getGridEditType());
        ipfCcmBo.setGenerateOption(request.getGenerateOption());
        ipfCcmBo.setLockRowExpress(request.getLockRowExpress());
        ipfCcmBo.setGridType(request.getGridType());
        ipfCcmBo.setIsMainObject(request.getIsMainObject());
        ipfCcmBo.setIsInitDataBo(request.getIsInitDataBo());
        ipfCcmBo.setIsAutoLoad(request.getIsAutoLoad());
        ipfCcmBo.setIsNeedAdvSearch(request.getIsNeedAdvSearch());
        ipfCcmBo.setNeedPaging(request.getNeedPaging());
        ipfCcmBo.setIsGridFilter(request.getIsGridFilter());
        ipfCcmBo.setIsGridCustom(request.getIsGridCustom());
        ipfCcmBo.setRemark(request.getRemark());
        ipfCcmBo.setWhereClause(request.getWhereClause());
        ipfCcmBo.setIdGenerator(request.getIdGenerator());
    	ipfCcmBoService.createIpfCcmBo(ipfCcmBo);
        //返回响应
        IpfCcmBoCreateResponse ipfCcmBoCreateResponse = new IpfCcmBoCreateResponse();
        ipfCcmBoCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoCreateResponse.setResultJson(ipfCcmBo);
        return ipfCcmBoCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.deleteIpfCcmBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBo(IpfCcmBoDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoService.deleteIpfCcmBo(idstr);
        //返回响应
        IpfCcmBoDeleteResponse ipfCcmBoDeleteResponse = new IpfCcmBoDeleteResponse();
        ipfCcmBoDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.updateIpfCcmBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBo(IpfCcmBoUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBo ipfCcmBo=new IpfCcmBo();
        ipfCcmBo=ipfCcmBoService.getIpfCcmBo(request.getId());
        if (request.getId()!=null){
	        ipfCcmBo.setId(request.getId());
        }
        if (request.getBoName()!=null){
	        ipfCcmBo.setBoName(request.getBoName());
        }
        if (request.getBoType()!=null){
	        ipfCcmBo.setBoType(request.getBoType());
        }
        if (request.getAppModule()!=null){
	        ipfCcmBo.setAppModule(request.getAppModule());
        }
        if (request.getServiceType()!=null){
	        ipfCcmBo.setServiceType(request.getServiceType());
        }
        if (request.getJavaPath()!=null){
	        ipfCcmBo.setJavaPath(request.getJavaPath());
        }
        if (request.getServiceCategory()!=null){
	        ipfCcmBo.setServiceCategory(request.getServiceCategory());
        }
        if (request.getTableName()!=null){
	        ipfCcmBo.setTableName(request.getTableName());
        }
        if (request.getTableType()!=null){
	        ipfCcmBo.setTableType(request.getTableType());
        }
        if (request.getDescription()!=null){
	        ipfCcmBo.setDescription(request.getDescription());
        }
        if (request.getSearchColumns()!=null){
	        ipfCcmBo.setSearchColumns(request.getSearchColumns());
        }
        if (request.getSearchMode()!=null){
	        ipfCcmBo.setSearchMode(request.getSearchMode());
        }
        if (request.getPageSize()!=null){
	        ipfCcmBo.setPageSize(request.getPageSize());
        }
        if (request.getIpfCcmUiLayoutId()!=null){
	        ipfCcmBo.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        }
        if (request.getUiLayoutName()!=null){
	        ipfCcmBo.setUiLayoutName(request.getUiLayoutName());
        }
        if (request.getFormCellMode()!=null){
	        ipfCcmBo.setFormCellMode(request.getFormCellMode());
        }
        if (request.getUiTemplate()!=null){
	        ipfCcmBo.setUiTemplate(request.getUiTemplate());
        }
        if (request.getFormColumns()!=null){
	        ipfCcmBo.setFormColumns(request.getFormColumns());
        }
        if (request.getGridStyle()!=null){
	        ipfCcmBo.setGridStyle(request.getGridStyle());
        }
        if (request.getGridAlign()!=null){
	        ipfCcmBo.setGridAlign(request.getGridAlign());
        }
        if (request.getGridEditType()!=null){
	        ipfCcmBo.setGridEditType(request.getGridEditType());
        }
        if (request.getGenerateOption()!=null){
	        ipfCcmBo.setGenerateOption(request.getGenerateOption());
        }
        if (request.getLockRowExpress()!=null){
	        ipfCcmBo.setLockRowExpress(request.getLockRowExpress());
        }
        if (request.getGridType()!=null){
	        ipfCcmBo.setGridType(request.getGridType());
        }
        if (request.getIsMainObject()!=null){
	        ipfCcmBo.setIsMainObject(request.getIsMainObject());
        }
        if (request.getIsInitDataBo()!=null){
	        ipfCcmBo.setIsInitDataBo(request.getIsInitDataBo());
        }
        if (request.getIsAutoLoad()!=null){
	        ipfCcmBo.setIsAutoLoad(request.getIsAutoLoad());
        }
        if (request.getIsNeedAdvSearch()!=null){
	        ipfCcmBo.setIsNeedAdvSearch(request.getIsNeedAdvSearch());
        }
        if (request.getNeedPaging()!=null){
	        ipfCcmBo.setNeedPaging(request.getNeedPaging());
        }
        if (request.getIsGridFilter()!=null){
	        ipfCcmBo.setIsGridFilter(request.getIsGridFilter());
        }
        if (request.getIsGridCustom()!=null){
	        ipfCcmBo.setIsGridCustom(request.getIsGridCustom());
        }
        if (request.getRemark()!=null){
	        ipfCcmBo.setRemark(request.getRemark());
        }
        if (request.getWhereClause()!=null){
	        ipfCcmBo.setWhereClause(request.getWhereClause());
        }
        if (request.getIdGenerator()!=null){
	        ipfCcmBo.setIdGenerator(request.getIdGenerator());
        }
    	ipfCcmBoService.updateIpfCcmBo(ipfCcmBo);
        //返回响应
        IpfCcmBoUpdateResponse ipfCcmBoUpdateResponse = new IpfCcmBoUpdateResponse();
        ipfCcmBoUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoUpdateResponse.setResultJson(ipfCcmBo);
        return ipfCcmBoUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.getIpfCcmBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBo(IpfCcmBoGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBo ipfCcmBo=new IpfCcmBo();
        ipfCcmBo=ipfCcmBoService.getIpfCcmBo(id);
        //返回响应
        IpfCcmBoGetResponse ipfCcmBoGetResponse = new IpfCcmBoGetResponse();
        ipfCcmBoGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoGetResponse.setResultJson(ipfCcmBo);
        return ipfCcmBoGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoSelectAllRequest request) {
        IpfCcmBoSelectAllResponse ipfCcmBoSelectAllResponse = new IpfCcmBoSelectAllResponse();
        ipfCcmBoSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoSelectAllResponse.setResultJson(ipfCcmBoService.selectAll());
        return ipfCcmBoSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoCountAllRequest request) {
        IpfCcmBoCountAllResponse ipfCcmBoCountAllResponse = new IpfCcmBoCountAllResponse();
        ipfCcmBoCountAllResponse.setResultString(String.valueOf(ipfCcmBoService.countAll()));
        ipfCcmBoCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoSelectAllResponse ipfCcmBoSelectAllResponse = new IpfCcmBoSelectAllResponse();
        ipfCcmBoSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoSelectAllResponse.setResultJson(ipfCcmBoService.selectBySql(sqlstr));
        return ipfCcmBoSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.selectIpfCcmBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBo_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBo ipfCcmBo=new IpfCcmBo();
        ipfCcmBo.setId(request.getId());
        ipfCcmBo.setBoName(request.getBoName());
        ipfCcmBo.setBoType(request.getBoType());
        ipfCcmBo.setAppModule(request.getAppModule());
        ipfCcmBo.setServiceType(request.getServiceType());
        ipfCcmBo.setJavaPath(request.getJavaPath());
        ipfCcmBo.setServiceCategory(request.getServiceCategory());
        ipfCcmBo.setTableName(request.getTableName());
        ipfCcmBo.setTableType(request.getTableType());
        ipfCcmBo.setDescription(request.getDescription());
        ipfCcmBo.setSearchColumns(request.getSearchColumns());
        ipfCcmBo.setSearchMode(request.getSearchMode());
        ipfCcmBo.setPageSize(request.getPageSize());
        ipfCcmBo.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        ipfCcmBo.setUiLayoutName(request.getUiLayoutName());
        ipfCcmBo.setFormCellMode(request.getFormCellMode());
        ipfCcmBo.setUiTemplate(request.getUiTemplate());
        ipfCcmBo.setFormColumns(request.getFormColumns());
        ipfCcmBo.setGridStyle(request.getGridStyle());
        ipfCcmBo.setGridAlign(request.getGridAlign());
        ipfCcmBo.setGridEditType(request.getGridEditType());
        ipfCcmBo.setGenerateOption(request.getGenerateOption());
        ipfCcmBo.setLockRowExpress(request.getLockRowExpress());
        ipfCcmBo.setGridType(request.getGridType());
        ipfCcmBo.setIsMainObject(request.getIsMainObject());
        ipfCcmBo.setIsInitDataBo(request.getIsInitDataBo());
        ipfCcmBo.setIsAutoLoad(request.getIsAutoLoad());
        ipfCcmBo.setIsNeedAdvSearch(request.getIsNeedAdvSearch());
        ipfCcmBo.setNeedPaging(request.getNeedPaging());
        ipfCcmBo.setIsGridFilter(request.getIsGridFilter());
        ipfCcmBo.setIsGridCustom(request.getIsGridCustom());
        ipfCcmBo.setRemark(request.getRemark());
        ipfCcmBo.setWhereClause(request.getWhereClause());
        ipfCcmBo.setIdGenerator(request.getIdGenerator());
    	IpfCcmBoSelectResponse ipfCcmBoSelectResponse = new IpfCcmBoSelectResponse();
        ipfCcmBoSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBo> ipfCcmBos= ipfCcmBoService.selectWithCondition(ipfCcmBo);
        ipfCcmBoSelectResponse.setResultJson(ipfCcmBos);
        return ipfCcmBoSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBo.isExistIpfCcmBo", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBo(IpfCcmBoSelectRequest request) {
        IpfCcmBo ipfCcmBo=new IpfCcmBo();
        ipfCcmBo.setId(request.getId());
        ipfCcmBo.setBoName(request.getBoName());
        ipfCcmBo.setBoType(request.getBoType());
        ipfCcmBo.setAppModule(request.getAppModule());
        ipfCcmBo.setServiceType(request.getServiceType());
        ipfCcmBo.setJavaPath(request.getJavaPath());
        ipfCcmBo.setServiceCategory(request.getServiceCategory());
        ipfCcmBo.setTableName(request.getTableName());
        ipfCcmBo.setTableType(request.getTableType());
        ipfCcmBo.setDescription(request.getDescription());
        ipfCcmBo.setSearchColumns(request.getSearchColumns());
        ipfCcmBo.setSearchMode(request.getSearchMode());
        ipfCcmBo.setPageSize(request.getPageSize());
        ipfCcmBo.setIpfCcmUiLayoutId(request.getIpfCcmUiLayoutId());
        ipfCcmBo.setUiLayoutName(request.getUiLayoutName());
        ipfCcmBo.setFormCellMode(request.getFormCellMode());
        ipfCcmBo.setUiTemplate(request.getUiTemplate());
        ipfCcmBo.setFormColumns(request.getFormColumns());
        ipfCcmBo.setGridStyle(request.getGridStyle());
        ipfCcmBo.setGridAlign(request.getGridAlign());
        ipfCcmBo.setGridEditType(request.getGridEditType());
        ipfCcmBo.setGenerateOption(request.getGenerateOption());
        ipfCcmBo.setLockRowExpress(request.getLockRowExpress());
        ipfCcmBo.setGridType(request.getGridType());
        ipfCcmBo.setIsMainObject(request.getIsMainObject());
        ipfCcmBo.setIsInitDataBo(request.getIsInitDataBo());
        ipfCcmBo.setIsAutoLoad(request.getIsAutoLoad());
        ipfCcmBo.setIsNeedAdvSearch(request.getIsNeedAdvSearch());
        ipfCcmBo.setNeedPaging(request.getNeedPaging());
        ipfCcmBo.setIsGridFilter(request.getIsGridFilter());
        ipfCcmBo.setIsGridCustom(request.getIsGridCustom());
        ipfCcmBo.setRemark(request.getRemark());
        ipfCcmBo.setWhereClause(request.getWhereClause());
        ipfCcmBo.setIdGenerator(request.getIdGenerator());
        ArrayList<IpfCcmBo> ipfCcmBos= ipfCcmBoService.selectWithCondition(ipfCcmBo);
    	IpfCcmBoCountAllResponse ipfCcmBoCountAllResponse = new IpfCcmBoCountAllResponse();
        if (ipfCcmBos.size()>0){
        	ipfCcmBoCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoCreateRequest request){
    	IpfCcmBo ipfCcmBo=new IpfCcmBo();
    	ipfCcmBo.setId(request.getId());
        ArrayList<IpfCcmBo> ipfCcmBos= ipfCcmBoService.selectWithCondition(ipfCcmBo);
        if (ipfCcmBos!=null&&ipfCcmBos.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoSelectRequest request){
        return  true;
     }    
}
