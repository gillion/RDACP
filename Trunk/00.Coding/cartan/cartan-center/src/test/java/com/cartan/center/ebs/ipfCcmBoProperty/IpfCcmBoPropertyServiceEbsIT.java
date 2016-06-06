/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoProperty;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoProperty.request.*;
import com.cartan.center.ebs.ipfCcmBoProperty.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoPropertyServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoPropertyServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyGetSessionRequest ipfCcmBoPropertyRequest = new IpfCcmBoPropertyGetSessionRequest();
     	CompositeResponse<IpfCcmBoPropertyGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoPropertyRequest, IpfCcmBoPropertyGetSessionResponse.class, "ipfCcmBoProperty.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoProperty(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyCreateRequest ipfCcmBoPropertyRequest = new IpfCcmBoPropertyCreateRequest();
	   	ipfCcmBoPropertyRequest.setId("1");
	   	ipfCcmBoPropertyRequest.setPropertyName("1");
	   	ipfCcmBoPropertyRequest.setColumnName("1");
	   	ipfCcmBoPropertyRequest.setPropertyType("1");
	   	ipfCcmBoPropertyRequest.setSubBoLayoutType("1");
	   	ipfCcmBoPropertyRequest.setTableName("1");
	   	ipfCcmBoPropertyRequest.setMaxValue("1");
	   	ipfCcmBoPropertyRequest.setMinValue("1");
	   	ipfCcmBoPropertyRequest.setElementCode("1");
	   	ipfCcmBoPropertyRequest.setFieldText("1");
	   	ipfCcmBoPropertyRequest.setDataType("1");
	   	ipfCcmBoPropertyRequest.setFieldLength("1");
	   	ipfCcmBoPropertyRequest.setDecimals("1");
	   	ipfCcmBoPropertyRequest.setIsNotNull("1");
	   	ipfCcmBoPropertyRequest.setIsKey("1");
	   	ipfCcmBoPropertyRequest.setSubBoName("1");
	   	ipfCcmBoPropertyRequest.setSubBoRelType("1");
	   	ipfCcmBoPropertyRequest.setSubBoRelPro("1");
	   	ipfCcmBoPropertyRequest.setSubBoOrderNo("1");
	   	ipfCcmBoPropertyRequest.setPersistentSaveType("1");
	   	ipfCcmBoPropertyRequest.setRelSubBoProName("1");
	   	ipfCcmBoPropertyRequest.setSearchHelp("1");
	   	ipfCcmBoPropertyRequest.setRefProName("1");
	   	ipfCcmBoPropertyRequest.setDictTableName("1");
	   	ipfCcmBoPropertyRequest.setDictGroupValue("1");
	   	ipfCcmBoPropertyRequest.setFetchWay("1");
	   	ipfCcmBoPropertyRequest.setFixValue("1");
	   	ipfCcmBoPropertyRequest.setValueExpression("1");
	   	ipfCcmBoPropertyRequest.setVlaueRuleNo("1");
	   	ipfCcmBoPropertyRequest.setPreCondition("1");
	   	ipfCcmBoPropertyRequest.setOptCondition("1");
	   	ipfCcmBoPropertyRequest.setIsSurcharge("1");
	   	ipfCcmBoPropertyRequest.setIsRealtimeCalculate("1");
	   	ipfCcmBoPropertyRequest.setRpType("1");
	   	ipfCcmBoPropertyRequest.setCustIdPropertyName("1");
	   	ipfCcmBoPropertyRequest.setBusinessDatePropertyName("1");
	   	ipfCcmBoPropertyRequest.setIpfCcmBoId("1");
	   	ipfCcmBoPropertyRequest.setAuthField("1");
	   	ipfCcmBoPropertyRequest.setHelpIndex("1");
	   	ipfCcmBoPropertyRequest.setNumberObjectId("1");
	   	ipfCcmBoPropertyRequest.setRelBoMethod("1");
	   	ipfCcmBoPropertyRequest.setRelBoName("1");
	   	ipfCcmBoPropertyRequest.setShTable("1");
	   	ipfCcmBoPropertyRequest.setShValueColumn("1");
	   	ipfCcmBoPropertyRequest.setValidactionType("1");
	   	ipfCcmBoPropertyRequest.setValidactionRegex("1");
        CompositeResponse<IpfCcmBoPropertyCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyRequest, IpfCcmBoPropertyCreateResponse.class, "ipfCcmBoProperty.createIpfCcmBoProperty", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyCreateResponse ipfCcmBoPropertyResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoProperty(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyDeleteRequest ipfCcmBoPropertyRequest = new IpfCcmBoPropertyDeleteRequest();
	   	ipfCcmBoPropertyRequest.setId("1");
        CompositeResponse<IpfCcmBoPropertyDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyRequest, IpfCcmBoPropertyDeleteResponse.class, "ipfCcmBoProperty.deleteIpfCcmBoProperty", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyDeleteResponse ipfCcmBoPropertyResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoProperty(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyUpdateRequest ipfCcmBoPropertyRequest = new IpfCcmBoPropertyUpdateRequest();
	   	ipfCcmBoPropertyRequest.setId("1");
	   	ipfCcmBoPropertyRequest.setPropertyName("1");
	   	ipfCcmBoPropertyRequest.setColumnName("1");
	   	ipfCcmBoPropertyRequest.setPropertyType("1");
	   	ipfCcmBoPropertyRequest.setSubBoLayoutType("1");
	   	ipfCcmBoPropertyRequest.setTableName("1");
	   	ipfCcmBoPropertyRequest.setMaxValue("1");
	   	ipfCcmBoPropertyRequest.setMinValue("1");
	   	ipfCcmBoPropertyRequest.setElementCode("1");
	   	ipfCcmBoPropertyRequest.setFieldText("1");
	   	ipfCcmBoPropertyRequest.setDataType("1");
	   	ipfCcmBoPropertyRequest.setFieldLength("1");
	   	ipfCcmBoPropertyRequest.setDecimals("1");
	   	ipfCcmBoPropertyRequest.setIsNotNull("1");
	   	ipfCcmBoPropertyRequest.setIsKey("1");
	   	ipfCcmBoPropertyRequest.setSubBoName("1");
	   	ipfCcmBoPropertyRequest.setSubBoRelType("1");
	   	ipfCcmBoPropertyRequest.setSubBoRelPro("1");
	   	ipfCcmBoPropertyRequest.setSubBoOrderNo("1");
	   	ipfCcmBoPropertyRequest.setPersistentSaveType("1");
	   	ipfCcmBoPropertyRequest.setRelSubBoProName("1");
	   	ipfCcmBoPropertyRequest.setSearchHelp("1");
	   	ipfCcmBoPropertyRequest.setRefProName("1");
	   	ipfCcmBoPropertyRequest.setDictTableName("1");
	   	ipfCcmBoPropertyRequest.setDictGroupValue("1");
	   	ipfCcmBoPropertyRequest.setFetchWay("1");
	   	ipfCcmBoPropertyRequest.setFixValue("1");
	   	ipfCcmBoPropertyRequest.setValueExpression("1");
	   	ipfCcmBoPropertyRequest.setVlaueRuleNo("1");
	   	ipfCcmBoPropertyRequest.setPreCondition("1");
	   	ipfCcmBoPropertyRequest.setOptCondition("1");
	   	ipfCcmBoPropertyRequest.setIsSurcharge("1");
	   	ipfCcmBoPropertyRequest.setIsRealtimeCalculate("1");
	   	ipfCcmBoPropertyRequest.setRpType("1");
	   	ipfCcmBoPropertyRequest.setCustIdPropertyName("1");
	   	ipfCcmBoPropertyRequest.setBusinessDatePropertyName("1");
	   	ipfCcmBoPropertyRequest.setIpfCcmBoId("1");
	   	ipfCcmBoPropertyRequest.setAuthField("1");
	   	ipfCcmBoPropertyRequest.setHelpIndex("1");
	   	ipfCcmBoPropertyRequest.setNumberObjectId("1");
	   	ipfCcmBoPropertyRequest.setRelBoMethod("1");
	   	ipfCcmBoPropertyRequest.setRelBoName("1");
	   	ipfCcmBoPropertyRequest.setShTable("1");
	   	ipfCcmBoPropertyRequest.setShValueColumn("1");
	   	ipfCcmBoPropertyRequest.setValidactionType("1");
	   	ipfCcmBoPropertyRequest.setValidactionRegex("1");
        CompositeResponse<IpfCcmBoPropertyUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyRequest, IpfCcmBoPropertyUpdateResponse.class, "ipfCcmBoProperty.updateIpfCcmBoProperty", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyUpdateResponse ipfCcmBoPropertyResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoProperty(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyGetRequest ipfCcmBoPropertyRequest = new IpfCcmBoPropertyGetRequest();
	   	ipfCcmBoPropertyRequest.setId("1");
        CompositeResponse<IpfCcmBoPropertyGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyRequest, IpfCcmBoPropertyGetResponse.class, "ipfCcmBoProperty.getIpfCcmBoProperty", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyGetResponse ipfCcmBoPropertyResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertySelectAllRequest ipfCcmBoPropertyRequest = new IpfCcmBoPropertySelectAllRequest();

        CompositeResponse<IpfCcmBoPropertySelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyRequest, IpfCcmBoPropertySelectAllResponse.class, "ipfCcmBoProperty.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertySelectAllResponse ipfCcmBoPropertyResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertyCountAllRequest ipfCcmBoPropertyRequest = new IpfCcmBoPropertyCountAllRequest();

        CompositeResponse<IpfCcmBoPropertyCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyRequest, IpfCcmBoPropertyCountAllResponse.class, "ipfCcmBoProperty.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertyCountAllResponse ipfCcmBoPropertyResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoPropertyResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoProperty(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPropertySelectRequest ipfCcmBoPropertyRequest = new IpfCcmBoPropertySelectRequest();
	   	ipfCcmBoPropertyRequest.setId("1");
	   	ipfCcmBoPropertyRequest.setPropertyName("1");
	   	ipfCcmBoPropertyRequest.setColumnName("1");
	   	ipfCcmBoPropertyRequest.setPropertyType("1");
	   	ipfCcmBoPropertyRequest.setSubBoLayoutType("1");
	   	ipfCcmBoPropertyRequest.setTableName("1");
	   	ipfCcmBoPropertyRequest.setMaxValue("1");
	   	ipfCcmBoPropertyRequest.setMinValue("1");
	   	ipfCcmBoPropertyRequest.setElementCode("1");
	   	ipfCcmBoPropertyRequest.setFieldText("1");
	   	ipfCcmBoPropertyRequest.setDataType("1");
	   	ipfCcmBoPropertyRequest.setFieldLength("1");
	   	ipfCcmBoPropertyRequest.setDecimals("1");
	   	ipfCcmBoPropertyRequest.setIsNotNull("1");
	   	ipfCcmBoPropertyRequest.setIsKey("1");
	   	ipfCcmBoPropertyRequest.setSubBoName("1");
	   	ipfCcmBoPropertyRequest.setSubBoRelType("1");
	   	ipfCcmBoPropertyRequest.setSubBoRelPro("1");
	   	ipfCcmBoPropertyRequest.setSubBoOrderNo("1");
	   	ipfCcmBoPropertyRequest.setPersistentSaveType("1");
	   	ipfCcmBoPropertyRequest.setRelSubBoProName("1");
	   	ipfCcmBoPropertyRequest.setSearchHelp("1");
	   	ipfCcmBoPropertyRequest.setRefProName("1");
	   	ipfCcmBoPropertyRequest.setDictTableName("1");
	   	ipfCcmBoPropertyRequest.setDictGroupValue("1");
	   	ipfCcmBoPropertyRequest.setFetchWay("1");
	   	ipfCcmBoPropertyRequest.setFixValue("1");
	   	ipfCcmBoPropertyRequest.setValueExpression("1");
	   	ipfCcmBoPropertyRequest.setVlaueRuleNo("1");
	   	ipfCcmBoPropertyRequest.setPreCondition("1");
	   	ipfCcmBoPropertyRequest.setOptCondition("1");
	   	ipfCcmBoPropertyRequest.setIsSurcharge("1");
	   	ipfCcmBoPropertyRequest.setIsRealtimeCalculate("1");
	   	ipfCcmBoPropertyRequest.setRpType("1");
	   	ipfCcmBoPropertyRequest.setCustIdPropertyName("1");
	   	ipfCcmBoPropertyRequest.setBusinessDatePropertyName("1");
	   	ipfCcmBoPropertyRequest.setIpfCcmBoId("1");
	   	ipfCcmBoPropertyRequest.setAuthField("1");
	   	ipfCcmBoPropertyRequest.setHelpIndex("1");
	   	ipfCcmBoPropertyRequest.setNumberObjectId("1");
	   	ipfCcmBoPropertyRequest.setRelBoMethod("1");
	   	ipfCcmBoPropertyRequest.setRelBoName("1");
	   	ipfCcmBoPropertyRequest.setShTable("1");
	   	ipfCcmBoPropertyRequest.setShValueColumn("1");
	   	ipfCcmBoPropertyRequest.setValidactionType("1");
	   	ipfCcmBoPropertyRequest.setValidactionRegex("1");
        CompositeResponse<IpfCcmBoPropertyCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyRequest, IpfCcmBoPropertyCreateResponse.class, "ipfCcmBoProperty.createIpfCcmBoProperty", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoPropertyRequest.setId("1");
	   	ipfCcmBoPropertyRequest.setPropertyName("1");
	   	ipfCcmBoPropertyRequest.setColumnName("1");
	   	ipfCcmBoPropertyRequest.setPropertyType("1");
	   	ipfCcmBoPropertyRequest.setSubBoLayoutType("1");
	   	ipfCcmBoPropertyRequest.setTableName("1");
	   	ipfCcmBoPropertyRequest.setMaxValue("1");
	   	ipfCcmBoPropertyRequest.setMinValue("1");
	   	ipfCcmBoPropertyRequest.setElementCode("1");
	   	ipfCcmBoPropertyRequest.setFieldText("1");
	   	ipfCcmBoPropertyRequest.setDataType("1");
	   	ipfCcmBoPropertyRequest.setFieldLength("1");
	   	ipfCcmBoPropertyRequest.setDecimals("1");
	   	ipfCcmBoPropertyRequest.setIsNotNull("1");
	   	ipfCcmBoPropertyRequest.setIsKey("1");
	   	ipfCcmBoPropertyRequest.setSubBoName("1");
	   	ipfCcmBoPropertyRequest.setSubBoRelType("1");
	   	ipfCcmBoPropertyRequest.setSubBoRelPro("1");
	   	ipfCcmBoPropertyRequest.setSubBoOrderNo("1");
	   	ipfCcmBoPropertyRequest.setPersistentSaveType("1");
	   	ipfCcmBoPropertyRequest.setRelSubBoProName("1");
	   	ipfCcmBoPropertyRequest.setSearchHelp("1");
	   	ipfCcmBoPropertyRequest.setRefProName("1");
	   	ipfCcmBoPropertyRequest.setDictTableName("1");
	   	ipfCcmBoPropertyRequest.setDictGroupValue("1");
	   	ipfCcmBoPropertyRequest.setFetchWay("1");
	   	ipfCcmBoPropertyRequest.setFixValue("1");
	   	ipfCcmBoPropertyRequest.setValueExpression("1");
	   	ipfCcmBoPropertyRequest.setVlaueRuleNo("1");
	   	ipfCcmBoPropertyRequest.setPreCondition("1");
	   	ipfCcmBoPropertyRequest.setOptCondition("1");
	   	ipfCcmBoPropertyRequest.setIsSurcharge("1");
	   	ipfCcmBoPropertyRequest.setIsRealtimeCalculate("1");
	   	ipfCcmBoPropertyRequest.setRpType("1");
	   	ipfCcmBoPropertyRequest.setCustIdPropertyName("1");
	   	ipfCcmBoPropertyRequest.setBusinessDatePropertyName("1");
	   	ipfCcmBoPropertyRequest.setIpfCcmBoId("1");
	   	ipfCcmBoPropertyRequest.setAuthField("1");
	   	ipfCcmBoPropertyRequest.setHelpIndex("1");
	   	ipfCcmBoPropertyRequest.setNumberObjectId("1");
	   	ipfCcmBoPropertyRequest.setRelBoMethod("1");
	   	ipfCcmBoPropertyRequest.setRelBoName("1");
	   	ipfCcmBoPropertyRequest.setShTable("1");
	   	ipfCcmBoPropertyRequest.setShValueColumn("1");
	   	ipfCcmBoPropertyRequest.setValidactionType("1");
	   	ipfCcmBoPropertyRequest.setValidactionRegex("1");
        CompositeResponse<IpfCcmBoPropertySelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyRequest, IpfCcmBoPropertySelectResponse.class, "ipfCcmBoProperty.selectIpfCcmBoProperty", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPropertySelectResponse ipfCcmBoPropertyResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoPropertyResponse.getResultJson());
        CompositeResponse<IpfCcmBoPropertyDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoPropertyRequest, IpfCcmBoPropertyDeleteResponse.class, "ipfCcmBoProperty.deleteIpfCcmBoProperty", "1.0");

    }
}
