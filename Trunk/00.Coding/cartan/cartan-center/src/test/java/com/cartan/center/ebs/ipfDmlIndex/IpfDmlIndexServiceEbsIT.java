/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlIndex;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlIndex.request.*;
import com.cartan.center.ebs.ipfDmlIndex.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlIndexServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlIndexServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexGetSessionRequest ipfDmlIndexRequest = new IpfDmlIndexGetSessionRequest();
     	CompositeResponse<IpfDmlIndexGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlIndexRequest, IpfDmlIndexGetSessionResponse.class, "ipfDmlIndex.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlIndex(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexCreateRequest ipfDmlIndexRequest = new IpfDmlIndexCreateRequest();
	   	ipfDmlIndexRequest.setId("1");
	   	ipfDmlIndexRequest.setIpfDmlTableId("1");
	   	ipfDmlIndexRequest.setIndexName("1");
	   	ipfDmlIndexRequest.setIndexType("1");
        CompositeResponse<IpfDmlIndexCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexRequest, IpfDmlIndexCreateResponse.class, "ipfDmlIndex.createIpfDmlIndex", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexCreateResponse ipfDmlIndexResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlIndex(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexDeleteRequest ipfDmlIndexRequest = new IpfDmlIndexDeleteRequest();
	   	ipfDmlIndexRequest.setId("1");
        CompositeResponse<IpfDmlIndexDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexRequest, IpfDmlIndexDeleteResponse.class, "ipfDmlIndex.deleteIpfDmlIndex", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexDeleteResponse ipfDmlIndexResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlIndex(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexUpdateRequest ipfDmlIndexRequest = new IpfDmlIndexUpdateRequest();
	   	ipfDmlIndexRequest.setId("1");
	   	ipfDmlIndexRequest.setIpfDmlTableId("1");
	   	ipfDmlIndexRequest.setIndexName("1");
	   	ipfDmlIndexRequest.setIndexType("1");
        CompositeResponse<IpfDmlIndexUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexRequest, IpfDmlIndexUpdateResponse.class, "ipfDmlIndex.updateIpfDmlIndex", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexUpdateResponse ipfDmlIndexResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlIndex(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexGetRequest ipfDmlIndexRequest = new IpfDmlIndexGetRequest();
	   	ipfDmlIndexRequest.setId("1");
        CompositeResponse<IpfDmlIndexGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexRequest, IpfDmlIndexGetResponse.class, "ipfDmlIndex.getIpfDmlIndex", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexGetResponse ipfDmlIndexResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexSelectAllRequest ipfDmlIndexRequest = new IpfDmlIndexSelectAllRequest();

        CompositeResponse<IpfDmlIndexSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexRequest, IpfDmlIndexSelectAllResponse.class, "ipfDmlIndex.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexSelectAllResponse ipfDmlIndexResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexCountAllRequest ipfDmlIndexRequest = new IpfDmlIndexCountAllRequest();

        CompositeResponse<IpfDmlIndexCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexRequest, IpfDmlIndexCountAllResponse.class, "ipfDmlIndex.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexCountAllResponse ipfDmlIndexResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlIndexResponse.getResultString());
    }

    @Test
    public void selectIpfDmlIndex(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexSelectRequest ipfDmlIndexRequest = new IpfDmlIndexSelectRequest();
	   	ipfDmlIndexRequest.setId("1");
	   	ipfDmlIndexRequest.setIpfDmlTableId("1");
	   	ipfDmlIndexRequest.setIndexName("1");
	   	ipfDmlIndexRequest.setIndexType("1");
        CompositeResponse<IpfDmlIndexCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexRequest, IpfDmlIndexCreateResponse.class, "ipfDmlIndex.createIpfDmlIndex", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlIndexRequest.setId("1");
	   	ipfDmlIndexRequest.setIpfDmlTableId("1");
	   	ipfDmlIndexRequest.setIndexName("1");
	   	ipfDmlIndexRequest.setIndexType("1");
        CompositeResponse<IpfDmlIndexSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlIndexRequest, IpfDmlIndexSelectResponse.class, "ipfDmlIndex.selectIpfDmlIndex", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexSelectResponse ipfDmlIndexResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlIndexResponse.getResultJson());
        CompositeResponse<IpfDmlIndexDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlIndexRequest, IpfDmlIndexDeleteResponse.class, "ipfDmlIndex.deleteIpfDmlIndex", "1.0");

    }
}
