package com.cartan.core.sectionPartition.service;

import com.cartan.core.BaseService;
import com.cartan.core.sectionPartition.dao.SectionPartitionMapper;
import com.cartan.core.sectionPartition.domain.SectionPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class SectionPartitionServiceBase extends BaseService {
    private SectionPartitionMapper sectionPartitionMapper;
    public SectionPartition getSectionPartition(String id){
        return sectionPartitionMapper.getSectionPartition(id);
    }

    public void createSectionPartition(SectionPartition sectionPartition){
    	sectionPartitionMapper.createSectionPartition(sectionPartition);
    }

    public void deleteSectionPartition(String id){
    	sectionPartitionMapper.deleteSectionPartition(id);
    }

    public void updateSectionPartition(SectionPartition sectionPartition){
    	sectionPartitionMapper.updateSectionPartition(sectionPartition);
    }

    public int countAll(){
       return sectionPartitionMapper.countAll();
    }

    public ArrayList<SectionPartition> selectAll(){
      return sectionPartitionMapper.selectAll();
    }
    
    public SectionPartitionMapper getSectionPartitionMapper() {
    	if(this.sectionPartitionMapper == null){
            this.sectionPartitionMapper = this.getSqlSessionTemplate().getMapper(SectionPartitionMapper.class);
        }
        return this.sectionPartitionMapper;
    }
        
    public void setSectionPartitionMapper(SectionPartitionMapper sectionPartitionMapper) {
        this.sectionPartitionMapper = sectionPartitionMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.sectionPartitionMapper = sqlSessionTemplate.getMapper(SectionPartitionMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param sectionPartition
     * @return
     */
    public ArrayList<SectionPartition> selectWithCondition(SectionPartition sectionPartition){
        return  sectionPartitionMapper.selectWithCondition(sectionPartition,"");
    }

    /** 按条件查询
     * @param sectionPartition
     * @conditions
     * @return
     */
    public ArrayList<SectionPartition> selectWithCondition(SectionPartition sectionPartition,String conditions){
        return  sectionPartitionMapper.selectWithCondition(sectionPartition,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<SectionPartition> selectBySql(String SqlStr){
        return  sectionPartitionMapper.selectBySql(SqlStr);
    }
}