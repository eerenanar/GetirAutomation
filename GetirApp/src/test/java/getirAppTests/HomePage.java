package getirAppTests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
public class HomePage{
	AppiumDriver<MobileElement> driver;
	public HomePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
    public int homePageSize(){
    	List<MobileElement> homePageElement = null;
    		homePageElement =driver.findElements(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup"));
    	return homePageElement.size();
    }
    public WebElement notifications(){
        WebElement notifications =driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Notifications\"]"));
        return notifications;
    }
    public WebElement leftMenuBtn(){
        WebElement leftMenu =driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]"));
        //leftMenu.getAttribute("index");
        return leftMenu;
    }
    public WebElement basketBtn(){
        WebElement basket =driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Cart\"]"));
        return basket;
    }
    public void randomProduct(){
        List<MobileElement> getProduct =driver.findElements(By.xpath("//android.view.ViewGroup/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.support.v7.widget.RecyclerView/*"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(getProduct.size());
        System.out.println("Selected random product = "+ randomProduct);
        System.out.println("Total Product = "+ getProduct.size());
        getProduct.get(randomProduct).click();
    }
    public void randomCategories(){
        List<MobileElement> getCategories =driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/*"));
        Random rand = new Random();
        int randomCategories = rand.nextInt(getCategories.size());
        System.out.println("Total Categories = "+ getCategories.size());
        System.out.println("Selected random Categories = "+ randomCategories);
        getCategories.get(randomCategories).click();
    }
    public void randomSelectHeart(){
        List<MobileElement> heartIcon =driver.findElements(By.xpath("//android.support.v4.view.ViewPager/android.support.v7.widget.RecyclerView/*/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView"));
        Random rand = new Random();
        int randomSelectHeart = rand.nextInt(heartIcon.size());
        System.out.println("Total Heart Icon = "+ heartIcon.size());
        System.out.println("Selected Icon = "+ randomSelectHeart);
        heartIcon.get(randomSelectHeart).click();
    }
}
