/**
 * //缓存客户端
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["types/Class"], function(Class){
    var CachedClient = Class.extend({
        /**
         * //构造函数
         *
         * @param cachedClientName //缓存客户端ID，例如业务对象模型配置缓存客户端（BomConfig）,部门缓存客户端（DEPT）,字典表缓存客户端(DICT)...
         * @param storageArea //存储类型（Session或Local），为空默认查询的是Local
         */
        ctor: function(cachedClientName, storageArea){
            this.cachedClientName = cachedClientName;
            this.storageArea = storageArea;
        },

        /**
         * //根据键获取值
         * @param key //键
         * @param storageArea  //存储类型（Session或Local），为空默认查询的是Local
         */
        get: function(key, storageArea){
            var storage = this.getStorage(storageArea);
            key = this._getCachedKey(key);

            return storage.getItem(key);
        },
        /**
         * //向缓存中设置值
         * @param key   键
         * @param value 值
         * @param storageArea 存储类型（Session或Local），为空默认查询的是Local
         */
        put: function(key, value, storageArea){
            var storage = this.getStorage(storageArea);
            key = this._getCachedKey(key);

            storage.getItem(key, value);
        },
        /**
         * //移除缓存中的值
         * @param key 键
         * @param storageArea 存储类型（Session或Local），为空默认查询的是Local
         */
        remove: function(key, storageArea){
            var storage = this.getStorage(storageArea);

            storage.remove(key);
        },
        /**
         * 客户端缓存刷新
         *
         * @param storageArea 存储类型（Session或Local），为空默认查询的是Local
         */
        refresh: function(storageArea){
            if(this.cachedClientName){
                alert("您的缓存客户端名称为空，请在创建的时候指定，否则不允许刷新");
                return;
            }

            var storage = this.getStorage(storageArea);
            var key;
            for (var i=0, len = storage.length; i < len; i++){
                key = storage.key(i);
                if(key.indexOf(this.cachedClientName) == 0)
                    storage.remove(key);
            }
        },
        /**
         * //获取存储对象
         * @param storageArea 存储类型（Session或Local），为空默认查询的是Local
         * @return {Storage}
         */
        getStorage: function(storageArea){
            storageArea = storageArea ? storageArea : this.storageArea;

            if(storageArea == null || storageArea == CachedClient.LOCAL_STORAGE_AREA)
                return this.localStorage();
            return this.sessionStorage();
        },
        /**
         * //获取缓存的键：<缓存客户端名称>_<key>
         * @param key
         * @return {String}
         * @private
         */
        _getCachedKey: function(key){
            var result = [];
            if(this.cachedClientName != null && this.cachedClientName != "")
                result.push(this.cachedClientName);
            result.push("_");
            result.push(key);

            return result.join("");
        },
        /**
         * //客户端永久缓存
         * @return {Storage}
         */
        localStorage: function(){
            return localStorage;
        },
        /**
         * //会话级缓存
         * @return {Storage}
         */
        sessionStorage: function(){
            return sessionStorage;
        }
    });

    CachedClient.SESSION_STORAGE_AREA = "Session";
    CachedClient.LOCAL_STORAGE_AREA = "Local";

    return CachedClient;
});
