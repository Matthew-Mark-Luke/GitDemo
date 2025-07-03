package com.appium.learning1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Course1 {

	// it works

	@Test
	public void appiumTest1() throws URISyntaxException, InterruptedException {

		// Start Appium server using the default configuration
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();

		if (!service.isRunning()) {
			System.err.println("❌ Failed to start the Appium server.");
			return;
		}

		try {

			String appNew = "eclipse-workspace/AppiumLearning1/src/test/resources/ApiDemos-debug.apk";
			UiAutomator2Options options = new UiAutomator2Options()

					.setDeviceName("phone1") // Replace with actual device name
					.setPlatformName("Android").setApp(appNew) // Update this path
					.setAutomationName("UiAutomator2");

			URI uri = new URI("http://127.0.0.1:4723");
			URL url = uri.toURL();

			// Instantiate AndroidDriver
			AndroidDriver driver = new AndroidDriver(url, options);
			System.out.println("✅ AndroidDriver session started successfully!");

	//-----------------------------
		
		//locators for appium: Xpath, id, Classname, AccessibilityId,androidUIAutomator
		// By. comes from selenium library and does not contain: AccessibilityId,androidUIAutomator
		// AppiumBy. comes from appium library and use it if you want to use AccessibilityId,androidUIAutomator	
		// also it is better to use AppiumBy with classname	
		WebElement preference = driver.findElement(AppiumBy.accessibilityId("Preference"));
		preference.click();
			
			
			
			
			
			
			Thread.sleep(5000);

			driver.quit();
			service.stop();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			service.stop();
			System.out.println("🛑 Appium server stopped.");
		}
	}
//**************************************************
	
	
	
	
}
