/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfFciLabel.dao;

import com.cartan.core.ipfFciLabel.domain.IpfFciLabel;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfFciLabelSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_fci_label where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfFciLabel ipfFciLabel=new IpfFciLabel();
        ipfFciLabel=(IpfFciLabel)parameter.get("ipfFciLabel");

        if(StringUtils.isNotBlank(ipfFciLabel.getId())){
        	conditionsStr.append(" and ID = #{ipfFciLabel.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfFciLabel.getIpfFciViewId())){
        	conditionsStr.append(" and IPF_FCI_VIEW_ID like  CONCAT('%',#{ipfFciLabel.IPF_FCI_VIEW_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabel.getLabelName())){
        	conditionsStr.append(" and LABEL_NAME like  CONCAT('%',#{ipfFciLabel.LABEL_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabel.getLabelDesc())){
        	conditionsStr.append(" and LABEL_DESC like  CONCAT('%',#{ipfFciLabel.LABEL_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabel.getIpfFciBuildId())){
        	conditionsStr.append(" and IPF_FCI_BUILD_ID like  CONCAT('%',#{ipfFciLabel.IPF_FCI_BUILD_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabel.getMajorVersion())){
        	conditionsStr.append(" and MAJOR_VERSION like  CONCAT('%',#{ipfFciLabel.MAJOR_VERSION},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabel.getMinorVersion())){
        	conditionsStr.append(" and MINOR_VERSION like  CONCAT('%',#{ipfFciLabel.MINOR_VERSION},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabel.getVersionBuildNumber())){
        	conditionsStr.append(" and VERSION_BUILD_NUMBER like  CONCAT('%',#{ipfFciLabel.VERSION_BUILD_NUMBER},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabel.getRevisionNumber())){
        	conditionsStr.append(" and REVISION_NUMBER like  CONCAT('%',#{ipfFciLabel.REVISION_NUMBER},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabel.getSvnRevision())){
        	conditionsStr.append(" and SVN_REVISION like  CONCAT('%',#{ipfFciLabel.SVN_REVISION},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabel.getSvnTagsPath())){
        	conditionsStr.append(" and SVN_TAGS_PATH like  CONCAT('%',#{ipfFciLabel.SVN_TAGS_PATH},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabel.getIsActive())){
        	conditionsStr.append(" and IS_ACTIVE like  CONCAT('%',#{ipfFciLabel.IS_ACTIVE},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabel.getViewName())){
        	conditionsStr.append(" and VIEW_NAME like  CONCAT('%',#{ipfFciLabel.VIEW_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}


