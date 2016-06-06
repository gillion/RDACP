/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmUiLayout.dao;

import com.cartan.core.ipfCcmUiLayout.domain.IpfCcmUiLayout;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmUiLayoutSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_ui_layout where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmUiLayout ipfCcmUiLayout=new IpfCcmUiLayout();
        ipfCcmUiLayout=(IpfCcmUiLayout)parameter.get("ipfCcmUiLayout");

        if(StringUtils.isNotBlank(ipfCcmUiLayout.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmUiLayout.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmUiLayout.getUiLayoutName())){
        	conditionsStr.append(" and UI_LAYOUT_NAME like  CONCAT('%',#{ipfCcmUiLayout.UI_LAYOUT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayout.getDescription())){
        	conditionsStr.append(" and DESCRIPTION like  CONCAT('%',#{ipfCcmUiLayout.DESCRIPTION},'%')");
        }
        return  conditionsStr.toString();
    }
}


