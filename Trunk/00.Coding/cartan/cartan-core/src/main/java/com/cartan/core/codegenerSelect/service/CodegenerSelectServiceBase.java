package com.cartan.core.codegenerSelect.service;

import com.cartan.core.BaseService;
import com.cartan.core.codegenerSelect.dao.CodegenerSelectMapper;
import com.cartan.core.codegenerSelect.domain.CodegenerSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class CodegenerSelectServiceBase extends BaseService {
    private CodegenerSelectMapper codegenerSelectMapper;
    public CodegenerSelect getCodegenerSelect(String id){
        return codegenerSelectMapper.getCodegenerSelect(id);
    }

    public void createCodegenerSelect(CodegenerSelect codegenerSelect){
    	codegenerSelectMapper.createCodegenerSelect(codegenerSelect);
    }

    public void deleteCodegenerSelect(String id){
    	codegenerSelectMapper.deleteCodegenerSelect(id);
    }

    public void updateCodegenerSelect(CodegenerSelect codegenerSelect){
    	codegenerSelectMapper.updateCodegenerSelect(codegenerSelect);
    }

    public int countAll(){
       return codegenerSelectMapper.countAll();
    }

    public ArrayList<CodegenerSelect> selectAll(){
      return codegenerSelectMapper.selectAll();
    }
    
    public CodegenerSelectMapper getCodegenerSelectMapper() {
    	if(this.codegenerSelectMapper == null){
            this.codegenerSelectMapper = this.getSqlSessionTemplate().getMapper(CodegenerSelectMapper.class);
        }
        return this.codegenerSelectMapper;
    }
        
    public void setCodegenerSelectMapper(CodegenerSelectMapper codegenerSelectMapper) {
        this.codegenerSelectMapper = codegenerSelectMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.codegenerSelectMapper = sqlSessionTemplate.getMapper(CodegenerSelectMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param codegenerSelect
     * @return
     */
    public ArrayList<CodegenerSelect> selectWithCondition(CodegenerSelect codegenerSelect){
        return  codegenerSelectMapper.selectWithCondition(codegenerSelect,"");
    }

    /** 按条件查询
     * @param codegenerSelect
     * @conditions
     * @return
     */
    public ArrayList<CodegenerSelect> selectWithCondition(CodegenerSelect codegenerSelect,String conditions){
        return  codegenerSelectMapper.selectWithCondition(codegenerSelect,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<CodegenerSelect> selectBySql(String SqlStr){
        return  codegenerSelectMapper.selectBySql(SqlStr);
    }
}