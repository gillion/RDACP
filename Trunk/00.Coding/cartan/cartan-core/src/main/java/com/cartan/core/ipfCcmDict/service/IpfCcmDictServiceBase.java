package com.cartan.core.ipfCcmDict.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmDict.dao.IpfCcmDictMapper;
import com.cartan.core.ipfCcmDict.domain.IpfCcmDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmDictServiceBase extends BaseService {
    private IpfCcmDictMapper ipfCcmDictMapper;
    public IpfCcmDict getIpfCcmDict(String id){
        return ipfCcmDictMapper.getIpfCcmDict(id);
    }

    public void createIpfCcmDict(IpfCcmDict ipfCcmDict){
    	ipfCcmDictMapper.createIpfCcmDict(ipfCcmDict);
    }

    public void deleteIpfCcmDict(String id){
    	ipfCcmDictMapper.deleteIpfCcmDict(id);
    }

    public void updateIpfCcmDict(IpfCcmDict ipfCcmDict){
    	ipfCcmDictMapper.updateIpfCcmDict(ipfCcmDict);
    }

    public int countAll(){
       return ipfCcmDictMapper.countAll();
    }

    public ArrayList<IpfCcmDict> selectAll(){
      return ipfCcmDictMapper.selectAll();
    }
    
    public IpfCcmDictMapper getIpfCcmDictMapper() {
    	if(this.ipfCcmDictMapper == null){
            this.ipfCcmDictMapper = this.getSqlSessionTemplate().getMapper(IpfCcmDictMapper.class);
        }
        return this.ipfCcmDictMapper;
    }
        
    public void setIpfCcmDictMapper(IpfCcmDictMapper ipfCcmDictMapper) {
        this.ipfCcmDictMapper = ipfCcmDictMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmDictMapper = sqlSessionTemplate.getMapper(IpfCcmDictMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmDict
     * @return
     */
    public ArrayList<IpfCcmDict> selectWithCondition(IpfCcmDict ipfCcmDict){
        return  ipfCcmDictMapper.selectWithCondition(ipfCcmDict,"");
    }

    /** 按条件查询
     * @param ipfCcmDict
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmDict> selectWithCondition(IpfCcmDict ipfCcmDict,String conditions){
        return  ipfCcmDictMapper.selectWithCondition(ipfCcmDict,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmDict> selectBySql(String SqlStr){
        return  ipfCcmDictMapper.selectBySql(SqlStr);
    }
}