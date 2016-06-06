/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlConstraintColumn;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlConstraintColumn.request.*;
import com.cartan.center.ebs.ipfDmlConstraintColumn.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlConstraintColumnServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlConstraintColumnServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintColumnGetSessionRequest ipfDmlConstraintColumnRequest = new IpfDmlConstraintColumnGetSessionRequest();
     	CompositeResponse<IpfDmlConstraintColumnGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlConstraintColumnRequest, IpfDmlConstraintColumnGetSessionResponse.class, "ipfDmlConstraintColumn.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlConstraintColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintColumnCreateRequest ipfDmlConstraintColumnRequest = new IpfDmlConstraintColumnCreateRequest();
	   	ipfDmlConstraintColumnRequest.setId("1");
	   	ipfDmlConstraintColumnRequest.setIpfDmlConstraintId("1");
	   	ipfDmlConstraintColumnRequest.setColumnName("1");
        CompositeResponse<IpfDmlConstraintColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintColumnRequest, IpfDmlConstraintColumnCreateResponse.class, "ipfDmlConstraintColumn.createIpfDmlConstraintColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintColumnCreateResponse ipfDmlConstraintColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlConstraintColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintColumnDeleteRequest ipfDmlConstraintColumnRequest = new IpfDmlConstraintColumnDeleteRequest();
	   	ipfDmlConstraintColumnRequest.setId("1");
        CompositeResponse<IpfDmlConstraintColumnDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintColumnRequest, IpfDmlConstraintColumnDeleteResponse.class, "ipfDmlConstraintColumn.deleteIpfDmlConstraintColumn", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintColumnDeleteResponse ipfDmlConstraintColumnResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlConstraintColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintColumnUpdateRequest ipfDmlConstraintColumnRequest = new IpfDmlConstraintColumnUpdateRequest();
	   	ipfDmlConstraintColumnRequest.setId("1");
	   	ipfDmlConstraintColumnRequest.setIpfDmlConstraintId("1");
	   	ipfDmlConstraintColumnRequest.setColumnName("1");
        CompositeResponse<IpfDmlConstraintColumnUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintColumnRequest, IpfDmlConstraintColumnUpdateResponse.class, "ipfDmlConstraintColumn.updateIpfDmlConstraintColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintColumnUpdateResponse ipfDmlConstraintColumnResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlConstraintColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintColumnGetRequest ipfDmlConstraintColumnRequest = new IpfDmlConstraintColumnGetRequest();
	   	ipfDmlConstraintColumnRequest.setId("1");
        CompositeResponse<IpfDmlConstraintColumnGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintColumnRequest, IpfDmlConstraintColumnGetResponse.class, "ipfDmlConstraintColumn.getIpfDmlConstraintColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintColumnGetResponse ipfDmlConstraintColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintColumnSelectAllRequest ipfDmlConstraintColumnRequest = new IpfDmlConstraintColumnSelectAllRequest();

        CompositeResponse<IpfDmlConstraintColumnSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintColumnRequest, IpfDmlConstraintColumnSelectAllResponse.class, "ipfDmlConstraintColumn.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintColumnSelectAllResponse ipfDmlConstraintColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintColumnCountAllRequest ipfDmlConstraintColumnRequest = new IpfDmlConstraintColumnCountAllRequest();

        CompositeResponse<IpfDmlConstraintColumnCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintColumnRequest, IpfDmlConstraintColumnCountAllResponse.class, "ipfDmlConstraintColumn.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintColumnCountAllResponse ipfDmlConstraintColumnResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlConstraintColumnResponse.getResultString());
    }

    @Test
    public void selectIpfDmlConstraintColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlConstraintColumnSelectRequest ipfDmlConstraintColumnRequest = new IpfDmlConstraintColumnSelectRequest();
	   	ipfDmlConstraintColumnRequest.setId("1");
	   	ipfDmlConstraintColumnRequest.setIpfDmlConstraintId("1");
	   	ipfDmlConstraintColumnRequest.setColumnName("1");
        CompositeResponse<IpfDmlConstraintColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlConstraintColumnRequest, IpfDmlConstraintColumnCreateResponse.class, "ipfDmlConstraintColumn.createIpfDmlConstraintColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlConstraintColumnRequest.setId("1");
	   	ipfDmlConstraintColumnRequest.setIpfDmlConstraintId("1");
	   	ipfDmlConstraintColumnRequest.setColumnName("1");
        CompositeResponse<IpfDmlConstraintColumnSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlConstraintColumnRequest, IpfDmlConstraintColumnSelectResponse.class, "ipfDmlConstraintColumn.selectIpfDmlConstraintColumn", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlConstraintColumnSelectResponse ipfDmlConstraintColumnResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlConstraintColumnResponse.getResultJson());
        CompositeResponse<IpfDmlConstraintColumnDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlConstraintColumnRequest, IpfDmlConstraintColumnDeleteResponse.class, "ipfDmlConstraintColumn.deleteIpfDmlConstraintColumn", "1.0");

    }
}
