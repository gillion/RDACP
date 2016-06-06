
/**
 * combox控件
 *
 * @author:xueduanyang
 */
function combox(el) {
    // 保存select引用指针
    this.select = el;
    el.relatedCombox = this;
    // 得到select的高度等
    var t = el.offsetTop;
    var l = el.offsetLeft;
    var w = el.offsetWidth;
    var h = el.offsetHeight - 2;
    while (el = el.offsetParent) {
    t += el.offsetTop;
    l += el.offsetLeft;
    }
this.top = t;
this.left = l;
this.width = w;
this.height = h;
this.selectRow = null;
this.minWidth = 100;
// 关联combox和select
this.FnRelateComboxWithSelect = function() {
    }
}
// 创建输入框
combox.prototype.createTextBox = function() {
    var span = document.createElement('span');
    this.inptContainer = span;
    var width = this.minWidth ? (this.width < this.minWidth
    ? this.width
    : this.minWidth) : this.width + "px";
    span.className = 'combox_input';
    span.style.height = this.height + "px";
    span.style.width = width;
    var txtBox = document.createElement('input');
    this.txtBox = txtBox;
    txtBox.type = 'text';
    txtBox.setAttribute('autoComplete', 'off');
    txtBox.id = 'combox_transform_select_'
    + (this.select.id ? this.select.id : this.select.name);
    txtBox.value = this.select.options[this.select.selectedIndex].text;
    txtBox.className = 'combox_text';
    txtBox.style.width = width - 18  + "px";
    txtBox.style.height = this.height - 2 + "px";
    span.appendChild(txtBox);
    this.select.parentNode.insertBefore(span, this.select);
    var block = document.createElement('span');
    this.block = block;
    block.style.width = "16px";
    block.style.cursor = 'hand';
    //block.innerHTML = '◢';
    block.innerHTML = '';
    this.dpListBtn = block;
    span.appendChild(block);
    }
