package com.cartan.core.codegenerCheckbox.dao;

import com.cartan.core.codegenerCheckbox.domain.CodegenerCheckbox;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface CodegenerCheckboxMapperBase {
	@Select("SELECT * FROM cartan_common.t_codegener_checkbox s WHERE s.ID = #{id}")
	CodegenerCheckbox getCodegenerCheckbox(String id);
	
	@Insert("INSERT INTO cartan_common.t_codegener_checkbox(ID,SETUP_ID,TABLE_ID,CHECKBOX_FIELD,CODE_TYPE) VALUES(#{id},#{setupId},#{tableId},#{checkboxField},#{codeType})")
    void createCodegenerCheckbox(CodegenerCheckbox codegenerCheckbox);
    
    @Delete("DELETE FROM cartan_common.t_codegener_checkbox WHERE ID = #{id}")
    void deleteCodegenerCheckbox(String id);

    @Update("update cartan_common.t_codegener_checkbox set SETUP_ID=#{setupId},TABLE_ID=#{tableId},CHECKBOX_FIELD=#{checkboxField},CODE_TYPE=#{codeType} where ID = #{id}")
    void updateCodegenerCheckbox(CodegenerCheckbox codegenerCheckbox);

    @Select("select count(*) c from cartan_common.t_codegener_checkbox")
    int countAll();
    
    @Select("select * from cartan_common.t_codegener_checkbox order by ID asc")
    ArrayList<CodegenerCheckbox> selectAll();
    
    @SelectProvider(type = CodegenerCheckboxSqlProvider.class, method = "getSql")
    ArrayList<CodegenerCheckbox> selectWithCondition(@Param("codegenerCheckbox") CodegenerCheckbox codegenerCheckbox,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<CodegenerCheckbox> selectBySql(@Param("SqlStr") String SqlStr);
}

