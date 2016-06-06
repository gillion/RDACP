package com.cartan.core.ipfCcmBizruleDtlParam.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBizruleDtlParam.dao.IpfCcmBizruleDtlParamMapper;
import com.cartan.core.ipfCcmBizruleDtlParam.domain.IpfCcmBizruleDtlParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBizruleDtlParamServiceBase extends BaseService {
    private IpfCcmBizruleDtlParamMapper ipfCcmBizruleDtlParamMapper;
    public IpfCcmBizruleDtlParam getIpfCcmBizruleDtlParam(String id){
        return ipfCcmBizruleDtlParamMapper.getIpfCcmBizruleDtlParam(id);
    }

    public void createIpfCcmBizruleDtlParam(IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam){
    	ipfCcmBizruleDtlParamMapper.createIpfCcmBizruleDtlParam(ipfCcmBizruleDtlParam);
    }

    public void deleteIpfCcmBizruleDtlParam(String id){
    	ipfCcmBizruleDtlParamMapper.deleteIpfCcmBizruleDtlParam(id);
    }

    public void updateIpfCcmBizruleDtlParam(IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam){
    	ipfCcmBizruleDtlParamMapper.updateIpfCcmBizruleDtlParam(ipfCcmBizruleDtlParam);
    }

    public int countAll(){
       return ipfCcmBizruleDtlParamMapper.countAll();
    }

    public ArrayList<IpfCcmBizruleDtlParam> selectAll(){
      return ipfCcmBizruleDtlParamMapper.selectAll();
    }
    
    public IpfCcmBizruleDtlParamMapper getIpfCcmBizruleDtlParamMapper() {
    	if(this.ipfCcmBizruleDtlParamMapper == null){
            this.ipfCcmBizruleDtlParamMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBizruleDtlParamMapper.class);
        }
        return this.ipfCcmBizruleDtlParamMapper;
    }
        
    public void setIpfCcmBizruleDtlParamMapper(IpfCcmBizruleDtlParamMapper ipfCcmBizruleDtlParamMapper) {
        this.ipfCcmBizruleDtlParamMapper = ipfCcmBizruleDtlParamMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBizruleDtlParamMapper = sqlSessionTemplate.getMapper(IpfCcmBizruleDtlParamMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBizruleDtlParam
     * @return
     */
    public ArrayList<IpfCcmBizruleDtlParam> selectWithCondition(IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam){
        return  ipfCcmBizruleDtlParamMapper.selectWithCondition(ipfCcmBizruleDtlParam,"");
    }

    /** 按条件查询
     * @param ipfCcmBizruleDtlParam
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBizruleDtlParam> selectWithCondition(IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam,String conditions){
        return  ipfCcmBizruleDtlParamMapper.selectWithCondition(ipfCcmBizruleDtlParam,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBizruleDtlParam> selectBySql(String SqlStr){
        return  ipfCcmBizruleDtlParamMapper.selectBySql(SqlStr);
    }
}