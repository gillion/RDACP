/**
 * Ajax请求引擎。
 * 该引擎是基于jquery.ajax()进行封装的，对请求的响应进行拦截，统一验证响应的后，再交由客户的callback处理。
 *
 * 该引擎只允许客户端程序通过Ajax请求的onComplete事件执行自己的callback。
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-23 上午9:10
 */
define(["jquery", "utils/Log", "types/Class", "rpc/AjaxResponseUtil"], function ($, Log, Class, AjaxResponseUtil) {
	var AjaxEngine = Class.extend({
        /**
         * 初始化构造函数
         * @param {Object} url 请求的URL
         * @param {Object} options 可选的参数配置
         * <pre>
         * 	type：       [String]  (默认: "GET")请求方式("POST" 或 "GET")，默认为 "GET"。
         * 							注意：其它 HTTP 请求方法，如 PUT 和 DELETE 也可以使用，但仅部分浏览器支持。
         *  timeout：    [Number]  设置请求超时时间（毫秒）。此设置将覆盖全局设置。
         *  async：      [Boolean] (默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
         *  				       注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
         *  cache：      [Boolean] (默认: true) jQuery 1.2 新功能，设置为 false 将不会从浏览器缓存中加载请求信息。
         *  contentType：[String]  (默认: "application/x-www-form-urlencoded") 发送信息至服务器时内容编码类型。默认值适合大多数应用场合。
         *  data：       [Object,String] 发送到服务器的数据。将自动转换为请求字符串格式。GET 请求中将附加在 URL 后。
         *                               查看 processData 选项说明以禁止此自动转换。必须为 Key/Value 格式。
         *                               如果为数组，jQuery 将自动为不同值对应同一个名称。如 {foo:[bar1", "bar2"]} 转换为 '&foo=bar1&foo=bar2'。
         *  dataType：        [String]  预期服务器返回的数据类型。
         *  					   如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息返回 responseXML 或 responseText，并作为回调函数参数传递，可用值:
         *                         "xml": 返回 XML 文档，可用 jQuery 处理。
         *                         "html": 返回纯文本 HTML 信息；包含 script 元素。
         *                         "script": 返回纯文本 JavaScript 代码。不会自动缓存结果。
         *                         "json": 返回 JSON 数据 。
         *                         "jsonp": JSONP 格式。使用 JSONP 形式调用函数时，如 "myurl?callback=?" jQuery 将自动替换 ? 为正确的函数名，以执行回调函数。
         *  complete：        [function] 回调函数
         * </pre>
         */
        ctor: function(url, options){
            if (url == null || $.trim(url) == '') {
                Log.error("请求的地址不能为空");
                return;
            }

            this._url = url;
            url = this._setUrl(url); //对请求的URL进行加工处理

            //对ajax请求选项进行加工处理
            options = $.extend({url: url}, (options || {}));
            options = this._setOptions(options);

            $.ajax(options);  //调用JQuery
        },
        /**
         * 对请求的URL进行加工处理
         * @param {Object} url
         */
        _setUrl: function(url) {
            return url;
        },
        /**
         * 对Ajax请求的参数选项进行处理（只允许客户端程序通过Ajax请求的onComplete事件执行自己的callback）
         *
         * @param {Object} options
         */
        _setOptions: function(options) {

            //只允许设置complete方法，屏蔽其它事件响应
            options["beforeSend"] = null;
            options["success"] = null;
            options["error"] = null;

            this._complete = options["complete"] || function () {};  //先记录下客户设置的回调
            options["complete"] = this._interceptResponse.bind(this);  //设置complete选项的值，调用拦截器处理响应

            return options;
        },
        /**
         * 拦截服务端响应的报文
         *
         * @param {Object} transport
         * @param {Object} textStatus
         */
        _interceptResponse: function(transport, textStatus) {
            //针对服务端的响应做统一的验证
            if (!this._validateResponse(transport))
                return;
            //执行客户定义的回调函数
            if ($.isFunction(this._complete))
                this._complete(transport);
        },
        /**
         * 对响应进行统一验证，做出处理
         *
         * @return boolean
         */
        _validateResponse: function (transport) {
            if(transport.status == 404){
                alert("请求地址不存在：" + this._url);
                Log.error("请求地址不存在：" + this._url);
                return false;
            }

            var responseStr = transport.responseText;
            if(responseStr == null || $.trim(responseStr) == "")
                return false;

            var responseUtil = new AjaxResponseUtil(responseStr);
            //如果服务端响应是成功的，也直接返回
            if (responseUtil.isSuccessfully())
                return true;

            //尚未登录到系统
            if (responseUtil.isUnLogon()) {
                alert("对不起，您的登录已超时，请重新登录！");
                return false;
            }

            //拒绝访问，权限不足
            if (responseUtil.isAccessDeniedException()) {
                alert("对不起，您的权限不足，无法访问");
                return false;
            }

            //系统异常
            if (responseUtil.isSystemException()) {
                alert("系统异常，请与管理员联系！");
                return false;
            }

            return true;
        }
    });

    return AjaxEngine;
});
