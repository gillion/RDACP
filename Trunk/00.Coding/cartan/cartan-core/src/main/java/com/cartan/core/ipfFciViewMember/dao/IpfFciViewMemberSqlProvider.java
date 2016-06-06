/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfFciViewMember.dao;

import com.cartan.core.ipfFciViewMember.domain.IpfFciViewMember;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfFciViewMemberSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_fci_view_member where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfFciViewMember ipfFciViewMember=new IpfFciViewMember();
        ipfFciViewMember=(IpfFciViewMember)parameter.get("ipfFciViewMember");

        if(StringUtils.isNotBlank(ipfFciViewMember.getId())){
        	conditionsStr.append(" and ID = #{ipfFciViewMember.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfFciViewMember.getIpfFciViewId())){
        	conditionsStr.append(" and IPF_FCI_VIEW_ID like  CONCAT('%',#{ipfFciViewMember.IPF_FCI_VIEW_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciViewMember.getConfigItemType())){
        	conditionsStr.append(" and CONFIG_ITEM_TYPE like  CONCAT('%',#{ipfFciViewMember.CONFIG_ITEM_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciViewMember.getConfigItemCode())){
        	conditionsStr.append(" and CONFIG_ITEM_CODE like  CONCAT('%',#{ipfFciViewMember.CONFIG_ITEM_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciViewMember.getConfigItemId())){
        	conditionsStr.append(" and CONFIG_ITEM_ID like  CONCAT('%',#{ipfFciViewMember.CONFIG_ITEM_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciViewMember.getRevisionNumber())){
        	conditionsStr.append(" and REVISION_NUMBER like  CONCAT('%',#{ipfFciViewMember.REVISION_NUMBER},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciViewMember.getSourceType())){
        	conditionsStr.append(" and SOURCE_TYPE like  CONCAT('%',#{ipfFciViewMember.SOURCE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciViewMember.getSourceItemId())){
        	conditionsStr.append(" and SOURCE_ITEM_ID like  CONCAT('%',#{ipfFciViewMember.SOURCE_ITEM_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciViewMember.getRelationMemberId())){
        	conditionsStr.append(" and RELATION_MEMBER_ID like  CONCAT('%',#{ipfFciViewMember.RELATION_MEMBER_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciViewMember.getIsLock())){
        	conditionsStr.append(" and IS_LOCK like  CONCAT('%',#{ipfFciViewMember.IS_LOCK},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciViewMember.getLockUser())){
        	conditionsStr.append(" and LOCK_USER like  CONCAT('%',#{ipfFciViewMember.LOCK_USER},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciViewMember.getLockTime())){
        	conditionsStr.append(" and LOCK_TIME like  CONCAT('%',#{ipfFciViewMember.LOCK_TIME},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciViewMember.getIsActive())){
        	conditionsStr.append(" and IS_ACTIVE like  CONCAT('%',#{ipfFciViewMember.IS_ACTIVE},'%')");
        }
        return  conditionsStr.toString();
    }
}


