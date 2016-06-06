/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoCheckGroup;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoCheckGroup.request.*;
import com.cartan.center.ebs.ipfCcmBoCheckGroup.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoCheckGroupServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoCheckGroupServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckGroupGetSessionRequest ipfCcmBoCheckGroupRequest = new IpfCcmBoCheckGroupGetSessionRequest();
     	CompositeResponse<IpfCcmBoCheckGroupGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoCheckGroupRequest, IpfCcmBoCheckGroupGetSessionResponse.class, "ipfCcmBoCheckGroup.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoCheckGroup(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckGroupCreateRequest ipfCcmBoCheckGroupRequest = new IpfCcmBoCheckGroupCreateRequest();
	   	ipfCcmBoCheckGroupRequest.setId("1");
	   	ipfCcmBoCheckGroupRequest.setIpfCcmBoId("1");
	   	ipfCcmBoCheckGroupRequest.setGroupName("1");
	   	ipfCcmBoCheckGroupRequest.setGroupDesc("1");
        CompositeResponse<IpfCcmBoCheckGroupCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckGroupRequest, IpfCcmBoCheckGroupCreateResponse.class, "ipfCcmBoCheckGroup.createIpfCcmBoCheckGroup", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckGroupCreateResponse ipfCcmBoCheckGroupResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoCheckGroup(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckGroupDeleteRequest ipfCcmBoCheckGroupRequest = new IpfCcmBoCheckGroupDeleteRequest();
	   	ipfCcmBoCheckGroupRequest.setId("1");
        CompositeResponse<IpfCcmBoCheckGroupDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckGroupRequest, IpfCcmBoCheckGroupDeleteResponse.class, "ipfCcmBoCheckGroup.deleteIpfCcmBoCheckGroup", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckGroupDeleteResponse ipfCcmBoCheckGroupResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoCheckGroup(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckGroupUpdateRequest ipfCcmBoCheckGroupRequest = new IpfCcmBoCheckGroupUpdateRequest();
	   	ipfCcmBoCheckGroupRequest.setId("1");
	   	ipfCcmBoCheckGroupRequest.setIpfCcmBoId("1");
	   	ipfCcmBoCheckGroupRequest.setGroupName("1");
	   	ipfCcmBoCheckGroupRequest.setGroupDesc("1");
        CompositeResponse<IpfCcmBoCheckGroupUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckGroupRequest, IpfCcmBoCheckGroupUpdateResponse.class, "ipfCcmBoCheckGroup.updateIpfCcmBoCheckGroup", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckGroupUpdateResponse ipfCcmBoCheckGroupResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoCheckGroup(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckGroupGetRequest ipfCcmBoCheckGroupRequest = new IpfCcmBoCheckGroupGetRequest();
	   	ipfCcmBoCheckGroupRequest.setId("1");
        CompositeResponse<IpfCcmBoCheckGroupGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckGroupRequest, IpfCcmBoCheckGroupGetResponse.class, "ipfCcmBoCheckGroup.getIpfCcmBoCheckGroup", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckGroupGetResponse ipfCcmBoCheckGroupResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckGroupSelectAllRequest ipfCcmBoCheckGroupRequest = new IpfCcmBoCheckGroupSelectAllRequest();

        CompositeResponse<IpfCcmBoCheckGroupSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckGroupRequest, IpfCcmBoCheckGroupSelectAllResponse.class, "ipfCcmBoCheckGroup.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckGroupSelectAllResponse ipfCcmBoCheckGroupResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckGroupCountAllRequest ipfCcmBoCheckGroupRequest = new IpfCcmBoCheckGroupCountAllRequest();

        CompositeResponse<IpfCcmBoCheckGroupCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckGroupRequest, IpfCcmBoCheckGroupCountAllResponse.class, "ipfCcmBoCheckGroup.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckGroupCountAllResponse ipfCcmBoCheckGroupResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoCheckGroupResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoCheckGroup(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckGroupSelectRequest ipfCcmBoCheckGroupRequest = new IpfCcmBoCheckGroupSelectRequest();
	   	ipfCcmBoCheckGroupRequest.setId("1");
	   	ipfCcmBoCheckGroupRequest.setIpfCcmBoId("1");
	   	ipfCcmBoCheckGroupRequest.setGroupName("1");
	   	ipfCcmBoCheckGroupRequest.setGroupDesc("1");
        CompositeResponse<IpfCcmBoCheckGroupCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckGroupRequest, IpfCcmBoCheckGroupCreateResponse.class, "ipfCcmBoCheckGroup.createIpfCcmBoCheckGroup", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoCheckGroupRequest.setId("1");
	   	ipfCcmBoCheckGroupRequest.setIpfCcmBoId("1");
	   	ipfCcmBoCheckGroupRequest.setGroupName("1");
	   	ipfCcmBoCheckGroupRequest.setGroupDesc("1");
        CompositeResponse<IpfCcmBoCheckGroupSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoCheckGroupRequest, IpfCcmBoCheckGroupSelectResponse.class, "ipfCcmBoCheckGroup.selectIpfCcmBoCheckGroup", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckGroupSelectResponse ipfCcmBoCheckGroupResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoCheckGroupResponse.getResultJson());
        CompositeResponse<IpfCcmBoCheckGroupDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoCheckGroupRequest, IpfCcmBoCheckGroupDeleteResponse.class, "ipfCcmBoCheckGroup.deleteIpfCcmBoCheckGroup", "1.0");

    }
}
