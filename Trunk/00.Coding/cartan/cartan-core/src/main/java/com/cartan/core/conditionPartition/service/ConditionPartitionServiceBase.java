package com.cartan.core.conditionPartition.service;

import com.cartan.core.BaseService;
import com.cartan.core.conditionPartition.dao.ConditionPartitionMapper;
import com.cartan.core.conditionPartition.domain.ConditionPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class ConditionPartitionServiceBase extends BaseService {
    private ConditionPartitionMapper conditionPartitionMapper;
    public ConditionPartition getConditionPartition(String id){
        return conditionPartitionMapper.getConditionPartition(id);
    }

    public void createConditionPartition(ConditionPartition conditionPartition){
    	conditionPartitionMapper.createConditionPartition(conditionPartition);
    }

    public void deleteConditionPartition(String id){
    	conditionPartitionMapper.deleteConditionPartition(id);
    }

    public void updateConditionPartition(ConditionPartition conditionPartition){
    	conditionPartitionMapper.updateConditionPartition(conditionPartition);
    }

    public int countAll(){
       return conditionPartitionMapper.countAll();
    }

    public ArrayList<ConditionPartition> selectAll(){
      return conditionPartitionMapper.selectAll();
    }
    
    public ConditionPartitionMapper getConditionPartitionMapper() {
    	if(this.conditionPartitionMapper == null){
            this.conditionPartitionMapper = this.getSqlSessionTemplate().getMapper(ConditionPartitionMapper.class);
        }
        return this.conditionPartitionMapper;
    }
        
    public void setConditionPartitionMapper(ConditionPartitionMapper conditionPartitionMapper) {
        this.conditionPartitionMapper = conditionPartitionMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.conditionPartitionMapper = sqlSessionTemplate.getMapper(ConditionPartitionMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param conditionPartition
     * @return
     */
    public ArrayList<ConditionPartition> selectWithCondition(ConditionPartition conditionPartition){
        return  conditionPartitionMapper.selectWithCondition(conditionPartition,"");
    }

    /** 按条件查询
     * @param conditionPartition
     * @conditions
     * @return
     */
    public ArrayList<ConditionPartition> selectWithCondition(ConditionPartition conditionPartition,String conditions){
        return  conditionPartitionMapper.selectWithCondition(conditionPartition,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<ConditionPartition> selectBySql(String SqlStr){
        return  conditionPartitionMapper.selectBySql(SqlStr);
    }
}