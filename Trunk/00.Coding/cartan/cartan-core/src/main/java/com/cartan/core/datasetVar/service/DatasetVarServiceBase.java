package com.cartan.core.datasetVar.service;

import com.cartan.core.BaseService;
import com.cartan.core.datasetVar.dao.DatasetVarMapper;
import com.cartan.core.datasetVar.domain.DatasetVar;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class DatasetVarServiceBase extends BaseService {
    private DatasetVarMapper datasetVarMapper;
    public DatasetVar getDatasetVar(String id){
        return datasetVarMapper.getDatasetVar(id);
    }

    public void createDatasetVar(DatasetVar datasetVar){
    	datasetVarMapper.createDatasetVar(datasetVar);
    }

    public void deleteDatasetVar(String id){
    	datasetVarMapper.deleteDatasetVar(id);
    }

    public void updateDatasetVar(DatasetVar datasetVar){
    	datasetVarMapper.updateDatasetVar(datasetVar);
    }

    public int countAll(){
       return datasetVarMapper.countAll();
    }

    public ArrayList<DatasetVar> selectAll(){
      return datasetVarMapper.selectAll();
    }
    
    public DatasetVarMapper getDatasetVarMapper() {
    	if(this.datasetVarMapper == null){
            this.datasetVarMapper = this.getSqlSessionTemplate().getMapper(DatasetVarMapper.class);
        }
        return this.datasetVarMapper;
    }
        
    public void setDatasetVarMapper(DatasetVarMapper datasetVarMapper) {
        this.datasetVarMapper = datasetVarMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.datasetVarMapper = sqlSessionTemplate.getMapper(DatasetVarMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param datasetVar
     * @return
     */
    public ArrayList<DatasetVar> selectWithCondition(DatasetVar datasetVar){
        return  datasetVarMapper.selectWithCondition(datasetVar,"");
    }

    /** 按条件查询
     * @param datasetVar
     * @conditions
     * @return
     */
    public ArrayList<DatasetVar> selectWithCondition(DatasetVar datasetVar,String conditions){
        return  datasetVarMapper.selectWithCondition(datasetVar,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<DatasetVar> selectBySql(String SqlStr){
        return  datasetVarMapper.selectBySql(SqlStr);
    }
}