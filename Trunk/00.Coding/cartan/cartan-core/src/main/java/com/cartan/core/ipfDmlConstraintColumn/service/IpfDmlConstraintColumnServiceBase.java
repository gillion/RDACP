package com.cartan.core.ipfDmlConstraintColumn.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlConstraintColumn.dao.IpfDmlConstraintColumnMapper;
import com.cartan.core.ipfDmlConstraintColumn.domain.IpfDmlConstraintColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlConstraintColumnServiceBase extends BaseService {
    private IpfDmlConstraintColumnMapper ipfDmlConstraintColumnMapper;
    public IpfDmlConstraintColumn getIpfDmlConstraintColumn(String id){
        return ipfDmlConstraintColumnMapper.getIpfDmlConstraintColumn(id);
    }

    public void createIpfDmlConstraintColumn(IpfDmlConstraintColumn ipfDmlConstraintColumn){
    	ipfDmlConstraintColumnMapper.createIpfDmlConstraintColumn(ipfDmlConstraintColumn);
    }

    public void deleteIpfDmlConstraintColumn(String id){
    	ipfDmlConstraintColumnMapper.deleteIpfDmlConstraintColumn(id);
    }

    public void updateIpfDmlConstraintColumn(IpfDmlConstraintColumn ipfDmlConstraintColumn){
    	ipfDmlConstraintColumnMapper.updateIpfDmlConstraintColumn(ipfDmlConstraintColumn);
    }

    public int countAll(){
       return ipfDmlConstraintColumnMapper.countAll();
    }

    public ArrayList<IpfDmlConstraintColumn> selectAll(){
      return ipfDmlConstraintColumnMapper.selectAll();
    }
    
    public IpfDmlConstraintColumnMapper getIpfDmlConstraintColumnMapper() {
    	if(this.ipfDmlConstraintColumnMapper == null){
            this.ipfDmlConstraintColumnMapper = this.getSqlSessionTemplate().getMapper(IpfDmlConstraintColumnMapper.class);
        }
        return this.ipfDmlConstraintColumnMapper;
    }
        
    public void setIpfDmlConstraintColumnMapper(IpfDmlConstraintColumnMapper ipfDmlConstraintColumnMapper) {
        this.ipfDmlConstraintColumnMapper = ipfDmlConstraintColumnMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlConstraintColumnMapper = sqlSessionTemplate.getMapper(IpfDmlConstraintColumnMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlConstraintColumn
     * @return
     */
    public ArrayList<IpfDmlConstraintColumn> selectWithCondition(IpfDmlConstraintColumn ipfDmlConstraintColumn){
        return  ipfDmlConstraintColumnMapper.selectWithCondition(ipfDmlConstraintColumn,"");
    }

    /** 按条件查询
     * @param ipfDmlConstraintColumn
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlConstraintColumn> selectWithCondition(IpfDmlConstraintColumn ipfDmlConstraintColumn,String conditions){
        return  ipfDmlConstraintColumnMapper.selectWithCondition(ipfDmlConstraintColumn,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlConstraintColumn> selectBySql(String SqlStr){
        return  ipfDmlConstraintColumnMapper.selectBySql(SqlStr);
    }
}