package com.cartan.core.ipfCcmBoFormColumn.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoFormColumn.dao.IpfCcmBoFormColumnMapper;
import com.cartan.core.ipfCcmBoFormColumn.domain.IpfCcmBoFormColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoFormColumnServiceBase extends BaseService {
    private IpfCcmBoFormColumnMapper ipfCcmBoFormColumnMapper;
    public IpfCcmBoFormColumn getIpfCcmBoFormColumn(String id){
        return ipfCcmBoFormColumnMapper.getIpfCcmBoFormColumn(id);
    }

    public void createIpfCcmBoFormColumn(IpfCcmBoFormColumn ipfCcmBoFormColumn){
    	ipfCcmBoFormColumnMapper.createIpfCcmBoFormColumn(ipfCcmBoFormColumn);
    }

    public void deleteIpfCcmBoFormColumn(String id){
    	ipfCcmBoFormColumnMapper.deleteIpfCcmBoFormColumn(id);
    }

    public void updateIpfCcmBoFormColumn(IpfCcmBoFormColumn ipfCcmBoFormColumn){
    	ipfCcmBoFormColumnMapper.updateIpfCcmBoFormColumn(ipfCcmBoFormColumn);
    }

    public int countAll(){
       return ipfCcmBoFormColumnMapper.countAll();
    }

    public ArrayList<IpfCcmBoFormColumn> selectAll(){
      return ipfCcmBoFormColumnMapper.selectAll();
    }
    
    public IpfCcmBoFormColumnMapper getIpfCcmBoFormColumnMapper() {
    	if(this.ipfCcmBoFormColumnMapper == null){
            this.ipfCcmBoFormColumnMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoFormColumnMapper.class);
        }
        return this.ipfCcmBoFormColumnMapper;
    }
        
    public void setIpfCcmBoFormColumnMapper(IpfCcmBoFormColumnMapper ipfCcmBoFormColumnMapper) {
        this.ipfCcmBoFormColumnMapper = ipfCcmBoFormColumnMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoFormColumnMapper = sqlSessionTemplate.getMapper(IpfCcmBoFormColumnMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoFormColumn
     * @return
     */
    public ArrayList<IpfCcmBoFormColumn> selectWithCondition(IpfCcmBoFormColumn ipfCcmBoFormColumn){
        return  ipfCcmBoFormColumnMapper.selectWithCondition(ipfCcmBoFormColumn,"");
    }

    /** 按条件查询
     * @param ipfCcmBoFormColumn
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoFormColumn> selectWithCondition(IpfCcmBoFormColumn ipfCcmBoFormColumn,String conditions){
        return  ipfCcmBoFormColumnMapper.selectWithCondition(ipfCcmBoFormColumn,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoFormColumn> selectBySql(String SqlStr){
        return  ipfCcmBoFormColumnMapper.selectBySql(SqlStr);
    }
}