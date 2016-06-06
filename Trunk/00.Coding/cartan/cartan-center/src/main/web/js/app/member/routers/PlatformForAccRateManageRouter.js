
/**
 * 外币帐户利率
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
                    data:{id: $("#id").val(),etlDate: $("#etlDate").val(),centerCus: $("#centerCus").val(),subbranch: $("#subbranch").val(),cardId: $("#cardId").val(),moneyCode: $("#moneyCode").val(),productCode: $("#productCode").val(),sector: $("#sector").val(),productValue: $("#productValue").val(),allShare: $("#allShare").val(),allValue: $("#allValue").val(),allValueRmb: $("#allValueRmb").val(),levMoneyCode: $("#levMoneyCode").val(),cardSector: $("#cardSector").val(),begindate: $("#begindate").val(),enddate: $("#enddate").val(),rproductCode: $("#rproductCode").val(),cardCenterCus: $("#cardCenterCus").val(),accountNum: $("#accountNum").val(),cusName: $("#cusName").val(),idCardType: $("#idCardType").val(),idCardNum: $("#idCardNum").val(),insertDate: $("#insertDate").val()},
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
                    data:{id: $("#id").val(),etlDate: $("#etlDate").val(),centerCus: $("#centerCus").val(),subbranch: $("#subbranch").val(),cardId: $("#cardId").val(),moneyCode: $("#moneyCode").val(),productCode: $("#productCode").val(),sector: $("#sector").val(),productValue: $("#productValue").val(),allShare: $("#allShare").val(),allValue: $("#allValue").val(),allValueRmb: $("#allValueRmb").val(),levMoneyCode: $("#levMoneyCode").val(),cardSector: $("#cardSector").val(),begindate: $("#begindate").val(),enddate: $("#enddate").val(),rproductCode: $("#rproductCode").val(),cardCenterCus: $("#cardCenterCus").val(),accountNum: $("#accountNum").val(),cusName: $("#cusName").val(),idCardType: $("#idCardType").val(),idCardNum: $("#idCardNum").val(),insertDate: $("#insertDate").val()},
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
    
    var PlatformForAccRateManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_ForAccRate_manage": "showPlatformForAccRateManageList",  
            "basic_manage/platform_ckForAccRate_manage": "showPlatformckForAccRateManageList"
        },
        showPlatformckForAccRateManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformForAccRateManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformForAccRateManageListView = new SimpleListView({
                id: "platform_forAccRate_manage_list",
                title: "基础管理 > 外币帐户利率",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("外币帐户利率");
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
                        detailstr+="<label id='lcenterCus' align='right'>核心客户号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='centerCus' name='核心客户号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubbranch' align='right'>销售机构编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='subbranch' name='销售机构编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardId' align='right'>卡号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardId' name='卡号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmoneyCode' align='right'>币种代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='moneyCode' name='币种代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductCode' align='right'>产品代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productCode' name='产品代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsector' align='right'>所属机构编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sector' name='所属机构编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductValue' align='right'>产品净值：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productValue' name='产品净值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lallShare' align='right'>份额总数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='allShare' name='份额总数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lallValue' align='right'>净值总额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='allValue' name='净值总额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lallValueRmb' align='right'>净值总额折人民币：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='allValueRmb' name='净值总额折人民币' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llevMoneyCode' align='right'>标准币种代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='levMoneyCode' name='标准币种代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardSector' align='right'>开卡机构编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardSector' name='开卡机构编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbegindate' align='right'>起息日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='begindate' name='起息日' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lenddate' align='right'>到期日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='enddate' name='到期日' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrproductCode' align='right'>R产品编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='rproductCode' name='R产品编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardCenterCus' align='right'>卡的核心客户号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardCenterCus' name='卡的核心客户号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>主帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='主帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusName' align='right'>客户姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusName' name='客户姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lidCardType' align='right'>标准证件类型：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='idCardType' name='标准证件类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lidCardNum' align='right'>标准证件号码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='idCardNum' name='标准证件号码' style='...'/>";
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
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=forAccRate.createForAccRate&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformForAccRateManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformForAccRateManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformForAccRateManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=forAccRate.deleteForAccRate&v=1.0&format=json",
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
                        detailstr+="<label id='lcenterCus' align='right'>核心客户号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='centerCus' name='核心客户号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubbranch' align='right'>销售机构编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='subbranch' name='销售机构编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardId' align='right'>卡号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardId' name='卡号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmoneyCode' align='right'>币种代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='moneyCode' name='币种代码' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductCode' align='right'>产品代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productCode' name='产品代码' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsector' align='right'>所属机构编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sector' name='所属机构编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductValue' align='right'>产品净值：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productValue' name='产品净值' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lallShare' align='right'>份额总数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='allShare' name='份额总数' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lallValue' align='right'>净值总额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='allValue' name='净值总额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lallValueRmb' align='right'>净值总额折人民币：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='allValueRmb' name='净值总额折人民币' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='llevMoneyCode' align='right'>标准币种代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='levMoneyCode' name='标准币种代码' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardSector' align='right'>开卡机构编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardSector' name='开卡机构编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbegindate' align='right'>起息日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='begindate' name='起息日' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lenddate' align='right'>到期日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='enddate' name='到期日' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrproductCode' align='right'>R产品编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='rproductCode' name='R产品编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardCenterCus' align='right'>卡的核心客户号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardCenterCus' name='卡的核心客户号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>主帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='主帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusName' align='right'>客户姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusName' name='客户姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lidCardType' align='right'>标准证件类型：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='idCardType' name='标准证件类型' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lidCardNum' align='right'>标准证件号码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='idCardNum' name='标准证件号码' style='...'/>";
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
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=forAccRate.selectForAccRate&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=forAccRate.selectForAccRate&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },etlDate: { type: "string" },centerCus: { type: "string" },subbranch: { type: "string" },cardId: { type: "string" },moneyCode: { type: "string" },productCode: { type: "string" },sector: { type: "string" },productValue: { type: "string" },allShare: { type: "string" },allValue: { type: "string" },allValueRmb: { type: "string" },levMoneyCode: { type: "string" },cardSector: { type: "string" },begindate: { type: "string" },enddate: { type: "string" },rproductCode: { type: "string" },cardCenterCus: { type: "string" },accountNum: { type: "string" },cusName: { type: "string" },idCardType: { type: "string" },idCardNum: { type: "string" },insertDate: { type: "string" }
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
                            result = platformForAccRateManageListView.appendColValue(result);
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

    						
                    		{field: "centerCus", title:"核心客户号", align:"center", width: "100px"},

    						
                    		{field: "subbranch", title:"销售机构编号", align:"center", width: "100px"},

    						
                    		{field: "cardId", title:"卡号", align:"center", width: "100px"},

    						
                    		{field: "moneyCode", title:"币种代码", align:"center", width: "100px"},

    						
                    		{field: "productCode", title:"产品代码", align:"center", width: "100px"},

    						
                    		{field: "sector", title:"所属机构编号", align:"center", width: "100px"},

    						
                    		{field: "productValue", title:"产品净值", align:"center", width: "100px"},

    						
                    		{field: "allShare", title:"份额总数", align:"center", width: "100px"},

    						
                    		{field: "allValue", title:"净值总额", align:"center", width: "100px"},

    						
                    		{field: "allValueRmb", title:"净值总额折人民币", align:"center", width: "100px"},

    						
                    		{field: "levMoneyCode", title:"标准币种代码", align:"center", width: "100px"},

    						
                    		{field: "cardSector", title:"开卡机构编号", align:"center", width: "100px"},

    						
                    		{field: "begindate", title:"起息日", align:"center", width: "100px"},

    						
                    		{field: "enddate", title:"到期日", align:"center", width: "100px"},

    						
                    		{field: "rproductCode", title:"R产品编号", align:"center", width: "100px"},

    						
                    		{field: "cardCenterCus", title:"卡的核心客户号", align:"center", width: "100px"},

    						
                    		{field: "accountNum", title:"主帐号", align:"center", width: "100px"},

    						
                    		{field: "cusName", title:"客户姓名", align:"center", width: "100px"},

    						
                    		{field: "idCardType", title:"标准证件类型", align:"center", width: "100px"},

    						
                    		{field: "idCardNum", title:"标准证件号码", align:"center", width: "100px"},

    						
                    		{field: "insertDate", title:"加载日期", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformForAccRateManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformForAccRateManageListView.get("columns");
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
                                detailstr+="<label id='lcenterCus' align='right'>核心客户号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='centerCus' name='核心客户号' value='"+ColumnValue["centerCus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsubbranch' align='right'>销售机构编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='subbranch' name='销售机构编号' value='"+ColumnValue["subbranch"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcardId' align='right'>卡号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cardId' name='卡号' value='"+ColumnValue["cardId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmoneyCode' align='right'>币种代码：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='moneyCode' name='币种代码' value='"+ColumnValue["moneyCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lproductCode' align='right'>产品代码：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='productCode' name='产品代码' value='"+ColumnValue["productCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsector' align='right'>所属机构编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='sector' name='所属机构编号' value='"+ColumnValue["sector"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lproductValue' align='right'>产品净值：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='productValue' name='产品净值' value='"+ColumnValue["productValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lallShare' align='right'>份额总数：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='allShare' name='份额总数' value='"+ColumnValue["allShare"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lallValue' align='right'>净值总额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='allValue' name='净值总额' value='"+ColumnValue["allValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lallValueRmb' align='right'>净值总额折人民币：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='allValueRmb' name='净值总额折人民币' value='"+ColumnValue["allValueRmb"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llevMoneyCode' align='right'>标准币种代码：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='levMoneyCode' name='标准币种代码' value='"+ColumnValue["levMoneyCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcardSector' align='right'>开卡机构编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cardSector' name='开卡机构编号' value='"+ColumnValue["cardSector"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbegindate' align='right'>起息日：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='begindate' name='起息日' value='"+ColumnValue["begindate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lenddate' align='right'>到期日：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='enddate' name='到期日' value='"+ColumnValue["enddate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrproductCode' align='right'>R产品编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='rproductCode' name='R产品编号' value='"+ColumnValue["rproductCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcardCenterCus' align='right'>卡的核心客户号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cardCenterCus' name='卡的核心客户号' value='"+ColumnValue["cardCenterCus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laccountNum' align='right'>主帐号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountNum' name='主帐号' value='"+ColumnValue["accountNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcusName' align='right'>客户姓名：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cusName' name='客户姓名' value='"+ColumnValue["cusName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lidCardType' align='right'>标准证件类型：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='idCardType' name='标准证件类型' value='"+ColumnValue["idCardType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lidCardNum' align='right'>标准证件号码：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='idCardNum' name='标准证件号码' value='"+ColumnValue["idCardNum"]+"' style='...'/>";
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
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=forAccRate.updateForAccRate&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformForAccRateManageListView);
        }
    });

    return PlatformForAccRateManageRouter;
});
