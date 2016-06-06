package com.cartan.core.ipfFciLabelDetail.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfFciLabelDetail.dao.IpfFciLabelDetailMapper;
import com.cartan.core.ipfFciLabelDetail.domain.IpfFciLabelDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfFciLabelDetailServiceBase extends BaseService {
    private IpfFciLabelDetailMapper ipfFciLabelDetailMapper;
    public IpfFciLabelDetail getIpfFciLabelDetail(String id){
        return ipfFciLabelDetailMapper.getIpfFciLabelDetail(id);
    }

    public void createIpfFciLabelDetail(IpfFciLabelDetail ipfFciLabelDetail){
    	ipfFciLabelDetailMapper.createIpfFciLabelDetail(ipfFciLabelDetail);
    }

    public void deleteIpfFciLabelDetail(String id){
    	ipfFciLabelDetailMapper.deleteIpfFciLabelDetail(id);
    }

    public void updateIpfFciLabelDetail(IpfFciLabelDetail ipfFciLabelDetail){
    	ipfFciLabelDetailMapper.updateIpfFciLabelDetail(ipfFciLabelDetail);
    }

    public int countAll(){
       return ipfFciLabelDetailMapper.countAll();
    }

    public ArrayList<IpfFciLabelDetail> selectAll(){
      return ipfFciLabelDetailMapper.selectAll();
    }
    
    public IpfFciLabelDetailMapper getIpfFciLabelDetailMapper() {
    	if(this.ipfFciLabelDetailMapper == null){
            this.ipfFciLabelDetailMapper = this.getSqlSessionTemplate().getMapper(IpfFciLabelDetailMapper.class);
        }
        return this.ipfFciLabelDetailMapper;
    }
        
    public void setIpfFciLabelDetailMapper(IpfFciLabelDetailMapper ipfFciLabelDetailMapper) {
        this.ipfFciLabelDetailMapper = ipfFciLabelDetailMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfFciLabelDetailMapper = sqlSessionTemplate.getMapper(IpfFciLabelDetailMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfFciLabelDetail
     * @return
     */
    public ArrayList<IpfFciLabelDetail> selectWithCondition(IpfFciLabelDetail ipfFciLabelDetail){
        return  ipfFciLabelDetailMapper.selectWithCondition(ipfFciLabelDetail,"");
    }

    /** 按条件查询
     * @param ipfFciLabelDetail
     * @conditions
     * @return
     */
    public ArrayList<IpfFciLabelDetail> selectWithCondition(IpfFciLabelDetail ipfFciLabelDetail,String conditions){
        return  ipfFciLabelDetailMapper.selectWithCondition(ipfFciLabelDetail,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfFciLabelDetail> selectBySql(String SqlStr){
        return  ipfFciLabelDetailMapper.selectBySql(SqlStr);
    }
}