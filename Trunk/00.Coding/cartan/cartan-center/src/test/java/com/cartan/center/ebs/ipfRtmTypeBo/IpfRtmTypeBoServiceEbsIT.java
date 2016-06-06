/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmTypeBo;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfRtmTypeBo.request.*;
import com.cartan.center.ebs.ipfRtmTypeBo.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfRtmTypeBoServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfRtmTypeBoServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoGetSessionRequest ipfRtmTypeBoRequest = new IpfRtmTypeBoGetSessionRequest();
     	CompositeResponse<IpfRtmTypeBoGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfRtmTypeBoRequest, IpfRtmTypeBoGetSessionResponse.class, "ipfRtmTypeBo.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfRtmTypeBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoCreateRequest ipfRtmTypeBoRequest = new IpfRtmTypeBoCreateRequest();
	   	ipfRtmTypeBoRequest.setId("1");
	   	ipfRtmTypeBoRequest.setIpfRtmTypeId("1");
	   	ipfRtmTypeBoRequest.setIpfCcmBoId("1");
	   	ipfRtmTypeBoRequest.setBoName("1");
	   	ipfRtmTypeBoRequest.setBoDesc("1");
	   	ipfRtmTypeBoRequest.setPropertyName("1");
	   	ipfRtmTypeBoRequest.setPropertyUtility("1");
	   	ipfRtmTypeBoRequest.setExternalBoName("1");
	   	ipfRtmTypeBoRequest.setExternalMatchProperty("1");
	   	ipfRtmTypeBoRequest.setExternalResultProperty("1");
	   	ipfRtmTypeBoRequest.setExternalBoId("1");
	   	ipfRtmTypeBoRequest.setTriggerPropertyName("1");
        CompositeResponse<IpfRtmTypeBoCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoRequest, IpfRtmTypeBoCreateResponse.class, "ipfRtmTypeBo.createIpfRtmTypeBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoCreateResponse ipfRtmTypeBoResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfRtmTypeBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoDeleteRequest ipfRtmTypeBoRequest = new IpfRtmTypeBoDeleteRequest();
	   	ipfRtmTypeBoRequest.setId("1");
        CompositeResponse<IpfRtmTypeBoDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoRequest, IpfRtmTypeBoDeleteResponse.class, "ipfRtmTypeBo.deleteIpfRtmTypeBo", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoDeleteResponse ipfRtmTypeBoResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfRtmTypeBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoUpdateRequest ipfRtmTypeBoRequest = new IpfRtmTypeBoUpdateRequest();
	   	ipfRtmTypeBoRequest.setId("1");
	   	ipfRtmTypeBoRequest.setIpfRtmTypeId("1");
	   	ipfRtmTypeBoRequest.setIpfCcmBoId("1");
	   	ipfRtmTypeBoRequest.setBoName("1");
	   	ipfRtmTypeBoRequest.setBoDesc("1");
	   	ipfRtmTypeBoRequest.setPropertyName("1");
	   	ipfRtmTypeBoRequest.setPropertyUtility("1");
	   	ipfRtmTypeBoRequest.setExternalBoName("1");
	   	ipfRtmTypeBoRequest.setExternalMatchProperty("1");
	   	ipfRtmTypeBoRequest.setExternalResultProperty("1");
	   	ipfRtmTypeBoRequest.setExternalBoId("1");
	   	ipfRtmTypeBoRequest.setTriggerPropertyName("1");
        CompositeResponse<IpfRtmTypeBoUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoRequest, IpfRtmTypeBoUpdateResponse.class, "ipfRtmTypeBo.updateIpfRtmTypeBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoUpdateResponse ipfRtmTypeBoResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfRtmTypeBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoGetRequest ipfRtmTypeBoRequest = new IpfRtmTypeBoGetRequest();
	   	ipfRtmTypeBoRequest.setId("1");
        CompositeResponse<IpfRtmTypeBoGetResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoRequest, IpfRtmTypeBoGetResponse.class, "ipfRtmTypeBo.getIpfRtmTypeBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoGetResponse ipfRtmTypeBoResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoSelectAllRequest ipfRtmTypeBoRequest = new IpfRtmTypeBoSelectAllRequest();

        CompositeResponse<IpfRtmTypeBoSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoRequest, IpfRtmTypeBoSelectAllResponse.class, "ipfRtmTypeBo.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoSelectAllResponse ipfRtmTypeBoResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoCountAllRequest ipfRtmTypeBoRequest = new IpfRtmTypeBoCountAllRequest();

        CompositeResponse<IpfRtmTypeBoCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoRequest, IpfRtmTypeBoCountAllResponse.class, "ipfRtmTypeBo.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoCountAllResponse ipfRtmTypeBoResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfRtmTypeBoResponse.getResultString());
    }

    @Test
    public void selectIpfRtmTypeBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoSelectRequest ipfRtmTypeBoRequest = new IpfRtmTypeBoSelectRequest();
	   	ipfRtmTypeBoRequest.setId("1");
	   	ipfRtmTypeBoRequest.setIpfRtmTypeId("1");
	   	ipfRtmTypeBoRequest.setIpfCcmBoId("1");
	   	ipfRtmTypeBoRequest.setBoName("1");
	   	ipfRtmTypeBoRequest.setBoDesc("1");
	   	ipfRtmTypeBoRequest.setPropertyName("1");
	   	ipfRtmTypeBoRequest.setPropertyUtility("1");
	   	ipfRtmTypeBoRequest.setExternalBoName("1");
	   	ipfRtmTypeBoRequest.setExternalMatchProperty("1");
	   	ipfRtmTypeBoRequest.setExternalResultProperty("1");
	   	ipfRtmTypeBoRequest.setExternalBoId("1");
	   	ipfRtmTypeBoRequest.setTriggerPropertyName("1");
        CompositeResponse<IpfRtmTypeBoCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoRequest, IpfRtmTypeBoCreateResponse.class, "ipfRtmTypeBo.createIpfRtmTypeBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfRtmTypeBoRequest.setId("1");
	   	ipfRtmTypeBoRequest.setIpfRtmTypeId("1");
	   	ipfRtmTypeBoRequest.setIpfCcmBoId("1");
	   	ipfRtmTypeBoRequest.setBoName("1");
	   	ipfRtmTypeBoRequest.setBoDesc("1");
	   	ipfRtmTypeBoRequest.setPropertyName("1");
	   	ipfRtmTypeBoRequest.setPropertyUtility("1");
	   	ipfRtmTypeBoRequest.setExternalBoName("1");
	   	ipfRtmTypeBoRequest.setExternalMatchProperty("1");
	   	ipfRtmTypeBoRequest.setExternalResultProperty("1");
	   	ipfRtmTypeBoRequest.setExternalBoId("1");
	   	ipfRtmTypeBoRequest.setTriggerPropertyName("1");
        CompositeResponse<IpfRtmTypeBoSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfRtmTypeBoRequest, IpfRtmTypeBoSelectResponse.class, "ipfRtmTypeBo.selectIpfRtmTypeBo", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoSelectResponse ipfRtmTypeBoResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfRtmTypeBoResponse.getResultJson());
        CompositeResponse<IpfRtmTypeBoDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfRtmTypeBoRequest, IpfRtmTypeBoDeleteResponse.class, "ipfRtmTypeBo.deleteIpfRtmTypeBo", "1.0");

    }
}
