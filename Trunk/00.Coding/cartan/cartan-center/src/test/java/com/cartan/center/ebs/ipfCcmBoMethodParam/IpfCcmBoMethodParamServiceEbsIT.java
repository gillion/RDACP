/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoMethodParam;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoMethodParam.request.*;
import com.cartan.center.ebs.ipfCcmBoMethodParam.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoMethodParamServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoMethodParamServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodParamGetSessionRequest ipfCcmBoMethodParamRequest = new IpfCcmBoMethodParamGetSessionRequest();
     	CompositeResponse<IpfCcmBoMethodParamGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoMethodParamRequest, IpfCcmBoMethodParamGetSessionResponse.class, "ipfCcmBoMethodParam.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoMethodParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodParamCreateRequest ipfCcmBoMethodParamRequest = new IpfCcmBoMethodParamCreateRequest();
	   	ipfCcmBoMethodParamRequest.setId("1");
	   	ipfCcmBoMethodParamRequest.setIpfCcmBoMethodId("1");
	   	ipfCcmBoMethodParamRequest.setConstantValue("1");
	   	ipfCcmBoMethodParamRequest.setIsCondition("1");
	   	ipfCcmBoMethodParamRequest.setMethodName("1");
	   	ipfCcmBoMethodParamRequest.setParamName("1");
	   	ipfCcmBoMethodParamRequest.setParamRef("1");
	   	ipfCcmBoMethodParamRequest.setParamType("1");
	   	ipfCcmBoMethodParamRequest.setBoNameRef("1");
        CompositeResponse<IpfCcmBoMethodParamCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodParamRequest, IpfCcmBoMethodParamCreateResponse.class, "ipfCcmBoMethodParam.createIpfCcmBoMethodParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodParamCreateResponse ipfCcmBoMethodParamResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoMethodParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodParamDeleteRequest ipfCcmBoMethodParamRequest = new IpfCcmBoMethodParamDeleteRequest();
	   	ipfCcmBoMethodParamRequest.setId("1");
        CompositeResponse<IpfCcmBoMethodParamDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodParamRequest, IpfCcmBoMethodParamDeleteResponse.class, "ipfCcmBoMethodParam.deleteIpfCcmBoMethodParam", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodParamDeleteResponse ipfCcmBoMethodParamResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoMethodParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodParamUpdateRequest ipfCcmBoMethodParamRequest = new IpfCcmBoMethodParamUpdateRequest();
	   	ipfCcmBoMethodParamRequest.setId("1");
	   	ipfCcmBoMethodParamRequest.setIpfCcmBoMethodId("1");
	   	ipfCcmBoMethodParamRequest.setConstantValue("1");
	   	ipfCcmBoMethodParamRequest.setIsCondition("1");
	   	ipfCcmBoMethodParamRequest.setMethodName("1");
	   	ipfCcmBoMethodParamRequest.setParamName("1");
	   	ipfCcmBoMethodParamRequest.setParamRef("1");
	   	ipfCcmBoMethodParamRequest.setParamType("1");
	   	ipfCcmBoMethodParamRequest.setBoNameRef("1");
        CompositeResponse<IpfCcmBoMethodParamUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodParamRequest, IpfCcmBoMethodParamUpdateResponse.class, "ipfCcmBoMethodParam.updateIpfCcmBoMethodParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodParamUpdateResponse ipfCcmBoMethodParamResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoMethodParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodParamGetRequest ipfCcmBoMethodParamRequest = new IpfCcmBoMethodParamGetRequest();
	   	ipfCcmBoMethodParamRequest.setId("1");
        CompositeResponse<IpfCcmBoMethodParamGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodParamRequest, IpfCcmBoMethodParamGetResponse.class, "ipfCcmBoMethodParam.getIpfCcmBoMethodParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodParamGetResponse ipfCcmBoMethodParamResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodParamSelectAllRequest ipfCcmBoMethodParamRequest = new IpfCcmBoMethodParamSelectAllRequest();

        CompositeResponse<IpfCcmBoMethodParamSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodParamRequest, IpfCcmBoMethodParamSelectAllResponse.class, "ipfCcmBoMethodParam.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodParamSelectAllResponse ipfCcmBoMethodParamResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodParamCountAllRequest ipfCcmBoMethodParamRequest = new IpfCcmBoMethodParamCountAllRequest();

        CompositeResponse<IpfCcmBoMethodParamCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodParamRequest, IpfCcmBoMethodParamCountAllResponse.class, "ipfCcmBoMethodParam.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodParamCountAllResponse ipfCcmBoMethodParamResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoMethodParamResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoMethodParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodParamSelectRequest ipfCcmBoMethodParamRequest = new IpfCcmBoMethodParamSelectRequest();
	   	ipfCcmBoMethodParamRequest.setId("1");
	   	ipfCcmBoMethodParamRequest.setIpfCcmBoMethodId("1");
	   	ipfCcmBoMethodParamRequest.setConstantValue("1");
	   	ipfCcmBoMethodParamRequest.setIsCondition("1");
	   	ipfCcmBoMethodParamRequest.setMethodName("1");
	   	ipfCcmBoMethodParamRequest.setParamName("1");
	   	ipfCcmBoMethodParamRequest.setParamRef("1");
	   	ipfCcmBoMethodParamRequest.setParamType("1");
	   	ipfCcmBoMethodParamRequest.setBoNameRef("1");
        CompositeResponse<IpfCcmBoMethodParamCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodParamRequest, IpfCcmBoMethodParamCreateResponse.class, "ipfCcmBoMethodParam.createIpfCcmBoMethodParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoMethodParamRequest.setId("1");
	   	ipfCcmBoMethodParamRequest.setIpfCcmBoMethodId("1");
	   	ipfCcmBoMethodParamRequest.setConstantValue("1");
	   	ipfCcmBoMethodParamRequest.setIsCondition("1");
	   	ipfCcmBoMethodParamRequest.setMethodName("1");
	   	ipfCcmBoMethodParamRequest.setParamName("1");
	   	ipfCcmBoMethodParamRequest.setParamRef("1");
	   	ipfCcmBoMethodParamRequest.setParamType("1");
	   	ipfCcmBoMethodParamRequest.setBoNameRef("1");
        CompositeResponse<IpfCcmBoMethodParamSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoMethodParamRequest, IpfCcmBoMethodParamSelectResponse.class, "ipfCcmBoMethodParam.selectIpfCcmBoMethodParam", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodParamSelectResponse ipfCcmBoMethodParamResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoMethodParamResponse.getResultJson());
        CompositeResponse<IpfCcmBoMethodParamDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoMethodParamRequest, IpfCcmBoMethodParamDeleteResponse.class, "ipfCcmBoMethodParam.deleteIpfCcmBoMethodParam", "1.0");

    }
}
