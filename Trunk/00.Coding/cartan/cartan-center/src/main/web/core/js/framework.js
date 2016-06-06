/**
 * 底层平台框架
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
window.ROOT_PATH = window.ROOT_PATH ? window.ROOT_PATH : (function(){
    var jsArray = document.scripts;
    var result = jsArray[jsArray.length - 1].src;
    result = result.substring(0, result.lastIndexOf("/"));  //先获取当前JS文件所在的路径
    result = result.substring(0, result.lastIndexOf("/"));  //然后往上退两层
    result = result.substring(0, result.lastIndexOf("/")+1);

    return result;  //系统的根路径
})();


/**根据指定的参数返回完整可用的 URL 路径。
 *@param urlPath 指定的 URL 路径，可以是不完整的路径。
 *p_pathPart 参数中，支持“~”符号表示当前站点的根路径。其他规则类似于文件系统，同样支持“../”、“/”等特殊含义的符号。
 *     // 假设当前页面路径:              /test/subpages/default.htm
 *     //     当前站点路径:              /test/
 *
 *     $url("index.htm")                // 返回“/test/subpages/index.htm”。
 *     $url("scripts/common.js")        // 返回“/test/subpages/scripts/common.js”。
 *
 *     $url("/test/images/home.gif")    // 返回“/test/images/home.gif”。
 *     $url("../images/home.gif")       // 返回“/test/images/home.gif”。
 *     $url("~/images/home.gif")        // 返回“/test/images/home.gif”。
 *
 *     $url("http://www.sina.com")      // 返回“http://www.sina.com”。
 *     $url("www.sina.com")             // 由于没有“http://”标记，则将参数作为 URL 的
 *                                       // 一部分，返回“/test/subpages/www.sina.com”。
 * </example>
 * </special-member> */
function $url(urlPath) {
    var tempUrlPath = urlPath.trim();
    if (tempUrlPath.toLowerCase().match("^[a-z][a-z0-9]*://") || tempUrlPath.indexOf("/")==0)
        return urlPath;

    if(tempUrlPath.indexOf("~")==0)
        return  window.ROOT_PATH + tempUrlPath.substring(1);

     var currentPath = location.pathname;
     var i = currentPath.lastIndexOf("/", currentPath.length - 1);
     if (i >= 0)
         currentPath = currentPath.substring(0, i);

     if (tempUrlPath.indexOf("../")==0){
         var path = currentPath;
         while (tempUrlPath.indexOf("../")==0){
             i = path.lastIndexOf('/', path.length - 1);
             if (i != -1)
                 path = path.substring(0, i);
             else
                 throw new Error("“" + urlPath + "”路径不存在。");
             tempUrlPath = tempUrlPath.substring(3);
         }

         if (!(path.lastIndexOf("/")==path.length-1))
             path += "/";
         return path + tempUrlPath;
     }

     return currentPath + "/" + tempUrlPath;
}

/**
 * 用来加载指定的框架外的脚本文件或 CSS 样式表单。文件路径参数的规则同 $url 方法。
 * <pre>
 * 说明：
 *     1. 此语句并不负责校验指定的项是否存在。
 *     2. 重复的项不会被再次加载。
 *     3. 此语句为同步操作，只有当此脚本文件被加载后才会继续执行后面的程序。
 * </pre>
 * @param fileName 指定的脚本文件路径。
 */
function $include(fileName, options){
    fileName = $url(fileName);
    var isJsFile = fileName.lastIndexOf(".js") == (fileName.length-3);
    var isCssFile = fileName.lastIndexOf(".css") == (fileName.length-4);
    if(!(isJsFile || isCssFile))
        return;

    var fileId = "f_" + hex_sha1(fileName);
    var isExisted = document.getElementById(fileId) != null;
    if(isExisted)
        return;

    var contentArray = [];
    if(isJsFile)
        contentArray.push('<script type="text/javascript" id="');
    else
        contentArray.push('<link rel="stylesheet" id="');

    contentArray.push(fileId);

    if(isJsFile)
        contentArray.push('" src="');
    else
        contentArray.push('" href="');

    contentArray.push(fileName);
    contentArray.push('" ');

    if(options != null){
        for(var key in options){
            contentArray.push(key);
            contentArray.push('="');
            contentArray.push(options[key]);
            contentArray.push('" ');
        }
    }

    if(isJsFile){
        contentArray.push(' ></');
        contentArray.push('script>');
    }else
        contentArray.push(' ></');

    document.write(contentArray.join(""));
}
//SHA1
/////////////////////////////////////////////////////////////////////////////////////////////
/*
 * Configurable variables. You may need to tweak these to be compatible with
 * the server-side, but the defaults work in most cases.
 */
var hexcase = 0;
/* hex output format. 0 - lowercase; 1 - uppercase        */

/*
 * These are the functions you'll usually want to call
 * They take string arguments and return either hex or base-64 encoded strings
 */
function hex_sha1(s) {
    return rstr2hex(rstr_sha1(str2rstr_utf8(s)));
}

/*
 * Calculate the SHA1 of a raw string
 */
function rstr_sha1(s) {
    return binb2rstr(binb_sha1(rstr2binb(s), s.length * 8));
}

