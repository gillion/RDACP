package com.cartan.core.ipfCcmEnvironment.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmEnvironment.dao.IpfCcmEnvironmentMapper;
import com.cartan.core.ipfCcmEnvironment.domain.IpfCcmEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmEnvironmentServiceBase extends BaseService {
    private IpfCcmEnvironmentMapper ipfCcmEnvironmentMapper;
    public IpfCcmEnvironment getIpfCcmEnvironment(String id){
        return ipfCcmEnvironmentMapper.getIpfCcmEnvironment(id);
    }

    public void createIpfCcmEnvironment(IpfCcmEnvironment ipfCcmEnvironment){
    	ipfCcmEnvironmentMapper.createIpfCcmEnvironment(ipfCcmEnvironment);
    }

    public void deleteIpfCcmEnvironment(String id){
    	ipfCcmEnvironmentMapper.deleteIpfCcmEnvironment(id);
    }

    public void updateIpfCcmEnvironment(IpfCcmEnvironment ipfCcmEnvironment){
    	ipfCcmEnvironmentMapper.updateIpfCcmEnvironment(ipfCcmEnvironment);
    }

    public int countAll(){
       return ipfCcmEnvironmentMapper.countAll();
    }

    public ArrayList<IpfCcmEnvironment> selectAll(){
      return ipfCcmEnvironmentMapper.selectAll();
    }
    
    public IpfCcmEnvironmentMapper getIpfCcmEnvironmentMapper() {
    	if(this.ipfCcmEnvironmentMapper == null){
            this.ipfCcmEnvironmentMapper = this.getSqlSessionTemplate().getMapper(IpfCcmEnvironmentMapper.class);
        }
        return this.ipfCcmEnvironmentMapper;
    }
        
    public void setIpfCcmEnvironmentMapper(IpfCcmEnvironmentMapper ipfCcmEnvironmentMapper) {
        this.ipfCcmEnvironmentMapper = ipfCcmEnvironmentMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmEnvironmentMapper = sqlSessionTemplate.getMapper(IpfCcmEnvironmentMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmEnvironment
     * @return
     */
    public ArrayList<IpfCcmEnvironment> selectWithCondition(IpfCcmEnvironment ipfCcmEnvironment){
        return  ipfCcmEnvironmentMapper.selectWithCondition(ipfCcmEnvironment,"");
    }

    /** 按条件查询
     * @param ipfCcmEnvironment
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmEnvironment> selectWithCondition(IpfCcmEnvironment ipfCcmEnvironment,String conditions){
        return  ipfCcmEnvironmentMapper.selectWithCondition(ipfCcmEnvironment,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmEnvironment> selectBySql(String SqlStr){
        return  ipfCcmEnvironmentMapper.selectBySql(SqlStr);
    }
}