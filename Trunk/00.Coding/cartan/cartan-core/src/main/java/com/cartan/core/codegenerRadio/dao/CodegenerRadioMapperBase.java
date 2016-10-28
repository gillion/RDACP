package com.cartan.core.codegenerRadio.dao;

import com.cartan.core.codegenerRadio.domain.CodegenerRadio;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface CodegenerRadioMapperBase {
	@Select("SELECT * FROM cartan_common.t_codegener_radio s WHERE s.ID = #{id}")
	CodegenerRadio getCodegenerRadio(String id);
	
	@Insert("INSERT INTO cartan_common.t_codegener_radio(ID,SETUP_ID,TABLE_ID,RADIO_FIELD,CODE_TYPE) VALUES(#{id},#{setupId},#{tableId},#{radioField},#{codeType})")
    void createCodegenerRadio(CodegenerRadio codegenerRadio);
    
    @Delete("DELETE FROM cartan_common.t_codegener_radio WHERE ID = #{id}")
    void deleteCodegenerRadio(String id);

    @Update("update cartan_common.t_codegener_radio set SETUP_ID=#{setupId},TABLE_ID=#{tableId},RADIO_FIELD=#{radioField},CODE_TYPE=#{codeType} where ID = #{id}")
    void updateCodegenerRadio(CodegenerRadio codegenerRadio);

    @Select("select count(*) c from cartan_common.t_codegener_radio")
    int countAll();
    
    @Select("select * from cartan_common.t_codegener_radio order by ID asc")
    ArrayList<CodegenerRadio> selectAll();
    
    @SelectProvider(type = CodegenerRadioSqlProvider.class, method = "getSql")
    ArrayList<CodegenerRadio> selectWithCondition(@Param("codegenerRadio") CodegenerRadio codegenerRadio,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<CodegenerRadio> selectBySql(@Param("SqlStr") String SqlStr);
}

