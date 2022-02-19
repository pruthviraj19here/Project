package com.inetbanking.testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;

public class LoginTest extends BaseClass{

	@Test(priority=1)
	public void lodadpage() {
		System.out.println(driver.getTitle());
	}
	
	@Test(priority = 2)
	public void login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage lp=new LoginPage(driver);
		String userid=p.getProperty("userID");
		String password=p.getProperty("password");
		
		lp.login(userid,password );
		String homepagetitle=driver.getTitle();
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(homepagetitle, "GTPL Bank Manager HomePage", "Login not Successful");
	}
	@Test(dependsOnMethods ="login" )
	public void logoutTest() {
		System.out.println("Logout Test Start");
		HomePage hp=new HomePage(driver);
		hp.logout();
		System.out.println("Alert is: "+driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		
	}
	
}
