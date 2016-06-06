/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.comstyle;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.comstyle.request.*;
import com.cartan.center.ebs.comstyle.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class ComstyleServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(ComstyleServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComstyleGetSessionRequest comstyleRequest = new ComstyleGetSessionRequest();
     	CompositeResponse<ComstyleGetSessionResponse> response =
                 ropClient.buildClientRequest().get(comstyleRequest, ComstyleGetSessionResponse.class, "comstyle.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createComstyle(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComstyleCreateRequest comstyleRequest = new ComstyleCreateRequest();
	   	comstyleRequest.setId("1");
	   	comstyleRequest.setCode("1");
	   	comstyleRequest.setName("1");
        CompositeResponse<ComstyleCreateResponse> response =
                ropClient.buildClientRequest().get(comstyleRequest, ComstyleCreateResponse.class, "comstyle.createComstyle", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComstyleCreateResponse comstyleResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteComstyle(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComstyleDeleteRequest comstyleRequest = new ComstyleDeleteRequest();
	   	comstyleRequest.setId("1");
        CompositeResponse<ComstyleDeleteResponse> response =
                ropClient.buildClientRequest().get(comstyleRequest, ComstyleDeleteResponse.class, "comstyle.deleteComstyle", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComstyleDeleteResponse comstyleResponse = response.getSuccessResponse();
    }




    @Test
    public void updateComstyle(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComstyleUpdateRequest comstyleRequest = new ComstyleUpdateRequest();
	   	comstyleRequest.setId("1");
	   	comstyleRequest.setCode("1");
	   	comstyleRequest.setName("1");
        CompositeResponse<ComstyleUpdateResponse> response =
                ropClient.buildClientRequest().get(comstyleRequest, ComstyleUpdateResponse.class, "comstyle.updateComstyle", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComstyleUpdateResponse comstyleResponse = response.getSuccessResponse();
    }


    @Test
    public void getComstyle(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComstyleGetRequest comstyleRequest = new ComstyleGetRequest();
	   	comstyleRequest.setId("1");
        CompositeResponse<ComstyleGetResponse> response =
                ropClient.buildClientRequest().get(comstyleRequest, ComstyleGetResponse.class, "comstyle.getComstyle", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComstyleGetResponse comstyleResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComstyleSelectAllRequest comstyleRequest = new ComstyleSelectAllRequest();

        CompositeResponse<ComstyleSelectAllResponse> response =
                ropClient.buildClientRequest().get(comstyleRequest, ComstyleSelectAllResponse.class, "comstyle.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComstyleSelectAllResponse comstyleResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComstyleCountAllRequest comstyleRequest = new ComstyleCountAllRequest();

        CompositeResponse<ComstyleCountAllResponse> response =
                ropClient.buildClientRequest().get(comstyleRequest, ComstyleCountAllResponse.class, "comstyle.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComstyleCountAllResponse comstyleResponse = response.getSuccessResponse();
        Assert.assertNotNull(comstyleResponse.getResultString());
    }

    @Test
    public void selectComstyle(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComstyleSelectRequest comstyleRequest = new ComstyleSelectRequest();
	   	comstyleRequest.setId("1");
	   	comstyleRequest.setCode("1");
	   	comstyleRequest.setName("1");
        CompositeResponse<ComstyleCreateResponse> response =
                ropClient.buildClientRequest().get(comstyleRequest, ComstyleCreateResponse.class, "comstyle.createComstyle", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	comstyleRequest.setId("1");
	   	comstyleRequest.setCode("1");
	   	comstyleRequest.setName("1");
        CompositeResponse<ComstyleSelectResponse> response1 =
                ropClient.buildClientRequest().get(comstyleRequest, ComstyleSelectResponse.class, "comstyle.selectComstyle", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComstyleSelectResponse comstyleResponse = response1.getSuccessResponse();
        Assert.assertNotNull(comstyleResponse.getResultJson());
        CompositeResponse<ComstyleDeleteResponse> response2 =
                ropClient.buildClientRequest().get(comstyleRequest, ComstyleDeleteResponse.class, "comstyle.deleteComstyle", "1.0");

    }
}
