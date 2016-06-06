package com.cartan.core.ipfDmlElementText.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfDmlElementText.dao.IpfDmlElementTextMapper;
import com.cartan.core.ipfDmlElementText.domain.IpfDmlElementText;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfDmlElementTextServiceBase extends BaseService {
    private IpfDmlElementTextMapper ipfDmlElementTextMapper;
    public IpfDmlElementText getIpfDmlElementText(String id){
        return ipfDmlElementTextMapper.getIpfDmlElementText(id);
    }

    public void createIpfDmlElementText(IpfDmlElementText ipfDmlElementText){
    	ipfDmlElementTextMapper.createIpfDmlElementText(ipfDmlElementText);
    }

    public void deleteIpfDmlElementText(String id){
    	ipfDmlElementTextMapper.deleteIpfDmlElementText(id);
    }

    public void updateIpfDmlElementText(IpfDmlElementText ipfDmlElementText){
    	ipfDmlElementTextMapper.updateIpfDmlElementText(ipfDmlElementText);
    }

    public int countAll(){
       return ipfDmlElementTextMapper.countAll();
    }

    public ArrayList<IpfDmlElementText> selectAll(){
      return ipfDmlElementTextMapper.selectAll();
    }
    
    public IpfDmlElementTextMapper getIpfDmlElementTextMapper() {
    	if(this.ipfDmlElementTextMapper == null){
            this.ipfDmlElementTextMapper = this.getSqlSessionTemplate().getMapper(IpfDmlElementTextMapper.class);
        }
        return this.ipfDmlElementTextMapper;
    }
        
    public void setIpfDmlElementTextMapper(IpfDmlElementTextMapper ipfDmlElementTextMapper) {
        this.ipfDmlElementTextMapper = ipfDmlElementTextMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfDmlElementTextMapper = sqlSessionTemplate.getMapper(IpfDmlElementTextMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfDmlElementText
     * @return
     */
    public ArrayList<IpfDmlElementText> selectWithCondition(IpfDmlElementText ipfDmlElementText){
        return  ipfDmlElementTextMapper.selectWithCondition(ipfDmlElementText,"");
    }

    /** 按条件查询
     * @param ipfDmlElementText
     * @conditions
     * @return
     */
    public ArrayList<IpfDmlElementText> selectWithCondition(IpfDmlElementText ipfDmlElementText,String conditions){
        return  ipfDmlElementTextMapper.selectWithCondition(ipfDmlElementText,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfDmlElementText> selectBySql(String SqlStr){
        return  ipfDmlElementTextMapper.selectBySql(SqlStr);
    }
}