package com.nov_sp_boot_spring_eve.Request;

public class LoginRequest {
	private String email;
	private String passcode;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
}
