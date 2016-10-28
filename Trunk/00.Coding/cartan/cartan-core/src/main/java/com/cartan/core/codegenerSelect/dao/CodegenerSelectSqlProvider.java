/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.codegenerSelect.dao;

import com.cartan.core.codegenerSelect.domain.CodegenerSelect;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class CodegenerSelectSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_codegener_select where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        CodegenerSelect codegenerSelect=new CodegenerSelect();
        codegenerSelect=(CodegenerSelect)parameter.get("codegenerSelect");

        if(StringUtils.isNotBlank(codegenerSelect.getId())){
        	conditionsStr.append(" and ID = #{codegenerSelect.ID} ");
        }    		
        if(StringUtils.isNotBlank(codegenerSelect.getSetupId())){
        	conditionsStr.append(" and SETUP_ID like  CONCAT('%',#{codegenerSelect.SETUP_ID},'%')");
        }
        if(StringUtils.isNotBlank(codegenerSelect.getTableId())){
        	conditionsStr.append(" and TABLE_ID like  CONCAT('%',#{codegenerSelect.TABLE_ID},'%')");
        }
        if(StringUtils.isNotBlank(codegenerSelect.getSelectField())){
        	conditionsStr.append(" and SELECT_FIELD like  CONCAT('%',#{codegenerSelect.SELECT_FIELD},'%')");
        }
        if(StringUtils.isNotBlank(codegenerSelect.getSelectTable())){
        	conditionsStr.append(" and SELECT_TABLE like  CONCAT('%',#{codegenerSelect.SELECT_TABLE},'%')");
        }
        if(StringUtils.isNotBlank(codegenerSelect.getSelectDes())){
        	conditionsStr.append(" and SELECT_DES like  CONCAT('%',#{codegenerSelect.SELECT_DES},'%')");
        }
        return  conditionsStr.toString();
    }
}


