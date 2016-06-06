/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoCheckRelGroup;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoCheckRelGroup.request.*;
import com.cartan.center.ebs.ipfCcmBoCheckRelGroup.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoCheckRelGroupServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoCheckRelGroupServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckRelGroupGetSessionRequest ipfCcmBoCheckRelGroupRequest = new IpfCcmBoCheckRelGroupGetSessionRequest();
     	CompositeResponse<IpfCcmBoCheckRelGroupGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoCheckRelGroupRequest, IpfCcmBoCheckRelGroupGetSessionResponse.class, "ipfCcmBoCheckRelGroup.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoCheckRelGroup(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckRelGroupCreateRequest ipfCcmBoCheckRelGroupRequest = new IpfCcmBoCheckRelGroupCreateRequest();
	   	ipfCcmBoCheckRelGroupRequest.setId("1");
	   	ipfCcmBoCheckRelGroupRequest.setIpfCcmBoCheckId("1");
	   	ipfCcmBoCheckRelGroupRequest.setGroupName("1");
	   	ipfCcmBoCheckRelGroupRequest.setGroupDesc("1");
        CompositeResponse<IpfCcmBoCheckRelGroupCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRelGroupRequest, IpfCcmBoCheckRelGroupCreateResponse.class, "ipfCcmBoCheckRelGroup.createIpfCcmBoCheckRelGroup", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckRelGroupCreateResponse ipfCcmBoCheckRelGroupResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoCheckRelGroup(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckRelGroupDeleteRequest ipfCcmBoCheckRelGroupRequest = new IpfCcmBoCheckRelGroupDeleteRequest();
	   	ipfCcmBoCheckRelGroupRequest.setId("1");
        CompositeResponse<IpfCcmBoCheckRelGroupDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRelGroupRequest, IpfCcmBoCheckRelGroupDeleteResponse.class, "ipfCcmBoCheckRelGroup.deleteIpfCcmBoCheckRelGroup", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckRelGroupDeleteResponse ipfCcmBoCheckRelGroupResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoCheckRelGroup(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckRelGroupUpdateRequest ipfCcmBoCheckRelGroupRequest = new IpfCcmBoCheckRelGroupUpdateRequest();
	   	ipfCcmBoCheckRelGroupRequest.setId("1");
	   	ipfCcmBoCheckRelGroupRequest.setIpfCcmBoCheckId("1");
	   	ipfCcmBoCheckRelGroupRequest.setGroupName("1");
	   	ipfCcmBoCheckRelGroupRequest.setGroupDesc("1");
        CompositeResponse<IpfCcmBoCheckRelGroupUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRelGroupRequest, IpfCcmBoCheckRelGroupUpdateResponse.class, "ipfCcmBoCheckRelGroup.updateIpfCcmBoCheckRelGroup", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckRelGroupUpdateResponse ipfCcmBoCheckRelGroupResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoCheckRelGroup(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckRelGroupGetRequest ipfCcmBoCheckRelGroupRequest = new IpfCcmBoCheckRelGroupGetRequest();
	   	ipfCcmBoCheckRelGroupRequest.setId("1");
        CompositeResponse<IpfCcmBoCheckRelGroupGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRelGroupRequest, IpfCcmBoCheckRelGroupGetResponse.class, "ipfCcmBoCheckRelGroup.getIpfCcmBoCheckRelGroup", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckRelGroupGetResponse ipfCcmBoCheckRelGroupResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckRelGroupSelectAllRequest ipfCcmBoCheckRelGroupRequest = new IpfCcmBoCheckRelGroupSelectAllRequest();

        CompositeResponse<IpfCcmBoCheckRelGroupSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRelGroupRequest, IpfCcmBoCheckRelGroupSelectAllResponse.class, "ipfCcmBoCheckRelGroup.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckRelGroupSelectAllResponse ipfCcmBoCheckRelGroupResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckRelGroupCountAllRequest ipfCcmBoCheckRelGroupRequest = new IpfCcmBoCheckRelGroupCountAllRequest();

        CompositeResponse<IpfCcmBoCheckRelGroupCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRelGroupRequest, IpfCcmBoCheckRelGroupCountAllResponse.class, "ipfCcmBoCheckRelGroup.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckRelGroupCountAllResponse ipfCcmBoCheckRelGroupResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoCheckRelGroupResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoCheckRelGroup(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCheckRelGroupSelectRequest ipfCcmBoCheckRelGroupRequest = new IpfCcmBoCheckRelGroupSelectRequest();
	   	ipfCcmBoCheckRelGroupRequest.setId("1");
	   	ipfCcmBoCheckRelGroupRequest.setIpfCcmBoCheckId("1");
	   	ipfCcmBoCheckRelGroupRequest.setGroupName("1");
	   	ipfCcmBoCheckRelGroupRequest.setGroupDesc("1");
        CompositeResponse<IpfCcmBoCheckRelGroupCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRelGroupRequest, IpfCcmBoCheckRelGroupCreateResponse.class, "ipfCcmBoCheckRelGroup.createIpfCcmBoCheckRelGroup", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoCheckRelGroupRequest.setId("1");
	   	ipfCcmBoCheckRelGroupRequest.setIpfCcmBoCheckId("1");
	   	ipfCcmBoCheckRelGroupRequest.setGroupName("1");
	   	ipfCcmBoCheckRelGroupRequest.setGroupDesc("1");
        CompositeResponse<IpfCcmBoCheckRelGroupSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRelGroupRequest, IpfCcmBoCheckRelGroupSelectResponse.class, "ipfCcmBoCheckRelGroup.selectIpfCcmBoCheckRelGroup", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCheckRelGroupSelectResponse ipfCcmBoCheckRelGroupResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoCheckRelGroupResponse.getResultJson());
        CompositeResponse<IpfCcmBoCheckRelGroupDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoCheckRelGroupRequest, IpfCcmBoCheckRelGroupDeleteResponse.class, "ipfCcmBoCheckRelGroup.deleteIpfCcmBoCheckRelGroup", "1.0");

    }
}
