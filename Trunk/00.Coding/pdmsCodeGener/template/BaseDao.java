package cn.cst.kcgl.common.dao;

import cn.com.xcs.framework.persist.Page;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface  BaseDao<T, PK extends Serializable> {
	public void save(T entity);
	
	public void merge(T entity);

	public void delete(T entity);

	public void delete(PK id);
	
	public T get(Class clz,PK id) ;
	
	public List<T> getAll();
	
	/**
	 * 此方法描述的是： 通过MyBatis查询单个记录或单个值
	 * 
	 * 
	 * @version: 2012-4-17 下午3:49:50
	 */
	public Object queryOneBySql(String statementId, Object value);

    /**
     * 查询
     * @param statementId
     * @param value
     * @return
     */
    public Object queryBySql(String statementId, Object value);

    /**
     * 分页查询
     * @param statementId
     * @param value
     * @param offset
     * @param limit
     * @return
     */
     Object queryLimitBySql(String statementId, Object value, int offset,
								  int limit);

	/**
	 * 分页查询
	 *
	 * @param statementId
	 * @param params
	 * @param page
	 * @return
	 */
	Page queryForPage(String statementId, Object params, Page page);
	/**
	 * 此方法描述的是： 通过MyBatis进行新建操作
	 * 
	 * 
	 * @version: 2012-4-17 下午3:50:53
	 */
	public Object createBySql(String statementId, Object value);

	/**
	     * 此方法描述的是： 通过MyBatis进行删除操作
	     * 
	     * @version: 2012-4-17 下午3:51:50
	 */
	public int deleteBySql(String statementId, Object value);

	/**
	     * 此方法描述的是： 通过MyBatis 更新
	     * 
	     * @version: 2012-4-17 下午3:52:10
	 */
	public int updateBySql(String statementId, Object value);


	/**
	 * 通过jdbc模板执行数据更新操作(包含：插入、更新、删除)
	 * @param sql:sql语句
	 * @param paramMap:参数
	 * @return
	 */
	public int update(String sql,Map<String,Object> paramMap);
	
	/**
	 * 列表查询
	 * @param sql
	 * @param paramMap
	 * @return
	 * 
	 */
	public  List<Map<String,Object>> sqlQueryForList(String sql, Map<String, Object> paramMap);
	
	/**
	 * 列表查询
	 * @param sql
	 * @param paramMap
	 * @param rowMapper
	 * @return
	 *
	 */
	public <T> List<T> sqlQueryForList(String sql, Map<String, ?> paramMap, RowMapper<T> rowMapper);
	/**
	 * 
	 * @param <T>
	 * @param sql
	 * @param rowMapper
	 * @return
	 */
	public <T> List<T> sqlQueryForList(String sql,RowMapper<T> rowMapper);

	/**
	 * 列表查询
	 * @param sql
	 * @param paramMap
	 * @param clazz 对应的POJO的CLASS 
	 * @return
	 * 
	 */
	public <T> List<T> sqlQueryForList(String sql, Map<String, ?> paramMap, Class<T> clazz);
	
	  /**
     * 单记录查询,返回字段名为主键的MAP
     * 
     * @param queryStr
     *            查询sql
     * @return Map
     */
    @SuppressWarnings("rawtypes")
	public Map sqlQueryForMap(String queryStr);
    
    /**
     * 单值查询
     * 
     * @param queryStr
     *            查询sql
     * @return 字符串
     */
    public String sqlQueryForValue(String queryStr) ;
    
    /**
     * 单值查询
     * 
     * @param queryStr
     *            查询sql
     * @param params
     *            查询参数
     * @return 字符串
     * 
     */
    @SuppressWarnings("rawtypes")
	public String sqlQueryForValue(String queryStr, Map params);
    
    /**
     * 
     * @param <T>
     * @param queryStr
     * @param params
     * @param rowMapper
     * @return
     */
    public <T> Object sqlQueryForObject(String queryStr,Map<String,?> params,RowMapper<T> rowMapper);
	
    /**
     * 单记录查询,返回字段名为主键的MAP
     * 
     * @param queryStr
     *            查询sql
     * @param params
     *            查询参数
     * @return Map
     * 
     */
    public  Map<String,Object> sqlQueryForMap(String sql, Map <String,Object> paramMap);
    /**
     * @param sql
     *            查询sql
     * @return 查询结果对象分页列表
     * 
     */
    public  Page sqlQueryForPage(String sql, Page pageInfo);


    /**
     * 
     * @param sql
     * @param pageInfo
     * @param rowMapper：每一项的构造对象
     * @return 查询结果对象分页列表
     *
     */
    public <T> Page sqlQueryForPage(String sql, Page pageInfo,RowMapper<T> rowMapper);
    
    /**
     * 分页查询
     * @param sql
     * @param pageInfo
     * @param clazz：对应的POJO的CLASS
     * @return
     *
     */
    public <T> Page sqlQueryForPage(String sql, Page pageInfo,Class<T> clazz);
    
    /**
     * @param sql
     *            查询sql
     * @param pageInfo
     *            分页条件
     * @return 查询结果对象分页列表
     * 
     */
    public <T> Page sqlQueryForPage(String sql, Map<String, ?> params, Page pageInfo);
    
    /**
     * @param sql
     *            查询sql
     * @param params
     *            查询参数
     * @param pageInfo
     *            分页条件
     * @return 查询结果对象分页列表
	 *
     */
	
	public <T> Page sqlQueryForPage(String sql, Map<String, ?> params, Page pageInfo,RowMapper<T> rowMapper);
	
	/**
	 * 
	 * @param sql
	 * @param params
	 * @param pageInfo
	 * @param clazz 对应的POJO 的class
	 * @return
	 *
	 */
	public <T> Page sqlQueryForPage(String sql, Map<String, ?> params, Page pageInfo,Class<T> clazz);
	
	
	public <X> X findUnique(String hql,Object... values);

	public void flush();

	public void clear();

	public void evict(Object obj);

    public <X> List<X> find(String hql, Map<String, ?> values);

    public Page findByPage(Page page,String hql,Map<String,?> params);

}
