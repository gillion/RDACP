/**
 * 对外暴露窗口的接口方法
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery", "utils/Log", "windows/MessageWindow", "windows/ModalDialog"], function($, Log, MessageWindow, ModalDialog){
    var WindowPlugin = function($){
        if($.window == null)
            $.window = {};

        /*******************************模态窗口*************************************/

        /**
         * 存储子窗口传递给父窗口的参数，该参数在子窗口关闭的瞬间只可能存在一个，父窗口即可马上获取，因此系统全局唯一
         * @type {null}
         */
        $.window.returnValue = null;

        /**
         * 存储父窗口传递给子窗口的参数，该参数在窗口弹出的瞬间只可能存在一个，弹出窗口即可马上获取，因此系统全局唯一
         * @type {null}
         */
        $.window.arguments = null;

        /**
         * 显示模态弹出窗口
         *
         * @param title 窗口的标题
         * @param url  窗口请求的链接
         * @param beforeCloseHandle 窗口关闭前的回调函数
         * @param afterCloseHandle 窗口关闭后的回调函数
         * @param vArguments 传递给窗口的参数
         * @param vFeatures  窗口的配置参数
         * @return {ModalDialog}
         */
        $.window.showModalDialog = function(title, url, beforeCloseHandle, afterCloseHandle, vArguments, vFeatures){

            vFeatures = vFeatures || {};
            var options = {
                title: title,
                href: url,
                beforeCloseHandle: beforeCloseHandle,
                afterCloseHandle: afterCloseHandle,
                isExecuteCallBack: vFeatures["isExecuteCallBack"],
                width: vFeatures["width"],
                height: vFeatures["height"],
                top:vFeatures["top"],
                left:vFeatures["left"],
                opener: window    //设置或获取创建当前窗口的窗口的引用
            }
            var modalDialog = new ModalDialog(options);
            modalDialog.show();

            $.window.arguments = vArguments;   //窗口显示的时候，设置全局参数变量
            $.window.returnValue = null;      //窗口显示的时候，重置全局的返回值为空

            return modalDialog;
        }

        /**
         * 关闭弹出窗口
         */
        $.window.close = function(){
            $.colorbox.close();  //colorbox在页面内全局唯一，所以才可以通过该方式关闭
        }

        /**
         * 获取父窗口传递给子窗口的参数
         * @return {*|null}
         */
        $.window.getArguments = function(){
            return $.window.arguments;
        }

        /**
         * 如果窗口数据已经发生变更了，就需要调用该函数
         * 主要用于执行当关闭窗口时，是否需要执行关闭窗口后的回调函数
         */
        $.window.markUpdated = function(){
            var modalDialog = $.window.getActive();
            if(modalDialog == null)
                return;
            modalDialog.markUpdated();
        }

        /**
         * 获取当前激活的窗口
         * @return {*}
         */
        $.window.getActive = function(){
            return window.ModalDialogManager.getActive();
        }

        /**
         * 获取创建当前窗口的窗口的引用
         * @return {*}
         */
        $.window.getOpener = function(){
            var modalDialog = $.window.getActive();
            if(modalDialog == null)
                return;
            return modalDialog.getOpener();
        }

        /*******************************消息窗口*************************************/

        $.window.showTip = function(msg, options){
            return MessageWindow.showTip(msg, options);
        }
        $.window.closeTip = function(id){
            return MessageWindow.closeTip(id);
        }
        $.window.showProgressTip = function(msg){
            return MessageWindow.showProgressTip(msg);
        }
        $.window.closeProgressTip = function(id){
            return MessageWindow.closeProgressTip(id);
        }
        $.window.showSucceedMsg = function(msg, options){
            return MessageWindow.showSucceedMsg(msg, options);
        }
        $.window.showErrorMsg = function(msg, options){
            return MessageWindow.showErrorMsg(msg, options);
        }
        $.window.showWarningMsg = function(msg, options){
            return MessageWindow.showWarningMsg(msg, options);
        }
        $.window.alert = function(msg, options){
            return MessageWindow.alert(msg, options);
        }
        $.window.confirm = function(msg, options){
            return MessageWindow.confirm(msg, options);
        }
        $.window.showMessage = function(msg, options){
            return MessageWindow.showMessage(msg, options);
        }

    }

    return WindowPlugin($);
});