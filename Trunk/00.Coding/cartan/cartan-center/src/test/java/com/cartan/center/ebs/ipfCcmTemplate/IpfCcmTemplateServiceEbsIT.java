/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmTemplate;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmTemplate.request.*;
import com.cartan.center.ebs.ipfCcmTemplate.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmTemplateServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmTemplateServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmTemplateGetSessionRequest ipfCcmTemplateRequest = new IpfCcmTemplateGetSessionRequest();
     	CompositeResponse<IpfCcmTemplateGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmTemplateRequest, IpfCcmTemplateGetSessionResponse.class, "ipfCcmTemplate.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmTemplate(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmTemplateCreateRequest ipfCcmTemplateRequest = new IpfCcmTemplateCreateRequest();
	   	ipfCcmTemplateRequest.setId("1");
	   	ipfCcmTemplateRequest.setTemplateFile("1");
	   	ipfCcmTemplateRequest.setTemplateDesc("1");
	   	ipfCcmTemplateRequest.setTemplateType("1");
        CompositeResponse<IpfCcmTemplateCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmTemplateRequest, IpfCcmTemplateCreateResponse.class, "ipfCcmTemplate.createIpfCcmTemplate", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmTemplateCreateResponse ipfCcmTemplateResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmTemplate(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmTemplateDeleteRequest ipfCcmTemplateRequest = new IpfCcmTemplateDeleteRequest();
	   	ipfCcmTemplateRequest.setId("1");
        CompositeResponse<IpfCcmTemplateDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmTemplateRequest, IpfCcmTemplateDeleteResponse.class, "ipfCcmTemplate.deleteIpfCcmTemplate", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmTemplateDeleteResponse ipfCcmTemplateResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmTemplate(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmTemplateUpdateRequest ipfCcmTemplateRequest = new IpfCcmTemplateUpdateRequest();
	   	ipfCcmTemplateRequest.setId("1");
	   	ipfCcmTemplateRequest.setTemplateFile("1");
	   	ipfCcmTemplateRequest.setTemplateDesc("1");
	   	ipfCcmTemplateRequest.setTemplateType("1");
        CompositeResponse<IpfCcmTemplateUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmTemplateRequest, IpfCcmTemplateUpdateResponse.class, "ipfCcmTemplate.updateIpfCcmTemplate", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmTemplateUpdateResponse ipfCcmTemplateResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmTemplate(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmTemplateGetRequest ipfCcmTemplateRequest = new IpfCcmTemplateGetRequest();
	   	ipfCcmTemplateRequest.setId("1");
        CompositeResponse<IpfCcmTemplateGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmTemplateRequest, IpfCcmTemplateGetResponse.class, "ipfCcmTemplate.getIpfCcmTemplate", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmTemplateGetResponse ipfCcmTemplateResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmTemplateSelectAllRequest ipfCcmTemplateRequest = new IpfCcmTemplateSelectAllRequest();

        CompositeResponse<IpfCcmTemplateSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmTemplateRequest, IpfCcmTemplateSelectAllResponse.class, "ipfCcmTemplate.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmTemplateSelectAllResponse ipfCcmTemplateResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmTemplateCountAllRequest ipfCcmTemplateRequest = new IpfCcmTemplateCountAllRequest();

        CompositeResponse<IpfCcmTemplateCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmTemplateRequest, IpfCcmTemplateCountAllResponse.class, "ipfCcmTemplate.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmTemplateCountAllResponse ipfCcmTemplateResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmTemplateResponse.getResultString());
    }

    @Test
    public void selectIpfCcmTemplate(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmTemplateSelectRequest ipfCcmTemplateRequest = new IpfCcmTemplateSelectRequest();
	   	ipfCcmTemplateRequest.setId("1");
	   	ipfCcmTemplateRequest.setTemplateFile("1");
	   	ipfCcmTemplateRequest.setTemplateDesc("1");
	   	ipfCcmTemplateRequest.setTemplateType("1");
        CompositeResponse<IpfCcmTemplateCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmTemplateRequest, IpfCcmTemplateCreateResponse.class, "ipfCcmTemplate.createIpfCcmTemplate", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmTemplateRequest.setId("1");
	   	ipfCcmTemplateRequest.setTemplateFile("1");
	   	ipfCcmTemplateRequest.setTemplateDesc("1");
	   	ipfCcmTemplateRequest.setTemplateType("1");
        CompositeResponse<IpfCcmTemplateSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmTemplateRequest, IpfCcmTemplateSelectResponse.class, "ipfCcmTemplate.selectIpfCcmTemplate", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmTemplateSelectResponse ipfCcmTemplateResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmTemplateResponse.getResultJson());
        CompositeResponse<IpfCcmTemplateDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmTemplateRequest, IpfCcmTemplateDeleteResponse.class, "ipfCcmTemplate.deleteIpfCcmTemplate", "1.0");

    }
}
