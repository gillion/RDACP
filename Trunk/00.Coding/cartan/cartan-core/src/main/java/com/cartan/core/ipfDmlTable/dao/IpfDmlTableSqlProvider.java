/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlTable.dao;

import com.cartan.core.ipfDmlTable.domain.IpfDmlTable;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlTableSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_table where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlTable ipfDmlTable=new IpfDmlTable();
        ipfDmlTable=(IpfDmlTable)parameter.get("ipfDmlTable");

        if(StringUtils.isNotBlank(ipfDmlTable.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlTable.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlTable.getTableName())){
        	conditionsStr.append(" and TABLE_NAME like  CONCAT('%',#{ipfDmlTable.TABLE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlTable.getTableType())){
        	conditionsStr.append(" and TABLE_TYPE like  CONCAT('%',#{ipfDmlTable.TABLE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlTable.getTableDesc())){
        	conditionsStr.append(" and TABLE_DESC like  CONCAT('%',#{ipfDmlTable.TABLE_DESC},'%')");
        }
        return  conditionsStr.toString();
    }
}


