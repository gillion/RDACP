/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.loginUser.dao;

import com.cartan.core.loginUser.domain.LoginUser;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class LoginUserSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_login_user where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        LoginUser loginUser=new LoginUser();
        loginUser=(LoginUser)parameter.get("loginUser");

        if(StringUtils.isNotBlank(loginUser.getId())){
        	conditionsStr.append(" and id = #{loginUser.id} ");
        }    		
        if(StringUtils.isNotBlank(loginUser.getUser())){
        	conditionsStr.append(" and user like  CONCAT('%',#{loginUser.user},'%')");
        }
        if(StringUtils.isNotBlank(loginUser.getPwd())){
        	conditionsStr.append(" and pwd like  CONCAT('%',#{loginUser.pwd},'%')");
        }
        if(StringUtils.isNotBlank(loginUser.getPower())){
        	conditionsStr.append(" and power like  CONCAT('%',#{loginUser.power},'%')");
        }
        if(StringUtils.isNotBlank(loginUser.getTemplateType())){
        	conditionsStr.append(" and templateType like  CONCAT('%',#{loginUser.templateType},'%')");
        }
        return  conditionsStr.toString();
    }
}


