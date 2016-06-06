package com.cartan.core.rule.service;

import com.cartan.core.BaseService;
import com.cartan.core.rule.dao.RuleMapper;
import com.cartan.core.rule.domain.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class RuleServiceBase extends BaseService {
    private RuleMapper ruleMapper;
    public Rule getRule(String id){
        return ruleMapper.getRule(id);
    }

    public void createRule(Rule rule){
    	ruleMapper.createRule(rule);
    }

    public void deleteRule(String id){
    	ruleMapper.deleteRule(id);
    }

    public void updateRule(Rule rule){
    	ruleMapper.updateRule(rule);
    }

    public int countAll(){
       return ruleMapper.countAll();
    }

    public ArrayList<Rule> selectAll(){
      return ruleMapper.selectAll();
    }
    
    public RuleMapper getRuleMapper() {
    	if(this.ruleMapper == null){
            this.ruleMapper = this.getSqlSessionTemplate().getMapper(RuleMapper.class);
        }
        return this.ruleMapper;
    }
        
    public void setRuleMapper(RuleMapper ruleMapper) {
        this.ruleMapper = ruleMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ruleMapper = sqlSessionTemplate.getMapper(RuleMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param rule
     * @return
     */
    public ArrayList<Rule> selectWithCondition(Rule rule){
        return  ruleMapper.selectWithCondition(rule,"");
    }

    /** 按条件查询
     * @param rule
     * @conditions
     * @return
     */
    public ArrayList<Rule> selectWithCondition(Rule rule,String conditions){
        return  ruleMapper.selectWithCondition(rule,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<Rule> selectBySql(String SqlStr){
        return  ruleMapper.selectBySql(SqlStr);
    }
}