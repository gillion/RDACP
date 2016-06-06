/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfFciView.dao;

import com.cartan.core.ipfFciView.domain.IpfFciView;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfFciViewSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_fci_view where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfFciView ipfFciView=new IpfFciView();
        ipfFciView=(IpfFciView)parameter.get("ipfFciView");

        if(StringUtils.isNotBlank(ipfFciView.getId())){
        	conditionsStr.append(" and ID = #{ipfFciView.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfFciView.getViewName())){
        	conditionsStr.append(" and VIEW_NAME like  CONCAT('%',#{ipfFciView.VIEW_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciView.getProjectName())){
        	conditionsStr.append(" and PROJECT_NAME like  CONCAT('%',#{ipfFciView.PROJECT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciView.getViewDesc())){
        	conditionsStr.append(" and VIEW_DESC like  CONCAT('%',#{ipfFciView.VIEW_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciView.getSvnBranchesPath())){
        	conditionsStr.append(" and SVN_BRANCHES_PATH like  CONCAT('%',#{ipfFciView.SVN_BRANCHES_PATH},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciView.getIsActive())){
        	conditionsStr.append(" and IS_ACTIVE like  CONCAT('%',#{ipfFciView.IS_ACTIVE},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciView.getConnectionString())){
        	conditionsStr.append(" and CONNECTION_STRING like  CONCAT('%',#{ipfFciView.CONNECTION_STRING},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciView.getIpfFciProjectId())){
        	conditionsStr.append(" and IPF_FCI_PROJECT_ID like  CONCAT('%',#{ipfFciView.IPF_FCI_PROJECT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciView.getSourceLabelId())){
        	conditionsStr.append(" and SOURCE_LABEL_ID like  CONCAT('%',#{ipfFciView.SOURCE_LABEL_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciView.getIsPermissionPageOnly())){
        	conditionsStr.append(" and IS_PERMISSION_PAGE_ONLY like  CONCAT('%',#{ipfFciView.IS_PERMISSION_PAGE_ONLY},'%')");
        }
        return  conditionsStr.toString();
    }
}


