package com.cartan.core.loginUser.service;

import com.cartan.core.BaseService;
import com.cartan.core.loginUser.dao.LoginUserMapper;
import com.cartan.core.loginUser.domain.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class LoginUserServiceBase extends BaseService {
    private LoginUserMapper loginUserMapper;
    public LoginUser getLoginUser(String id){
        return loginUserMapper.getLoginUser(id);
    }

    public void createLoginUser(LoginUser loginUser){
    	loginUserMapper.createLoginUser(loginUser);
    }

    public void deleteLoginUser(String id){
    	loginUserMapper.deleteLoginUser(id);
    }

    public void updateLoginUser(LoginUser loginUser){
    	loginUserMapper.updateLoginUser(loginUser);
    }

    public int countAll(){
       return loginUserMapper.countAll();
    }

    public ArrayList<LoginUser> selectAll(){
      return loginUserMapper.selectAll();
    }
    
    public LoginUserMapper getLoginUserMapper() {
    	if(this.loginUserMapper == null){
            this.loginUserMapper = this.getSqlSessionTemplate().getMapper(LoginUserMapper.class);
        }
        return this.loginUserMapper;
    }
        
    public void setLoginUserMapper(LoginUserMapper loginUserMapper) {
        this.loginUserMapper = loginUserMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.loginUserMapper = sqlSessionTemplate.getMapper(LoginUserMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param loginUser
     * @return
     */
    public ArrayList<LoginUser> selectWithCondition(LoginUser loginUser){
        return  loginUserMapper.selectWithCondition(loginUser,"");
    }

    /** 按条件查询
     * @param loginUser
     * @conditions
     * @return
     */
    public ArrayList<LoginUser> selectWithCondition(LoginUser loginUser,String conditions){
        return  loginUserMapper.selectWithCondition(loginUser,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<LoginUser> selectBySql(String SqlStr){
        return  loginUserMapper.selectBySql(SqlStr);
    }
}