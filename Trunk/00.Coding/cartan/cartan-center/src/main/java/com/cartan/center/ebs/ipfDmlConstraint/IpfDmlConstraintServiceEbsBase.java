/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlConstraint;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlConstraint.request.*;
import com.cartan.center.ebs.ipfDmlConstraint.response.*;
import com.cartan.core.ipfDmlConstraint.domain.IpfDmlConstraint;
import com.cartan.core.ipfDmlConstraint.service.IpfDmlConstraintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlConstraintServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlConstraintServiceEbs.class.getName());
	private IpfDmlConstraintService  ipfDmlConstraintService;
	
    public IpfDmlConstraintService getIpfDmlConstraintService() {
        return ipfDmlConstraintService;
    }

    @Autowired
    public void setIpfDmlConstraintService(IpfDmlConstraintService ipfDmlConstraintService) {
        this.ipfDmlConstraintService = ipfDmlConstraintService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlConstraintGetSessionRequest request) {      
    	IpfDmlConstraintGetSessionResponse ipfDmlConstraintGetSessionResponse = new IpfDmlConstraintGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlConstraintGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlConstraintGetSessionResponse.setResultString("1");
            ipfDmlConstraintGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlConstraintGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlConstraintGetSessionRequest request) {
    	IpfDmlConstraintGetSessionResponse ipfDmlConstraintGetSessionResponse = new IpfDmlConstraintGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlConstraintGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlConstraintGetSessionResponse.setResultString("0");
        }
        ipfDmlConstraintGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlConstraintGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlConstraintGetSessionRequest request) {
    	IpfDmlConstraintGetSessionResponse ipfDmlConstraintGetSessionResponse = new IpfDmlConstraintGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlConstraintGetSessionResponse.setResultString("0");
        	ipfDmlConstraintGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlConstraintGetSessionResponse.setResultString("1");
        }
        return ipfDmlConstraintGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.createIpfDmlConstraint", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlConstraint(IpfDmlConstraintCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlConstraint_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlConstraint ipfDmlConstraint=new IpfDmlConstraint();
        ipfDmlConstraint.setId(request.getId());    		
        ipfDmlConstraint.setIpfDmlTableId(request.getIpfDmlTableId());
        ipfDmlConstraint.setConstraintName(request.getConstraintName());
        ipfDmlConstraint.setConstraintType(request.getConstraintType());
        ipfDmlConstraint.setColumnName(request.getColumnName());
        ipfDmlConstraint.setForeignTableName(request.getForeignTableName());
        ipfDmlConstraint.setForeignColumnName(request.getForeignColumnName());
    	ipfDmlConstraintService.createIpfDmlConstraint(ipfDmlConstraint);
        //返回响应
        IpfDmlConstraintCreateResponse ipfDmlConstraintCreateResponse = new IpfDmlConstraintCreateResponse();
        ipfDmlConstraintCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlConstraintCreateResponse.setResultJson(ipfDmlConstraint);
        return ipfDmlConstraintCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.deleteIpfDmlConstraint", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlConstraint(IpfDmlConstraintDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlConstraint_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlConstraintService.deleteIpfDmlConstraint(idstr);
        //返回响应
        IpfDmlConstraintDeleteResponse ipfDmlConstraintDeleteResponse = new IpfDmlConstraintDeleteResponse();
        ipfDmlConstraintDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlConstraintDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.updateIpfDmlConstraint", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlConstraint(IpfDmlConstraintUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlConstraint_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlConstraint ipfDmlConstraint=new IpfDmlConstraint();
        ipfDmlConstraint=ipfDmlConstraintService.getIpfDmlConstraint(request.getId());
        if (request.getId()!=null){
	        ipfDmlConstraint.setId(request.getId());
        }
        if (request.getIpfDmlTableId()!=null){
	        ipfDmlConstraint.setIpfDmlTableId(request.getIpfDmlTableId());
        }
        if (request.getConstraintName()!=null){
	        ipfDmlConstraint.setConstraintName(request.getConstraintName());
        }
        if (request.getConstraintType()!=null){
	        ipfDmlConstraint.setConstraintType(request.getConstraintType());
        }
        if (request.getColumnName()!=null){
	        ipfDmlConstraint.setColumnName(request.getColumnName());
        }
        if (request.getForeignTableName()!=null){
	        ipfDmlConstraint.setForeignTableName(request.getForeignTableName());
        }
        if (request.getForeignColumnName()!=null){
	        ipfDmlConstraint.setForeignColumnName(request.getForeignColumnName());
        }
    	ipfDmlConstraintService.updateIpfDmlConstraint(ipfDmlConstraint);
        //返回响应
        IpfDmlConstraintUpdateResponse ipfDmlConstraintUpdateResponse = new IpfDmlConstraintUpdateResponse();
        ipfDmlConstraintUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlConstraintUpdateResponse.setResultJson(ipfDmlConstraint);
        return ipfDmlConstraintUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.getIpfDmlConstraint", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlConstraint(IpfDmlConstraintGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlConstraint ipfDmlConstraint=new IpfDmlConstraint();
        ipfDmlConstraint=ipfDmlConstraintService.getIpfDmlConstraint(id);
        //返回响应
        IpfDmlConstraintGetResponse ipfDmlConstraintGetResponse = new IpfDmlConstraintGetResponse();
        ipfDmlConstraintGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlConstraintGetResponse.setResultJson(ipfDmlConstraint);
        return ipfDmlConstraintGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlConstraintSelectAllRequest request) {
        IpfDmlConstraintSelectAllResponse ipfDmlConstraintSelectAllResponse = new IpfDmlConstraintSelectAllResponse();
        ipfDmlConstraintSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlConstraintSelectAllResponse.setResultJson(ipfDmlConstraintService.selectAll());
        return ipfDmlConstraintSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlConstraintCountAllRequest request) {
        IpfDmlConstraintCountAllResponse ipfDmlConstraintCountAllResponse = new IpfDmlConstraintCountAllResponse();
        ipfDmlConstraintCountAllResponse.setResultString(String.valueOf(ipfDmlConstraintService.countAll()));
        ipfDmlConstraintCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlConstraintCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlConstraintSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlConstraintSelectAllResponse ipfDmlConstraintSelectAllResponse = new IpfDmlConstraintSelectAllResponse();
        ipfDmlConstraintSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlConstraintSelectAllResponse.setResultJson(ipfDmlConstraintService.selectBySql(sqlstr));
        return ipfDmlConstraintSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.selectIpfDmlConstraint", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlConstraintSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlConstraint_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlConstraint ipfDmlConstraint=new IpfDmlConstraint();
        ipfDmlConstraint.setId(request.getId());
        ipfDmlConstraint.setIpfDmlTableId(request.getIpfDmlTableId());
        ipfDmlConstraint.setConstraintName(request.getConstraintName());
        ipfDmlConstraint.setConstraintType(request.getConstraintType());
        ipfDmlConstraint.setColumnName(request.getColumnName());
        ipfDmlConstraint.setForeignTableName(request.getForeignTableName());
        ipfDmlConstraint.setForeignColumnName(request.getForeignColumnName());
    	IpfDmlConstraintSelectResponse ipfDmlConstraintSelectResponse = new IpfDmlConstraintSelectResponse();
        ipfDmlConstraintSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlConstraint> ipfDmlConstraints= ipfDmlConstraintService.selectWithCondition(ipfDmlConstraint);
        ipfDmlConstraintSelectResponse.setResultJson(ipfDmlConstraints);
        return ipfDmlConstraintSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlConstraint.isExistIpfDmlConstraint", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlConstraint(IpfDmlConstraintSelectRequest request) {
        IpfDmlConstraint ipfDmlConstraint=new IpfDmlConstraint();
        ipfDmlConstraint.setId(request.getId());
        ipfDmlConstraint.setIpfDmlTableId(request.getIpfDmlTableId());
        ipfDmlConstraint.setConstraintName(request.getConstraintName());
        ipfDmlConstraint.setConstraintType(request.getConstraintType());
        ipfDmlConstraint.setColumnName(request.getColumnName());
        ipfDmlConstraint.setForeignTableName(request.getForeignTableName());
        ipfDmlConstraint.setForeignColumnName(request.getForeignColumnName());
        ArrayList<IpfDmlConstraint> ipfDmlConstraints= ipfDmlConstraintService.selectWithCondition(ipfDmlConstraint);
    	IpfDmlConstraintCountAllResponse ipfDmlConstraintCountAllResponse = new IpfDmlConstraintCountAllResponse();
        if (ipfDmlConstraints.size()>0){
        	ipfDmlConstraintCountAllResponse.setResultString("1");
        } else {
        	ipfDmlConstraintCountAllResponse.setResultString("0");
        }        
        return ipfDmlConstraintCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlConstraintCreateRequest request){
    	IpfDmlConstraint ipfDmlConstraint=new IpfDmlConstraint();
    	ipfDmlConstraint.setId(request.getId());
        ArrayList<IpfDmlConstraint> ipfDmlConstraints= ipfDmlConstraintService.selectWithCondition(ipfDmlConstraint);
        if (ipfDmlConstraints!=null&&ipfDmlConstraints.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlConstraintUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlConstraintDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlConstraintSelectRequest request){
        return  true;
     }    
}
