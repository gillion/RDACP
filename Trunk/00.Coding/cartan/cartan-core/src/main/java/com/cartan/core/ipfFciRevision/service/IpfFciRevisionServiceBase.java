package com.cartan.core.ipfFciRevision.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfFciRevision.dao.IpfFciRevisionMapper;
import com.cartan.core.ipfFciRevision.domain.IpfFciRevision;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfFciRevisionServiceBase extends BaseService {
    private IpfFciRevisionMapper ipfFciRevisionMapper;
    public IpfFciRevision getIpfFciRevision(String id){
        return ipfFciRevisionMapper.getIpfFciRevision(id);
    }

    public void createIpfFciRevision(IpfFciRevision ipfFciRevision){
    	ipfFciRevisionMapper.createIpfFciRevision(ipfFciRevision);
    }

    public void deleteIpfFciRevision(String id){
    	ipfFciRevisionMapper.deleteIpfFciRevision(id);
    }

    public void updateIpfFciRevision(IpfFciRevision ipfFciRevision){
    	ipfFciRevisionMapper.updateIpfFciRevision(ipfFciRevision);
    }

    public int countAll(){
       return ipfFciRevisionMapper.countAll();
    }

    public ArrayList<IpfFciRevision> selectAll(){
      return ipfFciRevisionMapper.selectAll();
    }
    
    public IpfFciRevisionMapper getIpfFciRevisionMapper() {
    	if(this.ipfFciRevisionMapper == null){
            this.ipfFciRevisionMapper = this.getSqlSessionTemplate().getMapper(IpfFciRevisionMapper.class);
        }
        return this.ipfFciRevisionMapper;
    }
        
    public void setIpfFciRevisionMapper(IpfFciRevisionMapper ipfFciRevisionMapper) {
        this.ipfFciRevisionMapper = ipfFciRevisionMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfFciRevisionMapper = sqlSessionTemplate.getMapper(IpfFciRevisionMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfFciRevision
     * @return
     */
    public ArrayList<IpfFciRevision> selectWithCondition(IpfFciRevision ipfFciRevision){
        return  ipfFciRevisionMapper.selectWithCondition(ipfFciRevision,"");
    }

    /** 按条件查询
     * @param ipfFciRevision
     * @conditions
     * @return
     */
    public ArrayList<IpfFciRevision> selectWithCondition(IpfFciRevision ipfFciRevision,String conditions){
        return  ipfFciRevisionMapper.selectWithCondition(ipfFciRevision,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfFciRevision> selectBySql(String SqlStr){
        return  ipfFciRevisionMapper.selectBySql(SqlStr);
    }
}