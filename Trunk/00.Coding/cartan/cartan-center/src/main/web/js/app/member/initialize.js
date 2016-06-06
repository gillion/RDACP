/**
 * //应用初始化
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["Application",
        "js/app/member/router",
        "js/app/member/routers/PlatformComstyleManageRouter",
        "js/app/member/routers/PlatformComcodeManageRouter",
        "js/app/member/routers/PlatformLoginUserManageRouter",
        "js/app/member/routers/PlatformGroupInfoManageRouter",
        "js/app/member/routers/PlatformGroupMemberManageRouter",
        "js/app/member/routers/PlatformGroupActionManageRouter",
        "js/app/member/routers/PlatformMemberVoteManageRouter",
        "js/app/member/routers/PlatformMemberPartakeManageRouter",
        "js/app/member/routers/PlatformMemberClothingsizeManageRouter",
        "js/demoRouter",
        "js/testRouter",
        "bootstrap"
], function(Application, AppRouter, 
		PlatformComstyleManageRouter,
		PlatformComcodeManageRouter,
		PlatformLoginUserManageRouter,
		PlatformGroupInfoManageRouter,
		PlatformGroupMemberManageRouter,
		PlatformGroupActionManageRouter,
		PlatformMemberVoteManageRouter,
		PlatformMemberPartakeManageRouter,
        PlatformMemberClothingsizeManageRouter,
            DemoRouter, TestRouter){
    //在此可以进行应用的初始化操作
    var MyApplication = Application.extend({
        applicationDidFinishLaunching: function(){
            new AppRouter(this.getAppRouterOption());    //注册该应用的路由
            //new PlatformUserManageRouter(this.getAppRouterOption());    //注册路由：基础管理-基础用户管理
    		new PlatformComstyleManageRouter(this.getAppRouterOption());
    		new PlatformComcodeManageRouter(this.getAppRouterOption());
    		new PlatformLoginUserManageRouter(this.getAppRouterOption());
    		new PlatformGroupInfoManageRouter(this.getAppRouterOption());
    		new PlatformGroupMemberManageRouter(this.getAppRouterOption());
    		new PlatformGroupActionManageRouter(this.getAppRouterOption());
    		new PlatformMemberVoteManageRouter(this.getAppRouterOption());
    		new PlatformMemberPartakeManageRouter(this.getAppRouterOption());
            new PlatformMemberClothingsizeManageRouter(this.getAppRouterOption());
            new DemoRouter(this.getAppRouterOption());   //注册Demo的路由
            new TestRouter(this.getAppRouterOption());   //注册测试的路由
            return true;
        }
    });

    var myApplication = new MyApplication();
        myApplication.run();  //启动应用
});

