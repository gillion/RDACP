package com.cartan.core.ipfRuleFilterDetail.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfRuleFilterDetail.dao.IpfRuleFilterDetailMapper;
import com.cartan.core.ipfRuleFilterDetail.domain.IpfRuleFilterDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfRuleFilterDetailServiceBase extends BaseService {
    private IpfRuleFilterDetailMapper ipfRuleFilterDetailMapper;
    public IpfRuleFilterDetail getIpfRuleFilterDetail(String id){
        return ipfRuleFilterDetailMapper.getIpfRuleFilterDetail(id);
    }

    public void createIpfRuleFilterDetail(IpfRuleFilterDetail ipfRuleFilterDetail){
    	ipfRuleFilterDetailMapper.createIpfRuleFilterDetail(ipfRuleFilterDetail);
    }

    public void deleteIpfRuleFilterDetail(String id){
    	ipfRuleFilterDetailMapper.deleteIpfRuleFilterDetail(id);
    }

    public void updateIpfRuleFilterDetail(IpfRuleFilterDetail ipfRuleFilterDetail){
    	ipfRuleFilterDetailMapper.updateIpfRuleFilterDetail(ipfRuleFilterDetail);
    }

    public int countAll(){
       return ipfRuleFilterDetailMapper.countAll();
    }

    public ArrayList<IpfRuleFilterDetail> selectAll(){
      return ipfRuleFilterDetailMapper.selectAll();
    }
    
    public IpfRuleFilterDetailMapper getIpfRuleFilterDetailMapper() {
    	if(this.ipfRuleFilterDetailMapper == null){
            this.ipfRuleFilterDetailMapper = this.getSqlSessionTemplate().getMapper(IpfRuleFilterDetailMapper.class);
        }
        return this.ipfRuleFilterDetailMapper;
    }
        
    public void setIpfRuleFilterDetailMapper(IpfRuleFilterDetailMapper ipfRuleFilterDetailMapper) {
        this.ipfRuleFilterDetailMapper = ipfRuleFilterDetailMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfRuleFilterDetailMapper = sqlSessionTemplate.getMapper(IpfRuleFilterDetailMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfRuleFilterDetail
     * @return
     */
    public ArrayList<IpfRuleFilterDetail> selectWithCondition(IpfRuleFilterDetail ipfRuleFilterDetail){
        return  ipfRuleFilterDetailMapper.selectWithCondition(ipfRuleFilterDetail,"");
    }

    /** 按条件查询
     * @param ipfRuleFilterDetail
     * @conditions
     * @return
     */
    public ArrayList<IpfRuleFilterDetail> selectWithCondition(IpfRuleFilterDetail ipfRuleFilterDetail,String conditions){
        return  ipfRuleFilterDetailMapper.selectWithCondition(ipfRuleFilterDetail,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfRuleFilterDetail> selectBySql(String SqlStr){
        return  ipfRuleFilterDetailMapper.selectBySql(SqlStr);
    }
}