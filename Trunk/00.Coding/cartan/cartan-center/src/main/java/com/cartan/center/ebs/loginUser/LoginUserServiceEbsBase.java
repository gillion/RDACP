/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.loginUser;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.loginUser.request.*;
import com.cartan.center.ebs.loginUser.response.*;
import com.cartan.core.loginUser.domain.LoginUser;
import com.cartan.core.loginUser.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class LoginUserServiceEbsBase {
    static Logger logger = Logger.getLogger(LoginUserServiceEbs.class.getName());
	private LoginUserService  loginUserService;
	
    public LoginUserService getLoginUserService() {
        return loginUserService;
    }

    @Autowired
    public void setLoginUserService(LoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(LoginUserGetSessionRequest request) {      
    	LoginUserGetSessionResponse loginUserGetSessionResponse = new LoginUserGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	loginUserGetSessionResponse.setResultString("0");
        } else {
        	loginUserGetSessionResponse.setResultString("1");
            loginUserGetSessionResponse.setSessionId(request.getSessionId());
        }
        return loginUserGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(LoginUserGetSessionRequest request) {
    	LoginUserGetSessionResponse loginUserGetSessionResponse = new LoginUserGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            loginUserGetSessionResponse.setResultString("1");
        } else {
        	loginUserGetSessionResponse.setResultString("0");
        }
        loginUserGetSessionResponse.setSessionId(request.getSessionId());
        return loginUserGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(LoginUserGetSessionRequest request) {
    	LoginUserGetSessionResponse loginUserGetSessionResponse = new LoginUserGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	loginUserGetSessionResponse.setResultString("0");
        	loginUserGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            loginUserGetSessionResponse.setResultString("1");
        }
        return loginUserGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.createLoginUser", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createLoginUser(LoginUserCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_LoginUser_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        LoginUser loginUser=new LoginUser();
        loginUser.setId(request.getId());    		
        loginUser.setUser(request.getUser());
        loginUser.setPwd(request.getPwd());
        loginUser.setPower(request.getPower());
    	loginUserService.createLoginUser(loginUser);
        //返回响应
        LoginUserCreateResponse loginUserCreateResponse = new LoginUserCreateResponse();
        loginUserCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        loginUserCreateResponse.setResultJson(loginUser);
        return loginUserCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.deleteLoginUser", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteLoginUser(LoginUserDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_LoginUser_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        loginUserService.deleteLoginUser(idstr);
        //返回响应
        LoginUserDeleteResponse loginUserDeleteResponse = new LoginUserDeleteResponse();
        loginUserDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return loginUserDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.updateLoginUser", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateLoginUser(LoginUserUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_LoginUser_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        LoginUser loginUser=new LoginUser();
        loginUser=loginUserService.getLoginUser(request.getId());
        if (request.getId()!=null){
	        loginUser.setId(request.getId());
        }
        if (request.getUser()!=null){
	        loginUser.setUser(request.getUser());
        }
        if (request.getPwd()!=null){
	        loginUser.setPwd(request.getPwd());
        }
        if (request.getPower()!=null){
	        loginUser.setPower(request.getPower());
        }
    	loginUserService.updateLoginUser(loginUser);
        //返回响应
        LoginUserUpdateResponse loginUserUpdateResponse = new LoginUserUpdateResponse();
        loginUserUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        loginUserUpdateResponse.setResultJson(loginUser);
        return loginUserUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.getLoginUser", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getLoginUser(LoginUserGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        LoginUser loginUser=new LoginUser();
        loginUser=loginUserService.getLoginUser(id);
        //返回响应
        LoginUserGetResponse loginUserGetResponse = new LoginUserGetResponse();
        loginUserGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        loginUserGetResponse.setResultJson(loginUser);
        return loginUserGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(LoginUserSelectAllRequest request) {
        LoginUserSelectAllResponse loginUserSelectAllResponse = new LoginUserSelectAllResponse();
        loginUserSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        loginUserSelectAllResponse.setResultJson(loginUserService.selectAll());
        return loginUserSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(LoginUserCountAllRequest request) {
        LoginUserCountAllResponse loginUserCountAllResponse = new LoginUserCountAllResponse();
        loginUserCountAllResponse.setResultString(String.valueOf(loginUserService.countAll()));
        loginUserCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return loginUserCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(LoginUserSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        LoginUserSelectAllResponse loginUserSelectAllResponse = new LoginUserSelectAllResponse();
        loginUserSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        loginUserSelectAllResponse.setResultJson(loginUserService.selectBySql(sqlstr));
        return loginUserSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.selectLoginUser", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(LoginUserSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_LoginUser_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        LoginUser loginUser=new LoginUser();
        loginUser.setId(request.getId());
        loginUser.setUser(request.getUser());
        loginUser.setPwd(request.getPwd());
        loginUser.setPower(request.getPower());
    	LoginUserSelectResponse loginUserSelectResponse = new LoginUserSelectResponse();
        loginUserSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<LoginUser> loginUsers= loginUserService.selectWithCondition(loginUser);
        loginUserSelectResponse.setResultJson(loginUsers);
        return loginUserSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "loginUser.isExistLoginUser", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistLoginUser(LoginUserSelectRequest request) {
        LoginUser loginUser=new LoginUser();
        loginUser.setId(request.getId());
        loginUser.setUser(request.getUser());
        loginUser.setPwd(request.getPwd());
        loginUser.setPower(request.getPower());
        ArrayList<LoginUser> loginUsers= loginUserService.selectWithCondition(loginUser);
    	LoginUserCountAllResponse loginUserCountAllResponse = new LoginUserCountAllResponse();
        if (loginUsers.size()>0){
        	loginUserCountAllResponse.setResultString("1");
        } else {
        	loginUserCountAllResponse.setResultString("0");
        }        
        return loginUserCountAllResponse;
    }

    public Boolean validateCreateRequest(LoginUserCreateRequest request){
    	LoginUser loginUser=new LoginUser();
    	loginUser.setId(request.getId());
        ArrayList<LoginUser> loginUsers= loginUserService.selectWithCondition(loginUser);
        if (loginUsers!=null&&loginUsers.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(LoginUserUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(LoginUserDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(LoginUserSelectRequest request){
        return  true;
     }    
}
