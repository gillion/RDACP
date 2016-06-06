/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlIndexColumn;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlIndexColumn.request.*;
import com.cartan.center.ebs.ipfDmlIndexColumn.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlIndexColumnServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlIndexColumnServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexColumnGetSessionRequest ipfDmlIndexColumnRequest = new IpfDmlIndexColumnGetSessionRequest();
     	CompositeResponse<IpfDmlIndexColumnGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlIndexColumnRequest, IpfDmlIndexColumnGetSessionResponse.class, "ipfDmlIndexColumn.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlIndexColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexColumnCreateRequest ipfDmlIndexColumnRequest = new IpfDmlIndexColumnCreateRequest();
	   	ipfDmlIndexColumnRequest.setId("1");
	   	ipfDmlIndexColumnRequest.setIpfDmlIndexId("1");
	   	ipfDmlIndexColumnRequest.setColumnName("1");
	   	ipfDmlIndexColumnRequest.setIndexOption("1");
        CompositeResponse<IpfDmlIndexColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexColumnRequest, IpfDmlIndexColumnCreateResponse.class, "ipfDmlIndexColumn.createIpfDmlIndexColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexColumnCreateResponse ipfDmlIndexColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlIndexColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexColumnDeleteRequest ipfDmlIndexColumnRequest = new IpfDmlIndexColumnDeleteRequest();
	   	ipfDmlIndexColumnRequest.setId("1");
        CompositeResponse<IpfDmlIndexColumnDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexColumnRequest, IpfDmlIndexColumnDeleteResponse.class, "ipfDmlIndexColumn.deleteIpfDmlIndexColumn", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexColumnDeleteResponse ipfDmlIndexColumnResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlIndexColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexColumnUpdateRequest ipfDmlIndexColumnRequest = new IpfDmlIndexColumnUpdateRequest();
	   	ipfDmlIndexColumnRequest.setId("1");
	   	ipfDmlIndexColumnRequest.setIpfDmlIndexId("1");
	   	ipfDmlIndexColumnRequest.setColumnName("1");
	   	ipfDmlIndexColumnRequest.setIndexOption("1");
        CompositeResponse<IpfDmlIndexColumnUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexColumnRequest, IpfDmlIndexColumnUpdateResponse.class, "ipfDmlIndexColumn.updateIpfDmlIndexColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexColumnUpdateResponse ipfDmlIndexColumnResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlIndexColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexColumnGetRequest ipfDmlIndexColumnRequest = new IpfDmlIndexColumnGetRequest();
	   	ipfDmlIndexColumnRequest.setId("1");
        CompositeResponse<IpfDmlIndexColumnGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexColumnRequest, IpfDmlIndexColumnGetResponse.class, "ipfDmlIndexColumn.getIpfDmlIndexColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexColumnGetResponse ipfDmlIndexColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexColumnSelectAllRequest ipfDmlIndexColumnRequest = new IpfDmlIndexColumnSelectAllRequest();

        CompositeResponse<IpfDmlIndexColumnSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexColumnRequest, IpfDmlIndexColumnSelectAllResponse.class, "ipfDmlIndexColumn.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexColumnSelectAllResponse ipfDmlIndexColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexColumnCountAllRequest ipfDmlIndexColumnRequest = new IpfDmlIndexColumnCountAllRequest();

        CompositeResponse<IpfDmlIndexColumnCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexColumnRequest, IpfDmlIndexColumnCountAllResponse.class, "ipfDmlIndexColumn.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexColumnCountAllResponse ipfDmlIndexColumnResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlIndexColumnResponse.getResultString());
    }

    @Test
    public void selectIpfDmlIndexColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlIndexColumnSelectRequest ipfDmlIndexColumnRequest = new IpfDmlIndexColumnSelectRequest();
	   	ipfDmlIndexColumnRequest.setId("1");
	   	ipfDmlIndexColumnRequest.setIpfDmlIndexId("1");
	   	ipfDmlIndexColumnRequest.setColumnName("1");
	   	ipfDmlIndexColumnRequest.setIndexOption("1");
        CompositeResponse<IpfDmlIndexColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlIndexColumnRequest, IpfDmlIndexColumnCreateResponse.class, "ipfDmlIndexColumn.createIpfDmlIndexColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlIndexColumnRequest.setId("1");
	   	ipfDmlIndexColumnRequest.setIpfDmlIndexId("1");
	   	ipfDmlIndexColumnRequest.setColumnName("1");
	   	ipfDmlIndexColumnRequest.setIndexOption("1");
        CompositeResponse<IpfDmlIndexColumnSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlIndexColumnRequest, IpfDmlIndexColumnSelectResponse.class, "ipfDmlIndexColumn.selectIpfDmlIndexColumn", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlIndexColumnSelectResponse ipfDmlIndexColumnResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlIndexColumnResponse.getResultJson());
        CompositeResponse<IpfDmlIndexColumnDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlIndexColumnRequest, IpfDmlIndexColumnDeleteResponse.class, "ipfDmlIndexColumn.deleteIpfDmlIndexColumn", "1.0");

    }
}
