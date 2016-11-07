/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.comstyle.dao;

import com.cartan.core.comstyle.domain.Comstyle;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class ComstyleSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_comstyle where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        Comstyle comstyle=new Comstyle();
        comstyle=(Comstyle)parameter.get("comstyle");

        if(StringUtils.isNotBlank(comstyle.getId())){
        	conditionsStr.append(" and ID = #{comstyle.ID} ");
        }    		
        if(StringUtils.isNotBlank(comstyle.getCode())){
        	conditionsStr.append(" and CODE like  CONCAT('%',#{comstyle.CODE},'%')");
        }
        if(StringUtils.isNotBlank(comstyle.getName())){
        	conditionsStr.append(" and NAME like  CONCAT('%',#{comstyle.NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}


