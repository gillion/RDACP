package com.cartan.core.ipfDmlElement.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlElement.dao.IpfDmlElementMapper;
import com.cartan.core.ipfDmlElement.domain.IpfDmlElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlElementServiceBase extends BaseService {
    private IpfDmlElementMapper ipfDmlElementMapper;
    public IpfDmlElement getIpfDmlElement(String id){
        return ipfDmlElementMapper.getIpfDmlElement(id);
    }

    public void createIpfDmlElement(IpfDmlElement ipfDmlElement){
    	ipfDmlElementMapper.createIpfDmlElement(ipfDmlElement);
    }

    public void deleteIpfDmlElement(String id){
    	ipfDmlElementMapper.deleteIpfDmlElement(id);
    }

    public void updateIpfDmlElement(IpfDmlElement ipfDmlElement){
    	ipfDmlElementMapper.updateIpfDmlElement(ipfDmlElement);
    }

    public int countAll(){
       return ipfDmlElementMapper.countAll();
    }

    public ArrayList<IpfDmlElement> selectAll(){
      return ipfDmlElementMapper.selectAll();
    }
    
    public IpfDmlElementMapper getIpfDmlElementMapper() {
    	if(this.ipfDmlElementMapper == null){
            this.ipfDmlElementMapper = this.getSqlSessionTemplate().getMapper(IpfDmlElementMapper.class);
        }
        return this.ipfDmlElementMapper;
    }
        
    public void setIpfDmlElementMapper(IpfDmlElementMapper ipfDmlElementMapper) {
        this.ipfDmlElementMapper = ipfDmlElementMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlElementMapper = sqlSessionTemplate.getMapper(IpfDmlElementMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlElement
     * @return
     */
    public ArrayList<IpfDmlElement> selectWithCondition(IpfDmlElement ipfDmlElement){
        return  ipfDmlElementMapper.selectWithCondition(ipfDmlElement,"");
    }

    /** 按条件查询
     * @param ipfDmlElement
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlElement> selectWithCondition(IpfDmlElement ipfDmlElement,String conditions){
        return  ipfDmlElementMapper.selectWithCondition(ipfDmlElement,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlElement> selectBySql(String SqlStr){
        return  ipfDmlElementMapper.selectBySql(SqlStr);
    }
}