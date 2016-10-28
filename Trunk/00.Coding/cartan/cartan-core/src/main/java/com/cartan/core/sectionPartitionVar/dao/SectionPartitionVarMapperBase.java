package com.cartan.core.sectionPartitionVar.dao;

import com.cartan.core.sectionPartitionVar.domain.SectionPartitionVar;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface SectionPartitionVarMapperBase {
	@Select("SELECT * FROM cartan_common.T_SECTION_PARTITION_VAR s WHERE s.ID = #{id}")
	SectionPartitionVar getSectionPartitionVar(String id);
	
	@Insert("INSERT INTO cartan_common.T_SECTION_PARTITION_VAR(ID,SECTION_PARITION_ID,VAR_NAME,SECTION_LOWER_MARK,SECTION_LOWER_LIMIT,SECTION_UPPER_MARK,SECTION_UPPER_LIMIT) VALUES(#{id},#{sectionParitionId},#{varName},#{sectionLowerMark},#{sectionLowerLimit},#{sectionUpperMark},#{sectionUpperLimit})")
    void createSectionPartitionVar(SectionPartitionVar sectionPartitionVar);
    
    @Delete("DELETE FROM cartan_common.T_SECTION_PARTITION_VAR WHERE ID = #{id}")
    void deleteSectionPartitionVar(String id);

    @Update("update cartan_common.T_SECTION_PARTITION_VAR set SECTION_PARITION_ID=#{sectionParitionId},VAR_NAME=#{varName},SECTION_LOWER_MARK=#{sectionLowerMark},SECTION_LOWER_LIMIT=#{sectionLowerLimit},SECTION_UPPER_MARK=#{sectionUpperMark},SECTION_UPPER_LIMIT=#{sectionUpperLimit} where ID = #{id}")
    void updateSectionPartitionVar(SectionPartitionVar sectionPartitionVar);

    @Select("select count(*) c from cartan_common.T_SECTION_PARTITION_VAR")
    int countAll();
    
    @Select("select * from cartan_common.T_SECTION_PARTITION_VAR order by ID asc")
    ArrayList<SectionPartitionVar> selectAll();
    
    @SelectProvider(type = SectionPartitionVarSqlProvider.class, method = "getSql")
    ArrayList<SectionPartitionVar> selectWithCondition(@Param("sectionPartitionVar") SectionPartitionVar sectionPartitionVar,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<SectionPartitionVar> selectBySql(@Param("SqlStr") String SqlStr);
}

