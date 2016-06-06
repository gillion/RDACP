/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciRevision;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfFciRevision.request.*;
import com.cartan.center.ebs.ipfFciRevision.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfFciRevisionServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfFciRevisionServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciRevisionGetSessionRequest ipfFciRevisionRequest = new IpfFciRevisionGetSessionRequest();
     	CompositeResponse<IpfFciRevisionGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfFciRevisionRequest, IpfFciRevisionGetSessionResponse.class, "ipfFciRevision.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfFciRevision(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciRevisionCreateRequest ipfFciRevisionRequest = new IpfFciRevisionCreateRequest();
	   	ipfFciRevisionRequest.setId("1");
	   	ipfFciRevisionRequest.setIpfFciViewId("1");
	   	ipfFciRevisionRequest.setIpfFciProjectId("1");
	   	ipfFciRevisionRequest.setRevisionNumber("1");
	   	ipfFciRevisionRequest.setRemark("1");
        CompositeResponse<IpfFciRevisionCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciRevisionRequest, IpfFciRevisionCreateResponse.class, "ipfFciRevision.createIpfFciRevision", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciRevisionCreateResponse ipfFciRevisionResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfFciRevision(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciRevisionDeleteRequest ipfFciRevisionRequest = new IpfFciRevisionDeleteRequest();
	   	ipfFciRevisionRequest.setId("1");
        CompositeResponse<IpfFciRevisionDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfFciRevisionRequest, IpfFciRevisionDeleteResponse.class, "ipfFciRevision.deleteIpfFciRevision", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciRevisionDeleteResponse ipfFciRevisionResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfFciRevision(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciRevisionUpdateRequest ipfFciRevisionRequest = new IpfFciRevisionUpdateRequest();
	   	ipfFciRevisionRequest.setId("1");
	   	ipfFciRevisionRequest.setIpfFciViewId("1");
	   	ipfFciRevisionRequest.setIpfFciProjectId("1");
	   	ipfFciRevisionRequest.setRevisionNumber("1");
	   	ipfFciRevisionRequest.setRemark("1");
        CompositeResponse<IpfFciRevisionUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfFciRevisionRequest, IpfFciRevisionUpdateResponse.class, "ipfFciRevision.updateIpfFciRevision", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciRevisionUpdateResponse ipfFciRevisionResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfFciRevision(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciRevisionGetRequest ipfFciRevisionRequest = new IpfFciRevisionGetRequest();
	   	ipfFciRevisionRequest.setId("1");
        CompositeResponse<IpfFciRevisionGetResponse> response =
                ropClient.buildClientRequest().get(ipfFciRevisionRequest, IpfFciRevisionGetResponse.class, "ipfFciRevision.getIpfFciRevision", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciRevisionGetResponse ipfFciRevisionResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciRevisionSelectAllRequest ipfFciRevisionRequest = new IpfFciRevisionSelectAllRequest();

        CompositeResponse<IpfFciRevisionSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciRevisionRequest, IpfFciRevisionSelectAllResponse.class, "ipfFciRevision.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciRevisionSelectAllResponse ipfFciRevisionResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciRevisionCountAllRequest ipfFciRevisionRequest = new IpfFciRevisionCountAllRequest();

        CompositeResponse<IpfFciRevisionCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciRevisionRequest, IpfFciRevisionCountAllResponse.class, "ipfFciRevision.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciRevisionCountAllResponse ipfFciRevisionResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfFciRevisionResponse.getResultString());
    }

    @Test
    public void selectIpfFciRevision(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciRevisionSelectRequest ipfFciRevisionRequest = new IpfFciRevisionSelectRequest();
	   	ipfFciRevisionRequest.setId("1");
	   	ipfFciRevisionRequest.setIpfFciViewId("1");
	   	ipfFciRevisionRequest.setIpfFciProjectId("1");
	   	ipfFciRevisionRequest.setRevisionNumber("1");
	   	ipfFciRevisionRequest.setRemark("1");
        CompositeResponse<IpfFciRevisionCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciRevisionRequest, IpfFciRevisionCreateResponse.class, "ipfFciRevision.createIpfFciRevision", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfFciRevisionRequest.setId("1");
	   	ipfFciRevisionRequest.setIpfFciViewId("1");
	   	ipfFciRevisionRequest.setIpfFciProjectId("1");
	   	ipfFciRevisionRequest.setRevisionNumber("1");
	   	ipfFciRevisionRequest.setRemark("1");
        CompositeResponse<IpfFciRevisionSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfFciRevisionRequest, IpfFciRevisionSelectResponse.class, "ipfFciRevision.selectIpfFciRevision", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciRevisionSelectResponse ipfFciRevisionResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfFciRevisionResponse.getResultJson());
        CompositeResponse<IpfFciRevisionDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfFciRevisionRequest, IpfFciRevisionDeleteResponse.class, "ipfFciRevision.deleteIpfFciRevision", "1.0");

    }
}
