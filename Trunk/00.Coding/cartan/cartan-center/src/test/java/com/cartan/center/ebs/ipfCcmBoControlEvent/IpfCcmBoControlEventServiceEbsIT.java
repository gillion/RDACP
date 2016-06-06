/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoControlEvent;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoControlEvent.request.*;
import com.cartan.center.ebs.ipfCcmBoControlEvent.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoControlEventServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoControlEventServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoControlEventGetSessionRequest ipfCcmBoControlEventRequest = new IpfCcmBoControlEventGetSessionRequest();
     	CompositeResponse<IpfCcmBoControlEventGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoControlEventRequest, IpfCcmBoControlEventGetSessionResponse.class, "ipfCcmBoControlEvent.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoControlEvent(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoControlEventCreateRequest ipfCcmBoControlEventRequest = new IpfCcmBoControlEventCreateRequest();
	   	ipfCcmBoControlEventRequest.setId("1");
	   	ipfCcmBoControlEventRequest.setIpfCcbBoFormColumnId("1");
	   	ipfCcmBoControlEventRequest.setEventType("1");
	   	ipfCcmBoControlEventRequest.setExecType("1");
	   	ipfCcmBoControlEventRequest.setExecContent("1");
	   	ipfCcmBoControlEventRequest.setCallBack("1");
        CompositeResponse<IpfCcmBoControlEventCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoControlEventRequest, IpfCcmBoControlEventCreateResponse.class, "ipfCcmBoControlEvent.createIpfCcmBoControlEvent", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoControlEventCreateResponse ipfCcmBoControlEventResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoControlEvent(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoControlEventDeleteRequest ipfCcmBoControlEventRequest = new IpfCcmBoControlEventDeleteRequest();
	   	ipfCcmBoControlEventRequest.setId("1");
        CompositeResponse<IpfCcmBoControlEventDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoControlEventRequest, IpfCcmBoControlEventDeleteResponse.class, "ipfCcmBoControlEvent.deleteIpfCcmBoControlEvent", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoControlEventDeleteResponse ipfCcmBoControlEventResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoControlEvent(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoControlEventUpdateRequest ipfCcmBoControlEventRequest = new IpfCcmBoControlEventUpdateRequest();
	   	ipfCcmBoControlEventRequest.setId("1");
	   	ipfCcmBoControlEventRequest.setIpfCcbBoFormColumnId("1");
	   	ipfCcmBoControlEventRequest.setEventType("1");
	   	ipfCcmBoControlEventRequest.setExecType("1");
	   	ipfCcmBoControlEventRequest.setExecContent("1");
	   	ipfCcmBoControlEventRequest.setCallBack("1");
        CompositeResponse<IpfCcmBoControlEventUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoControlEventRequest, IpfCcmBoControlEventUpdateResponse.class, "ipfCcmBoControlEvent.updateIpfCcmBoControlEvent", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoControlEventUpdateResponse ipfCcmBoControlEventResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoControlEvent(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoControlEventGetRequest ipfCcmBoControlEventRequest = new IpfCcmBoControlEventGetRequest();
	   	ipfCcmBoControlEventRequest.setId("1");
        CompositeResponse<IpfCcmBoControlEventGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoControlEventRequest, IpfCcmBoControlEventGetResponse.class, "ipfCcmBoControlEvent.getIpfCcmBoControlEvent", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoControlEventGetResponse ipfCcmBoControlEventResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoControlEventSelectAllRequest ipfCcmBoControlEventRequest = new IpfCcmBoControlEventSelectAllRequest();

        CompositeResponse<IpfCcmBoControlEventSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoControlEventRequest, IpfCcmBoControlEventSelectAllResponse.class, "ipfCcmBoControlEvent.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoControlEventSelectAllResponse ipfCcmBoControlEventResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoControlEventCountAllRequest ipfCcmBoControlEventRequest = new IpfCcmBoControlEventCountAllRequest();

        CompositeResponse<IpfCcmBoControlEventCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoControlEventRequest, IpfCcmBoControlEventCountAllResponse.class, "ipfCcmBoControlEvent.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoControlEventCountAllResponse ipfCcmBoControlEventResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoControlEventResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoControlEvent(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoControlEventSelectRequest ipfCcmBoControlEventRequest = new IpfCcmBoControlEventSelectRequest();
	   	ipfCcmBoControlEventRequest.setId("1");
	   	ipfCcmBoControlEventRequest.setIpfCcbBoFormColumnId("1");
	   	ipfCcmBoControlEventRequest.setEventType("1");
	   	ipfCcmBoControlEventRequest.setExecType("1");
	   	ipfCcmBoControlEventRequest.setExecContent("1");
	   	ipfCcmBoControlEventRequest.setCallBack("1");
        CompositeResponse<IpfCcmBoControlEventCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoControlEventRequest, IpfCcmBoControlEventCreateResponse.class, "ipfCcmBoControlEvent.createIpfCcmBoControlEvent", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoControlEventRequest.setId("1");
	   	ipfCcmBoControlEventRequest.setIpfCcbBoFormColumnId("1");
	   	ipfCcmBoControlEventRequest.setEventType("1");
	   	ipfCcmBoControlEventRequest.setExecType("1");
	   	ipfCcmBoControlEventRequest.setExecContent("1");
	   	ipfCcmBoControlEventRequest.setCallBack("1");
        CompositeResponse<IpfCcmBoControlEventSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoControlEventRequest, IpfCcmBoControlEventSelectResponse.class, "ipfCcmBoControlEvent.selectIpfCcmBoControlEvent", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoControlEventSelectResponse ipfCcmBoControlEventResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoControlEventResponse.getResultJson());
        CompositeResponse<IpfCcmBoControlEventDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoControlEventRequest, IpfCcmBoControlEventDeleteResponse.class, "ipfCcmBoControlEvent.deleteIpfCcmBoControlEvent", "1.0");

    }
}
