package AppiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class GoogleNoteWithReminder {
	WebDriverWait wait;
	AndroidDriver driver;
	
	@Test
	public void addNoteGKeepwithReminder() {
		String heading="Note2 with reminder";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.google.android.keep:id/skip_welcome")).click();
		driver.findElement(By.id("com.google.android.keep:id/new_note_button")).click();
		driver.findElement(By.id("com.google.android.keep:id/editable_title")).sendKeys(heading);
		driver.findElement(By.id("com.google.android.keep:id/edit_note_text")).sendKeys("This is my note 2 with reminder");
		
		//click reminder
		driver.findElement(By.id("com.google.android.keep:id/menu_reminder")).click();
		
		//click save
		driver.findElementByAndroidUIAutomator("text(\"Save\")").click();
		
		//back click
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
		
		String actual = driver.findElementByAndroidUIAutomator("text(\"Note2 with reminder\")").getText();
		System.out.println("Actual text : "+actual);
		Assert.assertEquals(heading, actual);
		
		Boolean reminder = driver.findElement(By.id("com.google.android.keep:id/reminder_chip_text")).isDisplayed();
		System.out.println("reminder  : "+reminder);
		Assert.assertTrue(reminder);
	
	}	
	

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceId", "emulator-5554");
		cap.setCapability("deviceName", "Pixel_4_Emulator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.google.android.keep");
		cap.setCapability("appActivity", ".activities.BrowseActivity");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@AfterClass
	public void afterClass() {
	}

}
