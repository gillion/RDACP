/**
 * //应用初始化
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["Application",
        "js/app/ruledesign/router",
        "js/app/ruledesign/routers/PlatformDatasetManageRouter",
        "js/app/ruledesign/routers/PlatformDatasetVarManageRouter",
        "js/app/ruledesign/routers/PlatformSectionPartitionManageRouter",
        "js/app/ruledesign/routers/PlatformSectionPartitionVarManageRouter",
        "js/app/ruledesign/routers/PlatformConditionPartitionManageRouter",
        "js/app/ruledesign/routers/PlatformConditionPartitionNodeManageRouter",
        "js/app/ruledesign/routers/PlatformRuleTreeManageRouter",
        "js/app/ruledesign/routers/PlatformRuleTreeOutputManageRouter",
        "js/app/ruledesign/routers/PlatformRuleTableManageRouter",
        "js/app/ruledesign/routers/PlatformRuleTableInputManageRouter",
        "js/app/ruledesign/routers/PlatformRuleTableOutputManageRouter",
        "js/app/ruledesign/routers/PlatformRulesetManageRouter",
        "js/app/ruledesign/routers/PlatformRuleManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmEnvironmentManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmTemplateManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmUiLayoutManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmUiLayoutListManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmUiLayoutDetailManageRouter",
        "js/app/ruledesign/routers/PlatformIpfPoiSettingManageRouter",
        "js/app/ruledesign/routers/PlatformIpfFciProjectManageRouter",
        "js/app/ruledesign/routers/PlatformIpfFciViewManageRouter",
        "js/app/ruledesign/routers/PlatformIpfFciViewMemberManageRouter",
        "js/app/ruledesign/routers/PlatformIpfFciRevisionManageRouter",
        "js/app/ruledesign/routers/PlatformIpfFciBuildManageRouter",
        "js/app/ruledesign/routers/PlatformIpfFciLabelManageRouter",
        "js/app/ruledesign/routers/PlatformIpfFciLabelDetailManageRouter",
        "js/app/ruledesign/routers/PlatformIpfReqRuleManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlTableManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlColumnManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlConstraintManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlConstraintColumnManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlIndexManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlIndexColumnManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlViewManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlViewColumnManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlViewSqlManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlElementManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlElementTextManageRouter",
        "js/app/ruledesign/routers/PlatformIpfDmlScriptPublishManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoCheckGroupManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoPropertyManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoPropertyCasManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoGridColumnManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoGridToolbarManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoFormColumnManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoControlEventManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoFormToolbarManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoMethodManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoMethodParamManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoMethodRuleManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoCheckManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoCheckFieldManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoCheckRelGroupManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmUiLayoutConfigManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoFormCellManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoRelationManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoPageManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoPageLayoutManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBoPgLoElementManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmDictManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmDictValueManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmShlpManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmShlpDetailManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmShlpTextManageRouter",
        "js/app/ruledesign/routers/PlatformIpfRtmTypeManageRouter",
        "js/app/ruledesign/routers/PlatformIpfRtmTypeBoManageRouter",
        "js/app/ruledesign/routers/PlatformIpfRtmTypeBoAttrManageRouter",
        "js/app/ruledesign/routers/PlatformIpfRtmTypeBoMapManageRouter",
        "js/app/ruledesign/routers/PlatformIpfRtmConfigManageRouter",
        "js/app/ruledesign/routers/PlatformIpfRtmConfigAttrManageRouter",
        "js/app/ruledesign/routers/PlatformIpfRtmConfigAttrBoManageRouter",
        "js/app/ruledesign/routers/PlatformIpfScheduleJobManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmNumruleManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmNumruleListManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBizruleManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBizruleDtlManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmBizruleDtlParamManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmStrategyManageRouter",
        "js/app/ruledesign/routers/PlatformIpfCcmStrategyParamManageRouter",
        "js/app/ruledesign/routers/PlatformIpfRuleFilterManageRouter",
        "js/app/ruledesign/routers/PlatformIpfRuleFilterDetailManageRouter",
        "js/app/ruledesign/routers/PlatformIpfRuleRotateManageRouter",
        "js/app/ruledesign/routers/PlatformIpfRuleRotateDetailManageRouter",
        "js/demoRouter",
        "js/testRouter",
        "bootstrap"
], function(Application, AppRouter, 
		PlatformDatasetManageRouter,
		PlatformDatasetVarManageRouter,
		PlatformSectionPartitionManageRouter,
		PlatformSectionPartitionVarManageRouter,
		PlatformConditionPartitionManageRouter,
		PlatformConditionPartitionNodeManageRouter,
		PlatformRuleTreeManageRouter,
		PlatformRuleTreeOutputManageRouter,
		PlatformRuleTableManageRouter,
		PlatformRuleTableInputManageRouter,
		PlatformRuleTableOutputManageRouter,
		PlatformRulesetManageRouter,
		PlatformRuleManageRouter,
        PlatformIpfCcmEnvironmentManageRouter,
        PlatformIpfCcmTemplateManageRouter,
        PlatformIpfCcmUiLayoutManageRouter,
        PlatformIpfCcmUiLayoutListManageRouter,
        PlatformIpfCcmUiLayoutDetailManageRouter,
        PlatformIpfPoiSettingManageRouter,
        PlatformIpfFciProjectManageRouter,
        PlatformIpfFciViewManageRouter,
        PlatformIpfFciViewMemberManageRouter,
        PlatformIpfFciRevisionManageRouter,
        PlatformIpfFciBuildManageRouter,
        PlatformIpfFciLabelManageRouter,
        PlatformIpfFciLabelDetailManageRouter,
        PlatformIpfReqRuleManageRouter,
        PlatformIpfDmlTableManageRouter,
        PlatformIpfDmlColumnManageRouter,
        PlatformIpfDmlConstraintManageRouter,
        PlatformIpfDmlConstraintColumnManageRouter,
        PlatformIpfDmlIndexManageRouter,
        PlatformIpfDmlIndexColumnManageRouter,
        PlatformIpfDmlViewManageRouter,
        PlatformIpfDmlViewColumnManageRouter,
        PlatformIpfDmlViewSqlManageRouter,
        PlatformIpfDmlElementManageRouter,
        PlatformIpfDmlElementTextManageRouter,
        PlatformIpfDmlScriptPublishManageRouter,
        PlatformIpfCcmBoManageRouter,
        PlatformIpfCcmBoCheckGroupManageRouter,
        PlatformIpfCcmBoPropertyManageRouter,
        PlatformIpfCcmBoPropertyCasManageRouter,
        PlatformIpfCcmBoGridColumnManageRouter,
        PlatformIpfCcmBoGridToolbarManageRouter,
        PlatformIpfCcmBoFormColumnManageRouter,
        PlatformIpfCcmBoControlEventManageRouter,
        PlatformIpfCcmBoFormToolbarManageRouter,
        PlatformIpfCcmBoMethodManageRouter,
        PlatformIpfCcmBoMethodParamManageRouter,
        PlatformIpfCcmBoMethodRuleManageRouter,
        PlatformIpfCcmBoCheckManageRouter,
        PlatformIpfCcmBoCheckFieldManageRouter,
        PlatformIpfCcmBoCheckRelGroupManageRouter,
        PlatformIpfCcmUiLayoutConfigManageRouter,
        PlatformIpfCcmBoFormCellManageRouter,
        PlatformIpfCcmBoRelationManageRouter,
        PlatformIpfCcmBoPageManageRouter,
        PlatformIpfCcmBoPageLayoutManageRouter,
        PlatformIpfCcmBoPgLoElementManageRouter,
        PlatformIpfCcmDictManageRouter,
        PlatformIpfCcmDictValueManageRouter,
        PlatformIpfCcmShlpManageRouter,
        PlatformIpfCcmShlpDetailManageRouter,
        PlatformIpfCcmShlpTextManageRouter,
        PlatformIpfRtmTypeManageRouter,
        PlatformIpfRtmTypeBoManageRouter,
        PlatformIpfRtmTypeBoAttrManageRouter,
        PlatformIpfRtmTypeBoMapManageRouter,
        PlatformIpfRtmConfigManageRouter,
        PlatformIpfRtmConfigAttrManageRouter,
        PlatformIpfRtmConfigAttrBoManageRouter,
        PlatformIpfScheduleJobManageRouter,
        PlatformIpfCcmNumruleManageRouter,
        PlatformIpfCcmNumruleListManageRouter,
        PlatformIpfCcmBizruleManageRouter,
        PlatformIpfCcmBizruleDtlManageRouter,
        PlatformIpfCcmBizruleDtlParamManageRouter,
        PlatformIpfCcmStrategyManageRouter,
        PlatformIpfCcmStrategyParamManageRouter,
        PlatformIpfRuleFilterManageRouter,
        PlatformIpfRuleFilterDetailManageRouter,
        PlatformIpfRuleRotateManageRouter,
        PlatformIpfRuleRotateDetailManageRouter,
            DemoRouter, TestRouter){
    //在此可以进行应用的初始化操作
    var MyApplication = Application.extend({
        applicationDidFinishLaunching: function(){
            new AppRouter(this.getAppRouterOption());    //注册该应用的路由
            //new PlatformUserManageRouter(this.getAppRouterOption());    //注册路由：基础管理-基础用户管理
    		new PlatformDatasetManageRouter(this.getAppRouterOption());
    		new PlatformDatasetVarManageRouter(this.getAppRouterOption());
    		new PlatformSectionPartitionManageRouter(this.getAppRouterOption());
    		new PlatformSectionPartitionVarManageRouter(this.getAppRouterOption());
    		new PlatformConditionPartitionManageRouter(this.getAppRouterOption());
    		new PlatformConditionPartitionNodeManageRouter(this.getAppRouterOption());
    		new PlatformRuleTreeManageRouter(this.getAppRouterOption());
    		new PlatformRuleTreeOutputManageRouter(this.getAppRouterOption());
    		new PlatformRuleTableManageRouter(this.getAppRouterOption());
    		new PlatformRuleTableInputManageRouter(this.getAppRouterOption());
    		new PlatformRuleTableOutputManageRouter(this.getAppRouterOption());
    		new PlatformRulesetManageRouter(this.getAppRouterOption());
    		new PlatformRuleManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmEnvironmentManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmTemplateManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmUiLayoutManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmUiLayoutListManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmUiLayoutDetailManageRouter(this.getAppRouterOption());
            new PlatformIpfPoiSettingManageRouter(this.getAppRouterOption());
            new PlatformIpfFciProjectManageRouter(this.getAppRouterOption());
            new PlatformIpfFciViewManageRouter(this.getAppRouterOption());
            new PlatformIpfFciViewMemberManageRouter(this.getAppRouterOption());
            new PlatformIpfFciRevisionManageRouter(this.getAppRouterOption());
            new PlatformIpfFciBuildManageRouter(this.getAppRouterOption());
            new PlatformIpfFciLabelManageRouter(this.getAppRouterOption());
            new PlatformIpfFciLabelDetailManageRouter(this.getAppRouterOption());
            new PlatformIpfReqRuleManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlTableManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlColumnManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlConstraintManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlConstraintColumnManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlIndexManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlIndexColumnManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlViewManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlViewColumnManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlViewSqlManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlElementManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlElementTextManageRouter(this.getAppRouterOption());
            new PlatformIpfDmlScriptPublishManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoCheckGroupManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoPropertyManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoPropertyCasManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoGridColumnManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoGridToolbarManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoFormColumnManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoControlEventManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoFormToolbarManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoMethodManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoMethodParamManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoMethodRuleManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoCheckManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoCheckFieldManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoCheckRelGroupManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmUiLayoutConfigManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoFormCellManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoRelationManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoPageManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoPageLayoutManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBoPgLoElementManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmDictManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmDictValueManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmShlpManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmShlpDetailManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmShlpTextManageRouter(this.getAppRouterOption());
            new PlatformIpfRtmTypeManageRouter(this.getAppRouterOption());
            new PlatformIpfRtmTypeBoManageRouter(this.getAppRouterOption());
            new PlatformIpfRtmTypeBoAttrManageRouter(this.getAppRouterOption());
            new PlatformIpfRtmTypeBoMapManageRouter(this.getAppRouterOption());
            new PlatformIpfRtmConfigManageRouter(this.getAppRouterOption());
            new PlatformIpfRtmConfigAttrManageRouter(this.getAppRouterOption());
            new PlatformIpfRtmConfigAttrBoManageRouter(this.getAppRouterOption());
            new PlatformIpfScheduleJobManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmNumruleManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmNumruleListManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBizruleManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBizruleDtlManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmBizruleDtlParamManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmStrategyManageRouter(this.getAppRouterOption());
            new PlatformIpfCcmStrategyParamManageRouter(this.getAppRouterOption());
            new PlatformIpfRuleFilterManageRouter(this.getAppRouterOption());
            new PlatformIpfRuleFilterDetailManageRouter(this.getAppRouterOption());
            new PlatformIpfRuleRotateManageRouter(this.getAppRouterOption());
            new PlatformIpfRuleRotateDetailManageRouter(this.getAppRouterOption());
            new DemoRouter(this.getAppRouterOption());   //注册Demo的路由
            new TestRouter(this.getAppRouterOption());   //注册测试的路由
            return true;
        }
    });

    var myApplication = new MyApplication();
        myApplication.run();  //启动应用
});

