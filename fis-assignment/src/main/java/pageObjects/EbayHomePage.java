package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHomePage {

	WebDriver driver;

	@FindBy(name = "_nkw")
	private WebElement searchBar;

	@FindBy(id = "gh-search-btn")
	private WebElement searchButton;

	public EbayHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void inputBookName(String bookName) {
		searchBar.sendKeys(bookName);
	}

	public void clickSearch() {
		searchButton.click();
	}

}
