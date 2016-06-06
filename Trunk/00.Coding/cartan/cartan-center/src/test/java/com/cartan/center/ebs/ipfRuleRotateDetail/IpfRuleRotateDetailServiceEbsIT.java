/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRuleRotateDetail;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfRuleRotateDetail.request.*;
import com.cartan.center.ebs.ipfRuleRotateDetail.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfRuleRotateDetailServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfRuleRotateDetailServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateDetailGetSessionRequest ipfRuleRotateDetailRequest = new IpfRuleRotateDetailGetSessionRequest();
     	CompositeResponse<IpfRuleRotateDetailGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfRuleRotateDetailRequest, IpfRuleRotateDetailGetSessionResponse.class, "ipfRuleRotateDetail.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfRuleRotateDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateDetailCreateRequest ipfRuleRotateDetailRequest = new IpfRuleRotateDetailCreateRequest();
	   	ipfRuleRotateDetailRequest.setId("1");
	   	ipfRuleRotateDetailRequest.setIpfRuleRotateId("1");
	   	ipfRuleRotateDetailRequest.setLineId("1");
	   	ipfRuleRotateDetailRequest.setLotAttributes("1");
	   	ipfRuleRotateDetailRequest.setSortType("1");
	   	ipfRuleRotateDetailRequest.setDetailDesc("1");
	   	ipfRuleRotateDetailRequest.setIsActive("1");
        CompositeResponse<IpfRuleRotateDetailCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateDetailRequest, IpfRuleRotateDetailCreateResponse.class, "ipfRuleRotateDetail.createIpfRuleRotateDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateDetailCreateResponse ipfRuleRotateDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfRuleRotateDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateDetailDeleteRequest ipfRuleRotateDetailRequest = new IpfRuleRotateDetailDeleteRequest();
	   	ipfRuleRotateDetailRequest.setId("1");
        CompositeResponse<IpfRuleRotateDetailDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateDetailRequest, IpfRuleRotateDetailDeleteResponse.class, "ipfRuleRotateDetail.deleteIpfRuleRotateDetail", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateDetailDeleteResponse ipfRuleRotateDetailResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfRuleRotateDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateDetailUpdateRequest ipfRuleRotateDetailRequest = new IpfRuleRotateDetailUpdateRequest();
	   	ipfRuleRotateDetailRequest.setId("1");
	   	ipfRuleRotateDetailRequest.setIpfRuleRotateId("1");
	   	ipfRuleRotateDetailRequest.setLineId("1");
	   	ipfRuleRotateDetailRequest.setLotAttributes("1");
	   	ipfRuleRotateDetailRequest.setSortType("1");
	   	ipfRuleRotateDetailRequest.setDetailDesc("1");
	   	ipfRuleRotateDetailRequest.setIsActive("1");
        CompositeResponse<IpfRuleRotateDetailUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateDetailRequest, IpfRuleRotateDetailUpdateResponse.class, "ipfRuleRotateDetail.updateIpfRuleRotateDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateDetailUpdateResponse ipfRuleRotateDetailResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfRuleRotateDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateDetailGetRequest ipfRuleRotateDetailRequest = new IpfRuleRotateDetailGetRequest();
	   	ipfRuleRotateDetailRequest.setId("1");
        CompositeResponse<IpfRuleRotateDetailGetResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateDetailRequest, IpfRuleRotateDetailGetResponse.class, "ipfRuleRotateDetail.getIpfRuleRotateDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateDetailGetResponse ipfRuleRotateDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateDetailSelectAllRequest ipfRuleRotateDetailRequest = new IpfRuleRotateDetailSelectAllRequest();

        CompositeResponse<IpfRuleRotateDetailSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateDetailRequest, IpfRuleRotateDetailSelectAllResponse.class, "ipfRuleRotateDetail.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateDetailSelectAllResponse ipfRuleRotateDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateDetailCountAllRequest ipfRuleRotateDetailRequest = new IpfRuleRotateDetailCountAllRequest();

        CompositeResponse<IpfRuleRotateDetailCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateDetailRequest, IpfRuleRotateDetailCountAllResponse.class, "ipfRuleRotateDetail.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateDetailCountAllResponse ipfRuleRotateDetailResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfRuleRotateDetailResponse.getResultString());
    }

    @Test
    public void selectIpfRuleRotateDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateDetailSelectRequest ipfRuleRotateDetailRequest = new IpfRuleRotateDetailSelectRequest();
	   	ipfRuleRotateDetailRequest.setId("1");
	   	ipfRuleRotateDetailRequest.setIpfRuleRotateId("1");
	   	ipfRuleRotateDetailRequest.setLineId("1");
	   	ipfRuleRotateDetailRequest.setLotAttributes("1");
	   	ipfRuleRotateDetailRequest.setSortType("1");
	   	ipfRuleRotateDetailRequest.setDetailDesc("1");
	   	ipfRuleRotateDetailRequest.setIsActive("1");
        CompositeResponse<IpfRuleRotateDetailCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateDetailRequest, IpfRuleRotateDetailCreateResponse.class, "ipfRuleRotateDetail.createIpfRuleRotateDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfRuleRotateDetailRequest.setId("1");
	   	ipfRuleRotateDetailRequest.setIpfRuleRotateId("1");
	   	ipfRuleRotateDetailRequest.setLineId("1");
	   	ipfRuleRotateDetailRequest.setLotAttributes("1");
	   	ipfRuleRotateDetailRequest.setSortType("1");
	   	ipfRuleRotateDetailRequest.setDetailDesc("1");
	   	ipfRuleRotateDetailRequest.setIsActive("1");
        CompositeResponse<IpfRuleRotateDetailSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfRuleRotateDetailRequest, IpfRuleRotateDetailSelectResponse.class, "ipfRuleRotateDetail.selectIpfRuleRotateDetail", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateDetailSelectResponse ipfRuleRotateDetailResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfRuleRotateDetailResponse.getResultJson());
        CompositeResponse<IpfRuleRotateDetailDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfRuleRotateDetailRequest, IpfRuleRotateDetailDeleteResponse.class, "ipfRuleRotateDetail.deleteIpfRuleRotateDetail", "1.0");

    }
}
