package com.company.mavenFramework.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.company.mavenFramework.generic.WebActionUtil;

public class ProductDetailPage extends BasePage
{
	@FindBy(className="icon-plus")
	private WebElement plusIcon;
	
	@FindBy(className="icon-minus")
	private WebElement minusIcon;
	
	@FindBy(id="group_1")
	private WebElement sizeListBox;
	
	@FindBy(xpath="//ul[@id='color_to_pick_list']/li/a")
	private List<WebElement> colorPickerList;
	
	@FindBy(name="Submit")
	private WebElement addToCartBTN;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckoutBTN;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	private WebElement continueShoppingBTN;

	@FindBy(className="cross")
	private WebElement closeIcon;
	
	final static String pageTitle = "Printed Summer Dress - My Store";
	final static String pageUrl = "http://automationpractice.com/index.php?id_product=5&controller=product";
	//Consrtuctor
	public ProductDetailPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil, pageTitle, pageUrl);
	}
	
	public void increaseQuantity(int numToInc)
	{
		for(int i=1; i<numToInc; i++)
		{
			webActionUtil.elementClick(plusIcon);
		}
	}
	public void decreaseQuantity(int numToDec)
	{
		for(int i=1; i<numToDec; i++)
		{
			webActionUtil.elementClick(minusIcon);
		}
	}
	public void selectSize(String size)
	{
		webActionUtil.selectByText(sizeListBox, size);
	}
	public void selectColor(String colorName)
	{
		for(WebElement color:colorPickerList)
		{
			if(color.getAttribute("name").equals(colorName))
			{
				webActionUtil.elementClick(color);
				break;
			}
		}
	}
	public void clickOnAddToCart()
	{
		webActionUtil.elementClick(addToCartBTN);
	}
	public OrderDetailPage clickOnProceedToCheckout()
	{
		webActionUtil.elementClick(proceedToCheckoutBTN);
//		webActionUtil.jsClick(proceedToCheckoutBTN);
		return new OrderDetailPage(driver, webActionUtil);
	}
	public void clickOnContinueShopping()
	{
		webActionUtil.elementClick(continueShoppingBTN);
	}
	public void clickOnCloseIcon()
	{
		webActionUtil.elementClick(closeIcon);
	}
	
	public OrderDetailPage addSelectItemToCart(int numToInc, int numToDec, String size, String colorName)
	{
		increaseQuantity(numToInc);
		decreaseQuantity(numToDec);
		selectSize(size);
		selectColor(colorName);
		clickOnAddToCart();
		return clickOnProceedToCheckout();
	}
}

