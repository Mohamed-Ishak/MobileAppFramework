package com.mobileresringframework.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;

import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mobileTestingFramework.pagesObjects.android.FormPage;

import com.mobileTestingFramework.utilis.AppiumUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumUtils {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;

	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {
		Properties prop = new Properties();
		FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\mobileresringframework\\resources\\data.properties");
		prop.load(inputStream);
		String ipAdress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
		//String ipAdress = prop.getProperty("ipAddress");
		String portNumber = prop.getProperty("port");
		service = startAppiumServer(ipAdress, Integer.parseInt(portNumber));

		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PlatformName"));
		options.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("AndroidDeviceName"));
		options.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("AndroidPlatformVersion"));
		// options.setChromedriverExecutable("C:\\Users\\mohamed.abdelrahman\\eclipse-workspace\\mobileTestingFramework\\drivers\\chromedriver.exe");
		options.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "\\apps\\General-Store.apk");
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		if (driver != null) {
			driver.quit();
			service.stop();
		}
//
	}

}
