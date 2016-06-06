/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTable;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ruleTable.request.*;
import com.cartan.center.ebs.ruleTable.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class RuleTableServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(RuleTableServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableGetSessionRequest ruleTableRequest = new RuleTableGetSessionRequest();
     	CompositeResponse<RuleTableGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ruleTableRequest, RuleTableGetSessionResponse.class, "ruleTable.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createRuleTable(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableCreateRequest ruleTableRequest = new RuleTableCreateRequest();
	   	ruleTableRequest.setId("1");
	   	ruleTableRequest.setRuleTableName("1");
	   	ruleTableRequest.setVersion("1");
	   	ruleTableRequest.setStatus("1");
	   	ruleTableRequest.setModifyDate("1");
	   	ruleTableRequest.setModifyed("1");
	   	ruleTableRequest.setOwner("1");
	   	ruleTableRequest.setLocked("1");
        CompositeResponse<RuleTableCreateResponse> response =
                ropClient.buildClientRequest().get(ruleTableRequest, RuleTableCreateResponse.class, "ruleTable.createRuleTable", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableCreateResponse ruleTableResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteRuleTable(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableDeleteRequest ruleTableRequest = new RuleTableDeleteRequest();
	   	ruleTableRequest.setId("1");
        CompositeResponse<RuleTableDeleteResponse> response =
                ropClient.buildClientRequest().get(ruleTableRequest, RuleTableDeleteResponse.class, "ruleTable.deleteRuleTable", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableDeleteResponse ruleTableResponse = response.getSuccessResponse();
    }




    @Test
    public void updateRuleTable(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableUpdateRequest ruleTableRequest = new RuleTableUpdateRequest();
	   	ruleTableRequest.setId("1");
	   	ruleTableRequest.setRuleTableName("1");
	   	ruleTableRequest.setVersion("1");
	   	ruleTableRequest.setStatus("1");
	   	ruleTableRequest.setModifyDate("1");
	   	ruleTableRequest.setModifyed("1");
	   	ruleTableRequest.setOwner("1");
	   	ruleTableRequest.setLocked("1");
        CompositeResponse<RuleTableUpdateResponse> response =
                ropClient.buildClientRequest().get(ruleTableRequest, RuleTableUpdateResponse.class, "ruleTable.updateRuleTable", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableUpdateResponse ruleTableResponse = response.getSuccessResponse();
    }


    @Test
    public void getRuleTable(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableGetRequest ruleTableRequest = new RuleTableGetRequest();
	   	ruleTableRequest.setId("1");
        CompositeResponse<RuleTableGetResponse> response =
                ropClient.buildClientRequest().get(ruleTableRequest, RuleTableGetResponse.class, "ruleTable.getRuleTable", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableGetResponse ruleTableResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableSelectAllRequest ruleTableRequest = new RuleTableSelectAllRequest();

        CompositeResponse<RuleTableSelectAllResponse> response =
                ropClient.buildClientRequest().get(ruleTableRequest, RuleTableSelectAllResponse.class, "ruleTable.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableSelectAllResponse ruleTableResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableCountAllRequest ruleTableRequest = new RuleTableCountAllRequest();

        CompositeResponse<RuleTableCountAllResponse> response =
                ropClient.buildClientRequest().get(ruleTableRequest, RuleTableCountAllResponse.class, "ruleTable.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableCountAllResponse ruleTableResponse = response.getSuccessResponse();
        Assert.assertNotNull(ruleTableResponse.getResultString());
    }

    @Test
    public void selectRuleTable(){
        RopClient ropClient = CartanRopClient.getRopClient();
        RuleTableSelectRequest ruleTableRequest = new RuleTableSelectRequest();
	   	ruleTableRequest.setId("1");
	   	ruleTableRequest.setRuleTableName("1");
	   	ruleTableRequest.setVersion("1");
	   	ruleTableRequest.setStatus("1");
	   	ruleTableRequest.setModifyDate("1");
	   	ruleTableRequest.setModifyed("1");
	   	ruleTableRequest.setOwner("1");
	   	ruleTableRequest.setLocked("1");
        CompositeResponse<RuleTableCreateResponse> response =
                ropClient.buildClientRequest().get(ruleTableRequest, RuleTableCreateResponse.class, "ruleTable.createRuleTable", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ruleTableRequest.setId("1");
	   	ruleTableRequest.setRuleTableName("1");
	   	ruleTableRequest.setVersion("1");
	   	ruleTableRequest.setStatus("1");
	   	ruleTableRequest.setModifyDate("1");
	   	ruleTableRequest.setModifyed("1");
	   	ruleTableRequest.setOwner("1");
	   	ruleTableRequest.setLocked("1");
        CompositeResponse<RuleTableSelectResponse> response1 =
                ropClient.buildClientRequest().get(ruleTableRequest, RuleTableSelectResponse.class, "ruleTable.selectRuleTable", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        RuleTableSelectResponse ruleTableResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ruleTableResponse.getResultJson());
        CompositeResponse<RuleTableDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ruleTableRequest, RuleTableDeleteResponse.class, "ruleTable.deleteRuleTable", "1.0");

    }
}
