/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmShlp;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmShlp.request.*;
import com.cartan.center.ebs.ipfCcmShlp.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmShlpServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmShlpServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpGetSessionRequest ipfCcmShlpRequest = new IpfCcmShlpGetSessionRequest();
     	CompositeResponse<IpfCcmShlpGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmShlpRequest, IpfCcmShlpGetSessionResponse.class, "ipfCcmShlp.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmShlp(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpCreateRequest ipfCcmShlpRequest = new IpfCcmShlpCreateRequest();
	   	ipfCcmShlpRequest.setId("1");
	   	ipfCcmShlpRequest.setShlpName("1");
	   	ipfCcmShlpRequest.setShlpStatus("1");
	   	ipfCcmShlpRequest.setDataSource("1");
	   	ipfCcmShlpRequest.setDataSourceType("1");
	   	ipfCcmShlpRequest.setValueColumn("1");
	   	ipfCcmShlpRequest.setDisplayColumn("1");
	   	ipfCcmShlpRequest.setRuleNo("1");
        CompositeResponse<IpfCcmShlpCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpRequest, IpfCcmShlpCreateResponse.class, "ipfCcmShlp.createIpfCcmShlp", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpCreateResponse ipfCcmShlpResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmShlp(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpDeleteRequest ipfCcmShlpRequest = new IpfCcmShlpDeleteRequest();
	   	ipfCcmShlpRequest.setId("1");
        CompositeResponse<IpfCcmShlpDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpRequest, IpfCcmShlpDeleteResponse.class, "ipfCcmShlp.deleteIpfCcmShlp", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpDeleteResponse ipfCcmShlpResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmShlp(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpUpdateRequest ipfCcmShlpRequest = new IpfCcmShlpUpdateRequest();
	   	ipfCcmShlpRequest.setId("1");
	   	ipfCcmShlpRequest.setShlpName("1");
	   	ipfCcmShlpRequest.setShlpStatus("1");
	   	ipfCcmShlpRequest.setDataSource("1");
	   	ipfCcmShlpRequest.setDataSourceType("1");
	   	ipfCcmShlpRequest.setValueColumn("1");
	   	ipfCcmShlpRequest.setDisplayColumn("1");
	   	ipfCcmShlpRequest.setRuleNo("1");
        CompositeResponse<IpfCcmShlpUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpRequest, IpfCcmShlpUpdateResponse.class, "ipfCcmShlp.updateIpfCcmShlp", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpUpdateResponse ipfCcmShlpResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmShlp(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpGetRequest ipfCcmShlpRequest = new IpfCcmShlpGetRequest();
	   	ipfCcmShlpRequest.setId("1");
        CompositeResponse<IpfCcmShlpGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpRequest, IpfCcmShlpGetResponse.class, "ipfCcmShlp.getIpfCcmShlp", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpGetResponse ipfCcmShlpResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpSelectAllRequest ipfCcmShlpRequest = new IpfCcmShlpSelectAllRequest();

        CompositeResponse<IpfCcmShlpSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpRequest, IpfCcmShlpSelectAllResponse.class, "ipfCcmShlp.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpSelectAllResponse ipfCcmShlpResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpCountAllRequest ipfCcmShlpRequest = new IpfCcmShlpCountAllRequest();

        CompositeResponse<IpfCcmShlpCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpRequest, IpfCcmShlpCountAllResponse.class, "ipfCcmShlp.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpCountAllResponse ipfCcmShlpResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmShlpResponse.getResultString());
    }

    @Test
    public void selectIpfCcmShlp(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpSelectRequest ipfCcmShlpRequest = new IpfCcmShlpSelectRequest();
	   	ipfCcmShlpRequest.setId("1");
	   	ipfCcmShlpRequest.setShlpName("1");
	   	ipfCcmShlpRequest.setShlpStatus("1");
	   	ipfCcmShlpRequest.setDataSource("1");
	   	ipfCcmShlpRequest.setDataSourceType("1");
	   	ipfCcmShlpRequest.setValueColumn("1");
	   	ipfCcmShlpRequest.setDisplayColumn("1");
	   	ipfCcmShlpRequest.setRuleNo("1");
        CompositeResponse<IpfCcmShlpCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpRequest, IpfCcmShlpCreateResponse.class, "ipfCcmShlp.createIpfCcmShlp", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmShlpRequest.setId("1");
	   	ipfCcmShlpRequest.setShlpName("1");
	   	ipfCcmShlpRequest.setShlpStatus("1");
	   	ipfCcmShlpRequest.setDataSource("1");
	   	ipfCcmShlpRequest.setDataSourceType("1");
	   	ipfCcmShlpRequest.setValueColumn("1");
	   	ipfCcmShlpRequest.setDisplayColumn("1");
	   	ipfCcmShlpRequest.setRuleNo("1");
        CompositeResponse<IpfCcmShlpSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmShlpRequest, IpfCcmShlpSelectResponse.class, "ipfCcmShlp.selectIpfCcmShlp", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpSelectResponse ipfCcmShlpResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmShlpResponse.getResultJson());
        CompositeResponse<IpfCcmShlpDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmShlpRequest, IpfCcmShlpDeleteResponse.class, "ipfCcmShlp.deleteIpfCcmShlp", "1.0");

    }
}
