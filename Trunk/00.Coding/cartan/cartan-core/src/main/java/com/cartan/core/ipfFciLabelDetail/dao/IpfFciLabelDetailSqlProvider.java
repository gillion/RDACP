/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfFciLabelDetail.dao;

import com.cartan.core.ipfFciLabelDetail.domain.IpfFciLabelDetail;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfFciLabelDetailSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_fci_label_detail where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfFciLabelDetail ipfFciLabelDetail=new IpfFciLabelDetail();
        ipfFciLabelDetail=(IpfFciLabelDetail)parameter.get("ipfFciLabelDetail");

        if(StringUtils.isNotBlank(ipfFciLabelDetail.getId())){
        	conditionsStr.append(" and ID = #{ipfFciLabelDetail.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfFciLabelDetail.getIpfFciLabelId())){
        	conditionsStr.append(" and IPF_FCI_LABEL_ID like  CONCAT('%',#{ipfFciLabelDetail.IPF_FCI_LABEL_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabelDetail.getIpfFciViewId())){
        	conditionsStr.append(" and IPF_FCI_VIEW_ID like  CONCAT('%',#{ipfFciLabelDetail.IPF_FCI_VIEW_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabelDetail.getConfigItemType())){
        	conditionsStr.append(" and CONFIG_ITEM_TYPE like  CONCAT('%',#{ipfFciLabelDetail.CONFIG_ITEM_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabelDetail.getConfigItemCode())){
        	conditionsStr.append(" and CONFIG_ITEM_CODE like  CONCAT('%',#{ipfFciLabelDetail.CONFIG_ITEM_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabelDetail.getConfigItemId())){
        	conditionsStr.append(" and CONFIG_ITEM_ID like  CONCAT('%',#{ipfFciLabelDetail.CONFIG_ITEM_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabelDetail.getRevisionNumber())){
        	conditionsStr.append(" and REVISION_NUMBER like  CONCAT('%',#{ipfFciLabelDetail.REVISION_NUMBER},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabelDetail.getRelationMemberId())){
        	conditionsStr.append(" and RELATION_MEMBER_ID like  CONCAT('%',#{ipfFciLabelDetail.RELATION_MEMBER_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciLabelDetail.getIsActive())){
        	conditionsStr.append(" and IS_ACTIVE like  CONCAT('%',#{ipfFciLabelDetail.IS_ACTIVE},'%')");
        }
        return  conditionsStr.toString();
    }
}


