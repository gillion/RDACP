/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoFormToolbar.dao;

import com.cartan.core.ipfCcmBoFormToolbar.domain.IpfCcmBoFormToolbar;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoFormToolbarSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_form_toolbar where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoFormToolbar ipfCcmBoFormToolbar=new IpfCcmBoFormToolbar();
        ipfCcmBoFormToolbar=(IpfCcmBoFormToolbar)parameter.get("ipfCcmBoFormToolbar");

        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoFormToolbar.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getIpfCcbBoId())){
        	conditionsStr.append(" and IPF_CCB_BO_ID like  CONCAT('%',#{ipfCcmBoFormToolbar.IPF_CCB_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getMethodName())){
        	conditionsStr.append(" and METHOD_NAME like  CONCAT('%',#{ipfCcmBoFormToolbar.METHOD_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getMethodDesc())){
        	conditionsStr.append(" and METHOD_DESC like  CONCAT('%',#{ipfCcmBoFormToolbar.METHOD_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getSeqNo())){
        	conditionsStr.append(" and SEQ_NO like  CONCAT('%',#{ipfCcmBoFormToolbar.SEQ_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getMethodId())){
        	conditionsStr.append(" and METHOD_ID like  CONCAT('%',#{ipfCcmBoFormToolbar.METHOD_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getButtonStyle())){
        	conditionsStr.append(" and BUTTON_STYLE like  CONCAT('%',#{ipfCcmBoFormToolbar.BUTTON_STYLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getDisabledExpree())){
        	conditionsStr.append(" and DISABLED_EXPREE like  CONCAT('%',#{ipfCcmBoFormToolbar.DISABLED_EXPREE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getIsRefreshParentBo())){
        	conditionsStr.append(" and IS_REFRESH_PARENT_BO like  CONCAT('%',#{ipfCcmBoFormToolbar.IS_REFRESH_PARENT_BO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getHotkeyType())){
        	conditionsStr.append(" and HOTKEY_TYPE like  CONCAT('%',#{ipfCcmBoFormToolbar.HOTKEY_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getHotkeyValue())){
        	conditionsStr.append(" and HOTKEY_VALUE like  CONCAT('%',#{ipfCcmBoFormToolbar.HOTKEY_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormToolbar.getIsHide())){
        	conditionsStr.append(" and IS_HIDE like  CONCAT('%',#{ipfCcmBoFormToolbar.IS_HIDE},'%')");
        }
        return  conditionsStr.toString();
    }
}


