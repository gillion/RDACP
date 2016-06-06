package com.cartan.core.ipfRtmType.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfRtmType.dao.IpfRtmTypeMapper;
import com.cartan.core.ipfRtmType.domain.IpfRtmType;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfRtmTypeServiceBase extends BaseService {
    private IpfRtmTypeMapper ipfRtmTypeMapper;
    public IpfRtmType getIpfRtmType(String id){
        return ipfRtmTypeMapper.getIpfRtmType(id);
    }

    public void createIpfRtmType(IpfRtmType ipfRtmType){
    	ipfRtmTypeMapper.createIpfRtmType(ipfRtmType);
    }

    public void deleteIpfRtmType(String id){
    	ipfRtmTypeMapper.deleteIpfRtmType(id);
    }

    public void updateIpfRtmType(IpfRtmType ipfRtmType){
    	ipfRtmTypeMapper.updateIpfRtmType(ipfRtmType);
    }

    public int countAll(){
       return ipfRtmTypeMapper.countAll();
    }

    public ArrayList<IpfRtmType> selectAll(){
      return ipfRtmTypeMapper.selectAll();
    }
    
    public IpfRtmTypeMapper getIpfRtmTypeMapper() {
    	if(this.ipfRtmTypeMapper == null){
            this.ipfRtmTypeMapper = this.getSqlSessionTemplate().getMapper(IpfRtmTypeMapper.class);
        }
        return this.ipfRtmTypeMapper;
    }
        
    public void setIpfRtmTypeMapper(IpfRtmTypeMapper ipfRtmTypeMapper) {
        this.ipfRtmTypeMapper = ipfRtmTypeMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfRtmTypeMapper = sqlSessionTemplate.getMapper(IpfRtmTypeMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfRtmType
     * @return
     */
    public ArrayList<IpfRtmType> selectWithCondition(IpfRtmType ipfRtmType){
        return  ipfRtmTypeMapper.selectWithCondition(ipfRtmType,"");
    }

    /** 按条件查询
     * @param ipfRtmType
     * @conditions
     * @return
     */
    public ArrayList<IpfRtmType> selectWithCondition(IpfRtmType ipfRtmType,String conditions){
        return  ipfRtmTypeMapper.selectWithCondition(ipfRtmType,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfRtmType> selectBySql(String SqlStr){
        return  ipfRtmTypeMapper.selectBySql(SqlStr);
    }
}