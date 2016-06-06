/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoGridColumn;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoGridColumn.request.*;
import com.cartan.center.ebs.ipfCcmBoGridColumn.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoGridColumnServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoGridColumnServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridColumnGetSessionRequest ipfCcmBoGridColumnRequest = new IpfCcmBoGridColumnGetSessionRequest();
     	CompositeResponse<IpfCcmBoGridColumnGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoGridColumnRequest, IpfCcmBoGridColumnGetSessionResponse.class, "ipfCcmBoGridColumn.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoGridColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridColumnCreateRequest ipfCcmBoGridColumnRequest = new IpfCcmBoGridColumnCreateRequest();
	   	ipfCcmBoGridColumnRequest.setId("1");
	   	ipfCcmBoGridColumnRequest.setIpfCcmBoId("1");
	   	ipfCcmBoGridColumnRequest.setDefaultValue("1");
	   	ipfCcmBoGridColumnRequest.setIsCondition("1");
	   	ipfCcmBoGridColumnRequest.setIsRange("1");
	   	ipfCcmBoGridColumnRequest.setCorrectType("1");
	   	ipfCcmBoGridColumnRequest.setIsSum("1");
	   	ipfCcmBoGridColumnRequest.setIsNotNull("1");
	   	ipfCcmBoGridColumnRequest.setIsOrderBy("1");
	   	ipfCcmBoGridColumnRequest.setPropertyName("1");
	   	ipfCcmBoGridColumnRequest.setPropertyType("1");
	   	ipfCcmBoGridColumnRequest.setUiType("1");
	   	ipfCcmBoGridColumnRequest.setColumnNo("1");
	   	ipfCcmBoGridColumnRequest.setIsReadOnly("1");
	   	ipfCcmBoGridColumnRequest.setIsVisible("1");
	   	ipfCcmBoGridColumnRequest.setWidth("1");
	   	ipfCcmBoGridColumnRequest.setPropertyId("1");
	   	ipfCcmBoGridColumnRequest.setCellRuleNo("1");
	   	ipfCcmBoGridColumnRequest.setMethodId("1");
	   	ipfCcmBoGridColumnRequest.setMethodName("1");
	   	ipfCcmBoGridColumnRequest.setSearchColumnNo("1");
	   	ipfCcmBoGridColumnRequest.setSearchRowNo("1");
	   	ipfCcmBoGridColumnRequest.setOperation("1");
	   	ipfCcmBoGridColumnRequest.setConditionVisible("1");
	   	ipfCcmBoGridColumnRequest.setShlpValueType("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickSearch("1");
	   	ipfCcmBoGridColumnRequest.setQuickCellName("1");
	   	ipfCcmBoGridColumnRequest.setQuickTextFormHeight("1");
	   	ipfCcmBoGridColumnRequest.setQuickTextLineNum("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineWidth("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineOrderNo("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineConnector("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickShowLabel("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickRadioInline("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvSearch("1");
	   	ipfCcmBoGridColumnRequest.setAdvCellName("1");
	   	ipfCcmBoGridColumnRequest.setAdvTextFormHeight("1");
	   	ipfCcmBoGridColumnRequest.setAdvTextLineNum("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineWidth("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineOrderNo("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineConnector("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvShowLabel("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvRadioInline("1");
	   	ipfCcmBoGridColumnRequest.setTabIndex("1");
	   	ipfCcmBoGridColumnRequest.setIsCellEditable("1");
	   	ipfCcmBoGridColumnRequest.setInitValueType("1");
	   	ipfCcmBoGridColumnRequest.setInitValueType2("1");
	   	ipfCcmBoGridColumnRequest.setDefaultValue2("1");
	   	ipfCcmBoGridColumnRequest.setFieldSort("1");
	   	ipfCcmBoGridColumnRequest.setActiveExpress("1");
	   	ipfCcmBoGridColumnRequest.setLockColumnExpress("1");
	   	ipfCcmBoGridColumnRequest.setUnlockColumnExpress("1");
	   	ipfCcmBoGridColumnRequest.setIsShowSort("1");
        CompositeResponse<IpfCcmBoGridColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridColumnRequest, IpfCcmBoGridColumnCreateResponse.class, "ipfCcmBoGridColumn.createIpfCcmBoGridColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridColumnCreateResponse ipfCcmBoGridColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoGridColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridColumnDeleteRequest ipfCcmBoGridColumnRequest = new IpfCcmBoGridColumnDeleteRequest();
	   	ipfCcmBoGridColumnRequest.setId("1");
        CompositeResponse<IpfCcmBoGridColumnDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridColumnRequest, IpfCcmBoGridColumnDeleteResponse.class, "ipfCcmBoGridColumn.deleteIpfCcmBoGridColumn", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridColumnDeleteResponse ipfCcmBoGridColumnResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoGridColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridColumnUpdateRequest ipfCcmBoGridColumnRequest = new IpfCcmBoGridColumnUpdateRequest();
	   	ipfCcmBoGridColumnRequest.setId("1");
	   	ipfCcmBoGridColumnRequest.setIpfCcmBoId("1");
	   	ipfCcmBoGridColumnRequest.setDefaultValue("1");
	   	ipfCcmBoGridColumnRequest.setIsCondition("1");
	   	ipfCcmBoGridColumnRequest.setIsRange("1");
	   	ipfCcmBoGridColumnRequest.setCorrectType("1");
	   	ipfCcmBoGridColumnRequest.setIsSum("1");
	   	ipfCcmBoGridColumnRequest.setIsNotNull("1");
	   	ipfCcmBoGridColumnRequest.setIsOrderBy("1");
	   	ipfCcmBoGridColumnRequest.setPropertyName("1");
	   	ipfCcmBoGridColumnRequest.setPropertyType("1");
	   	ipfCcmBoGridColumnRequest.setUiType("1");
	   	ipfCcmBoGridColumnRequest.setColumnNo("1");
	   	ipfCcmBoGridColumnRequest.setIsReadOnly("1");
	   	ipfCcmBoGridColumnRequest.setIsVisible("1");
	   	ipfCcmBoGridColumnRequest.setWidth("1");
	   	ipfCcmBoGridColumnRequest.setPropertyId("1");
	   	ipfCcmBoGridColumnRequest.setCellRuleNo("1");
	   	ipfCcmBoGridColumnRequest.setMethodId("1");
	   	ipfCcmBoGridColumnRequest.setMethodName("1");
	   	ipfCcmBoGridColumnRequest.setSearchColumnNo("1");
	   	ipfCcmBoGridColumnRequest.setSearchRowNo("1");
	   	ipfCcmBoGridColumnRequest.setOperation("1");
	   	ipfCcmBoGridColumnRequest.setConditionVisible("1");
	   	ipfCcmBoGridColumnRequest.setShlpValueType("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickSearch("1");
	   	ipfCcmBoGridColumnRequest.setQuickCellName("1");
	   	ipfCcmBoGridColumnRequest.setQuickTextFormHeight("1");
	   	ipfCcmBoGridColumnRequest.setQuickTextLineNum("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineWidth("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineOrderNo("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineConnector("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickShowLabel("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickRadioInline("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvSearch("1");
	   	ipfCcmBoGridColumnRequest.setAdvCellName("1");
	   	ipfCcmBoGridColumnRequest.setAdvTextFormHeight("1");
	   	ipfCcmBoGridColumnRequest.setAdvTextLineNum("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineWidth("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineOrderNo("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineConnector("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvShowLabel("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvRadioInline("1");
	   	ipfCcmBoGridColumnRequest.setTabIndex("1");
	   	ipfCcmBoGridColumnRequest.setIsCellEditable("1");
	   	ipfCcmBoGridColumnRequest.setInitValueType("1");
	   	ipfCcmBoGridColumnRequest.setInitValueType2("1");
	   	ipfCcmBoGridColumnRequest.setDefaultValue2("1");
	   	ipfCcmBoGridColumnRequest.setFieldSort("1");
	   	ipfCcmBoGridColumnRequest.setActiveExpress("1");
	   	ipfCcmBoGridColumnRequest.setLockColumnExpress("1");
	   	ipfCcmBoGridColumnRequest.setUnlockColumnExpress("1");
	   	ipfCcmBoGridColumnRequest.setIsShowSort("1");
        CompositeResponse<IpfCcmBoGridColumnUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridColumnRequest, IpfCcmBoGridColumnUpdateResponse.class, "ipfCcmBoGridColumn.updateIpfCcmBoGridColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridColumnUpdateResponse ipfCcmBoGridColumnResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoGridColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridColumnGetRequest ipfCcmBoGridColumnRequest = new IpfCcmBoGridColumnGetRequest();
	   	ipfCcmBoGridColumnRequest.setId("1");
        CompositeResponse<IpfCcmBoGridColumnGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridColumnRequest, IpfCcmBoGridColumnGetResponse.class, "ipfCcmBoGridColumn.getIpfCcmBoGridColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridColumnGetResponse ipfCcmBoGridColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridColumnSelectAllRequest ipfCcmBoGridColumnRequest = new IpfCcmBoGridColumnSelectAllRequest();

        CompositeResponse<IpfCcmBoGridColumnSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridColumnRequest, IpfCcmBoGridColumnSelectAllResponse.class, "ipfCcmBoGridColumn.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridColumnSelectAllResponse ipfCcmBoGridColumnResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridColumnCountAllRequest ipfCcmBoGridColumnRequest = new IpfCcmBoGridColumnCountAllRequest();

        CompositeResponse<IpfCcmBoGridColumnCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridColumnRequest, IpfCcmBoGridColumnCountAllResponse.class, "ipfCcmBoGridColumn.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridColumnCountAllResponse ipfCcmBoGridColumnResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoGridColumnResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoGridColumn(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGridColumnSelectRequest ipfCcmBoGridColumnRequest = new IpfCcmBoGridColumnSelectRequest();
	   	ipfCcmBoGridColumnRequest.setId("1");
	   	ipfCcmBoGridColumnRequest.setIpfCcmBoId("1");
	   	ipfCcmBoGridColumnRequest.setDefaultValue("1");
	   	ipfCcmBoGridColumnRequest.setIsCondition("1");
	   	ipfCcmBoGridColumnRequest.setIsRange("1");
	   	ipfCcmBoGridColumnRequest.setCorrectType("1");
	   	ipfCcmBoGridColumnRequest.setIsSum("1");
	   	ipfCcmBoGridColumnRequest.setIsNotNull("1");
	   	ipfCcmBoGridColumnRequest.setIsOrderBy("1");
	   	ipfCcmBoGridColumnRequest.setPropertyName("1");
	   	ipfCcmBoGridColumnRequest.setPropertyType("1");
	   	ipfCcmBoGridColumnRequest.setUiType("1");
	   	ipfCcmBoGridColumnRequest.setColumnNo("1");
	   	ipfCcmBoGridColumnRequest.setIsReadOnly("1");
	   	ipfCcmBoGridColumnRequest.setIsVisible("1");
	   	ipfCcmBoGridColumnRequest.setWidth("1");
	   	ipfCcmBoGridColumnRequest.setPropertyId("1");
	   	ipfCcmBoGridColumnRequest.setCellRuleNo("1");
	   	ipfCcmBoGridColumnRequest.setMethodId("1");
	   	ipfCcmBoGridColumnRequest.setMethodName("1");
	   	ipfCcmBoGridColumnRequest.setSearchColumnNo("1");
	   	ipfCcmBoGridColumnRequest.setSearchRowNo("1");
	   	ipfCcmBoGridColumnRequest.setOperation("1");
	   	ipfCcmBoGridColumnRequest.setConditionVisible("1");
	   	ipfCcmBoGridColumnRequest.setShlpValueType("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickSearch("1");
	   	ipfCcmBoGridColumnRequest.setQuickCellName("1");
	   	ipfCcmBoGridColumnRequest.setQuickTextFormHeight("1");
	   	ipfCcmBoGridColumnRequest.setQuickTextLineNum("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineWidth("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineOrderNo("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineConnector("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickShowLabel("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickRadioInline("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvSearch("1");
	   	ipfCcmBoGridColumnRequest.setAdvCellName("1");
	   	ipfCcmBoGridColumnRequest.setAdvTextFormHeight("1");
	   	ipfCcmBoGridColumnRequest.setAdvTextLineNum("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineWidth("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineOrderNo("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineConnector("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvShowLabel("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvRadioInline("1");
	   	ipfCcmBoGridColumnRequest.setTabIndex("1");
	   	ipfCcmBoGridColumnRequest.setIsCellEditable("1");
	   	ipfCcmBoGridColumnRequest.setInitValueType("1");
	   	ipfCcmBoGridColumnRequest.setInitValueType2("1");
	   	ipfCcmBoGridColumnRequest.setDefaultValue2("1");
	   	ipfCcmBoGridColumnRequest.setFieldSort("1");
	   	ipfCcmBoGridColumnRequest.setActiveExpress("1");
	   	ipfCcmBoGridColumnRequest.setLockColumnExpress("1");
	   	ipfCcmBoGridColumnRequest.setUnlockColumnExpress("1");
	   	ipfCcmBoGridColumnRequest.setIsShowSort("1");
        CompositeResponse<IpfCcmBoGridColumnCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoGridColumnRequest, IpfCcmBoGridColumnCreateResponse.class, "ipfCcmBoGridColumn.createIpfCcmBoGridColumn", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoGridColumnRequest.setId("1");
	   	ipfCcmBoGridColumnRequest.setIpfCcmBoId("1");
	   	ipfCcmBoGridColumnRequest.setDefaultValue("1");
	   	ipfCcmBoGridColumnRequest.setIsCondition("1");
	   	ipfCcmBoGridColumnRequest.setIsRange("1");
	   	ipfCcmBoGridColumnRequest.setCorrectType("1");
	   	ipfCcmBoGridColumnRequest.setIsSum("1");
	   	ipfCcmBoGridColumnRequest.setIsNotNull("1");
	   	ipfCcmBoGridColumnRequest.setIsOrderBy("1");
	   	ipfCcmBoGridColumnRequest.setPropertyName("1");
	   	ipfCcmBoGridColumnRequest.setPropertyType("1");
	   	ipfCcmBoGridColumnRequest.setUiType("1");
	   	ipfCcmBoGridColumnRequest.setColumnNo("1");
	   	ipfCcmBoGridColumnRequest.setIsReadOnly("1");
	   	ipfCcmBoGridColumnRequest.setIsVisible("1");
	   	ipfCcmBoGridColumnRequest.setWidth("1");
	   	ipfCcmBoGridColumnRequest.setPropertyId("1");
	   	ipfCcmBoGridColumnRequest.setCellRuleNo("1");
	   	ipfCcmBoGridColumnRequest.setMethodId("1");
	   	ipfCcmBoGridColumnRequest.setMethodName("1");
	   	ipfCcmBoGridColumnRequest.setSearchColumnNo("1");
	   	ipfCcmBoGridColumnRequest.setSearchRowNo("1");
	   	ipfCcmBoGridColumnRequest.setOperation("1");
	   	ipfCcmBoGridColumnRequest.setConditionVisible("1");
	   	ipfCcmBoGridColumnRequest.setShlpValueType("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickSearch("1");
	   	ipfCcmBoGridColumnRequest.setQuickCellName("1");
	   	ipfCcmBoGridColumnRequest.setQuickTextFormHeight("1");
	   	ipfCcmBoGridColumnRequest.setQuickTextLineNum("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineWidth("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineOrderNo("1");
	   	ipfCcmBoGridColumnRequest.setQuickInlineConnector("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickShowLabel("1");
	   	ipfCcmBoGridColumnRequest.setIsQuickRadioInline("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvSearch("1");
	   	ipfCcmBoGridColumnRequest.setAdvCellName("1");
	   	ipfCcmBoGridColumnRequest.setAdvTextFormHeight("1");
	   	ipfCcmBoGridColumnRequest.setAdvTextLineNum("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineWidth("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineOrderNo("1");
	   	ipfCcmBoGridColumnRequest.setAdvInlineConnector("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvShowLabel("1");
	   	ipfCcmBoGridColumnRequest.setIsAdvRadioInline("1");
	   	ipfCcmBoGridColumnRequest.setTabIndex("1");
	   	ipfCcmBoGridColumnRequest.setIsCellEditable("1");
	   	ipfCcmBoGridColumnRequest.setInitValueType("1");
	   	ipfCcmBoGridColumnRequest.setInitValueType2("1");
	   	ipfCcmBoGridColumnRequest.setDefaultValue2("1");
	   	ipfCcmBoGridColumnRequest.setFieldSort("1");
	   	ipfCcmBoGridColumnRequest.setActiveExpress("1");
	   	ipfCcmBoGridColumnRequest.setLockColumnExpress("1");
	   	ipfCcmBoGridColumnRequest.setUnlockColumnExpress("1");
	   	ipfCcmBoGridColumnRequest.setIsShowSort("1");
        CompositeResponse<IpfCcmBoGridColumnSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoGridColumnRequest, IpfCcmBoGridColumnSelectResponse.class, "ipfCcmBoGridColumn.selectIpfCcmBoGridColumn", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGridColumnSelectResponse ipfCcmBoGridColumnResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoGridColumnResponse.getResultJson());
        CompositeResponse<IpfCcmBoGridColumnDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoGridColumnRequest, IpfCcmBoGridColumnDeleteResponse.class, "ipfCcmBoGridColumn.deleteIpfCcmBoGridColumn", "1.0");

    }
}
