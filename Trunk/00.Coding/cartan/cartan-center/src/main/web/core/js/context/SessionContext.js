/**
 * //会话上下文，其中包含了应用上下文的信息
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["types/Class", "context/ApplicationContext"], function(Class, ApplicationContext){
    var SessionContext = Class.extend({
        applicationContext: null,           //应用上下文
        SKIN_THEME: "default",              //皮肤的主题

        ctor: function(){
            this.applicationContext = ApplicationContext;
        }
    });

    return SessionContext;
});
