package com.cartan.core.ipfCcmBoCheck.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoCheck.dao.IpfCcmBoCheckMapper;
import com.cartan.core.ipfCcmBoCheck.domain.IpfCcmBoCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoCheckServiceBase extends BaseService {
    private IpfCcmBoCheckMapper ipfCcmBoCheckMapper;
    public IpfCcmBoCheck getIpfCcmBoCheck(String id){
        return ipfCcmBoCheckMapper.getIpfCcmBoCheck(id);
    }

    public void createIpfCcmBoCheck(IpfCcmBoCheck ipfCcmBoCheck){
    	ipfCcmBoCheckMapper.createIpfCcmBoCheck(ipfCcmBoCheck);
    }

    public void deleteIpfCcmBoCheck(String id){
    	ipfCcmBoCheckMapper.deleteIpfCcmBoCheck(id);
    }

    public void updateIpfCcmBoCheck(IpfCcmBoCheck ipfCcmBoCheck){
    	ipfCcmBoCheckMapper.updateIpfCcmBoCheck(ipfCcmBoCheck);
    }

    public int countAll(){
       return ipfCcmBoCheckMapper.countAll();
    }

    public ArrayList<IpfCcmBoCheck> selectAll(){
      return ipfCcmBoCheckMapper.selectAll();
    }
    
    public IpfCcmBoCheckMapper getIpfCcmBoCheckMapper() {
    	if(this.ipfCcmBoCheckMapper == null){
            this.ipfCcmBoCheckMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoCheckMapper.class);
        }
        return this.ipfCcmBoCheckMapper;
    }
        
    public void setIpfCcmBoCheckMapper(IpfCcmBoCheckMapper ipfCcmBoCheckMapper) {
        this.ipfCcmBoCheckMapper = ipfCcmBoCheckMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoCheckMapper = sqlSessionTemplate.getMapper(IpfCcmBoCheckMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoCheck
     * @return
     */
    public ArrayList<IpfCcmBoCheck> selectWithCondition(IpfCcmBoCheck ipfCcmBoCheck){
        return  ipfCcmBoCheckMapper.selectWithCondition(ipfCcmBoCheck,"");
    }

    /** 按条件查询
     * @param ipfCcmBoCheck
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoCheck> selectWithCondition(IpfCcmBoCheck ipfCcmBoCheck,String conditions){
        return  ipfCcmBoCheckMapper.selectWithCondition(ipfCcmBoCheck,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoCheck> selectBySql(String SqlStr){
        return  ipfCcmBoCheckMapper.selectBySql(SqlStr);
    }
}