package com.wlan222.twitbukkit;

public class SocialStatus {
	private String author;
	private String message;
	private String origin;

	public SocialStatus(String author, String message, String origin) {
		this.author = author;
		this.message = message;
		this.origin = origin;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void post(SocialNetwork sn) {
		try {
			sn.post(this);
		} catch (UnauthenthicatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
