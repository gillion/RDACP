/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmShlpText;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmShlpText.request.*;
import com.cartan.center.ebs.ipfCcmShlpText.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmShlpTextServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmShlpTextServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpTextGetSessionRequest ipfCcmShlpTextRequest = new IpfCcmShlpTextGetSessionRequest();
     	CompositeResponse<IpfCcmShlpTextGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmShlpTextRequest, IpfCcmShlpTextGetSessionResponse.class, "ipfCcmShlpText.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmShlpText(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpTextCreateRequest ipfCcmShlpTextRequest = new IpfCcmShlpTextCreateRequest();
	   	ipfCcmShlpTextRequest.setId("1");
	   	ipfCcmShlpTextRequest.setIpfCcmShlpId("1");
	   	ipfCcmShlpTextRequest.setDdLanguage("1");
	   	ipfCcmShlpTextRequest.setDdText("1");
        CompositeResponse<IpfCcmShlpTextCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpTextRequest, IpfCcmShlpTextCreateResponse.class, "ipfCcmShlpText.createIpfCcmShlpText", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpTextCreateResponse ipfCcmShlpTextResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmShlpText(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpTextDeleteRequest ipfCcmShlpTextRequest = new IpfCcmShlpTextDeleteRequest();
	   	ipfCcmShlpTextRequest.setId("1");
        CompositeResponse<IpfCcmShlpTextDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpTextRequest, IpfCcmShlpTextDeleteResponse.class, "ipfCcmShlpText.deleteIpfCcmShlpText", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpTextDeleteResponse ipfCcmShlpTextResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmShlpText(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpTextUpdateRequest ipfCcmShlpTextRequest = new IpfCcmShlpTextUpdateRequest();
	   	ipfCcmShlpTextRequest.setId("1");
	   	ipfCcmShlpTextRequest.setIpfCcmShlpId("1");
	   	ipfCcmShlpTextRequest.setDdLanguage("1");
	   	ipfCcmShlpTextRequest.setDdText("1");
        CompositeResponse<IpfCcmShlpTextUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpTextRequest, IpfCcmShlpTextUpdateResponse.class, "ipfCcmShlpText.updateIpfCcmShlpText", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpTextUpdateResponse ipfCcmShlpTextResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmShlpText(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpTextGetRequest ipfCcmShlpTextRequest = new IpfCcmShlpTextGetRequest();
	   	ipfCcmShlpTextRequest.setId("1");
        CompositeResponse<IpfCcmShlpTextGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpTextRequest, IpfCcmShlpTextGetResponse.class, "ipfCcmShlpText.getIpfCcmShlpText", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpTextGetResponse ipfCcmShlpTextResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpTextSelectAllRequest ipfCcmShlpTextRequest = new IpfCcmShlpTextSelectAllRequest();

        CompositeResponse<IpfCcmShlpTextSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpTextRequest, IpfCcmShlpTextSelectAllResponse.class, "ipfCcmShlpText.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpTextSelectAllResponse ipfCcmShlpTextResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpTextCountAllRequest ipfCcmShlpTextRequest = new IpfCcmShlpTextCountAllRequest();

        CompositeResponse<IpfCcmShlpTextCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpTextRequest, IpfCcmShlpTextCountAllResponse.class, "ipfCcmShlpText.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpTextCountAllResponse ipfCcmShlpTextResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmShlpTextResponse.getResultString());
    }

    @Test
    public void selectIpfCcmShlpText(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpTextSelectRequest ipfCcmShlpTextRequest = new IpfCcmShlpTextSelectRequest();
	   	ipfCcmShlpTextRequest.setId("1");
	   	ipfCcmShlpTextRequest.setIpfCcmShlpId("1");
	   	ipfCcmShlpTextRequest.setDdLanguage("1");
	   	ipfCcmShlpTextRequest.setDdText("1");
        CompositeResponse<IpfCcmShlpTextCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpTextRequest, IpfCcmShlpTextCreateResponse.class, "ipfCcmShlpText.createIpfCcmShlpText", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmShlpTextRequest.setId("1");
	   	ipfCcmShlpTextRequest.setIpfCcmShlpId("1");
	   	ipfCcmShlpTextRequest.setDdLanguage("1");
	   	ipfCcmShlpTextRequest.setDdText("1");
        CompositeResponse<IpfCcmShlpTextSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmShlpTextRequest, IpfCcmShlpTextSelectResponse.class, "ipfCcmShlpText.selectIpfCcmShlpText", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpTextSelectResponse ipfCcmShlpTextResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmShlpTextResponse.getResultJson());
        CompositeResponse<IpfCcmShlpTextDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmShlpTextRequest, IpfCcmShlpTextDeleteResponse.class, "ipfCcmShlpText.deleteIpfCcmShlpText", "1.0");

    }
}
