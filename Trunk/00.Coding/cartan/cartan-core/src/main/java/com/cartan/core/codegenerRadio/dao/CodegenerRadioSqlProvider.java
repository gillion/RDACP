/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.codegenerRadio.dao;

import com.cartan.core.codegenerRadio.domain.CodegenerRadio;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class CodegenerRadioSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_codegener_radio where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        CodegenerRadio codegenerRadio=new CodegenerRadio();
        codegenerRadio=(CodegenerRadio)parameter.get("codegenerRadio");

        if(StringUtils.isNotBlank(codegenerRadio.getId())){
        	conditionsStr.append(" and ID = #{codegenerRadio.ID} ");
        }    		
        if(StringUtils.isNotBlank(codegenerRadio.getSetupId())){
        	conditionsStr.append(" and SETUP_ID like  CONCAT('%',#{codegenerRadio.SETUP_ID},'%')");
        }
        if(StringUtils.isNotBlank(codegenerRadio.getTableId())){
        	conditionsStr.append(" and TABLE_ID like  CONCAT('%',#{codegenerRadio.TABLE_ID},'%')");
        }
        if(StringUtils.isNotBlank(codegenerRadio.getRadioField())){
        	conditionsStr.append(" and RADIO_FIELD like  CONCAT('%',#{codegenerRadio.RADIO_FIELD},'%')");
        }
        if(StringUtils.isNotBlank(codegenerRadio.getCodeType())){
        	conditionsStr.append(" and CODE_TYPE like  CONCAT('%',#{codegenerRadio.CODE_TYPE},'%')");
        }
        return  conditionsStr.toString();
    }
}


