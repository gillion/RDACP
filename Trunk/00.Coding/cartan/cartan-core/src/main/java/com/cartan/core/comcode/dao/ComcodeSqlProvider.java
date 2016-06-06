/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.comcode.dao;

import com.cartan.core.comcode.domain.Comcode;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class ComcodeSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.T_COMCODE where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        Comcode comcode=new Comcode();
        comcode=(Comcode)parameter.get("comcode");

        if(StringUtils.isNotBlank(comcode.getId())){
        	conditionsStr.append(" and ID = #{comcode.ID} ");
        }    		
        if(StringUtils.isNotBlank(comcode.getTypecode())){
        	conditionsStr.append(" and TYPECODE like  CONCAT('%',#{comcode.TYPECODE},'%')");
        }
        if(StringUtils.isNotBlank(comcode.getCode())){
        	conditionsStr.append(" and CODE like  CONCAT('%',#{comcode.CODE},'%')");
        }
        if(StringUtils.isNotBlank(comcode.getName())){
        	conditionsStr.append(" and NAME like  CONCAT('%',#{comcode.NAME},'%')");
        }
        if(StringUtils.isNotBlank(comcode.getShortname())){
        	conditionsStr.append(" and SHORTNAME like  CONCAT('%',#{comcode.SHORTNAME},'%')");
        }
        return  conditionsStr.toString();
    }
}


