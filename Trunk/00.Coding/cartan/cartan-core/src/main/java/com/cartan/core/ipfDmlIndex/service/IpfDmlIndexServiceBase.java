package com.cartan.core.ipfDmlIndex.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlIndex.dao.IpfDmlIndexMapper;
import com.cartan.core.ipfDmlIndex.domain.IpfDmlIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlIndexServiceBase extends BaseService {
    private IpfDmlIndexMapper ipfDmlIndexMapper;
    public IpfDmlIndex getIpfDmlIndex(String id){
        return ipfDmlIndexMapper.getIpfDmlIndex(id);
    }

    public void createIpfDmlIndex(IpfDmlIndex ipfDmlIndex){
    	ipfDmlIndexMapper.createIpfDmlIndex(ipfDmlIndex);
    }

    public void deleteIpfDmlIndex(String id){
    	ipfDmlIndexMapper.deleteIpfDmlIndex(id);
    }

    public void updateIpfDmlIndex(IpfDmlIndex ipfDmlIndex){
    	ipfDmlIndexMapper.updateIpfDmlIndex(ipfDmlIndex);
    }

    public int countAll(){
       return ipfDmlIndexMapper.countAll();
    }

    public ArrayList<IpfDmlIndex> selectAll(){
      return ipfDmlIndexMapper.selectAll();
    }
    
    public IpfDmlIndexMapper getIpfDmlIndexMapper() {
    	if(this.ipfDmlIndexMapper == null){
            this.ipfDmlIndexMapper = this.getSqlSessionTemplate().getMapper(IpfDmlIndexMapper.class);
        }
        return this.ipfDmlIndexMapper;
    }
        
    public void setIpfDmlIndexMapper(IpfDmlIndexMapper ipfDmlIndexMapper) {
        this.ipfDmlIndexMapper = ipfDmlIndexMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlIndexMapper = sqlSessionTemplate.getMapper(IpfDmlIndexMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlIndex
     * @return
     */
    public ArrayList<IpfDmlIndex> selectWithCondition(IpfDmlIndex ipfDmlIndex){
        return  ipfDmlIndexMapper.selectWithCondition(ipfDmlIndex,"");
    }

    /** 按条件查询
     * @param ipfDmlIndex
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlIndex> selectWithCondition(IpfDmlIndex ipfDmlIndex,String conditions){
        return  ipfDmlIndexMapper.selectWithCondition(ipfDmlIndex,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlIndex> selectBySql(String SqlStr){
        return  ipfDmlIndexMapper.selectBySql(SqlStr);
    }
}