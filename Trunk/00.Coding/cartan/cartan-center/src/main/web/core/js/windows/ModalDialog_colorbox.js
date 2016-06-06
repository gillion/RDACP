/**
 * //模态窗口
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-16 上午9:10
 */
define(["jquery", "types/Class", "utils/Log", "utils/common", "colorbox"], function($, Class, Log){

    $.colorbox.originalClose = $.colorbox.close;     //先缓存colorbox原来的close方法

    //窗口管理器
    window.ModalDialogManager = {
        modalDialogArray: [],
        /**
         * 获取激活窗口
         * @return {*}
         */
        getActive: function(){
            var count = this.modalDialogArray ? this.modalDialogArray.length : 0;
            if(count == 0)
                return null;

            return this.modalDialogArray[count-1];
        },
        /**
         * 新增一个窗口
         * @param modalDialog
         */
        add: function(modalDialog){
            if(modalDialog == null)
                return;

            this.modalDialogArray.push(modalDialog);
        },
        /**
         * 销毁窗口
         * @param modalDialogId
         */
        remove: function(modalDialogId){
            if(modalDialogId == null)
                return;
            var newArray = [];
            var oldArray = this.modalDialogArray;
            var count = oldArray.length;
            var modalDialog = null;
            for(var i=0; i<count; i++){
                modalDialog = oldArray[i];
                if(modalDialogId != modalDialog.getId())
                    newArray.push(modalDialog);
            }

            this.modalDialogArray = newArray;
        }
    }

    var ModalDialog = Class.extend({
        _id: $.uuid(),
        el: "__modal_panel__",
        title: null,
        content: null,
        _returnValue: null,
        _beforeCloseCallbackArray: [],
        _afterCloseCallbackArray: [],
        _isExecuteCallBack: false,
        isExecuteCallBack: false,    //是否执行回调，全局性的，允许外部设置
        opener: null,                  //设置或获取创建当前窗口的窗口的引用

        ctor: function(options){
            options = options || {};
            var dialogOpts = {};
            dialogOpts["title"] = options["title"];
            dialogOpts["href"] = options["href"];
            dialogOpts["width"] = options["width"];
            dialogOpts["height"] = options["height"];
            dialogOpts["isExecuteCallBack"] = options["isExecuteCallBack"];
            dialogOpts["opener"] = options["opener"];

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
            this.overrideColorboxClose();       //覆盖colorbox的close方法，主要是添加关闭前的回调

            window.ModalDialogManager.add(this);  //向窗口管理容器中注册一个窗口
        },
        /**
         * 覆盖colorbox的close方法，主要是添加关闭前的回调
         * close方法将影响到escKey, overlayClose,  和 the close button
         */
        overrideColorboxClose: function(){
            var owner = this;
            $.colorbox.close = function(){
                var result = owner._executeCallBack(true);   //执行窗口关闭前的回调函数
                if(result != null && result == false)
                    return;

                window.ModalDialogManager.remove(owner.getId());  //关闭窗口前，直接从窗口管理器中移除
                $.colorbox.originalClose();   //执行colorbox原来的close方法
            };
        },
        /**
         * 显示窗口
         */
        show: function(){
            var href = this.get("href");
            var startStr = href.substr(0, 1);
            if(startStr == "#"){
                href = "modal_dialog_index.jsp" + href;
            }

            var width = this.get("width") || "80%";
            var height = this.get("height") || "80%";
            var overlayClose = this.get("overlayClose") == null ? false : this.get("overlayClose");
            var opacity = this.get("opacity") || 0.1;
            var title = this.get("title");

            var owner = this;
            $.colorbox({
                iframe:true,
                title: title,
                href: href,
                width: width,
                height: height,
                opacity: opacity,
                overlayClose:overlayClose,
                onClosed: function(){
                    owner._executeCallBack(false);  //设置窗口关闭后的回调函数
                }
            });
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

            //只有窗口的数据发生变化了，才执行窗口关闭后的回调函数
            if(!isBeforeClose){
                var isUpdated = this._isUpdated();
                if(!isUpdated)
                    return result;
            }

            var callBackArray = isBeforeClose ? this._beforeCloseCallbackArray : this._afterCloseCallbackArray;
            if(callBackArray == null || callBackArray.length == 0)
                return result;

            //仅关闭后才需要返回值
            var returnValue = isBeforeClose ? null : $.window.returnValue;

            var callBackFun = null;
            for(var i= 0, cbCount=callBackArray.length; i<cbCount; i++){
                callBackFun = callBackArray[i];

                if(typeof(callBackFun) == "string" && callBackFun != ""){
                    try {
                        callBackFun = callBackFun + "(returnValue)";
                        callBackFun = eval(callBackFun + "(returnValue)");
                    } catch (e) {
                        alert("对不起，页面未定义[" + callBackFun + "]函数，请先定义。");
                        return result;
                    }
                }

                if($.isFunction(callBackFun)){
                    try{
                        result = callBackFun(returnValue);
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
         * 主要用于执行当关闭窗口时，是否需要执行关闭窗口后的回调函数
         */
        markUpdated: function(){
            this._isExecuteCallBack = true;
        },
        /**
         * 重置执行回调函数的刷新标识
         */
        _resetUpdated: function(){
            this._isExecuteCallBack = false;
        },
        /**
         * 取得执行回调函数的刷新标识
         */
        _isUpdated: function(){
            return this.get("isExecuteCallBack") ||  this.get("_isExecuteCallBack");
        },
        getOpener: function(){
            return this.get("opener");
        }
    });

    return ModalDialog;
});