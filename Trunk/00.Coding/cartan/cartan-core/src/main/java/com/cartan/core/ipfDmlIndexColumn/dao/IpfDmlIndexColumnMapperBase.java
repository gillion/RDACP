package com.cartan.core.ipfDmlIndexColumn.dao;

import com.cartan.core.ipfDmlIndexColumn.domain.IpfDmlIndexColumn;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlIndexColumnMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_index_column s WHERE s.ID = #{id}")
	IpfDmlIndexColumn getIpfDmlIndexColumn(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_index_column(ID,IPF_DML_INDEX_ID,COLUMN_NAME,INDEX_OPTION) VALUES(#{id},#{ipfDmlIndexId},#{columnName},#{indexOption})")
    void createIpfDmlIndexColumn(IpfDmlIndexColumn ipfDmlIndexColumn);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_index_column WHERE ID = #{id}")
    void deleteIpfDmlIndexColumn(String id);

    @Update("update cartan_common.t_ipf_dml_index_column set IPF_DML_INDEX_ID=#{ipfDmlIndexId},COLUMN_NAME=#{columnName},INDEX_OPTION=#{indexOption} where ID = #{id}")
    void updateIpfDmlIndexColumn(IpfDmlIndexColumn ipfDmlIndexColumn);

    @Select("select count(*) c from cartan_common.t_ipf_dml_index_column")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_index_column order by ID asc")
    ArrayList<IpfDmlIndexColumn> selectAll();
    
    @SelectProvider(type = IpfDmlIndexColumnSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlIndexColumn> selectWithCondition(@Param("ipfDmlIndexColumn") IpfDmlIndexColumn ipfDmlIndexColumn,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlIndexColumn> selectBySql(@Param("SqlStr") String SqlStr);
}

