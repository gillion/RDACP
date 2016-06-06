/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTree;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ruleTree.request.*;
import com.cartan.center.ebs.ruleTree.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class RuleTreeServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(RuleTreeServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeGetSessionRequest ruleTreeRequest = new RuleTreeGetSessionRequest();
     	CompositeResponse<RuleTreeGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ruleTreeRequest, RuleTreeGetSessionResponse.class, "ruleTree.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createRuleTree(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeCreateRequest ruleTreeRequest = new RuleTreeCreateRequest();
	   	ruleTreeRequest.setId("1");
	   	ruleTreeRequest.setRuleTreeName("1");
	   	ruleTreeRequest.setVersion("1");
	   	ruleTreeRequest.setStatus("1");
	   	ruleTreeRequest.setOutputWay("1");
	   	ruleTreeRequest.setModifyDate("1");
	   	ruleTreeRequest.setModifyed("1");
	   	ruleTreeRequest.setOwner("1");
	   	ruleTreeRequest.setLocked("1");
        CompositeResponse<RuleTreeCreateResponse> response =
                ropClient.buildClientRequest().get(ruleTreeRequest, RuleTreeCreateResponse.class, "ruleTree.createRuleTree", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeCreateResponse ruleTreeResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteRuleTree(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeDeleteRequest ruleTreeRequest = new RuleTreeDeleteRequest();
	   	ruleTreeRequest.setId("1");
        CompositeResponse<RuleTreeDeleteResponse> response =
                ropClient.buildClientRequest().get(ruleTreeRequest, RuleTreeDeleteResponse.class, "ruleTree.deleteRuleTree", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeDeleteResponse ruleTreeResponse = response.getSuccessResponse();
    }




    @Test
    public void updateRuleTree(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeUpdateRequest ruleTreeRequest = new RuleTreeUpdateRequest();
	   	ruleTreeRequest.setId("1");
	   	ruleTreeRequest.setRuleTreeName("1");
	   	ruleTreeRequest.setVersion("1");
	   	ruleTreeRequest.setStatus("1");
	   	ruleTreeRequest.setOutputWay("1");
	   	ruleTreeRequest.setModifyDate("1");
	   	ruleTreeRequest.setModifyed("1");
	   	ruleTreeRequest.setOwner("1");
	   	ruleTreeRequest.setLocked("1");
        CompositeResponse<RuleTreeUpdateResponse> response =
                ropClient.buildClientRequest().get(ruleTreeRequest, RuleTreeUpdateResponse.class, "ruleTree.updateRuleTree", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeUpdateResponse ruleTreeResponse = response.getSuccessResponse();
    }


    @Test
    public void getRuleTree(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeGetRequest ruleTreeRequest = new RuleTreeGetRequest();
	   	ruleTreeRequest.setId("1");
        CompositeResponse<RuleTreeGetResponse> response =
                ropClient.buildClientRequest().get(ruleTreeRequest, RuleTreeGetResponse.class, "ruleTree.getRuleTree", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeGetResponse ruleTreeResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeSelectAllRequest ruleTreeRequest = new RuleTreeSelectAllRequest();

        CompositeResponse<RuleTreeSelectAllResponse> response =
                ropClient.buildClientRequest().get(ruleTreeRequest, RuleTreeSelectAllResponse.class, "ruleTree.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeSelectAllResponse ruleTreeResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeCountAllRequest ruleTreeRequest = new RuleTreeCountAllRequest();

        CompositeResponse<RuleTreeCountAllResponse> response =
                ropClient.buildClientRequest().get(ruleTreeRequest, RuleTreeCountAllResponse.class, "ruleTree.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeCountAllResponse ruleTreeResponse = response.getSuccessResponse();
        Assert.assertNotNull(ruleTreeResponse.getResultString());
    }

    @Test
    public void selectRuleTree(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeSelectRequest ruleTreeRequest = new RuleTreeSelectRequest();
	   	ruleTreeRequest.setId("1");
	   	ruleTreeRequest.setRuleTreeName("1");
	   	ruleTreeRequest.setVersion("1");
	   	ruleTreeRequest.setStatus("1");
	   	ruleTreeRequest.setOutputWay("1");
	   	ruleTreeRequest.setModifyDate("1");
	   	ruleTreeRequest.setModifyed("1");
	   	ruleTreeRequest.setOwner("1");
	   	ruleTreeRequest.setLocked("1");
        CompositeResponse<RuleTreeCreateResponse> response =
                ropClient.buildClientRequest().get(ruleTreeRequest, RuleTreeCreateResponse.class, "ruleTree.createRuleTree", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ruleTreeRequest.setId("1");
	   	ruleTreeRequest.setRuleTreeName("1");
	   	ruleTreeRequest.setVersion("1");
	   	ruleTreeRequest.setStatus("1");
	   	ruleTreeRequest.setOutputWay("1");
	   	ruleTreeRequest.setModifyDate("1");
	   	ruleTreeRequest.setModifyed("1");
	   	ruleTreeRequest.setOwner("1");
	   	ruleTreeRequest.setLocked("1");
        CompositeResponse<RuleTreeSelectResponse> response1 =
                ropClient.buildClientRequest().get(ruleTreeRequest, RuleTreeSelectResponse.class, "ruleTree.selectRuleTree", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeSelectResponse ruleTreeResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ruleTreeResponse.getResultJson());
        CompositeResponse<RuleTreeDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ruleTreeRequest, RuleTreeDeleteResponse.class, "ruleTree.deleteRuleTree", "1.0");

    }
}
