package com.udemy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.udemy.test.steps.UdemySteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class UdemyTest {
	
	@Managed
	WebDriver driver;
	
	@Steps
	UdemySteps steps;
	
	@Test
	@Title("Open Udemy login form and enter invalid credentials")
	public void testUdemyLoginInvalidCredentials() {
		steps.gotoUdemy();
		steps.openLoginForm();
		steps.enterUserName("someGuy@somePlace.com");
		steps.enterPassword("somePassword");
		steps.clickLoginButton();
		steps.verifyErrorText("Please check your email and password.");
	}

	@Test
	@Title("Open Udemy login form and enter no user name")
	public void testUdemyLoginNoUserName() {
		steps.gotoUdemy();
		steps.openLoginForm();
		steps.clearUserName();
		steps.enterPassword("somePassword");
		steps.clickLoginButton();
		steps.verifyErrorText("Please enter a valid email.");
	}

	@Test
	@Title("Open Udemy login form and enter no credentials")
	public void testUdemyLoginNoCredentials() {
		steps.gotoUdemy();
		steps.openLoginForm();
		steps.clearUserName();
		steps.clearPassword();
		steps.clickLoginButton();
		steps.verifyErrorText("Please check your email and password.");
	}

	@Test
	@Title("Open Udemy login form and enter no password")
	public void testUdemyLoginNoPassword() {
		steps.gotoUdemy();
		steps.openLoginForm();
		steps.enterUserName("someGuy@somePlace.com");
		steps.clearPassword();
		steps.clickLoginButton();
		steps.verifyErrorText("Please enter a valid password.");
	}

}
