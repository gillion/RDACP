package com.cartan.core.ipfFciLabel.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfFciLabel.dao.IpfFciLabelMapper;
import com.cartan.core.ipfFciLabel.domain.IpfFciLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfFciLabelServiceBase extends BaseService {
    private IpfFciLabelMapper ipfFciLabelMapper;
    public IpfFciLabel getIpfFciLabel(String id){
        return ipfFciLabelMapper.getIpfFciLabel(id);
    }

    public void createIpfFciLabel(IpfFciLabel ipfFciLabel){
    	ipfFciLabelMapper.createIpfFciLabel(ipfFciLabel);
    }

    public void deleteIpfFciLabel(String id){
    	ipfFciLabelMapper.deleteIpfFciLabel(id);
    }

    public void updateIpfFciLabel(IpfFciLabel ipfFciLabel){
    	ipfFciLabelMapper.updateIpfFciLabel(ipfFciLabel);
    }

    public int countAll(){
       return ipfFciLabelMapper.countAll();
    }

    public ArrayList<IpfFciLabel> selectAll(){
      return ipfFciLabelMapper.selectAll();
    }
    
    public IpfFciLabelMapper getIpfFciLabelMapper() {
    	if(this.ipfFciLabelMapper == null){
            this.ipfFciLabelMapper = this.getSqlSessionTemplate().getMapper(IpfFciLabelMapper.class);
        }
        return this.ipfFciLabelMapper;
    }
        
    public void setIpfFciLabelMapper(IpfFciLabelMapper ipfFciLabelMapper) {
        this.ipfFciLabelMapper = ipfFciLabelMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfFciLabelMapper = sqlSessionTemplate.getMapper(IpfFciLabelMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfFciLabel
     * @return
     */
    public ArrayList<IpfFciLabel> selectWithCondition(IpfFciLabel ipfFciLabel){
        return  ipfFciLabelMapper.selectWithCondition(ipfFciLabel,"");
    }

    /** 按条件查询
     * @param ipfFciLabel
     * @conditions
     * @return
     */
    public ArrayList<IpfFciLabel> selectWithCondition(IpfFciLabel ipfFciLabel,String conditions){
        return  ipfFciLabelMapper.selectWithCondition(ipfFciLabel,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfFciLabel> selectBySql(String SqlStr){
        return  ipfFciLabelMapper.selectBySql(SqlStr);
    }
}