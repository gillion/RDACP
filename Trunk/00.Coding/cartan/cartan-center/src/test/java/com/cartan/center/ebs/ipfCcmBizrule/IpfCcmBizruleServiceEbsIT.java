/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBizrule;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBizrule.request.*;
import com.cartan.center.ebs.ipfCcmBizrule.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBizruleServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBizruleServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleGetSessionRequest ipfCcmBizruleRequest = new IpfCcmBizruleGetSessionRequest();
     	CompositeResponse<IpfCcmBizruleGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBizruleRequest, IpfCcmBizruleGetSessionResponse.class, "ipfCcmBizrule.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBizrule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleCreateRequest ipfCcmBizruleRequest = new IpfCcmBizruleCreateRequest();
	   	ipfCcmBizruleRequest.setId("1");
	   	ipfCcmBizruleRequest.setRuleType("1");
	   	ipfCcmBizruleRequest.setRuleClass("1");
	   	ipfCcmBizruleRequest.setRuleCode("1");
	   	ipfCcmBizruleRequest.setRuleName("1");
	   	ipfCcmBizruleRequest.setRuleDes("1");
	   	ipfCcmBizruleRequest.setIsSystemCreate("1");
        CompositeResponse<IpfCcmBizruleCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleRequest, IpfCcmBizruleCreateResponse.class, "ipfCcmBizrule.createIpfCcmBizrule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleCreateResponse ipfCcmBizruleResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBizrule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDeleteRequest ipfCcmBizruleRequest = new IpfCcmBizruleDeleteRequest();
	   	ipfCcmBizruleRequest.setId("1");
        CompositeResponse<IpfCcmBizruleDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleRequest, IpfCcmBizruleDeleteResponse.class, "ipfCcmBizrule.deleteIpfCcmBizrule", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDeleteResponse ipfCcmBizruleResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBizrule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleUpdateRequest ipfCcmBizruleRequest = new IpfCcmBizruleUpdateRequest();
	   	ipfCcmBizruleRequest.setId("1");
	   	ipfCcmBizruleRequest.setRuleType("1");
	   	ipfCcmBizruleRequest.setRuleClass("1");
	   	ipfCcmBizruleRequest.setRuleCode("1");
	   	ipfCcmBizruleRequest.setRuleName("1");
	   	ipfCcmBizruleRequest.setRuleDes("1");
	   	ipfCcmBizruleRequest.setIsSystemCreate("1");
        CompositeResponse<IpfCcmBizruleUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleRequest, IpfCcmBizruleUpdateResponse.class, "ipfCcmBizrule.updateIpfCcmBizrule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleUpdateResponse ipfCcmBizruleResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBizrule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleGetRequest ipfCcmBizruleRequest = new IpfCcmBizruleGetRequest();
	   	ipfCcmBizruleRequest.setId("1");
        CompositeResponse<IpfCcmBizruleGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleRequest, IpfCcmBizruleGetResponse.class, "ipfCcmBizrule.getIpfCcmBizrule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleGetResponse ipfCcmBizruleResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleSelectAllRequest ipfCcmBizruleRequest = new IpfCcmBizruleSelectAllRequest();

        CompositeResponse<IpfCcmBizruleSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleRequest, IpfCcmBizruleSelectAllResponse.class, "ipfCcmBizrule.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleSelectAllResponse ipfCcmBizruleResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleCountAllRequest ipfCcmBizruleRequest = new IpfCcmBizruleCountAllRequest();

        CompositeResponse<IpfCcmBizruleCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleRequest, IpfCcmBizruleCountAllResponse.class, "ipfCcmBizrule.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleCountAllResponse ipfCcmBizruleResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBizruleResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBizrule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleSelectRequest ipfCcmBizruleRequest = new IpfCcmBizruleSelectRequest();
	   	ipfCcmBizruleRequest.setId("1");
	   	ipfCcmBizruleRequest.setRuleType("1");
	   	ipfCcmBizruleRequest.setRuleClass("1");
	   	ipfCcmBizruleRequest.setRuleCode("1");
	   	ipfCcmBizruleRequest.setRuleName("1");
	   	ipfCcmBizruleRequest.setRuleDes("1");
	   	ipfCcmBizruleRequest.setIsSystemCreate("1");
        CompositeResponse<IpfCcmBizruleCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleRequest, IpfCcmBizruleCreateResponse.class, "ipfCcmBizrule.createIpfCcmBizrule", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBizruleRequest.setId("1");
	   	ipfCcmBizruleRequest.setRuleType("1");
	   	ipfCcmBizruleRequest.setRuleClass("1");
	   	ipfCcmBizruleRequest.setRuleCode("1");
	   	ipfCcmBizruleRequest.setRuleName("1");
	   	ipfCcmBizruleRequest.setRuleDes("1");
	   	ipfCcmBizruleRequest.setIsSystemCreate("1");
        CompositeResponse<IpfCcmBizruleSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBizruleRequest, IpfCcmBizruleSelectResponse.class, "ipfCcmBizrule.selectIpfCcmBizrule", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleSelectResponse ipfCcmBizruleResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBizruleResponse.getResultJson());
        CompositeResponse<IpfCcmBizruleDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBizruleRequest, IpfCcmBizruleDeleteResponse.class, "ipfCcmBizrule.deleteIpfCcmBizrule", "1.0");

    }
}
