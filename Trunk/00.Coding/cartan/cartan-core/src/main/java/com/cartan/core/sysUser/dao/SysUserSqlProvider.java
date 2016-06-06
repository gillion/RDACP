/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.sysUser.dao;

import com.cartan.core.sysUser.domain.SysUser;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class SysUserSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_sys_user where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        SysUser sysUser=new SysUser();
        sysUser=(SysUser)parameter.get("sysUser");

        if(StringUtils.isNotBlank(sysUser.getUserId())){
        	conditionsStr.append(" and user_id = #{sysUser.user_id} ");
        }    		
        if(StringUtils.isNotBlank(sysUser.getUserName())){
        	conditionsStr.append(" and user_name like  CONCAT('%',#{sysUser.user_name},'%')");
        }
        if(StringUtils.isNotBlank(sysUser.getPassword())){
        	conditionsStr.append(" and password like  CONCAT('%',#{sysUser.password},'%')");
        }
        if(StringUtils.isNotBlank(sysUser.getUserType())){
        	conditionsStr.append(" and user_type = #{sysUser.user_type} ");
        }
        if(StringUtils.isNotBlank(sysUser.getLastLogonTime())){
        	conditionsStr.append(" and last_logon_time = #{sysUser.last_logon_time} ");
        }
        if(StringUtils.isNotBlank(sysUser.getLastLogonIp())){
        	conditionsStr.append(" and last_logon_ip like  CONCAT('%',#{sysUser.last_logon_ip},'%')");
        }
        if(StringUtils.isNotBlank(sysUser.getStatus())){
        	conditionsStr.append(" and status = #{sysUser.status} ");
        }
        if(StringUtils.isNotBlank(sysUser.getCreateTime())){
        	conditionsStr.append(" and create_time = #{sysUser.create_time} ");
        }
        return  conditionsStr.toString();
    }
}


