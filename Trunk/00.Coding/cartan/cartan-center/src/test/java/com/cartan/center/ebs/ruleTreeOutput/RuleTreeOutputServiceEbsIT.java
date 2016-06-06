/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTreeOutput;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ruleTreeOutput.request.*;
import com.cartan.center.ebs.ruleTreeOutput.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class RuleTreeOutputServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(RuleTreeOutputServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeOutputGetSessionRequest ruleTreeOutputRequest = new RuleTreeOutputGetSessionRequest();
     	CompositeResponse<RuleTreeOutputGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ruleTreeOutputRequest, RuleTreeOutputGetSessionResponse.class, "ruleTreeOutput.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createRuleTreeOutput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeOutputCreateRequest ruleTreeOutputRequest = new RuleTreeOutputCreateRequest();
	   	ruleTreeOutputRequest.setId("1");
	   	ruleTreeOutputRequest.setRuleTreeId("1");
	   	ruleTreeOutputRequest.setTreeNodeCode("1");
	   	ruleTreeOutputRequest.setTreeNodeName("1");
	   	ruleTreeOutputRequest.setOutputVer("1");
	   	ruleTreeOutputRequest.setOutputValue("1");
        CompositeResponse<RuleTreeOutputCreateResponse> response =
                ropClient.buildClientRequest().get(ruleTreeOutputRequest, RuleTreeOutputCreateResponse.class, "ruleTreeOutput.createRuleTreeOutput", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeOutputCreateResponse ruleTreeOutputResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteRuleTreeOutput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeOutputDeleteRequest ruleTreeOutputRequest = new RuleTreeOutputDeleteRequest();
	   	ruleTreeOutputRequest.setId("1");
        CompositeResponse<RuleTreeOutputDeleteResponse> response =
                ropClient.buildClientRequest().get(ruleTreeOutputRequest, RuleTreeOutputDeleteResponse.class, "ruleTreeOutput.deleteRuleTreeOutput", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeOutputDeleteResponse ruleTreeOutputResponse = response.getSuccessResponse();
    }




    @Test
    public void updateRuleTreeOutput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeOutputUpdateRequest ruleTreeOutputRequest = new RuleTreeOutputUpdateRequest();
	   	ruleTreeOutputRequest.setId("1");
	   	ruleTreeOutputRequest.setRuleTreeId("1");
	   	ruleTreeOutputRequest.setTreeNodeCode("1");
	   	ruleTreeOutputRequest.setTreeNodeName("1");
	   	ruleTreeOutputRequest.setOutputVer("1");
	   	ruleTreeOutputRequest.setOutputValue("1");
        CompositeResponse<RuleTreeOutputUpdateResponse> response =
                ropClient.buildClientRequest().get(ruleTreeOutputRequest, RuleTreeOutputUpdateResponse.class, "ruleTreeOutput.updateRuleTreeOutput", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeOutputUpdateResponse ruleTreeOutputResponse = response.getSuccessResponse();
    }


    @Test
    public void getRuleTreeOutput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeOutputGetRequest ruleTreeOutputRequest = new RuleTreeOutputGetRequest();
	   	ruleTreeOutputRequest.setId("1");
        CompositeResponse<RuleTreeOutputGetResponse> response =
                ropClient.buildClientRequest().get(ruleTreeOutputRequest, RuleTreeOutputGetResponse.class, "ruleTreeOutput.getRuleTreeOutput", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeOutputGetResponse ruleTreeOutputResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeOutputSelectAllRequest ruleTreeOutputRequest = new RuleTreeOutputSelectAllRequest();

        CompositeResponse<RuleTreeOutputSelectAllResponse> response =
                ropClient.buildClientRequest().get(ruleTreeOutputRequest, RuleTreeOutputSelectAllResponse.class, "ruleTreeOutput.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeOutputSelectAllResponse ruleTreeOutputResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeOutputCountAllRequest ruleTreeOutputRequest = new RuleTreeOutputCountAllRequest();

        CompositeResponse<RuleTreeOutputCountAllResponse> response =
                ropClient.buildClientRequest().get(ruleTreeOutputRequest, RuleTreeOutputCountAllResponse.class, "ruleTreeOutput.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeOutputCountAllResponse ruleTreeOutputResponse = response.getSuccessResponse();
        Assert.assertNotNull(ruleTreeOutputResponse.getResultString());
    }

    @Test
    public void selectRuleTreeOutput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTreeOutputSelectRequest ruleTreeOutputRequest = new RuleTreeOutputSelectRequest();
	   	ruleTreeOutputRequest.setId("1");
	   	ruleTreeOutputRequest.setRuleTreeId("1");
	   	ruleTreeOutputRequest.setTreeNodeCode("1");
	   	ruleTreeOutputRequest.setTreeNodeName("1");
	   	ruleTreeOutputRequest.setOutputVer("1");
	   	ruleTreeOutputRequest.setOutputValue("1");
        CompositeResponse<RuleTreeOutputCreateResponse> response =
                ropClient.buildClientRequest().get(ruleTreeOutputRequest, RuleTreeOutputCreateResponse.class, "ruleTreeOutput.createRuleTreeOutput", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ruleTreeOutputRequest.setId("1");
	   	ruleTreeOutputRequest.setRuleTreeId("1");
	   	ruleTreeOutputRequest.setTreeNodeCode("1");
	   	ruleTreeOutputRequest.setTreeNodeName("1");
	   	ruleTreeOutputRequest.setOutputVer("1");
	   	ruleTreeOutputRequest.setOutputValue("1");
        CompositeResponse<RuleTreeOutputSelectResponse> response1 =
                ropClient.buildClientRequest().get(ruleTreeOutputRequest, RuleTreeOutputSelectResponse.class, "ruleTreeOutput.selectRuleTreeOutput", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTreeOutputSelectResponse ruleTreeOutputResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ruleTreeOutputResponse.getResultJson());
        CompositeResponse<RuleTreeOutputDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ruleTreeOutputRequest, RuleTreeOutputDeleteResponse.class, "ruleTreeOutput.deleteRuleTreeOutput", "1.0");

    }
}
