package guru99.Banking.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewaccountPage extends NewcustomerPage {

	public NewaccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	protected static String accNum;
	
	By newcusacc = xpath("//a[normalize-space()='New Account']");
	
	By acctype = xpath("//select[@name='selaccount']");
	
	By initamount = xpath("//input[@name='inideposit']");
	
	By submitbtn = xpath("//input[@name='button2']");
	
	public void newAcc()
	{
		element(newcusacc).click();
		
		element(cusid).sendKeys(CusID);
		
		Select s = new Select(element(acctype));
		
		s.selectByValue("Savings");
		
		element(initamount).sendKeys("500");
		
		element(submitbtn).click();
		
		ScreenShot(driver,2);
		
		By getaccNum = xpath("//tbody/tr[4]/td[2]");
	
		accNum = element(getaccNum).getText();
		
		System.out.println(accNum);
		
		ScreenShot(driver,3);
	}

}
