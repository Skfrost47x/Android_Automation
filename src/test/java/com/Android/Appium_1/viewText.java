package com.Android.Appium_1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class viewText extends base {
	
	@Test
	public void textTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Buttons")).click();
		String normalBtn = driver.findElement(By.id("io.appium.android.apis:id/button_normal")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(normalBtn, "Normal");
	}

}
