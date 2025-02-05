package com.Android.Appium_1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class hybridTest extends base{
	
	@Test
	public void doHybrid() throws InterruptedException {
		
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bangladesh']")).click();
		
	//Type name in a text field
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("PROMI");
		driver.hideKeyboard(); //hide Keyboard
	//Select radio option	
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	//scroll until Air Jordan 9	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));"));
		
	//select air jordan 9
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0; i<count; i++) {
			
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
				if(productName.equalsIgnoreCase("Air Jordan 9 Retro")) {
					driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		
	// type Nvidia in google search
		
		Set<String> contextNames = driver.getContextHandles(); //both context names
		
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(7000);
		driver.findElement(By.name("q")).sendKeys("Nvidia");
		Thread.sleep(7000);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(7000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(7000);
		driver.context("NATIVE_APP");
		//driver.context("contextName for webView");
		
	}

}
