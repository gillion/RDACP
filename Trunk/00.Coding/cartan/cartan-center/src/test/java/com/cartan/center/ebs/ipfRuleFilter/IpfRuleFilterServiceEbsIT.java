/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRuleFilter;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfRuleFilter.request.*;
import com.cartan.center.ebs.ipfRuleFilter.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfRuleFilterServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfRuleFilterServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterGetSessionRequest ipfRuleFilterRequest = new IpfRuleFilterGetSessionRequest();
     	CompositeResponse<IpfRuleFilterGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfRuleFilterRequest, IpfRuleFilterGetSessionResponse.class, "ipfRuleFilter.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfRuleFilter(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterCreateRequest ipfRuleFilterRequest = new IpfRuleFilterCreateRequest();
	   	ipfRuleFilterRequest.setId("1");
	   	ipfRuleFilterRequest.setFilterCode("1");
	   	ipfRuleFilterRequest.setFilterName("1");
	   	ipfRuleFilterRequest.setFilterDesc("1");
	   	ipfRuleFilterRequest.setFilterExpress("1");
	   	ipfRuleFilterRequest.setIsActive("1");
	   	ipfRuleFilterRequest.setIsSystemCreate("1");
	   	ipfRuleFilterRequest.setIpfCcmBoId("1");
	   	ipfRuleFilterRequest.setBoName("1");
        CompositeResponse<IpfRuleFilterCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterRequest, IpfRuleFilterCreateResponse.class, "ipfRuleFilter.createIpfRuleFilter", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterCreateResponse ipfRuleFilterResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfRuleFilter(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterDeleteRequest ipfRuleFilterRequest = new IpfRuleFilterDeleteRequest();
	   	ipfRuleFilterRequest.setId("1");
        CompositeResponse<IpfRuleFilterDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterRequest, IpfRuleFilterDeleteResponse.class, "ipfRuleFilter.deleteIpfRuleFilter", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterDeleteResponse ipfRuleFilterResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfRuleFilter(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterUpdateRequest ipfRuleFilterRequest = new IpfRuleFilterUpdateRequest();
	   	ipfRuleFilterRequest.setId("1");
	   	ipfRuleFilterRequest.setFilterCode("1");
	   	ipfRuleFilterRequest.setFilterName("1");
	   	ipfRuleFilterRequest.setFilterDesc("1");
	   	ipfRuleFilterRequest.setFilterExpress("1");
	   	ipfRuleFilterRequest.setIsActive("1");
	   	ipfRuleFilterRequest.setIsSystemCreate("1");
	   	ipfRuleFilterRequest.setIpfCcmBoId("1");
	   	ipfRuleFilterRequest.setBoName("1");
        CompositeResponse<IpfRuleFilterUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterRequest, IpfRuleFilterUpdateResponse.class, "ipfRuleFilter.updateIpfRuleFilter", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterUpdateResponse ipfRuleFilterResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfRuleFilter(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterGetRequest ipfRuleFilterRequest = new IpfRuleFilterGetRequest();
	   	ipfRuleFilterRequest.setId("1");
        CompositeResponse<IpfRuleFilterGetResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterRequest, IpfRuleFilterGetResponse.class, "ipfRuleFilter.getIpfRuleFilter", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterGetResponse ipfRuleFilterResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterSelectAllRequest ipfRuleFilterRequest = new IpfRuleFilterSelectAllRequest();

        CompositeResponse<IpfRuleFilterSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterRequest, IpfRuleFilterSelectAllResponse.class, "ipfRuleFilter.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterSelectAllResponse ipfRuleFilterResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterCountAllRequest ipfRuleFilterRequest = new IpfRuleFilterCountAllRequest();

        CompositeResponse<IpfRuleFilterCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterRequest, IpfRuleFilterCountAllResponse.class, "ipfRuleFilter.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterCountAllResponse ipfRuleFilterResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfRuleFilterResponse.getResultString());
    }

    @Test
    public void selectIpfRuleFilter(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterSelectRequest ipfRuleFilterRequest = new IpfRuleFilterSelectRequest();
	   	ipfRuleFilterRequest.setId("1");
	   	ipfRuleFilterRequest.setFilterCode("1");
	   	ipfRuleFilterRequest.setFilterName("1");
	   	ipfRuleFilterRequest.setFilterDesc("1");
	   	ipfRuleFilterRequest.setFilterExpress("1");
	   	ipfRuleFilterRequest.setIsActive("1");
	   	ipfRuleFilterRequest.setIsSystemCreate("1");
	   	ipfRuleFilterRequest.setIpfCcmBoId("1");
	   	ipfRuleFilterRequest.setBoName("1");
        CompositeResponse<IpfRuleFilterCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterRequest, IpfRuleFilterCreateResponse.class, "ipfRuleFilter.createIpfRuleFilter", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfRuleFilterRequest.setId("1");
	   	ipfRuleFilterRequest.setFilterCode("1");
	   	ipfRuleFilterRequest.setFilterName("1");
	   	ipfRuleFilterRequest.setFilterDesc("1");
	   	ipfRuleFilterRequest.setFilterExpress("1");
	   	ipfRuleFilterRequest.setIsActive("1");
	   	ipfRuleFilterRequest.setIsSystemCreate("1");
	   	ipfRuleFilterRequest.setIpfCcmBoId("1");
	   	ipfRuleFilterRequest.setBoName("1");
        CompositeResponse<IpfRuleFilterSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfRuleFilterRequest, IpfRuleFilterSelectResponse.class, "ipfRuleFilter.selectIpfRuleFilter", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterSelectResponse ipfRuleFilterResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfRuleFilterResponse.getResultJson());
        CompositeResponse<IpfRuleFilterDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfRuleFilterRequest, IpfRuleFilterDeleteResponse.class, "ipfRuleFilter.deleteIpfRuleFilter", "1.0");

    }
}
