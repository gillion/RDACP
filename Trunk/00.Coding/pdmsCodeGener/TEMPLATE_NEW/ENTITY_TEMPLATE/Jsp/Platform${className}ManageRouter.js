<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign porpNo = 0>
	<#list table.columns as column>
     <#assign porpNo=porpNo+1>
     <#if porpNo==1>    
		    <#assign columnkey = column.columnNameLower>  
     		<#assign columnsqlkey = column.sqlName>   		
	</#if>
    <#if column.pk> 	   
    		<#assign columnkey = column.columnNameLower> 
     		<#assign columnsqlkey = column.sqlName>   			   		
		</#if>
	</#list>

    <#assign pagesize = psize>   
    <#assign pagewidth = pagesize*350+30>   
    <#assign kedoHeight=(porpNo+1)*30+10>

/**
 * ${table.tableAlias}
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
	<#list selectfieldList as prop> 
<#list table.columns as column>
<#if column.columnNameLower==prop.name>  
    "js/app/${sysname}/routers/Platform${prop.uiType}SelDialog",
    </#if>
	</#list>  
	</#list>  
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		<#list selectfieldList as prop>   
<#list table.columns as column>
<#if column.columnNameLower==prop.name>  
		Platform${prop.uiType}SelDialog,
	    </#if>
		</#list>  
		</#list>  
		AjaxEngine){    
	
	<#list selectfieldList as prop>     
	<#list table.columns as column>
	<#if column.columnNameLower==prop.name>  
    function show${prop.uiType}SelDialog(){
        var detailstr="";
        detailstr+="<div id='${prop.uiType}grid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = Platform${prop.uiType}SelDialog.showGridData($("#${prop.uiType}grid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.${prop.cnName};
            $("#${prop.name}").val(Id);
            $("#${prop.uiType}Name").val(Name);
            kendoUIWindow.close();
        });
    }
    </#if>
	</#list>  
	</#list>  
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, ${pagewidth}, height, titles);
        
    	<#list radioList as prop>     
		<#list table.columns as column>    
		<#if column.columnNameLower==prop.name>    
        var ${column.columnNameLower}Model = kendo.observable({
            isChecked:  $("*[name='${column.columnNameLower}']").attr("curdata")
        });
        kendo.bind($("*[name='${column.columnNameLower}']"), ${column.columnNameLower}Model);        
        </#if>
		</#list>  
        </#list>
    	
        
        
    	<#list selectfieldList as prop>       
		<#list table.columns as column>
		<#if column.columnNameLower==prop.name>    
        var ${prop.uiType}viewModel = kendo.observable({
            id: $("#${column.columnNameLower}").val(),
            name: $("#${prop.uiType}Name").val(),
            displayGreeting: function() {
            show${prop.uiType}SelDialog();
            }
        });
        kendo.bind($("#view${prop.uiType}"), ${prop.uiType}viewModel);
        </#if>
		</#list>  
        </#list>

    	<#list checkboxList as prop>       
		<#list table.columns as column>
		<#if column.columnNameLower==prop.name>    
        var ${column.columnNameLower}Model = kendo.observable({
            isChecked: $("#${column.columnNameLower}").val()=="1"
        });
        kendo.bind($("#${column.columnNameLower}"), ${column.columnNameLower}Model);
        var ${column.columnNameLower}val="0";
		
        </#if>
		</#list>  
        </#list>
        if (tp==1){
        $("#submitBtn").click(function(){    	
        <#list checkboxList as prop>       
		<#list table.columns as column>
		<#if column.columnNameLower==prop.name>    
            if (${column.columnNameLower}Model.isChecked){
            	${column.columnNameLower}val="1";
            } else {
            	${column.columnNameLower}val="0";
            }
        </#if>
    	</#list>  
        </#list>
        var sid=SimpleListUtil.getSessionId();
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{sessionId: sid,<#assign porpNo = 0><#list table.columns as column><#assign porpNo=porpNo+1><#if porpNo==1><#assign ckNo = 0><#list radioList as prop><#if column.columnNameLower==prop.name><#assign ckNo = 1>${column.columnNameLower}:${column.columnNameLower}Model.isChecked</#if></#list><#list checkboxList as prop><#if column.columnNameLower==prop.name><#assign ckNo = 1>${column.columnNameLower}:${column.columnNameLower}val</#if></#list><#if ckNo==0>${column.columnNameLower}: $("#${column.columnNameLower}").val()</#if><#else><#assign ckNo = 0><#list radioList as prop><#if column.columnNameLower==prop.name><#assign ckNo = 1>,${column.columnNameLower}:${column.columnNameLower}Model.isChecked</#if></#list><#list checkboxList as prop><#if column.columnNameLower==prop.name><#assign ckNo = 1>,${column.columnNameLower}: ${column.columnNameLower}val</#if></#list><#if ckNo==0>,${column.columnNameLower}: $("#${column.columnNameLower}").val()</#if></#if></#list>},
                    dataType: 'json',
                    complete: function(transport){
                        result = transport.responseText;
                        result = $.parseJSON(result);
                        alert("操作成功！");
                        kendoUIWindow.close();
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.read();
                        table0.refresh();
                        $("#submitBtn").attr("disabled", false);
                    }
                }
            );
        });
    	} else{
        $("#QueryBtn").click(function(){
            <#list checkboxList as prop>       
    		<#list table.columns as column>
    		<#if column.columnNameLower==prop.name>    
                if (${column.columnNameLower}Model.isChecked){
                	${column.columnNameLower}val="1";
                } else {
                	${column.columnNameLower}val="";
                }
            </#if>
        	</#list>  
            </#list>
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{<#assign porpNo = 0><#list table.columns as column><#assign porpNo=porpNo+1><#if porpNo==1><#assign ckNo = 0><#list radioList as prop><#if column.columnNameLower==prop.name><#assign ckNo = 1>${column.columnNameLower}:${column.columnNameLower}Model.isChecked</#if></#list><#list checkboxList as prop><#if column.columnNameLower==prop.name><#assign ckNo = 1>${column.columnNameLower}:${column.columnNameLower}val</#if></#list><#if ckNo==0>${column.columnNameLower}: $("#${column.columnNameLower}").val()</#if><#else><#assign ckNo = 0><#list radioList as prop><#if column.columnNameLower==prop.name><#assign ckNo = 1>,${column.columnNameLower}:${column.columnNameLower}Model.isChecked</#if></#list><#list checkboxList as prop><#if column.columnNameLower==prop.name><#assign ckNo = 1>,${column.columnNameLower}:${column.columnNameLower}val</#if></#list><#if ckNo==0>,${column.columnNameLower}: $("#${column.columnNameLower}").val()</#if></#if></#list>},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                            	<#list selectfieldList as prop>   
                            	<#list table.columns as column>
                            	<#if column.columnNameLower==prop.name>    
                                data["${prop.uiType}Name"] = Platform${prop.uiType}SelDialog.codetodes(data["${prop.name}"]);
                        	    </#if>
                        		</#list>  
                                </#list>

                            	<#list comboxList as prop>        
                            	<#list table.columns as column>
                        		<#if column.columnNameLower==prop.name> 
                        		data["${column.columnNameLower}Name"] = SimpleListUtil.getSelectDes("${prop.uiType}", data["${column.columnNameLower}"]);
                        		</#if>            
                        		</#list>        
        						</#list>        
        						
                            	<#list radioList as prop>        
                            	<#list table.columns as column>
                        		<#if column.columnNameLower==prop.name> 
                        		data["${column.columnNameLower}Name"] = SimpleListUtil.getSelectDes("${prop.uiType}", data["${column.columnNameLower}"]);
                        		</#if>            
                        		</#list>        
        						</#list>        
        						
                            	<#list checkboxList as prop>        
                            	<#list table.columns as column>
                        		<#if column.columnNameLower==prop.name> 
                        		data["${column.columnNameLower}Name"] = SimpleListUtil.getSelectDes("${prop.uiType}", data["${column.columnNameLower}"]);
                        		</#if>            
                        		</#list>        
        						</#list>        
                            }
                        }

                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.data([]);
                        table0.dataSource.data(result.resultJson);
                        $("#QueryBtn").attr("disabled", false);
                        kendoUIWindow.close();
                    }
                }
            );
        });
    	}
        SimpleListUtil.setDataTimeCn();

    	<#list timefieldList as prop>        
		<#list table.columns as column>
		<#if column.columnNameLower==prop.name>    
        if (tp==1){
        	$("#${prop.name}").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss", value:new Date()});
        } else {
        	$("#${prop.name}").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss"});
        }
        </#if>
        </#list>
    	</#list>
        
    }
    
    var Platform${className}ManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_${className}_manage": "showPlatform${className}ManageList",  
            "basic_manage/platform_ck${className}_manage": "showPlatformck${className}ManageList"
        },
        showPlatformck${className}ManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatform${className}ManageList: function(){
            var sid=SimpleListUtil.getSessionId();
            var platform${className}ManageListView = new SimpleListView({
                id: "platform_${classNameLower}_manage_list",
                title: "基础数据 > ${tabledes}",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("${tabledes}");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        <#assign rowsize = 0>                        
                        <#assign winheight = 60>
						<#list table.columns as column>

                        <#assign isComm = 0>
                    	<#list commonfieldList as prop>        
                		<#if column.columnNameLower==prop.name> 
                        <#assign isComm = 1>      
                		</#if>                  
						</#list>    
						<#if isComm == 0> 
						
                        <#if column.pk>      
                        detailstr+="<input id='${column.columnNameLower}' name='${column.columnAlias}' hidden='true' style='...'/>";                          
                        <#else>
                        <#if rowsize == 0> 
                        detailstr+="<tr>";
						<#assign winheight = winheight+30>
                        </#if>  
                        <#assign rowsize = rowsize+1> 
                        detailstr+="<td>";
                        detailstr+="<label id='l${column.columnNameLower}' align='right'>${column.columnAlias}：</label>";
                        detailstr+="</td><td>";
                        <#assign porpNo = 0>
                    	<#list selectfieldList as prop>        
                		<#if column.columnNameLower==prop.name> 
						<#assign winheight = winheight+2>
                        detailstr+="<div id='view${prop.uiType}'>";                        
                        detailstr+="<input id='${column.columnNameLower}' name='${column.columnNameLower}' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='${prop.uiType}Name' name='${prop.uiType}Name' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        <#assign porpNo = 1>      
                		</#if>                  
						</#list>   
                    	<#list comboxList as prop>        
                		<#if column.columnNameLower==prop.name> 
                        detailstr+="<select name='${column.columnAlias}' id='${column.columnNameLower}' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("${prop.uiType}","");
                        detailstr+="</select>";
                        <#assign porpNo = 1>      
                		</#if>                  
						</#list>  
                    	<#list radioList as prop>        
                		<#if column.columnNameLower==prop.name> 
                        detailstr+= SimpleListUtil.getRadioCode("${prop.uiType}", "${column.columnNameLower}", "");
                        <#assign porpNo = 1>   
                		</#if>                  
						</#list> 						
                    	<#list checkboxList as prop>        
                		<#if column.columnNameLower==prop.name> 
                		detailstr+="<input id='${column.columnNameLower}' name='${column.columnAlias}' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        <#assign porpNo = 1>      
                		</#if>                  
						</#list>   						
                		<#if porpNo==0>
                		detailstr+="<input id='${column.columnNameLower}' name='${column.columnAlias}' style='...'/>";
                        </#if>
                        detailstr+="</td>";                        
                        <#if rowsize == pagesize>
                        <#assign rowsize = 0> 
                        detailstr+="</tr>";
                        </#if> 
                        
                        </#if>         
                		</#if>                        
						</#list>   
						<#if rowsize != 0>
						<#if rowsize == pagesize>
						<#else>
                        detailstr+="</tr>";
                        </#if> 
                        </#if> 
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"${urlroot}router?appKey=000001&method=${classNameLower}.create${className}&v=1.0&format=json",$(detailstr),${winheight});
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platform${className}ManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platform${className}ManageListView.getGridObject().select().get(i);
                            var ${columnsqlkey} = SimpleListUtil.getColumnValue(platform${className}ManageListView.getGridObject(),rowEl, "${columnkey}");
                            new AjaxEngine("${urlroot}router?appKey=000001&method=${classNameLower}.delete${className}&v=1.0&format=json",
                            {
                                async: false,
                                data:{${columnkey}: ${columnsqlkey}},
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
                        <#assign rowsize = 0>
                        <#assign winheight = 60>
                        <#list table.columns as column>

                        <#assign isComm = 0>
                    	<#list commonfieldList as prop>        
                		<#if column.columnNameLower==prop.name> 
                        <#assign isComm = 1>      
                		</#if>                  
						</#list>    
						<#if isComm == 0> 
						
                        <#if column.pk>      
                        detailstr+="<input id='${column.columnNameLower}' name='${column.columnAlias}' hidden='true' style='...'/>";                          
                        <#else>
                        <#if rowsize == 0> 
                        detailstr+="<tr>";
						<#assign winheight = winheight+30>
                        </#if>  
                        <#assign rowsize = rowsize+1> 
                        detailstr+="<td>";
                        detailstr+="<label id='l${column.columnNameLower}' align='right'>${column.columnAlias}：</label>";
                        detailstr+="</td><td>";
                        <#assign porpNo = 0>
                    	<#list selectfieldList as prop>        
                		<#if column.columnNameLower==prop.name> 
						<#assign winheight = winheight+2>
                        detailstr+="<div id='view${prop.uiType}'>";                        
                        detailstr+="<input id='${column.columnNameLower}' name='${column.columnNameLower}' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='${prop.uiType}Name' name='${prop.uiType}Name' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        <#assign porpNo = 1>      
                		</#if>                  
						</#list>
                    	<#list comboxList as prop>        
                		<#if column.columnNameLower==prop.name> 
                        detailstr+="<select name='${column.columnAlias}' id='${column.columnNameLower}' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("${prop.uiType}","");
                        detailstr+="</select>";
                        <#assign porpNo = 1>      
                		</#if>                  
						</#list>
                    	<#list radioList as prop>        
                		<#if column.columnNameLower==prop.name> 
                        detailstr+= SimpleListUtil.getRadioCode("${prop.uiType}", "${column.columnNameLower}", "");
                        <#assign porpNo = 1>   
                		</#if>                  
						</#list>
                    	<#list checkboxList as prop>        
                		<#if column.columnNameLower==prop.name> 
                		detailstr+="<input id='${column.columnNameLower}' name='${column.columnAlias}' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        <#assign porpNo = 1>      
                		</#if>                  
						</#list>
                		<#if porpNo==0>
                		detailstr+="<input id='${column.columnNameLower}' name='${column.columnAlias}' style='...'/>";
                        </#if>
                        detailstr+="</td>";   
                        <#if rowsize == pagesize>
                        <#assign rowsize = 0> 
                        detailstr+="</tr>";
                        </#if> 
                        </#if>
                        </#if>
                        </#list>          
						<#if rowsize != 0>
						<#if rowsize == pagesize>
						<#else>
                        detailstr+="</tr>";
                        </#if> 
                        </#if>                
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"${urlroot}router?appKey=000001&method=${classNameLower}.select${className}&v=1.0&format=json&sid="+sid+"",$(detailstr),${winheight});
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "${urlroot}router?appKey=000001&method=${classNameLower}.select${className}&v=1.0&format=json&sid="+sid
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		<#assign porpNo = 0><#list table.columns as column><#assign porpNo=porpNo+1><#if porpNo==1>${column.columnNameLower}: { type: "string" }<#else>,${column.columnNameLower}: { type: "string" }</#if></#list>
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
                                	<#list selectfieldList as prop>     
                                	<#list table.columns as column>
                                	<#if column.columnNameLower==prop.name>  
                                    data["${prop.uiType}Name"] = Platform${prop.uiType}SelDialog.codetodes(data["${prop.name}"]);
                            	    </#if>
                            		</#list>  
                                    </#list>                                 
                                	<#list comboxList as prop>    
                                	<#list table.columns as column>
                            		<#if column.columnNameLower==prop.name> 
                            		data["${column.columnNameLower}Name"] = SimpleListUtil.getSelectDes("${prop.uiType}", data["${column.columnNameLower}"]);
                            		</#if>           
                            		</#list>         
            						</#list>                                
                                	<#list radioList as prop>    
                                	<#list table.columns as column>
                            		<#if column.columnNameLower==prop.name> 
                            		data["${column.columnNameLower}Name"] = SimpleListUtil.getSelectDes("${prop.uiType}", data["${column.columnNameLower}"]);
                            		</#if>           
                            		</#list>         
            						</#list>                 						
                                	<#list checkboxList as prop>    
                                	<#list table.columns as column>
                            		<#if column.columnNameLower==prop.name> 
                            		data["${column.columnNameLower}Name"] = SimpleListUtil.getSelectDes("${prop.uiType}", data["${column.columnNameLower}"]);
                            		</#if>           
                            		</#list>         
            						</#list>        
                                }
                            }
                            result = platform${className}ManageListView.appendColValue(result);
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
                          {field: "chk", type:"chk", title: "&nbsp;", value:"${columnsqlkey}"},
                          <#list table.columns as column>

                          <#assign isComm = 0>
                      	<#list commonfieldList as prop>        
                  		<#if column.columnNameLower==prop.name> 
                          <#assign isComm = 1>      
                  		</#if>                  
  						</#list>    
  						<#if isComm == 0> 
                          <#if column.pk>
                          {field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"},
                          <#else>
                          <#assign porpNo = 0>               
                      		<#list selectfieldList as prop>          		
                    		<#if column.columnNameLower==prop.name>  
                    		{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"},
                    		{field: "${prop.uiType}Name", title:"${column.columnAlias}", align:"center", width: "100px"},
                            <#assign porpNo = 1>  
                    		</#if>
                            </#list>
                        	<#list comboxList as prop>        
                    		<#if column.columnNameLower==prop.name> 
                    		{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"},
                    		{field: "${column.columnNameLower}Name", title:"${column.columnAlias}", align:"center", width: "100px"},
                    		<#assign porpNo = 1>  
                    		</#if>                  
    						</#list>        
                        	<#list radioList as prop>        
                    		<#if column.columnNameLower==prop.name> 
                    		{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"},
                    		{field: "${column.columnNameLower}Name", title:"${column.columnAlias}", align:"center", width: "100px"},
                    		<#assign porpNo = 1>  
                    		</#if>                  
    						</#list>        
                        	<#list checkboxList as prop>        
                    		<#if column.columnNameLower==prop.name> 
                    		{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"},
                    		{field: "${column.columnNameLower}Name", title:"${column.columnAlias}", align:"center", width: "100px"},
                    		<#assign porpNo = 1>  
                    		</#if>                  
    						</#list>            						
                    		<#if porpNo==0>
                    		{field: "${column.columnNameLower}", title:"${column.columnAlias}", align:"center", width: "100px"},
                            </#if>
                          </#if>

                          </#if>
                          </#list>
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platform${className}ManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platform${className}ManageListView.get("columns");
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
                                <#assign rowsize = 0>
                                <#assign winheight = 60>
                                <#list table.columns as column>    
                                
                                <#assign isComm = 0>
                            	<#list commonfieldList as prop>        
                        		<#if column.columnNameLower==prop.name> 
                                <#assign isComm = 1>      
                        		</#if>                  
        						</#list>    
        						<#if isComm == 0> 
        						
                                <#if column.pk>                                
                                detailstr+="<input id='${column.columnNameLower}' name='${column.columnAlias}' hidden='true' value='"+ColumnValue["${column.columnNameLower}"]+"' style='...'/>";
                            	<#else>
                                <#if rowsize == 0> 
                                detailstr+="<tr>";
        						<#assign winheight = winheight+30>
                                </#if>  
                                <#assign rowsize = rowsize+1> 
                                detailstr+="<td>";
                                detailstr+="<label id='l${column.columnNameLower}' align='right'>${column.columnAlias}：</label>";
                                detailstr+="</td><td>";
                                <#assign porpNo = 0>
                            	<#list selectfieldList as prop>        
                        		<#if column.columnNameLower==prop.name> 
        						<#assign winheight = winheight+2>
                                detailstr+="<div id='view${prop.uiType}'>";                        
                                detailstr+="<input id='${column.columnNameLower}' name='${column.columnNameLower}' hidden='true' data-bind='value: id' value='"+ColumnValue["${column.columnNameLower}"]+"' style='...'/>";
                                detailstr+="<input id='${prop.uiType}Name' name='${prop.uiType}Name' data-bind='value: name' value='"+Platform${prop.uiType}SelDialog.codetodes(ColumnValue["${column.columnNameLower}"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
                                <#assign porpNo = 1>      
                        		</#if>                  
        						</#list>        
          						
                            	<#list comboxList as prop>        
                        		<#if column.columnNameLower==prop.name> 
                                detailstr+="<select name='${column.columnAlias}' id='${column.columnNameLower}' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("${prop.uiType}", ColumnValue["${column.columnNameLower}"]);
                                detailstr+="</select>";
                                <#assign porpNo = 1>      
                        		</#if>                  
        						</#list>     
        						
                            	<#list radioList as prop>        
                        		<#if column.columnNameLower==prop.name> 
                                detailstr+= SimpleListUtil.getRadioCode("${prop.uiType}", "${column.columnNameLower}", ColumnValue["${column.columnNameLower}"]);
                                <#assign porpNo = 1>      
                        		</#if>                  
        						</#list>    
        						
                            	<#list checkboxList as prop>        
                        		<#if column.columnNameLower==prop.name> 
                        		detailstr+="<input id='${column.columnNameLower}' name='${column.columnAlias}' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["${column.columnNameLower}"]+"' style='...'/>";
                                <#assign porpNo = 1>      
                        		</#if>                  
        						</#list>    
        						
                        		<#if porpNo==0>
                        		detailstr+="<input id='${column.columnNameLower}' name='${column.columnAlias}' value='"+ColumnValue["${column.columnNameLower}"]+"' style='...'/>";
                                </#if>
                                detailstr+="</td>";
                                <#if rowsize == pagesize>
                                <#assign rowsize = 0> 
                                detailstr+="</tr>";
                                </#if> 
                                </#if>

                                </#if>
                                </#list>     
        						<#if rowsize != 0>
        						<#if rowsize == pagesize>
        						<#else>
                                detailstr+="</tr>";
                                </#if> 
                                </#if>      
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"${urlroot}router?appKey=000001&method=${classNameLower}.update${className}&v=1.0&format=json", $(detailstr),${winheight});
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platform${className}ManageListView);
            SimpleListUtil.ckSession(sid);            
        }
    });

    return Platform${className}ManageRouter;
});
