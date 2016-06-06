/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.memberVote;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.memberVote.request.*;
import com.cartan.center.ebs.memberVote.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class MemberVoteServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(MemberVoteServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberVoteGetSessionRequest memberVoteRequest = new MemberVoteGetSessionRequest();
     	CompositeResponse<MemberVoteGetSessionResponse> response =
                 ropClient.buildClientRequest().get(memberVoteRequest, MemberVoteGetSessionResponse.class, "memberVote.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createMemberVote(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberVoteCreateRequest memberVoteRequest = new MemberVoteCreateRequest();
	   	memberVoteRequest.setId("1");
	   	memberVoteRequest.setGroupActId("1");
	   	memberVoteRequest.setGroupMemberId("1");
	   	memberVoteRequest.setVotetime("1");
	   	memberVoteRequest.setVotestate("1");
        CompositeResponse<MemberVoteCreateResponse> response =
                ropClient.buildClientRequest().get(memberVoteRequest, MemberVoteCreateResponse.class, "memberVote.createMemberVote", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberVoteCreateResponse memberVoteResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteMemberVote(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberVoteDeleteRequest memberVoteRequest = new MemberVoteDeleteRequest();
	   	memberVoteRequest.setId("1");
        CompositeResponse<MemberVoteDeleteResponse> response =
                ropClient.buildClientRequest().get(memberVoteRequest, MemberVoteDeleteResponse.class, "memberVote.deleteMemberVote", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberVoteDeleteResponse memberVoteResponse = response.getSuccessResponse();
    }




    @Test
    public void updateMemberVote(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberVoteUpdateRequest memberVoteRequest = new MemberVoteUpdateRequest();
	   	memberVoteRequest.setId("1");
	   	memberVoteRequest.setGroupActId("1");
	   	memberVoteRequest.setGroupMemberId("1");
	   	memberVoteRequest.setVotetime("1");
	   	memberVoteRequest.setVotestate("1");
        CompositeResponse<MemberVoteUpdateResponse> response =
                ropClient.buildClientRequest().get(memberVoteRequest, MemberVoteUpdateResponse.class, "memberVote.updateMemberVote", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberVoteUpdateResponse memberVoteResponse = response.getSuccessResponse();
    }


    @Test
    public void getMemberVote(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberVoteGetRequest memberVoteRequest = new MemberVoteGetRequest();
	   	memberVoteRequest.setId("1");
        CompositeResponse<MemberVoteGetResponse> response =
                ropClient.buildClientRequest().get(memberVoteRequest, MemberVoteGetResponse.class, "memberVote.getMemberVote", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberVoteGetResponse memberVoteResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberVoteSelectAllRequest memberVoteRequest = new MemberVoteSelectAllRequest();

        CompositeResponse<MemberVoteSelectAllResponse> response =
                ropClient.buildClientRequest().get(memberVoteRequest, MemberVoteSelectAllResponse.class, "memberVote.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberVoteSelectAllResponse memberVoteResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberVoteCountAllRequest memberVoteRequest = new MemberVoteCountAllRequest();

        CompositeResponse<MemberVoteCountAllResponse> response =
                ropClient.buildClientRequest().get(memberVoteRequest, MemberVoteCountAllResponse.class, "memberVote.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberVoteCountAllResponse memberVoteResponse = response.getSuccessResponse();
        Assert.assertNotNull(memberVoteResponse.getResultString());
    }

    @Test
    public void selectMemberVote(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberVoteSelectRequest memberVoteRequest = new MemberVoteSelectRequest();
	   	memberVoteRequest.setId("1");
	   	memberVoteRequest.setGroupActId("1");
	   	memberVoteRequest.setGroupMemberId("1");
	   	memberVoteRequest.setVotetime("1");
	   	memberVoteRequest.setVotestate("1");
        CompositeResponse<MemberVoteCreateResponse> response =
                ropClient.buildClientRequest().get(memberVoteRequest, MemberVoteCreateResponse.class, "memberVote.createMemberVote", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	memberVoteRequest.setId("1");
	   	memberVoteRequest.setGroupActId("1");
	   	memberVoteRequest.setGroupMemberId("1");
	   	memberVoteRequest.setVotetime("1");
	   	memberVoteRequest.setVotestate("1");
        CompositeResponse<MemberVoteSelectResponse> response1 =
                ropClient.buildClientRequest().get(memberVoteRequest, MemberVoteSelectResponse.class, "memberVote.selectMemberVote", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberVoteSelectResponse memberVoteResponse = response1.getSuccessResponse();
        Assert.assertNotNull(memberVoteResponse.getResultJson());
        CompositeResponse<MemberVoteDeleteResponse> response2 =
                ropClient.buildClientRequest().get(memberVoteRequest, MemberVoteDeleteResponse.class, "memberVote.deleteMemberVote", "1.0");

    }
}
