package com.cartan.core.ipfDmlViewSql.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlViewSql.dao.IpfDmlViewSqlMapper;
import com.cartan.core.ipfDmlViewSql.domain.IpfDmlViewSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlViewSqlServiceBase extends BaseService {
    private IpfDmlViewSqlMapper ipfDmlViewSqlMapper;
    public IpfDmlViewSql getIpfDmlViewSql(String id){
        return ipfDmlViewSqlMapper.getIpfDmlViewSql(id);
    }

    public void createIpfDmlViewSql(IpfDmlViewSql ipfDmlViewSql){
    	ipfDmlViewSqlMapper.createIpfDmlViewSql(ipfDmlViewSql);
    }

    public void deleteIpfDmlViewSql(String id){
    	ipfDmlViewSqlMapper.deleteIpfDmlViewSql(id);
    }

    public void updateIpfDmlViewSql(IpfDmlViewSql ipfDmlViewSql){
    	ipfDmlViewSqlMapper.updateIpfDmlViewSql(ipfDmlViewSql);
    }

    public int countAll(){
       return ipfDmlViewSqlMapper.countAll();
    }

    public ArrayList<IpfDmlViewSql> selectAll(){
      return ipfDmlViewSqlMapper.selectAll();
    }
    
    public IpfDmlViewSqlMapper getIpfDmlViewSqlMapper() {
    	if(this.ipfDmlViewSqlMapper == null){
            this.ipfDmlViewSqlMapper = this.getSqlSessionTemplate().getMapper(IpfDmlViewSqlMapper.class);
        }
        return this.ipfDmlViewSqlMapper;
    }
        
    public void setIpfDmlViewSqlMapper(IpfDmlViewSqlMapper ipfDmlViewSqlMapper) {
        this.ipfDmlViewSqlMapper = ipfDmlViewSqlMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlViewSqlMapper = sqlSessionTemplate.getMapper(IpfDmlViewSqlMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlViewSql
     * @return
     */
    public ArrayList<IpfDmlViewSql> selectWithCondition(IpfDmlViewSql ipfDmlViewSql){
        return  ipfDmlViewSqlMapper.selectWithCondition(ipfDmlViewSql,"");
    }

    /** 按条件查询
     * @param ipfDmlViewSql
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlViewSql> selectWithCondition(IpfDmlViewSql ipfDmlViewSql,String conditions){
        return  ipfDmlViewSqlMapper.selectWithCondition(ipfDmlViewSql,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlViewSql> selectBySql(String SqlStr){
        return  ipfDmlViewSqlMapper.selectBySql(SqlStr);
    }
}