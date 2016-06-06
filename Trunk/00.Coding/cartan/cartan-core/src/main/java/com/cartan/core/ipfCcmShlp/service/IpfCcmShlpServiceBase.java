package com.cartan.core.ipfCcmShlp.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmShlp.dao.IpfCcmShlpMapper;
import com.cartan.core.ipfCcmShlp.domain.IpfCcmShlp;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmShlpServiceBase extends BaseService {
    private IpfCcmShlpMapper ipfCcmShlpMapper;
    public IpfCcmShlp getIpfCcmShlp(String id){
        return ipfCcmShlpMapper.getIpfCcmShlp(id);
    }

    public void createIpfCcmShlp(IpfCcmShlp ipfCcmShlp){
    	ipfCcmShlpMapper.createIpfCcmShlp(ipfCcmShlp);
    }

    public void deleteIpfCcmShlp(String id){
    	ipfCcmShlpMapper.deleteIpfCcmShlp(id);
    }

    public void updateIpfCcmShlp(IpfCcmShlp ipfCcmShlp){
    	ipfCcmShlpMapper.updateIpfCcmShlp(ipfCcmShlp);
    }

    public int countAll(){
       return ipfCcmShlpMapper.countAll();
    }

    public ArrayList<IpfCcmShlp> selectAll(){
      return ipfCcmShlpMapper.selectAll();
    }
    
    public IpfCcmShlpMapper getIpfCcmShlpMapper() {
    	if(this.ipfCcmShlpMapper == null){
            this.ipfCcmShlpMapper = this.getSqlSessionTemplate().getMapper(IpfCcmShlpMapper.class);
        }
        return this.ipfCcmShlpMapper;
    }
        
    public void setIpfCcmShlpMapper(IpfCcmShlpMapper ipfCcmShlpMapper) {
        this.ipfCcmShlpMapper = ipfCcmShlpMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmShlpMapper = sqlSessionTemplate.getMapper(IpfCcmShlpMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmShlp
     * @return
     */
    public ArrayList<IpfCcmShlp> selectWithCondition(IpfCcmShlp ipfCcmShlp){
        return  ipfCcmShlpMapper.selectWithCondition(ipfCcmShlp,"");
    }

    /** 按条件查询
     * @param ipfCcmShlp
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmShlp> selectWithCondition(IpfCcmShlp ipfCcmShlp,String conditions){
        return  ipfCcmShlpMapper.selectWithCondition(ipfCcmShlp,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmShlp> selectBySql(String SqlStr){
        return  ipfCcmShlpMapper.selectBySql(SqlStr);
    }
}