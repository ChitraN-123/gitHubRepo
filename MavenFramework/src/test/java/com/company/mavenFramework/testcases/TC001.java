package com.company.mavenFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.company.mavenFramework.pages.HomePage;
import com.company.mavenFramework.pages.OrderDetailPage;
import com.company.mavenFramework.pages.ProductDetailPage;
import com.company.mavenFramework.pages.ProductListPage;
import com.company.mavenFramework.generic.GenericXLLibrary;
import com.company.mavenFramework.generic.Utility;
/**
 * @author admin
 * add the product to the cart 
 */
public class TC001 extends BaseTest {
	@Test(description="Test case to verify if the added product is Displayed in ODP Page")
	public void testAddingProductToCart() {
		HomePage hp = new HomePage(driver, webActionUtil);
		
		//Get data from XL sheet
		String sheetName ="TC001";
		String menuName = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 0);
		String productId = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 1);
		productId = Utility.split(productId);
		String increaseQuantity = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 2);
		int incQ = Integer.parseInt(Utility.split(increaseQuantity));
		String decreaseQuantity = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 3);
		int decQ = Integer.parseInt(Utility.split(decreaseQuantity));
		String size = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 4);
		String color = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 5);
		
		ProductListPage plp = hp.clickOnMenu(menuName);
		ProductDetailPage pdp = plp.selectProduct(productId);
		OrderDetailPage odp = pdp.addSelectItemToCart(incQ, decQ, size, color);
		Assert.assertEquals(odp.isProductDisplayed(productId), true);
	}
}
