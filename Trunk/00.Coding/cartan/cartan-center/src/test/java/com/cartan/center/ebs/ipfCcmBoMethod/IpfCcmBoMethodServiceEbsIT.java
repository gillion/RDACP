/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoMethod;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoMethod.request.*;
import com.cartan.center.ebs.ipfCcmBoMethod.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoMethodServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoMethodServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodGetSessionRequest ipfCcmBoMethodRequest = new IpfCcmBoMethodGetSessionRequest();
     	CompositeResponse<IpfCcmBoMethodGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoMethodRequest, IpfCcmBoMethodGetSessionResponse.class, "ipfCcmBoMethod.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoMethod(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodCreateRequest ipfCcmBoMethodRequest = new IpfCcmBoMethodCreateRequest();
	   	ipfCcmBoMethodRequest.setId("1");
	   	ipfCcmBoMethodRequest.setIpfCcmBoId("1");
	   	ipfCcmBoMethodRequest.setBoType("1");
	   	ipfCcmBoMethodRequest.setBoRefId("1");
	   	ipfCcmBoMethodRequest.setIcon("1");
	   	ipfCcmBoMethodRequest.setRemark("1");
	   	ipfCcmBoMethodRequest.setMethodDesc("1");
	   	ipfCcmBoMethodRequest.setMethodName("1");
	   	ipfCcmBoMethodRequest.setMethodType("1");
	   	ipfCcmBoMethodRequest.setUrl("1");
	   	ipfCcmBoMethodRequest.setIsDefault("1");
	   	ipfCcmBoMethodRequest.setIsVisible("1");
	   	ipfCcmBoMethodRequest.setRefShlpName("1");
	   	ipfCcmBoMethodRequest.setRuleNo("1");
	   	ipfCcmBoMethodRequest.setJumpMethodId("1");
	   	ipfCcmBoMethodRequest.setJumpMethodName("1");
	   	ipfCcmBoMethodRequest.setJumpBoName("1");
	   	ipfCcmBoMethodRequest.setWidth("1");
	   	ipfCcmBoMethodRequest.setHeight("1");
	   	ipfCcmBoMethodRequest.setGroupName("1");
	   	ipfCcmBoMethodRequest.setGroupDesc("1");
	   	ipfCcmBoMethodRequest.setIsCache("1");
	   	ipfCcmBoMethodRequest.setCacheType("1");
	   	ipfCcmBoMethodRequest.setRequestType("1");
	   	ipfCcmBoMethodRequest.setJumpWindowTitle("1");
	   	ipfCcmBoMethodRequest.setIsRefreshParentBo("1");
        CompositeResponse<IpfCcmBoMethodCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRequest, IpfCcmBoMethodCreateResponse.class, "ipfCcmBoMethod.createIpfCcmBoMethod", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodCreateResponse ipfCcmBoMethodResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoMethod(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodDeleteRequest ipfCcmBoMethodRequest = new IpfCcmBoMethodDeleteRequest();
	   	ipfCcmBoMethodRequest.setId("1");
        CompositeResponse<IpfCcmBoMethodDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRequest, IpfCcmBoMethodDeleteResponse.class, "ipfCcmBoMethod.deleteIpfCcmBoMethod", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodDeleteResponse ipfCcmBoMethodResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoMethod(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodUpdateRequest ipfCcmBoMethodRequest = new IpfCcmBoMethodUpdateRequest();
	   	ipfCcmBoMethodRequest.setId("1");
	   	ipfCcmBoMethodRequest.setIpfCcmBoId("1");
	   	ipfCcmBoMethodRequest.setBoType("1");
	   	ipfCcmBoMethodRequest.setBoRefId("1");
	   	ipfCcmBoMethodRequest.setIcon("1");
	   	ipfCcmBoMethodRequest.setRemark("1");
	   	ipfCcmBoMethodRequest.setMethodDesc("1");
	   	ipfCcmBoMethodRequest.setMethodName("1");
	   	ipfCcmBoMethodRequest.setMethodType("1");
	   	ipfCcmBoMethodRequest.setUrl("1");
	   	ipfCcmBoMethodRequest.setIsDefault("1");
	   	ipfCcmBoMethodRequest.setIsVisible("1");
	   	ipfCcmBoMethodRequest.setRefShlpName("1");
	   	ipfCcmBoMethodRequest.setRuleNo("1");
	   	ipfCcmBoMethodRequest.setJumpMethodId("1");
	   	ipfCcmBoMethodRequest.setJumpMethodName("1");
	   	ipfCcmBoMethodRequest.setJumpBoName("1");
	   	ipfCcmBoMethodRequest.setWidth("1");
	   	ipfCcmBoMethodRequest.setHeight("1");
	   	ipfCcmBoMethodRequest.setGroupName("1");
	   	ipfCcmBoMethodRequest.setGroupDesc("1");
	   	ipfCcmBoMethodRequest.setIsCache("1");
	   	ipfCcmBoMethodRequest.setCacheType("1");
	   	ipfCcmBoMethodRequest.setRequestType("1");
	   	ipfCcmBoMethodRequest.setJumpWindowTitle("1");
	   	ipfCcmBoMethodRequest.setIsRefreshParentBo("1");
        CompositeResponse<IpfCcmBoMethodUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRequest, IpfCcmBoMethodUpdateResponse.class, "ipfCcmBoMethod.updateIpfCcmBoMethod", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodUpdateResponse ipfCcmBoMethodResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoMethod(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodGetRequest ipfCcmBoMethodRequest = new IpfCcmBoMethodGetRequest();
	   	ipfCcmBoMethodRequest.setId("1");
        CompositeResponse<IpfCcmBoMethodGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRequest, IpfCcmBoMethodGetResponse.class, "ipfCcmBoMethod.getIpfCcmBoMethod", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodGetResponse ipfCcmBoMethodResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodSelectAllRequest ipfCcmBoMethodRequest = new IpfCcmBoMethodSelectAllRequest();

        CompositeResponse<IpfCcmBoMethodSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRequest, IpfCcmBoMethodSelectAllResponse.class, "ipfCcmBoMethod.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodSelectAllResponse ipfCcmBoMethodResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodCountAllRequest ipfCcmBoMethodRequest = new IpfCcmBoMethodCountAllRequest();

        CompositeResponse<IpfCcmBoMethodCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRequest, IpfCcmBoMethodCountAllResponse.class, "ipfCcmBoMethod.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodCountAllResponse ipfCcmBoMethodResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoMethodResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoMethod(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoMethodSelectRequest ipfCcmBoMethodRequest = new IpfCcmBoMethodSelectRequest();
	   	ipfCcmBoMethodRequest.setId("1");
	   	ipfCcmBoMethodRequest.setIpfCcmBoId("1");
	   	ipfCcmBoMethodRequest.setBoType("1");
	   	ipfCcmBoMethodRequest.setBoRefId("1");
	   	ipfCcmBoMethodRequest.setIcon("1");
	   	ipfCcmBoMethodRequest.setRemark("1");
	   	ipfCcmBoMethodRequest.setMethodDesc("1");
	   	ipfCcmBoMethodRequest.setMethodName("1");
	   	ipfCcmBoMethodRequest.setMethodType("1");
	   	ipfCcmBoMethodRequest.setUrl("1");
	   	ipfCcmBoMethodRequest.setIsDefault("1");
	   	ipfCcmBoMethodRequest.setIsVisible("1");
	   	ipfCcmBoMethodRequest.setRefShlpName("1");
	   	ipfCcmBoMethodRequest.setRuleNo("1");
	   	ipfCcmBoMethodRequest.setJumpMethodId("1");
	   	ipfCcmBoMethodRequest.setJumpMethodName("1");
	   	ipfCcmBoMethodRequest.setJumpBoName("1");
	   	ipfCcmBoMethodRequest.setWidth("1");
	   	ipfCcmBoMethodRequest.setHeight("1");
	   	ipfCcmBoMethodRequest.setGroupName("1");
	   	ipfCcmBoMethodRequest.setGroupDesc("1");
	   	ipfCcmBoMethodRequest.setIsCache("1");
	   	ipfCcmBoMethodRequest.setCacheType("1");
	   	ipfCcmBoMethodRequest.setRequestType("1");
	   	ipfCcmBoMethodRequest.setJumpWindowTitle("1");
	   	ipfCcmBoMethodRequest.setIsRefreshParentBo("1");
        CompositeResponse<IpfCcmBoMethodCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRequest, IpfCcmBoMethodCreateResponse.class, "ipfCcmBoMethod.createIpfCcmBoMethod", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoMethodRequest.setId("1");
	   	ipfCcmBoMethodRequest.setIpfCcmBoId("1");
	   	ipfCcmBoMethodRequest.setBoType("1");
	   	ipfCcmBoMethodRequest.setBoRefId("1");
	   	ipfCcmBoMethodRequest.setIcon("1");
	   	ipfCcmBoMethodRequest.setRemark("1");
	   	ipfCcmBoMethodRequest.setMethodDesc("1");
	   	ipfCcmBoMethodRequest.setMethodName("1");
	   	ipfCcmBoMethodRequest.setMethodType("1");
	   	ipfCcmBoMethodRequest.setUrl("1");
	   	ipfCcmBoMethodRequest.setIsDefault("1");
	   	ipfCcmBoMethodRequest.setIsVisible("1");
	   	ipfCcmBoMethodRequest.setRefShlpName("1");
	   	ipfCcmBoMethodRequest.setRuleNo("1");
	   	ipfCcmBoMethodRequest.setJumpMethodId("1");
	   	ipfCcmBoMethodRequest.setJumpMethodName("1");
	   	ipfCcmBoMethodRequest.setJumpBoName("1");
	   	ipfCcmBoMethodRequest.setWidth("1");
	   	ipfCcmBoMethodRequest.setHeight("1");
	   	ipfCcmBoMethodRequest.setGroupName("1");
	   	ipfCcmBoMethodRequest.setGroupDesc("1");
	   	ipfCcmBoMethodRequest.setIsCache("1");
	   	ipfCcmBoMethodRequest.setCacheType("1");
	   	ipfCcmBoMethodRequest.setRequestType("1");
	   	ipfCcmBoMethodRequest.setJumpWindowTitle("1");
	   	ipfCcmBoMethodRequest.setIsRefreshParentBo("1");
        CompositeResponse<IpfCcmBoMethodSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRequest, IpfCcmBoMethodSelectResponse.class, "ipfCcmBoMethod.selectIpfCcmBoMethod", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoMethodSelectResponse ipfCcmBoMethodResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoMethodResponse.getResultJson());
        CompositeResponse<IpfCcmBoMethodDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoMethodRequest, IpfCcmBoMethodDeleteResponse.class, "ipfCcmBoMethod.deleteIpfCcmBoMethod", "1.0");

    }
}
