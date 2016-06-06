/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.center.ebs.sysUser;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.sysUser.request.*;
import com.cartan.center.ebs.sysUser.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

/**
 * @author : liuxb(13720880048@163.com)
 * @date: 2013-09-05
 */
public class SysUserServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(SysUserServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        SysUserGetSessionRequest sysUserRequest = new SysUserGetSessionRequest();
     	CompositeResponse<SysUserGetSessionResponse> response =
                 ropClient.buildClientRequest().get(sysUserRequest, SysUserGetSessionResponse.class, "sysUser.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createSysUser(){
        RopClient ropClient = CartanRopClient.getRopClient();
        SysUserCreateRequest sysUserRequest = new SysUserCreateRequest();
	   	sysUserRequest.setUserId(CodeUtils.uuid()); 
	   	sysUserRequest.setUserName("1");
	   	sysUserRequest.setPassword("1");
	   	sysUserRequest.setUserType("1");
	   	sysUserRequest.setLastLogonTime("20120101120101");
	   	sysUserRequest.setLastLogonIp("1");
	   	sysUserRequest.setStatus("1");
	   	sysUserRequest.setCreateTime("20120101120101");
        CompositeResponse<SysUserCreateResponse> response =
                ropClient.buildClientRequest().get(sysUserRequest, SysUserCreateResponse.class, "sysUser.createSysUser", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        SysUserCreateResponse sysUserResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteSysUser(){
        RopClient ropClient = CartanRopClient.getRopClient();
        SysUserDeleteRequest sysUserRequest = new SysUserDeleteRequest();
	   	sysUserRequest.setUserId("1");
        CompositeResponse<SysUserDeleteResponse> response =
                ropClient.buildClientRequest().get(sysUserRequest, SysUserDeleteResponse.class, "sysUser.deleteSysUser", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        SysUserDeleteResponse sysUserResponse = response.getSuccessResponse();
    }




    @Test
    public void updateSysUser(){
        RopClient ropClient = CartanRopClient.getRopClient();
        SysUserUpdateRequest sysUserRequest = new SysUserUpdateRequest();
	   	sysUserRequest.setUserId("1");
	   	sysUserRequest.setUserName("1");
	   	sysUserRequest.setPassword("1");
	   	sysUserRequest.setUserType("1");
	   	sysUserRequest.setLastLogonTime("20120101120101");
	   	sysUserRequest.setLastLogonIp("1");
	   	sysUserRequest.setStatus("1");
	   	sysUserRequest.setCreateTime("20120101120101");
        CompositeResponse<SysUserUpdateResponse> response =
                ropClient.buildClientRequest().get(sysUserRequest, SysUserUpdateResponse.class, "sysUser.updateSysUser", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        SysUserUpdateResponse sysUserResponse = response.getSuccessResponse();
    }


    @Test
    public void getSysUser(){
        RopClient ropClient = CartanRopClient.getRopClient();
        SysUserGetRequest sysUserRequest = new SysUserGetRequest();
	   	sysUserRequest.setUserId("1");
        CompositeResponse<SysUserGetResponse> response =
                ropClient.buildClientRequest().get(sysUserRequest, SysUserGetResponse.class, "sysUser.getSysUser", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        SysUserGetResponse sysUserResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        SysUserSelectAllRequest sysUserRequest = new SysUserSelectAllRequest();

        CompositeResponse<SysUserSelectAllResponse> response =
                ropClient.buildClientRequest().get(sysUserRequest, SysUserSelectAllResponse.class, "sysUser.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        SysUserSelectAllResponse sysUserResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        SysUserCountAllRequest sysUserRequest = new SysUserCountAllRequest();

        CompositeResponse<SysUserCountAllResponse> response =
                ropClient.buildClientRequest().get(sysUserRequest, SysUserCountAllResponse.class, "sysUser.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        SysUserCountAllResponse sysUserResponse = response.getSuccessResponse();
        Assert.assertNotNull(sysUserResponse.getResultString());
    }

    @Test
    public void selectSysUser(){
        RopClient ropClient = CartanRopClient.getRopClient();
        SysUserSelectRequest sysUserRequest = new SysUserSelectRequest();
	   	sysUserRequest.setUserId("1");
	   	sysUserRequest.setUserName("1");
	   	sysUserRequest.setPassword("1");
	   	sysUserRequest.setUserType("1");
	   	sysUserRequest.setLastLogonTime("20120101120101");
	   	sysUserRequest.setLastLogonIp("1");
	   	sysUserRequest.setStatus("1");
	   	sysUserRequest.setCreateTime("20120101120101");
        CompositeResponse<SysUserCreateResponse> response =
                ropClient.buildClientRequest().get(sysUserRequest, SysUserCreateResponse.class, "sysUser.createSysUser", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	sysUserRequest.setUserId("1");
	   	sysUserRequest.setUserName("1");
	   	sysUserRequest.setPassword("1");
	   	sysUserRequest.setUserType("1");
	   	sysUserRequest.setLastLogonTime("20120101120101");
	   	sysUserRequest.setLastLogonIp("1");
	   	sysUserRequest.setStatus("1");
	   	sysUserRequest.setCreateTime("20120101120101");
        CompositeResponse<SysUserSelectResponse> response1 =
                ropClient.buildClientRequest().get(sysUserRequest, SysUserSelectResponse.class, "sysUser.selectSysUser", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        SysUserSelectResponse sysUserResponse = response1.getSuccessResponse();
        Assert.assertNotNull(sysUserResponse.getResultJson());
        CompositeResponse<SysUserDeleteResponse> response2 =
                ropClient.buildClientRequest().get(sysUserRequest, SysUserDeleteResponse.class, "sysUser.deleteSysUser", "1.0");

    }
}
