package com.avalon.dao;

/**
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @类名: MyBatisDao
 * @功能描述:持久化操作基类--SqlSessionDaoSupport是mybatis-spring插件中封装的 用于获得SQL Session连接，执行数据库操作
 * @类创建人: H-BOY
 * @类创建时间： 2013-8-14 上午10:00:27
 */
@Repository
public class MyBatisDao<T> extends SqlSessionDaoSupport {

    @Resource  
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){  
        super.setSqlSessionFactory(sqlSessionFactory);  
    } 
    /**
     * 
     * @方法名: add
     * @功能描述: 新增
     * @param sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @param T entity
     * @return List<T>
     * @throws Exception
     * @创建人: H-BOY
     * @创建时间： 2013-8-14 上午10:01:23
     */
    public boolean add(String sqlId, T entity) throws Exception {
        boolean flag = false;
        try {
            
            flag = this.getSqlSession().insert(sqlId, entity) > 0 ? true : false;
            
            if(flag){
            }
            
        } catch (Exception e) {
            flag = false;
            throw e;
        }
        return flag;
    }

    /**
     * 
     * @方法名: edit
     * @功能描述: 编辑
     * @param String sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @param T entity
     * @return boolean
     * @throws Exception
     * @创建人: H-BOY
     * @创建时间： 2013-8-14 上午10:05:20
     */
    public boolean edit(String sqlId, T entity) throws Exception {
        boolean flag = false;
        try {
            //如果更新0条数据是正确的，不能返回false
//          flag = this.getSqlSession().update(sqlId, entity) > 0 ? true : false;
            flag = this.getSqlSession().update(sqlId, entity) >= 0 ? true : false;
        } catch (Exception e) {
            flag = false;
            throw e;
        }
        return flag;
    }
    
    public boolean edit2(String sqlId, T entity) throws Exception {
        boolean flag = false;
        try {
            //如果更新0条数据是正确的，不能返回false
//          flag = this.getSqlSession().update(sqlId, entity) > 0 ? true : false;
            flag = this.getSqlSession().update(sqlId, entity) > 0 ? true : false;
        } catch (Exception e) {
            flag = false;
            throw e;
        }
        return flag;
    }

    /**
     * 
     * @方法名: get
     * @功能描述: 获取单条数据
     * @param String sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @param T entity
     * @return T
     * @throws Exception  
     * @创建人: H-BOY
     * @创建时间： 2013-8-14 上午10:10:24
     */
    @SuppressWarnings("unchecked")
    public T get(String sqlId, T entity) throws Exception {
        T result = null;
        try {
            result = (T) this.getSqlSession().selectOne(sqlId, entity);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public T get(String sqlId, String entity) throws Exception {
        T result = null;
        try {
            result = (T) this.getSqlSession().selectOne(sqlId, entity);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    @SuppressWarnings("unchecked")
    public Map getDetail(String sqlId, T entity) throws Exception {
        Map map = null;
        try {
            map = (Map) this.getSqlSession().selectOne(sqlId, entity);
        } catch (Exception e) {
            throw e;
        }
        return map;
    }
    
    /**
     * 获取分页list
     * @param classMethod
     * @param map
     * @param offset 开始位置
     * @param limit 数量
     * @return List<T>
     */
    public List<T> getAllByEntity(String classMethod, T entity, int offset,int limit) throws Exception {
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<T> result = new ArrayList<T>();
        try {
            result = this.getSqlSession().selectList(classMethod, entity, rowBounds);
            
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    /**
     * 
     * @方法名: getAll
     * @功能描述: 查询所有
     * @param String sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @return List<T>
     * @throws Exception  
     * @创建人: H-BOY
     * @创建时间： 2013-8-14 上午10:12:14
     */
    public List<T> getAll(String sqlId) throws Exception {
        List<T> result = new ArrayList<T>();
        try {
            result = this.getSqlSession().selectList(sqlId);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
    /**
     * 
     * @方法名: getAllByEntity
     * @功能描述: 查询结果集 
     * @param String sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @param T entity
     * @return List<T>
     * @throws Exception  
     * @创建人: H-BOY
     * @创建时间： 2013-8-14 上午10:12:34
     */
    public List<T> getAllByEntity(String sqlId,T entity) throws Exception {
        List<T> result = new ArrayList<T>();
        try {
            result = this.getSqlSession().selectList(sqlId,entity);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
    public List<T> getAllByEntity(String sqlId,String entity) throws Exception {
        List<T> result = new ArrayList<T>();
        try {
            result = this.getSqlSession().selectList(sqlId,entity);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    
    /**
     * 
     * @方法名: getAllByEntityExt
     * @功能描述: 查询结果集 - 参数是实体对象 结果集是Map
     * @param String sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @param T entity
     * @return List<Map<String, Object>>
     * @throws Exception 
     * @创建人: H-BOY
     * @创建时间： 2013-8-14 上午10:12:41
     */
    public List<Map<String, Object>> getAllByEntityExt(String sqlId,T entity) throws Exception {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        try {
            result = this.getSqlSession().selectList(sqlId, entity);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
    /**
     * 
     * @方法名: getAllByMap
     * @功能描述:查询结果集 - 参数 和 返回结果均用Map
     * @param String sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @param Map<String, Object> entity
     * @return List<Map<String, Object>>
     * @throws Exception 
     * @创建人: H-BOY
     * @创建时间： 2013-8-14 上午10:12:51
     */
    public List<Map<String, Object>> getAllByMap(String sqlId,Map<String, Object> entity) throws Exception {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        try {
            result = this.getSqlSession().selectList(sqlId, entity);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
    /**
     * 
     * @方法名: getCountByMap
     * @功能描述: 查询总数 - 参数Map对象
     * @param String sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @param Map<String, Object> entity
     * @return int
     * @throws Exception 
     * @创建人: H-BOY
     * @创建时间： 2013-8-14 上午10:12:57
     */
    public int getCountByMap(String sqlId, Map<String, Object> entity)throws Exception {
        int count = 0;
        try {
            count = this.getSqlSession().selectOne(sqlId, entity);
        } catch (Exception e) {
            throw e;
        }
        return count;
    }

    /**
     * 
     * @方法名: remove
     * @功能描述: 删除
     * @param String sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @param T entity
     * @return boolean
     * @throws Exception 
     * @创建人: H-BOY
     * @创建时间： 2013-8-14 上午10:13:03
     */
    public boolean remove(String sqlId, T entity) throws Exception {
        boolean flag = false;
        try {
            //如果删除0条数据是正确的，不能返回false
//            flag = this.getSqlSession().delete(sqlId, entity) > 0 ? true : false;
            flag = this.getSqlSession().delete(sqlId, entity) >= 0 ? true : false;
        } catch (Exception e) {
            flag = false;
            throw e;
        }
        return flag;
    }

    /**
     * 
     * @方法名: getAllByPage
     * @功能描述: MyBatis3基于内存分页 - 舍弃不用
     * @param String sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @param T entity
     * @param int offset - 分页起始页码
     * @param int limit - 每页显示多少条
     * @return List<T>
     * @throws Exception
     * @创建人: H-BOY
     * @创建时间： 2013-8-14 上午10:13:09
     */
    public List<T> getAllByPage(String sqlId, T entity, int offset,int limit) throws Exception {
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<T> result = new ArrayList<T>();
        try {
            result = this.getSqlSession().selectList(sqlId, entity, rowBounds);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
    /**
     * @方法名: getAllByString 
     * @功能描述: 根据一个String类型的参数查询 
     * @param String sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @param String strr
     * @return List<T>
     * @throws Exception
     * @创建人：H-BOY
     * @创建时间： 2013-5-17 下午01:59:23 
     */
    public List<T> getAllByString(String sqlId, String str) throws Exception {
        List<T> result = new ArrayList<T>();
        try {
            result = this.getSqlSession().selectList(sqlId, str);
        } catch (Exception e) {
            throw e;
        }
        return result;
        
    }

    /**
     * 
     * @方法名: getAllCount
     * @功能描述: 查询总数 - 实体对象接收参数
     * @param String sqlId - Sqlmap.xml里面的： 命名空间.SqlId,如：mmRoleMapper.insert
     * @param T entity
     * @return int
     * @throws Exception
     * @创建人: H-BOY
     * @创建时间： 2013-8-14 上午10:13:20
     */
    public int getAllCount(String sqlId, T entity)throws Exception {
        int count = 0;
        try {
            count = this.getSqlSession().selectOne(sqlId, entity);
        } catch (Exception e) {
            throw e;
        }
        return count;
    }
    
}

