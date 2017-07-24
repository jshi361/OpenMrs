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

import java.util.ArrayList;
import java.util.List;

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
import org.openmrs.module.fludatatool.api.impl.FludatatoolServiceImpl;
import org.openmrs.module.fludatatool.Contact;

/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/${rootArtifactid}/${rootArtifactid}Link.form'.
 */
@Controller
public class FludatatoolController {
	
	@RequestMapping(value = "module/fludatatool/viewFDT", method = RequestMethod.GET)
	public void showForm(HttpServletRequest request) {
		//		FludatatoolServiceImpl fdtService = new FludatatoolServiceImpl();
		//		List<Contact> contactList = fdtService.getAllContact();
		//		String[] emailList = new String[contactList.size()];
		//		int i = 0;
		//		for (Contact c : contactList) {
		//			emailList[i] = c.getEmailLocal() + "@" + c.getEmailDomain();
		//			i++;
		//		}
		//		request.setAttribute("emailList", emailList);
		
	}
	
}
