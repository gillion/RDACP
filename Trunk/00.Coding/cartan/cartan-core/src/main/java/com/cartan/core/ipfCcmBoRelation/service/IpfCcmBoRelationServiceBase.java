package com.cartan.core.ipfCcmBoRelation.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoRelation.dao.IpfCcmBoRelationMapper;
import com.cartan.core.ipfCcmBoRelation.domain.IpfCcmBoRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoRelationServiceBase extends BaseService {
    private IpfCcmBoRelationMapper ipfCcmBoRelationMapper;
    public IpfCcmBoRelation getIpfCcmBoRelation(String id){
        return ipfCcmBoRelationMapper.getIpfCcmBoRelation(id);
    }

    public void createIpfCcmBoRelation(IpfCcmBoRelation ipfCcmBoRelation){
    	ipfCcmBoRelationMapper.createIpfCcmBoRelation(ipfCcmBoRelation);
    }

    public void deleteIpfCcmBoRelation(String id){
    	ipfCcmBoRelationMapper.deleteIpfCcmBoRelation(id);
    }

    public void updateIpfCcmBoRelation(IpfCcmBoRelation ipfCcmBoRelation){
    	ipfCcmBoRelationMapper.updateIpfCcmBoRelation(ipfCcmBoRelation);
    }

    public int countAll(){
       return ipfCcmBoRelationMapper.countAll();
    }

    public ArrayList<IpfCcmBoRelation> selectAll(){
      return ipfCcmBoRelationMapper.selectAll();
    }
    
    public IpfCcmBoRelationMapper getIpfCcmBoRelationMapper() {
    	if(this.ipfCcmBoRelationMapper == null){
            this.ipfCcmBoRelationMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoRelationMapper.class);
        }
        return this.ipfCcmBoRelationMapper;
    }
        
    public void setIpfCcmBoRelationMapper(IpfCcmBoRelationMapper ipfCcmBoRelationMapper) {
        this.ipfCcmBoRelationMapper = ipfCcmBoRelationMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoRelationMapper = sqlSessionTemplate.getMapper(IpfCcmBoRelationMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoRelation
     * @return
     */
    public ArrayList<IpfCcmBoRelation> selectWithCondition(IpfCcmBoRelation ipfCcmBoRelation){
        return  ipfCcmBoRelationMapper.selectWithCondition(ipfCcmBoRelation,"");
    }

    /** 按条件查询
     * @param ipfCcmBoRelation
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoRelation> selectWithCondition(IpfCcmBoRelation ipfCcmBoRelation,String conditions){
        return  ipfCcmBoRelationMapper.selectWithCondition(ipfCcmBoRelation,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoRelation> selectBySql(String SqlStr){
        return  ipfCcmBoRelationMapper.selectBySql(SqlStr);
    }
}