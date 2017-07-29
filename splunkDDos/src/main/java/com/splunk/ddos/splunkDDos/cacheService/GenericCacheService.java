package com.splunk.ddos.splunkDDos.cacheService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// TODO: Auto-generated Javadoc
/**
 * The Interface GenericCacheService.
 */
public interface GenericCacheService {

	/**
	 * Atomic get and set.
	 *
	 * @param key the key
	 * @param value the value
	 * @return the string
	 */
	public String atomicGetAndSet(String key, String value);

	/**
	 * Delete from cache.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	public boolean deleteFromCache(String key);

	/**
	 * Delete from cache.
	 *
	 * @param hashMapKey the hash map key
	 * @param key the key
	 * @return true, if successful
	 */
	public boolean deleteFromCache(String hashMapKey, String key);

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
	 * @param <T> the generic type
	 * @param hashMapKey the hash map key
	 * @param key the key
	 * @param cls the cls
	 * @return the from cache
	 */
	public <T> T getFromCache(String hashMapKey, String key, Class<?> cls);

	/**
	 * Gets the from cache using pattern.
	 *
	 * @param <T> the generic type
	 * @param keyPattern the key pattern
	 * @param cls the cls
	 * @return the from cache using pattern
	 */
	public <T> List<T> getFromCacheUsingPattern(String keyPattern, Class<?> cls);

	/**
	 * Gets the multiple from cache.
	 *
	 * @param keyList the key list
	 * @return the multiple from cache
	 */
	public List<? extends Object> getMultipleFromCache(List<String> keyList);

	/**
	 * Gets the object from cache.
	 *
	 * @param <T> the generic type
	 * @param key the key
	 * @param cls the cls
	 * @return the object from cache
	 */
	public <T> T getObjectFromCache(String key, Class<?> cls);

	/**
	 * Gets the object list from cache.
	 *
	 * @param <T> the generic type
	 * @param key the key
	 * @param cls the cls
	 * @return the object list from cache
	 */
	public <T> List<T> getObjectListFromCache(String key, Class<?> cls);

	/**
	 * Put in cache.
	 *
	 * @param <T> the generic type
	 * @param hashMapKey the hash map key
	 * @param key the key
	 * @param value the value
	 * @return true, if successful
	 */
	public <T> boolean putInCache(String hashMapKey, String key, T value);

	/**
	 * Put in cache with ttl.
	 *
	 * @param <T> the generic type
	 * @param hashMapKey the hash map key
	 * @param key the key
	 * @param value the value
	 * @param ttl the ttl
	 * @param timeUnit the time unit
	 * @return true, if successful
	 */
	public <T> boolean putInCacheWithTTL(String hashMapKey, String key, T value, Integer ttl, TimeUnit timeUnit);

	/**
	 * Put in cache with ttl.
	 *
	 * @param key the key
	 * @param value the value
	 * @param ttlTimeInSec the ttl time in sec
	 * @param timeUnit the time unit
	 * @return true, if successful
	 */
	public <T> boolean putInCacheWithTTL(String key, T value, Integer ttlTimeInSec, TimeUnit timeUnit);

	/**
	 * Put multiple in cache.
	 *
	 * @param keyValMap the key val map
	 * @return the boolean
	 */
	public Boolean putMultipleInCache(Map keyValMap);

	/**
	 * Put object in cache.
	 *
	 * @param <T> the generic type
	 * @param key the key
	 * @param valueObject the value object
	 * @return true, if successful
	 */
	public <T> boolean putObjectInCache(String key, T valueObject);

	/**
	 * Put object list in cache.
	 *
	 * @param <T> the generic type
	 * @param key the key
	 * @param valueObjectList the value object list
	 * @return true, if successful
	 */
	public <T> boolean putObjectListInCache(String key, List<T> valueObjectList);

	/**
	 * Put in cache with ttl.
	 *
	 * @param key the key
	 * @param value the value
	 * @param ttlTimeInSec the ttl time in sec
	 * @param timeUnit the time unit
	 * @return true, if successful
	 */
	public <T> boolean putObjectListInCacheWithTTL(String key, List<T> valueObjectList, Integer ttlTimeInSec,
			TimeUnit timeUnit);

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
