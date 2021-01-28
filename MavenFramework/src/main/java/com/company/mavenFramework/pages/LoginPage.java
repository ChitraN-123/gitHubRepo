package com.company.mavenFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.company.mavenFramework.generic.WebActionUtil;

public class LoginPage extends BasePage
{
	//Creating WebElement
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
	@FindBy(id = "email")
	private WebElement emailTB;
	
	@FindBy(id = "passwd")
	private WebElement passwordTB;
	
	@FindBy(id = "SubmitLogin")
	private WebElement loginBTN;
	
	@FindBy(linkText = "Forgot your password?")
	private WebElement forgetPasswordLink;
	
	final static String pageTitle = "Log - My Store";
	final static String pageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	
	//Constructor
	public LoginPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil, pageTitle, pageUrl);
	}

	/**  
	 * @param username String value to be entered into email Textbox
	 * @param password String value to be entered into password Textbox
	 * @return the next page object(Landing Page) i.e, HomePage
	 */
	public HomePage login(String username, String password)
	{
		webActionUtil.elementClick(signInLink);
		webActionUtil.enterData(emailTB, username);
		webActionUtil.enterData(passwordTB, password);
		webActionUtil.elementClick(loginBTN);
		return new HomePage(driver, webActionUtil);
	}
}