package com.cartan.core.ipfCcmTemplate.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmTemplate.dao.IpfCcmTemplateMapper;
import com.cartan.core.ipfCcmTemplate.domain.IpfCcmTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmTemplateServiceBase extends BaseService {
    private IpfCcmTemplateMapper ipfCcmTemplateMapper;
    public IpfCcmTemplate getIpfCcmTemplate(String id){
        return ipfCcmTemplateMapper.getIpfCcmTemplate(id);
    }

    public void createIpfCcmTemplate(IpfCcmTemplate ipfCcmTemplate){
    	ipfCcmTemplateMapper.createIpfCcmTemplate(ipfCcmTemplate);
    }

    public void deleteIpfCcmTemplate(String id){
    	ipfCcmTemplateMapper.deleteIpfCcmTemplate(id);
    }

    public void updateIpfCcmTemplate(IpfCcmTemplate ipfCcmTemplate){
    	ipfCcmTemplateMapper.updateIpfCcmTemplate(ipfCcmTemplate);
    }

    public int countAll(){
       return ipfCcmTemplateMapper.countAll();
    }

    public ArrayList<IpfCcmTemplate> selectAll(){
      return ipfCcmTemplateMapper.selectAll();
    }
    
    public IpfCcmTemplateMapper getIpfCcmTemplateMapper() {
    	if(this.ipfCcmTemplateMapper == null){
            this.ipfCcmTemplateMapper = this.getSqlSessionTemplate().getMapper(IpfCcmTemplateMapper.class);
        }
        return this.ipfCcmTemplateMapper;
    }
        
    public void setIpfCcmTemplateMapper(IpfCcmTemplateMapper ipfCcmTemplateMapper) {
        this.ipfCcmTemplateMapper = ipfCcmTemplateMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmTemplateMapper = sqlSessionTemplate.getMapper(IpfCcmTemplateMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmTemplate
     * @return
     */
    public ArrayList<IpfCcmTemplate> selectWithCondition(IpfCcmTemplate ipfCcmTemplate){
        return  ipfCcmTemplateMapper.selectWithCondition(ipfCcmTemplate,"");
    }

    /** 按条件查询
     * @param ipfCcmTemplate
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmTemplate> selectWithCondition(IpfCcmTemplate ipfCcmTemplate,String conditions){
        return  ipfCcmTemplateMapper.selectWithCondition(ipfCcmTemplate,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmTemplate> selectBySql(String SqlStr){
        return  ipfCcmTemplateMapper.selectBySql(SqlStr);
    }
}