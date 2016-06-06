/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayoutDetail;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmUiLayoutDetail.request.*;
import com.cartan.center.ebs.ipfCcmUiLayoutDetail.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmUiLayoutDetailServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmUiLayoutDetailServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutDetailGetSessionRequest ipfCcmUiLayoutDetailRequest = new IpfCcmUiLayoutDetailGetSessionRequest();
     	CompositeResponse<IpfCcmUiLayoutDetailGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmUiLayoutDetailRequest, IpfCcmUiLayoutDetailGetSessionResponse.class, "ipfCcmUiLayoutDetail.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmUiLayoutDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutDetailCreateRequest ipfCcmUiLayoutDetailRequest = new IpfCcmUiLayoutDetailCreateRequest();
	   	ipfCcmUiLayoutDetailRequest.setId("1");
	   	ipfCcmUiLayoutDetailRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmUiLayoutDetailRequest.setIpfCcmUiLayoutListId("1");
	   	ipfCcmUiLayoutDetailRequest.setLayoutElementName("1");
	   	ipfCcmUiLayoutDetailRequest.setDescription("1");
        CompositeResponse<IpfCcmUiLayoutDetailCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutDetailRequest, IpfCcmUiLayoutDetailCreateResponse.class, "ipfCcmUiLayoutDetail.createIpfCcmUiLayoutDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutDetailCreateResponse ipfCcmUiLayoutDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmUiLayoutDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutDetailDeleteRequest ipfCcmUiLayoutDetailRequest = new IpfCcmUiLayoutDetailDeleteRequest();
	   	ipfCcmUiLayoutDetailRequest.setId("1");
        CompositeResponse<IpfCcmUiLayoutDetailDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutDetailRequest, IpfCcmUiLayoutDetailDeleteResponse.class, "ipfCcmUiLayoutDetail.deleteIpfCcmUiLayoutDetail", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutDetailDeleteResponse ipfCcmUiLayoutDetailResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmUiLayoutDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutDetailUpdateRequest ipfCcmUiLayoutDetailRequest = new IpfCcmUiLayoutDetailUpdateRequest();
	   	ipfCcmUiLayoutDetailRequest.setId("1");
	   	ipfCcmUiLayoutDetailRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmUiLayoutDetailRequest.setIpfCcmUiLayoutListId("1");
	   	ipfCcmUiLayoutDetailRequest.setLayoutElementName("1");
	   	ipfCcmUiLayoutDetailRequest.setDescription("1");
        CompositeResponse<IpfCcmUiLayoutDetailUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutDetailRequest, IpfCcmUiLayoutDetailUpdateResponse.class, "ipfCcmUiLayoutDetail.updateIpfCcmUiLayoutDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutDetailUpdateResponse ipfCcmUiLayoutDetailResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmUiLayoutDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutDetailGetRequest ipfCcmUiLayoutDetailRequest = new IpfCcmUiLayoutDetailGetRequest();
	   	ipfCcmUiLayoutDetailRequest.setId("1");
        CompositeResponse<IpfCcmUiLayoutDetailGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutDetailRequest, IpfCcmUiLayoutDetailGetResponse.class, "ipfCcmUiLayoutDetail.getIpfCcmUiLayoutDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutDetailGetResponse ipfCcmUiLayoutDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutDetailSelectAllRequest ipfCcmUiLayoutDetailRequest = new IpfCcmUiLayoutDetailSelectAllRequest();

        CompositeResponse<IpfCcmUiLayoutDetailSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutDetailRequest, IpfCcmUiLayoutDetailSelectAllResponse.class, "ipfCcmUiLayoutDetail.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutDetailSelectAllResponse ipfCcmUiLayoutDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutDetailCountAllRequest ipfCcmUiLayoutDetailRequest = new IpfCcmUiLayoutDetailCountAllRequest();

        CompositeResponse<IpfCcmUiLayoutDetailCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutDetailRequest, IpfCcmUiLayoutDetailCountAllResponse.class, "ipfCcmUiLayoutDetail.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutDetailCountAllResponse ipfCcmUiLayoutDetailResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmUiLayoutDetailResponse.getResultString());
    }

    @Test
    public void selectIpfCcmUiLayoutDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutDetailSelectRequest ipfCcmUiLayoutDetailRequest = new IpfCcmUiLayoutDetailSelectRequest();
	   	ipfCcmUiLayoutDetailRequest.setId("1");
	   	ipfCcmUiLayoutDetailRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmUiLayoutDetailRequest.setIpfCcmUiLayoutListId("1");
	   	ipfCcmUiLayoutDetailRequest.setLayoutElementName("1");
	   	ipfCcmUiLayoutDetailRequest.setDescription("1");
        CompositeResponse<IpfCcmUiLayoutDetailCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutDetailRequest, IpfCcmUiLayoutDetailCreateResponse.class, "ipfCcmUiLayoutDetail.createIpfCcmUiLayoutDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmUiLayoutDetailRequest.setId("1");
	   	ipfCcmUiLayoutDetailRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmUiLayoutDetailRequest.setIpfCcmUiLayoutListId("1");
	   	ipfCcmUiLayoutDetailRequest.setLayoutElementName("1");
	   	ipfCcmUiLayoutDetailRequest.setDescription("1");
        CompositeResponse<IpfCcmUiLayoutDetailSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutDetailRequest, IpfCcmUiLayoutDetailSelectResponse.class, "ipfCcmUiLayoutDetail.selectIpfCcmUiLayoutDetail", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutDetailSelectResponse ipfCcmUiLayoutDetailResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmUiLayoutDetailResponse.getResultJson());
        CompositeResponse<IpfCcmUiLayoutDetailDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutDetailRequest, IpfCcmUiLayoutDetailDeleteResponse.class, "ipfCcmUiLayoutDetail.deleteIpfCcmUiLayoutDetail", "1.0");

    }
}
