package com.cartan.core.ipfCcmUiLayoutConfig.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmUiLayoutConfig.dao.IpfCcmUiLayoutConfigMapper;
import com.cartan.core.ipfCcmUiLayoutConfig.domain.IpfCcmUiLayoutConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmUiLayoutConfigServiceBase extends BaseService {
    private IpfCcmUiLayoutConfigMapper ipfCcmUiLayoutConfigMapper;
    public IpfCcmUiLayoutConfig getIpfCcmUiLayoutConfig(String id){
        return ipfCcmUiLayoutConfigMapper.getIpfCcmUiLayoutConfig(id);
    }

    public void createIpfCcmUiLayoutConfig(IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig){
    	ipfCcmUiLayoutConfigMapper.createIpfCcmUiLayoutConfig(ipfCcmUiLayoutConfig);
    }

    public void deleteIpfCcmUiLayoutConfig(String id){
    	ipfCcmUiLayoutConfigMapper.deleteIpfCcmUiLayoutConfig(id);
    }

    public void updateIpfCcmUiLayoutConfig(IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig){
    	ipfCcmUiLayoutConfigMapper.updateIpfCcmUiLayoutConfig(ipfCcmUiLayoutConfig);
    }

    public int countAll(){
       return ipfCcmUiLayoutConfigMapper.countAll();
    }

    public ArrayList<IpfCcmUiLayoutConfig> selectAll(){
      return ipfCcmUiLayoutConfigMapper.selectAll();
    }
    
    public IpfCcmUiLayoutConfigMapper getIpfCcmUiLayoutConfigMapper() {
    	if(this.ipfCcmUiLayoutConfigMapper == null){
            this.ipfCcmUiLayoutConfigMapper = this.getSqlSessionTemplate().getMapper(IpfCcmUiLayoutConfigMapper.class);
        }
        return this.ipfCcmUiLayoutConfigMapper;
    }
        
    public void setIpfCcmUiLayoutConfigMapper(IpfCcmUiLayoutConfigMapper ipfCcmUiLayoutConfigMapper) {
        this.ipfCcmUiLayoutConfigMapper = ipfCcmUiLayoutConfigMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmUiLayoutConfigMapper = sqlSessionTemplate.getMapper(IpfCcmUiLayoutConfigMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmUiLayoutConfig
     * @return
     */
    public ArrayList<IpfCcmUiLayoutConfig> selectWithCondition(IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig){
        return  ipfCcmUiLayoutConfigMapper.selectWithCondition(ipfCcmUiLayoutConfig,"");
    }

    /** 按条件查询
     * @param ipfCcmUiLayoutConfig
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmUiLayoutConfig> selectWithCondition(IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig,String conditions){
        return  ipfCcmUiLayoutConfigMapper.selectWithCondition(ipfCcmUiLayoutConfig,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmUiLayoutConfig> selectBySql(String SqlStr){
        return  ipfCcmUiLayoutConfigMapper.selectBySql(SqlStr);
    }
}