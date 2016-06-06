/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.groupInfo.dao;

import com.cartan.core.groupInfo.domain.GroupInfo;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class GroupInfoSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_group_info where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        GroupInfo groupInfo=new GroupInfo();
        groupInfo=(GroupInfo)parameter.get("groupInfo");

        if(StringUtils.isNotBlank(groupInfo.getId())){
        	conditionsStr.append(" and id = #{groupInfo.id} ");
        }    		
        if(StringUtils.isNotBlank(groupInfo.getType())){
        	conditionsStr.append(" and type like  CONCAT('%',#{groupInfo.type},'%')");
        }
        if(StringUtils.isNotBlank(groupInfo.getName())){
        	conditionsStr.append(" and name like  CONCAT('%',#{groupInfo.name},'%')");
        }
        if(StringUtils.isNotBlank(groupInfo.getCreatetime())){
        	conditionsStr.append(" and createtime like  CONCAT('%',#{groupInfo.createtime},'%')");
        }
        if(StringUtils.isNotBlank(groupInfo.getCreator())){
        	conditionsStr.append(" and creator like  CONCAT('%',#{groupInfo.creator},'%')");
        }
        if(StringUtils.isNotBlank(groupInfo.getMemoinfo())){
        	conditionsStr.append(" and memoinfo like  CONCAT('%',#{groupInfo.memoinfo},'%')");
        }
        return  conditionsStr.toString();
    }
}


