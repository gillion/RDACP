package com.cartan.core.codegenerCombobox.service;

import com.cartan.core.BaseService;
import com.cartan.core.codegenerCombobox.dao.CodegenerComboboxMapper;
import com.cartan.core.codegenerCombobox.domain.CodegenerCombobox;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class CodegenerComboboxServiceBase extends BaseService {
    private CodegenerComboboxMapper codegenerComboboxMapper;
    public CodegenerCombobox getCodegenerCombobox(String id){
        return codegenerComboboxMapper.getCodegenerCombobox(id);
    }

    public void createCodegenerCombobox(CodegenerCombobox codegenerCombobox){
    	codegenerComboboxMapper.createCodegenerCombobox(codegenerCombobox);
    }

    public void deleteCodegenerCombobox(String id){
    	codegenerComboboxMapper.deleteCodegenerCombobox(id);
    }

    public void updateCodegenerCombobox(CodegenerCombobox codegenerCombobox){
    	codegenerComboboxMapper.updateCodegenerCombobox(codegenerCombobox);
    }

    public int countAll(){
       return codegenerComboboxMapper.countAll();
    }

    public ArrayList<CodegenerCombobox> selectAll(){
      return codegenerComboboxMapper.selectAll();
    }
    
    public CodegenerComboboxMapper getCodegenerComboboxMapper() {
    	if(this.codegenerComboboxMapper == null){
            this.codegenerComboboxMapper = this.getSqlSessionTemplate().getMapper(CodegenerComboboxMapper.class);
        }
        return this.codegenerComboboxMapper;
    }
        
    public void setCodegenerComboboxMapper(CodegenerComboboxMapper codegenerComboboxMapper) {
        this.codegenerComboboxMapper = codegenerComboboxMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.codegenerComboboxMapper = sqlSessionTemplate.getMapper(CodegenerComboboxMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param codegenerCombobox
     * @return
     */
    public ArrayList<CodegenerCombobox> selectWithCondition(CodegenerCombobox codegenerCombobox){
        return  codegenerComboboxMapper.selectWithCondition(codegenerCombobox,"");
    }

    /** 按条件查询
     * @param codegenerCombobox
     * @conditions
     * @return
     */
    public ArrayList<CodegenerCombobox> selectWithCondition(CodegenerCombobox codegenerCombobox,String conditions){
        return  codegenerComboboxMapper.selectWithCondition(codegenerCombobox,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<CodegenerCombobox> selectBySql(String SqlStr){
        return  codegenerComboboxMapper.selectBySql(SqlStr);
    }
}