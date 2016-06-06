/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmConfigAttrBo;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfRtmConfigAttrBo.request.*;
import com.cartan.center.ebs.ipfRtmConfigAttrBo.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfRtmConfigAttrBoServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfRtmConfigAttrBoServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrBoGetSessionRequest ipfRtmConfigAttrBoRequest = new IpfRtmConfigAttrBoGetSessionRequest();
     	CompositeResponse<IpfRtmConfigAttrBoGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfRtmConfigAttrBoRequest, IpfRtmConfigAttrBoGetSessionResponse.class, "ipfRtmConfigAttrBo.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfRtmConfigAttrBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrBoCreateRequest ipfRtmConfigAttrBoRequest = new IpfRtmConfigAttrBoCreateRequest();
	   	ipfRtmConfigAttrBoRequest.setId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfRtmConfigAttrId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfRtmConfigId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfCcmBoId("1");
	   	ipfRtmConfigAttrBoRequest.setBoName("1");
	   	ipfRtmConfigAttrBoRequest.setBoDesc("1");
	   	ipfRtmConfigAttrBoRequest.setBoAttributeName("1");
	   	ipfRtmConfigAttrBoRequest.setIsVisible("1");
	   	ipfRtmConfigAttrBoRequest.setIsRequired("1");
	   	ipfRtmConfigAttrBoRequest.setDefaultValue("1");
	   	ipfRtmConfigAttrBoRequest.setShlpValueFiled("1");
        CompositeResponse<IpfRtmConfigAttrBoCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrBoRequest, IpfRtmConfigAttrBoCreateResponse.class, "ipfRtmConfigAttrBo.createIpfRtmConfigAttrBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrBoCreateResponse ipfRtmConfigAttrBoResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfRtmConfigAttrBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrBoDeleteRequest ipfRtmConfigAttrBoRequest = new IpfRtmConfigAttrBoDeleteRequest();
	   	ipfRtmConfigAttrBoRequest.setId("1");
        CompositeResponse<IpfRtmConfigAttrBoDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrBoRequest, IpfRtmConfigAttrBoDeleteResponse.class, "ipfRtmConfigAttrBo.deleteIpfRtmConfigAttrBo", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrBoDeleteResponse ipfRtmConfigAttrBoResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfRtmConfigAttrBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrBoUpdateRequest ipfRtmConfigAttrBoRequest = new IpfRtmConfigAttrBoUpdateRequest();
	   	ipfRtmConfigAttrBoRequest.setId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfRtmConfigAttrId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfRtmConfigId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfCcmBoId("1");
	   	ipfRtmConfigAttrBoRequest.setBoName("1");
	   	ipfRtmConfigAttrBoRequest.setBoDesc("1");
	   	ipfRtmConfigAttrBoRequest.setBoAttributeName("1");
	   	ipfRtmConfigAttrBoRequest.setIsVisible("1");
	   	ipfRtmConfigAttrBoRequest.setIsRequired("1");
	   	ipfRtmConfigAttrBoRequest.setDefaultValue("1");
	   	ipfRtmConfigAttrBoRequest.setShlpValueFiled("1");
        CompositeResponse<IpfRtmConfigAttrBoUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrBoRequest, IpfRtmConfigAttrBoUpdateResponse.class, "ipfRtmConfigAttrBo.updateIpfRtmConfigAttrBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrBoUpdateResponse ipfRtmConfigAttrBoResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfRtmConfigAttrBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrBoGetRequest ipfRtmConfigAttrBoRequest = new IpfRtmConfigAttrBoGetRequest();
	   	ipfRtmConfigAttrBoRequest.setId("1");
        CompositeResponse<IpfRtmConfigAttrBoGetResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrBoRequest, IpfRtmConfigAttrBoGetResponse.class, "ipfRtmConfigAttrBo.getIpfRtmConfigAttrBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrBoGetResponse ipfRtmConfigAttrBoResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrBoSelectAllRequest ipfRtmConfigAttrBoRequest = new IpfRtmConfigAttrBoSelectAllRequest();

        CompositeResponse<IpfRtmConfigAttrBoSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrBoRequest, IpfRtmConfigAttrBoSelectAllResponse.class, "ipfRtmConfigAttrBo.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrBoSelectAllResponse ipfRtmConfigAttrBoResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrBoCountAllRequest ipfRtmConfigAttrBoRequest = new IpfRtmConfigAttrBoCountAllRequest();

        CompositeResponse<IpfRtmConfigAttrBoCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrBoRequest, IpfRtmConfigAttrBoCountAllResponse.class, "ipfRtmConfigAttrBo.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrBoCountAllResponse ipfRtmConfigAttrBoResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfRtmConfigAttrBoResponse.getResultString());
    }

    @Test
    public void selectIpfRtmConfigAttrBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrBoSelectRequest ipfRtmConfigAttrBoRequest = new IpfRtmConfigAttrBoSelectRequest();
	   	ipfRtmConfigAttrBoRequest.setId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfRtmConfigAttrId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfRtmConfigId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfCcmBoId("1");
	   	ipfRtmConfigAttrBoRequest.setBoName("1");
	   	ipfRtmConfigAttrBoRequest.setBoDesc("1");
	   	ipfRtmConfigAttrBoRequest.setBoAttributeName("1");
	   	ipfRtmConfigAttrBoRequest.setIsVisible("1");
	   	ipfRtmConfigAttrBoRequest.setIsRequired("1");
	   	ipfRtmConfigAttrBoRequest.setDefaultValue("1");
	   	ipfRtmConfigAttrBoRequest.setShlpValueFiled("1");
        CompositeResponse<IpfRtmConfigAttrBoCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrBoRequest, IpfRtmConfigAttrBoCreateResponse.class, "ipfRtmConfigAttrBo.createIpfRtmConfigAttrBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfRtmConfigAttrBoRequest.setId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfRtmConfigAttrId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfRtmConfigId("1");
	   	ipfRtmConfigAttrBoRequest.setIpfCcmBoId("1");
	   	ipfRtmConfigAttrBoRequest.setBoName("1");
	   	ipfRtmConfigAttrBoRequest.setBoDesc("1");
	   	ipfRtmConfigAttrBoRequest.setBoAttributeName("1");
	   	ipfRtmConfigAttrBoRequest.setIsVisible("1");
	   	ipfRtmConfigAttrBoRequest.setIsRequired("1");
	   	ipfRtmConfigAttrBoRequest.setDefaultValue("1");
	   	ipfRtmConfigAttrBoRequest.setShlpValueFiled("1");
        CompositeResponse<IpfRtmConfigAttrBoSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrBoRequest, IpfRtmConfigAttrBoSelectResponse.class, "ipfRtmConfigAttrBo.selectIpfRtmConfigAttrBo", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrBoSelectResponse ipfRtmConfigAttrBoResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfRtmConfigAttrBoResponse.getResultJson());
        CompositeResponse<IpfRtmConfigAttrBoDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrBoRequest, IpfRtmConfigAttrBoDeleteResponse.class, "ipfRtmConfigAttrBo.deleteIpfRtmConfigAttrBo", "1.0");

    }
}
