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
    },{
        "code": "02",
        "name": "基础数据",
        "leaf": 0,
        "iconcls": "icon-check",
        children:[{
            "code": "0101",
            "name": "代码生成环境配置",
            "url": "#basic_manage/platform_IpfCcmEnvironment_manage",
            "leaf": 1,
            "parentcode": "01"
        },{
            "code": "0102",
            "name": "模板文件",
            "url": "#basic_manage/platform_IpfCcmTemplate_manage",
            "leaf": 1,
            "parentcode": "02"
        },{
            "code": "0103",
            "name": "界面布局",
            "url": "#basic_manage/platform_IpfCcmUiLayout_manage",
            "leaf": 1,
            "parentcode": "03"
        },{
            "code": "0104",
            "name": "界面布局列表",
            "url": "#basic_manage/platform_IpfCcmUiLayoutList_manage",
            "leaf": 1,
            "parentcode": "04"
        },{
            "code": "0105",
            "name": "界面布局明细",
            "url": "#basic_manage/platform_IpfCcmUiLayoutDetail_manage",
            "leaf": 1,
            "parentcode": "05"
        },{
            "code": "0106",
            "name": "POI配置管理",
            "url": "#basic_manage/platform_IpfPoiSetting_manage",
            "leaf": 1,
            "parentcode": "06"
        }]
    },{
        "code": "03",
        "name": "项目管理",
        "leaf": 0,
        "iconcls": "icon-check",
        children:[{
            "code": "0107",
            "name": "项目管理",
            "url": "#basic_manage/platform_IpfFciProject_manage",
            "leaf": 1,
            "parentcode": "07"
        },{
            "code": "0108",
            "name": "视图管理",
            "url": "#basic_manage/platform_IpfFciView_manage",
            "leaf": 1,
            "parentcode": "08"
        },{
            "code": "0109",
            "name": "视图成员",
            "url": "#basic_manage/platform_IpfFciViewMember_manage",
            "leaf": 1,
            "parentcode": "09"
        },{
            "code": "01010",
            "name": "视图修订号",
            "url": "#basic_manage/platform_IpfFciRevision_manage",
            "leaf": 1,
            "parentcode": "010"
        },{
            "code": "01011",
            "name": "视图编译号",
            "url": "#basic_manage/platform_IpfFciBuild_manage",
            "leaf": 1,
            "parentcode": "011"
        },{
            "code": "01012",
            "name": "基线管理",
            "url": "#basic_manage/platform_IpfFciLabel_manage",
            "leaf": 1,
            "parentcode": "012"
        },{
            "code": "01013",
            "name": "基线明细",
            "url": "#basic_manage/platform_IpfFciLabelDetail_manage",
            "leaf": 1,
            "parentcode": "013"
        }]
    },{
        "code": "04",
        "name": "需求管理",
        "leaf": 0,
        "iconcls": "icon-check",
        children:[{
            "code": "01014",
            "name": "规则需求",
            "url": "#basic_manage/platform_IpfReqRule_manage",
            "leaf": 1,
            "parentcode": "014"
        }]
    },{
        "code": "05",
        "name": "数据建模",
        "leaf": 0,
        "iconcls": "icon-check",
        children:[{
            "code": "01015",
            "name": "表定义",
            "url": "#basic_manage/platform_IpfDmlTable_manage",
            "leaf": 1,
            "parentcode": "015"
        },{
            "code": "01016",
            "name": "表字段",
            "url": "#basic_manage/platform_IpfDmlColumn_manage",
            "leaf": 1,
            "parentcode": "016"
        },{
            "code": "01017",
            "name": "表约束",
            "url": "#basic_manage/platform_IpfDmlConstraint_manage",
            "leaf": 1,
            "parentcode": "017"
        },{
            "code": "01018",
            "name": "表约束字段",
            "url": "#basic_manage/platform_IpfDmlConstraintColumn_manage",
            "leaf": 1,
            "parentcode": "018"
        },{
            "code": "01019",
            "name": "表索引",
            "url": "#basic_manage/platform_IpfDmlIndex_manage",
            "leaf": 1,
            "parentcode": "019"
        },{
            "code": "01020",
            "name": "表索引字段",
            "url": "#basic_manage/platform_IpfDmlIndexColumn_manage",
            "leaf": 1,
            "parentcode": "020"
        },{
            "code": "01021",
            "name": "视图定义",
            "url": "#basic_manage/platform_IpfDmlView_manage",
            "leaf": 1,
            "parentcode": "021"
        },{
            "code": "01022",
            "name": "视图字段",
            "url": "#basic_manage/platform_IpfDmlViewColumn_manage",
            "leaf": 1,
            "parentcode": "022"
        },{
            "code": "01023",
            "name": "视图SQL",
            "url": "#basic_manage/platform_IpfDmlViewSql_manage",
            "leaf": 1,
            "parentcode": "023"
        },{
            "code": "01024",
            "name": "数据元素",
            "url": "#basic_manage/platform_IpfDmlElement_manage",
            "leaf": 1,
            "parentcode": "024"
        },{
            "code": "01025",
            "name": "数据元素多语言",
            "url": "#basic_manage/platform_IpfDmlElementText_manage",
            "leaf": 1,
            "parentcode": "025"
        },{
            "code": "01026",
            "name": "脚本发布",
            "url": "#basic_manage/platform_IpfDmlScriptPublish_manage",
            "leaf": 1,
            "parentcode": "026"
        }]
    },{
        "code": "06",
        "name": "对象建模",
        "leaf": 0,
        "iconcls": "icon-check",
        children:[{
            "code": "01027",
            "name": "业务对象",
            "url": "#basic_manage/platform_IpfCcmBo_manage",
            "leaf": 1,
            "parentcode": "027"
        },{
            "code": "01028",
            "name": "对象校验分组",
            "url": "#basic_manage/platform_IpfCcmBoCheckGroup_manage",
            "leaf": 1,
            "parentcode": "028"
        },{
            "code": "01029",
            "name": "属性定义",
            "url": "#basic_manage/platform_IpfCcmBoProperty_manage",
            "leaf": 1,
            "parentcode": "029"
        },{
            "code": "01030",
            "name": "属性动态过滤配置",
            "url": "#basic_manage/platform_IpfCcmBoPropertyCas_manage",
            "leaf": 1,
            "parentcode": "030"
        },{
            "code": "01031",
            "name": "管理页",
            "url": "#basic_manage/platform_IpfCcmBoGridColumn_manage",
            "leaf": 1,
            "parentcode": "031"
        },{
            "code": "01032",
            "name": "管理页按钮",
            "url": "#basic_manage/platform_IpfCcmBoGridToolbar_manage",
            "leaf": 1,
            "parentcode": "032"
        },{
            "code": "01033",
            "name": "编辑页",
            "url": "#basic_manage/platform_IpfCcmBoFormColumn_manage",
            "leaf": 1,
            "parentcode": "033"
        },{
            "code": "01034",
            "name": "编辑页控件事件",
            "url": "#basic_manage/platform_IpfCcmBoControlEvent_manage",
            "leaf": 1,
            "parentcode": "034"
        },{
            "code": "01035",
            "name": "编辑页按钮",
            "url": "#basic_manage/platform_IpfCcmBoFormToolbar_manage",
            "leaf": 1,
            "parentcode": "035"
        },{
            "code": "01036",
            "name": "后台方法定义表",
            "url": "#basic_manage/platform_IpfCcmBoMethod_manage",
            "leaf": 1,
            "parentcode": "036"
        },{
            "code": "01037",
            "name": "方法参数定义表",
            "url": "#basic_manage/platform_IpfCcmBoMethodParam_manage",
            "leaf": 1,
            "parentcode": "037"
        },{
            "code": "01038",
            "name": "方法规则调用",
            "url": "#basic_manage/platform_IpfCcmBoMethodRule_manage",
            "leaf": 1,
            "parentcode": "038"
        },{
            "code": "01039",
            "name": "数据校验",
            "url": "#basic_manage/platform_IpfCcmBoCheck_manage",
            "leaf": 1,
            "parentcode": "039"
        },{
            "code": "01040",
            "name": "数据字段",
            "url": "#basic_manage/platform_IpfCcmBoCheckField_manage",
            "leaf": 1,
            "parentcode": "040"
        },{
            "code": "01041",
            "name": "校验分组",
            "url": "#basic_manage/platform_IpfCcmBoCheckRelGroup_manage",
            "leaf": 1,
            "parentcode": "041"
        },{
            "code": "01042",
            "name": "业务对象界面布局",
            "url": "#basic_manage/platform_IpfCcmUiLayoutConfig_manage",
            "leaf": 1,
            "parentcode": "042"
        },{
            "code": "01043",
            "name": "表单珊格",
            "url": "#basic_manage/platform_IpfCcmBoFormCell_manage",
            "leaf": 1,
            "parentcode": "043"
        },{
            "code": "01044",
            "name": "业务对象关系",
            "url": "#basic_manage/platform_IpfCcmBoRelation_manage",
            "leaf": 1,
            "parentcode": "044"
        },{
            "code": "01045",
            "name": "页面列表",
            "url": "#basic_manage/platform_IpfCcmBoPage_manage",
            "leaf": 1,
            "parentcode": "045"
        },{
            "code": "01046",
            "name": "页面布局",
            "url": "#basic_manage/platform_IpfCcmBoPageLayout_manage",
            "leaf": 1,
            "parentcode": "046"
        },{
            "code": "01047",
            "name": "布局元素定义",
            "url": "#basic_manage/platform_IpfCcmBoPgLoElement_manage",
            "leaf": 1,
            "parentcode": "047"
        },{
            "code": "01048",
            "name": "字典类型",
            "url": "#basic_manage/platform_IpfCcmDict_manage",
            "leaf": 1,
            "parentcode": "048"
        },{
            "code": "01049",
            "name": "字典数据",
            "url": "#basic_manage/platform_IpfCcmDictValue_manage",
            "leaf": 1,
            "parentcode": "049"
        },{
            "code": "01050",
            "name": "搜索帮助",
            "url": "#basic_manage/platform_IpfCcmShlp_manage",
            "leaf": 1,
            "parentcode": "050"
        },{
            "code": "01051",
            "name": "搜索帮助明细",
            "url": "#basic_manage/platform_IpfCcmShlpDetail_manage",
            "leaf": 1,
            "parentcode": "051"
        },{
            "code": "01052",
            "name": "搜索帮助多语言",
            "url": "#basic_manage/platform_IpfCcmShlpText_manage",
            "leaf": 1,
            "parentcode": "052"
        },{
            "code": "01053",
            "name": "运行期配置类型",
            "url": "#basic_manage/platform_IpfRtmType_manage",
            "leaf": 1,
            "parentcode": "053"
        },{
            "code": "01054",
            "name": "运行期配置界面",
            "url": "#basic_manage/platform_IpfRtmTypeBo_manage",
            "leaf": 1,
            "parentcode": "054"
        },{
            "code": "01055",
            "name": "运行期配置字段",
            "url": "#basic_manage/platform_IpfRtmTypeBoAttr_manage",
            "leaf": 1,
            "parentcode": "055"
        },{
            "code": "01056",
            "name": "类型与BO对照表",
            "url": "#basic_manage/platform_IpfRtmTypeBoMap_manage",
            "leaf": 1,
            "parentcode": "056"
        },{
            "code": "01057",
            "name": "运行期配置",
            "url": "#basic_manage/platform_IpfRtmConfig_manage",
            "leaf": 1,
            "parentcode": "057"
        },{
            "code": "01058",
            "name": "运行期配置明细",
            "url": "#basic_manage/platform_IpfRtmConfigAttr_manage",
            "leaf": 1,
            "parentcode": "058"
        },{
            "code": "01059",
            "name": "运行期配置明细BO扩展",
            "url": "#basic_manage/platform_IpfRtmConfigAttrBo_manage",
            "leaf": 1,
            "parentcode": "059"
        },{
            "code": "01060",
            "name": "定时任务",
            "url": "#basic_manage/platform_IpfScheduleJob_manage",
            "leaf": 1,
            "parentcode": "060"
        }]
    },{
        "code": "07",
        "name": "规则建模",
        "leaf": 0,
        "iconcls": "icon-check",
        children:[{
                "code": "01061",
                "name": "单号生成规则",
                "url": "#basic_manage/platform_IpfCcmNumrule_manage",
                "leaf": 1,
                "parentcode": "061"
            },{
                "code": "01062",
                "name": "单号生成规则历史",
                "url": "#basic_manage/platform_IpfCcmNumruleList_manage",
                "leaf": 1,
                "parentcode": "062"
            },{
                "code": "01063",
                "name": "业务规则",
                "url": "#basic_manage/platform_IpfCcmBizrule_manage",
                "leaf": 1,
                "parentcode": "063"
            },{
                "code": "01064",
                "name": "规则明细",
                "url": "#basic_manage/platform_IpfCcmBizruleDtl_manage",
                "leaf": 1,
                "parentcode": "064"
            },{
                "code": "01065",
                "name": "规则明细参数",
                "url": "#basic_manage/platform_IpfCcmBizruleDtlParam_manage",
                "leaf": 1,
                "parentcode": "065"
            },{
                "code": "01066",
                "name": "策略定义",
                "url": "#basic_manage/platform_IpfCcmStrategy_manage",
                "leaf": 1,
                "parentcode": "066"
            },{
                "code": "01067",
                "name": "策略参数定义",
                "url": "#basic_manage/platform_IpfCcmStrategyParam_manage",
                "leaf": 1,
                "parentcode": "067"
            },{
                "code": "01068",
                "name": "筛选条件配置",
                "url": "#basic_manage/platform_IpfRuleFilter_manage",
                "leaf": 1,
                "parentcode": "068"
            },{
                "code": "01069",
                "name": "筛选条件配置明细",
                "url": "#basic_manage/platform_IpfRuleFilterDetail_manage",
                "leaf": 1,
                "parentcode": "069"
            },{
                "code": "01070",
                "name": "周转规则",
                "url": "#basic_manage/platform_IpfRuleRotate_manage",
                "leaf": 1,
                "parentcode": "070"
            },{
                "code": "01071",
                "name": "周转规则明细",
                "url": "#basic_manage/platform_IpfRuleRotateDetail_manage",
                "leaf": 1,
                "parentcode": "071"
            }]
    }]
};