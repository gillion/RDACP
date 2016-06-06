package com.cartan.core.ipfCcmBoControlEvent.dao;

import com.cartan.core.ipfCcmBoControlEvent.domain.IpfCcmBoControlEvent;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoControlEventMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_control_event s WHERE s.ID = #{id}")
	IpfCcmBoControlEvent getIpfCcmBoControlEvent(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_control_event(ID,IPF_CCB_BO_FORM_COLUMN_ID,EVENT_TYPE,EXEC_TYPE,EXEC_CONTENT,CALL_BACK) VALUES(#{id},#{ipfCcbBoFormColumnId},#{eventType},#{execType},#{execContent},#{callBack})")
    void createIpfCcmBoControlEvent(IpfCcmBoControlEvent ipfCcmBoControlEvent);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_control_event WHERE ID = #{id}")
    void deleteIpfCcmBoControlEvent(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_control_event set IPF_CCB_BO_FORM_COLUMN_ID=#{ipfCcbBoFormColumnId},EVENT_TYPE=#{eventType},EXEC_TYPE=#{execType},EXEC_CONTENT=#{execContent},CALL_BACK=#{callBack} where ID = #{id}")
    void updateIpfCcmBoControlEvent(IpfCcmBoControlEvent ipfCcmBoControlEvent);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_control_event")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_control_event order by ID asc")
    ArrayList<IpfCcmBoControlEvent> selectAll();
    
    @SelectProvider(type = IpfCcmBoControlEventSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoControlEvent> selectWithCondition(@Param("ipfCcmBoControlEvent") IpfCcmBoControlEvent ipfCcmBoControlEvent,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoControlEvent> selectBySql(@Param("SqlStr") String SqlStr);
}

