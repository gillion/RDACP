package com.cartan.core.ipfCcmBoPropertyCas.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoPropertyCas.dao.IpfCcmBoPropertyCasMapper;
import com.cartan.core.ipfCcmBoPropertyCas.domain.IpfCcmBoPropertyCas;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoPropertyCasServiceBase extends BaseService {
    private IpfCcmBoPropertyCasMapper ipfCcmBoPropertyCasMapper;
    public IpfCcmBoPropertyCas getIpfCcmBoPropertyCas(String id){
        return ipfCcmBoPropertyCasMapper.getIpfCcmBoPropertyCas(id);
    }

    public void createIpfCcmBoPropertyCas(IpfCcmBoPropertyCas ipfCcmBoPropertyCas){
    	ipfCcmBoPropertyCasMapper.createIpfCcmBoPropertyCas(ipfCcmBoPropertyCas);
    }

    public void deleteIpfCcmBoPropertyCas(String id){
    	ipfCcmBoPropertyCasMapper.deleteIpfCcmBoPropertyCas(id);
    }

    public void updateIpfCcmBoPropertyCas(IpfCcmBoPropertyCas ipfCcmBoPropertyCas){
    	ipfCcmBoPropertyCasMapper.updateIpfCcmBoPropertyCas(ipfCcmBoPropertyCas);
    }

    public int countAll(){
       return ipfCcmBoPropertyCasMapper.countAll();
    }

    public ArrayList<IpfCcmBoPropertyCas> selectAll(){
      return ipfCcmBoPropertyCasMapper.selectAll();
    }
    
    public IpfCcmBoPropertyCasMapper getIpfCcmBoPropertyCasMapper() {
    	if(this.ipfCcmBoPropertyCasMapper == null){
            this.ipfCcmBoPropertyCasMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoPropertyCasMapper.class);
        }
        return this.ipfCcmBoPropertyCasMapper;
    }
        
    public void setIpfCcmBoPropertyCasMapper(IpfCcmBoPropertyCasMapper ipfCcmBoPropertyCasMapper) {
        this.ipfCcmBoPropertyCasMapper = ipfCcmBoPropertyCasMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoPropertyCasMapper = sqlSessionTemplate.getMapper(IpfCcmBoPropertyCasMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoPropertyCas
     * @return
     */
    public ArrayList<IpfCcmBoPropertyCas> selectWithCondition(IpfCcmBoPropertyCas ipfCcmBoPropertyCas){
        return  ipfCcmBoPropertyCasMapper.selectWithCondition(ipfCcmBoPropertyCas,"");
    }

    /** 按条件查询
     * @param ipfCcmBoPropertyCas
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoPropertyCas> selectWithCondition(IpfCcmBoPropertyCas ipfCcmBoPropertyCas,String conditions){
        return  ipfCcmBoPropertyCasMapper.selectWithCondition(ipfCcmBoPropertyCas,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoPropertyCas> selectBySql(String SqlStr){
        return  ipfCcmBoPropertyCasMapper.selectBySql(SqlStr);
    }
}