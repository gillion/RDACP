package com.cartan.core.ipfDmlView.dao;

import com.cartan.core.ipfDmlView.domain.IpfDmlView;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlViewMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_view s WHERE s.ID = #{id}")
	IpfDmlView getIpfDmlView(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_view(ID,VIEW_NAME,VIEW_DES,VIEW_TYPE) VALUES(#{id},#{viewName},#{viewDes},#{viewType})")
    void createIpfDmlView(IpfDmlView ipfDmlView);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_view WHERE ID = #{id}")
    void deleteIpfDmlView(String id);

    @Update("update cartan_common.t_ipf_dml_view set VIEW_NAME=#{viewName},VIEW_DES=#{viewDes},VIEW_TYPE=#{viewType} where ID = #{id}")
    void updateIpfDmlView(IpfDmlView ipfDmlView);

    @Select("select count(*) c from cartan_common.t_ipf_dml_view")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_view order by ID asc")
    ArrayList<IpfDmlView> selectAll();
    
    @SelectProvider(type = IpfDmlViewSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlView> selectWithCondition(@Param("ipfDmlView") IpfDmlView ipfDmlView,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlView> selectBySql(@Param("SqlStr") String SqlStr);
}

