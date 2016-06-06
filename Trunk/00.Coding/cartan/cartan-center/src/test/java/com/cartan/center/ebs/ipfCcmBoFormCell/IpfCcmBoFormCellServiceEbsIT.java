/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoFormCell;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBoFormCell.request.*;
import com.cartan.center.ebs.ipfCcmBoFormCell.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoFormCellServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoFormCellServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormCellGetSessionRequest ipfCcmBoFormCellRequest = new IpfCcmBoFormCellGetSessionRequest();
     	CompositeResponse<IpfCcmBoFormCellGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoFormCellRequest, IpfCcmBoFormCellGetSessionResponse.class, "ipfCcmBoFormCell.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBoFormCell(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormCellCreateRequest ipfCcmBoFormCellRequest = new IpfCcmBoFormCellCreateRequest();
	   	ipfCcmBoFormCellRequest.setId("1");
	   	ipfCcmBoFormCellRequest.setIpfCcmBoId("1");
	   	ipfCcmBoFormCellRequest.setFormType("1");
	   	ipfCcmBoFormCellRequest.setIsDefault("1");
	   	ipfCcmBoFormCellRequest.setCellName("1");
	   	ipfCcmBoFormCellRequest.setCellType("1");
	   	ipfCcmBoFormCellRequest.setCellHeigh("1");
	   	ipfCcmBoFormCellRequest.setIsShowGroup("1");
	   	ipfCcmBoFormCellRequest.setGroupWidget("1");
	   	ipfCcmBoFormCellRequest.setElementCode("1");
	   	ipfCcmBoFormCellRequest.setGroupTitle("1");
	   	ipfCcmBoFormCellRequest.setUnitCount("1");
	   	ipfCcmBoFormCellRequest.setIsParent("1");
	   	ipfCcmBoFormCellRequest.setChildrenLineCount("1");
	   	ipfCcmBoFormCellRequest.setParentCellName("1");
	   	ipfCcmBoFormCellRequest.setRowNo("1");
	   	ipfCcmBoFormCellRequest.setColumnNo("1");
	   	ipfCcmBoFormCellRequest.setLabelUnitCount("1");
        CompositeResponse<IpfCcmBoFormCellCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormCellRequest, IpfCcmBoFormCellCreateResponse.class, "ipfCcmBoFormCell.createIpfCcmBoFormCell", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormCellCreateResponse ipfCcmBoFormCellResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBoFormCell(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormCellDeleteRequest ipfCcmBoFormCellRequest = new IpfCcmBoFormCellDeleteRequest();
	   	ipfCcmBoFormCellRequest.setId("1");
        CompositeResponse<IpfCcmBoFormCellDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormCellRequest, IpfCcmBoFormCellDeleteResponse.class, "ipfCcmBoFormCell.deleteIpfCcmBoFormCell", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormCellDeleteResponse ipfCcmBoFormCellResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBoFormCell(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormCellUpdateRequest ipfCcmBoFormCellRequest = new IpfCcmBoFormCellUpdateRequest();
	   	ipfCcmBoFormCellRequest.setId("1");
	   	ipfCcmBoFormCellRequest.setIpfCcmBoId("1");
	   	ipfCcmBoFormCellRequest.setFormType("1");
	   	ipfCcmBoFormCellRequest.setIsDefault("1");
	   	ipfCcmBoFormCellRequest.setCellName("1");
	   	ipfCcmBoFormCellRequest.setCellType("1");
	   	ipfCcmBoFormCellRequest.setCellHeigh("1");
	   	ipfCcmBoFormCellRequest.setIsShowGroup("1");
	   	ipfCcmBoFormCellRequest.setGroupWidget("1");
	   	ipfCcmBoFormCellRequest.setElementCode("1");
	   	ipfCcmBoFormCellRequest.setGroupTitle("1");
	   	ipfCcmBoFormCellRequest.setUnitCount("1");
	   	ipfCcmBoFormCellRequest.setIsParent("1");
	   	ipfCcmBoFormCellRequest.setChildrenLineCount("1");
	   	ipfCcmBoFormCellRequest.setParentCellName("1");
	   	ipfCcmBoFormCellRequest.setRowNo("1");
	   	ipfCcmBoFormCellRequest.setColumnNo("1");
	   	ipfCcmBoFormCellRequest.setLabelUnitCount("1");
        CompositeResponse<IpfCcmBoFormCellUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormCellRequest, IpfCcmBoFormCellUpdateResponse.class, "ipfCcmBoFormCell.updateIpfCcmBoFormCell", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormCellUpdateResponse ipfCcmBoFormCellResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBoFormCell(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormCellGetRequest ipfCcmBoFormCellRequest = new IpfCcmBoFormCellGetRequest();
	   	ipfCcmBoFormCellRequest.setId("1");
        CompositeResponse<IpfCcmBoFormCellGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormCellRequest, IpfCcmBoFormCellGetResponse.class, "ipfCcmBoFormCell.getIpfCcmBoFormCell", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormCellGetResponse ipfCcmBoFormCellResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormCellSelectAllRequest ipfCcmBoFormCellRequest = new IpfCcmBoFormCellSelectAllRequest();

        CompositeResponse<IpfCcmBoFormCellSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormCellRequest, IpfCcmBoFormCellSelectAllResponse.class, "ipfCcmBoFormCell.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormCellSelectAllResponse ipfCcmBoFormCellResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormCellCountAllRequest ipfCcmBoFormCellRequest = new IpfCcmBoFormCellCountAllRequest();

        CompositeResponse<IpfCcmBoFormCellCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormCellRequest, IpfCcmBoFormCellCountAllResponse.class, "ipfCcmBoFormCell.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormCellCountAllResponse ipfCcmBoFormCellResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoFormCellResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBoFormCell(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoFormCellSelectRequest ipfCcmBoFormCellRequest = new IpfCcmBoFormCellSelectRequest();
	   	ipfCcmBoFormCellRequest.setId("1");
	   	ipfCcmBoFormCellRequest.setIpfCcmBoId("1");
	   	ipfCcmBoFormCellRequest.setFormType("1");
	   	ipfCcmBoFormCellRequest.setIsDefault("1");
	   	ipfCcmBoFormCellRequest.setCellName("1");
	   	ipfCcmBoFormCellRequest.setCellType("1");
	   	ipfCcmBoFormCellRequest.setCellHeigh("1");
	   	ipfCcmBoFormCellRequest.setIsShowGroup("1");
	   	ipfCcmBoFormCellRequest.setGroupWidget("1");
	   	ipfCcmBoFormCellRequest.setElementCode("1");
	   	ipfCcmBoFormCellRequest.setGroupTitle("1");
	   	ipfCcmBoFormCellRequest.setUnitCount("1");
	   	ipfCcmBoFormCellRequest.setIsParent("1");
	   	ipfCcmBoFormCellRequest.setChildrenLineCount("1");
	   	ipfCcmBoFormCellRequest.setParentCellName("1");
	   	ipfCcmBoFormCellRequest.setRowNo("1");
	   	ipfCcmBoFormCellRequest.setColumnNo("1");
	   	ipfCcmBoFormCellRequest.setLabelUnitCount("1");
        CompositeResponse<IpfCcmBoFormCellCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoFormCellRequest, IpfCcmBoFormCellCreateResponse.class, "ipfCcmBoFormCell.createIpfCcmBoFormCell", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoFormCellRequest.setId("1");
	   	ipfCcmBoFormCellRequest.setIpfCcmBoId("1");
	   	ipfCcmBoFormCellRequest.setFormType("1");
	   	ipfCcmBoFormCellRequest.setIsDefault("1");
	   	ipfCcmBoFormCellRequest.setCellName("1");
	   	ipfCcmBoFormCellRequest.setCellType("1");
	   	ipfCcmBoFormCellRequest.setCellHeigh("1");
	   	ipfCcmBoFormCellRequest.setIsShowGroup("1");
	   	ipfCcmBoFormCellRequest.setGroupWidget("1");
	   	ipfCcmBoFormCellRequest.setElementCode("1");
	   	ipfCcmBoFormCellRequest.setGroupTitle("1");
	   	ipfCcmBoFormCellRequest.setUnitCount("1");
	   	ipfCcmBoFormCellRequest.setIsParent("1");
	   	ipfCcmBoFormCellRequest.setChildrenLineCount("1");
	   	ipfCcmBoFormCellRequest.setParentCellName("1");
	   	ipfCcmBoFormCellRequest.setRowNo("1");
	   	ipfCcmBoFormCellRequest.setColumnNo("1");
	   	ipfCcmBoFormCellRequest.setLabelUnitCount("1");
        CompositeResponse<IpfCcmBoFormCellSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoFormCellRequest, IpfCcmBoFormCellSelectResponse.class, "ipfCcmBoFormCell.selectIpfCcmBoFormCell", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoFormCellSelectResponse ipfCcmBoFormCellResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoFormCellResponse.getResultJson());
        CompositeResponse<IpfCcmBoFormCellDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoFormCellRequest, IpfCcmBoFormCellDeleteResponse.class, "ipfCcmBoFormCell.deleteIpfCcmBoFormCell", "1.0");

    }
}
