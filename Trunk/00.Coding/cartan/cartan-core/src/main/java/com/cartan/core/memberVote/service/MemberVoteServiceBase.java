package com.cartan.core.memberVote.service;

import com.cartan.core.BaseService;
import com.cartan.core.memberVote.dao.MemberVoteMapper;
import com.cartan.core.memberVote.domain.MemberVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class MemberVoteServiceBase extends BaseService {
    private MemberVoteMapper memberVoteMapper;
    public MemberVote getMemberVote(String id){
        return memberVoteMapper.getMemberVote(id);
    }

    public void createMemberVote(MemberVote memberVote){
    	memberVoteMapper.createMemberVote(memberVote);
    }

    public void deleteMemberVote(String id){
    	memberVoteMapper.deleteMemberVote(id);
    }

    public void updateMemberVote(MemberVote memberVote){
    	memberVoteMapper.updateMemberVote(memberVote);
    }

    public int countAll(){
       return memberVoteMapper.countAll();
    }

    public ArrayList<MemberVote> selectAll(){
      return memberVoteMapper.selectAll();
    }
    
    public MemberVoteMapper getMemberVoteMapper() {
    	if(this.memberVoteMapper == null){
            this.memberVoteMapper = this.getSqlSessionTemplate().getMapper(MemberVoteMapper.class);
        }
        return this.memberVoteMapper;
    }
        
    public void setMemberVoteMapper(MemberVoteMapper memberVoteMapper) {
        this.memberVoteMapper = memberVoteMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.memberVoteMapper = sqlSessionTemplate.getMapper(MemberVoteMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param memberVote
     * @return
     */
    public ArrayList<MemberVote> selectWithCondition(MemberVote memberVote){
        return  memberVoteMapper.selectWithCondition(memberVote,"");
    }

    /** 按条件查询
     * @param memberVote
     * @conditions
     * @return
     */
    public ArrayList<MemberVote> selectWithCondition(MemberVote memberVote,String conditions){
        return  memberVoteMapper.selectWithCondition(memberVote,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<MemberVote> selectBySql(String SqlStr){
        return  memberVoteMapper.selectBySql(SqlStr);
    }
}