package com.andieguo.jersey.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Message {

	private boolean status;
	private String Information;
	
	public Message() {
		super();
	}
	public Message(boolean status, String information) {
		super();
		this.status = status;
		Information = information;
	}
	@XmlElement
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@XmlElement
	public String getInformation() {
		return Information;
	}
	public void setInformation(String information) {
		Information = information;
	}
	
}
