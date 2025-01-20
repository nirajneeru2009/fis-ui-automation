package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.CartPage;
import pageObjects.EbayHomePage;
import pageObjects.ProductPage;
import pageObjects.SearchResultPage;
import utils.TestUtil;

public class AddToCartTest extends BaseTest {
	String validBookEntry = "book";
	String inValidSearchEntry = "87^%^%*&*&%$&^****jkjkhj&&*(hj";
	EbayHomePage homePage;
	SearchResultPage resultPage;
	ProductPage productPage;
	CartPage cartPage;

	@Test
	public void verifyBookAdditionToCart() {
		homePage = new EbayHomePage(driver);
		homePage.inputBookName(validBookEntry);
		homePage.clickSearch();
		resultPage = new SearchResultPage(driver);
		resultPage.clickSearchResult();
		TestUtil testUtil = new TestUtil(driver);
		testUtil.switchToNewTab();
		driver.manage().timeouts().getImplicitWaitTimeout();
		productPage = new ProductPage(driver);
		productPage.clickAddToCart();
		cartPage = new CartPage(driver);
		Assert.assertEquals(true, cartPage.isItemAdded());
	}

	@Test
	public void verifyInValidBookSearch() {
		homePage = new EbayHomePage(driver);
		homePage.inputBookName(inValidSearchEntry);
		homePage.clickSearch();
		resultPage = new SearchResultPage(driver);
		Assert.assertEquals(true, resultPage.isSearchResultIsEmpty());
	}
}
