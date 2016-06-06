package com.cartan.core.ipfCcmDict.dao;

import com.cartan.core.ipfCcmDict.domain.IpfCcmDict;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmDictMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_dict s WHERE s.ID = #{id}")
	IpfCcmDict getIpfCcmDict(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_dict(ID,DICT_CODE,DICT_NAME,DICT_TYPE,CODE_COLUMN,NAME_COLUMN,KEY_COLUMN,TABLE_NAME,IS_GROUP,GROUP_COLUMN,REMARK,ORDER_COLUMN,IS_SYSTEM,DATA_TYPE,FIELD_LENGTH,DECIMALS) VALUES(#{id},#{dictCode},#{dictName},#{dictType},#{codeColumn},#{nameColumn},#{keyColumn},#{tableName},#{isGroup},#{groupColumn},#{remark},#{orderColumn},#{isSystem},#{dataType},#{fieldLength},#{decimals})")
    void createIpfCcmDict(IpfCcmDict ipfCcmDict);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_dict WHERE ID = #{id}")
    void deleteIpfCcmDict(String id);

    @Update("update cartan_common.t_ipf_ccm_dict set DICT_CODE=#{dictCode},DICT_NAME=#{dictName},DICT_TYPE=#{dictType},CODE_COLUMN=#{codeColumn},NAME_COLUMN=#{nameColumn},KEY_COLUMN=#{keyColumn},TABLE_NAME=#{tableName},IS_GROUP=#{isGroup},GROUP_COLUMN=#{groupColumn},REMARK=#{remark},ORDER_COLUMN=#{orderColumn},IS_SYSTEM=#{isSystem},DATA_TYPE=#{dataType},FIELD_LENGTH=#{fieldLength},DECIMALS=#{decimals} where ID = #{id}")
    void updateIpfCcmDict(IpfCcmDict ipfCcmDict);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_dict")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_dict order by ID asc")
    ArrayList<IpfCcmDict> selectAll();
    
    @SelectProvider(type = IpfCcmDictSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmDict> selectWithCondition(@Param("ipfCcmDict") IpfCcmDict ipfCcmDict,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmDict> selectBySql(@Param("SqlStr") String SqlStr);
}

