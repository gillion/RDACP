package com.cartan.core.ipfRuleRotateDetail.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfRuleRotateDetail.dao.IpfRuleRotateDetailMapper;
import com.cartan.core.ipfRuleRotateDetail.domain.IpfRuleRotateDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfRuleRotateDetailServiceBase extends BaseService {
    private IpfRuleRotateDetailMapper ipfRuleRotateDetailMapper;
    public IpfRuleRotateDetail getIpfRuleRotateDetail(String id){
        return ipfRuleRotateDetailMapper.getIpfRuleRotateDetail(id);
    }

    public void createIpfRuleRotateDetail(IpfRuleRotateDetail ipfRuleRotateDetail){
    	ipfRuleRotateDetailMapper.createIpfRuleRotateDetail(ipfRuleRotateDetail);
    }

    public void deleteIpfRuleRotateDetail(String id){
    	ipfRuleRotateDetailMapper.deleteIpfRuleRotateDetail(id);
    }

    public void updateIpfRuleRotateDetail(IpfRuleRotateDetail ipfRuleRotateDetail){
    	ipfRuleRotateDetailMapper.updateIpfRuleRotateDetail(ipfRuleRotateDetail);
    }

    public int countAll(){
       return ipfRuleRotateDetailMapper.countAll();
    }

    public ArrayList<IpfRuleRotateDetail> selectAll(){
      return ipfRuleRotateDetailMapper.selectAll();
    }
    
    public IpfRuleRotateDetailMapper getIpfRuleRotateDetailMapper() {
    	if(this.ipfRuleRotateDetailMapper == null){
            this.ipfRuleRotateDetailMapper = this.getSqlSessionTemplate().getMapper(IpfRuleRotateDetailMapper.class);
        }
        return this.ipfRuleRotateDetailMapper;
    }
        
    public void setIpfRuleRotateDetailMapper(IpfRuleRotateDetailMapper ipfRuleRotateDetailMapper) {
        this.ipfRuleRotateDetailMapper = ipfRuleRotateDetailMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfRuleRotateDetailMapper = sqlSessionTemplate.getMapper(IpfRuleRotateDetailMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfRuleRotateDetail
     * @return
     */
    public ArrayList<IpfRuleRotateDetail> selectWithCondition(IpfRuleRotateDetail ipfRuleRotateDetail){
        return  ipfRuleRotateDetailMapper.selectWithCondition(ipfRuleRotateDetail,"");
    }

    /** 按条件查询
     * @param ipfRuleRotateDetail
     * @conditions
     * @return
     */
    public ArrayList<IpfRuleRotateDetail> selectWithCondition(IpfRuleRotateDetail ipfRuleRotateDetail,String conditions){
        return  ipfRuleRotateDetailMapper.selectWithCondition(ipfRuleRotateDetail,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfRuleRotateDetail> selectBySql(String SqlStr){
        return  ipfRuleRotateDetailMapper.selectBySql(SqlStr);
    }
}