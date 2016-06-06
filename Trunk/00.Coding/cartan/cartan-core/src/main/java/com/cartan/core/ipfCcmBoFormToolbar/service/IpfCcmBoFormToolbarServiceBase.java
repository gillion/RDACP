package com.cartan.core.ipfCcmBoFormToolbar.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoFormToolbar.dao.IpfCcmBoFormToolbarMapper;
import com.cartan.core.ipfCcmBoFormToolbar.domain.IpfCcmBoFormToolbar;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoFormToolbarServiceBase extends BaseService {
    private IpfCcmBoFormToolbarMapper ipfCcmBoFormToolbarMapper;
    public IpfCcmBoFormToolbar getIpfCcmBoFormToolbar(String id){
        return ipfCcmBoFormToolbarMapper.getIpfCcmBoFormToolbar(id);
    }

    public void createIpfCcmBoFormToolbar(IpfCcmBoFormToolbar ipfCcmBoFormToolbar){
    	ipfCcmBoFormToolbarMapper.createIpfCcmBoFormToolbar(ipfCcmBoFormToolbar);
    }

    public void deleteIpfCcmBoFormToolbar(String id){
    	ipfCcmBoFormToolbarMapper.deleteIpfCcmBoFormToolbar(id);
    }

    public void updateIpfCcmBoFormToolbar(IpfCcmBoFormToolbar ipfCcmBoFormToolbar){
    	ipfCcmBoFormToolbarMapper.updateIpfCcmBoFormToolbar(ipfCcmBoFormToolbar);
    }

    public int countAll(){
       return ipfCcmBoFormToolbarMapper.countAll();
    }

    public ArrayList<IpfCcmBoFormToolbar> selectAll(){
      return ipfCcmBoFormToolbarMapper.selectAll();
    }
    
    public IpfCcmBoFormToolbarMapper getIpfCcmBoFormToolbarMapper() {
    	if(this.ipfCcmBoFormToolbarMapper == null){
            this.ipfCcmBoFormToolbarMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoFormToolbarMapper.class);
        }
        return this.ipfCcmBoFormToolbarMapper;
    }
        
    public void setIpfCcmBoFormToolbarMapper(IpfCcmBoFormToolbarMapper ipfCcmBoFormToolbarMapper) {
        this.ipfCcmBoFormToolbarMapper = ipfCcmBoFormToolbarMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoFormToolbarMapper = sqlSessionTemplate.getMapper(IpfCcmBoFormToolbarMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoFormToolbar
     * @return
     */
    public ArrayList<IpfCcmBoFormToolbar> selectWithCondition(IpfCcmBoFormToolbar ipfCcmBoFormToolbar){
        return  ipfCcmBoFormToolbarMapper.selectWithCondition(ipfCcmBoFormToolbar,"");
    }

    /** 按条件查询
     * @param ipfCcmBoFormToolbar
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoFormToolbar> selectWithCondition(IpfCcmBoFormToolbar ipfCcmBoFormToolbar,String conditions){
        return  ipfCcmBoFormToolbarMapper.selectWithCondition(ipfCcmBoFormToolbar,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoFormToolbar> selectBySql(String SqlStr){
        return  ipfCcmBoFormToolbarMapper.selectBySql(SqlStr);
    }
}