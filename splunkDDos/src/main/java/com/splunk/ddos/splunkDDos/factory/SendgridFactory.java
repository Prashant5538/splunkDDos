package com.splunk.ddos.splunkDDos.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sendgrid.SendGrid;
import com.splunk.ddos.splunkDDos.dto.EmailDTO;

@Component
public class SendgridFactory {

	@Value("${mail.sendgrid.apikey}")
	private String apiKey;
	@Value("${mail.sendgrid.passwd}")
	private String passwd;
	@Value("${mail.sendgrid.userName}")
	private String userName;

	public SendGrid.Email createSendgridEmailDTO(final EmailDTO dto) {
		final SendGrid.Email mail = new SendGrid.Email();
		mail.addTo(dto.getToAdd());
		mail.addToName(dto.getToName());
		mail.setFrom(dto.getFromAdd());
		mail.setSubject(dto.getSubject());
		mail.setText(dto.getBody());
		return mail;
	}

	public SendGrid createSendGridObj() {
		final SendGrid sendgrid = new SendGrid(userName, passwd);
		// final SendGrid sendgrid = new SendGrid(apiKey);
		return sendgrid;
	}

}
