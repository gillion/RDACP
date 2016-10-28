package com.cartan.core.conditionPartitionNode.service;

import com.cartan.core.BaseService;
import com.cartan.core.conditionPartitionNode.dao.ConditionPartitionNodeMapper;
import com.cartan.core.conditionPartitionNode.domain.ConditionPartitionNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class ConditionPartitionNodeServiceBase extends BaseService {
    private ConditionPartitionNodeMapper conditionPartitionNodeMapper;
    public ConditionPartitionNode getConditionPartitionNode(String id){
        return conditionPartitionNodeMapper.getConditionPartitionNode(id);
    }

    public void createConditionPartitionNode(ConditionPartitionNode conditionPartitionNode){
    	conditionPartitionNodeMapper.createConditionPartitionNode(conditionPartitionNode);
    }

    public void deleteConditionPartitionNode(String id){
    	conditionPartitionNodeMapper.deleteConditionPartitionNode(id);
    }

    public void updateConditionPartitionNode(ConditionPartitionNode conditionPartitionNode){
    	conditionPartitionNodeMapper.updateConditionPartitionNode(conditionPartitionNode);
    }

    public int countAll(){
       return conditionPartitionNodeMapper.countAll();
    }

    public ArrayList<ConditionPartitionNode> selectAll(){
      return conditionPartitionNodeMapper.selectAll();
    }
    
    public ConditionPartitionNodeMapper getConditionPartitionNodeMapper() {
    	if(this.conditionPartitionNodeMapper == null){
            this.conditionPartitionNodeMapper = this.getSqlSessionTemplate().getMapper(ConditionPartitionNodeMapper.class);
        }
        return this.conditionPartitionNodeMapper;
    }
        
    public void setConditionPartitionNodeMapper(ConditionPartitionNodeMapper conditionPartitionNodeMapper) {
        this.conditionPartitionNodeMapper = conditionPartitionNodeMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.conditionPartitionNodeMapper = sqlSessionTemplate.getMapper(ConditionPartitionNodeMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param conditionPartitionNode
     * @return
     */
    public ArrayList<ConditionPartitionNode> selectWithCondition(ConditionPartitionNode conditionPartitionNode){
        return  conditionPartitionNodeMapper.selectWithCondition(conditionPartitionNode,"");
    }

    /** 按条件查询
     * @param conditionPartitionNode
     * @conditions
     * @return
     */
    public ArrayList<ConditionPartitionNode> selectWithCondition(ConditionPartitionNode conditionPartitionNode,String conditions){
        return  conditionPartitionNodeMapper.selectWithCondition(conditionPartitionNode,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<ConditionPartitionNode> selectBySql(String SqlStr){
        return  conditionPartitionNodeMapper.selectBySql(SqlStr);
    }
}