package getirAppTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Product {
	AppiumDriver<MobileElement> driver;
	public Product(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}	
    public WebElement addToCart(){
        WebElement addToCart =driver.findElement(By.id("com.allandroidprojects.getirsample:id/text_action_bottom1"));
        return addToCart;
    }
    public WebElement getDetail(){
        WebElement getDetail =driver.findElement(By.xpath("//android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]"));
        return getDetail;
    }
    public WebElement getProductPrice(){
        WebElement getProductPrice =driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
        return getProductPrice;
    }
}
