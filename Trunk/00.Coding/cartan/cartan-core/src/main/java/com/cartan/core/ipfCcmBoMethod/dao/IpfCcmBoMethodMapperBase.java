package com.cartan.core.ipfCcmBoMethod.dao;

import com.cartan.core.ipfCcmBoMethod.domain.IpfCcmBoMethod;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoMethodMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_method s WHERE s.ID = #{id}")
	IpfCcmBoMethod getIpfCcmBoMethod(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_method(ID,IPF_CCM_BO_ID,BO_TYPE,BO_REF_ID,ICON,REMARK,METHOD_DESC,METHOD_NAME,METHOD_TYPE,URL,IS_DEFAULT,IS_VISIBLE,REF_SHLP_NAME,RULE_NO,JUMP_METHOD_ID,JUMP_METHOD_NAME,JUMP_BO_NAME,WIDTH,HEIGHT,GROUP_NAME,GROUP_DESC,IS_CACHE,CACHE_TYPE,REQUEST_TYPE,JUMP_WINDOW_TITLE,IS_REFRESH_PARENT_BO) VALUES(#{id},#{ipfCcmBoId},#{boType},#{boRefId},#{icon},#{remark},#{methodDesc},#{methodName},#{methodType},#{url},#{isDefault},#{isVisible},#{refShlpName},#{ruleNo},#{jumpMethodId},#{jumpMethodName},#{jumpBoName},#{width},#{height},#{groupName},#{groupDesc},#{isCache},#{cacheType},#{requestType},#{jumpWindowTitle},#{isRefreshParentBo})")
    void createIpfCcmBoMethod(IpfCcmBoMethod ipfCcmBoMethod);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_method WHERE ID = #{id}")
    void deleteIpfCcmBoMethod(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_method set IPF_CCM_BO_ID=#{ipfCcmBoId},BO_TYPE=#{boType},BO_REF_ID=#{boRefId},ICON=#{icon},REMARK=#{remark},METHOD_DESC=#{methodDesc},METHOD_NAME=#{methodName},METHOD_TYPE=#{methodType},URL=#{url},IS_DEFAULT=#{isDefault},IS_VISIBLE=#{isVisible},REF_SHLP_NAME=#{refShlpName},RULE_NO=#{ruleNo},JUMP_METHOD_ID=#{jumpMethodId},JUMP_METHOD_NAME=#{jumpMethodName},JUMP_BO_NAME=#{jumpBoName},WIDTH=#{width},HEIGHT=#{height},GROUP_NAME=#{groupName},GROUP_DESC=#{groupDesc},IS_CACHE=#{isCache},CACHE_TYPE=#{cacheType},REQUEST_TYPE=#{requestType},JUMP_WINDOW_TITLE=#{jumpWindowTitle},IS_REFRESH_PARENT_BO=#{isRefreshParentBo} where ID = #{id}")
    void updateIpfCcmBoMethod(IpfCcmBoMethod ipfCcmBoMethod);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_method")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_method order by ID asc")
    ArrayList<IpfCcmBoMethod> selectAll();
    
    @SelectProvider(type = IpfCcmBoMethodSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoMethod> selectWithCondition(@Param("ipfCcmBoMethod") IpfCcmBoMethod ipfCcmBoMethod,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoMethod> selectBySql(@Param("SqlStr") String SqlStr);
}

