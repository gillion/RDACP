/**
 * //基于jquery对表单元素做了一些扩展：添加了一些改变表达元素动画效果的API
*
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery"], function($){
    /**
     * Browser detection, based on mootools<br/>
     * platform will print out win32, mac, etc<br/>
     * type is the browser type, chrome, firefox etc
     * @type {Object}
     */
    window.Browser = {};
    (function () {
        window.Browser.ua = navigator.userAgent.toLowerCase();
        window.Browser.platform = navigator.platform.toLowerCase();
        window.Browser.UA = window.Browser.ua.match(/(opera|ie|firefox|chrome|version)[\s\/:]([\w\d\.]+)?.*?(safari|version[\s\/:]([\w\d\.]+)|$)/) || [null, 'unknown', 0];
        window.Browser.mode = window.Browser.UA[1] == 'ie' && document.documentMode;
        window.Browser.type = (window.Browser.UA[1] == 'version') ? window.Browser.UA[3] : window.Browser.UA[1];
        window.Browser.isMobile = (window.Browser.ua.indexOf('mobile') != -1 || window.Browser.ua.indexOf('android') != -1);
    })();

    //getting the prefix and css3 3d support
    switch (window.Browser.type) {
        case "firefox":
            $.pfx = "Moz";
            $.hd = true;
            break;
        case "chrome":
        case "safari":
            $.pfx = "webkit";
            $.hd = true;
            break;
        case "opera":
            $.pfx = "O";
            $.hd = false;
            break;
        case "ie":
            $.pfx = "ms";
            $.hd = false;
    }
    //cache for prefixed transform
    $.trans = $.pfx + "Transform";
    //helper function for constructing transform strings
    $.translate = ($.hd) ? function (a) {
        return "translate3d(" + a.x + "px, " + a.y + "px, 0) "
    } : function (a) {
        return "translate(" + a.x + "px, " + a.y + "px) "
    };
    $.rotate = ($.hd) ? function (a) {
        return "rotateZ(" + a + "deg) ";
    } : function (a) {
        return "rotate(" + a + "deg) ";
    };
    $.scale = function (a) {
        return "scale(" + a.x + ", " + a.y + ") "
    };
    $.skew = function (a) {
        return "skewX(" + -a.x + "deg) skewY(" + a.y + "deg)";
    };

    /**
     * helper function for updating the css transform
     * @return {$}
     */
    $.transforms = function(){
        var el = null;
        var transforms = null;
        for (var i = 0; i < this.length; i++) {
            el = this[i];
            el.position = el.position || {x:0, y:0};
            el.rotation = el.rotation || 0;
            el.scale = el.scale || {x:1, y:1};
            el.skew = el.skew || {x:0, y:0};

            el.style[$.trans] = $.translate(el.position) + $.rotate(el.rotation) + $.scale(el.scale) + $.skew(el.skew);
        }

        return this;
    };

    /**
     * move the element
     * @param {Number} x in pixel
     * @param {Number} y in pixel
     * @return {$}
     */
    $.translates = function (x, y) {
        var el = null;
        for (var i = 0; i < this.length; i++) {
            el = this[i];
            el.position = {x:x, y:y};
        }

        this.transforms();
        return this;
    };

    /**
     * rotate the element
     * @param {Number} x in degrees
     * @return {$}
     */
    $.rotate = function (x) {
        var el = null;
        for (var i = 0; i < this.length; i++) {
            el = this[i];
            el.rotation = x;
        }

        this.transforms();
        return this;
    };

    /**
     * resize the element
     * @param {Number} x
     * @param {Number} y
     * @return {$}
     */
    $.resize = function (x, y) {
        var el = null;
        for (var i = 0; i < this.length; i++) {
            el = this[i];
            el.scale = {x:x, y:y};
        }

        this.transforms();
        return this;
    };

    /**
     * skews the element
     * @param {Number} x in degrees
     * @param {Number} y
     * @return {$}
     */
    $.setSkew = function (x, y) {
        var el = null;
        for (var i = 0; i < this.length; i++) {
            el = this[i];
            el.skew = {x:x, y:y};
        }

        this.transforms();
        return this;
    };
});