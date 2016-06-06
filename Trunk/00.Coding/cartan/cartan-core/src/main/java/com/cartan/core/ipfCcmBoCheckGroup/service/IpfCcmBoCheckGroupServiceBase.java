package com.cartan.core.ipfCcmBoCheckGroup.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoCheckGroup.dao.IpfCcmBoCheckGroupMapper;
import com.cartan.core.ipfCcmBoCheckGroup.domain.IpfCcmBoCheckGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoCheckGroupServiceBase extends BaseService {
    private IpfCcmBoCheckGroupMapper ipfCcmBoCheckGroupMapper;
    public IpfCcmBoCheckGroup getIpfCcmBoCheckGroup(String id){
        return ipfCcmBoCheckGroupMapper.getIpfCcmBoCheckGroup(id);
    }

    public void createIpfCcmBoCheckGroup(IpfCcmBoCheckGroup ipfCcmBoCheckGroup){
    	ipfCcmBoCheckGroupMapper.createIpfCcmBoCheckGroup(ipfCcmBoCheckGroup);
    }

    public void deleteIpfCcmBoCheckGroup(String id){
    	ipfCcmBoCheckGroupMapper.deleteIpfCcmBoCheckGroup(id);
    }

    public void updateIpfCcmBoCheckGroup(IpfCcmBoCheckGroup ipfCcmBoCheckGroup){
    	ipfCcmBoCheckGroupMapper.updateIpfCcmBoCheckGroup(ipfCcmBoCheckGroup);
    }

    public int countAll(){
       return ipfCcmBoCheckGroupMapper.countAll();
    }

    public ArrayList<IpfCcmBoCheckGroup> selectAll(){
      return ipfCcmBoCheckGroupMapper.selectAll();
    }
    
    public IpfCcmBoCheckGroupMapper getIpfCcmBoCheckGroupMapper() {
    	if(this.ipfCcmBoCheckGroupMapper == null){
            this.ipfCcmBoCheckGroupMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoCheckGroupMapper.class);
        }
        return this.ipfCcmBoCheckGroupMapper;
    }
        
    public void setIpfCcmBoCheckGroupMapper(IpfCcmBoCheckGroupMapper ipfCcmBoCheckGroupMapper) {
        this.ipfCcmBoCheckGroupMapper = ipfCcmBoCheckGroupMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoCheckGroupMapper = sqlSessionTemplate.getMapper(IpfCcmBoCheckGroupMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoCheckGroup
     * @return
     */
    public ArrayList<IpfCcmBoCheckGroup> selectWithCondition(IpfCcmBoCheckGroup ipfCcmBoCheckGroup){
        return  ipfCcmBoCheckGroupMapper.selectWithCondition(ipfCcmBoCheckGroup,"");
    }

    /** 按条件查询
     * @param ipfCcmBoCheckGroup
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoCheckGroup> selectWithCondition(IpfCcmBoCheckGroup ipfCcmBoCheckGroup,String conditions){
        return  ipfCcmBoCheckGroupMapper.selectWithCondition(ipfCcmBoCheckGroup,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoCheckGroup> selectBySql(String SqlStr){
        return  ipfCcmBoCheckGroupMapper.selectBySql(SqlStr);
    }
}