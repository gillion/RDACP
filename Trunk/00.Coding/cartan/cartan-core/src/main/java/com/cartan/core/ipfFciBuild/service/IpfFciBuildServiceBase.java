package com.cartan.core.ipfFciBuild.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfFciBuild.dao.IpfFciBuildMapper;
import com.cartan.core.ipfFciBuild.domain.IpfFciBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfFciBuildServiceBase extends BaseService {
    private IpfFciBuildMapper ipfFciBuildMapper;
    public IpfFciBuild getIpfFciBuild(String id){
        return ipfFciBuildMapper.getIpfFciBuild(id);
    }

    public void createIpfFciBuild(IpfFciBuild ipfFciBuild){
    	ipfFciBuildMapper.createIpfFciBuild(ipfFciBuild);
    }

    public void deleteIpfFciBuild(String id){
    	ipfFciBuildMapper.deleteIpfFciBuild(id);
    }

    public void updateIpfFciBuild(IpfFciBuild ipfFciBuild){
    	ipfFciBuildMapper.updateIpfFciBuild(ipfFciBuild);
    }

    public int countAll(){
       return ipfFciBuildMapper.countAll();
    }

    public ArrayList<IpfFciBuild> selectAll(){
      return ipfFciBuildMapper.selectAll();
    }
    
    public IpfFciBuildMapper getIpfFciBuildMapper() {
    	if(this.ipfFciBuildMapper == null){
            this.ipfFciBuildMapper = this.getSqlSessionTemplate().getMapper(IpfFciBuildMapper.class);
        }
        return this.ipfFciBuildMapper;
    }
        
    public void setIpfFciBuildMapper(IpfFciBuildMapper ipfFciBuildMapper) {
        this.ipfFciBuildMapper = ipfFciBuildMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfFciBuildMapper = sqlSessionTemplate.getMapper(IpfFciBuildMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfFciBuild
     * @return
     */
    public ArrayList<IpfFciBuild> selectWithCondition(IpfFciBuild ipfFciBuild){
        return  ipfFciBuildMapper.selectWithCondition(ipfFciBuild,"");
    }

    /** 按条件查询
     * @param ipfFciBuild
     * @conditions
     * @return
     */
    public ArrayList<IpfFciBuild> selectWithCondition(IpfFciBuild ipfFciBuild,String conditions){
        return  ipfFciBuildMapper.selectWithCondition(ipfFciBuild,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfFciBuild> selectBySql(String SqlStr){
        return  ipfFciBuildMapper.selectBySql(SqlStr);
    }
}