package com.cartan.core.codegenerSelect.dao;

import com.cartan.core.codegenerSelect.domain.CodegenerSelect;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface CodegenerSelectMapperBase {
	@Select("SELECT * FROM cartan_common.t_codegener_select s WHERE s.ID = #{id}")
	CodegenerSelect getCodegenerSelect(String id);
	
	@Insert("INSERT INTO cartan_common.t_codegener_select(ID,SETUP_ID,TABLE_ID,SELECT_FIELD,SELECT_TABLE,SELECT_DES) VALUES(#{id},#{setupId},#{tableId},#{selectField},#{selectTable},#{selectDes})")
    void createCodegenerSelect(CodegenerSelect codegenerSelect);
    
    @Delete("DELETE FROM cartan_common.t_codegener_select WHERE ID = #{id}")
    void deleteCodegenerSelect(String id);

    @Update("update cartan_common.t_codegener_select set SETUP_ID=#{setupId},TABLE_ID=#{tableId},SELECT_FIELD=#{selectField},SELECT_TABLE=#{selectTable},SELECT_DES=#{selectDes} where ID = #{id}")
    void updateCodegenerSelect(CodegenerSelect codegenerSelect);

    @Select("select count(*) c from cartan_common.t_codegener_select")
    int countAll();
    
    @Select("select * from cartan_common.t_codegener_select order by ID asc")
    ArrayList<CodegenerSelect> selectAll();
    
    @SelectProvider(type = CodegenerSelectSqlProvider.class, method = "getSql")
    ArrayList<CodegenerSelect> selectWithCondition(@Param("codegenerSelect") CodegenerSelect codegenerSelect,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<CodegenerSelect> selectBySql(@Param("SqlStr") String SqlStr);
}

