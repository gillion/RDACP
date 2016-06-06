package com.cartan.core.ruleTableOutput.service;

import com.cartan.core.BaseService;
import com.cartan.core.ruleTableOutput.dao.RuleTableOutputMapper;
import com.cartan.core.ruleTableOutput.domain.RuleTableOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class RuleTableOutputServiceBase extends BaseService {
    private RuleTableOutputMapper ruleTableOutputMapper;
    public RuleTableOutput getRuleTableOutput(String id){
        return ruleTableOutputMapper.getRuleTableOutput(id);
    }

    public void createRuleTableOutput(RuleTableOutput ruleTableOutput){
    	ruleTableOutputMapper.createRuleTableOutput(ruleTableOutput);
    }

    public void deleteRuleTableOutput(String id){
    	ruleTableOutputMapper.deleteRuleTableOutput(id);
    }

    public void updateRuleTableOutput(RuleTableOutput ruleTableOutput){
    	ruleTableOutputMapper.updateRuleTableOutput(ruleTableOutput);
    }

    public int countAll(){
       return ruleTableOutputMapper.countAll();
    }

    public ArrayList<RuleTableOutput> selectAll(){
      return ruleTableOutputMapper.selectAll();
    }
    
    public RuleTableOutputMapper getRuleTableOutputMapper() {
    	if(this.ruleTableOutputMapper == null){
            this.ruleTableOutputMapper = this.getSqlSessionTemplate().getMapper(RuleTableOutputMapper.class);
        }
        return this.ruleTableOutputMapper;
    }
        
    public void setRuleTableOutputMapper(RuleTableOutputMapper ruleTableOutputMapper) {
        this.ruleTableOutputMapper = ruleTableOutputMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ruleTableOutputMapper = sqlSessionTemplate.getMapper(RuleTableOutputMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ruleTableOutput
     * @return
     */
    public ArrayList<RuleTableOutput> selectWithCondition(RuleTableOutput ruleTableOutput){
        return  ruleTableOutputMapper.selectWithCondition(ruleTableOutput,"");
    }

    /** 按条件查询
     * @param ruleTableOutput
     * @conditions
     * @return
     */
    public ArrayList<RuleTableOutput> selectWithCondition(RuleTableOutput ruleTableOutput,String conditions){
        return  ruleTableOutputMapper.selectWithCondition(ruleTableOutput,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<RuleTableOutput> selectBySql(String SqlStr){
        return  ruleTableOutputMapper.selectBySql(SqlStr);
    }
}