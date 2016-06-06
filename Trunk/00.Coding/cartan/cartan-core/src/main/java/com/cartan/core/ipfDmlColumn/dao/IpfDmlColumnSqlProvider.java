/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlColumn.dao;

import com.cartan.core.ipfDmlColumn.domain.IpfDmlColumn;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlColumnSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_column where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlColumn ipfDmlColumn=new IpfDmlColumn();
        ipfDmlColumn=(IpfDmlColumn)parameter.get("ipfDmlColumn");

        if(StringUtils.isNotBlank(ipfDmlColumn.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlColumn.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlColumn.getIpfDmlTableId())){
        	conditionsStr.append(" and IPF_DML_TABLE_ID like  CONCAT('%',#{ipfDmlColumn.IPF_DML_TABLE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlColumn.getColumnName())){
        	conditionsStr.append(" and COLUMN_NAME like  CONCAT('%',#{ipfDmlColumn.COLUMN_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlColumn.getIpfDmlElementId())){
        	conditionsStr.append(" and IPF_DML_ELEMENT_ID like  CONCAT('%',#{ipfDmlColumn.IPF_DML_ELEMENT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlColumn.getElementCode())){
        	conditionsStr.append(" and ELEMENT_CODE like  CONCAT('%',#{ipfDmlColumn.ELEMENT_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlColumn.getFieldText())){
        	conditionsStr.append(" and FIELD_TEXT like  CONCAT('%',#{ipfDmlColumn.FIELD_TEXT},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlColumn.getDataType())){
        	conditionsStr.append(" and DATA_TYPE like  CONCAT('%',#{ipfDmlColumn.DATA_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlColumn.getFieldLength())){
        	conditionsStr.append(" and FIELD_LENGTH like  CONCAT('%',#{ipfDmlColumn.FIELD_LENGTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlColumn.getDecimals())){
        	conditionsStr.append(" and DECIMALS like  CONCAT('%',#{ipfDmlColumn.DECIMALS},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlColumn.getIsNotNull())){
        	conditionsStr.append(" and IS_NOT_NULL like  CONCAT('%',#{ipfDmlColumn.IS_NOT_NULL},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlColumn.getIsPrimaryKey())){
        	conditionsStr.append(" and IS_PRIMARY_KEY like  CONCAT('%',#{ipfDmlColumn.IS_PRIMARY_KEY},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlColumn.getDefaultValue())){
        	conditionsStr.append(" and DEFAULT_VALUE like  CONCAT('%',#{ipfDmlColumn.DEFAULT_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlColumn.getInitValue())){
        	conditionsStr.append(" and INIT_VALUE like  CONCAT('%',#{ipfDmlColumn.INIT_VALUE},'%')");
        }
        return  conditionsStr.toString();
    }
}


