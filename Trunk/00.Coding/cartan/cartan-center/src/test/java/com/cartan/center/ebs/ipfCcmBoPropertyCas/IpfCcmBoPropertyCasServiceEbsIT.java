/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoPropertyCas;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoPropertyCas.request.*;
import com.cartan.center.ebs.ipfCcmBoPropertyCas.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoPropertyCasServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoPropertyCasServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyCasGetSessionRequest ipfCcmBoPropertyCasRequest = new IpfCcmBoPropertyCasGetSessionRequest();
     	CompositeResponse<IpfCcmBoPropertyCasGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoPropertyCasRequest, IpfCcmBoPropertyCasGetSessionResponse.class, "ipfCcmBoPropertyCas.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoPropertyCas(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyCasCreateRequest ipfCcmBoPropertyCasRequest = new IpfCcmBoPropertyCasCreateRequest();
	   	ipfCcmBoPropertyCasRequest.setId("1");
	   	ipfCcmBoPropertyCasRequest.setIpfCcmBoPropertyId("1");
	   	ipfCcmBoPropertyCasRequest.setCascadePropertyId("1");
	   	ipfCcmBoPropertyCasRequest.setOperation("1");
	   	ipfCcmBoPropertyCasRequest.setTargetPropertyName("1");
	   	ipfCcmBoPropertyCasRequest.setType("1");
        CompositeResponse<IpfCcmBoPropertyCasCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyCasRequest, IpfCcmBoPropertyCasCreateResponse.class, "ipfCcmBoPropertyCas.createIpfCcmBoPropertyCas", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyCasCreateResponse ipfCcmBoPropertyCasResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoPropertyCas(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyCasDeleteRequest ipfCcmBoPropertyCasRequest = new IpfCcmBoPropertyCasDeleteRequest();
	   	ipfCcmBoPropertyCasRequest.setId("1");
        CompositeResponse<IpfCcmBoPropertyCasDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyCasRequest, IpfCcmBoPropertyCasDeleteResponse.class, "ipfCcmBoPropertyCas.deleteIpfCcmBoPropertyCas", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyCasDeleteResponse ipfCcmBoPropertyCasResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoPropertyCas(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyCasUpdateRequest ipfCcmBoPropertyCasRequest = new IpfCcmBoPropertyCasUpdateRequest();
	   	ipfCcmBoPropertyCasRequest.setId("1");
	   	ipfCcmBoPropertyCasRequest.setIpfCcmBoPropertyId("1");
	   	ipfCcmBoPropertyCasRequest.setCascadePropertyId("1");
	   	ipfCcmBoPropertyCasRequest.setOperation("1");
	   	ipfCcmBoPropertyCasRequest.setTargetPropertyName("1");
	   	ipfCcmBoPropertyCasRequest.setType("1");
        CompositeResponse<IpfCcmBoPropertyCasUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyCasRequest, IpfCcmBoPropertyCasUpdateResponse.class, "ipfCcmBoPropertyCas.updateIpfCcmBoPropertyCas", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyCasUpdateResponse ipfCcmBoPropertyCasResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoPropertyCas(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyCasGetRequest ipfCcmBoPropertyCasRequest = new IpfCcmBoPropertyCasGetRequest();
	   	ipfCcmBoPropertyCasRequest.setId("1");
        CompositeResponse<IpfCcmBoPropertyCasGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyCasRequest, IpfCcmBoPropertyCasGetResponse.class, "ipfCcmBoPropertyCas.getIpfCcmBoPropertyCas", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyCasGetResponse ipfCcmBoPropertyCasResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyCasSelectAllRequest ipfCcmBoPropertyCasRequest = new IpfCcmBoPropertyCasSelectAllRequest();

        CompositeResponse<IpfCcmBoPropertyCasSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyCasRequest, IpfCcmBoPropertyCasSelectAllResponse.class, "ipfCcmBoPropertyCas.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyCasSelectAllResponse ipfCcmBoPropertyCasResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyCasCountAllRequest ipfCcmBoPropertyCasRequest = new IpfCcmBoPropertyCasCountAllRequest();

        CompositeResponse<IpfCcmBoPropertyCasCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyCasRequest, IpfCcmBoPropertyCasCountAllResponse.class, "ipfCcmBoPropertyCas.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyCasCountAllResponse ipfCcmBoPropertyCasResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoPropertyCasResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoPropertyCas(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyCasSelectRequest ipfCcmBoPropertyCasRequest = new IpfCcmBoPropertyCasSelectRequest();
	   	ipfCcmBoPropertyCasRequest.setId("1");
	   	ipfCcmBoPropertyCasRequest.setIpfCcmBoPropertyId("1");
	   	ipfCcmBoPropertyCasRequest.setCascadePropertyId("1");
	   	ipfCcmBoPropertyCasRequest.setOperation("1");
	   	ipfCcmBoPropertyCasRequest.setTargetPropertyName("1");
	   	ipfCcmBoPropertyCasRequest.setType("1");
        CompositeResponse<IpfCcmBoPropertyCasCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyCasRequest, IpfCcmBoPropertyCasCreateResponse.class, "ipfCcmBoPropertyCas.createIpfCcmBoPropertyCas", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoPropertyCasRequest.setId("1");
	   	ipfCcmBoPropertyCasRequest.setIpfCcmBoPropertyId("1");
	   	ipfCcmBoPropertyCasRequest.setCascadePropertyId("1");
	   	ipfCcmBoPropertyCasRequest.setOperation("1");
	   	ipfCcmBoPropertyCasRequest.setTargetPropertyName("1");
	   	ipfCcmBoPropertyCasRequest.setType("1");
        CompositeResponse<IpfCcmBoPropertyCasSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyCasRequest, IpfCcmBoPropertyCasSelectResponse.class, "ipfCcmBoPropertyCas.selectIpfCcmBoPropertyCas", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyCasSelectResponse ipfCcmBoPropertyCasResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoPropertyCasResponse.getResultJson());
        CompositeResponse<IpfCcmBoPropertyCasDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyCasRequest, IpfCcmBoPropertyCasDeleteResponse.class, "ipfCcmBoPropertyCas.deleteIpfCcmBoPropertyCas", "1.0");

    }
}
