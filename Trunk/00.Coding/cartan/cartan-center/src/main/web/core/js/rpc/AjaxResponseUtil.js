/**
 * 对通过AJAX请求返回的JSON字符串进行解析
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-12 上午9:10
 */
define(["jquery", "utils/Log", "types/Class"], function ($, Log, Class) {
	var AjaxResponseUtil = Class.extend({
        ctor: function(jsonOptions){
            if (jsonOptions == null)
                return;
            var jsonObj = $.parseJSON(jsonOptions);
            this._root = jsonObj[AjaxResponseUtil.JSON_ROOT] || {};
        },
        /**
         * 判断是否操作成功
         * @return boolean
         */
        isSuccessfully: function(){
            return this._root[AjaxResponseUtil.JSON_RESULT];
        },
        /**
         * 判断是否系统异常
         * @return boolean
         */
        isSystemException: function () {
            return this._validateReason(AjaxResponseUtil.JSON_REASON_SYSTEM_EXCEPTION);
        },
        /**
         * 判断是否违反了业务逻辑约束
         * @return boolean
         */
        isBusinessContraintException: function(){
            return this._validateReason(AjaxResponseUtil.JSON_REASON_BUSINESS_CONTRAINT);
        },
        /**
         * 判断是否违反了唯一约束
         * @return boolean
         */
        isUniqueContraintException: function(){
            return this._validateReason(AjaxResponseUtil.JSON_REASON_UNIQUE_CONTRAINT);
        },
        /**
         * 取得异常的提示信息
         * @return boolean
         */
        getMsg: function(){
            return this._root[AjaxResponseUtil.JSON_MSG];
        },
        /**
         * 取得自定义对象
         * @return Object json格式的对象
         */
        getCustomContent: function(){
            return this._root[AjaxResponseUtil.JSON_CUSTOM_CONTENT];
        },
        /**
         * 判断是否未登录
         * @return boolean
         */
        isUnLogon: function(){
            return this._validateReason(AjaxResponseUtil.JSON_REASON_LOGON_TIMEOUT);
        },
        /**
         * 判断是否拒绝访问
         * @return boolean
         */
        isAccessDeniedException: function(){
            return this._validateReason(AjaxResponseUtil.JSON_REASON_ACCESS_DENY);
        },
        /**
         * 根据给定的原因类型，验证是否是该类型的失败原因
         * @param {Object} type
         * @return boolean
         */
        _validateReason: function(type){
            var reason = this._getReason();
            return reason != null && reason == type;
        },
        /**
         * 获取失败的原因
         */
        _getReason: function(){
            return this._root[AjaxResponseUtil.JSON_REASON];
        }
    });

    AjaxResponseUtil.JSON_ROOT = "json-response";
    AjaxResponseUtil.JSON_RESULT = "result";
    AjaxResponseUtil.JSON_REASON = "reason";
    AjaxResponseUtil.JSON_REASON_LOGON_TIMEOUT = "unlogon";                  //未登陆
    AjaxResponseUtil.JSON_REASON_ACCESS_DENY = "access-deny";                //无权限，拒绝访问
    AjaxResponseUtil.JSON_REASON_UNIQUE_CONTRAINT = "unique-contraint";      //违反唯一性约束
    AjaxResponseUtil.JSON_REASON_BUSINESS_CONTRAINT = "business-contraint";  //业务逻辑异常
    AjaxResponseUtil.JSON_REASON_SYSTEM_EXCEPTION = "system-exception";      //系统异常
    AjaxResponseUtil.JSON_MSG = "msg";
    AjaxResponseUtil.JSON_CUSTOM_CONTENT = "custom-content";
		
	return AjaxResponseUtil;
});