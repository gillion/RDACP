<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign colcnName = table.className> 

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

		<#list selectfieldList as prop>    
		<#if className==prop.uiType> 
		<#assign colcnName = prop.cnName> 
		
	    </#if>
		</#list>  
	</#list>
/**
 * 选择窗口
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery",
    "utils/Log",
    "grid/SimpleListUtil",
	<#list selectfieldList as prop> 
    <#list table.columns as column>
    <#if column.columnNameLower==prop.name>  
        "js/app/${sysname}/routers/Platform${prop.uiType}SelDialog",
        </#if>
    	</#list>  
    	</#list>  
    "rpc/AjaxEngine",
    "utils/common"
], function($, Log, SimpleListUtil,
		<#list selectfieldList as prop>   
<#list table.columns as column>
<#if column.columnNameLower==prop.name>  
		Platform${prop.uiType}SelDialog,
	    </#if>
		</#list>  
		</#list>  
		AjaxEngine){	
    var Platform${className}SelDialog = {
    		codetodes: function(id,sid){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("${urlroot}router?appKey=000001&method=${classNameLower}.select${className}&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id,sid:sid},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].${colcnName};
                            }
		                }
		            }
		        );
		        return resstr;
                }
		    },
    		showGridData: function(gridObject,sid){
                var detailgrid= gridObject.kendoGrid({
                    dataSource: {
                        serverPaging: false,
                        transport: {
                            read: {
                                url: "${urlroot}router?appKey=000001&method=${classNameLower}.select${className}&sid="+sid+"&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
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
                                return result;
                            },
                            //记录条数
                            total: function(response) {
                                var result = response["total"] || response["resultJson"].length;
                                return result;
                            }
                        }
                    },
                    selectable: true,
                    pageable: {                     //是否支持分页，如果支持，其相关的配置信息
                        pageSizes: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],
                        info: true,
                        messages: {
                            empty: "查询无记录！",
                            itemsPerPage: "行每页",
                            display: "共 {2} 条记录"
                        }
                    },
                    columns: [
    <#assign porpNo = 0>
    	                  <#list table.columns as column>
    	                  <#assign porpNo=porpNo+1>
    	                  <#if column.pk>
    	                  <#if porpNo==1>
    	                  {field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"}
    	                  <#else>
    	                  ,{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"},
    	                  </#if>
    	                  <#else>    	                  
    	                  <#if porpNo==1>
                          <#assign pNo = 0>               
                      		<#list selectfieldList as prop>          		
                    		<#if column.columnNameLower==prop.name>  
                    		{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"}
                    		{field: "${prop.uiType}Name", title:"${column.columnAlias}", align:"center", width: "100px"}
                            <#assign pNo = 1>  
                    		</#if>
                            </#list>
                        	<#list comboxList as prop>        
                    		<#if column.columnNameLower==prop.name> 
                    		{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"}
                    		{field: "${column.columnNameLower}Name", title:"${column.columnAlias}", align:"center", width: "100px"}
                    		<#assign pNo = 1>  
                    		</#if>                  
    						</#list>        
                        	<#list radioList as prop>        
                    		<#if column.columnNameLower==prop.name> 
                    		{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"}
                    		{field: "${column.columnNameLower}Name", title:"${column.columnAlias}", align:"center", width: "100px"}
                    		<#assign pNo = 1>  
                    		</#if>                  
    						</#list>        
                        	<#list checkboxList as prop>        
                    		<#if column.columnNameLower==prop.name> 
                    		{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"}
                    		{field: "${column.columnNameLower}Name", title:"${column.columnAlias}", align:"center", width: "100px"}
                    		<#assign pNo = 1>  
                    		</#if>                  
    						</#list>            						
                    		<#if pNo==0>
                    		{field: "${column.columnNameLower}", title:"${column.columnAlias}", align:"center", width: "100px"}
                            </#if>
    	                  <#else>

                            <#assign pNo = 0>               
                        		<#list selectfieldList as prop>          		
                      		<#if column.columnNameLower==prop.name>  
                      		,{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"}
                      		,{field: "${prop.uiType}Name", title:"${column.columnAlias}", align:"center", width: "100px"}
                              <#assign pNo = 1>  
                      		</#if>
                              </#list>
                          	<#list comboxList as prop>        
                      		<#if column.columnNameLower==prop.name> 
                      		,{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"}
                      		,{field: "${column.columnNameLower}Name", title:"${column.columnAlias}", align:"center", width: "100px"}
                      		<#assign pNo = 1>  
                      		</#if>                  
      						</#list>        
                          	<#list radioList as prop>        
                      		<#if column.columnNameLower==prop.name> 
                      		,{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"}
                      		,{field: "${column.columnNameLower}Name", title:"${column.columnAlias}", align:"center", width: "100px"}
                      		<#assign pNo = 1>  
                      		</#if>                  
      						</#list>        
                          	<#list checkboxList as prop>        
                      		<#if column.columnNameLower==prop.name> 
                      		,{field: "${column.columnNameLower}", title:"${column.columnAlias}", hidden:"true", align:"center", width: "100px"}
                      		,{field: "${column.columnNameLower}Name", title:"${column.columnAlias}", align:"center", width: "100px"}
                      		<#assign pNo = 1>  
                      		</#if>                  
      						</#list>            						
                      		<#if pNo==0>
                      		,{field: "${column.columnNameLower}", title:"${column.columnAlias}", align:"center", width: "100px"}
                            </#if>
    	                  
                          </#if>
    	                  </#if>
    	                  </#list>
                    ]
                });
                return  detailgrid;
            }
    }
    return Platform${className}SelDialog;
})