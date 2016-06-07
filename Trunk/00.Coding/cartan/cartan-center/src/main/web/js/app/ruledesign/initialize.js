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
            new DemoRouter(this.getAppRouterOption());   //注册Demo的路由
            new TestRouter(this.getAppRouterOption());   //注册测试的路由
            return true;
        }
    });

    var myApplication = new MyApplication();
        myApplication.run();  //启动应用
});

