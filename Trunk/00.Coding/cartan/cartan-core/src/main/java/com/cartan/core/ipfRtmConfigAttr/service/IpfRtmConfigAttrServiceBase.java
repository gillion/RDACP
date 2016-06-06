package com.cartan.core.ipfRtmConfigAttr.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfRtmConfigAttr.dao.IpfRtmConfigAttrMapper;
import com.cartan.core.ipfRtmConfigAttr.domain.IpfRtmConfigAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfRtmConfigAttrServiceBase extends BaseService {
    private IpfRtmConfigAttrMapper ipfRtmConfigAttrMapper;
    public IpfRtmConfigAttr getIpfRtmConfigAttr(String id){
        return ipfRtmConfigAttrMapper.getIpfRtmConfigAttr(id);
    }

    public void createIpfRtmConfigAttr(IpfRtmConfigAttr ipfRtmConfigAttr){
    	ipfRtmConfigAttrMapper.createIpfRtmConfigAttr(ipfRtmConfigAttr);
    }

    public void deleteIpfRtmConfigAttr(String id){
    	ipfRtmConfigAttrMapper.deleteIpfRtmConfigAttr(id);
    }

    public void updateIpfRtmConfigAttr(IpfRtmConfigAttr ipfRtmConfigAttr){
    	ipfRtmConfigAttrMapper.updateIpfRtmConfigAttr(ipfRtmConfigAttr);
    }

    public int countAll(){
       return ipfRtmConfigAttrMapper.countAll();
    }

    public ArrayList<IpfRtmConfigAttr> selectAll(){
      return ipfRtmConfigAttrMapper.selectAll();
    }
    
    public IpfRtmConfigAttrMapper getIpfRtmConfigAttrMapper() {
    	if(this.ipfRtmConfigAttrMapper == null){
            this.ipfRtmConfigAttrMapper = this.getSqlSessionTemplate().getMapper(IpfRtmConfigAttrMapper.class);
        }
        return this.ipfRtmConfigAttrMapper;
    }
        
    public void setIpfRtmConfigAttrMapper(IpfRtmConfigAttrMapper ipfRtmConfigAttrMapper) {
        this.ipfRtmConfigAttrMapper = ipfRtmConfigAttrMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfRtmConfigAttrMapper = sqlSessionTemplate.getMapper(IpfRtmConfigAttrMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfRtmConfigAttr
     * @return
     */
    public ArrayList<IpfRtmConfigAttr> selectWithCondition(IpfRtmConfigAttr ipfRtmConfigAttr){
        return  ipfRtmConfigAttrMapper.selectWithCondition(ipfRtmConfigAttr,"");
    }

    /** 按条件查询
     * @param ipfRtmConfigAttr
     * @conditions
     * @return
     */
    public ArrayList<IpfRtmConfigAttr> selectWithCondition(IpfRtmConfigAttr ipfRtmConfigAttr,String conditions){
        return  ipfRtmConfigAttrMapper.selectWithCondition(ipfRtmConfigAttr,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfRtmConfigAttr> selectBySql(String SqlStr){
        return  ipfRtmConfigAttrMapper.selectBySql(SqlStr);
    }
}