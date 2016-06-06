/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRuleRotate;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfRuleRotate.request.*;
import com.cartan.center.ebs.ipfRuleRotate.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfRuleRotateServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfRuleRotateServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateGetSessionRequest ipfRuleRotateRequest = new IpfRuleRotateGetSessionRequest();
     	CompositeResponse<IpfRuleRotateGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfRuleRotateRequest, IpfRuleRotateGetSessionResponse.class, "ipfRuleRotate.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfRuleRotate(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateCreateRequest ipfRuleRotateRequest = new IpfRuleRotateCreateRequest();
	   	ipfRuleRotateRequest.setId("1");
	   	ipfRuleRotateRequest.setWarehouseOfficeId("1");
	   	ipfRuleRotateRequest.setRuleCode("1");
	   	ipfRuleRotateRequest.setRuleDesc("1");
	   	ipfRuleRotateRequest.setIsActive("1");
	   	ipfRuleRotateRequest.setIsSystemCreate("1");
	   	ipfRuleRotateRequest.setRotateExpress("1");
        CompositeResponse<IpfRuleRotateCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateRequest, IpfRuleRotateCreateResponse.class, "ipfRuleRotate.createIpfRuleRotate", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateCreateResponse ipfRuleRotateResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfRuleRotate(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateDeleteRequest ipfRuleRotateRequest = new IpfRuleRotateDeleteRequest();
	   	ipfRuleRotateRequest.setId("1");
        CompositeResponse<IpfRuleRotateDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateRequest, IpfRuleRotateDeleteResponse.class, "ipfRuleRotate.deleteIpfRuleRotate", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateDeleteResponse ipfRuleRotateResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfRuleRotate(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateUpdateRequest ipfRuleRotateRequest = new IpfRuleRotateUpdateRequest();
	   	ipfRuleRotateRequest.setId("1");
	   	ipfRuleRotateRequest.setWarehouseOfficeId("1");
	   	ipfRuleRotateRequest.setRuleCode("1");
	   	ipfRuleRotateRequest.setRuleDesc("1");
	   	ipfRuleRotateRequest.setIsActive("1");
	   	ipfRuleRotateRequest.setIsSystemCreate("1");
	   	ipfRuleRotateRequest.setRotateExpress("1");
        CompositeResponse<IpfRuleRotateUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateRequest, IpfRuleRotateUpdateResponse.class, "ipfRuleRotate.updateIpfRuleRotate", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateUpdateResponse ipfRuleRotateResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfRuleRotate(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateGetRequest ipfRuleRotateRequest = new IpfRuleRotateGetRequest();
	   	ipfRuleRotateRequest.setId("1");
        CompositeResponse<IpfRuleRotateGetResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateRequest, IpfRuleRotateGetResponse.class, "ipfRuleRotate.getIpfRuleRotate", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateGetResponse ipfRuleRotateResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateSelectAllRequest ipfRuleRotateRequest = new IpfRuleRotateSelectAllRequest();

        CompositeResponse<IpfRuleRotateSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateRequest, IpfRuleRotateSelectAllResponse.class, "ipfRuleRotate.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateSelectAllResponse ipfRuleRotateResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateCountAllRequest ipfRuleRotateRequest = new IpfRuleRotateCountAllRequest();

        CompositeResponse<IpfRuleRotateCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateRequest, IpfRuleRotateCountAllResponse.class, "ipfRuleRotate.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateCountAllResponse ipfRuleRotateResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfRuleRotateResponse.getResultString());
    }

    @Test
    public void selectIpfRuleRotate(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRuleRotateSelectRequest ipfRuleRotateRequest = new IpfRuleRotateSelectRequest();
	   	ipfRuleRotateRequest.setId("1");
	   	ipfRuleRotateRequest.setWarehouseOfficeId("1");
	   	ipfRuleRotateRequest.setRuleCode("1");
	   	ipfRuleRotateRequest.setRuleDesc("1");
	   	ipfRuleRotateRequest.setIsActive("1");
	   	ipfRuleRotateRequest.setIsSystemCreate("1");
	   	ipfRuleRotateRequest.setRotateExpress("1");
        CompositeResponse<IpfRuleRotateCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRuleRotateRequest, IpfRuleRotateCreateResponse.class, "ipfRuleRotate.createIpfRuleRotate", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfRuleRotateRequest.setId("1");
	   	ipfRuleRotateRequest.setWarehouseOfficeId("1");
	   	ipfRuleRotateRequest.setRuleCode("1");
	   	ipfRuleRotateRequest.setRuleDesc("1");
	   	ipfRuleRotateRequest.setIsActive("1");
	   	ipfRuleRotateRequest.setIsSystemCreate("1");
	   	ipfRuleRotateRequest.setRotateExpress("1");
        CompositeResponse<IpfRuleRotateSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfRuleRotateRequest, IpfRuleRotateSelectResponse.class, "ipfRuleRotate.selectIpfRuleRotate", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRuleRotateSelectResponse ipfRuleRotateResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfRuleRotateResponse.getResultJson());
        CompositeResponse<IpfRuleRotateDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfRuleRotateRequest, IpfRuleRotateDeleteResponse.class, "ipfRuleRotate.deleteIpfRuleRotate", "1.0");

    }
}
