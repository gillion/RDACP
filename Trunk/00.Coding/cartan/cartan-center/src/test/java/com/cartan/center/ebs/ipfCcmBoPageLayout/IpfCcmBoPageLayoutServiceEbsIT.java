/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoPageLayout;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoPageLayout.request.*;
import com.cartan.center.ebs.ipfCcmBoPageLayout.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoPageLayoutServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoPageLayoutServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageLayoutGetSessionRequest ipfCcmBoPageLayoutRequest = new IpfCcmBoPageLayoutGetSessionRequest();
     	CompositeResponse<IpfCcmBoPageLayoutGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoPageLayoutRequest, IpfCcmBoPageLayoutGetSessionResponse.class, "ipfCcmBoPageLayout.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoPageLayout(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageLayoutCreateRequest ipfCcmBoPageLayoutRequest = new IpfCcmBoPageLayoutCreateRequest();
	   	ipfCcmBoPageLayoutRequest.setId("1");
	   	ipfCcmBoPageLayoutRequest.setIpfCcmBoPageId("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutType("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutContainerType("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutBoName("1");
	   	ipfCcmBoPageLayoutRequest.setStyleClass("1");
	   	ipfCcmBoPageLayoutRequest.setStyle("1");
	   	ipfCcmBoPageLayoutRequest.setFormType("1");
	   	ipfCcmBoPageLayoutRequest.setElementName("1");
	   	ipfCcmBoPageLayoutRequest.setHeight("1");
	   	ipfCcmBoPageLayoutRequest.setIsShowGroup("1");
	   	ipfCcmBoPageLayoutRequest.setGroupWidget("1");
	   	ipfCcmBoPageLayoutRequest.setGroupMsgCode("1");
	   	ipfCcmBoPageLayoutRequest.setGroupTitle("1");
	   	ipfCcmBoPageLayoutRequest.setUnitCount("1");
	   	ipfCcmBoPageLayoutRequest.setIsParent("1");
	   	ipfCcmBoPageLayoutRequest.setChildrenLineCount("1");
	   	ipfCcmBoPageLayoutRequest.setCellName("1");
	   	ipfCcmBoPageLayoutRequest.setRowNo("1");
	   	ipfCcmBoPageLayoutRequest.setColumnNo("1");
	   	ipfCcmBoPageLayoutRequest.setLabelUnitCount("1");
	   	ipfCcmBoPageLayoutRequest.setSeqNo("1");
	   	ipfCcmBoPageLayoutRequest.setControlConnector("1");
	   	ipfCcmBoPageLayoutRequest.setParentCellName("1");
        CompositeResponse<IpfCcmBoPageLayoutCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageLayoutRequest, IpfCcmBoPageLayoutCreateResponse.class, "ipfCcmBoPageLayout.createIpfCcmBoPageLayout", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageLayoutCreateResponse ipfCcmBoPageLayoutResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoPageLayout(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageLayoutDeleteRequest ipfCcmBoPageLayoutRequest = new IpfCcmBoPageLayoutDeleteRequest();
	   	ipfCcmBoPageLayoutRequest.setId("1");
        CompositeResponse<IpfCcmBoPageLayoutDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageLayoutRequest, IpfCcmBoPageLayoutDeleteResponse.class, "ipfCcmBoPageLayout.deleteIpfCcmBoPageLayout", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageLayoutDeleteResponse ipfCcmBoPageLayoutResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoPageLayout(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageLayoutUpdateRequest ipfCcmBoPageLayoutRequest = new IpfCcmBoPageLayoutUpdateRequest();
	   	ipfCcmBoPageLayoutRequest.setId("1");
	   	ipfCcmBoPageLayoutRequest.setIpfCcmBoPageId("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutType("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutContainerType("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutBoName("1");
	   	ipfCcmBoPageLayoutRequest.setStyleClass("1");
	   	ipfCcmBoPageLayoutRequest.setStyle("1");
	   	ipfCcmBoPageLayoutRequest.setFormType("1");
	   	ipfCcmBoPageLayoutRequest.setElementName("1");
	   	ipfCcmBoPageLayoutRequest.setHeight("1");
	   	ipfCcmBoPageLayoutRequest.setIsShowGroup("1");
	   	ipfCcmBoPageLayoutRequest.setGroupWidget("1");
	   	ipfCcmBoPageLayoutRequest.setGroupMsgCode("1");
	   	ipfCcmBoPageLayoutRequest.setGroupTitle("1");
	   	ipfCcmBoPageLayoutRequest.setUnitCount("1");
	   	ipfCcmBoPageLayoutRequest.setIsParent("1");
	   	ipfCcmBoPageLayoutRequest.setChildrenLineCount("1");
	   	ipfCcmBoPageLayoutRequest.setCellName("1");
	   	ipfCcmBoPageLayoutRequest.setRowNo("1");
	   	ipfCcmBoPageLayoutRequest.setColumnNo("1");
	   	ipfCcmBoPageLayoutRequest.setLabelUnitCount("1");
	   	ipfCcmBoPageLayoutRequest.setSeqNo("1");
	   	ipfCcmBoPageLayoutRequest.setControlConnector("1");
	   	ipfCcmBoPageLayoutRequest.setParentCellName("1");
        CompositeResponse<IpfCcmBoPageLayoutUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageLayoutRequest, IpfCcmBoPageLayoutUpdateResponse.class, "ipfCcmBoPageLayout.updateIpfCcmBoPageLayout", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageLayoutUpdateResponse ipfCcmBoPageLayoutResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoPageLayout(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageLayoutGetRequest ipfCcmBoPageLayoutRequest = new IpfCcmBoPageLayoutGetRequest();
	   	ipfCcmBoPageLayoutRequest.setId("1");
        CompositeResponse<IpfCcmBoPageLayoutGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageLayoutRequest, IpfCcmBoPageLayoutGetResponse.class, "ipfCcmBoPageLayout.getIpfCcmBoPageLayout", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageLayoutGetResponse ipfCcmBoPageLayoutResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageLayoutSelectAllRequest ipfCcmBoPageLayoutRequest = new IpfCcmBoPageLayoutSelectAllRequest();

        CompositeResponse<IpfCcmBoPageLayoutSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageLayoutRequest, IpfCcmBoPageLayoutSelectAllResponse.class, "ipfCcmBoPageLayout.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageLayoutSelectAllResponse ipfCcmBoPageLayoutResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageLayoutCountAllRequest ipfCcmBoPageLayoutRequest = new IpfCcmBoPageLayoutCountAllRequest();

        CompositeResponse<IpfCcmBoPageLayoutCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageLayoutRequest, IpfCcmBoPageLayoutCountAllResponse.class, "ipfCcmBoPageLayout.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageLayoutCountAllResponse ipfCcmBoPageLayoutResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoPageLayoutResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoPageLayout(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoPageLayoutSelectRequest ipfCcmBoPageLayoutRequest = new IpfCcmBoPageLayoutSelectRequest();
	   	ipfCcmBoPageLayoutRequest.setId("1");
	   	ipfCcmBoPageLayoutRequest.setIpfCcmBoPageId("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutType("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutContainerType("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutBoName("1");
	   	ipfCcmBoPageLayoutRequest.setStyleClass("1");
	   	ipfCcmBoPageLayoutRequest.setStyle("1");
	   	ipfCcmBoPageLayoutRequest.setFormType("1");
	   	ipfCcmBoPageLayoutRequest.setElementName("1");
	   	ipfCcmBoPageLayoutRequest.setHeight("1");
	   	ipfCcmBoPageLayoutRequest.setIsShowGroup("1");
	   	ipfCcmBoPageLayoutRequest.setGroupWidget("1");
	   	ipfCcmBoPageLayoutRequest.setGroupMsgCode("1");
	   	ipfCcmBoPageLayoutRequest.setGroupTitle("1");
	   	ipfCcmBoPageLayoutRequest.setUnitCount("1");
	   	ipfCcmBoPageLayoutRequest.setIsParent("1");
	   	ipfCcmBoPageLayoutRequest.setChildrenLineCount("1");
	   	ipfCcmBoPageLayoutRequest.setCellName("1");
	   	ipfCcmBoPageLayoutRequest.setRowNo("1");
	   	ipfCcmBoPageLayoutRequest.setColumnNo("1");
	   	ipfCcmBoPageLayoutRequest.setLabelUnitCount("1");
	   	ipfCcmBoPageLayoutRequest.setSeqNo("1");
	   	ipfCcmBoPageLayoutRequest.setControlConnector("1");
	   	ipfCcmBoPageLayoutRequest.setParentCellName("1");
        CompositeResponse<IpfCcmBoPageLayoutCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoPageLayoutRequest, IpfCcmBoPageLayoutCreateResponse.class, "ipfCcmBoPageLayout.createIpfCcmBoPageLayout", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoPageLayoutRequest.setId("1");
	   	ipfCcmBoPageLayoutRequest.setIpfCcmBoPageId("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutType("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutContainerType("1");
	   	ipfCcmBoPageLayoutRequest.setLayoutBoName("1");
	   	ipfCcmBoPageLayoutRequest.setStyleClass("1");
	   	ipfCcmBoPageLayoutRequest.setStyle("1");
	   	ipfCcmBoPageLayoutRequest.setFormType("1");
	   	ipfCcmBoPageLayoutRequest.setElementName("1");
	   	ipfCcmBoPageLayoutRequest.setHeight("1");
	   	ipfCcmBoPageLayoutRequest.setIsShowGroup("1");
	   	ipfCcmBoPageLayoutRequest.setGroupWidget("1");
	   	ipfCcmBoPageLayoutRequest.setGroupMsgCode("1");
	   	ipfCcmBoPageLayoutRequest.setGroupTitle("1");
	   	ipfCcmBoPageLayoutRequest.setUnitCount("1");
	   	ipfCcmBoPageLayoutRequest.setIsParent("1");
	   	ipfCcmBoPageLayoutRequest.setChildrenLineCount("1");
	   	ipfCcmBoPageLayoutRequest.setCellName("1");
	   	ipfCcmBoPageLayoutRequest.setRowNo("1");
	   	ipfCcmBoPageLayoutRequest.setColumnNo("1");
	   	ipfCcmBoPageLayoutRequest.setLabelUnitCount("1");
	   	ipfCcmBoPageLayoutRequest.setSeqNo("1");
	   	ipfCcmBoPageLayoutRequest.setControlConnector("1");
	   	ipfCcmBoPageLayoutRequest.setParentCellName("1");
        CompositeResponse<IpfCcmBoPageLayoutSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoPageLayoutRequest, IpfCcmBoPageLayoutSelectResponse.class, "ipfCcmBoPageLayout.selectIpfCcmBoPageLayout", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoPageLayoutSelectResponse ipfCcmBoPageLayoutResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoPageLayoutResponse.getResultJson());
        CompositeResponse<IpfCcmBoPageLayoutDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoPageLayoutRequest, IpfCcmBoPageLayoutDeleteResponse.class, "ipfCcmBoPageLayout.deleteIpfCcmBoPageLayout", "1.0");

    }
}
