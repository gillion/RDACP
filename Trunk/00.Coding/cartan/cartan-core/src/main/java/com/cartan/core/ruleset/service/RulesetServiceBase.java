package com.cartan.core.ruleset.service;

import com.cartan.core.BaseService;
import com.cartan.core.ruleset.dao.RulesetMapper;
import com.cartan.core.ruleset.domain.Ruleset;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class RulesetServiceBase extends BaseService {
    private RulesetMapper rulesetMapper;
    public Ruleset getRuleset(String id){
        return rulesetMapper.getRuleset(id);
    }

    public void createRuleset(Ruleset ruleset){
    	rulesetMapper.createRuleset(ruleset);
    }

    public void deleteRuleset(String id){
    	rulesetMapper.deleteRuleset(id);
    }

    public void updateRuleset(Ruleset ruleset){
    	rulesetMapper.updateRuleset(ruleset);
    }

    public int countAll(){
       return rulesetMapper.countAll();
    }

    public ArrayList<Ruleset> selectAll(){
      return rulesetMapper.selectAll();
    }
    
    public RulesetMapper getRulesetMapper() {
    	if(this.rulesetMapper == null){
            this.rulesetMapper = this.getSqlSessionTemplate().getMapper(RulesetMapper.class);
        }
        return this.rulesetMapper;
    }
        
    public void setRulesetMapper(RulesetMapper rulesetMapper) {
        this.rulesetMapper = rulesetMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.rulesetMapper = sqlSessionTemplate.getMapper(RulesetMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ruleset
     * @return
     */
    public ArrayList<Ruleset> selectWithCondition(Ruleset ruleset){
        return  rulesetMapper.selectWithCondition(ruleset,"");
    }

    /** 按条件查询
     * @param ruleset
     * @conditions
     * @return
     */
    public ArrayList<Ruleset> selectWithCondition(Ruleset ruleset,String conditions){
        return  rulesetMapper.selectWithCondition(ruleset,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<Ruleset> selectBySql(String SqlStr){
        return  rulesetMapper.selectBySql(SqlStr);
    }
}