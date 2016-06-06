/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoFormCell.dao;

import com.cartan.core.ipfCcmBoFormCell.domain.IpfCcmBoFormCell;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoFormCellSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_form_cell where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoFormCell ipfCcmBoFormCell=new IpfCcmBoFormCell();
        ipfCcmBoFormCell=(IpfCcmBoFormCell)parameter.get("ipfCcmBoFormCell");

        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoFormCell.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfCcmBoFormCell.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getFormType())){
        	conditionsStr.append(" and FORM_TYPE like  CONCAT('%',#{ipfCcmBoFormCell.FORM_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getIsDefault())){
        	conditionsStr.append(" and IS_DEFAULT like  CONCAT('%',#{ipfCcmBoFormCell.IS_DEFAULT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getCellName())){
        	conditionsStr.append(" and CELL_NAME like  CONCAT('%',#{ipfCcmBoFormCell.CELL_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getCellType())){
        	conditionsStr.append(" and CELL_TYPE like  CONCAT('%',#{ipfCcmBoFormCell.CELL_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getCellHeigh())){
        	conditionsStr.append(" and CELL_HEIGH like  CONCAT('%',#{ipfCcmBoFormCell.CELL_HEIGH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getIsShowGroup())){
        	conditionsStr.append(" and IS_SHOW_GROUP like  CONCAT('%',#{ipfCcmBoFormCell.IS_SHOW_GROUP},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getGroupWidget())){
        	conditionsStr.append(" and GROUP_WIDGET like  CONCAT('%',#{ipfCcmBoFormCell.GROUP_WIDGET},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getElementCode())){
        	conditionsStr.append(" and ELEMENT_CODE like  CONCAT('%',#{ipfCcmBoFormCell.ELEMENT_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getGroupTitle())){
        	conditionsStr.append(" and GROUP_TITLE like  CONCAT('%',#{ipfCcmBoFormCell.GROUP_TITLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getUnitCount())){
        	conditionsStr.append(" and UNIT_COUNT like  CONCAT('%',#{ipfCcmBoFormCell.UNIT_COUNT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getIsParent())){
        	conditionsStr.append(" and IS_PARENT like  CONCAT('%',#{ipfCcmBoFormCell.IS_PARENT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getChildrenLineCount())){
        	conditionsStr.append(" and CHILDREN_LINE_COUNT like  CONCAT('%',#{ipfCcmBoFormCell.CHILDREN_LINE_COUNT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getParentCellName())){
        	conditionsStr.append(" and PARENT_CELL_NAME like  CONCAT('%',#{ipfCcmBoFormCell.PARENT_CELL_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getRowNo())){
        	conditionsStr.append(" and ROW_NO like  CONCAT('%',#{ipfCcmBoFormCell.ROW_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getColumnNo())){
        	conditionsStr.append(" and COLUMN_NO like  CONCAT('%',#{ipfCcmBoFormCell.COLUMN_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormCell.getLabelUnitCount())){
        	conditionsStr.append(" and LABEL_UNIT_COUNT like  CONCAT('%',#{ipfCcmBoFormCell.LABEL_UNIT_COUNT},'%')");
        }
        return  conditionsStr.toString();
    }
}


