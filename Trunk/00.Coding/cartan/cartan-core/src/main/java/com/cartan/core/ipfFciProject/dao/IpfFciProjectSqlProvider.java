/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfFciProject.dao;

import com.cartan.core.ipfFciProject.domain.IpfFciProject;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfFciProjectSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_fci_project where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfFciProject ipfFciProject=new IpfFciProject();
        ipfFciProject=(IpfFciProject)parameter.get("ipfFciProject");

        if(StringUtils.isNotBlank(ipfFciProject.getId())){
        	conditionsStr.append(" and ID = #{ipfFciProject.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfFciProject.getProjectName())){
        	conditionsStr.append(" and PROJECT_NAME like  CONCAT('%',#{ipfFciProject.PROJECT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciProject.getProjectType())){
        	conditionsStr.append(" and PROJECT_TYPE like  CONCAT('%',#{ipfFciProject.PROJECT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciProject.getProjectDes())){
        	conditionsStr.append(" and PROJECT_DES like  CONCAT('%',#{ipfFciProject.PROJECT_DES},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciProject.getDefaultViewId())){
        	conditionsStr.append(" and DEFAULT_VIEW_ID like  CONCAT('%',#{ipfFciProject.DEFAULT_VIEW_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciProject.getSvnRepositoryPath())){
        	conditionsStr.append(" and SVN_REPOSITORY_PATH like  CONCAT('%',#{ipfFciProject.SVN_REPOSITORY_PATH},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciProject.getSvnUser())){
        	conditionsStr.append(" and SVN_USER like  CONCAT('%',#{ipfFciProject.SVN_USER},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciProject.getSvnPassword())){
        	conditionsStr.append(" and SVN_PASSWORD like  CONCAT('%',#{ipfFciProject.SVN_PASSWORD},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciProject.getMaxRevisonNumber())){
        	conditionsStr.append(" and MAX_REVISON_NUMBER like  CONCAT('%',#{ipfFciProject.MAX_REVISON_NUMBER},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciProject.getDdLanguage())){
        	conditionsStr.append(" and DD_LANGUAGE like  CONCAT('%',#{ipfFciProject.DD_LANGUAGE},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciProject.getDbType())){
        	conditionsStr.append(" and DB_TYPE like  CONCAT('%',#{ipfFciProject.DB_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciProject.getDbVersion())){
        	conditionsStr.append(" and DB_VERSION like  CONCAT('%',#{ipfFciProject.DB_VERSION},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciProject.getIsActive())){
        	conditionsStr.append(" and IS_ACTIVE like  CONCAT('%',#{ipfFciProject.IS_ACTIVE},'%')");
        }
        return  conditionsStr.toString();
    }
}


