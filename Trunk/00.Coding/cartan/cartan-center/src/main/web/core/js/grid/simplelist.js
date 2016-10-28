/**
 * 简要列表：包含查询条件、工具栏、查询结果、分页信息
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery",
    "underscore",
    "types/Class",
    "utils/Log",
    "base/BaseView",
    "grid/SimpleListUtil",
    "text!core_templates/grid/simple_list.html",
    "utils/common",
    "kendo",
    "bootstrap",
    "rpc/AjaxEngine"
], function($, _, Class, Log, BaseView, SimpleListUtil, SimpleListViewTemplate, AjaxEngine){

    function showMoreQueryConditionDialog(id, left, top, url,content,reqdata){
        var dialogEl = document.getElementById(id);
        if(dialogEl != null)
            return;

        var documentWindow = $(window);
        var kendoUIWindow = $("<div id='" + id + "'  />").kendoWindow({
            title: "高级查询",
            width: "500px",
            height: "250px",
            modal: false,
            actions: [  "Close"],
            open: function (e) {
                left = left == null ? left : (left-500);
                top = top || documentWindow.scrollTop() + Math.max(0, (documentWindow.height() - this.wrapper.height()) / 2);  //默认居中显示
                left = left || (documentWindow.scrollLeft() + Math.max(0, (documentWindow.width() - this.wrapper.width()) / 2));  //默认居中显示
                this.wrapper.css({
                    left: left,
                    top: top
                });
            },
            close: function(e){
                kendoUIWindow.destroy();         //销毁窗口，将窗口相关代码从界面中移除
                kendoUIWindow = null;
            }
        }).data("kendoWindow").content(content);
        $("#QueryBtn").click(function(){
            alert(url);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: "1"},
                    dataType: 'json',
                    complete: function(transport){
                       // alert(result);
                        result = transport.responseText;
                        result = $.parseJSON(result);
                        alert("删除成功！");
                        location.reload();
                    }
                }
            );
        });
        kendoUIWindow.open();
    }

    var SimpleList = BaseView.extend({
        id: null,
        $simplelist: null,
        kendoGrid: null,

        $simplelistHeader: null,
        $simplelistToolbarCondition: null,
        $simplelistToolbar: null,
        $simplelistCondition: null,
        $simplelistList: null,

        buttonCount:2,

        /*-------------------------------KendoGrid配置信息  begin  ---------------------------------------------------*/

        dataSource: null,                                    //数据源
        columns: null,                                       //表格中列的信息
        pageable: null,                                     //是否支持分页，如果支持，其相关的配置信息
        toolbar: null,                                      //工具栏，如果用简要列表默认的工具栏，那么就不需要指定该工具栏；也可以隐藏默认提供的工具栏，通过模版自定义该工具栏信息
        detailTemplate: null,                              //表格中每条记录明细信息的模版，如果指定了，那么在表格中会嵌套记录的明细信息
        editable: false,                                    //是否支持在线编辑，如果支持，其相关的配置信息；默认是不支持在线编辑
        resizable: true,                                    //是否可以调整表格中列的宽度，默认是可调整的
        selectable: "multiple",                                   //是否支持选中行，默认是支持的
        navigatable: false,                                  //是否支持通过方向键来导航，默认是支持的
        groupable: false,                                   //是否支持分组，默认是不支持的
        sortable: false,                                    //是否支持排序，默认是不支持的
        height: null,                                       //表格的高度

        /*-------------------------------KendoGrid配置信息  end  ---------------------------------------------------*/

        _hasSeqCol: false,   //是否包含序列的列
        _hasChkCol: true,    //是否包含复选的列


        //布局模版
        viewTemplate: SimpleListViewTemplate,

        initialize: function(options){
            this._hasSeqCol = false;
            this._hasChkCol = false;
            this._primaryKey = null;    //主键列的列名

            this.set(options);
            this.id = $.uuid();

            this._readyArray = [];
        },
        /**
         * 取得简要列表中的grid对象
         */
        getGridObject : function(){
            return this.kendoGrid;
        },
        /**
         * 获取选中行的主键，如果选中多行，多个值用逗号分隔
         * @return {*}
         */
        getPrimaryKey: function(){
            var primaryKey = this._primaryKey;
            if(!primaryKey){
                alert("请先指定主键列");
                return;
            }
            var gridObject = this.getGridObject();
            if(!SimpleListUtil.checkSelection(gridObject))
                return;

            return SimpleListUtil.getSelectedColumnValue(gridObject, primaryKey);
        },
        getColumnValue: function(row, colName){
            return SimpleListUtil.getColumnValue(this.getGridObject(), row, colName);
        },
        selectRow: function(row){
            this.clearSelection();
            var chkColName = SimpleList.CHECK_COL_NAME;
            var chkElName = this._generateSingleChkElName(chkColName);

            $(row).find("input[name='" + chkElName + "']").trigger("click");
        },

        /**
         * 渲染页面
         */
        render: function(){

            this._initLayout();      //初始化布局
            this._initKendoGrid();   //初始化表格数据

            this._initAttachHeader();  //设置多表头

            this._initGridPosition();  //初始化表格的位置

            return this;
        },
        /**
         * 设置列分组（即多表头）
         * @private
         */
        _initAttachHeader: function(){
            var columnGroups = this.get("columnGroups");  //支持三种写法
            if(columnGroups == null)
                return;

            var attachHeaderArray = [];
            if($.isPlainObject(columnGroups)){
                attachHeaderArray.push(columnGroups);
                this.attachHeader(attachHeaderArray);
                return;
            }

            if($.isArray(columnGroups) && columnGroups.length > 0){
                attachHeaderArray = columnGroups[0];
                if($.isPlainObject(attachHeaderArray)){
                    this.attachHeader(columnGroups);
                    return;
                }else{
                    for(var i=0; i<columnGroups.length; i++){
                        this.attachHeader(columnGroups[i]);
                    }
                }
            }
        },
        /**
         * 初始化布局
         * @private
         */
        _initLayout: function(){
            $(this.el).empty();

            this.$simplelist = $("<div id='" + this.id + "' style='padding:1px;' />");
            this.$simplelist.get(0).innerHTML = this._getContent();   //先根据模版生成布局
            this.$simplelist.appendTo($(this.el));

            //缓存简要列表整体框架的元素
            this.$simplelistHeader = this.$simplelist.find("#simplelist_header");
            this.$simplelistToolbarCondition = this.$simplelist.find("#simplelist_toolbar_condition");
            this.$simplelistToolbar = this.$simplelistToolbarCondition.find("#simplelist_toolbar");
            this.$simplelistCondition = this.$simplelistToolbarCondition.find("#simplelist_condition");
            this.$simplelistList = this.$simplelist.find("#simplelist_list");
        },
        /**
         * 页面加载完成后执行的初始化操作
         */
        ready: function(){
            this.setSimpleListHeader("信息列表");
            this.addToolbarBtn("addBtn", "新 增", function(){alert('显示新增窗口')}, "add");
            this.addToolbarBtn("deleteBtn", "删 除", function(){alert('进行删除操作')}, "delete");
            this.addToolbarBtn("editBtn", "修 改", function(){alert('进行修改操作')}, "edit");

//            this.hideToolbarBtn("deleteBtn,addBtn");  //隐藏按钮

            this.addMoreQueryConditionBtn();   //添加“高级查询”按钮
        },
        /**
         * 添加高级查询条件按钮
         */
        addMoreQueryConditionBtn: function(url,content,reqdata){
            var $btn = $('<a id="moreQueryConditionBtn" class="k-button k-button-icontext"  href="#">高 级<span class="k-icon k-i-arrow-s"></span></a>');
            var dialogId = "more_query_condition_dialog_" + this.id;
            $btn.on("click", function(e){
                e.preventDefault();
                var left = e.clientX + (this.offsetWidth- e.offsetX);
                var top = e.clientY + (this.offsetHeight- e.offsetY);
                showMoreQueryConditionDialog(dialogId,left,top,url,content,reqdata);  //显示高级查询对话框
                dialogId = null;
            });

            this.$simplelistCondition.append($btn);
            this.showSimpleListToolbarAndCondition();
        },
        addToMoreToolbarMenu: function(btnId, title, btnFunction, icon, options){
            var moreBtnId = "more_toolbar_btn_" + this.id;
            var moreBtnMenuId = "more_toolbar_btn_menu_" + this.id;
            var $moreBtnGroup = null;
            var $moreBtn = $("#" + moreBtnId);
            var $moreBtnMenu = null;
            var isExisted = false;
            if ($moreBtn.length == 0){
                $moreBtnMenu = $('<ul class="dropdown-menu" id="' + moreBtnMenuId + '"/>');
                $moreBtn = $('<a class="btn k-button dropdown-toggle" id="' + moreBtnId + '" href="#" data-toggle="dropdown">更多操作<span class="k-icon k-i-arrow-s"></span></a>');
                $moreBtnGroup = $('<div class="btn-group" style="margin-top:1px;"/>');
                $moreBtnGroup.append($moreBtn);
                $moreBtnGroup.append($moreBtnMenu);
            }else{
                $moreBtnMenu = $("#" + moreBtnMenuId);
                isExisted = true;
            }

//            <span class="k-icon k-' + icon + '"></span>
            var $btn = $('<a id="' + btnId + '" href="#"><span class="k-icon k-' + icon + '"></span>' + title + '</a>');
            $btn.on("click", function(e){
                e.preventDefault();
                btnFunction();
            });
            var $li = $("<li />");
            $li.append($btn);
            $moreBtnMenu.append($li);

            if(!isExisted) {
                this.$simplelistToolbar.append($moreBtnGroup);
            }
        },
        /**
         * 向查询方案工具栏上添加一个按钮
         * @param btnId 按钮ID(eg:viewBtn)
         * @param title 按钮的名称(eg:查看)
         * @param btnFunction 按钮执行的函数(eg:function(){alert("查看");})
         * @param icon 按钮的图片
         * @param options 可选的配置，预留
         */
        addToolbarBtn : function(btnId, title, btnFunction, icon, options){

            var $childBtnArray = this.$simplelistToolbar.children("a");
            if($childBtnArray.length < this.buttonCount){
                var $btn = $('<a id="' + btnId + '" class="k-button k-button-icontext" style="margin-right:5px;" href="#"><span class="k-icon k-' + icon + '"></span>' + title + '</a>');
                $btn.on("click", function(e){
                    e.preventDefault();
                    btnFunction();
                });

                this.$simplelistToolbar.append($btn);
            }else{
                this.addToMoreToolbarMenu(btnId, title, btnFunction, icon, options);
            }

            this.showSimpleListToolbarAndCondition();
        },
        /**
         * 隐藏工具栏上的一些按钮
         * @param btnIdsStr 要隐藏的按钮ID列表，多个值用逗号分隔(eg:"viewBtn,updateBtn")
         */
        hideToolbarBtn : function(btnIdsStr){
            btnIdsStr = $.trim(btnIdsStr);
            if (btnIdsStr == "")
                return;

            var btnIdArray = btnIdsStr.split(",");
            var btnId = null;
            for(var i=0; i<btnIdArray.length; i++){
                btnId = $.trim(btnIdArray[i]);
                if(btnId == "")
                    continue;

                $("#" + btnId).hide();
            }
        },
        /**
         * 显示简要列表工具栏和查询条件
         */
        showSimpleListToolbarAndCondition: function(){
            //如果已经是显示状态，就不执行操作
            if(this.$simplelistToolbarCondition.is(':visible'))
                return;

            this.$simplelistToolbarCondition.show();
            this._initGridPosition();  //初始化表格的位置
        },
        /**
         * 显示简要列表工具栏和查询条件
         */
        hideSimpleListToolbarAndCondition: function(){
            //如果已经是隐藏状态，就不执行操作
            if(!this.$simplelistToolbarCondition.is(':visible'))
                return;

            this.$simplelistToolbarCondition.hide();
            this._initGridPosition();  //初始化表格的位置
        },
        /**
         * 显示简要列表标题
         */
        showSimpleListHeader: function(){
            //如果已经是显示状态，就不执行操作
            if(this.$simplelistHeader.is(':visible'))
                return;

            this.$simplelistHeader.show();
            this._initGridPosition();  //初始化表格的位置
        },
        /**
         * 显示简要列表标题
         */
        hideSimpleListHeader: function(){
            //如果已经是隐藏状态，就不执行操作
            if(!this.$simplelistHeader.is(':visible'))
                return;

            this.$simplelistHeader.hide();
            this._initGridPosition();  //初始化表格的位置
        },
        /**
         * 设置简要列表标题
         * @param title
         */
        setSimpleListHeader: function(title){
            title = $.trim(title);
            if(title == ""){
                this.hideSimpleListHeader();
                return;
            }

            this.$simplelistHeader.get(0).innerHTML = title;
            this.showSimpleListHeader();
        },
        _initReady: function(){
            var initFunArray = this._readyArray;
            for(var i= 0, funCount=initFunArray.length; i<funCount; i++){
                initFunArray[i](this);
            }
        },
        /**
         * 添加多表头
         *
         * @param attachHeaderArray eg: [{title:'联合', subField:[field1, field2]}]
         */
        attachHeader: function(attachHeaderArray){

            var gridObject = this.getGridObject();

            var $thead = gridObject.thead;
            var $lastTr = $thead.children("tr:last");   //标题的最后一行，即是不分组的单行
            var thElArray = $lastTr.children("th");

            var colArray = [];
            var $thEl = null;
            for(var i= 0, thCount=thElArray.length; i<thCount; i++){
                $thEl = $(thElArray[i]);
                if($thEl.is(":visible"))
                    colArray.push($thEl.data("field"));
            }


            var attachHeaderEl = [];
                attachHeaderEl.push("<tr>");
            var col = null;
            var th = null;
            var colspan = 1;
            var title = null;
            var isColspan = false;
            var subFieldArray = null;
            var attachHeader = null;
            var subFieldCount = 0;
            var hasAttachHeader = false;
            for(var i= 0, colCount=colArray.length; i<colCount; i++){
                colspan = 0;
                th = [];
                col = colArray[i];
                if($.trim(col) != ""){
                    for(var j=0; j<attachHeaderArray.length; j++){
                        colspan = 0;
                        attachHeader = attachHeaderArray[j];
                        subFieldArray = attachHeader["subFields"];
                        if(_.indexOf(subFieldArray, col) != -1){
                            for(var n=0; n<subFieldArray.length; n++){
                                if(_.indexOf(colArray, subFieldArray[n]) != -1){
                                    colspan++;
                                }
                            }

                            title = attachHeader["title"];
                            i += colspan;
                            hasAttachHeader = true;
                            break;
                        }
                    }
                }else{
                    colspan = 1;
                    title = "";
                }

                th.push("<th class='k-header' style='text-align:center;");

                if(colspan > 1){
                    th.push("border-bottom-width:1px;border-bottom-style:solid;border-right-width:1px;border-right-style:solid;' colspan='");
                    th.push(colspan);
                }

                th.push("'>");
                th.push(title);
                th.push("</th>");
                attachHeaderEl.push(th.join(""));
            }
            attachHeaderEl.push("</tr>");

            if(hasAttachHeader)
                gridObject.thead.first().prepend($(attachHeaderEl.join("")));
        },
        /**
         * 初始化表格的位置
         * @private
         */
        _initGridPosition: function(){
            var top = 1;
            var visible = this.$simplelistHeader.is(':visible');
            if(visible)
                top += this.$simplelistHeader.height() + 5;

            visible = this.$simplelistToolbarCondition.is(':visible');
            if(visible)
                top += this.$simplelistHeader.height() + 16;

            this.$simplelistList.parent().css("top", top);
        },
        /**
         * 初始化KendoGrid
         * @private
         */
        _initKendoGrid: function(id){
            var gridElId = $.uuid();

            var kendoGridConfig = this._getKendoGridConfig();    //获取KendoGrid的配置信息

            $("#simplelist_list").kendoGrid(kendoGridConfig);

            this.kendoGrid = $("#simplelist_list").data("kendoGrid");
        },

        _getKendoGridConfig: function(){
            var that = this;

            var result = {

                //数据源的配置信息：基于默认配置进行更改
                dataSource: $.extend(true, {}, {
                    //默认都是服务端请求处理
                    serverPaging: true,               //分页
                    serverFiltering: true,           //过滤条件
                    serverSorting: true,             //排序
                    serverAggregates: true,          //统计
                    serverGrouping: true,            //分组

                    pageSize: 10,                     //默认分页是每页10条记录

                    //对请求数据的加工处理
                    transport: {
                        read: {
                            cache: true   //默认是使用缓存的
                        }
                    },
                    //对返回的结果进行处理
                    schema: {
                        //服务端数据返回后，首先进入该方法，可在此对数据先做统一的预处理或解析返回的数据
                        parse: function(response) {
                            return $.parseJSON(response);   //将JSON字符串转换成JSON对象，注意json字符串中的键需要用括号包起来，不然会报错
                        }
                    },


                    requestStart: function(){
                        Log.debug("simplelist dataSource: requestStart");
                    },
                    requestEnd: function(){
                        Log.debug("simplelist dataSource: requestEnd");
                    },
                    //异常的统一拦截处理
                    error: function(e){
                        var transport = e.xhr;
                        if(transport.status == 404){
                            var url = null;
                            try {
                                url = this.transport.options.read.url;
                            }catch(e){
                            }
                            url = url || "";
                            alert("简要列表加载数据的地址不存在：" + url);
                        } else {
                        //    alert("简要列表加载异常,请与管理员联系：" + transport.errorThrown);
                        }
                    }
                }, this.get("dataSource")),
                columns: this._getKendoGridColumnsConfig(),                         //表格中列的信息
                pageable: $.extend(true, {}, {                     //是否支持分页，如果支持，其相关的配置信息
                    pageSizes: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],
                    info: true,
                    messages: {
                        empty: "查询无记录！",
                        itemsPerPage: "行每页",
                        display: "共 {2} 条记录，显示第 {0}-{1} 行记录"
                    }
                }, this.get("pageable")),
                dataBinding: function(){
                    Log.debug("simplelist: dataBinding");
                },
                dataBound: function(){
                    that._initReady();
                    Log.debug("simplelist: dataBound");
                },
                toolbar: this.get("toolbar"),                        //工具栏，如果用简要列表默认的工具栏，那么就不需要指定该工具栏；也可以隐藏默认提供的工具栏，通过模版自定义该工具栏信息
                detailTemplate: this.get("detailTemplate"),        //表格中每条记录明细信息的模版，如果指定了，那么在表格中会嵌套记录的明细信息
                editable: this.get("editable", false),              //是否支持在线编辑，如果支持，其相关的配置信息；默认是不支持在线编辑
                resizable: this.get("resizable", true),             //是否可以调整表格中列的宽度，默认是可调整的
                selectable: this.get("selectable", true),           //是否支持选中行，默认是支持的
                navigatable: this.get("navigatable", false),        //是否支持通过方向键来导航，默认是支持的
//                filterable: this.get("filterable"),                 //是否支持在每个标题中添加过滤信息，默认是不支持的
                groupable: this.get("groupable", false),            //是否支持分组，默认是不支持的
                sortable: this.get("sortable", false)              //是否支持排序，默认是不支持
            }

            //配置表格高度
            var height = this.get("height");
            if(height)
                result["height"] = height;

            return result;
        },

        _getKendoGridColumnsConfig: function(){
            var columnArray = this.get("columns");
            var col = null;
            var colAlign = null;
            var colType = null;
            var colName = null;
            var colTmpl = null;
            var extendInfo = null;
            var url = null;
            var chkElName = null;
            var chkAllElId = null;
            for(var i= 0, colCount=columnArray.length; i<colCount; i++){
                col = columnArray[i];

                if(typeof col == "string"){
                    col = {"field": col};
                }

                colName = col.field;

                //主键列，缓存主键字段名
                if(col.primary){
                    this._primaryKey = colName;

                    delete col.primary;
                }

                //标题统一居中对齐
                col.headerAttributes = col.headerAttributes || {};
                col.headerAttributes.style = "text-align: center;" + (col.headerAttributes.style || "");

                //单元格扩展：单元格类型（链接列）
                colType = col.type;
                if(colType){
                    colTmpl = col.template || ("#=" + colName + "#");

                    colType = $.trim(colType).toLowerCase();
                    //链接列
                    if(colType == "link"){
                        extendInfo = col["link"] || {};
                        url = extendInfo["url"] || "";
                        url = url.replace(/"/g, "&quot;");   //对双引号进行转义，不然到模版中就会被截取；同时如果url中要包含#，就必须写成\\#，否则模版解析会报错

                        col.template = "<a href=\"" + url + "\">" + colTmpl + "</a>";

                        delete col.link;
                    }
                    //序列
                    if(colType == "seq"){
                        this._hasSeqCol = true;
                        col.width = col.width || "40px";
                        col.align = col.align || "right";
                    }
                    //复选框列
                    if(colType == "chk"){
                        this._hasChkCol = true;
                        chkElName = this._generateSingleChkElName(colName);
                        chkAllElId = this._generateAllChkElId(colName);
                        col.headerTemplate = '<input type="checkbox" id="' + chkAllElId + '" />';
                        col.template = '<input type="checkbox" name="' + chkElName + '" value="' + (col.value||"") + '"/>';
                        col.width = col.width || "40px";
                        col.align = col.align || "center";
                        col.sortable = false;

                        //向初始化列表中添加事件，待初始化完成后执行
                        this._readyArray.push(function(simpleListObject){
                            simpleListObject.linkAllAndSingleChk(chkAllElId, chkElName);
                        });

                        delete col.value;
                    }

                    delete col.type;
                }

                //单元格扩展：单元格文本对齐设置
                colAlign = col.align;
                if(colAlign){
                    colAlign = $.trim(colAlign).toLowerCase();
                    colAlign = colAlign == "left" ? " text-left " : colAlign;       //左对齐
                    colAlign = colAlign == "center" ? " text-center " : colAlign;   //居中对齐
                    colAlign = colAlign == "right" ? " text-right " : colAlign;     //右对齐

                    col.attributes = col.attributes || {};
                    col.attributes.class = colAlign + (col.attributes.class || "");

                    delete col.align;
                }
            }
            return columnArray;
        },
        /**
         * 根据字段名生成全选复选框表单元素的ID
         * @param colName
         * @return {string}
         * @private
         */
        _generateAllChkElId: function(colName){
            return "__" + colName + "__check_all";
        },
        /**
         * 根据字段名生成单个复选框表单元素的Name
         * @param colName
         * @return {string}
         * @private
         */
        _generateSingleChkElName: function(colName){
            return "__" + colName + "__check_all";
        },
        /**
         * 联动全选和单个选复选框
         * @param gridObject        表格对象
         * @param allChkElId        全选复选框的表单元素ID
         * @param singleChkElName   单选复选框的表单元素Name（注意：这里是元素的name，不是ID）
         */
        linkAllAndSingleChk: function(allChkElId, singleChkElName){
            var gridObject = this.getGridObject();
            var $chkAll = $("#" + allChkElId);
            var $chkArray = $("input[name='" + singleChkElName + "']");

            //添加全选的单击事件
            $chkAll.on("click", function(e){
                var $cb = $(this);
                var checked = $cb.is(':checked');

                gridObject.clearSelection();   //清空所有选中的记录

                if(checked){
                    gridObject.tbody.find("tr").addClass('k-state-selected');   //如果当前复选框为选中状态，则将表格中所有行都选中
                }

                $chkArray.each(function(){
                    this.checked = checked;
                });
            });

            //添加表格中行的单击事件
            var that = this;
            gridObject.tbody.on("click", "tr", function(e){
                //有复选框，才需要考虑
                if(that._hasChkCol)
                    that._initSelectedRow(this);   //初始化选中的行，保证选中的行能以特殊背景色标注。这里不考虑单击整行选中记录，会出现死循环或者多次触发的情况。只能点击复选框进行选中
            });

            //添加单个复选框的单击事件
            $chkArray.on("click", function(e){
                var checked =  $(this).is(':checked');
                var hasDiff = false;  //判断是否所有都不一样

                $("input[name='" + this.name + "']").each(function(){
                    //判断是否有与当前选中复选框状态不一样
                    if(this.checked != checked){
                        hasDiff = true;
                        return false;
                    }
                });

                $chkAll.get(0).checked = hasDiff ? false : checked;
            });
        },
        clearSelection: function(){
            var chkColName = SimpleList.CHECK_COL_NAME;
            var allChkElId = this._generateAllChkElId(chkColName);
            var $allChk = $("#" + allChkElId);
            $allChk.get(0).checked = true;
            $allChk.trigger("click");
        },
        /**
         * 初始化选中的记录样式
         * @param row
         * @private
         */
        _initSelectedRow: function(row){
            var gridObject = this.getGridObject();
            gridObject.clearSelection();   //清空所有选中的记录

            var chkColName = SimpleList.CHECK_COL_NAME;
            var chkElName = this._generateSingleChkElName(chkColName);

            $("input[name='" + chkElName + "']").each(function(){
                //如果当前复选框选中，则设置表格该行的记录为选中状态
                if(this.checked)
                    $(this).closest("tr").addClass('k-state-selected');   //如果当前复选框为选中状态，则将表格中所有行都选中
            });
        },
        /**
         * 根据是否有序列号列或多选框列来向结果集中添加值
         * @param dataArray
         * @return {*}
         */
        appendColValue: function(dataArray){
            //如果没有包含序列列，则直接返回
            if(!this._hasSeqCol && !this._hasChkCol)
                return dataArray;

            if(dataArray == null)
                return dataArray;

            var hasSeqCol = this._hasSeqCol;
            var hasChkCol = this._hasChkCol;
            if($.isArray(dataArray)){
                var data = null;
                for(var i= 0, count=dataArray.length; i<count; i++){
                    data = dataArray[i];
                    if(hasSeqCol)
                        data["seq"] = i + 1;
                    if(hasChkCol)
                        data[SimpleList.CHECK_COL_NAME] = "";
                }
            }

            return dataArray;
        }
    });

    SimpleList.CHECK_COL_NAME = "chk";   //复选框的列名

    return SimpleList;
});