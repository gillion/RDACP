/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.datasetVar;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.datasetVar.request.*;
import com.cartan.center.ebs.datasetVar.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class DatasetVarServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(DatasetVarServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetVarGetSessionRequest datasetVarRequest = new DatasetVarGetSessionRequest();
     	CompositeResponse<DatasetVarGetSessionResponse> response =
                 ropClient.buildClientRequest().get(datasetVarRequest, DatasetVarGetSessionResponse.class, "datasetVar.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createDatasetVar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetVarCreateRequest datasetVarRequest = new DatasetVarCreateRequest();
	   	datasetVarRequest.setId("1");
	   	datasetVarRequest.setDatasetId("1");
	   	datasetVarRequest.setVarName("1");
	   	datasetVarRequest.setVarDes("1");
	   	datasetVarRequest.setIsDerived("1");
	   	datasetVarRequest.setIsSet("1");
	   	datasetVarRequest.setVarType("1");
	   	datasetVarRequest.setSpanBegin("1");
	   	datasetVarRequest.setSpanEnd("1");
	   	datasetVarRequest.setIsOutput("1");
	   	datasetVarRequest.setDefValue("1");
	   	datasetVarRequest.setRemark("1");
        CompositeResponse<DatasetVarCreateResponse> response =
                ropClient.buildClientRequest().get(datasetVarRequest, DatasetVarCreateResponse.class, "datasetVar.createDatasetVar", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetVarCreateResponse datasetVarResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteDatasetVar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetVarDeleteRequest datasetVarRequest = new DatasetVarDeleteRequest();
	   	datasetVarRequest.setId("1");
        CompositeResponse<DatasetVarDeleteResponse> response =
                ropClient.buildClientRequest().get(datasetVarRequest, DatasetVarDeleteResponse.class, "datasetVar.deleteDatasetVar", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetVarDeleteResponse datasetVarResponse = response.getSuccessResponse();
    }




    @Test
    public void updateDatasetVar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetVarUpdateRequest datasetVarRequest = new DatasetVarUpdateRequest();
	   	datasetVarRequest.setId("1");
	   	datasetVarRequest.setDatasetId("1");
	   	datasetVarRequest.setVarName("1");
	   	datasetVarRequest.setVarDes("1");
	   	datasetVarRequest.setIsDerived("1");
	   	datasetVarRequest.setIsSet("1");
	   	datasetVarRequest.setVarType("1");
	   	datasetVarRequest.setSpanBegin("1");
	   	datasetVarRequest.setSpanEnd("1");
	   	datasetVarRequest.setIsOutput("1");
	   	datasetVarRequest.setDefValue("1");
	   	datasetVarRequest.setRemark("1");
        CompositeResponse<DatasetVarUpdateResponse> response =
                ropClient.buildClientRequest().get(datasetVarRequest, DatasetVarUpdateResponse.class, "datasetVar.updateDatasetVar", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetVarUpdateResponse datasetVarResponse = response.getSuccessResponse();
    }


    @Test
    public void getDatasetVar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetVarGetRequest datasetVarRequest = new DatasetVarGetRequest();
	   	datasetVarRequest.setId("1");
        CompositeResponse<DatasetVarGetResponse> response =
                ropClient.buildClientRequest().get(datasetVarRequest, DatasetVarGetResponse.class, "datasetVar.getDatasetVar", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetVarGetResponse datasetVarResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetVarSelectAllRequest datasetVarRequest = new DatasetVarSelectAllRequest();

        CompositeResponse<DatasetVarSelectAllResponse> response =
                ropClient.buildClientRequest().get(datasetVarRequest, DatasetVarSelectAllResponse.class, "datasetVar.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetVarSelectAllResponse datasetVarResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetVarCountAllRequest datasetVarRequest = new DatasetVarCountAllRequest();

        CompositeResponse<DatasetVarCountAllResponse> response =
                ropClient.buildClientRequest().get(datasetVarRequest, DatasetVarCountAllResponse.class, "datasetVar.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetVarCountAllResponse datasetVarResponse = response.getSuccessResponse();
        Assert.assertNotNull(datasetVarResponse.getResultString());
    }

    @Test
    public void selectDatasetVar(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetVarSelectRequest datasetVarRequest = new DatasetVarSelectRequest();
	   	datasetVarRequest.setId("1");
	   	datasetVarRequest.setDatasetId("1");
	   	datasetVarRequest.setVarName("1");
	   	datasetVarRequest.setVarDes("1");
	   	datasetVarRequest.setIsDerived("1");
	   	datasetVarRequest.setIsSet("1");
	   	datasetVarRequest.setVarType("1");
	   	datasetVarRequest.setSpanBegin("1");
	   	datasetVarRequest.setSpanEnd("1");
	   	datasetVarRequest.setIsOutput("1");
	   	datasetVarRequest.setDefValue("1");
	   	datasetVarRequest.setRemark("1");
        CompositeResponse<DatasetVarCreateResponse> response =
                ropClient.buildClientRequest().get(datasetVarRequest, DatasetVarCreateResponse.class, "datasetVar.createDatasetVar", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	datasetVarRequest.setId("1");
	   	datasetVarRequest.setDatasetId("1");
	   	datasetVarRequest.setVarName("1");
	   	datasetVarRequest.setVarDes("1");
	   	datasetVarRequest.setIsDerived("1");
	   	datasetVarRequest.setIsSet("1");
	   	datasetVarRequest.setVarType("1");
	   	datasetVarRequest.setSpanBegin("1");
	   	datasetVarRequest.setSpanEnd("1");
	   	datasetVarRequest.setIsOutput("1");
	   	datasetVarRequest.setDefValue("1");
	   	datasetVarRequest.setRemark("1");
        CompositeResponse<DatasetVarSelectResponse> response1 =
                ropClient.buildClientRequest().get(datasetVarRequest, DatasetVarSelectResponse.class, "datasetVar.selectDatasetVar", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetVarSelectResponse datasetVarResponse = response1.getSuccessResponse();
        Assert.assertNotNull(datasetVarResponse.getResultJson());
        CompositeResponse<DatasetVarDeleteResponse> response2 =
                ropClient.buildClientRequest().get(datasetVarRequest, DatasetVarDeleteResponse.class, "datasetVar.deleteDatasetVar", "1.0");

    }
}
