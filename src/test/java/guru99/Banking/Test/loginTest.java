package guru99.Banking.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumBase.Base;
import guru99.Banking.Pages.homePage;
import guru99.Banking.Pages.loginPage;
import utilities.ReadExceldata;

public class loginTest extends Base {

	@Test(dataProvider = "getData", dataProviderClass=ReadExceldata.class)
	void case1(String data[]) {

		loginPage lp = new loginPage(driver);
		System.out.println(lp.getTitle());
		Assert.assertEquals(lp.getTitle(), "Guru99 Bank Home Page");
		lp.login(data);
		homePage hp = new homePage(driver);
		hp.verifyTitle();
		hp.userVerify();

	}

}
