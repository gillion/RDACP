/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmDictValue;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmDictValue.request.*;
import com.cartan.center.ebs.ipfCcmDictValue.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmDictValueServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmDictValueServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictValueGetSessionRequest ipfCcmDictValueRequest = new IpfCcmDictValueGetSessionRequest();
     	CompositeResponse<IpfCcmDictValueGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmDictValueRequest, IpfCcmDictValueGetSessionResponse.class, "ipfCcmDictValue.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmDictValue(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictValueCreateRequest ipfCcmDictValueRequest = new IpfCcmDictValueCreateRequest();
	   	ipfCcmDictValueRequest.setId("1");
	   	ipfCcmDictValueRequest.setIpfCcmDictId("1");
	   	ipfCcmDictValueRequest.setCodeValue("1");
	   	ipfCcmDictValueRequest.setDisplayValue("1");
	   	ipfCcmDictValueRequest.setSeqNo("1");
	   	ipfCcmDictValueRequest.setGroupValue("1");
	   	ipfCcmDictValueRequest.setRemark("1");
        CompositeResponse<IpfCcmDictValueCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictValueRequest, IpfCcmDictValueCreateResponse.class, "ipfCcmDictValue.createIpfCcmDictValue", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictValueCreateResponse ipfCcmDictValueResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmDictValue(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictValueDeleteRequest ipfCcmDictValueRequest = new IpfCcmDictValueDeleteRequest();
	   	ipfCcmDictValueRequest.setId("1");
        CompositeResponse<IpfCcmDictValueDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictValueRequest, IpfCcmDictValueDeleteResponse.class, "ipfCcmDictValue.deleteIpfCcmDictValue", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictValueDeleteResponse ipfCcmDictValueResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmDictValue(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictValueUpdateRequest ipfCcmDictValueRequest = new IpfCcmDictValueUpdateRequest();
	   	ipfCcmDictValueRequest.setId("1");
	   	ipfCcmDictValueRequest.setIpfCcmDictId("1");
	   	ipfCcmDictValueRequest.setCodeValue("1");
	   	ipfCcmDictValueRequest.setDisplayValue("1");
	   	ipfCcmDictValueRequest.setSeqNo("1");
	   	ipfCcmDictValueRequest.setGroupValue("1");
	   	ipfCcmDictValueRequest.setRemark("1");
        CompositeResponse<IpfCcmDictValueUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictValueRequest, IpfCcmDictValueUpdateResponse.class, "ipfCcmDictValue.updateIpfCcmDictValue", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictValueUpdateResponse ipfCcmDictValueResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmDictValue(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictValueGetRequest ipfCcmDictValueRequest = new IpfCcmDictValueGetRequest();
	   	ipfCcmDictValueRequest.setId("1");
        CompositeResponse<IpfCcmDictValueGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictValueRequest, IpfCcmDictValueGetResponse.class, "ipfCcmDictValue.getIpfCcmDictValue", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictValueGetResponse ipfCcmDictValueResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictValueSelectAllRequest ipfCcmDictValueRequest = new IpfCcmDictValueSelectAllRequest();

        CompositeResponse<IpfCcmDictValueSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictValueRequest, IpfCcmDictValueSelectAllResponse.class, "ipfCcmDictValue.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictValueSelectAllResponse ipfCcmDictValueResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictValueCountAllRequest ipfCcmDictValueRequest = new IpfCcmDictValueCountAllRequest();

        CompositeResponse<IpfCcmDictValueCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictValueRequest, IpfCcmDictValueCountAllResponse.class, "ipfCcmDictValue.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictValueCountAllResponse ipfCcmDictValueResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmDictValueResponse.getResultString());
    }

    @Test
    public void selectIpfCcmDictValue(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictValueSelectRequest ipfCcmDictValueRequest = new IpfCcmDictValueSelectRequest();
	   	ipfCcmDictValueRequest.setId("1");
	   	ipfCcmDictValueRequest.setIpfCcmDictId("1");
	   	ipfCcmDictValueRequest.setCodeValue("1");
	   	ipfCcmDictValueRequest.setDisplayValue("1");
	   	ipfCcmDictValueRequest.setSeqNo("1");
	   	ipfCcmDictValueRequest.setGroupValue("1");
	   	ipfCcmDictValueRequest.setRemark("1");
        CompositeResponse<IpfCcmDictValueCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictValueRequest, IpfCcmDictValueCreateResponse.class, "ipfCcmDictValue.createIpfCcmDictValue", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmDictValueRequest.setId("1");
	   	ipfCcmDictValueRequest.setIpfCcmDictId("1");
	   	ipfCcmDictValueRequest.setCodeValue("1");
	   	ipfCcmDictValueRequest.setDisplayValue("1");
	   	ipfCcmDictValueRequest.setSeqNo("1");
	   	ipfCcmDictValueRequest.setGroupValue("1");
	   	ipfCcmDictValueRequest.setRemark("1");
        CompositeResponse<IpfCcmDictValueSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmDictValueRequest, IpfCcmDictValueSelectResponse.class, "ipfCcmDictValue.selectIpfCcmDictValue", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictValueSelectResponse ipfCcmDictValueResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmDictValueResponse.getResultJson());
        CompositeResponse<IpfCcmDictValueDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmDictValueRequest, IpfCcmDictValueDeleteResponse.class, "ipfCcmDictValue.deleteIpfCcmDictValue", "1.0");

    }
}
