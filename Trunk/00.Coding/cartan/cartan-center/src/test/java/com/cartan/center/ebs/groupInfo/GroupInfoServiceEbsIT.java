/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.groupInfo;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.groupInfo.request.*;
import com.cartan.center.ebs.groupInfo.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class GroupInfoServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(GroupInfoServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupInfoGetSessionRequest groupInfoRequest = new GroupInfoGetSessionRequest();
     	CompositeResponse<GroupInfoGetSessionResponse> response =
                 ropClient.buildClientRequest().get(groupInfoRequest, GroupInfoGetSessionResponse.class, "groupInfo.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createGroupInfo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupInfoCreateRequest groupInfoRequest = new GroupInfoCreateRequest();
	   	groupInfoRequest.setId("1");
	   	groupInfoRequest.setType("1");
	   	groupInfoRequest.setName("1");
	   	groupInfoRequest.setCreatetime("1");
	   	groupInfoRequest.setCreator("1");
	   	groupInfoRequest.setMemoinfo("1");
        CompositeResponse<GroupInfoCreateResponse> response =
                ropClient.buildClientRequest().get(groupInfoRequest, GroupInfoCreateResponse.class, "groupInfo.createGroupInfo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupInfoCreateResponse groupInfoResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteGroupInfo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupInfoDeleteRequest groupInfoRequest = new GroupInfoDeleteRequest();
	   	groupInfoRequest.setId("1");
        CompositeResponse<GroupInfoDeleteResponse> response =
                ropClient.buildClientRequest().get(groupInfoRequest, GroupInfoDeleteResponse.class, "groupInfo.deleteGroupInfo", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupInfoDeleteResponse groupInfoResponse = response.getSuccessResponse();
    }




    @Test
    public void updateGroupInfo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupInfoUpdateRequest groupInfoRequest = new GroupInfoUpdateRequest();
	   	groupInfoRequest.setId("1");
	   	groupInfoRequest.setType("1");
	   	groupInfoRequest.setName("1");
	   	groupInfoRequest.setCreatetime("1");
	   	groupInfoRequest.setCreator("1");
	   	groupInfoRequest.setMemoinfo("1");
        CompositeResponse<GroupInfoUpdateResponse> response =
                ropClient.buildClientRequest().get(groupInfoRequest, GroupInfoUpdateResponse.class, "groupInfo.updateGroupInfo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupInfoUpdateResponse groupInfoResponse = response.getSuccessResponse();
    }


    @Test
    public void getGroupInfo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupInfoGetRequest groupInfoRequest = new GroupInfoGetRequest();
	   	groupInfoRequest.setId("1");
        CompositeResponse<GroupInfoGetResponse> response =
                ropClient.buildClientRequest().get(groupInfoRequest, GroupInfoGetResponse.class, "groupInfo.getGroupInfo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupInfoGetResponse groupInfoResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupInfoSelectAllRequest groupInfoRequest = new GroupInfoSelectAllRequest();

        CompositeResponse<GroupInfoSelectAllResponse> response =
                ropClient.buildClientRequest().get(groupInfoRequest, GroupInfoSelectAllResponse.class, "groupInfo.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupInfoSelectAllResponse groupInfoResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupInfoCountAllRequest groupInfoRequest = new GroupInfoCountAllRequest();

        CompositeResponse<GroupInfoCountAllResponse> response =
                ropClient.buildClientRequest().get(groupInfoRequest, GroupInfoCountAllResponse.class, "groupInfo.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupInfoCountAllResponse groupInfoResponse = response.getSuccessResponse();
        Assert.assertNotNull(groupInfoResponse.getResultString());
    }

    @Test
    public void selectGroupInfo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupInfoSelectRequest groupInfoRequest = new GroupInfoSelectRequest();
	   	groupInfoRequest.setId("1");
	   	groupInfoRequest.setType("1");
	   	groupInfoRequest.setName("1");
	   	groupInfoRequest.setCreatetime("1");
	   	groupInfoRequest.setCreator("1");
	   	groupInfoRequest.setMemoinfo("1");
        CompositeResponse<GroupInfoCreateResponse> response =
                ropClient.buildClientRequest().get(groupInfoRequest, GroupInfoCreateResponse.class, "groupInfo.createGroupInfo", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	groupInfoRequest.setId("1");
	   	groupInfoRequest.setType("1");
	   	groupInfoRequest.setName("1");
	   	groupInfoRequest.setCreatetime("1");
	   	groupInfoRequest.setCreator("1");
	   	groupInfoRequest.setMemoinfo("1");
        CompositeResponse<GroupInfoSelectResponse> response1 =
                ropClient.buildClientRequest().get(groupInfoRequest, GroupInfoSelectResponse.class, "groupInfo.selectGroupInfo", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupInfoSelectResponse groupInfoResponse = response1.getSuccessResponse();
        Assert.assertNotNull(groupInfoResponse.getResultJson());
        CompositeResponse<GroupInfoDeleteResponse> response2 =
                ropClient.buildClientRequest().get(groupInfoRequest, GroupInfoDeleteResponse.class, "groupInfo.deleteGroupInfo", "1.0");

    }
}
