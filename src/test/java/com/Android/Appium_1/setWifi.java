package com.Android.Appium_1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class setWifi extends base{
	
	@Test
	public void setWifiTest() throws InterruptedException {
		
		//Object Locators: x-path, id, className, accessibilityId, androidUIautomator
		//AppiumBy for accessibilityId, className & androidUIautomator
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\'android:id/checkbox\']")).click();
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\'android:id/list\']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/edit\")")).sendKeys("SkProm47x");
		Thread.sleep(5000);
		driver.findElement(By.id("android:id/button1")).click();
	}

}
