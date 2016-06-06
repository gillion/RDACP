package com.cartan.core.ipfDmlElementText.dao;

import com.cartan.core.ipfDmlElementText.domain.IpfDmlElementText;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfDmlElementTextMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_dml_element_text s WHERE s.ID = #{id}")
	IpfDmlElementText getIpfDmlElementText(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_dml_element_text(ID,IPF_DML_ELEMENT_ID,DD_LANGUAGE,DD_TEXT) VALUES(#{id},#{ipfDmlElementId},#{ddLanguage},#{ddText})")
    void createIpfDmlElementText(IpfDmlElementText ipfDmlElementText);
    
    @Delete("DELETE FROM cartan_common.t_ipf_dml_element_text WHERE ID = #{id}")
    void deleteIpfDmlElementText(String id);

    @Update("update cartan_common.t_ipf_dml_element_text set IPF_DML_ELEMENT_ID=#{ipfDmlElementId},DD_LANGUAGE=#{ddLanguage},DD_TEXT=#{ddText} where ID = #{id}")
    void updateIpfDmlElementText(IpfDmlElementText ipfDmlElementText);

    @Select("select count(*) c from cartan_common.t_ipf_dml_element_text")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_dml_element_text order by ID asc")
    ArrayList<IpfDmlElementText> selectAll();
    
    @SelectProvider(type = IpfDmlElementTextSqlProvider.class, method = "getSql")
    ArrayList<IpfDmlElementText> selectWithCondition(@Param("ipfDmlElementText") IpfDmlElementText ipfDmlElementText,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfDmlElementText> selectBySql(@Param("SqlStr") String SqlStr);
}

