package com.cartan.core.ipfCcmBoPgLoElement.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoPgLoElement.dao.IpfCcmBoPgLoElementMapper;
import com.cartan.core.ipfCcmBoPgLoElement.domain.IpfCcmBoPgLoElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoPgLoElementServiceBase extends BaseService {
    private IpfCcmBoPgLoElementMapper ipfCcmBoPgLoElementMapper;
    public IpfCcmBoPgLoElement getIpfCcmBoPgLoElement(String id){
        return ipfCcmBoPgLoElementMapper.getIpfCcmBoPgLoElement(id);
    }

    public void createIpfCcmBoPgLoElement(IpfCcmBoPgLoElement ipfCcmBoPgLoElement){
    	ipfCcmBoPgLoElementMapper.createIpfCcmBoPgLoElement(ipfCcmBoPgLoElement);
    }

    public void deleteIpfCcmBoPgLoElement(String id){
    	ipfCcmBoPgLoElementMapper.deleteIpfCcmBoPgLoElement(id);
    }

    public void updateIpfCcmBoPgLoElement(IpfCcmBoPgLoElement ipfCcmBoPgLoElement){
    	ipfCcmBoPgLoElementMapper.updateIpfCcmBoPgLoElement(ipfCcmBoPgLoElement);
    }

    public int countAll(){
       return ipfCcmBoPgLoElementMapper.countAll();
    }

    public ArrayList<IpfCcmBoPgLoElement> selectAll(){
      return ipfCcmBoPgLoElementMapper.selectAll();
    }
    
    public IpfCcmBoPgLoElementMapper getIpfCcmBoPgLoElementMapper() {
    	if(this.ipfCcmBoPgLoElementMapper == null){
            this.ipfCcmBoPgLoElementMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoPgLoElementMapper.class);
        }
        return this.ipfCcmBoPgLoElementMapper;
    }
        
    public void setIpfCcmBoPgLoElementMapper(IpfCcmBoPgLoElementMapper ipfCcmBoPgLoElementMapper) {
        this.ipfCcmBoPgLoElementMapper = ipfCcmBoPgLoElementMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoPgLoElementMapper = sqlSessionTemplate.getMapper(IpfCcmBoPgLoElementMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoPgLoElement
     * @return
     */
    public ArrayList<IpfCcmBoPgLoElement> selectWithCondition(IpfCcmBoPgLoElement ipfCcmBoPgLoElement){
        return  ipfCcmBoPgLoElementMapper.selectWithCondition(ipfCcmBoPgLoElement,"");
    }

    /** 按条件查询
     * @param ipfCcmBoPgLoElement
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoPgLoElement> selectWithCondition(IpfCcmBoPgLoElement ipfCcmBoPgLoElement,String conditions){
        return  ipfCcmBoPgLoElementMapper.selectWithCondition(ipfCcmBoPgLoElement,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoPgLoElement> selectBySql(String SqlStr){
        return  ipfCcmBoPgLoElementMapper.selectBySql(SqlStr);
    }
}