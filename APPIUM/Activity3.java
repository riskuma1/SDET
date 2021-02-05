package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.listener.AnsiColorLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity3 {
	AndroidDriver driver;
	WebDriverWait wait;
	
	@Test
	public void contact() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Contact Opened");
		//clicking on add button
		driver.findElement(By.id("com.android.contacts:id/floating_action_button")).click();
		//populating details
		driver.findElement(By.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Abishek");
		driver.findElement(By.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Mohan");
		driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("9902254893");
		driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();
		
		MobileElement card = (MobileElement) driver.findElement(By.id("com.android.contacts:id/toolbar_parent"));
		Assert.assertTrue(card.isDisplayed());
		
		
		String name = driver.findElement(By.id("com.android.contacts:id/large_title")).getText();
		Assert.assertEquals("Abishek Mohan", name);
	}

	@BeforeClass
	public void setup() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceId", "emulator-5554");
		cap.setCapability("deviceName", "Pixel_4_Emulator");
		cap.setCapability("platformName", "Android");
		
		cap.setCapability("appPackage", "com.android.contacts");
		cap.setCapability("appActivity", ".activities.PeopleActivity");

		cap.setCapability("noReset", true);

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		wait = new WebDriverWait(driver, 15);
	}

	@AfterClass
	public void teardown() {
	}

}
