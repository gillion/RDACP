package cn.cst.kcgl.common.dao.impl;

import cn.com.xcs.framework.persist.Page;
import cn.com.xcs.framework.persist.jdbc.dao.JdbcDao;
import cn.com.xcs.framework.persist.orm.HibernateDao;
import cn.cst.kcgl.common.dao.BaseDao;
import cn.cst.kcgl.common.dao.MyBatisDao;
import cn.cst.kcgl.common.utils.PageUtils;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 *
 * 此注解描述的是： @SuppressWarnings 通过注解屏蔽编译时警告 deprecation :使用了过时的类或方法时的警告 unchecked
 * : 执行了未检查的转换时的警告，例如当使用集合时没有用 泛型(Generics) 来指定集合保存的类型 fallthrough : 当Switch
 * 程序块直接通往下一种情况而没有Break 时的警告 path : 在类路径、源文件路径等中有不存在的路径是的警告 serial :
 * 当在可序列化的类上缺少serialVersionUID定义时的警告 finally : 任何finally子句不能正常完成时的警告 all :
 * 关于上述所有情况的警告 rawtypes ： 传递参数时也要检查泛型参数
 *
 *
 * @version: 2012-4-17 下午4:12:55
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Repository("baseDAO")
// 注解声明bean托管
public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T,PK> {

    @Resource(name="pageHibernateDao")
	private HibernateDao<T, Serializable> pageHibernateDao;

	@Resource(name = "myBatisDAO")
	private MyBatisDao<T, Serializable> myBatisDao;

	@Resource
	private JdbcDao jdbcDao;

	public JdbcDao getJdbcDao() {
		return jdbcDao;
	}

	public void setJdbcDao(JdbcDao jdbcDao) {
		this.jdbcDao = jdbcDao;
	}

	@Override
	public void save(final T entity) {
		this.pageHibernateDao.save(entity);
	}

	@Override
	public void merge(final T entity){
		this.pageHibernateDao.merge(entity);
	}

	@Override
	public void delete(final T entity) {
		this.pageHibernateDao.delete(entity);
	}

	@Override
	public void delete(final PK id) {
		this.pageHibernateDao.delete(id);
	}

	@Override
	public T get(Class clz,PK id) {
		return (T)this.pageHibernateDao.getSession().get(clz,id);
	}


	@Override
	public List<T> getAll() {
		return this.pageHibernateDao.find();
	}



	/**
	 * 此方法描述的是： 通过MyBatis查询单个记录或单个值
	 *
	 *
	 * @version: 2012-4-17 下午3:49:50
	 */
	@Override
	public Object queryOneBySql(String statementId, Object value){
		return this.myBatisDao.queryOneBySql(statementId, value);
	}

    /**
     * 查询
     * @param statementId
     * @param value
     * @return
     */
	@Override
    public Object queryBySql(String statementId, Object value){
		return this.myBatisDao.queryBySql(statementId, value);
	}

    /**
     * 分页查询
     * @param statementId
     * @param value
     * @param offset
     * @param limit
     * @return
     */
	@Override
    public Object queryLimitBySql(String statementId, Object value, int offset,
								  int limit){
		return this.myBatisDao.queryLimitBySql(statementId, value, offset, limit);
	}

	/**
	 * 分页查询
	 *
	 * @param statementId
	 * @param params
	 * @param page
	 * @return
	 */
	@Override
	public Page queryForPage(String statementId, Object params, Page page) {
		PageUtils.setContextPage(page);
		PageUtils.setContextNeedPage(true);
		Integer offset = (page.getPageIndex() - 1) * page.getPageSize();
		List list = (List) this.queryLimitBySql(statementId, params, offset, page.getPageSize());
		page.setDataList(list);
		return page;
	}

	/**
	 * 此方法描述的是： 通过MyBatis进行新建操作
	 *
	 *
	 * @version: 2012-4-17 下午3:50:53
	 */
	@Override
	public Object createBySql(String statementId, Object value){
		return this.myBatisDao.createBySql(statementId, value);
	}

	/**
	     * 此方法描述的是： 通过MyBatis进行删除操作
	     *
	     * @version: 2012-4-17 下午3:51:50
	 */
	@Override
	public int deleteBySql(String statementId, Object value){
		return this.myBatisDao.deleteBySql(statementId, value);
	}

	/**
	     * 此方法描述的是： 通过MyBatis 更新
	     *
	     * @version: 2012-4-17 下午3:52:10
	 */
	@Override
	public int updateBySql(String statementId, Object value){
		return this.myBatisDao.updateBySql(statementId, value);
	}


	@Override
	public int update(String sql, Map<String, Object> paramMap) {
		int count =  this.jdbcDao.getNamedParameterJdbcTemplate().update(sql,paramMap);
		return count;
	}

	/**
	 * 列表查询
	 * @param sql
	 * @param paramMap
	 * @return
	 *
	 */
	@Override
	public  List<Map<String,Object>> sqlQueryForList(String sql, Map<String, Object> paramMap) {
		return this.jdbcDao.sqlQueryForList(sql, paramMap);
	}

	/**
	 * 列表查询
	 * @param sql
	 * @param paramMap
	 * @param rowMapper
	 * @return
	 *
	 */
	@Override
	public <T> List<T> sqlQueryForList(String sql, Map<String, ?> paramMap, RowMapper<T> rowMapper){
		return this.jdbcDao.sqlQueryForList(sql, paramMap, rowMapper);
	}
	/**
	 *
	 * @param <T>
	 * @param sql
	 * @param rowMapper
	 * @return
	 */
	@Override
	public <T> List<T> sqlQueryForList(String sql,RowMapper<T> rowMapper){
		return this.jdbcDao.sqlQueryForList(sql, rowMapper);
	}

	/**
	 * 列表查询
	 * @param sql
	 * @param paramMap
	 * @param clazz 对应的POJO的CLASS
	 * @return
	 *
	 */
	@Override
	public <T> List<T> sqlQueryForList(String sql, Map<String, ?> paramMap, Class<T> clazz){
		return this.jdbcDao.sqlQueryForList(sql, paramMap, clazz);
	}

	  /**
     * 单记录查询,返回字段名为主键的MAP
     *
     * @param queryStr
     *            查询sql
     * @return Map
     */
	@Override
	public Map sqlQueryForMap(String queryStr){
		return this.jdbcDao.sqlQueryForMap(queryStr);
	}

    /**
     * 单值查询
     *
     * @param queryStr
     *            查询sql
     * @return 字符串
     */
	@Override
    public String sqlQueryForValue(String queryStr){
		return this.jdbcDao.sqlQueryForValue(queryStr);
	}

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
	@Override
	public String sqlQueryForValue(String queryStr, Map params){
		return this.jdbcDao.sqlQueryForValue(queryStr, params);
	}

    /**
     *
     * @param <T>
     * @param queryStr
     * @param params
     * @param rowMapper
     * @return
     */
	@Override
    public <T> Object sqlQueryForObject(String queryStr,Map<String,?> params,RowMapper<T> rowMapper){
		return this.jdbcDao.sqlQueryForObject(queryStr, params, rowMapper);
	}

    /**
     * 单记录查询,返回字段名为主键的MAP
     *
     * @param sql
     *            查询sql
     * @param paramMap
     *            查询参数
     * @return Map
     *
     */
	@Override
    public  Map<String,Object> sqlQueryForMap(String sql, Map <String,Object> paramMap){
		return this.jdbcDao.sqlQueryForMap(sql, paramMap);
	}
    /**
     * @param sql
     *            查询sql
     * @return 查询结果对象分页列表
     *
     */
	@Override
    public  Page sqlQueryForPage(String sql, Page pageInfo){
		return this.jdbcDao.sqlQueryForPage(sql, pageInfo);
	}


    /**
     *
     * @param sql
     * @param pageInfo
     * @param rowMapper：每一项的构造对象
     * @return 查询结果对象分页列表
     *
     */
	@Override
    public <T> Page sqlQueryForPage(String sql, Page pageInfo,RowMapper<T> rowMapper){
		return this.jdbcDao.sqlQueryForPage(sql, pageInfo, rowMapper);
	}

    /**
     * 分页查询
     * @param sql
     * @param pageInfo
     * @param clazz：对应的POJO的CLASS
     * @return
     *
     */
	@Override
    public <T> Page sqlQueryForPage(String sql, Page pageInfo,Class<T> clazz){
		return this.jdbcDao.sqlQueryForPage(sql, pageInfo, clazz);
	}

    /**
     * @param sql
     *            查询sql
     * @param pageInfo
     *            分页条件
     * @return 查询结果对象分页列表
     *
     */
	@Override
    public <T> Page sqlQueryForPage(String sql, Map<String, ?> params, Page pageInfo){
		return this.jdbcDao.sqlQueryForPage(sql, params, pageInfo);
	}

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
	@Override
	public <T> Page sqlQueryForPage(String sql, Map<String, ?> params, Page pageInfo,RowMapper<T> rowMapper){
		return this.jdbcDao.sqlQueryForPage(sql, params, pageInfo, rowMapper);
	}

	@Override
	public void evict(Object obj) {
		this.pageHibernateDao.getSession().evict(obj);
	}

	@Override
	public void clear() {
		this.pageHibernateDao.getSession().clear();
	}

	/**
	 *
	 * @param sql
	 * @param params
	 * @param pageInfo
	 * @param clazz 对应的POJO 的class
	 * @return
	 *
	 */
	@Override
	public <T> Page sqlQueryForPage(String sql, Map<String, ?> params, Page pageInfo,Class<T> clazz){
		return this.jdbcDao.sqlQueryForPage(sql, params, pageInfo, clazz);
	}

	@Override
	public <X> X findUnique(String hql,Object... values){
		return (X)this.pageHibernateDao.findUnique(hql,values);
	}

	@Override
	public void flush() {
		this.pageHibernateDao.flush();
	}

    @Override
    public Page findByPage(Page page, String hql, Map<String, ?> params) {
        return this.pageHibernateDao.findByPage(page, hql, params);
    }

    @Override
    public <X> List<X> find(String hql, Map<String, ?> values) {
        return this.pageHibernateDao.find(hql,values);
    }

    public HibernateTemplate getHibernateTemplate() {
        return this.pageHibernateDao.getHibernateTemplate();
    }
}
