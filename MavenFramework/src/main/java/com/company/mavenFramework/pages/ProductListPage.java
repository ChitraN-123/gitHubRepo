package com.company.mavenFramework.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.company.mavenFramework.generic.WebActionUtil;

public class ProductListPage extends BasePage
{
	@FindBy(xpath="//li//a[@class='product_img_link']")
	private List<WebElement> productIdList;
	
	final static String pageTitle = "Dresses - My Store";
	final static String pageUrl = "http://automationpractice.com/index.php?id_category=8&controller=category";
	//Constructor
	public ProductListPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil, pageTitle, pageUrl);
	}
	//Action
	/**
	 * @param productId
	 * @return the next page Object i.e, ProductDetailPage[PDP] 
	 */
	public ProductDetailPage selectProduct(String productId)
	{
		productId = "id_product="+productId;
		for(WebElement product:productIdList)
		{
			if(product.getAttribute("href").contains(productId))
			{
				webActionUtil.elementClick(product);
//				webActionUtil.jsClick(product);
				break;
			}
		}
		return new ProductDetailPage(driver, webActionUtil);
	}
}
