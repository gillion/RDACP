/**
 * //应用初始化
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["Application",
        "js/app/${sysname}/router",
    	<#list tablelist as prop>     
        "js/app/${sysname}/routers/Platform${prop.name}ManageRouter",
    	</#list>  
        "js/demoRouter",
        "js/testRouter",
        "bootstrap"
], function(Application, AppRouter, 
		<#list tablelist as prop>   
		Platform${prop.name}ManageRouter,
		</#list>  
            DemoRouter, TestRouter){
    //在此可以进行应用的初始化操作
    var MyApplication = Application.extend({
        applicationDidFinishLaunching: function(){
            new AppRouter(this.getAppRouterOption());    //注册该应用的路由
            //new PlatformUserManageRouter(this.getAppRouterOption());    //注册路由：基础管理-基础用户管理
    		<#list tablelist as prop>   
    		new Platform${prop.name}ManageRouter(this.getAppRouterOption());
    		</#list>  
            new DemoRouter(this.getAppRouterOption());   //注册Demo的路由
            new TestRouter(this.getAppRouterOption());   //注册测试的路由
            return true;
        }
    });

    var myApplication = new MyApplication();
        myApplication.run();  //启动应用
});

