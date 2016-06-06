/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmShlpDetail;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmShlpDetail.request.*;
import com.cartan.center.ebs.ipfCcmShlpDetail.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmShlpDetailServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmShlpDetailServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpDetailGetSessionRequest ipfCcmShlpDetailRequest = new IpfCcmShlpDetailGetSessionRequest();
     	CompositeResponse<IpfCcmShlpDetailGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmShlpDetailRequest, IpfCcmShlpDetailGetSessionResponse.class, "ipfCcmShlpDetail.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmShlpDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpDetailCreateRequest ipfCcmShlpDetailRequest = new IpfCcmShlpDetailCreateRequest();
	   	ipfCcmShlpDetailRequest.setId("1");
	   	ipfCcmShlpDetailRequest.setIpfCcmShlpId("1");
	   	ipfCcmShlpDetailRequest.setShlpName("1");
	   	ipfCcmShlpDetailRequest.setFieldName("1");
	   	ipfCcmShlpDetailRequest.setFieldText("1");
	   	ipfCcmShlpDetailRequest.setListPosition("1");
	   	ipfCcmShlpDetailRequest.setIsVisible("1");
	   	ipfCcmShlpDetailRequest.setIsInput("1");
	   	ipfCcmShlpDetailRequest.setIsOutput("1");
	   	ipfCcmShlpDetailRequest.setDetailStatus("1");
	   	ipfCcmShlpDetailRequest.setDataType("1");
	   	ipfCcmShlpDetailRequest.setDecimals("1");
	   	ipfCcmShlpDetailRequest.setDefaultValue("1");
	   	ipfCcmShlpDetailRequest.setColumnLength("1");
	   	ipfCcmShlpDetailRequest.setConditionPosition("1");
	   	ipfCcmShlpDetailRequest.setOperation("1");
	   	ipfCcmShlpDetailRequest.setIsRollChange("1");
	   	ipfCcmShlpDetailRequest.setIsEditable("1");
	   	ipfCcmShlpDetailRequest.setDdtext("1");
	   	ipfCcmShlpDetailRequest.setIsSort("1");
	   	ipfCcmShlpDetailRequest.setSortOrder("1");
	   	ipfCcmShlpDetailRequest.setSortType("1");
        CompositeResponse<IpfCcmShlpDetailCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpDetailRequest, IpfCcmShlpDetailCreateResponse.class, "ipfCcmShlpDetail.createIpfCcmShlpDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpDetailCreateResponse ipfCcmShlpDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmShlpDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpDetailDeleteRequest ipfCcmShlpDetailRequest = new IpfCcmShlpDetailDeleteRequest();
	   	ipfCcmShlpDetailRequest.setId("1");
        CompositeResponse<IpfCcmShlpDetailDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpDetailRequest, IpfCcmShlpDetailDeleteResponse.class, "ipfCcmShlpDetail.deleteIpfCcmShlpDetail", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpDetailDeleteResponse ipfCcmShlpDetailResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmShlpDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpDetailUpdateRequest ipfCcmShlpDetailRequest = new IpfCcmShlpDetailUpdateRequest();
	   	ipfCcmShlpDetailRequest.setId("1");
	   	ipfCcmShlpDetailRequest.setIpfCcmShlpId("1");
	   	ipfCcmShlpDetailRequest.setShlpName("1");
	   	ipfCcmShlpDetailRequest.setFieldName("1");
	   	ipfCcmShlpDetailRequest.setFieldText("1");
	   	ipfCcmShlpDetailRequest.setListPosition("1");
	   	ipfCcmShlpDetailRequest.setIsVisible("1");
	   	ipfCcmShlpDetailRequest.setIsInput("1");
	   	ipfCcmShlpDetailRequest.setIsOutput("1");
	   	ipfCcmShlpDetailRequest.setDetailStatus("1");
	   	ipfCcmShlpDetailRequest.setDataType("1");
	   	ipfCcmShlpDetailRequest.setDecimals("1");
	   	ipfCcmShlpDetailRequest.setDefaultValue("1");
	   	ipfCcmShlpDetailRequest.setColumnLength("1");
	   	ipfCcmShlpDetailRequest.setConditionPosition("1");
	   	ipfCcmShlpDetailRequest.setOperation("1");
	   	ipfCcmShlpDetailRequest.setIsRollChange("1");
	   	ipfCcmShlpDetailRequest.setIsEditable("1");
	   	ipfCcmShlpDetailRequest.setDdtext("1");
	   	ipfCcmShlpDetailRequest.setIsSort("1");
	   	ipfCcmShlpDetailRequest.setSortOrder("1");
	   	ipfCcmShlpDetailRequest.setSortType("1");
        CompositeResponse<IpfCcmShlpDetailUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpDetailRequest, IpfCcmShlpDetailUpdateResponse.class, "ipfCcmShlpDetail.updateIpfCcmShlpDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpDetailUpdateResponse ipfCcmShlpDetailResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmShlpDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpDetailGetRequest ipfCcmShlpDetailRequest = new IpfCcmShlpDetailGetRequest();
	   	ipfCcmShlpDetailRequest.setId("1");
        CompositeResponse<IpfCcmShlpDetailGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpDetailRequest, IpfCcmShlpDetailGetResponse.class, "ipfCcmShlpDetail.getIpfCcmShlpDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpDetailGetResponse ipfCcmShlpDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpDetailSelectAllRequest ipfCcmShlpDetailRequest = new IpfCcmShlpDetailSelectAllRequest();

        CompositeResponse<IpfCcmShlpDetailSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpDetailRequest, IpfCcmShlpDetailSelectAllResponse.class, "ipfCcmShlpDetail.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpDetailSelectAllResponse ipfCcmShlpDetailResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpDetailCountAllRequest ipfCcmShlpDetailRequest = new IpfCcmShlpDetailCountAllRequest();

        CompositeResponse<IpfCcmShlpDetailCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpDetailRequest, IpfCcmShlpDetailCountAllResponse.class, "ipfCcmShlpDetail.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpDetailCountAllResponse ipfCcmShlpDetailResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmShlpDetailResponse.getResultString());
    }

    @Test
    public void selectIpfCcmShlpDetail(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmShlpDetailSelectRequest ipfCcmShlpDetailRequest = new IpfCcmShlpDetailSelectRequest();
	   	ipfCcmShlpDetailRequest.setId("1");
	   	ipfCcmShlpDetailRequest.setIpfCcmShlpId("1");
	   	ipfCcmShlpDetailRequest.setShlpName("1");
	   	ipfCcmShlpDetailRequest.setFieldName("1");
	   	ipfCcmShlpDetailRequest.setFieldText("1");
	   	ipfCcmShlpDetailRequest.setListPosition("1");
	   	ipfCcmShlpDetailRequest.setIsVisible("1");
	   	ipfCcmShlpDetailRequest.setIsInput("1");
	   	ipfCcmShlpDetailRequest.setIsOutput("1");
	   	ipfCcmShlpDetailRequest.setDetailStatus("1");
	   	ipfCcmShlpDetailRequest.setDataType("1");
	   	ipfCcmShlpDetailRequest.setDecimals("1");
	   	ipfCcmShlpDetailRequest.setDefaultValue("1");
	   	ipfCcmShlpDetailRequest.setColumnLength("1");
	   	ipfCcmShlpDetailRequest.setConditionPosition("1");
	   	ipfCcmShlpDetailRequest.setOperation("1");
	   	ipfCcmShlpDetailRequest.setIsRollChange("1");
	   	ipfCcmShlpDetailRequest.setIsEditable("1");
	   	ipfCcmShlpDetailRequest.setDdtext("1");
	   	ipfCcmShlpDetailRequest.setIsSort("1");
	   	ipfCcmShlpDetailRequest.setSortOrder("1");
	   	ipfCcmShlpDetailRequest.setSortType("1");
        CompositeResponse<IpfCcmShlpDetailCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmShlpDetailRequest, IpfCcmShlpDetailCreateResponse.class, "ipfCcmShlpDetail.createIpfCcmShlpDetail", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmShlpDetailRequest.setId("1");
	   	ipfCcmShlpDetailRequest.setIpfCcmShlpId("1");
	   	ipfCcmShlpDetailRequest.setShlpName("1");
	   	ipfCcmShlpDetailRequest.setFieldName("1");
	   	ipfCcmShlpDetailRequest.setFieldText("1");
	   	ipfCcmShlpDetailRequest.setListPosition("1");
	   	ipfCcmShlpDetailRequest.setIsVisible("1");
	   	ipfCcmShlpDetailRequest.setIsInput("1");
	   	ipfCcmShlpDetailRequest.setIsOutput("1");
	   	ipfCcmShlpDetailRequest.setDetailStatus("1");
	   	ipfCcmShlpDetailRequest.setDataType("1");
	   	ipfCcmShlpDetailRequest.setDecimals("1");
	   	ipfCcmShlpDetailRequest.setDefaultValue("1");
	   	ipfCcmShlpDetailRequest.setColumnLength("1");
	   	ipfCcmShlpDetailRequest.setConditionPosition("1");
	   	ipfCcmShlpDetailRequest.setOperation("1");
	   	ipfCcmShlpDetailRequest.setIsRollChange("1");
	   	ipfCcmShlpDetailRequest.setIsEditable("1");
	   	ipfCcmShlpDetailRequest.setDdtext("1");
	   	ipfCcmShlpDetailRequest.setIsSort("1");
	   	ipfCcmShlpDetailRequest.setSortOrder("1");
	   	ipfCcmShlpDetailRequest.setSortType("1");
        CompositeResponse<IpfCcmShlpDetailSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmShlpDetailRequest, IpfCcmShlpDetailSelectResponse.class, "ipfCcmShlpDetail.selectIpfCcmShlpDetail", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmShlpDetailSelectResponse ipfCcmShlpDetailResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmShlpDetailResponse.getResultJson());
        CompositeResponse<IpfCcmShlpDetailDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmShlpDetailRequest, IpfCcmShlpDetailDeleteResponse.class, "ipfCcmShlpDetail.deleteIpfCcmShlpDetail", "1.0");

    }
}
