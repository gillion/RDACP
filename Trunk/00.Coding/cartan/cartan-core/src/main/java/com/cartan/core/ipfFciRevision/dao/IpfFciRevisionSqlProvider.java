/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfFciRevision.dao;

import com.cartan.core.ipfFciRevision.domain.IpfFciRevision;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfFciRevisionSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_fci_revision where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfFciRevision ipfFciRevision=new IpfFciRevision();
        ipfFciRevision=(IpfFciRevision)parameter.get("ipfFciRevision");

        if(StringUtils.isNotBlank(ipfFciRevision.getId())){
        	conditionsStr.append(" and ID = #{ipfFciRevision.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfFciRevision.getIpfFciViewId())){
        	conditionsStr.append(" and IPF_FCI_VIEW_ID like  CONCAT('%',#{ipfFciRevision.IPF_FCI_VIEW_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciRevision.getIpfFciProjectId())){
        	conditionsStr.append(" and IPF_FCI_PROJECT_ID like  CONCAT('%',#{ipfFciRevision.IPF_FCI_PROJECT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciRevision.getRevisionNumber())){
        	conditionsStr.append(" and REVISION_NUMBER like  CONCAT('%',#{ipfFciRevision.REVISION_NUMBER},'%')");
        }
        if(StringUtils.isNotBlank(ipfFciRevision.getRemark())){
        	conditionsStr.append(" and REMARK like  CONCAT('%',#{ipfFciRevision.REMARK},'%')");
        }
        return  conditionsStr.toString();
    }
}


