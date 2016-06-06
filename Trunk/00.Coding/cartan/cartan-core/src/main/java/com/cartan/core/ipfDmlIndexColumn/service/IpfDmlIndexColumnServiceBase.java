package com.cartan.core.ipfDmlIndexColumn.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlIndexColumn.dao.IpfDmlIndexColumnMapper;
import com.cartan.core.ipfDmlIndexColumn.domain.IpfDmlIndexColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlIndexColumnServiceBase extends BaseService {
    private IpfDmlIndexColumnMapper ipfDmlIndexColumnMapper;
    public IpfDmlIndexColumn getIpfDmlIndexColumn(String id){
        return ipfDmlIndexColumnMapper.getIpfDmlIndexColumn(id);
    }

    public void createIpfDmlIndexColumn(IpfDmlIndexColumn ipfDmlIndexColumn){
    	ipfDmlIndexColumnMapper.createIpfDmlIndexColumn(ipfDmlIndexColumn);
    }

    public void deleteIpfDmlIndexColumn(String id){
    	ipfDmlIndexColumnMapper.deleteIpfDmlIndexColumn(id);
    }

    public void updateIpfDmlIndexColumn(IpfDmlIndexColumn ipfDmlIndexColumn){
    	ipfDmlIndexColumnMapper.updateIpfDmlIndexColumn(ipfDmlIndexColumn);
    }

    public int countAll(){
       return ipfDmlIndexColumnMapper.countAll();
    }

    public ArrayList<IpfDmlIndexColumn> selectAll(){
      return ipfDmlIndexColumnMapper.selectAll();
    }
    
    public IpfDmlIndexColumnMapper getIpfDmlIndexColumnMapper() {
    	if(this.ipfDmlIndexColumnMapper == null){
            this.ipfDmlIndexColumnMapper = this.getSqlSessionTemplate().getMapper(IpfDmlIndexColumnMapper.class);
        }
        return this.ipfDmlIndexColumnMapper;
    }
        
    public void setIpfDmlIndexColumnMapper(IpfDmlIndexColumnMapper ipfDmlIndexColumnMapper) {
        this.ipfDmlIndexColumnMapper = ipfDmlIndexColumnMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlIndexColumnMapper = sqlSessionTemplate.getMapper(IpfDmlIndexColumnMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlIndexColumn
     * @return
     */
    public ArrayList<IpfDmlIndexColumn> selectWithCondition(IpfDmlIndexColumn ipfDmlIndexColumn){
        return  ipfDmlIndexColumnMapper.selectWithCondition(ipfDmlIndexColumn,"");
    }

    /** 按条件查询
     * @param ipfDmlIndexColumn
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlIndexColumn> selectWithCondition(IpfDmlIndexColumn ipfDmlIndexColumn,String conditions){
        return  ipfDmlIndexColumnMapper.selectWithCondition(ipfDmlIndexColumn,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlIndexColumn> selectBySql(String SqlStr){
        return  ipfDmlIndexColumnMapper.selectBySql(SqlStr);
    }
}