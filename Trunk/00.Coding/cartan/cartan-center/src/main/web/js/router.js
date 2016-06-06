/**
 * 应用自身的路由（最终会合并到整个应用系统的全局路由中）
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["types/Class",
        "utils/Log",
        "base/BaseRouter",
        "base/BaseView",
        "text!templates/login.html",
        "text!templates/home.html",
        'text!templates/nav_list_menu.html',
        'resources/data/menu.json'
    ], function(Class, Log, BaseRouter, BaseView, LoginViewTemplate, HomeViewTemplate, navListMenuTemplate){


        var MyAppRouter = BaseRouter.extend({
            routes: {
                "": "index",
                "login": "login",   //登录界面
                "home": "home"    //首页
            },
            initialize: function() {
                this.firstPage = true;
                Log.info("AppRoute initialize");
            },
            index: function(){
                var menuView = new BaseView({el: "#sidebar-nav", viewTemplate:  navListMenuTemplate, data: menuData["menus"], ready: function(){
//                    alert("菜单加载完毕");
                }});
                this.changePage(menuView);;  //显示菜单
                this.showPlatformSysUserManageList();   //显示主页
            },
            login: function(){
                var loginView = new BaseView({id: "login", title: "登陆界面", viewTemplate:  LoginViewTemplate, data: {}});
                this.changePage(loginView);
            },

            home: function(){
                Log.info("home Action");
                var homeView = new BaseView({ viewTemplate: HomeViewTemplate, data: {}});
                this.changePage(homeView);
            }
        });

        return MyAppRouter;
});