package com.cartan.core.ipfDmlConstraint.dao;

import com.cartan.core.ipfDmlConstraint.domain.IpfDmlConstraint;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlConstraintMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_constraint s WHERE s.ID = #{id}")
	IpfDmlConstraint getIpfDmlConstraint(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_constraint(ID,IPF_DML_TABLE_ID,CONSTRAINT_NAME,CONSTRAINT_TYPE,COLUMN_NAME,FOREIGN_TABLE_NAME,FOREIGN_COLUMN_NAME) VALUES(#{id},#{ipfDmlTableId},#{constraintName},#{constraintType},#{columnName},#{foreignTableName},#{foreignColumnName})")
    void createIpfDmlConstraint(IpfDmlConstraint ipfDmlConstraint);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_constraint WHERE ID = #{id}")
    void deleteIpfDmlConstraint(String id);

    @Update("update cartan_common.t_ipf_dml_constraint set IPF_DML_TABLE_ID=#{ipfDmlTableId},CONSTRAINT_NAME=#{constraintName},CONSTRAINT_TYPE=#{constraintType},COLUMN_NAME=#{columnName},FOREIGN_TABLE_NAME=#{foreignTableName},FOREIGN_COLUMN_NAME=#{foreignColumnName} where ID = #{id}")
    void updateIpfDmlConstraint(IpfDmlConstraint ipfDmlConstraint);

    @Select("select count(*) c from cartan_common.t_ipf_dml_constraint")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_constraint order by ID asc")
    ArrayList<IpfDmlConstraint> selectAll();
    
    @SelectProvider(type = IpfDmlConstraintSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlConstraint> selectWithCondition(@Param("ipfDmlConstraint") IpfDmlConstraint ipfDmlConstraint,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlConstraint> selectBySql(@Param("SqlStr") String SqlStr);
}

