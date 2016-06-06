/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoGridToolbar.dao;

import com.cartan.core.ipfCcmBoGridToolbar.domain.IpfCcmBoGridToolbar;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoGridToolbarSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_grid_toolbar where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoGridToolbar ipfCcmBoGridToolbar=new IpfCcmBoGridToolbar();
        ipfCcmBoGridToolbar=(IpfCcmBoGridToolbar)parameter.get("ipfCcmBoGridToolbar");

        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoGridToolbar.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getIpfCcbBoId())){
        	conditionsStr.append(" and IPF_CCB_BO_ID like  CONCAT('%',#{ipfCcmBoGridToolbar.IPF_CCB_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getMethodName())){
        	conditionsStr.append(" and METHOD_NAME like  CONCAT('%',#{ipfCcmBoGridToolbar.METHOD_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getMethodDesc())){
        	conditionsStr.append(" and METHOD_DESC like  CONCAT('%',#{ipfCcmBoGridToolbar.METHOD_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getSeqNo())){
        	conditionsStr.append(" and SEQ_NO like  CONCAT('%',#{ipfCcmBoGridToolbar.SEQ_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getMethodId())){
        	conditionsStr.append(" and METHOD_ID like  CONCAT('%',#{ipfCcmBoGridToolbar.METHOD_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getButtonStyle())){
        	conditionsStr.append(" and BUTTON_STYLE like  CONCAT('%',#{ipfCcmBoGridToolbar.BUTTON_STYLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getDisabledExpree())){
        	conditionsStr.append(" and DISABLED_EXPREE like  CONCAT('%',#{ipfCcmBoGridToolbar.DISABLED_EXPREE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getIsRefreshParentBo())){
        	conditionsStr.append(" and IS_REFRESH_PARENT_BO like  CONCAT('%',#{ipfCcmBoGridToolbar.IS_REFRESH_PARENT_BO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getHotkeyType())){
        	conditionsStr.append(" and HOTKEY_TYPE like  CONCAT('%',#{ipfCcmBoGridToolbar.HOTKEY_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getHotkeyValue())){
        	conditionsStr.append(" and HOTKEY_VALUE like  CONCAT('%',#{ipfCcmBoGridToolbar.HOTKEY_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridToolbar.getIsHide())){
        	conditionsStr.append(" and IS_HIDE like  CONCAT('%',#{ipfCcmBoGridToolbar.IS_HIDE},'%')");
        }
        return  conditionsStr.toString();
    }
}


