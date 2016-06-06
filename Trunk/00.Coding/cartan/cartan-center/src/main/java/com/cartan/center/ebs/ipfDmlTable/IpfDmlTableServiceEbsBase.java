/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlTable;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlTable.request.*;
import com.cartan.center.ebs.ipfDmlTable.response.*;
import com.cartan.core.ipfDmlTable.domain.IpfDmlTable;
import com.cartan.core.ipfDmlTable.service.IpfDmlTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlTableServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlTableServiceEbs.class.getName());
	private IpfDmlTableService  ipfDmlTableService;
	
    public IpfDmlTableService getIpfDmlTableService() {
        return ipfDmlTableService;
    }

    @Autowired
    public void setIpfDmlTableService(IpfDmlTableService ipfDmlTableService) {
        this.ipfDmlTableService = ipfDmlTableService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlTableGetSessionRequest request) {      
    	IpfDmlTableGetSessionResponse ipfDmlTableGetSessionResponse = new IpfDmlTableGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlTableGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlTableGetSessionResponse.setResultString("1");
            ipfDmlTableGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlTableGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlTableGetSessionRequest request) {
    	IpfDmlTableGetSessionResponse ipfDmlTableGetSessionResponse = new IpfDmlTableGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlTableGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlTableGetSessionResponse.setResultString("0");
        }
        ipfDmlTableGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlTableGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlTableGetSessionRequest request) {
    	IpfDmlTableGetSessionResponse ipfDmlTableGetSessionResponse = new IpfDmlTableGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlTableGetSessionResponse.setResultString("0");
        	ipfDmlTableGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlTableGetSessionResponse.setResultString("1");
        }
        return ipfDmlTableGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.createIpfDmlTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlTable(IpfDmlTableCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlTable ipfDmlTable=new IpfDmlTable();
        ipfDmlTable.setId(request.getId());    		
        ipfDmlTable.setTableName(request.getTableName());
        ipfDmlTable.setTableType(request.getTableType());
        ipfDmlTable.setTableDesc(request.getTableDesc());
    	ipfDmlTableService.createIpfDmlTable(ipfDmlTable);
        //返回响应
        IpfDmlTableCreateResponse ipfDmlTableCreateResponse = new IpfDmlTableCreateResponse();
        ipfDmlTableCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlTableCreateResponse.setResultJson(ipfDmlTable);
        return ipfDmlTableCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.deleteIpfDmlTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlTable(IpfDmlTableDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlTableService.deleteIpfDmlTable(idstr);
        //返回响应
        IpfDmlTableDeleteResponse ipfDmlTableDeleteResponse = new IpfDmlTableDeleteResponse();
        ipfDmlTableDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlTableDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.updateIpfDmlTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlTable(IpfDmlTableUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlTable ipfDmlTable=new IpfDmlTable();
        ipfDmlTable=ipfDmlTableService.getIpfDmlTable(request.getId());
        if (request.getId()!=null){
	        ipfDmlTable.setId(request.getId());
        }
        if (request.getTableName()!=null){
	        ipfDmlTable.setTableName(request.getTableName());
        }
        if (request.getTableType()!=null){
	        ipfDmlTable.setTableType(request.getTableType());
        }
        if (request.getTableDesc()!=null){
	        ipfDmlTable.setTableDesc(request.getTableDesc());
        }
    	ipfDmlTableService.updateIpfDmlTable(ipfDmlTable);
        //返回响应
        IpfDmlTableUpdateResponse ipfDmlTableUpdateResponse = new IpfDmlTableUpdateResponse();
        ipfDmlTableUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlTableUpdateResponse.setResultJson(ipfDmlTable);
        return ipfDmlTableUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.getIpfDmlTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlTable(IpfDmlTableGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlTable ipfDmlTable=new IpfDmlTable();
        ipfDmlTable=ipfDmlTableService.getIpfDmlTable(id);
        //返回响应
        IpfDmlTableGetResponse ipfDmlTableGetResponse = new IpfDmlTableGetResponse();
        ipfDmlTableGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlTableGetResponse.setResultJson(ipfDmlTable);
        return ipfDmlTableGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlTableSelectAllRequest request) {
        IpfDmlTableSelectAllResponse ipfDmlTableSelectAllResponse = new IpfDmlTableSelectAllResponse();
        ipfDmlTableSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlTableSelectAllResponse.setResultJson(ipfDmlTableService.selectAll());
        return ipfDmlTableSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlTableCountAllRequest request) {
        IpfDmlTableCountAllResponse ipfDmlTableCountAllResponse = new IpfDmlTableCountAllResponse();
        ipfDmlTableCountAllResponse.setResultString(String.valueOf(ipfDmlTableService.countAll()));
        ipfDmlTableCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlTableCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlTableSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlTableSelectAllResponse ipfDmlTableSelectAllResponse = new IpfDmlTableSelectAllResponse();
        ipfDmlTableSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlTableSelectAllResponse.setResultJson(ipfDmlTableService.selectBySql(sqlstr));
        return ipfDmlTableSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.selectIpfDmlTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlTableSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlTable_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlTable ipfDmlTable=new IpfDmlTable();
        ipfDmlTable.setId(request.getId());
        ipfDmlTable.setTableName(request.getTableName());
        ipfDmlTable.setTableType(request.getTableType());
        ipfDmlTable.setTableDesc(request.getTableDesc());
    	IpfDmlTableSelectResponse ipfDmlTableSelectResponse = new IpfDmlTableSelectResponse();
        ipfDmlTableSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlTable> ipfDmlTables= ipfDmlTableService.selectWithCondition(ipfDmlTable);
        ipfDmlTableSelectResponse.setResultJson(ipfDmlTables);
        return ipfDmlTableSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlTable.isExistIpfDmlTable", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlTable(IpfDmlTableSelectRequest request) {
        IpfDmlTable ipfDmlTable=new IpfDmlTable();
        ipfDmlTable.setId(request.getId());
        ipfDmlTable.setTableName(request.getTableName());
        ipfDmlTable.setTableType(request.getTableType());
        ipfDmlTable.setTableDesc(request.getTableDesc());
        ArrayList<IpfDmlTable> ipfDmlTables= ipfDmlTableService.selectWithCondition(ipfDmlTable);
    	IpfDmlTableCountAllResponse ipfDmlTableCountAllResponse = new IpfDmlTableCountAllResponse();
        if (ipfDmlTables.size()>0){
        	ipfDmlTableCountAllResponse.setResultString("1");
        } else {
        	ipfDmlTableCountAllResponse.setResultString("0");
        }        
        return ipfDmlTableCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlTableCreateRequest request){
    	IpfDmlTable ipfDmlTable=new IpfDmlTable();
    	ipfDmlTable.setId(request.getId());
        ArrayList<IpfDmlTable> ipfDmlTables= ipfDmlTableService.selectWithCondition(ipfDmlTable);
        if (ipfDmlTables!=null&&ipfDmlTables.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlTableUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlTableDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlTableSelectRequest request){
        return  true;
     }    
}
