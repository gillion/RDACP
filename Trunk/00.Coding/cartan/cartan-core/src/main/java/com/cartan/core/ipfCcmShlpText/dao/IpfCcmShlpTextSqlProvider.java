/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmShlpText.dao;

import com.cartan.core.ipfCcmShlpText.domain.IpfCcmShlpText;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmShlpTextSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_shlp_text where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmShlpText ipfCcmShlpText=new IpfCcmShlpText();
        ipfCcmShlpText=(IpfCcmShlpText)parameter.get("ipfCcmShlpText");

        if(StringUtils.isNotBlank(ipfCcmShlpText.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmShlpText.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmShlpText.getIpfCcmShlpId())){
        	conditionsStr.append(" and IPF_CCM_SHLP_ID like  CONCAT('%',#{ipfCcmShlpText.IPF_CCM_SHLP_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpText.getDdLanguage())){
        	conditionsStr.append(" and DD_LANGUAGE like  CONCAT('%',#{ipfCcmShlpText.DD_LANGUAGE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpText.getDdText())){
        	conditionsStr.append(" and DD_TEXT like  CONCAT('%',#{ipfCcmShlpText.DD_TEXT},'%')");
        }
        return  conditionsStr.toString();
    }
}


