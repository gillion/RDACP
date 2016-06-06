/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlViewSql.dao;

import com.cartan.core.ipfDmlViewSql.domain.IpfDmlViewSql;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlViewSqlSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_view_sql where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlViewSql ipfDmlViewSql=new IpfDmlViewSql();
        ipfDmlViewSql=(IpfDmlViewSql)parameter.get("ipfDmlViewSql");

        if(StringUtils.isNotBlank(ipfDmlViewSql.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlViewSql.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlViewSql.getIpfDmlViewId())){
        	conditionsStr.append(" and IPF_DML_VIEW_ID like  CONCAT('%',#{ipfDmlViewSql.IPF_DML_VIEW_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlViewSql.getDbmsType())){
        	conditionsStr.append(" and DBMS_TYPE like  CONCAT('%',#{ipfDmlViewSql.DBMS_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlViewSql.getSqlStatement())){
        	conditionsStr.append(" and SQL_STATEMENT like  CONCAT('%',#{ipfDmlViewSql.SQL_STATEMENT},'%')");
        }
        return  conditionsStr.toString();
    }
}