/*
 * Convert a raw string to a hex string
 */
function rstr2hex(input) {
    try {
        hexcase
    } catch (e) {
        hexcase = 0;
    }
    var hex_tab = hexcase ? "0123456789ABCDEF" : "0123456789abcdef";
    var output = "";
    var x;
    for (var i = 0; i < input.length; i++) {
        x = input.charCodeAt(i);
        output += hex_tab.charAt((x >>> 4) & 0x0F)
            + hex_tab.charAt(x & 0x0F);
    }
    return output;
}

/*
 * Encode a string as utf-8.
 * For efficiency, this assumes the input is valid utf-16.
 */
function str2rstr_utf8(input) {
    var output = "";
    var i = -1;
    var x, y;

    while (++i < input.length) {
        /* Decode utf-16 surrogate pairs */
        x = input.charCodeAt(i);
        y = i + 1 < input.length ? input.charCodeAt(i + 1) : 0;
        if (0xD800 <= x && x <= 0xDBFF && 0xDC00 <= y && y <= 0xDFFF) {
            x = 0x10000 + ((x & 0x03FF) << 10) + (y & 0x03FF);
            i++;
        }

        /* Encode output as utf-8 */
        if (x <= 0x7F)
            output += String.fromCharCode(x);
        else if (x <= 0x7FF)
            output += String.fromCharCode(0xC0 | ((x >>> 6 ) & 0x1F),
                0x80 | ( x & 0x3F));
        else if (x <= 0xFFFF)
            output += String.fromCharCode(0xE0 | ((x >>> 12) & 0x0F),
                0x80 | ((x >>> 6 ) & 0x3F),
                0x80 | ( x & 0x3F));
        else if (x <= 0x1FFFFF)
            output += String.fromCharCode(0xF0 | ((x >>> 18) & 0x07),
                0x80 | ((x >>> 12) & 0x3F),
                0x80 | ((x >>> 6 ) & 0x3F),
                0x80 | ( x & 0x3F));
    }
    return output;
}

/*
 * Convert a raw string to an array of big-endian words
 * Characters >255 have their high-byte silently ignored.
 */
function rstr2binb(input) {
    var output = Array(input.length >> 2);
    for (var i = 0; i < output.length; i++)
        output[i] = 0;
    for (var i = 0; i < input.length * 8; i += 8)
        output[i >> 5] |= (input.charCodeAt(i / 8) & 0xFF) << (24 - i % 32);
    return output;
}

/*
 * Convert an array of big-endian words to a string
 */
function binb2rstr(input) {
    var output = "";
    for (var i = 0; i < input.length * 32; i += 8)
        output += String.fromCharCode((input[i >> 5] >>> (24 - i % 32)) & 0xFF);
    return output;
}

/*
 * Calculate the SHA-1 of an array of big-endian words, and a bit length
 */
function binb_sha1(x, len) {
    /* append padding */
    x[len >> 5] |= 0x80 << (24 - len % 32);
    x[((len + 64 >> 9) << 4) + 15] = len;

    var w = Array(80);
    var a = 1732584193;
    var b = -271733879;
    var c = -1732584194;
    var d = 271733878;
    var e = -1009589776;

    for (var i = 0; i < x.length; i += 16) {
        var olda = a;
        var oldb = b;
        var oldc = c;
        var oldd = d;
        var olde = e;

        for (var j = 0; j < 80; j++) {
            if (j < 16) w[j] = x[i + j];
            else w[j] = bit_rol(w[j - 3] ^ w[j - 8] ^ w[j - 14] ^ w[j - 16], 1);
            var t = safe_add(safe_add(bit_rol(a, 5), sha1_ft(j, b, c, d)),
                safe_add(safe_add(e, w[j]), sha1_kt(j)));
            e = d;
            d = c;
            c = bit_rol(b, 30);
            b = a;
            a = t;
        }

        a = safe_add(a, olda);
        b = safe_add(b, oldb);
        c = safe_add(c, oldc);
        d = safe_add(d, oldd);
        e = safe_add(e, olde);
    }
    return Array(a, b, c, d, e);

}

/*
 * Perform the appropriate triplet combination function for the current
 * iteration
 */
function sha1_ft(t, b, c, d) {
    if (t < 20) return (b & c) | ((~b) & d);
    if (t < 40) return b ^ c ^ d;
    if (t < 60) return (b & c) | (b & d) | (c & d);
    return b ^ c ^ d;
}

/*
 * Determine the appropriate additive constant for the current iteration
 */
function sha1_kt(t) {
    return (t < 20) ? 1518500249 : (t < 40) ? 1859775393 :
        (t < 60) ? -1894007588 : -899497514;
}

/*
 * Add integers, wrapping at 2^32. This uses 16-bit operations internally
 * to work around bugs in some JS interpreters.
 */
function safe_add(x, y) {
    var lsw = (x & 0xFFFF) + (y & 0xFFFF);
    var msw = (x >> 16) + (y >> 16) + (lsw >> 16);
    return (msw << 16) | (lsw & 0xFFFF);
}

/*
 * Bitwise rotate a 32-bit number to the left.
 */
function bit_rol(num, cnt) {
    return (num << cnt) | (num >>> (32 - cnt));
}