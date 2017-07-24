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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class FDTUpdateEmailController {
	
	@RequestMapping(value = "module/fludatatool/updateEmail", method = RequestMethod.GET)
	public @ResponseBody
	String sentArticles(@RequestParam(value = "pid") int pid, @RequestParam(value = "emailLocal") String emailLocal,
	        @RequestParam(value = "emailDomain") String emailDomain) {
		
		System.out.println(pid);
		System.out.println(emailLocal);
		System.out.println(emailDomain);
		
		String username = "root"; //Change this if using a different username for mysql
		String password = "password"; //Change this if using a different password for mysql
		String dbURL = "jdbc:mysql://localhost:3306/server9"; ////Change accordingly
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			return "An error occur please try again later\nError:1";
		}
		
		try {
			connection = DriverManager.getConnection(dbURL, username, password);
			Statement statement = connection.createStatement();
			
			String command = "select * from fdt_contact_info where patient_id=" + pid;
			
			ResultSet resultset = null;
			
			resultset = statement.executeQuery(command);
			
			int flag = 0;
			while (resultset.next()) {
				flag++;
			}
			
			//update the entry
			if (flag > 0) {
				System.out.println("updating");
				String query = "update fdt_contact_info set emailLocal = ?, emailDomain = ? where patient_id = ?";
				PreparedStatement preparedStmt = connection.prepareStatement(query);
				preparedStmt.setString(1, emailLocal);
				preparedStmt.setString(2, emailDomain);
				preparedStmt.setInt(3, pid);
				
				// execute the java preparedstatement
				preparedStmt.executeUpdate();
			} else { //insert the entry
				System.out.println("inserting");
				// the mysql insert statement
				String query = " insert into fdt_contact_info (patient_id, emailLocal, emailDomain)" + " values (?, ?, ?)";
				
				// create the mysql insert preparedstatement
				PreparedStatement preparedStmt = connection.prepareStatement(query);
				preparedStmt.setInt(1, pid);
				preparedStmt.setString(2, emailLocal);
				preparedStmt.setString(3, emailDomain);
				
				// execute the preparedstatement
				preparedStmt.execute();
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			int count = 1;
			while (e != null) {
				System.out.println("SQLException " + count);
				System.out.println("Code: " + e.getErrorCode());
				System.out.println("SqlState: " + e.getSQLState());
				System.out.println("Error Message: " + e.getMessage());
				e = e.getNextException();
				count++;
			}
			return "An error occur please try again later\nError:2";
		}
		return "Email have been updated";
	}
	
}
