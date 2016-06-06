/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayoutConfig;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmUiLayoutConfig.request.*;
import com.cartan.center.ebs.ipfCcmUiLayoutConfig.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmUiLayoutConfigServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmUiLayoutConfigServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutConfigGetSessionRequest ipfCcmUiLayoutConfigRequest = new IpfCcmUiLayoutConfigGetSessionRequest();
     	CompositeResponse<IpfCcmUiLayoutConfigGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmUiLayoutConfigRequest, IpfCcmUiLayoutConfigGetSessionResponse.class, "ipfCcmUiLayoutConfig.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmUiLayoutConfig(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutConfigCreateRequest ipfCcmUiLayoutConfigRequest = new IpfCcmUiLayoutConfigCreateRequest();
	   	ipfCcmUiLayoutConfigRequest.setId("1");
	   	ipfCcmUiLayoutConfigRequest.setIpfCcmBoId("1");
	   	ipfCcmUiLayoutConfigRequest.setBoId("1");
	   	ipfCcmUiLayoutConfigRequest.setPageName("1");
	   	ipfCcmUiLayoutConfigRequest.setLayoutElementName("1");
	   	ipfCcmUiLayoutConfigRequest.setLayoutElementDescription("1");
	   	ipfCcmUiLayoutConfigRequest.setBoName("1");
	   	ipfCcmUiLayoutConfigRequest.setBoElementName("1");
        CompositeResponse<IpfCcmUiLayoutConfigCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutConfigRequest, IpfCcmUiLayoutConfigCreateResponse.class, "ipfCcmUiLayoutConfig.createIpfCcmUiLayoutConfig", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutConfigCreateResponse ipfCcmUiLayoutConfigResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmUiLayoutConfig(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutConfigDeleteRequest ipfCcmUiLayoutConfigRequest = new IpfCcmUiLayoutConfigDeleteRequest();
	   	ipfCcmUiLayoutConfigRequest.setId("1");
        CompositeResponse<IpfCcmUiLayoutConfigDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutConfigRequest, IpfCcmUiLayoutConfigDeleteResponse.class, "ipfCcmUiLayoutConfig.deleteIpfCcmUiLayoutConfig", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutConfigDeleteResponse ipfCcmUiLayoutConfigResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmUiLayoutConfig(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutConfigUpdateRequest ipfCcmUiLayoutConfigRequest = new IpfCcmUiLayoutConfigUpdateRequest();
	   	ipfCcmUiLayoutConfigRequest.setId("1");
	   	ipfCcmUiLayoutConfigRequest.setIpfCcmBoId("1");
	   	ipfCcmUiLayoutConfigRequest.setBoId("1");
	   	ipfCcmUiLayoutConfigRequest.setPageName("1");
	   	ipfCcmUiLayoutConfigRequest.setLayoutElementName("1");
	   	ipfCcmUiLayoutConfigRequest.setLayoutElementDescription("1");
	   	ipfCcmUiLayoutConfigRequest.setBoName("1");
	   	ipfCcmUiLayoutConfigRequest.setBoElementName("1");
        CompositeResponse<IpfCcmUiLayoutConfigUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutConfigRequest, IpfCcmUiLayoutConfigUpdateResponse.class, "ipfCcmUiLayoutConfig.updateIpfCcmUiLayoutConfig", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutConfigUpdateResponse ipfCcmUiLayoutConfigResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmUiLayoutConfig(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutConfigGetRequest ipfCcmUiLayoutConfigRequest = new IpfCcmUiLayoutConfigGetRequest();
	   	ipfCcmUiLayoutConfigRequest.setId("1");
        CompositeResponse<IpfCcmUiLayoutConfigGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutConfigRequest, IpfCcmUiLayoutConfigGetResponse.class, "ipfCcmUiLayoutConfig.getIpfCcmUiLayoutConfig", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutConfigGetResponse ipfCcmUiLayoutConfigResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutConfigSelectAllRequest ipfCcmUiLayoutConfigRequest = new IpfCcmUiLayoutConfigSelectAllRequest();

        CompositeResponse<IpfCcmUiLayoutConfigSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutConfigRequest, IpfCcmUiLayoutConfigSelectAllResponse.class, "ipfCcmUiLayoutConfig.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutConfigSelectAllResponse ipfCcmUiLayoutConfigResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutConfigCountAllRequest ipfCcmUiLayoutConfigRequest = new IpfCcmUiLayoutConfigCountAllRequest();

        CompositeResponse<IpfCcmUiLayoutConfigCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutConfigRequest, IpfCcmUiLayoutConfigCountAllResponse.class, "ipfCcmUiLayoutConfig.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutConfigCountAllResponse ipfCcmUiLayoutConfigResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmUiLayoutConfigResponse.getResultString());
    }

    @Test
    public void selectIpfCcmUiLayoutConfig(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutConfigSelectRequest ipfCcmUiLayoutConfigRequest = new IpfCcmUiLayoutConfigSelectRequest();
	   	ipfCcmUiLayoutConfigRequest.setId("1");
	   	ipfCcmUiLayoutConfigRequest.setIpfCcmBoId("1");
	   	ipfCcmUiLayoutConfigRequest.setBoId("1");
	   	ipfCcmUiLayoutConfigRequest.setPageName("1");
	   	ipfCcmUiLayoutConfigRequest.setLayoutElementName("1");
	   	ipfCcmUiLayoutConfigRequest.setLayoutElementDescription("1");
	   	ipfCcmUiLayoutConfigRequest.setBoName("1");
	   	ipfCcmUiLayoutConfigRequest.setBoElementName("1");
        CompositeResponse<IpfCcmUiLayoutConfigCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutConfigRequest, IpfCcmUiLayoutConfigCreateResponse.class, "ipfCcmUiLayoutConfig.createIpfCcmUiLayoutConfig", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmUiLayoutConfigRequest.setId("1");
	   	ipfCcmUiLayoutConfigRequest.setIpfCcmBoId("1");
	   	ipfCcmUiLayoutConfigRequest.setBoId("1");
	   	ipfCcmUiLayoutConfigRequest.setPageName("1");
	   	ipfCcmUiLayoutConfigRequest.setLayoutElementName("1");
	   	ipfCcmUiLayoutConfigRequest.setLayoutElementDescription("1");
	   	ipfCcmUiLayoutConfigRequest.setBoName("1");
	   	ipfCcmUiLayoutConfigRequest.setBoElementName("1");
        CompositeResponse<IpfCcmUiLayoutConfigSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutConfigRequest, IpfCcmUiLayoutConfigSelectResponse.class, "ipfCcmUiLayoutConfig.selectIpfCcmUiLayoutConfig", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutConfigSelectResponse ipfCcmUiLayoutConfigResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmUiLayoutConfigResponse.getResultJson());
        CompositeResponse<IpfCcmUiLayoutConfigDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutConfigRequest, IpfCcmUiLayoutConfigDeleteResponse.class, "ipfCcmUiLayoutConfig.deleteIpfCcmUiLayoutConfig", "1.0");

    }
}
