/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlConstraint.dao;

import com.cartan.core.ipfDmlConstraint.domain.IpfDmlConstraint;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlConstraintSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_constraint where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlConstraint ipfDmlConstraint=new IpfDmlConstraint();
        ipfDmlConstraint=(IpfDmlConstraint)parameter.get("ipfDmlConstraint");

        if(StringUtils.isNotBlank(ipfDmlConstraint.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlConstraint.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlConstraint.getIpfDmlTableId())){
        	conditionsStr.append(" and IPF_DML_TABLE_ID like  CONCAT('%',#{ipfDmlConstraint.IPF_DML_TABLE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlConstraint.getConstraintName())){
        	conditionsStr.append(" and CONSTRAINT_NAME like  CONCAT('%',#{ipfDmlConstraint.CONSTRAINT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlConstraint.getConstraintType())){
        	conditionsStr.append(" and CONSTRAINT_TYPE like  CONCAT('%',#{ipfDmlConstraint.CONSTRAINT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlConstraint.getColumnName())){
        	conditionsStr.append(" and COLUMN_NAME like  CONCAT('%',#{ipfDmlConstraint.COLUMN_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlConstraint.getForeignTableName())){
        	conditionsStr.append(" and FOREIGN_TABLE_NAME like  CONCAT('%',#{ipfDmlConstraint.FOREIGN_TABLE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlConstraint.getForeignColumnName())){
        	conditionsStr.append(" and FOREIGN_COLUMN_NAME like  CONCAT('%',#{ipfDmlConstraint.FOREIGN_COLUMN_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}


