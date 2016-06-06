/**
 * Demo的路由器
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["types/Class",
    "utils/Log",
    "jquery",
    "rpc/AjaxEngine",
    "base/BaseRouter",
    "base/BaseView",
    "grid/simplelist",
    "text!templates/demo/message_window.html",
    "text!templates/demo/modal_dialog.html",
    "text!templates/demo/simplelist.html",
    "resources/data/people"
], function(Class, Log, $, AjaxEngine, BaseRouter, BaseView, SimpleListView, MessageWindowViewTemplate, ModalDialogViewTemplate, SimpleListViewTemplate){

    window.showDetail = function(productName, unitPrice, unitsStock, discontinued){
        alert("productName: " + productName + "\n unitPrice: " + unitPrice + " \n unitsInStock：" + unitsStock + " \n discontinued: " + discontinued);
    }




    var DemoRouter = BaseRouter.extend({
        routes: {
            "demo/MessageWindow": "showMessageWindow",  //消息窗口Demo
            "demo/ModalDialog": "showModalDialog",      //模态窗口Demo
            "demo/simplelist": "showProductsList"         //简要列表Demo
        },
        showProductsList: function(){

            var simplelistDemoView = new SimpleListView({
                id: "simpleListDemo",
                title: "简要列表例子",
                viewTemplate: SimpleListViewTemplate,

                dataSource: {
                    transport: {
//                        read: function(options){
//                            var result = [];
//                            new AjaxEngine("resources/data/products.js", {async: false, dataType: 'json', complete: function(transport){
//                                result = transport.responseText;
//
//
//                                result = $.parseJSON(result);
//
//                                Log.debug("已经完获取数据");
//
//                                options.success(result);
//                            }})
//                        }
                        read: {
                            url: "resources/data/products.js",
                            data: function() {
                                return {
                                    q: "html5" // send "html5" as the "q" parameter
                                };
                            }
                        }

                        //提交给服务器的参数设置，kendoui提供了一套默认的，我们可以根据需要进行组装
//                        ,parameterMap: function(data, type) {
//                            //data.aggregate Array
//                            //data.group Array
//                            //data.filter Object
//                            //data.models Array
//                            //data.page Number
//                            //data.pageSize Number
//                            //data.skip Number
//                            //data.sort Array
//                            //data.take Number
//                            //type String
//
////                            if (type == "read") {
////                                // send take as "$top" and skip as "$skip"
////                                return {
////                                    $top: data.take,
////                                    $skip: data.skip
////                                }
////                            }
//                        }
                    },
                    serverAggregates: true,
                    aggregate: [
                        { field: "UnitPrice", aggregate: "max" },
                        { field: "UnitsInStock", aggregate: "count" }
                    ],

                    //服务端的条件过滤
                    serverFiltering: true,
                    filter: {
                        logic: "and",
                        filters: [ { field: "name", operator: "startswith", value: "Jane" }, {field: "unitPrice", operator: "eq", value: "18" } ]
                    },

                    schema: {
                        model: {
                            fields: {
                                ProductName: { type: "string" },
                                UnitPrice: { type: "number" },
                                UnitsInStock: { type: "number" },
                                Discontinued: { type: "boolean" }
                            }
                        },
                        //返回的数据
                        data: function(response) {
                            var result = response;
//                            result = result.slice(0, 20);

                            result = simplelistDemoView.appendColValue(result);
                            return result; // twitter's response is { "results": [ /* results */ ] }
                        },
                        //异常信息处理
//                        errors: function(response){
//                            return "无效的查询";
//                        },

                        //记录条数
                        total: function(response) {
                            var result = response;
                            return result.length; // total is returned in the "total" field of the response
                        },
                        //统计信息
                        aggregates: function(response) {
                            var result = response;
                            var product = null;
                            var max = 0;
                            var count=0;
                            for(var i=0; i<result.length; i++){
                                product = result[i];
                                if(max < product["UnitPrice"])
                                    max = product["UnitPrice"];

                                count++;
                            }

                            var result = {
                                UnitPrice: {
                                    max: max
                                },
                                UnitsInStock: {
                                    count: count
                                }
                            }

                            return result;
                        }
                    },
                    pageSize: 20,
                    serverPaging: true
                },
                dataBinding: function(){
                    Log.debug("dataBinding：正在绑定数据");
                },
                scrollable: true,
                sortable: true,
                filterable: true,
//                pageable: {
//                    input: true,
//                    numeric: false
//                },
                columns: [
                    {field: "seq", type:"seq", title: "序号", primary: true},
                    {field: "chk", type:"chk", title: "&nbsp;", value:"#=ProductID#"},
                    {field: "ProductID", hidden:true, title: "", primary: true},
                    {field: "ProductName", type:"link", link:{url: 'javascript:showDetail("#=ProductName#","#=UnitPrice#",#=UnitsInStock#,#=Discontinued#);'} },
                    { field: "UnitPrice", title: "Unit Price", format: "{0:c}", align:"right", width: "130px", footerTemplate: "<span style='text-align: center !important;' >#: max #</span>"  },
                    { field: "UnitsInStock",  title: "Units In Stock", align:"right", width: "130px", footerTemplate: "<span style='text-align: center !important;' >#: count #</span>" },
                    { field: "Discontinued", width: "130px", align:"center",  values: [{ text: "销售", value: false }, { text: "停产", value: true } ] },
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "details",
                            click: function(e) {
                                e.preventDefault();
                                simplelistDemoView.getPrimaryKey();

                                var tmp = simplelistDemoView.getColumnValue(this.select(), "Discontinued");
                                alert(tmp);
//                                alert("显示详细信息");
//                                // e.target is the DOM element representing the button
//                                var tr = $(e.target).closest("tr"); // get the current table row (tr)
//                                // get the data bound to the current table row
//                                var data = this.dataItem(tr);
//                                console.log("Details for: " + data.name);
                            }
                        }]
                    }
                ],
