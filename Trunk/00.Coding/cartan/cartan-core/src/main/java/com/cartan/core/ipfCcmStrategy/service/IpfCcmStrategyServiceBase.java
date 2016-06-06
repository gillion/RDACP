package com.cartan.core.ipfCcmStrategy.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmStrategy.dao.IpfCcmStrategyMapper;
import com.cartan.core.ipfCcmStrategy.domain.IpfCcmStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmStrategyServiceBase extends BaseService {
    private IpfCcmStrategyMapper ipfCcmStrategyMapper;
    public IpfCcmStrategy getIpfCcmStrategy(String id){
        return ipfCcmStrategyMapper.getIpfCcmStrategy(id);
    }

    public void createIpfCcmStrategy(IpfCcmStrategy ipfCcmStrategy){
    	ipfCcmStrategyMapper.createIpfCcmStrategy(ipfCcmStrategy);
    }

    public void deleteIpfCcmStrategy(String id){
    	ipfCcmStrategyMapper.deleteIpfCcmStrategy(id);
    }

    public void updateIpfCcmStrategy(IpfCcmStrategy ipfCcmStrategy){
    	ipfCcmStrategyMapper.updateIpfCcmStrategy(ipfCcmStrategy);
    }

    public int countAll(){
       return ipfCcmStrategyMapper.countAll();
    }

    public ArrayList<IpfCcmStrategy> selectAll(){
      return ipfCcmStrategyMapper.selectAll();
    }
    
    public IpfCcmStrategyMapper getIpfCcmStrategyMapper() {
    	if(this.ipfCcmStrategyMapper == null){
            this.ipfCcmStrategyMapper = this.getSqlSessionTemplate().getMapper(IpfCcmStrategyMapper.class);
        }
        return this.ipfCcmStrategyMapper;
    }
        
    public void setIpfCcmStrategyMapper(IpfCcmStrategyMapper ipfCcmStrategyMapper) {
        this.ipfCcmStrategyMapper = ipfCcmStrategyMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmStrategyMapper = sqlSessionTemplate.getMapper(IpfCcmStrategyMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmStrategy
     * @return
     */
    public ArrayList<IpfCcmStrategy> selectWithCondition(IpfCcmStrategy ipfCcmStrategy){
        return  ipfCcmStrategyMapper.selectWithCondition(ipfCcmStrategy,"");
    }

    /** 按条件查询
     * @param ipfCcmStrategy
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmStrategy> selectWithCondition(IpfCcmStrategy ipfCcmStrategy,String conditions){
        return  ipfCcmStrategyMapper.selectWithCondition(ipfCcmStrategy,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmStrategy> selectBySql(String SqlStr){
        return  ipfCcmStrategyMapper.selectBySql(SqlStr);
    }
}