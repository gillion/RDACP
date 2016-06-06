package com.cartan.core.ipfCcmBoPage.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoPage.dao.IpfCcmBoPageMapper;
import com.cartan.core.ipfCcmBoPage.domain.IpfCcmBoPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoPageServiceBase extends BaseService {
    private IpfCcmBoPageMapper ipfCcmBoPageMapper;
    public IpfCcmBoPage getIpfCcmBoPage(String id){
        return ipfCcmBoPageMapper.getIpfCcmBoPage(id);
    }

    public void createIpfCcmBoPage(IpfCcmBoPage ipfCcmBoPage){
    	ipfCcmBoPageMapper.createIpfCcmBoPage(ipfCcmBoPage);
    }

    public void deleteIpfCcmBoPage(String id){
    	ipfCcmBoPageMapper.deleteIpfCcmBoPage(id);
    }

    public void updateIpfCcmBoPage(IpfCcmBoPage ipfCcmBoPage){
    	ipfCcmBoPageMapper.updateIpfCcmBoPage(ipfCcmBoPage);
    }

    public int countAll(){
       return ipfCcmBoPageMapper.countAll();
    }

    public ArrayList<IpfCcmBoPage> selectAll(){
      return ipfCcmBoPageMapper.selectAll();
    }
    
    public IpfCcmBoPageMapper getIpfCcmBoPageMapper() {
    	if(this.ipfCcmBoPageMapper == null){
            this.ipfCcmBoPageMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoPageMapper.class);
        }
        return this.ipfCcmBoPageMapper;
    }
        
    public void setIpfCcmBoPageMapper(IpfCcmBoPageMapper ipfCcmBoPageMapper) {
        this.ipfCcmBoPageMapper = ipfCcmBoPageMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoPageMapper = sqlSessionTemplate.getMapper(IpfCcmBoPageMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoPage
     * @return
     */
    public ArrayList<IpfCcmBoPage> selectWithCondition(IpfCcmBoPage ipfCcmBoPage){
        return  ipfCcmBoPageMapper.selectWithCondition(ipfCcmBoPage,"");
    }

    /** 按条件查询
     * @param ipfCcmBoPage
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoPage> selectWithCondition(IpfCcmBoPage ipfCcmBoPage,String conditions){
        return  ipfCcmBoPageMapper.selectWithCondition(ipfCcmBoPage,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoPage> selectBySql(String SqlStr){
        return  ipfCcmBoPageMapper.selectBySql(SqlStr);
    }
}