/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.codegener.dao;

import com.cartan.core.codegener.domain.Codegener;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class CodegenerSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_codegener where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        Codegener codegener=new Codegener();
        codegener=(Codegener)parameter.get("codegener");

        if(StringUtils.isNotBlank(codegener.getId())){
        	conditionsStr.append(" and ID = #{codegener.ID} ");
        }    		
        if(StringUtils.isNotBlank(codegener.getSetupName())){
        	conditionsStr.append(" and SETUP_NAME like  CONCAT('%',#{codegener.SETUP_NAME},'%')");
        }
        if(StringUtils.isNotBlank(codegener.getBasePackage())){
        	conditionsStr.append(" and BASE_PACKAGE like  CONCAT('%',#{codegener.BASE_PACKAGE},'%')");
        }
        if(StringUtils.isNotBlank(codegener.getModuleName())){
        	conditionsStr.append(" and MODULE_NAME like  CONCAT('%',#{codegener.MODULE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(codegener.getRoot())){
        	conditionsStr.append(" and ROOT like  CONCAT('%',#{codegener.ROOT},'%')");
        }
        if(StringUtils.isNotBlank(codegener.getOutput())){
        	conditionsStr.append(" and OUTPUT like  CONCAT('%',#{codegener.OUTPUT},'%')");
        }
        if(StringUtils.isNotBlank(codegener.getSysname())){
        	conditionsStr.append(" and SYSNAME like  CONCAT('%',#{codegener.SYSNAME},'%')");
        }
        if(StringUtils.isNotBlank(codegener.getStatus())){
        	conditionsStr.append(" and STATUS like  CONCAT('%',#{codegener.STATUS},'%')");
        }
        if(StringUtils.isNotBlank(codegener.getLockMan())){
        	conditionsStr.append(" and LOCK_MAN like  CONCAT('%',#{codegener.LOCK_MAN},'%')");
        }
        if(StringUtils.isNotBlank(codegener.getLockTime())){
        	conditionsStr.append(" and LOCK_TIME like  CONCAT('%',#{codegener.LOCK_TIME},'%')");
        }
        if(StringUtils.isNotBlank(codegener.getProjectName())){
        	conditionsStr.append(" and projectName like  CONCAT('%',#{codegener.projectName},'%')");
        }
        return  conditionsStr.toString();
    }
}


