package com.cartan.core.ipfCcmBoMethodRule.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoMethodRule.dao.IpfCcmBoMethodRuleMapper;
import com.cartan.core.ipfCcmBoMethodRule.domain.IpfCcmBoMethodRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoMethodRuleServiceBase extends BaseService {
    private IpfCcmBoMethodRuleMapper ipfCcmBoMethodRuleMapper;
    public IpfCcmBoMethodRule getIpfCcmBoMethodRule(String id){
        return ipfCcmBoMethodRuleMapper.getIpfCcmBoMethodRule(id);
    }

    public void createIpfCcmBoMethodRule(IpfCcmBoMethodRule ipfCcmBoMethodRule){
    	ipfCcmBoMethodRuleMapper.createIpfCcmBoMethodRule(ipfCcmBoMethodRule);
    }

    public void deleteIpfCcmBoMethodRule(String id){
    	ipfCcmBoMethodRuleMapper.deleteIpfCcmBoMethodRule(id);
    }

    public void updateIpfCcmBoMethodRule(IpfCcmBoMethodRule ipfCcmBoMethodRule){
    	ipfCcmBoMethodRuleMapper.updateIpfCcmBoMethodRule(ipfCcmBoMethodRule);
    }

    public int countAll(){
       return ipfCcmBoMethodRuleMapper.countAll();
    }

    public ArrayList<IpfCcmBoMethodRule> selectAll(){
      return ipfCcmBoMethodRuleMapper.selectAll();
    }
    
    public IpfCcmBoMethodRuleMapper getIpfCcmBoMethodRuleMapper() {
    	if(this.ipfCcmBoMethodRuleMapper == null){
            this.ipfCcmBoMethodRuleMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoMethodRuleMapper.class);
        }
        return this.ipfCcmBoMethodRuleMapper;
    }
        
    public void setIpfCcmBoMethodRuleMapper(IpfCcmBoMethodRuleMapper ipfCcmBoMethodRuleMapper) {
        this.ipfCcmBoMethodRuleMapper = ipfCcmBoMethodRuleMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoMethodRuleMapper = sqlSessionTemplate.getMapper(IpfCcmBoMethodRuleMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoMethodRule
     * @return
     */
    public ArrayList<IpfCcmBoMethodRule> selectWithCondition(IpfCcmBoMethodRule ipfCcmBoMethodRule){
        return  ipfCcmBoMethodRuleMapper.selectWithCondition(ipfCcmBoMethodRule,"");
    }

    /** 按条件查询
     * @param ipfCcmBoMethodRule
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoMethodRule> selectWithCondition(IpfCcmBoMethodRule ipfCcmBoMethodRule,String conditions){
        return  ipfCcmBoMethodRuleMapper.selectWithCondition(ipfCcmBoMethodRule,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoMethodRule> selectBySql(String SqlStr){
        return  ipfCcmBoMethodRuleMapper.selectBySql(SqlStr);
    }
}