package com.cartan.core.ipfCcmNumrule.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmNumrule.dao.IpfCcmNumruleMapper;
import com.cartan.core.ipfCcmNumrule.domain.IpfCcmNumrule;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmNumruleServiceBase extends BaseService {
    private IpfCcmNumruleMapper ipfCcmNumruleMapper;
    public IpfCcmNumrule getIpfCcmNumrule(String id){
        return ipfCcmNumruleMapper.getIpfCcmNumrule(id);
    }

    public void createIpfCcmNumrule(IpfCcmNumrule ipfCcmNumrule){
    	ipfCcmNumruleMapper.createIpfCcmNumrule(ipfCcmNumrule);
    }

    public void deleteIpfCcmNumrule(String id){
    	ipfCcmNumruleMapper.deleteIpfCcmNumrule(id);
    }

    public void updateIpfCcmNumrule(IpfCcmNumrule ipfCcmNumrule){
    	ipfCcmNumruleMapper.updateIpfCcmNumrule(ipfCcmNumrule);
    }

    public int countAll(){
       return ipfCcmNumruleMapper.countAll();
    }

    public ArrayList<IpfCcmNumrule> selectAll(){
      return ipfCcmNumruleMapper.selectAll();
    }
    
    public IpfCcmNumruleMapper getIpfCcmNumruleMapper() {
    	if(this.ipfCcmNumruleMapper == null){
            this.ipfCcmNumruleMapper = this.getSqlSessionTemplate().getMapper(IpfCcmNumruleMapper.class);
        }
        return this.ipfCcmNumruleMapper;
    }
        
    public void setIpfCcmNumruleMapper(IpfCcmNumruleMapper ipfCcmNumruleMapper) {
        this.ipfCcmNumruleMapper = ipfCcmNumruleMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmNumruleMapper = sqlSessionTemplate.getMapper(IpfCcmNumruleMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmNumrule
     * @return
     */
    public ArrayList<IpfCcmNumrule> selectWithCondition(IpfCcmNumrule ipfCcmNumrule){
        return  ipfCcmNumruleMapper.selectWithCondition(ipfCcmNumrule,"");
    }

    /** 按条件查询
     * @param ipfCcmNumrule
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmNumrule> selectWithCondition(IpfCcmNumrule ipfCcmNumrule,String conditions){
        return  ipfCcmNumruleMapper.selectWithCondition(ipfCcmNumrule,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmNumrule> selectBySql(String SqlStr){
        return  ipfCcmNumruleMapper.selectBySql(SqlStr);
    }
}