/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.sectionPartition.dao;

import com.cartan.core.sectionPartition.domain.SectionPartition;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class SectionPartitionSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.T_SECTION_PARTITION where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        SectionPartition sectionPartition=new SectionPartition();
        sectionPartition=(SectionPartition)parameter.get("sectionPartition");

        if(StringUtils.isNotBlank(sectionPartition.getId())){
        	conditionsStr.append(" and ID = #{sectionPartition.ID} ");
        }    		
        if(StringUtils.isNotBlank(sectionPartition.getSectionName())){
        	conditionsStr.append(" and SECTION_NAME like  CONCAT('%',#{sectionPartition.SECTION_NAME},'%')");
        }
        if(StringUtils.isNotBlank(sectionPartition.getStatus())){
        	conditionsStr.append(" and STATUS like  CONCAT('%',#{sectionPartition.STATUS},'%')");
        }
        if(StringUtils.isNotBlank(sectionPartition.getModifyDate())){
        	conditionsStr.append(" and MODIFY_DATE like  CONCAT('%',#{sectionPartition.MODIFY_DATE},'%')");
        }
        if(StringUtils.isNotBlank(sectionPartition.getModifyed())){
        	conditionsStr.append(" and MODIFYED like  CONCAT('%',#{sectionPartition.MODIFYED},'%')");
        }
        if(StringUtils.isNotBlank(sectionPartition.getOwner())){
        	conditionsStr.append(" and OWNER like  CONCAT('%',#{sectionPartition.OWNER},'%')");
        }
        if(StringUtils.isNotBlank(sectionPartition.getLocked())){
        	conditionsStr.append(" and LOCKED like  CONCAT('%',#{sectionPartition.LOCKED},'%')");
        }
        return  conditionsStr.toString();
    }
}


