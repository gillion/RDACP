/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoCheckGroup.dao;

import com.cartan.core.ipfCcmBoCheckGroup.domain.IpfCcmBoCheckGroup;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoCheckGroupSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_check_group where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoCheckGroup ipfCcmBoCheckGroup=new IpfCcmBoCheckGroup();
        ipfCcmBoCheckGroup=(IpfCcmBoCheckGroup)parameter.get("ipfCcmBoCheckGroup");

        if(StringUtils.isNotBlank(ipfCcmBoCheckGroup.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoCheckGroup.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoCheckGroup.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfCcmBoCheckGroup.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoCheckGroup.getGroupName())){
        	conditionsStr.append(" and GROUP_NAME like  CONCAT('%',#{ipfCcmBoCheckGroup.GROUP_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoCheckGroup.getGroupDesc())){
        	conditionsStr.append(" and GROUP_DESC like  CONCAT('%',#{ipfCcmBoCheckGroup.GROUP_DESC},'%')");
        }
        return  conditionsStr.toString();
    }
}


