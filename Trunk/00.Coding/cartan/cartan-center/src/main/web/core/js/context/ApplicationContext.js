/**
 * //应用上下文
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["types/Class", "cache/CachedClient"],  function(Class, CachedClient){
    var ApplicationContext = Class.extend({
        WEB_CONTEXT_PATH: null,             //应用的根路径

        ctor: function(){
            this.WEB_CONTEXT_PATH = this.getRootPath();
        },
        /**
         * //向应用上下文中添加属性值
         * @param prop eg: {"version": "1.4"}
         */
        set: function(prop){
            for (var name in prop) {
                this[name] = prop[name];
            }

            this.refreshCache(); //刷新缓存中的值
        },

        getRootPath: function(){
            var jsArray = document.scripts;
            var result = jsArray[jsArray.length - 1].src;
            result = result.substring(0, result.lastIndexOf("/"));  //先获取当前JS文件所在的路径
            result = result.substring(0, result.lastIndexOf("/"));  //然后往上退三层
            result = result.substring(0, result.lastIndexOf("/"));
            result = result.substring(0, result.lastIndexOf("/")+1);

            return result;  //系统的根路径
        },
        refreshCache: function(){
            ApplicationContext.getCacheClient().put("sharedApplicationContext", this);
        }

    });

    ApplicationContext._cacheClient = null;
    ApplicationContext.getInstance = function() {
        this._cacheClient = ApplicationContext.getCacheClient();
        var sharedApplicationContext = this._cacheClient.get("sharedApplicationContext");       //用于共享的应用上下文信息
        if(sharedApplicationContext == null){
            sharedApplicationContext = new ApplicationContext();
            this._cacheClient.put("sharedApplicationContext", sharedApplicationContext);
        }

        return sharedApplicationContext;
    };

    ApplicationContext.getCacheClient = function(){
        return this._cacheClient ? this._cacheClient : new CachedClient("ApplicationContext");
    }

    return ApplicationContext.getInstance();
});
