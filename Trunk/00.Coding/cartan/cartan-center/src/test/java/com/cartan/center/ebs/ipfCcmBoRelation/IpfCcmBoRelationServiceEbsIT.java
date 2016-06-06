/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoRelation;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoRelation.request.*;
import com.cartan.center.ebs.ipfCcmBoRelation.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoRelationServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoRelationServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoRelationGetSessionRequest ipfCcmBoRelationRequest = new IpfCcmBoRelationGetSessionRequest();
     	CompositeResponse<IpfCcmBoRelationGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoRelationRequest, IpfCcmBoRelationGetSessionResponse.class, "ipfCcmBoRelation.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoRelation(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoRelationCreateRequest ipfCcmBoRelationRequest = new IpfCcmBoRelationCreateRequest();
	   	ipfCcmBoRelationRequest.setId("1");
	   	ipfCcmBoRelationRequest.setIpfCcmBoId("1");
	   	ipfCcmBoRelationRequest.setPropertyName("1");
	   	ipfCcmBoRelationRequest.setSubBoName("1");
	   	ipfCcmBoRelationRequest.setSubBoRelType("1");
	   	ipfCcmBoRelationRequest.setObjectType("1");
	   	ipfCcmBoRelationRequest.setDescription("1");
	   	ipfCcmBoRelationRequest.setSubBoOrderNo("1");
	   	ipfCcmBoRelationRequest.setPersistentSaveType("1");
	   	ipfCcmBoRelationRequest.setGridEditType("1");
	   	ipfCcmBoRelationRequest.setLinkBoName("1");
        CompositeResponse<IpfCcmBoRelationCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRelationRequest, IpfCcmBoRelationCreateResponse.class, "ipfCcmBoRelation.createIpfCcmBoRelation", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoRelationCreateResponse ipfCcmBoRelationResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoRelation(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoRelationDeleteRequest ipfCcmBoRelationRequest = new IpfCcmBoRelationDeleteRequest();
	   	ipfCcmBoRelationRequest.setId("1");
        CompositeResponse<IpfCcmBoRelationDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRelationRequest, IpfCcmBoRelationDeleteResponse.class, "ipfCcmBoRelation.deleteIpfCcmBoRelation", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoRelationDeleteResponse ipfCcmBoRelationResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoRelation(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoRelationUpdateRequest ipfCcmBoRelationRequest = new IpfCcmBoRelationUpdateRequest();
	   	ipfCcmBoRelationRequest.setId("1");
	   	ipfCcmBoRelationRequest.setIpfCcmBoId("1");
	   	ipfCcmBoRelationRequest.setPropertyName("1");
	   	ipfCcmBoRelationRequest.setSubBoName("1");
	   	ipfCcmBoRelationRequest.setSubBoRelType("1");
	   	ipfCcmBoRelationRequest.setObjectType("1");
	   	ipfCcmBoRelationRequest.setDescription("1");
	   	ipfCcmBoRelationRequest.setSubBoOrderNo("1");
	   	ipfCcmBoRelationRequest.setPersistentSaveType("1");
	   	ipfCcmBoRelationRequest.setGridEditType("1");
	   	ipfCcmBoRelationRequest.setLinkBoName("1");
        CompositeResponse<IpfCcmBoRelationUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRelationRequest, IpfCcmBoRelationUpdateResponse.class, "ipfCcmBoRelation.updateIpfCcmBoRelation", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoRelationUpdateResponse ipfCcmBoRelationResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoRelation(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoRelationGetRequest ipfCcmBoRelationRequest = new IpfCcmBoRelationGetRequest();
	   	ipfCcmBoRelationRequest.setId("1");
        CompositeResponse<IpfCcmBoRelationGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRelationRequest, IpfCcmBoRelationGetResponse.class, "ipfCcmBoRelation.getIpfCcmBoRelation", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoRelationGetResponse ipfCcmBoRelationResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoRelationSelectAllRequest ipfCcmBoRelationRequest = new IpfCcmBoRelationSelectAllRequest();

        CompositeResponse<IpfCcmBoRelationSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRelationRequest, IpfCcmBoRelationSelectAllResponse.class, "ipfCcmBoRelation.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoRelationSelectAllResponse ipfCcmBoRelationResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoRelationCountAllRequest ipfCcmBoRelationRequest = new IpfCcmBoRelationCountAllRequest();

        CompositeResponse<IpfCcmBoRelationCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRelationRequest, IpfCcmBoRelationCountAllResponse.class, "ipfCcmBoRelation.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoRelationCountAllResponse ipfCcmBoRelationResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoRelationResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoRelation(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoRelationSelectRequest ipfCcmBoRelationRequest = new IpfCcmBoRelationSelectRequest();
	   	ipfCcmBoRelationRequest.setId("1");
	   	ipfCcmBoRelationRequest.setIpfCcmBoId("1");
	   	ipfCcmBoRelationRequest.setPropertyName("1");
	   	ipfCcmBoRelationRequest.setSubBoName("1");
	   	ipfCcmBoRelationRequest.setSubBoRelType("1");
	   	ipfCcmBoRelationRequest.setObjectType("1");
	   	ipfCcmBoRelationRequest.setDescription("1");
	   	ipfCcmBoRelationRequest.setSubBoOrderNo("1");
	   	ipfCcmBoRelationRequest.setPersistentSaveType("1");
	   	ipfCcmBoRelationRequest.setGridEditType("1");
	   	ipfCcmBoRelationRequest.setLinkBoName("1");
        CompositeResponse<IpfCcmBoRelationCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRelationRequest, IpfCcmBoRelationCreateResponse.class, "ipfCcmBoRelation.createIpfCcmBoRelation", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoRelationRequest.setId("1");
	   	ipfCcmBoRelationRequest.setIpfCcmBoId("1");
	   	ipfCcmBoRelationRequest.setPropertyName("1");
	   	ipfCcmBoRelationRequest.setSubBoName("1");
	   	ipfCcmBoRelationRequest.setSubBoRelType("1");
	   	ipfCcmBoRelationRequest.setObjectType("1");
	   	ipfCcmBoRelationRequest.setDescription("1");
	   	ipfCcmBoRelationRequest.setSubBoOrderNo("1");
	   	ipfCcmBoRelationRequest.setPersistentSaveType("1");
	   	ipfCcmBoRelationRequest.setGridEditType("1");
	   	ipfCcmBoRelationRequest.setLinkBoName("1");
        CompositeResponse<IpfCcmBoRelationSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoRelationRequest, IpfCcmBoRelationSelectResponse.class, "ipfCcmBoRelation.selectIpfCcmBoRelation", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoRelationSelectResponse ipfCcmBoRelationResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoRelationResponse.getResultJson());
        CompositeResponse<IpfCcmBoRelationDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoRelationRequest, IpfCcmBoRelationDeleteResponse.class, "ipfCcmBoRelation.deleteIpfCcmBoRelation", "1.0");

    }
}
