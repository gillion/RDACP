/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmDictValue.dao;

import com.cartan.core.ipfCcmDictValue.domain.IpfCcmDictValue;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmDictValueSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_dict_value where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmDictValue ipfCcmDictValue=new IpfCcmDictValue();
        ipfCcmDictValue=(IpfCcmDictValue)parameter.get("ipfCcmDictValue");

        if(StringUtils.isNotBlank(ipfCcmDictValue.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmDictValue.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmDictValue.getIpfCcmDictId())){
        	conditionsStr.append(" and IPF_CCM_DICT_ID like  CONCAT('%',#{ipfCcmDictValue.IPF_CCM_DICT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDictValue.getCodeValue())){
        	conditionsStr.append(" and CODE_VALUE like  CONCAT('%',#{ipfCcmDictValue.CODE_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDictValue.getDisplayValue())){
        	conditionsStr.append(" and DISPLAY_VALUE like  CONCAT('%',#{ipfCcmDictValue.DISPLAY_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDictValue.getSeqNo())){
        	conditionsStr.append(" and SEQ_NO like  CONCAT('%',#{ipfCcmDictValue.SEQ_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDictValue.getGroupValue())){
        	conditionsStr.append(" and GROUP_VALUE like  CONCAT('%',#{ipfCcmDictValue.GROUP_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDictValue.getRemark())){
        	conditionsStr.append(" and REMARK like  CONCAT('%',#{ipfCcmDictValue.REMARK},'%')");
        }
        return  conditionsStr.toString();
    }
}


