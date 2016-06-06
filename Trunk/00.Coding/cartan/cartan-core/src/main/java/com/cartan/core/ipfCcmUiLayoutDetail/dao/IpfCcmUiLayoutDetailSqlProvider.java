/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmUiLayoutDetail.dao;

import com.cartan.core.ipfCcmUiLayoutDetail.domain.IpfCcmUiLayoutDetail;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmUiLayoutDetailSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_ui_layout_detail where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail=new IpfCcmUiLayoutDetail();
        ipfCcmUiLayoutDetail=(IpfCcmUiLayoutDetail)parameter.get("ipfCcmUiLayoutDetail");

        if(StringUtils.isNotBlank(ipfCcmUiLayoutDetail.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmUiLayoutDetail.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmUiLayoutDetail.getIpfCcmUiLayoutId())){
        	conditionsStr.append(" and IPF_CCM_UI_LAYOUT_ID like  CONCAT('%',#{ipfCcmUiLayoutDetail.IPF_CCM_UI_LAYOUT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutDetail.getIpfCcmUiLayoutListId())){
        	conditionsStr.append(" and IPF_CCM_UI_LAYOUT_LIST_ID like  CONCAT('%',#{ipfCcmUiLayoutDetail.IPF_CCM_UI_LAYOUT_LIST_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutDetail.getLayoutElementName())){
        	conditionsStr.append(" and LAYOUT_ELEMENT_NAME like  CONCAT('%',#{ipfCcmUiLayoutDetail.LAYOUT_ELEMENT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutDetail.getDescription())){
        	conditionsStr.append(" and DESCRIPTION like  CONCAT('%',#{ipfCcmUiLayoutDetail.DESCRIPTION},'%')");
        }
        return  conditionsStr.toString();
    }
}


