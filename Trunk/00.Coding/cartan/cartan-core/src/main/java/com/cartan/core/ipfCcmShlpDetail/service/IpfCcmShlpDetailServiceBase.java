package com.cartan.core.ipfCcmShlpDetail.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmShlpDetail.dao.IpfCcmShlpDetailMapper;
import com.cartan.core.ipfCcmShlpDetail.domain.IpfCcmShlpDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmShlpDetailServiceBase extends BaseService {
    private IpfCcmShlpDetailMapper ipfCcmShlpDetailMapper;
    public IpfCcmShlpDetail getIpfCcmShlpDetail(String id){
        return ipfCcmShlpDetailMapper.getIpfCcmShlpDetail(id);
    }

    public void createIpfCcmShlpDetail(IpfCcmShlpDetail ipfCcmShlpDetail){
    	ipfCcmShlpDetailMapper.createIpfCcmShlpDetail(ipfCcmShlpDetail);
    }

    public void deleteIpfCcmShlpDetail(String id){
    	ipfCcmShlpDetailMapper.deleteIpfCcmShlpDetail(id);
    }

    public void updateIpfCcmShlpDetail(IpfCcmShlpDetail ipfCcmShlpDetail){
    	ipfCcmShlpDetailMapper.updateIpfCcmShlpDetail(ipfCcmShlpDetail);
    }

    public int countAll(){
       return ipfCcmShlpDetailMapper.countAll();
    }

    public ArrayList<IpfCcmShlpDetail> selectAll(){
      return ipfCcmShlpDetailMapper.selectAll();
    }
    
    public IpfCcmShlpDetailMapper getIpfCcmShlpDetailMapper() {
    	if(this.ipfCcmShlpDetailMapper == null){
            this.ipfCcmShlpDetailMapper = this.getSqlSessionTemplate().getMapper(IpfCcmShlpDetailMapper.class);
        }
        return this.ipfCcmShlpDetailMapper;
    }
        
    public void setIpfCcmShlpDetailMapper(IpfCcmShlpDetailMapper ipfCcmShlpDetailMapper) {
        this.ipfCcmShlpDetailMapper = ipfCcmShlpDetailMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmShlpDetailMapper = sqlSessionTemplate.getMapper(IpfCcmShlpDetailMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmShlpDetail
     * @return
     */
    public ArrayList<IpfCcmShlpDetail> selectWithCondition(IpfCcmShlpDetail ipfCcmShlpDetail){
        return  ipfCcmShlpDetailMapper.selectWithCondition(ipfCcmShlpDetail,"");
    }

    /** 按条件查询
     * @param ipfCcmShlpDetail
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmShlpDetail> selectWithCondition(IpfCcmShlpDetail ipfCcmShlpDetail,String conditions){
        return  ipfCcmShlpDetailMapper.selectWithCondition(ipfCcmShlpDetail,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmShlpDetail> selectBySql(String SqlStr){
        return  ipfCcmShlpDetailMapper.selectBySql(SqlStr);
    }
}