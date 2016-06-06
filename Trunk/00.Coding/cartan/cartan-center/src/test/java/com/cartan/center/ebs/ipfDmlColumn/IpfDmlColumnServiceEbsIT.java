/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlColumn;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlColumn.request.*;
import com.cartan.center.ebs.ipfDmlColumn.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlColumnServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlColumnServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlColumnGetSessionRequest ipfDmlColumnRequest = new IpfDmlColumnGetSessionRequest();
     	CompositeResponse<IpfDmlColumnGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlColumnRequest, IpfDmlColumnGetSessionResponse.class, "ipfDmlColumn.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlColumnCreateRequest ipfDmlColumnRequest = new IpfDmlColumnCreateRequest();
	   	ipfDmlColumnRequest.setId("1");
	   	ipfDmlColumnRequest.setIpfDmlTableId("1");
	   	ipfDmlColumnRequest.setColumnName("1");
	   	ipfDmlColumnRequest.setIpfDmlElementId("1");
	   	ipfDmlColumnRequest.setElementCode("1");
	   	ipfDmlColumnRequest.setFieldText("1");
	   	ipfDmlColumnRequest.setDataType("1");
	   	ipfDmlColumnRequest.setFieldLength("1");
	   	ipfDmlColumnRequest.setDecimals("1");
	   	ipfDmlColumnRequest.setIsNotNull("1");
	   	ipfDmlColumnRequest.setIsPrimaryKey("1");
	   	ipfDmlColumnRequest.setDefaultValue("1");
	   	ipfDmlColumnRequest.setInitValue("1");
        CompositeResponse<IpfDmlColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlColumnRequest, IpfDmlColumnCreateResponse.class, "ipfDmlColumn.createIpfDmlColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlColumnCreateResponse ipfDmlColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlColumnDeleteRequest ipfDmlColumnRequest = new IpfDmlColumnDeleteRequest();
	   	ipfDmlColumnRequest.setId("1");
        CompositeResponse<IpfDmlColumnDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlColumnRequest, IpfDmlColumnDeleteResponse.class, "ipfDmlColumn.deleteIpfDmlColumn", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlColumnDeleteResponse ipfDmlColumnResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlColumnUpdateRequest ipfDmlColumnRequest = new IpfDmlColumnUpdateRequest();
	   	ipfDmlColumnRequest.setId("1");
	   	ipfDmlColumnRequest.setIpfDmlTableId("1");
	   	ipfDmlColumnRequest.setColumnName("1");
	   	ipfDmlColumnRequest.setIpfDmlElementId("1");
	   	ipfDmlColumnRequest.setElementCode("1");
	   	ipfDmlColumnRequest.setFieldText("1");
	   	ipfDmlColumnRequest.setDataType("1");
	   	ipfDmlColumnRequest.setFieldLength("1");
	   	ipfDmlColumnRequest.setDecimals("1");
	   	ipfDmlColumnRequest.setIsNotNull("1");
	   	ipfDmlColumnRequest.setIsPrimaryKey("1");
	   	ipfDmlColumnRequest.setDefaultValue("1");
	   	ipfDmlColumnRequest.setInitValue("1");
        CompositeResponse<IpfDmlColumnUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlColumnRequest, IpfDmlColumnUpdateResponse.class, "ipfDmlColumn.updateIpfDmlColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlColumnUpdateResponse ipfDmlColumnResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlColumnGetRequest ipfDmlColumnRequest = new IpfDmlColumnGetRequest();
	   	ipfDmlColumnRequest.setId("1");
        CompositeResponse<IpfDmlColumnGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlColumnRequest, IpfDmlColumnGetResponse.class, "ipfDmlColumn.getIpfDmlColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlColumnGetResponse ipfDmlColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlColumnSelectAllRequest ipfDmlColumnRequest = new IpfDmlColumnSelectAllRequest();

        CompositeResponse<IpfDmlColumnSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlColumnRequest, IpfDmlColumnSelectAllResponse.class, "ipfDmlColumn.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlColumnSelectAllResponse ipfDmlColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlColumnCountAllRequest ipfDmlColumnRequest = new IpfDmlColumnCountAllRequest();

        CompositeResponse<IpfDmlColumnCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlColumnRequest, IpfDmlColumnCountAllResponse.class, "ipfDmlColumn.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlColumnCountAllResponse ipfDmlColumnResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlColumnResponse.getResultString());
    }

    @Test
    public void selectIpfDmlColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlColumnSelectRequest ipfDmlColumnRequest = new IpfDmlColumnSelectRequest();
	   	ipfDmlColumnRequest.setId("1");
	   	ipfDmlColumnRequest.setIpfDmlTableId("1");
	   	ipfDmlColumnRequest.setColumnName("1");
	   	ipfDmlColumnRequest.setIpfDmlElementId("1");
	   	ipfDmlColumnRequest.setElementCode("1");
	   	ipfDmlColumnRequest.setFieldText("1");
	   	ipfDmlColumnRequest.setDataType("1");
	   	ipfDmlColumnRequest.setFieldLength("1");
	   	ipfDmlColumnRequest.setDecimals("1");
	   	ipfDmlColumnRequest.setIsNotNull("1");
	   	ipfDmlColumnRequest.setIsPrimaryKey("1");
	   	ipfDmlColumnRequest.setDefaultValue("1");
	   	ipfDmlColumnRequest.setInitValue("1");
        CompositeResponse<IpfDmlColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlColumnRequest, IpfDmlColumnCreateResponse.class, "ipfDmlColumn.createIpfDmlColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlColumnRequest.setId("1");
	   	ipfDmlColumnRequest.setIpfDmlTableId("1");
	   	ipfDmlColumnRequest.setColumnName("1");
	   	ipfDmlColumnRequest.setIpfDmlElementId("1");
	   	ipfDmlColumnRequest.setElementCode("1");
	   	ipfDmlColumnRequest.setFieldText("1");
	   	ipfDmlColumnRequest.setDataType("1");
	   	ipfDmlColumnRequest.setFieldLength("1");
	   	ipfDmlColumnRequest.setDecimals("1");
	   	ipfDmlColumnRequest.setIsNotNull("1");
	   	ipfDmlColumnRequest.setIsPrimaryKey("1");
	   	ipfDmlColumnRequest.setDefaultValue("1");
	   	ipfDmlColumnRequest.setInitValue("1");
        CompositeResponse<IpfDmlColumnSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlColumnRequest, IpfDmlColumnSelectResponse.class, "ipfDmlColumn.selectIpfDmlColumn", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlColumnSelectResponse ipfDmlColumnResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlColumnResponse.getResultJson());
        CompositeResponse<IpfDmlColumnDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlColumnRequest, IpfDmlColumnDeleteResponse.class, "ipfDmlColumn.deleteIpfDmlColumn", "1.0");

    }
}
