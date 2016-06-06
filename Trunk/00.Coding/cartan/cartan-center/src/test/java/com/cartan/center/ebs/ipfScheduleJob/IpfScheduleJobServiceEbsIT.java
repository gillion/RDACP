/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfScheduleJob;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfScheduleJob.request.*;
import com.cartan.center.ebs.ipfScheduleJob.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfScheduleJobServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfScheduleJobServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfScheduleJobGetSessionRequest ipfScheduleJobRequest = new IpfScheduleJobGetSessionRequest();
     	CompositeResponse<IpfScheduleJobGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfScheduleJobRequest, IpfScheduleJobGetSessionResponse.class, "ipfScheduleJob.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfScheduleJob(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfScheduleJobCreateRequest ipfScheduleJobRequest = new IpfScheduleJobCreateRequest();
	   	ipfScheduleJobRequest.setId("1");
	   	ipfScheduleJobRequest.setJobName("1");
	   	ipfScheduleJobRequest.setJobGroup("1");
	   	ipfScheduleJobRequest.setJobStatus("1");
	   	ipfScheduleJobRequest.setCronExpression("1");
	   	ipfScheduleJobRequest.setJobDesc("1");
	   	ipfScheduleJobRequest.setRuleNo("1");
	   	ipfScheduleJobRequest.setJobService("1");
	   	ipfScheduleJobRequest.setJobMethod("1");
        CompositeResponse<IpfScheduleJobCreateResponse> response =
                ropClient.buildClientRequest().get(ipfScheduleJobRequest, IpfScheduleJobCreateResponse.class, "ipfScheduleJob.createIpfScheduleJob", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfScheduleJobCreateResponse ipfScheduleJobResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfScheduleJob(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfScheduleJobDeleteRequest ipfScheduleJobRequest = new IpfScheduleJobDeleteRequest();
	   	ipfScheduleJobRequest.setId("1");
        CompositeResponse<IpfScheduleJobDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfScheduleJobRequest, IpfScheduleJobDeleteResponse.class, "ipfScheduleJob.deleteIpfScheduleJob", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfScheduleJobDeleteResponse ipfScheduleJobResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfScheduleJob(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfScheduleJobUpdateRequest ipfScheduleJobRequest = new IpfScheduleJobUpdateRequest();
	   	ipfScheduleJobRequest.setId("1");
	   	ipfScheduleJobRequest.setJobName("1");
	   	ipfScheduleJobRequest.setJobGroup("1");
	   	ipfScheduleJobRequest.setJobStatus("1");
	   	ipfScheduleJobRequest.setCronExpression("1");
	   	ipfScheduleJobRequest.setJobDesc("1");
	   	ipfScheduleJobRequest.setRuleNo("1");
	   	ipfScheduleJobRequest.setJobService("1");
	   	ipfScheduleJobRequest.setJobMethod("1");
        CompositeResponse<IpfScheduleJobUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfScheduleJobRequest, IpfScheduleJobUpdateResponse.class, "ipfScheduleJob.updateIpfScheduleJob", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfScheduleJobUpdateResponse ipfScheduleJobResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfScheduleJob(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfScheduleJobGetRequest ipfScheduleJobRequest = new IpfScheduleJobGetRequest();
	   	ipfScheduleJobRequest.setId("1");
        CompositeResponse<IpfScheduleJobGetResponse> response =
                ropClient.buildClientRequest().get(ipfScheduleJobRequest, IpfScheduleJobGetResponse.class, "ipfScheduleJob.getIpfScheduleJob", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfScheduleJobGetResponse ipfScheduleJobResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfScheduleJobSelectAllRequest ipfScheduleJobRequest = new IpfScheduleJobSelectAllRequest();

        CompositeResponse<IpfScheduleJobSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfScheduleJobRequest, IpfScheduleJobSelectAllResponse.class, "ipfScheduleJob.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfScheduleJobSelectAllResponse ipfScheduleJobResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfScheduleJobCountAllRequest ipfScheduleJobRequest = new IpfScheduleJobCountAllRequest();

        CompositeResponse<IpfScheduleJobCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfScheduleJobRequest, IpfScheduleJobCountAllResponse.class, "ipfScheduleJob.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfScheduleJobCountAllResponse ipfScheduleJobResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfScheduleJobResponse.getResultString());
    }

    @Test
    public void selectIpfScheduleJob(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfScheduleJobSelectRequest ipfScheduleJobRequest = new IpfScheduleJobSelectRequest();
	   	ipfScheduleJobRequest.setId("1");
	   	ipfScheduleJobRequest.setJobName("1");
	   	ipfScheduleJobRequest.setJobGroup("1");
	   	ipfScheduleJobRequest.setJobStatus("1");
	   	ipfScheduleJobRequest.setCronExpression("1");
	   	ipfScheduleJobRequest.setJobDesc("1");
	   	ipfScheduleJobRequest.setRuleNo("1");
	   	ipfScheduleJobRequest.setJobService("1");
	   	ipfScheduleJobRequest.setJobMethod("1");
        CompositeResponse<IpfScheduleJobCreateResponse> response =
                ropClient.buildClientRequest().get(ipfScheduleJobRequest, IpfScheduleJobCreateResponse.class, "ipfScheduleJob.createIpfScheduleJob", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfScheduleJobRequest.setId("1");
	   	ipfScheduleJobRequest.setJobName("1");
	   	ipfScheduleJobRequest.setJobGroup("1");
	   	ipfScheduleJobRequest.setJobStatus("1");
	   	ipfScheduleJobRequest.setCronExpression("1");
	   	ipfScheduleJobRequest.setJobDesc("1");
	   	ipfScheduleJobRequest.setRuleNo("1");
	   	ipfScheduleJobRequest.setJobService("1");
	   	ipfScheduleJobRequest.setJobMethod("1");
        CompositeResponse<IpfScheduleJobSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfScheduleJobRequest, IpfScheduleJobSelectResponse.class, "ipfScheduleJob.selectIpfScheduleJob", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfScheduleJobSelectResponse ipfScheduleJobResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfScheduleJobResponse.getResultJson());
        CompositeResponse<IpfScheduleJobDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfScheduleJobRequest, IpfScheduleJobDeleteResponse.class, "ipfScheduleJob.deleteIpfScheduleJob", "1.0");

    }
}
