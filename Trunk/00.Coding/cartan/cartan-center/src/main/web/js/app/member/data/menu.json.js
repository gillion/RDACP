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
        "name": "团体管理",
        "leaf": 0,
        "iconcls": "icon-home",
        children: [
            {
                "code": "0101",
                "name": "代码类别",
                "url": "#basic_manage/platform_Comstyle_manage",
                "leaf": 1,
                "parentcode": "01"
            }
            ,{
                "code": "0102",
                "name": "常用代码",
                "url": "#basic_manage/platform_Comcode_manage",
                "leaf": 1,
                "parentcode": "02"
            },{
                "code": "0103",
                "name": "用户信息",
                "url": "#basic_manage/platform_LoginUser_manage",
                "leaf": 1,
                "parentcode": "03"
            },{
                "code": "0104",
                "name": "团体信息",
                "url": "#basic_manage/platform_GroupInfo_manage",
                "leaf": 1,
                "parentcode": "04"
            },{
                "code": "0105",
                "name": "团体成员",
                "url": "#basic_manage/platform_GroupMember_manage",
                "leaf": 1,
                "parentcode": "05"
            },{
                "code": "0106",
                "name": "团务活动",
                "url": "#basic_manage/platform_GroupAction_manage",
                "leaf": 1,
                "parentcode": "06"
            },{
                "code": "0107",
                "name": "成员投票",
                "url": "#basic_manage/platform_MemberVote_manage",
                "leaf": 1,
                "parentcode": "07"
            },{
                "code": "0108",
                "name": "成员参与",
                "url": "#basic_manage/platform_MemberPartake_manage",
                "leaf": 1,
                "parentcode": "08"
            },{
                "code": "0109",
                "name": "衣服尺码",
                "url": "#basic_manage/platform_MemberClothingsize_manage",
                "leaf": 1,
                "parentcode": "09"
                }]
    }]
};