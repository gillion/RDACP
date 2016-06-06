/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlTable;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlTable.request.*;
import com.cartan.center.ebs.ipfDmlTable.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlTableServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlTableServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlTableGetSessionRequest ipfDmlTableRequest = new IpfDmlTableGetSessionRequest();
     	CompositeResponse<IpfDmlTableGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlTableRequest, IpfDmlTableGetSessionResponse.class, "ipfDmlTable.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlTable(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlTableCreateRequest ipfDmlTableRequest = new IpfDmlTableCreateRequest();
	   	ipfDmlTableRequest.setId("1");
	   	ipfDmlTableRequest.setTableName("1");
	   	ipfDmlTableRequest.setTableType("1");
	   	ipfDmlTableRequest.setTableDesc("1");
        CompositeResponse<IpfDmlTableCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlTableRequest, IpfDmlTableCreateResponse.class, "ipfDmlTable.createIpfDmlTable", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlTableCreateResponse ipfDmlTableResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlTable(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlTableDeleteRequest ipfDmlTableRequest = new IpfDmlTableDeleteRequest();
	   	ipfDmlTableRequest.setId("1");
        CompositeResponse<IpfDmlTableDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlTableRequest, IpfDmlTableDeleteResponse.class, "ipfDmlTable.deleteIpfDmlTable", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlTableDeleteResponse ipfDmlTableResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlTable(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlTableUpdateRequest ipfDmlTableRequest = new IpfDmlTableUpdateRequest();
	   	ipfDmlTableRequest.setId("1");
	   	ipfDmlTableRequest.setTableName("1");
	   	ipfDmlTableRequest.setTableType("1");
	   	ipfDmlTableRequest.setTableDesc("1");
        CompositeResponse<IpfDmlTableUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlTableRequest, IpfDmlTableUpdateResponse.class, "ipfDmlTable.updateIpfDmlTable", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlTableUpdateResponse ipfDmlTableResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlTable(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlTableGetRequest ipfDmlTableRequest = new IpfDmlTableGetRequest();
	   	ipfDmlTableRequest.setId("1");
        CompositeResponse<IpfDmlTableGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlTableRequest, IpfDmlTableGetResponse.class, "ipfDmlTable.getIpfDmlTable", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlTableGetResponse ipfDmlTableResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlTableSelectAllRequest ipfDmlTableRequest = new IpfDmlTableSelectAllRequest();

        CompositeResponse<IpfDmlTableSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlTableRequest, IpfDmlTableSelectAllResponse.class, "ipfDmlTable.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlTableSelectAllResponse ipfDmlTableResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlTableCountAllRequest ipfDmlTableRequest = new IpfDmlTableCountAllRequest();

        CompositeResponse<IpfDmlTableCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlTableRequest, IpfDmlTableCountAllResponse.class, "ipfDmlTable.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlTableCountAllResponse ipfDmlTableResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlTableResponse.getResultString());
    }

    @Test
    public void selectIpfDmlTable(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlTableSelectRequest ipfDmlTableRequest = new IpfDmlTableSelectRequest();
	   	ipfDmlTableRequest.setId("1");
	   	ipfDmlTableRequest.setTableName("1");
	   	ipfDmlTableRequest.setTableType("1");
	   	ipfDmlTableRequest.setTableDesc("1");
        CompositeResponse<IpfDmlTableCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlTableRequest, IpfDmlTableCreateResponse.class, "ipfDmlTable.createIpfDmlTable", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlTableRequest.setId("1");
	   	ipfDmlTableRequest.setTableName("1");
	   	ipfDmlTableRequest.setTableType("1");
	   	ipfDmlTableRequest.setTableDesc("1");
        CompositeResponse<IpfDmlTableSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlTableRequest, IpfDmlTableSelectResponse.class, "ipfDmlTable.selectIpfDmlTable", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlTableSelectResponse ipfDmlTableResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlTableResponse.getResultJson());
        CompositeResponse<IpfDmlTableDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlTableRequest, IpfDmlTableDeleteResponse.class, "ipfDmlTable.deleteIpfDmlTable", "1.0");

    }
}
