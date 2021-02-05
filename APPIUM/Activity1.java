package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity1 {
	WebDriverWait wait;
	AndroidDriver driver;

	@Test
	public void browser() {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/");
		String title = driver
				.findElement(By
						.xpath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]"))
				.getText();

		System.out.println("Page title : " + title);
		
		//click about us
		
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"About Us\"]/android.widget.TextView")).click();
		String title2 =  driver
				.findElement(By
						.xpath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]"))
				.getText();
		System.out.println("About Us Page title : " + title2);
		
	}

	@BeforeClass
	public void setup() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceId", "emulator-5554");
		cap.setCapability("deviceName", "Pixel_4_Emulator");
		cap.setCapability("platformName", "Android");

		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");

		cap.setCapability("noReset", true);

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		wait = new WebDriverWait(driver, 15);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
