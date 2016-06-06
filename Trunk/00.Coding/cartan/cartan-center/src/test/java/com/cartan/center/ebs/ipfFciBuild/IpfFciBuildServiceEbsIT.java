/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciBuild;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfFciBuild.request.*;
import com.cartan.center.ebs.ipfFciBuild.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfFciBuildServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfFciBuildServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciBuildGetSessionRequest ipfFciBuildRequest = new IpfFciBuildGetSessionRequest();
     	CompositeResponse<IpfFciBuildGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfFciBuildRequest, IpfFciBuildGetSessionResponse.class, "ipfFciBuild.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfFciBuild(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciBuildCreateRequest ipfFciBuildRequest = new IpfFciBuildCreateRequest();
	   	ipfFciBuildRequest.setId("1");
	   	ipfFciBuildRequest.setIpfFciViewId("1");
	   	ipfFciBuildRequest.setIpfFciProjectId("1");
	   	ipfFciBuildRequest.setMajorVersion("1");
	   	ipfFciBuildRequest.setMinorVersion("1");
	   	ipfFciBuildRequest.setMaxVersionBuildNumber("1");
	   	ipfFciBuildRequest.setIsDefault("1");
        CompositeResponse<IpfFciBuildCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciBuildRequest, IpfFciBuildCreateResponse.class, "ipfFciBuild.createIpfFciBuild", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciBuildCreateResponse ipfFciBuildResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfFciBuild(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciBuildDeleteRequest ipfFciBuildRequest = new IpfFciBuildDeleteRequest();
	   	ipfFciBuildRequest.setId("1");
        CompositeResponse<IpfFciBuildDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfFciBuildRequest, IpfFciBuildDeleteResponse.class, "ipfFciBuild.deleteIpfFciBuild", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciBuildDeleteResponse ipfFciBuildResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfFciBuild(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciBuildUpdateRequest ipfFciBuildRequest = new IpfFciBuildUpdateRequest();
	   	ipfFciBuildRequest.setId("1");
	   	ipfFciBuildRequest.setIpfFciViewId("1");
	   	ipfFciBuildRequest.setIpfFciProjectId("1");
	   	ipfFciBuildRequest.setMajorVersion("1");
	   	ipfFciBuildRequest.setMinorVersion("1");
	   	ipfFciBuildRequest.setMaxVersionBuildNumber("1");
	   	ipfFciBuildRequest.setIsDefault("1");
        CompositeResponse<IpfFciBuildUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfFciBuildRequest, IpfFciBuildUpdateResponse.class, "ipfFciBuild.updateIpfFciBuild", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciBuildUpdateResponse ipfFciBuildResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfFciBuild(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciBuildGetRequest ipfFciBuildRequest = new IpfFciBuildGetRequest();
	   	ipfFciBuildRequest.setId("1");
        CompositeResponse<IpfFciBuildGetResponse> response =
                ropClient.buildClientRequest().get(ipfFciBuildRequest, IpfFciBuildGetResponse.class, "ipfFciBuild.getIpfFciBuild", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciBuildGetResponse ipfFciBuildResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciBuildSelectAllRequest ipfFciBuildRequest = new IpfFciBuildSelectAllRequest();

        CompositeResponse<IpfFciBuildSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciBuildRequest, IpfFciBuildSelectAllResponse.class, "ipfFciBuild.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciBuildSelectAllResponse ipfFciBuildResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciBuildCountAllRequest ipfFciBuildRequest = new IpfFciBuildCountAllRequest();

        CompositeResponse<IpfFciBuildCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciBuildRequest, IpfFciBuildCountAllResponse.class, "ipfFciBuild.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciBuildCountAllResponse ipfFciBuildResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfFciBuildResponse.getResultString());
    }

    @Test
    public void selectIpfFciBuild(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciBuildSelectRequest ipfFciBuildRequest = new IpfFciBuildSelectRequest();
	   	ipfFciBuildRequest.setId("1");
	   	ipfFciBuildRequest.setIpfFciViewId("1");
	   	ipfFciBuildRequest.setIpfFciProjectId("1");
	   	ipfFciBuildRequest.setMajorVersion("1");
	   	ipfFciBuildRequest.setMinorVersion("1");
	   	ipfFciBuildRequest.setMaxVersionBuildNumber("1");
	   	ipfFciBuildRequest.setIsDefault("1");
        CompositeResponse<IpfFciBuildCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciBuildRequest, IpfFciBuildCreateResponse.class, "ipfFciBuild.createIpfFciBuild", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfFciBuildRequest.setId("1");
	   	ipfFciBuildRequest.setIpfFciViewId("1");
	   	ipfFciBuildRequest.setIpfFciProjectId("1");
	   	ipfFciBuildRequest.setMajorVersion("1");
	   	ipfFciBuildRequest.setMinorVersion("1");
	   	ipfFciBuildRequest.setMaxVersionBuildNumber("1");
	   	ipfFciBuildRequest.setIsDefault("1");
        CompositeResponse<IpfFciBuildSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfFciBuildRequest, IpfFciBuildSelectResponse.class, "ipfFciBuild.selectIpfFciBuild", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciBuildSelectResponse ipfFciBuildResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfFciBuildResponse.getResultJson());
        CompositeResponse<IpfFciBuildDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfFciBuildRequest, IpfFciBuildDeleteResponse.class, "ipfFciBuild.deleteIpfFciBuild", "1.0");

    }
}
