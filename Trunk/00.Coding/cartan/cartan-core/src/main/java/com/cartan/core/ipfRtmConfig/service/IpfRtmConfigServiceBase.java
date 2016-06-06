package com.cartan.core.ipfRtmConfig.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfRtmConfig.dao.IpfRtmConfigMapper;
import com.cartan.core.ipfRtmConfig.domain.IpfRtmConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfRtmConfigServiceBase extends BaseService {
    private IpfRtmConfigMapper ipfRtmConfigMapper;
    public IpfRtmConfig getIpfRtmConfig(String id){
        return ipfRtmConfigMapper.getIpfRtmConfig(id);
    }

    public void createIpfRtmConfig(IpfRtmConfig ipfRtmConfig){
    	ipfRtmConfigMapper.createIpfRtmConfig(ipfRtmConfig);
    }

    public void deleteIpfRtmConfig(String id){
    	ipfRtmConfigMapper.deleteIpfRtmConfig(id);
    }

    public void updateIpfRtmConfig(IpfRtmConfig ipfRtmConfig){
    	ipfRtmConfigMapper.updateIpfRtmConfig(ipfRtmConfig);
    }

    public int countAll(){
       return ipfRtmConfigMapper.countAll();
    }

    public ArrayList<IpfRtmConfig> selectAll(){
      return ipfRtmConfigMapper.selectAll();
    }
    
    public IpfRtmConfigMapper getIpfRtmConfigMapper() {
    	if(this.ipfRtmConfigMapper == null){
            this.ipfRtmConfigMapper = this.getSqlSessionTemplate().getMapper(IpfRtmConfigMapper.class);
        }
        return this.ipfRtmConfigMapper;
    }
        
    public void setIpfRtmConfigMapper(IpfRtmConfigMapper ipfRtmConfigMapper) {
        this.ipfRtmConfigMapper = ipfRtmConfigMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfRtmConfigMapper = sqlSessionTemplate.getMapper(IpfRtmConfigMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfRtmConfig
     * @return
     */
    public ArrayList<IpfRtmConfig> selectWithCondition(IpfRtmConfig ipfRtmConfig){
        return  ipfRtmConfigMapper.selectWithCondition(ipfRtmConfig,"");
    }

    /** 按条件查询
     * @param ipfRtmConfig
     * @conditions
     * @return
     */
    public ArrayList<IpfRtmConfig> selectWithCondition(IpfRtmConfig ipfRtmConfig,String conditions){
        return  ipfRtmConfigMapper.selectWithCondition(ipfRtmConfig,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfRtmConfig> selectBySql(String SqlStr){
        return  ipfRtmConfigMapper.selectBySql(SqlStr);
    }
}