/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoPgLoElement;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoPgLoElement.request.*;
import com.cartan.center.ebs.ipfCcmBoPgLoElement.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoPgLoElementServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoPgLoElementServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPgLoElementGetSessionRequest ipfCcmBoPgLoElementRequest = new IpfCcmBoPgLoElementGetSessionRequest();
     	CompositeResponse<IpfCcmBoPgLoElementGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoPgLoElementRequest, IpfCcmBoPgLoElementGetSessionResponse.class, "ipfCcmBoPgLoElement.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoPgLoElement(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPgLoElementCreateRequest ipfCcmBoPgLoElementRequest = new IpfCcmBoPgLoElementCreateRequest();
	   	ipfCcmBoPgLoElementRequest.setId("1");
	   	ipfCcmBoPgLoElementRequest.setIpfCcmBoPageLayoutId("1");
	   	ipfCcmBoPgLoElementRequest.setSeqNo("1");
	   	ipfCcmBoPgLoElementRequest.setLayoutElementType("1");
	   	ipfCcmBoPgLoElementRequest.setLayoutBoName("1");
	   	ipfCcmBoPgLoElementRequest.setControlHeight("1");
	   	ipfCcmBoPgLoElementRequest.setControlWidth("1");
	   	ipfCcmBoPgLoElementRequest.setTextLineNum("1");
	   	ipfCcmBoPgLoElementRequest.setControlConnector("1");
	   	ipfCcmBoPgLoElementRequest.setIsNotNull("1");
	   	ipfCcmBoPgLoElementRequest.setIsReadOnly("1");
	   	ipfCcmBoPgLoElementRequest.setUiType("1");
	   	ipfCcmBoPgLoElementRequest.setIsVisible("1");
	   	ipfCcmBoPgLoElementRequest.setColumnStyle("1");
	   	ipfCcmBoPgLoElementRequest.setLableStyle("1");
	   	ipfCcmBoPgLoElementRequest.setIsShowLable("1");
	   	ipfCcmBoPgLoElementRequest.setIsInline("1");
	   	ipfCcmBoPgLoElementRequest.setTabIndex("1");
	   	ipfCcmBoPgLoElementRequest.setDefaultValue("1");
	   	ipfCcmBoPgLoElementRequest.setInitValueType("1");
	   	ipfCcmBoPgLoElementRequest.setCorrectType("1");
	   	ipfCcmBoPgLoElementRequest.setConditionType("1");
	   	ipfCcmBoPgLoElementRequest.setOperation("1");
	   	ipfCcmBoPgLoElementRequest.setQueryType("1");
	   	ipfCcmBoPgLoElementRequest.setRangeType("1");
	   	ipfCcmBoPgLoElementRequest.setMethodName("1");
	   	ipfCcmBoPgLoElementRequest.setPropertyName("1");
        CompositeResponse<IpfCcmBoPgLoElementCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPgLoElementRequest, IpfCcmBoPgLoElementCreateResponse.class, "ipfCcmBoPgLoElement.createIpfCcmBoPgLoElement", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPgLoElementCreateResponse ipfCcmBoPgLoElementResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoPgLoElement(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPgLoElementDeleteRequest ipfCcmBoPgLoElementRequest = new IpfCcmBoPgLoElementDeleteRequest();
	   	ipfCcmBoPgLoElementRequest.setId("1");
        CompositeResponse<IpfCcmBoPgLoElementDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPgLoElementRequest, IpfCcmBoPgLoElementDeleteResponse.class, "ipfCcmBoPgLoElement.deleteIpfCcmBoPgLoElement", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPgLoElementDeleteResponse ipfCcmBoPgLoElementResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoPgLoElement(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPgLoElementUpdateRequest ipfCcmBoPgLoElementRequest = new IpfCcmBoPgLoElementUpdateRequest();
	   	ipfCcmBoPgLoElementRequest.setId("1");
	   	ipfCcmBoPgLoElementRequest.setIpfCcmBoPageLayoutId("1");
	   	ipfCcmBoPgLoElementRequest.setSeqNo("1");
	   	ipfCcmBoPgLoElementRequest.setLayoutElementType("1");
	   	ipfCcmBoPgLoElementRequest.setLayoutBoName("1");
	   	ipfCcmBoPgLoElementRequest.setControlHeight("1");
	   	ipfCcmBoPgLoElementRequest.setControlWidth("1");
	   	ipfCcmBoPgLoElementRequest.setTextLineNum("1");
	   	ipfCcmBoPgLoElementRequest.setControlConnector("1");
	   	ipfCcmBoPgLoElementRequest.setIsNotNull("1");
	   	ipfCcmBoPgLoElementRequest.setIsReadOnly("1");
	   	ipfCcmBoPgLoElementRequest.setUiType("1");
	   	ipfCcmBoPgLoElementRequest.setIsVisible("1");
	   	ipfCcmBoPgLoElementRequest.setColumnStyle("1");
	   	ipfCcmBoPgLoElementRequest.setLableStyle("1");
	   	ipfCcmBoPgLoElementRequest.setIsShowLable("1");
	   	ipfCcmBoPgLoElementRequest.setIsInline("1");
	   	ipfCcmBoPgLoElementRequest.setTabIndex("1");
	   	ipfCcmBoPgLoElementRequest.setDefaultValue("1");
	   	ipfCcmBoPgLoElementRequest.setInitValueType("1");
	   	ipfCcmBoPgLoElementRequest.setCorrectType("1");
	   	ipfCcmBoPgLoElementRequest.setConditionType("1");
	   	ipfCcmBoPgLoElementRequest.setOperation("1");
	   	ipfCcmBoPgLoElementRequest.setQueryType("1");
	   	ipfCcmBoPgLoElementRequest.setRangeType("1");
	   	ipfCcmBoPgLoElementRequest.setMethodName("1");
	   	ipfCcmBoPgLoElementRequest.setPropertyName("1");
        CompositeResponse<IpfCcmBoPgLoElementUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPgLoElementRequest, IpfCcmBoPgLoElementUpdateResponse.class, "ipfCcmBoPgLoElement.updateIpfCcmBoPgLoElement", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPgLoElementUpdateResponse ipfCcmBoPgLoElementResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoPgLoElement(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPgLoElementGetRequest ipfCcmBoPgLoElementRequest = new IpfCcmBoPgLoElementGetRequest();
	   	ipfCcmBoPgLoElementRequest.setId("1");
        CompositeResponse<IpfCcmBoPgLoElementGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPgLoElementRequest, IpfCcmBoPgLoElementGetResponse.class, "ipfCcmBoPgLoElement.getIpfCcmBoPgLoElement", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPgLoElementGetResponse ipfCcmBoPgLoElementResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPgLoElementSelectAllRequest ipfCcmBoPgLoElementRequest = new IpfCcmBoPgLoElementSelectAllRequest();

        CompositeResponse<IpfCcmBoPgLoElementSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPgLoElementRequest, IpfCcmBoPgLoElementSelectAllResponse.class, "ipfCcmBoPgLoElement.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPgLoElementSelectAllResponse ipfCcmBoPgLoElementResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPgLoElementCountAllRequest ipfCcmBoPgLoElementRequest = new IpfCcmBoPgLoElementCountAllRequest();

        CompositeResponse<IpfCcmBoPgLoElementCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPgLoElementRequest, IpfCcmBoPgLoElementCountAllResponse.class, "ipfCcmBoPgLoElement.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPgLoElementCountAllResponse ipfCcmBoPgLoElementResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoPgLoElementResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoPgLoElement(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPgLoElementSelectRequest ipfCcmBoPgLoElementRequest = new IpfCcmBoPgLoElementSelectRequest();
	   	ipfCcmBoPgLoElementRequest.setId("1");
	   	ipfCcmBoPgLoElementRequest.setIpfCcmBoPageLayoutId("1");
	   	ipfCcmBoPgLoElementRequest.setSeqNo("1");
	   	ipfCcmBoPgLoElementRequest.setLayoutElementType("1");
	   	ipfCcmBoPgLoElementRequest.setLayoutBoName("1");
	   	ipfCcmBoPgLoElementRequest.setControlHeight("1");
	   	ipfCcmBoPgLoElementRequest.setControlWidth("1");
	   	ipfCcmBoPgLoElementRequest.setTextLineNum("1");
	   	ipfCcmBoPgLoElementRequest.setControlConnector("1");
	   	ipfCcmBoPgLoElementRequest.setIsNotNull("1");
	   	ipfCcmBoPgLoElementRequest.setIsReadOnly("1");
	   	ipfCcmBoPgLoElementRequest.setUiType("1");
	   	ipfCcmBoPgLoElementRequest.setIsVisible("1");
	   	ipfCcmBoPgLoElementRequest.setColumnStyle("1");
	   	ipfCcmBoPgLoElementRequest.setLableStyle("1");
	   	ipfCcmBoPgLoElementRequest.setIsShowLable("1");
	   	ipfCcmBoPgLoElementRequest.setIsInline("1");
	   	ipfCcmBoPgLoElementRequest.setTabIndex("1");
	   	ipfCcmBoPgLoElementRequest.setDefaultValue("1");
	   	ipfCcmBoPgLoElementRequest.setInitValueType("1");
	   	ipfCcmBoPgLoElementRequest.setCorrectType("1");
	   	ipfCcmBoPgLoElementRequest.setConditionType("1");
	   	ipfCcmBoPgLoElementRequest.setOperation("1");
	   	ipfCcmBoPgLoElementRequest.setQueryType("1");
	   	ipfCcmBoPgLoElementRequest.setRangeType("1");
	   	ipfCcmBoPgLoElementRequest.setMethodName("1");
	   	ipfCcmBoPgLoElementRequest.setPropertyName("1");
        CompositeResponse<IpfCcmBoPgLoElementCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPgLoElementRequest, IpfCcmBoPgLoElementCreateResponse.class, "ipfCcmBoPgLoElement.createIpfCcmBoPgLoElement", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoPgLoElementRequest.setId("1");
	   	ipfCcmBoPgLoElementRequest.setIpfCcmBoPageLayoutId("1");
	   	ipfCcmBoPgLoElementRequest.setSeqNo("1");
	   	ipfCcmBoPgLoElementRequest.setLayoutElementType("1");
	   	ipfCcmBoPgLoElementRequest.setLayoutBoName("1");
	   	ipfCcmBoPgLoElementRequest.setControlHeight("1");
	   	ipfCcmBoPgLoElementRequest.setControlWidth("1");
	   	ipfCcmBoPgLoElementRequest.setTextLineNum("1");
	   	ipfCcmBoPgLoElementRequest.setControlConnector("1");
	   	ipfCcmBoPgLoElementRequest.setIsNotNull("1");
	   	ipfCcmBoPgLoElementRequest.setIsReadOnly("1");
	   	ipfCcmBoPgLoElementRequest.setUiType("1");
	   	ipfCcmBoPgLoElementRequest.setIsVisible("1");
	   	ipfCcmBoPgLoElementRequest.setColumnStyle("1");
	   	ipfCcmBoPgLoElementRequest.setLableStyle("1");
	   	ipfCcmBoPgLoElementRequest.setIsShowLable("1");
	   	ipfCcmBoPgLoElementRequest.setIsInline("1");
	   	ipfCcmBoPgLoElementRequest.setTabIndex("1");
	   	ipfCcmBoPgLoElementRequest.setDefaultValue("1");
	   	ipfCcmBoPgLoElementRequest.setInitValueType("1");
	   	ipfCcmBoPgLoElementRequest.setCorrectType("1");
	   	ipfCcmBoPgLoElementRequest.setConditionType("1");
	   	ipfCcmBoPgLoElementRequest.setOperation("1");
	   	ipfCcmBoPgLoElementRequest.setQueryType("1");
	   	ipfCcmBoPgLoElementRequest.setRangeType("1");
	   	ipfCcmBoPgLoElementRequest.setMethodName("1");
	   	ipfCcmBoPgLoElementRequest.setPropertyName("1");
        CompositeResponse<IpfCcmBoPgLoElementSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoPgLoElementRequest, IpfCcmBoPgLoElementSelectResponse.class, "ipfCcmBoPgLoElement.selectIpfCcmBoPgLoElement", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPgLoElementSelectResponse ipfCcmBoPgLoElementResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoPgLoElementResponse.getResultJson());
        CompositeResponse<IpfCcmBoPgLoElementDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoPgLoElementRequest, IpfCcmBoPgLoElementDeleteResponse.class, "ipfCcmBoPgLoElement.deleteIpfCcmBoPgLoElement", "1.0");

    }
}
