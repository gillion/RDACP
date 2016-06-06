package com.cartan.core.ipfCcmBoCheckRelGroup.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoCheckRelGroup.dao.IpfCcmBoCheckRelGroupMapper;
import com.cartan.core.ipfCcmBoCheckRelGroup.domain.IpfCcmBoCheckRelGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoCheckRelGroupServiceBase extends BaseService {
    private IpfCcmBoCheckRelGroupMapper ipfCcmBoCheckRelGroupMapper;
    public IpfCcmBoCheckRelGroup getIpfCcmBoCheckRelGroup(String id){
        return ipfCcmBoCheckRelGroupMapper.getIpfCcmBoCheckRelGroup(id);
    }

    public void createIpfCcmBoCheckRelGroup(IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup){
    	ipfCcmBoCheckRelGroupMapper.createIpfCcmBoCheckRelGroup(ipfCcmBoCheckRelGroup);
    }

    public void deleteIpfCcmBoCheckRelGroup(String id){
    	ipfCcmBoCheckRelGroupMapper.deleteIpfCcmBoCheckRelGroup(id);
    }

    public void updateIpfCcmBoCheckRelGroup(IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup){
    	ipfCcmBoCheckRelGroupMapper.updateIpfCcmBoCheckRelGroup(ipfCcmBoCheckRelGroup);
    }

    public int countAll(){
       return ipfCcmBoCheckRelGroupMapper.countAll();
    }

    public ArrayList<IpfCcmBoCheckRelGroup> selectAll(){
      return ipfCcmBoCheckRelGroupMapper.selectAll();
    }
    
    public IpfCcmBoCheckRelGroupMapper getIpfCcmBoCheckRelGroupMapper() {
    	if(this.ipfCcmBoCheckRelGroupMapper == null){
            this.ipfCcmBoCheckRelGroupMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoCheckRelGroupMapper.class);
        }
        return this.ipfCcmBoCheckRelGroupMapper;
    }
        
    public void setIpfCcmBoCheckRelGroupMapper(IpfCcmBoCheckRelGroupMapper ipfCcmBoCheckRelGroupMapper) {
        this.ipfCcmBoCheckRelGroupMapper = ipfCcmBoCheckRelGroupMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoCheckRelGroupMapper = sqlSessionTemplate.getMapper(IpfCcmBoCheckRelGroupMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoCheckRelGroup
     * @return
     */
    public ArrayList<IpfCcmBoCheckRelGroup> selectWithCondition(IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup){
        return  ipfCcmBoCheckRelGroupMapper.selectWithCondition(ipfCcmBoCheckRelGroup,"");
    }

    /** 按条件查询
     * @param ipfCcmBoCheckRelGroup
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoCheckRelGroup> selectWithCondition(IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup,String conditions){
        return  ipfCcmBoCheckRelGroupMapper.selectWithCondition(ipfCcmBoCheckRelGroup,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoCheckRelGroup> selectBySql(String SqlStr){
        return  ipfCcmBoCheckRelGroupMapper.selectBySql(SqlStr);
    }
}