/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlIndexColumn.dao;

import com.cartan.core.ipfDmlIndexColumn.domain.IpfDmlIndexColumn;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlIndexColumnSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_index_column where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlIndexColumn ipfDmlIndexColumn=new IpfDmlIndexColumn();
        ipfDmlIndexColumn=(IpfDmlIndexColumn)parameter.get("ipfDmlIndexColumn");

        if(StringUtils.isNotBlank(ipfDmlIndexColumn.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlIndexColumn.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlIndexColumn.getIpfDmlIndexId())){
        	conditionsStr.append(" and IPF_DML_INDEX_ID like  CONCAT('%',#{ipfDmlIndexColumn.IPF_DML_INDEX_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlIndexColumn.getColumnName())){
        	conditionsStr.append(" and COLUMN_NAME like  CONCAT('%',#{ipfDmlIndexColumn.COLUMN_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlIndexColumn.getIndexOption())){
        	conditionsStr.append(" and INDEX_OPTION like  CONCAT('%',#{ipfDmlIndexColumn.INDEX_OPTION},'%')");
        }
        return  conditionsStr.toString();
    }
}


