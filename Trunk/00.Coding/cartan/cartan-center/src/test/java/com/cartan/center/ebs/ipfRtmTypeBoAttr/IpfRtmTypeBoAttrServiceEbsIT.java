/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmTypeBoAttr;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfRtmTypeBoAttr.request.*;
import com.cartan.center.ebs.ipfRtmTypeBoAttr.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfRtmTypeBoAttrServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfRtmTypeBoAttrServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoAttrGetSessionRequest ipfRtmTypeBoAttrRequest = new IpfRtmTypeBoAttrGetSessionRequest();
     	CompositeResponse<IpfRtmTypeBoAttrGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfRtmTypeBoAttrRequest, IpfRtmTypeBoAttrGetSessionResponse.class, "ipfRtmTypeBoAttr.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfRtmTypeBoAttr(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoAttrCreateRequest ipfRtmTypeBoAttrRequest = new IpfRtmTypeBoAttrCreateRequest();
	   	ipfRtmTypeBoAttrRequest.setId("1");
	   	ipfRtmTypeBoAttrRequest.setIpfRtmTypeBoId("1");
	   	ipfRtmTypeBoAttrRequest.setPropertyName("1");
	   	ipfRtmTypeBoAttrRequest.setFieldText("1");
        CompositeResponse<IpfRtmTypeBoAttrCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoAttrRequest, IpfRtmTypeBoAttrCreateResponse.class, "ipfRtmTypeBoAttr.createIpfRtmTypeBoAttr", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoAttrCreateResponse ipfRtmTypeBoAttrResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfRtmTypeBoAttr(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoAttrDeleteRequest ipfRtmTypeBoAttrRequest = new IpfRtmTypeBoAttrDeleteRequest();
	   	ipfRtmTypeBoAttrRequest.setId("1");
        CompositeResponse<IpfRtmTypeBoAttrDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoAttrRequest, IpfRtmTypeBoAttrDeleteResponse.class, "ipfRtmTypeBoAttr.deleteIpfRtmTypeBoAttr", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoAttrDeleteResponse ipfRtmTypeBoAttrResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfRtmTypeBoAttr(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoAttrUpdateRequest ipfRtmTypeBoAttrRequest = new IpfRtmTypeBoAttrUpdateRequest();
	   	ipfRtmTypeBoAttrRequest.setId("1");
	   	ipfRtmTypeBoAttrRequest.setIpfRtmTypeBoId("1");
	   	ipfRtmTypeBoAttrRequest.setPropertyName("1");
	   	ipfRtmTypeBoAttrRequest.setFieldText("1");
        CompositeResponse<IpfRtmTypeBoAttrUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoAttrRequest, IpfRtmTypeBoAttrUpdateResponse.class, "ipfRtmTypeBoAttr.updateIpfRtmTypeBoAttr", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoAttrUpdateResponse ipfRtmTypeBoAttrResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfRtmTypeBoAttr(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoAttrGetRequest ipfRtmTypeBoAttrRequest = new IpfRtmTypeBoAttrGetRequest();
	   	ipfRtmTypeBoAttrRequest.setId("1");
        CompositeResponse<IpfRtmTypeBoAttrGetResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoAttrRequest, IpfRtmTypeBoAttrGetResponse.class, "ipfRtmTypeBoAttr.getIpfRtmTypeBoAttr", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoAttrGetResponse ipfRtmTypeBoAttrResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoAttrSelectAllRequest ipfRtmTypeBoAttrRequest = new IpfRtmTypeBoAttrSelectAllRequest();

        CompositeResponse<IpfRtmTypeBoAttrSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoAttrRequest, IpfRtmTypeBoAttrSelectAllResponse.class, "ipfRtmTypeBoAttr.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoAttrSelectAllResponse ipfRtmTypeBoAttrResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoAttrCountAllRequest ipfRtmTypeBoAttrRequest = new IpfRtmTypeBoAttrCountAllRequest();

        CompositeResponse<IpfRtmTypeBoAttrCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoAttrRequest, IpfRtmTypeBoAttrCountAllResponse.class, "ipfRtmTypeBoAttr.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoAttrCountAllResponse ipfRtmTypeBoAttrResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfRtmTypeBoAttrResponse.getResultString());
    }

    @Test
    public void selectIpfRtmTypeBoAttr(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeBoAttrSelectRequest ipfRtmTypeBoAttrRequest = new IpfRtmTypeBoAttrSelectRequest();
	   	ipfRtmTypeBoAttrRequest.setId("1");
	   	ipfRtmTypeBoAttrRequest.setIpfRtmTypeBoId("1");
	   	ipfRtmTypeBoAttrRequest.setPropertyName("1");
	   	ipfRtmTypeBoAttrRequest.setFieldText("1");
        CompositeResponse<IpfRtmTypeBoAttrCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeBoAttrRequest, IpfRtmTypeBoAttrCreateResponse.class, "ipfRtmTypeBoAttr.createIpfRtmTypeBoAttr", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfRtmTypeBoAttrRequest.setId("1");
	   	ipfRtmTypeBoAttrRequest.setIpfRtmTypeBoId("1");
	   	ipfRtmTypeBoAttrRequest.setPropertyName("1");
	   	ipfRtmTypeBoAttrRequest.setFieldText("1");
        CompositeResponse<IpfRtmTypeBoAttrSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfRtmTypeBoAttrRequest, IpfRtmTypeBoAttrSelectResponse.class, "ipfRtmTypeBoAttr.selectIpfRtmTypeBoAttr", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeBoAttrSelectResponse ipfRtmTypeBoAttrResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfRtmTypeBoAttrResponse.getResultJson());
        CompositeResponse<IpfRtmTypeBoAttrDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfRtmTypeBoAttrRequest, IpfRtmTypeBoAttrDeleteResponse.class, "ipfRtmTypeBoAttr.deleteIpfRtmTypeBoAttr", "1.0");

    }
}
