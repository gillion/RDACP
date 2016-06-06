package com.cartan.core.ruleTableInput.service;

import com.cartan.core.BaseService;
import com.cartan.core.ruleTableInput.dao.RuleTableInputMapper;
import com.cartan.core.ruleTableInput.domain.RuleTableInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class RuleTableInputServiceBase extends BaseService {
    private RuleTableInputMapper ruleTableInputMapper;
    public RuleTableInput getRuleTableInput(String id){
        return ruleTableInputMapper.getRuleTableInput(id);
    }

    public void createRuleTableInput(RuleTableInput ruleTableInput){
    	ruleTableInputMapper.createRuleTableInput(ruleTableInput);
    }

    public void deleteRuleTableInput(String id){
    	ruleTableInputMapper.deleteRuleTableInput(id);
    }

    public void updateRuleTableInput(RuleTableInput ruleTableInput){
    	ruleTableInputMapper.updateRuleTableInput(ruleTableInput);
    }

    public int countAll(){
       return ruleTableInputMapper.countAll();
    }

    public ArrayList<RuleTableInput> selectAll(){
      return ruleTableInputMapper.selectAll();
    }
    
    public RuleTableInputMapper getRuleTableInputMapper() {
    	if(this.ruleTableInputMapper == null){
            this.ruleTableInputMapper = this.getSqlSessionTemplate().getMapper(RuleTableInputMapper.class);
        }
        return this.ruleTableInputMapper;
    }
        
    public void setRuleTableInputMapper(RuleTableInputMapper ruleTableInputMapper) {
        this.ruleTableInputMapper = ruleTableInputMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ruleTableInputMapper = sqlSessionTemplate.getMapper(RuleTableInputMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ruleTableInput
     * @return
     */
    public ArrayList<RuleTableInput> selectWithCondition(RuleTableInput ruleTableInput){
        return  ruleTableInputMapper.selectWithCondition(ruleTableInput,"");
    }

    /** 按条件查询
     * @param ruleTableInput
     * @conditions
     * @return
     */
    public ArrayList<RuleTableInput> selectWithCondition(RuleTableInput ruleTableInput,String conditions){
        return  ruleTableInputMapper.selectWithCondition(ruleTableInput,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<RuleTableInput> selectBySql(String SqlStr){
        return  ruleTableInputMapper.selectBySql(SqlStr);
    }
}