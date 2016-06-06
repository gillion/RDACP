/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciView;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfFciView.request.*;
import com.cartan.center.ebs.ipfFciView.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfFciViewServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfFciViewServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewGetSessionRequest ipfFciViewRequest = new IpfFciViewGetSessionRequest();
     	CompositeResponse<IpfFciViewGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfFciViewRequest, IpfFciViewGetSessionResponse.class, "ipfFciView.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfFciView(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewCreateRequest ipfFciViewRequest = new IpfFciViewCreateRequest();
	   	ipfFciViewRequest.setId("1");
	   	ipfFciViewRequest.setViewName("1");
	   	ipfFciViewRequest.setProjectName("1");
	   	ipfFciViewRequest.setViewDesc("1");
	   	ipfFciViewRequest.setSvnBranchesPath("1");
	   	ipfFciViewRequest.setIsActive("1");
	   	ipfFciViewRequest.setConnectionString("1");
	   	ipfFciViewRequest.setIpfFciProjectId("1");
	   	ipfFciViewRequest.setSourceLabelId("1");
	   	ipfFciViewRequest.setIsPermissionPageOnly("1");
        CompositeResponse<IpfFciViewCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewRequest, IpfFciViewCreateResponse.class, "ipfFciView.createIpfFciView", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewCreateResponse ipfFciViewResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfFciView(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewDeleteRequest ipfFciViewRequest = new IpfFciViewDeleteRequest();
	   	ipfFciViewRequest.setId("1");
        CompositeResponse<IpfFciViewDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewRequest, IpfFciViewDeleteResponse.class, "ipfFciView.deleteIpfFciView", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewDeleteResponse ipfFciViewResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfFciView(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewUpdateRequest ipfFciViewRequest = new IpfFciViewUpdateRequest();
	   	ipfFciViewRequest.setId("1");
	   	ipfFciViewRequest.setViewName("1");
	   	ipfFciViewRequest.setProjectName("1");
	   	ipfFciViewRequest.setViewDesc("1");
	   	ipfFciViewRequest.setSvnBranchesPath("1");
	   	ipfFciViewRequest.setIsActive("1");
	   	ipfFciViewRequest.setConnectionString("1");
	   	ipfFciViewRequest.setIpfFciProjectId("1");
	   	ipfFciViewRequest.setSourceLabelId("1");
	   	ipfFciViewRequest.setIsPermissionPageOnly("1");
        CompositeResponse<IpfFciViewUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewRequest, IpfFciViewUpdateResponse.class, "ipfFciView.updateIpfFciView", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewUpdateResponse ipfFciViewResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfFciView(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewGetRequest ipfFciViewRequest = new IpfFciViewGetRequest();
	   	ipfFciViewRequest.setId("1");
        CompositeResponse<IpfFciViewGetResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewRequest, IpfFciViewGetResponse.class, "ipfFciView.getIpfFciView", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewGetResponse ipfFciViewResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewSelectAllRequest ipfFciViewRequest = new IpfFciViewSelectAllRequest();

        CompositeResponse<IpfFciViewSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewRequest, IpfFciViewSelectAllResponse.class, "ipfFciView.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewSelectAllResponse ipfFciViewResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewCountAllRequest ipfFciViewRequest = new IpfFciViewCountAllRequest();

        CompositeResponse<IpfFciViewCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewRequest, IpfFciViewCountAllResponse.class, "ipfFciView.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewCountAllResponse ipfFciViewResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfFciViewResponse.getResultString());
    }

    @Test
    public void selectIpfFciView(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewSelectRequest ipfFciViewRequest = new IpfFciViewSelectRequest();
	   	ipfFciViewRequest.setId("1");
	   	ipfFciViewRequest.setViewName("1");
	   	ipfFciViewRequest.setProjectName("1");
	   	ipfFciViewRequest.setViewDesc("1");
	   	ipfFciViewRequest.setSvnBranchesPath("1");
	   	ipfFciViewRequest.setIsActive("1");
	   	ipfFciViewRequest.setConnectionString("1");
	   	ipfFciViewRequest.setIpfFciProjectId("1");
	   	ipfFciViewRequest.setSourceLabelId("1");
	   	ipfFciViewRequest.setIsPermissionPageOnly("1");
        CompositeResponse<IpfFciViewCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewRequest, IpfFciViewCreateResponse.class, "ipfFciView.createIpfFciView", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfFciViewRequest.setId("1");
	   	ipfFciViewRequest.setViewName("1");
	   	ipfFciViewRequest.setProjectName("1");
	   	ipfFciViewRequest.setViewDesc("1");
	   	ipfFciViewRequest.setSvnBranchesPath("1");
	   	ipfFciViewRequest.setIsActive("1");
	   	ipfFciViewRequest.setConnectionString("1");
	   	ipfFciViewRequest.setIpfFciProjectId("1");
	   	ipfFciViewRequest.setSourceLabelId("1");
	   	ipfFciViewRequest.setIsPermissionPageOnly("1");
        CompositeResponse<IpfFciViewSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfFciViewRequest, IpfFciViewSelectResponse.class, "ipfFciView.selectIpfFciView", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewSelectResponse ipfFciViewResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfFciViewResponse.getResultJson());
        CompositeResponse<IpfFciViewDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfFciViewRequest, IpfFciViewDeleteResponse.class, "ipfFciView.deleteIpfFciView", "1.0");

    }
}
