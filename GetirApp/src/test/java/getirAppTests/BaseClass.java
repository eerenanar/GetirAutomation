package getirAppTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	static AppiumDriver<MobileElement> driver;
	static AppiumDriver<MobileElement> driver2;

	URL url;
	
	@BeforeTest
	public void setup() {
		GetInstanceTc1();
		GetInstanceTc2();
	}

	public AppiumDriver<MobileElement> GetInstanceTc1(){
		if(driver == null) {
			return driver = new AppiumDriver<MobileElement>(UrlCreator(),DesiredCapabilitiesCreator1());
		}
		return driver;
	}
	
	public AppiumDriver<MobileElement> GetInstanceTc2(){
		if(driver2 == null) {
			return driver2 = new AppiumDriver<MobileElement>(UrlCreator(),DesiredCapabilitiesCreator2());
		}
		return driver2;
	}
	
	private URL UrlCreator() {
			try {
				return url=new URL("http://localhost:4723/wd/hub");
			} catch (MalformedURLException e) {
				return url=null;
			}
	}
	
	private DesiredCapabilities DesiredCapabilitiesCreator1(){
		DesiredCapabilities capabilities;
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.VERSION,"7.0");
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT,"9538");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\anarer\\getirApp\\GetirApp\\src\\test\\resources\\apps\\sampleGetir.apk");
        return capabilities;
	}
	
	private DesiredCapabilities DesiredCapabilitiesCreator2(){
		DesiredCapabilities capabilities2;
        capabilities2 = new DesiredCapabilities();
        capabilities2.setCapability(MobileCapabilityType.UDID,"emulator-5556");
        capabilities2.setCapability(MobileCapabilityType.BROWSER_NAME,"Android");
        capabilities2.setCapability(MobileCapabilityType.VERSION,"7.0");
        capabilities2.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT,"6789");
        capabilities2.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities2.setCapability(MobileCapabilityType.APP,"C:\\Users\\anarer\\getirApp\\GetirApp\\src\\test\\resources\\apps\\sampleGetir.apk");
        return capabilities2;
	}
	
	public void sleep() {
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void Case1() throws InterruptedException {
		GetInstanceTc1();
        OnboardScreen screenOnboard1 = new OnboardScreen(GetInstanceTc1());
        HomePage home1 = new HomePage(GetInstanceTc1());
        Product product1 = new Product(GetInstanceTc1());
        ShoppingCart cart1 = new ShoppingCart(GetInstanceTc1());
        TreeItemMenu leftmenu1 = new TreeItemMenu(GetInstanceTc1());
        //Onboarding Screen Checking
        Thread.sleep(5000);
        System.out.println("Content size = "+screenOnboard1.onBoardingScreenContent());
        AssertJUnit.assertEquals(screenOnboard1.onBoardingScreenContent(),3);sleep();
        screenOnboard1.onBoardingScreenNextBtn().click();sleep();
        screenOnboard1.onBoardingScreenSkipBtn().click();sleep();
        //Home Page Load Control
        Assert.assertNotEquals(home1.homePageSize(), 0);
        //Open Left Menu
        home1.leftMenuBtn().click();sleep();
        //Open Categories 'Baby Care'
        leftmenu1.getBabyCare().click();sleep();
        //Open Random Product
        home1.randomProduct();sleep();
        //Open Detail
        product1.getDetail().getText();sleep();
        //Add product to basket
        product1.addToCart().click();sleep();
        //Return Lastpage
        driver.navigate().back();sleep();
        //Open Left Menu
        home1.leftMenuBtn().click();sleep();
        //Open Categories 'Snacks'
        leftmenu1.getSnacks().click();sleep();
        //Open Random Product
        home1.randomProduct();sleep();
        //Open Detail
        product1.getDetail().getText();sleep();
        //Add product to basket
        product1.addToCart().click();sleep();
        //Return Lastpage
        driver.navigate().back();sleep();
        //Open Basket
        home1.basketBtn().click();sleep();
        //Check products on Basket
        int sizeproduct =cart1.shoppingCartSize();
        System.out.println("Total product on Shopping Cart ="+ sizeproduct);
        AssertJUnit.assertEquals(cart1.shoppingCartSize(), 2);sleep();
        //Check Price on Basket
        System.out.println("Total price on Shopping Cart ="+cart1.totalPriceOnBasket().getText());
        AssertJUnit.assertEquals(cart1.totalPriceOnBasket().getText(), "$3.96");sleep();
        //Delete All Product
        cart1.removeShoppingCart();sleep();
        //Check basket should be null
        System.out.println("Shopping Product Count ="+cart1.removeShoppingCart());
        AssertJUnit.assertEquals(cart1.removeShoppingCart(), 0);sleep();
        //driver.close();
        //driver.resetApp();
        //Thread.sleep(5000);
        //driver.quit();
	}
	
	@Test
	public void Case2() throws InterruptedException {
		GetInstanceTc2();
        OnboardScreen screenOnboard = new OnboardScreen(GetInstanceTc2());
        HomePage home = new HomePage(GetInstanceTc2());
        TreeItemMenu leftmenu = new TreeItemMenu(GetInstanceTc2());
        Whislist whislist = new Whislist(GetInstanceTc2());
		//Onboarding Screen Checking
        Thread.sleep(5000);
        System.out.println("Content size case(2) = "+screenOnboard.onBoardingScreenContent());
        AssertJUnit.assertEquals(screenOnboard.onBoardingScreenContent(),3); sleep();      
        screenOnboard.onBoardingScreenNextBtn().click();sleep();
        screenOnboard.onBoardingScreenSkipBtn().click();sleep();
        //Home Page Load Control
        Assert.assertNotEquals(home.homePageSize(), 0);
        //Categories Total and Select Random Categories
        home.randomCategories();
        home.randomSelectHeart();sleep();
        home.randomSelectHeart();sleep();
        home.randomSelectHeart();sleep();
        //Open Left Menu
        home.leftMenuBtn().click();
        //Open Categories 'My Wishlist'
        leftmenu.myWishlist().click();sleep();
        //Delete All Whislist
        whislist.removeWhishList();sleep();
        //Check basket should be null
        System.out.println("Whislist Product Count ="+whislist.removeWhishList());
        AssertJUnit.assertEquals(whislist.removeWhishList(), 0);sleep();
	}
	@Test
	public void Case3() throws InterruptedException {
		System.out.println("This is bugs area,i can create another device for this tests");
			//Bugs//
		//1-Search bar results not working
		//2-Whislist button not clickable in selected product
		//3-Similar button not clickable in selected product
		//4-Share button not clickable in selected product
	}
	@AfterSuite
	public void teardown() {
		GetInstanceTc1().quit();
		GetInstanceTc2().quit();
		
	}
}
