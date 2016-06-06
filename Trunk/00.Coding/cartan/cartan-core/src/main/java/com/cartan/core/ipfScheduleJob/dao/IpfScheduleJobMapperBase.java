package com.cartan.core.ipfScheduleJob.dao;

import com.cartan.core.ipfScheduleJob.domain.IpfScheduleJob;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfScheduleJobMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_schedule_job s WHERE s.ID = #{id}")
	IpfScheduleJob getIpfScheduleJob(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_schedule_job(ID,JOB_NAME,JOB_GROUP,JOB_STATUS,CRON_EXPRESSION,JOB_DESC,RULE_NO,JOB_SERVICE,JOB_METHOD) VALUES(#{id},#{jobName},#{jobGroup},#{jobStatus},#{cronExpression},#{jobDesc},#{ruleNo},#{jobService},#{jobMethod})")
    void createIpfScheduleJob(IpfScheduleJob ipfScheduleJob);
    
    @Delete("DELETE FROM cartan_common.t_ipf_schedule_job WHERE ID = #{id}")
    void deleteIpfScheduleJob(String id);

    @Update("update cartan_common.t_ipf_schedule_job set JOB_NAME=#{jobName},JOB_GROUP=#{jobGroup},JOB_STATUS=#{jobStatus},CRON_EXPRESSION=#{cronExpression},JOB_DESC=#{jobDesc},RULE_NO=#{ruleNo},JOB_SERVICE=#{jobService},JOB_METHOD=#{jobMethod} where ID = #{id}")
    void updateIpfScheduleJob(IpfScheduleJob ipfScheduleJob);

    @Select("select count(*) c from cartan_common.t_ipf_schedule_job")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_schedule_job order by ID asc")
    ArrayList<IpfScheduleJob> selectAll();
    
    @SelectProvider(type = IpfScheduleJobSqlProvider.class, method = "getSql")
    ArrayList<IpfScheduleJob> selectWithCondition(@Param("ipfScheduleJob") IpfScheduleJob ipfScheduleJob,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfScheduleJob> selectBySql(@Param("SqlStr") String SqlStr);
}

