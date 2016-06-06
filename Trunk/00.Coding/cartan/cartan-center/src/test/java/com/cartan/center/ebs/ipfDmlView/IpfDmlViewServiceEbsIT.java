/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlView;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlView.request.*;
import com.cartan.center.ebs.ipfDmlView.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlViewServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlViewServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewGetSessionRequest ipfDmlViewRequest = new IpfDmlViewGetSessionRequest();
     	CompositeResponse<IpfDmlViewGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlViewRequest, IpfDmlViewGetSessionResponse.class, "ipfDmlView.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlView(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewCreateRequest ipfDmlViewRequest = new IpfDmlViewCreateRequest();
	   	ipfDmlViewRequest.setId("1");
	   	ipfDmlViewRequest.setViewName("1");
	   	ipfDmlViewRequest.setViewDes("1");
	   	ipfDmlViewRequest.setViewType("1");
        CompositeResponse<IpfDmlViewCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewRequest, IpfDmlViewCreateResponse.class, "ipfDmlView.createIpfDmlView", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewCreateResponse ipfDmlViewResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlView(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewDeleteRequest ipfDmlViewRequest = new IpfDmlViewDeleteRequest();
	   	ipfDmlViewRequest.setId("1");
        CompositeResponse<IpfDmlViewDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewRequest, IpfDmlViewDeleteResponse.class, "ipfDmlView.deleteIpfDmlView", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewDeleteResponse ipfDmlViewResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlView(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewUpdateRequest ipfDmlViewRequest = new IpfDmlViewUpdateRequest();
	   	ipfDmlViewRequest.setId("1");
	   	ipfDmlViewRequest.setViewName("1");
	   	ipfDmlViewRequest.setViewDes("1");
	   	ipfDmlViewRequest.setViewType("1");
        CompositeResponse<IpfDmlViewUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewRequest, IpfDmlViewUpdateResponse.class, "ipfDmlView.updateIpfDmlView", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewUpdateResponse ipfDmlViewResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlView(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewGetRequest ipfDmlViewRequest = new IpfDmlViewGetRequest();
	   	ipfDmlViewRequest.setId("1");
        CompositeResponse<IpfDmlViewGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewRequest, IpfDmlViewGetResponse.class, "ipfDmlView.getIpfDmlView", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewGetResponse ipfDmlViewResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewSelectAllRequest ipfDmlViewRequest = new IpfDmlViewSelectAllRequest();

        CompositeResponse<IpfDmlViewSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewRequest, IpfDmlViewSelectAllResponse.class, "ipfDmlView.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewSelectAllResponse ipfDmlViewResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewCountAllRequest ipfDmlViewRequest = new IpfDmlViewCountAllRequest();

        CompositeResponse<IpfDmlViewCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewRequest, IpfDmlViewCountAllResponse.class, "ipfDmlView.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewCountAllResponse ipfDmlViewResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlViewResponse.getResultString());
    }

    @Test
    public void selectIpfDmlView(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewSelectRequest ipfDmlViewRequest = new IpfDmlViewSelectRequest();
	   	ipfDmlViewRequest.setId("1");
	   	ipfDmlViewRequest.setViewName("1");
	   	ipfDmlViewRequest.setViewDes("1");
	   	ipfDmlViewRequest.setViewType("1");
        CompositeResponse<IpfDmlViewCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewRequest, IpfDmlViewCreateResponse.class, "ipfDmlView.createIpfDmlView", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlViewRequest.setId("1");
	   	ipfDmlViewRequest.setViewName("1");
	   	ipfDmlViewRequest.setViewDes("1");
	   	ipfDmlViewRequest.setViewType("1");
        CompositeResponse<IpfDmlViewSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlViewRequest, IpfDmlViewSelectResponse.class, "ipfDmlView.selectIpfDmlView", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewSelectResponse ipfDmlViewResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlViewResponse.getResultJson());
        CompositeResponse<IpfDmlViewDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlViewRequest, IpfDmlViewDeleteResponse.class, "ipfDmlView.deleteIpfDmlView", "1.0");

    }
}
