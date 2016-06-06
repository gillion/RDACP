package com.cartan.core.memberClothingsize.service;

import com.cartan.core.BaseService;
import com.cartan.core.memberClothingsize.dao.MemberClothingsizeMapper;
import com.cartan.core.memberClothingsize.domain.MemberClothingsize;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class MemberClothingsizeServiceBase extends BaseService {
    private MemberClothingsizeMapper memberClothingsizeMapper;
    public MemberClothingsize getMemberClothingsize(String id){
        return memberClothingsizeMapper.getMemberClothingsize(id);
    }

    public void createMemberClothingsize(MemberClothingsize memberClothingsize){
    	memberClothingsizeMapper.createMemberClothingsize(memberClothingsize);
    }

    public void deleteMemberClothingsize(String id){
    	memberClothingsizeMapper.deleteMemberClothingsize(id);
    }

    public void updateMemberClothingsize(MemberClothingsize memberClothingsize){
    	memberClothingsizeMapper.updateMemberClothingsize(memberClothingsize);
    }

    public int countAll(){
       return memberClothingsizeMapper.countAll();
    }

    public ArrayList<MemberClothingsize> selectAll(){
      return memberClothingsizeMapper.selectAll();
    }
    
    public MemberClothingsizeMapper getMemberClothingsizeMapper() {
    	if(this.memberClothingsizeMapper == null){
            this.memberClothingsizeMapper = this.getSqlSessionTemplate().getMapper(MemberClothingsizeMapper.class);
        }
        return this.memberClothingsizeMapper;
    }
        
    public void setMemberClothingsizeMapper(MemberClothingsizeMapper memberClothingsizeMapper) {
        this.memberClothingsizeMapper = memberClothingsizeMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.memberClothingsizeMapper = sqlSessionTemplate.getMapper(MemberClothingsizeMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param memberClothingsize
     * @return
     */
    public ArrayList<MemberClothingsize> selectWithCondition(MemberClothingsize memberClothingsize){
        return  memberClothingsizeMapper.selectWithCondition(memberClothingsize,"");
    }

    /** 按条件查询
     * @param memberClothingsize
     * @conditions
     * @return
     */
    public ArrayList<MemberClothingsize> selectWithCondition(MemberClothingsize memberClothingsize,String conditions){
        return  memberClothingsizeMapper.selectWithCondition(memberClothingsize,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<MemberClothingsize> selectBySql(String SqlStr){
        return  memberClothingsizeMapper.selectBySql(SqlStr);
    }
}