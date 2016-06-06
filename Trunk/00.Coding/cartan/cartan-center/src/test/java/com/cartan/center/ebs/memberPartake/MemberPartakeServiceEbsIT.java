/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.memberPartake;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.memberPartake.request.*;
import com.cartan.center.ebs.memberPartake.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class MemberPartakeServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(MemberPartakeServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberPartakeGetSessionRequest memberPartakeRequest = new MemberPartakeGetSessionRequest();
     	CompositeResponse<MemberPartakeGetSessionResponse> response =
                 ropClient.buildClientRequest().get(memberPartakeRequest, MemberPartakeGetSessionResponse.class, "memberPartake.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createMemberPartake(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberPartakeCreateRequest memberPartakeRequest = new MemberPartakeCreateRequest();
	   	memberPartakeRequest.setId("1");
	   	memberPartakeRequest.setGroupActId("1");
	   	memberPartakeRequest.setGroupMemberId("1");
	   	memberPartakeRequest.setPartaketime("1");
	   	memberPartakeRequest.setSpending("1");
        CompositeResponse<MemberPartakeCreateResponse> response =
                ropClient.buildClientRequest().get(memberPartakeRequest, MemberPartakeCreateResponse.class, "memberPartake.createMemberPartake", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberPartakeCreateResponse memberPartakeResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteMemberPartake(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberPartakeDeleteRequest memberPartakeRequest = new MemberPartakeDeleteRequest();
	   	memberPartakeRequest.setId("1");
        CompositeResponse<MemberPartakeDeleteResponse> response =
                ropClient.buildClientRequest().get(memberPartakeRequest, MemberPartakeDeleteResponse.class, "memberPartake.deleteMemberPartake", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberPartakeDeleteResponse memberPartakeResponse = response.getSuccessResponse();
    }




    @Test
    public void updateMemberPartake(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberPartakeUpdateRequest memberPartakeRequest = new MemberPartakeUpdateRequest();
	   	memberPartakeRequest.setId("1");
	   	memberPartakeRequest.setGroupActId("1");
	   	memberPartakeRequest.setGroupMemberId("1");
	   	memberPartakeRequest.setPartaketime("1");
	   	memberPartakeRequest.setSpending("1");
        CompositeResponse<MemberPartakeUpdateResponse> response =
                ropClient.buildClientRequest().get(memberPartakeRequest, MemberPartakeUpdateResponse.class, "memberPartake.updateMemberPartake", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberPartakeUpdateResponse memberPartakeResponse = response.getSuccessResponse();
    }


    @Test
    public void getMemberPartake(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberPartakeGetRequest memberPartakeRequest = new MemberPartakeGetRequest();
	   	memberPartakeRequest.setId("1");
        CompositeResponse<MemberPartakeGetResponse> response =
                ropClient.buildClientRequest().get(memberPartakeRequest, MemberPartakeGetResponse.class, "memberPartake.getMemberPartake", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberPartakeGetResponse memberPartakeResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberPartakeSelectAllRequest memberPartakeRequest = new MemberPartakeSelectAllRequest();

        CompositeResponse<MemberPartakeSelectAllResponse> response =
                ropClient.buildClientRequest().get(memberPartakeRequest, MemberPartakeSelectAllResponse.class, "memberPartake.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberPartakeSelectAllResponse memberPartakeResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberPartakeCountAllRequest memberPartakeRequest = new MemberPartakeCountAllRequest();

        CompositeResponse<MemberPartakeCountAllResponse> response =
                ropClient.buildClientRequest().get(memberPartakeRequest, MemberPartakeCountAllResponse.class, "memberPartake.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberPartakeCountAllResponse memberPartakeResponse = response.getSuccessResponse();
        Assert.assertNotNull(memberPartakeResponse.getResultString());
    }

    @Test
    public void selectMemberPartake(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberPartakeSelectRequest memberPartakeRequest = new MemberPartakeSelectRequest();
	   	memberPartakeRequest.setId("1");
	   	memberPartakeRequest.setGroupActId("1");
	   	memberPartakeRequest.setGroupMemberId("1");
	   	memberPartakeRequest.setPartaketime("1");
	   	memberPartakeRequest.setSpending("1");
        CompositeResponse<MemberPartakeCreateResponse> response =
                ropClient.buildClientRequest().get(memberPartakeRequest, MemberPartakeCreateResponse.class, "memberPartake.createMemberPartake", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	memberPartakeRequest.setId("1");
	   	memberPartakeRequest.setGroupActId("1");
	   	memberPartakeRequest.setGroupMemberId("1");
	   	memberPartakeRequest.setPartaketime("1");
	   	memberPartakeRequest.setSpending("1");
        CompositeResponse<MemberPartakeSelectResponse> response1 =
                ropClient.buildClientRequest().get(memberPartakeRequest, MemberPartakeSelectResponse.class, "memberPartake.selectMemberPartake", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberPartakeSelectResponse memberPartakeResponse = response1.getSuccessResponse();
        Assert.assertNotNull(memberPartakeResponse.getResultJson());
        CompositeResponse<MemberPartakeDeleteResponse> response2 =
                ropClient.buildClientRequest().get(memberPartakeRequest, MemberPartakeDeleteResponse.class, "memberPartake.deleteMemberPartake", "1.0");

    }
}
