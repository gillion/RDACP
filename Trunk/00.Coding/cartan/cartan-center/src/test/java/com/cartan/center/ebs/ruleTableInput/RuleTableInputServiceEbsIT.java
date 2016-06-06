/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTableInput;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ruleTableInput.request.*;
import com.cartan.center.ebs.ruleTableInput.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class RuleTableInputServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(RuleTableInputServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableInputGetSessionRequest ruleTableInputRequest = new RuleTableInputGetSessionRequest();
     	CompositeResponse<RuleTableInputGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ruleTableInputRequest, RuleTableInputGetSessionResponse.class, "ruleTableInput.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createRuleTableInput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableInputCreateRequest ruleTableInputRequest = new RuleTableInputCreateRequest();
	   	ruleTableInputRequest.setId("1");
	   	ruleTableInputRequest.setRuleTableId("1");
	   	ruleTableInputRequest.setOutputLocation("1");
	   	ruleTableInputRequest.setInputVar("1");
	   	ruleTableInputRequest.setInputValue("1");
        CompositeResponse<RuleTableInputCreateResponse> response =
                ropClient.buildClientRequest().get(ruleTableInputRequest, RuleTableInputCreateResponse.class, "ruleTableInput.createRuleTableInput", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableInputCreateResponse ruleTableInputResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteRuleTableInput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableInputDeleteRequest ruleTableInputRequest = new RuleTableInputDeleteRequest();
	   	ruleTableInputRequest.setId("1");
        CompositeResponse<RuleTableInputDeleteResponse> response =
                ropClient.buildClientRequest().get(ruleTableInputRequest, RuleTableInputDeleteResponse.class, "ruleTableInput.deleteRuleTableInput", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableInputDeleteResponse ruleTableInputResponse = response.getSuccessResponse();
    }




    @Test
    public void updateRuleTableInput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableInputUpdateRequest ruleTableInputRequest = new RuleTableInputUpdateRequest();
	   	ruleTableInputRequest.setId("1");
	   	ruleTableInputRequest.setRuleTableId("1");
	   	ruleTableInputRequest.setOutputLocation("1");
	   	ruleTableInputRequest.setInputVar("1");
	   	ruleTableInputRequest.setInputValue("1");
        CompositeResponse<RuleTableInputUpdateResponse> response =
                ropClient.buildClientRequest().get(ruleTableInputRequest, RuleTableInputUpdateResponse.class, "ruleTableInput.updateRuleTableInput", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableInputUpdateResponse ruleTableInputResponse = response.getSuccessResponse();
    }


    @Test
    public void getRuleTableInput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableInputGetRequest ruleTableInputRequest = new RuleTableInputGetRequest();
	   	ruleTableInputRequest.setId("1");
        CompositeResponse<RuleTableInputGetResponse> response =
                ropClient.buildClientRequest().get(ruleTableInputRequest, RuleTableInputGetResponse.class, "ruleTableInput.getRuleTableInput", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableInputGetResponse ruleTableInputResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableInputSelectAllRequest ruleTableInputRequest = new RuleTableInputSelectAllRequest();

        CompositeResponse<RuleTableInputSelectAllResponse> response =
                ropClient.buildClientRequest().get(ruleTableInputRequest, RuleTableInputSelectAllResponse.class, "ruleTableInput.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableInputSelectAllResponse ruleTableInputResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableInputCountAllRequest ruleTableInputRequest = new RuleTableInputCountAllRequest();

        CompositeResponse<RuleTableInputCountAllResponse> response =
                ropClient.buildClientRequest().get(ruleTableInputRequest, RuleTableInputCountAllResponse.class, "ruleTableInput.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableInputCountAllResponse ruleTableInputResponse = response.getSuccessResponse();
        Assert.assertNotNull(ruleTableInputResponse.getResultString());
    }

    @Test
    public void selectRuleTableInput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableInputSelectRequest ruleTableInputRequest = new RuleTableInputSelectRequest();
	   	ruleTableInputRequest.setId("1");
	   	ruleTableInputRequest.setRuleTableId("1");
	   	ruleTableInputRequest.setOutputLocation("1");
	   	ruleTableInputRequest.setInputVar("1");
	   	ruleTableInputRequest.setInputValue("1");
        CompositeResponse<RuleTableInputCreateResponse> response =
                ropClient.buildClientRequest().get(ruleTableInputRequest, RuleTableInputCreateResponse.class, "ruleTableInput.createRuleTableInput", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ruleTableInputRequest.setId("1");
	   	ruleTableInputRequest.setRuleTableId("1");
	   	ruleTableInputRequest.setOutputLocation("1");
	   	ruleTableInputRequest.setInputVar("1");
	   	ruleTableInputRequest.setInputValue("1");
        CompositeResponse<RuleTableInputSelectResponse> response1 =
                ropClient.buildClientRequest().get(ruleTableInputRequest, RuleTableInputSelectResponse.class, "ruleTableInput.selectRuleTableInput", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableInputSelectResponse ruleTableInputResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ruleTableInputResponse.getResultJson());
        CompositeResponse<RuleTableInputDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ruleTableInputRequest, RuleTableInputDeleteResponse.class, "ruleTableInput.deleteRuleTableInput", "1.0");

    }
}
