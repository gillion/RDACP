/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.app.dao;

import com.cartan.core.app.domain.App;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class AppSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_app where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        App app=new App();
        app=(App)parameter.get("app");

        if(StringUtils.isNotBlank(app.getAppName())){
        	conditionsStr.append(" and app_name = #{app.app_name} ");
        }    		
        if(StringUtils.isNotBlank(app.getAppLabel())){
        	conditionsStr.append(" and app_label like  CONCAT('%',#{app.app_label},'%')");
        }
        if(StringUtils.isNotBlank(app.getAppkey())){
        	conditionsStr.append(" and appkey like  CONCAT('%',#{app.appkey},'%')");
        }
        if(StringUtils.isNotBlank(app.getSecret())){
        	conditionsStr.append(" and secret like  CONCAT('%',#{app.secret},'%')");
        }
        if(StringUtils.isNotBlank(app.getDescription())){
        	conditionsStr.append(" and description like  CONCAT('%',#{app.description},'%')");
        }
        if(StringUtils.isNotBlank(app.getAuthor())){
        	conditionsStr.append(" and author like  CONCAT('%',#{app.author},'%')");
        }
        if(StringUtils.isNotBlank(app.getCreateTime())){
        	conditionsStr.append(" and create_time = #{app.create_time} ");
        }
        if(StringUtils.isNotBlank(app.getStatus())){
        	conditionsStr.append(" and status = #{app.status} ");
        }
        if(StringUtils.isNotBlank(app.getAuditor())){
        	conditionsStr.append(" and auditor like  CONCAT('%',#{app.auditor},'%')");
        }
        if(StringUtils.isNotBlank(app.getAuditInfo())){
        	conditionsStr.append(" and audit_info like  CONCAT('%',#{app.audit_info},'%')");
        }
        if(StringUtils.isNotBlank(app.getAuditTime())){
        	conditionsStr.append(" and audit_time = #{app.audit_time} ");
        }
        if(StringUtils.isNotBlank(app.getCurrVersion())){
        	conditionsStr.append(" and curr_version like  CONCAT('%',#{app.curr_version},'%')");
        }
        return  conditionsStr.toString();
    }
}


