package com.cartan.core.ipfCcmBoGridToolbar.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoGridToolbar.dao.IpfCcmBoGridToolbarMapper;
import com.cartan.core.ipfCcmBoGridToolbar.domain.IpfCcmBoGridToolbar;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoGridToolbarServiceBase extends BaseService {
    private IpfCcmBoGridToolbarMapper ipfCcmBoGridToolbarMapper;
    public IpfCcmBoGridToolbar getIpfCcmBoGridToolbar(String id){
        return ipfCcmBoGridToolbarMapper.getIpfCcmBoGridToolbar(id);
    }

    public void createIpfCcmBoGridToolbar(IpfCcmBoGridToolbar ipfCcmBoGridToolbar){
    	ipfCcmBoGridToolbarMapper.createIpfCcmBoGridToolbar(ipfCcmBoGridToolbar);
    }

    public void deleteIpfCcmBoGridToolbar(String id){
    	ipfCcmBoGridToolbarMapper.deleteIpfCcmBoGridToolbar(id);
    }

    public void updateIpfCcmBoGridToolbar(IpfCcmBoGridToolbar ipfCcmBoGridToolbar){
    	ipfCcmBoGridToolbarMapper.updateIpfCcmBoGridToolbar(ipfCcmBoGridToolbar);
    }

    public int countAll(){
       return ipfCcmBoGridToolbarMapper.countAll();
    }

    public ArrayList<IpfCcmBoGridToolbar> selectAll(){
      return ipfCcmBoGridToolbarMapper.selectAll();
    }
    
    public IpfCcmBoGridToolbarMapper getIpfCcmBoGridToolbarMapper() {
    	if(this.ipfCcmBoGridToolbarMapper == null){
            this.ipfCcmBoGridToolbarMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoGridToolbarMapper.class);
        }
        return this.ipfCcmBoGridToolbarMapper;
    }
        
    public void setIpfCcmBoGridToolbarMapper(IpfCcmBoGridToolbarMapper ipfCcmBoGridToolbarMapper) {
        this.ipfCcmBoGridToolbarMapper = ipfCcmBoGridToolbarMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoGridToolbarMapper = sqlSessionTemplate.getMapper(IpfCcmBoGridToolbarMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoGridToolbar
     * @return
     */
    public ArrayList<IpfCcmBoGridToolbar> selectWithCondition(IpfCcmBoGridToolbar ipfCcmBoGridToolbar){
        return  ipfCcmBoGridToolbarMapper.selectWithCondition(ipfCcmBoGridToolbar,"");
    }

    /** 按条件查询
     * @param ipfCcmBoGridToolbar
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoGridToolbar> selectWithCondition(IpfCcmBoGridToolbar ipfCcmBoGridToolbar,String conditions){
        return  ipfCcmBoGridToolbarMapper.selectWithCondition(ipfCcmBoGridToolbar,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoGridToolbar> selectBySql(String SqlStr){
        return  ipfCcmBoGridToolbarMapper.selectBySql(SqlStr);
    }
}