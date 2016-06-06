package com.cartan.core.ipfDmlScriptPublish.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlScriptPublish.dao.IpfDmlScriptPublishMapper;
import com.cartan.core.ipfDmlScriptPublish.domain.IpfDmlScriptPublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlScriptPublishServiceBase extends BaseService {
    private IpfDmlScriptPublishMapper ipfDmlScriptPublishMapper;
    public IpfDmlScriptPublish getIpfDmlScriptPublish(String id){
        return ipfDmlScriptPublishMapper.getIpfDmlScriptPublish(id);
    }

    public void createIpfDmlScriptPublish(IpfDmlScriptPublish ipfDmlScriptPublish){
    	ipfDmlScriptPublishMapper.createIpfDmlScriptPublish(ipfDmlScriptPublish);
    }

    public void deleteIpfDmlScriptPublish(String id){
    	ipfDmlScriptPublishMapper.deleteIpfDmlScriptPublish(id);
    }

    public void updateIpfDmlScriptPublish(IpfDmlScriptPublish ipfDmlScriptPublish){
    	ipfDmlScriptPublishMapper.updateIpfDmlScriptPublish(ipfDmlScriptPublish);
    }

    public int countAll(){
       return ipfDmlScriptPublishMapper.countAll();
    }

    public ArrayList<IpfDmlScriptPublish> selectAll(){
      return ipfDmlScriptPublishMapper.selectAll();
    }
    
    public IpfDmlScriptPublishMapper getIpfDmlScriptPublishMapper() {
    	if(this.ipfDmlScriptPublishMapper == null){
            this.ipfDmlScriptPublishMapper = this.getSqlSessionTemplate().getMapper(IpfDmlScriptPublishMapper.class);
        }
        return this.ipfDmlScriptPublishMapper;
    }
        
    public void setIpfDmlScriptPublishMapper(IpfDmlScriptPublishMapper ipfDmlScriptPublishMapper) {
        this.ipfDmlScriptPublishMapper = ipfDmlScriptPublishMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlScriptPublishMapper = sqlSessionTemplate.getMapper(IpfDmlScriptPublishMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlScriptPublish
     * @return
     */
    public ArrayList<IpfDmlScriptPublish> selectWithCondition(IpfDmlScriptPublish ipfDmlScriptPublish){
        return  ipfDmlScriptPublishMapper.selectWithCondition(ipfDmlScriptPublish,"");
    }

    /** 按条件查询
     * @param ipfDmlScriptPublish
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlScriptPublish> selectWithCondition(IpfDmlScriptPublish ipfDmlScriptPublish,String conditions){
        return  ipfDmlScriptPublishMapper.selectWithCondition(ipfDmlScriptPublish,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlScriptPublish> selectBySql(String SqlStr){
        return  ipfDmlScriptPublishMapper.selectBySql(SqlStr);
    }
}