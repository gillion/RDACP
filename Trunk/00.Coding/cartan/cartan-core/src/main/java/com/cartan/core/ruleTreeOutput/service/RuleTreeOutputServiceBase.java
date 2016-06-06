package com.cartan.core.ruleTreeOutput.service;

import com.cartan.core.BaseService;
import com.cartan.core.ruleTreeOutput.dao.RuleTreeOutputMapper;
import com.cartan.core.ruleTreeOutput.domain.RuleTreeOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class RuleTreeOutputServiceBase extends BaseService {
    private RuleTreeOutputMapper ruleTreeOutputMapper;
    public RuleTreeOutput getRuleTreeOutput(String id){
        return ruleTreeOutputMapper.getRuleTreeOutput(id);
    }

    public void createRuleTreeOutput(RuleTreeOutput ruleTreeOutput){
    	ruleTreeOutputMapper.createRuleTreeOutput(ruleTreeOutput);
    }

    public void deleteRuleTreeOutput(String id){
    	ruleTreeOutputMapper.deleteRuleTreeOutput(id);
    }

    public void updateRuleTreeOutput(RuleTreeOutput ruleTreeOutput){
    	ruleTreeOutputMapper.updateRuleTreeOutput(ruleTreeOutput);
    }

    public int countAll(){
       return ruleTreeOutputMapper.countAll();
    }

    public ArrayList<RuleTreeOutput> selectAll(){
      return ruleTreeOutputMapper.selectAll();
    }
    
    public RuleTreeOutputMapper getRuleTreeOutputMapper() {
    	if(this.ruleTreeOutputMapper == null){
            this.ruleTreeOutputMapper = this.getSqlSessionTemplate().getMapper(RuleTreeOutputMapper.class);
        }
        return this.ruleTreeOutputMapper;
    }
        
    public void setRuleTreeOutputMapper(RuleTreeOutputMapper ruleTreeOutputMapper) {
        this.ruleTreeOutputMapper = ruleTreeOutputMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ruleTreeOutputMapper = sqlSessionTemplate.getMapper(RuleTreeOutputMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ruleTreeOutput
     * @return
     */
    public ArrayList<RuleTreeOutput> selectWithCondition(RuleTreeOutput ruleTreeOutput){
        return  ruleTreeOutputMapper.selectWithCondition(ruleTreeOutput,"");
    }

    /** 按条件查询
     * @param ruleTreeOutput
     * @conditions
     * @return
     */
    public ArrayList<RuleTreeOutput> selectWithCondition(RuleTreeOutput ruleTreeOutput,String conditions){
        return  ruleTreeOutputMapper.selectWithCondition(ruleTreeOutput,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<RuleTreeOutput> selectBySql(String SqlStr){
        return  ruleTreeOutputMapper.selectBySql(SqlStr);
    }
}