package com.cartan.core.codegenerCheckbox.service;

import com.cartan.core.BaseService;
import com.cartan.core.codegenerCheckbox.dao.CodegenerCheckboxMapper;
import com.cartan.core.codegenerCheckbox.domain.CodegenerCheckbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class CodegenerCheckboxServiceBase extends BaseService {
    private CodegenerCheckboxMapper codegenerCheckboxMapper;
    public CodegenerCheckbox getCodegenerCheckbox(String id){
        return codegenerCheckboxMapper.getCodegenerCheckbox(id);
    }

    public void createCodegenerCheckbox(CodegenerCheckbox codegenerCheckbox){
    	codegenerCheckboxMapper.createCodegenerCheckbox(codegenerCheckbox);
    }

    public void deleteCodegenerCheckbox(String id){
    	codegenerCheckboxMapper.deleteCodegenerCheckbox(id);
    }

    public void updateCodegenerCheckbox(CodegenerCheckbox codegenerCheckbox){
    	codegenerCheckboxMapper.updateCodegenerCheckbox(codegenerCheckbox);
    }

    public int countAll(){
       return codegenerCheckboxMapper.countAll();
    }

    public ArrayList<CodegenerCheckbox> selectAll(){
      return codegenerCheckboxMapper.selectAll();
    }
    
    public CodegenerCheckboxMapper getCodegenerCheckboxMapper() {
    	if(this.codegenerCheckboxMapper == null){
            this.codegenerCheckboxMapper = this.getSqlSessionTemplate().getMapper(CodegenerCheckboxMapper.class);
        }
        return this.codegenerCheckboxMapper;
    }
        
    public void setCodegenerCheckboxMapper(CodegenerCheckboxMapper codegenerCheckboxMapper) {
        this.codegenerCheckboxMapper = codegenerCheckboxMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.codegenerCheckboxMapper = sqlSessionTemplate.getMapper(CodegenerCheckboxMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param codegenerCheckbox
     * @return
     */
    public ArrayList<CodegenerCheckbox> selectWithCondition(CodegenerCheckbox codegenerCheckbox){
        return  codegenerCheckboxMapper.selectWithCondition(codegenerCheckbox,"");
    }

    /** 按条件查询
     * @param codegenerCheckbox
     * @conditions
     * @return
     */
    public ArrayList<CodegenerCheckbox> selectWithCondition(CodegenerCheckbox codegenerCheckbox,String conditions){
        return  codegenerCheckboxMapper.selectWithCondition(codegenerCheckbox,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<CodegenerCheckbox> selectBySql(String SqlStr){
        return  codegenerCheckboxMapper.selectBySql(SqlStr);
    }
}