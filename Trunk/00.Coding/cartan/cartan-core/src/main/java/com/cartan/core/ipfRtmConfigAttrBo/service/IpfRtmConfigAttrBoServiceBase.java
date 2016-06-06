package com.cartan.core.ipfRtmConfigAttrBo.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfRtmConfigAttrBo.dao.IpfRtmConfigAttrBoMapper;
import com.cartan.core.ipfRtmConfigAttrBo.domain.IpfRtmConfigAttrBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfRtmConfigAttrBoServiceBase extends BaseService {
    private IpfRtmConfigAttrBoMapper ipfRtmConfigAttrBoMapper;
    public IpfRtmConfigAttrBo getIpfRtmConfigAttrBo(String id){
        return ipfRtmConfigAttrBoMapper.getIpfRtmConfigAttrBo(id);
    }

    public void createIpfRtmConfigAttrBo(IpfRtmConfigAttrBo ipfRtmConfigAttrBo){
    	ipfRtmConfigAttrBoMapper.createIpfRtmConfigAttrBo(ipfRtmConfigAttrBo);
    }

    public void deleteIpfRtmConfigAttrBo(String id){
    	ipfRtmConfigAttrBoMapper.deleteIpfRtmConfigAttrBo(id);
    }

    public void updateIpfRtmConfigAttrBo(IpfRtmConfigAttrBo ipfRtmConfigAttrBo){
    	ipfRtmConfigAttrBoMapper.updateIpfRtmConfigAttrBo(ipfRtmConfigAttrBo);
    }

    public int countAll(){
       return ipfRtmConfigAttrBoMapper.countAll();
    }

    public ArrayList<IpfRtmConfigAttrBo> selectAll(){
      return ipfRtmConfigAttrBoMapper.selectAll();
    }
    
    public IpfRtmConfigAttrBoMapper getIpfRtmConfigAttrBoMapper() {
    	if(this.ipfRtmConfigAttrBoMapper == null){
            this.ipfRtmConfigAttrBoMapper = this.getSqlSessionTemplate().getMapper(IpfRtmConfigAttrBoMapper.class);
        }
        return this.ipfRtmConfigAttrBoMapper;
    }
        
    public void setIpfRtmConfigAttrBoMapper(IpfRtmConfigAttrBoMapper ipfRtmConfigAttrBoMapper) {
        this.ipfRtmConfigAttrBoMapper = ipfRtmConfigAttrBoMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfRtmConfigAttrBoMapper = sqlSessionTemplate.getMapper(IpfRtmConfigAttrBoMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfRtmConfigAttrBo
     * @return
     */
    public ArrayList<IpfRtmConfigAttrBo> selectWithCondition(IpfRtmConfigAttrBo ipfRtmConfigAttrBo){
        return  ipfRtmConfigAttrBoMapper.selectWithCondition(ipfRtmConfigAttrBo,"");
    }

    /** 按条件查询
     * @param ipfRtmConfigAttrBo
     * @conditions
     * @return
     */
    public ArrayList<IpfRtmConfigAttrBo> selectWithCondition(IpfRtmConfigAttrBo ipfRtmConfigAttrBo,String conditions){
        return  ipfRtmConfigAttrBoMapper.selectWithCondition(ipfRtmConfigAttrBo,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfRtmConfigAttrBo> selectBySql(String SqlStr){
        return  ipfRtmConfigAttrBoMapper.selectBySql(SqlStr);
    }
}