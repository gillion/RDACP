package com.cartan.core.datasetVar.dao;

import com.cartan.core.datasetVar.domain.DatasetVar;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface DatasetVarMapperBase {
	@Select("SELECT * FROM cartan_common.T_DATASET_VAR s WHERE s.ID = #{id}")
	DatasetVar getDatasetVar(String id);
	
	@Insert("INSERT INTO cartan_common.T_DATASET_VAR(ID,DATASET_ID,VAR_NAME,VAR_DES,IS_DERIVED,IS_SET,VAR_TYPE,SPAN_BEGIN,SPAN_END,IS_OUTPUT,DEF_VALUE,REMARK) VALUES(#{id},#{datasetId},#{varName},#{varDes},#{isDerived},#{isSet},#{varType},#{spanBegin},#{spanEnd},#{isOutput},#{defValue},#{remark})")
    void createDatasetVar(DatasetVar datasetVar);
    
    @Delete("DELETE FROM cartan_common.T_DATASET_VAR WHERE ID = #{id}")
    void deleteDatasetVar(String id);

    @Update("update cartan_common.T_DATASET_VAR set DATASET_ID=#{datasetId},VAR_NAME=#{varName},VAR_DES=#{varDes},IS_DERIVED=#{isDerived},IS_SET=#{isSet},VAR_TYPE=#{varType},SPAN_BEGIN=#{spanBegin},SPAN_END=#{spanEnd},IS_OUTPUT=#{isOutput},DEF_VALUE=#{defValue},REMARK=#{remark} where ID = #{id}")
    void updateDatasetVar(DatasetVar datasetVar);

    @Select("select count(*) c from cartan_common.T_DATASET_VAR")
    int countAll();
    
    @Select("select * from cartan_common.T_DATASET_VAR order by ID asc")
    ArrayList<DatasetVar> selectAll();
    
    @SelectProvider(type = DatasetVarSqlProvider.class, method = "getSql")
    ArrayList<DatasetVar> selectWithCondition(@Param("datasetVar") DatasetVar datasetVar,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<DatasetVar> selectBySql(@Param("SqlStr") String SqlStr);
}

