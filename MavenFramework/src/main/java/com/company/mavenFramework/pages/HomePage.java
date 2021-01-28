package com.company.mavenFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.company.mavenFramework.generic.WebActionUtil;

public class HomePage extends BasePage {
	//Creating WebElement
	@FindBy(linkText = "Sign out")
	private WebElement signOutLink;
	
	@FindBy(linkText = "Women")
	private WebElement womenMenu;
	
	@FindBy(xpath="(//a[text()='Dresses'])[2]")
	private WebElement dressesMenu;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	private WebElement tShirtsMenu;
	
	final static String pageTitle = "My account - My Store";
	final static String pageUrl = "http://automationpractice.com/index.php?controller=my-account";
	
	//Constructor
	public HomePage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil, pageTitle, pageUrl);
	}
	/**
	 * User should give the name of the menu items either dresses or women or t-shirts 
	 * the given menu will be clicked
	 * @param menuName
	 * @return the next page Object i.e, ProductListPage[PLP] Object
	 */
	public ProductListPage clickOnMenu(String menuName) {
		menuName=menuName.toLowerCase();
		switch(menuName) {
			case "dresses":webActionUtil.elementClick(dressesMenu);
						   break;
			case "women":webActionUtil.elementClick(womenMenu);
			             break;
			case "t-shirts":webActionUtil.elementClick(tShirtsMenu);
            				break;
			
		}
		
		return new ProductListPage(driver, webActionUtil);
	}
	/**
	 *  Logout from the application
	 */
	public void logout() {
		webActionUtil.elementClick(signOutLink);
	}
}
