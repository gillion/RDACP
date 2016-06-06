/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmEnvironment;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmEnvironment.request.*;
import com.cartan.center.ebs.ipfCcmEnvironment.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmEnvironmentServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmEnvironmentServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmEnvironmentGetSessionRequest ipfCcmEnvironmentRequest = new IpfCcmEnvironmentGetSessionRequest();
     	CompositeResponse<IpfCcmEnvironmentGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmEnvironmentRequest, IpfCcmEnvironmentGetSessionResponse.class, "ipfCcmEnvironment.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmEnvironment(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmEnvironmentCreateRequest ipfCcmEnvironmentRequest = new IpfCcmEnvironmentCreateRequest();
	   	ipfCcmEnvironmentRequest.setId("1");
	   	ipfCcmEnvironmentRequest.setUserCode("1");
	   	ipfCcmEnvironmentRequest.setProjectName("1");
	   	ipfCcmEnvironmentRequest.setProjectPath("1");
	   	ipfCcmEnvironmentRequest.setSrcPath("1");
	   	ipfCcmEnvironmentRequest.setTemplatePath("1");
	   	ipfCcmEnvironmentRequest.setWebContentName("1");
	   	ipfCcmEnvironmentRequest.setTargetProjectName("1");
	   	ipfCcmEnvironmentRequest.setTargetProjectPath("1");
        CompositeResponse<IpfCcmEnvironmentCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmEnvironmentRequest, IpfCcmEnvironmentCreateResponse.class, "ipfCcmEnvironment.createIpfCcmEnvironment", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmEnvironmentCreateResponse ipfCcmEnvironmentResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmEnvironment(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmEnvironmentDeleteRequest ipfCcmEnvironmentRequest = new IpfCcmEnvironmentDeleteRequest();
	   	ipfCcmEnvironmentRequest.setId("1");
        CompositeResponse<IpfCcmEnvironmentDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmEnvironmentRequest, IpfCcmEnvironmentDeleteResponse.class, "ipfCcmEnvironment.deleteIpfCcmEnvironment", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmEnvironmentDeleteResponse ipfCcmEnvironmentResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmEnvironment(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmEnvironmentUpdateRequest ipfCcmEnvironmentRequest = new IpfCcmEnvironmentUpdateRequest();
	   	ipfCcmEnvironmentRequest.setId("1");
	   	ipfCcmEnvironmentRequest.setUserCode("1");
	   	ipfCcmEnvironmentRequest.setProjectName("1");
	   	ipfCcmEnvironmentRequest.setProjectPath("1");
	   	ipfCcmEnvironmentRequest.setSrcPath("1");
	   	ipfCcmEnvironmentRequest.setTemplatePath("1");
	   	ipfCcmEnvironmentRequest.setWebContentName("1");
	   	ipfCcmEnvironmentRequest.setTargetProjectName("1");
	   	ipfCcmEnvironmentRequest.setTargetProjectPath("1");
        CompositeResponse<IpfCcmEnvironmentUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmEnvironmentRequest, IpfCcmEnvironmentUpdateResponse.class, "ipfCcmEnvironment.updateIpfCcmEnvironment", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmEnvironmentUpdateResponse ipfCcmEnvironmentResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmEnvironment(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmEnvironmentGetRequest ipfCcmEnvironmentRequest = new IpfCcmEnvironmentGetRequest();
	   	ipfCcmEnvironmentRequest.setId("1");
        CompositeResponse<IpfCcmEnvironmentGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmEnvironmentRequest, IpfCcmEnvironmentGetResponse.class, "ipfCcmEnvironment.getIpfCcmEnvironment", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmEnvironmentGetResponse ipfCcmEnvironmentResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmEnvironmentSelectAllRequest ipfCcmEnvironmentRequest = new IpfCcmEnvironmentSelectAllRequest();

        CompositeResponse<IpfCcmEnvironmentSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmEnvironmentRequest, IpfCcmEnvironmentSelectAllResponse.class, "ipfCcmEnvironment.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmEnvironmentSelectAllResponse ipfCcmEnvironmentResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmEnvironmentCountAllRequest ipfCcmEnvironmentRequest = new IpfCcmEnvironmentCountAllRequest();

        CompositeResponse<IpfCcmEnvironmentCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmEnvironmentRequest, IpfCcmEnvironmentCountAllResponse.class, "ipfCcmEnvironment.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmEnvironmentCountAllResponse ipfCcmEnvironmentResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmEnvironmentResponse.getResultString());
    }

    @Test
    public void selectIpfCcmEnvironment(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmEnvironmentSelectRequest ipfCcmEnvironmentRequest = new IpfCcmEnvironmentSelectRequest();
	   	ipfCcmEnvironmentRequest.setId("1");
	   	ipfCcmEnvironmentRequest.setUserCode("1");
	   	ipfCcmEnvironmentRequest.setProjectName("1");
	   	ipfCcmEnvironmentRequest.setProjectPath("1");
	   	ipfCcmEnvironmentRequest.setSrcPath("1");
	   	ipfCcmEnvironmentRequest.setTemplatePath("1");
	   	ipfCcmEnvironmentRequest.setWebContentName("1");
	   	ipfCcmEnvironmentRequest.setTargetProjectName("1");
	   	ipfCcmEnvironmentRequest.setTargetProjectPath("1");
        CompositeResponse<IpfCcmEnvironmentCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmEnvironmentRequest, IpfCcmEnvironmentCreateResponse.class, "ipfCcmEnvironment.createIpfCcmEnvironment", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmEnvironmentRequest.setId("1");
	   	ipfCcmEnvironmentRequest.setUserCode("1");
	   	ipfCcmEnvironmentRequest.setProjectName("1");
	   	ipfCcmEnvironmentRequest.setProjectPath("1");
	   	ipfCcmEnvironmentRequest.setSrcPath("1");
	   	ipfCcmEnvironmentRequest.setTemplatePath("1");
	   	ipfCcmEnvironmentRequest.setWebContentName("1");
	   	ipfCcmEnvironmentRequest.setTargetProjectName("1");
	   	ipfCcmEnvironmentRequest.setTargetProjectPath("1");
        CompositeResponse<IpfCcmEnvironmentSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmEnvironmentRequest, IpfCcmEnvironmentSelectResponse.class, "ipfCcmEnvironment.selectIpfCcmEnvironment", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmEnvironmentSelectResponse ipfCcmEnvironmentResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmEnvironmentResponse.getResultJson());
        CompositeResponse<IpfCcmEnvironmentDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmEnvironmentRequest, IpfCcmEnvironmentDeleteResponse.class, "ipfCcmEnvironment.deleteIpfCcmEnvironment", "1.0");

    }
}
