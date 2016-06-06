/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfReqRule;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfReqRule.request.*;
import com.cartan.center.ebs.ipfReqRule.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfReqRuleServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfReqRuleServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfReqRuleGetSessionRequest ipfReqRuleRequest = new IpfReqRuleGetSessionRequest();
     	CompositeResponse<IpfReqRuleGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfReqRuleRequest, IpfReqRuleGetSessionResponse.class, "ipfReqRule.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfReqRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfReqRuleCreateRequest ipfReqRuleRequest = new IpfReqRuleCreateRequest();
	   	ipfReqRuleRequest.setId("1");
	   	ipfReqRuleRequest.setRuleName("1");
	   	ipfReqRuleRequest.setRuleNo("1");
	   	ipfReqRuleRequest.setRuleType("1");
	   	ipfReqRuleRequest.setRuleStatus("1");
	   	ipfReqRuleRequest.setTriggerType("1");
	   	ipfReqRuleRequest.setPhysicalLocation("1");
	   	ipfReqRuleRequest.setActionType("1");
	   	ipfReqRuleRequest.setBusinessLocation("1");
	   	ipfReqRuleRequest.setBusinessModule("1");
	   	ipfReqRuleRequest.setDroolsAttribute("1");
	   	ipfReqRuleRequest.setRuleDesc("1");
	   	ipfReqRuleRequest.setIsDecisionTable("1");
	   	ipfReqRuleRequest.setPublicType("1");
	   	ipfReqRuleRequest.setIpfCcmBoId("1");
	   	ipfReqRuleRequest.setImportDesc("1");
	   	ipfReqRuleRequest.setDroolsWhen("1");
	   	ipfReqRuleRequest.setDroolsThen("1");
	   	ipfReqRuleRequest.setRemark("1");
        CompositeResponse<IpfReqRuleCreateResponse> response =
                ropClient.buildClientRequest().get(ipfReqRuleRequest, IpfReqRuleCreateResponse.class, "ipfReqRule.createIpfReqRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfReqRuleCreateResponse ipfReqRuleResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfReqRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfReqRuleDeleteRequest ipfReqRuleRequest = new IpfReqRuleDeleteRequest();
	   	ipfReqRuleRequest.setId("1");
        CompositeResponse<IpfReqRuleDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfReqRuleRequest, IpfReqRuleDeleteResponse.class, "ipfReqRule.deleteIpfReqRule", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfReqRuleDeleteResponse ipfReqRuleResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfReqRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfReqRuleUpdateRequest ipfReqRuleRequest = new IpfReqRuleUpdateRequest();
	   	ipfReqRuleRequest.setId("1");
	   	ipfReqRuleRequest.setRuleName("1");
	   	ipfReqRuleRequest.setRuleNo("1");
	   	ipfReqRuleRequest.setRuleType("1");
	   	ipfReqRuleRequest.setRuleStatus("1");
	   	ipfReqRuleRequest.setTriggerType("1");
	   	ipfReqRuleRequest.setPhysicalLocation("1");
	   	ipfReqRuleRequest.setActionType("1");
	   	ipfReqRuleRequest.setBusinessLocation("1");
	   	ipfReqRuleRequest.setBusinessModule("1");
	   	ipfReqRuleRequest.setDroolsAttribute("1");
	   	ipfReqRuleRequest.setRuleDesc("1");
	   	ipfReqRuleRequest.setIsDecisionTable("1");
	   	ipfReqRuleRequest.setPublicType("1");
	   	ipfReqRuleRequest.setIpfCcmBoId("1");
	   	ipfReqRuleRequest.setImportDesc("1");
	   	ipfReqRuleRequest.setDroolsWhen("1");
	   	ipfReqRuleRequest.setDroolsThen("1");
	   	ipfReqRuleRequest.setRemark("1");
        CompositeResponse<IpfReqRuleUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfReqRuleRequest, IpfReqRuleUpdateResponse.class, "ipfReqRule.updateIpfReqRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfReqRuleUpdateResponse ipfReqRuleResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfReqRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfReqRuleGetRequest ipfReqRuleRequest = new IpfReqRuleGetRequest();
	   	ipfReqRuleRequest.setId("1");
        CompositeResponse<IpfReqRuleGetResponse> response =
                ropClient.buildClientRequest().get(ipfReqRuleRequest, IpfReqRuleGetResponse.class, "ipfReqRule.getIpfReqRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfReqRuleGetResponse ipfReqRuleResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfReqRuleSelectAllRequest ipfReqRuleRequest = new IpfReqRuleSelectAllRequest();

        CompositeResponse<IpfReqRuleSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfReqRuleRequest, IpfReqRuleSelectAllResponse.class, "ipfReqRule.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfReqRuleSelectAllResponse ipfReqRuleResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfReqRuleCountAllRequest ipfReqRuleRequest = new IpfReqRuleCountAllRequest();

        CompositeResponse<IpfReqRuleCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfReqRuleRequest, IpfReqRuleCountAllResponse.class, "ipfReqRule.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfReqRuleCountAllResponse ipfReqRuleResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfReqRuleResponse.getResultString());
    }

    @Test
    public void selectIpfReqRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfReqRuleSelectRequest ipfReqRuleRequest = new IpfReqRuleSelectRequest();
	   	ipfReqRuleRequest.setId("1");
	   	ipfReqRuleRequest.setRuleName("1");
	   	ipfReqRuleRequest.setRuleNo("1");
	   	ipfReqRuleRequest.setRuleType("1");
	   	ipfReqRuleRequest.setRuleStatus("1");
	   	ipfReqRuleRequest.setTriggerType("1");
	   	ipfReqRuleRequest.setPhysicalLocation("1");
	   	ipfReqRuleRequest.setActionType("1");
	   	ipfReqRuleRequest.setBusinessLocation("1");
	   	ipfReqRuleRequest.setBusinessModule("1");
	   	ipfReqRuleRequest.setDroolsAttribute("1");
	   	ipfReqRuleRequest.setRuleDesc("1");
	   	ipfReqRuleRequest.setIsDecisionTable("1");
	   	ipfReqRuleRequest.setPublicType("1");
	   	ipfReqRuleRequest.setIpfCcmBoId("1");
	   	ipfReqRuleRequest.setImportDesc("1");
	   	ipfReqRuleRequest.setDroolsWhen("1");
	   	ipfReqRuleRequest.setDroolsThen("1");
	   	ipfReqRuleRequest.setRemark("1");
        CompositeResponse<IpfReqRuleCreateResponse> response =
                ropClient.buildClientRequest().get(ipfReqRuleRequest, IpfReqRuleCreateResponse.class, "ipfReqRule.createIpfReqRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfReqRuleRequest.setId("1");
	   	ipfReqRuleRequest.setRuleName("1");
	   	ipfReqRuleRequest.setRuleNo("1");
	   	ipfReqRuleRequest.setRuleType("1");
	   	ipfReqRuleRequest.setRuleStatus("1");
	   	ipfReqRuleRequest.setTriggerType("1");
	   	ipfReqRuleRequest.setPhysicalLocation("1");
	   	ipfReqRuleRequest.setActionType("1");
	   	ipfReqRuleRequest.setBusinessLocation("1");
	   	ipfReqRuleRequest.setBusinessModule("1");
	   	ipfReqRuleRequest.setDroolsAttribute("1");
	   	ipfReqRuleRequest.setRuleDesc("1");
	   	ipfReqRuleRequest.setIsDecisionTable("1");
	   	ipfReqRuleRequest.setPublicType("1");
	   	ipfReqRuleRequest.setIpfCcmBoId("1");
	   	ipfReqRuleRequest.setImportDesc("1");
	   	ipfReqRuleRequest.setDroolsWhen("1");
	   	ipfReqRuleRequest.setDroolsThen("1");
	   	ipfReqRuleRequest.setRemark("1");
        CompositeResponse<IpfReqRuleSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfReqRuleRequest, IpfReqRuleSelectResponse.class, "ipfReqRule.selectIpfReqRule", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfReqRuleSelectResponse ipfReqRuleResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfReqRuleResponse.getResultJson());
        CompositeResponse<IpfReqRuleDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfReqRuleRequest, IpfReqRuleDeleteResponse.class, "ipfReqRule.deleteIpfReqRule", "1.0");

    }
}
