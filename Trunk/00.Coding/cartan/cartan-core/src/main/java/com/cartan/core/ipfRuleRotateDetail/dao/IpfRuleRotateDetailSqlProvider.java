/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfRuleRotateDetail.dao;

import com.cartan.core.ipfRuleRotateDetail.domain.IpfRuleRotateDetail;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfRuleRotateDetailSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_rule_rotate_detail where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfRuleRotateDetail ipfRuleRotateDetail=new IpfRuleRotateDetail();
        ipfRuleRotateDetail=(IpfRuleRotateDetail)parameter.get("ipfRuleRotateDetail");

        if(StringUtils.isNotBlank(ipfRuleRotateDetail.getId())){
        	conditionsStr.append(" and ID = #{ipfRuleRotateDetail.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfRuleRotateDetail.getIpfRuleRotateId())){
        	conditionsStr.append(" and IPF_RULE_ROTATE_ID like  CONCAT('%',#{ipfRuleRotateDetail.IPF_RULE_ROTATE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleRotateDetail.getLineId())){
        	conditionsStr.append(" and LINE_ID like  CONCAT('%',#{ipfRuleRotateDetail.LINE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleRotateDetail.getLotAttributes())){
        	conditionsStr.append(" and LOT_ATTRIBUTES like  CONCAT('%',#{ipfRuleRotateDetail.LOT_ATTRIBUTES},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleRotateDetail.getSortType())){
        	conditionsStr.append(" and SORT_TYPE like  CONCAT('%',#{ipfRuleRotateDetail.SORT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleRotateDetail.getDetailDesc())){
        	conditionsStr.append(" and DETAIL_DESC like  CONCAT('%',#{ipfRuleRotateDetail.DETAIL_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleRotateDetail.getIsActive())){
        	conditionsStr.append(" and IS_ACTIVE like  CONCAT('%',#{ipfRuleRotateDetail.IS_ACTIVE},'%')");
        }
        return  conditionsStr.toString();
    }
}


