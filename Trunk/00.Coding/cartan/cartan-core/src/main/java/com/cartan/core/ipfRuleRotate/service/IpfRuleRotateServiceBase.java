package com.cartan.core.ipfRuleRotate.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfRuleRotate.dao.IpfRuleRotateMapper;
import com.cartan.core.ipfRuleRotate.domain.IpfRuleRotate;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfRuleRotateServiceBase extends BaseService {
    private IpfRuleRotateMapper ipfRuleRotateMapper;
    public IpfRuleRotate getIpfRuleRotate(String id){
        return ipfRuleRotateMapper.getIpfRuleRotate(id);
    }

    public void createIpfRuleRotate(IpfRuleRotate ipfRuleRotate){
    	ipfRuleRotateMapper.createIpfRuleRotate(ipfRuleRotate);
    }

    public void deleteIpfRuleRotate(String id){
    	ipfRuleRotateMapper.deleteIpfRuleRotate(id);
    }

    public void updateIpfRuleRotate(IpfRuleRotate ipfRuleRotate){
    	ipfRuleRotateMapper.updateIpfRuleRotate(ipfRuleRotate);
    }

    public int countAll(){
       return ipfRuleRotateMapper.countAll();
    }

    public ArrayList<IpfRuleRotate> selectAll(){
      return ipfRuleRotateMapper.selectAll();
    }
    
    public IpfRuleRotateMapper getIpfRuleRotateMapper() {
    	if(this.ipfRuleRotateMapper == null){
            this.ipfRuleRotateMapper = this.getSqlSessionTemplate().getMapper(IpfRuleRotateMapper.class);
        }
        return this.ipfRuleRotateMapper;
    }
        
    public void setIpfRuleRotateMapper(IpfRuleRotateMapper ipfRuleRotateMapper) {
        this.ipfRuleRotateMapper = ipfRuleRotateMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfRuleRotateMapper = sqlSessionTemplate.getMapper(IpfRuleRotateMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfRuleRotate
     * @return
     */
    public ArrayList<IpfRuleRotate> selectWithCondition(IpfRuleRotate ipfRuleRotate){
        return  ipfRuleRotateMapper.selectWithCondition(ipfRuleRotate,"");
    }

    /** 按条件查询
     * @param ipfRuleRotate
     * @conditions
     * @return
     */
    public ArrayList<IpfRuleRotate> selectWithCondition(IpfRuleRotate ipfRuleRotate,String conditions){
        return  ipfRuleRotateMapper.selectWithCondition(ipfRuleRotate,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfRuleRotate> selectBySql(String SqlStr){
        return  ipfRuleRotateMapper.selectBySql(SqlStr);
    }
}