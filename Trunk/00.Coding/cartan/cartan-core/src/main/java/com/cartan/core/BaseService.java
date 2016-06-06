/**
 * Copyright：中软海晟信息科技有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author : chenxh(quickselect@163.com)
 * @date: 13-6-24
 */
public abstract class BaseService {

    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @PostConstruct
    protected final void init(){
        initMappers(this.sqlSessionTemplate);
    }

    /**
     *  在此初始化Service的所需要的各Map
     * @param sqlSessionTemplate
     */
    protected abstract void initMappers(SqlSessionTemplate sqlSessionTemplate);
}
