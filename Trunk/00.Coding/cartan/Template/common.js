/**
 * 系统业务公用代码
 * athor yyp 2016-04-11
 */
(function($,window){
    window.CommonMethods = {};

    /**
     * [add：编辑]
     * @param  {[type]} title        [dialog标题]
     * @param  {[type]} width        [dialog宽度]
     * @param  {[type]} height       [dialog公安段]
     * @param  {[type]} url          [dialog打开url]
     * @param  {[type]} gridSelector [dialog父页面的datagrid]
     * @param  {[type]} onLoadFun    [是否有onLoad方法]
     * 由于是在页面直接调用，选择传参数的方式
     */
    CommonMethods.add = function (title, width, height, url, onLoadFun) {
        this.type = 0;
        if (onLoadFun) {
            var onLoadFun = function(){DialogForm.init()};
        }
        var opts = {
            title: title,
            width: width,
            height: height,
            href: url,
            buttons: [{
                text: '存储',
                iconCls: 'icon-ok',
                handler: function(){DialogForm.addCommit();}
            },{
                text: '关闭',
                iconCls: 'icon-cancel',
                handler: function(){
                    $('#addDialog').dialog('close');
                }
            }],
            onLoad: onLoadFun || function(){}
        };
        Utils.buildDialog('addDialog', opts, 0);
    };

    // 编辑
    CommonMethods.edit = function (title, width, height, url, gridSelector, onLoadFun) {
        this.type = 1;
        var row = gridSelector.datagrid('getSelected');
        if (onLoadFun) {
            var onLoadFun = function(){DialogForm.init(row.id)};
        }
        if (row) {
            var opts = {
                title: title,
                width: width,
                height: height,
                href: url+'?id='+row.id,
                buttons: [{
                    text: '存储',
                    iconCls: 'icon-ok',
                    handler: function(){DialogForm.editCommit();}
                },{
                    text: '关闭',
                    iconCls: 'icon-cancel',
                    handler: function(){
                        $('#editDialog').dialog('close');
                    }
                }],
                // onLoad: function(){DialogForm.init(row.id)} || null
                onLoad: onLoadFun || function(){}
            };
	        Utils.buildDialog('editDialog', opts, 0);

    	} else {
    		$.messager.alert('提示信息', '请选择一行记录！', 'info');
    	}
    };

    // 查看
    CommonMethods.view = function (title, width, height, url, gridSelector, onLoadFun) {
        var row = gridSelector.datagrid('getSelected');
        if (onLoadFun) {
           var onLoadFun = function(){DialogFormView.init(row.id)}
        }
        if (row) {
            var opts = {
                title: title,
                width: width,
                height: height,
                href: url+'?'+row.id,
                buttons: [{
                    text: '关闭',
                    iconCls: 'icon-cancel',
                    handler: function(){
                        $('#viewDialog').dialog('close');
                    }
                }],
                // onLoad: function(){DialogFormView.init(row.id)} || null
                onLoad: onLoadFun || function(){}
            };
            Utils.buildDialog('viewDialog', opts, 0);

        } else {
            $.messager.alert('提示信息', '请选择一行记录！', 'info');
        }
    };

    // 删除
    CommonMethods.deletes = function (url, gridSelector) {
        var row = gridSelector.datagrid('getSelected');
        
        if (row) {
            var deleteData = row.id;
            $.messager.confirm("删除确认","您确认想要删除记录吗?",function(r){
                if(r){
                    var opts = {
                        method: 'post',
                        url: url,
                        data: {
                            id: deleteData
                        },
                        messager: function (data) {
                            if (data) {
                                $.messager.alert('提示信息', '删除成功！', 'info');
                                gridSelector.datagrid('load');
                            }
                        },
                        callback: function(data) {
                            gridSelector.datagrid('reload');
                        },
                        skip: true
                    };
                    Utils.doAjax(opts);
                }
            });
        } else {
            $.messager.alert('提示信息', '请选择一行记录！', 'info');
        }
    };

    // 导出 预览
    CommonMethods.viewExport = function () {

        // 动态创建导出机台人员对照表dialog并打开
        var dynamicTable = $('<table id="exportExcelGrid"></table>');
        var dialogOpts = {
            title: '导出机台人员对照表'
        };
        Utils.buildDialog('viewExportDialog', dialogOpts, 0);

        $('#viewExportDialog').html(dynamicTable);

        // 创建grid并初始化
        Utils.createGrid($('#exportExcelGrid'), options.exportExcel.opts);
    };

    // 导出功能
    CommonMethods.exports = function () {
        var rows = $('#exportExcelGrid').datagrid("getData");
        var totals = rows.total;
        if (totals > 0 ) {
            /*var opts = {
                method: 'post',
                url: ResearchersUrl.exportAjax,
                data: '',
                messager: function (data) {
                    if (data) {
                        $.messager.alert('提示信息', '导出成功！', 'info');
                    }
                },
                skip: true
            };
            Utils.doAjax(opts);*/

            // 测试 后期删除
            $.messager.alert('提示信息', '导出成功！', 'info');

        } else {
            $.messager.alert("提示信息","当前没有可导出数据","info");
        }
    };

    // 转班
    CommonMethods.transfer = function () {
        var opts = {
            title: '转班',
            href: leftMenuUrl.transferDialog,
            buttons: [{
                text: '存储',
                iconCls: 'icon-ok',
                handler: function(){DialogForm.transferCommit();}
            },{
                text: '关闭',
                iconCls: 'icon-cancel',
                handler: function(){
                    $('#transferDialog').dialog('close');
                }
            }]
        };
        Utils.buildDialog('transferDialog', opts, 0);
    };

    // 排程抓取: 只有上胶生产排程的栏位设定不是此方法
    // 栏位设定  这个功能是前端完成，后端不需要记住列交换的位置，刷新页面则设定栏位恢复初始化。
    CommonMethods.setColumns = function () {

        // 动态创建模具变动单dialog并打开
        var dynamicTable = $('<table id="setColumsGrid"></table>');
        var dialogOpts = {
            width: 400,
            height: 520,
            title: '栏位设定'
        };
        Utils.buildDialog('setColumsDialog', dialogOpts, 0);

        $('#setColumsDialog').html(dynamicTable);
        var $grid = $('#setColumsGrid');

        // 获取当前选中的页签下的datagrid
        var tab = $('#tabsList').tabs('getSelected');
        var index = $('#tabsList').tabs('getTabIndex',tab);
        var $selectedGrid = $('#dayGrid'+index);
        var colName = []; // 存放所有列的title；

        // 获取datagrid 数据
        var data = [];
        var colums = $selectedGrid.datagrid('getColumnFields');
        for(var i=0;i<colums.length;i++){
            colName[i] = $selectedGrid.datagrid('getColumnOption', colums[i]).title;
            data[i] = {
                columnName: colName[i]
            }
        }

        // 创建grid并初始化
        var gridOpts = {
            fitColumns: true,
            pagination: false,
            // singleSelect: false,
            // ctrlSelect: true,
            data: data,
            columns: [[
                {field: 'id', checkbox:true},
                {field: 'columnName', title: '栏位名称', width: 100, align: 'center'}
            ]],
            toolbar: [{
                text: '剪上',
                iconCls: 'icon-up',
                handler: function(){
                    var row = $grid.datagrid('getSelected');
                    var i = $grid.datagrid("getRowIndex", row);
                    CommonMethods.moveGridRow.moveupRow($grid, row);
                    var colums = $selectedGrid.datagrid('options').columns[0];
                    if(i>0) {
                        colums.splice(i-1, 2, colums[i], colums[i-1]); // 交换值
                        Schedule.columns[index][0] = colums;
                    }
                }
            },'-',{
                text: '贴下',
                iconCls: 'icon-down',
                handler: function(){
                    var row = $grid.datagrid('getSelected');
                    var j = $grid.datagrid("getRowIndex", row);
                    CommonMethods.moveGridRow.movedownRow($grid, row);
                    var colums = $selectedGrid.datagrid('options').columns[0];
                    if(j<colums.length-1) {
                        colums.splice(j, 2, colums[j+1], colums[j]); // 交换值
                        Schedule.columns[index][0] = colums;
                    }
                }
            },{
                id: 'yesBtn',
                text: '确定',
                iconCls: 'icon-ok',
                handler: function(){
                    $selectedGrid.datagrid({
                        columns: Schedule.columns[index]
                    });
                    $('#setColumsDialog').dialog('close');
                }
            }]
        };
        Utils.createGrid($grid, gridOpts);

        // 确定按钮，右对齐
        $('#yesBtn').css('margin-left', 200);
    };




    /**
     * 模糊查询限制输入特殊字符例如:"%或_"
     * params $selector 选择器; special保存需限制的特殊字符数组
     * author wyf 2016-03-17
     */
    CommonMethods.limitInputSpecial = function ($selector,special) {

        $selector.on('change keyup blur keydown',function(){
            var _self = this;
            $.each(special,function(i,n){
                if(_self.value.indexOf(n) != -1){
                    _self.value = _self.value.replace(n,'');
                }
            });
        });
    };

    // 单元格合并
    CommonMethods.mergeCellsByField = function (tableID, colList) {
        var ColArray = colList.split(",");
        var tTable = $("#" + tableID);
        var TableRowCnts = tTable.datagrid("getRows").length;
        var tmpA;
        var tmpB;
        var PerTxt = "";
        var CurTxt = "";
        var alertStr = "";
        for (j = ColArray.length - 1; j >= 0; j--) {
            PerTxt = "";
            tmpA = 1;
            tmpB = 0;

            for (i = 0; i <= TableRowCnts; i++) {
                if (i == TableRowCnts) {
                    CurTxt = "";
                }
                else {
                    CurTxt = tTable.datagrid("getRows")[i][ColArray[j]];
                }
                if (PerTxt == CurTxt) {
                    tmpA += 1;
                }
                else {
                    tmpB += tmpA;

                    tTable.datagrid("mergeCells", {
                        index: i - tmpA,
                        field: ColArray[j],　　//合并字段
                        rowspan: tmpA,
                        colspan: null
                    });
                    tTable.datagrid("mergeCells", { //根据ColArray[j]进行合并
                        index: i - tmpA,
                        field: "Ideparture",
                        rowspan: tmpA,
                        colspan: null
                    });

                    tmpA = 1;
                }
                PerTxt = CurTxt;
            }
        }
    };

    /**
     * 开始时间小于结束时间
     * opts:$beginTime   $endTime
     * showDay: 是否为datebox:默认为datatimebox
     * author yyp 2016-03-10
     */
    CommonMethods.compareTimes = function ($beginTime, $endTime, showDay) {

        if (showDay){

            // 解决new Date()对浏览器兼容问题。
            var beginTime= $beginTime.datetimebox('getValue').toString();
            var endTime= $endTime.datetimebox('getValue').toString();
            var sd =  new Date(Date.parse(beginTime.replace(/-/g,"/")));
            var ed =  new Date(Date.parse(endTime.replace(/-/g,"/")));

            if (ed<sd) {
                $beginTime.datetimebox('setValue','');
                $endTime.datetimebox('setValue','');
                $.messager.alert('提示信息','开始时间不能大于结束时间','info');
            }
        } else {
            // 解决new Date()对浏览器兼容问题。
            var beginTimes= $beginTime.datebox('getValue').toString();
            var endTimes= $endTime.datebox('getValue').toString();
            var start =  new Date(Date.parse(beginTimes.replace(/-/g,"/")));
            var end =  new Date(Date.parse(endTimes.replace(/-/g,"/")));

            if (end<start) {
                $beginTime.datebox('setValue','');
                $endTime.datebox('setValue','');
                $.messager.alert('提示信息','开始时间不能大于结束时间','info');
            }
        }
    };

    /**
     * [rangDatebox 输入一个时间自动设置另一个时间]
     * @param  {[type]} opts [时间对象]
     */
    CommonMethods.rangDatebox = function (opts) {
        var dates  = opts.$this.datebox('getValue');
        var selectDay = new Date(Date.parse(dates.replace(/-/g,"/")));
        if (opts.$this.attr('id') == opts.beginTime && dates) {
            var beginDay= new Date(selectDay.getTime() + opts.dayNo*24*60*60*1000);
            $('#'+opts.endTime).datebox('setValue',Utils.dateFormat(beginDay, "yyyy-MM-dd"));
        } else if (opts.$this.attr('id') == opts.endTime && dates) {
            var endDay = new Date(selectDay.getTime() - opts.dayNo*24*60*60*1000);
            $('#'+opts.beginTime).datebox('setValue',Utils.dateFormat(endDay, "yyyy-MM-dd"));
        } else if (!dates) {
            $('#'+opts.beginTime).datebox('setValue','');
            $('#'+opts.endTime).datebox('setValue','');
        }
    };

    /**
     * [resizeTab 重新刷新表格]
     * @param  {[type]} opts [需要操作的grid及其对象]
     * author yyp 2016-04-14
     */
    CommonMethods.resizeTab = function (opts) {

        // 设置column的title并重新生成grid
        var week = [];
        var firstDay = new Date(Date.parse(opts.begin.replace(/-/g,"/")));
        for(i=0;i<7;i++) {
            time= new Date(firstDay.getTime() + i*24*60*60*1000);
            week[i] = Utils.dateFormat(time, "yyyy-MM-dd");
            opts.$grid.datagrid('getColumnOption', i).title = week[i];
        }
        opts.$grid.datagrid();

        // 设置grid的title;
        opts.others ? others = opts.others : others = '';
        var newTitle = week[0] + '至' + week[6] + others;
        opts.$grid.datagrid('getPanel').panel('setTitle',newTitle);
    };

    // 先选择时间再操作
    CommonMethods.searchByDate = function (opts, callback) {
        if(opts.begin && opts.end) {

            // 重置grid
            callback.call();
        } else {
            $.messager.alert("提示信息","请选择查询时间","info");
        }
    };

    /**
     * [moreSearch 更多查询信息 展开]
     * @param  {[type]} aButton    [点击按钮ID]
     * @param  {[type]} divContent [需要显示的div]
     * @param  {[type]} layoutId   [当前内容所在布局的ID]
     */
    CommonMethods.moreSearch = function ($aButton, $divContent, layoutId, initHeight, openHeight) {
        var flag = true;
        $aButton.on('click', function() {
            if(flag){
                $aButton.linkbutton({
                    iconCls : 'icon-del'
                });
                CommonMethods.resizeLayout(layoutId,'north',openHeight);
                $divContent.fadeIn();

                flag = !flag;
            }else{
                $aButton.linkbutton({
                    iconCls : 'icon-add'
                });
                $divContent.hide();
                CommonMethods.resizeLayout(layoutId,'north',initHeight);

                flag = !flag;
            }
        });
    };

    CommonMethods.resizeLayout = function(layout,region,height){
        var panel = $("#"+layout).layout("panel",region);
        panel.panel("resize",{height:height});
        $("#"+layout).layout("resize");
    };

    /**
     * [moveGridRow datagrid行上下移动功能]
     * @ author yyp 2015-04-15
     */
    CommonMethods.moveGridRow = {

        isFirstRow: function ($grid, row) {
            var index = $grid.datagrid("getRowIndex", row);
            if (index == 0) {
                return true;
            }
            return false;
        },
        isLastRow: function ($grid, row) {
            var index = $grid.datagrid("getRowIndex", row);
            var rowNum = $grid.datagrid("getRows").length;
            if (index == (rowNum - 1)) {
                return true;
            }
            return false;
        },
        moveupRow: function ($grid, row) {
            if(row){
                var index = $grid.datagrid("getRowIndex", row);
                if (this.isFirstRow($grid, row)) {
                    $.messager.alert("提示信息" ,"已经是第一条！", "info");
                    return;
                }
                $grid.datagrid("deleteRow", index);
                $grid.datagrid("insertRow", {
                    index : index - 1, // 索引从0开始
                    row : row
                });
                $grid.datagrid("selectRow", index - 1);
            } else {
                $.messager.alert("提示信息" ,"请选择需要移动的一行", "info");
            }
        },
        movedownRow: function ($grid, row) {
            if(row){
                var index = $grid.datagrid("getRowIndex", row);
                if (this.isLastRow($grid, row)) {
                    $.messager.alert("提示信息" ,"已经是最后一条！", "info");
                    return;
                }
                $grid.datagrid("deleteRow", index);
                $grid.datagrid("insertRow", {
                    index : index + 1, // 索引从0开始
                    row : row
                });
                $grid.datagrid("selectRow", index + 1);
            } else {
                $.messager.alert("提示信息" ,"请选择需要移动的一行", "info");
            }
        }
    };

})(jQuery,window);


/*easyui-validetype   验证数字*/
$.extend($.fn.validatebox.defaults.rules, {
    numbers : {
        validator : function(value, params) {
            // return /(^0\d{9,11}$)|(^1[3,8,5][0-9]{9}$)/g.test(value);
            return /^([0-9]+)$/.test(value);
        },
        message : '只能输入数字,请重新输入!'
    }
});
