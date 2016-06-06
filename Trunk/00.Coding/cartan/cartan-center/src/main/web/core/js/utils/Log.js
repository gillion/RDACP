/**
 * 日志工具类
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-10 上午9:10
 */
define(function(){
    var Log = {
        info: function(s){
            console.log('【信息】页面：'+location.href+"\n"+s);
        },
        debug: function(s){
            console.log('【调试】页面：'+location.href+"\n"+s);
        },
        error: function(s){
            console.log('【错误】页面：'+location.href+"\n"+s);
        },
        warn: function(s){
            console.log('【警告】页面：'+location.href+"\n"+s);
        }
    }

    return Log;
});