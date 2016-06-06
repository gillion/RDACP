/**
 * Copyright：中软海晟信息科技有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core;

import com.cartan.core.app.domain.App;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class SqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("");

        if(parameter.get("SqlStr")!=null){
            String SqlStr = parameter.get("SqlStr").toString();
            conditionsStr.append(SqlStr);
        }

        return  conditionsStr.toString();
    }
}


