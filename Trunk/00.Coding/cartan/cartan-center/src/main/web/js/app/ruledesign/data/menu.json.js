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
        "name": "规则管理",
        "leaf": 0,
        "iconcls": "icon-home",
        children: [
           		{
                    "code": "1101",
                    "name": "数据模型",
                    "url": "ruledesign.html#basic_manage/platform_Dataset_manage",
                    "leaf": 1,
                    "parentcode": "01"
                },{
                    "code": "1102",
                    "name": "分段细分",
                    "url": "ruledesign.html#basic_manage/platform_SectionPartition_manage",
                    "leaf": 1,
                    "parentcode": "02"
                },{
                    "code": "1103",
                    "name": "条件细分",
                    "url": "ruledesign.html#basic_manage/platform_ConditionPartition_manage",
                    "leaf": 1,
                    "parentcode": "03"
                },{
                    "code": "1104",
                    "name": "决策树",
                    "url": "ruledesign.html#basic_manage/platform_RuleTree_manage",
                    "leaf": 1,
                    "parentcode": "04"
                },{
                    "code": "1105",
                    "name": "决策表",
                    "url": "ruledesign.html#basic_manage/platform_RuleTable_manage",
                    "leaf": 1,
                    "parentcode": "05"
                },{
                    "code": "1106",
                    "name": "规则/规则集",
                    "url": "ruledesign.html#basic_manage/platform_Ruleset_manage",
                    "leaf": 1,
                    "parentcode": "06"
                }]
    }]
};