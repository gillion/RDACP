package com.cartan.core.comstyle.service;

import com.cartan.core.BaseService;
import com.cartan.core.comstyle.dao.ComstyleMapper;
import com.cartan.core.comstyle.domain.Comstyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class ComstyleServiceBase extends BaseService {
    private ComstyleMapper comstyleMapper;
    public Comstyle getComstyle(String id){
        return comstyleMapper.getComstyle(id);
    }

    public void createComstyle(Comstyle comstyle){
    	comstyleMapper.createComstyle(comstyle);
    }

    public void deleteComstyle(String id){
    	comstyleMapper.deleteComstyle(id);
    }

    public void updateComstyle(Comstyle comstyle){
    	comstyleMapper.updateComstyle(comstyle);
    }

    public int countAll(){
       return comstyleMapper.countAll();
    }

    public ArrayList<Comstyle> selectAll(){
      return comstyleMapper.selectAll();
    }
    
    public ComstyleMapper getComstyleMapper() {
    	if(this.comstyleMapper == null){
            this.comstyleMapper = this.getSqlSessionTemplate().getMapper(ComstyleMapper.class);
        }
        return this.comstyleMapper;
    }
        
    public void setComstyleMapper(ComstyleMapper comstyleMapper) {
        this.comstyleMapper = comstyleMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.comstyleMapper = sqlSessionTemplate.getMapper(ComstyleMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param comstyle
     * @return
     */
    public ArrayList<Comstyle> selectWithCondition(Comstyle comstyle){
        return  comstyleMapper.selectWithCondition(comstyle,"");
    }

    /** 按条件查询
     * @param comstyle
     * @conditions
     * @return
     */
    public ArrayList<Comstyle> selectWithCondition(Comstyle comstyle,String conditions){
        return  comstyleMapper.selectWithCondition(comstyle,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<Comstyle> selectBySql(String SqlStr){
        return  comstyleMapper.selectBySql(SqlStr);
    }
}