//                columnGroups : {title: '产品详细信息', subFields: ["UnitPrice", "UnitsInStock", "Discontinued"]},
//                columnGroups : [{title: '产品详细信息', subFields: ["UnitPrice", "UnitsInStock", "Discontinued"]}],
                columnGroups : [
                    [{title: '产品详细信息', subFields: ["UnitPrice", "UnitsInStock", "Discontinued"]}],
                    [{title: '产品总信息', subFields: ["ProductName","UnitPrice", "UnitsInStock", "Discontinued"]}]
                ],
                detailTemplate: "<div>产品名: #: ProductName #</div><div>单价: #: UnitPrice #</div>"
            });
            this.changePage(simplelistDemoView);
        },
        showSimpleList: function(){
            var simplelistDemoView = new SimpleListView({
                id: "simpleListDemo",
                title: "简要列表例子",
                viewTemplate: SimpleListViewTemplate,

                dataSource: {
                    data: createRandomData(50),
                    aggregate: [
                        { field: "Age", aggregate: "sum" },
                        { field: "Age", aggregate: "max" }
                    ]
                },
                sortable: true,
//                height:height,
//            groupable: {
//                messages: {
//                    empty: "分组的标题"
//                }
//            },
//                navigatable: true,
                resizable: true,
//            selectable: true,
//                pageable: {
//                    pageSizes: true,
//                    info: true,
//                    messages: {
//                        itemsPerPage: "222",
//                        display: "333"
//                    }
//                },
                columns: [ {
                    field: "FirstName",
                    width: 140,
                    title: "First Name",
                    editor: function(container, options) {
                        // create an input element
                        var input = $("<input/>");
                        // set its name to the field to which the column is bound ('name' in this case)
                        input.attr("name", options.field);
                        // append it to the container
                        input.appendTo(container);
                        // initialize a Kendo UI AutoComplete
                        input.kendoAutoComplete({
                            dataTextField: "name",
                            dataSource: [
                                { name: "Jane Doe" },
                                { name: "John Doe" }
                            ]
                        });
                    },
                    headerAttributes: {
                        style: "text-align: center; font-size: 14px"
                    }

                } , {
                    field: "LastName",
                    width: 90,
                    title: "Last Name",
                    headerAttributes: {
                        style: "text-align: center; font-size: 14px"
                    },
                    footerTemplate: "合计："
                } , {
                    title: "城市",
                    width: 120,
                    field: "City",
                    attributes: {style: "color:red;"},
                    headerAttributes: {
                        style: "text-align: center; font-size: 14px"
                    }
                } , {
                    field: "Title",
                    template: "<strong>#: Title # </strong>",
                    headerAttributes: {
                        style: "text-align: center; font-size: 14px"
                    }
                } , {
                    field: "BirthDate",
                    title: "出生日期",
                    width: 120,
                    template: '#= kendo.toString(BirthDate,"yyyy-MM-dd") #',
                    attributes: {style: "text-align:center"},
                    headerAttributes: {
                        style: "text-align: center; font-size: 14px"
                    }
                } , {
                    width: 70,
                    title: "年龄",
                    field: "Age",
                    attributes: {style: "text-align:right"},
                    footerTemplate: "<span style='text-align: center !important;' >#: max #</span>",
                    headerAttributes: {
                        style: "text-align: center; font-size: 14px"
                    }
                },{
                    width: 230,
                    title: "操作列",
                    headerAttributes: {
                        style: "text-align: center; font-size: 14px"
                    },
                    command: [ {
                        name: "details",
                        click: function(e) {
                            // e.target is the DOM element representing the button
                            var tr = $(e.target).closest("tr"); // get the current table row (tr)
                            // get the data bound to the current table row
                            var data = this.dataItem(tr);
                            console.log("Details for: " + data.name);
                        }
                    },
                        { name: "destroy",className: "btn-destroy", text:"删除" }, { name: "edit" }]
                }
                ],
                editable: {
                    destroy: false,
                    mode: "inline",
                    createAt: "bottom"
                },
//            filterable: {
//                messages: {
//                    selectValue: "请选择",
//                    info: "过滤条件: ",
//                    and: "且",
//                    or: "或",
//                    filter: "条件过滤",
//                    clear: "清除过滤条件",
//                    isFalse: "true"
//                },
//                operators: {
//                    string: {
//                        eq: "等于",
//                        neq: "不等于"
//                    }
//                }
//            },
//            toolbar: kendo.template($("#toolbarTemplate").html()),
                detailTemplate: "<div>标题: #: Title #</div><div>年龄: #: Age #</div>"
            });
            this.changePage(simplelistDemoView);
        },
        showMessageWindow: function(){
            var msgWinDemoView = new BaseView({id: "messageWindowDemo", title: "消息窗口例子", viewTemplate: MessageWindowViewTemplate});
            this.changePage(msgWinDemoView);
        },
        showModalDialog: function(){
            var modalDialogDemoView = new BaseView({id: "modalDialogDemo", title: "模态窗口例子", viewTemplate: ModalDialogViewTemplate});
            this.changePage(modalDialogDemoView);
        }
    });

    return DemoRouter;
});