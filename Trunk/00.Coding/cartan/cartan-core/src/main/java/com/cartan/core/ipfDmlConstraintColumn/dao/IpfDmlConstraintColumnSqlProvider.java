/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlConstraintColumn.dao;

import com.cartan.core.ipfDmlConstraintColumn.domain.IpfDmlConstraintColumn;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlConstraintColumnSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_constraint_column where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlConstraintColumn ipfDmlConstraintColumn=new IpfDmlConstraintColumn();
        ipfDmlConstraintColumn=(IpfDmlConstraintColumn)parameter.get("ipfDmlConstraintColumn");

        if(StringUtils.isNotBlank(ipfDmlConstraintColumn.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlConstraintColumn.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlConstraintColumn.getIpfDmlConstraintId())){
        	conditionsStr.append(" and IPF_DML_CONSTRAINT_ID like  CONCAT('%',#{ipfDmlConstraintColumn.IPF_DML_CONSTRAINT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlConstraintColumn.getColumnName())){
        	conditionsStr.append(" and COLUMN_NAME like  CONCAT('%',#{ipfDmlConstraintColumn.COLUMN_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}


