/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlViewSql;

import com.cartan.center.CartanRopClient;
import com.cartan.center.ebs.ipfDmlViewSql.request.*;
import com.cartan.center.ebs.ipfDmlViewSql.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class IpfDmlViewSqlServiceEbsIT extends UnitilsTestNG {
    static Logger logger = Logger.getLogger(IpfDmlViewSqlServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewSqlGetSessionRequest ipfDmlViewSqlRequest = new IpfDmlViewSqlGetSessionRequest();
     	CompositeResponse<IpfDmlViewSqlGetSessionResponse> response =
                 ropClient.buildClientRequest().get(ipfDmlViewSqlRequest, IpfDmlViewSqlGetSessionResponse.class, "ipfDmlViewSql.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void createIpfDmlViewSql(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewSqlCreateRequest ipfDmlViewSqlRequest = new IpfDmlViewSqlCreateRequest();
	   	ipfDmlViewSqlRequest.setId("1");
	   	ipfDmlViewSqlRequest.setIpfDmlViewId("1");
	   	ipfDmlViewSqlRequest.setDbmsType("1");
	   	ipfDmlViewSqlRequest.setSqlStatement("1");
        CompositeResponse<IpfDmlViewSqlCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewSqlRequest, IpfDmlViewSqlCreateResponse.class, "ipfDmlViewSql.createIpfDmlViewSql", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewSqlCreateResponse ipfDmlViewSqlResponse = response.getSuccessResponse();
    }

    @Test
    public void deleteIpfDmlViewSql(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewSqlDeleteRequest ipfDmlViewSqlRequest = new IpfDmlViewSqlDeleteRequest();
	   	ipfDmlViewSqlRequest.setId("1");
        CompositeResponse<IpfDmlViewSqlDeleteResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewSqlRequest, IpfDmlViewSqlDeleteResponse.class, "ipfDmlViewSql.deleteIpfDmlViewSql", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewSqlDeleteResponse ipfDmlViewSqlResponse = response.getSuccessResponse();
    }




    @Test
    public void updateIpfDmlViewSql(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewSqlUpdateRequest ipfDmlViewSqlRequest = new IpfDmlViewSqlUpdateRequest();
	   	ipfDmlViewSqlRequest.setId("1");
	   	ipfDmlViewSqlRequest.setIpfDmlViewId("1");
	   	ipfDmlViewSqlRequest.setDbmsType("1");
	   	ipfDmlViewSqlRequest.setSqlStatement("1");
        CompositeResponse<IpfDmlViewSqlUpdateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewSqlRequest, IpfDmlViewSqlUpdateResponse.class, "ipfDmlViewSql.updateIpfDmlViewSql", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewSqlUpdateResponse ipfDmlViewSqlResponse = response.getSuccessResponse();
    }


    @Test
    public void getIpfDmlViewSql(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewSqlGetRequest ipfDmlViewSqlRequest = new IpfDmlViewSqlGetRequest();
	   	ipfDmlViewSqlRequest.setId("1");
        CompositeResponse<IpfDmlViewSqlGetResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewSqlRequest, IpfDmlViewSqlGetResponse.class, "ipfDmlViewSql.getIpfDmlViewSql", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewSqlGetResponse ipfDmlViewSqlResponse = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewSqlSelectAllRequest ipfDmlViewSqlRequest = new IpfDmlViewSqlSelectAllRequest();

        CompositeResponse<IpfDmlViewSqlSelectAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewSqlRequest, IpfDmlViewSqlSelectAllResponse.class, "ipfDmlViewSql.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewSqlSelectAllResponse ipfDmlViewSqlResponse = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewSqlCountAllRequest ipfDmlViewSqlRequest = new IpfDmlViewSqlCountAllRequest();

        CompositeResponse<IpfDmlViewSqlCountAllResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewSqlRequest, IpfDmlViewSqlCountAllResponse.class, "ipfDmlViewSql.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewSqlCountAllResponse ipfDmlViewSqlResponse = response.getSuccessResponse();
        Assert.assertNotNull(ipfDmlViewSqlResponse.getResultString());
    }

    @Test
    public void selectIpfDmlViewSql(){
        RopClient ropClient = CartanRopClient.getRopClient();
        IpfDmlViewSqlSelectRequest ipfDmlViewSqlRequest = new IpfDmlViewSqlSelectRequest();
	   	ipfDmlViewSqlRequest.setId("1");
	   	ipfDmlViewSqlRequest.setIpfDmlViewId("1");
	   	ipfDmlViewSqlRequest.setDbmsType("1");
	   	ipfDmlViewSqlRequest.setSqlStatement("1");
        CompositeResponse<IpfDmlViewSqlCreateResponse> response =
                ropClient.buildClientRequest().get(ipfDmlViewSqlRequest, IpfDmlViewSqlCreateResponse.class, "ipfDmlViewSql.createIpfDmlViewSql", "1.0");
        Assert.assertTrue(response.isSuccessful());
	   	ipfDmlViewSqlRequest.setId("1");
	   	ipfDmlViewSqlRequest.setIpfDmlViewId("1");
	   	ipfDmlViewSqlRequest.setDbmsType("1");
	   	ipfDmlViewSqlRequest.setSqlStatement("1");
        CompositeResponse<IpfDmlViewSqlSelectResponse> response1 =
                ropClient.buildClientRequest().get(ipfDmlViewSqlRequest, IpfDmlViewSqlSelectResponse.class, "ipfDmlViewSql.selectIpfDmlViewSql", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        IpfDmlViewSqlSelectResponse ipfDmlViewSqlResponse = response1.getSuccessResponse();
        Assert.assertNotNull(ipfDmlViewSqlResponse.getResultJson());
        CompositeResponse<IpfDmlViewSqlDeleteResponse> response2 =
                ropClient.buildClientRequest().get(ipfDmlViewSqlRequest, IpfDmlViewSqlDeleteResponse.class, "ipfDmlViewSql.deleteIpfDmlViewSql", "1.0");

    }
}
