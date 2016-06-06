/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmDict.dao;

import com.cartan.core.ipfCcmDict.domain.IpfCcmDict;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmDictSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_dict where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmDict ipfCcmDict=new IpfCcmDict();
        ipfCcmDict=(IpfCcmDict)parameter.get("ipfCcmDict");

        if(StringUtils.isNotBlank(ipfCcmDict.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmDict.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmDict.getDictCode())){
        	conditionsStr.append(" and DICT_CODE like  CONCAT('%',#{ipfCcmDict.DICT_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getDictName())){
        	conditionsStr.append(" and DICT_NAME like  CONCAT('%',#{ipfCcmDict.DICT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getDictType())){
        	conditionsStr.append(" and DICT_TYPE like  CONCAT('%',#{ipfCcmDict.DICT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getCodeColumn())){
        	conditionsStr.append(" and CODE_COLUMN like  CONCAT('%',#{ipfCcmDict.CODE_COLUMN},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getNameColumn())){
        	conditionsStr.append(" and NAME_COLUMN like  CONCAT('%',#{ipfCcmDict.NAME_COLUMN},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getKeyColumn())){
        	conditionsStr.append(" and KEY_COLUMN like  CONCAT('%',#{ipfCcmDict.KEY_COLUMN},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getTableName())){
        	conditionsStr.append(" and TABLE_NAME like  CONCAT('%',#{ipfCcmDict.TABLE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getIsGroup())){
        	conditionsStr.append(" and IS_GROUP like  CONCAT('%',#{ipfCcmDict.IS_GROUP},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getGroupColumn())){
        	conditionsStr.append(" and GROUP_COLUMN like  CONCAT('%',#{ipfCcmDict.GROUP_COLUMN},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getRemark())){
        	conditionsStr.append(" and REMARK like  CONCAT('%',#{ipfCcmDict.REMARK},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getOrderColumn())){
        	conditionsStr.append(" and ORDER_COLUMN like  CONCAT('%',#{ipfCcmDict.ORDER_COLUMN},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getIsSystem())){
        	conditionsStr.append(" and IS_SYSTEM like  CONCAT('%',#{ipfCcmDict.IS_SYSTEM},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getDataType())){
        	conditionsStr.append(" and DATA_TYPE like  CONCAT('%',#{ipfCcmDict.DATA_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getFieldLength())){
        	conditionsStr.append(" and FIELD_LENGTH like  CONCAT('%',#{ipfCcmDict.FIELD_LENGTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmDict.getDecimals())){
        	conditionsStr.append(" and DECIMALS like  CONCAT('%',#{ipfCcmDict.DECIMALS},'%')");
        }
        return  conditionsStr.toString();
    }
}


