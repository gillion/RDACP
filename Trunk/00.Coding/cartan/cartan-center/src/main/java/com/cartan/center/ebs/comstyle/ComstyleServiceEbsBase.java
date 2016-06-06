/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.comstyle;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.comstyle.request.*;
import com.cartan.center.ebs.comstyle.response.*;
import com.cartan.core.comstyle.domain.Comstyle;
import com.cartan.core.comstyle.service.ComstyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class ComstyleServiceEbsBase {
    static Logger logger = Logger.getLogger(ComstyleServiceEbs.class.getName());
	private ComstyleService  comstyleService;
	
    public ComstyleService getComstyleService() {
        return comstyleService;
    }

    @Autowired
    public void setComstyleService(ComstyleService comstyleService) {
        this.comstyleService = comstyleService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(ComstyleGetSessionRequest request) {      
    	ComstyleGetSessionResponse comstyleGetSessionResponse = new ComstyleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	comstyleGetSessionResponse.setResultString("0");
        } else {
        	comstyleGetSessionResponse.setResultString("1");
            comstyleGetSessionResponse.setSessionId(request.getSessionId());
        }
        return comstyleGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(ComstyleGetSessionRequest request) {
    	ComstyleGetSessionResponse comstyleGetSessionResponse = new ComstyleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            comstyleGetSessionResponse.setResultString("1");
        } else {
        	comstyleGetSessionResponse.setResultString("0");
        }
        comstyleGetSessionResponse.setSessionId(request.getSessionId());
        return comstyleGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(ComstyleGetSessionRequest request) {
    	ComstyleGetSessionResponse comstyleGetSessionResponse = new ComstyleGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	comstyleGetSessionResponse.setResultString("0");
        	comstyleGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            comstyleGetSessionResponse.setResultString("1");
        }
        return comstyleGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.createComstyle", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createComstyle(ComstyleCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_Comstyle_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Comstyle comstyle=new Comstyle();
        comstyle.setId(request.getId());    		
        comstyle.setCode(request.getCode());
        comstyle.setName(request.getName());
    	comstyleService.createComstyle(comstyle);
        //返回响应
        ComstyleCreateResponse comstyleCreateResponse = new ComstyleCreateResponse();
        comstyleCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        comstyleCreateResponse.setResultJson(comstyle);
        return comstyleCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.deleteComstyle", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteComstyle(ComstyleDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_Comstyle_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        comstyleService.deleteComstyle(idstr);
        //返回响应
        ComstyleDeleteResponse comstyleDeleteResponse = new ComstyleDeleteResponse();
        comstyleDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return comstyleDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.updateComstyle", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateComstyle(ComstyleUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_Comstyle_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Comstyle comstyle=new Comstyle();
        comstyle=comstyleService.getComstyle(request.getId());
        if (request.getId()!=null){
	        comstyle.setId(request.getId());
        }
        if (request.getCode()!=null){
	        comstyle.setCode(request.getCode());
        }
        if (request.getName()!=null){
	        comstyle.setName(request.getName());
        }
    	comstyleService.updateComstyle(comstyle);
        //返回响应
        ComstyleUpdateResponse comstyleUpdateResponse = new ComstyleUpdateResponse();
        comstyleUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        comstyleUpdateResponse.setResultJson(comstyle);
        return comstyleUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.getComstyle", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getComstyle(ComstyleGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        Comstyle comstyle=new Comstyle();
        comstyle=comstyleService.getComstyle(id);
        //返回响应
        ComstyleGetResponse comstyleGetResponse = new ComstyleGetResponse();
        comstyleGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        comstyleGetResponse.setResultJson(comstyle);
        return comstyleGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(ComstyleSelectAllRequest request) {
        ComstyleSelectAllResponse comstyleSelectAllResponse = new ComstyleSelectAllResponse();
        comstyleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        comstyleSelectAllResponse.setResultJson(comstyleService.selectAll());
        return comstyleSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(ComstyleCountAllRequest request) {
        ComstyleCountAllResponse comstyleCountAllResponse = new ComstyleCountAllResponse();
        comstyleCountAllResponse.setResultString(String.valueOf(comstyleService.countAll()));
        comstyleCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return comstyleCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(ComstyleSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        ComstyleSelectAllResponse comstyleSelectAllResponse = new ComstyleSelectAllResponse();
        comstyleSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        comstyleSelectAllResponse.setResultJson(comstyleService.selectBySql(sqlstr));
        return comstyleSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.selectComstyle", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(ComstyleSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_Comstyle_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        Comstyle comstyle=new Comstyle();
        comstyle.setId(request.getId());
        comstyle.setCode(request.getCode());
        comstyle.setName(request.getName());
    	ComstyleSelectResponse comstyleSelectResponse = new ComstyleSelectResponse();
        comstyleSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<Comstyle> comstyles= comstyleService.selectWithCondition(comstyle);
        comstyleSelectResponse.setResultJson(comstyles);
        return comstyleSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "comstyle.isExistComstyle", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistComstyle(ComstyleSelectRequest request) {
        Comstyle comstyle=new Comstyle();
        comstyle.setId(request.getId());
        comstyle.setCode(request.getCode());
        comstyle.setName(request.getName());
        ArrayList<Comstyle> comstyles= comstyleService.selectWithCondition(comstyle);
    	ComstyleCountAllResponse comstyleCountAllResponse = new ComstyleCountAllResponse();
        if (comstyles.size()>0){
        	comstyleCountAllResponse.setResultString("1");
        } else {
        	comstyleCountAllResponse.setResultString("0");
        }        
        return comstyleCountAllResponse;
    }

    public Boolean validateCreateRequest(ComstyleCreateRequest request){
    	Comstyle comstyle=new Comstyle();
    	comstyle.setId(request.getId());
        ArrayList<Comstyle> comstyles= comstyleService.selectWithCondition(comstyle);
        if (comstyles!=null&&comstyles.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(ComstyleUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(ComstyleDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(ComstyleSelectRequest request){
        return  true;
     }    
}
