/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleset;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ruleset.request.*;
import com.cartan.center.ebs.ruleset.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class RulesetServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(RulesetServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RulesetGetSessionRequest rulesetRequest = new RulesetGetSessionRequest();
     	CompositeResponse<RulesetGetSessionResponse> response =
                 ropClient.buildClientRequest().get(rulesetRequest, RulesetGetSessionResponse.class, "ruleset.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createRuleset(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RulesetCreateRequest rulesetRequest = new RulesetCreateRequest();
	   	rulesetRequest.setId("1");
	   	rulesetRequest.setRulesetName("1");
	   	rulesetRequest.setVersion("1");
	   	rulesetRequest.setStatus("1");
	   	rulesetRequest.setModifyDate("1");
	   	rulesetRequest.setModifyed("1");
	   	rulesetRequest.setOwner("1");
	   	rulesetRequest.setLocked("1");
        CompositeResponse<RulesetCreateResponse> response =
                ropClient.buildClientRequest().get(rulesetRequest, RulesetCreateResponse.class, "ruleset.createRuleset", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RulesetCreateResponse rulesetResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteRuleset(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RulesetDeleteRequest rulesetRequest = new RulesetDeleteRequest();
	   	rulesetRequest.setId("1");
        CompositeResponse<RulesetDeleteResponse> response =
                ropClient.buildClientRequest().get(rulesetRequest, RulesetDeleteResponse.class, "ruleset.deleteRuleset", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RulesetDeleteResponse rulesetResponse = response.getSuccessResponse();
    }




    @Test
    public void updateRuleset(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RulesetUpdateRequest rulesetRequest = new RulesetUpdateRequest();
	   	rulesetRequest.setId("1");
	   	rulesetRequest.setRulesetName("1");
	   	rulesetRequest.setVersion("1");
	   	rulesetRequest.setStatus("1");
	   	rulesetRequest.setModifyDate("1");
	   	rulesetRequest.setModifyed("1");
	   	rulesetRequest.setOwner("1");
	   	rulesetRequest.setLocked("1");
        CompositeResponse<RulesetUpdateResponse> response =
                ropClient.buildClientRequest().get(rulesetRequest, RulesetUpdateResponse.class, "ruleset.updateRuleset", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RulesetUpdateResponse rulesetResponse = response.getSuccessResponse();
    }


    @Test
    public void getRuleset(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RulesetGetRequest rulesetRequest = new RulesetGetRequest();
	   	rulesetRequest.setId("1");
        CompositeResponse<RulesetGetResponse> response =
                ropClient.buildClientRequest().get(rulesetRequest, RulesetGetResponse.class, "ruleset.getRuleset", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RulesetGetResponse rulesetResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RulesetSelectAllRequest rulesetRequest = new RulesetSelectAllRequest();

        CompositeResponse<RulesetSelectAllResponse> response =
                ropClient.buildClientRequest().get(rulesetRequest, RulesetSelectAllResponse.class, "ruleset.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RulesetSelectAllResponse rulesetResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RulesetCountAllRequest rulesetRequest = new RulesetCountAllRequest();

        CompositeResponse<RulesetCountAllResponse> response =
                ropClient.buildClientRequest().get(rulesetRequest, RulesetCountAllResponse.class, "ruleset.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RulesetCountAllResponse rulesetResponse = response.getSuccessResponse();
        Assert.assertNotNull(rulesetResponse.getResultString());
    }

    @Test
    public void selectRuleset(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RulesetSelectRequest rulesetRequest = new RulesetSelectRequest();
	   	rulesetRequest.setId("1");
	   	rulesetRequest.setRulesetName("1");
	   	rulesetRequest.setVersion("1");
	   	rulesetRequest.setStatus("1");
	   	rulesetRequest.setModifyDate("1");
	   	rulesetRequest.setModifyed("1");
	   	rulesetRequest.setOwner("1");
	   	rulesetRequest.setLocked("1");
        CompositeResponse<RulesetCreateResponse> response =
                ropClient.buildClientRequest().get(rulesetRequest, RulesetCreateResponse.class, "ruleset.createRuleset", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	rulesetRequest.setId("1");
	   	rulesetRequest.setRulesetName("1");
	   	rulesetRequest.setVersion("1");
	   	rulesetRequest.setStatus("1");
	   	rulesetRequest.setModifyDate("1");
	   	rulesetRequest.setModifyed("1");
	   	rulesetRequest.setOwner("1");
	   	rulesetRequest.setLocked("1");
        CompositeResponse<RulesetSelectResponse> response1 =
                ropClient.buildClientRequest().get(rulesetRequest, RulesetSelectResponse.class, "ruleset.selectRuleset", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RulesetSelectResponse rulesetResponse = response1.getSuccessResponse();
        Assert.assertNotNull(rulesetResponse.getResultJson());
        CompositeResponse<RulesetDeleteResponse> response2 =
                ropClient.buildClientRequest().get(rulesetRequest, RulesetDeleteResponse.class, "ruleset.deleteRuleset", "1.0");

    }
}
