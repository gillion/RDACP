/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmNumruleList;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmNumruleList.request.*;
import com.cartan.center.ebs.ipfCcmNumruleList.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmNumruleListServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmNumruleListServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleListGetSessionRequest ipfCcmNumruleListRequest = new IpfCcmNumruleListGetSessionRequest();
     	CompositeResponse<IpfCcmNumruleListGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmNumruleListRequest, IpfCcmNumruleListGetSessionResponse.class, "ipfCcmNumruleList.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmNumruleList(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleListCreateRequest ipfCcmNumruleListRequest = new IpfCcmNumruleListCreateRequest();
	   	ipfCcmNumruleListRequest.setId("1");
	   	ipfCcmNumruleListRequest.setIpfCcmNumruleId("1");
	   	ipfCcmNumruleListRequest.setConstExpression("1");
	   	ipfCcmNumruleListRequest.setCurrentValue("1");
	   	ipfCcmNumruleListRequest.setInitialValue("1");
	   	ipfCcmNumruleListRequest.setMaxValue("1");
	   	ipfCcmNumruleListRequest.setGrowth("1");
	   	ipfCcmNumruleListRequest.setRemark("1");
	   	ipfCcmNumruleListRequest.setIsActive("1");
        CompositeResponse<IpfCcmNumruleListCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleListRequest, IpfCcmNumruleListCreateResponse.class, "ipfCcmNumruleList.createIpfCcmNumruleList", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleListCreateResponse ipfCcmNumruleListResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmNumruleList(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleListDeleteRequest ipfCcmNumruleListRequest = new IpfCcmNumruleListDeleteRequest();
	   	ipfCcmNumruleListRequest.setId("1");
        CompositeResponse<IpfCcmNumruleListDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleListRequest, IpfCcmNumruleListDeleteResponse.class, "ipfCcmNumruleList.deleteIpfCcmNumruleList", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleListDeleteResponse ipfCcmNumruleListResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmNumruleList(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleListUpdateRequest ipfCcmNumruleListRequest = new IpfCcmNumruleListUpdateRequest();
	   	ipfCcmNumruleListRequest.setId("1");
	   	ipfCcmNumruleListRequest.setIpfCcmNumruleId("1");
	   	ipfCcmNumruleListRequest.setConstExpression("1");
	   	ipfCcmNumruleListRequest.setCurrentValue("1");
	   	ipfCcmNumruleListRequest.setInitialValue("1");
	   	ipfCcmNumruleListRequest.setMaxValue("1");
	   	ipfCcmNumruleListRequest.setGrowth("1");
	   	ipfCcmNumruleListRequest.setRemark("1");
	   	ipfCcmNumruleListRequest.setIsActive("1");
        CompositeResponse<IpfCcmNumruleListUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleListRequest, IpfCcmNumruleListUpdateResponse.class, "ipfCcmNumruleList.updateIpfCcmNumruleList", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleListUpdateResponse ipfCcmNumruleListResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmNumruleList(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleListGetRequest ipfCcmNumruleListRequest = new IpfCcmNumruleListGetRequest();
	   	ipfCcmNumruleListRequest.setId("1");
        CompositeResponse<IpfCcmNumruleListGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleListRequest, IpfCcmNumruleListGetResponse.class, "ipfCcmNumruleList.getIpfCcmNumruleList", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleListGetResponse ipfCcmNumruleListResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleListSelectAllRequest ipfCcmNumruleListRequest = new IpfCcmNumruleListSelectAllRequest();

        CompositeResponse<IpfCcmNumruleListSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleListRequest, IpfCcmNumruleListSelectAllResponse.class, "ipfCcmNumruleList.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleListSelectAllResponse ipfCcmNumruleListResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleListCountAllRequest ipfCcmNumruleListRequest = new IpfCcmNumruleListCountAllRequest();

        CompositeResponse<IpfCcmNumruleListCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleListRequest, IpfCcmNumruleListCountAllResponse.class, "ipfCcmNumruleList.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleListCountAllResponse ipfCcmNumruleListResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmNumruleListResponse.getResultString());
    }

    @Test
    public void selectIpfCcmNumruleList(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmNumruleListSelectRequest ipfCcmNumruleListRequest = new IpfCcmNumruleListSelectRequest();
	   	ipfCcmNumruleListRequest.setId("1");
	   	ipfCcmNumruleListRequest.setIpfCcmNumruleId("1");
	   	ipfCcmNumruleListRequest.setConstExpression("1");
	   	ipfCcmNumruleListRequest.setCurrentValue("1");
	   	ipfCcmNumruleListRequest.setInitialValue("1");
	   	ipfCcmNumruleListRequest.setMaxValue("1");
	   	ipfCcmNumruleListRequest.setGrowth("1");
	   	ipfCcmNumruleListRequest.setRemark("1");
	   	ipfCcmNumruleListRequest.setIsActive("1");
        CompositeResponse<IpfCcmNumruleListCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmNumruleListRequest, IpfCcmNumruleListCreateResponse.class, "ipfCcmNumruleList.createIpfCcmNumruleList", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmNumruleListRequest.setId("1");
	   	ipfCcmNumruleListRequest.setIpfCcmNumruleId("1");
	   	ipfCcmNumruleListRequest.setConstExpression("1");
	   	ipfCcmNumruleListRequest.setCurrentValue("1");
	   	ipfCcmNumruleListRequest.setInitialValue("1");
	   	ipfCcmNumruleListRequest.setMaxValue("1");
	   	ipfCcmNumruleListRequest.setGrowth("1");
	   	ipfCcmNumruleListRequest.setRemark("1");
	   	ipfCcmNumruleListRequest.setIsActive("1");
        CompositeResponse<IpfCcmNumruleListSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmNumruleListRequest, IpfCcmNumruleListSelectResponse.class, "ipfCcmNumruleList.selectIpfCcmNumruleList", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmNumruleListSelectResponse ipfCcmNumruleListResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmNumruleListResponse.getResultJson());
        CompositeResponse<IpfCcmNumruleListDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmNumruleListRequest, IpfCcmNumruleListDeleteResponse.class, "ipfCcmNumruleList.deleteIpfCcmNumruleList", "1.0");

    }
}
