/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciLabelDetail;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfFciLabelDetail.request.*;
import com.cartan.center.ebs.ipfFciLabelDetail.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfFciLabelDetailServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfFciLabelDetailServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelDetailGetSessionRequest ipfFciLabelDetailRequest = new IpfFciLabelDetailGetSessionRequest();
     	CompositeResponse<IpfFciLabelDetailGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfFciLabelDetailRequest, IpfFciLabelDetailGetSessionResponse.class, "ipfFciLabelDetail.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfFciLabelDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelDetailCreateRequest ipfFciLabelDetailRequest = new IpfFciLabelDetailCreateRequest();
	   	ipfFciLabelDetailRequest.setId("1");
	   	ipfFciLabelDetailRequest.setIpfFciLabelId("1");
	   	ipfFciLabelDetailRequest.setIpfFciViewId("1");
	   	ipfFciLabelDetailRequest.setConfigItemType("1");
	   	ipfFciLabelDetailRequest.setConfigItemCode("1");
	   	ipfFciLabelDetailRequest.setConfigItemId("1");
	   	ipfFciLabelDetailRequest.setRevisionNumber("1");
	   	ipfFciLabelDetailRequest.setRelationMemberId("1");
	   	ipfFciLabelDetailRequest.setIsActive("1");
        CompositeResponse<IpfFciLabelDetailCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelDetailRequest, IpfFciLabelDetailCreateResponse.class, "ipfFciLabelDetail.createIpfFciLabelDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelDetailCreateResponse ipfFciLabelDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfFciLabelDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelDetailDeleteRequest ipfFciLabelDetailRequest = new IpfFciLabelDetailDeleteRequest();
	   	ipfFciLabelDetailRequest.setId("1");
        CompositeResponse<IpfFciLabelDetailDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelDetailRequest, IpfFciLabelDetailDeleteResponse.class, "ipfFciLabelDetail.deleteIpfFciLabelDetail", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelDetailDeleteResponse ipfFciLabelDetailResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfFciLabelDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelDetailUpdateRequest ipfFciLabelDetailRequest = new IpfFciLabelDetailUpdateRequest();
	   	ipfFciLabelDetailRequest.setId("1");
	   	ipfFciLabelDetailRequest.setIpfFciLabelId("1");
	   	ipfFciLabelDetailRequest.setIpfFciViewId("1");
	   	ipfFciLabelDetailRequest.setConfigItemType("1");
	   	ipfFciLabelDetailRequest.setConfigItemCode("1");
	   	ipfFciLabelDetailRequest.setConfigItemId("1");
	   	ipfFciLabelDetailRequest.setRevisionNumber("1");
	   	ipfFciLabelDetailRequest.setRelationMemberId("1");
	   	ipfFciLabelDetailRequest.setIsActive("1");
        CompositeResponse<IpfFciLabelDetailUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelDetailRequest, IpfFciLabelDetailUpdateResponse.class, "ipfFciLabelDetail.updateIpfFciLabelDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelDetailUpdateResponse ipfFciLabelDetailResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfFciLabelDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelDetailGetRequest ipfFciLabelDetailRequest = new IpfFciLabelDetailGetRequest();
	   	ipfFciLabelDetailRequest.setId("1");
        CompositeResponse<IpfFciLabelDetailGetResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelDetailRequest, IpfFciLabelDetailGetResponse.class, "ipfFciLabelDetail.getIpfFciLabelDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelDetailGetResponse ipfFciLabelDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelDetailSelectAllRequest ipfFciLabelDetailRequest = new IpfFciLabelDetailSelectAllRequest();

        CompositeResponse<IpfFciLabelDetailSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelDetailRequest, IpfFciLabelDetailSelectAllResponse.class, "ipfFciLabelDetail.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelDetailSelectAllResponse ipfFciLabelDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelDetailCountAllRequest ipfFciLabelDetailRequest = new IpfFciLabelDetailCountAllRequest();

        CompositeResponse<IpfFciLabelDetailCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelDetailRequest, IpfFciLabelDetailCountAllResponse.class, "ipfFciLabelDetail.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelDetailCountAllResponse ipfFciLabelDetailResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfFciLabelDetailResponse.getResultString());
    }

    @Test
    public void selectIpfFciLabelDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelDetailSelectRequest ipfFciLabelDetailRequest = new IpfFciLabelDetailSelectRequest();
	   	ipfFciLabelDetailRequest.setId("1");
	   	ipfFciLabelDetailRequest.setIpfFciLabelId("1");
	   	ipfFciLabelDetailRequest.setIpfFciViewId("1");
	   	ipfFciLabelDetailRequest.setConfigItemType("1");
	   	ipfFciLabelDetailRequest.setConfigItemCode("1");
	   	ipfFciLabelDetailRequest.setConfigItemId("1");
	   	ipfFciLabelDetailRequest.setRevisionNumber("1");
	   	ipfFciLabelDetailRequest.setRelationMemberId("1");
	   	ipfFciLabelDetailRequest.setIsActive("1");
        CompositeResponse<IpfFciLabelDetailCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelDetailRequest, IpfFciLabelDetailCreateResponse.class, "ipfFciLabelDetail.createIpfFciLabelDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfFciLabelDetailRequest.setId("1");
	   	ipfFciLabelDetailRequest.setIpfFciLabelId("1");
	   	ipfFciLabelDetailRequest.setIpfFciViewId("1");
	   	ipfFciLabelDetailRequest.setConfigItemType("1");
	   	ipfFciLabelDetailRequest.setConfigItemCode("1");
	   	ipfFciLabelDetailRequest.setConfigItemId("1");
	   	ipfFciLabelDetailRequest.setRevisionNumber("1");
	   	ipfFciLabelDetailRequest.setRelationMemberId("1");
	   	ipfFciLabelDetailRequest.setIsActive("1");
        CompositeResponse<IpfFciLabelDetailSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfFciLabelDetailRequest, IpfFciLabelDetailSelectResponse.class, "ipfFciLabelDetail.selectIpfFciLabelDetail", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelDetailSelectResponse ipfFciLabelDetailResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfFciLabelDetailResponse.getResultJson());
        CompositeResponse<IpfFciLabelDetailDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfFciLabelDetailRequest, IpfFciLabelDetailDeleteResponse.class, "ipfFciLabelDetail.deleteIpfFciLabelDetail", "1.0");

    }
}
