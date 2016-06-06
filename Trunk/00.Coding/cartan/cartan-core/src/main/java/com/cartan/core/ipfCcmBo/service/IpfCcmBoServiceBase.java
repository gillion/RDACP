package com.cartan.core.ipfCcmBo.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBo.dao.IpfCcmBoMapper;
import com.cartan.core.ipfCcmBo.domain.IpfCcmBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoServiceBase extends BaseService {
    private IpfCcmBoMapper ipfCcmBoMapper;
    public IpfCcmBo getIpfCcmBo(String id){
        return ipfCcmBoMapper.getIpfCcmBo(id);
    }

    public void createIpfCcmBo(IpfCcmBo ipfCcmBo){
    	ipfCcmBoMapper.createIpfCcmBo(ipfCcmBo);
    }

    public void deleteIpfCcmBo(String id){
    	ipfCcmBoMapper.deleteIpfCcmBo(id);
    }

    public void updateIpfCcmBo(IpfCcmBo ipfCcmBo){
    	ipfCcmBoMapper.updateIpfCcmBo(ipfCcmBo);
    }

    public int countAll(){
       return ipfCcmBoMapper.countAll();
    }

    public ArrayList<IpfCcmBo> selectAll(){
      return ipfCcmBoMapper.selectAll();
    }
    
    public IpfCcmBoMapper getIpfCcmBoMapper() {
    	if(this.ipfCcmBoMapper == null){
            this.ipfCcmBoMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoMapper.class);
        }
        return this.ipfCcmBoMapper;
    }
        
    public void setIpfCcmBoMapper(IpfCcmBoMapper ipfCcmBoMapper) {
        this.ipfCcmBoMapper = ipfCcmBoMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoMapper = sqlSessionTemplate.getMapper(IpfCcmBoMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBo
     * @return
     */
    public ArrayList<IpfCcmBo> selectWithCondition(IpfCcmBo ipfCcmBo){
        return  ipfCcmBoMapper.selectWithCondition(ipfCcmBo,"");
    }

    /** 按条件查询
     * @param ipfCcmBo
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBo> selectWithCondition(IpfCcmBo ipfCcmBo,String conditions){
        return  ipfCcmBoMapper.selectWithCondition(ipfCcmBo,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBo> selectBySql(String SqlStr){
        return  ipfCcmBoMapper.selectBySql(SqlStr);
    }
}