package SeleniumBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utilities.ReadpropertyFile;

public class Base extends ReadpropertyFile {

	public WebDriver driver = null;
	private WebDriverWait wait = null;
	protected Properties pro = null;

	// ReadpropertyFile pr = new ReadpropertyFile();
	@BeforeTest
	public void setUp() {

		if (driver == null) {
			pro = configProperty();
		}

		if (pro.getProperty("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions op = new ChromeOptions();
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "subash7726");
			ltOptions.put("accessKey", "n1BOY93Leur5LoGctQbRKBjie5N614DNaYKcZjklkqCF49g9hK");
			ltOptions.put("project", "Banking App");
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			op.setCapability("LT:Options", ltOptions);
			//op.addArguments("headless");
			driver = new ChromeDriver(op);
		}

		else if (pro.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (pro.getProperty("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.get(pro.getProperty("testurl"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public WebElement element(By b) {

		try {
			return driver.findElement(b);
		} catch (NoSuchElementException e) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(b));
		} catch (WebDriverException e) {
			System.err.println(e.getMessage());
			throw new WebDriverException("Some unknown webdriver error");
		}
		return null;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public boolean isDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}

	public void alertdismiss(WebDriver driver) {

		try {
			driver.switchTo().alert().dismiss();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
		}
	}

	public void alertaccept(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
		}
	}
	
	public By xpath(String str)
	{
		return By.xpath(str);
	}
	
	public static void ScreenShot(WebDriver driver, int i) {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File("./reports/Screen"+i+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
