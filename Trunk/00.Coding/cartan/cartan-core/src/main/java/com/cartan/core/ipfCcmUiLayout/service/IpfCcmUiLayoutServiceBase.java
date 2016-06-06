package com.cartan.core.ipfCcmUiLayout.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmUiLayout.dao.IpfCcmUiLayoutMapper;
import com.cartan.core.ipfCcmUiLayout.domain.IpfCcmUiLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmUiLayoutServiceBase extends BaseService {
    private IpfCcmUiLayoutMapper ipfCcmUiLayoutMapper;
    public IpfCcmUiLayout getIpfCcmUiLayout(String id){
        return ipfCcmUiLayoutMapper.getIpfCcmUiLayout(id);
    }

    public void createIpfCcmUiLayout(IpfCcmUiLayout ipfCcmUiLayout){
    	ipfCcmUiLayoutMapper.createIpfCcmUiLayout(ipfCcmUiLayout);
    }

    public void deleteIpfCcmUiLayout(String id){
    	ipfCcmUiLayoutMapper.deleteIpfCcmUiLayout(id);
    }

    public void updateIpfCcmUiLayout(IpfCcmUiLayout ipfCcmUiLayout){
    	ipfCcmUiLayoutMapper.updateIpfCcmUiLayout(ipfCcmUiLayout);
    }

    public int countAll(){
       return ipfCcmUiLayoutMapper.countAll();
    }

    public ArrayList<IpfCcmUiLayout> selectAll(){
      return ipfCcmUiLayoutMapper.selectAll();
    }
    
    public IpfCcmUiLayoutMapper getIpfCcmUiLayoutMapper() {
    	if(this.ipfCcmUiLayoutMapper == null){
            this.ipfCcmUiLayoutMapper = this.getSqlSessionTemplate().getMapper(IpfCcmUiLayoutMapper.class);
        }
        return this.ipfCcmUiLayoutMapper;
    }
        
    public void setIpfCcmUiLayoutMapper(IpfCcmUiLayoutMapper ipfCcmUiLayoutMapper) {
        this.ipfCcmUiLayoutMapper = ipfCcmUiLayoutMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmUiLayoutMapper = sqlSessionTemplate.getMapper(IpfCcmUiLayoutMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmUiLayout
     * @return
     */
    public ArrayList<IpfCcmUiLayout> selectWithCondition(IpfCcmUiLayout ipfCcmUiLayout){
        return  ipfCcmUiLayoutMapper.selectWithCondition(ipfCcmUiLayout,"");
    }

    /** 按条件查询
     * @param ipfCcmUiLayout
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmUiLayout> selectWithCondition(IpfCcmUiLayout ipfCcmUiLayout,String conditions){
        return  ipfCcmUiLayoutMapper.selectWithCondition(ipfCcmUiLayout,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmUiLayout> selectBySql(String SqlStr){
        return  ipfCcmUiLayoutMapper.selectBySql(SqlStr);
    }
}