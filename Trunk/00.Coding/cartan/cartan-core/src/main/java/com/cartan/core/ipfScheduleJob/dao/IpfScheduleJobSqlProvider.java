/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfScheduleJob.dao;

import com.cartan.core.ipfScheduleJob.domain.IpfScheduleJob;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfScheduleJobSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_schedule_job where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfScheduleJob ipfScheduleJob=new IpfScheduleJob();
        ipfScheduleJob=(IpfScheduleJob)parameter.get("ipfScheduleJob");

        if(StringUtils.isNotBlank(ipfScheduleJob.getId())){
        	conditionsStr.append(" and ID = #{ipfScheduleJob.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfScheduleJob.getJobName())){
        	conditionsStr.append(" and JOB_NAME like  CONCAT('%',#{ipfScheduleJob.JOB_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfScheduleJob.getJobGroup())){
        	conditionsStr.append(" and JOB_GROUP like  CONCAT('%',#{ipfScheduleJob.JOB_GROUP},'%')");
        }
        if(StringUtils.isNotBlank(ipfScheduleJob.getJobStatus())){
        	conditionsStr.append(" and JOB_STATUS like  CONCAT('%',#{ipfScheduleJob.JOB_STATUS},'%')");
        }
        if(StringUtils.isNotBlank(ipfScheduleJob.getCronExpression())){
        	conditionsStr.append(" and CRON_EXPRESSION like  CONCAT('%',#{ipfScheduleJob.CRON_EXPRESSION},'%')");
        }
        if(StringUtils.isNotBlank(ipfScheduleJob.getJobDesc())){
        	conditionsStr.append(" and JOB_DESC like  CONCAT('%',#{ipfScheduleJob.JOB_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfScheduleJob.getRuleNo())){
        	conditionsStr.append(" and RULE_NO like  CONCAT('%',#{ipfScheduleJob.RULE_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfScheduleJob.getJobService())){
        	conditionsStr.append(" and JOB_SERVICE like  CONCAT('%',#{ipfScheduleJob.JOB_SERVICE},'%')");
        }
        if(StringUtils.isNotBlank(ipfScheduleJob.getJobMethod())){
        	conditionsStr.append(" and JOB_METHOD like  CONCAT('%',#{ipfScheduleJob.JOB_METHOD},'%')");
        }
        return  conditionsStr.toString();
    }
}


