package com.cartan.core.ipfCcmUiLayoutList.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmUiLayoutList.dao.IpfCcmUiLayoutListMapper;
import com.cartan.core.ipfCcmUiLayoutList.domain.IpfCcmUiLayoutList;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmUiLayoutListServiceBase extends BaseService {
    private IpfCcmUiLayoutListMapper ipfCcmUiLayoutListMapper;
    public IpfCcmUiLayoutList getIpfCcmUiLayoutList(String id){
        return ipfCcmUiLayoutListMapper.getIpfCcmUiLayoutList(id);
    }

    public void createIpfCcmUiLayoutList(IpfCcmUiLayoutList ipfCcmUiLayoutList){
    	ipfCcmUiLayoutListMapper.createIpfCcmUiLayoutList(ipfCcmUiLayoutList);
    }

    public void deleteIpfCcmUiLayoutList(String id){
    	ipfCcmUiLayoutListMapper.deleteIpfCcmUiLayoutList(id);
    }

    public void updateIpfCcmUiLayoutList(IpfCcmUiLayoutList ipfCcmUiLayoutList){
    	ipfCcmUiLayoutListMapper.updateIpfCcmUiLayoutList(ipfCcmUiLayoutList);
    }

    public int countAll(){
       return ipfCcmUiLayoutListMapper.countAll();
    }

    public ArrayList<IpfCcmUiLayoutList> selectAll(){
      return ipfCcmUiLayoutListMapper.selectAll();
    }
    
    public IpfCcmUiLayoutListMapper getIpfCcmUiLayoutListMapper() {
    	if(this.ipfCcmUiLayoutListMapper == null){
            this.ipfCcmUiLayoutListMapper = this.getSqlSessionTemplate().getMapper(IpfCcmUiLayoutListMapper.class);
        }
        return this.ipfCcmUiLayoutListMapper;
    }
        
    public void setIpfCcmUiLayoutListMapper(IpfCcmUiLayoutListMapper ipfCcmUiLayoutListMapper) {
        this.ipfCcmUiLayoutListMapper = ipfCcmUiLayoutListMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmUiLayoutListMapper = sqlSessionTemplate.getMapper(IpfCcmUiLayoutListMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmUiLayoutList
     * @return
     */
    public ArrayList<IpfCcmUiLayoutList> selectWithCondition(IpfCcmUiLayoutList ipfCcmUiLayoutList){
        return  ipfCcmUiLayoutListMapper.selectWithCondition(ipfCcmUiLayoutList,"");
    }

    /** 按条件查询
     * @param ipfCcmUiLayoutList
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmUiLayoutList> selectWithCondition(IpfCcmUiLayoutList ipfCcmUiLayoutList,String conditions){
        return  ipfCcmUiLayoutListMapper.selectWithCondition(ipfCcmUiLayoutList,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmUiLayoutList> selectBySql(String SqlStr){
        return  ipfCcmUiLayoutListMapper.selectBySql(SqlStr);
    }
}