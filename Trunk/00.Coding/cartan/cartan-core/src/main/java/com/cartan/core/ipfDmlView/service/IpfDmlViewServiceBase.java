package com.cartan.core.ipfDmlView.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlView.dao.IpfDmlViewMapper;
import com.cartan.core.ipfDmlView.domain.IpfDmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlViewServiceBase extends BaseService {
    private IpfDmlViewMapper ipfDmlViewMapper;
    public IpfDmlView getIpfDmlView(String id){
        return ipfDmlViewMapper.getIpfDmlView(id);
    }

    public void createIpfDmlView(IpfDmlView ipfDmlView){
    	ipfDmlViewMapper.createIpfDmlView(ipfDmlView);
    }

    public void deleteIpfDmlView(String id){
    	ipfDmlViewMapper.deleteIpfDmlView(id);
    }

    public void updateIpfDmlView(IpfDmlView ipfDmlView){
    	ipfDmlViewMapper.updateIpfDmlView(ipfDmlView);
    }

    public int countAll(){
       return ipfDmlViewMapper.countAll();
    }

    public ArrayList<IpfDmlView> selectAll(){
      return ipfDmlViewMapper.selectAll();
    }
    
    public IpfDmlViewMapper getIpfDmlViewMapper() {
    	if(this.ipfDmlViewMapper == null){
            this.ipfDmlViewMapper = this.getSqlSessionTemplate().getMapper(IpfDmlViewMapper.class);
        }
        return this.ipfDmlViewMapper;
    }
        
    public void setIpfDmlViewMapper(IpfDmlViewMapper ipfDmlViewMapper) {
        this.ipfDmlViewMapper = ipfDmlViewMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlViewMapper = sqlSessionTemplate.getMapper(IpfDmlViewMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlView
     * @return
     */
    public ArrayList<IpfDmlView> selectWithCondition(IpfDmlView ipfDmlView){
        return  ipfDmlViewMapper.selectWithCondition(ipfDmlView,"");
    }

    /** 按条件查询
     * @param ipfDmlView
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlView> selectWithCondition(IpfDmlView ipfDmlView,String conditions){
        return  ipfDmlViewMapper.selectWithCondition(ipfDmlView,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlView> selectBySql(String SqlStr){
        return  ipfDmlViewMapper.selectBySql(SqlStr);
    }
}