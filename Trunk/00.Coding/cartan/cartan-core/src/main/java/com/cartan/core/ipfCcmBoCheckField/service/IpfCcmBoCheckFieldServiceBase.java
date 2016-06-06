package com.cartan.core.ipfCcmBoCheckField.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoCheckField.dao.IpfCcmBoCheckFieldMapper;
import com.cartan.core.ipfCcmBoCheckField.domain.IpfCcmBoCheckField;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoCheckFieldServiceBase extends BaseService {
    private IpfCcmBoCheckFieldMapper ipfCcmBoCheckFieldMapper;
    public IpfCcmBoCheckField getIpfCcmBoCheckField(String id){
        return ipfCcmBoCheckFieldMapper.getIpfCcmBoCheckField(id);
    }

    public void createIpfCcmBoCheckField(IpfCcmBoCheckField ipfCcmBoCheckField){
    	ipfCcmBoCheckFieldMapper.createIpfCcmBoCheckField(ipfCcmBoCheckField);
    }

    public void deleteIpfCcmBoCheckField(String id){
    	ipfCcmBoCheckFieldMapper.deleteIpfCcmBoCheckField(id);
    }

    public void updateIpfCcmBoCheckField(IpfCcmBoCheckField ipfCcmBoCheckField){
    	ipfCcmBoCheckFieldMapper.updateIpfCcmBoCheckField(ipfCcmBoCheckField);
    }

    public int countAll(){
       return ipfCcmBoCheckFieldMapper.countAll();
    }

    public ArrayList<IpfCcmBoCheckField> selectAll(){
      return ipfCcmBoCheckFieldMapper.selectAll();
    }
    
    public IpfCcmBoCheckFieldMapper getIpfCcmBoCheckFieldMapper() {
    	if(this.ipfCcmBoCheckFieldMapper == null){
            this.ipfCcmBoCheckFieldMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoCheckFieldMapper.class);
        }
        return this.ipfCcmBoCheckFieldMapper;
    }
        
    public void setIpfCcmBoCheckFieldMapper(IpfCcmBoCheckFieldMapper ipfCcmBoCheckFieldMapper) {
        this.ipfCcmBoCheckFieldMapper = ipfCcmBoCheckFieldMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoCheckFieldMapper = sqlSessionTemplate.getMapper(IpfCcmBoCheckFieldMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoCheckField
     * @return
     */
    public ArrayList<IpfCcmBoCheckField> selectWithCondition(IpfCcmBoCheckField ipfCcmBoCheckField){
        return  ipfCcmBoCheckFieldMapper.selectWithCondition(ipfCcmBoCheckField,"");
    }

    /** 按条件查询
     * @param ipfCcmBoCheckField
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoCheckField> selectWithCondition(IpfCcmBoCheckField ipfCcmBoCheckField,String conditions){
        return  ipfCcmBoCheckFieldMapper.selectWithCondition(ipfCcmBoCheckField,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoCheckField> selectBySql(String SqlStr){
        return  ipfCcmBoCheckFieldMapper.selectBySql(SqlStr);
    }
}