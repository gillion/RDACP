/**
 * 系统信息
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-28 上午9:10
 */
define(function(){
    window.sys = window.sys || {};

    /** LocalStorage is a local storage component.
     */
    sys.localStorage = window.localStorage;


    /** Capabilities
     */
    Object.defineProperties(sys,
        {
            "capabilities" : {
                get : function(){
                    var capabilities = {"canvas":true};

                    if( 'ontouchstart' in document.documentElement )
                        capabilities["touches"] = true;
                    else if( 'onmouseup' in document.documentElement )
                        capabilities["mouse"] = true;

                    if( 'onkeyup' in document.documentElement )
                        capabilities["keyboard"] = true;

                    return capabilities;
                },
                enumerable : true,
                configurable : true
            },
            "os" : {
                get : function() {
                    var iOS = ( navigator.userAgent.match(/(iPad|iPhone|iPod)/i) ? true : false );
                    var isAndroid = navigator.userAgent.match(/android/i) || navigator.platform.match(/android/i) ? true : false;
                    var OSName=navigator.appVersion;
                    if (navigator.appVersion.indexOf("Win")!=-1)
                        OSName="Windows";
                    else if (navigator.appVersion.indexOf("Mac")!=-1)
                        OSName="OS X";
                    else if (navigator.appVersion.indexOf("X11")!=-1)
                        OSName="UNIX";
                    else if (navigator.appVersion.indexOf("Linux")!=-1)
                        OSName="Linux";
                    else if( iOS )
                        OSName = "iOS";
                    else if( isAndroid )
                        OSName = "Android";
                },
                enumerable : true,
                configurable : true
            },
            "platform" : {
                get : function(){
                    return "browser";
                },
                enumerable : true,
                configurable : true
            },
            "version" : {
                get : function(){
                    return cc.ENGINE_VERSION;
                },
                enumerable : true,
                configurable : true
            }
        });
});