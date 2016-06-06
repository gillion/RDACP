/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayoutList;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmUiLayoutList.request.*;
import com.cartan.center.ebs.ipfCcmUiLayoutList.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmUiLayoutListServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmUiLayoutListServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutListGetSessionRequest ipfCcmUiLayoutListRequest = new IpfCcmUiLayoutListGetSessionRequest();
     	CompositeResponse<IpfCcmUiLayoutListGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmUiLayoutListRequest, IpfCcmUiLayoutListGetSessionResponse.class, "ipfCcmUiLayoutList.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmUiLayoutList(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutListCreateRequest ipfCcmUiLayoutListRequest = new IpfCcmUiLayoutListCreateRequest();
	   	ipfCcmUiLayoutListRequest.setId("1");
	   	ipfCcmUiLayoutListRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmUiLayoutListRequest.setPageName("1");
	   	ipfCcmUiLayoutListRequest.setDescription("1");
	   	ipfCcmUiLayoutListRequest.setImagePath("1");
        CompositeResponse<IpfCcmUiLayoutListCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutListRequest, IpfCcmUiLayoutListCreateResponse.class, "ipfCcmUiLayoutList.createIpfCcmUiLayoutList", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutListCreateResponse ipfCcmUiLayoutListResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmUiLayoutList(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutListDeleteRequest ipfCcmUiLayoutListRequest = new IpfCcmUiLayoutListDeleteRequest();
	   	ipfCcmUiLayoutListRequest.setId("1");
        CompositeResponse<IpfCcmUiLayoutListDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutListRequest, IpfCcmUiLayoutListDeleteResponse.class, "ipfCcmUiLayoutList.deleteIpfCcmUiLayoutList", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutListDeleteResponse ipfCcmUiLayoutListResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmUiLayoutList(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutListUpdateRequest ipfCcmUiLayoutListRequest = new IpfCcmUiLayoutListUpdateRequest();
	   	ipfCcmUiLayoutListRequest.setId("1");
	   	ipfCcmUiLayoutListRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmUiLayoutListRequest.setPageName("1");
	   	ipfCcmUiLayoutListRequest.setDescription("1");
	   	ipfCcmUiLayoutListRequest.setImagePath("1");
        CompositeResponse<IpfCcmUiLayoutListUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutListRequest, IpfCcmUiLayoutListUpdateResponse.class, "ipfCcmUiLayoutList.updateIpfCcmUiLayoutList", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutListUpdateResponse ipfCcmUiLayoutListResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmUiLayoutList(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutListGetRequest ipfCcmUiLayoutListRequest = new IpfCcmUiLayoutListGetRequest();
	   	ipfCcmUiLayoutListRequest.setId("1");
        CompositeResponse<IpfCcmUiLayoutListGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutListRequest, IpfCcmUiLayoutListGetResponse.class, "ipfCcmUiLayoutList.getIpfCcmUiLayoutList", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutListGetResponse ipfCcmUiLayoutListResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutListSelectAllRequest ipfCcmUiLayoutListRequest = new IpfCcmUiLayoutListSelectAllRequest();

        CompositeResponse<IpfCcmUiLayoutListSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutListRequest, IpfCcmUiLayoutListSelectAllResponse.class, "ipfCcmUiLayoutList.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutListSelectAllResponse ipfCcmUiLayoutListResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutListCountAllRequest ipfCcmUiLayoutListRequest = new IpfCcmUiLayoutListCountAllRequest();

        CompositeResponse<IpfCcmUiLayoutListCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutListRequest, IpfCcmUiLayoutListCountAllResponse.class, "ipfCcmUiLayoutList.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutListCountAllResponse ipfCcmUiLayoutListResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmUiLayoutListResponse.getResultString());
    }

    @Test
    public void selectIpfCcmUiLayoutList(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmUiLayoutListSelectRequest ipfCcmUiLayoutListRequest = new IpfCcmUiLayoutListSelectRequest();
	   	ipfCcmUiLayoutListRequest.setId("1");
	   	ipfCcmUiLayoutListRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmUiLayoutListRequest.setPageName("1");
	   	ipfCcmUiLayoutListRequest.setDescription("1");
	   	ipfCcmUiLayoutListRequest.setImagePath("1");
        CompositeResponse<IpfCcmUiLayoutListCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutListRequest, IpfCcmUiLayoutListCreateResponse.class, "ipfCcmUiLayoutList.createIpfCcmUiLayoutList", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmUiLayoutListRequest.setId("1");
	   	ipfCcmUiLayoutListRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmUiLayoutListRequest.setPageName("1");
	   	ipfCcmUiLayoutListRequest.setDescription("1");
	   	ipfCcmUiLayoutListRequest.setImagePath("1");
        CompositeResponse<IpfCcmUiLayoutListSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutListRequest, IpfCcmUiLayoutListSelectResponse.class, "ipfCcmUiLayoutList.selectIpfCcmUiLayoutList", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmUiLayoutListSelectResponse ipfCcmUiLayoutListResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmUiLayoutListResponse.getResultJson());
        CompositeResponse<IpfCcmUiLayoutListDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmUiLayoutListRequest, IpfCcmUiLayoutListDeleteResponse.class, "ipfCcmUiLayoutList.deleteIpfCcmUiLayoutList", "1.0");

    }
}
