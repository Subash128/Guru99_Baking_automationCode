package guru99.Banking.Test;

import org.testng.annotations.Test;

import SeleniumBase.Base;
import guru99.Banking.Pages.NewcustomerPage;
import guru99.Banking.Pages.loginPage;

public class NewCustomerTest extends Base {
	
	@Test
	void case2()
	{
		loginPage lp = new loginPage(driver);
		
		lp.login();
		
		NewcustomerPage cp = new NewcustomerPage(driver);
		
		cp.addingNewcustomer();
		
		cp.verify();
	}

}
