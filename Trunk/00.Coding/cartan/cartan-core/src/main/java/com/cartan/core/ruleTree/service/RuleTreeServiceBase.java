package com.cartan.core.ruleTree.service;

import com.cartan.core.BaseService;
import com.cartan.core.ruleTree.dao.RuleTreeMapper;
import com.cartan.core.ruleTree.domain.RuleTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class RuleTreeServiceBase extends BaseService {
    private RuleTreeMapper ruleTreeMapper;
    public RuleTree getRuleTree(String id){
        return ruleTreeMapper.getRuleTree(id);
    }

    public void createRuleTree(RuleTree ruleTree){
    	ruleTreeMapper.createRuleTree(ruleTree);
    }

    public void deleteRuleTree(String id){
    	ruleTreeMapper.deleteRuleTree(id);
    }

    public void updateRuleTree(RuleTree ruleTree){
    	ruleTreeMapper.updateRuleTree(ruleTree);
    }

    public int countAll(){
       return ruleTreeMapper.countAll();
    }

    public ArrayList<RuleTree> selectAll(){
      return ruleTreeMapper.selectAll();
    }
    
    public RuleTreeMapper getRuleTreeMapper() {
    	if(this.ruleTreeMapper == null){
            this.ruleTreeMapper = this.getSqlSessionTemplate().getMapper(RuleTreeMapper.class);
        }
        return this.ruleTreeMapper;
    }
        
    public void setRuleTreeMapper(RuleTreeMapper ruleTreeMapper) {
        this.ruleTreeMapper = ruleTreeMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ruleTreeMapper = sqlSessionTemplate.getMapper(RuleTreeMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ruleTree
     * @return
     */
    public ArrayList<RuleTree> selectWithCondition(RuleTree ruleTree){
        return  ruleTreeMapper.selectWithCondition(ruleTree,"");
    }

    /** 按条件查询
     * @param ruleTree
     * @conditions
     * @return
     */
    public ArrayList<RuleTree> selectWithCondition(RuleTree ruleTree,String conditions){
        return  ruleTreeMapper.selectWithCondition(ruleTree,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<RuleTree> selectBySql(String SqlStr){
        return  ruleTreeMapper.selectBySql(SqlStr);
    }
}