package com.cartan.core.ipfCcmBoMethodParam.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoMethodParam.dao.IpfCcmBoMethodParamMapper;
import com.cartan.core.ipfCcmBoMethodParam.domain.IpfCcmBoMethodParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoMethodParamServiceBase extends BaseService {
    private IpfCcmBoMethodParamMapper ipfCcmBoMethodParamMapper;
    public IpfCcmBoMethodParam getIpfCcmBoMethodParam(String id){
        return ipfCcmBoMethodParamMapper.getIpfCcmBoMethodParam(id);
    }

    public void createIpfCcmBoMethodParam(IpfCcmBoMethodParam ipfCcmBoMethodParam){
    	ipfCcmBoMethodParamMapper.createIpfCcmBoMethodParam(ipfCcmBoMethodParam);
    }

    public void deleteIpfCcmBoMethodParam(String id){
    	ipfCcmBoMethodParamMapper.deleteIpfCcmBoMethodParam(id);
    }

    public void updateIpfCcmBoMethodParam(IpfCcmBoMethodParam ipfCcmBoMethodParam){
    	ipfCcmBoMethodParamMapper.updateIpfCcmBoMethodParam(ipfCcmBoMethodParam);
    }

    public int countAll(){
       return ipfCcmBoMethodParamMapper.countAll();
    }

    public ArrayList<IpfCcmBoMethodParam> selectAll(){
      return ipfCcmBoMethodParamMapper.selectAll();
    }
    
    public IpfCcmBoMethodParamMapper getIpfCcmBoMethodParamMapper() {
    	if(this.ipfCcmBoMethodParamMapper == null){
            this.ipfCcmBoMethodParamMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoMethodParamMapper.class);
        }
        return this.ipfCcmBoMethodParamMapper;
    }
        
    public void setIpfCcmBoMethodParamMapper(IpfCcmBoMethodParamMapper ipfCcmBoMethodParamMapper) {
        this.ipfCcmBoMethodParamMapper = ipfCcmBoMethodParamMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoMethodParamMapper = sqlSessionTemplate.getMapper(IpfCcmBoMethodParamMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoMethodParam
     * @return
     */
    public ArrayList<IpfCcmBoMethodParam> selectWithCondition(IpfCcmBoMethodParam ipfCcmBoMethodParam){
        return  ipfCcmBoMethodParamMapper.selectWithCondition(ipfCcmBoMethodParam,"");
    }

    /** 按条件查询
     * @param ipfCcmBoMethodParam
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoMethodParam> selectWithCondition(IpfCcmBoMethodParam ipfCcmBoMethodParam,String conditions){
        return  ipfCcmBoMethodParamMapper.selectWithCondition(ipfCcmBoMethodParam,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoMethodParam> selectBySql(String SqlStr){
        return  ipfCcmBoMethodParamMapper.selectBySql(SqlStr);
    }
}