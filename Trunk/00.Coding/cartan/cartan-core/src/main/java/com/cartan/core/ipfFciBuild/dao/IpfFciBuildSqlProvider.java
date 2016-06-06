/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfFciBuild.dao;

import com.cartan.core.ipfFciBuild.domain.IpfFciBuild;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfFciBuildSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_fci_build where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfFciBuild ipfFciBuild=new IpfFciBuild();
        ipfFciBuild=(IpfFciBuild)parameter.get("ipfFciBuild");

        if(StringUtils.isNotBlank(ipfFciBuild.getId())){
        	conditionsStr.append(" and ID = #{ipfFciBuild.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfFciBuild.getIpfFciViewId())){
        	conditionsStr.append(" and IPF_FCI_VIEW_ID like  CONCAT('%',#{ipfFciBuild.IPF_FCI_VIEW_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciBuild.getIpfFciProjectId())){
        	conditionsStr.append(" and IPF_FCI_PROJECT_ID like  CONCAT('%',#{ipfFciBuild.IPF_FCI_PROJECT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciBuild.getMajorVersion())){
        	conditionsStr.append(" and MAJOR_VERSION like  CONCAT('%',#{ipfFciBuild.MAJOR_VERSION},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciBuild.getMinorVersion())){
        	conditionsStr.append(" and MINOR_VERSION like  CONCAT('%',#{ipfFciBuild.MINOR_VERSION},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciBuild.getMaxVersionBuildNumber())){
        	conditionsStr.append(" and MAX_VERSION_BUILD_NUMBER like  CONCAT('%',#{ipfFciBuild.MAX_VERSION_BUILD_NUMBER},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciBuild.getIsDefault())){
        	conditionsStr.append(" and IS_DEFAULT like  CONCAT('%',#{ipfFciBuild.IS_DEFAULT},'%')");
        }
        return  conditionsStr.toString();
    }
}


