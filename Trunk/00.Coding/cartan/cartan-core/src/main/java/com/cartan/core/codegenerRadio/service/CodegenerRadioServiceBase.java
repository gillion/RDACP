package com.cartan.core.codegenerRadio.service;

import com.cartan.core.BaseService;
import com.cartan.core.codegenerRadio.dao.CodegenerRadioMapper;
import com.cartan.core.codegenerRadio.domain.CodegenerRadio;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class CodegenerRadioServiceBase extends BaseService {
    private CodegenerRadioMapper codegenerRadioMapper;
    public CodegenerRadio getCodegenerRadio(String id){
        return codegenerRadioMapper.getCodegenerRadio(id);
    }

    public void createCodegenerRadio(CodegenerRadio codegenerRadio){
    	codegenerRadioMapper.createCodegenerRadio(codegenerRadio);
    }

    public void deleteCodegenerRadio(String id){
    	codegenerRadioMapper.deleteCodegenerRadio(id);
    }

    public void updateCodegenerRadio(CodegenerRadio codegenerRadio){
    	codegenerRadioMapper.updateCodegenerRadio(codegenerRadio);
    }

    public int countAll(){
       return codegenerRadioMapper.countAll();
    }

    public ArrayList<CodegenerRadio> selectAll(){
      return codegenerRadioMapper.selectAll();
    }
    
    public CodegenerRadioMapper getCodegenerRadioMapper() {
    	if(this.codegenerRadioMapper == null){
            this.codegenerRadioMapper = this.getSqlSessionTemplate().getMapper(CodegenerRadioMapper.class);
        }
        return this.codegenerRadioMapper;
    }
        
    public void setCodegenerRadioMapper(CodegenerRadioMapper codegenerRadioMapper) {
        this.codegenerRadioMapper = codegenerRadioMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.codegenerRadioMapper = sqlSessionTemplate.getMapper(CodegenerRadioMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param codegenerRadio
     * @return
     */
    public ArrayList<CodegenerRadio> selectWithCondition(CodegenerRadio codegenerRadio){
        return  codegenerRadioMapper.selectWithCondition(codegenerRadio,"");
    }

    /** 按条件查询
     * @param codegenerRadio
     * @conditions
     * @return
     */
    public ArrayList<CodegenerRadio> selectWithCondition(CodegenerRadio codegenerRadio,String conditions){
        return  codegenerRadioMapper.selectWithCondition(codegenerRadio,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<CodegenerRadio> selectBySql(String SqlStr){
        return  codegenerRadioMapper.selectBySql(SqlStr);
    }
}