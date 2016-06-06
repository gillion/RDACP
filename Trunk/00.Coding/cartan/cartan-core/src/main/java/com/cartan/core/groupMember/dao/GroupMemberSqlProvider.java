/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.groupMember.dao;

import com.cartan.core.groupMember.domain.GroupMember;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class GroupMemberSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_group_member where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        GroupMember groupMember=new GroupMember();
        groupMember=(GroupMember)parameter.get("groupMember");

        if(StringUtils.isNotBlank(groupMember.getId())){
        	conditionsStr.append(" and id = #{groupMember.id} ");
        }    		
        if(StringUtils.isNotBlank(groupMember.getUser())){
        	conditionsStr.append(" and user like  CONCAT('%',#{groupMember.user},'%')");
        }
        if(StringUtils.isNotBlank(groupMember.getGroupInfoId())){
        	conditionsStr.append(" and GroupInfoId like  CONCAT('%',#{groupMember.GroupInfoId},'%')");
        }
        if(StringUtils.isNotBlank(groupMember.getArea())){
        	conditionsStr.append(" and area like  CONCAT('%',#{groupMember.area},'%')");
        }
        if(StringUtils.isNotBlank(groupMember.getName())){
        	conditionsStr.append(" and name like  CONCAT('%',#{groupMember.name},'%')");
        }
        if(StringUtils.isNotBlank(groupMember.getTel())){
        	conditionsStr.append(" and tel like  CONCAT('%',#{groupMember.tel},'%')");
        }
        if(StringUtils.isNotBlank(groupMember.getUnit())){
        	conditionsStr.append(" and unit like  CONCAT('%',#{groupMember.unit},'%')");
        }
        if(StringUtils.isNotBlank(groupMember.getAddr())){
        	conditionsStr.append(" and addr like  CONCAT('%',#{groupMember.addr},'%')");
        }
        return  conditionsStr.toString();
    }
}


