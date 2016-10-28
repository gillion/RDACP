package com.cartan.core.codegenerCombobox.dao;

import com.cartan.core.codegenerCombobox.domain.CodegenerCombobox;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface CodegenerComboboxMapperBase {
	@Select("SELECT * FROM cartan_common.t_codegener_combobox s WHERE s.ID = #{id}")
	CodegenerCombobox getCodegenerCombobox(String id);
	
	@Insert("INSERT INTO cartan_common.t_codegener_combobox(ID,SETUP_ID,TABLE_ID,COMBOBOX_FIELD,CODE_TYPE) VALUES(#{id},#{setupId},#{tableId},#{comboboxField},#{codeType})")
    void createCodegenerCombobox(CodegenerCombobox codegenerCombobox);
    
    @Delete("DELETE FROM cartan_common.t_codegener_combobox WHERE ID = #{id}")
    void deleteCodegenerCombobox(String id);

    @Update("update cartan_common.t_codegener_combobox set SETUP_ID=#{setupId},TABLE_ID=#{tableId},COMBOBOX_FIELD=#{comboboxField},CODE_TYPE=#{codeType} where ID = #{id}")
    void updateCodegenerCombobox(CodegenerCombobox codegenerCombobox);

    @Select("select count(*) c from cartan_common.t_codegener_combobox")
    int countAll();
    
    @Select("select * from cartan_common.t_codegener_combobox order by ID asc")
    ArrayList<CodegenerCombobox> selectAll();
    
    @SelectProvider(type = CodegenerComboboxSqlProvider.class, method = "getSql")
    ArrayList<CodegenerCombobox> selectWithCondition(@Param("codegenerCombobox") CodegenerCombobox codegenerCombobox,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<CodegenerCombobox> selectBySql(@Param("SqlStr") String SqlStr);
}

