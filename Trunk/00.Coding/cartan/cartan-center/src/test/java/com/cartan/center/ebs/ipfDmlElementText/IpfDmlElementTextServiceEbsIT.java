/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlElementText;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlElementText.request.*;
import com.cartan.center.ebs.ipfDmlElementText.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlElementTextServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlElementTextServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementTextGetSessionRequest ipfDmlElementTextRequest = new IpfDmlElementTextGetSessionRequest();
     	CompositeResponse<IpfDmlElementTextGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlElementTextRequest, IpfDmlElementTextGetSessionResponse.class, "ipfDmlElementText.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlElementText(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementTextCreateRequest ipfDmlElementTextRequest = new IpfDmlElementTextCreateRequest();
	   	ipfDmlElementTextRequest.setId("1");
	   	ipfDmlElementTextRequest.setIpfDmlElementId("1");
	   	ipfDmlElementTextRequest.setDdLanguage("1");
	   	ipfDmlElementTextRequest.setDdText("1");
        CompositeResponse<IpfDmlElementTextCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementTextRequest, IpfDmlElementTextCreateResponse.class, "ipfDmlElementText.createIpfDmlElementText", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementTextCreateResponse ipfDmlElementTextResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlElementText(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementTextDeleteRequest ipfDmlElementTextRequest = new IpfDmlElementTextDeleteRequest();
	   	ipfDmlElementTextRequest.setId("1");
        CompositeResponse<IpfDmlElementTextDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementTextRequest, IpfDmlElementTextDeleteResponse.class, "ipfDmlElementText.deleteIpfDmlElementText", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementTextDeleteResponse ipfDmlElementTextResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlElementText(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementTextUpdateRequest ipfDmlElementTextRequest = new IpfDmlElementTextUpdateRequest();
	   	ipfDmlElementTextRequest.setId("1");
	   	ipfDmlElementTextRequest.setIpfDmlElementId("1");
	   	ipfDmlElementTextRequest.setDdLanguage("1");
	   	ipfDmlElementTextRequest.setDdText("1");
        CompositeResponse<IpfDmlElementTextUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementTextRequest, IpfDmlElementTextUpdateResponse.class, "ipfDmlElementText.updateIpfDmlElementText", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementTextUpdateResponse ipfDmlElementTextResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlElementText(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementTextGetRequest ipfDmlElementTextRequest = new IpfDmlElementTextGetRequest();
	   	ipfDmlElementTextRequest.setId("1");
        CompositeResponse<IpfDmlElementTextGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementTextRequest, IpfDmlElementTextGetResponse.class, "ipfDmlElementText.getIpfDmlElementText", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementTextGetResponse ipfDmlElementTextResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementTextSelectAllRequest ipfDmlElementTextRequest = new IpfDmlElementTextSelectAllRequest();

        CompositeResponse<IpfDmlElementTextSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementTextRequest, IpfDmlElementTextSelectAllResponse.class, "ipfDmlElementText.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementTextSelectAllResponse ipfDmlElementTextResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementTextCountAllRequest ipfDmlElementTextRequest = new IpfDmlElementTextCountAllRequest();

        CompositeResponse<IpfDmlElementTextCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementTextRequest, IpfDmlElementTextCountAllResponse.class, "ipfDmlElementText.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementTextCountAllResponse ipfDmlElementTextResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlElementTextResponse.getResultString());
    }

    @Test
    public void selectIpfDmlElementText(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementTextSelectRequest ipfDmlElementTextRequest = new IpfDmlElementTextSelectRequest();
	   	ipfDmlElementTextRequest.setId("1");
	   	ipfDmlElementTextRequest.setIpfDmlElementId("1");
	   	ipfDmlElementTextRequest.setDdLanguage("1");
	   	ipfDmlElementTextRequest.setDdText("1");
        CompositeResponse<IpfDmlElementTextCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementTextRequest, IpfDmlElementTextCreateResponse.class, "ipfDmlElementText.createIpfDmlElementText", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlElementTextRequest.setId("1");
	   	ipfDmlElementTextRequest.setIpfDmlElementId("1");
	   	ipfDmlElementTextRequest.setDdLanguage("1");
	   	ipfDmlElementTextRequest.setDdText("1");
        CompositeResponse<IpfDmlElementTextSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlElementTextRequest, IpfDmlElementTextSelectResponse.class, "ipfDmlElementText.selectIpfDmlElementText", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementTextSelectResponse ipfDmlElementTextResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlElementTextResponse.getResultJson());
        CompositeResponse<IpfDmlElementTextDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlElementTextRequest, IpfDmlElementTextDeleteResponse.class, "ipfDmlElementText.deleteIpfDmlElementText", "1.0");

    }
}
