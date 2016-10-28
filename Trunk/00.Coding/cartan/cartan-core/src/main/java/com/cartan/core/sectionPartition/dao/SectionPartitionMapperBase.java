package com.cartan.core.sectionPartition.dao;

import com.cartan.core.sectionPartition.domain.SectionPartition;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface SectionPartitionMapperBase {
	@Select("SELECT * FROM cartan_common.T_SECTION_PARTITION s WHERE s.ID = #{id}")
	SectionPartition getSectionPartition(String id);
	
	@Insert("INSERT INTO cartan_common.T_SECTION_PARTITION(ID,SECTION_NAME,STATUS,MODIFY_DATE,MODIFYED,OWNER,LOCKED) VALUES(#{id},#{sectionName},#{status},#{modifyDate},#{modifyed},#{owner},#{locked})")
    void createSectionPartition(SectionPartition sectionPartition);
    
    @Delete("DELETE FROM cartan_common.T_SECTION_PARTITION WHERE ID = #{id}")
    void deleteSectionPartition(String id);

    @Update("update cartan_common.T_SECTION_PARTITION set SECTION_NAME=#{sectionName},STATUS=#{status},MODIFY_DATE=#{modifyDate},MODIFYED=#{modifyed},OWNER=#{owner},LOCKED=#{locked} where ID = #{id}")
    void updateSectionPartition(SectionPartition sectionPartition);

    @Select("select count(*) c from cartan_common.T_SECTION_PARTITION")
    int countAll();
    
    @Select("select * from cartan_common.T_SECTION_PARTITION order by ID asc")
    ArrayList<SectionPartition> selectAll();
    
    @SelectProvider(type = SectionPartitionSqlProvider.class, method = "getSql")
    ArrayList<SectionPartition> selectWithCondition(@Param("sectionPartition") SectionPartition sectionPartition,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<SectionPartition> selectBySql(@Param("SqlStr") String SqlStr);
}

