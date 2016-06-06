package com.cartan.core.ipfDmlColumn.dao;

import com.cartan.core.ipfDmlColumn.domain.IpfDmlColumn;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlColumnMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_column s WHERE s.ID = #{id}")
	IpfDmlColumn getIpfDmlColumn(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_column(ID,IPF_DML_TABLE_ID,COLUMN_NAME,IPF_DML_ELEMENT_ID,ELEMENT_CODE,FIELD_TEXT,DATA_TYPE,FIELD_LENGTH,DECIMALS,IS_NOT_NULL,IS_PRIMARY_KEY,DEFAULT_VALUE,INIT_VALUE) VALUES(#{id},#{ipfDmlTableId},#{columnName},#{ipfDmlElementId},#{elementCode},#{fieldText},#{dataType},#{fieldLength},#{decimals},#{isNotNull},#{isPrimaryKey},#{defaultValue},#{initValue})")
    void createIpfDmlColumn(IpfDmlColumn ipfDmlColumn);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_column WHERE ID = #{id}")
    void deleteIpfDmlColumn(String id);

    @Update("update cartan_common.t_ipf_dml_column set IPF_DML_TABLE_ID=#{ipfDmlTableId},COLUMN_NAME=#{columnName},IPF_DML_ELEMENT_ID=#{ipfDmlElementId},ELEMENT_CODE=#{elementCode},FIELD_TEXT=#{fieldText},DATA_TYPE=#{dataType},FIELD_LENGTH=#{fieldLength},DECIMALS=#{decimals},IS_NOT_NULL=#{isNotNull},IS_PRIMARY_KEY=#{isPrimaryKey},DEFAULT_VALUE=#{defaultValue},INIT_VALUE=#{initValue} where ID = #{id}")
    void updateIpfDmlColumn(IpfDmlColumn ipfDmlColumn);

    @Select("select count(*) c from cartan_common.t_ipf_dml_column")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_column order by ID asc")
    ArrayList<IpfDmlColumn> selectAll();
    
    @SelectProvider(type = IpfDmlColumnSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlColumn> selectWithCondition(@Param("ipfDmlColumn") IpfDmlColumn ipfDmlColumn,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlColumn> selectBySql(@Param("SqlStr") String SqlStr);
}

