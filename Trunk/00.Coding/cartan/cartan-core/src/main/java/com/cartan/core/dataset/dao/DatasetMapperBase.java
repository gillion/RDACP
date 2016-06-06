package com.cartan.core.dataset.dao;

import com.cartan.core.dataset.domain.Dataset;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface DatasetMapperBase {
	@Select("SELECT * FROM cartan_common.T_DATASET s WHERE s.ID = #{id}")
	Dataset getDataset(String id);
	
	@Insert("INSERT INTO cartan_common.T_DATASET(ID,DATASET_NAME,DATASET_DES,DATASET_TYPE,REMARK) VALUES(#{id},#{datasetName},#{datasetDes},#{datasetType},#{remark})")
    void createDataset(Dataset dataset);
    
    @Delete("DELETE FROM cartan_common.T_DATASET WHERE ID = #{id}")
    void deleteDataset(String id);

    @Update("update cartan_common.T_DATASET set DATASET_NAME=#{datasetName},DATASET_DES=#{datasetDes},DATASET_TYPE=#{datasetType},REMARK=#{remark} where ID = #{id}")
    void updateDataset(Dataset dataset);

    @Select("select count(*) c from cartan_common.T_DATASET")
    int countAll();
    
    @Select("select * from cartan_common.T_DATASET order by ID asc")
    ArrayList<Dataset> selectAll();
    
    @SelectProvider(type = DatasetSqlProvider.class, method = "getSql")
    ArrayList<Dataset> selectWithCondition(@Param("dataset") Dataset dataset,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<Dataset> selectBySql(@Param("SqlStr") String SqlStr);
}

