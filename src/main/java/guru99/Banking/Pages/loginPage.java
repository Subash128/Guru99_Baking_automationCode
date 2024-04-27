package guru99.Banking.Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import SeleniumBase.Base;
import utilities.ReadExceldata;

public class loginPage extends Base {

	Properties pro = null;

	@FindBy(name = "uid")
	WebElement userid;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "btnLogin")
	WebElement loginbtn;

	/*
	 * By userid = By.name("uid");
	 * 
	 * By password = By.name("password");
	 * 
	 * By loginbtn = By.name("btnLogin");
	 */

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public homePage login(String data[]) {

		System.out.println(data[0]);
		System.out.println(data[1]);

		userid.sendKeys(data[0]);

		password.sendKeys(data[1]);

		loginbtn.click();

		return new homePage(driver);
	}

	public homePage login() {

		pro = configProperty();

		System.out.println(pro.getProperty("userid"));
		System.out.println(pro.getProperty("password"));

		userid.sendKeys(pro.getProperty("userid"));

		password.sendKeys(pro.getProperty("password"));

		loginbtn.click();

		return new homePage(driver);
	}

}
