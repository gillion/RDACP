package com.cartan.core.ipfCcmBoMethod.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoMethod.dao.IpfCcmBoMethodMapper;
import com.cartan.core.ipfCcmBoMethod.domain.IpfCcmBoMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoMethodServiceBase extends BaseService {
    private IpfCcmBoMethodMapper ipfCcmBoMethodMapper;
    public IpfCcmBoMethod getIpfCcmBoMethod(String id){
        return ipfCcmBoMethodMapper.getIpfCcmBoMethod(id);
    }

    public void createIpfCcmBoMethod(IpfCcmBoMethod ipfCcmBoMethod){
    	ipfCcmBoMethodMapper.createIpfCcmBoMethod(ipfCcmBoMethod);
    }

    public void deleteIpfCcmBoMethod(String id){
    	ipfCcmBoMethodMapper.deleteIpfCcmBoMethod(id);
    }

    public void updateIpfCcmBoMethod(IpfCcmBoMethod ipfCcmBoMethod){
    	ipfCcmBoMethodMapper.updateIpfCcmBoMethod(ipfCcmBoMethod);
    }

    public int countAll(){
       return ipfCcmBoMethodMapper.countAll();
    }

    public ArrayList<IpfCcmBoMethod> selectAll(){
      return ipfCcmBoMethodMapper.selectAll();
    }
    
    public IpfCcmBoMethodMapper getIpfCcmBoMethodMapper() {
    	if(this.ipfCcmBoMethodMapper == null){
            this.ipfCcmBoMethodMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoMethodMapper.class);
        }
        return this.ipfCcmBoMethodMapper;
    }
        
    public void setIpfCcmBoMethodMapper(IpfCcmBoMethodMapper ipfCcmBoMethodMapper) {
        this.ipfCcmBoMethodMapper = ipfCcmBoMethodMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoMethodMapper = sqlSessionTemplate.getMapper(IpfCcmBoMethodMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoMethod
     * @return
     */
    public ArrayList<IpfCcmBoMethod> selectWithCondition(IpfCcmBoMethod ipfCcmBoMethod){
        return  ipfCcmBoMethodMapper.selectWithCondition(ipfCcmBoMethod,"");
    }

    /** 按条件查询
     * @param ipfCcmBoMethod
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoMethod> selectWithCondition(IpfCcmBoMethod ipfCcmBoMethod,String conditions){
        return  ipfCcmBoMethodMapper.selectWithCondition(ipfCcmBoMethod,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoMethod> selectBySql(String SqlStr){
        return  ipfCcmBoMethodMapper.selectBySql(SqlStr);
    }
}