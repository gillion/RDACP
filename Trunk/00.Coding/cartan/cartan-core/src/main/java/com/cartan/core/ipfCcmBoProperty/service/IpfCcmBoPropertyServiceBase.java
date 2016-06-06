package com.cartan.core.ipfCcmBoProperty.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoProperty.dao.IpfCcmBoPropertyMapper;
import com.cartan.core.ipfCcmBoProperty.domain.IpfCcmBoProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoPropertyServiceBase extends BaseService {
    private IpfCcmBoPropertyMapper ipfCcmBoPropertyMapper;
    public IpfCcmBoProperty getIpfCcmBoProperty(String id){
        return ipfCcmBoPropertyMapper.getIpfCcmBoProperty(id);
    }

    public void createIpfCcmBoProperty(IpfCcmBoProperty ipfCcmBoProperty){
    	ipfCcmBoPropertyMapper.createIpfCcmBoProperty(ipfCcmBoProperty);
    }

    public void deleteIpfCcmBoProperty(String id){
    	ipfCcmBoPropertyMapper.deleteIpfCcmBoProperty(id);
    }

    public void updateIpfCcmBoProperty(IpfCcmBoProperty ipfCcmBoProperty){
    	ipfCcmBoPropertyMapper.updateIpfCcmBoProperty(ipfCcmBoProperty);
    }

    public int countAll(){
       return ipfCcmBoPropertyMapper.countAll();
    }

    public ArrayList<IpfCcmBoProperty> selectAll(){
      return ipfCcmBoPropertyMapper.selectAll();
    }
    
    public IpfCcmBoPropertyMapper getIpfCcmBoPropertyMapper() {
    	if(this.ipfCcmBoPropertyMapper == null){
            this.ipfCcmBoPropertyMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoPropertyMapper.class);
        }
        return this.ipfCcmBoPropertyMapper;
    }
        
    public void setIpfCcmBoPropertyMapper(IpfCcmBoPropertyMapper ipfCcmBoPropertyMapper) {
        this.ipfCcmBoPropertyMapper = ipfCcmBoPropertyMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoPropertyMapper = sqlSessionTemplate.getMapper(IpfCcmBoPropertyMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoProperty
     * @return
     */
    public ArrayList<IpfCcmBoProperty> selectWithCondition(IpfCcmBoProperty ipfCcmBoProperty){
        return  ipfCcmBoPropertyMapper.selectWithCondition(ipfCcmBoProperty,"");
    }

    /** 按条件查询
     * @param ipfCcmBoProperty
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoProperty> selectWithCondition(IpfCcmBoProperty ipfCcmBoProperty,String conditions){
        return  ipfCcmBoPropertyMapper.selectWithCondition(ipfCcmBoProperty,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoProperty> selectBySql(String SqlStr){
        return  ipfCcmBoPropertyMapper.selectBySql(SqlStr);
    }
}