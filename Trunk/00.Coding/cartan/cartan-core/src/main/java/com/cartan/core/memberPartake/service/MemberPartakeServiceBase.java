package com.cartan.core.memberPartake.service;

import com.cartan.core.BaseService;
import com.cartan.core.memberPartake.dao.MemberPartakeMapper;
import com.cartan.core.memberPartake.domain.MemberPartake;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class MemberPartakeServiceBase extends BaseService {
    private MemberPartakeMapper memberPartakeMapper;
    public MemberPartake getMemberPartake(String id){
        return memberPartakeMapper.getMemberPartake(id);
    }

    public void createMemberPartake(MemberPartake memberPartake){
    	memberPartakeMapper.createMemberPartake(memberPartake);
    }

    public void deleteMemberPartake(String id){
    	memberPartakeMapper.deleteMemberPartake(id);
    }

    public void updateMemberPartake(MemberPartake memberPartake){
    	memberPartakeMapper.updateMemberPartake(memberPartake);
    }

    public int countAll(){
       return memberPartakeMapper.countAll();
    }

    public ArrayList<MemberPartake> selectAll(){
      return memberPartakeMapper.selectAll();
    }
    
    public MemberPartakeMapper getMemberPartakeMapper() {
    	if(this.memberPartakeMapper == null){
            this.memberPartakeMapper = this.getSqlSessionTemplate().getMapper(MemberPartakeMapper.class);
        }
        return this.memberPartakeMapper;
    }
        
    public void setMemberPartakeMapper(MemberPartakeMapper memberPartakeMapper) {
        this.memberPartakeMapper = memberPartakeMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.memberPartakeMapper = sqlSessionTemplate.getMapper(MemberPartakeMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param memberPartake
     * @return
     */
    public ArrayList<MemberPartake> selectWithCondition(MemberPartake memberPartake){
        return  memberPartakeMapper.selectWithCondition(memberPartake,"");
    }

    /** 按条件查询
     * @param memberPartake
     * @conditions
     * @return
     */
    public ArrayList<MemberPartake> selectWithCondition(MemberPartake memberPartake,String conditions){
        return  memberPartakeMapper.selectWithCondition(memberPartake,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<MemberPartake> selectBySql(String SqlStr){
        return  memberPartakeMapper.selectBySql(SqlStr);
    }
}