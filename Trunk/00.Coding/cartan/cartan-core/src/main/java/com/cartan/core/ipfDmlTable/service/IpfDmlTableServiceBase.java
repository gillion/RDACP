package com.cartan.core.ipfDmlTable.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlTable.dao.IpfDmlTableMapper;
import com.cartan.core.ipfDmlTable.domain.IpfDmlTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlTableServiceBase extends BaseService {
    private IpfDmlTableMapper ipfDmlTableMapper;
    public IpfDmlTable getIpfDmlTable(String id){
        return ipfDmlTableMapper.getIpfDmlTable(id);
    }

    public void createIpfDmlTable(IpfDmlTable ipfDmlTable){
    	ipfDmlTableMapper.createIpfDmlTable(ipfDmlTable);
    }

    public void deleteIpfDmlTable(String id){
    	ipfDmlTableMapper.deleteIpfDmlTable(id);
    }

    public void updateIpfDmlTable(IpfDmlTable ipfDmlTable){
    	ipfDmlTableMapper.updateIpfDmlTable(ipfDmlTable);
    }

    public int countAll(){
       return ipfDmlTableMapper.countAll();
    }

    public ArrayList<IpfDmlTable> selectAll(){
      return ipfDmlTableMapper.selectAll();
    }
    
    public IpfDmlTableMapper getIpfDmlTableMapper() {
    	if(this.ipfDmlTableMapper == null){
            this.ipfDmlTableMapper = this.getSqlSessionTemplate().getMapper(IpfDmlTableMapper.class);
        }
        return this.ipfDmlTableMapper;
    }
        
    public void setIpfDmlTableMapper(IpfDmlTableMapper ipfDmlTableMapper) {
        this.ipfDmlTableMapper = ipfDmlTableMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlTableMapper = sqlSessionTemplate.getMapper(IpfDmlTableMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlTable
     * @return
     */
    public ArrayList<IpfDmlTable> selectWithCondition(IpfDmlTable ipfDmlTable){
        return  ipfDmlTableMapper.selectWithCondition(ipfDmlTable,"");
    }

    /** 按条件查询
     * @param ipfDmlTable
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlTable> selectWithCondition(IpfDmlTable ipfDmlTable,String conditions){
        return  ipfDmlTableMapper.selectWithCondition(ipfDmlTable,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlTable> selectBySql(String SqlStr){
        return  ipfDmlTableMapper.selectBySql(SqlStr);
    }
}