package com.splunk.ddos.splunkDDos.cacheService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {

	@Autowired
	@Qualifier(value = "objectRedisTemplate")
	public RedisTemplate<String, ? extends Object> objectRedisTemplate;

	@Autowired
	@Qualifier(value = "redisTemplate")
	public RedisTemplate<String, String> redisTemplate;

	@Override
	public String atomicGetAndSet(final String key, final String value) {
		return redisTemplate.opsForValue().getAndSet(key, value);
	}

	@Override
	public boolean deleteFromCache(final Object hashMapKey, final String key) {
		redisTemplate.opsForHash().delete(key, hashMapKey);
		return true;
	}

	@Override
	public boolean deleteFromCache(final String key) {
		try {
			redisTemplate.delete(key);
			return true;
		}
		catch (final Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteFromCacheUsingJDKSerializer(final String key) {
		try {
			objectRedisTemplate.delete(key);
			return true;
		}
		catch (final Exception e) {
			return false;
		}
	}

	@Override
	public Object getFromCache(final Object hashMapKey, final String key) {
		return redisTemplate.opsForHash().get(key, hashMapKey);
	}

	@Override
	public String getFromCache(final String key) {
		final String value = redisTemplate.opsForValue().get(key);
		return value;
	}

	@Override
	public Set<String> getFromCacheUsingPattern(final String keyPattern) {
		return redisTemplate.keys(keyPattern);
	}

	@Override
	public List<? extends Object> getMultipleFromCache(final List<String> keyList) {
		return objectRedisTemplate.opsForValue().multiGet(keyList);

	}

	@Override
	public boolean putInCache(final Object hashMapKey, final String key, final String value) {
		redisTemplate.opsForHash().put(key, hashMapKey, value);
		return true;
	}

	@Override
	public boolean putInCache(final String key, final String value) {
		try {
			redisTemplate.opsForValue().set(key, value);
			return true;
		}
		catch (final Exception e) {
			return false;
		}
	}

	@Override
	public boolean putInCacheWithTTL(final Object hashMapKey, final String key, final String value, final Integer ttl, final TimeUnit timeUnit) {
		try {
			redisTemplate.opsForHash().put(key, hashMapKey, value);
			redisTemplate.expire(key, ttl, timeUnit);
			return true;
		}
		catch (final Exception e) {
			return false;
		}
	}

	@Override
	public boolean putInCacheWithTTL(final String key, final String value, final Integer ttlTimeInSec,
			final TimeUnit timeUnit) {
		try {
			redisTemplate.execute(new SessionCallback() {
				@Override
				public Object execute(final RedisOperations operations) throws DataAccessException {
					operations.opsForValue().set(key, value);
					return operations.expire(key, ttlTimeInSec, timeUnit);
				}
			});
			return true;
		}
		catch (final Exception e) {
			return false;
		}

	}

	@Override
	public Boolean putMultipleInCache(final Map keyValMap) {
		try {
			objectRedisTemplate.opsForValue().multiSet(keyValMap);
			return true;
		}
		catch (final Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean setTTLInCache(final String key, final Integer ttlTimeInSec, final TimeUnit timeUnit) {
		return redisTemplate.expire(key, ttlTimeInSec, timeUnit);
	}

}
