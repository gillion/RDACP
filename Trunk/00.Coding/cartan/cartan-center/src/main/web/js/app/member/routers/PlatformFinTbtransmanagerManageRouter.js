
/**
 * 交易客户经理登记
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["types/Class",
    "utils/Log",
    "jquery",
    "base/BaseRouter",
    "base/BaseView",
    "grid/simplelist",
    "grid/SimpleListUtil",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		AjaxEngine){    
	
    
    function showEditDetilDialog(tp, titles, id, url, content){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, 190, titles);
    	
        
        if (tp==1){
        $("#submitBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),etlDate: $("#etlDate").val(),serialNo: $("#serialNo").val(),clientNo: $("#clientNo").val(),managerType: $("#managerType").val(),taCode: $("#taCode").val(),summary: $("#summary").val(),clientManager01: $("#clientManager01").val(),managerRate01: $("#managerRate01").val(),clientManager02: $("#clientManager02").val(),managerRate02: $("#managerRate02").val(),clientManager03: $("#clientManager03").val(),managerRate03: $("#managerRate03").val(),clientManager04: $("#clientManager04").val(),managerRate04: $("#managerRate04").val(),clientManager05: $("#clientManager05").val(),managerRate05: $("#managerRate05").val(),clientManager06: $("#clientManager06").val(),managerRate06: $("#managerRate06").val(),clientManager07: $("#clientManager07").val(),managerRate07: $("#managerRate07").val(),clientManager08: $("#clientManager08").val(),managerRate08: $("#managerRate08").val(),clientManager09: $("#clientManager09").val(),managerRate09: $("#managerRate09").val(),clientManager10: $("#clientManager10").val(),managerRate10: $("#managerRate10").val(),insertDate: $("#insertDate").val()},
                    dataType: 'json',
                    complete: function(transport){
                        result = transport.responseText;
                        result = $.parseJSON(result);
                        alert("操作成功！");
                        kendoUIWindow.close();
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.read();
                        table0.refresh();
                    }
                }
            );
        });
    	} else{
        $("#QueryBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),etlDate: $("#etlDate").val(),serialNo: $("#serialNo").val(),clientNo: $("#clientNo").val(),managerType: $("#managerType").val(),taCode: $("#taCode").val(),summary: $("#summary").val(),clientManager01: $("#clientManager01").val(),managerRate01: $("#managerRate01").val(),clientManager02: $("#clientManager02").val(),managerRate02: $("#managerRate02").val(),clientManager03: $("#clientManager03").val(),managerRate03: $("#managerRate03").val(),clientManager04: $("#clientManager04").val(),managerRate04: $("#managerRate04").val(),clientManager05: $("#clientManager05").val(),managerRate05: $("#managerRate05").val(),clientManager06: $("#clientManager06").val(),managerRate06: $("#managerRate06").val(),clientManager07: $("#clientManager07").val(),managerRate07: $("#managerRate07").val(),clientManager08: $("#clientManager08").val(),managerRate08: $("#managerRate08").val(),clientManager09: $("#clientManager09").val(),managerRate09: $("#managerRate09").val(),clientManager10: $("#clientManager10").val(),managerRate10: $("#managerRate10").val(),insertDate: $("#insertDate").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];

                            }
                        }
                        
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.data([]);
                        table0.dataSource.data(result.resultJson);
                        kendoUIWindow.close();
                    }
                }
            );
        });
    	}
        SimpleListUtil.setDataTimeCn();

        
    }
    
    var PlatformFinTbtransmanagerManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_FinTbtransmanager_manage": "showPlatformFinTbtransmanagerManageList",  
            "basic_manage/platform_ckFinTbtransmanager_manage": "showPlatformckFinTbtransmanagerManageList"
        },
        showPlatformckFinTbtransmanagerManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformFinTbtransmanagerManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformFinTbtransmanagerManageListView = new SimpleListView({
                id: "platform_finTbtransmanager_manage_list",
                title: "基础管理 > 交易客户经理登记",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("交易客户经理登记");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='letlDate' align='right'>ETL日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='etlDate' name='ETL日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lserialNo' align='right'>流水号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='serialNo' name='流水号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientNo' align='right'>客户编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientNo' name='客户编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerType' align='right'>客户经理类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerType' name='客户经理类别' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltaCode' align='right'>TA代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='taCode' name='TA代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsummary' align='right'>备注：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='summary' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager01' align='right'>客户经理编号01：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager01' name='客户经理编号01' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate01' align='right'>客户经理比例01：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate01' name='客户经理比例01' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager02' align='right'>客户经理编号02：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager02' name='客户经理编号02' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate02' align='right'>客户经理比例02：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate02' name='客户经理比例02' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager03' align='right'>客户经理编号03：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager03' name='客户经理编号03' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate03' align='right'>客户经理比例03：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate03' name='客户经理比例03' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager04' align='right'>客户经理编号04：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager04' name='客户经理编号04' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate04' align='right'>客户经理编号04：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate04' name='客户经理编号04' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager05' align='right'>客户经理编号05：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager05' name='客户经理编号05' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate05' align='right'>客户经理编号05：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate05' name='客户经理编号05' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager06' align='right'>客户经理编号06：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager06' name='客户经理编号06' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate06' align='right'>客户经理编号06：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate06' name='客户经理编号06' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager07' align='right'>客户经理编号07：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager07' name='客户经理编号07' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate07' align='right'>客户经理编号07：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate07' name='客户经理编号07' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager08' align='right'>客户经理编号08：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager08' name='客户经理编号08' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate08' align='right'>客户经理编号08：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate08' name='客户经理编号08' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager09' align='right'>客户经理编号09：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager09' name='客户经理编号09' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate09' align='right'>客户经理编号09：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate09' name='客户经理编号09' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager10' align='right'>客户经理编号10：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager10' name='客户经理编号10' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate10' align='right'>客户经理编号10：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate10' name='客户经理编号10' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linsertDate' align='right'>加载日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='insertDate' name='加载日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=finTbtransmanager.createFinTbtransmanager&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformFinTbtransmanagerManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformFinTbtransmanagerManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformFinTbtransmanagerManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=finTbtransmanager.deleteFinTbtransmanager&v=1.0&format=json",
                            {
                                async: false,
                                data:{id: ID},
                                dataType: 'json',
                                complete: function(transport){
                                    result = transport.responseText;
                                    result = $.parseJSON(result);
                                	}
                            	}
                            );
                        }
                        alert("删除成功！");
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.read();
                        table0.refresh();
                        } else {
                            alert("请先选择记录！");
                        }
                    }, "delete");
                    this.addToolbarBtn("queryBtn", "查 询", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          

                        detailstr+="<tr><td>";
                        detailstr+="<label id='letlDate' align='right'>ETL日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='etlDate' name='ETL日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lserialNo' align='right'>流水号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='serialNo' name='流水号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientNo' align='right'>客户编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientNo' name='客户编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerType' align='right'>客户经理类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerType' name='客户经理类别' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltaCode' align='right'>TA代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='taCode' name='TA代码' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsummary' align='right'>备注：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='summary' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager01' align='right'>客户经理编号01：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager01' name='客户经理编号01' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate01' align='right'>客户经理比例01：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate01' name='客户经理比例01' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager02' align='right'>客户经理编号02：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager02' name='客户经理编号02' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate02' align='right'>客户经理比例02：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate02' name='客户经理比例02' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager03' align='right'>客户经理编号03：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager03' name='客户经理编号03' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate03' align='right'>客户经理比例03：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate03' name='客户经理比例03' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager04' align='right'>客户经理编号04：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager04' name='客户经理编号04' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate04' align='right'>客户经理编号04：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate04' name='客户经理编号04' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager05' align='right'>客户经理编号05：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager05' name='客户经理编号05' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate05' align='right'>客户经理编号05：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate05' name='客户经理编号05' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager06' align='right'>客户经理编号06：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager06' name='客户经理编号06' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate06' align='right'>客户经理编号06：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate06' name='客户经理编号06' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager07' align='right'>客户经理编号07：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager07' name='客户经理编号07' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate07' align='right'>客户经理编号07：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate07' name='客户经理编号07' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager08' align='right'>客户经理编号08：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager08' name='客户经理编号08' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate08' align='right'>客户经理编号08：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate08' name='客户经理编号08' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager09' align='right'>客户经理编号09：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager09' name='客户经理编号09' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate09' align='right'>客户经理编号09：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate09' name='客户经理编号09' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientManager10' align='right'>客户经理编号10：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientManager10' name='客户经理编号10' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmanagerRate10' align='right'>客户经理编号10：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='managerRate10' name='客户经理编号10' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='linsertDate' align='right'>加载日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='insertDate' name='加载日期' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=finTbtransmanager.selectFinTbtransmanager&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=finTbtransmanager.selectFinTbtransmanager&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },etlDate: { type: "string" },serialNo: { type: "string" },clientNo: { type: "string" },managerType: { type: "string" },taCode: { type: "string" },summary: { type: "string" },clientManager01: { type: "string" },managerRate01: { type: "string" },clientManager02: { type: "string" },managerRate02: { type: "string" },clientManager03: { type: "string" },managerRate03: { type: "string" },clientManager04: { type: "string" },managerRate04: { type: "string" },clientManager05: { type: "string" },managerRate05: { type: "string" },clientManager06: { type: "string" },managerRate06: { type: "string" },clientManager07: { type: "string" },managerRate07: { type: "string" },clientManager08: { type: "string" },managerRate08: { type: "string" },clientManager09: { type: "string" },managerRate09: { type: "string" },clientManager10: { type: "string" },managerRate10: { type: "string" },insertDate: { type: "string" }
                            }
                        },
                        parse: function(response) {
                            return response;
                        },
                        //返回的数据
                        data: function(response) {
                            var result = response["resultJson"];

                            if($.isArray(result)){
                                var data = null;
                                for(var i= 0, count=result.length; i<count; i++){
                                    data = result[i];


                                }
                            }
                            result = platformFinTbtransmanagerManageListView.appendColValue(result);
                            return result;
                        },
                        //记录条数
                        total: function(response) {
                            var result = response["total"] || response["resultJson"].length;
                            return result;
                        }
                    }
                },
                columns: [
                          {field: "chk", type:"chk", title: "&nbsp;", value:"ID"},
                          {field: "id", title:"编号", hidden:"true", align:"center", width: "100px"},

    						
                    		{field: "etlDate", title:"ETL日期", align:"center", width: "100px"},

    						
                    		{field: "serialNo", title:"流水号", align:"center", width: "100px"},

    						
                    		{field: "clientNo", title:"客户编号", align:"center", width: "100px"},

    						
                    		{field: "managerType", title:"客户经理类别", align:"center", width: "100px"},

    						
                    		{field: "taCode", title:"TA代码", align:"center", width: "100px"},

    						
                    		{field: "summary", title:"备注", align:"center", width: "100px"},

    						
                    		{field: "clientManager01", title:"客户经理编号01", align:"center", width: "100px"},

    						
                    		{field: "managerRate01", title:"客户经理比例01", align:"center", width: "100px"},

    						
                    		{field: "clientManager02", title:"客户经理编号02", align:"center", width: "100px"},

    						
                    		{field: "managerRate02", title:"客户经理比例02", align:"center", width: "100px"},

    						
                    		{field: "clientManager03", title:"客户经理编号03", align:"center", width: "100px"},

    						
                    		{field: "managerRate03", title:"客户经理比例03", align:"center", width: "100px"},

    						
                    		{field: "clientManager04", title:"客户经理编号04", align:"center", width: "100px"},

    						
                    		{field: "managerRate04", title:"客户经理编号04", align:"center", width: "100px"},

    						
                    		{field: "clientManager05", title:"客户经理编号05", align:"center", width: "100px"},

    						
                    		{field: "managerRate05", title:"客户经理编号05", align:"center", width: "100px"},

    						
                    		{field: "clientManager06", title:"客户经理编号06", align:"center", width: "100px"},

    						
                    		{field: "managerRate06", title:"客户经理编号06", align:"center", width: "100px"},

    						
                    		{field: "clientManager07", title:"客户经理编号07", align:"center", width: "100px"},

    						
                    		{field: "managerRate07", title:"客户经理编号07", align:"center", width: "100px"},

    						
                    		{field: "clientManager08", title:"客户经理编号08", align:"center", width: "100px"},

    						
                    		{field: "managerRate08", title:"客户经理编号08", align:"center", width: "100px"},

    						
                    		{field: "clientManager09", title:"客户经理编号09", align:"center", width: "100px"},

    						
                    		{field: "managerRate09", title:"客户经理编号09", align:"center", width: "100px"},

    						
                    		{field: "clientManager10", title:"客户经理编号10", align:"center", width: "100px"},

    						
                    		{field: "managerRate10", title:"客户经理编号10", align:"center", width: "100px"},

    						
                    		{field: "insertDate", title:"加载日期", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformFinTbtransmanagerManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformFinTbtransmanagerManageListView.get("columns");
                                var col = null;
                                var colName = null;
                                var value = null;
                                var ColumnValue = {};
                                for(var i= 0, colCount=columnArray.length; i<colCount; i++){
                                    col = columnArray[i];
                                    colName = col.field;
                                    value = SimpleListUtil.getSelectedColumnValue(this, colName);
                                    ColumnValue[colName] = value;
                                }

                                var detailstr="";
                                detailstr+="<div id='content' align='center'>";
                                detailstr+="<table>";
                                detailstr+="<input id='id' name='编号' hidden='true' value='"+ColumnValue["id"]+"' style='...'/>";

                                detailstr+="<tr><td>";
                                detailstr+="<label id='letlDate' align='right'>ETL日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='etlDate' name='ETL日期' value='"+ColumnValue["etlDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lserialNo' align='right'>流水号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='serialNo' name='流水号' value='"+ColumnValue["serialNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientNo' align='right'>客户编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientNo' name='客户编号' value='"+ColumnValue["clientNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmanagerType' align='right'>客户经理类别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='managerType' name='客户经理类别' value='"+ColumnValue["managerType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltaCode' align='right'>TA代码：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='taCode' name='TA代码' value='"+ColumnValue["taCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsummary' align='right'>备注：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='summary' name='备注' value='"+ColumnValue["summary"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientManager01' align='right'>客户经理编号01：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientManager01' name='客户经理编号01' value='"+ColumnValue["clientManager01"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmanagerRate01' align='right'>客户经理比例01：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='managerRate01' name='客户经理比例01' value='"+ColumnValue["managerRate01"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientManager02' align='right'>客户经理编号02：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientManager02' name='客户经理编号02' value='"+ColumnValue["clientManager02"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmanagerRate02' align='right'>客户经理比例02：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='managerRate02' name='客户经理比例02' value='"+ColumnValue["managerRate02"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientManager03' align='right'>客户经理编号03：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientManager03' name='客户经理编号03' value='"+ColumnValue["clientManager03"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmanagerRate03' align='right'>客户经理比例03：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='managerRate03' name='客户经理比例03' value='"+ColumnValue["managerRate03"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientManager04' align='right'>客户经理编号04：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientManager04' name='客户经理编号04' value='"+ColumnValue["clientManager04"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmanagerRate04' align='right'>客户经理编号04：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='managerRate04' name='客户经理编号04' value='"+ColumnValue["managerRate04"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientManager05' align='right'>客户经理编号05：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientManager05' name='客户经理编号05' value='"+ColumnValue["clientManager05"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmanagerRate05' align='right'>客户经理编号05：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='managerRate05' name='客户经理编号05' value='"+ColumnValue["managerRate05"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientManager06' align='right'>客户经理编号06：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientManager06' name='客户经理编号06' value='"+ColumnValue["clientManager06"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmanagerRate06' align='right'>客户经理编号06：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='managerRate06' name='客户经理编号06' value='"+ColumnValue["managerRate06"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientManager07' align='right'>客户经理编号07：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientManager07' name='客户经理编号07' value='"+ColumnValue["clientManager07"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmanagerRate07' align='right'>客户经理编号07：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='managerRate07' name='客户经理编号07' value='"+ColumnValue["managerRate07"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientManager08' align='right'>客户经理编号08：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientManager08' name='客户经理编号08' value='"+ColumnValue["clientManager08"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmanagerRate08' align='right'>客户经理编号08：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='managerRate08' name='客户经理编号08' value='"+ColumnValue["managerRate08"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientManager09' align='right'>客户经理编号09：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientManager09' name='客户经理编号09' value='"+ColumnValue["clientManager09"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmanagerRate09' align='right'>客户经理编号09：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='managerRate09' name='客户经理编号09' value='"+ColumnValue["managerRate09"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientManager10' align='right'>客户经理编号10：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientManager10' name='客户经理编号10' value='"+ColumnValue["clientManager10"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmanagerRate10' align='right'>客户经理编号10：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='managerRate10' name='客户经理编号10' value='"+ColumnValue["managerRate10"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linsertDate' align='right'>加载日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='insertDate' name='加载日期' value='"+ColumnValue["insertDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=finTbtransmanager.updateFinTbtransmanager&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformFinTbtransmanagerManageListView);
        }
    });

    return PlatformFinTbtransmanagerManageRouter;
});
