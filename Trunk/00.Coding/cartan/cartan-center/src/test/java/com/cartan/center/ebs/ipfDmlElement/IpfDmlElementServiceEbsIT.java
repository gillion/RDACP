/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlElement;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlElement.request.*;
import com.cartan.center.ebs.ipfDmlElement.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlElementServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlElementServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementGetSessionRequest ipfDmlElementRequest = new IpfDmlElementGetSessionRequest();
     	CompositeResponse<IpfDmlElementGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlElementRequest, IpfDmlElementGetSessionResponse.class, "ipfDmlElement.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlElement(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementCreateRequest ipfDmlElementRequest = new IpfDmlElementCreateRequest();
	   	ipfDmlElementRequest.setId("1");
	   	ipfDmlElementRequest.setElementCode("1");
	   	ipfDmlElementRequest.setFieldText("1");
	   	ipfDmlElementRequest.setDataType("1");
	   	ipfDmlElementRequest.setFieldLength("1");
	   	ipfDmlElementRequest.setDecimals("1");
        CompositeResponse<IpfDmlElementCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementRequest, IpfDmlElementCreateResponse.class, "ipfDmlElement.createIpfDmlElement", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementCreateResponse ipfDmlElementResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlElement(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementDeleteRequest ipfDmlElementRequest = new IpfDmlElementDeleteRequest();
	   	ipfDmlElementRequest.setId("1");
        CompositeResponse<IpfDmlElementDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementRequest, IpfDmlElementDeleteResponse.class, "ipfDmlElement.deleteIpfDmlElement", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementDeleteResponse ipfDmlElementResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlElement(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementUpdateRequest ipfDmlElementRequest = new IpfDmlElementUpdateRequest();
	   	ipfDmlElementRequest.setId("1");
	   	ipfDmlElementRequest.setElementCode("1");
	   	ipfDmlElementRequest.setFieldText("1");
	   	ipfDmlElementRequest.setDataType("1");
	   	ipfDmlElementRequest.setFieldLength("1");
	   	ipfDmlElementRequest.setDecimals("1");
        CompositeResponse<IpfDmlElementUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementRequest, IpfDmlElementUpdateResponse.class, "ipfDmlElement.updateIpfDmlElement", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementUpdateResponse ipfDmlElementResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlElement(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementGetRequest ipfDmlElementRequest = new IpfDmlElementGetRequest();
	   	ipfDmlElementRequest.setId("1");
        CompositeResponse<IpfDmlElementGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementRequest, IpfDmlElementGetResponse.class, "ipfDmlElement.getIpfDmlElement", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementGetResponse ipfDmlElementResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementSelectAllRequest ipfDmlElementRequest = new IpfDmlElementSelectAllRequest();

        CompositeResponse<IpfDmlElementSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementRequest, IpfDmlElementSelectAllResponse.class, "ipfDmlElement.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementSelectAllResponse ipfDmlElementResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementCountAllRequest ipfDmlElementRequest = new IpfDmlElementCountAllRequest();

        CompositeResponse<IpfDmlElementCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementRequest, IpfDmlElementCountAllResponse.class, "ipfDmlElement.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementCountAllResponse ipfDmlElementResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlElementResponse.getResultString());
    }

    @Test
    public void selectIpfDmlElement(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlElementSelectRequest ipfDmlElementRequest = new IpfDmlElementSelectRequest();
	   	ipfDmlElementRequest.setId("1");
	   	ipfDmlElementRequest.setElementCode("1");
	   	ipfDmlElementRequest.setFieldText("1");
	   	ipfDmlElementRequest.setDataType("1");
	   	ipfDmlElementRequest.setFieldLength("1");
	   	ipfDmlElementRequest.setDecimals("1");
        CompositeResponse<IpfDmlElementCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlElementRequest, IpfDmlElementCreateResponse.class, "ipfDmlElement.createIpfDmlElement", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlElementRequest.setId("1");
	   	ipfDmlElementRequest.setElementCode("1");
	   	ipfDmlElementRequest.setFieldText("1");
	   	ipfDmlElementRequest.setDataType("1");
	   	ipfDmlElementRequest.setFieldLength("1");
	   	ipfDmlElementRequest.setDecimals("1");
        CompositeResponse<IpfDmlElementSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlElementRequest, IpfDmlElementSelectResponse.class, "ipfDmlElement.selectIpfDmlElement", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlElementSelectResponse ipfDmlElementResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlElementResponse.getResultJson());
        CompositeResponse<IpfDmlElementDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlElementRequest, IpfDmlElementDeleteResponse.class, "ipfDmlElement.deleteIpfDmlElement", "1.0");

    }
}
