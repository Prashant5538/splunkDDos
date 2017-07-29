package com.splunk.ddos.splunkDDos.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splunk.ddos.splunkDDos.cacheService.GenericCacheService;
import com.splunk.ddos.splunkDDos.dto.EmailDTO;

@Service
public class SplunkServiceImpl implements SplunkService {

	@Autowired
	private GenericCacheService cacheService;
	@Autowired
	private EmailSenderService senderService;

	@Override
	public void markIpAsBlackListed(final String ipAdd) {
		// put the data in redis to be used by other service
		cacheService.putInCacheWithTTL(ipAdd, Boolean.FALSE, 30, TimeUnit.MINUTES);
		// call sendgrid service to send mail
		senderService.triggerMail(populateMailDTO(ipAdd));
	}

	private EmailDTO populateMailDTO(final String ipAdd) {
		final EmailDTO dto = new EmailDTO();
		dto.setBody("This ipAdd has been blocked for next 30 minutes due to DDOs attack detection " + ipAdd);
		dto.setFromAdd("teja.divya99@gmail.com");
		dto.setSubject("DDos Attack detected");
		// dto.setToAdd("meghanajagruthi@gmail.com");
		dto.setToAdd("teja.divya99@gmail.com");
		dto.setToName("Meghu DDos Expert");
		return dto;
	}

}
