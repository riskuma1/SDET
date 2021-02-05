package ActivitiesSession3;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity1 {
	WebDriverWait wait;
	AndroidDriver driver;

	@Test
	public void sms() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// compose sms
		driver.findElementByAndroidUIAutomator("text(\"Start chat\")").click();
		// select contact
		driver.findElementByAndroidUIAutomator("text(\"Abishek Mohan\")").click();

		// send keys
		driver.findElementByAndroidUIAutomator("text(\"Text message\")").sendKeys("Hello from Appium!!");

		// click send
		driver.findElement(By.id("com.google.android.apps.messaging:id/send_message_button_icon")).click();

		String locator = "resource_id(\"com.google.android.apps.messaging:id/message_text\")";
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(locator)));
		AndroidElement text = (AndroidElement) driver.findElementByAndroidUIAutomator(locator);

		Assert.assertEquals("Hello from Appium!!", text.getText());
	}

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceId", "emulator-5554");
		cap.setCapability("deviceName", "Pixel_4_Emulator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.google.android.apps.messaging");
		cap.setCapability("appActivity", ".ui.ConversationListActivity");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
