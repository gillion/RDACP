package com.cartan.core.app.service;

import com.cartan.core.BaseService;
import com.cartan.core.app.dao.AppMapper;
import com.cartan.core.app.domain.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class AppServiceBase extends BaseService {
    private AppMapper appMapper;
    public App getApp(String appName){
        return appMapper.getApp(appName);
    }

    public void createApp(App app){
    	appMapper.createApp(app);
    }

    public void deleteApp(String appName){
    	appMapper.deleteApp(appName);
    }

    public void updateApp(App app){
    	appMapper.updateApp(app);
    }

    public int countAll(){
       return appMapper.countAll();
    }

    public ArrayList<App> selectAll(){
      return appMapper.selectAll();
    }
    
    public AppMapper getAppMapper() {
    	if(this.appMapper == null){
            this.appMapper = this.getSqlSessionTemplate().getMapper(AppMapper.class);
        }
        return this.appMapper;
    }
        
    public void setAppMapper(AppMapper appMapper) {
        this.appMapper = appMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.appMapper = sqlSessionTemplate.getMapper(AppMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param app
     * @return
     */
    public ArrayList<App> selectWithCondition(App app){
        return  appMapper.selectWithCondition(app,"");
    }

    /** 按条件查询
     * @param app
     * @conditions
     * @return
     */
    public ArrayList<App> selectWithCondition(App app,String conditions){
        return  appMapper.selectWithCondition(app,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<App> selectBySql(String SqlStr){
        return  appMapper.selectBySql(SqlStr);
    }
}