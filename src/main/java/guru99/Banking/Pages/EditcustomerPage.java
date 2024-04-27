package guru99.Banking.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditcustomerPage extends NewcustomerPage {
	
public EditcustomerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	EditcustomerPage(WebDriver driver)
//	{
//		this.driver=driver;
//	}

	
	By editcus = By.xpath("//a[normalize-space()='Edit Customer']");
	
	By editpagesubt = By.xpath("//input[@name='AccSubmit']");
	
	By resetbtn = By.xpath("//input[@name='res']");
	
	public void editcusDetials()
	{
		element(editcus).click();
		
		element(cusid).sendKeys(pro.getProperty("cusid"));
		
		element(editpagesubt).click();
	}
	
	public void edit()
	{
		element(city).clear();
		
		element(city).sendKeys("cbe");
		
		element(submitbtn).click();
		
		alertaccept(driver);
	}
	
}
