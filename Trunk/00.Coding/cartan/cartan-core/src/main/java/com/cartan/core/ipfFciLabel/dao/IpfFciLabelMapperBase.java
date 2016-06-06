package com.cartan.core.ipfFciLabel.dao;

import com.cartan.core.ipfFciLabel.domain.IpfFciLabel;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfFciLabelMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_fci_label s WHERE s.ID = #{id}")
	IpfFciLabel getIpfFciLabel(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_fci_label(ID,IPF_FCI_VIEW_ID,LABEL_NAME,LABEL_DESC,IPF_FCI_BUILD_ID,MAJOR_VERSION,MINOR_VERSION,VERSION_BUILD_NUMBER,REVISION_NUMBER,SVN_REVISION,SVN_TAGS_PATH,IS_ACTIVE,VIEW_NAME) VALUES(#{id},#{ipfFciViewId},#{labelName},#{labelDesc},#{ipfFciBuildId},#{majorVersion},#{minorVersion},#{versionBuildNumber},#{revisionNumber},#{svnRevision},#{svnTagsPath},#{isActive},#{viewName})")
    void createIpfFciLabel(IpfFciLabel ipfFciLabel);
    
    @Delete("DELETE FROM cartan_common.t_ipf_fci_label WHERE ID = #{id}")
    void deleteIpfFciLabel(String id);

    @Update("update cartan_common.t_ipf_fci_label set IPF_FCI_VIEW_ID=#{ipfFciViewId},LABEL_NAME=#{labelName},LABEL_DESC=#{labelDesc},IPF_FCI_BUILD_ID=#{ipfFciBuildId},MAJOR_VERSION=#{majorVersion},MINOR_VERSION=#{minorVersion},VERSION_BUILD_NUMBER=#{versionBuildNumber},REVISION_NUMBER=#{revisionNumber},SVN_REVISION=#{svnRevision},SVN_TAGS_PATH=#{svnTagsPath},IS_ACTIVE=#{isActive},VIEW_NAME=#{viewName} where ID = #{id}")
    void updateIpfFciLabel(IpfFciLabel ipfFciLabel);

    @Select("select count(*) c from cartan_common.t_ipf_fci_label")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_fci_label order by ID asc")
    ArrayList<IpfFciLabel> selectAll();
    
    @SelectProvider(type = IpfFciLabelSqlProvider.class, method = "getSql")
    ArrayList<IpfFciLabel> selectWithCondition(@Param("ipfFciLabel") IpfFciLabel ipfFciLabel,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfFciLabel> selectBySql(@Param("SqlStr") String SqlStr);
}

