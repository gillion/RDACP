package com.cartan.core.comcode.service;

import com.cartan.core.BaseService;
import com.cartan.core.comcode.dao.ComcodeMapper;
import com.cartan.core.comcode.domain.Comcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class ComcodeServiceBase extends BaseService {
    private ComcodeMapper comcodeMapper;
    public Comcode getComcode(String id){
        return comcodeMapper.getComcode(id);
    }

    public void createComcode(Comcode comcode){
    	comcodeMapper.createComcode(comcode);
    }

    public void deleteComcode(String id){
    	comcodeMapper.deleteComcode(id);
    }

    public void updateComcode(Comcode comcode){
    	comcodeMapper.updateComcode(comcode);
    }

    public int countAll(){
       return comcodeMapper.countAll();
    }

    public ArrayList<Comcode> selectAll(){
      return comcodeMapper.selectAll();
    }
    
    public ComcodeMapper getComcodeMapper() {
    	if(this.comcodeMapper == null){
            this.comcodeMapper = this.getSqlSessionTemplate().getMapper(ComcodeMapper.class);
        }
        return this.comcodeMapper;
    }
        
    public void setComcodeMapper(ComcodeMapper comcodeMapper) {
        this.comcodeMapper = comcodeMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.comcodeMapper = sqlSessionTemplate.getMapper(ComcodeMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param comcode
     * @return
     */
    public ArrayList<Comcode> selectWithCondition(Comcode comcode){
        return  comcodeMapper.selectWithCondition(comcode,"");
    }

    /** 按条件查询
     * @param comcode
     * @conditions
     * @return
     */
    public ArrayList<Comcode> selectWithCondition(Comcode comcode,String conditions){
        return  comcodeMapper.selectWithCondition(comcode,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<Comcode> selectBySql(String SqlStr){
        return  comcodeMapper.selectBySql(SqlStr);
    }
}