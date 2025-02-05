package com.Android.Appium_1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class generalStoreTest extends base{
	
	@Test (enabled = false)
	public void dropDownTest () {
	//scroll and select Bangladesh
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bangladesh']")).click();
		
	//Type name in a text field
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("PROMI");
		driver.hideKeyboard(); //hide Keyboard
	//Select radio option	
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}
	
	@Test
	public void toastMessage() {
		
		//scroll and select Bangladesh
				driver.findElement(By.id("android:id/text1")).click();
				driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));"));
				driver.findElement(By.xpath("//android.widget.TextView[@text='Bangladesh']")).click();
				
			
			//Select radio option	
				driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
				driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			//Spying toast message and get the text tagName = andriod.widget.Toast
				String toastMsg = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("text");
			    Assert.assertEquals(toastMsg, "Please enter your name");
				
	}

}
