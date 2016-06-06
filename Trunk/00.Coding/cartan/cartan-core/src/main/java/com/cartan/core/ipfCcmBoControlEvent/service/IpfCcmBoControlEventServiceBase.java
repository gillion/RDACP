package com.cartan.core.ipfCcmBoControlEvent.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoControlEvent.dao.IpfCcmBoControlEventMapper;
import com.cartan.core.ipfCcmBoControlEvent.domain.IpfCcmBoControlEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoControlEventServiceBase extends BaseService {
    private IpfCcmBoControlEventMapper ipfCcmBoControlEventMapper;
    public IpfCcmBoControlEvent getIpfCcmBoControlEvent(String id){
        return ipfCcmBoControlEventMapper.getIpfCcmBoControlEvent(id);
    }

    public void createIpfCcmBoControlEvent(IpfCcmBoControlEvent ipfCcmBoControlEvent){
    	ipfCcmBoControlEventMapper.createIpfCcmBoControlEvent(ipfCcmBoControlEvent);
    }

    public void deleteIpfCcmBoControlEvent(String id){
    	ipfCcmBoControlEventMapper.deleteIpfCcmBoControlEvent(id);
    }

    public void updateIpfCcmBoControlEvent(IpfCcmBoControlEvent ipfCcmBoControlEvent){
    	ipfCcmBoControlEventMapper.updateIpfCcmBoControlEvent(ipfCcmBoControlEvent);
    }

    public int countAll(){
       return ipfCcmBoControlEventMapper.countAll();
    }

    public ArrayList<IpfCcmBoControlEvent> selectAll(){
      return ipfCcmBoControlEventMapper.selectAll();
    }
    
    public IpfCcmBoControlEventMapper getIpfCcmBoControlEventMapper() {
    	if(this.ipfCcmBoControlEventMapper == null){
            this.ipfCcmBoControlEventMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoControlEventMapper.class);
        }
        return this.ipfCcmBoControlEventMapper;
    }
        
    public void setIpfCcmBoControlEventMapper(IpfCcmBoControlEventMapper ipfCcmBoControlEventMapper) {
        this.ipfCcmBoControlEventMapper = ipfCcmBoControlEventMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoControlEventMapper = sqlSessionTemplate.getMapper(IpfCcmBoControlEventMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoControlEvent
     * @return
     */
    public ArrayList<IpfCcmBoControlEvent> selectWithCondition(IpfCcmBoControlEvent ipfCcmBoControlEvent){
        return  ipfCcmBoControlEventMapper.selectWithCondition(ipfCcmBoControlEvent,"");
    }

    /** 按条件查询
     * @param ipfCcmBoControlEvent
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoControlEvent> selectWithCondition(IpfCcmBoControlEvent ipfCcmBoControlEvent,String conditions){
        return  ipfCcmBoControlEventMapper.selectWithCondition(ipfCcmBoControlEvent,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoControlEvent> selectBySql(String SqlStr){
        return  ipfCcmBoControlEventMapper.selectBySql(SqlStr);
    }
}