/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.groupAction;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.groupAction.request.*;
import com.cartan.center.ebs.groupAction.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class GroupActionServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(GroupActionServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupActionGetSessionRequest groupActionRequest = new GroupActionGetSessionRequest();
     	CompositeResponse<GroupActionGetSessionResponse> response =
                 ropClient.buildClientRequest().get(groupActionRequest, GroupActionGetSessionResponse.class, "groupAction.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createGroupAction(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupActionCreateRequest groupActionRequest = new GroupActionCreateRequest();
	   	groupActionRequest.setId("1");
	   	groupActionRequest.setName("1");
	   	groupActionRequest.setBegintime("1");
	   	groupActionRequest.setEndtime("1");
	   	groupActionRequest.setAddr("1");
	   	groupActionRequest.setLeadings("1");
	   	groupActionRequest.setMemoinfo("1");
	   	groupActionRequest.setMincount("1");
	   	groupActionRequest.setBudget("1");
	   	groupActionRequest.setSpending("1");
        CompositeResponse<GroupActionCreateResponse> response =
                ropClient.buildClientRequest().get(groupActionRequest, GroupActionCreateResponse.class, "groupAction.createGroupAction", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupActionCreateResponse groupActionResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteGroupAction(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupActionDeleteRequest groupActionRequest = new GroupActionDeleteRequest();
	   	groupActionRequest.setId("1");
        CompositeResponse<GroupActionDeleteResponse> response =
                ropClient.buildClientRequest().get(groupActionRequest, GroupActionDeleteResponse.class, "groupAction.deleteGroupAction", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupActionDeleteResponse groupActionResponse = response.getSuccessResponse();
    }




    @Test
    public void updateGroupAction(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupActionUpdateRequest groupActionRequest = new GroupActionUpdateRequest();
	   	groupActionRequest.setId("1");
	   	groupActionRequest.setName("1");
	   	groupActionRequest.setBegintime("1");
	   	groupActionRequest.setEndtime("1");
	   	groupActionRequest.setAddr("1");
	   	groupActionRequest.setLeadings("1");
	   	groupActionRequest.setMemoinfo("1");
	   	groupActionRequest.setMincount("1");
	   	groupActionRequest.setBudget("1");
	   	groupActionRequest.setSpending("1");
        CompositeResponse<GroupActionUpdateResponse> response =
                ropClient.buildClientRequest().get(groupActionRequest, GroupActionUpdateResponse.class, "groupAction.updateGroupAction", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupActionUpdateResponse groupActionResponse = response.getSuccessResponse();
    }


    @Test
    public void getGroupAction(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupActionGetRequest groupActionRequest = new GroupActionGetRequest();
	   	groupActionRequest.setId("1");
        CompositeResponse<GroupActionGetResponse> response =
                ropClient.buildClientRequest().get(groupActionRequest, GroupActionGetResponse.class, "groupAction.getGroupAction", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupActionGetResponse groupActionResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupActionSelectAllRequest groupActionRequest = new GroupActionSelectAllRequest();

        CompositeResponse<GroupActionSelectAllResponse> response =
                ropClient.buildClientRequest().get(groupActionRequest, GroupActionSelectAllResponse.class, "groupAction.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupActionSelectAllResponse groupActionResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupActionCountAllRequest groupActionRequest = new GroupActionCountAllRequest();

        CompositeResponse<GroupActionCountAllResponse> response =
                ropClient.buildClientRequest().get(groupActionRequest, GroupActionCountAllResponse.class, "groupAction.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupActionCountAllResponse groupActionResponse = response.getSuccessResponse();
        Assert.assertNotNull(groupActionResponse.getResultString());
    }

    @Test
    public void selectGroupAction(){
        RopClient ropClient = CartanRopClient.getRopClient();
        GroupActionSelectRequest groupActionRequest = new GroupActionSelectRequest();
	   	groupActionRequest.setId("1");
	   	groupActionRequest.setName("1");
	   	groupActionRequest.setBegintime("1");
	   	groupActionRequest.setEndtime("1");
	   	groupActionRequest.setAddr("1");
	   	groupActionRequest.setLeadings("1");
	   	groupActionRequest.setMemoinfo("1");
	   	groupActionRequest.setMincount("1");
	   	groupActionRequest.setBudget("1");
	   	groupActionRequest.setSpending("1");
        CompositeResponse<GroupActionCreateResponse> response =
                ropClient.buildClientRequest().get(groupActionRequest, GroupActionCreateResponse.class, "groupAction.createGroupAction", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	groupActionRequest.setId("1");
	   	groupActionRequest.setName("1");
	   	groupActionRequest.setBegintime("1");
	   	groupActionRequest.setEndtime("1");
	   	groupActionRequest.setAddr("1");
	   	groupActionRequest.setLeadings("1");
	   	groupActionRequest.setMemoinfo("1");
	   	groupActionRequest.setMincount("1");
	   	groupActionRequest.setBudget("1");
	   	groupActionRequest.setSpending("1");
        CompositeResponse<GroupActionSelectResponse> response1 =
                ropClient.buildClientRequest().get(groupActionRequest, GroupActionSelectResponse.class, "groupAction.selectGroupAction", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        GroupActionSelectResponse groupActionResponse = response1.getSuccessResponse();
        Assert.assertNotNull(groupActionResponse.getResultJson());
        CompositeResponse<GroupActionDeleteResponse> response2 =
                ropClient.buildClientRequest().get(groupActionRequest, GroupActionDeleteResponse.class, "groupAction.deleteGroupAction", "1.0");

    }
}
