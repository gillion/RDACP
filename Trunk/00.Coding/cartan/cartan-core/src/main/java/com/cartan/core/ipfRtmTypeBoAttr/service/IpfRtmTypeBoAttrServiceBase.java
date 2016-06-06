package com.cartan.core.ipfRtmTypeBoAttr.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfRtmTypeBoAttr.dao.IpfRtmTypeBoAttrMapper;
import com.cartan.core.ipfRtmTypeBoAttr.domain.IpfRtmTypeBoAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfRtmTypeBoAttrServiceBase extends BaseService {
    private IpfRtmTypeBoAttrMapper ipfRtmTypeBoAttrMapper;
    public IpfRtmTypeBoAttr getIpfRtmTypeBoAttr(String id){
        return ipfRtmTypeBoAttrMapper.getIpfRtmTypeBoAttr(id);
    }

    public void createIpfRtmTypeBoAttr(IpfRtmTypeBoAttr ipfRtmTypeBoAttr){
    	ipfRtmTypeBoAttrMapper.createIpfRtmTypeBoAttr(ipfRtmTypeBoAttr);
    }

    public void deleteIpfRtmTypeBoAttr(String id){
    	ipfRtmTypeBoAttrMapper.deleteIpfRtmTypeBoAttr(id);
    }

    public void updateIpfRtmTypeBoAttr(IpfRtmTypeBoAttr ipfRtmTypeBoAttr){
    	ipfRtmTypeBoAttrMapper.updateIpfRtmTypeBoAttr(ipfRtmTypeBoAttr);
    }

    public int countAll(){
       return ipfRtmTypeBoAttrMapper.countAll();
    }

    public ArrayList<IpfRtmTypeBoAttr> selectAll(){
      return ipfRtmTypeBoAttrMapper.selectAll();
    }
    
    public IpfRtmTypeBoAttrMapper getIpfRtmTypeBoAttrMapper() {
    	if(this.ipfRtmTypeBoAttrMapper == null){
            this.ipfRtmTypeBoAttrMapper = this.getSqlSessionTemplate().getMapper(IpfRtmTypeBoAttrMapper.class);
        }
        return this.ipfRtmTypeBoAttrMapper;
    }
        
    public void setIpfRtmTypeBoAttrMapper(IpfRtmTypeBoAttrMapper ipfRtmTypeBoAttrMapper) {
        this.ipfRtmTypeBoAttrMapper = ipfRtmTypeBoAttrMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfRtmTypeBoAttrMapper = sqlSessionTemplate.getMapper(IpfRtmTypeBoAttrMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfRtmTypeBoAttr
     * @return
     */
    public ArrayList<IpfRtmTypeBoAttr> selectWithCondition(IpfRtmTypeBoAttr ipfRtmTypeBoAttr){
        return  ipfRtmTypeBoAttrMapper.selectWithCondition(ipfRtmTypeBoAttr,"");
    }

    /** 按条件查询
     * @param ipfRtmTypeBoAttr
     * @conditions
     * @return
     */
    public ArrayList<IpfRtmTypeBoAttr> selectWithCondition(IpfRtmTypeBoAttr ipfRtmTypeBoAttr,String conditions){
        return  ipfRtmTypeBoAttrMapper.selectWithCondition(ipfRtmTypeBoAttr,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfRtmTypeBoAttr> selectBySql(String SqlStr){
        return  ipfRtmTypeBoAttrMapper.selectBySql(SqlStr);
    }
}