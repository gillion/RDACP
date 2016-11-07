/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.datasetVar.dao;

import com.cartan.core.datasetVar.domain.DatasetVar;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class DatasetVarSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_dataset_var where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        DatasetVar datasetVar=new DatasetVar();
        datasetVar=(DatasetVar)parameter.get("datasetVar");

        if(StringUtils.isNotBlank(datasetVar.getId())){
        	conditionsStr.append(" and ID = #{datasetVar.ID} ");
        }    		
        if(StringUtils.isNotBlank(datasetVar.getDatasetId())){
        	conditionsStr.append(" and DATASET_ID like  CONCAT('%',#{datasetVar.DATASET_ID},'%')");
        }
        if(StringUtils.isNotBlank(datasetVar.getVarName())){
        	conditionsStr.append(" and VAR_NAME like  CONCAT('%',#{datasetVar.VAR_NAME},'%')");
        }
        if(StringUtils.isNotBlank(datasetVar.getVarDes())){
        	conditionsStr.append(" and VAR_DES like  CONCAT('%',#{datasetVar.VAR_DES},'%')");
        }
        if(StringUtils.isNotBlank(datasetVar.getIsDerived())){
        	conditionsStr.append(" and IS_DERIVED = #{datasetVar.IS_DERIVED} ");
        }
        if(StringUtils.isNotBlank(datasetVar.getIsSet())){
        	conditionsStr.append(" and IS_SET = #{datasetVar.IS_SET} ");
        }
        if(StringUtils.isNotBlank(datasetVar.getVarType())){
        	conditionsStr.append(" and VAR_TYPE like  CONCAT('%',#{datasetVar.VAR_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(datasetVar.getSpanBegin())){
        	conditionsStr.append(" and SPAN_BEGIN like  CONCAT('%',#{datasetVar.SPAN_BEGIN},'%')");
        }
        if(StringUtils.isNotBlank(datasetVar.getSpanEnd())){
        	conditionsStr.append(" and SPAN_END like  CONCAT('%',#{datasetVar.SPAN_END},'%')");
        }
        if(StringUtils.isNotBlank(datasetVar.getIsOutput())){
        	conditionsStr.append(" and IS_OUTPUT = #{datasetVar.IS_OUTPUT} ");
        }
        if(StringUtils.isNotBlank(datasetVar.getDefValue())){
        	conditionsStr.append(" and DEF_VALUE like  CONCAT('%',#{datasetVar.DEF_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(datasetVar.getRemark())){
        	conditionsStr.append(" and REMARK like  CONCAT('%',#{datasetVar.REMARK},'%')");
        }
        return  conditionsStr.toString();
    }
}


