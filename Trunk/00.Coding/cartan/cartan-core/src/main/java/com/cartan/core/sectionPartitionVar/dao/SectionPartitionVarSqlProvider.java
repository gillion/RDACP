/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.sectionPartitionVar.dao;

import com.cartan.core.sectionPartitionVar.domain.SectionPartitionVar;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class SectionPartitionVarSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_section_partition_var where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        SectionPartitionVar sectionPartitionVar=new SectionPartitionVar();
        sectionPartitionVar=(SectionPartitionVar)parameter.get("sectionPartitionVar");

        if(StringUtils.isNotBlank(sectionPartitionVar.getId())){
        	conditionsStr.append(" and ID = #{sectionPartitionVar.ID} ");
        }    		
        if(StringUtils.isNotBlank(sectionPartitionVar.getSectionParitionId())){
        	conditionsStr.append(" and SECTION_PARITION_ID like  CONCAT('%',#{sectionPartitionVar.SECTION_PARITION_ID},'%')");
        }
        if(StringUtils.isNotBlank(sectionPartitionVar.getVarName())){
        	conditionsStr.append(" and VAR_NAME like  CONCAT('%',#{sectionPartitionVar.VAR_NAME},'%')");
        }
        if(StringUtils.isNotBlank(sectionPartitionVar.getSectionLowerMark())){
        	conditionsStr.append(" and SECTION_LOWER_MARK like  CONCAT('%',#{sectionPartitionVar.SECTION_LOWER_MARK},'%')");
        }
        if(StringUtils.isNotBlank(sectionPartitionVar.getSectionLowerLimit())){
        	conditionsStr.append(" and SECTION_LOWER_LIMIT like  CONCAT('%',#{sectionPartitionVar.SECTION_LOWER_LIMIT},'%')");
        }
        if(StringUtils.isNotBlank(sectionPartitionVar.getSectionUpperMark())){
        	conditionsStr.append(" and SECTION_UPPER_MARK like  CONCAT('%',#{sectionPartitionVar.SECTION_UPPER_MARK},'%')");
        }
        if(StringUtils.isNotBlank(sectionPartitionVar.getSectionUpperLimit())){
        	conditionsStr.append(" and SECTION_UPPER_LIMIT like  CONCAT('%',#{sectionPartitionVar.SECTION_UPPER_LIMIT},'%')");
        }
        return  conditionsStr.toString();
    }
}


