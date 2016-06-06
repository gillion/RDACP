package com.cartan.core.ipfCcmBoFormCell.dao;

import com.cartan.core.ipfCcmBoFormCell.domain.IpfCcmBoFormCell;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoFormCellMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_form_cell s WHERE s.ID = #{id}")
	IpfCcmBoFormCell getIpfCcmBoFormCell(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_form_cell(ID,IPF_CCM_BO_ID,FORM_TYPE,IS_DEFAULT,CELL_NAME,CELL_TYPE,CELL_HEIGH,IS_SHOW_GROUP,GROUP_WIDGET,ELEMENT_CODE,GROUP_TITLE,UNIT_COUNT,IS_PARENT,CHILDREN_LINE_COUNT,PARENT_CELL_NAME,ROW_NO,COLUMN_NO,LABEL_UNIT_COUNT) VALUES(#{id},#{ipfCcmBoId},#{formType},#{isDefault},#{cellName},#{cellType},#{cellHeigh},#{isShowGroup},#{groupWidget},#{elementCode},#{groupTitle},#{unitCount},#{isParent},#{childrenLineCount},#{parentCellName},#{rowNo},#{columnNo},#{labelUnitCount})")
    void createIpfCcmBoFormCell(IpfCcmBoFormCell ipfCcmBoFormCell);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_form_cell WHERE ID = #{id}")
    void deleteIpfCcmBoFormCell(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_form_cell set IPF_CCM_BO_ID=#{ipfCcmBoId},FORM_TYPE=#{formType},IS_DEFAULT=#{isDefault},CELL_NAME=#{cellName},CELL_TYPE=#{cellType},CELL_HEIGH=#{cellHeigh},IS_SHOW_GROUP=#{isShowGroup},GROUP_WIDGET=#{groupWidget},ELEMENT_CODE=#{elementCode},GROUP_TITLE=#{groupTitle},UNIT_COUNT=#{unitCount},IS_PARENT=#{isParent},CHILDREN_LINE_COUNT=#{childrenLineCount},PARENT_CELL_NAME=#{parentCellName},ROW_NO=#{rowNo},COLUMN_NO=#{columnNo},LABEL_UNIT_COUNT=#{labelUnitCount} where ID = #{id}")
    void updateIpfCcmBoFormCell(IpfCcmBoFormCell ipfCcmBoFormCell);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_form_cell")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_form_cell order by ID asc")
    ArrayList<IpfCcmBoFormCell> selectAll();
    
    @SelectProvider(type = IpfCcmBoFormCellSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoFormCell> selectWithCondition(@Param("ipfCcmBoFormCell") IpfCcmBoFormCell ipfCcmBoFormCell,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoFormCell> selectBySql(@Param("SqlStr") String SqlStr);
}

