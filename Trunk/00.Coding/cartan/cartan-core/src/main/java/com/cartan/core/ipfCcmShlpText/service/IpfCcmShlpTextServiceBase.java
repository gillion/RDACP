package com.cartan.core.ipfCcmShlpText.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmShlpText.dao.IpfCcmShlpTextMapper;
import com.cartan.core.ipfCcmShlpText.domain.IpfCcmShlpText;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmShlpTextServiceBase extends BaseService {
    private IpfCcmShlpTextMapper ipfCcmShlpTextMapper;
    public IpfCcmShlpText getIpfCcmShlpText(String id){
        return ipfCcmShlpTextMapper.getIpfCcmShlpText(id);
    }

    public void createIpfCcmShlpText(IpfCcmShlpText ipfCcmShlpText){
    	ipfCcmShlpTextMapper.createIpfCcmShlpText(ipfCcmShlpText);
    }

    public void deleteIpfCcmShlpText(String id){
    	ipfCcmShlpTextMapper.deleteIpfCcmShlpText(id);
    }

    public void updateIpfCcmShlpText(IpfCcmShlpText ipfCcmShlpText){
    	ipfCcmShlpTextMapper.updateIpfCcmShlpText(ipfCcmShlpText);
    }

    public int countAll(){
       return ipfCcmShlpTextMapper.countAll();
    }

    public ArrayList<IpfCcmShlpText> selectAll(){
      return ipfCcmShlpTextMapper.selectAll();
    }
    
    public IpfCcmShlpTextMapper getIpfCcmShlpTextMapper() {
    	if(this.ipfCcmShlpTextMapper == null){
            this.ipfCcmShlpTextMapper = this.getSqlSessionTemplate().getMapper(IpfCcmShlpTextMapper.class);
        }
        return this.ipfCcmShlpTextMapper;
    }
        
    public void setIpfCcmShlpTextMapper(IpfCcmShlpTextMapper ipfCcmShlpTextMapper) {
        this.ipfCcmShlpTextMapper = ipfCcmShlpTextMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmShlpTextMapper = sqlSessionTemplate.getMapper(IpfCcmShlpTextMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmShlpText
     * @return
     */
    public ArrayList<IpfCcmShlpText> selectWithCondition(IpfCcmShlpText ipfCcmShlpText){
        return  ipfCcmShlpTextMapper.selectWithCondition(ipfCcmShlpText,"");
    }

    /** 按条件查询
     * @param ipfCcmShlpText
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmShlpText> selectWithCondition(IpfCcmShlpText ipfCcmShlpText,String conditions){
        return  ipfCcmShlpTextMapper.selectWithCondition(ipfCcmShlpText,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmShlpText> selectBySql(String SqlStr){
        return  ipfCcmShlpTextMapper.selectBySql(SqlStr);
    }
}