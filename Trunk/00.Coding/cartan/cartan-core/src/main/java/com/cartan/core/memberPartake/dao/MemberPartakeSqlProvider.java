/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.memberPartake.dao;

import com.cartan.core.memberPartake.domain.MemberPartake;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class MemberPartakeSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_member_partake where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        MemberPartake memberPartake=new MemberPartake();
        memberPartake=(MemberPartake)parameter.get("memberPartake");

        if(StringUtils.isNotBlank(memberPartake.getId())){
        	conditionsStr.append(" and id = #{memberPartake.id} ");
        }    		
        if(StringUtils.isNotBlank(memberPartake.getGroupActId())){
        	conditionsStr.append(" and GroupActId like  CONCAT('%',#{memberPartake.GroupActId},'%')");
        }
        if(StringUtils.isNotBlank(memberPartake.getGroupMemberId())){
        	conditionsStr.append(" and GroupMemberId like  CONCAT('%',#{memberPartake.GroupMemberId},'%')");
        }
        if(StringUtils.isNotBlank(memberPartake.getPartaketime())){
        	conditionsStr.append(" and partaketime like  CONCAT('%',#{memberPartake.partaketime},'%')");
        }
        if(StringUtils.isNotBlank(memberPartake.getSpending())){
        	conditionsStr.append(" and spending like  CONCAT('%',#{memberPartake.spending},'%')");
        }
        return  conditionsStr.toString();
    }
}


