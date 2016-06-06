package com.cartan.core.groupInfo.service;

import com.cartan.core.BaseService;
import com.cartan.core.groupInfo.dao.GroupInfoMapper;
import com.cartan.core.groupInfo.domain.GroupInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class GroupInfoServiceBase extends BaseService {
    private GroupInfoMapper groupInfoMapper;
    public GroupInfo getGroupInfo(String id){
        return groupInfoMapper.getGroupInfo(id);
    }

    public void createGroupInfo(GroupInfo groupInfo){
    	groupInfoMapper.createGroupInfo(groupInfo);
    }

    public void deleteGroupInfo(String id){
    	groupInfoMapper.deleteGroupInfo(id);
    }

    public void updateGroupInfo(GroupInfo groupInfo){
    	groupInfoMapper.updateGroupInfo(groupInfo);
    }

    public int countAll(){
       return groupInfoMapper.countAll();
    }

    public ArrayList<GroupInfo> selectAll(){
      return groupInfoMapper.selectAll();
    }
    
    public GroupInfoMapper getGroupInfoMapper() {
    	if(this.groupInfoMapper == null){
            this.groupInfoMapper = this.getSqlSessionTemplate().getMapper(GroupInfoMapper.class);
        }
        return this.groupInfoMapper;
    }
        
    public void setGroupInfoMapper(GroupInfoMapper groupInfoMapper) {
        this.groupInfoMapper = groupInfoMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.groupInfoMapper = sqlSessionTemplate.getMapper(GroupInfoMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param groupInfo
     * @return
     */
    public ArrayList<GroupInfo> selectWithCondition(GroupInfo groupInfo){
        return  groupInfoMapper.selectWithCondition(groupInfo,"");
    }

    /** 按条件查询
     * @param groupInfo
     * @conditions
     * @return
     */
    public ArrayList<GroupInfo> selectWithCondition(GroupInfo groupInfo,String conditions){
        return  groupInfoMapper.selectWithCondition(groupInfo,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<GroupInfo> selectBySql(String SqlStr){
        return  groupInfoMapper.selectBySql(SqlStr);
    }
}