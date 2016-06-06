/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlScriptPublish;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlScriptPublish.request.*;
import com.cartan.center.ebs.ipfDmlScriptPublish.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlScriptPublishServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlScriptPublishServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlScriptPublishGetSessionRequest ipfDmlScriptPublishRequest = new IpfDmlScriptPublishGetSessionRequest();
     	CompositeResponse<IpfDmlScriptPublishGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlScriptPublishRequest, IpfDmlScriptPublishGetSessionResponse.class, "ipfDmlScriptPublish.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlScriptPublish(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlScriptPublishCreateRequest ipfDmlScriptPublishRequest = new IpfDmlScriptPublishCreateRequest();
	   	ipfDmlScriptPublishRequest.setId("1");
	   	ipfDmlScriptPublishRequest.setFileName("1");
	   	ipfDmlScriptPublishRequest.setFileDes("1");
	   	ipfDmlScriptPublishRequest.setFileContent("1");
	   	ipfDmlScriptPublishRequest.setIsPublished("1");
        CompositeResponse<IpfDmlScriptPublishCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlScriptPublishRequest, IpfDmlScriptPublishCreateResponse.class, "ipfDmlScriptPublish.createIpfDmlScriptPublish", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlScriptPublishCreateResponse ipfDmlScriptPublishResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlScriptPublish(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlScriptPublishDeleteRequest ipfDmlScriptPublishRequest = new IpfDmlScriptPublishDeleteRequest();
	   	ipfDmlScriptPublishRequest.setId("1");
        CompositeResponse<IpfDmlScriptPublishDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlScriptPublishRequest, IpfDmlScriptPublishDeleteResponse.class, "ipfDmlScriptPublish.deleteIpfDmlScriptPublish", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlScriptPublishDeleteResponse ipfDmlScriptPublishResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlScriptPublish(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlScriptPublishUpdateRequest ipfDmlScriptPublishRequest = new IpfDmlScriptPublishUpdateRequest();
	   	ipfDmlScriptPublishRequest.setId("1");
	   	ipfDmlScriptPublishRequest.setFileName("1");
	   	ipfDmlScriptPublishRequest.setFileDes("1");
	   	ipfDmlScriptPublishRequest.setFileContent("1");
	   	ipfDmlScriptPublishRequest.setIsPublished("1");
        CompositeResponse<IpfDmlScriptPublishUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlScriptPublishRequest, IpfDmlScriptPublishUpdateResponse.class, "ipfDmlScriptPublish.updateIpfDmlScriptPublish", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlScriptPublishUpdateResponse ipfDmlScriptPublishResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlScriptPublish(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlScriptPublishGetRequest ipfDmlScriptPublishRequest = new IpfDmlScriptPublishGetRequest();
	   	ipfDmlScriptPublishRequest.setId("1");
        CompositeResponse<IpfDmlScriptPublishGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlScriptPublishRequest, IpfDmlScriptPublishGetResponse.class, "ipfDmlScriptPublish.getIpfDmlScriptPublish", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlScriptPublishGetResponse ipfDmlScriptPublishResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlScriptPublishSelectAllRequest ipfDmlScriptPublishRequest = new IpfDmlScriptPublishSelectAllRequest();

        CompositeResponse<IpfDmlScriptPublishSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlScriptPublishRequest, IpfDmlScriptPublishSelectAllResponse.class, "ipfDmlScriptPublish.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlScriptPublishSelectAllResponse ipfDmlScriptPublishResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlScriptPublishCountAllRequest ipfDmlScriptPublishRequest = new IpfDmlScriptPublishCountAllRequest();

        CompositeResponse<IpfDmlScriptPublishCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlScriptPublishRequest, IpfDmlScriptPublishCountAllResponse.class, "ipfDmlScriptPublish.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlScriptPublishCountAllResponse ipfDmlScriptPublishResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlScriptPublishResponse.getResultString());
    }

    @Test
    public void selectIpfDmlScriptPublish(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlScriptPublishSelectRequest ipfDmlScriptPublishRequest = new IpfDmlScriptPublishSelectRequest();
	   	ipfDmlScriptPublishRequest.setId("1");
	   	ipfDmlScriptPublishRequest.setFileName("1");
	   	ipfDmlScriptPublishRequest.setFileDes("1");
	   	ipfDmlScriptPublishRequest.setFileContent("1");
	   	ipfDmlScriptPublishRequest.setIsPublished("1");
        CompositeResponse<IpfDmlScriptPublishCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlScriptPublishRequest, IpfDmlScriptPublishCreateResponse.class, "ipfDmlScriptPublish.createIpfDmlScriptPublish", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlScriptPublishRequest.setId("1");
	   	ipfDmlScriptPublishRequest.setFileName("1");
	   	ipfDmlScriptPublishRequest.setFileDes("1");
	   	ipfDmlScriptPublishRequest.setFileContent("1");
	   	ipfDmlScriptPublishRequest.setIsPublished("1");
        CompositeResponse<IpfDmlScriptPublishSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlScriptPublishRequest, IpfDmlScriptPublishSelectResponse.class, "ipfDmlScriptPublish.selectIpfDmlScriptPublish", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlScriptPublishSelectResponse ipfDmlScriptPublishResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlScriptPublishResponse.getResultJson());
        CompositeResponse<IpfDmlScriptPublishDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlScriptPublishRequest, IpfDmlScriptPublishDeleteResponse.class, "ipfDmlScriptPublish.deleteIpfDmlScriptPublish", "1.0");

    }
}
