package guru99.Banking.Test;

import org.testng.annotations.Test;

import SeleniumBase.Base;
import guru99.Banking.Pages.NewaccountPage;
import guru99.Banking.Pages.loginPage;

public class NewaccTest extends Base {
	
	@Test
	void case4()
	{
		loginPage lp = new loginPage(driver);

		lp.login();
		
		NewaccountPage nap = new NewaccountPage(driver);
		
		nap.newAcc();

	}

}
