package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name="uid")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="btnLogin")
	private WebElement loginButton;
	
	@FindBy(name="btnReset")
	private WebElement resetButton;
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un,String pass) throws InterruptedException {
		
		username.sendKeys(un);
		Thread.sleep(2000);
		password.sendKeys(pass);
		Thread.sleep(2000);
		loginButton.click();
	}
	
	

}
