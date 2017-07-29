package com.splunk.ddos.splunkDDos.cacheService.resourceLocking;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splunk.ddos.splunkDDos.cacheService.GenericCacheService;

@Service
public class GenericResourceLockingServiceImpl implements GenericResourceLockingService {

	// private static Logger logger =
	// LogManager.getLogger(CustomerIdentificationServiceImpl.class);

	@Autowired
	private GenericCacheService cacheService;

	@Override
	public boolean acquirelock(final String key, final Integer lockingPeriod, final TimeUnit timeUnit) {
		// logger.info("trying to acquiring lock at "+System.currentTimeMillis()+" for
		// data "+key);
		final String prevVal = cacheService.atomicGetAndSet(key, "1");
		cacheService.setTTLInCache(key, lockingPeriod, timeUnit);
		if (prevVal != null && Integer.parseInt(prevVal) == 1) {
			// logger.info("failed at acquiring lock at ::-::
			// "+System.currentTimeMillis()+" for data "+key);
			return false;
		}
		// System.out.println("acquire lock at "+System.currentTimeMillis()+" for data
		// "+key);
		return true;
	}

}
