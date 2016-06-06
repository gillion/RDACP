package com.cartan.core.ipfDmlColumn.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlColumn.dao.IpfDmlColumnMapper;
import com.cartan.core.ipfDmlColumn.domain.IpfDmlColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlColumnServiceBase extends BaseService {
    private IpfDmlColumnMapper ipfDmlColumnMapper;
    public IpfDmlColumn getIpfDmlColumn(String id){
        return ipfDmlColumnMapper.getIpfDmlColumn(id);
    }

    public void createIpfDmlColumn(IpfDmlColumn ipfDmlColumn){
    	ipfDmlColumnMapper.createIpfDmlColumn(ipfDmlColumn);
    }

    public void deleteIpfDmlColumn(String id){
    	ipfDmlColumnMapper.deleteIpfDmlColumn(id);
    }

    public void updateIpfDmlColumn(IpfDmlColumn ipfDmlColumn){
    	ipfDmlColumnMapper.updateIpfDmlColumn(ipfDmlColumn);
    }

    public int countAll(){
       return ipfDmlColumnMapper.countAll();
    }

    public ArrayList<IpfDmlColumn> selectAll(){
      return ipfDmlColumnMapper.selectAll();
    }
    
    public IpfDmlColumnMapper getIpfDmlColumnMapper() {
    	if(this.ipfDmlColumnMapper == null){
            this.ipfDmlColumnMapper = this.getSqlSessionTemplate().getMapper(IpfDmlColumnMapper.class);
        }
        return this.ipfDmlColumnMapper;
    }
        
    public void setIpfDmlColumnMapper(IpfDmlColumnMapper ipfDmlColumnMapper) {
        this.ipfDmlColumnMapper = ipfDmlColumnMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlColumnMapper = sqlSessionTemplate.getMapper(IpfDmlColumnMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlColumn
     * @return
     */
    public ArrayList<IpfDmlColumn> selectWithCondition(IpfDmlColumn ipfDmlColumn){
        return  ipfDmlColumnMapper.selectWithCondition(ipfDmlColumn,"");
    }

    /** 按条件查询
     * @param ipfDmlColumn
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlColumn> selectWithCondition(IpfDmlColumn ipfDmlColumn,String conditions){
        return  ipfDmlColumnMapper.selectWithCondition(ipfDmlColumn,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlColumn> selectBySql(String SqlStr){
        return  ipfDmlColumnMapper.selectBySql(SqlStr);
    }
}