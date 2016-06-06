/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmUiLayoutList.dao;

import com.cartan.core.ipfCcmUiLayoutList.domain.IpfCcmUiLayoutList;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmUiLayoutListSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_ui_layout_list where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmUiLayoutList ipfCcmUiLayoutList=new IpfCcmUiLayoutList();
        ipfCcmUiLayoutList=(IpfCcmUiLayoutList)parameter.get("ipfCcmUiLayoutList");

        if(StringUtils.isNotBlank(ipfCcmUiLayoutList.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmUiLayoutList.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmUiLayoutList.getIpfCcmUiLayoutId())){
        	conditionsStr.append(" and IPF_CCM_UI_LAYOUT_ID like  CONCAT('%',#{ipfCcmUiLayoutList.IPF_CCM_UI_LAYOUT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutList.getPageName())){
        	conditionsStr.append(" and PAGE_NAME like  CONCAT('%',#{ipfCcmUiLayoutList.PAGE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutList.getDescription())){
        	conditionsStr.append(" and DESCRIPTION like  CONCAT('%',#{ipfCcmUiLayoutList.DESCRIPTION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmUiLayoutList.getImagePath())){
        	conditionsStr.append(" and IMAGE_PATH like  CONCAT('%',#{ipfCcmUiLayoutList.IMAGE_PATH},'%')");
        }
        return  conditionsStr.toString();
    }
}


