package com.cartan.core.groupAction.service;

import com.cartan.core.BaseService;
import com.cartan.core.groupAction.dao.GroupActionMapper;
import com.cartan.core.groupAction.domain.GroupAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class GroupActionServiceBase extends BaseService {
    private GroupActionMapper groupActionMapper;
    public GroupAction getGroupAction(String id){
        return groupActionMapper.getGroupAction(id);
    }

    public void createGroupAction(GroupAction groupAction){
    	groupActionMapper.createGroupAction(groupAction);
    }

    public void deleteGroupAction(String id){
    	groupActionMapper.deleteGroupAction(id);
    }

    public void updateGroupAction(GroupAction groupAction){
    	groupActionMapper.updateGroupAction(groupAction);
    }

    public int countAll(){
       return groupActionMapper.countAll();
    }

    public ArrayList<GroupAction> selectAll(){
      return groupActionMapper.selectAll();
    }
    
    public GroupActionMapper getGroupActionMapper() {
    	if(this.groupActionMapper == null){
            this.groupActionMapper = this.getSqlSessionTemplate().getMapper(GroupActionMapper.class);
        }
        return this.groupActionMapper;
    }
        
    public void setGroupActionMapper(GroupActionMapper groupActionMapper) {
        this.groupActionMapper = groupActionMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.groupActionMapper = sqlSessionTemplate.getMapper(GroupActionMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param groupAction
     * @return
     */
    public ArrayList<GroupAction> selectWithCondition(GroupAction groupAction){
        return  groupActionMapper.selectWithCondition(groupAction,"");
    }

    /** 按条件查询
     * @param groupAction
     * @conditions
     * @return
     */
    public ArrayList<GroupAction> selectWithCondition(GroupAction groupAction,String conditions){
        return  groupActionMapper.selectWithCondition(groupAction,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<GroupAction> selectBySql(String SqlStr){
        return  groupActionMapper.selectBySql(SqlStr);
    }
}