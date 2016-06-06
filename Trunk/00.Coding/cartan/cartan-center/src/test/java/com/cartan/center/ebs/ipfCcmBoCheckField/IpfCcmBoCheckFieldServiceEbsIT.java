/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoCheckField;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoCheckField.request.*;
import com.cartan.center.ebs.ipfCcmBoCheckField.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoCheckFieldServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoCheckFieldServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckFieldGetSessionRequest ipfCcmBoCheckFieldRequest = new IpfCcmBoCheckFieldGetSessionRequest();
     	CompositeResponse<IpfCcmBoCheckFieldGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoCheckFieldRequest, IpfCcmBoCheckFieldGetSessionResponse.class, "ipfCcmBoCheckField.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoCheckField(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckFieldCreateRequest ipfCcmBoCheckFieldRequest = new IpfCcmBoCheckFieldCreateRequest();
	   	ipfCcmBoCheckFieldRequest.setId("1");
	   	ipfCcmBoCheckFieldRequest.setIpfCcmBoCheckId("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyId("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyName("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyDesc("1");
	   	ipfCcmBoCheckFieldRequest.setBoName("1");
	   	ipfCcmBoCheckFieldRequest.setSeqNo("1");
        CompositeResponse<IpfCcmBoCheckFieldCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckFieldRequest, IpfCcmBoCheckFieldCreateResponse.class, "ipfCcmBoCheckField.createIpfCcmBoCheckField", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckFieldCreateResponse ipfCcmBoCheckFieldResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoCheckField(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckFieldDeleteRequest ipfCcmBoCheckFieldRequest = new IpfCcmBoCheckFieldDeleteRequest();
	   	ipfCcmBoCheckFieldRequest.setId("1");
        CompositeResponse<IpfCcmBoCheckFieldDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckFieldRequest, IpfCcmBoCheckFieldDeleteResponse.class, "ipfCcmBoCheckField.deleteIpfCcmBoCheckField", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckFieldDeleteResponse ipfCcmBoCheckFieldResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoCheckField(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckFieldUpdateRequest ipfCcmBoCheckFieldRequest = new IpfCcmBoCheckFieldUpdateRequest();
	   	ipfCcmBoCheckFieldRequest.setId("1");
	   	ipfCcmBoCheckFieldRequest.setIpfCcmBoCheckId("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyId("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyName("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyDesc("1");
	   	ipfCcmBoCheckFieldRequest.setBoName("1");
	   	ipfCcmBoCheckFieldRequest.setSeqNo("1");
        CompositeResponse<IpfCcmBoCheckFieldUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckFieldRequest, IpfCcmBoCheckFieldUpdateResponse.class, "ipfCcmBoCheckField.updateIpfCcmBoCheckField", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckFieldUpdateResponse ipfCcmBoCheckFieldResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoCheckField(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckFieldGetRequest ipfCcmBoCheckFieldRequest = new IpfCcmBoCheckFieldGetRequest();
	   	ipfCcmBoCheckFieldRequest.setId("1");
        CompositeResponse<IpfCcmBoCheckFieldGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckFieldRequest, IpfCcmBoCheckFieldGetResponse.class, "ipfCcmBoCheckField.getIpfCcmBoCheckField", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckFieldGetResponse ipfCcmBoCheckFieldResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckFieldSelectAllRequest ipfCcmBoCheckFieldRequest = new IpfCcmBoCheckFieldSelectAllRequest();

        CompositeResponse<IpfCcmBoCheckFieldSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckFieldRequest, IpfCcmBoCheckFieldSelectAllResponse.class, "ipfCcmBoCheckField.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckFieldSelectAllResponse ipfCcmBoCheckFieldResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckFieldCountAllRequest ipfCcmBoCheckFieldRequest = new IpfCcmBoCheckFieldCountAllRequest();

        CompositeResponse<IpfCcmBoCheckFieldCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckFieldRequest, IpfCcmBoCheckFieldCountAllResponse.class, "ipfCcmBoCheckField.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckFieldCountAllResponse ipfCcmBoCheckFieldResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoCheckFieldResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoCheckField(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckFieldSelectRequest ipfCcmBoCheckFieldRequest = new IpfCcmBoCheckFieldSelectRequest();
	   	ipfCcmBoCheckFieldRequest.setId("1");
	   	ipfCcmBoCheckFieldRequest.setIpfCcmBoCheckId("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyId("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyName("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyDesc("1");
	   	ipfCcmBoCheckFieldRequest.setBoName("1");
	   	ipfCcmBoCheckFieldRequest.setSeqNo("1");
        CompositeResponse<IpfCcmBoCheckFieldCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckFieldRequest, IpfCcmBoCheckFieldCreateResponse.class, "ipfCcmBoCheckField.createIpfCcmBoCheckField", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoCheckFieldRequest.setId("1");
	   	ipfCcmBoCheckFieldRequest.setIpfCcmBoCheckId("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyId("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyName("1");
	   	ipfCcmBoCheckFieldRequest.setPropertyDesc("1");
	   	ipfCcmBoCheckFieldRequest.setBoName("1");
	   	ipfCcmBoCheckFieldRequest.setSeqNo("1");
        CompositeResponse<IpfCcmBoCheckFieldSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoCheckFieldRequest, IpfCcmBoCheckFieldSelectResponse.class, "ipfCcmBoCheckField.selectIpfCcmBoCheckField", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckFieldSelectResponse ipfCcmBoCheckFieldResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoCheckFieldResponse.getResultJson());
        CompositeResponse<IpfCcmBoCheckFieldDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoCheckFieldRequest, IpfCcmBoCheckFieldDeleteResponse.class, "ipfCcmBoCheckField.deleteIpfCcmBoCheckField", "1.0");

    }
}
