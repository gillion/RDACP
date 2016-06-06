/**
 * 测试路由器
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["types/Class",
    "utils/Log",
    "base/BaseRouter",
    "base/BaseView"
], function(Class, Log, BaseRouter, BaseView){

    var DemoRouter = BaseRouter.extend({
        routes: {
        }
    });

    return DemoRouter;
});