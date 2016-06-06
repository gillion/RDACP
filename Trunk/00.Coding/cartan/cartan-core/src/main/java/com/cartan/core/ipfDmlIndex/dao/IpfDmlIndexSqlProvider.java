/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlIndex.dao;

import com.cartan.core.ipfDmlIndex.domain.IpfDmlIndex;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlIndexSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_index where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlIndex ipfDmlIndex=new IpfDmlIndex();
        ipfDmlIndex=(IpfDmlIndex)parameter.get("ipfDmlIndex");

        if(StringUtils.isNotBlank(ipfDmlIndex.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlIndex.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlIndex.getIpfDmlTableId())){
        	conditionsStr.append(" and IPF_DML_TABLE_ID like  CONCAT('%',#{ipfDmlIndex.IPF_DML_TABLE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlIndex.getIndexName())){
        	conditionsStr.append(" and INDEX_NAME like  CONCAT('%',#{ipfDmlIndex.INDEX_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlIndex.getIndexType())){
        	conditionsStr.append(" and INDEX_TYPE like  CONCAT('%',#{ipfDmlIndex.INDEX_TYPE},'%')");
        }
        return  conditionsStr.toString();
    }
}


