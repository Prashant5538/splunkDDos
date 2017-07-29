package com.splunk.ddos.splunkDDos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SplunkServiceImpl implements SplunkService {

	@Autowired
	private EmailSenderService senderService;

	@Override
	public void markIpAsBlackListed(final String ipAdd) {
		// put the data in redis to be used by other service

		// call sendgrid service to send mail
		senderService.triggerMail(null);
	}

}
