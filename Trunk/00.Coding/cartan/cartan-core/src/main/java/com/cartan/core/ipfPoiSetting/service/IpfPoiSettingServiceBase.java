package com.cartan.core.ipfPoiSetting.service;

import com.cartan.core.BaseService;
import com.cartan.core.ipfPoiSetting.dao.IpfPoiSettingMapper;
import com.cartan.core.ipfPoiSetting.domain.IpfPoiSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class IpfPoiSettingServiceBase extends BaseService {
    private IpfPoiSettingMapper ipfPoiSettingMapper;
    public IpfPoiSetting getIpfPoiSetting(String id){
        return ipfPoiSettingMapper.getIpfPoiSetting(id);
    }

    public void createIpfPoiSetting(IpfPoiSetting ipfPoiSetting){
    	ipfPoiSettingMapper.createIpfPoiSetting(ipfPoiSetting);
    }

    public void deleteIpfPoiSetting(String id){
    	ipfPoiSettingMapper.deleteIpfPoiSetting(id);
    }

    public void updateIpfPoiSetting(IpfPoiSetting ipfPoiSetting){
    	ipfPoiSettingMapper.updateIpfPoiSetting(ipfPoiSetting);
    }

    public int countAll(){
       return ipfPoiSettingMapper.countAll();
    }

    public ArrayList<IpfPoiSetting> selectAll(){
      return ipfPoiSettingMapper.selectAll();
    }
    
    public IpfPoiSettingMapper getIpfPoiSettingMapper() {
    	if(this.ipfPoiSettingMapper == null){
            this.ipfPoiSettingMapper = this.getSqlSessionTemplate().getMapper(IpfPoiSettingMapper.class);
        }
        return this.ipfPoiSettingMapper;
    }
        
    public void setIpfPoiSettingMapper(IpfPoiSettingMapper ipfPoiSettingMapper) {
        this.ipfPoiSettingMapper = ipfPoiSettingMapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.ipfPoiSettingMapper = sqlSessionTemplate.getMapper(IpfPoiSettingMapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ipfPoiSetting
     * @return
     */
    public ArrayList<IpfPoiSetting> selectWithCondition(IpfPoiSetting ipfPoiSetting){
        return  ipfPoiSettingMapper.selectWithCondition(ipfPoiSetting,"");
    }

    /** 按条件查询
     * @param ipfPoiSetting
     * @conditions
     * @return
     */
    public ArrayList<IpfPoiSetting> selectWithCondition(IpfPoiSetting ipfPoiSetting,String conditions){
        return  ipfPoiSettingMapper.selectWithCondition(ipfPoiSetting,conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<IpfPoiSetting> selectBySql(String SqlStr){
        return  ipfPoiSettingMapper.selectBySql(SqlStr);
    }
}