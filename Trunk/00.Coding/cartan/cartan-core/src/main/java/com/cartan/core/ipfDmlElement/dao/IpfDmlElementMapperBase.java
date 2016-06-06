package com.cartan.core.ipfDmlElement.dao;

import com.cartan.core.ipfDmlElement.domain.IpfDmlElement;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlElementMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_element s WHERE s.ID = #{id}")
	IpfDmlElement getIpfDmlElement(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_element(ID,ELEMENT_CODE,FIELD_TEXT,DATA_TYPE,FIELD_LENGTH,DECIMALS) VALUES(#{id},#{elementCode},#{fieldText},#{dataType},#{fieldLength},#{decimals})")
    void createIpfDmlElement(IpfDmlElement ipfDmlElement);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_element WHERE ID = #{id}")
    void deleteIpfDmlElement(String id);

    @Update("update cartan_common.t_ipf_dml_element set ELEMENT_CODE=#{elementCode},FIELD_TEXT=#{fieldText},DATA_TYPE=#{dataType},FIELD_LENGTH=#{fieldLength},DECIMALS=#{decimals} where ID = #{id}")
    void updateIpfDmlElement(IpfDmlElement ipfDmlElement);

    @Select("select count(*) c from cartan_common.t_ipf_dml_element")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_element order by ID asc")
    ArrayList<IpfDmlElement> selectAll();
    
    @SelectProvider(type = IpfDmlElementSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlElement> selectWithCondition(@Param("ipfDmlElement") IpfDmlElement ipfDmlElement,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlElement> selectBySql(@Param("SqlStr") String SqlStr);
}

