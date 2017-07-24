/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fludatatool.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;

@Controller
public class FludatatoolSentController {
	
	@RequestMapping(value = "module/fludatatool/sentArticles", params = { "email" }, method = RequestMethod.GET)
	public @ResponseBody
	String sentArticles(@RequestParam(value = "email") String email) {
		//		@SuppressWarnings("unchecked")
		//		ArrayList<String> emails = (ArrayList<String>) request.getAttribute("emails");
		
		// Recipient's email ID needs to be mentioned.
		String to = email;//change accordingly
		
		// Sender's email ID needs to be mentioned
		String from = "Your gmail account";//change accordingly
		final String username = "username for your account";//change accordingly
		final String password = "password for your account";//change accordingly
		
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			
			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			
			// Set Subject: header field
			message.setSubject("Flu Articles");
			
			// Now set the actual message
			message.setText("http://fludataproject.comeze.com");
			// Send message
			Transport.send(message);
			
			System.out.println("Sent message successfully....");
			
		}
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		return "Test Flu Article is sented";
	}
	
}
