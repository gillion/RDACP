package com.cartan.core.sectionPartitionVar.service;

import com.cartan.core.BaseService;
import com.cartan.core.sectionPartitionVar.dao.SectionPartitionVarMapper;
import com.cartan.core.sectionPartitionVar.domain.SectionPartitionVar;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class SectionPartitionVarServiceBase extends BaseService {
    private SectionPartitionVarMapper sectionPartitionVarMapper;
    public SectionPartitionVar getSectionPartitionVar(String id){
        return sectionPartitionVarMapper.getSectionPartitionVar(id);
    }

    public void createSectionPartitionVar(SectionPartitionVar sectionPartitionVar){
    	sectionPartitionVarMapper.createSectionPartitionVar(sectionPartitionVar);
    }

    public void deleteSectionPartitionVar(String id){
    	sectionPartitionVarMapper.deleteSectionPartitionVar(id);
    }

    public void updateSectionPartitionVar(SectionPartitionVar sectionPartitionVar){
    	sectionPartitionVarMapper.updateSectionPartitionVar(sectionPartitionVar);
    }

    public int countAll(){
       return sectionPartitionVarMapper.countAll();
    }

    public ArrayList<SectionPartitionVar> selectAll(){
      return sectionPartitionVarMapper.selectAll();
    }
    
    public SectionPartitionVarMapper getSectionPartitionVarMapper() {
    	if(this.sectionPartitionVarMapper == null){
            this.sectionPartitionVarMapper = this.getSqlSessionTemplate().getMapper(SectionPartitionVarMapper.class);
        }
        return this.sectionPartitionVarMapper;
    }
        
    public void setSectionPartitionVarMapper(SectionPartitionVarMapper sectionPartitionVarMapper) {
        this.sectionPartitionVarMapper = sectionPartitionVarMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.sectionPartitionVarMapper = sqlSessionTemplate.getMapper(SectionPartitionVarMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param sectionPartitionVar
     * @return
     */
    public ArrayList<SectionPartitionVar> selectWithCondition(SectionPartitionVar sectionPartitionVar){
        return  sectionPartitionVarMapper.selectWithCondition(sectionPartitionVar,"");
    }

    /** 按条件查询
     * @param sectionPartitionVar
     * @conditions
     * @return
     */
    public ArrayList<SectionPartitionVar> selectWithCondition(SectionPartitionVar sectionPartitionVar,String conditions){
        return  sectionPartitionVarMapper.selectWithCondition(sectionPartitionVar,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<SectionPartitionVar> selectBySql(String SqlStr){
        return  sectionPartitionVarMapper.selectBySql(SqlStr);
    }
}