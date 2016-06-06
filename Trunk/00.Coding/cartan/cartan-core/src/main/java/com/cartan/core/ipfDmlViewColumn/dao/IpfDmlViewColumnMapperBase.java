package com.cartan.core.ipfDmlViewColumn.dao;

import com.cartan.core.ipfDmlViewColumn.domain.IpfDmlViewColumn;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlViewColumnMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_view_column s WHERE s.ID = #{id}")
	IpfDmlViewColumn getIpfDmlViewColumn(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_view_column(ID,IPF_DML_VIEW_ID,COLUMN_NAME,FIELD_TEXT,DATA_TYPE,FIELD_LENGTH,DECIMALS,IS_NOT_NULL,IS_PRIMARY_KEY) VALUES(#{id},#{ipfDmlViewId},#{columnName},#{fieldText},#{dataType},#{fieldLength},#{decimals},#{isNotNull},#{isPrimaryKey})")
    void createIpfDmlViewColumn(IpfDmlViewColumn ipfDmlViewColumn);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_view_column WHERE ID = #{id}")
    void deleteIpfDmlViewColumn(String id);

    @Update("update cartan_common.t_ipf_dml_view_column set IPF_DML_VIEW_ID=#{ipfDmlViewId},COLUMN_NAME=#{columnName},FIELD_TEXT=#{fieldText},DATA_TYPE=#{dataType},FIELD_LENGTH=#{fieldLength},DECIMALS=#{decimals},IS_NOT_NULL=#{isNotNull},IS_PRIMARY_KEY=#{isPrimaryKey} where ID = #{id}")
    void updateIpfDmlViewColumn(IpfDmlViewColumn ipfDmlViewColumn);

    @Select("select count(*) c from cartan_common.t_ipf_dml_view_column")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_view_column order by ID asc")
    ArrayList<IpfDmlViewColumn> selectAll();
    
    @SelectProvider(type = IpfDmlViewColumnSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlViewColumn> selectWithCondition(@Param("ipfDmlViewColumn") IpfDmlViewColumn ipfDmlViewColumn,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlViewColumn> selectBySql(@Param("SqlStr") String SqlStr);
}

