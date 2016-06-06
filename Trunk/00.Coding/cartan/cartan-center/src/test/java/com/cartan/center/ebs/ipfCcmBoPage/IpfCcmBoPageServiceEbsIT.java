/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoPage;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoPage.request.*;
import com.cartan.center.ebs.ipfCcmBoPage.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoPageServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoPageServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageGetSessionRequest ipfCcmBoPageRequest = new IpfCcmBoPageGetSessionRequest();
     	CompositeResponse<IpfCcmBoPageGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoPageRequest, IpfCcmBoPageGetSessionResponse.class, "ipfCcmBoPage.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoPage(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageCreateRequest ipfCcmBoPageRequest = new IpfCcmBoPageCreateRequest();
	   	ipfCcmBoPageRequest.setId("1");
	   	ipfCcmBoPageRequest.setIpfCcmBoId("1");
	   	ipfCcmBoPageRequest.setPageType("1");
	   	ipfCcmBoPageRequest.setDescription("1");
	   	ipfCcmBoPageRequest.setPageName("1");
        CompositeResponse<IpfCcmBoPageCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageRequest, IpfCcmBoPageCreateResponse.class, "ipfCcmBoPage.createIpfCcmBoPage", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageCreateResponse ipfCcmBoPageResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoPage(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageDeleteRequest ipfCcmBoPageRequest = new IpfCcmBoPageDeleteRequest();
	   	ipfCcmBoPageRequest.setId("1");
        CompositeResponse<IpfCcmBoPageDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageRequest, IpfCcmBoPageDeleteResponse.class, "ipfCcmBoPage.deleteIpfCcmBoPage", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageDeleteResponse ipfCcmBoPageResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoPage(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageUpdateRequest ipfCcmBoPageRequest = new IpfCcmBoPageUpdateRequest();
	   	ipfCcmBoPageRequest.setId("1");
	   	ipfCcmBoPageRequest.setIpfCcmBoId("1");
	   	ipfCcmBoPageRequest.setPageType("1");
	   	ipfCcmBoPageRequest.setDescription("1");
	   	ipfCcmBoPageRequest.setPageName("1");
        CompositeResponse<IpfCcmBoPageUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageRequest, IpfCcmBoPageUpdateResponse.class, "ipfCcmBoPage.updateIpfCcmBoPage", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageUpdateResponse ipfCcmBoPageResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoPage(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageGetRequest ipfCcmBoPageRequest = new IpfCcmBoPageGetRequest();
	   	ipfCcmBoPageRequest.setId("1");
        CompositeResponse<IpfCcmBoPageGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageRequest, IpfCcmBoPageGetResponse.class, "ipfCcmBoPage.getIpfCcmBoPage", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageGetResponse ipfCcmBoPageResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageSelectAllRequest ipfCcmBoPageRequest = new IpfCcmBoPageSelectAllRequest();

        CompositeResponse<IpfCcmBoPageSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageRequest, IpfCcmBoPageSelectAllResponse.class, "ipfCcmBoPage.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageSelectAllResponse ipfCcmBoPageResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageCountAllRequest ipfCcmBoPageRequest = new IpfCcmBoPageCountAllRequest();

        CompositeResponse<IpfCcmBoPageCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageRequest, IpfCcmBoPageCountAllResponse.class, "ipfCcmBoPage.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageCountAllResponse ipfCcmBoPageResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoPageResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoPage(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageSelectRequest ipfCcmBoPageRequest = new IpfCcmBoPageSelectRequest();
	   	ipfCcmBoPageRequest.setId("1");
	   	ipfCcmBoPageRequest.setIpfCcmBoId("1");
	   	ipfCcmBoPageRequest.setPageType("1");
	   	ipfCcmBoPageRequest.setDescription("1");
	   	ipfCcmBoPageRequest.setPageName("1");
        CompositeResponse<IpfCcmBoPageCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageRequest, IpfCcmBoPageCreateResponse.class, "ipfCcmBoPage.createIpfCcmBoPage", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoPageRequest.setId("1");
	   	ipfCcmBoPageRequest.setIpfCcmBoId("1");
	   	ipfCcmBoPageRequest.setPageType("1");
	   	ipfCcmBoPageRequest.setDescription("1");
	   	ipfCcmBoPageRequest.setPageName("1");
        CompositeResponse<IpfCcmBoPageSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoPageRequest, IpfCcmBoPageSelectResponse.class, "ipfCcmBoPage.selectIpfCcmBoPage", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageSelectResponse ipfCcmBoPageResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoPageResponse.getResultJson());
        CompositeResponse<IpfCcmBoPageDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoPageRequest, IpfCcmBoPageDeleteResponse.class, "ipfCcmBoPage.deleteIpfCcmBoPage", "1.0");

    }
}
