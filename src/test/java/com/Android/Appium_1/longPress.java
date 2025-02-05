package com.Android.Appium_1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class longPress extends base {
	
	@Test
	public void longPressTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement longele = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"People Names\")"));
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) longele).getId(),"duration", 2000));
		Thread.sleep(2000);
		WebElement smenu = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sample menu\")"));
		String Peopletext = smenu.getText();
		Assert.assertEquals(Peopletext, "Sample menu");
		
		boolean display = smenu.isDisplayed();
		Assert.assertTrue(display);
	}

}
