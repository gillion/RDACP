package com.cartan.core.ipfDmlConstraintColumn.dao;

import com.cartan.core.ipfDmlConstraintColumn.domain.IpfDmlConstraintColumn;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlConstraintColumnMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_constraint_column s WHERE s.ID = #{id}")
	IpfDmlConstraintColumn getIpfDmlConstraintColumn(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_constraint_column(ID,IPF_DML_CONSTRAINT_ID,COLUMN_NAME) VALUES(#{id},#{ipfDmlConstraintId},#{columnName})")
    void createIpfDmlConstraintColumn(IpfDmlConstraintColumn ipfDmlConstraintColumn);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_constraint_column WHERE ID = #{id}")
    void deleteIpfDmlConstraintColumn(String id);

    @Update("update cartan_common.t_ipf_dml_constraint_column set IPF_DML_CONSTRAINT_ID=#{ipfDmlConstraintId},COLUMN_NAME=#{columnName} where ID = #{id}")
    void updateIpfDmlConstraintColumn(IpfDmlConstraintColumn ipfDmlConstraintColumn);

    @Select("select count(*) c from cartan_common.t_ipf_dml_constraint_column")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_constraint_column order by ID asc")
    ArrayList<IpfDmlConstraintColumn> selectAll();
    
    @SelectProvider(type = IpfDmlConstraintColumnSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlConstraintColumn> selectWithCondition(@Param("ipfDmlConstraintColumn") IpfDmlConstraintColumn ipfDmlConstraintColumn,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlConstraintColumn> selectBySql(@Param("SqlStr") String SqlStr);
}

