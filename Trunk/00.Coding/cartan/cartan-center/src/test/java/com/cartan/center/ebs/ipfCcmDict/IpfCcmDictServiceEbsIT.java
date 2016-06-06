/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmDict;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmDict.request.*;
import com.cartan.center.ebs.ipfCcmDict.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmDictServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmDictServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictGetSessionRequest ipfCcmDictRequest = new IpfCcmDictGetSessionRequest();
     	CompositeResponse<IpfCcmDictGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmDictRequest, IpfCcmDictGetSessionResponse.class, "ipfCcmDict.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmDict(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictCreateRequest ipfCcmDictRequest = new IpfCcmDictCreateRequest();
	   	ipfCcmDictRequest.setId("1");
	   	ipfCcmDictRequest.setDictCode("1");
	   	ipfCcmDictRequest.setDictName("1");
	   	ipfCcmDictRequest.setDictType("1");
	   	ipfCcmDictRequest.setCodeColumn("1");
	   	ipfCcmDictRequest.setNameColumn("1");
	   	ipfCcmDictRequest.setKeyColumn("1");
	   	ipfCcmDictRequest.setTableName("1");
	   	ipfCcmDictRequest.setIsGroup("1");
	   	ipfCcmDictRequest.setGroupColumn("1");
	   	ipfCcmDictRequest.setRemark("1");
	   	ipfCcmDictRequest.setOrderColumn("1");
	   	ipfCcmDictRequest.setIsSystem("1");
	   	ipfCcmDictRequest.setDataType("1");
	   	ipfCcmDictRequest.setFieldLength("1");
	   	ipfCcmDictRequest.setDecimals("1");
        CompositeResponse<IpfCcmDictCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictRequest, IpfCcmDictCreateResponse.class, "ipfCcmDict.createIpfCcmDict", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictCreateResponse ipfCcmDictResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmDict(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictDeleteRequest ipfCcmDictRequest = new IpfCcmDictDeleteRequest();
	   	ipfCcmDictRequest.setId("1");
        CompositeResponse<IpfCcmDictDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictRequest, IpfCcmDictDeleteResponse.class, "ipfCcmDict.deleteIpfCcmDict", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictDeleteResponse ipfCcmDictResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmDict(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictUpdateRequest ipfCcmDictRequest = new IpfCcmDictUpdateRequest();
	   	ipfCcmDictRequest.setId("1");
	   	ipfCcmDictRequest.setDictCode("1");
	   	ipfCcmDictRequest.setDictName("1");
	   	ipfCcmDictRequest.setDictType("1");
	   	ipfCcmDictRequest.setCodeColumn("1");
	   	ipfCcmDictRequest.setNameColumn("1");
	   	ipfCcmDictRequest.setKeyColumn("1");
	   	ipfCcmDictRequest.setTableName("1");
	   	ipfCcmDictRequest.setIsGroup("1");
	   	ipfCcmDictRequest.setGroupColumn("1");
	   	ipfCcmDictRequest.setRemark("1");
	   	ipfCcmDictRequest.setOrderColumn("1");
	   	ipfCcmDictRequest.setIsSystem("1");
	   	ipfCcmDictRequest.setDataType("1");
	   	ipfCcmDictRequest.setFieldLength("1");
	   	ipfCcmDictRequest.setDecimals("1");
        CompositeResponse<IpfCcmDictUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictRequest, IpfCcmDictUpdateResponse.class, "ipfCcmDict.updateIpfCcmDict", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictUpdateResponse ipfCcmDictResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmDict(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictGetRequest ipfCcmDictRequest = new IpfCcmDictGetRequest();
	   	ipfCcmDictRequest.setId("1");
        CompositeResponse<IpfCcmDictGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictRequest, IpfCcmDictGetResponse.class, "ipfCcmDict.getIpfCcmDict", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictGetResponse ipfCcmDictResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictSelectAllRequest ipfCcmDictRequest = new IpfCcmDictSelectAllRequest();

        CompositeResponse<IpfCcmDictSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictRequest, IpfCcmDictSelectAllResponse.class, "ipfCcmDict.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictSelectAllResponse ipfCcmDictResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictCountAllRequest ipfCcmDictRequest = new IpfCcmDictCountAllRequest();

        CompositeResponse<IpfCcmDictCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictRequest, IpfCcmDictCountAllResponse.class, "ipfCcmDict.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictCountAllResponse ipfCcmDictResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmDictResponse.getResultString());
    }

    @Test
    public void selectIpfCcmDict(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmDictSelectRequest ipfCcmDictRequest = new IpfCcmDictSelectRequest();
	   	ipfCcmDictRequest.setId("1");
	   	ipfCcmDictRequest.setDictCode("1");
	   	ipfCcmDictRequest.setDictName("1");
	   	ipfCcmDictRequest.setDictType("1");
	   	ipfCcmDictRequest.setCodeColumn("1");
	   	ipfCcmDictRequest.setNameColumn("1");
	   	ipfCcmDictRequest.setKeyColumn("1");
	   	ipfCcmDictRequest.setTableName("1");
	   	ipfCcmDictRequest.setIsGroup("1");
	   	ipfCcmDictRequest.setGroupColumn("1");
	   	ipfCcmDictRequest.setRemark("1");
	   	ipfCcmDictRequest.setOrderColumn("1");
	   	ipfCcmDictRequest.setIsSystem("1");
	   	ipfCcmDictRequest.setDataType("1");
	   	ipfCcmDictRequest.setFieldLength("1");
	   	ipfCcmDictRequest.setDecimals("1");
        CompositeResponse<IpfCcmDictCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmDictRequest, IpfCcmDictCreateResponse.class, "ipfCcmDict.createIpfCcmDict", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmDictRequest.setId("1");
	   	ipfCcmDictRequest.setDictCode("1");
	   	ipfCcmDictRequest.setDictName("1");
	   	ipfCcmDictRequest.setDictType("1");
	   	ipfCcmDictRequest.setCodeColumn("1");
	   	ipfCcmDictRequest.setNameColumn("1");
	   	ipfCcmDictRequest.setKeyColumn("1");
	   	ipfCcmDictRequest.setTableName("1");
	   	ipfCcmDictRequest.setIsGroup("1");
	   	ipfCcmDictRequest.setGroupColumn("1");
	   	ipfCcmDictRequest.setRemark("1");
	   	ipfCcmDictRequest.setOrderColumn("1");
	   	ipfCcmDictRequest.setIsSystem("1");
	   	ipfCcmDictRequest.setDataType("1");
	   	ipfCcmDictRequest.setFieldLength("1");
	   	ipfCcmDictRequest.setDecimals("1");
        CompositeResponse<IpfCcmDictSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmDictRequest, IpfCcmDictSelectResponse.class, "ipfCcmDict.selectIpfCcmDict", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmDictSelectResponse ipfCcmDictResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmDictResponse.getResultJson());
        CompositeResponse<IpfCcmDictDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmDictRequest, IpfCcmDictDeleteResponse.class, "ipfCcmDict.deleteIpfCcmDict", "1.0");

    }
}
