package com.bbc.ops.BBCOps.model;

import javax.persistence.Embeddable;

@Embeddable
public class ContactInfo {
	private String email;
	private String phone;

	public ContactInfo() {
	}

	public ContactInfo(String email, String phone) {
		super();
		this.email = email;
		this.phone = phone;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ContactInfo [email=" + email + ", phone=" + phone + "]";
	}
}
