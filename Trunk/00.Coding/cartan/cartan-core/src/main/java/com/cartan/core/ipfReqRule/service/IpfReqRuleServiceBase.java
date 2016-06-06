package com.cartan.core.ipfReqRule.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfReqRule.dao.IpfReqRuleMapper;
import com.cartan.core.ipfReqRule.domain.IpfReqRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfReqRuleServiceBase extends BaseService {
    private IpfReqRuleMapper ipfReqRuleMapper;
    public IpfReqRule getIpfReqRule(String id){
        return ipfReqRuleMapper.getIpfReqRule(id);
    }

    public void createIpfReqRule(IpfReqRule ipfReqRule){
    	ipfReqRuleMapper.createIpfReqRule(ipfReqRule);
    }

    public void deleteIpfReqRule(String id){
    	ipfReqRuleMapper.deleteIpfReqRule(id);
    }

    public void updateIpfReqRule(IpfReqRule ipfReqRule){
    	ipfReqRuleMapper.updateIpfReqRule(ipfReqRule);
    }

    public int countAll(){
       return ipfReqRuleMapper.countAll();
    }

    public ArrayList<IpfReqRule> selectAll(){
      return ipfReqRuleMapper.selectAll();
    }
    
    public IpfReqRuleMapper getIpfReqRuleMapper() {
    	if(this.ipfReqRuleMapper == null){
            this.ipfReqRuleMapper = this.getSqlSessionTemplate().getMapper(IpfReqRuleMapper.class);
        }
        return this.ipfReqRuleMapper;
    }
        
    public void setIpfReqRuleMapper(IpfReqRuleMapper ipfReqRuleMapper) {
        this.ipfReqRuleMapper = ipfReqRuleMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfReqRuleMapper = sqlSessionTemplate.getMapper(IpfReqRuleMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfReqRule
     * @return
     */
    public ArrayList<IpfReqRule> selectWithCondition(IpfReqRule ipfReqRule){
        return  ipfReqRuleMapper.selectWithCondition(ipfReqRule,"");
    }

    /** 按条件查询
     * @param ipfReqRule
     * @conditions
     * @return
     */
    public ArrayList<IpfReqRule> selectWithCondition(IpfReqRule ipfReqRule,String conditions){
        return  ipfReqRuleMapper.selectWithCondition(ipfReqRule,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfReqRule> selectBySql(String SqlStr){
        return  ipfReqRuleMapper.selectBySql(SqlStr);
    }
}