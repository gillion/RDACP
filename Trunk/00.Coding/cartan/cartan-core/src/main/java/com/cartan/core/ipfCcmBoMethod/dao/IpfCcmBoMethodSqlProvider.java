/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoMethod.dao;

import com.cartan.core.ipfCcmBoMethod.domain.IpfCcmBoMethod;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoMethodSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_method where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoMethod ipfCcmBoMethod=new IpfCcmBoMethod();
        ipfCcmBoMethod=(IpfCcmBoMethod)parameter.get("ipfCcmBoMethod");

        if(StringUtils.isNotBlank(ipfCcmBoMethod.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoMethod.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfCcmBoMethod.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getBoType())){
        	conditionsStr.append(" and BO_TYPE like  CONCAT('%',#{ipfCcmBoMethod.BO_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getBoRefId())){
        	conditionsStr.append(" and BO_REF_ID like  CONCAT('%',#{ipfCcmBoMethod.BO_REF_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getIcon())){
        	conditionsStr.append(" and ICON like  CONCAT('%',#{ipfCcmBoMethod.ICON},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getRemark())){
        	conditionsStr.append(" and REMARK like  CONCAT('%',#{ipfCcmBoMethod.REMARK},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getMethodDesc())){
        	conditionsStr.append(" and METHOD_DESC like  CONCAT('%',#{ipfCcmBoMethod.METHOD_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getMethodName())){
        	conditionsStr.append(" and METHOD_NAME like  CONCAT('%',#{ipfCcmBoMethod.METHOD_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getMethodType())){
        	conditionsStr.append(" and METHOD_TYPE like  CONCAT('%',#{ipfCcmBoMethod.METHOD_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getUrl())){
        	conditionsStr.append(" and URL like  CONCAT('%',#{ipfCcmBoMethod.URL},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getIsDefault())){
        	conditionsStr.append(" and IS_DEFAULT like  CONCAT('%',#{ipfCcmBoMethod.IS_DEFAULT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getIsVisible())){
        	conditionsStr.append(" and IS_VISIBLE like  CONCAT('%',#{ipfCcmBoMethod.IS_VISIBLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getRefShlpName())){
        	conditionsStr.append(" and REF_SHLP_NAME like  CONCAT('%',#{ipfCcmBoMethod.REF_SHLP_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getRuleNo())){
        	conditionsStr.append(" and RULE_NO like  CONCAT('%',#{ipfCcmBoMethod.RULE_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getJumpMethodId())){
        	conditionsStr.append(" and JUMP_METHOD_ID like  CONCAT('%',#{ipfCcmBoMethod.JUMP_METHOD_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getJumpMethodName())){
        	conditionsStr.append(" and JUMP_METHOD_NAME like  CONCAT('%',#{ipfCcmBoMethod.JUMP_METHOD_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getJumpBoName())){
        	conditionsStr.append(" and JUMP_BO_NAME like  CONCAT('%',#{ipfCcmBoMethod.JUMP_BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getWidth())){
        	conditionsStr.append(" and WIDTH like  CONCAT('%',#{ipfCcmBoMethod.WIDTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getHeight())){
        	conditionsStr.append(" and HEIGHT like  CONCAT('%',#{ipfCcmBoMethod.HEIGHT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getGroupName())){
        	conditionsStr.append(" and GROUP_NAME like  CONCAT('%',#{ipfCcmBoMethod.GROUP_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getGroupDesc())){
        	conditionsStr.append(" and GROUP_DESC like  CONCAT('%',#{ipfCcmBoMethod.GROUP_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getIsCache())){
        	conditionsStr.append(" and IS_CACHE like  CONCAT('%',#{ipfCcmBoMethod.IS_CACHE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getCacheType())){
        	conditionsStr.append(" and CACHE_TYPE like  CONCAT('%',#{ipfCcmBoMethod.CACHE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getRequestType())){
        	conditionsStr.append(" and REQUEST_TYPE like  CONCAT('%',#{ipfCcmBoMethod.REQUEST_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getJumpWindowTitle())){
        	conditionsStr.append(" and JUMP_WINDOW_TITLE like  CONCAT('%',#{ipfCcmBoMethod.JUMP_WINDOW_TITLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethod.getIsRefreshParentBo())){
        	conditionsStr.append(" and IS_REFRESH_PARENT_BO like  CONCAT('%',#{ipfCcmBoMethod.IS_REFRESH_PARENT_BO},'%')");
        }
        return  conditionsStr.toString();
    }
}


