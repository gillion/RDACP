package com.cartan.core.groupMember.service;

import com.cartan.core.BaseService;
import com.cartan.core.groupMember.dao.GroupMemberMapper;
import com.cartan.core.groupMember.domain.GroupMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class GroupMemberServiceBase extends BaseService {
    private GroupMemberMapper groupMemberMapper;
    public GroupMember getGroupMember(String id){
        return groupMemberMapper.getGroupMember(id);
    }

    public void createGroupMember(GroupMember groupMember){
    	groupMemberMapper.createGroupMember(groupMember);
    }

    public void deleteGroupMember(String id){
    	groupMemberMapper.deleteGroupMember(id);
    }

    public void updateGroupMember(GroupMember groupMember){
    	groupMemberMapper.updateGroupMember(groupMember);
    }

    public int countAll(){
       return groupMemberMapper.countAll();
    }

    public ArrayList<GroupMember> selectAll(){
      return groupMemberMapper.selectAll();
    }
    
    public GroupMemberMapper getGroupMemberMapper() {
    	if(this.groupMemberMapper == null){
            this.groupMemberMapper = this.getSqlSessionTemplate().getMapper(GroupMemberMapper.class);
        }
        return this.groupMemberMapper;
    }
        
    public void setGroupMemberMapper(GroupMemberMapper groupMemberMapper) {
        this.groupMemberMapper = groupMemberMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.groupMemberMapper = sqlSessionTemplate.getMapper(GroupMemberMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param groupMember
     * @return
     */
    public ArrayList<GroupMember> selectWithCondition(GroupMember groupMember){
        return  groupMemberMapper.selectWithCondition(groupMember,"");
    }

    /** 按条件查询
     * @param groupMember
     * @conditions
     * @return
     */
    public ArrayList<GroupMember> selectWithCondition(GroupMember groupMember,String conditions){
        return  groupMemberMapper.selectWithCondition(groupMember,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<GroupMember> selectBySql(String SqlStr){
        return  groupMemberMapper.selectBySql(SqlStr);
    }
}