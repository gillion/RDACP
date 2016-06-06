package com.cartan.core.ipfCcmBizruleDtl.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBizruleDtl.dao.IpfCcmBizruleDtlMapper;
import com.cartan.core.ipfCcmBizruleDtl.domain.IpfCcmBizruleDtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBizruleDtlServiceBase extends BaseService {
    private IpfCcmBizruleDtlMapper ipfCcmBizruleDtlMapper;
    public IpfCcmBizruleDtl getIpfCcmBizruleDtl(String id){
        return ipfCcmBizruleDtlMapper.getIpfCcmBizruleDtl(id);
    }

    public void createIpfCcmBizruleDtl(IpfCcmBizruleDtl ipfCcmBizruleDtl){
    	ipfCcmBizruleDtlMapper.createIpfCcmBizruleDtl(ipfCcmBizruleDtl);
    }

    public void deleteIpfCcmBizruleDtl(String id){
    	ipfCcmBizruleDtlMapper.deleteIpfCcmBizruleDtl(id);
    }

    public void updateIpfCcmBizruleDtl(IpfCcmBizruleDtl ipfCcmBizruleDtl){
    	ipfCcmBizruleDtlMapper.updateIpfCcmBizruleDtl(ipfCcmBizruleDtl);
    }

    public int countAll(){
       return ipfCcmBizruleDtlMapper.countAll();
    }

    public ArrayList<IpfCcmBizruleDtl> selectAll(){
      return ipfCcmBizruleDtlMapper.selectAll();
    }
    
    public IpfCcmBizruleDtlMapper getIpfCcmBizruleDtlMapper() {
    	if(this.ipfCcmBizruleDtlMapper == null){
            this.ipfCcmBizruleDtlMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBizruleDtlMapper.class);
        }
        return this.ipfCcmBizruleDtlMapper;
    }
        
    public void setIpfCcmBizruleDtlMapper(IpfCcmBizruleDtlMapper ipfCcmBizruleDtlMapper) {
        this.ipfCcmBizruleDtlMapper = ipfCcmBizruleDtlMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBizruleDtlMapper = sqlSessionTemplate.getMapper(IpfCcmBizruleDtlMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBizruleDtl
     * @return
     */
    public ArrayList<IpfCcmBizruleDtl> selectWithCondition(IpfCcmBizruleDtl ipfCcmBizruleDtl){
        return  ipfCcmBizruleDtlMapper.selectWithCondition(ipfCcmBizruleDtl,"");
    }

    /** 按条件查询
     * @param ipfCcmBizruleDtl
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBizruleDtl> selectWithCondition(IpfCcmBizruleDtl ipfCcmBizruleDtl,String conditions){
        return  ipfCcmBizruleDtlMapper.selectWithCondition(ipfCcmBizruleDtl,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBizruleDtl> selectBySql(String SqlStr){
        return  ipfCcmBizruleDtlMapper.selectBySql(SqlStr);
    }
}