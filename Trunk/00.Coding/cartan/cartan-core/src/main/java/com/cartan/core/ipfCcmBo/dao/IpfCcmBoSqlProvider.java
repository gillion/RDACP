/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBo.dao;

import com.cartan.core.ipfCcmBo.domain.IpfCcmBo;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBo ipfCcmBo=new IpfCcmBo();
        ipfCcmBo=(IpfCcmBo)parameter.get("ipfCcmBo");

        if(StringUtils.isNotBlank(ipfCcmBo.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBo.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBo.getBoName())){
        	conditionsStr.append(" and BO_NAME like  CONCAT('%',#{ipfCcmBo.BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getBoType())){
        	conditionsStr.append(" and BO_TYPE like  CONCAT('%',#{ipfCcmBo.BO_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getAppModule())){
        	conditionsStr.append(" and APP_MODULE like  CONCAT('%',#{ipfCcmBo.APP_MODULE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getServiceType())){
        	conditionsStr.append(" and SERVICE_TYPE like  CONCAT('%',#{ipfCcmBo.SERVICE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getJavaPath())){
        	conditionsStr.append(" and JAVA_PATH like  CONCAT('%',#{ipfCcmBo.JAVA_PATH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getServiceCategory())){
        	conditionsStr.append(" and SERVICE_CATEGORY like  CONCAT('%',#{ipfCcmBo.SERVICE_CATEGORY},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getTableName())){
        	conditionsStr.append(" and TABLE_NAME like  CONCAT('%',#{ipfCcmBo.TABLE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getTableType())){
        	conditionsStr.append(" and TABLE_TYPE like  CONCAT('%',#{ipfCcmBo.TABLE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getDescription())){
        	conditionsStr.append(" and DESCRIPTION like  CONCAT('%',#{ipfCcmBo.DESCRIPTION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getSearchColumns())){
        	conditionsStr.append(" and SEARCH_COLUMNS like  CONCAT('%',#{ipfCcmBo.SEARCH_COLUMNS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getSearchMode())){
        	conditionsStr.append(" and SEARCH_MODE like  CONCAT('%',#{ipfCcmBo.SEARCH_MODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getPageSize())){
        	conditionsStr.append(" and PAGE_SIZE like  CONCAT('%',#{ipfCcmBo.PAGE_SIZE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getIpfCcmUiLayoutId())){
        	conditionsStr.append(" and IPF_CCM_UI_LAYOUT_ID like  CONCAT('%',#{ipfCcmBo.IPF_CCM_UI_LAYOUT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getUiLayoutName())){
        	conditionsStr.append(" and UI_LAYOUT_NAME like  CONCAT('%',#{ipfCcmBo.UI_LAYOUT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getFormCellMode())){
        	conditionsStr.append(" and FORM_CELL_MODE like  CONCAT('%',#{ipfCcmBo.FORM_CELL_MODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getUiTemplate())){
        	conditionsStr.append(" and UI_TEMPLATE like  CONCAT('%',#{ipfCcmBo.UI_TEMPLATE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getFormColumns())){
        	conditionsStr.append(" and FORM_COLUMNS like  CONCAT('%',#{ipfCcmBo.FORM_COLUMNS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getGridStyle())){
        	conditionsStr.append(" and GRID_STYLE like  CONCAT('%',#{ipfCcmBo.GRID_STYLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getGridAlign())){
        	conditionsStr.append(" and GRID_ALIGN like  CONCAT('%',#{ipfCcmBo.GRID_ALIGN},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getGridEditType())){
        	conditionsStr.append(" and GRID_EDIT_TYPE like  CONCAT('%',#{ipfCcmBo.GRID_EDIT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getGenerateOption())){
        	conditionsStr.append(" and GENERATE_OPTION like  CONCAT('%',#{ipfCcmBo.GENERATE_OPTION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getLockRowExpress())){
        	conditionsStr.append(" and LOCK_ROW_EXPRESS like  CONCAT('%',#{ipfCcmBo.LOCK_ROW_EXPRESS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getGridType())){
        	conditionsStr.append(" and GRID_TYPE like  CONCAT('%',#{ipfCcmBo.GRID_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getIsMainObject())){
        	conditionsStr.append(" and IS_MAIN_OBJECT like  CONCAT('%',#{ipfCcmBo.IS_MAIN_OBJECT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getIsInitDataBo())){
        	conditionsStr.append(" and IS_INIT_DATA_BO like  CONCAT('%',#{ipfCcmBo.IS_INIT_DATA_BO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getIsAutoLoad())){
        	conditionsStr.append(" and IS_AUTO_LOAD like  CONCAT('%',#{ipfCcmBo.IS_AUTO_LOAD},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getIsNeedAdvSearch())){
        	conditionsStr.append(" and IS_NEED_ADV_SEARCH like  CONCAT('%',#{ipfCcmBo.IS_NEED_ADV_SEARCH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getNeedPaging())){
        	conditionsStr.append(" and NEED_PAGING like  CONCAT('%',#{ipfCcmBo.NEED_PAGING},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getIsGridFilter())){
        	conditionsStr.append(" and IS_GRID_FILTER like  CONCAT('%',#{ipfCcmBo.IS_GRID_FILTER},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getIsGridCustom())){
        	conditionsStr.append(" and IS_GRID_CUSTOM like  CONCAT('%',#{ipfCcmBo.IS_GRID_CUSTOM},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getRemark())){
        	conditionsStr.append(" and REMARK like  CONCAT('%',#{ipfCcmBo.REMARK},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getWhereClause())){
        	conditionsStr.append(" and WHERE_CLAUSE like  CONCAT('%',#{ipfCcmBo.WHERE_CLAUSE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBo.getIdGenerator())){
        	conditionsStr.append(" and ID_GENERATOR like  CONCAT('%',#{ipfCcmBo.ID_GENERATOR},'%')");
        }
        return  conditionsStr.toString();
    }
}


