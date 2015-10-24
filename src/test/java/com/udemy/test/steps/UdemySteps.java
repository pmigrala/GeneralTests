package com.udemy.test.steps;

import static org.junit.Assert.*;
import org.openqa.selenium.By;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UdemySteps extends ScenarioSteps {
	
	@Step("Go to udemy.com")
	public void gotoUdemy() {
		getDriver().get("http://www.udemy.com");
	}
	
	@Step("Open login form")
	public void openLoginForm() {
		getDriver().findElement(By.linkText("Login")).click();
	}
	
	@Step("Clear username")
	public void clearUserName() {
		getDriver().findElement(By.id("id_email")).clear();
	}

	@Step("Enter username: \"{0}\"")
	public void enterUserName(String s) {
		getDriver().findElement(By.id("id_email")).sendKeys(s);
	}

	@Step("Clear password")
	public void clearPassword() {
		getDriver().findElement(By.id("id_password")).clear();
	}

	@Step("Enter password: \"{0}\"")
	public void enterPassword(String s) {
		getDriver().findElement(By.id("id_password")).sendKeys(s);
	}

	@Step("Click Login button")
	public void clickLoginButton() {
		getDriver().findElement(By.id("submit-id-submit")).click();
	}

	@Step("Verify error text is equal to: \"{0}\"")
	public void verifyErrorText(String s) {
		String errTxt = getDriver().findElement(By.xpath(".//*[@id='login-form']/div[1]/ul/li")).getText();
		assertEquals(errTxt, s);
	}

}
