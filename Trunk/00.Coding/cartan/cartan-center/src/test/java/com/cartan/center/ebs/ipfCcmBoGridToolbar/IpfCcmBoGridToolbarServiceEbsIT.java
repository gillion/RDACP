/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoGridToolbar;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoGridToolbar.request.*;
import com.cartan.center.ebs.ipfCcmBoGridToolbar.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoGridToolbarServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoGridToolbarServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridToolbarGetSessionRequest ipfCcmBoGridToolbarRequest = new IpfCcmBoGridToolbarGetSessionRequest();
     	CompositeResponse<IpfCcmBoGridToolbarGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoGridToolbarRequest, IpfCcmBoGridToolbarGetSessionResponse.class, "ipfCcmBoGridToolbar.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoGridToolbar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridToolbarCreateRequest ipfCcmBoGridToolbarRequest = new IpfCcmBoGridToolbarCreateRequest();
	   	ipfCcmBoGridToolbarRequest.setId("1");
	   	ipfCcmBoGridToolbarRequest.setIpfCcbBoId("1");
	   	ipfCcmBoGridToolbarRequest.setMethodName("1");
	   	ipfCcmBoGridToolbarRequest.setMethodDesc("1");
	   	ipfCcmBoGridToolbarRequest.setSeqNo("1");
	   	ipfCcmBoGridToolbarRequest.setMethodId("1");
	   	ipfCcmBoGridToolbarRequest.setButtonStyle("1");
	   	ipfCcmBoGridToolbarRequest.setDisabledExpree("1");
	   	ipfCcmBoGridToolbarRequest.setIsRefreshParentBo("1");
	   	ipfCcmBoGridToolbarRequest.setHotkeyType("1");
	   	ipfCcmBoGridToolbarRequest.setHotkeyValue("1");
	   	ipfCcmBoGridToolbarRequest.setIsHide("1");
        CompositeResponse<IpfCcmBoGridToolbarCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridToolbarRequest, IpfCcmBoGridToolbarCreateResponse.class, "ipfCcmBoGridToolbar.createIpfCcmBoGridToolbar", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridToolbarCreateResponse ipfCcmBoGridToolbarResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoGridToolbar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridToolbarDeleteRequest ipfCcmBoGridToolbarRequest = new IpfCcmBoGridToolbarDeleteRequest();
	   	ipfCcmBoGridToolbarRequest.setId("1");
        CompositeResponse<IpfCcmBoGridToolbarDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridToolbarRequest, IpfCcmBoGridToolbarDeleteResponse.class, "ipfCcmBoGridToolbar.deleteIpfCcmBoGridToolbar", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridToolbarDeleteResponse ipfCcmBoGridToolbarResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoGridToolbar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridToolbarUpdateRequest ipfCcmBoGridToolbarRequest = new IpfCcmBoGridToolbarUpdateRequest();
	   	ipfCcmBoGridToolbarRequest.setId("1");
	   	ipfCcmBoGridToolbarRequest.setIpfCcbBoId("1");
	   	ipfCcmBoGridToolbarRequest.setMethodName("1");
	   	ipfCcmBoGridToolbarRequest.setMethodDesc("1");
	   	ipfCcmBoGridToolbarRequest.setSeqNo("1");
	   	ipfCcmBoGridToolbarRequest.setMethodId("1");
	   	ipfCcmBoGridToolbarRequest.setButtonStyle("1");
	   	ipfCcmBoGridToolbarRequest.setDisabledExpree("1");
	   	ipfCcmBoGridToolbarRequest.setIsRefreshParentBo("1");
	   	ipfCcmBoGridToolbarRequest.setHotkeyType("1");
	   	ipfCcmBoGridToolbarRequest.setHotkeyValue("1");
	   	ipfCcmBoGridToolbarRequest.setIsHide("1");
        CompositeResponse<IpfCcmBoGridToolbarUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridToolbarRequest, IpfCcmBoGridToolbarUpdateResponse.class, "ipfCcmBoGridToolbar.updateIpfCcmBoGridToolbar", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridToolbarUpdateResponse ipfCcmBoGridToolbarResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoGridToolbar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridToolbarGetRequest ipfCcmBoGridToolbarRequest = new IpfCcmBoGridToolbarGetRequest();
	   	ipfCcmBoGridToolbarRequest.setId("1");
        CompositeResponse<IpfCcmBoGridToolbarGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridToolbarRequest, IpfCcmBoGridToolbarGetResponse.class, "ipfCcmBoGridToolbar.getIpfCcmBoGridToolbar", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridToolbarGetResponse ipfCcmBoGridToolbarResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridToolbarSelectAllRequest ipfCcmBoGridToolbarRequest = new IpfCcmBoGridToolbarSelectAllRequest();

        CompositeResponse<IpfCcmBoGridToolbarSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridToolbarRequest, IpfCcmBoGridToolbarSelectAllResponse.class, "ipfCcmBoGridToolbar.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridToolbarSelectAllResponse ipfCcmBoGridToolbarResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridToolbarCountAllRequest ipfCcmBoGridToolbarRequest = new IpfCcmBoGridToolbarCountAllRequest();

        CompositeResponse<IpfCcmBoGridToolbarCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridToolbarRequest, IpfCcmBoGridToolbarCountAllResponse.class, "ipfCcmBoGridToolbar.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridToolbarCountAllResponse ipfCcmBoGridToolbarResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoGridToolbarResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoGridToolbar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridToolbarSelectRequest ipfCcmBoGridToolbarRequest = new IpfCcmBoGridToolbarSelectRequest();
	   	ipfCcmBoGridToolbarRequest.setId("1");
	   	ipfCcmBoGridToolbarRequest.setIpfCcbBoId("1");
	   	ipfCcmBoGridToolbarRequest.setMethodName("1");
	   	ipfCcmBoGridToolbarRequest.setMethodDesc("1");
	   	ipfCcmBoGridToolbarRequest.setSeqNo("1");
	   	ipfCcmBoGridToolbarRequest.setMethodId("1");
	   	ipfCcmBoGridToolbarRequest.setButtonStyle("1");
	   	ipfCcmBoGridToolbarRequest.setDisabledExpree("1");
	   	ipfCcmBoGridToolbarRequest.setIsRefreshParentBo("1");
	   	ipfCcmBoGridToolbarRequest.setHotkeyType("1");
	   	ipfCcmBoGridToolbarRequest.setHotkeyValue("1");
	   	ipfCcmBoGridToolbarRequest.setIsHide("1");
        CompositeResponse<IpfCcmBoGridToolbarCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridToolbarRequest, IpfCcmBoGridToolbarCreateResponse.class, "ipfCcmBoGridToolbar.createIpfCcmBoGridToolbar", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoGridToolbarRequest.setId("1");
	   	ipfCcmBoGridToolbarRequest.setIpfCcbBoId("1");
	   	ipfCcmBoGridToolbarRequest.setMethodName("1");
	   	ipfCcmBoGridToolbarRequest.setMethodDesc("1");
	   	ipfCcmBoGridToolbarRequest.setSeqNo("1");
	   	ipfCcmBoGridToolbarRequest.setMethodId("1");
	   	ipfCcmBoGridToolbarRequest.setButtonStyle("1");
	   	ipfCcmBoGridToolbarRequest.setDisabledExpree("1");
	   	ipfCcmBoGridToolbarRequest.setIsRefreshParentBo("1");
	   	ipfCcmBoGridToolbarRequest.setHotkeyType("1");
	   	ipfCcmBoGridToolbarRequest.setHotkeyValue("1");
	   	ipfCcmBoGridToolbarRequest.setIsHide("1");
        CompositeResponse<IpfCcmBoGridToolbarSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoGridToolbarRequest, IpfCcmBoGridToolbarSelectResponse.class, "ipfCcmBoGridToolbar.selectIpfCcmBoGridToolbar", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridToolbarSelectResponse ipfCcmBoGridToolbarResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoGridToolbarResponse.getResultJson());
        CompositeResponse<IpfCcmBoGridToolbarDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoGridToolbarRequest, IpfCcmBoGridToolbarDeleteResponse.class, "ipfCcmBoGridToolbar.deleteIpfCcmBoGridToolbar", "1.0");

    }
}
