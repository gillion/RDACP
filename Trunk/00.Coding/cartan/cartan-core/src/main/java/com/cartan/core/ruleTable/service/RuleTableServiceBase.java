package com.cartan.core.ruleTable.service;

import com.cartan.core.BaseService;
import com.cartan.core.ruleTable.dao.RuleTableMapper;
import com.cartan.core.ruleTable.domain.RuleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class RuleTableServiceBase extends BaseService {
    private RuleTableMapper ruleTableMapper;
    public RuleTable getRuleTable(String id){
        return ruleTableMapper.getRuleTable(id);
    }

    public void createRuleTable(RuleTable ruleTable){
    	ruleTableMapper.createRuleTable(ruleTable);
    }

    public void deleteRuleTable(String id){
    	ruleTableMapper.deleteRuleTable(id);
    }

    public void updateRuleTable(RuleTable ruleTable){
    	ruleTableMapper.updateRuleTable(ruleTable);
    }

    public int countAll(){
       return ruleTableMapper.countAll();
    }

    public ArrayList<RuleTable> selectAll(){
      return ruleTableMapper.selectAll();
    }
    
    public RuleTableMapper getRuleTableMapper() {
    	if(this.ruleTableMapper == null){
            this.ruleTableMapper = this.getSqlSessionTemplate().getMapper(RuleTableMapper.class);
        }
        return this.ruleTableMapper;
    }
        
    public void setRuleTableMapper(RuleTableMapper ruleTableMapper) {
        this.ruleTableMapper = ruleTableMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ruleTableMapper = sqlSessionTemplate.getMapper(RuleTableMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ruleTable
     * @return
     */
    public ArrayList<RuleTable> selectWithCondition(RuleTable ruleTable){
        return  ruleTableMapper.selectWithCondition(ruleTable,"");
    }

    /** 按条件查询
     * @param ruleTable
     * @conditions
     * @return
     */
    public ArrayList<RuleTable> selectWithCondition(RuleTable ruleTable,String conditions){
        return  ruleTableMapper.selectWithCondition(ruleTable,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<RuleTable> selectBySql(String SqlStr){
        return  ruleTableMapper.selectBySql(SqlStr);
    }
}