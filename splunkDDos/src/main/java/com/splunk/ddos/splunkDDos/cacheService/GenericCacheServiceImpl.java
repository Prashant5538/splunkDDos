package com.splunk.ddos.splunkDDos.cacheService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splunk.ddos.splunkDDos.utility.JsonParser;

@Service
public class GenericCacheServiceImpl implements GenericCacheService {

	@Autowired
	JsonParser jsonParser;
	@Autowired
	RedisCacheService redisCacheService;

	@Override
	public String atomicGetAndSet(final String key, final String value) {
		return redisCacheService.atomicGetAndSet(key, value);
	}

	@Override
	public boolean deleteFromCache(final String key) {
		return redisCacheService.deleteFromCache(key);
	}

	@Override
	public boolean deleteFromCache(final String hashMapKey, final String key) {
		return redisCacheService.deleteFromCache(hashMapKey, key);
	}

	@Override
	public boolean deleteFromCacheUsingJDKSerializer(final String key) {
		return redisCacheService.deleteFromCacheUsingJDKSerializer(key);
	}

	@Override
	public <T> T getFromCache(final String hashMapKey, final String key, final Class<?> cls) {
		final String jsonvalue = (String) redisCacheService.getFromCache(hashMapKey, key);
		if (jsonvalue == null) {
			return null;
		}
		else {
			return jsonParser.generalJsonToObject(jsonvalue, cls);
		}
	}

	@Override
	public <T> List<T> getFromCacheUsingPattern(final String keyPattern, final Class<?> cls) {
		final Set<String> valueSet = redisCacheService.getFromCacheUsingPattern(keyPattern);
		if (valueSet != null && !valueSet.isEmpty()) {
			final StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (final String val : valueSet) {
				sb.append(val);
			}
			sb.append("]");
			return jsonParser.generalJsonListToObjectList(sb.toString(), cls);
		}

		return null;
	}

	@Override
	public List<? extends Object> getMultipleFromCache(final List<String> keyList) {
		return redisCacheService.getMultipleFromCache(keyList);
	}

	@Override
	public <T> T getObjectFromCache(final String key, final Class<?> cls) {
		final String jsonvalue = redisCacheService.getFromCache(key);
		if (jsonvalue == null) {
			return null;
		}
		return jsonParser.generalJsonToObject(jsonvalue, cls);
	}

	@Override
	public <T> List<T> getObjectListFromCache(final String key, final Class<?> cls) {
		final String jsonvalue = redisCacheService.getFromCache(key);
		if (jsonvalue == null) {
			return null;
		}
		return jsonParser.generalJsonListToObjectList(jsonvalue, cls);
	}

	@Override
	public <T> boolean putInCache(final String hashMapKey, final String key, final T value) {
		if (hashMapKey == null || key == null || value == null) {
			return false;
		}
		final String redisValue = jsonParser.objectToJson(value);
		return redisCacheService.putInCache(hashMapKey, key, redisValue);
	}

	@Override
	public <T> boolean putInCacheWithTTL(final String hashMapKey, final String key, final T value, final Integer ttl, final TimeUnit timeUnit) {
		if (value == null) {
			return false;
		}
		final String redisValue = jsonParser.objectToJson(value);
		redisCacheService.putInCacheWithTTL(hashMapKey, key, redisValue, ttl, timeUnit);

		return false;
	}

	@Override
	public <T> boolean putInCacheWithTTL(final String key, final T value, final Integer ttlTimeInSec, final TimeUnit timeUnit) {
		if (value == null) {
			return false;
		}
		final String redisValue = jsonParser.objectToJson(value);
		return redisCacheService.putInCacheWithTTL(key, redisValue, ttlTimeInSec, timeUnit);
	}

	@Override
	public Boolean putMultipleInCache(final Map keyValMap) {
		return redisCacheService.putMultipleInCache(keyValMap);
	}

	@Override
	public <T> boolean putObjectInCache(final String key, final T valueObject) {
		if (valueObject == null) {
			return false;
		}
		final String redisValue = jsonParser.objectToJson(valueObject);
		return redisCacheService.putInCache(key, redisValue);
	}

	@Override
	public <T> boolean putObjectListInCache(final String key, final List<T> valueObjectList) {
		if (valueObjectList == null || valueObjectList.isEmpty()) {
			return false;
		}
		final String redisValue = jsonParser.objectListToJson(valueObjectList);
		return redisCacheService.putInCache(key, redisValue);
	}

	@Override
	public <T> boolean putObjectListInCacheWithTTL(final String key, final List<T> valueObjectList, final Integer ttlTimeInSec,
			final TimeUnit timeUnit) {
		if (valueObjectList == null || valueObjectList.isEmpty()) {
			return false;
		}
		final String redisValue = jsonParser.objectListToJson(valueObjectList);
		return redisCacheService.putInCacheWithTTL(key, redisValue, ttlTimeInSec, timeUnit);
	}

	@Override
	public boolean setTTLInCache(final String key, final Integer ttlTimeInSec, final TimeUnit timeUnit) {
		return redisCacheService.setTTLInCache(key, ttlTimeInSec, timeUnit);
	}

}
