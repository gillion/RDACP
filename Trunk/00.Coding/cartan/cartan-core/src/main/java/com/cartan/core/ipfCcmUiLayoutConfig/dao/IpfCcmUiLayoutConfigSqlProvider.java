/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmUiLayoutConfig.dao;

import com.cartan.core.ipfCcmUiLayoutConfig.domain.IpfCcmUiLayoutConfig;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmUiLayoutConfigSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_ui_layout_config where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig=new IpfCcmUiLayoutConfig();
        ipfCcmUiLayoutConfig=(IpfCcmUiLayoutConfig)parameter.get("ipfCcmUiLayoutConfig");

        if(StringUtils.isNotBlank(ipfCcmUiLayoutConfig.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmUiLayoutConfig.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmUiLayoutConfig.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfCcmUiLayoutConfig.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutConfig.getBoId())){
        	conditionsStr.append(" and BO_ID like  CONCAT('%',#{ipfCcmUiLayoutConfig.BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutConfig.getPageName())){
        	conditionsStr.append(" and PAGE_NAME like  CONCAT('%',#{ipfCcmUiLayoutConfig.PAGE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutConfig.getLayoutElementName())){
        	conditionsStr.append(" and LAYOUT_ELEMENT_NAME like  CONCAT('%',#{ipfCcmUiLayoutConfig.LAYOUT_ELEMENT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutConfig.getLayoutElementDescription())){
        	conditionsStr.append(" and LAYOUT_ELEMENT_DESCRIPTION like  CONCAT('%',#{ipfCcmUiLayoutConfig.LAYOUT_ELEMENT_DESCRIPTION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutConfig.getBoName())){
        	conditionsStr.append(" and BO_NAME like  CONCAT('%',#{ipfCcmUiLayoutConfig.BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutConfig.getBoElementName())){
        	conditionsStr.append(" and BO_ELEMENT_NAME like  CONCAT('%',#{ipfCcmUiLayoutConfig.BO_ELEMENT_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}


