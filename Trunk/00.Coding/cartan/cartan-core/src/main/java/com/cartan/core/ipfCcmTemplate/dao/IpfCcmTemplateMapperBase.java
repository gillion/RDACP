package com.cartan.core.ipfCcmTemplate.dao;

import com.cartan.core.ipfCcmTemplate.domain.IpfCcmTemplate;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmTemplateMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_template s WHERE s.ID = #{id}")
	IpfCcmTemplate getIpfCcmTemplate(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_template(ID,TEMPLATE_FILE,TEMPLATE_DESC,TEMPLATE_TYPE) VALUES(#{id},#{templateFile},#{templateDesc},#{templateType})")
    void createIpfCcmTemplate(IpfCcmTemplate ipfCcmTemplate);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_template WHERE ID = #{id}")
    void deleteIpfCcmTemplate(String id);

    @Update("update cartan_common.t_ipf_ccm_template set TEMPLATE_FILE=#{templateFile},TEMPLATE_DESC=#{templateDesc},TEMPLATE_TYPE=#{templateType} where ID = #{id}")
    void updateIpfCcmTemplate(IpfCcmTemplate ipfCcmTemplate);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_template")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_template order by ID asc")
    ArrayList<IpfCcmTemplate> selectAll();
    
    @SelectProvider(type = IpfCcmTemplateSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmTemplate> selectWithCondition(@Param("ipfCcmTemplate") IpfCcmTemplate ipfCcmTemplate,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmTemplate> selectBySql(@Param("SqlStr") String SqlStr);
}

