package com.cartan.core.ipfCcmNumruleList.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmNumruleList.dao.IpfCcmNumruleListMapper;
import com.cartan.core.ipfCcmNumruleList.domain.IpfCcmNumruleList;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmNumruleListServiceBase extends BaseService {
    private IpfCcmNumruleListMapper ipfCcmNumruleListMapper;
    public IpfCcmNumruleList getIpfCcmNumruleList(String id){
        return ipfCcmNumruleListMapper.getIpfCcmNumruleList(id);
    }

    public void createIpfCcmNumruleList(IpfCcmNumruleList ipfCcmNumruleList){
    	ipfCcmNumruleListMapper.createIpfCcmNumruleList(ipfCcmNumruleList);
    }

    public void deleteIpfCcmNumruleList(String id){
    	ipfCcmNumruleListMapper.deleteIpfCcmNumruleList(id);
    }

    public void updateIpfCcmNumruleList(IpfCcmNumruleList ipfCcmNumruleList){
    	ipfCcmNumruleListMapper.updateIpfCcmNumruleList(ipfCcmNumruleList);
    }

    public int countAll(){
       return ipfCcmNumruleListMapper.countAll();
    }

    public ArrayList<IpfCcmNumruleList> selectAll(){
      return ipfCcmNumruleListMapper.selectAll();
    }
    
    public IpfCcmNumruleListMapper getIpfCcmNumruleListMapper() {
    	if(this.ipfCcmNumruleListMapper == null){
            this.ipfCcmNumruleListMapper = this.getSqlSessionTemplate().getMapper(IpfCcmNumruleListMapper.class);
        }
        return this.ipfCcmNumruleListMapper;
    }
        
    public void setIpfCcmNumruleListMapper(IpfCcmNumruleListMapper ipfCcmNumruleListMapper) {
        this.ipfCcmNumruleListMapper = ipfCcmNumruleListMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmNumruleListMapper = sqlSessionTemplate.getMapper(IpfCcmNumruleListMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmNumruleList
     * @return
     */
    public ArrayList<IpfCcmNumruleList> selectWithCondition(IpfCcmNumruleList ipfCcmNumruleList){
        return  ipfCcmNumruleListMapper.selectWithCondition(ipfCcmNumruleList,"");
    }

    /** 按条件查询
     * @param ipfCcmNumruleList
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmNumruleList> selectWithCondition(IpfCcmNumruleList ipfCcmNumruleList,String conditions){
        return  ipfCcmNumruleListMapper.selectWithCondition(ipfCcmNumruleList,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmNumruleList> selectBySql(String SqlStr){
        return  ipfCcmNumruleListMapper.selectBySql(SqlStr);
    }
}