package com.splunk.app1.splunkLog1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.splunk.app1.splunkLog1.http.filter.RequestScopeContext;

@RestController
public class SplunkRequestController {

	@Autowired
	private RequestScopeContext request;

	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public ResponseEntity<String> giveMyUniqueId() {
		final String resp = "request that we received is bein made from ip->," + request.getIpAddress()
				+ ", having id ->," + request.getRequestId();
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

}
