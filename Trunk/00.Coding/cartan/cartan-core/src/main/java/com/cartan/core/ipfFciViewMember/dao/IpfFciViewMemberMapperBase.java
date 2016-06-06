package com.cartan.core.ipfFciViewMember.dao;

import com.cartan.core.ipfFciViewMember.domain.IpfFciViewMember;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfFciViewMemberMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_fci_view_member s WHERE s.ID = #{id}")
	IpfFciViewMember getIpfFciViewMember(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_fci_view_member(ID,IPF_FCI_VIEW_ID,CONFIG_ITEM_TYPE,CONFIG_ITEM_CODE,CONFIG_ITEM_ID,REVISION_NUMBER,SOURCE_TYPE,SOURCE_ITEM_ID,RELATION_MEMBER_ID,IS_LOCK,LOCK_USER,LOCK_TIME,IS_ACTIVE) VALUES(#{id},#{ipfFciViewId},#{configItemType},#{configItemCode},#{configItemId},#{revisionNumber},#{sourceType},#{sourceItemId},#{relationMemberId},#{isLock},#{lockUser},#{lockTime},#{isActive})")
    void createIpfFciViewMember(IpfFciViewMember ipfFciViewMember);
    
    @Delete("DELETE FROM cartan_common.t_ipf_fci_view_member WHERE ID = #{id}")
    void deleteIpfFciViewMember(String id);

    @Update("update cartan_common.t_ipf_fci_view_member set IPF_FCI_VIEW_ID=#{ipfFciViewId},CONFIG_ITEM_TYPE=#{configItemType},CONFIG_ITEM_CODE=#{configItemCode},CONFIG_ITEM_ID=#{configItemId},REVISION_NUMBER=#{revisionNumber},SOURCE_TYPE=#{sourceType},SOURCE_ITEM_ID=#{sourceItemId},RELATION_MEMBER_ID=#{relationMemberId},IS_LOCK=#{isLock},LOCK_USER=#{lockUser},LOCK_TIME=#{lockTime},IS_ACTIVE=#{isActive} where ID = #{id}")
    void updateIpfFciViewMember(IpfFciViewMember ipfFciViewMember);

    @Select("select count(*) c from cartan_common.t_ipf_fci_view_member")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_fci_view_member order by ID asc")
    ArrayList<IpfFciViewMember> selectAll();
    
    @SelectProvider(type = IpfFciViewMemberSqlProvider.class, method = "getSql")
    ArrayList<IpfFciViewMember> selectWithCondition(@Param("ipfFciViewMember") IpfFciViewMember ipfFciViewMember,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfFciViewMember> selectBySql(@Param("SqlStr") String SqlStr);
}

