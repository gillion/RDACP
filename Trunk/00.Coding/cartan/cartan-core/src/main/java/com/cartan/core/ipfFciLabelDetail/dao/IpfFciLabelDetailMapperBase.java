package com.cartan.core.ipfFciLabelDetail.dao;

import com.cartan.core.ipfFciLabelDetail.domain.IpfFciLabelDetail;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfFciLabelDetailMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_fci_label_detail s WHERE s.ID = #{id}")
	IpfFciLabelDetail getIpfFciLabelDetail(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_fci_label_detail(ID,IPF_FCI_LABEL_ID,IPF_FCI_VIEW_ID,CONFIG_ITEM_TYPE,CONFIG_ITEM_CODE,CONFIG_ITEM_ID,REVISION_NUMBER,RELATION_MEMBER_ID,IS_ACTIVE) VALUES(#{id},#{ipfFciLabelId},#{ipfFciViewId},#{configItemType},#{configItemCode},#{configItemId},#{revisionNumber},#{relationMemberId},#{isActive})")
    void createIpfFciLabelDetail(IpfFciLabelDetail ipfFciLabelDetail);
    
    @Delete("DELETE FROM cartan_common.t_ipf_fci_label_detail WHERE ID = #{id}")
    void deleteIpfFciLabelDetail(String id);

    @Update("update cartan_common.t_ipf_fci_label_detail set IPF_FCI_LABEL_ID=#{ipfFciLabelId},IPF_FCI_VIEW_ID=#{ipfFciViewId},CONFIG_ITEM_TYPE=#{configItemType},CONFIG_ITEM_CODE=#{configItemCode},CONFIG_ITEM_ID=#{configItemId},REVISION_NUMBER=#{revisionNumber},RELATION_MEMBER_ID=#{relationMemberId},IS_ACTIVE=#{isActive} where ID = #{id}")
    void updateIpfFciLabelDetail(IpfFciLabelDetail ipfFciLabelDetail);

    @Select("select count(*) c from cartan_common.t_ipf_fci_label_detail")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_fci_label_detail order by ID asc")
    ArrayList<IpfFciLabelDetail> selectAll();
    
    @SelectProvider(type = IpfFciLabelDetailSqlProvider.class, method = "getSql")
    ArrayList<IpfFciLabelDetail> selectWithCondition(@Param("ipfFciLabelDetail") IpfFciLabelDetail ipfFciLabelDetail,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfFciLabelDetail> selectBySql(@Param("SqlStr") String SqlStr);
}

