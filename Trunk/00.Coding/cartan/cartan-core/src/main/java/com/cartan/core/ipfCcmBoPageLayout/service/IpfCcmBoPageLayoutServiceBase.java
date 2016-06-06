package com.cartan.core.ipfCcmBoPageLayout.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoPageLayout.dao.IpfCcmBoPageLayoutMapper;
import com.cartan.core.ipfCcmBoPageLayout.domain.IpfCcmBoPageLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoPageLayoutServiceBase extends BaseService {
    private IpfCcmBoPageLayoutMapper ipfCcmBoPageLayoutMapper;
    public IpfCcmBoPageLayout getIpfCcmBoPageLayout(String id){
        return ipfCcmBoPageLayoutMapper.getIpfCcmBoPageLayout(id);
    }

    public void createIpfCcmBoPageLayout(IpfCcmBoPageLayout ipfCcmBoPageLayout){
    	ipfCcmBoPageLayoutMapper.createIpfCcmBoPageLayout(ipfCcmBoPageLayout);
    }

    public void deleteIpfCcmBoPageLayout(String id){
    	ipfCcmBoPageLayoutMapper.deleteIpfCcmBoPageLayout(id);
    }

    public void updateIpfCcmBoPageLayout(IpfCcmBoPageLayout ipfCcmBoPageLayout){
    	ipfCcmBoPageLayoutMapper.updateIpfCcmBoPageLayout(ipfCcmBoPageLayout);
    }

    public int countAll(){
       return ipfCcmBoPageLayoutMapper.countAll();
    }

    public ArrayList<IpfCcmBoPageLayout> selectAll(){
      return ipfCcmBoPageLayoutMapper.selectAll();
    }
    
    public IpfCcmBoPageLayoutMapper getIpfCcmBoPageLayoutMapper() {
    	if(this.ipfCcmBoPageLayoutMapper == null){
            this.ipfCcmBoPageLayoutMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoPageLayoutMapper.class);
        }
        return this.ipfCcmBoPageLayoutMapper;
    }
        
    public void setIpfCcmBoPageLayoutMapper(IpfCcmBoPageLayoutMapper ipfCcmBoPageLayoutMapper) {
        this.ipfCcmBoPageLayoutMapper = ipfCcmBoPageLayoutMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoPageLayoutMapper = sqlSessionTemplate.getMapper(IpfCcmBoPageLayoutMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoPageLayout
     * @return
     */
    public ArrayList<IpfCcmBoPageLayout> selectWithCondition(IpfCcmBoPageLayout ipfCcmBoPageLayout){
        return  ipfCcmBoPageLayoutMapper.selectWithCondition(ipfCcmBoPageLayout,"");
    }

    /** 按条件查询
     * @param ipfCcmBoPageLayout
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoPageLayout> selectWithCondition(IpfCcmBoPageLayout ipfCcmBoPageLayout,String conditions){
        return  ipfCcmBoPageLayoutMapper.selectWithCondition(ipfCcmBoPageLayout,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoPageLayout> selectBySql(String SqlStr){
        return  ipfCcmBoPageLayoutMapper.selectBySql(SqlStr);
    }
}