package com.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest extends ExtentReporter{
	
	private static ThreadLocal<AppiumDriver<MobileElement>> mobileDriver=new ThreadLocal<AppiumDriver<MobileElement>>();
	public static ThreadLocal<DesiredCapabilities> capabilities = new ThreadLocal<DesiredCapabilities>();
	public static String URL = "";
	public static String myOS = "";
	public static String myGeo = "";
	public static String myMobileOS = "";
	public static String deviceLocation1 = "";
	public static String myPlatform = "";
	public static String executionMode = "";
	public static String language = "";
	public static String app = "";
	public static ThreadLocal<String> myDevice = new ThreadLocal<String>();
	public static ThreadLocal<String> myXcodeOrgId = new ThreadLocal<String>();
	public static ThreadLocal<String> myBundleID = new ThreadLocal<String>();
	public static ThreadLocal<String> myAppPackage = new ThreadLocal<String>();
	public static ThreadLocal<String> myAppActivity = new ThreadLocal<String>();
	public static ThreadLocal<String> myDeviceName = new ThreadLocal<String>();
	public static String suitExecutionTime="";
	public static int totalScripts=0;
	static String myBrowser = null;
	
	public static void setMobileDriver(AppiumDriver<MobileElement> mobileDriver) {
		BaseTest.mobileDriver.set(mobileDriver);
	}
	
	public static 	AppiumDriver<MobileElement> getDriver(){
		AppiumDriver<MobileElement> dr = null;
		return dr = mobileDriver.get();
	}
	
	@Parameters({"platform"})
	@BeforeMethod(alwaysRun=true)
	public static void initializeSetUp(String url, @Optional String deviceName, String deviceLocation, String platform, @Optional String osPlatform, @Optional String geo, 
			@Optional String mobilePlatform, @Optional String device,String planguage){		
		try {
			capabilities.set(new DesiredCapabilities());
			URL=(url);
			myOS=(osPlatform);
			myGeo=(geo);
			myMobileOS=(mobilePlatform);
			myDevice.set(device);
			if(!deviceName.isEmpty() || deviceName!=null)
				myDeviceName.set(deviceName);
			myPlatform=(platform);
			deviceLocation1=(deviceLocation);
			language=(planguage);
			setCapabilitiesLocal(platform);
		} catch (Exception e) {
			Assert.fail("Could not initialize Android/IOS WebDriver -> "+e.getMessage(), e);
		}
	}
		
	public static void createAndSetDriver() {
		WebDriver webdriver;
		AppiumDriver<MobileElement> mobiledriver;
		AppiumDriver<WebElement> mobilewebdriver;
		AndroidDriver<MobileElement> androiddriver;
		
		
		try {
			switch(myPlatform.toUpperCase()) {
			
			case "WEB":
				if(myBrowser.equalsIgnoreCase("CHROME")) {
					
				}else if(myBrowser.equalsIgnoreCase("FIREFOX")){
					
				}else if(myBrowser.equalsIgnoreCase("IE")){
					
				}
				break;
			case "ANDROID":
						capabilities.get().setCapability("locale", myGeo.toUpperCase());
						capabilities.get().setCapability("language", language.toUpperCase());
						mobiledriver = new AndroidDriver<MobileElement>(new URL(URL),capabilities.get());
						setMobileDriver(mobiledriver);
						break;
			case "IOS":
						capabilities.get().setCapability("locale", myGeo.toUpperCase());
						capabilities.get().setCapability("language", language.toUpperCase());
						mobiledriver = new IOSDriver<MobileElement>(new URL(URL),capabilities.get());
						setMobileDriver(mobiledriver);
						break;				
			
			default :
				Assert.fail("Could not identify the platform "+myPlatform);
			
			}
		} catch (Exception e) {
			Assert.fail("Could not initialize "+myPlatform+" Driver"+e.getMessage(),e);
		}
		
		
	}
	
	public static DesiredCapabilities setCapabilitiesLocal(String platform) throws MalformedURLException {
		
		switch(platform) {
		case "ANDROID":
		capabilities.get().setCapability(MobileCapabilityType.DEVICE_NAME, "deviceName");
		capabilities.get().setCapability(MobileCapabilityType.UDID, "UDID");
		capabilities.get().setCapability(MobileCapabilityType.PLATFORM_VERSION,  "platformVersion");
		capabilities.get().setCapability(MobileCapabilityType.AUTOMATION_NAME, "automationName");
		capabilities.get().setCapability(MobileCapabilityType.NO_RESET,"noReset");
		capabilities.get().setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "appActivity");
		capabilities.get().setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "appPackage");
		capabilities.get().setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		break;
		case "iOS":
		capabilities.get().setCapability(MobileCapabilityType.DEVICE_NAME,  "deviceName");
		capabilities.get().setCapability(MobileCapabilityType.UDID,  "UDID");
		capabilities.get().setCapability(MobileCapabilityType.PLATFORM_VERSION, "platformVersion");
		capabilities.get().setCapability(MobileCapabilityType.AUTOMATION_NAME, "automationName");
		capabilities.get().setCapability(IOSMobileCapabilityType.BUNDLE_ID,  "bundleId");
		capabilities.get().setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		break;
		}
	
	return capabilities.get();
}	
	
}
