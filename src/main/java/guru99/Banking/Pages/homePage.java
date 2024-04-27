package guru99.Banking.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SeleniumBase.Base;

public class homePage extends Base {

	@FindBy(xpath = "//td[normalize-space()='Manger Id : mngr564769']")
	WebElement verifyuser;

	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void userVerify() {
		if (!verifyTitle()) {

			String actual = driver.switchTo().alert().getText();

			Assert.assertEquals(actual, "User or Password is not valid");

			alertaccept(driver);
		}
	}

	public boolean verifyTitle() {
		Assert.assertEquals(getTitle(), "Guru99 Bank Manager HomePage");

		System.out.println(verifyuser.getText());

		return verifyuser.isDisplayed();
	}

}
