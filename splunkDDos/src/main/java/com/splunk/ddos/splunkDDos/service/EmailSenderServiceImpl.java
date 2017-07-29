package com.splunk.ddos.splunkDDos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;
import com.splunk.ddos.splunkDDos.dto.EmailDTO;
import com.splunk.ddos.splunkDDos.factory.SendgridFactory;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

	@Autowired
	private SendgridFactory sendgridFactory;

	@Override
	public Boolean triggerMail(final EmailDTO dto) {
		try {
			final SendGrid.Response resp = sendgridFactory.createSendGridObj()
					.send(sendgridFactory.createSendgridEmailDTO(dto));
			System.out.println(resp.getMessage());
			if (resp != null && resp.getCode() == 200) {
				return Boolean.TRUE;
			}
		}
		catch (final SendGridException e) {
			e.printStackTrace();
		}
		return Boolean.TRUE;
	}

}
