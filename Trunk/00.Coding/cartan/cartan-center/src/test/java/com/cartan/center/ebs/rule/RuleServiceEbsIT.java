/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.rule;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.rule.request.*;
import com.cartan.center.ebs.rule.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class RuleServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(RuleServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleGetSessionRequest ruleRequest = new RuleGetSessionRequest();
     	CompositeResponse<RuleGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ruleRequest, RuleGetSessionResponse.class, "rule.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleCreateRequest ruleRequest = new RuleCreateRequest();
	   	ruleRequest.setId("1");
	   	ruleRequest.setRuleName("1");
	   	ruleRequest.setRulesetId("1");
	   	ruleRequest.setIsUsed("1");
	   	ruleRequest.setPriLevel("1");
	   	ruleRequest.setContentType("1");
	   	ruleRequest.setEffectDate("1");
	   	ruleRequest.setInvalidDate("1");
	   	ruleRequest.setCreator("1");
	   	ruleRequest.setCreateDate("1");
	   	ruleRequest.setModifyDate("1");
	   	ruleRequest.setModifyed("1");
	   	ruleRequest.setOwner("1");
	   	ruleRequest.setLocked("1");
        CompositeResponse<RuleCreateResponse> response =
                ropClient.buildClientRequest().get(ruleRequest, RuleCreateResponse.class, "rule.createRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleCreateResponse ruleResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleDeleteRequest ruleRequest = new RuleDeleteRequest();
	   	ruleRequest.setId("1");
        CompositeResponse<RuleDeleteResponse> response =
                ropClient.buildClientRequest().get(ruleRequest, RuleDeleteResponse.class, "rule.deleteRule", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleDeleteResponse ruleResponse = response.getSuccessResponse();
    }




    @Test
    public void updateRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleUpdateRequest ruleRequest = new RuleUpdateRequest();
	   	ruleRequest.setId("1");
	   	ruleRequest.setRuleName("1");
	   	ruleRequest.setRulesetId("1");
	   	ruleRequest.setIsUsed("1");
	   	ruleRequest.setPriLevel("1");
	   	ruleRequest.setContentType("1");
	   	ruleRequest.setEffectDate("1");
	   	ruleRequest.setInvalidDate("1");
	   	ruleRequest.setCreator("1");
	   	ruleRequest.setCreateDate("1");
	   	ruleRequest.setModifyDate("1");
	   	ruleRequest.setModifyed("1");
	   	ruleRequest.setOwner("1");
	   	ruleRequest.setLocked("1");
        CompositeResponse<RuleUpdateResponse> response =
                ropClient.buildClientRequest().get(ruleRequest, RuleUpdateResponse.class, "rule.updateRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleUpdateResponse ruleResponse = response.getSuccessResponse();
    }


    @Test
    public void getRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleGetRequest ruleRequest = new RuleGetRequest();
	   	ruleRequest.setId("1");
        CompositeResponse<RuleGetResponse> response =
                ropClient.buildClientRequest().get(ruleRequest, RuleGetResponse.class, "rule.getRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleGetResponse ruleResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleSelectAllRequest ruleRequest = new RuleSelectAllRequest();

        CompositeResponse<RuleSelectAllResponse> response =
                ropClient.buildClientRequest().get(ruleRequest, RuleSelectAllResponse.class, "rule.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleSelectAllResponse ruleResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleCountAllRequest ruleRequest = new RuleCountAllRequest();

        CompositeResponse<RuleCountAllResponse> response =
                ropClient.buildClientRequest().get(ruleRequest, RuleCountAllResponse.class, "rule.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleCountAllResponse ruleResponse = response.getSuccessResponse();
        Assert.assertNotNull(ruleResponse.getResultString());
    }

    @Test
    public void selectRule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleSelectRequest ruleRequest = new RuleSelectRequest();
	   	ruleRequest.setId("1");
	   	ruleRequest.setRuleName("1");
	   	ruleRequest.setRulesetId("1");
	   	ruleRequest.setIsUsed("1");
	   	ruleRequest.setPriLevel("1");
	   	ruleRequest.setContentType("1");
	   	ruleRequest.setEffectDate("1");
	   	ruleRequest.setInvalidDate("1");
	   	ruleRequest.setCreator("1");
	   	ruleRequest.setCreateDate("1");
	   	ruleRequest.setModifyDate("1");
	   	ruleRequest.setModifyed("1");
	   	ruleRequest.setOwner("1");
	   	ruleRequest.setLocked("1");
        CompositeResponse<RuleCreateResponse> response =
                ropClient.buildClientRequest().get(ruleRequest, RuleCreateResponse.class, "rule.createRule", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ruleRequest.setId("1");
	   	ruleRequest.setRuleName("1");
	   	ruleRequest.setRulesetId("1");
	   	ruleRequest.setIsUsed("1");
	   	ruleRequest.setPriLevel("1");
	   	ruleRequest.setContentType("1");
	   	ruleRequest.setEffectDate("1");
	   	ruleRequest.setInvalidDate("1");
	   	ruleRequest.setCreator("1");
	   	ruleRequest.setCreateDate("1");
	   	ruleRequest.setModifyDate("1");
	   	ruleRequest.setModifyed("1");
	   	ruleRequest.setOwner("1");
	   	ruleRequest.setLocked("1");
        CompositeResponse<RuleSelectResponse> response1 =
                ropClient.buildClientRequest().get(ruleRequest, RuleSelectResponse.class, "rule.selectRule", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleSelectResponse ruleResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ruleResponse.getResultJson());
        CompositeResponse<RuleDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ruleRequest, RuleDeleteResponse.class, "rule.deleteRule", "1.0");

    }
}
