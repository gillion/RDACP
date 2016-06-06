package com.cartan.core.sysUser.service;

import com.cartan.core.BaseService;
import com.cartan.core.sysUser.dao.SysUserMapper;
import com.cartan.core.sysUser.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class SysUserServiceBase extends BaseService {
    private SysUserMapper sysUserMapper;
    public SysUser getSysUser(String userId){
        return sysUserMapper.getSysUser(userId);
    }

    public void createSysUser(SysUser sysUser){
    	sysUserMapper.createSysUser(sysUser);
    }

    public void deleteSysUser(String userId){
    	sysUserMapper.deleteSysUser(userId);
    }

    public void updateSysUser(SysUser sysUser){
    	sysUserMapper.updateSysUser(sysUser);
    }

    public int countAll(){
       return sysUserMapper.countAll();
    }

    public ArrayList<SysUser> selectAll(){
      return sysUserMapper.selectAll();
    }
    
    public SysUserMapper getSysUserMapper() {
    	if(this.sysUserMapper == null){
            this.sysUserMapper = this.getSqlSessionTemplate().getMapper(SysUserMapper.class);
        }
        return this.sysUserMapper;
    }
        
    public void setSysUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.sysUserMapper = sqlSessionTemplate.getMapper(SysUserMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param sysUser
     * @return
     */
    public ArrayList<SysUser> selectWithCondition(SysUser sysUser){
        return  sysUserMapper.selectWithCondition(sysUser,"");
    }

    /** 按条件查询
     * @param sysUser
     * @conditions
     * @return
     */
    public ArrayList<SysUser> selectWithCondition(SysUser sysUser,String conditions){
        return  sysUserMapper.selectWithCondition(sysUser,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<SysUser> selectBySql(String SqlStr){
        return  sysUserMapper.selectBySql(SqlStr);
    }
}