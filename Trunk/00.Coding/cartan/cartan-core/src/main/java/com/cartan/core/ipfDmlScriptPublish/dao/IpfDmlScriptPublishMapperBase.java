package com.cartan.core.ipfDmlScriptPublish.dao;

import com.cartan.core.ipfDmlScriptPublish.domain.IpfDmlScriptPublish;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlScriptPublishMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_script_publish s WHERE s.ID = #{id}")
	IpfDmlScriptPublish getIpfDmlScriptPublish(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_script_publish(ID,FILE_NAME,FILE_DES,FILE_CONTENT,IS_PUBLISHED) VALUES(#{id},#{fileName},#{fileDes},#{fileContent},#{isPublished})")
    void createIpfDmlScriptPublish(IpfDmlScriptPublish ipfDmlScriptPublish);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_script_publish WHERE ID = #{id}")
    void deleteIpfDmlScriptPublish(String id);

    @Update("update cartan_common.t_ipf_dml_script_publish set FILE_NAME=#{fileName},FILE_DES=#{fileDes},FILE_CONTENT=#{fileContent},IS_PUBLISHED=#{isPublished} where ID = #{id}")
    void updateIpfDmlScriptPublish(IpfDmlScriptPublish ipfDmlScriptPublish);

    @Select("select count(*) c from cartan_common.t_ipf_dml_script_publish")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_script_publish order by ID asc")
    ArrayList<IpfDmlScriptPublish> selectAll();
    
    @SelectProvider(type = IpfDmlScriptPublishSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlScriptPublish> selectWithCondition(@Param("ipfDmlScriptPublish") IpfDmlScriptPublish ipfDmlScriptPublish,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlScriptPublish> selectBySql(@Param("SqlStr") String SqlStr);
}

