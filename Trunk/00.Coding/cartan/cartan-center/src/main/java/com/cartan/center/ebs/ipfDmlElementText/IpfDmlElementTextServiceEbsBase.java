/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlElementText;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfDmlElementText.request.*;
import com.cartan.center.ebs.ipfDmlElementText.response.*;
import com.cartan.core.ipfDmlElementText.domain.IpfDmlElementText;
import com.cartan.core.ipfDmlElementText.service.IpfDmlElementTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfDmlElementTextServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfDmlElementTextServiceEbs.class.getName());
	private IpfDmlElementTextService  ipfDmlElementTextService;
	
    public IpfDmlElementTextService getIpfDmlElementTextService() {
        return ipfDmlElementTextService;
    }

    @Autowired
    public void setIpfDmlElementTextService(IpfDmlElementTextService ipfDmlElementTextService) {
        this.ipfDmlElementTextService = ipfDmlElementTextService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfDmlElementTextGetSessionRequest request) {      
    	IpfDmlElementTextGetSessionResponse ipfDmlElementTextGetSessionResponse = new IpfDmlElementTextGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlElementTextGetSessionResponse.setResultString("0");
        } else {
        	ipfDmlElementTextGetSessionResponse.setResultString("1");
            ipfDmlElementTextGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfDmlElementTextGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfDmlElementTextGetSessionRequest request) {
    	IpfDmlElementTextGetSessionResponse ipfDmlElementTextGetSessionResponse = new IpfDmlElementTextGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfDmlElementTextGetSessionResponse.setResultString("1");
        } else {
        	ipfDmlElementTextGetSessionResponse.setResultString("0");
        }
        ipfDmlElementTextGetSessionResponse.setSessionId(request.getSessionId());
        return ipfDmlElementTextGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfDmlElementTextGetSessionRequest request) {
    	IpfDmlElementTextGetSessionResponse ipfDmlElementTextGetSessionResponse = new IpfDmlElementTextGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfDmlElementTextGetSessionResponse.setResultString("0");
        	ipfDmlElementTextGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfDmlElementTextGetSessionResponse.setResultString("1");
        }
        return ipfDmlElementTextGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.createIpfDmlElementText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfDmlElementText(IpfDmlElementTextCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfDmlElementText_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlElementText ipfDmlElementText=new IpfDmlElementText();
        ipfDmlElementText.setId(request.getId());    		
        ipfDmlElementText.setIpfDmlElementId(request.getIpfDmlElementId());
        ipfDmlElementText.setDdLanguage(request.getDdLanguage());
        ipfDmlElementText.setDdText(request.getDdText());
    	ipfDmlElementTextService.createIpfDmlElementText(ipfDmlElementText);
        //返回响应
        IpfDmlElementTextCreateResponse ipfDmlElementTextCreateResponse = new IpfDmlElementTextCreateResponse();
        ipfDmlElementTextCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlElementTextCreateResponse.setResultJson(ipfDmlElementText);
        return ipfDmlElementTextCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.deleteIpfDmlElementText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfDmlElementText(IpfDmlElementTextDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfDmlElementText_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfDmlElementTextService.deleteIpfDmlElementText(idstr);
        //返回响应
        IpfDmlElementTextDeleteResponse ipfDmlElementTextDeleteResponse = new IpfDmlElementTextDeleteResponse();
        ipfDmlElementTextDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlElementTextDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.updateIpfDmlElementText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfDmlElementText(IpfDmlElementTextUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfDmlElementText_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlElementText ipfDmlElementText=new IpfDmlElementText();
        ipfDmlElementText=ipfDmlElementTextService.getIpfDmlElementText(request.getId());
        if (request.getId()!=null){
	        ipfDmlElementText.setId(request.getId());
        }
        if (request.getIpfDmlElementId()!=null){
	        ipfDmlElementText.setIpfDmlElementId(request.getIpfDmlElementId());
        }
        if (request.getDdLanguage()!=null){
	        ipfDmlElementText.setDdLanguage(request.getDdLanguage());
        }
        if (request.getDdText()!=null){
	        ipfDmlElementText.setDdText(request.getDdText());
        }
    	ipfDmlElementTextService.updateIpfDmlElementText(ipfDmlElementText);
        //返回响应
        IpfDmlElementTextUpdateResponse ipfDmlElementTextUpdateResponse = new IpfDmlElementTextUpdateResponse();
        ipfDmlElementTextUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlElementTextUpdateResponse.setResultJson(ipfDmlElementText);
        return ipfDmlElementTextUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.getIpfDmlElementText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfDmlElementText(IpfDmlElementTextGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfDmlElementText ipfDmlElementText=new IpfDmlElementText();
        ipfDmlElementText=ipfDmlElementTextService.getIpfDmlElementText(id);
        //返回响应
        IpfDmlElementTextGetResponse ipfDmlElementTextGetResponse = new IpfDmlElementTextGetResponse();
        ipfDmlElementTextGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlElementTextGetResponse.setResultJson(ipfDmlElementText);
        return ipfDmlElementTextGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfDmlElementTextSelectAllRequest request) {
        IpfDmlElementTextSelectAllResponse ipfDmlElementTextSelectAllResponse = new IpfDmlElementTextSelectAllResponse();
        ipfDmlElementTextSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlElementTextSelectAllResponse.setResultJson(ipfDmlElementTextService.selectAll());
        return ipfDmlElementTextSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfDmlElementTextCountAllRequest request) {
        IpfDmlElementTextCountAllResponse ipfDmlElementTextCountAllResponse = new IpfDmlElementTextCountAllResponse();
        ipfDmlElementTextCountAllResponse.setResultString(String.valueOf(ipfDmlElementTextService.countAll()));
        ipfDmlElementTextCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfDmlElementTextCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfDmlElementTextSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfDmlElementTextSelectAllResponse ipfDmlElementTextSelectAllResponse = new IpfDmlElementTextSelectAllResponse();
        ipfDmlElementTextSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfDmlElementTextSelectAllResponse.setResultJson(ipfDmlElementTextService.selectBySql(sqlstr));
        return ipfDmlElementTextSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.selectIpfDmlElementText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfDmlElementTextSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfDmlElementText_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfDmlElementText ipfDmlElementText=new IpfDmlElementText();
        ipfDmlElementText.setId(request.getId());
        ipfDmlElementText.setIpfDmlElementId(request.getIpfDmlElementId());
        ipfDmlElementText.setDdLanguage(request.getDdLanguage());
        ipfDmlElementText.setDdText(request.getDdText());
    	IpfDmlElementTextSelectResponse ipfDmlElementTextSelectResponse = new IpfDmlElementTextSelectResponse();
        ipfDmlElementTextSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfDmlElementText> ipfDmlElementTexts= ipfDmlElementTextService.selectWithCondition(ipfDmlElementText);
        ipfDmlElementTextSelectResponse.setResultJson(ipfDmlElementTexts);
        return ipfDmlElementTextSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfDmlElementText.isExistIpfDmlElementText", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfDmlElementText(IpfDmlElementTextSelectRequest request) {
        IpfDmlElementText ipfDmlElementText=new IpfDmlElementText();
        ipfDmlElementText.setId(request.getId());
        ipfDmlElementText.setIpfDmlElementId(request.getIpfDmlElementId());
        ipfDmlElementText.setDdLanguage(request.getDdLanguage());
        ipfDmlElementText.setDdText(request.getDdText());
        ArrayList<IpfDmlElementText> ipfDmlElementTexts= ipfDmlElementTextService.selectWithCondition(ipfDmlElementText);
    	IpfDmlElementTextCountAllResponse ipfDmlElementTextCountAllResponse = new IpfDmlElementTextCountAllResponse();
        if (ipfDmlElementTexts.size()>0){
        	ipfDmlElementTextCountAllResponse.setResultString("1");
        } else {
        	ipfDmlElementTextCountAllResponse.setResultString("0");
        }        
        return ipfDmlElementTextCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfDmlElementTextCreateRequest request){
    	IpfDmlElementText ipfDmlElementText=new IpfDmlElementText();
    	ipfDmlElementText.setId(request.getId());
        ArrayList<IpfDmlElementText> ipfDmlElementTexts= ipfDmlElementTextService.selectWithCondition(ipfDmlElementText);
        if (ipfDmlElementTexts!=null&&ipfDmlElementTexts.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfDmlElementTextUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfDmlElementTextDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfDmlElementTextSelectRequest request){
        return  true;
     }    
}
