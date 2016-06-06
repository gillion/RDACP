/**
 * //
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-16 上午9:10
 */
define(["jquery", "types/Class", "utils/Log", "utils/common", "kendo"], function($, Class, Log){

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
        _id: null,
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
            dialogOpts["_id"] = $.uuid();
            dialogOpts["title"] = options["title"];
            dialogOpts["href"] = options["href"];
            dialogOpts["top"] = options["top"];
            dialogOpts["left"] = options["left"];
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

            window.ModalDialogManager.add(this);  //向窗口管理容器中注册一个窗口
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

            var documentWindow = $(window);
            var top = this.get("top");
            var left = this.get("left");
            var width = this.get("width") || "800px";
            var height = this.get("height") || "550px";
            var overlayClose = this.get("overlayClose") == null ? false : this.get("overlayClose");
            var opacity = this.get("opacity") || 0.1;
            var title = this.get("title");
            var modal = this.get("modal") == null ? false : modal;


            //保证弹出框都是基于第一个弹出框所在页面进行弹出的，而不是嵌入在弹出框中
            if(typeof $window == "undefined"){
                if(typeof parent.$window == "undefined")
                    window.$window = $;
                else
                    $window = parent.$window;
            }

            var owner = this;
            //设置iframe与窗口容器的边距为0；并且设置窗口容器的滚动条不出来，iframe的滚动条根据情况会出现
            var kendoUIWindow = $window("<div id='" + this.getId() + "' style='padding: 0; overflow:hidden' />").kendoWindow({
                content:href,
                title: title,
                width: width,
                height: height,
                modal: modal,
                iframe: true,   //用iframe进行加载，不能用默认ajax，如果用ajax加载，那么界面初始化脚本将不执行
                actions: [ "Maximize", "Minimize", "Close"],
                open: function (e) {
                    top = top || documentWindow.scrollTop() + Math.max(0, (documentWindow.height() - this.wrapper.height()) / 2);  //默认居中显示
                    left = left || (documentWindow.scrollLeft() + Math.max(0, (documentWindow.width() - this.wrapper.width()) / 2));  //默认居中显示
                    this.wrapper.css({
                        left: left,
                        top: top
                    });
                },
                close: function(e){
                    var result = owner._executeCallBack(true);   //执行窗口关闭前的回调函数
                    if(result != null && result == false){
                        e.preventDefault();   //阻止事件继续向上冒泡，即不会将该窗口关闭
                        return;
                    }

                    kendoUIWindow.destroy();         //销毁窗口，将窗口相关代码从界面中移除
                    kendoUIWindow = null;

                    owner._executeCallBack(false);  //设置窗口关闭后的回调函数
                    window.ModalDialogManager.remove(owner.getId());  //关闭窗口前，直接从窗口管理器中移除
                    owner = null;
                }
            }).data("kendoWindow");

            kendoUIWindow.open();   //显示窗口
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