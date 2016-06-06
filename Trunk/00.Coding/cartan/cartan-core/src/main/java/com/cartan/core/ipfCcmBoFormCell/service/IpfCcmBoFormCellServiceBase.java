package com.cartan.core.ipfCcmBoFormCell.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfCcmBoFormCell.dao.IpfCcmBoFormCellMapper;
import com.cartan.core.ipfCcmBoFormCell.domain.IpfCcmBoFormCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfCcmBoFormCellServiceBase extends BaseService {
    private IpfCcmBoFormCellMapper ipfCcmBoFormCellMapper;
    public IpfCcmBoFormCell getIpfCcmBoFormCell(String id){
        return ipfCcmBoFormCellMapper.getIpfCcmBoFormCell(id);
    }

    public void createIpfCcmBoFormCell(IpfCcmBoFormCell ipfCcmBoFormCell){
    	ipfCcmBoFormCellMapper.createIpfCcmBoFormCell(ipfCcmBoFormCell);
    }

    public void deleteIpfCcmBoFormCell(String id){
    	ipfCcmBoFormCellMapper.deleteIpfCcmBoFormCell(id);
    }

    public void updateIpfCcmBoFormCell(IpfCcmBoFormCell ipfCcmBoFormCell){
    	ipfCcmBoFormCellMapper.updateIpfCcmBoFormCell(ipfCcmBoFormCell);
    }

    public int countAll(){
       return ipfCcmBoFormCellMapper.countAll();
    }

    public ArrayList<IpfCcmBoFormCell> selectAll(){
      return ipfCcmBoFormCellMapper.selectAll();
    }
    
    public IpfCcmBoFormCellMapper getIpfCcmBoFormCellMapper() {
    	if(this.ipfCcmBoFormCellMapper == null){
            this.ipfCcmBoFormCellMapper = this.getSqlSessionTemplate().getMapper(IpfCcmBoFormCellMapper.class);
        }
        return this.ipfCcmBoFormCellMapper;
    }
        
    public void setIpfCcmBoFormCellMapper(IpfCcmBoFormCellMapper ipfCcmBoFormCellMapper) {
        this.ipfCcmBoFormCellMapper = ipfCcmBoFormCellMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfCcmBoFormCellMapper = sqlSessionTemplate.getMapper(IpfCcmBoFormCellMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfCcmBoFormCell
     * @return
     */
    public ArrayList<IpfCcmBoFormCell> selectWithCondition(IpfCcmBoFormCell ipfCcmBoFormCell){
        return  ipfCcmBoFormCellMapper.selectWithCondition(ipfCcmBoFormCell,"");
    }

    /** 按条件查询
     * @param ipfCcmBoFormCell
     * @conditions
     * @return
     */
    public ArrayList<IpfCcmBoFormCell> selectWithCondition(IpfCcmBoFormCell ipfCcmBoFormCell,String conditions){
        return  ipfCcmBoFormCellMapper.selectWithCondition(ipfCcmBoFormCell,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfCcmBoFormCell> selectBySql(String SqlStr){
        return  ipfCcmBoFormCellMapper.selectBySql(SqlStr);
    }
}