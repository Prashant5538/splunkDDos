package com.splunk.ddos.splunkDDos.cacheService.resourceLocking;

import java.util.concurrent.TimeUnit;

public interface GenericResourceLockingService {

	/**
	 * Acquirelock.
	 *
	 * @param key the key
	 * @param ttlTimeInSec the ttl time in sec
	 * @param timeUnit the time unit
	 * @return true, if successful
	 */
	public boolean acquirelock(String key, Integer lockingPeriod, TimeUnit timeUnit);

}