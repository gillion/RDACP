/**
 * //模态窗口
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery", "types/Class", "utils/Log", "utils/common", "dialog"], function($, Class, Log){

    var ModalDialog = Class.extend({
        _id: $.uuid(),
        _closed: false,     //窗口关闭标识
        el: "__modal_panel__",
        title: null,
        content: null,
        _vArguments: null,
        _returnValue: null,
        _beforeCloseCallbackArray: [],
        _afterCloseCallbackArray: [],
        _isExcecuteCallBack: false,

        ctor: function(options){
            options = options || {};
            var dialogOpts = {};
            dialogOpts["title"] = options["title"];
            dialogOpts["url"] = options["url"];

            //窗口关闭前的回调函数
            this._beforeCloseCallbackArray = [];
            var beforeCloseHandle = options["beforeCloseHandle"];
            if($.isFunction(beforeCloseHandle)){
                this._beforeCloseCallbackArray.push(beforeCloseHandle);
            }

            //窗口关闭后的回调函数
            this._afterCloseCallbackArray = [];
            var afterCloseHandle = options["afterCloseHandle"];
            if($.isFunction(afterCloseHandle))
                this._afterCloseCallbackArray.push(afterCloseHandle);

            this.set(dialogOpts);
        },
        /**
         * 显示窗口
         */
        show: function(){
            var url = this.get("url");
            var startStr = url.substr(0, 1);
            if(startStr == "#"){
                url = "modal_dialog_index.jsp" + url;
            }

            var width = this.get("width") || "80%";
            var height = this.get("height") || "80%";
            var overlayClose = this.get("overlayClose") == null ? false : this.get("overlayClose");
            var opacity = this.get("opacity") || 0.1;
            var title = this.get("title");
            var lock = this.get("lock") == null ? true : this.get("lock");
            var padding = this.get("padding") || 30;

            $.dialog.open(url, {
                title: title,
                width: width,
                height: height,
                opacity: opacity,
                lock: lock,
                padding: padding
            } );
        },
        /**
         * 关闭窗口，并且执行相应的回调函数
         */
        close: function(){
            var result = this._executeCallBack(true);   //执行窗口关闭前的回调函数
            if(!result)
                return;


            //只有窗口的数据发生变化了，才执行窗口关闭后的回调函数
            var isUpdated = this._isUpdated();
            if(isUpdated)
                this._executeCallBack(false);  //执行窗口关闭后的回调函数

            //如果窗口的返回值为空，则说明该窗口关闭后已再无用处了，因此直接从窗口管理器中移除
            if(!this._returnValue){
            }
        },
        /**
         * 执行回调函数
         *
         * @param isBeforeClose  用来区分是窗口关闭之前还是之后的回调函数
         * @return {boolean}
         * @private
         */
        _executeCallBack: function(isBeforeClose){
            var result = true;
            var callBackArray = isBeforeClose ? this._beforeCloseCallbackArray : this._afterCloseCallbackArray;
            if(callBackArray == null || callBackArray.length == 0)
                return result;
            var callBackFun = null;
            for(var i= 0, cbCount=callBackArray.length; i<cbCount; i++){
                callBackFun = callBackArray[i];

                if(typeof(callBackFun) == "string" && callBackFun != ""){
                    try {
                        callBackFun = eval(callBackFun);
                    } catch (e) {
                        alert("对不起，页面未定义[" + callBackFun + "]函数，请先定义。");
                        return result;
                    }
                }

                if($.isFunction(callBackFun)){
                    try{
                        result = callBackFun();
                    }catch(e){
                    }
                    //如果有一个回调函数返回false，那么就中止其他回调函数的执行
                    if(result != null && !result)
                        return result;
                }
            }

            if(result == null)
                result = true;

            return result;
        },
        /**
         * 获取模态窗口ID
         * @return {*}
         */
        getId: function(){
            return this._id;
        },
        /**
         * 设置模态窗口的返回值
         * @param returnValue
         */
        setReturnValue: function(returnValue){
            this._returnValue = returnValue;
        },
        /**
         * 取得模态窗口的返回值
         */
        getReturnValue: function(){
            //当返回值被获取过一次后，就认为该窗口已无用了，直接从窗口管理器中移除
            window.ModalDialogManager.remove(this.getId());

            return this._returnValue;
        },
        /**
         * 取得源窗口传递给弹出窗口的参数值
         */
        getArguments: function(){
            return this._vArguments;
        },
        /**
         * 设置关闭窗口前的回调函数（注意：该方法会覆盖所有关闭窗口前的回调函数，注意与appendBeforeCloseCallback方法的区别）
         * @param beforeCloseCallback 关闭窗口前的回调函数
         */
        setBeforeCloseCallback: function(beforeCloseCallback){
            if(beforeCloseCallback == null)
                return;

            if($.isFunction(beforeCloseCallback)){
                this._beforeCloseCallbackArray = [];
                this._beforeCloseCallbackArray.push(beforeCloseCallback);
                return;
            }

            if($.isArray(beforeCloseCallback)){
                this._beforeCloseCallbackArray = beforeCloseCallback;
            }
        },
        /**
         * 新增关闭窗口前的回调函数，但不会清空该窗口的其他关闭窗口前回调函数，注意与setBeforeCloseCallback方法的区别
         * @param beforeCloseCallback 新增关闭窗口前的回调函数
         */
        appendBeforeCloseCallback: function(beforeCloseCallback){
            if(beforeCloseCallback == null || !$.isFunction(beforeCloseCallback))
                return;

            this._beforeCloseCallbackArray.push(beforeCloseCallback);
        },
        /**
         * 设置关闭窗口后的回调函数（注意：该方法会覆盖所有关闭窗口后的回调函数，注意与appendAfterCloseCallback方法的区别）
         * @param afterCloseCallback 关闭窗口后的回调函数
         */
        setAfterCloseCallback: function(afterCloseCallback){
            if(afterCloseCallback == null)
                return;

            if($.isFunction(afterCloseCallback)){
                this._afterCloseCallbackArray = [];
                this._afterCloseCallbackArray.push(afterCloseCallback);
                return;
            }

            if($.isArray(afterCloseCallback)){
                this._afterCloseCallbackArray = afterCloseCallback;
            }
        },
        /**
         * 新增关闭窗口后的回调函数，但不会清空该窗口的其他关闭窗口后回调函数，注意与setAfterCloseCallback方法的区别
         * @param afterCloseCallback 新增关闭窗口后的回调函数
         */
        appendAfterCloseCallback: function(afterCloseCallback){
            if(afterCloseCallback == null || !$.isFunction(afterCloseCallback))
                return;

            this._afterCloseCallbackArray.push(afterCloseCallback);
        },
        /**
         * 如果窗口数据已经发生变更了，就需要调用该函数
         * 主要用于执行当关闭(隐藏)窗口时，是否需要执行关闭窗口后的回调函数
         */
        markUpdated: function(){
            this._isExcecuteCallBack = true;
        },
        /**
         * 重置执行回调函数的刷新标识
         */
        _resetUpdated: function(extWin){
            this._isExcecuteCallBack = false;
        },
        /**
         * 取得执行回调函数的刷新标识
         */
        _isUpdated: function(){
            return this.get("_isExcecuteCallBack");
        }
    });
    var WindowPlugin = function($){
        if($.ui == null)
            $.ui = {};

        $.ui.showDialog = function(title, url, beforeCloseHandle, afterCloseHandle, vArguments){

            var options = {
                title: title,
                url: url,
                beforeCloseHandle: beforeCloseHandle,
                afterCloseHandle: afterCloseHandle,
                vArguments: vArguments
            }
            var modalDialog = new ModalDialog(options);
            modalDialog.show();

            return modalDialog;
        }
    }

    return WindowPlugin($);
});