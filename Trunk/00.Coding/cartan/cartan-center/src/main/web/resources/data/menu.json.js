/**
 * Json格式的菜单数据
 * <pre>
 *     {
        "code": "",
        "name": "",
        "url": "",
        "leaf": 0,
        "parentcode": "",
        "enabled": "",
        "iconcls": ""
        "children":[
        ]
    }
 * </pre>
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-23 上午9:10
 */
window.menuData = {
    "menus": [{
        "code": "01",
        "name": "基础管理",
        "leaf": 0,
        "iconcls": "icon-home",
        children: [{
            "code": "0101",
            "name": "服务管理",
            "url": "#service_manage",
            "leaf": 1,
            "parentcode": "01"
        },{
            "code": "0102",
            "name": "平台用户管理",
            "url": "#basic_manage/platform_sysUser_manage",
            "leaf": 1,
            "parentcode": "01"
        },{
            "code": "0103",
            "name": "设备管理",
            "url": "#device_manage",
            "leaf": 1,
            "parentcode": "03"
        },{
            "code": "0104",
            "name": "应用管理",
            "url": "#app_manage",
            "leaf": 1,
            "parentcode": "01"
        }]
    },{
        "code": "02",
        "name": "消息管理",
        "leaf": 0,
        "iconcls": "icon-envelope",
        children: [{
            "code": "0201",
            "name": "SMS发送",
            "url": "#sms_send",
            "leaf": 1,
            "parentcode": "02"
        },{
            "code": "0202",
            "name": "消息网关",
            "url": "#message_gateway",
            "leaf": 1,
            "parentcode": "02"
        },{
            "code": "0203",
            "name": "消息推送",
            "url": "#message_push",
            "leaf": 1,
            "parentcode": "02"
        }]
    },{
        "code": "03",
        "name": "安全管理",
        "leaf": 0,
        "iconcls": "icon-briefcase",
        children: [{
            "code": "0301",
            "name": "安全策略",
            "url": "#safety_policy",
            "leaf": 1,
            "parentcode": "03"
        },{
            "code": "0302",
            "name": "应用用户管理",
            "url": "#app_user_manage",
            "leaf": 1,
            "parentcode": "03"
        }]
    },{
        "code": "04",
        "name": "服务监控",
        "leaf": 0,
        "iconcls": "icon-eye-open",
        children:[{
            "code": "0401",
            "name": "服务统计",
            "url": "#service_stat",
            "leaf": 1,
            "parentcode": "04"
        },{
            "code": "0402",
            "name": "消息统计",
            "url": "#message_stat",
            "leaf": 1,
            "parentcode": "04"
        },{
            "code": "0403",
            "name": "应用统计",
            "url": "#app_stat",
            "leaf": 1,
            "parentcode": "04"
        },{
            "code": "0404",
            "name": "用户统计",
            "url": "#user_stat",
            "leaf": 1,
            "parentcode": "04"
        }]
    },{
        "code": "05",
        "name": "日志管理",
        "leaf": 0,
        "iconcls": "icon-bookmark",
        children:[{
            "code": "0501",
            "name": "系统日志",
            "url": "#system_log",
            "leaf": 1,
            "parentcode": "05"
        },{
            "code": "0502",
            "name": "业务日志",
            "url": "#business_log",
            "leaf": 1,
            "parentcode": "05"
        }]
    },{
        "code": "06",
        "name": "演示例子",
        "leaf": 0,
        "iconcls": "icon-check",
        children:[{
            "code": "0601",
            "name": "模态窗口",
            "url": "#demo/ModalDialog",
            "leaf": 1,
            "parentcode": "06"
        },{
            "code": "0602",
            "name": "消息窗口",
            "url": "#demo/MessageWindow",
            "leaf": 1,
            "parentcode": "06"
        },{
            "code": "0603",
            "name": "简要列表",
            "url": "#demo/simplelist",
            "leaf": 1,
            "parentcode": "06"
        }]
    }]
};