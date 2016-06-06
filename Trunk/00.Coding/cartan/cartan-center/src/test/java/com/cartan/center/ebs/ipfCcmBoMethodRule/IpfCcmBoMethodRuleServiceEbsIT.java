/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoMethodRule;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoMethodRule.request.*;
import com.cartan.center.ebs.ipfCcmBoMethodRule.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoMethodRuleServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoMethodRuleServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodRuleGetSessionRequest ipfCcmBoMethodRuleRequest = new IpfCcmBoMethodRuleGetSessionRequest();
     	CompositeResponse<IpfCcmBoMethodRuleGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoMethodRuleRequest, IpfCcmBoMethodRuleGetSessionResponse.class, "ipfCcmBoMethodRule.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoMethodRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodRuleCreateRequest ipfCcmBoMethodRuleRequest = new IpfCcmBoMethodRuleCreateRequest();
	   	ipfCcmBoMethodRuleRequest.setId("1");
	   	ipfCcmBoMethodRuleRequest.setIpfCcbBoMethodId("1");
	   	ipfCcmBoMethodRuleRequest.setRuleNo("1");
	   	ipfCcmBoMethodRuleRequest.setRuleName("1");
	   	ipfCcmBoMethodRuleRequest.setInvokePoint("1");
	   	ipfCcmBoMethodRuleRequest.setInvokeOrder("1");
	   	ipfCcmBoMethodRuleRequest.setRuleId("1");
        CompositeResponse<IpfCcmBoMethodRuleCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRuleRequest, IpfCcmBoMethodRuleCreateResponse.class, "ipfCcmBoMethodRule.createIpfCcmBoMethodRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodRuleCreateResponse ipfCcmBoMethodRuleResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoMethodRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodRuleDeleteRequest ipfCcmBoMethodRuleRequest = new IpfCcmBoMethodRuleDeleteRequest();
	   	ipfCcmBoMethodRuleRequest.setId("1");
        CompositeResponse<IpfCcmBoMethodRuleDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRuleRequest, IpfCcmBoMethodRuleDeleteResponse.class, "ipfCcmBoMethodRule.deleteIpfCcmBoMethodRule", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodRuleDeleteResponse ipfCcmBoMethodRuleResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoMethodRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodRuleUpdateRequest ipfCcmBoMethodRuleRequest = new IpfCcmBoMethodRuleUpdateRequest();
	   	ipfCcmBoMethodRuleRequest.setId("1");
	   	ipfCcmBoMethodRuleRequest.setIpfCcbBoMethodId("1");
	   	ipfCcmBoMethodRuleRequest.setRuleNo("1");
	   	ipfCcmBoMethodRuleRequest.setRuleName("1");
	   	ipfCcmBoMethodRuleRequest.setInvokePoint("1");
	   	ipfCcmBoMethodRuleRequest.setInvokeOrder("1");
	   	ipfCcmBoMethodRuleRequest.setRuleId("1");
        CompositeResponse<IpfCcmBoMethodRuleUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRuleRequest, IpfCcmBoMethodRuleUpdateResponse.class, "ipfCcmBoMethodRule.updateIpfCcmBoMethodRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodRuleUpdateResponse ipfCcmBoMethodRuleResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoMethodRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodRuleGetRequest ipfCcmBoMethodRuleRequest = new IpfCcmBoMethodRuleGetRequest();
	   	ipfCcmBoMethodRuleRequest.setId("1");
        CompositeResponse<IpfCcmBoMethodRuleGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRuleRequest, IpfCcmBoMethodRuleGetResponse.class, "ipfCcmBoMethodRule.getIpfCcmBoMethodRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodRuleGetResponse ipfCcmBoMethodRuleResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodRuleSelectAllRequest ipfCcmBoMethodRuleRequest = new IpfCcmBoMethodRuleSelectAllRequest();

        CompositeResponse<IpfCcmBoMethodRuleSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRuleRequest, IpfCcmBoMethodRuleSelectAllResponse.class, "ipfCcmBoMethodRule.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodRuleSelectAllResponse ipfCcmBoMethodRuleResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodRuleCountAllRequest ipfCcmBoMethodRuleRequest = new IpfCcmBoMethodRuleCountAllRequest();

        CompositeResponse<IpfCcmBoMethodRuleCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRuleRequest, IpfCcmBoMethodRuleCountAllResponse.class, "ipfCcmBoMethodRule.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodRuleCountAllResponse ipfCcmBoMethodRuleResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoMethodRuleResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoMethodRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodRuleSelectRequest ipfCcmBoMethodRuleRequest = new IpfCcmBoMethodRuleSelectRequest();
	   	ipfCcmBoMethodRuleRequest.setId("1");
	   	ipfCcmBoMethodRuleRequest.setIpfCcbBoMethodId("1");
	   	ipfCcmBoMethodRuleRequest.setRuleNo("1");
	   	ipfCcmBoMethodRuleRequest.setRuleName("1");
	   	ipfCcmBoMethodRuleRequest.setInvokePoint("1");
	   	ipfCcmBoMethodRuleRequest.setInvokeOrder("1");
	   	ipfCcmBoMethodRuleRequest.setRuleId("1");
        CompositeResponse<IpfCcmBoMethodRuleCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRuleRequest, IpfCcmBoMethodRuleCreateResponse.class, "ipfCcmBoMethodRule.createIpfCcmBoMethodRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoMethodRuleRequest.setId("1");
	   	ipfCcmBoMethodRuleRequest.setIpfCcbBoMethodId("1");
	   	ipfCcmBoMethodRuleRequest.setRuleNo("1");
	   	ipfCcmBoMethodRuleRequest.setRuleName("1");
	   	ipfCcmBoMethodRuleRequest.setInvokePoint("1");
	   	ipfCcmBoMethodRuleRequest.setInvokeOrder("1");
	   	ipfCcmBoMethodRuleRequest.setRuleId("1");
        CompositeResponse<IpfCcmBoMethodRuleSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRuleRequest, IpfCcmBoMethodRuleSelectResponse.class, "ipfCcmBoMethodRule.selectIpfCcmBoMethodRule", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodRuleSelectResponse ipfCcmBoMethodRuleResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoMethodRuleResponse.getResultJson());
        CompositeResponse<IpfCcmBoMethodRuleDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRuleRequest, IpfCcmBoMethodRuleDeleteResponse.class, "ipfCcmBoMethodRule.deleteIpfCcmBoMethodRule", "1.0");

    }
}
