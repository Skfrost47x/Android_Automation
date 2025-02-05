package com.Android.Appium_1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class base {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		
		//run appium server automatically
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\17185\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
		
		//create capabilities
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Pixel 9 Pro XL API 35");
		//options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\General-Store.apk");
		options.setChromedriverExecutable("C:\\Shabbir\\Software\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		//create object for AndroidDriver/ ISODriver
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		
		 
		
		//driver.findElement(By.xpath(null));
		
			
	}
	
	public void scrollToEnd() {
		//scroll as long as the App has elements
		boolean canScrollMore;
		do{
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		} while(canScrollMore);
	}
	
	public void scrollToElement(String WebView) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	}
	
	public void swipeAction(WebElement ele, String swipeDirection) {
		
		//performed when swiping
				((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of( "elementId", ((RemoteWebElement) ele).getId(),
					    "direction", swipeDirection,
					    "percent", 0.75
					));
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		service.stop();
	}
	

}
