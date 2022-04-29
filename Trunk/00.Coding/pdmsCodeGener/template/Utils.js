/* 
 *  Utils.js 0.1
 *  Author: zsk
 *  Date: 2016-01-05
 */
;(function(root, factory) {
    if(typeof define === 'function' && define.amd) {
        define(function() {
            return (root.Utils = factory());
        });
    } else if(typeof exports === 'object') {
        module.exports = factory();
    } else {
        root.Utils = factory();
    }
} (this, function() {

    var root = this || global;
    var _previousUtils = root.Utils;

    var Utils = {};
    Utils.VERSION = '0.1';
    // ------------------------------------
    

    /*
     *   服务器交互返回 回调方法
     *   messager;
     *   Author zsk 2014-07-03
     */
    Utils.messager = function(data, callback, skip) {
        if (data.status === 1) {
            if (skip) { // 跳过提示，直接回调
                callback && callback.call(data, data.data);
            } else {
                $.messager.alert("提示", data.message, "info", function() {
                    callback && callback.call(data, data.data)
                });
            }
            return true;
        } else if (data.status === 0) {
            if (302 === data.code) { // 会话超时
                window.location.reload();
            } else {
                $.messager.alert("提示", data.message, "warning");
            }
        } else if (data.status == undefined) {
            alert("返回数据格式不正确！\n" + JSON.stringify(data));
        }
        return false;
    };


    /**
     *  doAjax  统一AJAX方法
     *  参数 opts:
     *  type    : "GET",
     *  url     : str 地址
     *  data    : post or get Data
     *  dataType: "JSON"
     *  callback: function(data){} 回调函数
     *  messager: boolean || function  提示框(true)
     *  skip    : boolean 成功时是否跳过提示框(true)
     *  progress: boolean || function  是否显示进度条(false)
     *
     *  Author zsk 2014-07-03
     */
    Utils.doAjax = function(opts) {

        var _self = this;

        var defalutOpts = {
            type: "GET",
            data: {},
            dataType: "JSON",

            callback: function() {},

            messager: true, // 提示操作提示
            skip: true,

            progress: false
        }

        var options = $.extend({}, defalutOpts, opts);

        // 显示进度条
        if (typeof options.progress === 'boolean') {
            options.progress && $.messager.progress({
                msg: '处理中...',
				text:''
            });
        } else {
            $.messager.progress(options.progress);
        }

        return $.ajax(options).done(function(data, textStatus, jqXHR) {
                var _result = true;
                if (typeof options.messager === 'boolean') {
                    _result = options.messager && _self.messager.call(data, data, false, options.skip) || true;
                } else {
                    _result = _self.messager.call(data, data, options.messager, options.skip);
                }
                
                // 只有成功的时候才调用回调函数
                // if(data.status === 1 && data.code === 200) {
                options.callback.call(data, data, _result);
                // }
            })
            .fail(function(jqXHR, textStatus, errorThrown) {
                $.messager.alert('错误信息', '操作失败!', 'warning');
            })
            .always(function(data, textStatus) {
                options.progress && $.messager.progress('close');
            });
    }


    /**
     *  queryParam 方法 获取和设置地址栏的参数
     *  参数  如果没有参数则返回当前地址栏的所有参数名值对象
     *  参数一 ： param '则返回该参数的值'
     *  参数二 ： searchStr  '当前地址栏的search字符串'
     *  
     *  Author zsk 2014-07-03
     */
    Utils.queryParam = function(param, searchStr) {

        var searchStr = searchStr || window.location.search;
        if (searchStr.length == 0) {
            return
        };

        if (typeof param === 'string') { // 直接字符串读取
            //返回请求的参数值
            var REP = new RegExp("(^|&|\\?)" + param + "=(.*?)($|\&|#)");
            var value = searchStr.match(REP);
            return value && decodeURIComponent(value[2]);
        }

        //返回当前 search 的所有参数名值对象
        var objParam = {};
        var param = searchStr.replace(/^\?/, '').split('&');
        for (var i = 0, j = param.length; i < j; i++) {
            var x = param[i].split('=');
            objParam[decodeURIComponent(x[0])] = decodeURIComponent(x[1]);
        }

        return objParam;
    }


    /**
     *  将数值四舍五入后格式化.
     *  num 数值(Number或者String)
     *  isThousand 是否需要千分位 (boolean);
     *  cent 要保留的小数位(Number)
     *  return 格式的字符串,如'1,234,567.45'
     *
     *  Author zsk 2014-07-03
     */
    Utils.formatNumber = function(num, isThousand, cent) {
        var num = num.toString().replace(/\$|\,/g, '');
        var isThousand = isThousand === false ? false : true;
        var cent = cent || 0;
        // 检查传入数值为数值类型
        if (isNaN(num))
            num = "0";

        // 获取符号(正/负数)
        sign = (num == (num = Math.abs(num)));

        num = Math.floor(num * Math.pow(10, cent) + 0.50000000001); // 把指定的小数位先转换成整数.多余的小数位四舍五入
        cents = num % Math.pow(10, cent); // 求出小数位数值
        num = Math.floor(num / Math.pow(10, cent)).toString(); // 求出整数位数值
        cents = cents.toString(); // 把小数位转换成字符串,以便求小数位长度

        // 补足小数位到指定的位数
        while (cents.length < cent)
            cents = "0" + cents;

        if (isThousand) {
            // 对整数部分进行千分位格式化.
            for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
                num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));
        }

        if (cent > 0)
            return (((sign) ? '' : '-') + num + '.' + cents);
        else
            return (((sign) ? '' : '-') + num);
    }

    /**
     *  判定是否是IE浏览器
     *  version: IE的版本
     *  Author zsk 2016-03-30
     */
    Utils.ie = function(version) {
        var userAgent = 'navigator' in window && 'userAgent' in navigator && navigator.userAgent.toLowerCase() || '';
        if(!version) {
            return /msie/i.test(userAgent) || "ActiveXObject" in window;
        }
        if(version >= 11) {
            return "ActiveXObject" in window;
        }
        return new RegExp('msie ' + version).test(userAgent);
    };

    /**
     * 对Date的扩展，将 Date 转化为指定格式的String
     * 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
     * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
     * 例子： 
     * (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
     * (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
    */
    Utils.dateFormat = function(dateObj, fmt) {
        var o = {
            "M+": dateObj.getMonth() + 1, //月份 
            "d+": dateObj.getDate(), //日 
            "h+": dateObj.getHours(), //小时 
            "m+": dateObj.getMinutes(), //分 
            "s+": dateObj.getSeconds(), //秒 
            "q+": Math.floor((dateObj.getMonth() + 3) / 3), //季度 
            "S": dateObj.getMilliseconds() //毫秒 
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (dateObj.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            }

        }
        return fmt;
    }

     /**
      *  @Author yyp 2015-02-29
      *  获取当前时间: (yyyy-MM-dd hh:mm:ss)
      */
    Utils.getCurrentTime = function() {
        var date = Utils.dateFormat(new Date(),"yyyy-MM-dd hh:mm:ss");
        return date;
    };

    /*
     *  getFormObjStr  getFormObj
     *  获取表单值，并转为字符串
     *  param:  $form       表单的jQuery对象
     *          exception   排除不需要的项
     *  author: zsk 2014-07-31 
     *  修改： yyp 2016-03-02
     */
    Utils.getFormObj = function($form, exception) {
        var param = {};
        $("[name]", $form).each(function() {

            // 如果name为空不执行：修改：yyp 2016-03-25
            if ($(this).attr('name')) {    
                var $this = $(this);
                if ($this.attr("type") == "radio") {
                    if ($this.prop("checked")) {
                        param[$this.attr("name")] = $.trim($this.val());
                    }
                }else if($this.attr("type") == "checkbox"){
                    if ($this.prop("checked")) {
                        param[$this.attr("name")] === undefined ? 
                            param[$this.attr("name")] = $.trim($this.val()) : 
                            param[$this.attr("name")] += (',' + $.trim($this.val()));
                    }
                } else {
                    param[$this.attr("name")] = $.trim($this.val());
                }
            }
        });
        if(exception){ // delete exception
            for(var i = 0, j = exception.length; i < j; i++){
                delete param[exception[i]];
            }
        }
        return param;
    };

    Utils.getFormObjStr = function($form, exception) {
        var paramObj = Utils.getFormObj($form, exception);
        return JSON.stringify(paramObj);
    };

    /*   
     * 回车绑定方法     TODO 后期可以优化 yyp
     *   author zsk
     */
    Utils.keyEnter = {

        // 绑定的回调方法数量
        _bindLength: 0

        , _onBindFuns: []
        , _offBindFuns: []

        , _isExsit: function (tage) {

            var result = false;

            if (typeof _allBindFun !== undefined) {
                result = true;
            }

            return result;
        }

        // 回车后的调用的方法
        , _fireFun: function (e) {
            if (e.keyCode == 13) {
                for (var i = this._onBindFuns.length; i >= 0; i--) {
                    if (this._onBindFuns[i] !== undefined) {
                        return this._onBindFuns[i].call(null, e);
                    }
                }
                ;
            }

        }

        // 添加回车事件
        , on: function keyEnterOn(zindex, fun) {
            var _self = this;

            if (fun) {
                this._onBindFuns[zindex] = fun
                ++this._bindLength;
            } else {
                if (this._offBindFuns[zindex] != undefined) {
                    this._onBindFuns[zindex] = this._offBindFuns[zindex];
                    this._offBindFuns[zindex] = undefined;
                    ++this._bindLength;
                }
            }
            if (this._bindLength == 1) {
                $(document).on('keydown._keyEnter', function (e) {
                    _self._fireFun.call(_self, e);
                });
            }
        }

        // 移除回车事件
        , off: function keyEnterOff(zindex) {
            if (this._onBindFuns[zindex] != undefined) {
                --this._bindLength
                this._offBindFuns[zindex] = this._onBindFuns[zindex];
                this._onBindFuns[zindex] = undefined;
            }

            if (this._bindLength == 0) {
                $(document).off('keydown._keyEnter');
            }
        }
    };

    Utils.buildDialog = function (dialogId, opts, zindex) {

        var defaultDialogOpts = {
            closable: true,
            closed: false,
            modal: true,
            width: 1000,
            height: 500,
            method: 'post',
            id: dialogId,
            onBeforeOpen: function(){
                
                // 关闭父窗口的enter事件
                if($.type(zindex) === "number"){
                    Utils.keyEnter.off(zindex);
                }
            } || null,
            onClose: function(){
                
                // 开启父窗口的enter事件
                if($.type(zindex) === "number"){
                    Utils.keyEnter.on(zindex);
                }

                // 关闭时销毁弹框 避免多次创建出现重复id
                $(this).dialog('destroy');
            }
        };

        var optionDialog = $.extend({}, defaultDialogOpts, opts);
        return $('<div></div>').dialog(optionDialog);
    };

    /*  创建 datagrid 方法
     *  grid:需要创建的datagrid
     *  opts: datagrid对象
     *  author yyp 2016-03-28
     */
    Utils.createGrid = function (grid, opts, params) {
        var defaultGridOps = {
            pagination: true,
            pageNumber: 1,
            pageSize: 15,
            pageList: [15, 25, 35, 45 ,55],
            autoRowHeight: false,
            rownumbers: true,
            nowrap: false,
            singleSelect: true,
            fit: true,
            border: false,
            queryParams: params || null
        };

        var optionGrid = $.extend({}, defaultGridOps, opts);
        return grid.datagrid(optionGrid);
    };

    /*  动态解析内容，只有在打开dialog或页面的时候才开始解析
     *  wrapperId: html代码解析后需要放到的父容器Id
     *  toParserId：待解析的html代码存放位置的Id
     *  callBack: 需要执行的方法
     *  author yyp 2016-03-25
     */
    Utils.parserScript = function (wrapperId, toParserId, callBack) {
        $.parser.onComplete = function (context) {
            if (context == ('#'+wrapperId)) {
                callBack && callBack();
            }
        };
        var html = document.getElementById(toParserId).innerHTML;
        document.getElementById(wrapperId).innerHTML = html;
        $.parser.parse('#'+wrapperId);
    };

    // ------------------------------------
    Utils.extend = function(prop, fun) {
        if(this[prop]){
            alert(prop + ' alreay exist!!')
        }else{
            Utils[prop] = fun;
        }
    }

    Utils.noConflict = function() {
        root.Utils = _previousUtils;
        return this;
    };

    return Utils;
}));


