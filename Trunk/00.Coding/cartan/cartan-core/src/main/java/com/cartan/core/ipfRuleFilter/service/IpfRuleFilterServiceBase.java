package com.cartan.core.ipfRuleFilter.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfRuleFilter.dao.IpfRuleFilterMapper;
import com.cartan.core.ipfRuleFilter.domain.IpfRuleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfRuleFilterServiceBase extends BaseService {
    private IpfRuleFilterMapper ipfRuleFilterMapper;
    public IpfRuleFilter getIpfRuleFilter(String id){
        return ipfRuleFilterMapper.getIpfRuleFilter(id);
    }

    public void createIpfRuleFilter(IpfRuleFilter ipfRuleFilter){
    	ipfRuleFilterMapper.createIpfRuleFilter(ipfRuleFilter);
    }

    public void deleteIpfRuleFilter(String id){
    	ipfRuleFilterMapper.deleteIpfRuleFilter(id);
    }

    public void updateIpfRuleFilter(IpfRuleFilter ipfRuleFilter){
    	ipfRuleFilterMapper.updateIpfRuleFilter(ipfRuleFilter);
    }

    public int countAll(){
       return ipfRuleFilterMapper.countAll();
    }

    public ArrayList<IpfRuleFilter> selectAll(){
      return ipfRuleFilterMapper.selectAll();
    }
    
    public IpfRuleFilterMapper getIpfRuleFilterMapper() {
    	if(this.ipfRuleFilterMapper == null){
            this.ipfRuleFilterMapper = this.getSqlSessionTemplate().getMapper(IpfRuleFilterMapper.class);
        }
        return this.ipfRuleFilterMapper;
    }
        
    public void setIpfRuleFilterMapper(IpfRuleFilterMapper ipfRuleFilterMapper) {
        this.ipfRuleFilterMapper = ipfRuleFilterMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfRuleFilterMapper = sqlSessionTemplate.getMapper(IpfRuleFilterMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfRuleFilter
     * @return
     */
    public ArrayList<IpfRuleFilter> selectWithCondition(IpfRuleFilter ipfRuleFilter){
        return  ipfRuleFilterMapper.selectWithCondition(ipfRuleFilter,"");
    }

    /** 按条件查询
     * @param ipfRuleFilter
     * @conditions
     * @return
     */
    public ArrayList<IpfRuleFilter> selectWithCondition(IpfRuleFilter ipfRuleFilter,String conditions){
        return  ipfRuleFilterMapper.selectWithCondition(ipfRuleFilter,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfRuleFilter> selectBySql(String SqlStr){
        return  ipfRuleFilterMapper.selectBySql(SqlStr);
    }
}