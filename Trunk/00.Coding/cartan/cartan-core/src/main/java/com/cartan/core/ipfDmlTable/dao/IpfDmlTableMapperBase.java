package com.cartan.core.ipfDmlTable.dao;

import com.cartan.core.ipfDmlTable.domain.IpfDmlTable;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlTableMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_table s WHERE s.ID = #{id}")
	IpfDmlTable getIpfDmlTable(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_table(ID,TABLE_NAME,TABLE_TYPE,TABLE_DESC) VALUES(#{id},#{tableName},#{tableType},#{tableDesc})")
    void createIpfDmlTable(IpfDmlTable ipfDmlTable);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_table WHERE ID = #{id}")
    void deleteIpfDmlTable(String id);

    @Update("update cartan_common.t_ipf_dml_table set TABLE_NAME=#{tableName},TABLE_TYPE=#{tableType},TABLE_DESC=#{tableDesc} where ID = #{id}")
    void updateIpfDmlTable(IpfDmlTable ipfDmlTable);

    @Select("select count(*) c from cartan_common.t_ipf_dml_table")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_table order by ID asc")
    ArrayList<IpfDmlTable> selectAll();
    
    @SelectProvider(type = IpfDmlTableSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlTable> selectWithCondition(@Param("ipfDmlTable") IpfDmlTable ipfDmlTable,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlTable> selectBySql(@Param("SqlStr") String SqlStr);
}

