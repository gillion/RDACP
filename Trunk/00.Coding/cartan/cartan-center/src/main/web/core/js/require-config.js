/**
 * 在require.js加载之前先定义一个全局的require配置对象，那么当require.js加载后，会自动拥有这些属性
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-10-28 上午9:10
 */
var require = {
    baseUrl: "core/js/",
    paths: {
        "require": "lib/require/2.1.4/require",
		"text": "lib/require/plugin/text",
        "normalize": "lib/require/plugin/css/normalize",
        "css": "lib/require/plugin/css/css",

        //"jquery": "/js/app/ruledesign/js/jquery_ui/jquery",
        "jquery": "lib/jquery/1.9.1/jquery",
        "underscore": "lib/underscore/1.4.4/underscore",

		"backbone": "lib/backbone/1.0.0/backbone",
        "bootstrap": "lib/bootstrap/2.3.2/js/bootstrap",

        "kendo": "lib/kendoui/kendo.web",

        "drag": "lib/dom-drag",
        "artDialog": "lib/artDialog/jquery.artDialog.source",
        "dialog": "lib/artDialog/plugins/iframeTools.source",   //artDialog的一个iframe插件，由此为窗口的入口
        "colorbox": "lib/colorbox/jquery.colorbox",
        

        "style": "../../resources/themes/default",

        "core_templates": "../resources/templates",

        "ddsmoothmenu": "/js/app/ruledesign/js/jquery_ui/ddsmoothmenu",
        "jquery_ui": "/js/app/ruledesign/js/jquery_ui/jquery-ui",
        "jquery_messager": "/js/app/ruledesign/js/jquery_ui/jquery.messager",
        "jquery_page": "/js/app/ruledesign/js/page/jquery.page",
        "footable": "/js/app/ruledesign/js/footable/footable",
        "jquery_ztree_core_min": "/js/app/ruledesign/js/ztree/jquery.ztree.core-3.5.min",
        "jquery_ztree_core": "/js/app/ruledesign/js/ztree/jquery.ztree.core-3.5",
        "jquery_ztree_excheck": "/js/app/ruledesign/js/ztree/jquery.ztree.excheck-3.5",
        "jquery_ztree_exedit": "/js/app/ruledesign/js/ztree/jquery.ztree.exedit-3.5",


        "js": "../../js",
        "templates": "../../resources/templates",
        "resources": "../../resources"


    },
    shim: {
        "jquery": {
            "exports": "$"
        },
        "underscore": {
            exports: "_"
        },
		"backbone": {
			"deps": [ "underscore", "jquery" ],
            "exports": "Backbone"  //attaches "Backbone" to the window object
        },
        "bootstrap": {
            "deps": ["jquery"]
        },
        "kendo": {
            "deps": ["jquery", "css!lib/kendoui/kendo.common.min", "css!lib/kendoui/kendo.default.min"],
            "exports": "kendo"
        },
        "drag": {
            exports: "Drag"
        },
        "artDialog": {
            "deps": ["jquery",  "css!lib/artDialog/skins/aero"],
            "exports": "artDialog"
        },
        "dialog": {
            "deps": ["artDialog"],
            "exports": "dialog"
        },
        "colorbox": {
            "deps": ["jquery", "css!lib/colorbox/colorbox", "drag"],
            "exports": "colorbox"
        }
    }
};