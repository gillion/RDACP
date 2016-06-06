/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlElementText.dao;

import com.cartan.core.ipfDmlElementText.domain.IpfDmlElementText;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlElementTextSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_element_text where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlElementText ipfDmlElementText=new IpfDmlElementText();
        ipfDmlElementText=(IpfDmlElementText)parameter.get("ipfDmlElementText");

        if(StringUtils.isNotBlank(ipfDmlElementText.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlElementText.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlElementText.getIpfDmlElementId())){
        	conditionsStr.append(" and IPF_DML_ELEMENT_ID like  CONCAT('%',#{ipfDmlElementText.IPF_DML_ELEMENT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlElementText.getDdLanguage())){
        	conditionsStr.append(" and DD_LANGUAGE like  CONCAT('%',#{ipfDmlElementText.DD_LANGUAGE},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlElementText.getDdText())){
        	conditionsStr.append(" and DD_TEXT like  CONCAT('%',#{ipfDmlElementText.DD_TEXT},'%')");
        }
        return  conditionsStr.toString();
    }
}


