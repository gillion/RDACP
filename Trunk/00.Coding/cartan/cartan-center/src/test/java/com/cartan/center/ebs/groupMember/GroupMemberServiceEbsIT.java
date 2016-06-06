/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.groupMember;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.groupMember.request.*;
import com.cartan.center.ebs.groupMember.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class GroupMemberServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(GroupMemberServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupMemberGetSessionRequest groupMemberRequest = new GroupMemberGetSessionRequest();
     	CompositeResponse<GroupMemberGetSessionResponse> response =
                 ropClient.buildClientRequest().get(groupMemberRequest, GroupMemberGetSessionResponse.class, "groupMember.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createGroupMember(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupMemberCreateRequest groupMemberRequest = new GroupMemberCreateRequest();
	   	groupMemberRequest.setId("1");
	   	groupMemberRequest.setUser("1");
	   	groupMemberRequest.setGroupInfoId("1");
	   	groupMemberRequest.setArea("1");
	   	groupMemberRequest.setName("1");
	   	groupMemberRequest.setTel("1");
	   	groupMemberRequest.setUnit("1");
	   	groupMemberRequest.setAddr("1");
        CompositeResponse<GroupMemberCreateResponse> response =
                ropClient.buildClientRequest().get(groupMemberRequest, GroupMemberCreateResponse.class, "groupMember.createGroupMember", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupMemberCreateResponse groupMemberResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteGroupMember(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupMemberDeleteRequest groupMemberRequest = new GroupMemberDeleteRequest();
	   	groupMemberRequest.setId("1");
        CompositeResponse<GroupMemberDeleteResponse> response =
                ropClient.buildClientRequest().get(groupMemberRequest, GroupMemberDeleteResponse.class, "groupMember.deleteGroupMember", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupMemberDeleteResponse groupMemberResponse = response.getSuccessResponse();
    }




    @Test
    public void updateGroupMember(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupMemberUpdateRequest groupMemberRequest = new GroupMemberUpdateRequest();
	   	groupMemberRequest.setId("1");
	   	groupMemberRequest.setUser("1");
	   	groupMemberRequest.setGroupInfoId("1");
	   	groupMemberRequest.setArea("1");
	   	groupMemberRequest.setName("1");
	   	groupMemberRequest.setTel("1");
	   	groupMemberRequest.setUnit("1");
	   	groupMemberRequest.setAddr("1");
        CompositeResponse<GroupMemberUpdateResponse> response =
                ropClient.buildClientRequest().get(groupMemberRequest, GroupMemberUpdateResponse.class, "groupMember.updateGroupMember", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupMemberUpdateResponse groupMemberResponse = response.getSuccessResponse();
    }


    @Test
    public void getGroupMember(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupMemberGetRequest groupMemberRequest = new GroupMemberGetRequest();
	   	groupMemberRequest.setId("1");
        CompositeResponse<GroupMemberGetResponse> response =
                ropClient.buildClientRequest().get(groupMemberRequest, GroupMemberGetResponse.class, "groupMember.getGroupMember", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupMemberGetResponse groupMemberResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupMemberSelectAllRequest groupMemberRequest = new GroupMemberSelectAllRequest();

        CompositeResponse<GroupMemberSelectAllResponse> response =
                ropClient.buildClientRequest().get(groupMemberRequest, GroupMemberSelectAllResponse.class, "groupMember.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupMemberSelectAllResponse groupMemberResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupMemberCountAllRequest groupMemberRequest = new GroupMemberCountAllRequest();

        CompositeResponse<GroupMemberCountAllResponse> response =
                ropClient.buildClientRequest().get(groupMemberRequest, GroupMemberCountAllResponse.class, "groupMember.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupMemberCountAllResponse groupMemberResponse = response.getSuccessResponse();
        Assert.assertNotNull(groupMemberResponse.getResultString());
    }

    @Test
    public void selectGroupMember(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupMemberSelectRequest groupMemberRequest = new GroupMemberSelectRequest();
	   	groupMemberRequest.setId("1");
	   	groupMemberRequest.setUser("1");
	   	groupMemberRequest.setGroupInfoId("1");
	   	groupMemberRequest.setArea("1");
	   	groupMemberRequest.setName("1");
	   	groupMemberRequest.setTel("1");
	   	groupMemberRequest.setUnit("1");
	   	groupMemberRequest.setAddr("1");
        CompositeResponse<GroupMemberCreateResponse> response =
                ropClient.buildClientRequest().get(groupMemberRequest, GroupMemberCreateResponse.class, "groupMember.createGroupMember", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	groupMemberRequest.setId("1");
	   	groupMemberRequest.setUser("1");
	   	groupMemberRequest.setGroupInfoId("1");
	   	groupMemberRequest.setArea("1");
	   	groupMemberRequest.setName("1");
	   	groupMemberRequest.setTel("1");
	   	groupMemberRequest.setUnit("1");
	   	groupMemberRequest.setAddr("1");
        CompositeResponse<GroupMemberSelectResponse> response1 =
                ropClient.buildClientRequest().get(groupMemberRequest, GroupMemberSelectResponse.class, "groupMember.selectGroupMember", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupMemberSelectResponse groupMemberResponse = response1.getSuccessResponse();
        Assert.assertNotNull(groupMemberResponse.getResultJson());
        CompositeResponse<GroupMemberDeleteResponse> response2 =
                ropClient.buildClientRequest().get(groupMemberRequest, GroupMemberDeleteResponse.class, "groupMember.deleteGroupMember", "1.0");

    }
}
