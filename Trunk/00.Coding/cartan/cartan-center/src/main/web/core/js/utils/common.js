/**
 * 工具类
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery"], function($){
    /**
     * Utility function to create a psuedo GUID
     ```
     var id= $.uuid();
     ```
     * @title $.uuid
     */
    $.uuid = function () {
        var S4 = function () {
            return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
        }
        return (S4()+S4()+"-"+S4()+"-"+S4()+"-"+S4()+"-"+S4()+S4()+S4());
    };
});