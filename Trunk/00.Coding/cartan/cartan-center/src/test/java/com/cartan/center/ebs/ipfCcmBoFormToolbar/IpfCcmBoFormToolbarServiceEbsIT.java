/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoFormToolbar;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoFormToolbar.request.*;
import com.cartan.center.ebs.ipfCcmBoFormToolbar.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoFormToolbarServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoFormToolbarServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormToolbarGetSessionRequest ipfCcmBoFormToolbarRequest = new IpfCcmBoFormToolbarGetSessionRequest();
     	CompositeResponse<IpfCcmBoFormToolbarGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoFormToolbarRequest, IpfCcmBoFormToolbarGetSessionResponse.class, "ipfCcmBoFormToolbar.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoFormToolbar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormToolbarCreateRequest ipfCcmBoFormToolbarRequest = new IpfCcmBoFormToolbarCreateRequest();
	   	ipfCcmBoFormToolbarRequest.setId("1");
	   	ipfCcmBoFormToolbarRequest.setIpfCcbBoId("1");
	   	ipfCcmBoFormToolbarRequest.setMethodName("1");
	   	ipfCcmBoFormToolbarRequest.setMethodDesc("1");
	   	ipfCcmBoFormToolbarRequest.setSeqNo("1");
	   	ipfCcmBoFormToolbarRequest.setMethodId("1");
	   	ipfCcmBoFormToolbarRequest.setButtonStyle("1");
	   	ipfCcmBoFormToolbarRequest.setDisabledExpree("1");
	   	ipfCcmBoFormToolbarRequest.setIsRefreshParentBo("1");
	   	ipfCcmBoFormToolbarRequest.setHotkeyType("1");
	   	ipfCcmBoFormToolbarRequest.setHotkeyValue("1");
	   	ipfCcmBoFormToolbarRequest.setIsHide("1");
        CompositeResponse<IpfCcmBoFormToolbarCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormToolbarRequest, IpfCcmBoFormToolbarCreateResponse.class, "ipfCcmBoFormToolbar.createIpfCcmBoFormToolbar", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormToolbarCreateResponse ipfCcmBoFormToolbarResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoFormToolbar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormToolbarDeleteRequest ipfCcmBoFormToolbarRequest = new IpfCcmBoFormToolbarDeleteRequest();
	   	ipfCcmBoFormToolbarRequest.setId("1");
        CompositeResponse<IpfCcmBoFormToolbarDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormToolbarRequest, IpfCcmBoFormToolbarDeleteResponse.class, "ipfCcmBoFormToolbar.deleteIpfCcmBoFormToolbar", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormToolbarDeleteResponse ipfCcmBoFormToolbarResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoFormToolbar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormToolbarUpdateRequest ipfCcmBoFormToolbarRequest = new IpfCcmBoFormToolbarUpdateRequest();
	   	ipfCcmBoFormToolbarRequest.setId("1");
	   	ipfCcmBoFormToolbarRequest.setIpfCcbBoId("1");
	   	ipfCcmBoFormToolbarRequest.setMethodName("1");
	   	ipfCcmBoFormToolbarRequest.setMethodDesc("1");
	   	ipfCcmBoFormToolbarRequest.setSeqNo("1");
	   	ipfCcmBoFormToolbarRequest.setMethodId("1");
	   	ipfCcmBoFormToolbarRequest.setButtonStyle("1");
	   	ipfCcmBoFormToolbarRequest.setDisabledExpree("1");
	   	ipfCcmBoFormToolbarRequest.setIsRefreshParentBo("1");
	   	ipfCcmBoFormToolbarRequest.setHotkeyType("1");
	   	ipfCcmBoFormToolbarRequest.setHotkeyValue("1");
	   	ipfCcmBoFormToolbarRequest.setIsHide("1");
        CompositeResponse<IpfCcmBoFormToolbarUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormToolbarRequest, IpfCcmBoFormToolbarUpdateResponse.class, "ipfCcmBoFormToolbar.updateIpfCcmBoFormToolbar", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormToolbarUpdateResponse ipfCcmBoFormToolbarResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoFormToolbar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormToolbarGetRequest ipfCcmBoFormToolbarRequest = new IpfCcmBoFormToolbarGetRequest();
	   	ipfCcmBoFormToolbarRequest.setId("1");
        CompositeResponse<IpfCcmBoFormToolbarGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormToolbarRequest, IpfCcmBoFormToolbarGetResponse.class, "ipfCcmBoFormToolbar.getIpfCcmBoFormToolbar", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormToolbarGetResponse ipfCcmBoFormToolbarResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormToolbarSelectAllRequest ipfCcmBoFormToolbarRequest = new IpfCcmBoFormToolbarSelectAllRequest();

        CompositeResponse<IpfCcmBoFormToolbarSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormToolbarRequest, IpfCcmBoFormToolbarSelectAllResponse.class, "ipfCcmBoFormToolbar.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormToolbarSelectAllResponse ipfCcmBoFormToolbarResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormToolbarCountAllRequest ipfCcmBoFormToolbarRequest = new IpfCcmBoFormToolbarCountAllRequest();

        CompositeResponse<IpfCcmBoFormToolbarCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormToolbarRequest, IpfCcmBoFormToolbarCountAllResponse.class, "ipfCcmBoFormToolbar.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormToolbarCountAllResponse ipfCcmBoFormToolbarResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoFormToolbarResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoFormToolbar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormToolbarSelectRequest ipfCcmBoFormToolbarRequest = new IpfCcmBoFormToolbarSelectRequest();
	   	ipfCcmBoFormToolbarRequest.setId("1");
	   	ipfCcmBoFormToolbarRequest.setIpfCcbBoId("1");
	   	ipfCcmBoFormToolbarRequest.setMethodName("1");
	   	ipfCcmBoFormToolbarRequest.setMethodDesc("1");
	   	ipfCcmBoFormToolbarRequest.setSeqNo("1");
	   	ipfCcmBoFormToolbarRequest.setMethodId("1");
	   	ipfCcmBoFormToolbarRequest.setButtonStyle("1");
	   	ipfCcmBoFormToolbarRequest.setDisabledExpree("1");
	   	ipfCcmBoFormToolbarRequest.setIsRefreshParentBo("1");
	   	ipfCcmBoFormToolbarRequest.setHotkeyType("1");
	   	ipfCcmBoFormToolbarRequest.setHotkeyValue("1");
	   	ipfCcmBoFormToolbarRequest.setIsHide("1");
        CompositeResponse<IpfCcmBoFormToolbarCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormToolbarRequest, IpfCcmBoFormToolbarCreateResponse.class, "ipfCcmBoFormToolbar.createIpfCcmBoFormToolbar", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoFormToolbarRequest.setId("1");
	   	ipfCcmBoFormToolbarRequest.setIpfCcbBoId("1");
	   	ipfCcmBoFormToolbarRequest.setMethodName("1");
	   	ipfCcmBoFormToolbarRequest.setMethodDesc("1");
	   	ipfCcmBoFormToolbarRequest.setSeqNo("1");
	   	ipfCcmBoFormToolbarRequest.setMethodId("1");
	   	ipfCcmBoFormToolbarRequest.setButtonStyle("1");
	   	ipfCcmBoFormToolbarRequest.setDisabledExpree("1");
	   	ipfCcmBoFormToolbarRequest.setIsRefreshParentBo("1");
	   	ipfCcmBoFormToolbarRequest.setHotkeyType("1");
	   	ipfCcmBoFormToolbarRequest.setHotkeyValue("1");
	   	ipfCcmBoFormToolbarRequest.setIsHide("1");
        CompositeResponse<IpfCcmBoFormToolbarSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoFormToolbarRequest, IpfCcmBoFormToolbarSelectResponse.class, "ipfCcmBoFormToolbar.selectIpfCcmBoFormToolbar", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormToolbarSelectResponse ipfCcmBoFormToolbarResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoFormToolbarResponse.getResultJson());
        CompositeResponse<IpfCcmBoFormToolbarDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoFormToolbarRequest, IpfCcmBoFormToolbarDeleteResponse.class, "ipfCcmBoFormToolbar.deleteIpfCcmBoFormToolbar", "1.0");

    }
}
