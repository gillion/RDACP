/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmStrategyParam;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmStrategyParam.request.*;
import com.cartan.center.ebs.ipfCcmStrategyParam.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmStrategyParamServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmStrategyParamServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyParamGetSessionRequest ipfCcmStrategyParamRequest = new IpfCcmStrategyParamGetSessionRequest();
     	CompositeResponse<IpfCcmStrategyParamGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmStrategyParamRequest, IpfCcmStrategyParamGetSessionResponse.class, "ipfCcmStrategyParam.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmStrategyParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyParamCreateRequest ipfCcmStrategyParamRequest = new IpfCcmStrategyParamCreateRequest();
	   	ipfCcmStrategyParamRequest.setId("1");
	   	ipfCcmStrategyParamRequest.setIpfCcmStrategyId("1");
	   	ipfCcmStrategyParamRequest.setParamType("1");
	   	ipfCcmStrategyParamRequest.setParamName("1");
	   	ipfCcmStrategyParamRequest.setParamDes("1");
	   	ipfCcmStrategyParamRequest.setRtmConfigCode("1");
        CompositeResponse<IpfCcmStrategyParamCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyParamRequest, IpfCcmStrategyParamCreateResponse.class, "ipfCcmStrategyParam.createIpfCcmStrategyParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyParamCreateResponse ipfCcmStrategyParamResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmStrategyParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyParamDeleteRequest ipfCcmStrategyParamRequest = new IpfCcmStrategyParamDeleteRequest();
	   	ipfCcmStrategyParamRequest.setId("1");
        CompositeResponse<IpfCcmStrategyParamDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyParamRequest, IpfCcmStrategyParamDeleteResponse.class, "ipfCcmStrategyParam.deleteIpfCcmStrategyParam", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyParamDeleteResponse ipfCcmStrategyParamResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmStrategyParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyParamUpdateRequest ipfCcmStrategyParamRequest = new IpfCcmStrategyParamUpdateRequest();
	   	ipfCcmStrategyParamRequest.setId("1");
	   	ipfCcmStrategyParamRequest.setIpfCcmStrategyId("1");
	   	ipfCcmStrategyParamRequest.setParamType("1");
	   	ipfCcmStrategyParamRequest.setParamName("1");
	   	ipfCcmStrategyParamRequest.setParamDes("1");
	   	ipfCcmStrategyParamRequest.setRtmConfigCode("1");
        CompositeResponse<IpfCcmStrategyParamUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyParamRequest, IpfCcmStrategyParamUpdateResponse.class, "ipfCcmStrategyParam.updateIpfCcmStrategyParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyParamUpdateResponse ipfCcmStrategyParamResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmStrategyParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyParamGetRequest ipfCcmStrategyParamRequest = new IpfCcmStrategyParamGetRequest();
	   	ipfCcmStrategyParamRequest.setId("1");
        CompositeResponse<IpfCcmStrategyParamGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyParamRequest, IpfCcmStrategyParamGetResponse.class, "ipfCcmStrategyParam.getIpfCcmStrategyParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyParamGetResponse ipfCcmStrategyParamResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyParamSelectAllRequest ipfCcmStrategyParamRequest = new IpfCcmStrategyParamSelectAllRequest();

        CompositeResponse<IpfCcmStrategyParamSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyParamRequest, IpfCcmStrategyParamSelectAllResponse.class, "ipfCcmStrategyParam.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyParamSelectAllResponse ipfCcmStrategyParamResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyParamCountAllRequest ipfCcmStrategyParamRequest = new IpfCcmStrategyParamCountAllRequest();

        CompositeResponse<IpfCcmStrategyParamCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyParamRequest, IpfCcmStrategyParamCountAllResponse.class, "ipfCcmStrategyParam.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyParamCountAllResponse ipfCcmStrategyParamResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmStrategyParamResponse.getResultString());
    }

    @Test
    public void selectIpfCcmStrategyParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyParamSelectRequest ipfCcmStrategyParamRequest = new IpfCcmStrategyParamSelectRequest();
	   	ipfCcmStrategyParamRequest.setId("1");
	   	ipfCcmStrategyParamRequest.setIpfCcmStrategyId("1");
	   	ipfCcmStrategyParamRequest.setParamType("1");
	   	ipfCcmStrategyParamRequest.setParamName("1");
	   	ipfCcmStrategyParamRequest.setParamDes("1");
	   	ipfCcmStrategyParamRequest.setRtmConfigCode("1");
        CompositeResponse<IpfCcmStrategyParamCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyParamRequest, IpfCcmStrategyParamCreateResponse.class, "ipfCcmStrategyParam.createIpfCcmStrategyParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmStrategyParamRequest.setId("1");
	   	ipfCcmStrategyParamRequest.setIpfCcmStrategyId("1");
	   	ipfCcmStrategyParamRequest.setParamType("1");
	   	ipfCcmStrategyParamRequest.setParamName("1");
	   	ipfCcmStrategyParamRequest.setParamDes("1");
	   	ipfCcmStrategyParamRequest.setRtmConfigCode("1");
        CompositeResponse<IpfCcmStrategyParamSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmStrategyParamRequest, IpfCcmStrategyParamSelectResponse.class, "ipfCcmStrategyParam.selectIpfCcmStrategyParam", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyParamSelectResponse ipfCcmStrategyParamResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmStrategyParamResponse.getResultJson());
        CompositeResponse<IpfCcmStrategyParamDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmStrategyParamRequest, IpfCcmStrategyParamDeleteResponse.class, "ipfCcmStrategyParam.deleteIpfCcmStrategyParam", "1.0");

    }
}
