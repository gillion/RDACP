/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmDict;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmDict.request.*;
import com.cartan.center.ebs.ipfCcmDict.response.*;
import com.cartan.core.ipfCcmDict.domain.IpfCcmDict;
import com.cartan.core.ipfCcmDict.service.IpfCcmDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmDictServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmDictServiceEbs.class.getName());
	private IpfCcmDictService  ipfCcmDictService;
	
    public IpfCcmDictService getIpfCcmDictService() {
        return ipfCcmDictService;
    }

    @Autowired
    public void setIpfCcmDictService(IpfCcmDictService ipfCcmDictService) {
        this.ipfCcmDictService = ipfCcmDictService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmDictGetSessionRequest request) {      
    	IpfCcmDictGetSessionResponse ipfCcmDictGetSessionResponse = new IpfCcmDictGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmDictGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmDictGetSessionResponse.setResultString("1");
            ipfCcmDictGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmDictGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmDictGetSessionRequest request) {
    	IpfCcmDictGetSessionResponse ipfCcmDictGetSessionResponse = new IpfCcmDictGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmDictGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmDictGetSessionResponse.setResultString("0");
        }
        ipfCcmDictGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmDictGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmDictGetSessionRequest request) {
    	IpfCcmDictGetSessionResponse ipfCcmDictGetSessionResponse = new IpfCcmDictGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmDictGetSessionResponse.setResultString("0");
        	ipfCcmDictGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmDictGetSessionResponse.setResultString("1");
        }
        return ipfCcmDictGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.createIpfCcmDict", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmDict(IpfCcmDictCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmDict_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmDict ipfCcmDict=new IpfCcmDict();
        ipfCcmDict.setId(request.getId());    		
        ipfCcmDict.setDictCode(request.getDictCode());
        ipfCcmDict.setDictName(request.getDictName());
        ipfCcmDict.setDictType(request.getDictType());
        ipfCcmDict.setCodeColumn(request.getCodeColumn());
        ipfCcmDict.setNameColumn(request.getNameColumn());
        ipfCcmDict.setKeyColumn(request.getKeyColumn());
        ipfCcmDict.setTableName(request.getTableName());
        ipfCcmDict.setIsGroup(request.getIsGroup());
        ipfCcmDict.setGroupColumn(request.getGroupColumn());
        ipfCcmDict.setRemark(request.getRemark());
        ipfCcmDict.setOrderColumn(request.getOrderColumn());
        ipfCcmDict.setIsSystem(request.getIsSystem());
        ipfCcmDict.setDataType(request.getDataType());
        ipfCcmDict.setFieldLength(request.getFieldLength());
        ipfCcmDict.setDecimals(request.getDecimals());
    	ipfCcmDictService.createIpfCcmDict(ipfCcmDict);
        //返回响应
        IpfCcmDictCreateResponse ipfCcmDictCreateResponse = new IpfCcmDictCreateResponse();
        ipfCcmDictCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmDictCreateResponse.setResultJson(ipfCcmDict);
        return ipfCcmDictCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.deleteIpfCcmDict", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmDict(IpfCcmDictDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmDict_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmDictService.deleteIpfCcmDict(idstr);
        //返回响应
        IpfCcmDictDeleteResponse ipfCcmDictDeleteResponse = new IpfCcmDictDeleteResponse();
        ipfCcmDictDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmDictDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.updateIpfCcmDict", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmDict(IpfCcmDictUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmDict_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmDict ipfCcmDict=new IpfCcmDict();
        ipfCcmDict=ipfCcmDictService.getIpfCcmDict(request.getId());
        if (request.getId()!=null){
	        ipfCcmDict.setId(request.getId());
        }
        if (request.getDictCode()!=null){
	        ipfCcmDict.setDictCode(request.getDictCode());
        }
        if (request.getDictName()!=null){
	        ipfCcmDict.setDictName(request.getDictName());
        }
        if (request.getDictType()!=null){
	        ipfCcmDict.setDictType(request.getDictType());
        }
        if (request.getCodeColumn()!=null){
	        ipfCcmDict.setCodeColumn(request.getCodeColumn());
        }
        if (request.getNameColumn()!=null){
	        ipfCcmDict.setNameColumn(request.getNameColumn());
        }
        if (request.getKeyColumn()!=null){
	        ipfCcmDict.setKeyColumn(request.getKeyColumn());
        }
        if (request.getTableName()!=null){
	        ipfCcmDict.setTableName(request.getTableName());
        }
        if (request.getIsGroup()!=null){
	        ipfCcmDict.setIsGroup(request.getIsGroup());
        }
        if (request.getGroupColumn()!=null){
	        ipfCcmDict.setGroupColumn(request.getGroupColumn());
        }
        if (request.getRemark()!=null){
	        ipfCcmDict.setRemark(request.getRemark());
        }
        if (request.getOrderColumn()!=null){
	        ipfCcmDict.setOrderColumn(request.getOrderColumn());
        }
        if (request.getIsSystem()!=null){
	        ipfCcmDict.setIsSystem(request.getIsSystem());
        }
        if (request.getDataType()!=null){
	        ipfCcmDict.setDataType(request.getDataType());
        }
        if (request.getFieldLength()!=null){
	        ipfCcmDict.setFieldLength(request.getFieldLength());
        }
        if (request.getDecimals()!=null){
	        ipfCcmDict.setDecimals(request.getDecimals());
        }
    	ipfCcmDictService.updateIpfCcmDict(ipfCcmDict);
        //返回响应
        IpfCcmDictUpdateResponse ipfCcmDictUpdateResponse = new IpfCcmDictUpdateResponse();
        ipfCcmDictUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmDictUpdateResponse.setResultJson(ipfCcmDict);
        return ipfCcmDictUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.getIpfCcmDict", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmDict(IpfCcmDictGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmDict ipfCcmDict=new IpfCcmDict();
        ipfCcmDict=ipfCcmDictService.getIpfCcmDict(id);
        //返回响应
        IpfCcmDictGetResponse ipfCcmDictGetResponse = new IpfCcmDictGetResponse();
        ipfCcmDictGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmDictGetResponse.setResultJson(ipfCcmDict);
        return ipfCcmDictGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmDictSelectAllRequest request) {
        IpfCcmDictSelectAllResponse ipfCcmDictSelectAllResponse = new IpfCcmDictSelectAllResponse();
        ipfCcmDictSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmDictSelectAllResponse.setResultJson(ipfCcmDictService.selectAll());
        return ipfCcmDictSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmDictCountAllRequest request) {
        IpfCcmDictCountAllResponse ipfCcmDictCountAllResponse = new IpfCcmDictCountAllResponse();
        ipfCcmDictCountAllResponse.setResultString(String.valueOf(ipfCcmDictService.countAll()));
        ipfCcmDictCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmDictCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmDictSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmDictSelectAllResponse ipfCcmDictSelectAllResponse = new IpfCcmDictSelectAllResponse();
        ipfCcmDictSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmDictSelectAllResponse.setResultJson(ipfCcmDictService.selectBySql(sqlstr));
        return ipfCcmDictSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.selectIpfCcmDict", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmDictSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmDict_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmDict ipfCcmDict=new IpfCcmDict();
        ipfCcmDict.setId(request.getId());
        ipfCcmDict.setDictCode(request.getDictCode());
        ipfCcmDict.setDictName(request.getDictName());
        ipfCcmDict.setDictType(request.getDictType());
        ipfCcmDict.setCodeColumn(request.getCodeColumn());
        ipfCcmDict.setNameColumn(request.getNameColumn());
        ipfCcmDict.setKeyColumn(request.getKeyColumn());
        ipfCcmDict.setTableName(request.getTableName());
        ipfCcmDict.setIsGroup(request.getIsGroup());
        ipfCcmDict.setGroupColumn(request.getGroupColumn());
        ipfCcmDict.setRemark(request.getRemark());
        ipfCcmDict.setOrderColumn(request.getOrderColumn());
        ipfCcmDict.setIsSystem(request.getIsSystem());
        ipfCcmDict.setDataType(request.getDataType());
        ipfCcmDict.setFieldLength(request.getFieldLength());
        ipfCcmDict.setDecimals(request.getDecimals());
    	IpfCcmDictSelectResponse ipfCcmDictSelectResponse = new IpfCcmDictSelectResponse();
        ipfCcmDictSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmDict> ipfCcmDicts= ipfCcmDictService.selectWithCondition(ipfCcmDict);
        ipfCcmDictSelectResponse.setResultJson(ipfCcmDicts);
        return ipfCcmDictSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmDict.isExistIpfCcmDict", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmDict(IpfCcmDictSelectRequest request) {
        IpfCcmDict ipfCcmDict=new IpfCcmDict();
        ipfCcmDict.setId(request.getId());
        ipfCcmDict.setDictCode(request.getDictCode());
        ipfCcmDict.setDictName(request.getDictName());
        ipfCcmDict.setDictType(request.getDictType());
        ipfCcmDict.setCodeColumn(request.getCodeColumn());
        ipfCcmDict.setNameColumn(request.getNameColumn());
        ipfCcmDict.setKeyColumn(request.getKeyColumn());
        ipfCcmDict.setTableName(request.getTableName());
        ipfCcmDict.setIsGroup(request.getIsGroup());
        ipfCcmDict.setGroupColumn(request.getGroupColumn());
        ipfCcmDict.setRemark(request.getRemark());
        ipfCcmDict.setOrderColumn(request.getOrderColumn());
        ipfCcmDict.setIsSystem(request.getIsSystem());
        ipfCcmDict.setDataType(request.getDataType());
        ipfCcmDict.setFieldLength(request.getFieldLength());
        ipfCcmDict.setDecimals(request.getDecimals());
        ArrayList<IpfCcmDict> ipfCcmDicts= ipfCcmDictService.selectWithCondition(ipfCcmDict);
    	IpfCcmDictCountAllResponse ipfCcmDictCountAllResponse = new IpfCcmDictCountAllResponse();
        if (ipfCcmDicts.size()>0){
        	ipfCcmDictCountAllResponse.setResultString("1");
        } else {
        	ipfCcmDictCountAllResponse.setResultString("0");
        }        
        return ipfCcmDictCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmDictCreateRequest request){
    	IpfCcmDict ipfCcmDict=new IpfCcmDict();
    	ipfCcmDict.setId(request.getId());
        ArrayList<IpfCcmDict> ipfCcmDicts= ipfCcmDictService.selectWithCondition(ipfCcmDict);
        if (ipfCcmDicts!=null&&ipfCcmDicts.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmDictUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmDictDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmDictSelectRequest request){
        return  true;
     }    
}
