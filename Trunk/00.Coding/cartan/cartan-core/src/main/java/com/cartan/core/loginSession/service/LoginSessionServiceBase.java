package com.cartan.core.loginSession.service;

import com.cartan.core.BaseService;
import com.cartan.core.loginSession.dao.LoginSessionMapper;
import com.cartan.core.loginSession.domain.LoginSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class LoginSessionServiceBase extends BaseService {
    private LoginSessionMapper loginSessionMapper;
    public LoginSession getLoginSession(String id){
        return loginSessionMapper.getLoginSession(id);
    }

    public void createLoginSession(LoginSession loginSession){
    	loginSessionMapper.createLoginSession(loginSession);
    }

    public void deleteLoginSession(String id){
    	loginSessionMapper.deleteLoginSession(id);
    }

    public void updateLoginSession(LoginSession loginSession){
    	loginSessionMapper.updateLoginSession(loginSession);
    }

    public int countAll(){
       return loginSessionMapper.countAll();
    }

    public ArrayList<LoginSession> selectAll(){
      return loginSessionMapper.selectAll();
    }
    
    public LoginSessionMapper getLoginSessionMapper() {
    	if(this.loginSessionMapper == null){
            this.loginSessionMapper = this.getSqlSessionTemplate().getMapper(LoginSessionMapper.class);
        }
        return this.loginSessionMapper;
    }
        
    public void setLoginSessionMapper(LoginSessionMapper loginSessionMapper) {
        this.loginSessionMapper = loginSessionMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.loginSessionMapper = sqlSessionTemplate.getMapper(LoginSessionMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param loginSession
     * @return
     */
    public ArrayList<LoginSession> selectWithCondition(LoginSession loginSession){
        return  loginSessionMapper.selectWithCondition(loginSession,"");
    }

    /** 按条件查询
     * @param loginSession
     * @conditions
     * @return
     */
    public ArrayList<LoginSession> selectWithCondition(LoginSession loginSession,String conditions){
        return  loginSessionMapper.selectWithCondition(loginSession,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<LoginSession> selectBySql(String SqlStr){
        return  loginSessionMapper.selectBySql(SqlStr);
    }
}