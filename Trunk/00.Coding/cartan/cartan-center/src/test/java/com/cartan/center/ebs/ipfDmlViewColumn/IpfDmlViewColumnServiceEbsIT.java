/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlViewColumn;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlViewColumn.request.*;
import com.cartan.center.ebs.ipfDmlViewColumn.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlViewColumnServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlViewColumnServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewColumnGetSessionRequest ipfDmlViewColumnRequest = new IpfDmlViewColumnGetSessionRequest();
     	CompositeResponse<IpfDmlViewColumnGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlViewColumnRequest, IpfDmlViewColumnGetSessionResponse.class, "ipfDmlViewColumn.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlViewColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewColumnCreateRequest ipfDmlViewColumnRequest = new IpfDmlViewColumnCreateRequest();
	   	ipfDmlViewColumnRequest.setId("1");
	   	ipfDmlViewColumnRequest.setIpfDmlViewId("1");
	   	ipfDmlViewColumnRequest.setColumnName("1");
	   	ipfDmlViewColumnRequest.setFieldText("1");
	   	ipfDmlViewColumnRequest.setDataType("1");
	   	ipfDmlViewColumnRequest.setFieldLength("1");
	   	ipfDmlViewColumnRequest.setDecimals("1");
	   	ipfDmlViewColumnRequest.setIsNotNull("1");
	   	ipfDmlViewColumnRequest.setIsPrimaryKey("1");
        CompositeResponse<IpfDmlViewColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewColumnRequest, IpfDmlViewColumnCreateResponse.class, "ipfDmlViewColumn.createIpfDmlViewColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewColumnCreateResponse ipfDmlViewColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlViewColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewColumnDeleteRequest ipfDmlViewColumnRequest = new IpfDmlViewColumnDeleteRequest();
	   	ipfDmlViewColumnRequest.setId("1");
        CompositeResponse<IpfDmlViewColumnDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewColumnRequest, IpfDmlViewColumnDeleteResponse.class, "ipfDmlViewColumn.deleteIpfDmlViewColumn", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewColumnDeleteResponse ipfDmlViewColumnResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlViewColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewColumnUpdateRequest ipfDmlViewColumnRequest = new IpfDmlViewColumnUpdateRequest();
	   	ipfDmlViewColumnRequest.setId("1");
	   	ipfDmlViewColumnRequest.setIpfDmlViewId("1");
	   	ipfDmlViewColumnRequest.setColumnName("1");
	   	ipfDmlViewColumnRequest.setFieldText("1");
	   	ipfDmlViewColumnRequest.setDataType("1");
	   	ipfDmlViewColumnRequest.setFieldLength("1");
	   	ipfDmlViewColumnRequest.setDecimals("1");
	   	ipfDmlViewColumnRequest.setIsNotNull("1");
	   	ipfDmlViewColumnRequest.setIsPrimaryKey("1");
        CompositeResponse<IpfDmlViewColumnUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewColumnRequest, IpfDmlViewColumnUpdateResponse.class, "ipfDmlViewColumn.updateIpfDmlViewColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewColumnUpdateResponse ipfDmlViewColumnResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlViewColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewColumnGetRequest ipfDmlViewColumnRequest = new IpfDmlViewColumnGetRequest();
	   	ipfDmlViewColumnRequest.setId("1");
        CompositeResponse<IpfDmlViewColumnGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewColumnRequest, IpfDmlViewColumnGetResponse.class, "ipfDmlViewColumn.getIpfDmlViewColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewColumnGetResponse ipfDmlViewColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewColumnSelectAllRequest ipfDmlViewColumnRequest = new IpfDmlViewColumnSelectAllRequest();

        CompositeResponse<IpfDmlViewColumnSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewColumnRequest, IpfDmlViewColumnSelectAllResponse.class, "ipfDmlViewColumn.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewColumnSelectAllResponse ipfDmlViewColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewColumnCountAllRequest ipfDmlViewColumnRequest = new IpfDmlViewColumnCountAllRequest();

        CompositeResponse<IpfDmlViewColumnCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewColumnRequest, IpfDmlViewColumnCountAllResponse.class, "ipfDmlViewColumn.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewColumnCountAllResponse ipfDmlViewColumnResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlViewColumnResponse.getResultString());
    }

    @Test
    public void selectIpfDmlViewColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewColumnSelectRequest ipfDmlViewColumnRequest = new IpfDmlViewColumnSelectRequest();
	   	ipfDmlViewColumnRequest.setId("1");
	   	ipfDmlViewColumnRequest.setIpfDmlViewId("1");
	   	ipfDmlViewColumnRequest.setColumnName("1");
	   	ipfDmlViewColumnRequest.setFieldText("1");
	   	ipfDmlViewColumnRequest.setDataType("1");
	   	ipfDmlViewColumnRequest.setFieldLength("1");
	   	ipfDmlViewColumnRequest.setDecimals("1");
	   	ipfDmlViewColumnRequest.setIsNotNull("1");
	   	ipfDmlViewColumnRequest.setIsPrimaryKey("1");
        CompositeResponse<IpfDmlViewColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewColumnRequest, IpfDmlViewColumnCreateResponse.class, "ipfDmlViewColumn.createIpfDmlViewColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlViewColumnRequest.setId("1");
	   	ipfDmlViewColumnRequest.setIpfDmlViewId("1");
	   	ipfDmlViewColumnRequest.setColumnName("1");
	   	ipfDmlViewColumnRequest.setFieldText("1");
	   	ipfDmlViewColumnRequest.setDataType("1");
	   	ipfDmlViewColumnRequest.setFieldLength("1");
	   	ipfDmlViewColumnRequest.setDecimals("1");
	   	ipfDmlViewColumnRequest.setIsNotNull("1");
	   	ipfDmlViewColumnRequest.setIsPrimaryKey("1");
        CompositeResponse<IpfDmlViewColumnSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlViewColumnRequest, IpfDmlViewColumnSelectResponse.class, "ipfDmlViewColumn.selectIpfDmlViewColumn", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewColumnSelectResponse ipfDmlViewColumnResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlViewColumnResponse.getResultJson());
        CompositeResponse<IpfDmlViewColumnDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlViewColumnRequest, IpfDmlViewColumnDeleteResponse.class, "ipfDmlViewColumn.deleteIpfDmlViewColumn", "1.0");

    }
}
