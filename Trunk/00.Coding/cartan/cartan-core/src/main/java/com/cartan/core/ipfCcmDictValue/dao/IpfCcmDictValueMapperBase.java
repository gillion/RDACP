package com.cartan.core.ipfCcmDictValue.dao;

import com.cartan.core.ipfCcmDictValue.domain.IpfCcmDictValue;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmDictValueMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_dict_value s WHERE s.ID = #{id}")
	IpfCcmDictValue getIpfCcmDictValue(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_dict_value(ID,IPF_CCM_DICT_ID,CODE_VALUE,DISPLAY_VALUE,SEQ_NO,GROUP_VALUE,REMARK) VALUES(#{id},#{ipfCcmDictId},#{codeValue},#{displayValue},#{seqNo},#{groupValue},#{remark})")
    void createIpfCcmDictValue(IpfCcmDictValue ipfCcmDictValue);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_dict_value WHERE ID = #{id}")
    void deleteIpfCcmDictValue(String id);

    @Update("update cartan_common.t_ipf_ccm_dict_value set IPF_CCM_DICT_ID=#{ipfCcmDictId},CODE_VALUE=#{codeValue},DISPLAY_VALUE=#{displayValue},SEQ_NO=#{seqNo},GROUP_VALUE=#{groupValue},REMARK=#{remark} where ID = #{id}")
    void updateIpfCcmDictValue(IpfCcmDictValue ipfCcmDictValue);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_dict_value")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_dict_value order by ID asc")
    ArrayList<IpfCcmDictValue> selectAll();
    
    @SelectProvider(type = IpfCcmDictValueSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmDictValue> selectWithCondition(@Param("ipfCcmDictValue") IpfCcmDictValue ipfCcmDictValue,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmDictValue> selectBySql(@Param("SqlStr") String SqlStr);
}

