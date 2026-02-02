package mobileAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class vanilla_android {

    public static String userName = System.getenv("LT_USERNAME") == null
            ? "naveenkannan"
            : System.getenv("LT_USERNAME");

    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null
            ? "LT_hsaE113rWUL74CS1JCNdHzo6Vdw3MPMZJhaU09NZ7WR8XUW"
            : System.getenv("LT_ACCESS_KEY");

    private static AppiumDriver driver;

    @SuppressWarnings("deprecation")
	public static void main(String[] args)
            throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Galaxy S20");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("app", "lt://APP10160301691768227720720640"); // <-- your app url
        capabilities.setCapability("deviceOrientation", "PORTRAIT");
        capabilities.setCapability("build", "Java Vanilla Android");
        capabilities.setCapability("name", "Sample Test Java");
        capabilities.setCapability("console", true);
        capabilities.setCapability("network", false);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("devicelog", true);

        driver = new AndroidDriver(
                new URL("https://" + userName + ":" + accessKey
                        + "@mobile-hub.lambdatest.com/wd/hub"),
                capabilities
        );

        WebElement color =
                driver.findElement(By.id("com.lambdatest.proverbial:id/color"));

        color.click();

        driver.quit();
    }
}
