/**
 * 简要列表工具类
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery",
    "utils/Log",
    "rpc/AjaxEngine",
    "utils/common"
], function($, Log,AjaxEngine){
    var SimpleListUtil = {

        /**
         * 根据单元格元素获取当前行
         * @param cell
         * @return {*}
         */
         getCurrentRow: function(cell){
            if(cell == null)
                return null;

            return $(cell).closest("tr");
        },

        getDataItem: function(gridObject, colName, colValue){
            var data = gridObject._data;
//            for()
        },

        toUTF8 : function(szInput){
            var wch,x,uch="",szRet="";
            for (x=0; x<szInput.length; x++)
            {
                wch=szInput.charCodeAt(x);
                if (!(wch & 0xFF80))
                {
                    szRet += szInput.charAt(x);
                }
                else if (!(wch & 0xF000))
                {
                    uch = "%" + (wch>>6 | 0xC0).toString(16) + "%" + (wch & 0x3F | 0x80).toString(16);
                    szRet += uch;
                }
                else
                {
                    uch = "%" + (wch >> 12 | 0xE0).toString(16) + "%" + (((wch >> 6) & 0x3F) | 0x80).toString(16) +"%" + (wch & 0x3F | 0x80).toString(16);
                    szRet += uch;
                }
            }
            return(szRet);
        },

        GetQueryString: function(name){
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
            var r = window.location.search.substr(1).match(reg);
            if (r!=null) return (r[2]); return null;
        },

        /**
         * 获取选中行中指定列的值
         *
         * @param gridObject
         * @param colName
         */
        getSelectedColumnValue: function(gridObject, colName){
            var begin = new Date();
            if(gridObject == null || colName == null)
                return null;
            var $selectedRow = gridObject.select();
            var rowCount = $selectedRow.length;
            if(rowCount == 0)
                return null;

            var result = [];
            var rowEl = null;
            var value = null;
            for(var i=0; i<rowCount; i++){
                rowEl = $selectedRow.get(i);
                value = this.getColumnValue(gridObject, rowEl, colName);
                if(value)
                    result.push(value);
            }

            var end = new Date();
            Log.debug("获取表格选中列值耗时：" + (end.getMilliseconds() - begin.getMilliseconds()));

            return result.join(",");
        },

        /**
         * 获取选中行的数据
         *
         * @param gridObject
         * @return {Array}
         */
        getSelectedDataItem: function(gridObject){
            var result = [];
            if(gridObject == null)
                return result;
            var $selectedRow = gridObject.select();
            var rowCount = $selectedRow.length;
            if(rowCount == 0)
                return result;

            var rowEl = null;
            var dataItem = null;
            for(var i=0; i<rowCount; i++){
                rowEl = $selectedRow.get(i);
                dataItem = this.getDataItem(gridObject, rowEl);
                if(dataItem != null)
                    result.push(dataItem);
            }

            return result;
        },

        /**
         * 根据给定的行和列名获取该列的值
         * @param gridObject
         * @param row
         * @param colName //允许多个值，多个值用逗号分隔
         * @return {*} //如果请求的是单个列，则返回单个列的值；多个列则返回一个键值对的对象
         */
        getColumnValue: function(gridObject, row, colName){
            var dataItem = this.getDataItem(gridObject, row);
            if(dataItem == null)
                return null;

            var colNameArray = colName.split(",");
            if(colNameArray.length == 1)
                return dataItem[colName];

            var result = {};
            for(var i= 0, colCount=colNameArray.length; i<colCount; i++){
                colName = $.trim(colNameArray[i]);
                if(colName == "")
                    continue;

                result[colName] = dataItem[colName];
            }

            return result;
        },

        /**
         * 根据行的信息来获取该行的数据（用该方式来获取值，性能更佳）
         * @param gridObject
         * @param row
         * @return {null}
         */
        getDataItem: function(gridObject, row){
            if(gridObject == null || row == null)
                return null;

            var $row = $(row);
            var data = gridObject._data;
            var uid = $row.data("uid");
            if(uid == null)
                return null;

            var result = null;
            for(var i= 0, dataCount=data.length; i<dataCount; i++){
                result = data[i];
                if(uid == result["uid"])
                    break;
            }

            return result;
        },

        /**
         * 判断表格是否选择单条记录
         *
         * @param gridObject
         */
        checkSingleSelection: function(gridObject){
            if (!this.checkSelection())
                return false;

            if (this.hasMultiSelected(gridObject)) {
                alert("只能操作一条记录，您选择的记录数过多。");
                return false;
            }

            return true;
        },

        /**
         * 判断表格是否有选中记录
         *
         * @param gridObject
         */
        checkSelection: function(gridObject){
            if (!this.hasSelected(gridObject)) {
                alert("请选择一条要操作的记录");
                return false;
            }

            return true;
        },
        /**
         * 判断列表是否选中多条记录
         * @param gridObject
         * @return {boolean}
         */
        hasMultiSelected: function(gridObject){
            return this.getSelectedCount(gridObject) > 1;
        },

        /**
         * 判断列表是否有选中记录
         *
         * @param gridObject
         * @return {boolean}
         */
        hasSelected: function(gridObject){
            return this.getSelectedCount(gridObject) > 0;
        },

        /**
         * 获取表格选中的记录数
         * @param gridObject
         * @return {*}
         */
        getSelectedCount: function(gridObject){
            if(gridObject == null)
                return 0;

            var $selectedRow = gridObject.select();

            return $selectedRow.length;
        },
        setDataTimeCn: function(){
            kendo.cultures["zh-CN"] = {
                name: "zh-CN",
                numberFormat: {
                    pattern: ["-n"],
                    decimals: 2,
                    ",": ",",
                    ".": ".",
                    groupSize: [3],
                    percent: {
                        pattern: ["-n %","n %"],
                        decimals: 2,
                        ",": ",",
                        ".": ".",
                        groupSize: [3],
                        symbol: "%"
                    },
                    currency: {
                        pattern: ["($n)","$n"],
                        decimals: 2,
                        ",": ",",
                        ".": ".",
                        groupSize: [3],
                        symbol: "$"
                    }
                },
                calendars: {
                    standard: {
                        days: {
                            names: ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
                            namesAbbr: ["周日","周一","周二","周三","周四","周五","周六"],
                            namesShort: ["日","一","二","三","四","五","六"]
                        },
                        months: {
                            names: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月",""],
                            namesAbbr: ["一","二","三","四","五","六","七","八","九","十","十一","十二",""]
                        },
                        AM: ["上午","早","上午"],
                        PM: ["下午","晚","下午"],
                        patterns: {
                            d: "M/d/yyyy",
                            D: "dddd, MMMM dd, yyyy",
                            F: "dddd, MMMM dd, yyyy h:mm:ss tt",
                            g: "M/d/yyyy h:mm tt",
                            G: "M/d/yyyy h:mm:ss tt",
                            m: "MMMM dd",
                            M: "MMMM dd",
                            s: "yyyy'-'MM'-'dd'T'HH':'mm':'ss",
                            t: "h:mm tt",
                            T: "h:mm:ss tt",
                            u: "yyyy'-'MM'-'dd HH':'mm':'ss'Z'",
                            y: "MMMM, yyyy",
                            Y: "MMMM, yyyy"
                        },
                        "/": "/",
                        ":": ":",
                        firstDay: 0
                    }
                }
            }
            return true;
        },
        showkdDialog: function(id, content, width, height,titles){
            var dialogEl = document.getElementById(id);
            if(dialogEl != null)
                return;
            var documentWindow = $(window);
            var kendoUIWindow = $("<div id='" + id + "'  />").kendoWindow({
                title: titles,
                width: width + "px",
                height: height + "px",
                modal: false,
                actions: [
                    "Close"],
                open: function (e) {
                },
                close: function(e){
                    kendoUIWindow.destroy();         //销毁窗口，将窗口相关代码从界面中移除
                    kendoUIWindow = null;
                }
            }).data("kendoWindow").content(content);
            kendoUIWindow.center().open();

            return kendoUIWindow;
        },
        getSessionId: function(){
            var sessionid="";
            new AjaxEngine("1.jsp",
                {
                    async: false,
                    data:{},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);
                        sessionid = result.sessionId;
                    }
                }
            );
            return sessionid;
        },
        ckSession: function(sid){
            new AjaxEngine("router?appKey=000001&method=loginUser.getSession&v=1.0&format=json",
                {
                    async: false,
                    data:{sessionId: sid},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);
                        if (result.resultString=="1"){
                        } else {
                            location.replace("demo.html#login");
                        }

                    }
                }
            );
        },
        cklogin: function(sid){
            var isSuccess="";
            new AjaxEngine("router?appKey=000001&method=loginUser.isExistLoginUser&v=1.0&format=json",
                {
                    async: false,
                    data:{sessionId: sid,id: $("#id").val(),pwd: $("#pwd").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);
                        isSuccess = result.resultString;
                    }
                }
            );
            return isSuccess;
        },
        addSession: function(sid){
            new AjaxEngine("router?appKey=000001&method=loginUser.addSession&v=1.0&format=json",
                {
                    async: false,
                    data:{sessionId: sid},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);
                        if (result.resultString=="1"){
                            alert("登录成功！")
                            location.replace("demo.html");
                        } else {
                            alert("登录失败！")
                            location.reload();
                        }

                    }
                }
            );
        },
        removeSession: function(sid){
            new AjaxEngine("router?appKey=000001&method=loginUser.removeSession&v=1.0&format=json",
                {
                    async: false,
                    data:{sessionId: sid},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);
                        alert("登录失败！")
                        location.reload();
                    }
                }
            );
        } ,
        getSelectCode: function(typecode,seletecode){
            var detailstr="";
            var styleid="";
            new AjaxEngine("router?appKey=000001&method=comstyle.selectComstyle&v=1.0&format=json",
                {
                    async: false,
                    data:{code: typecode},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);
                        if (result.resultJson.length>0) {
                            styleid=result.resultJson[0].id;
                        }

                        new AjaxEngine("router?appKey=000001&method=comcode.selectComcode&v=1.0&format=json",
                            {
                                async: false,
                                data:{typecode: styleid},
                                dataType: 'json',
                                complete: function(transport){
                                    var result = transport.responseText;
                                    result = $.parseJSON(result);
                                    if($.isArray(result.resultJson)){
                                        var data = null;
                                        for(var i= 0, count=result.resultJson.length; i<count; i++){
                                            if (seletecode==result.resultJson[i].code)   {
                                                detailstr+="    <option value='"+result.resultJson[i].code+"' selected>"+result.resultJson[i].name+"</option>";
                                            } else{
                                                detailstr+="    <option value='"+result.resultJson[i].code+"' >"+result.resultJson[i].name+"</option>";
                                            }
                                        }
                                    }
                                }
                            }
                        );

                    }
                }
            );
            return detailstr;
        },
        getRadioCode: function(typecode,radioname,curdata){
            var detailstr="";
            var styleid="";
            new AjaxEngine("router?appKey=000001&method=comstyle.selectComstyle&v=1.0&format=json",
                {
                    async: false,
                    data:{code: typecode},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);
                        if (result.resultJson.length>0) {
                            styleid=result.resultJson[0].id;
                        }

                        new AjaxEngine("router?appKey=000001&method=comcode.selectComcode&v=1.0&format=json",
                            {
                                async: false,
                                data:{typecode: styleid},
                                dataType: 'json',
                                complete: function(transport){
                                    var result = transport.responseText;
                                    result = $.parseJSON(result);
                                    if($.isArray(result.resultJson)){
                                        var data = null;
                                        for(var i= 0, count=result.resultJson.length; i<count; i++){
                                            detailstr+="&nbsp;&nbsp;<input type='radio' curdata='"+curdata+"' value='"+result.resultJson[i].code+"' name='"+radioname+"' data-bind='checked: isChecked' style='...'/>&nbsp;"+result.resultJson[i].name;
                                        }
                                    }
                                }
                            }
                        );

                    }
                }
            );
            return detailstr;
        },
        getSelectDes: function(typecode,seletecode){
            var detailstr="";
            var styleid="";
            if (seletecode==""){
                return detailstr;
            } else {
            new AjaxEngine("router?appKey=000001&method=comstyle.selectComstyle&v=1.0&format=json",
                {
                    async: false,
                    data:{code: typecode},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);
                        if (result.resultJson.length>0) {
                            styleid=result.resultJson[0].id;
                        }

                        new AjaxEngine("router?appKey=000001&method=comcode.selectComcode&v=1.0&format=json",
                            {
                                async: false,
                                data:{typecode: styleid,code:seletecode},
                                dataType: 'json',
                                complete: function(transport){
                                    var result = transport.responseText;
                                    result = $.parseJSON(result);
                                    if (result.resultJson.length>0) {
                                        detailstr = result.resultJson[0].name;
                                    }
                                    //alert(detailstr);
                                }
                            }
                        );

                    }
                }
            );
            return detailstr;
            }
        }

    }

    return SimpleListUtil;
})