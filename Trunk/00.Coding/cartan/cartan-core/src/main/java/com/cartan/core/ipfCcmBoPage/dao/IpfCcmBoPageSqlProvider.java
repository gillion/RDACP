/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoPage.dao;

import com.cartan.core.ipfCcmBoPage.domain.IpfCcmBoPage;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoPageSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_page where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoPage ipfCcmBoPage=new IpfCcmBoPage();
        ipfCcmBoPage=(IpfCcmBoPage)parameter.get("ipfCcmBoPage");

        if(StringUtils.isNotBlank(ipfCcmBoPage.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoPage.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoPage.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfCcmBoPage.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPage.getPageType())){
        	conditionsStr.append(" and PAGE_TYPE like  CONCAT('%',#{ipfCcmBoPage.PAGE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPage.getDescription())){
        	conditionsStr.append(" and DESCRIPTION like  CONCAT('%',#{ipfCcmBoPage.DESCRIPTION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPage.getPageName())){
        	conditionsStr.append(" and PAGE_NAME like  CONCAT('%',#{ipfCcmBoPage.PAGE_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}


