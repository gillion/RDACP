/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciLabel;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfFciLabel.request.*;
import com.cartan.center.ebs.ipfFciLabel.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfFciLabelServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfFciLabelServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelGetSessionRequest ipfFciLabelRequest = new IpfFciLabelGetSessionRequest();
     	CompositeResponse<IpfFciLabelGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfFciLabelRequest, IpfFciLabelGetSessionResponse.class, "ipfFciLabel.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfFciLabel(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelCreateRequest ipfFciLabelRequest = new IpfFciLabelCreateRequest();
	   	ipfFciLabelRequest.setId("1");
	   	ipfFciLabelRequest.setIpfFciViewId("1");
	   	ipfFciLabelRequest.setLabelName("1");
	   	ipfFciLabelRequest.setLabelDesc("1");
	   	ipfFciLabelRequest.setIpfFciBuildId("1");
	   	ipfFciLabelRequest.setMajorVersion("1");
	   	ipfFciLabelRequest.setMinorVersion("1");
	   	ipfFciLabelRequest.setVersionBuildNumber("1");
	   	ipfFciLabelRequest.setRevisionNumber("1");
	   	ipfFciLabelRequest.setSvnRevision("1");
	   	ipfFciLabelRequest.setSvnTagsPath("1");
	   	ipfFciLabelRequest.setIsActive("1");
	   	ipfFciLabelRequest.setViewName("1");
        CompositeResponse<IpfFciLabelCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelRequest, IpfFciLabelCreateResponse.class, "ipfFciLabel.createIpfFciLabel", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelCreateResponse ipfFciLabelResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfFciLabel(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelDeleteRequest ipfFciLabelRequest = new IpfFciLabelDeleteRequest();
	   	ipfFciLabelRequest.setId("1");
        CompositeResponse<IpfFciLabelDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelRequest, IpfFciLabelDeleteResponse.class, "ipfFciLabel.deleteIpfFciLabel", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelDeleteResponse ipfFciLabelResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfFciLabel(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelUpdateRequest ipfFciLabelRequest = new IpfFciLabelUpdateRequest();
	   	ipfFciLabelRequest.setId("1");
	   	ipfFciLabelRequest.setIpfFciViewId("1");
	   	ipfFciLabelRequest.setLabelName("1");
	   	ipfFciLabelRequest.setLabelDesc("1");
	   	ipfFciLabelRequest.setIpfFciBuildId("1");
	   	ipfFciLabelRequest.setMajorVersion("1");
	   	ipfFciLabelRequest.setMinorVersion("1");
	   	ipfFciLabelRequest.setVersionBuildNumber("1");
	   	ipfFciLabelRequest.setRevisionNumber("1");
	   	ipfFciLabelRequest.setSvnRevision("1");
	   	ipfFciLabelRequest.setSvnTagsPath("1");
	   	ipfFciLabelRequest.setIsActive("1");
	   	ipfFciLabelRequest.setViewName("1");
        CompositeResponse<IpfFciLabelUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelRequest, IpfFciLabelUpdateResponse.class, "ipfFciLabel.updateIpfFciLabel", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelUpdateResponse ipfFciLabelResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfFciLabel(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelGetRequest ipfFciLabelRequest = new IpfFciLabelGetRequest();
	   	ipfFciLabelRequest.setId("1");
        CompositeResponse<IpfFciLabelGetResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelRequest, IpfFciLabelGetResponse.class, "ipfFciLabel.getIpfFciLabel", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelGetResponse ipfFciLabelResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelSelectAllRequest ipfFciLabelRequest = new IpfFciLabelSelectAllRequest();

        CompositeResponse<IpfFciLabelSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelRequest, IpfFciLabelSelectAllResponse.class, "ipfFciLabel.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelSelectAllResponse ipfFciLabelResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelCountAllRequest ipfFciLabelRequest = new IpfFciLabelCountAllRequest();

        CompositeResponse<IpfFciLabelCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelRequest, IpfFciLabelCountAllResponse.class, "ipfFciLabel.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelCountAllResponse ipfFciLabelResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfFciLabelResponse.getResultString());
    }

    @Test
    public void selectIpfFciLabel(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciLabelSelectRequest ipfFciLabelRequest = new IpfFciLabelSelectRequest();
	   	ipfFciLabelRequest.setId("1");
	   	ipfFciLabelRequest.setIpfFciViewId("1");
	   	ipfFciLabelRequest.setLabelName("1");
	   	ipfFciLabelRequest.setLabelDesc("1");
	   	ipfFciLabelRequest.setIpfFciBuildId("1");
	   	ipfFciLabelRequest.setMajorVersion("1");
	   	ipfFciLabelRequest.setMinorVersion("1");
	   	ipfFciLabelRequest.setVersionBuildNumber("1");
	   	ipfFciLabelRequest.setRevisionNumber("1");
	   	ipfFciLabelRequest.setSvnRevision("1");
	   	ipfFciLabelRequest.setSvnTagsPath("1");
	   	ipfFciLabelRequest.setIsActive("1");
	   	ipfFciLabelRequest.setViewName("1");
        CompositeResponse<IpfFciLabelCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciLabelRequest, IpfFciLabelCreateResponse.class, "ipfFciLabel.createIpfFciLabel", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfFciLabelRequest.setId("1");
	   	ipfFciLabelRequest.setIpfFciViewId("1");
	   	ipfFciLabelRequest.setLabelName("1");
	   	ipfFciLabelRequest.setLabelDesc("1");
	   	ipfFciLabelRequest.setIpfFciBuildId("1");
	   	ipfFciLabelRequest.setMajorVersion("1");
	   	ipfFciLabelRequest.setMinorVersion("1");
	   	ipfFciLabelRequest.setVersionBuildNumber("1");
	   	ipfFciLabelRequest.setRevisionNumber("1");
	   	ipfFciLabelRequest.setSvnRevision("1");
	   	ipfFciLabelRequest.setSvnTagsPath("1");
	   	ipfFciLabelRequest.setIsActive("1");
	   	ipfFciLabelRequest.setViewName("1");
        CompositeResponse<IpfFciLabelSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfFciLabelRequest, IpfFciLabelSelectResponse.class, "ipfFciLabel.selectIpfFciLabel", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciLabelSelectResponse ipfFciLabelResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfFciLabelResponse.getResultJson());
        CompositeResponse<IpfFciLabelDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfFciLabelRequest, IpfFciLabelDeleteResponse.class, "ipfFciLabel.deleteIpfFciLabel", "1.0");

    }
}
