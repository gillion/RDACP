/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoFormColumn;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoFormColumn.request.*;
import com.cartan.center.ebs.ipfCcmBoFormColumn.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoFormColumnServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoFormColumnServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormColumnGetSessionRequest ipfCcmBoFormColumnRequest = new IpfCcmBoFormColumnGetSessionRequest();
     	CompositeResponse<IpfCcmBoFormColumnGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoFormColumnRequest, IpfCcmBoFormColumnGetSessionResponse.class, "ipfCcmBoFormColumn.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoFormColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormColumnCreateRequest ipfCcmBoFormColumnRequest = new IpfCcmBoFormColumnCreateRequest();
	   	ipfCcmBoFormColumnRequest.setId("1");
	   	ipfCcmBoFormColumnRequest.setIpfCcmBoId("1");
	   	ipfCcmBoFormColumnRequest.setDefaultValue("1");
	   	ipfCcmBoFormColumnRequest.setIsGroup("1");
	   	ipfCcmBoFormColumnRequest.setGroupName("1");
	   	ipfCcmBoFormColumnRequest.setIsCaNote("1");
	   	ipfCcmBoFormColumnRequest.setIsHeader("1");
	   	ipfCcmBoFormColumnRequest.setIsNotNull("1");
	   	ipfCcmBoFormColumnRequest.setIsReadOnly("1");
	   	ipfCcmBoFormColumnRequest.setPropertyName("1");
	   	ipfCcmBoFormColumnRequest.setPropertyType("1");
	   	ipfCcmBoFormColumnRequest.setColumnNo("1");
	   	ipfCcmBoFormColumnRequest.setRowNo("1");
	   	ipfCcmBoFormColumnRequest.setUiType("1");
	   	ipfCcmBoFormColumnRequest.setIsVisible("1");
	   	ipfCcmBoFormColumnRequest.setPropertyId("1");
	   	ipfCcmBoFormColumnRequest.setRuleNo("1");
	   	ipfCcmBoFormColumnRequest.setColumnStyle("1");
	   	ipfCcmBoFormColumnRequest.setDisplayLable("1");
	   	ipfCcmBoFormColumnRequest.setLableStyle("1");
	   	ipfCcmBoFormColumnRequest.setCellName("1");
	   	ipfCcmBoFormColumnRequest.setTextFormHeight("1");
	   	ipfCcmBoFormColumnRequest.setTextLineNum("1");
	   	ipfCcmBoFormColumnRequest.setInlineWidth("1");
	   	ipfCcmBoFormColumnRequest.setInlineOrderNo("1");
	   	ipfCcmBoFormColumnRequest.setInlineConnector("1");
	   	ipfCcmBoFormColumnRequest.setIsShowLabel("1");
	   	ipfCcmBoFormColumnRequest.setIsRadioInline("1");
	   	ipfCcmBoFormColumnRequest.setTabIndex("1");
	   	ipfCcmBoFormColumnRequest.setInitValueType("1");
	   	ipfCcmBoFormColumnRequest.setCorrectType("1");
	   	ipfCcmBoFormColumnRequest.setActiveExpress("1");
        CompositeResponse<IpfCcmBoFormColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormColumnRequest, IpfCcmBoFormColumnCreateResponse.class, "ipfCcmBoFormColumn.createIpfCcmBoFormColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormColumnCreateResponse ipfCcmBoFormColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoFormColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormColumnDeleteRequest ipfCcmBoFormColumnRequest = new IpfCcmBoFormColumnDeleteRequest();
	   	ipfCcmBoFormColumnRequest.setId("1");
        CompositeResponse<IpfCcmBoFormColumnDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormColumnRequest, IpfCcmBoFormColumnDeleteResponse.class, "ipfCcmBoFormColumn.deleteIpfCcmBoFormColumn", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormColumnDeleteResponse ipfCcmBoFormColumnResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoFormColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormColumnUpdateRequest ipfCcmBoFormColumnRequest = new IpfCcmBoFormColumnUpdateRequest();
	   	ipfCcmBoFormColumnRequest.setId("1");
	   	ipfCcmBoFormColumnRequest.setIpfCcmBoId("1");
	   	ipfCcmBoFormColumnRequest.setDefaultValue("1");
	   	ipfCcmBoFormColumnRequest.setIsGroup("1");
	   	ipfCcmBoFormColumnRequest.setGroupName("1");
	   	ipfCcmBoFormColumnRequest.setIsCaNote("1");
	   	ipfCcmBoFormColumnRequest.setIsHeader("1");
	   	ipfCcmBoFormColumnRequest.setIsNotNull("1");
	   	ipfCcmBoFormColumnRequest.setIsReadOnly("1");
	   	ipfCcmBoFormColumnRequest.setPropertyName("1");
	   	ipfCcmBoFormColumnRequest.setPropertyType("1");
	   	ipfCcmBoFormColumnRequest.setColumnNo("1");
	   	ipfCcmBoFormColumnRequest.setRowNo("1");
	   	ipfCcmBoFormColumnRequest.setUiType("1");
	   	ipfCcmBoFormColumnRequest.setIsVisible("1");
	   	ipfCcmBoFormColumnRequest.setPropertyId("1");
	   	ipfCcmBoFormColumnRequest.setRuleNo("1");
	   	ipfCcmBoFormColumnRequest.setColumnStyle("1");
	   	ipfCcmBoFormColumnRequest.setDisplayLable("1");
	   	ipfCcmBoFormColumnRequest.setLableStyle("1");
	   	ipfCcmBoFormColumnRequest.setCellName("1");
	   	ipfCcmBoFormColumnRequest.setTextFormHeight("1");
	   	ipfCcmBoFormColumnRequest.setTextLineNum("1");
	   	ipfCcmBoFormColumnRequest.setInlineWidth("1");
	   	ipfCcmBoFormColumnRequest.setInlineOrderNo("1");
	   	ipfCcmBoFormColumnRequest.setInlineConnector("1");
	   	ipfCcmBoFormColumnRequest.setIsShowLabel("1");
	   	ipfCcmBoFormColumnRequest.setIsRadioInline("1");
	   	ipfCcmBoFormColumnRequest.setTabIndex("1");
	   	ipfCcmBoFormColumnRequest.setInitValueType("1");
	   	ipfCcmBoFormColumnRequest.setCorrectType("1");
	   	ipfCcmBoFormColumnRequest.setActiveExpress("1");
        CompositeResponse<IpfCcmBoFormColumnUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormColumnRequest, IpfCcmBoFormColumnUpdateResponse.class, "ipfCcmBoFormColumn.updateIpfCcmBoFormColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormColumnUpdateResponse ipfCcmBoFormColumnResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoFormColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormColumnGetRequest ipfCcmBoFormColumnRequest = new IpfCcmBoFormColumnGetRequest();
	   	ipfCcmBoFormColumnRequest.setId("1");
        CompositeResponse<IpfCcmBoFormColumnGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormColumnRequest, IpfCcmBoFormColumnGetResponse.class, "ipfCcmBoFormColumn.getIpfCcmBoFormColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormColumnGetResponse ipfCcmBoFormColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormColumnSelectAllRequest ipfCcmBoFormColumnRequest = new IpfCcmBoFormColumnSelectAllRequest();

        CompositeResponse<IpfCcmBoFormColumnSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormColumnRequest, IpfCcmBoFormColumnSelectAllResponse.class, "ipfCcmBoFormColumn.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormColumnSelectAllResponse ipfCcmBoFormColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormColumnCountAllRequest ipfCcmBoFormColumnRequest = new IpfCcmBoFormColumnCountAllRequest();

        CompositeResponse<IpfCcmBoFormColumnCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormColumnRequest, IpfCcmBoFormColumnCountAllResponse.class, "ipfCcmBoFormColumn.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormColumnCountAllResponse ipfCcmBoFormColumnResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoFormColumnResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoFormColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormColumnSelectRequest ipfCcmBoFormColumnRequest = new IpfCcmBoFormColumnSelectRequest();
	   	ipfCcmBoFormColumnRequest.setId("1");
	   	ipfCcmBoFormColumnRequest.setIpfCcmBoId("1");
	   	ipfCcmBoFormColumnRequest.setDefaultValue("1");
	   	ipfCcmBoFormColumnRequest.setIsGroup("1");
	   	ipfCcmBoFormColumnRequest.setGroupName("1");
	   	ipfCcmBoFormColumnRequest.setIsCaNote("1");
	   	ipfCcmBoFormColumnRequest.setIsHeader("1");
	   	ipfCcmBoFormColumnRequest.setIsNotNull("1");
	   	ipfCcmBoFormColumnRequest.setIsReadOnly("1");
	   	ipfCcmBoFormColumnRequest.setPropertyName("1");
	   	ipfCcmBoFormColumnRequest.setPropertyType("1");
	   	ipfCcmBoFormColumnRequest.setColumnNo("1");
	   	ipfCcmBoFormColumnRequest.setRowNo("1");
	   	ipfCcmBoFormColumnRequest.setUiType("1");
	   	ipfCcmBoFormColumnRequest.setIsVisible("1");
	   	ipfCcmBoFormColumnRequest.setPropertyId("1");
	   	ipfCcmBoFormColumnRequest.setRuleNo("1");
	   	ipfCcmBoFormColumnRequest.setColumnStyle("1");
	   	ipfCcmBoFormColumnRequest.setDisplayLable("1");
	   	ipfCcmBoFormColumnRequest.setLableStyle("1");
	   	ipfCcmBoFormColumnRequest.setCellName("1");
	   	ipfCcmBoFormColumnRequest.setTextFormHeight("1");
	   	ipfCcmBoFormColumnRequest.setTextLineNum("1");
	   	ipfCcmBoFormColumnRequest.setInlineWidth("1");
	   	ipfCcmBoFormColumnRequest.setInlineOrderNo("1");
	   	ipfCcmBoFormColumnRequest.setInlineConnector("1");
	   	ipfCcmBoFormColumnRequest.setIsShowLabel("1");
	   	ipfCcmBoFormColumnRequest.setIsRadioInline("1");
	   	ipfCcmBoFormColumnRequest.setTabIndex("1");
	   	ipfCcmBoFormColumnRequest.setInitValueType("1");
	   	ipfCcmBoFormColumnRequest.setCorrectType("1");
	   	ipfCcmBoFormColumnRequest.setActiveExpress("1");
        CompositeResponse<IpfCcmBoFormColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormColumnRequest, IpfCcmBoFormColumnCreateResponse.class, "ipfCcmBoFormColumn.createIpfCcmBoFormColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoFormColumnRequest.setId("1");
	   	ipfCcmBoFormColumnRequest.setIpfCcmBoId("1");
	   	ipfCcmBoFormColumnRequest.setDefaultValue("1");
	   	ipfCcmBoFormColumnRequest.setIsGroup("1");
	   	ipfCcmBoFormColumnRequest.setGroupName("1");
	   	ipfCcmBoFormColumnRequest.setIsCaNote("1");
	   	ipfCcmBoFormColumnRequest.setIsHeader("1");
	   	ipfCcmBoFormColumnRequest.setIsNotNull("1");
	   	ipfCcmBoFormColumnRequest.setIsReadOnly("1");
	   	ipfCcmBoFormColumnRequest.setPropertyName("1");
	   	ipfCcmBoFormColumnRequest.setPropertyType("1");
	   	ipfCcmBoFormColumnRequest.setColumnNo("1");
	   	ipfCcmBoFormColumnRequest.setRowNo("1");
	   	ipfCcmBoFormColumnRequest.setUiType("1");
	   	ipfCcmBoFormColumnRequest.setIsVisible("1");
	   	ipfCcmBoFormColumnRequest.setPropertyId("1");
	   	ipfCcmBoFormColumnRequest.setRuleNo("1");
	   	ipfCcmBoFormColumnRequest.setColumnStyle("1");
	   	ipfCcmBoFormColumnRequest.setDisplayLable("1");
	   	ipfCcmBoFormColumnRequest.setLableStyle("1");
	   	ipfCcmBoFormColumnRequest.setCellName("1");
	   	ipfCcmBoFormColumnRequest.setTextFormHeight("1");
	   	ipfCcmBoFormColumnRequest.setTextLineNum("1");
	   	ipfCcmBoFormColumnRequest.setInlineWidth("1");
	   	ipfCcmBoFormColumnRequest.setInlineOrderNo("1");
	   	ipfCcmBoFormColumnRequest.setInlineConnector("1");
	   	ipfCcmBoFormColumnRequest.setIsShowLabel("1");
	   	ipfCcmBoFormColumnRequest.setIsRadioInline("1");
	   	ipfCcmBoFormColumnRequest.setTabIndex("1");
	   	ipfCcmBoFormColumnRequest.setInitValueType("1");
	   	ipfCcmBoFormColumnRequest.setCorrectType("1");
	   	ipfCcmBoFormColumnRequest.setActiveExpress("1");
        CompositeResponse<IpfCcmBoFormColumnSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoFormColumnRequest, IpfCcmBoFormColumnSelectResponse.class, "ipfCcmBoFormColumn.selectIpfCcmBoFormColumn", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormColumnSelectResponse ipfCcmBoFormColumnResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoFormColumnResponse.getResultJson());
        CompositeResponse<IpfCcmBoFormColumnDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoFormColumnRequest, IpfCcmBoFormColumnDeleteResponse.class, "ipfCcmBoFormColumn.deleteIpfCcmBoFormColumn", "1.0");

    }
}
