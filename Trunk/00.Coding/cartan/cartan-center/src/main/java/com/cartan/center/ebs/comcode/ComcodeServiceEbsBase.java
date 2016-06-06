/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.comcode;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.comcode.request.*;
import com.cartan.center.ebs.comcode.response.*;
import com.cartan.core.comcode.domain.Comcode;
import com.cartan.core.comcode.service.ComcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class ComcodeServiceEbsBase {
    static Logger logger = Logger.getLogger(ComcodeServiceEbs.class.getName());
	private ComcodeService  comcodeService;
	
    public ComcodeService getComcodeService() {
        return comcodeService;
    }

    @Autowired
    public void setComcodeService(ComcodeService comcodeService) {
        this.comcodeService = comcodeService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(ComcodeGetSessionRequest request) {      
    	ComcodeGetSessionResponse comcodeGetSessionResponse = new ComcodeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	comcodeGetSessionResponse.setResultString("0");
        } else {
        	comcodeGetSessionResponse.setResultString("1");
            comcodeGetSessionResponse.setSessionId(request.getSessionId());
        }
        return comcodeGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(ComcodeGetSessionRequest request) {
    	ComcodeGetSessionResponse comcodeGetSessionResponse = new ComcodeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            comcodeGetSessionResponse.setResultString("1");
        } else {
        	comcodeGetSessionResponse.setResultString("0");
        }
        comcodeGetSessionResponse.setSessionId(request.getSessionId());
        return comcodeGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(ComcodeGetSessionRequest request) {
    	ComcodeGetSessionResponse comcodeGetSessionResponse = new ComcodeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	comcodeGetSessionResponse.setResultString("0");
        	comcodeGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            comcodeGetSessionResponse.setResultString("1");
        }
        return comcodeGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.createComcode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createComcode(ComcodeCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_Comcode_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Comcode comcode=new Comcode();
        comcode.setId(request.getId());    		
        comcode.setTypecode(request.getTypecode());
        comcode.setCode(request.getCode());
        comcode.setName(request.getName());
        comcode.setShortname(request.getShortname());
    	comcodeService.createComcode(comcode);
        //返回响应
        ComcodeCreateResponse comcodeCreateResponse = new ComcodeCreateResponse();
        comcodeCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        comcodeCreateResponse.setResultJson(comcode);
        return comcodeCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.deleteComcode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteComcode(ComcodeDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_Comcode_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        comcodeService.deleteComcode(idstr);
        //返回响应
        ComcodeDeleteResponse comcodeDeleteResponse = new ComcodeDeleteResponse();
        comcodeDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return comcodeDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.updateComcode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateComcode(ComcodeUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_Comcode_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Comcode comcode=new Comcode();
        comcode=comcodeService.getComcode(request.getId());
        if (request.getId()!=null){
	        comcode.setId(request.getId());
        }
        if (request.getTypecode()!=null){
	        comcode.setTypecode(request.getTypecode());
        }
        if (request.getCode()!=null){
	        comcode.setCode(request.getCode());
        }
        if (request.getName()!=null){
	        comcode.setName(request.getName());
        }
        if (request.getShortname()!=null){
	        comcode.setShortname(request.getShortname());
        }
    	comcodeService.updateComcode(comcode);
        //返回响应
        ComcodeUpdateResponse comcodeUpdateResponse = new ComcodeUpdateResponse();
        comcodeUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        comcodeUpdateResponse.setResultJson(comcode);
        return comcodeUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.getComcode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getComcode(ComcodeGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        Comcode comcode=new Comcode();
        comcode=comcodeService.getComcode(id);
        //返回响应
        ComcodeGetResponse comcodeGetResponse = new ComcodeGetResponse();
        comcodeGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        comcodeGetResponse.setResultJson(comcode);
        return comcodeGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(ComcodeSelectAllRequest request) {
        ComcodeSelectAllResponse comcodeSelectAllResponse = new ComcodeSelectAllResponse();
        comcodeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        comcodeSelectAllResponse.setResultJson(comcodeService.selectAll());
        return comcodeSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(ComcodeCountAllRequest request) {
        ComcodeCountAllResponse comcodeCountAllResponse = new ComcodeCountAllResponse();
        comcodeCountAllResponse.setResultString(String.valueOf(comcodeService.countAll()));
        comcodeCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return comcodeCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(ComcodeSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        ComcodeSelectAllResponse comcodeSelectAllResponse = new ComcodeSelectAllResponse();
        comcodeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        comcodeSelectAllResponse.setResultJson(comcodeService.selectBySql(sqlstr));
        return comcodeSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.selectComcode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(ComcodeSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_Comcode_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Comcode comcode=new Comcode();
        comcode.setId(request.getId());
        comcode.setTypecode(request.getTypecode());
        comcode.setCode(request.getCode());
        comcode.setName(request.getName());
        comcode.setShortname(request.getShortname());
    	ComcodeSelectResponse comcodeSelectResponse = new ComcodeSelectResponse();
        comcodeSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<Comcode> comcodes= comcodeService.selectWithCondition(comcode);
        comcodeSelectResponse.setResultJson(comcodes);
        return comcodeSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comcode.isExistComcode", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistComcode(ComcodeSelectRequest request) {
        Comcode comcode=new Comcode();
        comcode.setId(request.getId());
        comcode.setTypecode(request.getTypecode());
        comcode.setCode(request.getCode());
        comcode.setName(request.getName());
        comcode.setShortname(request.getShortname());
        ArrayList<Comcode> comcodes= comcodeService.selectWithCondition(comcode);
    	ComcodeCountAllResponse comcodeCountAllResponse = new ComcodeCountAllResponse();
        if (comcodes.size()>0){
        	comcodeCountAllResponse.setResultString("1");
        } else {
        	comcodeCountAllResponse.setResultString("0");
        }        
        return comcodeCountAllResponse;
    }

    public Boolean validateCreateRequest(ComcodeCreateRequest request){
    	Comcode comcode=new Comcode();
    	comcode.setId(request.getId());
        ArrayList<Comcode> comcodes= comcodeService.selectWithCondition(comcode);
        if (comcodes!=null&&comcodes.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(ComcodeUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(ComcodeDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(ComcodeSelectRequest request){
        return  true;
     }    
}
