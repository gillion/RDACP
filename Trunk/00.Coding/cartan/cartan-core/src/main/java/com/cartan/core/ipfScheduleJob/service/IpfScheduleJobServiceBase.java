package com.cartan.core.ipfScheduleJob.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfScheduleJob.dao.IpfScheduleJobMapper;
import com.cartan.core.ipfScheduleJob.domain.IpfScheduleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfScheduleJobServiceBase extends BaseService {
    private IpfScheduleJobMapper ipfScheduleJobMapper;
    public IpfScheduleJob getIpfScheduleJob(String id){
        return ipfScheduleJobMapper.getIpfScheduleJob(id);
    }

    public void createIpfScheduleJob(IpfScheduleJob ipfScheduleJob){
    	ipfScheduleJobMapper.createIpfScheduleJob(ipfScheduleJob);
    }

    public void deleteIpfScheduleJob(String id){
    	ipfScheduleJobMapper.deleteIpfScheduleJob(id);
    }

    public void updateIpfScheduleJob(IpfScheduleJob ipfScheduleJob){
    	ipfScheduleJobMapper.updateIpfScheduleJob(ipfScheduleJob);
    }

    public int countAll(){
       return ipfScheduleJobMapper.countAll();
    }

    public ArrayList<IpfScheduleJob> selectAll(){
      return ipfScheduleJobMapper.selectAll();
    }
    
    public IpfScheduleJobMapper getIpfScheduleJobMapper() {
    	if(this.ipfScheduleJobMapper == null){
            this.ipfScheduleJobMapper = this.getSqlSessionTemplate().getMapper(IpfScheduleJobMapper.class);
        }
        return this.ipfScheduleJobMapper;
    }
        
    public void setIpfScheduleJobMapper(IpfScheduleJobMapper ipfScheduleJobMapper) {
        this.ipfScheduleJobMapper = ipfScheduleJobMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfScheduleJobMapper = sqlSessionTemplate.getMapper(IpfScheduleJobMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfScheduleJob
     * @return
     */
    public ArrayList<IpfScheduleJob> selectWithCondition(IpfScheduleJob ipfScheduleJob){
        return  ipfScheduleJobMapper.selectWithCondition(ipfScheduleJob,"");
    }

    /** 按条件查询
     * @param ipfScheduleJob
     * @conditions
     * @return
     */
    public ArrayList<IpfScheduleJob> selectWithCondition(IpfScheduleJob ipfScheduleJob,String conditions){
        return  ipfScheduleJobMapper.selectWithCondition(ipfScheduleJob,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfScheduleJob> selectBySql(String SqlStr){
        return  ipfScheduleJobMapper.selectBySql(SqlStr);
    }
}