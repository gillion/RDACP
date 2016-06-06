/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmType;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfRtmType.request.*;
import com.cartan.center.ebs.ipfRtmType.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfRtmTypeServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfRtmTypeServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeGetSessionRequest ipfRtmTypeRequest = new IpfRtmTypeGetSessionRequest();
     	CompositeResponse<IpfRtmTypeGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfRtmTypeRequest, IpfRtmTypeGetSessionResponse.class, "ipfRtmType.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfRtmType(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeCreateRequest ipfRtmTypeRequest = new IpfRtmTypeCreateRequest();
	   	ipfRtmTypeRequest.setId("1");
	   	ipfRtmTypeRequest.setTypeCode("1");
	   	ipfRtmTypeRequest.setTypeName("1");
        CompositeResponse<IpfRtmTypeCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeRequest, IpfRtmTypeCreateResponse.class, "ipfRtmType.createIpfRtmType", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeCreateResponse ipfRtmTypeResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfRtmType(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeDeleteRequest ipfRtmTypeRequest = new IpfRtmTypeDeleteRequest();
	   	ipfRtmTypeRequest.setId("1");
        CompositeResponse<IpfRtmTypeDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeRequest, IpfRtmTypeDeleteResponse.class, "ipfRtmType.deleteIpfRtmType", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeDeleteResponse ipfRtmTypeResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfRtmType(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeUpdateRequest ipfRtmTypeRequest = new IpfRtmTypeUpdateRequest();
	   	ipfRtmTypeRequest.setId("1");
	   	ipfRtmTypeRequest.setTypeCode("1");
	   	ipfRtmTypeRequest.setTypeName("1");
        CompositeResponse<IpfRtmTypeUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeRequest, IpfRtmTypeUpdateResponse.class, "ipfRtmType.updateIpfRtmType", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeUpdateResponse ipfRtmTypeResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfRtmType(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeGetRequest ipfRtmTypeRequest = new IpfRtmTypeGetRequest();
	   	ipfRtmTypeRequest.setId("1");
        CompositeResponse<IpfRtmTypeGetResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeRequest, IpfRtmTypeGetResponse.class, "ipfRtmType.getIpfRtmType", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeGetResponse ipfRtmTypeResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeSelectAllRequest ipfRtmTypeRequest = new IpfRtmTypeSelectAllRequest();

        CompositeResponse<IpfRtmTypeSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeRequest, IpfRtmTypeSelectAllResponse.class, "ipfRtmType.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeSelectAllResponse ipfRtmTypeResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeCountAllRequest ipfRtmTypeRequest = new IpfRtmTypeCountAllRequest();

        CompositeResponse<IpfRtmTypeCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeRequest, IpfRtmTypeCountAllResponse.class, "ipfRtmType.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeCountAllResponse ipfRtmTypeResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfRtmTypeResponse.getResultString());
    }

    @Test
    public void selectIpfRtmType(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmTypeSelectRequest ipfRtmTypeRequest = new IpfRtmTypeSelectRequest();
	   	ipfRtmTypeRequest.setId("1");
	   	ipfRtmTypeRequest.setTypeCode("1");
	   	ipfRtmTypeRequest.setTypeName("1");
        CompositeResponse<IpfRtmTypeCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmTypeRequest, IpfRtmTypeCreateResponse.class, "ipfRtmType.createIpfRtmType", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfRtmTypeRequest.setId("1");
	   	ipfRtmTypeRequest.setTypeCode("1");
	   	ipfRtmTypeRequest.setTypeName("1");
        CompositeResponse<IpfRtmTypeSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfRtmTypeRequest, IpfRtmTypeSelectResponse.class, "ipfRtmType.selectIpfRtmType", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmTypeSelectResponse ipfRtmTypeResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfRtmTypeResponse.getResultJson());
        CompositeResponse<IpfRtmTypeDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfRtmTypeRequest, IpfRtmTypeDeleteResponse.class, "ipfRtmType.deleteIpfRtmType", "1.0");

    }
}
