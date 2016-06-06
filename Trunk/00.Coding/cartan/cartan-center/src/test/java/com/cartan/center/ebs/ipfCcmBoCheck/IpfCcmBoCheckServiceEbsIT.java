/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoCheck;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoCheck.request.*;
import com.cartan.center.ebs.ipfCcmBoCheck.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoCheckServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoCheckServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckGetSessionRequest ipfCcmBoCheckRequest = new IpfCcmBoCheckGetSessionRequest();
     	CompositeResponse<IpfCcmBoCheckGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoCheckRequest, IpfCcmBoCheckGetSessionResponse.class, "ipfCcmBoCheck.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoCheck(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckCreateRequest ipfCcmBoCheckRequest = new IpfCcmBoCheckCreateRequest();
	   	ipfCcmBoCheckRequest.setId("1");
	   	ipfCcmBoCheckRequest.setCheckType("1");
	   	ipfCcmBoCheckRequest.setCheckName("1");
	   	ipfCcmBoCheckRequest.setBoName("1");
	   	ipfCcmBoCheckRequest.setPropertyName("1");
	   	ipfCcmBoCheckRequest.setPropertyDesc("1");
        CompositeResponse<IpfCcmBoCheckCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRequest, IpfCcmBoCheckCreateResponse.class, "ipfCcmBoCheck.createIpfCcmBoCheck", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckCreateResponse ipfCcmBoCheckResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoCheck(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckDeleteRequest ipfCcmBoCheckRequest = new IpfCcmBoCheckDeleteRequest();
	   	ipfCcmBoCheckRequest.setId("1");
        CompositeResponse<IpfCcmBoCheckDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRequest, IpfCcmBoCheckDeleteResponse.class, "ipfCcmBoCheck.deleteIpfCcmBoCheck", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckDeleteResponse ipfCcmBoCheckResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoCheck(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckUpdateRequest ipfCcmBoCheckRequest = new IpfCcmBoCheckUpdateRequest();
	   	ipfCcmBoCheckRequest.setId("1");
	   	ipfCcmBoCheckRequest.setCheckType("1");
	   	ipfCcmBoCheckRequest.setCheckName("1");
	   	ipfCcmBoCheckRequest.setBoName("1");
	   	ipfCcmBoCheckRequest.setPropertyName("1");
	   	ipfCcmBoCheckRequest.setPropertyDesc("1");
        CompositeResponse<IpfCcmBoCheckUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRequest, IpfCcmBoCheckUpdateResponse.class, "ipfCcmBoCheck.updateIpfCcmBoCheck", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckUpdateResponse ipfCcmBoCheckResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoCheck(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckGetRequest ipfCcmBoCheckRequest = new IpfCcmBoCheckGetRequest();
	   	ipfCcmBoCheckRequest.setId("1");
        CompositeResponse<IpfCcmBoCheckGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRequest, IpfCcmBoCheckGetResponse.class, "ipfCcmBoCheck.getIpfCcmBoCheck", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckGetResponse ipfCcmBoCheckResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckSelectAllRequest ipfCcmBoCheckRequest = new IpfCcmBoCheckSelectAllRequest();

        CompositeResponse<IpfCcmBoCheckSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRequest, IpfCcmBoCheckSelectAllResponse.class, "ipfCcmBoCheck.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckSelectAllResponse ipfCcmBoCheckResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckCountAllRequest ipfCcmBoCheckRequest = new IpfCcmBoCheckCountAllRequest();

        CompositeResponse<IpfCcmBoCheckCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRequest, IpfCcmBoCheckCountAllResponse.class, "ipfCcmBoCheck.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckCountAllResponse ipfCcmBoCheckResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoCheckResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoCheck(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckSelectRequest ipfCcmBoCheckRequest = new IpfCcmBoCheckSelectRequest();
	   	ipfCcmBoCheckRequest.setId("1");
	   	ipfCcmBoCheckRequest.setCheckType("1");
	   	ipfCcmBoCheckRequest.setCheckName("1");
	   	ipfCcmBoCheckRequest.setBoName("1");
	   	ipfCcmBoCheckRequest.setPropertyName("1");
	   	ipfCcmBoCheckRequest.setPropertyDesc("1");
        CompositeResponse<IpfCcmBoCheckCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRequest, IpfCcmBoCheckCreateResponse.class, "ipfCcmBoCheck.createIpfCcmBoCheck", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoCheckRequest.setId("1");
	   	ipfCcmBoCheckRequest.setCheckType("1");
	   	ipfCcmBoCheckRequest.setCheckName("1");
	   	ipfCcmBoCheckRequest.setBoName("1");
	   	ipfCcmBoCheckRequest.setPropertyName("1");
	   	ipfCcmBoCheckRequest.setPropertyDesc("1");
        CompositeResponse<IpfCcmBoCheckSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRequest, IpfCcmBoCheckSelectResponse.class, "ipfCcmBoCheck.selectIpfCcmBoCheck", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckSelectResponse ipfCcmBoCheckResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoCheckResponse.getResultJson());
        CompositeResponse<IpfCcmBoCheckDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRequest, IpfCcmBoCheckDeleteResponse.class, "ipfCcmBoCheck.deleteIpfCcmBoCheck", "1.0");

    }
}
