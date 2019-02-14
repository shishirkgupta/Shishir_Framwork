package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CyclosMemberContactPaymentPOM {
	
	@SuppressWarnings("unused")
	private WebDriver driver;
	
	public CyclosMemberContactPaymentPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
