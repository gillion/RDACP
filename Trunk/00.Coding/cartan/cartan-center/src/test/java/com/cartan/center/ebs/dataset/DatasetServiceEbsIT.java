/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.dataset;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.dataset.request.*;
import com.cartan.center.ebs.dataset.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class DatasetServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(DatasetServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetGetSessionRequest datasetRequest = new DatasetGetSessionRequest();
     	CompositeResponse<DatasetGetSessionResponse> response =
                 ropClient.buildClientRequest().get(datasetRequest, DatasetGetSessionResponse.class, "dataset.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createDataset(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetCreateRequest datasetRequest = new DatasetCreateRequest();
	   	datasetRequest.setId("1");
	   	datasetRequest.setDatasetName("1");
	   	datasetRequest.setDatasetDes("1");
	   	datasetRequest.setDatasetType("1");
	   	datasetRequest.setRemark("1");
        CompositeResponse<DatasetCreateResponse> response =
                ropClient.buildClientRequest().get(datasetRequest, DatasetCreateResponse.class, "dataset.createDataset", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetCreateResponse datasetResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteDataset(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetDeleteRequest datasetRequest = new DatasetDeleteRequest();
	   	datasetRequest.setId("1");
        CompositeResponse<DatasetDeleteResponse> response =
                ropClient.buildClientRequest().get(datasetRequest, DatasetDeleteResponse.class, "dataset.deleteDataset", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetDeleteResponse datasetResponse = response.getSuccessResponse();
    }




    @Test
    public void updateDataset(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetUpdateRequest datasetRequest = new DatasetUpdateRequest();
	   	datasetRequest.setId("1");
	   	datasetRequest.setDatasetName("1");
	   	datasetRequest.setDatasetDes("1");
	   	datasetRequest.setDatasetType("1");
	   	datasetRequest.setRemark("1");
        CompositeResponse<DatasetUpdateResponse> response =
                ropClient.buildClientRequest().get(datasetRequest, DatasetUpdateResponse.class, "dataset.updateDataset", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetUpdateResponse datasetResponse = response.getSuccessResponse();
    }


    @Test
    public void getDataset(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetGetRequest datasetRequest = new DatasetGetRequest();
	   	datasetRequest.setId("1");
        CompositeResponse<DatasetGetResponse> response =
                ropClient.buildClientRequest().get(datasetRequest, DatasetGetResponse.class, "dataset.getDataset", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetGetResponse datasetResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetSelectAllRequest datasetRequest = new DatasetSelectAllRequest();

        CompositeResponse<DatasetSelectAllResponse> response =
                ropClient.buildClientRequest().get(datasetRequest, DatasetSelectAllResponse.class, "dataset.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetSelectAllResponse datasetResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetCountAllRequest datasetRequest = new DatasetCountAllRequest();

        CompositeResponse<DatasetCountAllResponse> response =
                ropClient.buildClientRequest().get(datasetRequest, DatasetCountAllResponse.class, "dataset.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetCountAllResponse datasetResponse = response.getSuccessResponse();
        Assert.assertNotNull(datasetResponse.getResultString());
    }

    @Test
    public void selectDataset(){
        RopClient ropClient = CartanRopClient.getRopClient();
        DatasetSelectRequest datasetRequest = new DatasetSelectRequest();
	   	datasetRequest.setId("1");
	   	datasetRequest.setDatasetName("1");
	   	datasetRequest.setDatasetDes("1");
	   	datasetRequest.setDatasetType("1");
	   	datasetRequest.setRemark("1");
        CompositeResponse<DatasetCreateResponse> response =
                ropClient.buildClientRequest().get(datasetRequest, DatasetCreateResponse.class, "dataset.createDataset", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	datasetRequest.setId("1");
	   	datasetRequest.setDatasetName("1");
	   	datasetRequest.setDatasetDes("1");
	   	datasetRequest.setDatasetType("1");
	   	datasetRequest.setRemark("1");
        CompositeResponse<DatasetSelectResponse> response1 =
                ropClient.buildClientRequest().get(datasetRequest, DatasetSelectResponse.class, "dataset.selectDataset", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        DatasetSelectResponse datasetResponse = response1.getSuccessResponse();
        Assert.assertNotNull(datasetResponse.getResultJson());
        CompositeResponse<DatasetDeleteResponse> response2 =
                ropClient.buildClientRequest().get(datasetRequest, DatasetDeleteResponse.class, "dataset.deleteDataset", "1.0");

    }
}
