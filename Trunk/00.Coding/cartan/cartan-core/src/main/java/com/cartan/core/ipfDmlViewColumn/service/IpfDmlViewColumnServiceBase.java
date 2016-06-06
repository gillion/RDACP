package com.cartan.core.ipfDmlViewColumn.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlViewColumn.dao.IpfDmlViewColumnMapper;
import com.cartan.core.ipfDmlViewColumn.domain.IpfDmlViewColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlViewColumnServiceBase extends BaseService {
    private IpfDmlViewColumnMapper ipfDmlViewColumnMapper;
    public IpfDmlViewColumn getIpfDmlViewColumn(String id){
        return ipfDmlViewColumnMapper.getIpfDmlViewColumn(id);
    }

    public void createIpfDmlViewColumn(IpfDmlViewColumn ipfDmlViewColumn){
    	ipfDmlViewColumnMapper.createIpfDmlViewColumn(ipfDmlViewColumn);
    }

    public void deleteIpfDmlViewColumn(String id){
    	ipfDmlViewColumnMapper.deleteIpfDmlViewColumn(id);
    }

    public void updateIpfDmlViewColumn(IpfDmlViewColumn ipfDmlViewColumn){
    	ipfDmlViewColumnMapper.updateIpfDmlViewColumn(ipfDmlViewColumn);
    }

    public int countAll(){
       return ipfDmlViewColumnMapper.countAll();
    }

    public ArrayList<IpfDmlViewColumn> selectAll(){
      return ipfDmlViewColumnMapper.selectAll();
    }
    
    public IpfDmlViewColumnMapper getIpfDmlViewColumnMapper() {
    	if(this.ipfDmlViewColumnMapper == null){
            this.ipfDmlViewColumnMapper = this.getSqlSessionTemplate().getMapper(IpfDmlViewColumnMapper.class);
        }
        return this.ipfDmlViewColumnMapper;
    }
        
    public void setIpfDmlViewColumnMapper(IpfDmlViewColumnMapper ipfDmlViewColumnMapper) {
        this.ipfDmlViewColumnMapper = ipfDmlViewColumnMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlViewColumnMapper = sqlSessionTemplate.getMapper(IpfDmlViewColumnMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlViewColumn
     * @return
     */
    public ArrayList<IpfDmlViewColumn> selectWithCondition(IpfDmlViewColumn ipfDmlViewColumn){
        return  ipfDmlViewColumnMapper.selectWithCondition(ipfDmlViewColumn,"");
    }

    /** 按条件查询
     * @param ipfDmlViewColumn
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlViewColumn> selectWithCondition(IpfDmlViewColumn ipfDmlViewColumn,String conditions){
        return  ipfDmlViewColumnMapper.selectWithCondition(ipfDmlViewColumn,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlViewColumn> selectBySql(String SqlStr){
        return  ipfDmlViewColumnMapper.selectBySql(SqlStr);
    }
}