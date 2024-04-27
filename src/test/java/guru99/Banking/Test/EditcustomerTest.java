package guru99.Banking.Test;

import org.testng.annotations.Test;

import SeleniumBase.Base;
import guru99.Banking.Pages.EditcustomerPage;
import guru99.Banking.Pages.loginPage;

public class EditcustomerTest extends Base {

	@Test
	void case3() {
		loginPage lp = new loginPage(driver);

		lp.login();

		EditcustomerPage ep = new EditcustomerPage(driver);

		ep.editcusDetials();

		ep.edit();

	}

}
