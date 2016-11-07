/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.dataset.dao;

import com.cartan.core.dataset.domain.Dataset;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class DatasetSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_dataset where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        Dataset dataset=new Dataset();
        dataset=(Dataset)parameter.get("dataset");

        if(StringUtils.isNotBlank(dataset.getId())){
        	conditionsStr.append(" and ID = #{dataset.ID} ");
        }    		
        if(StringUtils.isNotBlank(dataset.getDatasetName())){
        	conditionsStr.append(" and DATASET_NAME like  CONCAT('%',#{dataset.DATASET_NAME},'%')");
        }
        if(StringUtils.isNotBlank(dataset.getDatasetDes())){
        	conditionsStr.append(" and DATASET_DES like  CONCAT('%',#{dataset.DATASET_DES},'%')");
        }
        if(StringUtils.isNotBlank(dataset.getDatasetType())){
        	conditionsStr.append(" and DATASET_TYPE like  CONCAT('%',#{dataset.DATASET_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(dataset.getRemark())){
        	conditionsStr.append(" and REMARK like  CONCAT('%',#{dataset.REMARK},'%')");
        }
        return  conditionsStr.toString();
    }
}


