/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmConfigAttr;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfRtmConfigAttr.request.*;
import com.cartan.center.ebs.ipfRtmConfigAttr.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfRtmConfigAttrServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfRtmConfigAttrServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrGetSessionRequest ipfRtmConfigAttrRequest = new IpfRtmConfigAttrGetSessionRequest();
     	CompositeResponse<IpfRtmConfigAttrGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfRtmConfigAttrRequest, IpfRtmConfigAttrGetSessionResponse.class, "ipfRtmConfigAttr.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfRtmConfigAttr(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrCreateRequest ipfRtmConfigAttrRequest = new IpfRtmConfigAttrCreateRequest();
	   	ipfRtmConfigAttrRequest.setId("1");
	   	ipfRtmConfigAttrRequest.setIpfRtmConfigId("1");
	   	ipfRtmConfigAttrRequest.setSeqNo("1");
	   	ipfRtmConfigAttrRequest.setDisplayLabel("1");
	   	ipfRtmConfigAttrRequest.setDataType("1");
	   	ipfRtmConfigAttrRequest.setUiType("1");
	   	ipfRtmConfigAttrRequest.setDictTableName("1");
	   	ipfRtmConfigAttrRequest.setDictGroupValue("1");
	   	ipfRtmConfigAttrRequest.setSearchHelp("1");
	   	ipfRtmConfigAttrRequest.setShValueColumn("1");
	   	ipfRtmConfigAttrRequest.setShDisplayColumn("1");
        CompositeResponse<IpfRtmConfigAttrCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrRequest, IpfRtmConfigAttrCreateResponse.class, "ipfRtmConfigAttr.createIpfRtmConfigAttr", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrCreateResponse ipfRtmConfigAttrResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfRtmConfigAttr(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrDeleteRequest ipfRtmConfigAttrRequest = new IpfRtmConfigAttrDeleteRequest();
	   	ipfRtmConfigAttrRequest.setId("1");
        CompositeResponse<IpfRtmConfigAttrDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrRequest, IpfRtmConfigAttrDeleteResponse.class, "ipfRtmConfigAttr.deleteIpfRtmConfigAttr", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrDeleteResponse ipfRtmConfigAttrResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfRtmConfigAttr(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrUpdateRequest ipfRtmConfigAttrRequest = new IpfRtmConfigAttrUpdateRequest();
	   	ipfRtmConfigAttrRequest.setId("1");
	   	ipfRtmConfigAttrRequest.setIpfRtmConfigId("1");
	   	ipfRtmConfigAttrRequest.setSeqNo("1");
	   	ipfRtmConfigAttrRequest.setDisplayLabel("1");
	   	ipfRtmConfigAttrRequest.setDataType("1");
	   	ipfRtmConfigAttrRequest.setUiType("1");
	   	ipfRtmConfigAttrRequest.setDictTableName("1");
	   	ipfRtmConfigAttrRequest.setDictGroupValue("1");
	   	ipfRtmConfigAttrRequest.setSearchHelp("1");
	   	ipfRtmConfigAttrRequest.setShValueColumn("1");
	   	ipfRtmConfigAttrRequest.setShDisplayColumn("1");
        CompositeResponse<IpfRtmConfigAttrUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrRequest, IpfRtmConfigAttrUpdateResponse.class, "ipfRtmConfigAttr.updateIpfRtmConfigAttr", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrUpdateResponse ipfRtmConfigAttrResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfRtmConfigAttr(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrGetRequest ipfRtmConfigAttrRequest = new IpfRtmConfigAttrGetRequest();
	   	ipfRtmConfigAttrRequest.setId("1");
        CompositeResponse<IpfRtmConfigAttrGetResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrRequest, IpfRtmConfigAttrGetResponse.class, "ipfRtmConfigAttr.getIpfRtmConfigAttr", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrGetResponse ipfRtmConfigAttrResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrSelectAllRequest ipfRtmConfigAttrRequest = new IpfRtmConfigAttrSelectAllRequest();

        CompositeResponse<IpfRtmConfigAttrSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrRequest, IpfRtmConfigAttrSelectAllResponse.class, "ipfRtmConfigAttr.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrSelectAllResponse ipfRtmConfigAttrResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrCountAllRequest ipfRtmConfigAttrRequest = new IpfRtmConfigAttrCountAllRequest();

        CompositeResponse<IpfRtmConfigAttrCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrRequest, IpfRtmConfigAttrCountAllResponse.class, "ipfRtmConfigAttr.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrCountAllResponse ipfRtmConfigAttrResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfRtmConfigAttrResponse.getResultString());
    }

    @Test
    public void selectIpfRtmConfigAttr(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfRtmConfigAttrSelectRequest ipfRtmConfigAttrRequest = new IpfRtmConfigAttrSelectRequest();
	   	ipfRtmConfigAttrRequest.setId("1");
	   	ipfRtmConfigAttrRequest.setIpfRtmConfigId("1");
	   	ipfRtmConfigAttrRequest.setSeqNo("1");
	   	ipfRtmConfigAttrRequest.setDisplayLabel("1");
	   	ipfRtmConfigAttrRequest.setDataType("1");
	   	ipfRtmConfigAttrRequest.setUiType("1");
	   	ipfRtmConfigAttrRequest.setDictTableName("1");
	   	ipfRtmConfigAttrRequest.setDictGroupValue("1");
	   	ipfRtmConfigAttrRequest.setSearchHelp("1");
	   	ipfRtmConfigAttrRequest.setShValueColumn("1");
	   	ipfRtmConfigAttrRequest.setShDisplayColumn("1");
        CompositeResponse<IpfRtmConfigAttrCreateResponse> response =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrRequest, IpfRtmConfigAttrCreateResponse.class, "ipfRtmConfigAttr.createIpfRtmConfigAttr", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfRtmConfigAttrRequest.setId("1");
	   	ipfRtmConfigAttrRequest.setIpfRtmConfigId("1");
	   	ipfRtmConfigAttrRequest.setSeqNo("1");
	   	ipfRtmConfigAttrRequest.setDisplayLabel("1");
	   	ipfRtmConfigAttrRequest.setDataType("1");
	   	ipfRtmConfigAttrRequest.setUiType("1");
	   	ipfRtmConfigAttrRequest.setDictTableName("1");
	   	ipfRtmConfigAttrRequest.setDictGroupValue("1");
	   	ipfRtmConfigAttrRequest.setSearchHelp("1");
	   	ipfRtmConfigAttrRequest.setShValueColumn("1");
	   	ipfRtmConfigAttrRequest.setShDisplayColumn("1");
        CompositeResponse<IpfRtmConfigAttrSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrRequest, IpfRtmConfigAttrSelectResponse.class, "ipfRtmConfigAttr.selectIpfRtmConfigAttr", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfRtmConfigAttrSelectResponse ipfRtmConfigAttrResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfRtmConfigAttrResponse.getResultJson());
        CompositeResponse<IpfRtmConfigAttrDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfRtmConfigAttrRequest, IpfRtmConfigAttrDeleteResponse.class, "ipfRtmConfigAttr.deleteIpfRtmConfigAttr", "1.0");

    }
}
