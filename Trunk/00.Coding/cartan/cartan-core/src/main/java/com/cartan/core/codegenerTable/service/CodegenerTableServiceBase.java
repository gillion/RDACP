package com.cartan.core.codegenerTable.service;

import com.cartan.core.BaseService;
import com.cartan.core.codegenerTable.dao.CodegenerTableMapper;
import com.cartan.core.codegenerTable.domain.CodegenerTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class CodegenerTableServiceBase extends BaseService {
    private CodegenerTableMapper codegenerTableMapper;
    public CodegenerTable getCodegenerTable(String id){
        return codegenerTableMapper.getCodegenerTable(id);
    }

    public void createCodegenerTable(CodegenerTable codegenerTable){
    	codegenerTableMapper.createCodegenerTable(codegenerTable);
    }

    public void deleteCodegenerTable(String id){
    	codegenerTableMapper.deleteCodegenerTable(id);
    }

    public void updateCodegenerTable(CodegenerTable codegenerTable){
    	codegenerTableMapper.updateCodegenerTable(codegenerTable);
    }

    public int countAll(){
       return codegenerTableMapper.countAll();
    }

    public ArrayList<CodegenerTable> selectAll(){
      return codegenerTableMapper.selectAll();
    }
    
    public CodegenerTableMapper getCodegenerTableMapper() {
    	if(this.codegenerTableMapper == null){
            this.codegenerTableMapper = this.getSqlSessionTemplate().getMapper(CodegenerTableMapper.class);
        }
        return this.codegenerTableMapper;
    }
        
    public void setCodegenerTableMapper(CodegenerTableMapper codegenerTableMapper) {
        this.codegenerTableMapper = codegenerTableMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.codegenerTableMapper = sqlSessionTemplate.getMapper(CodegenerTableMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param codegenerTable
     * @return
     */
    public ArrayList<CodegenerTable> selectWithCondition(CodegenerTable codegenerTable){
        return  codegenerTableMapper.selectWithCondition(codegenerTable,"");
    }

    /** 按条件查询
     * @param codegenerTable
     * @conditions
     * @return
     */
    public ArrayList<CodegenerTable> selectWithCondition(CodegenerTable codegenerTable,String conditions){
        return  codegenerTableMapper.selectWithCondition(codegenerTable,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<CodegenerTable> selectBySql(String SqlStr){
        return  codegenerTableMapper.selectBySql(SqlStr);
    }
}