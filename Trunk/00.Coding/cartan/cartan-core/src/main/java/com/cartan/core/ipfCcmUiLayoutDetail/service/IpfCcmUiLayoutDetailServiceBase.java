package com.cartan.core.ipfCcmUiLayoutDetail.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmUiLayoutDetail.dao.IpfCcmUiLayoutDetailMapper;
import com.cartan.core.ipfCcmUiLayoutDetail.domain.IpfCcmUiLayoutDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmUiLayoutDetailServiceBase extends BaseService {
    private IpfCcmUiLayoutDetailMapper ipfCcmUiLayoutDetailMapper;
    public IpfCcmUiLayoutDetail getIpfCcmUiLayoutDetail(String id){
        return ipfCcmUiLayoutDetailMapper.getIpfCcmUiLayoutDetail(id);
    }

    public void createIpfCcmUiLayoutDetail(IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail){
    	ipfCcmUiLayoutDetailMapper.createIpfCcmUiLayoutDetail(ipfCcmUiLayoutDetail);
    }

    public void deleteIpfCcmUiLayoutDetail(String id){
    	ipfCcmUiLayoutDetailMapper.deleteIpfCcmUiLayoutDetail(id);
    }

    public void updateIpfCcmUiLayoutDetail(IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail){
    	ipfCcmUiLayoutDetailMapper.updateIpfCcmUiLayoutDetail(ipfCcmUiLayoutDetail);
    }

    public int countAll(){
       return ipfCcmUiLayoutDetailMapper.countAll();
    }

    public ArrayList<IpfCcmUiLayoutDetail> selectAll(){
      return ipfCcmUiLayoutDetailMapper.selectAll();
    }
    
    public IpfCcmUiLayoutDetailMapper getIpfCcmUiLayoutDetailMapper() {
    	if(this.ipfCcmUiLayoutDetailMapper == null){
            this.ipfCcmUiLayoutDetailMapper = this.getSqlSessionTemplate().getMapper(IpfCcmUiLayoutDetailMapper.class);
        }
        return this.ipfCcmUiLayoutDetailMapper;
    }
        
    public void setIpfCcmUiLayoutDetailMapper(IpfCcmUiLayoutDetailMapper ipfCcmUiLayoutDetailMapper) {
        this.ipfCcmUiLayoutDetailMapper = ipfCcmUiLayoutDetailMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmUiLayoutDetailMapper = sqlSessionTemplate.getMapper(IpfCcmUiLayoutDetailMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmUiLayoutDetail
     * @return
     */
    public ArrayList<IpfCcmUiLayoutDetail> selectWithCondition(IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail){
        return  ipfCcmUiLayoutDetailMapper.selectWithCondition(ipfCcmUiLayoutDetail,"");
    }

    /** 按条件查询
     * @param ipfCcmUiLayoutDetail
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmUiLayoutDetail> selectWithCondition(IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail,String conditions){
        return  ipfCcmUiLayoutDetailMapper.selectWithCondition(ipfCcmUiLayoutDetail,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmUiLayoutDetail> selectBySql(String SqlStr){
        return  ipfCcmUiLayoutDetailMapper.selectBySql(SqlStr);
    }
}