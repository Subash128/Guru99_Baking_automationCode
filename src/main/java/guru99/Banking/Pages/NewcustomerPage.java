package guru99.Banking.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import SeleniumBase.Base;

public class NewcustomerPage extends Base {

	public NewcustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected String CusID;

	protected Properties pro = cusDetailProperty();

	private By newcustomer = By.xpath("//a[normalize-space()='New Customer']");

	private By name = By.xpath("//input[@name='name']");

	private By gender = By.xpath(gender());

	private By dob = By.id("dob");

	private By address = By.xpath("//textarea[@name='addr']");

	protected By city = By.xpath("//input[@name='city']");

	protected By state = By.xpath("//input[@name='state']");

	protected By pincode = By.xpath("//input[@name='pinno']");

	protected By moblie = By.xpath("//input[@name='telephoneno']");

	protected By email = By.xpath("//input[@name='emailid']");

	private By password = By.xpath("//input[@name='password']");

	protected By submitbtn = By.xpath("//input[@name='sub']");

	protected By reset = By.xpath("input[@name='res']");
	
	private By sucessMsg = By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p");
	
	private By continuebtn = By.xpath("//*[@id=\"customer\"]/tbody/tr[14]/td/a");
	
	protected By cusid = By.xpath("//input[@name='cusid']");
	
	private By CustomerID = xpath("//td[normalize-space()='Customer ID']/following-sibling::td");

	private String gender() {
		String g;

		if (pro.getProperty("gender").equalsIgnoreCase("male")) {
			g = "//input[@value='m']";
		} else {
			g = "//input[@value='f']";
		}

		return g;
	}

	public void addingNewcustomer() {

		element(newcustomer).click();

		element(name).sendKeys(pro.getProperty("name"));

		element(gender).click();

		element(dob).sendKeys(pro.getProperty("dob"));

		element(address).sendKeys(pro.getProperty("address"));

		element(city).sendKeys(pro.getProperty("city"));

		element(state).sendKeys(pro.getProperty("state"));

		element(pincode).sendKeys(pro.getProperty("pincode"));

		element(moblie).sendKeys(pro.getProperty("moblie"));

		element(email).sendKeys(pro.getProperty("email"));

		element(password).sendKeys(pro.getProperty("password"));

		element(submitbtn).click();
		
	    CusID = element(CustomerID).getText();
		
		ScreenShot(driver, 1);

	}
	
	public void verify()
	{
		String act = element(sucessMsg).getText();
		
		Assert.assertEquals(act , "Customer Registered Successfully!!!");
		
		element(continuebtn).click();
	}

}
