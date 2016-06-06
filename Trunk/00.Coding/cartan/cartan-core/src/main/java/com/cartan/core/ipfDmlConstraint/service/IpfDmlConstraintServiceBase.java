package com.cartan.core.ipfDmlConstraint.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlConstraint.dao.IpfDmlConstraintMapper;
import com.cartan.core.ipfDmlConstraint.domain.IpfDmlConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlConstraintServiceBase extends BaseService {
    private IpfDmlConstraintMapper ipfDmlConstraintMapper;
    public IpfDmlConstraint getIpfDmlConstraint(String id){
        return ipfDmlConstraintMapper.getIpfDmlConstraint(id);
    }

    public void createIpfDmlConstraint(IpfDmlConstraint ipfDmlConstraint){
    	ipfDmlConstraintMapper.createIpfDmlConstraint(ipfDmlConstraint);
    }

    public void deleteIpfDmlConstraint(String id){
    	ipfDmlConstraintMapper.deleteIpfDmlConstraint(id);
    }

    public void updateIpfDmlConstraint(IpfDmlConstraint ipfDmlConstraint){
    	ipfDmlConstraintMapper.updateIpfDmlConstraint(ipfDmlConstraint);
    }

    public int countAll(){
       return ipfDmlConstraintMapper.countAll();
    }

    public ArrayList<IpfDmlConstraint> selectAll(){
      return ipfDmlConstraintMapper.selectAll();
    }
    
    public IpfDmlConstraintMapper getIpfDmlConstraintMapper() {
    	if(this.ipfDmlConstraintMapper == null){
            this.ipfDmlConstraintMapper = this.getSqlSessionTemplate().getMapper(IpfDmlConstraintMapper.class);
        }
        return this.ipfDmlConstraintMapper;
    }
        
    public void setIpfDmlConstraintMapper(IpfDmlConstraintMapper ipfDmlConstraintMapper) {
        this.ipfDmlConstraintMapper = ipfDmlConstraintMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlConstraintMapper = sqlSessionTemplate.getMapper(IpfDmlConstraintMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlConstraint
     * @return
     */
    public ArrayList<IpfDmlConstraint> selectWithCondition(IpfDmlConstraint ipfDmlConstraint){
        return  ipfDmlConstraintMapper.selectWithCondition(ipfDmlConstraint,"");
    }

    /** 按条件查询
     * @param ipfDmlConstraint
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlConstraint> selectWithCondition(IpfDmlConstraint ipfDmlConstraint,String conditions){
        return  ipfDmlConstraintMapper.selectWithCondition(ipfDmlConstraint,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlConstraint> selectBySql(String SqlStr){
        return  ipfDmlConstraintMapper.selectBySql(SqlStr);
    }
}