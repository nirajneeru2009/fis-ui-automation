package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver;

	@FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']/li[1]/div/div[1]")
	private WebElement searchResult;
	
	@FindBy(xpath="//h3[text()='No exact matches found']")
	private WebElement noSearchResultMessage;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSearchResult() {
		searchResult.click();
	}
	
	public boolean isSearchResultIsEmpty() {
		if(noSearchResultMessage.isDisplayed())
			return true;
		else
			return false;
	}
}
