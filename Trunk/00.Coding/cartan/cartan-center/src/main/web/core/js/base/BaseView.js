/**
 * 所有视图的基类，继承于Backbone的View
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(['jquery',
        'underscore',
        'backbone'
    ], function($, _, Backbone){
        var BaseView = Backbone.View.extend({
            template: null,
            id: '__default_id__',
            title: '默认标题',
            modal: false,
            el: "#main",        //页面默认显示的工作区域，用户可以根据实际情况进行覆盖调整

            initialize: function(options){
                this.set(options);
            },
            /**
             * 渲染页面
             */
            render: function(){
                $(this.el).get(0).innerHTML = this._getContent();  //因为jquery的html()函数会对javascript进行屏蔽处理，所以用传统的方式赋值

                return this;
            },
            showModalDialog: function(){
                if(!this.modal)
                    return;


            },
            _getContent: function(){
                this.template = _.template(this.get("viewTemplate"));
                var data = this.get("data") || {};
                return this.template({data: data});
            },
            getId: function(){
                return this.get("id");
            },
            getTitle: function(){
                return this.get("title");
            },
            /**
             * 用于弹出框关闭之前的回调
             * @return {*}
             */
            getBeforeCloseHandle: function(){
                return this.get("beforeCloseHandle");
            },
            /**
             * 用于弹出框关闭之后的回调
             * @return {*}
             */
            getAfterCloseHandle: function(){
                return this.get("afterCloseHandle");
            },
            /**
             * 用于弹出框的参数
             * @return {*}
             */
            getArguments: function(){
                return this.get("arguments");
            },
            isModal: function(){
                return this.get("modal");
            },
            get: function(attr, defaultValue){
                var result = this[attr];
                if(result == null)
                    result = defaultValue;
                return result;
            },
            set: function(options){
                if(options == null)
                    return;
                for(var prop in options){
                    this[prop] = options[prop];
                }
            },
            ready: function(){

            }
        });

        return BaseView;
});