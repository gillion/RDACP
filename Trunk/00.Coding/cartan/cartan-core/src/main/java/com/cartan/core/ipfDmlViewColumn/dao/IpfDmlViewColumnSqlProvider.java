/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlViewColumn.dao;

import com.cartan.core.ipfDmlViewColumn.domain.IpfDmlViewColumn;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlViewColumnSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_view_column where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlViewColumn ipfDmlViewColumn=new IpfDmlViewColumn();
        ipfDmlViewColumn=(IpfDmlViewColumn)parameter.get("ipfDmlViewColumn");

        if(StringUtils.isNotBlank(ipfDmlViewColumn.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlViewColumn.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlViewColumn.getIpfDmlViewId())){
        	conditionsStr.append(" and IPF_DML_VIEW_ID like  CONCAT('%',#{ipfDmlViewColumn.IPF_DML_VIEW_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlViewColumn.getColumnName())){
        	conditionsStr.append(" and COLUMN_NAME like  CONCAT('%',#{ipfDmlViewColumn.COLUMN_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlViewColumn.getFieldText())){
        	conditionsStr.append(" and FIELD_TEXT like  CONCAT('%',#{ipfDmlViewColumn.FIELD_TEXT},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlViewColumn.getDataType())){
        	conditionsStr.append(" and DATA_TYPE like  CONCAT('%',#{ipfDmlViewColumn.DATA_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlViewColumn.getFieldLength())){
        	conditionsStr.append(" and FIELD_LENGTH like  CONCAT('%',#{ipfDmlViewColumn.FIELD_LENGTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlViewColumn.getDecimals())){
        	conditionsStr.append(" and DECIMALS like  CONCAT('%',#{ipfDmlViewColumn.DECIMALS},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlViewColumn.getIsNotNull())){
        	conditionsStr.append(" and IS_NOT_NULL like  CONCAT('%',#{ipfDmlViewColumn.IS_NOT_NULL},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlViewColumn.getIsPrimaryKey())){
        	conditionsStr.append(" and IS_PRIMARY_KEY like  CONCAT('%',#{ipfDmlViewColumn.IS_PRIMARY_KEY},'%')");
        }
        return  conditionsStr.toString();
    }
}


