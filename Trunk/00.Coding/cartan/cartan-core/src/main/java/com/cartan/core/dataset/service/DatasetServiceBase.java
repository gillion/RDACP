package com.cartan.core.dataset.service;

import com.cartan.core.BaseService;
import com.cartan.core.dataset.dao.DatasetMapper;
import com.cartan.core.dataset.domain.Dataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class DatasetServiceBase extends BaseService {
    private DatasetMapper datasetMapper;
    public Dataset getDataset(String id){
        return datasetMapper.getDataset(id);
    }

    public void createDataset(Dataset dataset){
    	datasetMapper.createDataset(dataset);
    }

    public void deleteDataset(String id){
    	datasetMapper.deleteDataset(id);
    }

    public void updateDataset(Dataset dataset){
    	datasetMapper.updateDataset(dataset);
    }

    public int countAll(){
       return datasetMapper.countAll();
    }

    public ArrayList<Dataset> selectAll(){
      return datasetMapper.selectAll();
    }
    
    public DatasetMapper getDatasetMapper() {
    	if(this.datasetMapper == null){
            this.datasetMapper = this.getSqlSessionTemplate().getMapper(DatasetMapper.class);
        }
        return this.datasetMapper;
    }
        
    public void setDatasetMapper(DatasetMapper datasetMapper) {
        this.datasetMapper = datasetMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.datasetMapper = sqlSessionTemplate.getMapper(DatasetMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param dataset
     * @return
     */
    public ArrayList<Dataset> selectWithCondition(Dataset dataset){
        return  datasetMapper.selectWithCondition(dataset,"");
    }

    /** 按条件查询
     * @param dataset
     * @conditions
     * @return
     */
    public ArrayList<Dataset> selectWithCondition(Dataset dataset,String conditions){
        return  datasetMapper.selectWithCondition(dataset,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<Dataset> selectBySql(String SqlStr){
        return  datasetMapper.selectBySql(SqlStr);
    }
}