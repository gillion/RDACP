package com.cartan.core.codegenerTable.dao;

import com.cartan.core.codegenerTable.domain.CodegenerTable;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface CodegenerTableMapperBase {
	@Select("SELECT * FROM cartan_common.t_codegener_table s WHERE s.ID = #{id}")
	CodegenerTable getCodegenerTable(String id);
	
	@Insert("INSERT INTO cartan_common.t_codegener_table(ID,SETUP_ID,TABLE_NAME,TABLE_DES,PARENT_TABLE_NAME,NO_PARENT,IS_NEW_BSCLASS,PAGE_SIZE) VALUES(#{id},#{setupId},#{tableName},#{tableDes},#{parentTableName},#{noParent},#{isNewBsclass},#{pageSize})")
    void createCodegenerTable(CodegenerTable codegenerTable);
    
    @Delete("DELETE FROM cartan_common.t_codegener_table WHERE ID = #{id}")
    void deleteCodegenerTable(String id);

    @Update("update cartan_common.t_codegener_table set SETUP_ID=#{setupId},TABLE_NAME=#{tableName},TABLE_DES=#{tableDes},PARENT_TABLE_NAME=#{parentTableName},NO_PARENT=#{noParent},IS_NEW_BSCLASS=#{isNewBsclass},PAGE_SIZE=#{pageSize} where ID = #{id}")
    void updateCodegenerTable(CodegenerTable codegenerTable);

    @Select("select count(*) c from cartan_common.t_codegener_table")
    int countAll();
    
    @Select("select * from cartan_common.t_codegener_table order by ID asc")
    ArrayList<CodegenerTable> selectAll();
    
    @SelectProvider(type = CodegenerTableSqlProvider.class, method = "getSql")
    ArrayList<CodegenerTable> selectWithCondition(@Param("codegenerTable") CodegenerTable codegenerTable,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<CodegenerTable> selectBySql(@Param("SqlStr") String SqlStr);
}

