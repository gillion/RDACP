package com.cartan.core.ipfCcmDictValue.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmDictValue.dao.IpfCcmDictValueMapper;
import com.cartan.core.ipfCcmDictValue.domain.IpfCcmDictValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmDictValueServiceBase extends BaseService {
    private IpfCcmDictValueMapper ipfCcmDictValueMapper;
    public IpfCcmDictValue getIpfCcmDictValue(String id){
        return ipfCcmDictValueMapper.getIpfCcmDictValue(id);
    }

    public void createIpfCcmDictValue(IpfCcmDictValue ipfCcmDictValue){
    	ipfCcmDictValueMapper.createIpfCcmDictValue(ipfCcmDictValue);
    }

    public void deleteIpfCcmDictValue(String id){
    	ipfCcmDictValueMapper.deleteIpfCcmDictValue(id);
    }

    public void updateIpfCcmDictValue(IpfCcmDictValue ipfCcmDictValue){
    	ipfCcmDictValueMapper.updateIpfCcmDictValue(ipfCcmDictValue);
    }

    public int countAll(){
       return ipfCcmDictValueMapper.countAll();
    }

    public ArrayList<IpfCcmDictValue> selectAll(){
      return ipfCcmDictValueMapper.selectAll();
    }
    
    public IpfCcmDictValueMapper getIpfCcmDictValueMapper() {
    	if(this.ipfCcmDictValueMapper == null){
            this.ipfCcmDictValueMapper = this.getSqlSessionTemplate().getMapper(IpfCcmDictValueMapper.class);
        }
        return this.ipfCcmDictValueMapper;
    }
        
    public void setIpfCcmDictValueMapper(IpfCcmDictValueMapper ipfCcmDictValueMapper) {
        this.ipfCcmDictValueMapper = ipfCcmDictValueMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmDictValueMapper = sqlSessionTemplate.getMapper(IpfCcmDictValueMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmDictValue
     * @return
     */
    public ArrayList<IpfCcmDictValue> selectWithCondition(IpfCcmDictValue ipfCcmDictValue){
        return  ipfCcmDictValueMapper.selectWithCondition(ipfCcmDictValue,"");
    }

    /** 按条件查询
     * @param ipfCcmDictValue
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmDictValue> selectWithCondition(IpfCcmDictValue ipfCcmDictValue,String conditions){
        return  ipfCcmDictValueMapper.selectWithCondition(ipfCcmDictValue,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmDictValue> selectBySql(String SqlStr){
        return  ipfCcmDictValueMapper.selectBySql(SqlStr);
    }
}