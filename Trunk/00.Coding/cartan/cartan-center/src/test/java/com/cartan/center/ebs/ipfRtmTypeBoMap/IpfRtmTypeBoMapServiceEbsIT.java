/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmTypeBoMap;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfRtmTypeBoMap.request.*;
import com.cartan.center.ebs.ipfRtmTypeBoMap.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfRtmTypeBoMapServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfRtmTypeBoMapServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoMapGetSessionRequest ipfRtmTypeBoMapRequest = new IpfRtmTypeBoMapGetSessionRequest();
     	CompositeResponse<IpfRtmTypeBoMapGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfRtmTypeBoMapRequest, IpfRtmTypeBoMapGetSessionResponse.class, "ipfRtmTypeBoMap.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfRtmTypeBoMap(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoMapCreateRequest ipfRtmTypeBoMapRequest = new IpfRtmTypeBoMapCreateRequest();
	   	ipfRtmTypeBoMapRequest.setId("1");
	   	ipfRtmTypeBoMapRequest.setIpfRtmTypeBoId("1");
	   	ipfRtmTypeBoMapRequest.setSourceValue("1");
	   	ipfRtmTypeBoMapRequest.setDestValue("1");
        CompositeResponse<IpfRtmTypeBoMapCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoMapRequest, IpfRtmTypeBoMapCreateResponse.class, "ipfRtmTypeBoMap.createIpfRtmTypeBoMap", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoMapCreateResponse ipfRtmTypeBoMapResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfRtmTypeBoMap(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoMapDeleteRequest ipfRtmTypeBoMapRequest = new IpfRtmTypeBoMapDeleteRequest();
	   	ipfRtmTypeBoMapRequest.setId("1");
        CompositeResponse<IpfRtmTypeBoMapDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoMapRequest, IpfRtmTypeBoMapDeleteResponse.class, "ipfRtmTypeBoMap.deleteIpfRtmTypeBoMap", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoMapDeleteResponse ipfRtmTypeBoMapResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfRtmTypeBoMap(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoMapUpdateRequest ipfRtmTypeBoMapRequest = new IpfRtmTypeBoMapUpdateRequest();
	   	ipfRtmTypeBoMapRequest.setId("1");
	   	ipfRtmTypeBoMapRequest.setIpfRtmTypeBoId("1");
	   	ipfRtmTypeBoMapRequest.setSourceValue("1");
	   	ipfRtmTypeBoMapRequest.setDestValue("1");
        CompositeResponse<IpfRtmTypeBoMapUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoMapRequest, IpfRtmTypeBoMapUpdateResponse.class, "ipfRtmTypeBoMap.updateIpfRtmTypeBoMap", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoMapUpdateResponse ipfRtmTypeBoMapResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfRtmTypeBoMap(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoMapGetRequest ipfRtmTypeBoMapRequest = new IpfRtmTypeBoMapGetRequest();
	   	ipfRtmTypeBoMapRequest.setId("1");
        CompositeResponse<IpfRtmTypeBoMapGetResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoMapRequest, IpfRtmTypeBoMapGetResponse.class, "ipfRtmTypeBoMap.getIpfRtmTypeBoMap", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoMapGetResponse ipfRtmTypeBoMapResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoMapSelectAllRequest ipfRtmTypeBoMapRequest = new IpfRtmTypeBoMapSelectAllRequest();

        CompositeResponse<IpfRtmTypeBoMapSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoMapRequest, IpfRtmTypeBoMapSelectAllResponse.class, "ipfRtmTypeBoMap.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoMapSelectAllResponse ipfRtmTypeBoMapResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoMapCountAllRequest ipfRtmTypeBoMapRequest = new IpfRtmTypeBoMapCountAllRequest();

        CompositeResponse<IpfRtmTypeBoMapCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoMapRequest, IpfRtmTypeBoMapCountAllResponse.class, "ipfRtmTypeBoMap.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoMapCountAllResponse ipfRtmTypeBoMapResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfRtmTypeBoMapResponse.getResultString());
    }

    @Test
    public void selectIpfRtmTypeBoMap(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoMapSelectRequest ipfRtmTypeBoMapRequest = new IpfRtmTypeBoMapSelectRequest();
	   	ipfRtmTypeBoMapRequest.setId("1");
	   	ipfRtmTypeBoMapRequest.setIpfRtmTypeBoId("1");
	   	ipfRtmTypeBoMapRequest.setSourceValue("1");
	   	ipfRtmTypeBoMapRequest.setDestValue("1");
        CompositeResponse<IpfRtmTypeBoMapCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoMapRequest, IpfRtmTypeBoMapCreateResponse.class, "ipfRtmTypeBoMap.createIpfRtmTypeBoMap", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfRtmTypeBoMapRequest.setId("1");
	   	ipfRtmTypeBoMapRequest.setIpfRtmTypeBoId("1");
	   	ipfRtmTypeBoMapRequest.setSourceValue("1");
	   	ipfRtmTypeBoMapRequest.setDestValue("1");
        CompositeResponse<IpfRtmTypeBoMapSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfRtmTypeBoMapRequest, IpfRtmTypeBoMapSelectResponse.class, "ipfRtmTypeBoMap.selectIpfRtmTypeBoMap", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoMapSelectResponse ipfRtmTypeBoMapResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfRtmTypeBoMapResponse.getResultJson());
        CompositeResponse<IpfRtmTypeBoMapDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfRtmTypeBoMapRequest, IpfRtmTypeBoMapDeleteResponse.class, "ipfRtmTypeBoMap.deleteIpfRtmTypeBoMap", "1.0");

    }
}
