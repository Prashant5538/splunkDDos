package com.splunk.ddos.splunkDDos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.splunk.ddos.splunkDDos.service.DDosCheckService;

@RestController
public class DDosCheckController {

	@Autowired
	private DDosCheckService ddosCheckService;

	@RequestMapping(value = "/check/ddos", method = RequestMethod.GET)
	public ResponseEntity<Boolean> checkStatus(final String ipAdd) {
		return new ResponseEntity<>(ddosCheckService.checkIpAdd(ipAdd), HttpStatus.OK);
	}

}
