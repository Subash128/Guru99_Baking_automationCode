package guru99.Banking.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletecustomerPage extends NewcustomerPage {

	public DeletecustomerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By delecus = xpath("//a[normalize-space()='Delete Customer']");
	
	By cusid = xpath("//input[@name='cusid']");
	
	By submitbtn = xpath("//input[@name='AccSubmit']");
	
	private void deletecus()
	{
		element(delecus).click();
		
		element(cusid).sendKeys("96960");
		
		element(submitbtn).click();
		
		alertaccept(driver);
	}

}
