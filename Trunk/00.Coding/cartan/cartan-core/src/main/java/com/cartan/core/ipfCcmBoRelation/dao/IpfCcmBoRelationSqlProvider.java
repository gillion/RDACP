/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoRelation.dao;

import com.cartan.core.ipfCcmBoRelation.domain.IpfCcmBoRelation;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoRelationSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_relation where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoRelation ipfCcmBoRelation=new IpfCcmBoRelation();
        ipfCcmBoRelation=(IpfCcmBoRelation)parameter.get("ipfCcmBoRelation");

        if(StringUtils.isNotBlank(ipfCcmBoRelation.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoRelation.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoRelation.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfCcmBoRelation.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoRelation.getPropertyName())){
        	conditionsStr.append(" and PROPERTY_NAME like  CONCAT('%',#{ipfCcmBoRelation.PROPERTY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoRelation.getSubBoName())){
        	conditionsStr.append(" and SUB_BO_NAME like  CONCAT('%',#{ipfCcmBoRelation.SUB_BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoRelation.getSubBoRelType())){
        	conditionsStr.append(" and SUB_BO_REL_TYPE like  CONCAT('%',#{ipfCcmBoRelation.SUB_BO_REL_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoRelation.getObjectType())){
        	conditionsStr.append(" and OBJECT_TYPE like  CONCAT('%',#{ipfCcmBoRelation.OBJECT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoRelation.getDescription())){
        	conditionsStr.append(" and DESCRIPTION like  CONCAT('%',#{ipfCcmBoRelation.DESCRIPTION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoRelation.getSubBoOrderNo())){
        	conditionsStr.append(" and SUB_BO_ORDER_NO like  CONCAT('%',#{ipfCcmBoRelation.SUB_BO_ORDER_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoRelation.getPersistentSaveType())){
        	conditionsStr.append(" and PERSISTENT_SAVE_TYPE like  CONCAT('%',#{ipfCcmBoRelation.PERSISTENT_SAVE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoRelation.getGridEditType())){
        	conditionsStr.append(" and GRID_EDIT_TYPE like  CONCAT('%',#{ipfCcmBoRelation.GRID_EDIT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoRelation.getLinkBoName())){
        	conditionsStr.append(" and LINK_BO_NAME like  CONCAT('%',#{ipfCcmBoRelation.LINK_BO_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}


