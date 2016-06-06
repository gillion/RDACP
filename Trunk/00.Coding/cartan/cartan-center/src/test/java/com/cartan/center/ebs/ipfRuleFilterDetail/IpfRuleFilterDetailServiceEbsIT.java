/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRuleFilterDetail;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfRuleFilterDetail.request.*;
import com.cartan.center.ebs.ipfRuleFilterDetail.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfRuleFilterDetailServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfRuleFilterDetailServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterDetailGetSessionRequest ipfRuleFilterDetailRequest = new IpfRuleFilterDetailGetSessionRequest();
     	CompositeResponse<IpfRuleFilterDetailGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfRuleFilterDetailRequest, IpfRuleFilterDetailGetSessionResponse.class, "ipfRuleFilterDetail.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfRuleFilterDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterDetailCreateRequest ipfRuleFilterDetailRequest = new IpfRuleFilterDetailCreateRequest();
	   	ipfRuleFilterDetailRequest.setId("1");
	   	ipfRuleFilterDetailRequest.setIpfRuleFilterId("1");
	   	ipfRuleFilterDetailRequest.setLineId("1");
	   	ipfRuleFilterDetailRequest.setAttribute("1");
	   	ipfRuleFilterDetailRequest.setOperand("1");
	   	ipfRuleFilterDetailRequest.setLiteralValue("1");
	   	ipfRuleFilterDetailRequest.setAndOr("1");
	   	ipfRuleFilterDetailRequest.setLeftParen("1");
	   	ipfRuleFilterDetailRequest.setRightParen("1");
        CompositeResponse<IpfRuleFilterDetailCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterDetailRequest, IpfRuleFilterDetailCreateResponse.class, "ipfRuleFilterDetail.createIpfRuleFilterDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterDetailCreateResponse ipfRuleFilterDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfRuleFilterDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterDetailDeleteRequest ipfRuleFilterDetailRequest = new IpfRuleFilterDetailDeleteRequest();
	   	ipfRuleFilterDetailRequest.setId("1");
        CompositeResponse<IpfRuleFilterDetailDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterDetailRequest, IpfRuleFilterDetailDeleteResponse.class, "ipfRuleFilterDetail.deleteIpfRuleFilterDetail", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterDetailDeleteResponse ipfRuleFilterDetailResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfRuleFilterDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterDetailUpdateRequest ipfRuleFilterDetailRequest = new IpfRuleFilterDetailUpdateRequest();
	   	ipfRuleFilterDetailRequest.setId("1");
	   	ipfRuleFilterDetailRequest.setIpfRuleFilterId("1");
	   	ipfRuleFilterDetailRequest.setLineId("1");
	   	ipfRuleFilterDetailRequest.setAttribute("1");
	   	ipfRuleFilterDetailRequest.setOperand("1");
	   	ipfRuleFilterDetailRequest.setLiteralValue("1");
	   	ipfRuleFilterDetailRequest.setAndOr("1");
	   	ipfRuleFilterDetailRequest.setLeftParen("1");
	   	ipfRuleFilterDetailRequest.setRightParen("1");
        CompositeResponse<IpfRuleFilterDetailUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterDetailRequest, IpfRuleFilterDetailUpdateResponse.class, "ipfRuleFilterDetail.updateIpfRuleFilterDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterDetailUpdateResponse ipfRuleFilterDetailResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfRuleFilterDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterDetailGetRequest ipfRuleFilterDetailRequest = new IpfRuleFilterDetailGetRequest();
	   	ipfRuleFilterDetailRequest.setId("1");
        CompositeResponse<IpfRuleFilterDetailGetResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterDetailRequest, IpfRuleFilterDetailGetResponse.class, "ipfRuleFilterDetail.getIpfRuleFilterDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterDetailGetResponse ipfRuleFilterDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterDetailSelectAllRequest ipfRuleFilterDetailRequest = new IpfRuleFilterDetailSelectAllRequest();

        CompositeResponse<IpfRuleFilterDetailSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterDetailRequest, IpfRuleFilterDetailSelectAllResponse.class, "ipfRuleFilterDetail.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterDetailSelectAllResponse ipfRuleFilterDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterDetailCountAllRequest ipfRuleFilterDetailRequest = new IpfRuleFilterDetailCountAllRequest();

        CompositeResponse<IpfRuleFilterDetailCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterDetailRequest, IpfRuleFilterDetailCountAllResponse.class, "ipfRuleFilterDetail.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterDetailCountAllResponse ipfRuleFilterDetailResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfRuleFilterDetailResponse.getResultString());
    }

    @Test
    public void selectIpfRuleFilterDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleFilterDetailSelectRequest ipfRuleFilterDetailRequest = new IpfRuleFilterDetailSelectRequest();
	   	ipfRuleFilterDetailRequest.setId("1");
	   	ipfRuleFilterDetailRequest.setIpfRuleFilterId("1");
	   	ipfRuleFilterDetailRequest.setLineId("1");
	   	ipfRuleFilterDetailRequest.setAttribute("1");
	   	ipfRuleFilterDetailRequest.setOperand("1");
	   	ipfRuleFilterDetailRequest.setLiteralValue("1");
	   	ipfRuleFilterDetailRequest.setAndOr("1");
	   	ipfRuleFilterDetailRequest.setLeftParen("1");
	   	ipfRuleFilterDetailRequest.setRightParen("1");
        CompositeResponse<IpfRuleFilterDetailCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleFilterDetailRequest, IpfRuleFilterDetailCreateResponse.class, "ipfRuleFilterDetail.createIpfRuleFilterDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfRuleFilterDetailRequest.setId("1");
	   	ipfRuleFilterDetailRequest.setIpfRuleFilterId("1");
	   	ipfRuleFilterDetailRequest.setLineId("1");
	   	ipfRuleFilterDetailRequest.setAttribute("1");
	   	ipfRuleFilterDetailRequest.setOperand("1");
	   	ipfRuleFilterDetailRequest.setLiteralValue("1");
	   	ipfRuleFilterDetailRequest.setAndOr("1");
	   	ipfRuleFilterDetailRequest.setLeftParen("1");
	   	ipfRuleFilterDetailRequest.setRightParen("1");
        CompositeResponse<IpfRuleFilterDetailSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfRuleFilterDetailRequest, IpfRuleFilterDetailSelectResponse.class, "ipfRuleFilterDetail.selectIpfRuleFilterDetail", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleFilterDetailSelectResponse ipfRuleFilterDetailResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfRuleFilterDetailResponse.getResultJson());
        CompositeResponse<IpfRuleFilterDetailDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfRuleFilterDetailRequest, IpfRuleFilterDetailDeleteResponse.class, "ipfRuleFilterDetail.deleteIpfRuleFilterDetail", "1.0");

    }
}
