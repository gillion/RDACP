package com.cartan.core.ipfDmlViewSql.dao;

import com.cartan.core.ipfDmlViewSql.domain.IpfDmlViewSql;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlViewSqlMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_view_sql s WHERE s.ID = #{id}")
	IpfDmlViewSql getIpfDmlViewSql(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_view_sql(ID,IPF_DML_VIEW_ID,DBMS_TYPE,SQL_STATEMENT) VALUES(#{id},#{ipfDmlViewId},#{dbmsType},#{sqlStatement})")
    void createIpfDmlViewSql(IpfDmlViewSql ipfDmlViewSql);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_view_sql WHERE ID = #{id}")
    void deleteIpfDmlViewSql(String id);

    @Update("update cartan_common.t_ipf_dml_view_sql set IPF_DML_VIEW_ID=#{ipfDmlViewId},DBMS_TYPE=#{dbmsType},SQL_STATEMENT=#{sqlStatement} where ID = #{id}")
    void updateIpfDmlViewSql(IpfDmlViewSql ipfDmlViewSql);

    @Select("select count(*) c from cartan_common.t_ipf_dml_view_sql")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_view_sql order by ID asc")
    ArrayList<IpfDmlViewSql> selectAll();
    
    @SelectProvider(type = IpfDmlViewSqlSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlViewSql> selectWithCondition(@Param("ipfDmlViewSql") IpfDmlViewSql ipfDmlViewSql,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlViewSql> selectBySql(@Param("SqlStr") String SqlStr);
}

