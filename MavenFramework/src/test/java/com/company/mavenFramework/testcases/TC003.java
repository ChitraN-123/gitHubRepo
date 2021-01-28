package com.company.mavenFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.company.mavenFramework.pages.HomePage;
import com.company.mavenFramework.pages.OrderDetailPage;
import com.company.mavenFramework.pages.ProductDetailPage;
import com.company.mavenFramework.pages.ProductListPage;

import com.company.mavenFramework.generic.GenericXLLibrary;
import com.company.mavenFramework.generic.Utility;
/**
 * @author admin
 * add the multiple products to the cart
 */
public class TC003 extends BaseTest {
	@DataProvider
	public String[][] getData() {
		return GenericXLLibrary.getMultipleData(XL_PATH, "TC003");
	}
	
	@Test(dataProvider="getData",
		  description="Test case to verify if the added product via DataProvider is displayed on ODP page")
	public void testMultipleProductToCart(String menuName, String productId, 
										String increaseQuantity, String decreaseQuantity,
										String size, String color) {
		productId = Utility.split(productId);
		int incQ = Integer.parseInt(Utility.split(increaseQuantity));
		int decQ = Integer.parseInt(Utility.split(decreaseQuantity));
		
		HomePage hp = new HomePage(driver, webActionUtil);
		ProductListPage plp = hp.clickOnMenu(menuName);
		ProductDetailPage pdp = plp.selectProduct(productId);
		OrderDetailPage odp = pdp.addSelectItemToCart(incQ, decQ, size, color);
		Assert.assertEquals(odp.isProductDisplayed(productId), true);
	}
}
