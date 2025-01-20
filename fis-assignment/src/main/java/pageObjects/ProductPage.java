package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

	WebDriver driver;

	@FindBy(xpath = "//span[text()='Add to cart']")
	private WebElement addToCart;

	@FindBy(xpath = "//button[@value='Select']")
	private WebElement selectColor;

	@FindBy(xpath = "//select[@class='listbox__native']")
	private WebElement selectBookColor;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddToCart() {
		addToCart.click();
	}

	public void selectColor() {
		selectColor.click();
		Select sel = new Select(selectBookColor);
		sel.selectByIndex(1);

	}
}
