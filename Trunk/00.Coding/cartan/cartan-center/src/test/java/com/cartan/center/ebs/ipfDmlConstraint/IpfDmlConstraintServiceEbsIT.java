/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlConstraint;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlConstraint.request.*;
import com.cartan.center.ebs.ipfDmlConstraint.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlConstraintServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlConstraintServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintGetSessionRequest ipfDmlConstraintRequest = new IpfDmlConstraintGetSessionRequest();
     	CompositeResponse<IpfDmlConstraintGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlConstraintRequest, IpfDmlConstraintGetSessionResponse.class, "ipfDmlConstraint.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlConstraint(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintCreateRequest ipfDmlConstraintRequest = new IpfDmlConstraintCreateRequest();
	   	ipfDmlConstraintRequest.setId("1");
	   	ipfDmlConstraintRequest.setIpfDmlTableId("1");
	   	ipfDmlConstraintRequest.setConstraintName("1");
	   	ipfDmlConstraintRequest.setConstraintType("1");
	   	ipfDmlConstraintRequest.setColumnName("1");
	   	ipfDmlConstraintRequest.setForeignTableName("1");
	   	ipfDmlConstraintRequest.setForeignColumnName("1");
        CompositeResponse<IpfDmlConstraintCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintRequest, IpfDmlConstraintCreateResponse.class, "ipfDmlConstraint.createIpfDmlConstraint", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintCreateResponse ipfDmlConstraintResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlConstraint(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintDeleteRequest ipfDmlConstraintRequest = new IpfDmlConstraintDeleteRequest();
	   	ipfDmlConstraintRequest.setId("1");
        CompositeResponse<IpfDmlConstraintDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintRequest, IpfDmlConstraintDeleteResponse.class, "ipfDmlConstraint.deleteIpfDmlConstraint", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintDeleteResponse ipfDmlConstraintResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlConstraint(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintUpdateRequest ipfDmlConstraintRequest = new IpfDmlConstraintUpdateRequest();
	   	ipfDmlConstraintRequest.setId("1");
	   	ipfDmlConstraintRequest.setIpfDmlTableId("1");
	   	ipfDmlConstraintRequest.setConstraintName("1");
	   	ipfDmlConstraintRequest.setConstraintType("1");
	   	ipfDmlConstraintRequest.setColumnName("1");
	   	ipfDmlConstraintRequest.setForeignTableName("1");
	   	ipfDmlConstraintRequest.setForeignColumnName("1");
        CompositeResponse<IpfDmlConstraintUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintRequest, IpfDmlConstraintUpdateResponse.class, "ipfDmlConstraint.updateIpfDmlConstraint", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintUpdateResponse ipfDmlConstraintResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlConstraint(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintGetRequest ipfDmlConstraintRequest = new IpfDmlConstraintGetRequest();
	   	ipfDmlConstraintRequest.setId("1");
        CompositeResponse<IpfDmlConstraintGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintRequest, IpfDmlConstraintGetResponse.class, "ipfDmlConstraint.getIpfDmlConstraint", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintGetResponse ipfDmlConstraintResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintSelectAllRequest ipfDmlConstraintRequest = new IpfDmlConstraintSelectAllRequest();

        CompositeResponse<IpfDmlConstraintSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintRequest, IpfDmlConstraintSelectAllResponse.class, "ipfDmlConstraint.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintSelectAllResponse ipfDmlConstraintResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintCountAllRequest ipfDmlConstraintRequest = new IpfDmlConstraintCountAllRequest();

        CompositeResponse<IpfDmlConstraintCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintRequest, IpfDmlConstraintCountAllResponse.class, "ipfDmlConstraint.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintCountAllResponse ipfDmlConstraintResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlConstraintResponse.getResultString());
    }

    @Test
    public void selectIpfDmlConstraint(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintSelectRequest ipfDmlConstraintRequest = new IpfDmlConstraintSelectRequest();
	   	ipfDmlConstraintRequest.setId("1");
	   	ipfDmlConstraintRequest.setIpfDmlTableId("1");
	   	ipfDmlConstraintRequest.setConstraintName("1");
	   	ipfDmlConstraintRequest.setConstraintType("1");
	   	ipfDmlConstraintRequest.setColumnName("1");
	   	ipfDmlConstraintRequest.setForeignTableName("1");
	   	ipfDmlConstraintRequest.setForeignColumnName("1");
        CompositeResponse<IpfDmlConstraintCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintRequest, IpfDmlConstraintCreateResponse.class, "ipfDmlConstraint.createIpfDmlConstraint", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlConstraintRequest.setId("1");
	   	ipfDmlConstraintRequest.setIpfDmlTableId("1");
	   	ipfDmlConstraintRequest.setConstraintName("1");
	   	ipfDmlConstraintRequest.setConstraintType("1");
	   	ipfDmlConstraintRequest.setColumnName("1");
	   	ipfDmlConstraintRequest.setForeignTableName("1");
	   	ipfDmlConstraintRequest.setForeignColumnName("1");
        CompositeResponse<IpfDmlConstraintSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlConstraintRequest, IpfDmlConstraintSelectResponse.class, "ipfDmlConstraint.selectIpfDmlConstraint", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintSelectResponse ipfDmlConstraintResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlConstraintResponse.getResultJson());
        CompositeResponse<IpfDmlConstraintDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlConstraintRequest, IpfDmlConstraintDeleteResponse.class, "ipfDmlConstraint.deleteIpfDmlConstraint", "1.0");

    }
}
