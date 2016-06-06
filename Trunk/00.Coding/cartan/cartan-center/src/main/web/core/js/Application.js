/**
 * //应用程序的基类
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-28 上午9:10
 */
define(["types/Class",
        "utils/Log",
        "jquery",
        "backbone",
        "ApplicationRouter"
    ], function(Class, Log, $, Backbone, appRouterOption){
    var Application = Class.extend({
        router: null,

        /**
         * Constructor
         */
        ctor: function () {
            Log.info("Application ctor");
        },
        /**
         * 应用开始运行启动
         *
         * @return {number}
         */
        run: function(){
            // Initialize instance and cocos2d.
            if (!this.applicationDidFinishLaunching()) {
                return 0;
            }

            this.initBackbone();   //初始化backbone

            Log.info("Application run ");
        },
        /**
         * 初始化Backbone,主要是进行路由器的监听处理
         */
        initBackbone: function(){
            this.router = appRouterOption.generateAppRouter();    //生成整个系统Backbone的路由器
            Backbone.history.start();   //启动Backbone的路由
        },
        registerAppRouteOption: function(route, name, callback){
            appRouterOption.register(route, name, callback);
        },

        /**
         * 获取整个应用的路由
         * @return {*}
         */
        getAppRouter: function(){
            return this.router;
        },
        getAppRouterOption: function(){
            return appRouterOption;
        },
       /*
         * 应用启动完成后执行的操作（给子类override）
         */
        applicationDidFinishLaunching: function(){
            return true;
        }
    });

    return Application;
});