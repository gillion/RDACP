/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciViewMember;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfFciViewMember.request.*;
import com.cartan.center.ebs.ipfFciViewMember.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfFciViewMemberServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfFciViewMemberServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewMemberGetSessionRequest ipfFciViewMemberRequest = new IpfFciViewMemberGetSessionRequest();
     	CompositeResponse<IpfFciViewMemberGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfFciViewMemberRequest, IpfFciViewMemberGetSessionResponse.class, "ipfFciViewMember.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfFciViewMember(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewMemberCreateRequest ipfFciViewMemberRequest = new IpfFciViewMemberCreateRequest();
	   	ipfFciViewMemberRequest.setId("1");
	   	ipfFciViewMemberRequest.setIpfFciViewId("1");
	   	ipfFciViewMemberRequest.setConfigItemType("1");
	   	ipfFciViewMemberRequest.setConfigItemCode("1");
	   	ipfFciViewMemberRequest.setConfigItemId("1");
	   	ipfFciViewMemberRequest.setRevisionNumber("1");
	   	ipfFciViewMemberRequest.setSourceType("1");
	   	ipfFciViewMemberRequest.setSourceItemId("1");
	   	ipfFciViewMemberRequest.setRelationMemberId("1");
	   	ipfFciViewMemberRequest.setIsLock("1");
	   	ipfFciViewMemberRequest.setLockUser("1");
	   	ipfFciViewMemberRequest.setLockTime("1");
	   	ipfFciViewMemberRequest.setIsActive("1");
        CompositeResponse<IpfFciViewMemberCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewMemberRequest, IpfFciViewMemberCreateResponse.class, "ipfFciViewMember.createIpfFciViewMember", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewMemberCreateResponse ipfFciViewMemberResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfFciViewMember(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewMemberDeleteRequest ipfFciViewMemberRequest = new IpfFciViewMemberDeleteRequest();
	   	ipfFciViewMemberRequest.setId("1");
        CompositeResponse<IpfFciViewMemberDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewMemberRequest, IpfFciViewMemberDeleteResponse.class, "ipfFciViewMember.deleteIpfFciViewMember", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewMemberDeleteResponse ipfFciViewMemberResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfFciViewMember(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewMemberUpdateRequest ipfFciViewMemberRequest = new IpfFciViewMemberUpdateRequest();
	   	ipfFciViewMemberRequest.setId("1");
	   	ipfFciViewMemberRequest.setIpfFciViewId("1");
	   	ipfFciViewMemberRequest.setConfigItemType("1");
	   	ipfFciViewMemberRequest.setConfigItemCode("1");
	   	ipfFciViewMemberRequest.setConfigItemId("1");
	   	ipfFciViewMemberRequest.setRevisionNumber("1");
	   	ipfFciViewMemberRequest.setSourceType("1");
	   	ipfFciViewMemberRequest.setSourceItemId("1");
	   	ipfFciViewMemberRequest.setRelationMemberId("1");
	   	ipfFciViewMemberRequest.setIsLock("1");
	   	ipfFciViewMemberRequest.setLockUser("1");
	   	ipfFciViewMemberRequest.setLockTime("1");
	   	ipfFciViewMemberRequest.setIsActive("1");
        CompositeResponse<IpfFciViewMemberUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewMemberRequest, IpfFciViewMemberUpdateResponse.class, "ipfFciViewMember.updateIpfFciViewMember", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewMemberUpdateResponse ipfFciViewMemberResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfFciViewMember(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewMemberGetRequest ipfFciViewMemberRequest = new IpfFciViewMemberGetRequest();
	   	ipfFciViewMemberRequest.setId("1");
        CompositeResponse<IpfFciViewMemberGetResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewMemberRequest, IpfFciViewMemberGetResponse.class, "ipfFciViewMember.getIpfFciViewMember", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewMemberGetResponse ipfFciViewMemberResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewMemberSelectAllRequest ipfFciViewMemberRequest = new IpfFciViewMemberSelectAllRequest();

        CompositeResponse<IpfFciViewMemberSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewMemberRequest, IpfFciViewMemberSelectAllResponse.class, "ipfFciViewMember.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewMemberSelectAllResponse ipfFciViewMemberResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewMemberCountAllRequest ipfFciViewMemberRequest = new IpfFciViewMemberCountAllRequest();

        CompositeResponse<IpfFciViewMemberCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewMemberRequest, IpfFciViewMemberCountAllResponse.class, "ipfFciViewMember.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewMemberCountAllResponse ipfFciViewMemberResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfFciViewMemberResponse.getResultString());
    }

    @Test
    public void selectIpfFciViewMember(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciViewMemberSelectRequest ipfFciViewMemberRequest = new IpfFciViewMemberSelectRequest();
	   	ipfFciViewMemberRequest.setId("1");
	   	ipfFciViewMemberRequest.setIpfFciViewId("1");
	   	ipfFciViewMemberRequest.setConfigItemType("1");
	   	ipfFciViewMemberRequest.setConfigItemCode("1");
	   	ipfFciViewMemberRequest.setConfigItemId("1");
	   	ipfFciViewMemberRequest.setRevisionNumber("1");
	   	ipfFciViewMemberRequest.setSourceType("1");
	   	ipfFciViewMemberRequest.setSourceItemId("1");
	   	ipfFciViewMemberRequest.setRelationMemberId("1");
	   	ipfFciViewMemberRequest.setIsLock("1");
	   	ipfFciViewMemberRequest.setLockUser("1");
	   	ipfFciViewMemberRequest.setLockTime("1");
	   	ipfFciViewMemberRequest.setIsActive("1");
        CompositeResponse<IpfFciViewMemberCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciViewMemberRequest, IpfFciViewMemberCreateResponse.class, "ipfFciViewMember.createIpfFciViewMember", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfFciViewMemberRequest.setId("1");
	   	ipfFciViewMemberRequest.setIpfFciViewId("1");
	   	ipfFciViewMemberRequest.setConfigItemType("1");
	   	ipfFciViewMemberRequest.setConfigItemCode("1");
	   	ipfFciViewMemberRequest.setConfigItemId("1");
	   	ipfFciViewMemberRequest.setRevisionNumber("1");
	   	ipfFciViewMemberRequest.setSourceType("1");
	   	ipfFciViewMemberRequest.setSourceItemId("1");
	   	ipfFciViewMemberRequest.setRelationMemberId("1");
	   	ipfFciViewMemberRequest.setIsLock("1");
	   	ipfFciViewMemberRequest.setLockUser("1");
	   	ipfFciViewMemberRequest.setLockTime("1");
	   	ipfFciViewMemberRequest.setIsActive("1");
        CompositeResponse<IpfFciViewMemberSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfFciViewMemberRequest, IpfFciViewMemberSelectResponse.class, "ipfFciViewMember.selectIpfFciViewMember", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciViewMemberSelectResponse ipfFciViewMemberResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfFciViewMemberResponse.getResultJson());
        CompositeResponse<IpfFciViewMemberDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfFciViewMemberRequest, IpfFciViewMemberDeleteResponse.class, "ipfFciViewMember.deleteIpfFciViewMember", "1.0");

    }
}
