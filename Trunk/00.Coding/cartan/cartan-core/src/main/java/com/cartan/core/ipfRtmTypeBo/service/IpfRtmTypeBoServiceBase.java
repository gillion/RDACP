package com.cartan.core.ipfRtmTypeBo.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfRtmTypeBo.dao.IpfRtmTypeBoMapper;
import com.cartan.core.ipfRtmTypeBo.domain.IpfRtmTypeBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfRtmTypeBoServiceBase extends BaseService {
    private IpfRtmTypeBoMapper ipfRtmTypeBoMapper;
    public IpfRtmTypeBo getIpfRtmTypeBo(String id){
        return ipfRtmTypeBoMapper.getIpfRtmTypeBo(id);
    }

    public void createIpfRtmTypeBo(IpfRtmTypeBo ipfRtmTypeBo){
    	ipfRtmTypeBoMapper.createIpfRtmTypeBo(ipfRtmTypeBo);
    }

    public void deleteIpfRtmTypeBo(String id){
    	ipfRtmTypeBoMapper.deleteIpfRtmTypeBo(id);
    }

    public void updateIpfRtmTypeBo(IpfRtmTypeBo ipfRtmTypeBo){
    	ipfRtmTypeBoMapper.updateIpfRtmTypeBo(ipfRtmTypeBo);
    }

    public int countAll(){
       return ipfRtmTypeBoMapper.countAll();
    }

    public ArrayList<IpfRtmTypeBo> selectAll(){
      return ipfRtmTypeBoMapper.selectAll();
    }
    
    public IpfRtmTypeBoMapper getIpfRtmTypeBoMapper() {
    	if(this.ipfRtmTypeBoMapper == null){
            this.ipfRtmTypeBoMapper = this.getSqlSessionTemplate().getMapper(IpfRtmTypeBoMapper.class);
        }
        return this.ipfRtmTypeBoMapper;
    }
        
    public void setIpfRtmTypeBoMapper(IpfRtmTypeBoMapper ipfRtmTypeBoMapper) {
        this.ipfRtmTypeBoMapper = ipfRtmTypeBoMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfRtmTypeBoMapper = sqlSessionTemplate.getMapper(IpfRtmTypeBoMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfRtmTypeBo
     * @return
     */
    public ArrayList<IpfRtmTypeBo> selectWithCondition(IpfRtmTypeBo ipfRtmTypeBo){
        return  ipfRtmTypeBoMapper.selectWithCondition(ipfRtmTypeBo,"");
    }

    /** 按条件查询
     * @param ipfRtmTypeBo
     * @conditions
     * @return
     */
    public ArrayList<IpfRtmTypeBo> selectWithCondition(IpfRtmTypeBo ipfRtmTypeBo,String conditions){
        return  ipfRtmTypeBoMapper.selectWithCondition(ipfRtmTypeBo,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfRtmTypeBo> selectBySql(String SqlStr){
        return  ipfRtmTypeBoMapper.selectBySql(SqlStr);
    }
}