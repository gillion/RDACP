package com.cartan.core.ipfFciViewMember.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfFciViewMember.dao.IpfFciViewMemberMapper;
import com.cartan.core.ipfFciViewMember.domain.IpfFciViewMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfFciViewMemberServiceBase extends BaseService {
    private IpfFciViewMemberMapper ipfFciViewMemberMapper;
    public IpfFciViewMember getIpfFciViewMember(String id){
        return ipfFciViewMemberMapper.getIpfFciViewMember(id);
    }

    public void createIpfFciViewMember(IpfFciViewMember ipfFciViewMember){
    	ipfFciViewMemberMapper.createIpfFciViewMember(ipfFciViewMember);
    }

    public void deleteIpfFciViewMember(String id){
    	ipfFciViewMemberMapper.deleteIpfFciViewMember(id);
    }

    public void updateIpfFciViewMember(IpfFciViewMember ipfFciViewMember){
    	ipfFciViewMemberMapper.updateIpfFciViewMember(ipfFciViewMember);
    }

    public int countAll(){
       return ipfFciViewMemberMapper.countAll();
    }

    public ArrayList<IpfFciViewMember> selectAll(){
      return ipfFciViewMemberMapper.selectAll();
    }
    
    public IpfFciViewMemberMapper getIpfFciViewMemberMapper() {
    	if(this.ipfFciViewMemberMapper == null){
            this.ipfFciViewMemberMapper = this.getSqlSessionTemplate().getMapper(IpfFciViewMemberMapper.class);
        }
        return this.ipfFciViewMemberMapper;
    }
        
    public void setIpfFciViewMemberMapper(IpfFciViewMemberMapper ipfFciViewMemberMapper) {
        this.ipfFciViewMemberMapper = ipfFciViewMemberMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfFciViewMemberMapper = sqlSessionTemplate.getMapper(IpfFciViewMemberMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfFciViewMember
     * @return
     */
    public ArrayList<IpfFciViewMember> selectWithCondition(IpfFciViewMember ipfFciViewMember){
        return  ipfFciViewMemberMapper.selectWithCondition(ipfFciViewMember,"");
    }

    /** 按条件查询
     * @param ipfFciViewMember
     * @conditions
     * @return
     */
    public ArrayList<IpfFciViewMember> selectWithCondition(IpfFciViewMember ipfFciViewMember,String conditions){
        return  ipfFciViewMemberMapper.selectWithCondition(ipfFciViewMember,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfFciViewMember> selectBySql(String SqlStr){
        return  ipfFciViewMemberMapper.selectBySql(SqlStr);
    }
}