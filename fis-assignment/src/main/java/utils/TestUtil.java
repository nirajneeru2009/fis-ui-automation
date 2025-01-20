package utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class TestUtil {

	private WebDriver driver;
	private String parentWindow;

	public TestUtil(WebDriver driver) {
		this.driver = driver;
		this.parentWindow = driver.getWindowHandle();
	}

	public void switchToNewTab() {
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				System.out.println("Switched to new tab: " + driver.getTitle());
				return;
			}
		}

		throw new RuntimeException("No new tab found to switch to!");
	}

	public void switchToParentWindow() {
		driver.switchTo().window(parentWindow);
		System.out.println("Switched back to parent window: " + driver.getTitle());
	}

	public void closeCurrentTabAndReturnToParent() {
		driver.close(); // Closes the current tab
		driver.switchTo().window(parentWindow);
		System.out.println("Closed current tab and returned to parent window: " + driver.getTitle());
	}

}
