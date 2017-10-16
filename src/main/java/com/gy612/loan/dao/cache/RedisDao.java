
package com.gy612.loan.dao.cache;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.Remind;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis的数据访问对象
 * @author K550J
 *
 */
public class RedisDao {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//操作Redis的Connection
	private final JedisPool jedisPool;
	
	//自定义序列化，Protostuff的SeckillEntity序列化schema模式,按照其模式进行 序列化/反序列化
	private RuntimeSchema<Integer> schema = RuntimeSchema.createFrom(Integer.class);
	
	private RuntimeSchema<CacheEntry> cacheSchema =  RuntimeSchema.createFrom(CacheEntry.class);
	
	public RedisDao(String ip, int port){
		jedisPool = new JedisPool(ip,port);//初始化Jedis对象，连接Redis
	}
	
	/**
	 * 在Redis中拿到Integer对象
	 * 过程:byte[]---(schema)--->Object
	 * @param seckillId
	 * @return
	 */
	public Integer getRemindsCount(String key){
		//redis逻辑操作
		try{
			//jedis类似于session,jedisPool类似于Connection
			Jedis jedis = jedisPool.getResource();
			try{
				//String key = "seckillEntity:"+seckillId;
				/*redis并没有实现内部序列化操作
				//get->byte[]->反序列化操作->Object(SeckillEntity)(需要一个schema去做反序列操作把btye[]数组转化为对象)
				 *采用自定义序列化(protostuff的序列化对比于原生序列化,
				 *               空间压缩到1/5,速度快2个数量级) 
				*/
				byte[] bytes = jedis.get(key.getBytes());
				//缓存获取到
				if(bytes!=null){
					//空对象
					Integer remindsCount =schema.newMessage();
					//相当于放入 数据，骨架，转换规则 进行反序列化到骨架中
					ProtostuffIOUtil.mergeFrom(bytes,remindsCount,schema);
					return remindsCount;
				}
			}finally{
				//关闭redis连接
				jedis.close();
			}
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null; 
	}

	/**
	 * 向Redis中缓存Integer对象
	 * 过程:Object---(schema)--->byte[]
	 * @param seckillEntity
	 * @return
	 */
	public String putRemindsCount(Integer remindsCount,String key){
		//redis逻辑操作
		try{
			Jedis jedis = jedisPool.getResource();
			try{
				//set->Object(SeckillEntity)->序列化->byte[]
				//String key = "seckillEntity:"+seckillEntity.getSeckillId();
				
				/*构建存储byte数组数据:利用protostuff的schema模序列化pojo对象
				 * LinkedBuffer是缓存器，在pojo对象过大时进行缓存序列化
				*/
				byte[] bytes = ProtostuffIOUtil.toByteArray(remindsCount,schema,
						LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				//超时缓存(缓存过多久会失效，单位:秒)
				String result = jedis.setex(key.getBytes(),60,bytes);
				return result;
			}finally{
				jedis.close();
			}
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null; //TODO
	}
	
	
	/**
	 * 在Redis中拿到List<Remind>对象
	 * 过程:byte[]---(schema)--->Object
	 * @param seckillId
	 * @return
	 */
	public CacheEntry<Remind> getReminds(String key){
		//redis逻辑操作
		try{
			//jedis类似于session,jedisPool类似于Connection
			Jedis jedis = jedisPool.getResource();
			try{
				//String key = "seckillEntity:"+seckillId;
				/*redis并没有实现内部序列化操作
				//get->byte[]->反序列化操作->Object(SeckillEntity)(需要一个schema去做反序列操作把btye[]数组转化为对象)
				 *采用自定义序列化(protostuff的序列化对比于原生序列化,
				 *               空间压缩到1/5,速度快2个数量级) 
				*/
				byte[] bytes = jedis.get(key.getBytes());
				//缓存获取到
				if(bytes!=null){
					//空对象
					CacheEntry<Remind> reminds =cacheSchema.newMessage();
					//相当于放入 数据，骨架，转换规则 进行反序列化到骨架中
					ProtostuffIOUtil.mergeFrom(bytes,reminds,cacheSchema);
					return reminds;
				}
			}finally{
				//关闭redis连接
				jedis.close();
			}
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null; 
	}
	
	/**
	 * 向Redis中缓存List<Remind>对象
	 * 过程:Object---(schema)--->byte[]
	 * @param seckillEntity
	 * @return
	 */
	public String putReminds(CacheEntry<Remind> reminds,String key){
		//redis逻辑操作
		try{
			Jedis jedis = jedisPool.getResource();
			try{
				//set->Object(SeckillEntity)->序列化->byte[]
				//String key = "seckillEntity:"+seckillEntity.getSeckillId();
				
				/*构建存储byte数组数据:利用protostuff的schema模序列化pojo对象
				 * LinkedBuffer是缓存器，在pojo对象过大时进行缓存序列化
				*/
				byte[] bytes = ProtostuffIOUtil.toByteArray(reminds,cacheSchema,
						LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				//超时缓存(缓存过多久会失效，单位:秒)
				String result = jedis.setex(key.getBytes(),60,bytes);
				return result;
			}finally{
				jedis.close();
			}
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null; //TODO
	}
	
	
}
