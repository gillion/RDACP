/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.codegenerTable.dao;

import com.cartan.core.codegenerTable.domain.CodegenerTable;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class CodegenerTableSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_codegener_table where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        CodegenerTable codegenerTable=new CodegenerTable();
        codegenerTable=(CodegenerTable)parameter.get("codegenerTable");

        if(StringUtils.isNotBlank(codegenerTable.getId())){
        	conditionsStr.append(" and ID = #{codegenerTable.ID} ");
        }    		
        if(StringUtils.isNotBlank(codegenerTable.getSetupId())){
        	conditionsStr.append(" and SETUP_ID like  CONCAT('%',#{codegenerTable.SETUP_ID},'%')");
        }
        if(StringUtils.isNotBlank(codegenerTable.getTableName())){
        	conditionsStr.append(" and TABLE_NAME like  CONCAT('%',#{codegenerTable.TABLE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(codegenerTable.getTableDes())){
        	conditionsStr.append(" and TABLE_DES like  CONCAT('%',#{codegenerTable.TABLE_DES},'%')");
        }
        if(StringUtils.isNotBlank(codegenerTable.getParentTableName())){
        	conditionsStr.append(" and PARENT_TABLE_NAME like  CONCAT('%',#{codegenerTable.PARENT_TABLE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(codegenerTable.getNoParent())){
        	conditionsStr.append(" and NO_PARENT = #{codegenerTable.NO_PARENT} ");
        }
        if(StringUtils.isNotBlank(codegenerTable.getIsNewBsclass())){
        	conditionsStr.append(" and IS_NEW_BSCLASS = #{codegenerTable.IS_NEW_BSCLASS} ");
        }
        if(StringUtils.isNotBlank(codegenerTable.getPageSize())){
        	conditionsStr.append(" and PAGE_SIZE like  CONCAT('%',#{codegenerTable.PAGE_SIZE},'%')");
        }
        return  conditionsStr.toString();
    }
}


