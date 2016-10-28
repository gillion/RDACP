/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.codegenerCombobox.dao;

import com.cartan.core.codegenerCombobox.domain.CodegenerCombobox;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class CodegenerComboboxSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_codegener_combobox where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        CodegenerCombobox codegenerCombobox=new CodegenerCombobox();
        codegenerCombobox=(CodegenerCombobox)parameter.get("codegenerCombobox");

        if(StringUtils.isNotBlank(codegenerCombobox.getId())){
        	conditionsStr.append(" and ID = #{codegenerCombobox.ID} ");
        }    		
        if(StringUtils.isNotBlank(codegenerCombobox.getSetupId())){
        	conditionsStr.append(" and SETUP_ID like  CONCAT('%',#{codegenerCombobox.SETUP_ID},'%')");
        }
        if(StringUtils.isNotBlank(codegenerCombobox.getTableId())){
        	conditionsStr.append(" and TABLE_ID like  CONCAT('%',#{codegenerCombobox.TABLE_ID},'%')");
        }
        if(StringUtils.isNotBlank(codegenerCombobox.getComboboxField())){
        	conditionsStr.append(" and COMBOBOX_FIELD like  CONCAT('%',#{codegenerCombobox.COMBOBOX_FIELD},'%')");
        }
        if(StringUtils.isNotBlank(codegenerCombobox.getCodeType())){
        	conditionsStr.append(" and CODE_TYPE like  CONCAT('%',#{codegenerCombobox.CODE_TYPE},'%')");
        }
        return  conditionsStr.toString();
    }
}


