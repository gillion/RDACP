package com.cartan.core.ipfRtmTypeBoMap.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfRtmTypeBoMap.dao.IpfRtmTypeBoMapMapper;
import com.cartan.core.ipfRtmTypeBoMap.domain.IpfRtmTypeBoMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfRtmTypeBoMapServiceBase extends BaseService {
    private IpfRtmTypeBoMapMapper ipfRtmTypeBoMapMapper;
    public IpfRtmTypeBoMap getIpfRtmTypeBoMap(String id){
        return ipfRtmTypeBoMapMapper.getIpfRtmTypeBoMap(id);
    }

    public void createIpfRtmTypeBoMap(IpfRtmTypeBoMap ipfRtmTypeBoMap){
    	ipfRtmTypeBoMapMapper.createIpfRtmTypeBoMap(ipfRtmTypeBoMap);
    }

    public void deleteIpfRtmTypeBoMap(String id){
    	ipfRtmTypeBoMapMapper.deleteIpfRtmTypeBoMap(id);
    }

    public void updateIpfRtmTypeBoMap(IpfRtmTypeBoMap ipfRtmTypeBoMap){
    	ipfRtmTypeBoMapMapper.updateIpfRtmTypeBoMap(ipfRtmTypeBoMap);
    }

    public int countAll(){
       return ipfRtmTypeBoMapMapper.countAll();
    }

    public ArrayList<IpfRtmTypeBoMap> selectAll(){
      return ipfRtmTypeBoMapMapper.selectAll();
    }
    
    public IpfRtmTypeBoMapMapper getIpfRtmTypeBoMapMapper() {
    	if(this.ipfRtmTypeBoMapMapper == null){
            this.ipfRtmTypeBoMapMapper = this.getSqlSessionTemplate().getMapper(IpfRtmTypeBoMapMapper.class);
        }
        return this.ipfRtmTypeBoMapMapper;
    }
        
    public void setIpfRtmTypeBoMapMapper(IpfRtmTypeBoMapMapper ipfRtmTypeBoMapMapper) {
        this.ipfRtmTypeBoMapMapper = ipfRtmTypeBoMapMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfRtmTypeBoMapMapper = sqlSessionTemplate.getMapper(IpfRtmTypeBoMapMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfRtmTypeBoMap
     * @return
     */
    public ArrayList<IpfRtmTypeBoMap> selectWithCondition(IpfRtmTypeBoMap ipfRtmTypeBoMap){
        return  ipfRtmTypeBoMapMapper.selectWithCondition(ipfRtmTypeBoMap,"");
    }

    /** 按条件查询
     * @param ipfRtmTypeBoMap
     * @conditions
     * @return
     */
    public ArrayList<IpfRtmTypeBoMap> selectWithCondition(IpfRtmTypeBoMap ipfRtmTypeBoMap,String conditions){
        return  ipfRtmTypeBoMapMapper.selectWithCondition(ipfRtmTypeBoMap,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfRtmTypeBoMap> selectBySql(String SqlStr){
        return  ipfRtmTypeBoMapMapper.selectBySql(SqlStr);
    }
}