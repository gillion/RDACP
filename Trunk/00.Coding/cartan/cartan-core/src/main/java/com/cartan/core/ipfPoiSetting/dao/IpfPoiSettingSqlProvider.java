/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfPoiSetting.dao;

import com.cartan.core.ipfPoiSetting.domain.IpfPoiSetting;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfPoiSettingSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_poi_setting where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfPoiSetting ipfPoiSetting=new IpfPoiSetting();
        ipfPoiSetting=(IpfPoiSetting)parameter.get("ipfPoiSetting");

        if(StringUtils.isNotBlank(ipfPoiSetting.getId())){
        	conditionsStr.append(" and ID = #{ipfPoiSetting.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfPoiSetting.getBoName())){
        	conditionsStr.append(" and BO_NAME like  CONCAT('%',#{ipfPoiSetting.BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getPoiType())){
        	conditionsStr.append(" and POI_TYPE like  CONCAT('%',#{ipfPoiSetting.POI_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getTemplateFileName())){
        	conditionsStr.append(" and TEMPLATE_FILE_NAME like  CONCAT('%',#{ipfPoiSetting.TEMPLATE_FILE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getTemplateUrl())){
        	conditionsStr.append(" and TEMPLATE_URL like  CONCAT('%',#{ipfPoiSetting.TEMPLATE_URL},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getFileName())){
        	conditionsStr.append(" and FILE_NAME like  CONCAT('%',#{ipfPoiSetting.FILE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getSourceService())){
        	conditionsStr.append(" and SOURCE_SERVICE like  CONCAT('%',#{ipfPoiSetting.SOURCE_SERVICE},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getClassName())){
        	conditionsStr.append(" and CLASS_NAME like  CONCAT('%',#{ipfPoiSetting.CLASS_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getTemplateExtName())){
        	conditionsStr.append(" and TEMPLATE_EXT_NAME like  CONCAT('%',#{ipfPoiSetting.TEMPLATE_EXT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getRuleNo())){
        	conditionsStr.append(" and RULE_NO like  CONCAT('%',#{ipfPoiSetting.RULE_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getDictName())){
        	conditionsStr.append(" and DICT_NAME like  CONCAT('%',#{ipfPoiSetting.DICT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getDealService())){
        	conditionsStr.append(" and DEAL_SERVICE like  CONCAT('%',#{ipfPoiSetting.DEAL_SERVICE},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getMethodeName())){
        	conditionsStr.append(" and METHODE_NAME like  CONCAT('%',#{ipfPoiSetting.METHODE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getIsAsync())){
        	conditionsStr.append(" and IS_ASYNC like  CONCAT('%',#{ipfPoiSetting.IS_ASYNC},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getAsyncPageSize())){
        	conditionsStr.append(" and ASYNC_PAGE_SIZE like  CONCAT('%',#{ipfPoiSetting.ASYNC_PAGE_SIZE},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getTemplate())){
        	conditionsStr.append(" and TEMPLATE like  CONCAT('%',#{ipfPoiSetting.TEMPLATE},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getTemplateFileKey())){
        	conditionsStr.append(" and TEMPLATE_FILE_KEY like  CONCAT('%',#{ipfPoiSetting.TEMPLATE_FILE_KEY},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getPrimaryColumns())){
        	conditionsStr.append(" and PRIMARY_COLUMNS like  CONCAT('%',#{ipfPoiSetting.PRIMARY_COLUMNS},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getChildrenTable())){
        	conditionsStr.append(" and CHILDREN_TABLE like  CONCAT('%',#{ipfPoiSetting.CHILDREN_TABLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getSortExpress())){
        	conditionsStr.append(" and SORT_EXPRESS like  CONCAT('%',#{ipfPoiSetting.SORT_EXPRESS},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getAllowParameter())){
        	conditionsStr.append(" and ALLOW_PARAMETER like  CONCAT('%',#{ipfPoiSetting.ALLOW_PARAMETER},'%')");
        }
        if(StringUtils.isNotBlank(ipfPoiSetting.getIpfDefineColumn())){
        	conditionsStr.append(" and IPF_DEFINE_COLUMN like  CONCAT('%',#{ipfPoiSetting.IPF_DEFINE_COLUMN},'%')");
        }
        return  conditionsStr.toString();
    }
}


