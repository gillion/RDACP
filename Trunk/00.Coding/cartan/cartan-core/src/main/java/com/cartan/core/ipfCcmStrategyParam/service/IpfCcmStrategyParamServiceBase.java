package com.cartan.core.ipfCcmStrategyParam.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmStrategyParam.dao.IpfCcmStrategyParamMapper;
import com.cartan.core.ipfCcmStrategyParam.domain.IpfCcmStrategyParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmStrategyParamServiceBase extends BaseService {
    private IpfCcmStrategyParamMapper ipfCcmStrategyParamMapper;
    public IpfCcmStrategyParam getIpfCcmStrategyParam(String id){
        return ipfCcmStrategyParamMapper.getIpfCcmStrategyParam(id);
    }

    public void createIpfCcmStrategyParam(IpfCcmStrategyParam ipfCcmStrategyParam){
    	ipfCcmStrategyParamMapper.createIpfCcmStrategyParam(ipfCcmStrategyParam);
    }

    public void deleteIpfCcmStrategyParam(String id){
    	ipfCcmStrategyParamMapper.deleteIpfCcmStrategyParam(id);
    }

    public void updateIpfCcmStrategyParam(IpfCcmStrategyParam ipfCcmStrategyParam){
    	ipfCcmStrategyParamMapper.updateIpfCcmStrategyParam(ipfCcmStrategyParam);
    }

    public int countAll(){
       return ipfCcmStrategyParamMapper.countAll();
    }

    public ArrayList<IpfCcmStrategyParam> selectAll(){
      return ipfCcmStrategyParamMapper.selectAll();
    }
    
    public IpfCcmStrategyParamMapper getIpfCcmStrategyParamMapper() {
    	if(this.ipfCcmStrategyParamMapper == null){
            this.ipfCcmStrategyParamMapper = this.getSqlSessionTemplate().getMapper(IpfCcmStrategyParamMapper.class);
        }
        return this.ipfCcmStrategyParamMapper;
    }
        
    public void setIpfCcmStrategyParamMapper(IpfCcmStrategyParamMapper ipfCcmStrategyParamMapper) {
        this.ipfCcmStrategyParamMapper = ipfCcmStrategyParamMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmStrategyParamMapper = sqlSessionTemplate.getMapper(IpfCcmStrategyParamMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmStrategyParam
     * @return
     */
    public ArrayList<IpfCcmStrategyParam> selectWithCondition(IpfCcmStrategyParam ipfCcmStrategyParam){
        return  ipfCcmStrategyParamMapper.selectWithCondition(ipfCcmStrategyParam,"");
    }

    /** 按条件查询
     * @param ipfCcmStrategyParam
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmStrategyParam> selectWithCondition(IpfCcmStrategyParam ipfCcmStrategyParam,String conditions){
        return  ipfCcmStrategyParamMapper.selectWithCondition(ipfCcmStrategyParam,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmStrategyParam> selectBySql(String SqlStr){
        return  ipfCcmStrategyParamMapper.selectBySql(SqlStr);
    }
}