/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.loginSession.dao;

import com.cartan.core.loginSession.domain.LoginSession;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class LoginSessionSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_login_session where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        LoginSession loginSession=new LoginSession();
        loginSession=(LoginSession)parameter.get("loginSession");

        if(StringUtils.isNotBlank(loginSession.getId())){
        	conditionsStr.append(" and id = #{loginSession.id} ");
        }    		
        if(StringUtils.isNotBlank(loginSession.getSessionid())){
        	conditionsStr.append(" and sessionid like  CONCAT('%',#{loginSession.sessionid},'%')");
        }
        if(StringUtils.isNotBlank(loginSession.getLoginUser())){
        	conditionsStr.append(" and loginUser like  CONCAT('%',#{loginSession.loginUser},'%')");
        }
        if(StringUtils.isNotBlank(loginSession.getUserName())){
        	conditionsStr.append(" and UserName like  CONCAT('%',#{loginSession.UserName},'%')");
        }
        if(StringUtils.isNotBlank(loginSession.getLoginTime())){
        	conditionsStr.append(" and loginTime like  CONCAT('%',#{loginSession.loginTime},'%')");
        }
        if(StringUtils.isNotBlank(loginSession.getProjectName())){
        	conditionsStr.append(" and projectName like  CONCAT('%',#{loginSession.projectName},'%')");
        }
        return  conditionsStr.toString();
    }
}


