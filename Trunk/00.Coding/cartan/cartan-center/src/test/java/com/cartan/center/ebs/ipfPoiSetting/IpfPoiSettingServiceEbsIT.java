/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfPoiSetting;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfPoiSetting.request.*;
import com.cartan.center.ebs.ipfPoiSetting.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfPoiSettingServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfPoiSettingServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfPoiSettingGetSessionRequest ipfPoiSettingRequest = new IpfPoiSettingGetSessionRequest();
     	CompositeResponse<IpfPoiSettingGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfPoiSettingRequest, IpfPoiSettingGetSessionResponse.class, "ipfPoiSetting.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfPoiSetting(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfPoiSettingCreateRequest ipfPoiSettingRequest = new IpfPoiSettingCreateRequest();
	   	ipfPoiSettingRequest.setId("1");
	   	ipfPoiSettingRequest.setBoName("1");
	   	ipfPoiSettingRequest.setPoiType("1");
	   	ipfPoiSettingRequest.setTemplateFileName("1");
	   	ipfPoiSettingRequest.setTemplateUrl("1");
	   	ipfPoiSettingRequest.setFileName("1");
	   	ipfPoiSettingRequest.setSourceService("1");
	   	ipfPoiSettingRequest.setClassName("1");
	   	ipfPoiSettingRequest.setTemplateExtName("1");
	   	ipfPoiSettingRequest.setRuleNo("1");
	   	ipfPoiSettingRequest.setDictName("1");
	   	ipfPoiSettingRequest.setDealService("1");
	   	ipfPoiSettingRequest.setMethodeName("1");
	   	ipfPoiSettingRequest.setIsAsync("1");
	   	ipfPoiSettingRequest.setAsyncPageSize("1");
	   	ipfPoiSettingRequest.setTemplate("1");
	   	ipfPoiSettingRequest.setTemplateFileKey("1");
	   	ipfPoiSettingRequest.setPrimaryColumns("1");
	   	ipfPoiSettingRequest.setChildrenTable("1");
	   	ipfPoiSettingRequest.setSortExpress("1");
	   	ipfPoiSettingRequest.setAllowParameter("1");
	   	ipfPoiSettingRequest.setIpfDefineColumn("1");
        CompositeResponse<IpfPoiSettingCreateResponse> response =
                ropClient.buildClientRequest().get(ipfPoiSettingRequest, IpfPoiSettingCreateResponse.class, "ipfPoiSetting.createIpfPoiSetting", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfPoiSettingCreateResponse ipfPoiSettingResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfPoiSetting(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfPoiSettingDeleteRequest ipfPoiSettingRequest = new IpfPoiSettingDeleteRequest();
	   	ipfPoiSettingRequest.setId("1");
        CompositeResponse<IpfPoiSettingDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfPoiSettingRequest, IpfPoiSettingDeleteResponse.class, "ipfPoiSetting.deleteIpfPoiSetting", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfPoiSettingDeleteResponse ipfPoiSettingResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfPoiSetting(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfPoiSettingUpdateRequest ipfPoiSettingRequest = new IpfPoiSettingUpdateRequest();
	   	ipfPoiSettingRequest.setId("1");
	   	ipfPoiSettingRequest.setBoName("1");
	   	ipfPoiSettingRequest.setPoiType("1");
	   	ipfPoiSettingRequest.setTemplateFileName("1");
	   	ipfPoiSettingRequest.setTemplateUrl("1");
	   	ipfPoiSettingRequest.setFileName("1");
	   	ipfPoiSettingRequest.setSourceService("1");
	   	ipfPoiSettingRequest.setClassName("1");
	   	ipfPoiSettingRequest.setTemplateExtName("1");
	   	ipfPoiSettingRequest.setRuleNo("1");
	   	ipfPoiSettingRequest.setDictName("1");
	   	ipfPoiSettingRequest.setDealService("1");
	   	ipfPoiSettingRequest.setMethodeName("1");
	   	ipfPoiSettingRequest.setIsAsync("1");
	   	ipfPoiSettingRequest.setAsyncPageSize("1");
	   	ipfPoiSettingRequest.setTemplate("1");
	   	ipfPoiSettingRequest.setTemplateFileKey("1");
	   	ipfPoiSettingRequest.setPrimaryColumns("1");
	   	ipfPoiSettingRequest.setChildrenTable("1");
	   	ipfPoiSettingRequest.setSortExpress("1");
	   	ipfPoiSettingRequest.setAllowParameter("1");
	   	ipfPoiSettingRequest.setIpfDefineColumn("1");
        CompositeResponse<IpfPoiSettingUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfPoiSettingRequest, IpfPoiSettingUpdateResponse.class, "ipfPoiSetting.updateIpfPoiSetting", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfPoiSettingUpdateResponse ipfPoiSettingResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfPoiSetting(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfPoiSettingGetRequest ipfPoiSettingRequest = new IpfPoiSettingGetRequest();
	   	ipfPoiSettingRequest.setId("1");
        CompositeResponse<IpfPoiSettingGetResponse> response =
                ropClient.buildClientRequest().get(ipfPoiSettingRequest, IpfPoiSettingGetResponse.class, "ipfPoiSetting.getIpfPoiSetting", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfPoiSettingGetResponse ipfPoiSettingResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfPoiSettingSelectAllRequest ipfPoiSettingRequest = new IpfPoiSettingSelectAllRequest();

        CompositeResponse<IpfPoiSettingSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfPoiSettingRequest, IpfPoiSettingSelectAllResponse.class, "ipfPoiSetting.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfPoiSettingSelectAllResponse ipfPoiSettingResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfPoiSettingCountAllRequest ipfPoiSettingRequest = new IpfPoiSettingCountAllRequest();

        CompositeResponse<IpfPoiSettingCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfPoiSettingRequest, IpfPoiSettingCountAllResponse.class, "ipfPoiSetting.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfPoiSettingCountAllResponse ipfPoiSettingResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfPoiSettingResponse.getResultString());
    }

    @Test
    public void selectIpfPoiSetting(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfPoiSettingSelectRequest ipfPoiSettingRequest = new IpfPoiSettingSelectRequest();
	   	ipfPoiSettingRequest.setId("1");
	   	ipfPoiSettingRequest.setBoName("1");
	   	ipfPoiSettingRequest.setPoiType("1");
	   	ipfPoiSettingRequest.setTemplateFileName("1");
	   	ipfPoiSettingRequest.setTemplateUrl("1");
	   	ipfPoiSettingRequest.setFileName("1");
	   	ipfPoiSettingRequest.setSourceService("1");
	   	ipfPoiSettingRequest.setClassName("1");
	   	ipfPoiSettingRequest.setTemplateExtName("1");
	   	ipfPoiSettingRequest.setRuleNo("1");
	   	ipfPoiSettingRequest.setDictName("1");
	   	ipfPoiSettingRequest.setDealService("1");
	   	ipfPoiSettingRequest.setMethodeName("1");
	   	ipfPoiSettingRequest.setIsAsync("1");
	   	ipfPoiSettingRequest.setAsyncPageSize("1");
	   	ipfPoiSettingRequest.setTemplate("1");
	   	ipfPoiSettingRequest.setTemplateFileKey("1");
	   	ipfPoiSettingRequest.setPrimaryColumns("1");
	   	ipfPoiSettingRequest.setChildrenTable("1");
	   	ipfPoiSettingRequest.setSortExpress("1");
	   	ipfPoiSettingRequest.setAllowParameter("1");
	   	ipfPoiSettingRequest.setIpfDefineColumn("1");
        CompositeResponse<IpfPoiSettingCreateResponse> response =
                ropClient.buildClientRequest().get(ipfPoiSettingRequest, IpfPoiSettingCreateResponse.class, "ipfPoiSetting.createIpfPoiSetting", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfPoiSettingRequest.setId("1");
	   	ipfPoiSettingRequest.setBoName("1");
	   	ipfPoiSettingRequest.setPoiType("1");
	   	ipfPoiSettingRequest.setTemplateFileName("1");
	   	ipfPoiSettingRequest.setTemplateUrl("1");
	   	ipfPoiSettingRequest.setFileName("1");
	   	ipfPoiSettingRequest.setSourceService("1");
	   	ipfPoiSettingRequest.setClassName("1");
	   	ipfPoiSettingRequest.setTemplateExtName("1");
	   	ipfPoiSettingRequest.setRuleNo("1");
	   	ipfPoiSettingRequest.setDictName("1");
	   	ipfPoiSettingRequest.setDealService("1");
	   	ipfPoiSettingRequest.setMethodeName("1");
	   	ipfPoiSettingRequest.setIsAsync("1");
	   	ipfPoiSettingRequest.setAsyncPageSize("1");
	   	ipfPoiSettingRequest.setTemplate("1");
	   	ipfPoiSettingRequest.setTemplateFileKey("1");
	   	ipfPoiSettingRequest.setPrimaryColumns("1");
	   	ipfPoiSettingRequest.setChildrenTable("1");
	   	ipfPoiSettingRequest.setSortExpress("1");
	   	ipfPoiSettingRequest.setAllowParameter("1");
	   	ipfPoiSettingRequest.setIpfDefineColumn("1");
        CompositeResponse<IpfPoiSettingSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfPoiSettingRequest, IpfPoiSettingSelectResponse.class, "ipfPoiSetting.selectIpfPoiSetting", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfPoiSettingSelectResponse ipfPoiSettingResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfPoiSettingResponse.getResultJson());
        CompositeResponse<IpfPoiSettingDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfPoiSettingRequest, IpfPoiSettingDeleteResponse.class, "ipfPoiSetting.deleteIpfPoiSetting", "1.0");

    }
}
