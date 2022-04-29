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
        "name": "功能模块",
        "leaf": 0,
        "iconcls": "icon-home",
        children: [
<#assign porpNo = 0>
           		<#list tablelist as prop>   
           		<#assign porpNo=porpNo+1>
           		<#if porpNo==1>
           		{
                    "code": "010${porpNo}",
                    "name": "${prop.uiType}",
                    "url": "#basic_manage/platform_${prop.name}_manage",
                    "leaf": 1,
                    "parentcode": "0${porpNo}"
                }
           		<#else>,{
                    "code": "010${porpNo}",
                    "name": "${prop.uiType}",
                    "url": "#basic_manage/platform_${prop.name}_manage",
                    "leaf": 1,
                    "parentcode": "0${porpNo}"
                }</#if></#list>]
    },{
        "code": "02",
        "name": "演示例子",
        "leaf": 0,
        "iconcls": "icon-check",
        children:[{
            "code": "0601",
            "name": "模态窗口",
            "url": "#demo/ModalDialog",
            "leaf": 1,
            "parentcode": "06"
        }]
    }]
};