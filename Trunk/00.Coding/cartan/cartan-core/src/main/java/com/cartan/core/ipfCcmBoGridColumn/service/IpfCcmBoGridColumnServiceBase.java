package com.cartan.core.ipfCcmBoGridColumn.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoGridColumn.dao.IpfCcmBoGridColumnMapper;
import com.cartan.core.ipfCcmBoGridColumn.domain.IpfCcmBoGridColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoGridColumnServiceBase extends BaseService {
    private IpfCcmBoGridColumnMapper ipfCcmBoGridColumnMapper;
    public IpfCcmBoGridColumn getIpfCcmBoGridColumn(String id){
        return ipfCcmBoGridColumnMapper.getIpfCcmBoGridColumn(id);
    }

    public void createIpfCcmBoGridColumn(IpfCcmBoGridColumn ipfCcmBoGridColumn){
    	ipfCcmBoGridColumnMapper.createIpfCcmBoGridColumn(ipfCcmBoGridColumn);
    }

    public void deleteIpfCcmBoGridColumn(String id){
    	ipfCcmBoGridColumnMapper.deleteIpfCcmBoGridColumn(id);
    }

    public void updateIpfCcmBoGridColumn(IpfCcmBoGridColumn ipfCcmBoGridColumn){
    	ipfCcmBoGridColumnMapper.updateIpfCcmBoGridColumn(ipfCcmBoGridColumn);
    }

    public int countAll(){
       return ipfCcmBoGridColumnMapper.countAll();
    }

    public ArrayList<IpfCcmBoGridColumn> selectAll(){
      return ipfCcmBoGridColumnMapper.selectAll();
    }
    
    public IpfCcmBoGridColumnMapper getIpfCcmBoGridColumnMapper() {
    	if(this.ipfCcmBoGridColumnMapper == null){
            this.ipfCcmBoGridColumnMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoGridColumnMapper.class);
        }
        return this.ipfCcmBoGridColumnMapper;
    }
        
    public void setIpfCcmBoGridColumnMapper(IpfCcmBoGridColumnMapper ipfCcmBoGridColumnMapper) {
        this.ipfCcmBoGridColumnMapper = ipfCcmBoGridColumnMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoGridColumnMapper = sqlSessionTemplate.getMapper(IpfCcmBoGridColumnMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoGridColumn
     * @return
     */
    public ArrayList<IpfCcmBoGridColumn> selectWithCondition(IpfCcmBoGridColumn ipfCcmBoGridColumn){
        return  ipfCcmBoGridColumnMapper.selectWithCondition(ipfCcmBoGridColumn,"");
    }

    /** 按条件查询
     * @param ipfCcmBoGridColumn
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoGridColumn> selectWithCondition(IpfCcmBoGridColumn ipfCcmBoGridColumn,String conditions){
        return  ipfCcmBoGridColumnMapper.selectWithCondition(ipfCcmBoGridColumn,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoGridColumn> selectBySql(String SqlStr){
        return  ipfCcmBoGridColumnMapper.selectBySql(SqlStr);
    }
}