package ActivitiesSession3;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity2 {
	WebDriverWait wait;
	AndroidDriver driver;
	
  @Test
  public void lazyloading() {
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	  driver.get("https://www.training-support.net/selenium/lazy-loading");
	  driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
	  driver.findElement(By.id("com.android.chrome:id/next_button")).click();
	  driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
	  
	  List images = driver.findElements(By.xpath("//android.view.View/android.view.View/android.widget.Image"));
	  System.out.println("Number of images in current frame : "+images.size());
	  
	  
	  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\"helen\"))");
	  
	  List images1 = driver.findElements(By.xpath("//android.view.View/android.view.View/android.widget.Image"));
	  System.out.println("Number of images after scrolling frame : "+images1.size());
	  
  }
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceId", "emulator-5554");
		cap.setCapability("deviceName", "Pixel_4_Emulator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
