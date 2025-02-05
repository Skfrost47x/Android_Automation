package com.Android.Appium_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class swipe extends base{
	
	@Test
	public void swipeTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		WebElement firstImage =driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
		WebElement secondImage =driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)"));
		// Performed Before Swipe
		String firstTimeValue = firstImage.getAttribute("focusable");
		Assert.assertEquals("true", firstTimeValue);
		
		//performed when swiping
		swipeAction(firstImage, "left");
		// Performed After Swipe
				String secondTimeValue = firstImage.getAttribute("focusable");
				Assert.assertEquals("false", secondTimeValue);
				
		swipeAction(secondImage, "right");
		Thread.sleep(3000);
	}

}
