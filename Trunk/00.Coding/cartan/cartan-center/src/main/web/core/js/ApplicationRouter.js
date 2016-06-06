/**
 * 整个系统的路由（页面跳转）
 * 这是整个应用系统全局性的路由选项，并且对外暴露该选项，是为了在应用启动之前，先将整个系统的应用路由选项先注册进来，然后再应用启动的时候，再创建该路由器
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(['jquery',
    'underscore',
    'backbone',
    'utils/Log',
    'types/Class'
], function($, _, Backbone, Log, Class){
    'use strict';

    var AppRouterOptions = Class.extend({
        options: {
            routes: {}  //routes中的先后顺序很关键，Backbone匹配的时候是从上到下匹配，如果前面已经匹配了，就会直接执行
        },

        router: null,

        /**
         * //注册全局应用路由配置信息
         * @param route [可选] 如果为空，则是向配置信息中注册一个函数
         * @param name [必填]，操作名或者说是函数名
        * @param callback [可选]如果为空，则说明操作（函数）名之前已经注册过了，因此只需共用即可
         */
        register: function(route, name, callback){
            if(route != null)
                this.options["routes"][route] = name;

            if(callback != null)
                this.options[name] = callback;
        },
        /**
         * 构造函数，主要是注册一些默认的公用路由或处理方法
         */
        ctor: function(){
        },
        /**
         * 注册一些默认的公用路由或处理方法
         */
        registerCommon: function(){
            //注册公用的页面跳转时的方法，外部可以直接调用该方法
            this.register(null, "changePage", this.changePage);
            //先注册匹配不到路由的处理方法
            this.register("*action", "faultAction", function(actions){
                Log.warn("No route：" + actions);
            });
        },

        /**
         * 页面切换时执行的操作
         * @param page 视图
        */
        changePage: function(page){
            var start = new Date();

            page.render();   //渲染页面内容

            //页面加载完成的回调函数
            if(page.ready){
                $(document).ready(page.ready());
            }

            var end = new Date();
            Log.debug("time waste: " + (end - start));   //显示渲染时间
        },
        /**
         * 创建应用全局的路由器
         * @return {AppRouter}
         */
        generateAppRouter: function(){
            this.registerCommon();
            var AppRouter = Backbone.Router.extend(this.options);
            this.router = new AppRouter();
            return this.router;
        }
    });

    return new AppRouterOptions();
});