/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBizruleDtl;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBizruleDtl.request.*;
import com.cartan.center.ebs.ipfCcmBizruleDtl.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBizruleDtlServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBizruleDtlServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlGetSessionRequest ipfCcmBizruleDtlRequest = new IpfCcmBizruleDtlGetSessionRequest();
     	CompositeResponse<IpfCcmBizruleDtlGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBizruleDtlRequest, IpfCcmBizruleDtlGetSessionResponse.class, "ipfCcmBizruleDtl.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBizruleDtl(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlCreateRequest ipfCcmBizruleDtlRequest = new IpfCcmBizruleDtlCreateRequest();
	   	ipfCcmBizruleDtlRequest.setId("1");
	   	ipfCcmBizruleDtlRequest.setIpfCcmBizruleId("1");
	   	ipfCcmBizruleDtlRequest.setIpfCcmStrategyId("1");
	   	ipfCcmBizruleDtlRequest.setStrategyCode("1");
	   	ipfCcmBizruleDtlRequest.setStrategyName("1");
	   	ipfCcmBizruleDtlRequest.setRemark("1");
	   	ipfCcmBizruleDtlRequest.setRuleDetailIndex("1");
        CompositeResponse<IpfCcmBizruleDtlCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlRequest, IpfCcmBizruleDtlCreateResponse.class, "ipfCcmBizruleDtl.createIpfCcmBizruleDtl", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlCreateResponse ipfCcmBizruleDtlResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBizruleDtl(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlDeleteRequest ipfCcmBizruleDtlRequest = new IpfCcmBizruleDtlDeleteRequest();
	   	ipfCcmBizruleDtlRequest.setId("1");
        CompositeResponse<IpfCcmBizruleDtlDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlRequest, IpfCcmBizruleDtlDeleteResponse.class, "ipfCcmBizruleDtl.deleteIpfCcmBizruleDtl", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlDeleteResponse ipfCcmBizruleDtlResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBizruleDtl(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlUpdateRequest ipfCcmBizruleDtlRequest = new IpfCcmBizruleDtlUpdateRequest();
	   	ipfCcmBizruleDtlRequest.setId("1");
	   	ipfCcmBizruleDtlRequest.setIpfCcmBizruleId("1");
	   	ipfCcmBizruleDtlRequest.setIpfCcmStrategyId("1");
	   	ipfCcmBizruleDtlRequest.setStrategyCode("1");
	   	ipfCcmBizruleDtlRequest.setStrategyName("1");
	   	ipfCcmBizruleDtlRequest.setRemark("1");
	   	ipfCcmBizruleDtlRequest.setRuleDetailIndex("1");
        CompositeResponse<IpfCcmBizruleDtlUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlRequest, IpfCcmBizruleDtlUpdateResponse.class, "ipfCcmBizruleDtl.updateIpfCcmBizruleDtl", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlUpdateResponse ipfCcmBizruleDtlResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBizruleDtl(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlGetRequest ipfCcmBizruleDtlRequest = new IpfCcmBizruleDtlGetRequest();
	   	ipfCcmBizruleDtlRequest.setId("1");
        CompositeResponse<IpfCcmBizruleDtlGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlRequest, IpfCcmBizruleDtlGetResponse.class, "ipfCcmBizruleDtl.getIpfCcmBizruleDtl", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlGetResponse ipfCcmBizruleDtlResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlSelectAllRequest ipfCcmBizruleDtlRequest = new IpfCcmBizruleDtlSelectAllRequest();

        CompositeResponse<IpfCcmBizruleDtlSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlRequest, IpfCcmBizruleDtlSelectAllResponse.class, "ipfCcmBizruleDtl.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlSelectAllResponse ipfCcmBizruleDtlResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlCountAllRequest ipfCcmBizruleDtlRequest = new IpfCcmBizruleDtlCountAllRequest();

        CompositeResponse<IpfCcmBizruleDtlCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlRequest, IpfCcmBizruleDtlCountAllResponse.class, "ipfCcmBizruleDtl.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlCountAllResponse ipfCcmBizruleDtlResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBizruleDtlResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBizruleDtl(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBizruleDtlSelectRequest ipfCcmBizruleDtlRequest = new IpfCcmBizruleDtlSelectRequest();
	   	ipfCcmBizruleDtlRequest.setId("1");
	   	ipfCcmBizruleDtlRequest.setIpfCcmBizruleId("1");
	   	ipfCcmBizruleDtlRequest.setIpfCcmStrategyId("1");
	   	ipfCcmBizruleDtlRequest.setStrategyCode("1");
	   	ipfCcmBizruleDtlRequest.setStrategyName("1");
	   	ipfCcmBizruleDtlRequest.setRemark("1");
	   	ipfCcmBizruleDtlRequest.setRuleDetailIndex("1");
        CompositeResponse<IpfCcmBizruleDtlCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlRequest, IpfCcmBizruleDtlCreateResponse.class, "ipfCcmBizruleDtl.createIpfCcmBizruleDtl", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBizruleDtlRequest.setId("1");
	   	ipfCcmBizruleDtlRequest.setIpfCcmBizruleId("1");
	   	ipfCcmBizruleDtlRequest.setIpfCcmStrategyId("1");
	   	ipfCcmBizruleDtlRequest.setStrategyCode("1");
	   	ipfCcmBizruleDtlRequest.setStrategyName("1");
	   	ipfCcmBizruleDtlRequest.setRemark("1");
	   	ipfCcmBizruleDtlRequest.setRuleDetailIndex("1");
        CompositeResponse<IpfCcmBizruleDtlSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlRequest, IpfCcmBizruleDtlSelectResponse.class, "ipfCcmBizruleDtl.selectIpfCcmBizruleDtl", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBizruleDtlSelectResponse ipfCcmBizruleDtlResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBizruleDtlResponse.getResultJson());
        CompositeResponse<IpfCcmBizruleDtlDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBizruleDtlRequest, IpfCcmBizruleDtlDeleteResponse.class, "ipfCcmBizruleDtl.deleteIpfCcmBizruleDtl", "1.0");

    }
}
