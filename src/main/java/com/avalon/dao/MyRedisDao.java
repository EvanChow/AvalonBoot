package com.avalon.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisListCommands.Position;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyRedisDao {
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    /**
     * 
     * @方法名: add
     * @功能描述: 设置指定 key 的值
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 2:37:58 PM
     */
    public boolean set(final byte[] k,final byte[] v){
        boolean result=redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(k,v);
                return true;
            }
          });
        return result;
    }
    
    /**
     * 
     * @方法名: get
     * @功能描述: 获取指定 key 的值。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 2:42:27 PM
     */
    public String get(final byte[] k){
        String result=redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] v=connection.get(k);
                return new String(v);
            }
          });
        return result;
    }
    
    /**
     * 
     * @方法名: get
     * @功能描述: 返回 key 中字符串值的子字符
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 2:45:33 PM
     */
    public String getRange(final byte[] k,final long begin,final long end){
        String result=redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] v=connection.getRange(k, begin, end);
                return new String(v);
            }
          });
        return result;
    }
    
    /**
     * 
     * @方法名: get
     * @功能描述: 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 2:49:01 PM
     */
    public String getSet(final byte[] k,final byte[] v){
        String result=redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] v1=connection.getSet(k, v);
                return new String(v1);
            }
          }); 
        return result;
    }
    
    /**
     * 
     * @方法名: get
     * @功能描述: 对 key 所储存的字符串值，获取指定偏移量上的位(bit)。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 2:55:26 PM
     */
    public Boolean getBit(final byte[] k,final long offset){
        Boolean result=redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.getBit(k, offset);
            }
          }); 
        return result;
    }
    
    /**
     * 
     * @方法名: get
     * @功能描述: 获取所有(一个或多个)给定 key 的值。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 2:58:25 PM
     */
    public List<byte[]> mGet(final byte[]... keys){
        List<byte[]> result=redisTemplate.execute(new RedisCallback<List<byte[]>>() {
            @Override
            public List<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                return  connection.mGet(keys);
            }
          }); 
        return result;
    }
    
    /**
     * 
     * @方法名: set
     * @功能描述: 对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:03:58 PM
     */
    public void setBit(final byte[] k,final long offset,final boolean v){
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                 connection.setBit(k,offset,v);
                 return true;
            }
          }); 
    }
    
    /**
     * 
     * @方法名: set
     * @功能描述: 将值 value 关联到 key ，并将 key 的过期时间设为 seconds (以秒为单位)。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:05:41 PM
     */
    public void setEx(final byte[] k,final long seconds,final byte[] v){
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                 connection.setEx(k, seconds, v);
                 return true;
            }
          }); 
    }
    
    /**
     * 
     * @方法名: set
     * @功能描述: 只有在 key 不存在时设置 key 的值。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:08:11 PM
     */
    public Boolean setNX(final byte[] k,final byte[] v){
        Boolean result=redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(k,v);
            }
          }); 
        return result;
    }
    /**
     * 
     * @方法名: set
     * @功能描述: 用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:10:10 PM
     */
    public void setRange(final byte[] k,final byte[] v,final long offset){
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setRange(k, v, offset);
                return true;
            }
       }); 
    }
    
    /**
     * 
     * @方法名: length
     * @功能描述: 返回 key 所储存的字符串值的长度。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:13:12 PM
     */
    public long strLen(final byte[] k){
        long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.strLen(k);
            }
        }); 
        return result;
    }
    
    /**
     * 
     * @方法名: set
     * @功能描述: 同时设置一个或多个 key-value 对。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:15:48 PM
     */
    public void mSet(final Map<byte[],byte[]> map){
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.mSet(map);
                return true;
            }
       }); 
    }
    
    /**
     * 
     * @方法名: setNX
     * @功能描述: 同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:17:37 PM
     */
    public void mSetNX(final Map<byte[],byte[]> map){
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.mSetNX(map);
                return true;
            }
       }); 
    }
    
    /**
     * 
     * @方法名: incr
     * @功能描述: 将 key 中储存的数字值增一。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:21:54 PM
     */
    public Long incr(final byte[] k){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.incr(k);
            }
       });
        return result;
    }
    /**
     * 
     * @方法名: incr
     * @功能描述:将 key 所储存的值加上给定的增量值（increment） 。 
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:26:37 PM
     */
    public Long incrBy(final byte[] k,final long v){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.incrBy(k,v);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: deCR
     * @功能描述: 将 key 中储存的数字值减一。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:29:15 PM
     */
    public Long decr(final byte[] k){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.decr(k);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: deCR
     * @功能描述:key 所储存的值减去给定的减量值（decrement） 。 
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:29:25 PM
     */
    public Long decrBy(final byte[] k,final long v){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.decrBy(k,v);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: append
     * @功能描述: 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:31:51 PM
     */
    public Long append(final byte[] k,final byte[] v){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.append(k, v);
            }
          }); 
        return result;
    }
    
  //***********************************************************************************************************//
  //***********************************************************************************************************//
  //*****************************************HashMap 方法******************************************************//
  //***********************************************************************************************************//
  //***********************************************************************************************************//
  //***********************************************************************************************************//
  //***********************************************************************************************************//
    
    /**
     * 
     * @方法名: del
     * @功能描述: 删除一个或多个哈希表字段
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:45:21 PM
     */
    public Long hDel(final byte[] k,final byte[] f){
    	Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.hDel(k, f);
            }
          }); 
        return result;
    }
    
    /**
     * 
     * @方法名: exis
     * @功能描述: 查看哈希表 key 中，指定的字段是否存在。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:48:24 PM
     */
    public Boolean  hExists(final byte[] k,final byte[] f){
        Boolean result=redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.hExists(k,f);
            }
          }); 
        return result;
    } 
    /**
     * 
     * @方法名: hGet
     * @功能描述: 获取存储在哈希表中指定字段的值。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:50:22 PM
     */
    public byte[] hGet(final byte[] k,final byte[] f){
        byte[] result=redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.hGet(k, f);
            }
          }); 
        return result;
    }
    
    /**
     * 
     * @方法名: hGetAll
     * @功能描述: 获取在哈希表中指定 key 的所有字段和值
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:52:27 PM
     */
    public Map<byte[], byte[]> hGetAll(final byte[] k){
        Map<byte[], byte[]> result=redisTemplate.execute(new RedisCallback<Map<byte[], byte[]>>() {
            @Override
            public Map<byte[], byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.hGetAll(k);
            }
          }); 
        return result;
    }
    
    /**
     * 
     * @方法名: hINCR
     * @功能描述: 为哈希表 key 中的指定字段的整数值加上增量 increment 。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:58:22 PM
     */
    public Long hIncrBy(final byte[] k,final byte[] f,final long v){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hIncrBy(k, f, v);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: getKeys
     * @功能描述: 获取哈希表中所有的字段
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 3:59:48 PM
     */
    public Set<byte[]> hKeys(final byte[] k){
        Set<byte[]> result=redisTemplate.execute(new RedisCallback<Set<byte[]>>() {
            @Override
            public Set<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hKeys(k);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: hlength
     * @功能描述: 获取哈希表中字段的数量
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:02:04 PM
     */
    public Long hLen(final byte[] k){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hLen(k);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: hGet
     * @功能描述: 获取所有给定字段的值
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:08:33 PM
     */
    public List<byte[]> hMGet(final byte[] k,final byte[]... f){
        List<byte[]> result=redisTemplate.execute(new RedisCallback<List<byte[]>>() {
            @Override
            public  List<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hMGet(k,f);
            }
       });
        return result;
    }
    /**
     * 
     * @方法名: hSet
     * @功能描述: 同时将多个 field-value (域-值)对设置到哈希表 key 中。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:10:56 PM
     */
    public Boolean hMSet(final byte[] k,final Map<byte[],byte[]> hs){
        Boolean result=redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                 connection.hMSet(k, hs);
                 return true;
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: hSet
     * @功能描述: 将哈希表 key 中的字段 field 的值设为 value 。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:13:34 PM
     */
    public Boolean hSet(final byte[] k,final byte[] f,final byte[] v){
        Boolean result=redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.hSet(k, f, v);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: hSetNX
     * @功能描述: 只有在字段 field 不存在时，设置哈希表字段的值。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:14:33 PM
     */
    public Boolean hSetNX(final byte[] k,final byte[] f,final byte[] v){
        Boolean result=redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.hSetNX(k, f, v);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: hVals
     * @功能描述: 获取哈希表中所有值
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:16:01 PM
     */
    public List<byte[]> hVals(final byte[] k){
        List<byte[]> result=redisTemplate.execute(new RedisCallback<List<byte[]>>() {
            @Override
            public List<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.hVals(k);
            }
       });
        return result;
    }
    
    //***********************************************************************************************************//
    //***********************************************************************************************************//
    //*****************************************List 方法*********************************************************//
    //***********************************************************************************************************//
    //***********************************************************************************************************//
    //***********************************************************************************************************//
    //***********************************************************************************************************//
    
    /**
     * 
     * @方法名: bLPop
     * @功能描述: 移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:16:01 PM
     */
    public List<byte[]> bLPop(final int timeout,final byte[]... k){
        List<byte[]> result=redisTemplate.execute(new RedisCallback<List<byte[]>>() {
            @Override
            public List<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.bLPop(timeout,k);
            }
       });
        return result;
    }
    
    /**
     * 
     * 
     * @方法名: bRPop
     * @功能描述: 移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:31:01 PM
     */
    public List<byte[]> bRPop(final int timeout,final byte[]... k){
        List<byte[]> result=redisTemplate.execute(new RedisCallback<List<byte[]>>() {
            @Override
            public List<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.bRPop(timeout, k);
            }
       });
        return result;
    }
    
   /**
    * 
    * @方法名: bRPopLPush
    * @功能描述: 从列表中弹出一个值，将弹出的元素插入到另外一个列表中并返回它； 
    * 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
    * @参数：@param
    * @返回：@return
    * @创建人: Evan
    * @创建时间： Apr 20, 2017 4:32:58 PM
    */
    public byte[] bRPopLPush(final int timeout,final byte[] k1,final byte[] k2){
        byte[] result=redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.bRPopLPush(timeout, k1, k2);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: lIndex
     * @功能描述: 获取列表长度
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:34:57 PM
     */
    public byte[] lIndex(final byte[] k,final long index){
        byte[] result=redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.lIndex(k, index);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: lInsert
     * @功能描述: 在列表的元素前或者后插入元素
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:39:25 PM
     */
    public Long lInsert(final byte[] k,final Position where,final byte[] p,final byte[] v){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.lInsert(k, where, p, v);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: lLen
     * @功能描述: 获取列表长度
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:40:10 PM
     */
    public Long lLen(final byte[] k){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.lLen(k);
            }
       });
        return result;
    }
    
    
    /**
     * 
     * @方法名: lPop
     * @功能描述: 移出并获取列表的第一个元素
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:37:05 PM
     */
    public byte[] lPop(final byte[] k){
        byte[] result=redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.lPop(k);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: lPush
     * @功能描述: 将一个或多个值插入到列表头部
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:41:34 PM
     */
    public Long lPush(final byte[] k,final byte[] v){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.lPush(k, v);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: lPushX
     * @功能描述: 将一个或多个值插入到已存在的列表头部
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:43:10 PM
     */
    public Long lPushX(final byte[] k,final byte[] v){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.lPushX(k, v);
            }
       });
        return result;
    }
    
    /**
     * 
     * @方法名: lRange
     * @功能描述: 分页获取列表
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 21, 2017 3:24:10 PM
     */
    public List<byte[]> lRange(final byte[] k, final long begin,final long end){
        List<byte[]> result=redisTemplate.execute(new RedisCallback<List<byte[]>>() {
            @Override
            public List<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.lRange(k, begin, end);
            }
       });
        return result;
    }
    
    
    
    
    
    /**
     * 
     * @方法名: del
     * @功能描述: 删除
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： Apr 20, 2017 4:51:17 PM
     */
    public Long del(final byte[]... k){
        Long result=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.del(k);
            }
       });
        return result;
    }
    
    
}
