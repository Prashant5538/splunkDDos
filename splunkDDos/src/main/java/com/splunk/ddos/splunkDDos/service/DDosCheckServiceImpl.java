package com.splunk.ddos.splunkDDos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splunk.ddos.splunkDDos.cacheService.GenericCacheService;

@Service
public class DDosCheckServiceImpl implements DDosCheckService {

	@Autowired
	private GenericCacheService cacheService;

	@Override
	public Boolean checkIpAdd(final String ipAdd) {
		return cacheService.getObjectFromCache(ipAdd, Boolean.class);

	}

}
