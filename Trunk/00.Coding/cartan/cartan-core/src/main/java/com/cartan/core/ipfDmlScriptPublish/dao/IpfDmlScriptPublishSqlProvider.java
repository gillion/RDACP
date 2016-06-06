/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlScriptPublish.dao;

import com.cartan.core.ipfDmlScriptPublish.domain.IpfDmlScriptPublish;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlScriptPublishSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_script_publish where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlScriptPublish ipfDmlScriptPublish=new IpfDmlScriptPublish();
        ipfDmlScriptPublish=(IpfDmlScriptPublish)parameter.get("ipfDmlScriptPublish");

        if(StringUtils.isNotBlank(ipfDmlScriptPublish.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlScriptPublish.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlScriptPublish.getFileName())){
        	conditionsStr.append(" and FILE_NAME like  CONCAT('%',#{ipfDmlScriptPublish.FILE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlScriptPublish.getFileDes())){
        	conditionsStr.append(" and FILE_DES like  CONCAT('%',#{ipfDmlScriptPublish.FILE_DES},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlScriptPublish.getFileContent())){
        	conditionsStr.append(" and FILE_CONTENT like  CONCAT('%',#{ipfDmlScriptPublish.FILE_CONTENT},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlScriptPublish.getIsPublished())){
        	conditionsStr.append(" and IS_PUBLISHED like  CONCAT('%',#{ipfDmlScriptPublish.IS_PUBLISHED},'%')");
        }
        return  conditionsStr.toString();
    }
}


