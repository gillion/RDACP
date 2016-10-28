package com.cartan.core.codegener.service;

import com.cartan.core.BaseService;
import com.cartan.core.codegener.dao.CodegenerMapper;
import com.cartan.core.codegener.domain.Codegener;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class CodegenerServiceBase extends BaseService {
    private CodegenerMapper codegenerMapper;
    public Codegener getCodegener(String id){
        return codegenerMapper.getCodegener(id);
    }

    public void createCodegener(Codegener codegener){
    	codegenerMapper.createCodegener(codegener);
    }

    public void deleteCodegener(String id){
    	codegenerMapper.deleteCodegener(id);
    }

    public void updateCodegener(Codegener codegener){
    	codegenerMapper.updateCodegener(codegener);
    }

    public int countAll(){
       return codegenerMapper.countAll();
    }

    public ArrayList<Codegener> selectAll(){
      return codegenerMapper.selectAll();
    }
    
    public CodegenerMapper getCodegenerMapper() {
    	if(this.codegenerMapper == null){
            this.codegenerMapper = this.getSqlSessionTemplate().getMapper(CodegenerMapper.class);
        }
        return this.codegenerMapper;
    }
        
    public void setCodegenerMapper(CodegenerMapper codegenerMapper) {
        this.codegenerMapper = codegenerMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.codegenerMapper = sqlSessionTemplate.getMapper(CodegenerMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param codegener
     * @return
     */
    public ArrayList<Codegener> selectWithCondition(Codegener codegener){
        return  codegenerMapper.selectWithCondition(codegener,"");
    }

    /** 按条件查询
     * @param codegener
     * @conditions
     * @return
     */
    public ArrayList<Codegener> selectWithCondition(Codegener codegener,String conditions){
        return  codegenerMapper.selectWithCondition(codegener,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<Codegener> selectBySql(String SqlStr){
        return  codegenerMapper.selectBySql(SqlStr);
    }
}