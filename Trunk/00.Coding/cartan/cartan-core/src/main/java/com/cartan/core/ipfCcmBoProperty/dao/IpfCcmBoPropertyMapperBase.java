package com.cartan.core.ipfCcmBoProperty.dao;

import com.cartan.core.ipfCcmBoProperty.domain.IpfCcmBoProperty;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoPropertyMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_property s WHERE s.ID = #{id}")
	IpfCcmBoProperty getIpfCcmBoProperty(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_property(ID,PROPERTY_NAME,COLUMN_NAME,PROPERTY_TYPE,SUB_BO_LAYOUT_TYPE,TABLE_NAME,MAX_VALUE,MIN_VALUE,ELEMENT_CODE,FIELD_TEXT,DATA_TYPE,FIELD_LENGTH,DECIMALS,IS_NOT_NULL,IS_KEY,SUB_BO_NAME,SUB_BO_REL_TYPE,SUB_BO_REL_PRO,SUB_BO_ORDER_NO,PERSISTENT_SAVE_TYPE,REL_SUB_BO_PRO_NAME,SEARCH_HELP,REF_PRO_NAME,DICT_TABLE_NAME,DICT_GROUP_VALUE,FETCH_WAY,FIX_VALUE,VALUE_EXPRESSION,VLAUE_RULE_NO,PRE_CONDITION,OPT_CONDITION,IS_SURCHARGE,IS_REALTIME_CALCULATE,RP_TYPE,CUST_ID_PROPERTY_NAME,BUSINESS_DATE_PROPERTY_NAME,IPF_CCM_BO_ID,AUTH_FIELD,HELP_INDEX,NUMBER_OBJECT_ID,REL_BO_METHOD,REL_BO_NAME,SH_TABLE,SH_VALUE_COLUMN,VALIDACTION_TYPE,VALIDACTION_REGEX) VALUES(#{id},#{propertyName},#{columnName},#{propertyType},#{subBoLayoutType},#{tableName},#{maxValue},#{minValue},#{elementCode},#{fieldText},#{dataType},#{fieldLength},#{decimals},#{isNotNull},#{isKey},#{subBoName},#{subBoRelType},#{subBoRelPro},#{subBoOrderNo},#{persistentSaveType},#{relSubBoProName},#{searchHelp},#{refProName},#{dictTableName},#{dictGroupValue},#{fetchWay},#{fixValue},#{valueExpression},#{vlaueRuleNo},#{preCondition},#{optCondition},#{isSurcharge},#{isRealtimeCalculate},#{rpType},#{custIdPropertyName},#{businessDatePropertyName},#{ipfCcmBoId},#{authField},#{helpIndex},#{numberObjectId},#{relBoMethod},#{relBoName},#{shTable},#{shValueColumn},#{validactionType},#{validactionRegex})")
    void createIpfCcmBoProperty(IpfCcmBoProperty ipfCcmBoProperty);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_property WHERE ID = #{id}")
    void deleteIpfCcmBoProperty(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_property set PROPERTY_NAME=#{propertyName},COLUMN_NAME=#{columnName},PROPERTY_TYPE=#{propertyType},SUB_BO_LAYOUT_TYPE=#{subBoLayoutType},TABLE_NAME=#{tableName},MAX_VALUE=#{maxValue},MIN_VALUE=#{minValue},ELEMENT_CODE=#{elementCode},FIELD_TEXT=#{fieldText},DATA_TYPE=#{dataType},FIELD_LENGTH=#{fieldLength},DECIMALS=#{decimals},IS_NOT_NULL=#{isNotNull},IS_KEY=#{isKey},SUB_BO_NAME=#{subBoName},SUB_BO_REL_TYPE=#{subBoRelType},SUB_BO_REL_PRO=#{subBoRelPro},SUB_BO_ORDER_NO=#{subBoOrderNo},PERSISTENT_SAVE_TYPE=#{persistentSaveType},REL_SUB_BO_PRO_NAME=#{relSubBoProName},SEARCH_HELP=#{searchHelp},REF_PRO_NAME=#{refProName},DICT_TABLE_NAME=#{dictTableName},DICT_GROUP_VALUE=#{dictGroupValue},FETCH_WAY=#{fetchWay},FIX_VALUE=#{fixValue},VALUE_EXPRESSION=#{valueExpression},VLAUE_RULE_NO=#{vlaueRuleNo},PRE_CONDITION=#{preCondition},OPT_CONDITION=#{optCondition},IS_SURCHARGE=#{isSurcharge},IS_REALTIME_CALCULATE=#{isRealtimeCalculate},RP_TYPE=#{rpType},CUST_ID_PROPERTY_NAME=#{custIdPropertyName},BUSINESS_DATE_PROPERTY_NAME=#{businessDatePropertyName},IPF_CCM_BO_ID=#{ipfCcmBoId},AUTH_FIELD=#{authField},HELP_INDEX=#{helpIndex},NUMBER_OBJECT_ID=#{numberObjectId},REL_BO_METHOD=#{relBoMethod},REL_BO_NAME=#{relBoName},SH_TABLE=#{shTable},SH_VALUE_COLUMN=#{shValueColumn},VALIDACTION_TYPE=#{validactionType},VALIDACTION_REGEX=#{validactionRegex} where ID = #{id}")
    void updateIpfCcmBoProperty(IpfCcmBoProperty ipfCcmBoProperty);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_property")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_property order by ID asc")
    ArrayList<IpfCcmBoProperty> selectAll();
    
    @SelectProvider(type = IpfCcmBoPropertySqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoProperty> selectWithCondition(@Param("ipfCcmBoProperty") IpfCcmBoProperty ipfCcmBoProperty,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoProperty> selectBySql(@Param("SqlStr") String SqlStr);
}

