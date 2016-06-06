/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.groupAction.dao;

import com.cartan.core.groupAction.domain.GroupAction;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class GroupActionSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_group_action where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        GroupAction groupAction=new GroupAction();
        groupAction=(GroupAction)parameter.get("groupAction");

        if(StringUtils.isNotBlank(groupAction.getId())){
        	conditionsStr.append(" and id = #{groupAction.id} ");
        }    		
        if(StringUtils.isNotBlank(groupAction.getName())){
        	conditionsStr.append(" and name like  CONCAT('%',#{groupAction.name},'%')");
        }
        if(StringUtils.isNotBlank(groupAction.getBegintime())){
        	conditionsStr.append(" and begintime like  CONCAT('%',#{groupAction.begintime},'%')");
        }
        if(StringUtils.isNotBlank(groupAction.getEndtime())){
        	conditionsStr.append(" and endtime like  CONCAT('%',#{groupAction.endtime},'%')");
        }
        if(StringUtils.isNotBlank(groupAction.getAddr())){
        	conditionsStr.append(" and addr like  CONCAT('%',#{groupAction.addr},'%')");
        }
        if(StringUtils.isNotBlank(groupAction.getLeadings())){
        	conditionsStr.append(" and leadings like  CONCAT('%',#{groupAction.leadings},'%')");
        }
        if(StringUtils.isNotBlank(groupAction.getMemoinfo())){
        	conditionsStr.append(" and memoinfo like  CONCAT('%',#{groupAction.memoinfo},'%')");
        }
        if(StringUtils.isNotBlank(groupAction.getMincount())){
        	conditionsStr.append(" and mincount like  CONCAT('%',#{groupAction.mincount},'%')");
        }
        if(StringUtils.isNotBlank(groupAction.getBudget())){
        	conditionsStr.append(" and budget like  CONCAT('%',#{groupAction.budget},'%')");
        }
        if(StringUtils.isNotBlank(groupAction.getSpending())){
        	conditionsStr.append(" and spending like  CONCAT('%',#{groupAction.spending},'%')");
        }
        return  conditionsStr.toString();
    }
}


