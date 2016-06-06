/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmConfig;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfRtmConfig.request.*;
import com.cartan.center.ebs.ipfRtmConfig.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfRtmConfigServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfRtmConfigServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigGetSessionRequest ipfRtmConfigRequest = new IpfRtmConfigGetSessionRequest();
     	CompositeResponse<IpfRtmConfigGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfRtmConfigRequest, IpfRtmConfigGetSessionResponse.class, "ipfRtmConfig.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfRtmConfig(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigCreateRequest ipfRtmConfigRequest = new IpfRtmConfigCreateRequest();
	   	ipfRtmConfigRequest.setId("1");
	   	ipfRtmConfigRequest.setConfigCode("1");
	   	ipfRtmConfigRequest.setConfigName("1");
	   	ipfRtmConfigRequest.setTypeCode("1");
        CompositeResponse<IpfRtmConfigCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigRequest, IpfRtmConfigCreateResponse.class, "ipfRtmConfig.createIpfRtmConfig", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigCreateResponse ipfRtmConfigResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfRtmConfig(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigDeleteRequest ipfRtmConfigRequest = new IpfRtmConfigDeleteRequest();
	   	ipfRtmConfigRequest.setId("1");
        CompositeResponse<IpfRtmConfigDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigRequest, IpfRtmConfigDeleteResponse.class, "ipfRtmConfig.deleteIpfRtmConfig", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigDeleteResponse ipfRtmConfigResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfRtmConfig(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigUpdateRequest ipfRtmConfigRequest = new IpfRtmConfigUpdateRequest();
	   	ipfRtmConfigRequest.setId("1");
	   	ipfRtmConfigRequest.setConfigCode("1");
	   	ipfRtmConfigRequest.setConfigName("1");
	   	ipfRtmConfigRequest.setTypeCode("1");
        CompositeResponse<IpfRtmConfigUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigRequest, IpfRtmConfigUpdateResponse.class, "ipfRtmConfig.updateIpfRtmConfig", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigUpdateResponse ipfRtmConfigResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfRtmConfig(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigGetRequest ipfRtmConfigRequest = new IpfRtmConfigGetRequest();
	   	ipfRtmConfigRequest.setId("1");
        CompositeResponse<IpfRtmConfigGetResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigRequest, IpfRtmConfigGetResponse.class, "ipfRtmConfig.getIpfRtmConfig", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigGetResponse ipfRtmConfigResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigSelectAllRequest ipfRtmConfigRequest = new IpfRtmConfigSelectAllRequest();

        CompositeResponse<IpfRtmConfigSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigRequest, IpfRtmConfigSelectAllResponse.class, "ipfRtmConfig.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigSelectAllResponse ipfRtmConfigResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigCountAllRequest ipfRtmConfigRequest = new IpfRtmConfigCountAllRequest();

        CompositeResponse<IpfRtmConfigCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigRequest, IpfRtmConfigCountAllResponse.class, "ipfRtmConfig.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigCountAllResponse ipfRtmConfigResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfRtmConfigResponse.getResultString());
    }

    @Test
    public void selectIpfRtmConfig(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigSelectRequest ipfRtmConfigRequest = new IpfRtmConfigSelectRequest();
	   	ipfRtmConfigRequest.setId("1");
	   	ipfRtmConfigRequest.setConfigCode("1");
	   	ipfRtmConfigRequest.setConfigName("1");
	   	ipfRtmConfigRequest.setTypeCode("1");
        CompositeResponse<IpfRtmConfigCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigRequest, IpfRtmConfigCreateResponse.class, "ipfRtmConfig.createIpfRtmConfig", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfRtmConfigRequest.setId("1");
	   	ipfRtmConfigRequest.setConfigCode("1");
	   	ipfRtmConfigRequest.setConfigName("1");
	   	ipfRtmConfigRequest.setTypeCode("1");
        CompositeResponse<IpfRtmConfigSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfRtmConfigRequest, IpfRtmConfigSelectResponse.class, "ipfRtmConfig.selectIpfRtmConfig", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigSelectResponse ipfRtmConfigResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfRtmConfigResponse.getResultJson());
        CompositeResponse<IpfRtmConfigDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfRtmConfigRequest, IpfRtmConfigDeleteResponse.class, "ipfRtmConfig.deleteIpfRtmConfig", "1.0");

    }
}
