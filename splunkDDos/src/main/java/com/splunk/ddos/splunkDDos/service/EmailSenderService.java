package com.splunk.ddos.splunkDDos.service;

import com.splunk.ddos.splunkDDos.dto.EmailDTO;

public interface EmailSenderService {

	public Boolean triggerMail(EmailDTO dto);

}
