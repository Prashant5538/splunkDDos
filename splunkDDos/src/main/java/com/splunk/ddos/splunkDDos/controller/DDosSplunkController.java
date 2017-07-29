package com.splunk.ddos.splunkDDos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.splunk.ddos.splunkDDos.service.SplunkService;

@RestController
public class DDosSplunkController {

	@Autowired
	private SplunkService splunkService;

	@RequestMapping(value = "/splunk/ddos", method = RequestMethod.GET)
	public ResponseEntity<String> checkStatus(final String ipAdd) {
		splunkService.markIpAsBlackListed(ipAdd);
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

}
