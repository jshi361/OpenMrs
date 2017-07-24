/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fludatatool;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.User;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Please note that a corresponding table schema must be created in liquibase.xml.
 */
//Uncomment 2 lines below if you want to make the Item class persistable, see also FludatatoolDaoTest and liquibase.xml
//@Entity(name = "fludatatool.Item")
//@Table(name = "fludatatool_item")
public class Contact extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column(name = "contact_id")
	private Integer contactId;
	
	@Basic
	@Column(name = "emailLocal", length = 64)
	private String emailLocal;
	
	@Basic
	@Column(name = "emailHost", length = 256)
	private String emailDomain;
	
	@Basic
	public Integer getContactId() {
		return contactId;
	}
	
	public void setContactId(Integer id) {
		this.contactId = id;
	}
	
	public String getEmailLocal() {
		return emailLocal;
	}
	
	public void setEmailLocal(String email_local) {
		this.emailLocal = email_local;
	}
	
	public String getEmailDomain() {
		return emailDomain;
	}
	
	public void setEmailDomain(String email_domain) {
		this.emailDomain = email_domain;
	}
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return getContactId();
	}
	
	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		setContactId(id);
	}
	
}
