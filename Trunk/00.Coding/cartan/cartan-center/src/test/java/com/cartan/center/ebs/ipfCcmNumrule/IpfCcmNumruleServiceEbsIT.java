/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmNumrule;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmNumrule.request.*;
import com.cartan.center.ebs.ipfCcmNumrule.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmNumruleServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmNumruleServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleGetSessionRequest ipfCcmNumruleRequest = new IpfCcmNumruleGetSessionRequest();
     	CompositeResponse<IpfCcmNumruleGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmNumruleRequest, IpfCcmNumruleGetSessionResponse.class, "ipfCcmNumrule.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmNumrule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleCreateRequest ipfCcmNumruleRequest = new IpfCcmNumruleCreateRequest();
	   	ipfCcmNumruleRequest.setId("1");
	   	ipfCcmNumruleRequest.setRuleCode("1");
	   	ipfCcmNumruleRequest.setRuleName("1");
	   	ipfCcmNumruleRequest.setRuleExpression("1");
	   	ipfCcmNumruleRequest.setRuleStatus("1");
	   	ipfCcmNumruleRequest.setInitialValue("1");
	   	ipfCcmNumruleRequest.setMaxValue("1");
	   	ipfCcmNumruleRequest.setGrowth("1");
	   	ipfCcmNumruleRequest.setRemark("1");
	   	ipfCcmNumruleRequest.setIsActive("1");
	   	ipfCcmNumruleRequest.setIpfCcmBoId("1");
	   	ipfCcmNumruleRequest.setBoName("1");
	   	ipfCcmNumruleRequest.setIpfCcmBoPropertyId("1");
	   	ipfCcmNumruleRequest.setPropertyName("1");
        CompositeResponse<IpfCcmNumruleCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleRequest, IpfCcmNumruleCreateResponse.class, "ipfCcmNumrule.createIpfCcmNumrule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleCreateResponse ipfCcmNumruleResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmNumrule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleDeleteRequest ipfCcmNumruleRequest = new IpfCcmNumruleDeleteRequest();
	   	ipfCcmNumruleRequest.setId("1");
        CompositeResponse<IpfCcmNumruleDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleRequest, IpfCcmNumruleDeleteResponse.class, "ipfCcmNumrule.deleteIpfCcmNumrule", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleDeleteResponse ipfCcmNumruleResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmNumrule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleUpdateRequest ipfCcmNumruleRequest = new IpfCcmNumruleUpdateRequest();
	   	ipfCcmNumruleRequest.setId("1");
	   	ipfCcmNumruleRequest.setRuleCode("1");
	   	ipfCcmNumruleRequest.setRuleName("1");
	   	ipfCcmNumruleRequest.setRuleExpression("1");
	   	ipfCcmNumruleRequest.setRuleStatus("1");
	   	ipfCcmNumruleRequest.setInitialValue("1");
	   	ipfCcmNumruleRequest.setMaxValue("1");
	   	ipfCcmNumruleRequest.setGrowth("1");
	   	ipfCcmNumruleRequest.setRemark("1");
	   	ipfCcmNumruleRequest.setIsActive("1");
	   	ipfCcmNumruleRequest.setIpfCcmBoId("1");
	   	ipfCcmNumruleRequest.setBoName("1");
	   	ipfCcmNumruleRequest.setIpfCcmBoPropertyId("1");
	   	ipfCcmNumruleRequest.setPropertyName("1");
        CompositeResponse<IpfCcmNumruleUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleRequest, IpfCcmNumruleUpdateResponse.class, "ipfCcmNumrule.updateIpfCcmNumrule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleUpdateResponse ipfCcmNumruleResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmNumrule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleGetRequest ipfCcmNumruleRequest = new IpfCcmNumruleGetRequest();
	   	ipfCcmNumruleRequest.setId("1");
        CompositeResponse<IpfCcmNumruleGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleRequest, IpfCcmNumruleGetResponse.class, "ipfCcmNumrule.getIpfCcmNumrule", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleGetResponse ipfCcmNumruleResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleSelectAllRequest ipfCcmNumruleRequest = new IpfCcmNumruleSelectAllRequest();

        CompositeResponse<IpfCcmNumruleSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleRequest, IpfCcmNumruleSelectAllResponse.class, "ipfCcmNumrule.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleSelectAllResponse ipfCcmNumruleResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleCountAllRequest ipfCcmNumruleRequest = new IpfCcmNumruleCountAllRequest();

        CompositeResponse<IpfCcmNumruleCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleRequest, IpfCcmNumruleCountAllResponse.class, "ipfCcmNumrule.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleCountAllResponse ipfCcmNumruleResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmNumruleResponse.getResultString());
    }

    @Test
    public void selectIpfCcmNumrule(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleSelectRequest ipfCcmNumruleRequest = new IpfCcmNumruleSelectRequest();
	   	ipfCcmNumruleRequest.setId("1");
	   	ipfCcmNumruleRequest.setRuleCode("1");
	   	ipfCcmNumruleRequest.setRuleName("1");
	   	ipfCcmNumruleRequest.setRuleExpression("1");
	   	ipfCcmNumruleRequest.setRuleStatus("1");
	   	ipfCcmNumruleRequest.setInitialValue("1");
	   	ipfCcmNumruleRequest.setMaxValue("1");
	   	ipfCcmNumruleRequest.setGrowth("1");
	   	ipfCcmNumruleRequest.setRemark("1");
	   	ipfCcmNumruleRequest.setIsActive("1");
	   	ipfCcmNumruleRequest.setIpfCcmBoId("1");
	   	ipfCcmNumruleRequest.setBoName("1");
	   	ipfCcmNumruleRequest.setIpfCcmBoPropertyId("1");
	   	ipfCcmNumruleRequest.setPropertyName("1");
        CompositeResponse<IpfCcmNumruleCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleRequest, IpfCcmNumruleCreateResponse.class, "ipfCcmNumrule.createIpfCcmNumrule", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmNumruleRequest.setId("1");
	   	ipfCcmNumruleRequest.setRuleCode("1");
	   	ipfCcmNumruleRequest.setRuleName("1");
	   	ipfCcmNumruleRequest.setRuleExpression("1");
	   	ipfCcmNumruleRequest.setRuleStatus("1");
	   	ipfCcmNumruleRequest.setInitialValue("1");
	   	ipfCcmNumruleRequest.setMaxValue("1");
	   	ipfCcmNumruleRequest.setGrowth("1");
	   	ipfCcmNumruleRequest.setRemark("1");
	   	ipfCcmNumruleRequest.setIsActive("1");
	   	ipfCcmNumruleRequest.setIpfCcmBoId("1");
	   	ipfCcmNumruleRequest.setBoName("1");
	   	ipfCcmNumruleRequest.setIpfCcmBoPropertyId("1");
	   	ipfCcmNumruleRequest.setPropertyName("1");
        CompositeResponse<IpfCcmNumruleSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmNumruleRequest, IpfCcmNumruleSelectResponse.class, "ipfCcmNumrule.selectIpfCcmNumrule", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleSelectResponse ipfCcmNumruleResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmNumruleResponse.getResultJson());
        CompositeResponse<IpfCcmNumruleDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmNumruleRequest, IpfCcmNumruleDeleteResponse.class, "ipfCcmNumrule.deleteIpfCcmNumrule", "1.0");

    }
}
