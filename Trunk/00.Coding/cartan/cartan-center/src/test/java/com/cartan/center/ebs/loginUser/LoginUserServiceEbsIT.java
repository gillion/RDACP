/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.loginUser;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.loginUser.request.*;
import com.cartan.center.ebs.loginUser.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class LoginUserServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(LoginUserServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        LoginUserGetSessionRequest loginUserRequest = new LoginUserGetSessionRequest();
     	CompositeResponse<LoginUserGetSessionResponse> response =
                 ropClient.buildClientRequest().get(loginUserRequest, LoginUserGetSessionResponse.class, "loginUser.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createLoginUser(){
        RopClient ropClient = CartanRopClient.getRopClient();
        LoginUserCreateRequest loginUserRequest = new LoginUserCreateRequest();
	   	loginUserRequest.setId("1");
	   	loginUserRequest.setUser("1");
	   	loginUserRequest.setPwd("1");
	   	loginUserRequest.setPower("1");
        CompositeResponse<LoginUserCreateResponse> response =
                ropClient.buildClientRequest().get(loginUserRequest, LoginUserCreateResponse.class, "loginUser.createLoginUser", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        LoginUserCreateResponse loginUserResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteLoginUser(){
        RopClient ropClient = CartanRopClient.getRopClient();
        LoginUserDeleteRequest loginUserRequest = new LoginUserDeleteRequest();
	   	loginUserRequest.setId("1");
        CompositeResponse<LoginUserDeleteResponse> response =
                ropClient.buildClientRequest().get(loginUserRequest, LoginUserDeleteResponse.class, "loginUser.deleteLoginUser", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        LoginUserDeleteResponse loginUserResponse = response.getSuccessResponse();
    }




    @Test
    public void updateLoginUser(){
        RopClient ropClient = CartanRopClient.getRopClient();
        LoginUserUpdateRequest loginUserRequest = new LoginUserUpdateRequest();
	   	loginUserRequest.setId("1");
	   	loginUserRequest.setUser("1");
	   	loginUserRequest.setPwd("1");
	   	loginUserRequest.setPower("1");
        CompositeResponse<LoginUserUpdateResponse> response =
                ropClient.buildClientRequest().get(loginUserRequest, LoginUserUpdateResponse.class, "loginUser.updateLoginUser", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        LoginUserUpdateResponse loginUserResponse = response.getSuccessResponse();
    }


    @Test
    public void getLoginUser(){
        RopClient ropClient = CartanRopClient.getRopClient();
        LoginUserGetRequest loginUserRequest = new LoginUserGetRequest();
	   	loginUserRequest.setId("1");
        CompositeResponse<LoginUserGetResponse> response =
                ropClient.buildClientRequest().get(loginUserRequest, LoginUserGetResponse.class, "loginUser.getLoginUser", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        LoginUserGetResponse loginUserResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        LoginUserSelectAllRequest loginUserRequest = new LoginUserSelectAllRequest();

        CompositeResponse<LoginUserSelectAllResponse> response =
                ropClient.buildClientRequest().get(loginUserRequest, LoginUserSelectAllResponse.class, "loginUser.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        LoginUserSelectAllResponse loginUserResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        LoginUserCountAllRequest loginUserRequest = new LoginUserCountAllRequest();

        CompositeResponse<LoginUserCountAllResponse> response =
                ropClient.buildClientRequest().get(loginUserRequest, LoginUserCountAllResponse.class, "loginUser.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        LoginUserCountAllResponse loginUserResponse = response.getSuccessResponse();
        Assert.assertNotNull(loginUserResponse.getResultString());
    }

    @Test
    public void selectLoginUser(){
        RopClient ropClient = CartanRopClient.getRopClient();
        LoginUserSelectRequest loginUserRequest = new LoginUserSelectRequest();
	   	loginUserRequest.setId("1");
	   	loginUserRequest.setUser("1");
	   	loginUserRequest.setPwd("1");
	   	loginUserRequest.setPower("1");
        CompositeResponse<LoginUserCreateResponse> response =
                ropClient.buildClientRequest().get(loginUserRequest, LoginUserCreateResponse.class, "loginUser.createLoginUser", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	loginUserRequest.setId("1");
	   	loginUserRequest.setUser("1");
	   	loginUserRequest.setPwd("1");
	   	loginUserRequest.setPower("1");
        CompositeResponse<LoginUserSelectResponse> response1 =
                ropClient.buildClientRequest().get(loginUserRequest, LoginUserSelectResponse.class, "loginUser.selectLoginUser", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        LoginUserSelectResponse loginUserResponse = response1.getSuccessResponse();
        Assert.assertNotNull(loginUserResponse.getResultJson());
        CompositeResponse<LoginUserDeleteResponse> response2 =
                ropClient.buildClientRequest().get(loginUserRequest, LoginUserDeleteResponse.class, "loginUser.deleteLoginUser", "1.0");

    }
}
