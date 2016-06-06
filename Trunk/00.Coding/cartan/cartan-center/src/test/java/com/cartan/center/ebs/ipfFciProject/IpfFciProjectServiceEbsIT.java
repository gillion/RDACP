/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciProject;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfFciProject.request.*;
import com.cartan.center.ebs.ipfFciProject.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfFciProjectServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfFciProjectServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciProjectGetSessionRequest ipfFciProjectRequest = new IpfFciProjectGetSessionRequest();
     	CompositeResponse<IpfFciProjectGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfFciProjectRequest, IpfFciProjectGetSessionResponse.class, "ipfFciProject.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfFciProject(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciProjectCreateRequest ipfFciProjectRequest = new IpfFciProjectCreateRequest();
	   	ipfFciProjectRequest.setId("1");
	   	ipfFciProjectRequest.setProjectName("1");
	   	ipfFciProjectRequest.setProjectType("1");
	   	ipfFciProjectRequest.setProjectDes("1");
	   	ipfFciProjectRequest.setDefaultViewId("1");
	   	ipfFciProjectRequest.setSvnRepositoryPath("1");
	   	ipfFciProjectRequest.setSvnUser("1");
	   	ipfFciProjectRequest.setSvnPassword("1");
	   	ipfFciProjectRequest.setMaxRevisonNumber("1");
	   	ipfFciProjectRequest.setDdLanguage("1");
	   	ipfFciProjectRequest.setDbType("1");
	   	ipfFciProjectRequest.setDbVersion("1");
	   	ipfFciProjectRequest.setIsActive("1");
        CompositeResponse<IpfFciProjectCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciProjectRequest, IpfFciProjectCreateResponse.class, "ipfFciProject.createIpfFciProject", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciProjectCreateResponse ipfFciProjectResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfFciProject(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciProjectDeleteRequest ipfFciProjectRequest = new IpfFciProjectDeleteRequest();
	   	ipfFciProjectRequest.setId("1");
        CompositeResponse<IpfFciProjectDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfFciProjectRequest, IpfFciProjectDeleteResponse.class, "ipfFciProject.deleteIpfFciProject", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciProjectDeleteResponse ipfFciProjectResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfFciProject(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciProjectUpdateRequest ipfFciProjectRequest = new IpfFciProjectUpdateRequest();
	   	ipfFciProjectRequest.setId("1");
	   	ipfFciProjectRequest.setProjectName("1");
	   	ipfFciProjectRequest.setProjectType("1");
	   	ipfFciProjectRequest.setProjectDes("1");
	   	ipfFciProjectRequest.setDefaultViewId("1");
	   	ipfFciProjectRequest.setSvnRepositoryPath("1");
	   	ipfFciProjectRequest.setSvnUser("1");
	   	ipfFciProjectRequest.setSvnPassword("1");
	   	ipfFciProjectRequest.setMaxRevisonNumber("1");
	   	ipfFciProjectRequest.setDdLanguage("1");
	   	ipfFciProjectRequest.setDbType("1");
	   	ipfFciProjectRequest.setDbVersion("1");
	   	ipfFciProjectRequest.setIsActive("1");
        CompositeResponse<IpfFciProjectUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfFciProjectRequest, IpfFciProjectUpdateResponse.class, "ipfFciProject.updateIpfFciProject", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciProjectUpdateResponse ipfFciProjectResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfFciProject(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciProjectGetRequest ipfFciProjectRequest = new IpfFciProjectGetRequest();
	   	ipfFciProjectRequest.setId("1");
        CompositeResponse<IpfFciProjectGetResponse> response =
                ropClient.buildClientRequest().get(ipfFciProjectRequest, IpfFciProjectGetResponse.class, "ipfFciProject.getIpfFciProject", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciProjectGetResponse ipfFciProjectResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciProjectSelectAllRequest ipfFciProjectRequest = new IpfFciProjectSelectAllRequest();

        CompositeResponse<IpfFciProjectSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciProjectRequest, IpfFciProjectSelectAllResponse.class, "ipfFciProject.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciProjectSelectAllResponse ipfFciProjectResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciProjectCountAllRequest ipfFciProjectRequest = new IpfFciProjectCountAllRequest();

        CompositeResponse<IpfFciProjectCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfFciProjectRequest, IpfFciProjectCountAllResponse.class, "ipfFciProject.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciProjectCountAllResponse ipfFciProjectResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfFciProjectResponse.getResultString());
    }

    @Test
    public void selectIpfFciProject(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfFciProjectSelectRequest ipfFciProjectRequest = new IpfFciProjectSelectRequest();
	   	ipfFciProjectRequest.setId("1");
	   	ipfFciProjectRequest.setProjectName("1");
	   	ipfFciProjectRequest.setProjectType("1");
	   	ipfFciProjectRequest.setProjectDes("1");
	   	ipfFciProjectRequest.setDefaultViewId("1");
	   	ipfFciProjectRequest.setSvnRepositoryPath("1");
	   	ipfFciProjectRequest.setSvnUser("1");
	   	ipfFciProjectRequest.setSvnPassword("1");
	   	ipfFciProjectRequest.setMaxRevisonNumber("1");
	   	ipfFciProjectRequest.setDdLanguage("1");
	   	ipfFciProjectRequest.setDbType("1");
	   	ipfFciProjectRequest.setDbVersion("1");
	   	ipfFciProjectRequest.setIsActive("1");
        CompositeResponse<IpfFciProjectCreateResponse> response =
                ropClient.buildClientRequest().get(ipfFciProjectRequest, IpfFciProjectCreateResponse.class, "ipfFciProject.createIpfFciProject", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfFciProjectRequest.setId("1");
	   	ipfFciProjectRequest.setProjectName("1");
	   	ipfFciProjectRequest.setProjectType("1");
	   	ipfFciProjectRequest.setProjectDes("1");
	   	ipfFciProjectRequest.setDefaultViewId("1");
	   	ipfFciProjectRequest.setSvnRepositoryPath("1");
	   	ipfFciProjectRequest.setSvnUser("1");
	   	ipfFciProjectRequest.setSvnPassword("1");
	   	ipfFciProjectRequest.setMaxRevisonNumber("1");
	   	ipfFciProjectRequest.setDdLanguage("1");
	   	ipfFciProjectRequest.setDbType("1");
	   	ipfFciProjectRequest.setDbVersion("1");
	   	ipfFciProjectRequest.setIsActive("1");
        CompositeResponse<IpfFciProjectSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfFciProjectRequest, IpfFciProjectSelectResponse.class, "ipfFciProject.selectIpfFciProject", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfFciProjectSelectResponse ipfFciProjectResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfFciProjectResponse.getResultJson());
        CompositeResponse<IpfFciProjectDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfFciProjectRequest, IpfFciProjectDeleteResponse.class, "ipfFciProject.deleteIpfFciProject", "1.0");

    }
}
