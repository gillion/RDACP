/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTableOutput;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ruleTableOutput.request.*;
import com.cartan.center.ebs.ruleTableOutput.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class RuleTableOutputServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(RuleTableOutputServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableOutputGetSessionRequest ruleTableOutputRequest = new RuleTableOutputGetSessionRequest();
     	CompositeResponse<RuleTableOutputGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ruleTableOutputRequest, RuleTableOutputGetSessionResponse.class, "ruleTableOutput.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createRuleTableOutput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableOutputCreateRequest ruleTableOutputRequest = new RuleTableOutputCreateRequest();
	   	ruleTableOutputRequest.setId("1");
	   	ruleTableOutputRequest.setRuleTableId("1");
	   	ruleTableOutputRequest.setOutputLocation("1");
	   	ruleTableOutputRequest.setOutputVar("1");
	   	ruleTableOutputRequest.setOutputValue("1");
        CompositeResponse<RuleTableOutputCreateResponse> response =
                ropClient.buildClientRequest().get(ruleTableOutputRequest, RuleTableOutputCreateResponse.class, "ruleTableOutput.createRuleTableOutput", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableOutputCreateResponse ruleTableOutputResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteRuleTableOutput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableOutputDeleteRequest ruleTableOutputRequest = new RuleTableOutputDeleteRequest();
	   	ruleTableOutputRequest.setId("1");
        CompositeResponse<RuleTableOutputDeleteResponse> response =
                ropClient.buildClientRequest().get(ruleTableOutputRequest, RuleTableOutputDeleteResponse.class, "ruleTableOutput.deleteRuleTableOutput", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableOutputDeleteResponse ruleTableOutputResponse = response.getSuccessResponse();
    }




    @Test
    public void updateRuleTableOutput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableOutputUpdateRequest ruleTableOutputRequest = new RuleTableOutputUpdateRequest();
	   	ruleTableOutputRequest.setId("1");
	   	ruleTableOutputRequest.setRuleTableId("1");
	   	ruleTableOutputRequest.setOutputLocation("1");
	   	ruleTableOutputRequest.setOutputVar("1");
	   	ruleTableOutputRequest.setOutputValue("1");
        CompositeResponse<RuleTableOutputUpdateResponse> response =
                ropClient.buildClientRequest().get(ruleTableOutputRequest, RuleTableOutputUpdateResponse.class, "ruleTableOutput.updateRuleTableOutput", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableOutputUpdateResponse ruleTableOutputResponse = response.getSuccessResponse();
    }


    @Test
    public void getRuleTableOutput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableOutputGetRequest ruleTableOutputRequest = new RuleTableOutputGetRequest();
	   	ruleTableOutputRequest.setId("1");
        CompositeResponse<RuleTableOutputGetResponse> response =
                ropClient.buildClientRequest().get(ruleTableOutputRequest, RuleTableOutputGetResponse.class, "ruleTableOutput.getRuleTableOutput", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableOutputGetResponse ruleTableOutputResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableOutputSelectAllRequest ruleTableOutputRequest = new RuleTableOutputSelectAllRequest();

        CompositeResponse<RuleTableOutputSelectAllResponse> response =
                ropClient.buildClientRequest().get(ruleTableOutputRequest, RuleTableOutputSelectAllResponse.class, "ruleTableOutput.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableOutputSelectAllResponse ruleTableOutputResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableOutputCountAllRequest ruleTableOutputRequest = new RuleTableOutputCountAllRequest();

        CompositeResponse<RuleTableOutputCountAllResponse> response =
                ropClient.buildClientRequest().get(ruleTableOutputRequest, RuleTableOutputCountAllResponse.class, "ruleTableOutput.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableOutputCountAllResponse ruleTableOutputResponse = response.getSuccessResponse();
        Assert.assertNotNull(ruleTableOutputResponse.getResultString());
    }

    @Test
    public void selectRuleTableOutput(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableOutputSelectRequest ruleTableOutputRequest = new RuleTableOutputSelectRequest();
	   	ruleTableOutputRequest.setId("1");
	   	ruleTableOutputRequest.setRuleTableId("1");
	   	ruleTableOutputRequest.setOutputLocation("1");
	   	ruleTableOutputRequest.setOutputVar("1");
	   	ruleTableOutputRequest.setOutputValue("1");
        CompositeResponse<RuleTableOutputCreateResponse> response =
                ropClient.buildClientRequest().get(ruleTableOutputRequest, RuleTableOutputCreateResponse.class, "ruleTableOutput.createRuleTableOutput", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ruleTableOutputRequest.setId("1");
	   	ruleTableOutputRequest.setRuleTableId("1");
	   	ruleTableOutputRequest.setOutputLocation("1");
	   	ruleTableOutputRequest.setOutputVar("1");
	   	ruleTableOutputRequest.setOutputValue("1");
        CompositeResponse<RuleTableOutputSelectResponse> response1 =
                ropClient.buildClientRequest().get(ruleTableOutputRequest, RuleTableOutputSelectResponse.class, "ruleTableOutput.selectRuleTableOutput", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableOutputSelectResponse ruleTableOutputResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ruleTableOutputResponse.getResultJson());
        CompositeResponse<RuleTableOutputDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ruleTableOutputRequest, RuleTableOutputDeleteResponse.class, "ruleTableOutput.deleteRuleTableOutput", "1.0");

    }
}
