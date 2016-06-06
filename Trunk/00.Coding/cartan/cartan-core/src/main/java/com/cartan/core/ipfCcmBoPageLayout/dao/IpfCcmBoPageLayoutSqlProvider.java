/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoPageLayout.dao;

import com.cartan.core.ipfCcmBoPageLayout.domain.IpfCcmBoPageLayout;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoPageLayoutSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_page_layout where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoPageLayout ipfCcmBoPageLayout=new IpfCcmBoPageLayout();
        ipfCcmBoPageLayout=(IpfCcmBoPageLayout)parameter.get("ipfCcmBoPageLayout");

        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoPageLayout.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getIpfCcmBoPageId())){
        	conditionsStr.append(" and IPF_CCM_BO_PAGE_ID like  CONCAT('%',#{ipfCcmBoPageLayout.IPF_CCM_BO_PAGE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getLayoutType())){
        	conditionsStr.append(" and LAYOUT_TYPE like  CONCAT('%',#{ipfCcmBoPageLayout.LAYOUT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getLayoutContainerType())){
        	conditionsStr.append(" and LAYOUT_CONTAINER_TYPE like  CONCAT('%',#{ipfCcmBoPageLayout.LAYOUT_CONTAINER_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getLayoutBoName())){
        	conditionsStr.append(" and LAYOUT_BO_NAME like  CONCAT('%',#{ipfCcmBoPageLayout.LAYOUT_BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getStyleClass())){
        	conditionsStr.append(" and STYLE_CLASS like  CONCAT('%',#{ipfCcmBoPageLayout.STYLE_CLASS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getStyle())){
        	conditionsStr.append(" and STYLE like  CONCAT('%',#{ipfCcmBoPageLayout.STYLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getFormType())){
        	conditionsStr.append(" and FORM_TYPE like  CONCAT('%',#{ipfCcmBoPageLayout.FORM_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getElementName())){
        	conditionsStr.append(" and ELEMENT_NAME like  CONCAT('%',#{ipfCcmBoPageLayout.ELEMENT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getHeight())){
        	conditionsStr.append(" and HEIGHT like  CONCAT('%',#{ipfCcmBoPageLayout.HEIGHT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getIsShowGroup())){
        	conditionsStr.append(" and IS_SHOW_GROUP like  CONCAT('%',#{ipfCcmBoPageLayout.IS_SHOW_GROUP},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getGroupWidget())){
        	conditionsStr.append(" and GROUP_WIDGET like  CONCAT('%',#{ipfCcmBoPageLayout.GROUP_WIDGET},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getGroupMsgCode())){
        	conditionsStr.append(" and GROUP_MSG_CODE like  CONCAT('%',#{ipfCcmBoPageLayout.GROUP_MSG_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getGroupTitle())){
        	conditionsStr.append(" and GROUP_TITLE like  CONCAT('%',#{ipfCcmBoPageLayout.GROUP_TITLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getUnitCount())){
        	conditionsStr.append(" and UNIT_COUNT like  CONCAT('%',#{ipfCcmBoPageLayout.UNIT_COUNT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getIsParent())){
        	conditionsStr.append(" and IS_PARENT like  CONCAT('%',#{ipfCcmBoPageLayout.IS_PARENT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getChildrenLineCount())){
        	conditionsStr.append(" and CHILDREN_LINE_COUNT like  CONCAT('%',#{ipfCcmBoPageLayout.CHILDREN_LINE_COUNT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getCellName())){
        	conditionsStr.append(" and CELL_NAME like  CONCAT('%',#{ipfCcmBoPageLayout.CELL_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getRowNo())){
        	conditionsStr.append(" and ROW_NO like  CONCAT('%',#{ipfCcmBoPageLayout.ROW_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getColumnNo())){
        	conditionsStr.append(" and COLUMN_NO like  CONCAT('%',#{ipfCcmBoPageLayout.COLUMN_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getLabelUnitCount())){
        	conditionsStr.append(" and LABEL_UNIT_COUNT like  CONCAT('%',#{ipfCcmBoPageLayout.LABEL_UNIT_COUNT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getSeqNo())){
        	conditionsStr.append(" and SEQ_NO like  CONCAT('%',#{ipfCcmBoPageLayout.SEQ_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getControlConnector())){
        	conditionsStr.append(" and CONTROL_CONNECTOR like  CONCAT('%',#{ipfCcmBoPageLayout.CONTROL_CONNECTOR},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPageLayout.getParentCellName())){
        	conditionsStr.append(" and PARENT_CELL_NAME like  CONCAT('%',#{ipfCcmBoPageLayout.PARENT_CELL_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}


