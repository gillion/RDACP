/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayout;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmUiLayout.request.*;
import com.cartan.center.ebs.ipfCcmUiLayout.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmUiLayoutServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmUiLayoutServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutGetSessionRequest ipfCcmUiLayoutRequest = new IpfCcmUiLayoutGetSessionRequest();
     	CompositeResponse<IpfCcmUiLayoutGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmUiLayoutRequest, IpfCcmUiLayoutGetSessionResponse.class, "ipfCcmUiLayout.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmUiLayout(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutCreateRequest ipfCcmUiLayoutRequest = new IpfCcmUiLayoutCreateRequest();
	   	ipfCcmUiLayoutRequest.setId("1");
	   	ipfCcmUiLayoutRequest.setUiLayoutName("1");
	   	ipfCcmUiLayoutRequest.setDescription("1");
        CompositeResponse<IpfCcmUiLayoutCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutRequest, IpfCcmUiLayoutCreateResponse.class, "ipfCcmUiLayout.createIpfCcmUiLayout", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutCreateResponse ipfCcmUiLayoutResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmUiLayout(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutDeleteRequest ipfCcmUiLayoutRequest = new IpfCcmUiLayoutDeleteRequest();
	   	ipfCcmUiLayoutRequest.setId("1");
        CompositeResponse<IpfCcmUiLayoutDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutRequest, IpfCcmUiLayoutDeleteResponse.class, "ipfCcmUiLayout.deleteIpfCcmUiLayout", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutDeleteResponse ipfCcmUiLayoutResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmUiLayout(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutUpdateRequest ipfCcmUiLayoutRequest = new IpfCcmUiLayoutUpdateRequest();
	   	ipfCcmUiLayoutRequest.setId("1");
	   	ipfCcmUiLayoutRequest.setUiLayoutName("1");
	   	ipfCcmUiLayoutRequest.setDescription("1");
        CompositeResponse<IpfCcmUiLayoutUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutRequest, IpfCcmUiLayoutUpdateResponse.class, "ipfCcmUiLayout.updateIpfCcmUiLayout", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutUpdateResponse ipfCcmUiLayoutResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmUiLayout(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutGetRequest ipfCcmUiLayoutRequest = new IpfCcmUiLayoutGetRequest();
	   	ipfCcmUiLayoutRequest.setId("1");
        CompositeResponse<IpfCcmUiLayoutGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutRequest, IpfCcmUiLayoutGetResponse.class, "ipfCcmUiLayout.getIpfCcmUiLayout", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutGetResponse ipfCcmUiLayoutResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutSelectAllRequest ipfCcmUiLayoutRequest = new IpfCcmUiLayoutSelectAllRequest();

        CompositeResponse<IpfCcmUiLayoutSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutRequest, IpfCcmUiLayoutSelectAllResponse.class, "ipfCcmUiLayout.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutSelectAllResponse ipfCcmUiLayoutResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutCountAllRequest ipfCcmUiLayoutRequest = new IpfCcmUiLayoutCountAllRequest();

        CompositeResponse<IpfCcmUiLayoutCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutRequest, IpfCcmUiLayoutCountAllResponse.class, "ipfCcmUiLayout.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutCountAllResponse ipfCcmUiLayoutResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmUiLayoutResponse.getResultString());
    }

    @Test
    public void selectIpfCcmUiLayout(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutSelectRequest ipfCcmUiLayoutRequest = new IpfCcmUiLayoutSelectRequest();
	   	ipfCcmUiLayoutRequest.setId("1");
	   	ipfCcmUiLayoutRequest.setUiLayoutName("1");
	   	ipfCcmUiLayoutRequest.setDescription("1");
        CompositeResponse<IpfCcmUiLayoutCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutRequest, IpfCcmUiLayoutCreateResponse.class, "ipfCcmUiLayout.createIpfCcmUiLayout", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmUiLayoutRequest.setId("1");
	   	ipfCcmUiLayoutRequest.setUiLayoutName("1");
	   	ipfCcmUiLayoutRequest.setDescription("1");
        CompositeResponse<IpfCcmUiLayoutSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutRequest, IpfCcmUiLayoutSelectResponse.class, "ipfCcmUiLayout.selectIpfCcmUiLayout", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutSelectResponse ipfCcmUiLayoutResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmUiLayoutResponse.getResultJson());
        CompositeResponse<IpfCcmUiLayoutDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutRequest, IpfCcmUiLayoutDeleteResponse.class, "ipfCcmUiLayout.deleteIpfCcmUiLayout", "1.0");

    }
}
