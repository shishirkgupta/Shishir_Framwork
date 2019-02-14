package com.training.bean;

public class CyclosBean {
	
	private String recipient;
	private String amount;
	private String description;
	
	public CyclosBean() {
	}

	public CyclosBean(String recipient, String amount, String description) {
		super();
		this.recipient=recipient;
		this.amount=amount;
		this.description=description;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "CyclosBeanBean [recipient=" + recipient + ", amount=" + amount + ", description=" + description +"]";
	}
}
