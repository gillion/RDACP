/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfDmlView.dao;

import com.cartan.core.ipfDmlView.domain.IpfDmlView;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfDmlViewSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_dml_view where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfDmlView ipfDmlView=new IpfDmlView();
        ipfDmlView=(IpfDmlView)parameter.get("ipfDmlView");

        if(StringUtils.isNotBlank(ipfDmlView.getId())){
        	conditionsStr.append(" and ID = #{ipfDmlView.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfDmlView.getViewName())){
        	conditionsStr.append(" and VIEW_NAME like  CONCAT('%',#{ipfDmlView.VIEW_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlView.getViewDes())){
        	conditionsStr.append(" and VIEW_DES like  CONCAT('%',#{ipfDmlView.VIEW_DES},'%')");
        }
        if(StringUtils.isNotBlank(ipfDmlView.getViewType())){
        	conditionsStr.append(" and VIEW_TYPE like  CONCAT('%',#{ipfDmlView.VIEW_TYPE},'%')");
        }
        return  conditionsStr.toString();
    }
}


