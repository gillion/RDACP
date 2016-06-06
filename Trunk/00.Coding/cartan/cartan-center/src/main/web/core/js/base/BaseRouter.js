/**
 * 系统路由器的基类
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["types/Class",
    "utils/Log",
    "windows/Window"
], function(Class, Log){


    var BaseRouter = Class.extend({
        routes: {
        },

        ctor: function(globalAppRouterOption){
            this.register(globalAppRouterOption);
        },

        /**
         * 注册路由配置信息
         * @param route [必填] 如果为空，则是向配置信息中注册一个函数
         * @param name [必填]，操作名或者说是函数名
         */
        registerRoute: function(route, name){
            this.routes[route] = name;
        },

        /*-------------------------------公共的，主要负责向全局系统路由中注册------------------------------------------------*/
        register: function(globalAppRouterOption){
            this.globalAppRouterOption = globalAppRouterOption;   //应用程序的全局路由配置信息
            this._bindRoutes();
        },
        _bindRoutes: function(){
            var routes = this.routes;
            if (!routes)
                return;
            var name = null;
            var callback = null;

            this.globalAppRouterOption.register(null, "initialize", this.initialize);  //注册初始化路由选项

            for(var route in routes){
                name = routes[route];
                callback = this[name];

                if(!callback){
                    Log.warn("请求路径[" + route + "]在该类中找不到匹配的方法[" + name + "]");
                    continue;
                }

                this.globalAppRouterOption.register(route, name, callback);  //注册应用程序的全局路由器选项
            }
        }
    });

    return BaseRouter;
});