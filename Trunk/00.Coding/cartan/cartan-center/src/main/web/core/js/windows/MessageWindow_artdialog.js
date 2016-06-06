/**
 * //消息窗口
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery", "types/Class", "utils/Log", "utils/common", "dialog"], function($, Class, Log){
    var MessageWindow = {
        /**
         * 弹出一个非模态的消息提示框（默认2秒窗口自动关闭）
         */
        /**
         * 弹出一个消息提示框（默认2.5秒窗口自动关闭）
         *
         * @param {Object} msg 	[必填]确认的内容
         * @param {Object} options [可选]配置参数，json格式，可配置的信息说明如下：
         * <pre>
         * 	    duration:      窗口几秒后自动关闭（默认值为2秒，单位为秒）
         * 	    lock:     {Boolean}默认值为true。开启锁屏(中断用户对话框之外的交互，用于显示非常重要的操作/消息，所以不建议频繁使用它，它会让操作变得繁琐)
         * </pre>
         */
        showTip: function(msg, options){
            options = options || {};
            options["duration"] = options["duration"] == null ? 2.5 : options["duration"];
            options["lock"] = options["lock"] == null ? false :options["lock"];

            return this.showMessage(msg, options);
        },
        /**
         * 关闭提示窗口
         */
        closeTip: function(id){
            var currentDialog = this.getDialog(id);
            if(currentDialog == null){
                this.showErrorMsg("请传入正确的窗口ID");
                return;
            }

            currentDialog.close();
        },
        /**
         * 显示正在处理的提示窗口（模态窗口）
         */
        showProgressTip: function(msg){
            msg = msg || "系统正在处理，请稍后...";
            var options = {icon: "face-smile", lock: true, duration:0, cancel: function(){
                $.dialog({title: '提示信息', content:"系统正在处理，不允许关闭窗口", button:[{name: "确 定"}]});
                return false;
            }};
            return this.showTip(msg, options);
        },
        /**
         * 关闭正在处理的提示窗口
         */
        closeProgressTip: function(id){
            this.closeTip(id);
        },
        /**
         * 显示成功信息，默认是2.5秒后自动关闭
         * @param msg
         * @param options
         */
        showSucceedMsg: function(msg, options){
            options = options || {};
            options["duration"] = options["duration"]==null ? "2.5" : options["duration"];

            return this.showMsgWithIcon(msg, "succeed", options);
        },
        /**
         * 显示失败信息
         * @param msg
         * @param options
         */
        showErrorMsg: function(msg, options){
            return this.showMsgWithIcon(msg, "error", options);
        },
        /**
         * 显示警告信息
         * @param msg
         * @param options
         */
        showWarningMsg: function(msg, options){
            return this.showMsgWithIcon(msg, "warning", options);
        },
        /**
         * 显示带有图标的提示信息（默认是不开启锁屏的）
         * @param msg
         * @param icon
         * @param {Object} options [可选]配置参数，json格式，可配置的信息说明如下：
         * <pre>
         * 		label：        确定按钮的名字(默认为：确定)
         * 	    handle:        点击确定按钮后执行的回调函数
         * 		title：        确认信息的标题(默认为：提示信息)
         * 	    duration: {Number}窗口几秒后自动关闭（默认值为0秒[即不自动关闭]，单位为秒）
         * 	    icon:     {String}定义消息图标。可定义“core/js/lib/artDialog/skins/icons/”目录下的图标名作为参数名（不包含后缀名）
         * 	    lock:     {Boolean}默认值为true。开启锁屏(中断用户对话框之外的交互，用于显示非常重要的操作/消息，所以不建议频繁使用它，它会让操作变得繁琐)
         * 	    id:       {String/Number}设定对话框唯一标识。用途：1、防止重复弹出;2、定义id后可以使用art.dialog.list[youID]获取扩展方法
         * </pre>
         * @return {*}
         */
        showMsgWithIcon: function(msg, icon, options){
            options = options || {};
            options["icon"] = icon;
            options["lock"] = options["lock"] == null ? false : options["lock"];  //默认是不开启锁屏的

            return this.alert(msg, options);
        },
        /**
         * 弹出一个包含一个按钮的模态对话框（默认是不开启锁屏的）
         *
         * @param {Object} msg 	[必填]确认的内容
         * @param {Object} options [可选]配置参数，json格式，可配置的信息说明如下：
         * <pre>
         * 		label：        确定按钮的名字(默认为：确定)
         * 	    handle:        点击确定按钮后执行的回调函数
         * 		title：        确认信息的标题(默认为：提示信息)
         * 	    duration: {Number}窗口几秒后自动关闭（默认值为0秒[即不自动关闭]，单位为秒）
         * 	    icon:     {String}定义消息图标。可定义“core/js/lib/artDialog/skins/icons/”目录下的图标名作为参数名（不包含后缀名）
         * 	    lock:     {Boolean}默认值为true。开启锁屏(中断用户对话框之外的交互，用于显示非常重要的操作/消息，所以不建议频繁使用它，它会让操作变得繁琐)
         * 	    id:       {String/Number}设定对话框唯一标识。用途：1、防止重复弹出;2、定义id后可以使用art.dialog.list[youID]获取扩展方法
         * </pre>
         */
        alert: function(msg, options){
            options = options || {};
            var label = options["label"] || "确 定";
            var handle = options["handle"];
            var button = [{name: label, callback: handle}];
            var alertOpts = {
                button: button,
                title: options["title"],
                duration: options["duration"],
                icon: options["icon"],
                lock: options["lock"]==null ? false : options["lock"],
                id: options["id"]
            };

            return this.showMessage(msg, alertOpts);
        },
        /**
         * 弹出一个包含两个按钮的模态对话框（默认为二态[确认、取消]对话框）。
         *
         * @param {Object} msg 	[必填]确认的内容
         * @param {Object} options [可选]配置参数，json格式，可配置的信息说明如下：
         * <pre>
         * 		yesBtnTitle：确定按钮的名字(默认为：确定)
         * 	    noBtnTitle：取消按钮的名字(默认为：取消)
         * 	    yesHandle：点击确定按钮后执行的回调函数
         * 	    noHandle：点击取消按钮后执行的回调函数
         * 		title：        确认信息的标题(默认为：提示信息)
         * 	    duration: {Number}窗口几秒后自动关闭（默认值为0秒[即不自动关闭]，单位为秒）
         * 	    icon:     {String}定义消息图标。可定义“core/js/lib/artDialog/skins/icons/”目录下的图标名作为参数名（不包含后缀名）
         * 	    lock:     {Boolean}默认值为true。开启锁屏(中断用户对话框之外的交互，用于显示非常重要的操作/消息，所以不建议频繁使用它，它会让操作变得繁琐)
         * 	    id:       {String/Number}设定对话框唯一标识。用途：1、防止重复弹出;2、定义id后可以使用art.dialog.list[youID]获取扩展方法
         * </pre>
         */
        confirm: function(msg, options){
            options = options || {};
            var yesBtnTitle = options["yesBtnTitle"] || "确 定";
            var noBtnTitle = options["noBtnTitle"] || "取 消";
            var yesHandle = options["yesHandle"];
            var noHandle = options["noHandle"];
            var button = [{name: yesBtnTitle, callback: yesHandle},{name: noBtnTitle, callback: noHandle}];
            var confirmOpts = {
                button: button,
                title: options["title"],
                duration: options["duration"],
                icon: options["icon"] || "question",
                lock: options["lock"]==null ? true : options["lock"],
                id: options["id"]
            };

            return this.showMessage(msg, confirmOpts);
        },
        /**
         * 弹出一个模态对话框
         *
         * @param {Object} msg 	[必填]确认的内容
         * @param {Object} type [可选，默认值为1]确认窗口的类型：1-仅有一个确认按钮；2-有'确定'和'取消'两个按钮（默认值）；3-有'确定'、'取消'和'关闭'三个按钮
         * @param {Object} options [可选]配置参数，json格式，可配置的信息说明如下：
         * <pre>
         * 		button：  {Array}自定义按钮。配置参数成员：
         * 	                            name —— 按钮名称
         * 	                            callback —— 按下后执行的函数
         * 	                            focus —— 是否聚焦点
         * 	                            disabled —— 是否标记按钮为不可用状态（后续可使用扩展方法让其恢复可用状态）
         * 	                     示例：
         * 	                     参数如：[{name: '登录', callback: function () {}}, {name: '取消'}] 。注意点击按钮默认会触发按钮关闭动作，需要阻止触发关闭请让回调函数返回false
         * 		title：   {String}标题内容(默认为：提示信息)
         * 	    duration: {Number}窗口几秒后自动关闭（默认值为0秒[即不自动关闭]，单位为秒）
         * 	    icon:     {String}定义消息图标。可定义“core/js/lib/artDialog/skins/icons/”目录下的图标名作为参数名（不包含后缀名）
         * 	    lock:     {Boolean}默认值为true。开启锁屏(中断用户对话框之外的交互，用于显示非常重要的操作/消息，所以不建议频繁使用它，它会让操作变得繁琐)
         * 	    id:       {String/Number}设定对话框唯一标识。用途：1、防止重复弹出;2、定义id后可以使用art.dialog.list[youID]获取扩展方法
         * </pre>
         */
        showMessage: function(msg, options){
            if(msg == null){
                Log.warn("提示的信息内容不能为空");
                return;
            }

            options = options || {};
            var button = options["button"];
            var title = options["title"] || "提示信息";
            var inDuration = options["duration"]==null || options["duration"]==0 || options["duration"]=="0" ? null : options["duration"];
            var icon = options["icon"];
            var lock = options["lock"] == null ? true : options["lock"];
            var id = options["id"] || $.uuid();
            var cancel = options["cancel"];
            $.dialog({
                title: title,
                content: msg,
                button: button,
                icon: icon,
                id: id,
                lock: lock,
                cancel: cancel,
                time: inDuration,
                opacity: 0.1
            });

            return id;
        },
        /**
         * 根据窗口ID获取窗口对象
         * @param id
         * @return {*}
         */
        getDialog: function(id){
            if(id == null){
                Log.warn("窗口的ID不能为空");
                return null;
            }
            return $.dialog({id: id});
        }
    };

    return MessageWindow;
});