/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBo;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfCcmBo.request.*;
import com.cartan.center.ebs.ipfCcmBo.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfCcmBoServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfCcmBoServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGetSessionRequest ipfCcmBoRequest = new IpfCcmBoGetSessionRequest();
     	CompositeResponse<IpfCcmBoGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfCcmBoRequest, IpfCcmBoGetSessionResponse.class, "ipfCcmBo.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfCcmBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCreateRequest ipfCcmBoRequest = new IpfCcmBoCreateRequest();
	   	ipfCcmBoRequest.setId("1");
	   	ipfCcmBoRequest.setBoName("1");
	   	ipfCcmBoRequest.setBoType("1");
	   	ipfCcmBoRequest.setAppModule("1");
	   	ipfCcmBoRequest.setServiceType("1");
	   	ipfCcmBoRequest.setJavaPath("1");
	   	ipfCcmBoRequest.setServiceCategory("1");
	   	ipfCcmBoRequest.setTableName("1");
	   	ipfCcmBoRequest.setTableType("1");
	   	ipfCcmBoRequest.setDescription("1");
	   	ipfCcmBoRequest.setSearchColumns("1");
	   	ipfCcmBoRequest.setSearchMode("1");
	   	ipfCcmBoRequest.setPageSize("1");
	   	ipfCcmBoRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmBoRequest.setUiLayoutName("1");
	   	ipfCcmBoRequest.setFormCellMode("1");
	   	ipfCcmBoRequest.setUiTemplate("1");
	   	ipfCcmBoRequest.setFormColumns("1");
	   	ipfCcmBoRequest.setGridStyle("1");
	   	ipfCcmBoRequest.setGridAlign("1");
	   	ipfCcmBoRequest.setGridEditType("1");
	   	ipfCcmBoRequest.setGenerateOption("1");
	   	ipfCcmBoRequest.setLockRowExpress("1");
	   	ipfCcmBoRequest.setGridType("1");
	   	ipfCcmBoRequest.setIsMainObject("1");
	   	ipfCcmBoRequest.setIsInitDataBo("1");
	   	ipfCcmBoRequest.setIsAutoLoad("1");
	   	ipfCcmBoRequest.setIsNeedAdvSearch("1");
	   	ipfCcmBoRequest.setNeedPaging("1");
	   	ipfCcmBoRequest.setIsGridFilter("1");
	   	ipfCcmBoRequest.setIsGridCustom("1");
	   	ipfCcmBoRequest.setRemark("1");
	   	ipfCcmBoRequest.setWhereClause("1");
	   	ipfCcmBoRequest.setIdGenerator("1");
        CompositeResponse<IpfCcmBoCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRequest, IpfCcmBoCreateResponse.class, "ipfCcmBo.createIpfCcmBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCreateResponse ipfCcmBoResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfCcmBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoDeleteRequest ipfCcmBoRequest = new IpfCcmBoDeleteRequest();
	   	ipfCcmBoRequest.setId("1");
        CompositeResponse<IpfCcmBoDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRequest, IpfCcmBoDeleteResponse.class, "ipfCcmBo.deleteIpfCcmBo", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoDeleteResponse ipfCcmBoResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfCcmBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoUpdateRequest ipfCcmBoRequest = new IpfCcmBoUpdateRequest();
	   	ipfCcmBoRequest.setId("1");
	   	ipfCcmBoRequest.setBoName("1");
	   	ipfCcmBoRequest.setBoType("1");
	   	ipfCcmBoRequest.setAppModule("1");
	   	ipfCcmBoRequest.setServiceType("1");
	   	ipfCcmBoRequest.setJavaPath("1");
	   	ipfCcmBoRequest.setServiceCategory("1");
	   	ipfCcmBoRequest.setTableName("1");
	   	ipfCcmBoRequest.setTableType("1");
	   	ipfCcmBoRequest.setDescription("1");
	   	ipfCcmBoRequest.setSearchColumns("1");
	   	ipfCcmBoRequest.setSearchMode("1");
	   	ipfCcmBoRequest.setPageSize("1");
	   	ipfCcmBoRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmBoRequest.setUiLayoutName("1");
	   	ipfCcmBoRequest.setFormCellMode("1");
	   	ipfCcmBoRequest.setUiTemplate("1");
	   	ipfCcmBoRequest.setFormColumns("1");
	   	ipfCcmBoRequest.setGridStyle("1");
	   	ipfCcmBoRequest.setGridAlign("1");
	   	ipfCcmBoRequest.setGridEditType("1");
	   	ipfCcmBoRequest.setGenerateOption("1");
	   	ipfCcmBoRequest.setLockRowExpress("1");
	   	ipfCcmBoRequest.setGridType("1");
	   	ipfCcmBoRequest.setIsMainObject("1");
	   	ipfCcmBoRequest.setIsInitDataBo("1");
	   	ipfCcmBoRequest.setIsAutoLoad("1");
	   	ipfCcmBoRequest.setIsNeedAdvSearch("1");
	   	ipfCcmBoRequest.setNeedPaging("1");
	   	ipfCcmBoRequest.setIsGridFilter("1");
	   	ipfCcmBoRequest.setIsGridCustom("1");
	   	ipfCcmBoRequest.setRemark("1");
	   	ipfCcmBoRequest.setWhereClause("1");
	   	ipfCcmBoRequest.setIdGenerator("1");
        CompositeResponse<IpfCcmBoUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRequest, IpfCcmBoUpdateResponse.class, "ipfCcmBo.updateIpfCcmBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoUpdateResponse ipfCcmBoResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfCcmBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoGetRequest ipfCcmBoRequest = new IpfCcmBoGetRequest();
	   	ipfCcmBoRequest.setId("1");
        CompositeResponse<IpfCcmBoGetResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRequest, IpfCcmBoGetResponse.class, "ipfCcmBo.getIpfCcmBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoGetResponse ipfCcmBoResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoSelectAllRequest ipfCcmBoRequest = new IpfCcmBoSelectAllRequest();

        CompositeResponse<IpfCcmBoSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRequest, IpfCcmBoSelectAllResponse.class, "ipfCcmBo.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoSelectAllResponse ipfCcmBoResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoCountAllRequest ipfCcmBoRequest = new IpfCcmBoCountAllRequest();

        CompositeResponse<IpfCcmBoCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRequest, IpfCcmBoCountAllResponse.class, "ipfCcmBo.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoCountAllResponse ipfCcmBoResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoResponse.getResultString());
    }

    @Test
    public void selectIpfCcmBo(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfCcmBoSelectRequest ipfCcmBoRequest = new IpfCcmBoSelectRequest();
	   	ipfCcmBoRequest.setId("1");
	   	ipfCcmBoRequest.setBoName("1");
	   	ipfCcmBoRequest.setBoType("1");
	   	ipfCcmBoRequest.setAppModule("1");
	   	ipfCcmBoRequest.setServiceType("1");
	   	ipfCcmBoRequest.setJavaPath("1");
	   	ipfCcmBoRequest.setServiceCategory("1");
	   	ipfCcmBoRequest.setTableName("1");
	   	ipfCcmBoRequest.setTableType("1");
	   	ipfCcmBoRequest.setDescription("1");
	   	ipfCcmBoRequest.setSearchColumns("1");
	   	ipfCcmBoRequest.setSearchMode("1");
	   	ipfCcmBoRequest.setPageSize("1");
	   	ipfCcmBoRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmBoRequest.setUiLayoutName("1");
	   	ipfCcmBoRequest.setFormCellMode("1");
	   	ipfCcmBoRequest.setUiTemplate("1");
	   	ipfCcmBoRequest.setFormColumns("1");
	   	ipfCcmBoRequest.setGridStyle("1");
	   	ipfCcmBoRequest.setGridAlign("1");
	   	ipfCcmBoRequest.setGridEditType("1");
	   	ipfCcmBoRequest.setGenerateOption("1");
	   	ipfCcmBoRequest.setLockRowExpress("1");
	   	ipfCcmBoRequest.setGridType("1");
	   	ipfCcmBoRequest.setIsMainObject("1");
	   	ipfCcmBoRequest.setIsInitDataBo("1");
	   	ipfCcmBoRequest.setIsAutoLoad("1");
	   	ipfCcmBoRequest.setIsNeedAdvSearch("1");
	   	ipfCcmBoRequest.setNeedPaging("1");
	   	ipfCcmBoRequest.setIsGridFilter("1");
	   	ipfCcmBoRequest.setIsGridCustom("1");
	   	ipfCcmBoRequest.setRemark("1");
	   	ipfCcmBoRequest.setWhereClause("1");
	   	ipfCcmBoRequest.setIdGenerator("1");
        CompositeResponse<IpfCcmBoCreateResponse> response =
                ropClient.buildClientRequest().get(ipfCcmBoRequest, IpfCcmBoCreateResponse.class, "ipfCcmBo.createIpfCcmBo", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfCcmBoRequest.setId("1");
	   	ipfCcmBoRequest.setBoName("1");
	   	ipfCcmBoRequest.setBoType("1");
	   	ipfCcmBoRequest.setAppModule("1");
	   	ipfCcmBoRequest.setServiceType("1");
	   	ipfCcmBoRequest.setJavaPath("1");
	   	ipfCcmBoRequest.setServiceCategory("1");
	   	ipfCcmBoRequest.setTableName("1");
	   	ipfCcmBoRequest.setTableType("1");
	   	ipfCcmBoRequest.setDescription("1");
	   	ipfCcmBoRequest.setSearchColumns("1");
	   	ipfCcmBoRequest.setSearchMode("1");
	   	ipfCcmBoRequest.setPageSize("1");
	   	ipfCcmBoRequest.setIpfCcmUiLayoutId("1");
	   	ipfCcmBoRequest.setUiLayoutName("1");
	   	ipfCcmBoRequest.setFormCellMode("1");
	   	ipfCcmBoRequest.setUiTemplate("1");
	   	ipfCcmBoRequest.setFormColumns("1");
	   	ipfCcmBoRequest.setGridStyle("1");
	   	ipfCcmBoRequest.setGridAlign("1");
	   	ipfCcmBoRequest.setGridEditType("1");
	   	ipfCcmBoRequest.setGenerateOption("1");
	   	ipfCcmBoRequest.setLockRowExpress("1");
	   	ipfCcmBoRequest.setGridType("1");
	   	ipfCcmBoRequest.setIsMainObject("1");
	   	ipfCcmBoRequest.setIsInitDataBo("1");
	   	ipfCcmBoRequest.setIsAutoLoad("1");
	   	ipfCcmBoRequest.setIsNeedAdvSearch("1");
	   	ipfCcmBoRequest.setNeedPaging("1");
	   	ipfCcmBoRequest.setIsGridFilter("1");
	   	ipfCcmBoRequest.setIsGridCustom("1");
	   	ipfCcmBoRequest.setRemark("1");
	   	ipfCcmBoRequest.setWhereClause("1");
	   	ipfCcmBoRequest.setIdGenerator("1");
        CompositeResponse<IpfCcmBoSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfCcmBoRequest, IpfCcmBoSelectResponse.class, "ipfCcmBo.selectIpfCcmBo", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfCcmBoSelectResponse ipfCcmBoResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfCcmBoResponse.getResultJson());
        CompositeResponse<IpfCcmBoDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfCcmBoRequest, IpfCcmBoDeleteResponse.class, "ipfCcmBo.deleteIpfCcmBo", "1.0");

    }
}
