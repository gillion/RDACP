package com.cartan.core.ipfDmlIndex.dao;

import com.cartan.core.ipfDmlIndex.domain.IpfDmlIndex;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlIndexMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_index s WHERE s.ID = #{id}")
	IpfDmlIndex getIpfDmlIndex(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_index(ID,IPF_DML_TABLE_ID,INDEX_NAME,INDEX_TYPE) VALUES(#{id},#{ipfDmlTableId},#{indexName},#{indexType})")
    void createIpfDmlIndex(IpfDmlIndex ipfDmlIndex);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_index WHERE ID = #{id}")
    void deleteIpfDmlIndex(String id);

    @Update("update cartan_common.t_ipf_dml_index set IPF_DML_TABLE_ID=#{ipfDmlTableId},INDEX_NAME=#{indexName},INDEX_TYPE=#{indexType} where ID = #{id}")
    void updateIpfDmlIndex(IpfDmlIndex ipfDmlIndex);

    @Select("select count(*) c from cartan_common.t_ipf_dml_index")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_index order by ID asc")
    ArrayList<IpfDmlIndex> selectAll();
    
    @SelectProvider(type = IpfDmlIndexSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlIndex> selectWithCondition(@Param("ipfDmlIndex") IpfDmlIndex ipfDmlIndex,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlIndex> selectBySql(@Param("SqlStr") String SqlStr);
}