// 创建下拉框
combox.prototype.createDpList = function() {
    var select = this.select;
    var txtBox = this.txtBox;
    var selectRow = this.selectRow;
    //
    var container = document.createElement("div");
    this.dpListContainer = container;
    container.style.display = 'none';
    container.style.position = "absolute";
    container.style.width = this.width -12+ "px";
    container.style.top = (this.top + this.height) + 1 + "px";
    container.style.left = this.left + "px";
    container.className = 'combox_container';
    container.innerHTML = '<iframe style="position:absolute;z-index:-1;width:100%;height:100%;top:0;left:0;right:0;scrolling:no;" frameborder="0" src="about:blank"></iframe>';
    //
    document.body.appendChild(container);
    // 列表
    var dpList = document.createElement("ul");
    this.dpListContainer.dpList = dpList;
    dpList.className = 'combox_dplist';
    container.appendChild(dpList);
    // 列表每行
    for (var i = 0; i < select.options.length; i++) {
    var row = document.createElement("li");
    row.className = 'combox_row';
    row.innerHTML = select.options[i].text;
    row.selectValue = select.options[i].value;
    row.index = i;
    //
    if (select.options[i].selected == true) {
    selectRow = row;
    }
//
dpList.appendChild(row);
}
if (selectRow == null) {
    selectRow = dpList.childNodes[0];
    }
container.onmouseover = function() {
    var el = document.all ? window.event.srcElement : arguments[0].target;
    if (el.tagName && el.tagName == 'LI') {
    selectRow.className = 'combox_row_mouseout';
    el.className = 'combox_row_mouseover';
    selectRow = el;
    }
}
container.onclick = function() {
    var el = document.all ? window.event.srcElement : arguments[0].target;
    if (el.tagName && el.tagName == 'LI') {
    selectRow = el;
    txtBox.value = el.innerHTML;
    if (select.value != el.selectValue) {
    if (el.selectValue == null || el.selectValue == '') {
    for (var i = 0; i > select.options.length; i++) {
    if (select.options[i].value == el.selectValue) {
    select.options[i].selected = true;
    break;
    }
}
select.options[0].selected = true;
} else
select.value = el.selectValue;
if (select.onchange)
select.onchange(select);
}
txtBox.style.width=select.options[select.selectedIndex].text.length*12+12+"px";

// 同时我们把下拉的关闭掉。
container.style.display = 'none';
stopEventPropagation();
}
}
this.txtBox.onkeydown = function() {
    var keyCode = window.event
    ? window.event.keyCode
    : arguments[0].keyCode;
    // down
    if (keyCode == 40 && container.style.display != 'none') {
    var selectRowHeight = 0;
    for (var i = 0; i < dpList.childNodes.length; i++) {
    var row = dpList.childNodes[i];

    if (selectRow.index >= i) {
    if (row.style.display != 'none') {
    selectRowHeight += 20;
    }
} else {
    if (row.style.display != 'none') {
    selectRow.className = 'combox_row_mouseout';
    selectRow = row;
    row.className = 'combox_row_mouseover';
    break;
    }
}
}
keyDownMoveScrollTop(keyCode, selectRowHeight);
}// up
else if (keyCode == 38 && container.style.display != 'none') {
            if (selectRow.index > 0) {
                var selectRowHeight = 0;
                var find = false;
                for (var i = selectRow.index - 1; i >= 0; i--) {
                    var row = dpList.childNodes[i];
                    if (row.style.display != 'none') {
                        selectRowHeight += 20;
                        if (!find) {
                            selectRow.className = 'combox_row_mouseout';
                            selectRow = row;
                            row.className = 'combox_row_mouseover';

                            find = true;
                        }
                    }
                }
            }
            keyDownMoveScrollTop(keyCode, selectRowHeight - 20);
        }
    }
    this.txtBox.onkeyup = function() {
        var keyCode = window.event
                ? window.event.keyCode
                : arguments[0].keyCode;
        if (keyCode == 40 || keyCode == 38) {
            if (selectRow != null) {
                selectRow.className = 'combox_row_mouseover';
                if (container.style.display == 'none') {
                    container.style.display = '';
                    resetContainerHeight();
                    resetContainerHeight();
                }
            }
            return false;
        } // enter
        else if (keyCode == 13) {
            if (container.style.display != 'none') {
                txtBox.value = selectRow.innerHTML;
                if (select.value != selectRow.selectValue) {
                    if (selectRow.selectValue == null
                            || selectRow.selectValue == '') {
                        for (var i = 0; i > select.options.length; i++) {
                            if (select.options[i].value = selectRow.selectValue) {
                                select.options[i].selected = true;
                                break;
                            }
                        }
                    } else  {
                        select.value = selectRow.selectValue;
                    }

                    if (select.onchange)
                        select.onchange(select);
                }
                container.style.display = 'none';
                stopEventPropagation();
                return false;
            } else {
                for (var i = 0; i < dpList.childNodes.length; i++) {
                    var row = dpList.childNodes[i];
                    row.style.display = '';
                    row.className = 'combox_row_mouseout';
                }
                container.style.display = '';
                selectRow.className = 'combox_row_mouseover';
                resetContainerHeight();
                resetContainerHeight();
                stopEventPropagation();
                return false;
            }
        }// esc
        else if (keyCode == 27) {
            if (container.style.display != 'none') {
                container.style.display = 'none';
                return false;
            } else {
                return false;
            }
        }// page down
        else if (keyCode == 34) {
            for (var i = 0; i < dpList.childNodes.length; i++) {
                var row = dpList.childNodes[i];
                row.style.display = '';
                row.className = 'combox_row_mouseout';
            }
            container.style.display = '';
            selectRow.className = 'combox_row_mouseover';
            resetContainerHeight();
            resetContainerHeight();
            return false;
        } else {

            var val = this.value;
            for (var i = 0, row; row = dpList.childNodes[i]; i++) {
                if (row.innerHTML.indexOf(val) > -1) {
                    row.style.display = '';
                } else {
                    row.style.display = 'none';
                }
            }
            resetContainerHeight();
        }
        if (selectRow != null)
            selectRow.className = 'combox_row_mouseover';
        container.style.display = '';
    }
    // this.txtBox.onfocus = function() {
    // if (container.style.display != 'none') {
    // container.style.display = 'none';
    // }
    // }
    // this.txtBox.onblur = function() {
    // var el = document.all ? window.event.srcElement : arguments[0].target;
    // if (el == container) {
    // return false;
    // }
    // finishComboxInput();
    //
    // }
    this.txtBox.onclick = function() {
        if (container.style.display != 'none') {
            txtBox.value = selectRow.innerHTML;
            if (select.value != selectRow.selectValue) {
                if (selectRow.selectValue == null
                    || selectRow.selectValue == '') {
                    for (var i = 0; i > select.options.length; i++) {
                        if (select.options[i].value = selectRow.selectValue) {
                            select.options[i].selected = true;
                            break;
                        }
                    }
                } else
                    select.value = selectRow.selectValue;
                if (select.onchange)
                    select.onchange(select);
            }
            container.style.display = 'none';
            stopEventPropagation();
            return false;
        } else {
            for (var i = 0; i < dpList.childNodes.length; i++) {
                var row = dpList.childNodes[i];
                row.style.display = '';
                row.className = 'combox_row_mouseout';
            }
            container.style.display = '';
            selectRow.className = 'combox_row_mouseover';
            resetContainerHeight();
            resetContainerHeight();
            stopEventPropagation();
            return false;
        }
        //stopEventPropagation();
    }
    this.dpListBtn.onclick = function() {
        resetRowDisplay();
        if (container.style.display == 'none') {
            container.style.display = '';
        } else {
            for (var i = 0; i < select.options.length; i++) {
                if (select.options[i].text == txtBox.value) {
                    if (select.options[i].selected != true) {
                        select.options[i].selected = true;
                        if (select.onchange)
                            select.onchange(select);
                    }
                    break;
                }
                if (i == select.options.length - 1)
                    txtBox.value = select.options[select.selectedIndex].text;
            }
            for (var i = 0; i < dpList.childNodes.length; i++) {
                var row = dpList.childNodes[i];
                if (row.innerHTML == txtBox.value) {
                    selectRow.className = 'combox_row_mouseout';
                    selectRow = row;
                    row.className = 'combox_row_mouseover';
                    break;
                }
            }
            container.style.display = 'none'
        }
        resetContainerHeight();
        resetContainerHeight();
        stopEventPropagation();
    }
    function finishComboxInput() {
        // 键盘或者鼠标选中的
        try {
            if (txtBox.value == selectRow.innerHTML) {
                if (select.value != selectRow.selectValue) {
                    if (selectRow.selectValue == null
                            || selectRow.selectValue == '') {
                        for (var i = 0; i > select.options.length; i++) {
                            if (select.options[i].value = selectRow.selectValue) {
                                select.options[i].selected = true;
                                break;
                            }
                        }
                    } else
                        select.value = selectRow.selectValue;
                    if (select.onchange)
                        select.onchange(select);
                }
            } else {
                // 按键后，鼠标选中
                if (select.value != selectRow.selectValue) {
                    txtBox.value = selectRow.innerHTML;
                    if (selectRow.selectValue == null
                            || selectRow.selectValue == '') {
                        for (var i = 0; i > select.options.length; i++) {
                            if (select.options[i].value = selectRow.selectValue) {
                                select.options[i].selected = true;
                                break;
                            }
                        }
                    } else
                        select.value = selectRow.selectValue;
                    if (select.onchange)
                        select.onchange(select);
                } else {// 手输
                    for (var i = 0; i < select.options.length; i++) {
                        if (select.options[i].text == txtBox.value) {
                            if (select.options[i].selected != true) {
                                select.value = select.options[i].value;
                                if (select.onchange)
                                    select.onchange(select);
                            }
                            break;
                        }
                        if (i == (select.options.length - 1))
                        {
                            //if (select.options[select.selectedIndex].text.length>0)
                            txtBox.value = select.options[select.selectedIndex].text;
                        }

                    }
                    for (var i = 0; i < dpList.childNodes.length; i++) {
                        var row = dpList.childNodes[i];
                        if (row.innerHTML == txtBox.value) {
                            if (selectRow != null)
                                selectRow.className = 'combox_row_mouseout';
                            selectRow = row;
                            row.className = 'combox_row_mouseover';
                            break;
                        }
                    }
                }
            }
            container.style.display = 'none';
        } catch (e) {
            alert(e)
        }
    }
    if (document.addEventListener) {
        document.body.addEventListener('click', finishComboxInput, false);
    } else {
        document.body.attachEvent('onclick', finishComboxInput);// IE
    }
    function resetRowDisplay() {
        var f = true;
        for (var i = 0, row; row = dpList.childNodes[i]; i++) {
            row.style.display = '';
            row.className = 'combox_row_mouseout';
            selectRow.className = 'combox_row_mouseover';
        }
    }
    // 控制容器的最大高度
    function resetContainerHeight() {
        var minHeight = 0;
        var selectRowTop = 0;
        var curRowIsSelected = false;
        for (var i = 0; i < dpList.childNodes.length; i++) {
            var row = dpList.childNodes[i];
            if (row.style.display != 'none') {
                minHeight += 20;
                if (!curRowIsSelected) {
                    if (selectRow != row) {
                        selectRowTop += 20;
                    } else {
                        curRowIsSelected = true;
                    }
                }
            }
        }
        if (minHeight < 200) {
            container.style.height = minHeight == 0 ? 20 + 2 + "px" : minHeight
                    + 2 + "px";
        } else {
            container.style.height = 202 + "px";
            if (container.style.display == 'none') {
            }
            if (selectRow != null && selectRow.style.display != 'none') {
                container.scrollTop += selectRowTop - container.scrollTop;
            } else {
                container.scrollTop = 0;
            }
        }
    }
    function keyDownMoveScrollTop(keyCode, selectRowHeight) {
        // down
        if (keyCode == 40 && container.style.display != 'none') {
            if (selectRowHeight - container.scrollTop > 180)
                container.scrollTop += 20;
        }// up
        else if (keyCode == 38 && container.style.display != 'none') {
            if (selectRowHeight < container.scrollTop)
                container.scrollTop -= 20;
        }
    }
    // 阻止事件传播
    function stopEventPropagation() {
        var event = window.event
                ? window.event
                : arguments.callee.caller.arguments[0];
        event.cancelBubble = true;
        event.returnValue = false;
        if (event.preventDefault) {
            event.preventDefault();
        }
        if (event.stopPropagation) {
            event.stopPropagation();
        }
    }
}
combox.prototype.correctErrData = function() {
    //
}
combox.prototype.hideDropList = function() {
    this.dpListContainer.style.display = 'none';
}
combox.prototype.transform = function() {
    // 将原select隐藏
    this.FnRelateComboxWithSelect = function() {
        var key = document.all
                ? window.event.propertyName
                : arguments[0].attrName;
        if (key == 'value') {
            var el = document.all
                    ? window.event.srcElement
                    : arguments[0].target;
            if (el.tagName && el.tagName == 'SELECT'
                    && el.relatedCombox != null) {
                el.relatedCombox.txtBox.value = el.options[el.selectedIndex].text;
            }
        }
        // document.getElementById('combox_transform_select_'
        // + (p.id ? p.id : p.name)).value = p.options[p.selectedIndex].text;
    }
    if (document.addEventListener) {
        this.select.addEventListener('DOMAttrModified',
                this.FnRelateComboxWithSelect, false);
    } else {
        this.select.attachEvent('onpropertychange',
                this.FnRelateComboxWithSelect);// IE
    }
    // 在原select前面新建一个span，里面套一个text
    this.createTextBox();
    // 下拉列表容器
    this.createDpList();
    this.correctErrData();
    this.select.style.display = 'none';
}
combox.prototype.isDataCorrect = function() {
    return this.txtBox.value == this.select.value;
};
// go go 初始化
(function() {
    function select_transform() {
        var sel_ary = document.getElementsByTagName('select');
        for (var i = 0; i < sel_ary.length; i++) {
            if (!sel_ary[i].multiple && sel_ary[i].style.display != 'none') {
                if (hasCss('combox', sel_ary[i].className))
                    (new combox(sel_ary[i])).transform();
            }
        }
    }
    function hasCss(cssName, cssNameAry) {
        var cssAry = cssNameAry.split(/\s/);
        for (var i = 0, css; css = cssAry[i]; i++) {
            if (cssName.toLowerCase() == css.toLowerCase()) {
                return true;
            }
        }
        return false;
    }
    if (document.addEventListener) {
        window.addEventListener("load", select_transform, false);// FireFox
    } else {
        window.attachEvent("onload", select_transform);// IE
    }
})();
combox.prototype.destroy = function() {

    if (document.addEventListener) {
        this.select.removeEventListener('DOMAttrModified',
                this.FnRelateComboxWithSelect, false);
    } else {
        this.select.detachEvent('onpropertychange',
                this.FnRelateComboxWithSelect);// IE
    }
    if (document.all) {
        this.dpListContainer.removeNode(true);
    } else
        this.dpListContainer.parentNode.removeChild(this.dpListContainer);
    if (document.all) {
        this.inptContainer.removeNode(true);
    } else
        this.inptContainer.parentNode.removeChild(this.inptContainer);
    this.FnRelateComboxWithSelect = null;
    this.select.relatedCombox = null;
    this.top = null;
    this.left = null;
    this.height = null;
    this.width = null;
    this.selectRow = null;
    this.select.style.display = '';
    this.select = null;

}
