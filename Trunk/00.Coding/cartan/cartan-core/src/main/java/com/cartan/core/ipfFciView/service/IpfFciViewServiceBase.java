package com.cartan.core.ipfFciView.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfFciView.dao.IpfFciViewMapper;
import com.cartan.core.ipfFciView.domain.IpfFciView;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfFciViewServiceBase extends BaseService {
    private IpfFciViewMapper ipfFciViewMapper;
    public IpfFciView getIpfFciView(String id){
        return ipfFciViewMapper.getIpfFciView(id);
    }

    public void createIpfFciView(IpfFciView ipfFciView){
    	ipfFciViewMapper.createIpfFciView(ipfFciView);
    }

    public void deleteIpfFciView(String id){
    	ipfFciViewMapper.deleteIpfFciView(id);
    }

    public void updateIpfFciView(IpfFciView ipfFciView){
    	ipfFciViewMapper.updateIpfFciView(ipfFciView);
    }

    public int countAll(){
       return ipfFciViewMapper.countAll();
    }

    public ArrayList<IpfFciView> selectAll(){
      return ipfFciViewMapper.selectAll();
    }
    
    public IpfFciViewMapper getIpfFciViewMapper() {
    	if(this.ipfFciViewMapper == null){
            this.ipfFciViewMapper = this.getSqlSessionTemplate().getMapper(IpfFciViewMapper.class);
        }
        return this.ipfFciViewMapper;
    }
        
    public void setIpfFciViewMapper(IpfFciViewMapper ipfFciViewMapper) {
        this.ipfFciViewMapper = ipfFciViewMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfFciViewMapper = sqlSessionTemplate.getMapper(IpfFciViewMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfFciView
     * @return
     */
    public ArrayList<IpfFciView> selectWithCondition(IpfFciView ipfFciView){
        return  ipfFciViewMapper.selectWithCondition(ipfFciView,"");
    }

    /** 按条件查询
     * @param ipfFciView
     * @conditions
     * @return
     */
    public ArrayList<IpfFciView> selectWithCondition(IpfFciView ipfFciView,String conditions){
        return  ipfFciViewMapper.selectWithCondition(ipfFciView,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfFciView> selectBySql(String SqlStr){
        return  ipfFciViewMapper.selectBySql(SqlStr);
    }
}