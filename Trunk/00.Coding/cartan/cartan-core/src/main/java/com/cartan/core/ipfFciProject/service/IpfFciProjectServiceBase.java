package com.cartan.core.ipfFciProject.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfFciProject.dao.IpfFciProjectMapper;
import com.cartan.core.ipfFciProject.domain.IpfFciProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfFciProjectServiceBase extends BaseService {
    private IpfFciProjectMapper ipfFciProjectMapper;
    public IpfFciProject getIpfFciProject(String id){
        return ipfFciProjectMapper.getIpfFciProject(id);
    }

    public void createIpfFciProject(IpfFciProject ipfFciProject){
    	ipfFciProjectMapper.createIpfFciProject(ipfFciProject);
    }

    public void deleteIpfFciProject(String id){
    	ipfFciProjectMapper.deleteIpfFciProject(id);
    }

    public void updateIpfFciProject(IpfFciProject ipfFciProject){
    	ipfFciProjectMapper.updateIpfFciProject(ipfFciProject);
    }

    public int countAll(){
       return ipfFciProjectMapper.countAll();
    }

    public ArrayList<IpfFciProject> selectAll(){
      return ipfFciProjectMapper.selectAll();
    }
    
    public IpfFciProjectMapper getIpfFciProjectMapper() {
    	if(this.ipfFciProjectMapper == null){
            this.ipfFciProjectMapper = this.getSqlSessionTemplate().getMapper(IpfFciProjectMapper.class);
        }
        return this.ipfFciProjectMapper;
    }
        
    public void setIpfFciProjectMapper(IpfFciProjectMapper ipfFciProjectMapper) {
        this.ipfFciProjectMapper = ipfFciProjectMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfFciProjectMapper = sqlSessionTemplate.getMapper(IpfFciProjectMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfFciProject
     * @return
     */
    public ArrayList<IpfFciProject> selectWithCondition(IpfFciProject ipfFciProject){
        return  ipfFciProjectMapper.selectWithCondition(ipfFciProject,"");
    }

    /** 按条件查询
     * @param ipfFciProject
     * @conditions
     * @return
     */
    public ArrayList<IpfFciProject> selectWithCondition(IpfFciProject ipfFciProject,String conditions){
        return  ipfFciProjectMapper.selectWithCondition(ipfFciProject,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfFciProject> selectBySql(String SqlStr){
        return  ipfFciProjectMapper.selectBySql(SqlStr);
    }
}