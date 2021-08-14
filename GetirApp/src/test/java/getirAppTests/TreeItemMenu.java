package getirAppTests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TreeItemMenu {
	AppiumDriver<MobileElement> driver;
	public TreeItemMenu(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}	
    public WebElement getBabyCare(){
        WebElement babyCare =driver.findElement(By.xpath("//android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[5]/android.widget.CheckedTextView"));
        return  babyCare;
    }
    public WebElement getSnacks(){
        WebElement getSnacks =driver.findElement(By.xpath("//android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[1]"));
        return getSnacks;
    }
    public WebElement myWishlist(){
        WebElement myWishlist =driver.findElement(By.xpath("//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[9]"));
        return myWishlist;
    }
}
