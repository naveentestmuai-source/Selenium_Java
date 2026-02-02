package testMuAIdemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestMuAIDemo {
	
	public static void main(String[] args) throws MalformedURLException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("dev");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "naveenkannanlambdatest");
		ltOptions.put("accessKey", "LT_wiTVrrdVeLyPnGpuYAaKLC2gXXDQvJ8jtnkaDoCwcUIXr00");
		ltOptions.put("geoLocation", "IN");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("resolution", "1024x768");
		ltOptions.put("network", true);
		ltOptions.put("build", "NaveentestmuaitestNew");
		ltOptions.put("project", "NaveentestmuaitestNew_Automation");
		ltOptions.put("name", "Naveentestmuaitest_NewTest1");
		ltOptions.put("networkThrottling", "Regular 4G");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		ltOptions.put("accessibility", true);
		
		browserOptions.setCapability("LT:Options", ltOptions);
		DesiredCapabilities caps = new DesiredCapabilities();
		

		// To view performance metrics
		caps.setCapability("performance", true);
		
		@SuppressWarnings({ "deprecation" })
		WebDriver driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		driver.get("https://www.apple.com");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String title = driver.getTitle();
		System.out.println("Page Title: " + title);

		if (title.contains("Apple")) {
		    System.out.println("Apple homepage loaded successfully");
		} else {
		    System.out.println("Unexpected page title");
		}

		driver.findElement(By.linkText("iPhone")).click();

		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 600)");

		WebElement iphoneText = driver.findElement(By.xpath("//h1[contains(text(),'iPhone')]"));
		System.out.println("Section Text: " + iphoneText.getText());

		driver.navigate().back();

		driver.navigate().refresh();

		driver.quit();

	}

}
