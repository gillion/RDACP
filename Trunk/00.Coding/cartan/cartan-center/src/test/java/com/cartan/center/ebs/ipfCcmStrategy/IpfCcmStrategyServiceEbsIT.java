/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmStrategy;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmStrategy.request.*;
import com.cartan.center.ebs.ipfCcmStrategy.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmStrategyServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmStrategyServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyGetSessionRequest ipfCcmStrategyRequest = new IpfCcmStrategyGetSessionRequest();
     	CompositeResponse<IpfCcmStrategyGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmStrategyRequest, IpfCcmStrategyGetSessionResponse.class, "ipfCcmStrategy.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmStrategy(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyCreateRequest ipfCcmStrategyRequest = new IpfCcmStrategyCreateRequest();
	   	ipfCcmStrategyRequest.setId("1");
	   	ipfCcmStrategyRequest.setStrategyType("1");
	   	ipfCcmStrategyRequest.setStrategyCode("1");
	   	ipfCcmStrategyRequest.setStrategyName("1");
	   	ipfCcmStrategyRequest.setStrategyDes("1");
	   	ipfCcmStrategyRequest.setDrlFile("1");
	   	ipfCcmStrategyRequest.setDrlRoute("1");
	   	ipfCcmStrategyRequest.setPackageName("1");
	   	ipfCcmStrategyRequest.setRuleNo("1");
	   	ipfCcmStrategyRequest.setRuleType("1");
	   	ipfCcmStrategyRequest.setSourceCode("1");
	   	ipfCcmStrategyRequest.setSvnRevision("1");
        CompositeResponse<IpfCcmStrategyCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyRequest, IpfCcmStrategyCreateResponse.class, "ipfCcmStrategy.createIpfCcmStrategy", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyCreateResponse ipfCcmStrategyResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmStrategy(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyDeleteRequest ipfCcmStrategyRequest = new IpfCcmStrategyDeleteRequest();
	   	ipfCcmStrategyRequest.setId("1");
        CompositeResponse<IpfCcmStrategyDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyRequest, IpfCcmStrategyDeleteResponse.class, "ipfCcmStrategy.deleteIpfCcmStrategy", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyDeleteResponse ipfCcmStrategyResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmStrategy(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyUpdateRequest ipfCcmStrategyRequest = new IpfCcmStrategyUpdateRequest();
	   	ipfCcmStrategyRequest.setId("1");
	   	ipfCcmStrategyRequest.setStrategyType("1");
	   	ipfCcmStrategyRequest.setStrategyCode("1");
	   	ipfCcmStrategyRequest.setStrategyName("1");
	   	ipfCcmStrategyRequest.setStrategyDes("1");
	   	ipfCcmStrategyRequest.setDrlFile("1");
	   	ipfCcmStrategyRequest.setDrlRoute("1");
	   	ipfCcmStrategyRequest.setPackageName("1");
	   	ipfCcmStrategyRequest.setRuleNo("1");
	   	ipfCcmStrategyRequest.setRuleType("1");
	   	ipfCcmStrategyRequest.setSourceCode("1");
	   	ipfCcmStrategyRequest.setSvnRevision("1");
        CompositeResponse<IpfCcmStrategyUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyRequest, IpfCcmStrategyUpdateResponse.class, "ipfCcmStrategy.updateIpfCcmStrategy", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyUpdateResponse ipfCcmStrategyResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmStrategy(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyGetRequest ipfCcmStrategyRequest = new IpfCcmStrategyGetRequest();
	   	ipfCcmStrategyRequest.setId("1");
        CompositeResponse<IpfCcmStrategyGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyRequest, IpfCcmStrategyGetResponse.class, "ipfCcmStrategy.getIpfCcmStrategy", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyGetResponse ipfCcmStrategyResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategySelectAllRequest ipfCcmStrategyRequest = new IpfCcmStrategySelectAllRequest();

        CompositeResponse<IpfCcmStrategySelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyRequest, IpfCcmStrategySelectAllResponse.class, "ipfCcmStrategy.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategySelectAllResponse ipfCcmStrategyResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategyCountAllRequest ipfCcmStrategyRequest = new IpfCcmStrategyCountAllRequest();

        CompositeResponse<IpfCcmStrategyCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyRequest, IpfCcmStrategyCountAllResponse.class, "ipfCcmStrategy.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategyCountAllResponse ipfCcmStrategyResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmStrategyResponse.getResultString());
    }

    @Test
    public void selectIpfCcmStrategy(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmStrategySelectRequest ipfCcmStrategyRequest = new IpfCcmStrategySelectRequest();
	   	ipfCcmStrategyRequest.setId("1");
	   	ipfCcmStrategyRequest.setStrategyType("1");
	   	ipfCcmStrategyRequest.setStrategyCode("1");
	   	ipfCcmStrategyRequest.setStrategyName("1");
	   	ipfCcmStrategyRequest.setStrategyDes("1");
	   	ipfCcmStrategyRequest.setDrlFile("1");
	   	ipfCcmStrategyRequest.setDrlRoute("1");
	   	ipfCcmStrategyRequest.setPackageName("1");
	   	ipfCcmStrategyRequest.setRuleNo("1");
	   	ipfCcmStrategyRequest.setRuleType("1");
	   	ipfCcmStrategyRequest.setSourceCode("1");
	   	ipfCcmStrategyRequest.setSvnRevision("1");
        CompositeResponse<IpfCcmStrategyCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmStrategyRequest, IpfCcmStrategyCreateResponse.class, "ipfCcmStrategy.createIpfCcmStrategy", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmStrategyRequest.setId("1");
	   	ipfCcmStrategyRequest.setStrategyType("1");
	   	ipfCcmStrategyRequest.setStrategyCode("1");
	   	ipfCcmStrategyRequest.setStrategyName("1");
	   	ipfCcmStrategyRequest.setStrategyDes("1");
	   	ipfCcmStrategyRequest.setDrlFile("1");
	   	ipfCcmStrategyRequest.setDrlRoute("1");
	   	ipfCcmStrategyRequest.setPackageName("1");
	   	ipfCcmStrategyRequest.setRuleNo("1");
	   	ipfCcmStrategyRequest.setRuleType("1");
	   	ipfCcmStrategyRequest.setSourceCode("1");
	   	ipfCcmStrategyRequest.setSvnRevision("1");
        CompositeResponse<IpfCcmStrategySelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmStrategyRequest, IpfCcmStrategySelectResponse.class, "ipfCcmStrategy.selectIpfCcmStrategy", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmStrategySelectResponse ipfCcmStrategyResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmStrategyResponse.getResultJson());
        CompositeResponse<IpfCcmStrategyDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmStrategyRequest, IpfCcmStrategyDeleteResponse.class, "ipfCcmStrategy.deleteIpfCcmStrategy", "1.0");

    }
}
