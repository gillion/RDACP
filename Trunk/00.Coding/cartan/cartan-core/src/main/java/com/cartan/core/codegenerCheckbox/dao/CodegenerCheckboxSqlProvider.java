/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.codegenerCheckbox.dao;

import com.cartan.core.codegenerCheckbox.domain.CodegenerCheckbox;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class CodegenerCheckboxSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_codegener_checkbox where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        CodegenerCheckbox codegenerCheckbox=new CodegenerCheckbox();
        codegenerCheckbox=(CodegenerCheckbox)parameter.get("codegenerCheckbox");

        if(StringUtils.isNotBlank(codegenerCheckbox.getId())){
        	conditionsStr.append(" and ID = #{codegenerCheckbox.ID} ");
        }    		
        if(StringUtils.isNotBlank(codegenerCheckbox.getSetupId())){
        	conditionsStr.append(" and SETUP_ID like  CONCAT('%',#{codegenerCheckbox.SETUP_ID},'%')");
        }
        if(StringUtils.isNotBlank(codegenerCheckbox.getTableId())){
        	conditionsStr.append(" and TABLE_ID like  CONCAT('%',#{codegenerCheckbox.TABLE_ID},'%')");
        }
        if(StringUtils.isNotBlank(codegenerCheckbox.getCheckboxField())){
        	conditionsStr.append(" and CHECKBOX_FIELD like  CONCAT('%',#{codegenerCheckbox.CHECKBOX_FIELD},'%')");
        }
        if(StringUtils.isNotBlank(codegenerCheckbox.getCodeType())){
        	conditionsStr.append(" and CODE_TYPE like  CONCAT('%',#{codegenerCheckbox.CODE_TYPE},'%')");
        }
        return  conditionsStr.toString();
    }
}


