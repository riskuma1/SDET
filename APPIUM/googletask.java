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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class googletask {
	WebDriverWait wait;
	AndroidDriver driver;
	
	@Test
	public void googleTask() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//get started
		driver.findElement(By.id("com.google.android.apps.tasks:id/welcome_get_started")).click();
		//click to add task
		driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();
		driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
		driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_done")).click();
		
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.google.android.apps.tasks:id/task_name")));
		
		//click to add task
		driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();
		driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
		driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_done")).click();
		
		
		//click to add task
		driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();
		driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Second Activity with Google Keep");
		driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_done")).click();
		
		//tasks added
		String task1 = driver.findElementByAndroidUIAutomator("text(\"Complete Activity with Google Tasks\")").getText();
		String task2 = driver.findElementByAndroidUIAutomator("text(\"Complete Activity with Google Keep\")").getText();
		String task3 = driver.findElementByAndroidUIAutomator("text(\"Complete Second Activity with Google Keep\")").getText();
		
	
		//assert
		Assert.assertEquals("Complete Activity with Google Tasks", task1);
		Assert.assertEquals("Complete Activity with Google Keep", task2);
		Assert.assertEquals("Complete Second Activity with Google Keep", task3);
			}

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		 DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability("deviceId", "emulator-5554");
			cap.setCapability("deviceName", "Pixel_4_Emulator");
			cap.setCapability("platformName", "Android");
			cap.setCapability("appPackage", "com.google.android.apps.tasks");
			cap.setCapability("appActivity", ".ui.TaskListsActivity");

			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
