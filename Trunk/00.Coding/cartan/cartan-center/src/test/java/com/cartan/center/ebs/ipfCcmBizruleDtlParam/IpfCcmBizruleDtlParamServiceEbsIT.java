/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBizruleDtlParam;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBizruleDtlParam.request.*;
import com.cartan.center.ebs.ipfCcmBizruleDtlParam.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBizruleDtlParamServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBizruleDtlParamServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlParamGetSessionRequest ipfCcmBizruleDtlParamRequest = new IpfCcmBizruleDtlParamGetSessionRequest();
     	CompositeResponse<IpfCcmBizruleDtlParamGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBizruleDtlParamRequest, IpfCcmBizruleDtlParamGetSessionResponse.class, "ipfCcmBizruleDtlParam.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBizruleDtlParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlParamCreateRequest ipfCcmBizruleDtlParamRequest = new IpfCcmBizruleDtlParamCreateRequest();
	   	ipfCcmBizruleDtlParamRequest.setId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmBizruleId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmStrategyId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmStrategyParamId("1");
	   	ipfCcmBizruleDtlParamRequest.setParamName("1");
	   	ipfCcmBizruleDtlParamRequest.setParamDes("1");
	   	ipfCcmBizruleDtlParamRequest.setParamValue("1");
	   	ipfCcmBizruleDtlParamRequest.setParamValueDes("1");
        CompositeResponse<IpfCcmBizruleDtlParamCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlParamRequest, IpfCcmBizruleDtlParamCreateResponse.class, "ipfCcmBizruleDtlParam.createIpfCcmBizruleDtlParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlParamCreateResponse ipfCcmBizruleDtlParamResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBizruleDtlParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlParamDeleteRequest ipfCcmBizruleDtlParamRequest = new IpfCcmBizruleDtlParamDeleteRequest();
	   	ipfCcmBizruleDtlParamRequest.setId("1");
        CompositeResponse<IpfCcmBizruleDtlParamDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlParamRequest, IpfCcmBizruleDtlParamDeleteResponse.class, "ipfCcmBizruleDtlParam.deleteIpfCcmBizruleDtlParam", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlParamDeleteResponse ipfCcmBizruleDtlParamResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBizruleDtlParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlParamUpdateRequest ipfCcmBizruleDtlParamRequest = new IpfCcmBizruleDtlParamUpdateRequest();
	   	ipfCcmBizruleDtlParamRequest.setId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmBizruleId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmStrategyId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmStrategyParamId("1");
	   	ipfCcmBizruleDtlParamRequest.setParamName("1");
	   	ipfCcmBizruleDtlParamRequest.setParamDes("1");
	   	ipfCcmBizruleDtlParamRequest.setParamValue("1");
	   	ipfCcmBizruleDtlParamRequest.setParamValueDes("1");
        CompositeResponse<IpfCcmBizruleDtlParamUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlParamRequest, IpfCcmBizruleDtlParamUpdateResponse.class, "ipfCcmBizruleDtlParam.updateIpfCcmBizruleDtlParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlParamUpdateResponse ipfCcmBizruleDtlParamResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBizruleDtlParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlParamGetRequest ipfCcmBizruleDtlParamRequest = new IpfCcmBizruleDtlParamGetRequest();
	   	ipfCcmBizruleDtlParamRequest.setId("1");
        CompositeResponse<IpfCcmBizruleDtlParamGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlParamRequest, IpfCcmBizruleDtlParamGetResponse.class, "ipfCcmBizruleDtlParam.getIpfCcmBizruleDtlParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlParamGetResponse ipfCcmBizruleDtlParamResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlParamSelectAllRequest ipfCcmBizruleDtlParamRequest = new IpfCcmBizruleDtlParamSelectAllRequest();

        CompositeResponse<IpfCcmBizruleDtlParamSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlParamRequest, IpfCcmBizruleDtlParamSelectAllResponse.class, "ipfCcmBizruleDtlParam.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlParamSelectAllResponse ipfCcmBizruleDtlParamResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlParamCountAllRequest ipfCcmBizruleDtlParamRequest = new IpfCcmBizruleDtlParamCountAllRequest();

        CompositeResponse<IpfCcmBizruleDtlParamCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlParamRequest, IpfCcmBizruleDtlParamCountAllResponse.class, "ipfCcmBizruleDtlParam.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlParamCountAllResponse ipfCcmBizruleDtlParamResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBizruleDtlParamResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBizruleDtlParam(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlParamSelectRequest ipfCcmBizruleDtlParamRequest = new IpfCcmBizruleDtlParamSelectRequest();
	   	ipfCcmBizruleDtlParamRequest.setId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmBizruleId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmStrategyId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmStrategyParamId("1");
	   	ipfCcmBizruleDtlParamRequest.setParamName("1");
	   	ipfCcmBizruleDtlParamRequest.setParamDes("1");
	   	ipfCcmBizruleDtlParamRequest.setParamValue("1");
	   	ipfCcmBizruleDtlParamRequest.setParamValueDes("1");
        CompositeResponse<IpfCcmBizruleDtlParamCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlParamRequest, IpfCcmBizruleDtlParamCreateResponse.class, "ipfCcmBizruleDtlParam.createIpfCcmBizruleDtlParam", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBizruleDtlParamRequest.setId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmBizruleId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmStrategyId("1");
	   	ipfCcmBizruleDtlParamRequest.setIpfCcmStrategyParamId("1");
	   	ipfCcmBizruleDtlParamRequest.setParamName("1");
	   	ipfCcmBizruleDtlParamRequest.setParamDes("1");
	   	ipfCcmBizruleDtlParamRequest.setParamValue("1");
	   	ipfCcmBizruleDtlParamRequest.setParamValueDes("1");
        CompositeResponse<IpfCcmBizruleDtlParamSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlParamRequest, IpfCcmBizruleDtlParamSelectResponse.class, "ipfCcmBizruleDtlParam.selectIpfCcmBizruleDtlParam", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlParamSelectResponse ipfCcmBizruleDtlParamResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBizruleDtlParamResponse.getResultJson());
        CompositeResponse<IpfCcmBizruleDtlParamDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlParamRequest, IpfCcmBizruleDtlParamDeleteResponse.class, "ipfCcmBizruleDtlParam.deleteIpfCcmBizruleDtlParam", "1.0");

    }
}
