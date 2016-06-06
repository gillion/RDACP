/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoControlEvent.dao;

import com.cartan.core.ipfCcmBoControlEvent.domain.IpfCcmBoControlEvent;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoControlEventSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_control_event where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoControlEvent ipfCcmBoControlEvent=new IpfCcmBoControlEvent();
        ipfCcmBoControlEvent=(IpfCcmBoControlEvent)parameter.get("ipfCcmBoControlEvent");

        if(StringUtils.isNotBlank(ipfCcmBoControlEvent.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoControlEvent.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoControlEvent.getIpfCcbBoFormColumnId())){
        	conditionsStr.append(" and IPF_CCB_BO_FORM_COLUMN_ID like  CONCAT('%',#{ipfCcmBoControlEvent.IPF_CCB_BO_FORM_COLUMN_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoControlEvent.getEventType())){
        	conditionsStr.append(" and EVENT_TYPE like  CONCAT('%',#{ipfCcmBoControlEvent.EVENT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoControlEvent.getExecType())){
        	conditionsStr.append(" and EXEC_TYPE like  CONCAT('%',#{ipfCcmBoControlEvent.EXEC_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoControlEvent.getExecContent())){
        	conditionsStr.append(" and EXEC_CONTENT like  CONCAT('%',#{ipfCcmBoControlEvent.EXEC_CONTENT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoControlEvent.getCallBack())){
        	conditionsStr.append(" and CALL_BACK like  CONCAT('%',#{ipfCcmBoControlEvent.CALL_BACK},'%')");
        }
        return  conditionsStr.toString();
    }
}


