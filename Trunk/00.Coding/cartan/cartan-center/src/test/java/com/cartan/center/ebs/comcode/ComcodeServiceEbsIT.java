/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.comcode;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.comcode.request.*;
import com.cartan.center.ebs.comcode.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class ComcodeServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(ComcodeServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComcodeGetSessionRequest comcodeRequest = new ComcodeGetSessionRequest();
     	CompositeResponse<ComcodeGetSessionResponse> response =
                 ropClient.buildClientRequest().get(comcodeRequest, ComcodeGetSessionResponse.class, "comcode.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createComcode(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComcodeCreateRequest comcodeRequest = new ComcodeCreateRequest();
	   	comcodeRequest.setId("1");
	   	comcodeRequest.setTypecode("1");
	   	comcodeRequest.setCode("1");
	   	comcodeRequest.setName("1");
	   	comcodeRequest.setShortname("1");
        CompositeResponse<ComcodeCreateResponse> response =
                ropClient.buildClientRequest().get(comcodeRequest, ComcodeCreateResponse.class, "comcode.createComcode", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComcodeCreateResponse comcodeResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteComcode(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComcodeDeleteRequest comcodeRequest = new ComcodeDeleteRequest();
	   	comcodeRequest.setId("1");
        CompositeResponse<ComcodeDeleteResponse> response =
                ropClient.buildClientRequest().get(comcodeRequest, ComcodeDeleteResponse.class, "comcode.deleteComcode", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComcodeDeleteResponse comcodeResponse = response.getSuccessResponse();
    }




    @Test
    public void updateComcode(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComcodeUpdateRequest comcodeRequest = new ComcodeUpdateRequest();
	   	comcodeRequest.setId("1");
	   	comcodeRequest.setTypecode("1");
	   	comcodeRequest.setCode("1");
	   	comcodeRequest.setName("1");
	   	comcodeRequest.setShortname("1");
        CompositeResponse<ComcodeUpdateResponse> response =
                ropClient.buildClientRequest().get(comcodeRequest, ComcodeUpdateResponse.class, "comcode.updateComcode", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComcodeUpdateResponse comcodeResponse = response.getSuccessResponse();
    }


    @Test
    public void getComcode(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComcodeGetRequest comcodeRequest = new ComcodeGetRequest();
	   	comcodeRequest.setId("1");
        CompositeResponse<ComcodeGetResponse> response =
                ropClient.buildClientRequest().get(comcodeRequest, ComcodeGetResponse.class, "comcode.getComcode", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComcodeGetResponse comcodeResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComcodeSelectAllRequest comcodeRequest = new ComcodeSelectAllRequest();

        CompositeResponse<ComcodeSelectAllResponse> response =
                ropClient.buildClientRequest().get(comcodeRequest, ComcodeSelectAllResponse.class, "comcode.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComcodeSelectAllResponse comcodeResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComcodeCountAllRequest comcodeRequest = new ComcodeCountAllRequest();

        CompositeResponse<ComcodeCountAllResponse> response =
                ropClient.buildClientRequest().get(comcodeRequest, ComcodeCountAllResponse.class, "comcode.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComcodeCountAllResponse comcodeResponse = response.getSuccessResponse();
        Assert.assertNotNull(comcodeResponse.getResultString());
    }

    @Test
    public void selectComcode(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ComcodeSelectRequest comcodeRequest = new ComcodeSelectRequest();
	   	comcodeRequest.setId("1");
	   	comcodeRequest.setTypecode("1");
	   	comcodeRequest.setCode("1");
	   	comcodeRequest.setName("1");
	   	comcodeRequest.setShortname("1");
        CompositeResponse<ComcodeCreateResponse> response =
                ropClient.buildClientRequest().get(comcodeRequest, ComcodeCreateResponse.class, "comcode.createComcode", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	comcodeRequest.setId("1");
	   	comcodeRequest.setTypecode("1");
	   	comcodeRequest.setCode("1");
	   	comcodeRequest.setName("1");
	   	comcodeRequest.setShortname("1");
        CompositeResponse<ComcodeSelectResponse> response1 =
                ropClient.buildClientRequest().get(comcodeRequest, ComcodeSelectResponse.class, "comcode.selectComcode", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ComcodeSelectResponse comcodeResponse = response1.getSuccessResponse();
        Assert.assertNotNull(comcodeResponse.getResultJson());
        CompositeResponse<ComcodeDeleteResponse> response2 =
                ropClient.buildClientRequest().get(comcodeRequest, ComcodeDeleteResponse.class, "comcode.deleteComcode", "1.0");

    }
}
