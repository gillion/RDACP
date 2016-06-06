package com.cartan.core.ipfCcmBizrule.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBizrule.dao.IpfCcmBizruleMapper;
import com.cartan.core.ipfCcmBizrule.domain.IpfCcmBizrule;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBizruleServiceBase extends BaseService {
    private IpfCcmBizruleMapper ipfCcmBizruleMapper;
    public IpfCcmBizrule getIpfCcmBizrule(String id){
        return ipfCcmBizruleMapper.getIpfCcmBizrule(id);
    }

    public void createIpfCcmBizrule(IpfCcmBizrule ipfCcmBizrule){
    	ipfCcmBizruleMapper.createIpfCcmBizrule(ipfCcmBizrule);
    }

    public void deleteIpfCcmBizrule(String id){
    	ipfCcmBizruleMapper.deleteIpfCcmBizrule(id);
    }

    public void updateIpfCcmBizrule(IpfCcmBizrule ipfCcmBizrule){
    	ipfCcmBizruleMapper.updateIpfCcmBizrule(ipfCcmBizrule);
    }

    public int countAll(){
       return ipfCcmBizruleMapper.countAll();
    }

    public ArrayList<IpfCcmBizrule> selectAll(){
      return ipfCcmBizruleMapper.selectAll();
    }
    
    public IpfCcmBizruleMapper getIpfCcmBizruleMapper() {
    	if(this.ipfCcmBizruleMapper == null){
            this.ipfCcmBizruleMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBizruleMapper.class);
        }
        return this.ipfCcmBizruleMapper;
    }
        
    public void setIpfCcmBizruleMapper(IpfCcmBizruleMapper ipfCcmBizruleMapper) {
        this.ipfCcmBizruleMapper = ipfCcmBizruleMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBizruleMapper = sqlSessionTemplate.getMapper(IpfCcmBizruleMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBizrule
     * @return
     */
    public ArrayList<IpfCcmBizrule> selectWithCondition(IpfCcmBizrule ipfCcmBizrule){
        return  ipfCcmBizruleMapper.selectWithCondition(ipfCcmBizrule,"");
    }

    /** 按条件查询
     * @param ipfCcmBizrule
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBizrule> selectWithCondition(IpfCcmBizrule ipfCcmBizrule,String conditions){
        return  ipfCcmBizruleMapper.selectWithCondition(ipfCcmBizrule,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBizrule> selectBySql(String SqlStr){
        return  ipfCcmBizruleMapper.selectBySql(SqlStr);
    }
}