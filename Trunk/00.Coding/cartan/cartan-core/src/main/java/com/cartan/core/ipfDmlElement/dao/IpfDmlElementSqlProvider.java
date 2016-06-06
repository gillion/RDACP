/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlElement.dao;

import com.cartan.core.ipfDmlElement.domain.IpfDmlElement;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlElementSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_element where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlElement ipfDmlElement=new IpfDmlElement();
        ipfDmlElement=(IpfDmlElement)parameter.get("ipfDmlElement");

        if(StringUtils.isNotBlank(ipfDmlElement.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlElement.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlElement.getElementCode())){
        	conditionsStr.append(" and ELEMENT_CODE like  CONCAT('%',#{ipfDmlElement.ELEMENT_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlElement.getFieldText())){
        	conditionsStr.append(" and FIELD_TEXT like  CONCAT('%',#{ipfDmlElement.FIELD_TEXT},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlElement.getDataType())){
        	conditionsStr.append(" and DATA_TYPE like  CONCAT('%',#{ipfDmlElement.DATA_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlElement.getFieldLength())){
        	conditionsStr.append(" and FIELD_LENGTH like  CONCAT('%',#{ipfDmlElement.FIELD_LENGTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlElement.getDecimals())){
        	conditionsStr.append(" and DECIMALS like  CONCAT('%',#{ipfDmlElement.DECIMALS},'%')");
        }
        return  conditionsStr.toString();
    }
}


