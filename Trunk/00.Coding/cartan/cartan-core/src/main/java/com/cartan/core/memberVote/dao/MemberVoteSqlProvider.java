/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.memberVote.dao;

import com.cartan.core.memberVote.domain.MemberVote;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class MemberVoteSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_member_vote where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        MemberVote memberVote=new MemberVote();
        memberVote=(MemberVote)parameter.get("memberVote");

        if(StringUtils.isNotBlank(memberVote.getId())){
        	conditionsStr.append(" and id = #{memberVote.id} ");
        }    		
        if(StringUtils.isNotBlank(memberVote.getGroupActId())){
        	conditionsStr.append(" and GroupActId like  CONCAT('%',#{memberVote.GroupActId},'%')");
        }
        if(StringUtils.isNotBlank(memberVote.getGroupMemberId())){
        	conditionsStr.append(" and GroupMemberId like  CONCAT('%',#{memberVote.GroupMemberId},'%')");
        }
        if(StringUtils.isNotBlank(memberVote.getVotetime())){
        	conditionsStr.append(" and votetime like  CONCAT('%',#{memberVote.votetime},'%')");
        }
        if(StringUtils.isNotBlank(memberVote.getVotestate())){
        	conditionsStr.append(" and votestate like  CONCAT('%',#{memberVote.votestate},'%')");
        }
        return  conditionsStr.toString();
    }
}


