/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.memberClothingsize;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.memberClothingsize.request.*;
import com.cartan.center.ebs.memberClothingsize.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class MemberClothingsizeServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(MemberClothingsizeServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberClothingsizeGetSessionRequest memberClothingsizeRequest = new MemberClothingsizeGetSessionRequest();
     	CompositeResponse<MemberClothingsizeGetSessionResponse> response =
                 ropClient.buildClientRequest().get(memberClothingsizeRequest, MemberClothingsizeGetSessionResponse.class, "memberClothingsize.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createMemberClothingsize(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberClothingsizeCreateRequest memberClothingsizeRequest = new MemberClothingsizeCreateRequest();
	   	memberClothingsizeRequest.setId("1");
	   	memberClothingsizeRequest.setName("1");
	   	memberClothingsizeRequest.setDepart("1");
	   	memberClothingsizeRequest.setHeight("1");
	   	memberClothingsizeRequest.setWeight("1");
	   	memberClothingsizeRequest.setClothingSize("1");
        CompositeResponse<MemberClothingsizeCreateResponse> response =
                ropClient.buildClientRequest().get(memberClothingsizeRequest, MemberClothingsizeCreateResponse.class, "memberClothingsize.createMemberClothingsize", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberClothingsizeCreateResponse memberClothingsizeResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteMemberClothingsize(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberClothingsizeDeleteRequest memberClothingsizeRequest = new MemberClothingsizeDeleteRequest();
	   	memberClothingsizeRequest.setId("1");
        CompositeResponse<MemberClothingsizeDeleteResponse> response =
                ropClient.buildClientRequest().get(memberClothingsizeRequest, MemberClothingsizeDeleteResponse.class, "memberClothingsize.deleteMemberClothingsize", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberClothingsizeDeleteResponse memberClothingsizeResponse = response.getSuccessResponse();
    }




    @Test
    public void updateMemberClothingsize(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberClothingsizeUpdateRequest memberClothingsizeRequest = new MemberClothingsizeUpdateRequest();
	   	memberClothingsizeRequest.setId("1");
	   	memberClothingsizeRequest.setName("1");
	   	memberClothingsizeRequest.setDepart("1");
	   	memberClothingsizeRequest.setHeight("1");
	   	memberClothingsizeRequest.setWeight("1");
	   	memberClothingsizeRequest.setClothingSize("1");
        CompositeResponse<MemberClothingsizeUpdateResponse> response =
                ropClient.buildClientRequest().get(memberClothingsizeRequest, MemberClothingsizeUpdateResponse.class, "memberClothingsize.updateMemberClothingsize", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberClothingsizeUpdateResponse memberClothingsizeResponse = response.getSuccessResponse();
    }


    @Test
    public void getMemberClothingsize(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberClothingsizeGetRequest memberClothingsizeRequest = new MemberClothingsizeGetRequest();
	   	memberClothingsizeRequest.setId("1");
        CompositeResponse<MemberClothingsizeGetResponse> response =
                ropClient.buildClientRequest().get(memberClothingsizeRequest, MemberClothingsizeGetResponse.class, "memberClothingsize.getMemberClothingsize", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberClothingsizeGetResponse memberClothingsizeResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberClothingsizeSelectAllRequest memberClothingsizeRequest = new MemberClothingsizeSelectAllRequest();

        CompositeResponse<MemberClothingsizeSelectAllResponse> response =
                ropClient.buildClientRequest().get(memberClothingsizeRequest, MemberClothingsizeSelectAllResponse.class, "memberClothingsize.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberClothingsizeSelectAllResponse memberClothingsizeResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberClothingsizeCountAllRequest memberClothingsizeRequest = new MemberClothingsizeCountAllRequest();

        CompositeResponse<MemberClothingsizeCountAllResponse> response =
                ropClient.buildClientRequest().get(memberClothingsizeRequest, MemberClothingsizeCountAllResponse.class, "memberClothingsize.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberClothingsizeCountAllResponse memberClothingsizeResponse = response.getSuccessResponse();
        Assert.assertNotNull(memberClothingsizeResponse.getResultString());
    }

    @Test
    public void selectMemberClothingsize(){
        RopClient ropClient = CartanRopClient.getRopClient();
        MemberClothingsizeSelectRequest memberClothingsizeRequest = new MemberClothingsizeSelectRequest();
	   	memberClothingsizeRequest.setId("1");
	   	memberClothingsizeRequest.setName("1");
	   	memberClothingsizeRequest.setDepart("1");
	   	memberClothingsizeRequest.setHeight("1");
	   	memberClothingsizeRequest.setWeight("1");
	   	memberClothingsizeRequest.setClothingSize("1");
        CompositeResponse<MemberClothingsizeCreateResponse> response =
                ropClient.buildClientRequest().get(memberClothingsizeRequest, MemberClothingsizeCreateResponse.class, "memberClothingsize.createMemberClothingsize", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	memberClothingsizeRequest.setId("1");
	   	memberClothingsizeRequest.setName("1");
	   	memberClothingsizeRequest.setDepart("1");
	   	memberClothingsizeRequest.setHeight("1");
	   	memberClothingsizeRequest.setWeight("1");
	   	memberClothingsizeRequest.setClothingSize("1");
        CompositeResponse<MemberClothingsizeSelectResponse> response1 =
                ropClient.buildClientRequest().get(memberClothingsizeRequest, MemberClothingsizeSelectResponse.class, "memberClothingsize.selectMemberClothingsize", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        MemberClothingsizeSelectResponse memberClothingsizeResponse = response1.getSuccessResponse();
        Assert.assertNotNull(memberClothingsizeResponse.getResultJson());
        CompositeResponse<MemberClothingsizeDeleteResponse> response2 =
                ropClient.buildClientRequest().get(memberClothingsizeRequest, MemberClothingsizeDeleteResponse.class, "memberClothingsize.deleteMemberClothingsize", "1.0");

    }
}
