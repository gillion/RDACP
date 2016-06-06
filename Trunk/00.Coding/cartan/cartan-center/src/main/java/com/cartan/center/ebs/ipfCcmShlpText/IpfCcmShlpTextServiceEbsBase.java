/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmShlpText;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmShlpText.request.*;
import com.cartan.center.ebs.ipfCcmShlpText.response.*;
import com.cartan.core.ipfCcmShlpText.domain.IpfCcmShlpText;
import com.cartan.core.ipfCcmShlpText.service.IpfCcmShlpTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmShlpTextServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmShlpTextServiceEbs.class.getName());
	private IpfCcmShlpTextService  ipfCcmShlpTextService;
	
    public IpfCcmShlpTextService getIpfCcmShlpTextService() {
        return ipfCcmShlpTextService;
    }

    @Autowired
    public void setIpfCcmShlpTextService(IpfCcmShlpTextService ipfCcmShlpTextService) {
        this.ipfCcmShlpTextService = ipfCcmShlpTextService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmShlpTextGetSessionRequest request) {      
    	IpfCcmShlpTextGetSessionResponse ipfCcmShlpTextGetSessionResponse = new IpfCcmShlpTextGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmShlpTextGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmShlpTextGetSessionResponse.setResultString("1");
            ipfCcmShlpTextGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmShlpTextGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmShlpTextGetSessionRequest request) {
    	IpfCcmShlpTextGetSessionResponse ipfCcmShlpTextGetSessionResponse = new IpfCcmShlpTextGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmShlpTextGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmShlpTextGetSessionResponse.setResultString("0");
        }
        ipfCcmShlpTextGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmShlpTextGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmShlpTextGetSessionRequest request) {
    	IpfCcmShlpTextGetSessionResponse ipfCcmShlpTextGetSessionResponse = new IpfCcmShlpTextGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmShlpTextGetSessionResponse.setResultString("0");
        	ipfCcmShlpTextGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmShlpTextGetSessionResponse.setResultString("1");
        }
        return ipfCcmShlpTextGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.createIpfCcmShlpText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmShlpText(IpfCcmShlpTextCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmShlpText_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmShlpText ipfCcmShlpText=new IpfCcmShlpText();
        ipfCcmShlpText.setId(request.getId());    		
        ipfCcmShlpText.setIpfCcmShlpId(request.getIpfCcmShlpId());
        ipfCcmShlpText.setDdLanguage(request.getDdLanguage());
        ipfCcmShlpText.setDdText(request.getDdText());
    	ipfCcmShlpTextService.createIpfCcmShlpText(ipfCcmShlpText);
        //返回响应
        IpfCcmShlpTextCreateResponse ipfCcmShlpTextCreateResponse = new IpfCcmShlpTextCreateResponse();
        ipfCcmShlpTextCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpTextCreateResponse.setResultJson(ipfCcmShlpText);
        return ipfCcmShlpTextCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.deleteIpfCcmShlpText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmShlpText(IpfCcmShlpTextDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmShlpText_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmShlpTextService.deleteIpfCcmShlpText(idstr);
        //返回响应
        IpfCcmShlpTextDeleteResponse ipfCcmShlpTextDeleteResponse = new IpfCcmShlpTextDeleteResponse();
        ipfCcmShlpTextDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmShlpTextDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.updateIpfCcmShlpText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmShlpText(IpfCcmShlpTextUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmShlpText_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmShlpText ipfCcmShlpText=new IpfCcmShlpText();
        ipfCcmShlpText=ipfCcmShlpTextService.getIpfCcmShlpText(request.getId());
        if (request.getId()!=null){
	        ipfCcmShlpText.setId(request.getId());
        }
        if (request.getIpfCcmShlpId()!=null){
	        ipfCcmShlpText.setIpfCcmShlpId(request.getIpfCcmShlpId());
        }
        if (request.getDdLanguage()!=null){
	        ipfCcmShlpText.setDdLanguage(request.getDdLanguage());
        }
        if (request.getDdText()!=null){
	        ipfCcmShlpText.setDdText(request.getDdText());
        }
    	ipfCcmShlpTextService.updateIpfCcmShlpText(ipfCcmShlpText);
        //返回响应
        IpfCcmShlpTextUpdateResponse ipfCcmShlpTextUpdateResponse = new IpfCcmShlpTextUpdateResponse();
        ipfCcmShlpTextUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpTextUpdateResponse.setResultJson(ipfCcmShlpText);
        return ipfCcmShlpTextUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.getIpfCcmShlpText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmShlpText(IpfCcmShlpTextGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmShlpText ipfCcmShlpText=new IpfCcmShlpText();
        ipfCcmShlpText=ipfCcmShlpTextService.getIpfCcmShlpText(id);
        //返回响应
        IpfCcmShlpTextGetResponse ipfCcmShlpTextGetResponse = new IpfCcmShlpTextGetResponse();
        ipfCcmShlpTextGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpTextGetResponse.setResultJson(ipfCcmShlpText);
        return ipfCcmShlpTextGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmShlpTextSelectAllRequest request) {
        IpfCcmShlpTextSelectAllResponse ipfCcmShlpTextSelectAllResponse = new IpfCcmShlpTextSelectAllResponse();
        ipfCcmShlpTextSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpTextSelectAllResponse.setResultJson(ipfCcmShlpTextService.selectAll());
        return ipfCcmShlpTextSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmShlpTextCountAllRequest request) {
        IpfCcmShlpTextCountAllResponse ipfCcmShlpTextCountAllResponse = new IpfCcmShlpTextCountAllResponse();
        ipfCcmShlpTextCountAllResponse.setResultString(String.valueOf(ipfCcmShlpTextService.countAll()));
        ipfCcmShlpTextCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmShlpTextCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmShlpTextSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmShlpTextSelectAllResponse ipfCcmShlpTextSelectAllResponse = new IpfCcmShlpTextSelectAllResponse();
        ipfCcmShlpTextSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmShlpTextSelectAllResponse.setResultJson(ipfCcmShlpTextService.selectBySql(sqlstr));
        return ipfCcmShlpTextSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.selectIpfCcmShlpText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmShlpTextSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmShlpText_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmShlpText ipfCcmShlpText=new IpfCcmShlpText();
        ipfCcmShlpText.setId(request.getId());
        ipfCcmShlpText.setIpfCcmShlpId(request.getIpfCcmShlpId());
        ipfCcmShlpText.setDdLanguage(request.getDdLanguage());
        ipfCcmShlpText.setDdText(request.getDdText());
    	IpfCcmShlpTextSelectResponse ipfCcmShlpTextSelectResponse = new IpfCcmShlpTextSelectResponse();
        ipfCcmShlpTextSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmShlpText> ipfCcmShlpTexts= ipfCcmShlpTextService.selectWithCondition(ipfCcmShlpText);
        ipfCcmShlpTextSelectResponse.setResultJson(ipfCcmShlpTexts);
        return ipfCcmShlpTextSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmShlpText.isExistIpfCcmShlpText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmShlpText(IpfCcmShlpTextSelectRequest request) {
        IpfCcmShlpText ipfCcmShlpText=new IpfCcmShlpText();
        ipfCcmShlpText.setId(request.getId());
        ipfCcmShlpText.setIpfCcmShlpId(request.getIpfCcmShlpId());
        ipfCcmShlpText.setDdLanguage(request.getDdLanguage());
        ipfCcmShlpText.setDdText(request.getDdText());
        ArrayList<IpfCcmShlpText> ipfCcmShlpTexts= ipfCcmShlpTextService.selectWithCondition(ipfCcmShlpText);
    	IpfCcmShlpTextCountAllResponse ipfCcmShlpTextCountAllResponse = new IpfCcmShlpTextCountAllResponse();
        if (ipfCcmShlpTexts.size()>0){
        	ipfCcmShlpTextCountAllResponse.setResultString("1");
        } else {
        	ipfCcmShlpTextCountAllResponse.setResultString("0");
        }        
        return ipfCcmShlpTextCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmShlpTextCreateRequest request){
    	IpfCcmShlpText ipfCcmShlpText=new IpfCcmShlpText();
    	ipfCcmShlpText.setId(request.getId());
        ArrayList<IpfCcmShlpText> ipfCcmShlpTexts= ipfCcmShlpTextService.selectWithCondition(ipfCcmShlpText);
        if (ipfCcmShlpTexts!=null&&ipfCcmShlpTexts.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmShlpTextUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmShlpTextDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmShlpTextSelectRequest request){
        return  true;
     }    
}
