/*
 *
 */
package com.splunk.ddos.splunkDDos.cacheService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// TODO: Auto-generated Javadoc
/**
 * The Interface RedisCacheService.
 */
public interface RedisCacheService {

	/**
	 * Atomic get and set.
	 *
	 * @param key the key
	 * @param value the value
	 * @return the integer
	 */
	public String atomicGetAndSet(String key, String value);

	/**
	 * Delete from cache.
	 *
	 * @param hashMapKey the hash map key
	 * @param key the key
	 * @return true, if successful
	 */
	public boolean deleteFromCache(Object hashMapKey, String key);

	/**
	 * Delete from cache.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	public boolean deleteFromCache(String key);

	/**
	 * Delete from cache using jdk serializer.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	boolean deleteFromCacheUsingJDKSerializer(String key);

	/**
	 * Gets the from cache.
	 *
	 * @param hashMapKey the hash map key
	 * @param key the key
	 * @return the from cache
	 */
	public Object getFromCache(Object hashMapKey, String key);

	/**
	 * Gets the from cache.
	 *
	 * @param key the key
	 * @return the from cache
	 */
	public String getFromCache(String key);

	/**
	 * Gets the from cache using pattern.
	 *
	 * @param keyPattern the key pattern
	 * @return the from cache using pattern
	 */
	public Set<String> getFromCacheUsingPattern(String keyPattern);

	/**
	 * Get multiple values from cache.
	 *
	 * @param keyList the key list
	 * @return the multiple from cache
	 */
	public List<? extends Object> getMultipleFromCache(List<String> keyList);

	/**
	 * Put in cache.
	 *
	 * @param hashMapKey the hash map key
	 * @param key the key
	 * @param value the value
	 * @return true, if successful
	 */
	public boolean putInCache(Object hashMapKey, String key, String value);

	/**
	 * Put in cache.
	 *
	 * @param key the key
	 * @param value the value
	 * @return true, if successful
	 */
	public boolean putInCache(String key, String value);

	/**
	 * Put in cache with ttl.
	 *
	 * @param hashMapKey the hash map key
	 * @param key the key
	 * @param value the value
	 * @param ttlTimeInSec the ttl time in sec
	 * @param timeUnit the time unit
	 * @return true, if successful
	 */
	public boolean putInCacheWithTTL(Object hashMapKey, String key, String value, Integer ttlTimeInSec,
			TimeUnit timeUnit);

	/**
	 * Put in cache with ttl.
	 *
	 * @param key the key
	 * @param value the value
	 * @param ttlTimeInSec the ttl time in sec
	 * @param timeUnit the time unit
	 * @return true, if successful
	 */
	public boolean putInCacheWithTTL(String key, String value, Integer ttlTimeInSec, TimeUnit timeUnit);

	/**
	 * Set multiple values in cache.
	 *
	 * @param keyValMap the key val map
	 * @return the boolean
	 */
	public Boolean putMultipleInCache(Map keyValMap);

	/**
	 * Sets the ttl in cache.
	 *
	 * @param key the key
	 * @param ttlTimeInSec the ttl time in sec
	 * @param timeUnit the time unit
	 * @return true, if successful
	 */
	public boolean setTTLInCache(String key, Integer ttlTimeInSec, TimeUnit timeUnit);

}
