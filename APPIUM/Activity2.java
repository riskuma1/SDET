package activities;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.tools.ant.listener.AnsiColorLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.util.FileCopyUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2 {
	
	AndroidDriver driver = null;
	
	public void screenshot(String path) throws IOException {
		File screenshot = new File(path);
		File ss = driver.getScreenshotAs(OutputType.FILE);
		
		FileCopyUtils.copy(ss, screenshot);
		
	}
	
	@Test
	public void multiply() throws IOException {
		System.out.println("Calc app opened");
		driver.findElement(By.id("com.android.calculator2:id/result")).clear();
		driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		String res = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
		System.out.println("5*100 = "+res);
		screenshot("src/multiply.jpg");
		Assert.assertEquals(res, "500");
	}
	
	@Test
	public void addition() throws IOException {
		
		driver.findElement(By.id("com.android.calculator2:id/result")).clear();
		driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
		driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		String res = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
		System.out.println("5+9 = "+res);
		screenshot("src/addition.jpg");
		Assert.assertEquals(res, "14");
	}
	
	@Test
	public void division() throws IOException {
		
		driver.findElement(By.id("com.android.calculator2:id/result")).clear();
		driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(By.id("com.android.calculator2:id/op_div")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
		driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		String res = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
		System.out.println("5+9 = "+res);
		screenshot("src/Div.jpg");
		Assert.assertEquals(res, "25");
	}
	
	@Test
	public void subtraction() throws IOException {
		
		driver.findElement(By.id("com.android.calculator2:id/result")).clear();
		driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(By.id("com.android.calculator2:id/op_sub")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		String res = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
		System.out.println("10-5 = "+res);
		screenshot("src/Sub.jpg");
		Assert.assertEquals(res, "5");
	}

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceId", "emulator-5554");
		cap.setCapability("deviceName", "Pixel_4_Emulator");
		cap.setCapability("platformName","Android");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", ".Calculator");
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
	}

	@AfterClass
	public void afterClass() {
	}

}
